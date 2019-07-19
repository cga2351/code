package com.viber.voip.util.http;

import com.facebook.react.modules.network.ReactCookieJarContainer;
import com.viber.dexshared.Logger;
import com.viber.liblinkparser.DefaultHttpDelegate;
import com.viber.libnativehttp.OkHttp3HttpDelegate;
import com.viber.voip.ViberEnv;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.pixie.PixieController.PixieReadyListener;
import com.viber.voip.pixie.PixieControllerNativeImpl;
import com.viber.voip.util.bg;
import com.viber.voip.util.upload.t;
import f.j;
import f.l;
import java.io.IOException;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

public class DefaultOkHttpClientFactory
  implements OkHttpClientFactory
{
  private static final Logger L = ViberEnv.getLogger();
  private static final long POOL_KEEP_ALIVE_DURATION_MINUTES = 5L;
  private static final int POOL_MAX_IDLE_CONNECTIONS = 5;
  private static final String PROXY_HOST = "10.10.9.246";
  private static final int PROXY_PORT = 8080;
  private static final long SHORT_TIMEOUT = TimeUnit.SECONDS.toMillis(5L);
  private static final boolean USE_PROXY;
  private static volatile boolean sConnectionAllowed;
  private static PixieController.PixieReadyListener sPixieReadyListener;
  private ClientBuilderCreator[] mClientBuilderCreators = new ClientBuilderCreator[OkHttpClientFactory.Type.values().length];
  private volatile OkHttpClient mCommonClient;
  private CommonInterceptor mCommonInterceptor;
  private final ConnectionPool mConnectionPool;
  private GzipAwareInterceptor mGzipAwareInterceptor;
  private UnblockerAwaitingInterceptor mUnblockerAwaitingInterceptor;

  public DefaultOkHttpClientFactory()
  {
    com.viber.liblinkparser.AndroidHttp.setGlobalDelegateFactory(new SingleClientLinkParserHttpDelegateFactory(null));
    com.viber.libnativehttp.AndroidHttp.setGlobalDelegateFactory(new SingleClientLibNativeHttpDelegateFactory(null));
    this.mUnblockerAwaitingInterceptor = new UnblockerAwaitingInterceptor(null);
    this.mCommonInterceptor = new CommonInterceptor(null);
    this.mGzipAwareInterceptor = new GzipAwareInterceptor();
    this.mConnectionPool = new ConnectionPool(5, 5L, TimeUnit.MINUTES);
    this.mClientBuilderCreators[OkHttpClientFactory.Type.DEFAULT.ordinal()] = new ClientBuilderCreator()
    {
      public OkHttpClient.Builder createBuilder()
      {
        OkHttpClient.Builder localBuilder = DefaultOkHttpClientFactory.this.baseBuilder();
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mUnblockerAwaitingInterceptor);
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mCommonInterceptor);
        DefaultOkHttpClientFactory.enforceProxy(localBuilder);
        return localBuilder;
      }
    };
    this.mClientBuilderCreators[OkHttpClientFactory.Type.ABSTRACT_OK_HTTP_UPLOAD_TASK.ordinal()] = new ClientBuilderCreator()
    {
      public OkHttpClient.Builder createBuilder()
      {
        OkHttpClient.Builder localBuilder = DefaultOkHttpClientFactory.this.baseBuilder();
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mUnblockerAwaitingInterceptor);
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mCommonInterceptor);
        localBuilder.connectTimeout(t.a, TimeUnit.MILLISECONDS);
        localBuilder.readTimeout(t.b, TimeUnit.MILLISECONDS);
        localBuilder.writeTimeout(t.b, TimeUnit.MILLISECONDS);
        DefaultOkHttpClientFactory.enforceProxy(localBuilder);
        return localBuilder;
      }
    };
    this.mClientBuilderCreators[OkHttpClientFactory.Type.MEDIA_SHARE.ordinal()] = new ClientBuilderCreator()
    {
      public OkHttpClient.Builder createBuilder()
      {
        OkHttpClient.Builder localBuilder = DefaultOkHttpClientFactory.this.mClientBuilderCreators[OkHttpClientFactory.Type.ABSTRACT_OK_HTTP_UPLOAD_TASK.ordinal()].createBuilder();
        localBuilder.addNetworkInterceptor(new DefaultOkHttpClientFactory.LCHeadersInterceptor(null));
        return localBuilder;
      }
    };
    this.mClientBuilderCreators[OkHttpClientFactory.Type.QUICK_REQUEST.ordinal()] = new ClientBuilderCreator()
    {
      public OkHttpClient.Builder createBuilder()
      {
        OkHttpClient.Builder localBuilder = DefaultOkHttpClientFactory.this.baseBuilder();
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mUnblockerAwaitingInterceptor);
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mCommonInterceptor);
        localBuilder.connectTimeout(DefaultOkHttpClientFactory.SHORT_TIMEOUT, TimeUnit.MILLISECONDS);
        localBuilder.readTimeout(DefaultOkHttpClientFactory.SHORT_TIMEOUT, TimeUnit.MILLISECONDS);
        localBuilder.writeTimeout(DefaultOkHttpClientFactory.SHORT_TIMEOUT, TimeUnit.MILLISECONDS);
        DefaultOkHttpClientFactory.enforceProxy(localBuilder);
        return localBuilder;
      }
    };
    this.mClientBuilderCreators[OkHttpClientFactory.Type.NATIVE_HTTP.ordinal()] = new ClientBuilderCreator()
    {
      public OkHttpClient.Builder createBuilder()
      {
        System.setProperty("http.keepAlive", "true");
        OkHttpClient.Builder localBuilder = DefaultOkHttpClientFactory.this.baseBuilder();
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mCommonInterceptor);
        localBuilder.connectionPool(new ConnectionPool(10, 1L, TimeUnit.HOURS));
        Protocol[] arrayOfProtocol = new Protocol[1];
        arrayOfProtocol[0] = Protocol.HTTP_1_1;
        localBuilder.protocols(Arrays.asList(arrayOfProtocol));
        return localBuilder;
      }
    };
    this.mClientBuilderCreators[OkHttpClientFactory.Type.DIRECT.ordinal()] = new ClientBuilderCreator()
    {
      public OkHttpClient.Builder createBuilder()
      {
        OkHttpClient.Builder localBuilder = DefaultOkHttpClientFactory.this.baseBuilder();
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mCommonInterceptor);
        return localBuilder;
      }
    };
    this.mClientBuilderCreators[OkHttpClientFactory.Type.REACT.ordinal()] = new ClientBuilderCreator()
    {
      public OkHttpClient.Builder createBuilder()
      {
        OkHttpClient.Builder localBuilder = DefaultOkHttpClientFactory.this.baseBuilder();
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mUnblockerAwaitingInterceptor);
        localBuilder.addInterceptor(DefaultOkHttpClientFactory.this.mCommonInterceptor);
        localBuilder.connectTimeout(0L, TimeUnit.MILLISECONDS);
        localBuilder.readTimeout(0L, TimeUnit.MILLISECONDS);
        localBuilder.writeTimeout(0L, TimeUnit.MILLISECONDS);
        localBuilder.cookieJar(new ReactCookieJarContainer());
        DefaultOkHttpClientFactory.enforceProxy(localBuilder);
        return localBuilder;
      }
    };
    this.mClientBuilderCreators[OkHttpClientFactory.Type.GZIP_AWARE.ordinal()] = new DefaultOkHttpClientFactory..Lambda.0(this);
  }

  private static void allowConnection(String paramString)
  {
    if (sConnectionAllowed)
      return;
    try
    {
      if (sConnectionAllowed)
        return;
    }
    finally
    {
    }
    if (sPixieReadyListener == null)
      initPixie();
    boolean bool = sConnectionAllowed;
    if (!bool);
    try
    {
      DefaultOkHttpClientFactory.class.wait();
      label48: return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label48;
    }
  }

  private OkHttpClient.Builder baseBuilder()
  {
    return getCommonClient().newBuilder();
  }

  private static void enforceProxy(OkHttpClient.Builder paramBuilder)
  {
    Proxy localProxy = PixieControllerNativeImpl.getInstance().getProxy();
    if (localProxy != null)
      paramBuilder.proxy(localProxy);
  }

  private OkHttpClient getCommonClient()
  {
    if (this.mCommonClient == null);
    try
    {
      if (this.mCommonClient == null)
      {
        OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
        patchSslSocketFactory(localBuilder);
        localBuilder.connectionPool(this.mConnectionPool);
        this.mCommonClient = localBuilder.build();
      }
      return this.mCommonClient;
    }
    finally
    {
    }
  }

  private static String getDefaultUA()
  {
    return bg.a();
  }

  private static void initPixie()
  {
    sPixieReadyListener = new PixieController.PixieReadyListener()
    {
      public void onReady()
      {
        try
        {
          DefaultOkHttpClientFactory.access$1502(null);
          DefaultOkHttpClientFactory.access$1602(true);
          DefaultOkHttpClientFactory.class.notifyAll();
          return;
        }
        finally
        {
        }
      }
    };
    ViberEnv.getPixieController().addReadyListener(sPixieReadyListener);
  }

  private void patchSslSocketFactory(OkHttpClient.Builder paramBuilder)
  {
    if (!com.viber.common.d.a.g())
      try
      {
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        localTrustManagerFactory.init((KeyStore)null);
        TrustManager[] arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
        if (arrayOfTrustManager.length >= 1)
        {
          if (!(arrayOfTrustManager[0] instanceof X509TrustManager))
            return;
          X509TrustManager localX509TrustManager = (X509TrustManager)arrayOfTrustManager[0];
          SSLContext localSSLContext = SSLContext.getInstance("TLS");
          localSSLContext.init(null, new TrustManager[] { localX509TrustManager }, null);
          SSLSocketFactory localSSLSocketFactory = localSSLContext.getSocketFactory();
          if (localSSLSocketFactory != null)
          {
            paramBuilder.sslSocketFactory(new Android4SSLSocketFactory(localSSLSocketFactory), localX509TrustManager);
            return;
          }
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
      }
      catch (Exception localException)
      {
      }
      catch (KeyStoreException localKeyStoreException)
      {
      }
      catch (KeyManagementException localKeyManagementException)
      {
      }
  }

  public OkHttpClient.Builder createBuilder()
  {
    return createBuilder(OkHttpClientFactory.Type.DEFAULT);
  }

  public OkHttpClient.Builder createBuilder(OkHttpClientFactory.Type paramType)
  {
    return this.mClientBuilderCreators[paramType.ordinal()].createBuilder();
  }

  public OkHttpClient createClient()
  {
    return createBuilder(OkHttpClientFactory.Type.DEFAULT).build();
  }

  public OkHttpClient createClient(OkHttpClientFactory.Type paramType)
  {
    return createBuilder(paramType).build();
  }

  public void logRequests(OkHttpClient.Builder paramBuilder, Logger paramLogger)
  {
    paramBuilder.addNetworkInterceptor(new LoggingRequestInterceptor(paramLogger));
  }

  private static abstract interface ClientBuilderCreator
  {
    public abstract OkHttpClient.Builder createBuilder();
  }

  private static class CommonInterceptor
    implements Interceptor
  {
    public Response intercept(Interceptor.Chain paramChain)
      throws IOException
    {
      try
      {
        Request localRequest = paramChain.request();
        if (localRequest.header("User-Agent") == null)
        {
          Request.Builder localBuilder = localRequest.newBuilder();
          localBuilder.header("User-Agent", DefaultOkHttpClientFactory.access$1200());
          return paramChain.proceed(localBuilder.build());
        }
        Response localResponse = paramChain.proceed(localRequest);
        return localResponse;
      }
      catch (Exception localException)
      {
        com.viber.voip.analytics.f.a.a("CommonInterceptor.intercept", localException);
        throw new IOException(localException);
      }
    }
  }

  public static class GzipAwareInterceptor
    implements Interceptor
  {
    private Response unzip(Response paramResponse)
    {
      if ((paramResponse.body() == null) || (!"gzip".equalsIgnoreCase(paramResponse.header("Content-Encoding"))))
        return paramResponse;
      Response.Builder localBuilder = paramResponse.newBuilder();
      j localj = new j(paramResponse.body().source());
      localBuilder.headers(paramResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
      String str = paramResponse.header("Content-Type");
      if (str != null);
      for (MediaType localMediaType = MediaType.parse(str); ; localMediaType = null)
      {
        localBuilder.body(ResponseBody.create(localMediaType, -1L, l.a(localj)));
        return localBuilder.build();
      }
    }

    public Response intercept(Interceptor.Chain paramChain)
      throws IOException
    {
      return unzip(paramChain.proceed(paramChain.request()));
    }
  }

  private static class LCHeadersInterceptor
    implements Interceptor
  {
    public Response intercept(Interceptor.Chain paramChain)
      throws IOException
    {
      Request localRequest = paramChain.request();
      Request.Builder localBuilder = localRequest.newBuilder();
      Headers localHeaders = localRequest.headers();
      Headers.Builder localBuilder1 = new Headers.Builder();
      for (int i = 0; i < localHeaders.size(); i++)
      {
        String str1 = localHeaders.name(i);
        String str2 = localHeaders.value(i);
        localBuilder1.add(str1.toLowerCase(), str2);
      }
      localBuilder.headers(localBuilder1.build());
      return paramChain.proceed(localBuilder.build());
    }
  }

  private static class LoggingRequestInterceptor
    implements Interceptor
  {
    private Logger logger;

    LoggingRequestInterceptor(Logger paramLogger)
    {
      this.logger = ViberEnv.getLogger(paramLogger, "RequestDump");
    }

    public Response intercept(Interceptor.Chain paramChain)
      throws IOException
    {
      int i = 0;
      Request localRequest = paramChain.request();
      Headers localHeaders1 = localRequest.headers();
      for (int j = 0; j < localHeaders1.size(); j++)
      {
        localHeaders1.name(j);
        localHeaders1.value(j);
      }
      Response localResponse = paramChain.proceed(localRequest);
      Headers localHeaders2 = localResponse.headers();
      while (i < localResponse.headers().size())
      {
        localHeaders2.name(i);
        localHeaders2.value(i);
        i++;
      }
      return localResponse;
    }
  }

  private class SingleClientLibNativeHttpDelegate extends OkHttp3HttpDelegate
  {
    private SingleClientLibNativeHttpDelegate()
    {
    }

    protected OkHttpClient createOkHttpClient()
    {
      return DefaultOkHttpClientFactory.this.createClient(OkHttpClientFactory.Type.DIRECT);
    }
  }

  private class SingleClientLibNativeHttpDelegateFactory
    implements com.viber.libnativehttp.Http.DelegateFactory
  {
    private SingleClientLibNativeHttpDelegateFactory()
    {
    }

    public com.viber.libnativehttp.Http.Delegate createDelegate()
    {
      return new DefaultOkHttpClientFactory.SingleClientLibNativeHttpDelegate(DefaultOkHttpClientFactory.this, null);
    }
  }

  private class SingleClientLinkParserHttpDelegate extends DefaultHttpDelegate
  {
    private SingleClientLinkParserHttpDelegate()
    {
    }

    protected OkHttpClient createOkHttpClient()
    {
      return DefaultOkHttpClientFactory.this.createClient(OkHttpClientFactory.Type.DEFAULT);
    }
  }

  private class SingleClientLinkParserHttpDelegateFactory
    implements com.viber.liblinkparser.Http.DelegateFactory
  {
    private SingleClientLinkParserHttpDelegateFactory()
    {
    }

    public com.viber.liblinkparser.Http.Delegate createDelegate()
    {
      return new DefaultOkHttpClientFactory.SingleClientLinkParserHttpDelegate(DefaultOkHttpClientFactory.this, null);
    }
  }

  private static class UnblockerAwaitingInterceptor
    implements Interceptor
  {
    public Response intercept(Interceptor.Chain paramChain)
      throws IOException
    {
      Request localRequest = paramChain.request();
      DefaultOkHttpClientFactory.allowConnection(localRequest.url().toString());
      return paramChain.proceed(localRequest);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.http.DefaultOkHttpClientFactory
 * JD-Core Version:    0.6.2
 */