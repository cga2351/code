package com.viber.jni.downloader;

import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NativeDownloader
{
  private static final int DIRECT_BUFFER_SIZE = 16384;
  private static final int HTTP_OK = 200;
  private static final Logger L = ViberEnv.getLogger();
  private static final int METHOD_GET = 0;
  private static final int METHOD_POST = 1;
  private static final int WEB_REQUEST_CANCELED = -1;
  private static final int WEB_REQUEST_INTERNAL_ERROR = -3;
  private static final int WEB_REQUEST_IN_PROGRESS = 0;
  private static final int WEB_REQUEST_TIMEOUT = -2;
  private SparseArray<Future<Downloader>> downloadsMap = new SparseArray();
  long mNateiveObj = 0L;
  private final ExecutorService pool;

  public NativeDownloader(int paramInt)
  {
    this.pool = Executors.newFixedThreadPool(paramInt);
  }

  private native void downloadFinished(long paramLong, int paramInt1, int paramInt2);

  private native void onDataReceived(long paramLong, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);

  private native void onHead(long paramLong, int paramInt, RequestHeader[] paramArrayOfRequestHeader);

  public void cancelAll()
  {
    SparseArray localSparseArray = this.downloadsMap;
    for (int i = 0; ; i++)
      try
      {
        if (i < this.downloadsMap.size())
        {
          Future localFuture = (Future)this.downloadsMap.valueAt(i);
          if (localFuture != null)
            localFuture.cancel(true);
        }
        else
        {
          this.downloadsMap.clear();
          return;
        }
      }
      finally
      {
      }
  }

  public boolean cancelBySeq(int paramInt)
  {
    synchronized (this.downloadsMap)
    {
      Future localFuture = (Future)this.downloadsMap.get(paramInt);
      if (localFuture != null)
      {
        localFuture.cancel(true);
        this.downloadsMap.remove(paramInt);
        return true;
      }
      return false;
    }
  }

  public void handleRequest(int paramInt1, int paramInt2, String paramString, int paramInt3, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    Downloader localDownloader = new Downloader(paramInt1, paramInt2, paramString, paramInt3, paramMap, paramArrayOfByte);
    Future localFuture = this.pool.submit(localDownloader, localDownloader);
    if (localFuture != null)
      synchronized (this.downloadsMap)
      {
        this.downloadsMap.append(paramInt1, localFuture);
        return;
      }
  }

  public void setNativeContext(long paramLong)
  {
    this.mNateiveObj = paramLong;
  }

  private class Downloader
    implements Runnable
  {
    private Map<String, String> headers;
    private int method;
    private byte[] postData;
    private int responseCode;
    private int seq;
    private int timeout;
    private String url;

    public Downloader(int paramString, String paramInt1, int paramMap, Map<String, String> paramArrayOfByte, byte[] arg6)
    {
      this.seq = paramString;
      this.url = paramMap;
      this.timeout = paramArrayOfByte;
      Object localObject1;
      this.headers = localObject1;
      this.method = paramInt1;
      Object localObject2;
      this.postData = localObject2;
      this.responseCode = 0;
    }

    protected RequestHeader[] getHeaders(Map<String, List<String>> paramMap)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localArrayList.add(new RequestHeader((String)localEntry.getKey(), (String)((List)localEntry.getValue()).get(0)));
      }
      return (RequestHeader[])localArrayList.toArray(new RequestHeader[localArrayList.size()]);
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: invokestatic 116	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
      //   5: getstatic 122	com/viber/voip/util/http/OkHttpClientFactory$Type:GZIP_AWARE	Lcom/viber/voip/util/http/OkHttpClientFactory$Type;
      //   8: invokeinterface 128 2 0
      //   13: aload_0
      //   14: getfield 33	com/viber/jni/downloader/NativeDownloader$Downloader:timeout	I
      //   17: i2l
      //   18: getstatic 134	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
      //   21: invokevirtual 140	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
      //   24: aload_0
      //   25: getfield 33	com/viber/jni/downloader/NativeDownloader$Downloader:timeout	I
      //   28: i2l
      //   29: getstatic 134	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
      //   32: invokevirtual 143	okhttp3/OkHttpClient$Builder:readTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
      //   35: astore 13
      //   37: new 145	okhttp3/Request$Builder
      //   40: dup
      //   41: invokespecial 146	okhttp3/Request$Builder:<init>	()V
      //   44: aload_0
      //   45: getfield 31	com/viber/jni/downloader/NativeDownloader$Downloader:url	Ljava/lang/String;
      //   48: invokevirtual 149	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
      //   51: astore 14
      //   53: aload_0
      //   54: getfield 35	com/viber/jni/downloader/NativeDownloader$Downloader:headers	Ljava/util/Map;
      //   57: ifnull +128 -> 185
      //   60: aload_0
      //   61: getfield 35	com/viber/jni/downloader/NativeDownloader$Downloader:headers	Ljava/util/Map;
      //   64: invokeinterface 52 1 0
      //   69: invokeinterface 58 1 0
      //   74: astore 26
      //   76: aload 26
      //   78: invokeinterface 64 1 0
      //   83: ifeq +102 -> 185
      //   86: aload 26
      //   88: invokeinterface 68 1 0
      //   93: checkcast 70	java/util/Map$Entry
      //   96: astore 27
      //   98: aload 14
      //   100: aload 27
      //   102: invokeinterface 75 1 0
      //   107: checkcast 77	java/lang/String
      //   110: aload 27
      //   112: invokeinterface 80 1 0
      //   117: checkcast 77	java/lang/String
      //   120: invokevirtual 153	okhttp3/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
      //   123: pop
      //   124: goto -48 -> 76
      //   127: astore 12
      //   129: aload_1
      //   130: astore_3
      //   131: aload_0
      //   132: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   135: aload_0
      //   136: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   139: getfield 159	com/viber/jni/downloader/NativeDownloader:mNateiveObj	J
      //   142: aload_0
      //   143: getfield 29	com/viber/jni/downloader/NativeDownloader$Downloader:seq	I
      //   146: bipush 254
      //   148: invokestatic 163	com/viber/jni/downloader/NativeDownloader:access$200	(Lcom/viber/jni/downloader/NativeDownloader;JII)V
      //   151: aload_3
      //   152: invokestatic 169	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
      //   155: aload_0
      //   156: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   159: invokestatic 173	com/viber/jni/downloader/NativeDownloader:access$300	(Lcom/viber/jni/downloader/NativeDownloader;)Landroid/util/SparseArray;
      //   162: astore 9
      //   164: aload 9
      //   166: monitorenter
      //   167: aload_0
      //   168: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   171: invokestatic 173	com/viber/jni/downloader/NativeDownloader:access$300	(Lcom/viber/jni/downloader/NativeDownloader;)Landroid/util/SparseArray;
      //   174: aload_0
      //   175: getfield 29	com/viber/jni/downloader/NativeDownloader$Downloader:seq	I
      //   178: invokevirtual 179	android/util/SparseArray:delete	(I)V
      //   181: aload 9
      //   183: monitorexit
      //   184: return
      //   185: aload_0
      //   186: getfield 37	com/viber/jni/downloader/NativeDownloader$Downloader:method	I
      //   189: iconst_1
      //   190: if_icmpne +28 -> 218
      //   193: aload_0
      //   194: getfield 39	com/viber/jni/downloader/NativeDownloader$Downloader:postData	[B
      //   197: ifnull +171 -> 368
      //   200: aconst_null
      //   201: aload_0
      //   202: getfield 39	com/viber/jni/downloader/NativeDownloader$Downloader:postData	[B
      //   205: invokestatic 185	okhttp3/RequestBody:create	(Lokhttp3/MediaType;[B)Lokhttp3/RequestBody;
      //   208: astore 24
      //   210: aload 14
      //   212: aload 24
      //   214: invokevirtual 189	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
      //   217: pop
      //   218: aload 13
      //   220: invokevirtual 193	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
      //   223: aload 14
      //   225: invokevirtual 196	okhttp3/Request$Builder:build	()Lokhttp3/Request;
      //   228: invokevirtual 202	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
      //   231: invokeinterface 208 1 0
      //   236: astore 15
      //   238: aload_0
      //   239: aload 15
      //   241: invokevirtual 213	okhttp3/Response:code	()I
      //   244: putfield 41	com/viber/jni/downloader/NativeDownloader$Downloader:responseCode	I
      //   247: aload_0
      //   248: aload 15
      //   250: invokevirtual 216	okhttp3/Response:headers	()Lokhttp3/Headers;
      //   253: invokevirtual 222	okhttp3/Headers:toMultimap	()Ljava/util/Map;
      //   256: invokevirtual 224	com/viber/jni/downloader/NativeDownloader$Downloader:getHeaders	(Ljava/util/Map;)[Lcom/viber/jni/downloader/RequestHeader;
      //   259: astore 16
      //   261: aload_0
      //   262: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   265: aload_0
      //   266: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   269: getfield 159	com/viber/jni/downloader/NativeDownloader:mNateiveObj	J
      //   272: aload_0
      //   273: getfield 29	com/viber/jni/downloader/NativeDownloader$Downloader:seq	I
      //   276: aload 16
      //   278: invokestatic 228	com/viber/jni/downloader/NativeDownloader:access$000	(Lcom/viber/jni/downloader/NativeDownloader;JI[Lcom/viber/jni/downloader/RequestHeader;)V
      //   281: new 230	java/io/BufferedInputStream
      //   284: dup
      //   285: aload 15
      //   287: invokevirtual 234	okhttp3/Response:body	()Lokhttp3/ResponseBody;
      //   290: invokevirtual 240	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
      //   293: sipush 16384
      //   296: invokespecial 243	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
      //   299: astore_3
      //   300: sipush 16384
      //   303: invokestatic 249	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
      //   306: astore 20
      //   308: iconst_0
      //   309: istore 21
      //   311: aload_3
      //   312: aload 20
      //   314: invokevirtual 253	java/nio/ByteBuffer:array	()[B
      //   317: aload 20
      //   319: invokevirtual 256	java/nio/ByteBuffer:arrayOffset	()I
      //   322: sipush 16384
      //   325: invokevirtual 262	java/io/InputStream:read	([BII)I
      //   328: istore 22
      //   330: iload 22
      //   332: iconst_m1
      //   333: if_icmpeq +51 -> 384
      //   336: aload_0
      //   337: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   340: aload_0
      //   341: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   344: getfield 159	com/viber/jni/downloader/NativeDownloader:mNateiveObj	J
      //   347: aload_0
      //   348: getfield 29	com/viber/jni/downloader/NativeDownloader$Downloader:seq	I
      //   351: aload 20
      //   353: iload 22
      //   355: invokestatic 266	com/viber/jni/downloader/NativeDownloader:access$100	(Lcom/viber/jni/downloader/NativeDownloader;JILjava/nio/ByteBuffer;I)V
      //   358: iload 21
      //   360: iload 22
      //   362: iadd
      //   363: istore 21
      //   365: goto -54 -> 311
      //   368: aconst_null
      //   369: iconst_0
      //   370: newarray byte
      //   372: invokestatic 185	okhttp3/RequestBody:create	(Lokhttp3/MediaType;[B)Lokhttp3/RequestBody;
      //   375: astore 23
      //   377: aload 23
      //   379: astore 24
      //   381: goto -171 -> 210
      //   384: aload_0
      //   385: getfield 31	com/viber/jni/downloader/NativeDownloader$Downloader:url	Ljava/lang/String;
      //   388: iload 21
      //   390: i2l
      //   391: invokestatic 271	com/viber/voip/util/de:a	(Ljava/lang/String;J)V
      //   394: aload_0
      //   395: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   398: aload_0
      //   399: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   402: getfield 159	com/viber/jni/downloader/NativeDownloader:mNateiveObj	J
      //   405: aload_0
      //   406: getfield 29	com/viber/jni/downloader/NativeDownloader$Downloader:seq	I
      //   409: sipush 200
      //   412: invokestatic 163	com/viber/jni/downloader/NativeDownloader:access$200	(Lcom/viber/jni/downloader/NativeDownloader;JII)V
      //   415: goto -264 -> 151
      //   418: astore 19
      //   420: aload_3
      //   421: astore_1
      //   422: goto -293 -> 129
      //   425: astore 11
      //   427: aconst_null
      //   428: astore_3
      //   429: aload_0
      //   430: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   433: aload_0
      //   434: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   437: getfield 159	com/viber/jni/downloader/NativeDownloader:mNateiveObj	J
      //   440: aload_0
      //   441: getfield 29	com/viber/jni/downloader/NativeDownloader$Downloader:seq	I
      //   444: bipush 253
      //   446: invokestatic 163	com/viber/jni/downloader/NativeDownloader:access$200	(Lcom/viber/jni/downloader/NativeDownloader;JII)V
      //   449: goto -298 -> 151
      //   452: astore 4
      //   454: aload_3
      //   455: astore 5
      //   457: aload 4
      //   459: astore 6
      //   461: aload 5
      //   463: invokestatic 169	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
      //   466: aload_0
      //   467: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   470: invokestatic 173	com/viber/jni/downloader/NativeDownloader:access$300	(Lcom/viber/jni/downloader/NativeDownloader;)Landroid/util/SparseArray;
      //   473: astore 7
      //   475: aload 7
      //   477: monitorenter
      //   478: aload_0
      //   479: getfield 24	com/viber/jni/downloader/NativeDownloader$Downloader:this$0	Lcom/viber/jni/downloader/NativeDownloader;
      //   482: invokestatic 173	com/viber/jni/downloader/NativeDownloader:access$300	(Lcom/viber/jni/downloader/NativeDownloader;)Landroid/util/SparseArray;
      //   485: aload_0
      //   486: getfield 29	com/viber/jni/downloader/NativeDownloader$Downloader:seq	I
      //   489: invokevirtual 179	android/util/SparseArray:delete	(I)V
      //   492: aload 7
      //   494: monitorexit
      //   495: aload 6
      //   497: athrow
      //   498: astore 10
      //   500: aload 9
      //   502: monitorexit
      //   503: aload 10
      //   505: athrow
      //   506: astore 8
      //   508: aload 7
      //   510: monitorexit
      //   511: aload 8
      //   513: athrow
      //   514: astore 6
      //   516: aconst_null
      //   517: astore 5
      //   519: goto -58 -> 461
      //   522: astore 18
      //   524: goto -95 -> 429
      //   527: astore_2
      //   528: aconst_null
      //   529: astore_3
      //   530: goto -399 -> 131
      //   533: astore 17
      //   535: goto -404 -> 131
      //
      // Exception table:
      //   from	to	target	type
      //   2	76	127	java/net/SocketTimeoutException
      //   76	124	127	java/net/SocketTimeoutException
      //   185	210	127	java/net/SocketTimeoutException
      //   210	218	127	java/net/SocketTimeoutException
      //   218	300	127	java/net/SocketTimeoutException
      //   368	377	127	java/net/SocketTimeoutException
      //   300	308	418	java/net/SocketTimeoutException
      //   311	330	418	java/net/SocketTimeoutException
      //   336	358	418	java/net/SocketTimeoutException
      //   384	415	418	java/net/SocketTimeoutException
      //   2	76	425	java/io/IOException
      //   76	124	425	java/io/IOException
      //   185	210	425	java/io/IOException
      //   210	218	425	java/io/IOException
      //   218	300	425	java/io/IOException
      //   368	377	425	java/io/IOException
      //   131	151	452	finally
      //   300	308	452	finally
      //   311	330	452	finally
      //   336	358	452	finally
      //   384	415	452	finally
      //   429	449	452	finally
      //   167	184	498	finally
      //   500	503	498	finally
      //   478	495	506	finally
      //   508	511	506	finally
      //   2	76	514	finally
      //   76	124	514	finally
      //   185	210	514	finally
      //   210	218	514	finally
      //   218	300	514	finally
      //   368	377	514	finally
      //   300	308	522	java/io/IOException
      //   311	330	522	java/io/IOException
      //   336	358	522	java/io/IOException
      //   384	415	522	java/io/IOException
      //   2	76	527	java/net/UnknownHostException
      //   76	124	527	java/net/UnknownHostException
      //   185	210	527	java/net/UnknownHostException
      //   210	218	527	java/net/UnknownHostException
      //   218	300	527	java/net/UnknownHostException
      //   368	377	527	java/net/UnknownHostException
      //   300	308	533	java/net/UnknownHostException
      //   311	330	533	java/net/UnknownHostException
      //   336	358	533	java/net/UnknownHostException
      //   384	415	533	java/net/UnknownHostException
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.downloader.NativeDownloader
 * JD-Core Version:    0.6.2
 */