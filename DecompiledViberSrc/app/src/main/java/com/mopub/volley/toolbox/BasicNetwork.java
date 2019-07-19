package com.mopub.volley.toolbox;

import com.mopub.volley.Cache.Entry;
import com.mopub.volley.Header;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.ServerError;
import com.mopub.volley.VolleyError;
import com.mopub.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class BasicNetwork
  implements Network
{
  protected static final boolean a = VolleyLog.DEBUG;
  protected final ByteArrayPool b;
  private final BaseHttpStack c;

  public BasicNetwork(BaseHttpStack paramBaseHttpStack)
  {
    this(paramBaseHttpStack, new ByteArrayPool(4096));
  }

  public BasicNetwork(BaseHttpStack paramBaseHttpStack, ByteArrayPool paramByteArrayPool)
  {
    this.c = paramBaseHttpStack;
    this.b = paramByteArrayPool;
  }

  private static List<Header> a(List<Header> paramList, Cache.Entry paramEntry)
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    if (!paramList.isEmpty())
    {
      Iterator localIterator3 = paramList.iterator();
      while (localIterator3.hasNext())
        localTreeSet.add(((Header)localIterator3.next()).getName());
    }
    ArrayList localArrayList = new ArrayList(paramList);
    if (paramEntry.allResponseHeaders != null)
    {
      if (!paramEntry.allResponseHeaders.isEmpty())
      {
        Iterator localIterator2 = paramEntry.allResponseHeaders.iterator();
        while (localIterator2.hasNext())
        {
          Header localHeader = (Header)localIterator2.next();
          if (!localTreeSet.contains(localHeader.getName()))
            localArrayList.add(localHeader);
        }
      }
    }
    else if (!paramEntry.responseHeaders.isEmpty())
    {
      Iterator localIterator1 = paramEntry.responseHeaders.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        if (!localTreeSet.contains(localEntry.getKey()))
          localArrayList.add(new Header((String)localEntry.getKey(), (String)localEntry.getValue()));
      }
    }
    return localArrayList;
  }

  private Map<String, String> a(Cache.Entry paramEntry)
  {
    Object localObject;
    if (paramEntry == null)
      localObject = Collections.emptyMap();
    do
    {
      return localObject;
      localObject = new HashMap();
      if (paramEntry.etag != null)
        ((Map)localObject).put("If-None-Match", paramEntry.etag);
    }
    while (paramEntry.lastModified <= 0L);
    ((Map)localObject).put("If-Modified-Since", HttpHeaderParser.a(paramEntry.lastModified));
    return localObject;
  }

  private void a(long paramLong, Request<?> paramRequest, byte[] paramArrayOfByte, int paramInt)
  {
    Object[] arrayOfObject;
    if ((a) || (paramLong > 3000L))
    {
      arrayOfObject = new Object[5];
      arrayOfObject[0] = paramRequest;
      arrayOfObject[1] = Long.valueOf(paramLong);
      if (paramArrayOfByte == null)
        break label85;
    }
    label85: for (Object localObject = Integer.valueOf(paramArrayOfByte.length); ; localObject = "null")
    {
      arrayOfObject[2] = localObject;
      arrayOfObject[3] = Integer.valueOf(paramInt);
      arrayOfObject[4] = Integer.valueOf(paramRequest.getRetryPolicy().getCurrentRetryCount());
      VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", arrayOfObject);
      return;
    }
  }

  private static void a(String paramString, Request<?> paramRequest, VolleyError paramVolleyError)
    throws VolleyError
  {
    RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try
    {
      localRetryPolicy.retry(paramVolleyError);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(i);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", arrayOfObject2));
      return;
    }
    catch (VolleyError localVolleyError)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramString;
      arrayOfObject1[1] = Integer.valueOf(i);
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", arrayOfObject1));
      throw localVolleyError;
    }
  }

  private byte[] a(InputStream paramInputStream, int paramInt)
    throws IOException, ServerError
  {
    PoolingByteArrayOutputStream localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.b, paramInt);
    byte[] arrayOfByte1 = null;
    if (paramInputStream == null)
      try
      {
        throw new ServerError();
      }
      finally
      {
        if (paramInputStream == null);
      }
    try
    {
      paramInputStream.close();
      this.b.returnBuf(arrayOfByte1);
      localPoolingByteArrayOutputStream.close();
      throw localObject;
      arrayOfByte1 = this.b.getBuf(1024);
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte1);
        if (i == -1)
          break;
        localPoolingByteArrayOutputStream.write(arrayOfByte1, 0, i);
      }
      byte[] arrayOfByte2 = localPoolingByteArrayOutputStream.toByteArray();
      if (paramInputStream != null);
      try
      {
        paramInputStream.close();
        this.b.returnBuf(arrayOfByte1);
        localPoolingByteArrayOutputStream.close();
        return arrayOfByte2;
      }
      catch (IOException localIOException2)
      {
        while (true)
          VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
      }
    }
    catch (IOException localIOException1)
    {
      while (true)
        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
    }
  }

  // ERROR //
  public com.mopub.volley.NetworkResponse performRequest(Request<?> paramRequest)
    throws VolleyError
  {
    // Byte code:
    //   0: invokestatic 259	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: invokestatic 263	java/util/Collections:emptyList	()Ljava/util/List;
    //   10: astore 5
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 267	com/mopub/volley/Request:getCacheEntry	()Lcom/mopub/volley/Cache$Entry;
    //   17: invokespecial 269	com/mopub/volley/toolbox/BasicNetwork:a	(Lcom/mopub/volley/Cache$Entry;)Ljava/util/Map;
    //   20: astore 13
    //   22: aload_0
    //   23: getfield 35	com/mopub/volley/toolbox/BasicNetwork:c	Lcom/mopub/volley/toolbox/BaseHttpStack;
    //   26: aload_1
    //   27: aload 13
    //   29: invokevirtual 275	com/mopub/volley/toolbox/BaseHttpStack:executeRequest	(Lcom/mopub/volley/Request;Ljava/util/Map;)Lcom/mopub/volley/toolbox/HttpResponse;
    //   32: astore 14
    //   34: aload 14
    //   36: invokevirtual 280	com/mopub/volley/toolbox/HttpResponse:getStatusCode	()I
    //   39: istore 15
    //   41: aload 14
    //   43: invokevirtual 283	com/mopub/volley/toolbox/HttpResponse:getHeaders	()Ljava/util/List;
    //   46: astore 5
    //   48: iload 15
    //   50: sipush 304
    //   53: if_icmpne +67 -> 120
    //   56: aload_1
    //   57: invokevirtual 267	com/mopub/volley/Request:getCacheEntry	()Lcom/mopub/volley/Cache$Entry;
    //   60: astore 16
    //   62: aload 16
    //   64: ifnonnull +23 -> 87
    //   67: new 285	com/mopub/volley/NetworkResponse
    //   70: dup
    //   71: sipush 304
    //   74: aconst_null
    //   75: iconst_1
    //   76: invokestatic 259	android/os/SystemClock:elapsedRealtime	()J
    //   79: lload_2
    //   80: lsub
    //   81: aload 5
    //   83: invokespecial 288	com/mopub/volley/NetworkResponse:<init>	(I[BZJLjava/util/List;)V
    //   86: areturn
    //   87: aload 5
    //   89: aload 16
    //   91: invokestatic 290	com/mopub/volley/toolbox/BasicNetwork:a	(Ljava/util/List;Lcom/mopub/volley/Cache$Entry;)Ljava/util/List;
    //   94: astore 17
    //   96: new 285	com/mopub/volley/NetworkResponse
    //   99: dup
    //   100: sipush 304
    //   103: aload 16
    //   105: getfield 294	com/mopub/volley/Cache$Entry:data	[B
    //   108: iconst_1
    //   109: invokestatic 259	android/os/SystemClock:elapsedRealtime	()J
    //   112: lload_2
    //   113: lsub
    //   114: aload 17
    //   116: invokespecial 288	com/mopub/volley/NetworkResponse:<init>	(I[BZJLjava/util/List;)V
    //   119: areturn
    //   120: aload 14
    //   122: invokevirtual 298	com/mopub/volley/toolbox/HttpResponse:getContent	()Ljava/io/InputStream;
    //   125: astore 18
    //   127: aload 18
    //   129: ifnull +77 -> 206
    //   132: aload_0
    //   133: aload 18
    //   135: aload 14
    //   137: invokevirtual 301	com/mopub/volley/toolbox/HttpResponse:getContentLength	()I
    //   140: invokespecial 303	com/mopub/volley/toolbox/BasicNetwork:a	(Ljava/io/InputStream;I)[B
    //   143: astore 19
    //   145: aload 19
    //   147: astore 20
    //   149: aload_0
    //   150: invokestatic 259	android/os/SystemClock:elapsedRealtime	()J
    //   153: lload_2
    //   154: lsub
    //   155: aload_1
    //   156: aload 20
    //   158: iload 15
    //   160: invokespecial 305	com/mopub/volley/toolbox/BasicNetwork:a	(JLcom/mopub/volley/Request;[BI)V
    //   163: iload 15
    //   165: sipush 200
    //   168: if_icmplt +11 -> 179
    //   171: iload 15
    //   173: sipush 299
    //   176: if_icmple +38 -> 214
    //   179: new 208	java/io/IOException
    //   182: dup
    //   183: invokespecial 306	java/io/IOException:<init>	()V
    //   186: athrow
    //   187: astore 12
    //   189: ldc_w 308
    //   192: aload_1
    //   193: new 310	com/mopub/volley/TimeoutError
    //   196: dup
    //   197: invokespecial 311	com/mopub/volley/TimeoutError:<init>	()V
    //   200: invokestatic 313	com/mopub/volley/toolbox/BasicNetwork:a	(Ljava/lang/String;Lcom/mopub/volley/Request;Lcom/mopub/volley/VolleyError;)V
    //   203: goto -199 -> 4
    //   206: iconst_0
    //   207: newarray byte
    //   209: astore 20
    //   211: goto -62 -> 149
    //   214: invokestatic 259	android/os/SystemClock:elapsedRealtime	()J
    //   217: lload_2
    //   218: lsub
    //   219: lstore 21
    //   221: new 285	com/mopub/volley/NetworkResponse
    //   224: dup
    //   225: iload 15
    //   227: aload 20
    //   229: iconst_0
    //   230: lload 21
    //   232: aload 5
    //   234: invokespecial 288	com/mopub/volley/NetworkResponse:<init>	(I[BZJLjava/util/List;)V
    //   237: astore 23
    //   239: aload 23
    //   241: areturn
    //   242: astore 11
    //   244: new 315	java/lang/RuntimeException
    //   247: dup
    //   248: new 317	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 320
    //   258: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_1
    //   262: invokevirtual 327	com/mopub/volley/Request:getUrl	()Ljava/lang/String;
    //   265: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: aload 11
    //   273: invokespecial 333	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   276: athrow
    //   277: astore 6
    //   279: aconst_null
    //   280: astore 7
    //   282: aload 4
    //   284: ifnull +102 -> 386
    //   287: aload 4
    //   289: invokevirtual 280	com/mopub/volley/toolbox/HttpResponse:getStatusCode	()I
    //   292: istore 8
    //   294: iconst_2
    //   295: anewarray 4	java/lang/Object
    //   298: astore 9
    //   300: aload 9
    //   302: iconst_0
    //   303: iload 8
    //   305: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: aastore
    //   309: aload 9
    //   311: iconst_1
    //   312: aload_1
    //   313: invokevirtual 327	com/mopub/volley/Request:getUrl	()Ljava/lang/String;
    //   316: aastore
    //   317: ldc_w 335
    //   320: aload 9
    //   322: invokestatic 338	com/mopub/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: aload 7
    //   327: ifnull +157 -> 484
    //   330: new 285	com/mopub/volley/NetworkResponse
    //   333: dup
    //   334: iload 8
    //   336: aload 7
    //   338: iconst_0
    //   339: invokestatic 259	android/os/SystemClock:elapsedRealtime	()J
    //   342: lload_2
    //   343: lsub
    //   344: aload 5
    //   346: invokespecial 288	com/mopub/volley/NetworkResponse:<init>	(I[BZJLjava/util/List;)V
    //   349: astore 10
    //   351: iload 8
    //   353: sipush 401
    //   356: if_icmpeq +11 -> 367
    //   359: iload 8
    //   361: sipush 403
    //   364: if_icmpne +32 -> 396
    //   367: ldc_w 340
    //   370: aload_1
    //   371: new 342	com/mopub/volley/AuthFailureError
    //   374: dup
    //   375: aload 10
    //   377: invokespecial 345	com/mopub/volley/AuthFailureError:<init>	(Lcom/mopub/volley/NetworkResponse;)V
    //   380: invokestatic 313	com/mopub/volley/toolbox/BasicNetwork:a	(Ljava/lang/String;Lcom/mopub/volley/Request;Lcom/mopub/volley/VolleyError;)V
    //   383: goto -379 -> 4
    //   386: new 347	com/mopub/volley/NoConnectionError
    //   389: dup
    //   390: aload 6
    //   392: invokespecial 350	com/mopub/volley/NoConnectionError:<init>	(Ljava/lang/Throwable;)V
    //   395: athrow
    //   396: iload 8
    //   398: sipush 400
    //   401: if_icmplt +21 -> 422
    //   404: iload 8
    //   406: sipush 499
    //   409: if_icmpgt +13 -> 422
    //   412: new 352	com/mopub/volley/ClientError
    //   415: dup
    //   416: aload 10
    //   418: invokespecial 353	com/mopub/volley/ClientError:<init>	(Lcom/mopub/volley/NetworkResponse;)V
    //   421: athrow
    //   422: iload 8
    //   424: sipush 500
    //   427: if_icmplt +47 -> 474
    //   430: iload 8
    //   432: sipush 599
    //   435: if_icmpgt +39 -> 474
    //   438: aload_1
    //   439: invokevirtual 356	com/mopub/volley/Request:shouldRetryServerErrors	()Z
    //   442: ifeq +22 -> 464
    //   445: ldc_w 358
    //   448: aload_1
    //   449: new 210	com/mopub/volley/ServerError
    //   452: dup
    //   453: aload 10
    //   455: invokespecial 359	com/mopub/volley/ServerError:<init>	(Lcom/mopub/volley/NetworkResponse;)V
    //   458: invokestatic 313	com/mopub/volley/toolbox/BasicNetwork:a	(Ljava/lang/String;Lcom/mopub/volley/Request;Lcom/mopub/volley/VolleyError;)V
    //   461: goto -457 -> 4
    //   464: new 210	com/mopub/volley/ServerError
    //   467: dup
    //   468: aload 10
    //   470: invokespecial 359	com/mopub/volley/ServerError:<init>	(Lcom/mopub/volley/NetworkResponse;)V
    //   473: athrow
    //   474: new 210	com/mopub/volley/ServerError
    //   477: dup
    //   478: aload 10
    //   480: invokespecial 359	com/mopub/volley/ServerError:<init>	(Lcom/mopub/volley/NetworkResponse;)V
    //   483: athrow
    //   484: ldc_w 361
    //   487: aload_1
    //   488: new 363	com/mopub/volley/NetworkError
    //   491: dup
    //   492: invokespecial 364	com/mopub/volley/NetworkError:<init>	()V
    //   495: invokestatic 313	com/mopub/volley/toolbox/BasicNetwork:a	(Ljava/lang/String;Lcom/mopub/volley/Request;Lcom/mopub/volley/VolleyError;)V
    //   498: goto -494 -> 4
    //   501: astore 6
    //   503: aload 14
    //   505: astore 4
    //   507: aconst_null
    //   508: astore 7
    //   510: goto -228 -> 282
    //   513: astore 6
    //   515: aload 20
    //   517: astore 7
    //   519: aload 14
    //   521: astore 4
    //   523: goto -241 -> 282
    //
    // Exception table:
    //   from	to	target	type
    //   12	34	187	java/net/SocketTimeoutException
    //   34	48	187	java/net/SocketTimeoutException
    //   56	62	187	java/net/SocketTimeoutException
    //   67	87	187	java/net/SocketTimeoutException
    //   87	120	187	java/net/SocketTimeoutException
    //   120	127	187	java/net/SocketTimeoutException
    //   132	145	187	java/net/SocketTimeoutException
    //   149	163	187	java/net/SocketTimeoutException
    //   179	187	187	java/net/SocketTimeoutException
    //   206	211	187	java/net/SocketTimeoutException
    //   214	239	187	java/net/SocketTimeoutException
    //   12	34	242	java/net/MalformedURLException
    //   34	48	242	java/net/MalformedURLException
    //   56	62	242	java/net/MalformedURLException
    //   67	87	242	java/net/MalformedURLException
    //   87	120	242	java/net/MalformedURLException
    //   120	127	242	java/net/MalformedURLException
    //   132	145	242	java/net/MalformedURLException
    //   149	163	242	java/net/MalformedURLException
    //   179	187	242	java/net/MalformedURLException
    //   206	211	242	java/net/MalformedURLException
    //   214	239	242	java/net/MalformedURLException
    //   12	34	277	java/io/IOException
    //   34	48	501	java/io/IOException
    //   56	62	501	java/io/IOException
    //   67	87	501	java/io/IOException
    //   87	120	501	java/io/IOException
    //   120	127	501	java/io/IOException
    //   132	145	501	java/io/IOException
    //   206	211	501	java/io/IOException
    //   149	163	513	java/io/IOException
    //   179	187	513	java/io/IOException
    //   214	239	513	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.BasicNetwork
 * JD-Core Version:    0.6.2
 */