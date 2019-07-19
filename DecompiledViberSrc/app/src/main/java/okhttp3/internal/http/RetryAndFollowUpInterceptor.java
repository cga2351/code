package okhttp3.internal.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.StreamAllocation;

public final class RetryAndFollowUpInterceptor
  implements Interceptor
{
  private static final int MAX_FOLLOW_UPS = 20;
  private Object callStackTrace;
  private volatile boolean canceled;
  private final OkHttpClient client;
  private final boolean forWebSocket;
  private volatile StreamAllocation streamAllocation;

  public RetryAndFollowUpInterceptor(OkHttpClient paramOkHttpClient, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.forWebSocket = paramBoolean;
  }

  private Address createAddress(HttpUrl paramHttpUrl)
  {
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramHttpUrl.isHttps())
    {
      localSSLSocketFactory = this.client.sslSocketFactory();
      localHostnameVerifier = this.client.hostnameVerifier();
    }
    for (CertificatePinner localCertificatePinner = this.client.certificatePinner(); ; localCertificatePinner = null)
    {
      return new Address(paramHttpUrl.host(), paramHttpUrl.port(), this.client.dns(), this.client.socketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
      localSSLSocketFactory = null;
      localHostnameVerifier = null;
    }
  }

  private Request followUpRequest(Response paramResponse, Route paramRoute)
    throws IOException
  {
    if (paramResponse == null)
      throw new IllegalStateException();
    int i = paramResponse.code();
    String str1 = paramResponse.request().method();
    switch (i)
    {
    default:
    case 407:
    case 401:
    case 307:
    case 308:
    case 300:
    case 301:
    case 302:
    case 303:
    case 408:
    case 503:
    }
    label383: 
    do
    {
      do
      {
        HttpUrl localHttpUrl;
        do
        {
          String str2;
          do
          {
            do
            {
              return null;
              if (paramRoute != null);
              for (Proxy localProxy = paramRoute.proxy(); localProxy.type() != Proxy.Type.HTTP; localProxy = this.client.proxy())
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
              return this.client.proxyAuthenticator().authenticate(paramRoute, paramResponse);
              return this.client.authenticator().authenticate(paramRoute, paramResponse);
            }
            while (((!str1.equals("GET")) && (!str1.equals("HEAD"))) || (!this.client.followRedirects()));
            str2 = paramResponse.header("Location");
          }
          while (str2 == null);
          localHttpUrl = paramResponse.request().url().resolve(str2);
        }
        while ((localHttpUrl == null) || ((!localHttpUrl.scheme().equals(paramResponse.request().url().scheme())) && (!this.client.followSslRedirects())));
        Request.Builder localBuilder = paramResponse.request().newBuilder();
        boolean bool;
        if (HttpMethod.permitsRequestBody(str1))
        {
          bool = HttpMethod.redirectsWithBody(str1);
          if (!HttpMethod.redirectsToGet(str1))
            break label383;
          localBuilder.method("GET", null);
        }
        while (true)
        {
          if (!bool)
          {
            localBuilder.removeHeader("Transfer-Encoding");
            localBuilder.removeHeader("Content-Length");
            localBuilder.removeHeader("Content-Type");
          }
          if (!sameConnection(paramResponse, localHttpUrl))
            localBuilder.removeHeader("Authorization");
          return localBuilder.url(localHttpUrl).build();
          RequestBody localRequestBody = null;
          if (bool)
            localRequestBody = paramResponse.request().body();
          localBuilder.method(str1, localRequestBody);
        }
      }
      while ((!this.client.retryOnConnectionFailure()) || ((paramResponse.request().body() instanceof UnrepeatableRequestBody)) || ((paramResponse.priorResponse() != null) && (paramResponse.priorResponse().code() == 408)) || (retryAfter(paramResponse, 0) > 0));
      return paramResponse.request();
    }
    while (((paramResponse.priorResponse() != null) && (paramResponse.priorResponse().code() == 503)) || (retryAfter(paramResponse, 2147483647) != 0));
    return paramResponse.request();
  }

  private boolean isRecoverable(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramIOException instanceof ProtocolException));
    do
    {
      return false;
      if ((paramIOException instanceof InterruptedIOException))
      {
        if (((paramIOException instanceof SocketTimeoutException)) && (!paramBoolean));
        while (true)
        {
          return bool;
          bool = false;
        }
      }
    }
    while ((((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)));
    return bool;
  }

  private boolean recover(IOException paramIOException, StreamAllocation paramStreamAllocation, boolean paramBoolean, Request paramRequest)
  {
    paramStreamAllocation.streamFailed(paramIOException);
    if (!this.client.retryOnConnectionFailure());
    while (((paramBoolean) && ((paramRequest.body() instanceof UnrepeatableRequestBody))) || (!isRecoverable(paramIOException, paramBoolean)) || (!paramStreamAllocation.hasMoreRoutes()))
      return false;
    return true;
  }

  private int retryAfter(Response paramResponse, int paramInt)
  {
    String str = paramResponse.header("Retry-After");
    if (str == null)
      return paramInt;
    if (str.matches("\\d+"))
      return Integer.valueOf(str).intValue();
    return 2147483647;
  }

  private boolean sameConnection(Response paramResponse, HttpUrl paramHttpUrl)
  {
    HttpUrl localHttpUrl = paramResponse.request().url();
    return (localHttpUrl.host().equals(paramHttpUrl.host())) && (localHttpUrl.port() == paramHttpUrl.port()) && (localHttpUrl.scheme().equals(paramHttpUrl.scheme()));
  }

  public void cancel()
  {
    this.canceled = true;
    StreamAllocation localStreamAllocation = this.streamAllocation;
    if (localStreamAllocation != null)
      localStreamAllocation.cancel();
  }

  // ERROR //
  public Response intercept(okhttp3.Interceptor.Chain paramChain)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 294 1 0
    //   6: astore_2
    //   7: aload_1
    //   8: checkcast 296	okhttp3/internal/http/RealInterceptorChain
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 300	okhttp3/internal/http/RealInterceptorChain:call	()Lokhttp3/Call;
    //   16: astore 4
    //   18: aload_3
    //   19: invokevirtual 304	okhttp3/internal/http/RealInterceptorChain:eventListener	()Lokhttp3/EventListener;
    //   22: astore 5
    //   24: new 255	okhttp3/internal/connection/StreamAllocation
    //   27: dup
    //   28: aload_0
    //   29: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   32: invokevirtual 308	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   35: aload_0
    //   36: aload_2
    //   37: invokevirtual 164	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   40: invokespecial 310	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   43: aload 4
    //   45: aload 5
    //   47: aload_0
    //   48: getfield 312	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   51: invokespecial 315	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;Ljava/lang/Object;)V
    //   54: astore 6
    //   56: aload_0
    //   57: aload 6
    //   59: putfield 285	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   62: iconst_0
    //   63: istore 7
    //   65: aload 6
    //   67: astore 8
    //   69: aload_2
    //   70: astore 9
    //   72: aconst_null
    //   73: astore 10
    //   75: aload_0
    //   76: getfield 283	okhttp3/internal/http/RetryAndFollowUpInterceptor:canceled	Z
    //   79: ifeq +19 -> 98
    //   82: aload 8
    //   84: invokevirtual 318	okhttp3/internal/connection/StreamAllocation:release	()V
    //   87: new 93	java/io/IOException
    //   90: dup
    //   91: ldc_w 320
    //   94: invokespecial 321	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    //   98: aload_3
    //   99: aload 9
    //   101: aload 8
    //   103: aconst_null
    //   104: aconst_null
    //   105: invokevirtual 325	okhttp3/internal/http/RealInterceptorChain:proceed	(Lokhttp3/Request;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/internal/http/HttpCodec;Lokhttp3/internal/connection/RealConnection;)Lokhttp3/Response;
    //   108: astore 15
    //   110: aload 15
    //   112: astore 16
    //   114: aload 10
    //   116: ifnull +28 -> 144
    //   119: aload 16
    //   121: invokevirtual 328	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   124: aload 10
    //   126: invokevirtual 328	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   129: aconst_null
    //   130: invokevirtual 333	okhttp3/Response$Builder:body	(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   133: invokevirtual 335	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   136: invokevirtual 338	okhttp3/Response$Builder:priorResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   139: invokevirtual 335	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   142: astore 16
    //   144: aload_0
    //   145: aload 16
    //   147: aload 8
    //   149: invokevirtual 342	okhttp3/internal/connection/StreamAllocation:route	()Lokhttp3/Route;
    //   152: invokespecial 344	okhttp3/internal/http/RetryAndFollowUpInterceptor:followUpRequest	(Lokhttp3/Response;Lokhttp3/Route;)Lokhttp3/Request;
    //   155: astore 17
    //   157: aload 17
    //   159: ifnonnull +96 -> 255
    //   162: aload_0
    //   163: getfield 27	okhttp3/internal/http/RetryAndFollowUpInterceptor:forWebSocket	Z
    //   166: ifne +8 -> 174
    //   169: aload 8
    //   171: invokevirtual 318	okhttp3/internal/connection/StreamAllocation:release	()V
    //   174: aload 16
    //   176: areturn
    //   177: astore 14
    //   179: aload_0
    //   180: aload 14
    //   182: invokevirtual 348	okhttp3/internal/connection/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   185: aload 8
    //   187: iconst_0
    //   188: aload 9
    //   190: invokespecial 350	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;Lokhttp3/internal/connection/StreamAllocation;ZLokhttp3/Request;)Z
    //   193: ifne -118 -> 75
    //   196: aload 14
    //   198: invokevirtual 348	okhttp3/internal/connection/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   201: athrow
    //   202: astore 13
    //   204: aload 8
    //   206: aconst_null
    //   207: invokevirtual 259	okhttp3/internal/connection/StreamAllocation:streamFailed	(Ljava/io/IOException;)V
    //   210: aload 8
    //   212: invokevirtual 318	okhttp3/internal/connection/StreamAllocation:release	()V
    //   215: aload 13
    //   217: athrow
    //   218: astore 11
    //   220: aload 11
    //   222: instanceof 352
    //   225: ifne +24 -> 249
    //   228: iconst_1
    //   229: istore 12
    //   231: aload_0
    //   232: aload 11
    //   234: aload 8
    //   236: iload 12
    //   238: aload 9
    //   240: invokespecial 350	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;Lokhttp3/internal/connection/StreamAllocation;ZLokhttp3/Request;)Z
    //   243: ifne -168 -> 75
    //   246: aload 11
    //   248: athrow
    //   249: iconst_0
    //   250: istore 12
    //   252: goto -21 -> 231
    //   255: aload 16
    //   257: invokevirtual 355	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   260: invokestatic 361	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   263: iload 7
    //   265: iconst_1
    //   266: iadd
    //   267: istore 18
    //   269: iload 18
    //   271: bipush 20
    //   273: if_icmple +37 -> 310
    //   276: aload 8
    //   278: invokevirtual 318	okhttp3/internal/connection/StreamAllocation:release	()V
    //   281: new 127	java/net/ProtocolException
    //   284: dup
    //   285: new 363	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 366
    //   295: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload 18
    //   300: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokespecial 132	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   309: athrow
    //   310: aload 17
    //   312: invokevirtual 221	okhttp3/Request:body	()Lokhttp3/RequestBody;
    //   315: instanceof 226
    //   318: ifeq +24 -> 342
    //   321: aload 8
    //   323: invokevirtual 318	okhttp3/internal/connection/StreamAllocation:release	()V
    //   326: new 378	java/net/HttpRetryException
    //   329: dup
    //   330: ldc_w 380
    //   333: aload 16
    //   335: invokevirtual 101	okhttp3/Response:code	()I
    //   338: invokespecial 383	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   341: athrow
    //   342: aload_0
    //   343: aload 16
    //   345: aload 17
    //   347: invokevirtual 164	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   350: invokespecial 209	okhttp3/internal/http/RetryAndFollowUpInterceptor:sameConnection	(Lokhttp3/Response;Lokhttp3/HttpUrl;)Z
    //   353: ifne +66 -> 419
    //   356: aload 8
    //   358: invokevirtual 318	okhttp3/internal/connection/StreamAllocation:release	()V
    //   361: new 255	okhttp3/internal/connection/StreamAllocation
    //   364: dup
    //   365: aload_0
    //   366: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   369: invokevirtual 308	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   372: aload_0
    //   373: aload 17
    //   375: invokevirtual 164	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   378: invokespecial 310	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   381: aload 4
    //   383: aload 5
    //   385: aload_0
    //   386: getfield 312	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   389: invokespecial 315	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;Ljava/lang/Object;)V
    //   392: astore 19
    //   394: aload_0
    //   395: aload 19
    //   397: putfield 285	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   400: iload 18
    //   402: istore 7
    //   404: aload 19
    //   406: astore 8
    //   408: aload 17
    //   410: astore 9
    //   412: aload 16
    //   414: astore 10
    //   416: goto -341 -> 75
    //   419: aload 8
    //   421: invokevirtual 387	okhttp3/internal/connection/StreamAllocation:codec	()Lokhttp3/internal/http/HttpCodec;
    //   424: ifnull +38 -> 462
    //   427: new 95	java/lang/IllegalStateException
    //   430: dup
    //   431: new 363	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 389
    //   441: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 16
    //   446: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   449: ldc_w 394
    //   452: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokespecial 395	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   461: athrow
    //   462: aload 8
    //   464: astore 19
    //   466: goto -66 -> 400
    //
    // Exception table:
    //   from	to	target	type
    //   98	110	177	okhttp3/internal/connection/RouteException
    //   98	110	202	finally
    //   179	202	202	finally
    //   220	228	202	finally
    //   231	249	202	finally
    //   98	110	218	java/io/IOException
  }

  public boolean isCanceled()
  {
    return this.canceled;
  }

  public void setCallStackTrace(Object paramObject)
  {
    this.callStackTrace = paramObject;
  }

  public StreamAllocation streamAllocation()
  {
    return this.streamAllocation;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.RetryAndFollowUpInterceptor
 * JD-Core Version:    0.6.2
 */