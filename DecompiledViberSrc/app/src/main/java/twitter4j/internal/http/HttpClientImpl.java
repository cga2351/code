package twitter4j.internal.http;

import java.io.IOException;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import twitter4j.TwitterException;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.util.z_T4JInternalStringUtil;

public class HttpClientImpl extends HttpClientBase
  implements Serializable, HttpResponseCode
{
  private static final Map<HttpClientConfiguration, HttpClient> instanceMap = new HashMap(1);
  private static final Logger logger = Logger.getLogger(HttpClientImpl.class);
  private static final long serialVersionUID = -8819171414069621503L;

  static
  {
    if (ConfigurationContext.getInstance().isDalvik())
      System.setProperty("http.keepAlive", "false");
  }

  public HttpClientImpl()
  {
    super(ConfigurationContext.getInstance());
  }

  public HttpClientImpl(HttpClientConfiguration paramHttpClientConfiguration)
  {
    super(paramHttpClientConfiguration);
  }

  public static HttpClient getInstance(HttpClientConfiguration paramHttpClientConfiguration)
  {
    Object localObject = (HttpClient)instanceMap.get(paramHttpClientConfiguration);
    if (localObject == null)
    {
      localObject = new HttpClientImpl(paramHttpClientConfiguration);
      instanceMap.put(paramHttpClientConfiguration, localObject);
    }
    return localObject;
  }

  private void setHeaders(HttpRequest paramHttpRequest, HttpURLConnection paramHttpURLConnection)
  {
    if (logger.isDebugEnabled())
    {
      logger.debug("Request: ");
      logger.debug(paramHttpRequest.getMethod().name() + " ", paramHttpRequest.getURL());
    }
    if (paramHttpRequest.getAuthorization() != null)
    {
      String str2 = paramHttpRequest.getAuthorization().getAuthorizationHeader(paramHttpRequest);
      if (str2 != null)
      {
        if (logger.isDebugEnabled())
          logger.debug("Authorization: ", z_T4JInternalStringUtil.maskString(str2));
        paramHttpURLConnection.addRequestProperty("Authorization", str2);
      }
    }
    if (paramHttpRequest.getRequestHeaders() != null)
    {
      Iterator localIterator = paramHttpRequest.getRequestHeaders().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        paramHttpURLConnection.addRequestProperty(str1, (String)paramHttpRequest.getRequestHeaders().get(str1));
        logger.debug(str1 + ": " + (String)paramHttpRequest.getRequestHeaders().get(str1));
      }
    }
  }

  public HttpResponse get(String paramString)
    throws TwitterException
  {
    return request(new HttpRequest(RequestMethod.GET, paramString, null, null, null));
  }

  protected HttpURLConnection getConnection(String paramString)
    throws IOException
  {
    Proxy localProxy;
    if (isProxyConfigured())
    {
      if ((this.CONF.getHttpProxyUser() != null) && (!this.CONF.getHttpProxyUser().equals("")))
      {
        if (logger.isDebugEnabled())
        {
          logger.debug("Proxy AuthUser: " + this.CONF.getHttpProxyUser());
          logger.debug("Proxy AuthPassword: " + z_T4JInternalStringUtil.maskString(this.CONF.getHttpProxyPassword()));
        }
        Authenticator.setDefault(new Authenticator()
        {
          protected PasswordAuthentication getPasswordAuthentication()
          {
            if (getRequestorType().equals(Authenticator.RequestorType.PROXY))
              return new PasswordAuthentication(HttpClientImpl.this.CONF.getHttpProxyUser(), HttpClientImpl.this.CONF.getHttpProxyPassword().toCharArray());
            return null;
          }
        });
      }
      localProxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
      if (logger.isDebugEnabled())
        logger.debug("Opening proxied connection(" + this.CONF.getHttpProxyHost() + ":" + this.CONF.getHttpProxyPort() + ")");
    }
    for (HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection(localProxy); ; localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection())
    {
      if (this.CONF.getHttpConnectionTimeout() > 0)
        localHttpURLConnection.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
      if (this.CONF.getHttpReadTimeout() > 0)
        localHttpURLConnection.setReadTimeout(this.CONF.getHttpReadTimeout());
      localHttpURLConnection.setInstanceFollowRedirects(false);
      return localHttpURLConnection;
    }
  }

  public HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter)
    throws TwitterException
  {
    return request(new HttpRequest(RequestMethod.POST, paramString, paramArrayOfHttpParameter, null, null));
  }

  // ERROR //
  public HttpResponse request(HttpRequest paramHttpRequest)
    throws TwitterException
  {
    // Byte code:
    //   0: iconst_1
    //   1: aload_0
    //   2: getfield 193	twitter4j/internal/http/HttpClientImpl:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   5: invokeinterface 294 1 0
    //   10: iadd
    //   11: istore_2
    //   12: aconst_null
    //   13: astore_3
    //   14: iconst_0
    //   15: istore 4
    //   17: iload 4
    //   19: iload_2
    //   20: if_icmpge +973 -> 993
    //   23: iconst_m1
    //   24: istore 5
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 113	twitter4j/internal/http/HttpRequest:getURL	()Ljava/lang/String;
    //   31: invokevirtual 296	twitter4j/internal/http/HttpClientImpl:getConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   34: astore 16
    //   36: aload 16
    //   38: iconst_1
    //   39: invokevirtual 299	java/net/HttpURLConnection:setDoInput	(Z)V
    //   42: aload_0
    //   43: aload_1
    //   44: aload 16
    //   46: invokespecial 301	twitter4j/internal/http/HttpClientImpl:setHeaders	(Ltwitter4j/internal/http/HttpRequest;Ljava/net/HttpURLConnection;)V
    //   49: aload 16
    //   51: aload_1
    //   52: invokevirtual 95	twitter4j/internal/http/HttpRequest:getMethod	()Ltwitter4j/internal/http/RequestMethod;
    //   55: invokevirtual 101	twitter4j/internal/http/RequestMethod:name	()Ljava/lang/String;
    //   58: invokevirtual 304	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: invokevirtual 95	twitter4j/internal/http/HttpRequest:getMethod	()Ltwitter4j/internal/http/RequestMethod;
    //   65: getstatic 287	twitter4j/internal/http/RequestMethod:POST	Ltwitter4j/internal/http/RequestMethod;
    //   68: if_acmpne +1084 -> 1152
    //   71: aload_1
    //   72: invokevirtual 308	twitter4j/internal/http/HttpRequest:getParameters	()[Ltwitter4j/internal/http/HttpParameter;
    //   75: invokestatic 314	twitter4j/internal/http/HttpParameter:containsFile	([Ltwitter4j/internal/http/HttpParameter;)Z
    //   78: ifeq +761 -> 839
    //   81: new 87	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 316
    //   91: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokestatic 320	java/lang/System:currentTimeMillis	()J
    //   97: invokevirtual 323	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 32
    //   105: aload 16
    //   107: ldc_w 325
    //   110: new 87	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 327
    //   120: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 32
    //   125: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokevirtual 330	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: new 87	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 332
    //   144: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 32
    //   149: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore 33
    //   157: aload 16
    //   159: iconst_1
    //   160: invokevirtual 335	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   163: aload 16
    //   165: invokevirtual 339	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   168: astore 34
    //   170: aload 34
    //   172: astore 30
    //   174: new 341	java/io/DataOutputStream
    //   177: dup
    //   178: aload 30
    //   180: invokespecial 344	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   183: astore 35
    //   185: aload_1
    //   186: invokevirtual 308	twitter4j/internal/http/HttpRequest:getParameters	()[Ltwitter4j/internal/http/HttpParameter;
    //   189: astore 36
    //   191: aload 36
    //   193: arraylength
    //   194: istore 37
    //   196: iconst_0
    //   197: istore 38
    //   199: iload 38
    //   201: iload 37
    //   203: if_icmpge +406 -> 609
    //   206: aload 36
    //   208: iload 38
    //   210: aaload
    //   211: astore 39
    //   213: aload 39
    //   215: invokevirtual 347	twitter4j/internal/http/HttpParameter:isFile	()Z
    //   218: ifeq +280 -> 498
    //   221: aload_0
    //   222: aload 35
    //   224: new 87	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   231: aload 33
    //   233: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 349
    //   239: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   248: aload_0
    //   249: aload 35
    //   251: new 87	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 355
    //   261: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 39
    //   266: invokevirtual 358	twitter4j/internal/http/HttpParameter:getName	()Ljava/lang/String;
    //   269: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 360
    //   275: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 39
    //   280: invokevirtual 364	twitter4j/internal/http/HttpParameter:getFile	()Ljava/io/File;
    //   283: invokevirtual 367	java/io/File:getName	()Ljava/lang/String;
    //   286: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 369
    //   292: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   301: aload_0
    //   302: aload 35
    //   304: new 87	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 371
    //   314: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload 39
    //   319: invokevirtual 374	twitter4j/internal/http/HttpParameter:getContentType	()Ljava/lang/String;
    //   322: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 376
    //   328: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   337: aload 39
    //   339: invokevirtual 379	twitter4j/internal/http/HttpParameter:hasFileBody	()Z
    //   342: ifeq +122 -> 464
    //   345: aload 39
    //   347: invokevirtual 383	twitter4j/internal/http/HttpParameter:getFileBody	()Ljava/io/InputStream;
    //   350: astore 40
    //   352: new 385	java/io/BufferedInputStream
    //   355: dup
    //   356: aload 40
    //   358: invokespecial 388	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   361: astore 41
    //   363: sipush 1024
    //   366: newarray byte
    //   368: astore 42
    //   370: aload 41
    //   372: aload 42
    //   374: invokevirtual 392	java/io/BufferedInputStream:read	([B)I
    //   377: istore 43
    //   379: iload 43
    //   381: iconst_m1
    //   382: if_icmpeq +99 -> 481
    //   385: aload 35
    //   387: aload 42
    //   389: iconst_0
    //   390: iload 43
    //   392: invokevirtual 395	java/io/DataOutputStream:write	([BII)V
    //   395: goto -25 -> 370
    //   398: astore 31
    //   400: aload_3
    //   401: astore 7
    //   403: aload 31
    //   405: astore 8
    //   407: aload 30
    //   409: astore 10
    //   411: iload 5
    //   413: istore 9
    //   415: aload 10
    //   417: invokevirtual 400	java/io/OutputStream:close	()V
    //   420: aload 8
    //   422: athrow
    //   423: astore 12
    //   425: iload 9
    //   427: istore 5
    //   429: aload 7
    //   431: astore 13
    //   433: iload 4
    //   435: aload_0
    //   436: getfield 193	twitter4j/internal/http/HttpClientImpl:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   439: invokeinterface 294 1 0
    //   444: if_icmpne +714 -> 1158
    //   447: new 171	twitter4j/TwitterException
    //   450: dup
    //   451: aload 12
    //   453: invokevirtual 403	java/io/IOException:getMessage	()Ljava/lang/String;
    //   456: aload 12
    //   458: iload 5
    //   460: invokespecial 406	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Exception;I)V
    //   463: athrow
    //   464: new 408	java/io/FileInputStream
    //   467: dup
    //   468: aload 39
    //   470: invokevirtual 364	twitter4j/internal/http/HttpParameter:getFile	()Ljava/io/File;
    //   473: invokespecial 411	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   476: astore 40
    //   478: goto -126 -> 352
    //   481: aload_0
    //   482: aload 35
    //   484: ldc_w 349
    //   487: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   490: aload 41
    //   492: invokevirtual 412	java/io/BufferedInputStream:close	()V
    //   495: goto +669 -> 1164
    //   498: aload_0
    //   499: aload 35
    //   501: new 87	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   508: aload 33
    //   510: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: ldc_w 349
    //   516: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   525: aload_0
    //   526: aload 35
    //   528: new 87	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 355
    //   538: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload 39
    //   543: invokevirtual 358	twitter4j/internal/http/HttpParameter:getName	()Ljava/lang/String;
    //   546: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 369
    //   552: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   561: aload_0
    //   562: aload 35
    //   564: ldc_w 414
    //   567: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   570: getstatic 27	twitter4j/internal/http/HttpClientImpl:logger	Ltwitter4j/internal/logging/Logger;
    //   573: aload 39
    //   575: invokevirtual 417	twitter4j/internal/http/HttpParameter:getValue	()Ljava/lang/String;
    //   578: invokevirtual 85	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   581: aload 35
    //   583: aload 39
    //   585: invokevirtual 417	twitter4j/internal/http/HttpParameter:getValue	()Ljava/lang/String;
    //   588: ldc_w 419
    //   591: invokevirtual 423	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   594: invokevirtual 426	java/io/DataOutputStream:write	([B)V
    //   597: aload_0
    //   598: aload 35
    //   600: ldc_w 349
    //   603: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   606: goto +558 -> 1164
    //   609: aload_0
    //   610: aload 35
    //   612: new 87	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   619: aload 33
    //   621: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: ldc_w 428
    //   627: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   636: aload_0
    //   637: aload 35
    //   639: ldc_w 349
    //   642: invokevirtual 353	twitter4j/internal/http/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   645: aload 30
    //   647: invokevirtual 431	java/io/OutputStream:flush	()V
    //   650: aload 30
    //   652: invokevirtual 400	java/io/OutputStream:close	()V
    //   655: aload 30
    //   657: astore 17
    //   659: new 433	twitter4j/internal/http/HttpResponseImpl
    //   662: dup
    //   663: aload 16
    //   665: aload_0
    //   666: getfield 193	twitter4j/internal/http/HttpClientImpl:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   669: invokespecial 436	twitter4j/internal/http/HttpResponseImpl:<init>	(Ljava/net/HttpURLConnection;Ltwitter4j/internal/http/HttpClientConfiguration;)V
    //   672: astore 13
    //   674: aload 16
    //   676: invokevirtual 439	java/net/HttpURLConnection:getResponseCode	()I
    //   679: istore 5
    //   681: getstatic 27	twitter4j/internal/http/HttpClientImpl:logger	Ltwitter4j/internal/logging/Logger;
    //   684: invokevirtual 79	twitter4j/internal/logging/Logger:isDebugEnabled	()Z
    //   687: ifeq +483 -> 1170
    //   690: getstatic 27	twitter4j/internal/http/HttpClientImpl:logger	Ltwitter4j/internal/logging/Logger;
    //   693: ldc_w 441
    //   696: invokevirtual 85	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   699: aload 16
    //   701: invokevirtual 444	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   704: astore 20
    //   706: aload 20
    //   708: invokeinterface 149 1 0
    //   713: invokeinterface 155 1 0
    //   718: astore 21
    //   720: aload 21
    //   722: invokeinterface 160 1 0
    //   727: ifeq +443 -> 1170
    //   730: aload 21
    //   732: invokeinterface 164 1 0
    //   737: checkcast 166	java/lang/String
    //   740: astore 22
    //   742: aload 20
    //   744: aload 22
    //   746: invokeinterface 67 2 0
    //   751: checkcast 446	java/util/List
    //   754: invokeinterface 447 1 0
    //   759: astore 23
    //   761: aload 23
    //   763: invokeinterface 160 1 0
    //   768: ifeq -48 -> 720
    //   771: aload 23
    //   773: invokeinterface 164 1 0
    //   778: checkcast 166	java/lang/String
    //   781: astore 24
    //   783: aload 22
    //   785: ifnull +136 -> 921
    //   788: getstatic 27	twitter4j/internal/http/HttpClientImpl:logger	Ltwitter4j/internal/logging/Logger;
    //   791: new 87	java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   798: aload 22
    //   800: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc 168
    //   805: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload 24
    //   810: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: invokevirtual 85	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   819: goto -58 -> 761
    //   822: astore 8
    //   824: aload 17
    //   826: astore 10
    //   828: aload 13
    //   830: astore 7
    //   832: iload 5
    //   834: istore 9
    //   836: goto -421 -> 415
    //   839: aload 16
    //   841: ldc_w 325
    //   844: ldc_w 449
    //   847: invokevirtual 330	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   850: aload_1
    //   851: invokevirtual 308	twitter4j/internal/http/HttpRequest:getParameters	()[Ltwitter4j/internal/http/HttpParameter;
    //   854: invokestatic 453	twitter4j/internal/http/HttpParameter:encodeParameters	([Ltwitter4j/internal/http/HttpParameter;)Ljava/lang/String;
    //   857: astore 27
    //   859: getstatic 27	twitter4j/internal/http/HttpClientImpl:logger	Ltwitter4j/internal/logging/Logger;
    //   862: ldc_w 455
    //   865: aload 27
    //   867: invokevirtual 116	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: aload 27
    //   872: ldc_w 419
    //   875: invokevirtual 423	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   878: astore 28
    //   880: aload 16
    //   882: ldc_w 457
    //   885: aload 28
    //   887: arraylength
    //   888: invokestatic 462	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   891: invokevirtual 330	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   894: aload 16
    //   896: iconst_1
    //   897: invokevirtual 335	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   900: aload 16
    //   902: invokevirtual 339	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   905: astore 29
    //   907: aload 29
    //   909: astore 30
    //   911: aload 30
    //   913: aload 28
    //   915: invokevirtual 463	java/io/OutputStream:write	([B)V
    //   918: goto -273 -> 645
    //   921: getstatic 27	twitter4j/internal/http/HttpClientImpl:logger	Ltwitter4j/internal/logging/Logger;
    //   924: aload 24
    //   926: invokevirtual 85	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   929: goto -168 -> 761
    //   932: iload 5
    //   934: sipush 420
    //   937: if_icmpeq +33 -> 970
    //   940: iload 5
    //   942: sipush 400
    //   945: if_icmpeq +25 -> 970
    //   948: iload 5
    //   950: sipush 500
    //   953: if_icmplt +17 -> 970
    //   956: iload 4
    //   958: aload_0
    //   959: getfield 193	twitter4j/internal/http/HttpClientImpl:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   962: invokeinterface 294 1 0
    //   967: if_icmpne +28 -> 995
    //   970: new 171	twitter4j/TwitterException
    //   973: dup
    //   974: aload 13
    //   976: invokevirtual 468	twitter4j/internal/http/HttpResponse:asString	()Ljava/lang/String;
    //   979: aload 13
    //   981: invokespecial 471	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ltwitter4j/internal/http/HttpResponse;)V
    //   984: athrow
    //   985: aload 17
    //   987: invokevirtual 400	java/io/OutputStream:close	()V
    //   990: aload 13
    //   992: astore_3
    //   993: aload_3
    //   994: areturn
    //   995: aload 17
    //   997: invokevirtual 400	java/io/OutputStream:close	()V
    //   1000: aload 13
    //   1002: astore_3
    //   1003: getstatic 27	twitter4j/internal/http/HttpClientImpl:logger	Ltwitter4j/internal/logging/Logger;
    //   1006: invokevirtual 79	twitter4j/internal/logging/Logger:isDebugEnabled	()Z
    //   1009: ifeq +12 -> 1021
    //   1012: aload_3
    //   1013: ifnull +8 -> 1021
    //   1016: aload_3
    //   1017: invokevirtual 468	twitter4j/internal/http/HttpResponse:asString	()Ljava/lang/String;
    //   1020: pop
    //   1021: getstatic 27	twitter4j/internal/http/HttpClientImpl:logger	Ltwitter4j/internal/logging/Logger;
    //   1024: new 87	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1031: ldc_w 473
    //   1034: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_0
    //   1038: getfield 193	twitter4j/internal/http/HttpClientImpl:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   1041: invokeinterface 476 1 0
    //   1046: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1049: ldc_w 478
    //   1052: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokevirtual 85	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   1061: sipush 1000
    //   1064: aload_0
    //   1065: getfield 193	twitter4j/internal/http/HttpClientImpl:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   1068: invokeinterface 476 1 0
    //   1073: imul
    //   1074: i2l
    //   1075: invokestatic 484	java/lang/Thread:sleep	(J)V
    //   1078: iinc 4 1
    //   1081: goto -1064 -> 17
    //   1084: astore 19
    //   1086: goto -96 -> 990
    //   1089: astore 18
    //   1091: goto -91 -> 1000
    //   1094: astore 11
    //   1096: goto -676 -> 420
    //   1099: astore 14
    //   1101: goto -23 -> 1078
    //   1104: astore 12
    //   1106: goto -673 -> 433
    //   1109: astore 6
    //   1111: aload_3
    //   1112: astore 7
    //   1114: aload 6
    //   1116: astore 8
    //   1118: iload 5
    //   1120: istore 9
    //   1122: aconst_null
    //   1123: astore 10
    //   1125: goto -710 -> 415
    //   1128: astore 25
    //   1130: iload 5
    //   1132: istore 9
    //   1134: aload 17
    //   1136: astore 26
    //   1138: aload_3
    //   1139: astore 7
    //   1141: aload 25
    //   1143: astore 8
    //   1145: aload 26
    //   1147: astore 10
    //   1149: goto -734 -> 415
    //   1152: aconst_null
    //   1153: astore 17
    //   1155: goto -496 -> 659
    //   1158: aload 13
    //   1160: astore_3
    //   1161: goto -158 -> 1003
    //   1164: iinc 38 1
    //   1167: goto -968 -> 199
    //   1170: iload 5
    //   1172: sipush 200
    //   1175: if_icmplt -243 -> 932
    //   1178: iload 5
    //   1180: sipush 302
    //   1183: if_icmpeq -198 -> 985
    //   1186: sipush 300
    //   1189: iload 5
    //   1191: if_icmpgt -206 -> 985
    //   1194: goto -262 -> 932
    //
    // Exception table:
    //   from	to	target	type
    //   174	196	398	finally
    //   206	352	398	finally
    //   352	370	398	finally
    //   370	379	398	finally
    //   385	395	398	finally
    //   464	478	398	finally
    //   481	495	398	finally
    //   498	606	398	finally
    //   609	645	398	finally
    //   645	655	398	finally
    //   911	918	398	finally
    //   415	420	423	java/io/IOException
    //   420	423	423	java/io/IOException
    //   674	720	822	finally
    //   720	761	822	finally
    //   761	783	822	finally
    //   788	819	822	finally
    //   921	929	822	finally
    //   956	970	822	finally
    //   970	985	822	finally
    //   985	990	1084	java/lang/Exception
    //   995	1000	1089	java/lang/Exception
    //   415	420	1094	java/lang/Exception
    //   1003	1012	1099	java/lang/InterruptedException
    //   1016	1021	1099	java/lang/InterruptedException
    //   1021	1078	1099	java/lang/InterruptedException
    //   985	990	1104	java/io/IOException
    //   995	1000	1104	java/io/IOException
    //   26	170	1109	finally
    //   839	907	1109	finally
    //   659	674	1128	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.HttpClientImpl
 * JD-Core Version:    0.6.2
 */