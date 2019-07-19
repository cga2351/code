package com.mopub.mobileads;

import android.os.AsyncTask;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class VideoDownloader
{
  private static final Deque<WeakReference<b>> a = new ArrayDeque();

  private static boolean a(WeakReference<b> paramWeakReference)
  {
    if (paramWeakReference == null)
      return false;
    b localb = (b)paramWeakReference.get();
    if (localb == null)
      return false;
    return localb.cancel(true);
  }

  public static void cache(String paramString, a parama)
  {
    Preconditions.checkNotNull(parama);
    if (paramString == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "VideoDownloader attempted to cache video with null url." });
      parama.onComplete(false);
      return;
    }
    b localb = new b(parama);
    try
    {
      AsyncTasks.safeExecuteOnExecutor(localb, new String[] { paramString });
      return;
    }
    catch (Exception localException)
    {
      parama.onComplete(false);
    }
  }

  public static void cancelAllDownloaderTasks()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
      a((WeakReference)localIterator.next());
    a.clear();
  }

  public static void cancelLastDownloadTask()
  {
    if (a.isEmpty())
      return;
    a((WeakReference)a.peekLast());
    a.removeLast();
  }

  @Deprecated
  @VisibleForTesting
  public static void clearDownloaderTasks()
  {
    a.clear();
  }

  @Deprecated
  @VisibleForTesting
  public static Deque<WeakReference<b>> getDownloaderTasks()
  {
    return a;
  }

  static abstract interface a
  {
    public abstract void onComplete(boolean paramBoolean);
  }

  @VisibleForTesting
  static class b extends AsyncTask<String, Void, Boolean>
  {
    private final VideoDownloader.a a;
    private final WeakReference<b> b;

    @VisibleForTesting
    b(VideoDownloader.a parama)
    {
      this.a = parama;
      this.b = new WeakReference(this);
      VideoDownloader.a().add(this.b);
    }

    // ERROR //
    protected Boolean a(String[] paramArrayOfString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aload_1
      //   3: ifnull +14 -> 17
      //   6: aload_1
      //   7: arraylength
      //   8: ifeq +9 -> 17
      //   11: aload_1
      //   12: iconst_0
      //   13: aaload
      //   14: ifnonnull +25 -> 39
      //   17: getstatic 45	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
      //   20: iconst_1
      //   21: anewarray 47	java/lang/Object
      //   24: dup
      //   25: iconst_0
      //   26: ldc 49
      //   28: aastore
      //   29: invokestatic 55	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
      //   32: iconst_0
      //   33: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   36: astore_3
      //   37: aload_3
      //   38: areturn
      //   39: aload_1
      //   40: iconst_0
      //   41: aaload
      //   42: astore 4
      //   44: aload 4
      //   46: invokestatic 67	com/mopub/common/MoPubHttpUrlConnection:getHttpUrlConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
      //   49: astore 10
      //   51: aload 10
      //   53: astore 7
      //   55: new 69	java/io/BufferedInputStream
      //   58: dup
      //   59: aload 7
      //   61: invokevirtual 75	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   64: invokespecial 78	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   67: astore 6
      //   69: aload 7
      //   71: invokevirtual 82	java/net/HttpURLConnection:getResponseCode	()I
      //   74: istore 11
      //   76: iload 11
      //   78: sipush 200
      //   81: if_icmplt +11 -> 92
      //   84: iload 11
      //   86: sipush 300
      //   89: if_icmplt +71 -> 160
      //   92: getstatic 45	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
      //   95: astore 12
      //   97: iconst_1
      //   98: anewarray 47	java/lang/Object
      //   101: astore 13
      //   103: aload 13
      //   105: iconst_0
      //   106: new 84	java/lang/StringBuilder
      //   109: dup
      //   110: invokespecial 85	java/lang/StringBuilder:<init>	()V
      //   113: ldc 87
      //   115: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   118: iload 11
      //   120: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   123: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   126: aastore
      //   127: aload 12
      //   129: aload 13
      //   131: invokestatic 55	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
      //   134: iconst_0
      //   135: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   138: astore 14
      //   140: aload 14
      //   142: astore_3
      //   143: aload 6
      //   145: invokestatic 104	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   148: aload 7
      //   150: ifnull -113 -> 37
      //   153: aload 7
      //   155: invokevirtual 107	java/net/HttpURLConnection:disconnect	()V
      //   158: aload_3
      //   159: areturn
      //   160: aload 7
      //   162: invokevirtual 110	java/net/HttpURLConnection:getContentLength	()I
      //   165: istore 15
      //   167: iload 15
      //   169: ldc 111
      //   171: if_icmple +82 -> 253
      //   174: getstatic 45	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
      //   177: astore 16
      //   179: iconst_1
      //   180: anewarray 47	java/lang/Object
      //   183: astore 17
      //   185: iconst_2
      //   186: anewarray 47	java/lang/Object
      //   189: astore 18
      //   191: aload 18
      //   193: iconst_0
      //   194: iload 15
      //   196: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   199: aastore
      //   200: aload 18
      //   202: iconst_1
      //   203: ldc 111
      //   205: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   208: aastore
      //   209: aload 17
      //   211: iconst_0
      //   212: ldc 118
      //   214: aload 18
      //   216: invokestatic 124	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   219: aastore
      //   220: aload 16
      //   222: aload 17
      //   224: invokestatic 55	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
      //   227: iconst_0
      //   228: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   231: astore 19
      //   233: aload 19
      //   235: astore_3
      //   236: aload 6
      //   238: invokestatic 104	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   241: aload 7
      //   243: ifnull -206 -> 37
      //   246: aload 7
      //   248: invokevirtual 107	java/net/HttpURLConnection:disconnect	()V
      //   251: aload_3
      //   252: areturn
      //   253: aload 4
      //   255: aload 6
      //   257: invokestatic 130	com/mopub/common/CacheService:putToDiskCache	(Ljava/lang/String;Ljava/io/InputStream;)Z
      //   260: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   263: astore 20
      //   265: aload 20
      //   267: astore_3
      //   268: aload 6
      //   270: invokestatic 104	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   273: aload 7
      //   275: ifnull -238 -> 37
      //   278: aload 7
      //   280: invokevirtual 107	java/net/HttpURLConnection:disconnect	()V
      //   283: aload_3
      //   284: areturn
      //   285: astore 8
      //   287: aconst_null
      //   288: astore 6
      //   290: getstatic 133	com/mopub/common/logging/MoPubLog$SdkLogEvent:ERROR	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
      //   293: iconst_2
      //   294: anewarray 47	java/lang/Object
      //   297: dup
      //   298: iconst_0
      //   299: ldc 135
      //   301: aastore
      //   302: dup
      //   303: iconst_1
      //   304: aload 8
      //   306: aastore
      //   307: invokestatic 55	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
      //   310: iconst_0
      //   311: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   314: astore 9
      //   316: aload 9
      //   318: astore_3
      //   319: aload 6
      //   321: invokestatic 104	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   324: aload_2
      //   325: ifnull -288 -> 37
      //   328: aload_2
      //   329: invokevirtual 107	java/net/HttpURLConnection:disconnect	()V
      //   332: aload_3
      //   333: areturn
      //   334: astore 5
      //   336: aconst_null
      //   337: astore 6
      //   339: aconst_null
      //   340: astore 7
      //   342: aload 6
      //   344: invokestatic 104	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
      //   347: aload 7
      //   349: ifnull +8 -> 357
      //   352: aload 7
      //   354: invokevirtual 107	java/net/HttpURLConnection:disconnect	()V
      //   357: aload 5
      //   359: athrow
      //   360: astore 5
      //   362: aconst_null
      //   363: astore 6
      //   365: goto -23 -> 342
      //   368: astore 5
      //   370: goto -28 -> 342
      //   373: astore 5
      //   375: aload_2
      //   376: astore 7
      //   378: goto -36 -> 342
      //   381: astore 8
      //   383: aload 7
      //   385: astore_2
      //   386: aconst_null
      //   387: astore 6
      //   389: goto -99 -> 290
      //   392: astore 8
      //   394: aload 7
      //   396: astore_2
      //   397: goto -107 -> 290
      //
      // Exception table:
      //   from	to	target	type
      //   44	51	285	java/lang/Exception
      //   44	51	334	finally
      //   55	69	360	finally
      //   69	76	368	finally
      //   92	140	368	finally
      //   160	167	368	finally
      //   174	233	368	finally
      //   253	265	368	finally
      //   290	316	373	finally
      //   55	69	381	java/lang/Exception
      //   69	76	392	java/lang/Exception
      //   92	140	392	java/lang/Exception
      //   160	167	392	java/lang/Exception
      //   174	233	392	java/lang/Exception
      //   253	265	392	java/lang/Exception
    }

    protected void a(Boolean paramBoolean)
    {
      if (isCancelled())
      {
        onCancelled();
        return;
      }
      VideoDownloader.a().remove(this.b);
      if (paramBoolean == null)
      {
        this.a.onComplete(false);
        return;
      }
      this.a.onComplete(paramBoolean.booleanValue());
    }

    protected void onCancelled()
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "VideoDownloader task was cancelled." });
      VideoDownloader.a().remove(this.b);
      this.a.onComplete(false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VideoDownloader
 * JD-Core Version:    0.6.2
 */