package okhttp3.internal.huc;

import f.c;
import f.u;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Connection;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.JavaNetHeaders;
import okhttp3.internal.URLFilter;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;

public final class OkHttpURLConnection extends HttpURLConnection
  implements Callback
{
  private static final Set<String> METHODS = new LinkedHashSet(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH" }));
  public static final String RESPONSE_SOURCE;
  public static final String SELECTED_PROTOCOL = Platform.get().getPrefix() + "-Selected-Protocol";
  Call call;
  private Throwable callFailure;
  OkHttpClient client;
  boolean connectPending = true;
  private boolean executed;
  private long fixedContentLength = -1L;
  Handshake handshake;
  private final Object lock = new Object();
  private final NetworkInterceptor networkInterceptor = new NetworkInterceptor();
  Response networkResponse;
  Proxy proxy;
  private Headers.Builder requestHeaders = new Headers.Builder();
  private Response response;
  private Headers responseHeaders;
  URLFilter urlFilter;

  static
  {
    RESPONSE_SOURCE = Platform.get().getPrefix() + "-Response-Source";
  }

  public OkHttpURLConnection(URL paramURL, OkHttpClient paramOkHttpClient)
  {
    super(paramURL);
    this.client = paramOkHttpClient;
  }

  public OkHttpURLConnection(URL paramURL, OkHttpClient paramOkHttpClient, URLFilter paramURLFilter)
  {
    this(paramURL, paramOkHttpClient);
    this.urlFilter = paramURLFilter;
  }

  private Call buildCall()
    throws IOException
  {
    boolean bool = true;
    long l = -1L;
    if (this.call != null)
      return this.call;
    this.connected = bool;
    label124: String str;
    label149: Object localObject;
    if (this.doOutput)
    {
      if (this.method.equals("GET"))
        this.method = "POST";
    }
    else
    {
      if (this.requestHeaders.get("User-Agent") == null)
        this.requestHeaders.add("User-Agent", defaultUserAgent());
      if (!HttpMethod.permitsRequestBody(this.method))
        break label443;
      if (this.requestHeaders.get("Content-Type") == null)
        this.requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
      if ((this.fixedContentLength == l) && (this.chunkLength <= 0))
        break label411;
      str = this.requestHeaders.get("Content-Length");
      if (this.fixedContentLength == l)
        break label416;
      l = this.fixedContentLength;
      if (!bool)
        break label430;
      localObject = new StreamedRequestBody(l);
      label163: ((OutputStreamRequestBody)localObject).timeout().timeout(this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    }
    while (true)
    {
      Request localRequest = new Request.Builder().url(Internal.instance.getHttpUrlChecked(getURL().toString())).headers(this.requestHeaders.build()).method(this.method, (RequestBody)localObject).build();
      if (this.urlFilter != null)
        this.urlFilter.checkURLPermitted(localRequest.url().url());
      OkHttpClient.Builder localBuilder = this.client.newBuilder();
      localBuilder.interceptors().clear();
      localBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
      localBuilder.networkInterceptors().clear();
      localBuilder.networkInterceptors().add(this.networkInterceptor);
      localBuilder.dispatcher(new Dispatcher(this.client.dispatcher().executorService()));
      if (!getUseCaches())
        localBuilder.cache(null);
      Call localCall = localBuilder.build().newCall(localRequest);
      this.call = localCall;
      return localCall;
      if (HttpMethod.permitsRequestBody(this.method))
        break;
      throw new ProtocolException(this.method + " does not support writing");
      label411: bool = false;
      break label124;
      label416: if (str == null)
        break label149;
      l = Long.parseLong(str);
      break label149;
      label430: localObject = new BufferedRequestBody(l);
      break label163;
      label443: localObject = null;
    }
  }

  private String defaultUserAgent()
  {
    String str = System.getProperty("http.agent");
    if (str != null)
      return toHumanReadableAscii(str);
    return Version.userAgent();
  }

  private Headers getHeaders()
    throws IOException
  {
    if (this.responseHeaders == null)
    {
      Response localResponse = getResponse(true);
      this.responseHeaders = localResponse.headers().newBuilder().add(SELECTED_PROTOCOL, localResponse.protocol().toString()).add(RESPONSE_SOURCE, responseSourceHeader(localResponse)).build();
    }
    return this.responseHeaders;
  }

  private Response getResponse(boolean paramBoolean)
    throws IOException
  {
    synchronized (this.lock)
    {
      if (this.response != null)
      {
        Response localResponse3 = this.response;
        return localResponse3;
      }
      if (this.callFailure == null)
        break label67;
      if ((paramBoolean) && (this.networkResponse != null))
      {
        Response localResponse1 = this.networkResponse;
        return localResponse1;
      }
    }
    throw propagate(this.callFailure);
    label67: Call localCall = buildCall();
    this.networkInterceptor.proceed();
    OutputStreamRequestBody localOutputStreamRequestBody = (OutputStreamRequestBody)localCall.request().body();
    if (localOutputStreamRequestBody != null)
      localOutputStreamRequestBody.outputStream().close();
    if (this.executed)
      synchronized (this.lock)
      {
        try
        {
          while ((this.response == null) && (this.callFailure == null))
            this.lock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new InterruptedIOException();
        }
      }
    while (true)
    {
      synchronized (this.lock)
      {
        if (this.callFailure == null)
          break;
        throw propagate(this.callFailure);
      }
      this.executed = true;
      try
      {
        onResponse(localCall, localCall.execute());
      }
      catch (IOException localIOException)
      {
        onFailure(localCall, localIOException);
      }
    }
    if (this.response != null)
    {
      Response localResponse2 = this.response;
      return localResponse2;
    }
    throw new AssertionError();
  }

  private static IOException propagate(Throwable paramThrowable)
    throws IOException
  {
    if ((paramThrowable instanceof IOException))
      throw ((IOException)paramThrowable);
    if ((paramThrowable instanceof Error))
      throw ((Error)paramThrowable);
    if ((paramThrowable instanceof RuntimeException))
      throw ((RuntimeException)paramThrowable);
    throw new AssertionError();
  }

  private static String responseSourceHeader(Response paramResponse)
  {
    if (paramResponse.networkResponse() == null)
    {
      if (paramResponse.cacheResponse() == null)
        return "NONE";
      return "CACHE " + paramResponse.code();
    }
    if (paramResponse.cacheResponse() == null)
      return "NETWORK " + paramResponse.code();
    return "CONDITIONAL_CACHE " + paramResponse.networkResponse().code();
  }

  private static String toHumanReadableAscii(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    while (j < i)
    {
      int k = paramString.codePointAt(j);
      if ((k > 31) && (k < 127))
      {
        j += Character.charCount(k);
      }
      else
      {
        c localc = new c();
        localc.a(paramString, 0, j);
        localc.a(63);
        int m = j + Character.charCount(k);
        if (m < i)
        {
          int n = paramString.codePointAt(m);
          if ((n > 31) && (n < 127));
          for (int i1 = n; ; i1 = 63)
          {
            localc.a(i1);
            m += Character.charCount(n);
            break;
          }
        }
        paramString = localc.r();
      }
    }
    return paramString;
  }

  public void addRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected)
      throw new IllegalStateException("Cannot add request property after connection is made");
    if (paramString1 == null)
      throw new NullPointerException("field == null");
    if (paramString2 == null)
    {
      Platform.get().log(5, "Ignoring header " + paramString1 + " because its value was null.", null);
      return;
    }
    this.requestHeaders.add(paramString1, paramString2);
  }

  public void connect()
    throws IOException
  {
    if (this.executed)
      return;
    Call localCall = buildCall();
    this.executed = true;
    localCall.enqueue(this);
    synchronized (this.lock)
    {
      try
      {
        while ((this.connectPending) && (this.response == null) && (this.callFailure == null))
          this.lock.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new InterruptedIOException();
      }
    }
    if (this.callFailure != null)
      throw propagate(this.callFailure);
  }

  public void disconnect()
  {
    if (this.call == null)
      return;
    this.networkInterceptor.proceed();
    this.call.cancel();
  }

  public int getConnectTimeout()
  {
    return this.client.connectTimeoutMillis();
  }

  public InputStream getErrorStream()
  {
    try
    {
      Response localResponse = getResponse(true);
      boolean bool = HttpHeaders.hasBody(localResponse);
      Object localObject = null;
      if (bool)
      {
        int i = localResponse.code();
        localObject = null;
        if (i >= 400)
        {
          InputStream localInputStream = localResponse.body().byteStream();
          localObject = localInputStream;
        }
      }
      return localObject;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public String getHeaderField(int paramInt)
  {
    try
    {
      Headers localHeaders = getHeaders();
      if (paramInt >= 0)
      {
        if (paramInt >= localHeaders.size())
          return null;
        String str = localHeaders.value(paramInt);
        return str;
      }
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public String getHeaderField(String paramString)
  {
    if (paramString == null);
    try
    {
      return StatusLine.get(getResponse(true)).toString();
      String str = getHeaders().get(paramString);
      return str;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public String getHeaderFieldKey(int paramInt)
  {
    try
    {
      Headers localHeaders = getHeaders();
      if (paramInt >= 0)
      {
        if (paramInt >= localHeaders.size())
          return null;
        String str = localHeaders.name(paramInt);
        return str;
      }
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public Map<String, List<String>> getHeaderFields()
  {
    try
    {
      Map localMap = JavaNetHeaders.toMultimap(getHeaders(), StatusLine.get(getResponse(true)).toString());
      return localMap;
    }
    catch (IOException localIOException)
    {
    }
    return Collections.emptyMap();
  }

  public InputStream getInputStream()
    throws IOException
  {
    if (!this.doInput)
      throw new ProtocolException("This protocol does not support input");
    Response localResponse = getResponse(false);
    if (localResponse.code() >= 400)
      throw new FileNotFoundException(this.url.toString());
    return localResponse.body().byteStream();
  }

  public boolean getInstanceFollowRedirects()
  {
    return this.client.followRedirects();
  }

  public OutputStream getOutputStream()
    throws IOException
  {
    OutputStreamRequestBody localOutputStreamRequestBody = (OutputStreamRequestBody)buildCall().request().body();
    if (localOutputStreamRequestBody == null)
      throw new ProtocolException("method does not support a request body: " + this.method);
    if ((localOutputStreamRequestBody instanceof StreamedRequestBody))
    {
      connect();
      this.networkInterceptor.proceed();
    }
    if (localOutputStreamRequestBody.isClosed())
      throw new ProtocolException("cannot write request body after response has been read");
    return localOutputStreamRequestBody.outputStream();
  }

  public Permission getPermission()
    throws IOException
  {
    URL localURL = getURL();
    String str = localURL.getHost();
    if (localURL.getPort() != -1);
    for (int i = localURL.getPort(); ; i = HttpUrl.defaultPort(localURL.getProtocol()))
    {
      if (usingProxy())
      {
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)this.client.proxy().address();
        str = localInetSocketAddress.getHostName();
        i = localInetSocketAddress.getPort();
      }
      return new SocketPermission(str + ":" + i, "connect, resolve");
    }
  }

  public int getReadTimeout()
  {
    return this.client.readTimeoutMillis();
  }

  public Map<String, List<String>> getRequestProperties()
  {
    if (this.connected)
      throw new IllegalStateException("Cannot access request header fields after connection is set");
    return JavaNetHeaders.toMultimap(this.requestHeaders.build(), null);
  }

  public String getRequestProperty(String paramString)
  {
    if (paramString == null)
      return null;
    return this.requestHeaders.get(paramString);
  }

  public int getResponseCode()
    throws IOException
  {
    return getResponse(true).code();
  }

  public String getResponseMessage()
    throws IOException
  {
    return getResponse(true).message();
  }

  public void onFailure(Call paramCall, IOException paramIOException)
  {
    synchronized (this.lock)
    {
      if ((paramIOException instanceof UnexpectedException))
        paramIOException = paramIOException.getCause();
      this.callFailure = paramIOException;
      this.lock.notifyAll();
      return;
    }
  }

  public void onResponse(Call paramCall, Response paramResponse)
  {
    synchronized (this.lock)
    {
      this.response = paramResponse;
      this.handshake = paramResponse.handshake();
      this.url = paramResponse.request().url().url();
      this.lock.notifyAll();
      return;
    }
  }

  public void setConnectTimeout(int paramInt)
  {
    this.client = this.client.newBuilder().connectTimeout(paramInt, TimeUnit.MILLISECONDS).build();
  }

  public void setFixedLengthStreamingMode(int paramInt)
  {
    setFixedLengthStreamingMode(paramInt);
  }

  public void setFixedLengthStreamingMode(long paramLong)
  {
    if (this.connected)
      throw new IllegalStateException("Already connected");
    if (this.chunkLength > 0)
      throw new IllegalStateException("Already in chunked mode");
    if (paramLong < 0L)
      throw new IllegalArgumentException("contentLength < 0");
    this.fixedContentLength = paramLong;
    this.fixedContentLength = ((int)Math.min(paramLong, 2147483647L));
  }

  public void setIfModifiedSince(long paramLong)
  {
    super.setIfModifiedSince(paramLong);
    if (this.ifModifiedSince != 0L)
    {
      this.requestHeaders.set("If-Modified-Since", HttpDate.format(new Date(this.ifModifiedSince)));
      return;
    }
    this.requestHeaders.removeAll("If-Modified-Since");
  }

  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.client = this.client.newBuilder().followRedirects(paramBoolean).build();
  }

  public void setReadTimeout(int paramInt)
  {
    this.client = this.client.newBuilder().readTimeout(paramInt, TimeUnit.MILLISECONDS).build();
  }

  public void setRequestMethod(String paramString)
    throws ProtocolException
  {
    if (!METHODS.contains(paramString))
      throw new ProtocolException("Expected one of " + METHODS + " but was " + paramString);
    this.method = paramString;
  }

  public void setRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected)
      throw new IllegalStateException("Cannot set request property after connection is made");
    if (paramString1 == null)
      throw new NullPointerException("field == null");
    if (paramString2 == null)
    {
      Platform.get().log(5, "Ignoring header " + paramString1 + " because its value was null.", null);
      return;
    }
    this.requestHeaders.set(paramString1, paramString2);
  }

  public boolean usingProxy()
  {
    if (this.proxy != null);
    Proxy localProxy;
    do
    {
      return true;
      localProxy = this.client.proxy();
    }
    while ((localProxy != null) && (localProxy.type() != Proxy.Type.DIRECT));
    return false;
  }

  final class NetworkInterceptor
    implements Interceptor
  {
    private boolean proceed;

    NetworkInterceptor()
    {
    }

    public Response intercept(Interceptor.Chain paramChain)
      throws IOException
    {
      Request localRequest1 = paramChain.request();
      if (OkHttpURLConnection.this.urlFilter != null)
        OkHttpURLConnection.this.urlFilter.checkURLPermitted(localRequest1.url().url());
      synchronized (OkHttpURLConnection.this.lock)
      {
        OkHttpURLConnection.this.connectPending = false;
        OkHttpURLConnection.this.proxy = paramChain.connection().route().proxy();
        OkHttpURLConnection.this.handshake = paramChain.connection().handshake();
        OkHttpURLConnection.this.lock.notifyAll();
        try
        {
          while (!this.proceed)
            OkHttpURLConnection.this.lock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new InterruptedIOException();
        }
      }
      if ((localRequest1.body() instanceof OutputStreamRequestBody));
      for (Request localRequest2 = ((OutputStreamRequestBody)localRequest1.body()).prepareToSendRequest(localRequest1); ; localRequest2 = localRequest1)
      {
        Response localResponse = paramChain.proceed(localRequest2);
        synchronized (OkHttpURLConnection.this.lock)
        {
          OkHttpURLConnection.this.networkResponse = localResponse;
          OkHttpURLConnection.access$102(OkHttpURLConnection.this, localResponse.request().url().url());
          return localResponse;
        }
      }
    }

    public void proceed()
    {
      synchronized (OkHttpURLConnection.this.lock)
      {
        this.proceed = true;
        OkHttpURLConnection.this.lock.notifyAll();
        return;
      }
    }
  }

  static final class UnexpectedException extends IOException
  {
    static final Interceptor INTERCEPTOR = new Interceptor()
    {
      public Response intercept(Interceptor.Chain paramAnonymousChain)
        throws IOException
      {
        try
        {
          Response localResponse = paramAnonymousChain.proceed(paramAnonymousChain.request());
          return localResponse;
        }
        catch (RuntimeException localRuntimeException)
        {
          throw new OkHttpURLConnection.UnexpectedException(localRuntimeException);
        }
        catch (Error localError)
        {
          label16: break label16;
        }
      }
    };

    UnexpectedException(Throwable paramThrowable)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.huc.OkHttpURLConnection
 * JD-Core Version:    0.6.2
 */