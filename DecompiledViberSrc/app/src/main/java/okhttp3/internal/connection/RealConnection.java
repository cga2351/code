package okhttp3.internal.connection;

import f.c;
import f.d;
import f.e;
import f.t;
import f.u;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Connection.Builder;
import okhttp3.internal.http2.Http2Connection.Listener;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket.Streams;

public final class RealConnection extends Http2Connection.Listener
  implements Connection
{
  private static final int MAX_TUNNEL_ATTEMPTS = 21;
  private static final String NPE_THROW_WITH_NULL = "throw with null exception";
  public int allocationLimit = 1;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  private final ConnectionPool connectionPool;
  private Handshake handshake;
  private Http2Connection http2Connection;
  public long idleAtNanos = 9223372036854775807L;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  private d sink;
  private Socket socket;
  private e source;
  public int successCount;

  public RealConnection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    this.connectionPool = paramConnectionPool;
    this.route = paramRoute;
  }

  // ERROR //
  private void connectSocket(int paramInt1, int paramInt2, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   4: invokevirtual 73	okhttp3/Route:proxy	()Ljava/net/Proxy;
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   13: invokevirtual 77	okhttp3/Route:address	()Lokhttp3/Address;
    //   16: astore 6
    //   18: aload 5
    //   20: invokevirtual 83	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   23: getstatic 89	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   26: if_acmpeq +14 -> 40
    //   29: aload 5
    //   31: invokevirtual 83	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   34: getstatic 92	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   37: if_acmpne +89 -> 126
    //   40: aload 6
    //   42: invokevirtual 98	okhttp3/Address:socketFactory	()Ljavax/net/SocketFactory;
    //   45: invokevirtual 104	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   48: astore 7
    //   50: aload_0
    //   51: aload 7
    //   53: putfield 106	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   56: aload 4
    //   58: aload_3
    //   59: aload_0
    //   60: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   63: invokevirtual 110	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   66: aload 5
    //   68: invokevirtual 116	okhttp3/EventListener:connectStart	(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   71: aload_0
    //   72: getfield 106	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   75: iload_2
    //   76: invokevirtual 122	java/net/Socket:setSoTimeout	(I)V
    //   79: invokestatic 128	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   82: aload_0
    //   83: getfield 106	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   86: aload_0
    //   87: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   90: invokevirtual 110	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   93: iload_1
    //   94: invokevirtual 131	okhttp3/internal/platform/Platform:connectSocket	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 106	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   102: invokestatic 137	f/l:b	(Ljava/net/Socket;)Lf/t;
    //   105: invokestatic 141	f/l:a	(Lf/t;)Lf/e;
    //   108: putfield 143	okhttp3/internal/connection/RealConnection:source	Lf/e;
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 106	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   116: invokestatic 146	f/l:a	(Ljava/net/Socket;)Lf/s;
    //   119: invokestatic 149	f/l:a	(Lf/s;)Lf/d;
    //   122: putfield 151	okhttp3/internal/connection/RealConnection:sink	Lf/d;
    //   125: return
    //   126: new 118	java/net/Socket
    //   129: dup
    //   130: aload 5
    //   132: invokespecial 154	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   135: astore 7
    //   137: goto -87 -> 50
    //   140: astore 8
    //   142: new 65	java/net/ConnectException
    //   145: dup
    //   146: new 156	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   153: ldc 159
    //   155: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   162: invokevirtual 110	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   165: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 173	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   174: astore 9
    //   176: aload 9
    //   178: aload 8
    //   180: invokevirtual 177	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   183: pop
    //   184: aload 9
    //   186: athrow
    //   187: astore 11
    //   189: ldc 13
    //   191: aload 11
    //   193: invokevirtual 180	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   196: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq -74 -> 125
    //   202: new 63	java/io/IOException
    //   205: dup
    //   206: aload 11
    //   208: invokespecial 189	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   211: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   79	97	140	java/net/ConnectException
    //   97	125	187	java/lang/NullPointerException
  }

  // ERROR //
  private void connectTls(ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   6: invokevirtual 77	okhttp3/Route:address	()Lokhttp3/Address;
    //   9: astore_3
    //   10: aload_3
    //   11: invokevirtual 197	okhttp3/Address:sslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   14: astore 4
    //   16: aload 4
    //   18: aload_0
    //   19: getfield 106	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   22: aload_3
    //   23: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   26: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   29: aload_3
    //   30: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   33: invokevirtual 210	okhttp3/HttpUrl:port	()I
    //   36: iconst_1
    //   37: invokevirtual 215	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   40: checkcast 217	javax/net/ssl/SSLSocket
    //   43: astore 7
    //   45: aload_1
    //   46: aload 7
    //   48: invokevirtual 223	okhttp3/internal/connection/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;
    //   51: astore 10
    //   53: aload 10
    //   55: invokevirtual 229	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   58: ifeq +22 -> 80
    //   61: invokestatic 128	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   64: aload 7
    //   66: aload_3
    //   67: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   70: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   73: aload_3
    //   74: invokevirtual 233	okhttp3/Address:protocols	()Ljava/util/List;
    //   77: invokevirtual 237	okhttp3/internal/platform/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   80: aload 7
    //   82: invokevirtual 240	javax/net/ssl/SSLSocket:startHandshake	()V
    //   85: aload 7
    //   87: invokevirtual 244	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   90: astore 11
    //   92: aload_0
    //   93: aload 11
    //   95: invokespecial 248	okhttp3/internal/connection/RealConnection:isValid	(Ljavax/net/ssl/SSLSession;)Z
    //   98: ifne +60 -> 158
    //   101: new 63	java/io/IOException
    //   104: dup
    //   105: ldc 250
    //   107: invokespecial 251	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   110: athrow
    //   111: astore 9
    //   113: aload 7
    //   115: astore_2
    //   116: aload 9
    //   118: astore 5
    //   120: aload 5
    //   122: invokestatic 257	okhttp3/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   125: ifeq +282 -> 407
    //   128: new 63	java/io/IOException
    //   131: dup
    //   132: aload 5
    //   134: invokespecial 189	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   137: athrow
    //   138: astore 6
    //   140: aload_2
    //   141: ifnull +10 -> 151
    //   144: invokestatic 128	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   147: aload_2
    //   148: invokevirtual 261	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   151: aload_2
    //   152: invokestatic 265	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   155: aload 6
    //   157: athrow
    //   158: aload 11
    //   160: invokestatic 270	okhttp3/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;
    //   163: astore 12
    //   165: aload_3
    //   166: invokevirtual 274	okhttp3/Address:hostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   169: aload_3
    //   170: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   173: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   176: aload 11
    //   178: invokeinterface 280 3 0
    //   183: ifne +100 -> 283
    //   186: aload 12
    //   188: invokevirtual 283	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   191: iconst_0
    //   192: invokeinterface 288 2 0
    //   197: checkcast 290	java/security/cert/X509Certificate
    //   200: astore 16
    //   202: new 292	javax/net/ssl/SSLPeerUnverifiedException
    //   205: dup
    //   206: new 156	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 294
    //   216: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_3
    //   220: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   223: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   226: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 296
    //   232: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 16
    //   237: invokestatic 302	okhttp3/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   240: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 304
    //   246: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 16
    //   251: invokevirtual 308	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   254: invokeinterface 313 1 0
    //   259: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 315
    //   265: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 16
    //   270: invokestatic 321	okhttp3/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   273: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokespecial 322	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   282: athrow
    //   283: aload_3
    //   284: invokevirtual 326	okhttp3/Address:certificatePinner	()Lokhttp3/CertificatePinner;
    //   287: aload_3
    //   288: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   291: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   294: aload 12
    //   296: invokevirtual 283	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   299: invokevirtual 330	okhttp3/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   302: aload 10
    //   304: invokevirtual 229	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   307: istore 13
    //   309: aconst_null
    //   310: astore 14
    //   312: iload 13
    //   314: ifeq +13 -> 327
    //   317: invokestatic 128	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   320: aload 7
    //   322: invokevirtual 334	okhttp3/internal/platform/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   325: astore 14
    //   327: aload_0
    //   328: aload 7
    //   330: putfield 336	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   333: aload_0
    //   334: aload_0
    //   335: getfield 336	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   338: invokestatic 137	f/l:b	(Ljava/net/Socket;)Lf/t;
    //   341: invokestatic 141	f/l:a	(Lf/t;)Lf/e;
    //   344: putfield 143	okhttp3/internal/connection/RealConnection:source	Lf/e;
    //   347: aload_0
    //   348: aload_0
    //   349: getfield 336	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   352: invokestatic 146	f/l:a	(Ljava/net/Socket;)Lf/s;
    //   355: invokestatic 149	f/l:a	(Lf/s;)Lf/d;
    //   358: putfield 151	okhttp3/internal/connection/RealConnection:sink	Lf/d;
    //   361: aload_0
    //   362: aload 12
    //   364: putfield 338	okhttp3/internal/connection/RealConnection:handshake	Lokhttp3/Handshake;
    //   367: aload 14
    //   369: ifnull +30 -> 399
    //   372: aload 14
    //   374: invokestatic 343	okhttp3/Protocol:get	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   377: astore 15
    //   379: aload_0
    //   380: aload 15
    //   382: putfield 345	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   385: aload 7
    //   387: ifnull +11 -> 398
    //   390: invokestatic 128	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   393: aload 7
    //   395: invokevirtual 261	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   398: return
    //   399: getstatic 348	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   402: astore 15
    //   404: goto -25 -> 379
    //   407: aload 5
    //   409: athrow
    //   410: astore 5
    //   412: aconst_null
    //   413: astore_2
    //   414: goto -294 -> 120
    //   417: astore 8
    //   419: aload 7
    //   421: astore_2
    //   422: aload 8
    //   424: astore 6
    //   426: goto -286 -> 140
    //
    // Exception table:
    //   from	to	target	type
    //   45	80	111	java/lang/AssertionError
    //   80	111	111	java/lang/AssertionError
    //   158	283	111	java/lang/AssertionError
    //   283	309	111	java/lang/AssertionError
    //   317	327	111	java/lang/AssertionError
    //   327	367	111	java/lang/AssertionError
    //   372	379	111	java/lang/AssertionError
    //   379	385	111	java/lang/AssertionError
    //   399	404	111	java/lang/AssertionError
    //   16	45	138	finally
    //   120	138	138	finally
    //   407	410	138	finally
    //   16	45	410	java/lang/AssertionError
    //   45	80	417	finally
    //   80	111	417	finally
    //   158	283	417	finally
    //   283	309	417	finally
    //   317	327	417	finally
    //   327	367	417	finally
    //   372	379	417	finally
    //   379	385	417	finally
    //   399	404	417	finally
  }

  private void connectTunnel(int paramInt1, int paramInt2, int paramInt3, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    Request localRequest = createTunnelRequest();
    HttpUrl localHttpUrl = localRequest.url();
    for (int i = 0; ; i++)
    {
      if (i < 21)
      {
        connectSocket(paramInt1, paramInt2, paramCall, paramEventListener);
        localRequest = createTunnel(paramInt2, paramInt3, localRequest, localHttpUrl);
        if (localRequest != null);
      }
      else
      {
        return;
      }
      Util.closeQuietly(this.rawSocket);
      this.rawSocket = null;
      this.sink = null;
      this.source = null;
      paramEventListener.connectEnd(paramCall, this.route.socketAddress(), this.route.proxy(), null);
    }
  }

  private Request createTunnel(int paramInt1, int paramInt2, Request paramRequest, HttpUrl paramHttpUrl)
    throws IOException
  {
    String str = "CONNECT " + Util.hostHeader(paramHttpUrl, true) + " HTTP/1.1";
    Response localResponse;
    do
    {
      Http1Codec localHttp1Codec = new Http1Codec(null, null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      localHttp1Codec.writeRequest(paramRequest.headers(), str);
      localHttp1Codec.finishRequest();
      localResponse = localHttp1Codec.readResponseHeaders(false).request(paramRequest).build();
      long l = HttpHeaders.contentLength(localResponse);
      if (l == -1L)
        l = 0L;
      t localt = localHttp1Codec.newFixedLengthSource(l);
      Util.skipAll(localt, 2147483647, TimeUnit.MILLISECONDS);
      localt.close();
      switch (localResponse.code())
      {
      default:
        throw new IOException("Unexpected response code for CONNECT: " + localResponse.code());
      case 200:
        if ((!this.source.b().f()) || (!this.sink.b().f()))
          throw new IOException("TLS tunnel buffered too many bytes!");
        return null;
      case 407:
      }
      paramRequest = this.route.address().proxyAuthenticator().authenticate(this.route, localResponse);
      if (paramRequest == null)
        throw new IOException("Failed to authenticate with proxy");
    }
    while (!"close".equalsIgnoreCase(localResponse.header("Connection")));
    return paramRequest;
  }

  private Request createTunnelRequest()
  {
    return new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }

  private void establishProtocol(ConnectionSpecSelector paramConnectionSpecSelector, int paramInt, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    if (this.route.address().sslSocketFactory() == null)
    {
      this.protocol = Protocol.HTTP_1_1;
      this.socket = this.rawSocket;
    }
    do
    {
      return;
      paramEventListener.secureConnectStart(paramCall);
      connectTls(paramConnectionSpecSelector);
      paramEventListener.secureConnectEnd(paramCall, this.handshake);
    }
    while (this.protocol != Protocol.HTTP_2);
    this.socket.setSoTimeout(0);
    this.http2Connection = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(paramInt).build();
    this.http2Connection.start();
  }

  private boolean isValid(SSLSession paramSSLSession)
  {
    return (!"NONE".equals(paramSSLSession.getProtocol())) && (!"SSL_NULL_WITH_NULL_NULL".equals(paramSSLSession.getCipherSuite()));
  }

  public static RealConnection testConnection(ConnectionPool paramConnectionPool, Route paramRoute, Socket paramSocket, long paramLong)
  {
    RealConnection localRealConnection = new RealConnection(paramConnectionPool, paramRoute);
    localRealConnection.socket = paramSocket;
    localRealConnection.idleAtNanos = paramLong;
    return localRealConnection;
  }

  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }

  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Call paramCall, EventListener paramEventListener)
  {
    if (this.protocol != null)
      throw new IllegalStateException("already connected");
    List localList = this.route.address().connectionSpecs();
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector(localList);
    if (this.route.address().sslSocketFactory() == null)
    {
      if (!localList.contains(ConnectionSpec.CLEARTEXT))
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
      String str = this.route.address().url().host();
      if (!Platform.get().isCleartextTrafficPermitted(str))
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + str + " not permitted by network security policy"));
    }
    Object localObject2;
    for (Object localObject1 = localObject2; ; localObject1 = null)
    {
      try
      {
        if (this.route.requiresTunnel())
        {
          connectTunnel(paramInt1, paramInt2, paramInt3, paramCall, paramEventListener);
          Socket localSocket = this.rawSocket;
          if (localSocket != null)
            break label234;
        }
        while ((this.route.requiresTunnel()) && (this.rawSocket == null))
        {
          throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
          connectSocket(paramInt1, paramInt2, paramCall, paramEventListener);
          label234: establishProtocol(localConnectionSpecSelector, paramInt4, paramCall, paramEventListener);
          paramEventListener.connectEnd(paramCall, this.route.socketAddress(), this.route.proxy(), this.protocol);
        }
      }
      catch (IOException localIOException)
      {
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        this.http2Connection = null;
        paramEventListener.connectFailed(paramCall, this.route.socketAddress(), this.route.proxy(), null, localIOException);
        if (localObject1 == null);
        for (localObject2 = new RouteException(localIOException); (!paramBoolean) || (!localConnectionSpecSelector.connectionFailed(localIOException)); localObject2 = localObject1)
        {
          throw ((Throwable)localObject2);
          localObject1.addConnectException(localIOException);
        }
      }
      if (this.http2Connection == null)
        return;
      synchronized (this.connectionPool)
      {
        this.allocationLimit = this.http2Connection.maxConcurrentStreams();
        return;
      }
    }
  }

  public Handshake handshake()
  {
    return this.handshake;
  }

  public boolean isEligible(Address paramAddress, @Nullable Route paramRoute)
  {
    if ((this.allocations.size() >= this.allocationLimit) || (this.noNewStreams));
    do
    {
      do
        return false;
      while (!Internal.instance.equalsNonHost(this.route.address(), paramAddress));
      if (paramAddress.url().host().equals(route().address().url().host()))
        return true;
    }
    while ((this.http2Connection == null) || (paramRoute == null) || (paramRoute.proxy().type() != Proxy.Type.DIRECT) || (this.route.proxy().type() != Proxy.Type.DIRECT) || (!this.route.socketAddress().equals(paramRoute.socketAddress())) || (paramRoute.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE) || (!supportsUrl(paramAddress.url())));
    try
    {
      paramAddress.certificatePinner().check(paramAddress.url().host(), handshake().peerCertificates());
      return true;
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
    }
    return false;
  }

  public boolean isHealthy(boolean paramBoolean)
  {
    boolean bool1 = true;
    if ((this.socket.isClosed()) || (this.socket.isInputShutdown()) || (this.socket.isOutputShutdown()))
      bool1 = false;
    do
    {
      do
      {
        return bool1;
        if (this.http2Connection == null)
          break;
      }
      while (!this.http2Connection.isShutdown());
      return false;
    }
    while (!paramBoolean);
    try
    {
      int i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(1);
        boolean bool2 = this.source.f();
        if (bool2)
          return false;
        return bool1;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
    }
    return bool1;
  }

  public boolean isMultiplexed()
  {
    return this.http2Connection != null;
  }

  public HttpCodec newCodec(OkHttpClient paramOkHttpClient, Interceptor.Chain paramChain, StreamAllocation paramStreamAllocation)
    throws SocketException
  {
    if (this.http2Connection != null)
      return new Http2Codec(paramOkHttpClient, paramChain, paramStreamAllocation, this.http2Connection);
    this.socket.setSoTimeout(paramChain.readTimeoutMillis());
    this.source.timeout().timeout(paramChain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
    this.sink.timeout().timeout(paramChain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    return new Http1Codec(paramOkHttpClient, paramStreamAllocation, this.source, this.sink);
  }

  public RealWebSocket.Streams newWebSocketStreams(final StreamAllocation paramStreamAllocation)
  {
    return new RealWebSocket.Streams(true, this.source, this.sink)
    {
      public void close()
        throws IOException
      {
        paramStreamAllocation.streamFinished(true, paramStreamAllocation.codec(), -1L, null);
      }
    };
  }

  public void onSettings(Http2Connection paramHttp2Connection)
  {
    synchronized (this.connectionPool)
    {
      this.allocationLimit = paramHttp2Connection.maxConcurrentStreams();
      return;
    }
  }

  public void onStream(Http2Stream paramHttp2Stream)
    throws IOException
  {
    paramHttp2Stream.close(ErrorCode.REFUSED_STREAM);
  }

  public Protocol protocol()
  {
    return this.protocol;
  }

  public Route route()
  {
    return this.route;
  }

  public Socket socket()
  {
    return this.socket;
  }

  public boolean supportsUrl(HttpUrl paramHttpUrl)
  {
    if (paramHttpUrl.port() != this.route.address().url().port())
      return false;
    if (!paramHttpUrl.host().equals(this.route.address().url().host()))
    {
      if ((this.handshake != null) && (OkHostnameVerifier.INSTANCE.verify(paramHttpUrl.host(), (X509Certificate)this.handshake.peerCertificates().get(0))));
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    return true;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(":").append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
    if (this.handshake != null);
    for (Object localObject = this.handshake.cipherSuite(); ; localObject = "none")
      return localObject + " protocol=" + this.protocol + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.RealConnection
 * JD-Core Version:    0.6.2
 */