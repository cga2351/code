package com.viber.libnativehttp;

import com.viber.common.a.e;
import com.viber.common.a.f;
import f.c;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttp3HttpDelegate extends DefaultHttpDelegate
{
  OkHttpClient.Builder client = createOkHttpClient().newBuilder();
  boolean headWasReported = false;

  private Http.Response convertResponse(Response paramResponse)
  {
    Http.RequestHeader[] arrayOfRequestHeader = getHeaders(paramResponse.headers().toMultimap());
    long l1 = 0L;
    Object localObject = "";
    boolean bool = paramResponse.isRedirect();
    String str1 = null;
    if (bool)
      str1 = paramResponse.header("location");
    if (paramResponse.body() != null);
    while (true)
    {
      try
      {
        l1 = paramResponse.body().contentLength();
        String str2 = paramResponse.body().contentType().toString();
        localObject = str2;
        l2 = l1;
        return new Http.Response(str1, paramResponse.code(), (int)l2, (String)localObject, arrayOfRequestHeader);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      long l2 = l1;
    }
  }

  protected OkHttpClient createOkHttpClient()
  {
    return new OkHttpClient.Builder().build();
  }

  // ERROR //
  public void executeRequest(String paramString, Http.Request paramRequest, Http.Downloader paramDownloader, Http paramHttp)
  {
    // Byte code:
    //   0: new 104	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   7: ldc 107
    //   9: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: getstatic 115	com/viber/libnativehttp/OkHttp3HttpDelegate:requestId	Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: invokevirtual 120	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   18: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: ldc 125
    //   23: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 132	com/viber/common/a/f:a	(Ljava/lang/String;)Lcom/viber/common/a/e;
    //   32: astore 5
    //   34: aload_0
    //   35: getfield 26	com/viber/libnativehttp/OkHttp3HttpDelegate:client	Lokhttp3/OkHttpClient$Builder;
    //   38: aload_2
    //   39: getfield 138	com/viber/libnativehttp/Http$Request:timeout	I
    //   42: i2l
    //   43: getstatic 144	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   46: invokevirtual 148	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   49: pop
    //   50: aload_0
    //   51: getfield 26	com/viber/libnativehttp/OkHttp3HttpDelegate:client	Lokhttp3/OkHttpClient$Builder;
    //   54: aload_2
    //   55: getfield 138	com/viber/libnativehttp/Http$Request:timeout	I
    //   58: i2l
    //   59: getstatic 144	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   62: invokevirtual 151	okhttp3/OkHttpClient$Builder:readTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   65: pop
    //   66: aload_0
    //   67: getfield 26	com/viber/libnativehttp/OkHttp3HttpDelegate:client	Lokhttp3/OkHttpClient$Builder;
    //   70: aload_2
    //   71: getfield 138	com/viber/libnativehttp/Http$Request:timeout	I
    //   74: i2l
    //   75: getstatic 144	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   78: invokevirtual 154	okhttp3/OkHttpClient$Builder:writeTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   81: pop
    //   82: aload_0
    //   83: getfield 26	com/viber/libnativehttp/OkHttp3HttpDelegate:client	Lokhttp3/OkHttpClient$Builder;
    //   86: iconst_1
    //   87: invokevirtual 158	okhttp3/OkHttpClient$Builder:followRedirects	(Z)Lokhttp3/OkHttpClient$Builder;
    //   90: pop
    //   91: aload_0
    //   92: getfield 26	com/viber/libnativehttp/OkHttp3HttpDelegate:client	Lokhttp3/OkHttpClient$Builder;
    //   95: invokestatic 164	com/viber/libnativehttp/TlsUtils:enableTls12OnPreLollipop	(Lokhttp3/OkHttpClient$Builder;)Lokhttp3/OkHttpClient$Builder;
    //   98: pop
    //   99: new 166	okhttp3/Request$Builder
    //   102: dup
    //   103: invokespecial 167	okhttp3/Request$Builder:<init>	()V
    //   106: aload_2
    //   107: getfield 171	com/viber/libnativehttp/Http$Request:url	Ljava/lang/String;
    //   110: invokevirtual 174	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   113: astore 11
    //   115: aload_2
    //   116: getfield 177	com/viber/libnativehttp/Http$Request:headers	[Lcom/viber/libnativehttp/Http$RequestHeader;
    //   119: ifnull +88 -> 207
    //   122: aload_2
    //   123: getfield 177	com/viber/libnativehttp/Http$Request:headers	[Lcom/viber/libnativehttp/Http$RequestHeader;
    //   126: astore 45
    //   128: aload 45
    //   130: arraylength
    //   131: istore 46
    //   133: iconst_0
    //   134: istore 47
    //   136: iload 47
    //   138: iload 46
    //   140: if_icmpge +67 -> 207
    //   143: aload 45
    //   145: iload 47
    //   147: aaload
    //   148: astore 48
    //   150: iconst_2
    //   151: anewarray 179	java/lang/Object
    //   154: astore 49
    //   156: aload 49
    //   158: iconst_0
    //   159: aload 48
    //   161: getfield 184	com/viber/libnativehttp/Http$RequestHeader:headerName	Ljava/lang/String;
    //   164: aastore
    //   165: aload 49
    //   167: iconst_1
    //   168: aload 48
    //   170: getfield 187	com/viber/libnativehttp/Http$RequestHeader:headerValue	Ljava/lang/String;
    //   173: aastore
    //   174: aload 5
    //   176: ldc 189
    //   178: aload 49
    //   180: invokeinterface 195 3 0
    //   185: aload 11
    //   187: aload 48
    //   189: getfield 184	com/viber/libnativehttp/Http$RequestHeader:headerName	Ljava/lang/String;
    //   192: aload 48
    //   194: getfield 187	com/viber/libnativehttp/Http$RequestHeader:headerValue	Ljava/lang/String;
    //   197: invokevirtual 199	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   200: pop
    //   201: iinc 47 1
    //   204: goto -68 -> 136
    //   207: aload 11
    //   209: ldc 201
    //   211: ldc 203
    //   213: invokevirtual 199	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   216: pop
    //   217: aload_2
    //   218: getfield 207	com/viber/libnativehttp/Http$Request:postData	[B
    //   221: astore 13
    //   223: aconst_null
    //   224: astore 14
    //   226: aload 13
    //   228: ifnull +17 -> 245
    //   231: ldc 209
    //   233: invokestatic 213	okhttp3/MediaType:parse	(Ljava/lang/String;)Lokhttp3/MediaType;
    //   236: aload_2
    //   237: getfield 207	com/viber/libnativehttp/Http$Request:postData	[B
    //   240: invokestatic 219	okhttp3/RequestBody:create	(Lokhttp3/MediaType;[B)Lokhttp3/RequestBody;
    //   243: astore 14
    //   245: aload 14
    //   247: ifnull +11 -> 258
    //   250: aload 11
    //   252: aload 14
    //   254: invokevirtual 223	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   257: pop
    //   258: aconst_null
    //   259: astore 15
    //   261: aconst_null
    //   262: astore 16
    //   264: aload_0
    //   265: getfield 26	com/viber/libnativehttp/OkHttp3HttpDelegate:client	Lokhttp3/OkHttpClient$Builder;
    //   268: invokevirtual 96	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   271: aload 11
    //   273: invokevirtual 226	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   276: invokevirtual 230	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   279: invokeinterface 236 1 0
    //   284: astore 24
    //   286: aload 5
    //   288: ldc 238
    //   290: iconst_1
    //   291: anewarray 179	java/lang/Object
    //   294: dup
    //   295: iconst_0
    //   296: aload 24
    //   298: aastore
    //   299: invokeinterface 195 3 0
    //   304: aload_0
    //   305: aload 24
    //   307: invokespecial 240	com/viber/libnativehttp/OkHttp3HttpDelegate:convertResponse	(Lokhttp3/Response;)Lcom/viber/libnativehttp/Http$Response;
    //   310: astore 25
    //   312: aload_3
    //   313: ifnull +18 -> 331
    //   316: aload_3
    //   317: aload 4
    //   319: aload 25
    //   321: invokeinterface 246 3 0
    //   326: aload_0
    //   327: iconst_1
    //   328: putfield 14	com/viber/libnativehttp/OkHttp3HttpDelegate:headWasReported	Z
    //   331: aload 24
    //   333: invokevirtual 249	okhttp3/Response:isSuccessful	()Z
    //   336: ifne +51 -> 387
    //   339: aload_3
    //   340: aload 4
    //   342: aconst_null
    //   343: iconst_0
    //   344: iconst_0
    //   345: iconst_1
    //   346: invokeinterface 253 6 0
    //   351: pop
    //   352: iconst_0
    //   353: ifeq +7 -> 360
    //   356: aconst_null
    //   357: invokevirtual 258	java/io/InputStream:close	()V
    //   360: iconst_0
    //   361: ifeq +7 -> 368
    //   364: aconst_null
    //   365: invokevirtual 261	java/io/BufferedInputStream:close	()V
    //   368: return
    //   369: astore 43
    //   371: aload 43
    //   373: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   376: goto -16 -> 360
    //   379: astore 42
    //   381: aload 42
    //   383: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   386: return
    //   387: aload 5
    //   389: ldc_w 264
    //   392: iconst_0
    //   393: anewarray 179	java/lang/Object
    //   396: invokeinterface 195 3 0
    //   401: aload_2
    //   402: getfield 267	com/viber/libnativehttp/Http$Request:chunkSize	I
    //   405: istore 26
    //   407: iload 26
    //   409: ifgt +320 -> 729
    //   412: sipush 1024
    //   415: istore 27
    //   417: aload 24
    //   419: invokevirtual 62	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   422: invokevirtual 271	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   425: astore 28
    //   427: new 260	java/io/BufferedInputStream
    //   430: dup
    //   431: aload 28
    //   433: invokespecial 274	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   436: astore 29
    //   438: iload 27
    //   440: newarray byte
    //   442: astore 31
    //   444: lconst_0
    //   445: lstore 32
    //   447: aload 29
    //   449: aload 31
    //   451: iconst_0
    //   452: iload 27
    //   454: invokevirtual 278	java/io/BufferedInputStream:read	([BII)I
    //   457: istore 34
    //   459: iload 34
    //   461: iconst_m1
    //   462: if_icmpeq +28 -> 490
    //   465: lload 32
    //   467: iload 34
    //   469: i2l
    //   470: ladd
    //   471: lstore 38
    //   473: aload_3
    //   474: aload 4
    //   476: aload 31
    //   478: iconst_0
    //   479: iload 34
    //   481: iconst_0
    //   482: invokeinterface 253 6 0
    //   487: ifne +45 -> 532
    //   490: aload_3
    //   491: aload 4
    //   493: aconst_null
    //   494: iconst_0
    //   495: iconst_0
    //   496: iconst_1
    //   497: invokeinterface 253 6 0
    //   502: pop
    //   503: aload 28
    //   505: ifnull +8 -> 513
    //   508: aload 28
    //   510: invokevirtual 258	java/io/InputStream:close	()V
    //   513: aload 29
    //   515: ifnull -147 -> 368
    //   518: aload 29
    //   520: invokevirtual 261	java/io/BufferedInputStream:close	()V
    //   523: return
    //   524: astore 36
    //   526: aload 36
    //   528: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   531: return
    //   532: lload 38
    //   534: lstore 32
    //   536: goto -89 -> 447
    //   539: astore 37
    //   541: aload 37
    //   543: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   546: goto -33 -> 513
    //   549: astore 20
    //   551: aload_0
    //   552: getfield 14	com/viber/libnativehttp/OkHttp3HttpDelegate:headWasReported	Z
    //   555: ifne +27 -> 582
    //   558: aload_3
    //   559: aload 4
    //   561: new 80	com/viber/libnativehttp/Http$Response
    //   564: dup
    //   565: ldc 48
    //   567: sipush 408
    //   570: iconst_0
    //   571: ldc 48
    //   573: aconst_null
    //   574: invokespecial 87	com/viber/libnativehttp/Http$Response:<init>	(Ljava/lang/String;IILjava/lang/String;[Lcom/viber/libnativehttp/Http$RequestHeader;)V
    //   577: invokeinterface 246 3 0
    //   582: aload_3
    //   583: aload 4
    //   585: aconst_null
    //   586: iconst_0
    //   587: iconst_0
    //   588: iconst_1
    //   589: invokeinterface 253 6 0
    //   594: pop
    //   595: aload 15
    //   597: ifnull +8 -> 605
    //   600: aload 15
    //   602: invokevirtual 258	java/io/InputStream:close	()V
    //   605: aload 16
    //   607: ifnull -239 -> 368
    //   610: aload 16
    //   612: invokevirtual 261	java/io/BufferedInputStream:close	()V
    //   615: return
    //   616: astore 22
    //   618: aload 22
    //   620: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   623: return
    //   624: astore 23
    //   626: aload 23
    //   628: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   631: goto -26 -> 605
    //   634: astore 17
    //   636: aload 15
    //   638: ifnull +8 -> 646
    //   641: aload 15
    //   643: invokevirtual 258	java/io/InputStream:close	()V
    //   646: aload 16
    //   648: ifnull +8 -> 656
    //   651: aload 16
    //   653: invokevirtual 261	java/io/BufferedInputStream:close	()V
    //   656: aload 17
    //   658: athrow
    //   659: astore 19
    //   661: aload 19
    //   663: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   666: goto -20 -> 646
    //   669: astore 18
    //   671: aload 18
    //   673: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   676: goto -20 -> 656
    //   679: astore 17
    //   681: aload 28
    //   683: astore 15
    //   685: aconst_null
    //   686: astore 16
    //   688: goto -52 -> 636
    //   691: astore 17
    //   693: aload 29
    //   695: astore 16
    //   697: aload 28
    //   699: astore 15
    //   701: goto -65 -> 636
    //   704: astore 40
    //   706: aload 28
    //   708: astore 15
    //   710: aconst_null
    //   711: astore 16
    //   713: goto -162 -> 551
    //   716: astore 30
    //   718: aload 29
    //   720: astore 16
    //   722: aload 28
    //   724: astore 15
    //   726: goto -175 -> 551
    //   729: iload 26
    //   731: istore 27
    //   733: goto -316 -> 417
    //
    // Exception table:
    //   from	to	target	type
    //   356	360	369	java/io/IOException
    //   364	368	379	java/io/IOException
    //   518	523	524	java/io/IOException
    //   508	513	539	java/io/IOException
    //   264	312	549	java/lang/Throwable
    //   316	331	549	java/lang/Throwable
    //   331	352	549	java/lang/Throwable
    //   387	407	549	java/lang/Throwable
    //   417	427	549	java/lang/Throwable
    //   610	615	616	java/io/IOException
    //   600	605	624	java/io/IOException
    //   264	312	634	finally
    //   316	331	634	finally
    //   331	352	634	finally
    //   387	407	634	finally
    //   417	427	634	finally
    //   551	582	634	finally
    //   582	595	634	finally
    //   641	646	659	java/io/IOException
    //   651	656	669	java/io/IOException
    //   427	438	679	finally
    //   438	444	691	finally
    //   447	459	691	finally
    //   473	490	691	finally
    //   490	503	691	finally
    //   427	438	704	java/lang/Throwable
    //   438	444	716	java/lang/Throwable
    //   447	459	716	java/lang/Throwable
    //   473	490	716	java/lang/Throwable
    //   490	503	716	java/lang/Throwable
  }

  public class LoggingInterceptor
    implements Interceptor
  {
    private static final String F_BODY = "body: %s";
    private static final String F_BREAK = " %n";
    private static final String F_BREAKER = " %n------------------------------------------- %n";
    private static final String F_HEADERS = "%s";
    private static final String F_REQUEST_WITHOUT_BODY = " %s in %.1fms %n%s";
    private static final String F_REQUEST_WITH_BODY = " %s in %.1fms %n%sbody: %s %n";
    private static final String F_RESPONSE = " %nResponse: %d";
    private static final String F_RESPONSE_WITHOUT_BODY = " %nResponse: %d %n%s %n------------------------------------------- %n";
    private static final String F_RESPONSE_WITH_BODY = " %nResponse: %d %n%sbody: %s %n %n------------------------------------------- %n";
    private static final String F_TIME = " in %.1fms";
    private static final String F_URL = " %s";

    public LoggingInterceptor()
    {
    }

    private String stringifyRequestBody(Request paramRequest)
    {
      try
      {
        Request localRequest = paramRequest.newBuilder().build();
        c localc = new c();
        localRequest.body().writeTo(localc);
        String str = localc.r();
        return str;
      }
      catch (IOException localIOException)
      {
      }
      return "did not work";
    }

    public Response intercept(Interceptor.Chain paramChain)
      throws IOException
    {
      e locale = f.a("NativeHttp - interceptor");
      Request localRequest = paramChain.request();
      long l = System.nanoTime();
      Response localResponse = paramChain.proceed(localRequest);
      double d = (System.nanoTime() - l) / 1000000.0D;
      if (localRequest.method().equals("GET"))
      {
        Object[] arrayOfObject4 = new Object[6];
        arrayOfObject4[0] = localRequest.url();
        arrayOfObject4[1] = Double.valueOf(d);
        arrayOfObject4[2] = localRequest.headers();
        arrayOfObject4[3] = Integer.valueOf(localResponse.code());
        arrayOfObject4[4] = localResponse.headers();
        arrayOfObject4[5] = stringifyResponseBody(localResponse);
        locale.b(String.format("GET  %s in %.1fms %n%s %nResponse: %d %n%sbody: %s %n %n------------------------------------------- %n", arrayOfObject4), new Object[0]);
      }
      do
      {
        return localResponse;
        if (localRequest.method().equals("POST"))
        {
          Object[] arrayOfObject3 = new Object[7];
          arrayOfObject3[0] = localRequest.url();
          arrayOfObject3[1] = Double.valueOf(d);
          arrayOfObject3[2] = localRequest.headers();
          arrayOfObject3[3] = stringifyRequestBody(localRequest);
          arrayOfObject3[4] = Integer.valueOf(localResponse.code());
          arrayOfObject3[5] = localResponse.headers();
          arrayOfObject3[6] = stringifyResponseBody(localResponse);
          locale.b(String.format("POST  %s in %.1fms %n%sbody: %s %n %nResponse: %d %n%sbody: %s %n %n------------------------------------------- %n", arrayOfObject3), new Object[0]);
          return localResponse;
        }
        if (localRequest.method().equals("PUT"))
        {
          Object[] arrayOfObject2 = new Object[7];
          arrayOfObject2[0] = localRequest.url();
          arrayOfObject2[1] = Double.valueOf(d);
          arrayOfObject2[2] = localRequest.headers();
          arrayOfObject2[3] = localRequest.body().toString();
          arrayOfObject2[4] = Integer.valueOf(localResponse.code());
          arrayOfObject2[5] = localResponse.headers();
          arrayOfObject2[6] = stringifyResponseBody(localResponse);
          locale.b(String.format("PUT  %s in %.1fms %n%sbody: %s %n %nResponse: %d %n%sbody: %s %n %n------------------------------------------- %n", arrayOfObject2), new Object[0]);
          return localResponse;
        }
      }
      while (!localRequest.method().equals("DELETE"));
      Object[] arrayOfObject1 = new Object[5];
      arrayOfObject1[0] = localRequest.url();
      arrayOfObject1[1] = Double.valueOf(d);
      arrayOfObject1[2] = localRequest.headers();
      arrayOfObject1[3] = Integer.valueOf(localResponse.code());
      arrayOfObject1[4] = localResponse.headers();
      locale.b(String.format("DELETE  %s in %.1fms %n%s %nResponse: %d %n%s %n------------------------------------------- %n", arrayOfObject1), new Object[0]);
      return localResponse;
    }

    public String stringifyResponseBody(Response paramResponse)
    {
      ResponseBody localResponseBody = paramResponse.body();
      Object localObject = null;
      if (localResponseBody != null)
        paramResponse.body().contentType();
      try
      {
        String str = paramResponse.body().toString();
        localObject = str;
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.OkHttp3HttpDelegate
 * JD-Core Version:    0.6.2
 */