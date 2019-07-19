package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CacheService
{
  private static DiskLruCache a;

  @Deprecated
  @VisibleForTesting
  public static void clearAndNullCaches()
  {
    if (a != null);
    try
    {
      a.delete();
      a = null;
      return;
    }
    catch (IOException localIOException)
    {
      a = null;
    }
  }

  public static boolean containsKeyDiskCache(String paramString)
  {
    if (a == null);
    while (true)
    {
      return false;
      try
      {
        DiskLruCache.Snapshot localSnapshot = a.get(createValidDiskCacheKey(paramString));
        if (localSnapshot != null)
          return true;
      }
      catch (Exception localException)
      {
      }
    }
    return false;
  }

  public static String createValidDiskCacheKey(String paramString)
  {
    return Utils.sha1(paramString);
  }

  public static File getDiskCacheDirectory(Context paramContext)
  {
    File localFile = paramContext.getCacheDir();
    if (localFile == null)
      return null;
    String str = localFile.getPath();
    return new File(str + File.separator + "mopub-cache");
  }

  @Deprecated
  @VisibleForTesting
  public static DiskLruCache getDiskLruCache()
  {
    return a;
  }

  public static String getFilePathDiskCache(String paramString)
  {
    if (a == null)
      return null;
    return a.getDirectory() + File.separator + createValidDiskCacheKey(paramString) + "." + 0;
  }

  // ERROR //
  public static byte[] getFromDiskCache(String paramString)
  {
    // Byte code:
    //   0: getstatic 17	com/mopub/common/CacheService:a	Lcom/mopub/common/DiskLruCache;
    //   3: astore_1
    //   4: aconst_null
    //   5: astore_2
    //   6: aload_1
    //   7: ifnonnull +5 -> 12
    //   10: aload_2
    //   11: areturn
    //   12: getstatic 17	com/mopub/common/CacheService:a	Lcom/mopub/common/DiskLruCache;
    //   15: aload_0
    //   16: invokestatic 30	com/mopub/common/CacheService:createValidDiskCacheKey	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual 34	com/mopub/common/DiskLruCache:get	(Ljava/lang/String;)Lcom/mopub/common/DiskLruCache$Snapshot;
    //   22: astore 7
    //   24: aload 7
    //   26: astore 4
    //   28: aload 4
    //   30: ifnonnull +17 -> 47
    //   33: aconst_null
    //   34: astore_2
    //   35: aload 4
    //   37: ifnull -27 -> 10
    //   40: aload 4
    //   42: invokevirtual 93	com/mopub/common/DiskLruCache$Snapshot:close	()V
    //   45: aconst_null
    //   46: areturn
    //   47: aload 4
    //   49: iconst_0
    //   50: invokevirtual 97	com/mopub/common/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   53: astore 8
    //   55: aconst_null
    //   56: astore_2
    //   57: aload 8
    //   59: ifnull +40 -> 99
    //   62: aload 4
    //   64: iconst_0
    //   65: invokevirtual 101	com/mopub/common/DiskLruCache$Snapshot:getLength	(I)J
    //   68: l2i
    //   69: newarray byte
    //   71: astore 9
    //   73: new 103	java/io/BufferedInputStream
    //   76: dup
    //   77: aload 8
    //   79: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   82: astore 10
    //   84: aload 10
    //   86: aload 9
    //   88: invokestatic 112	com/mopub/common/util/Streams:readStream	(Ljava/io/InputStream;[B)V
    //   91: aload 10
    //   93: invokestatic 116	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   96: aload 9
    //   98: astore_2
    //   99: aload 4
    //   101: ifnull -91 -> 10
    //   104: aload 4
    //   106: invokevirtual 93	com/mopub/common/DiskLruCache$Snapshot:close	()V
    //   109: aload_2
    //   110: areturn
    //   111: astore 11
    //   113: aload 10
    //   115: invokestatic 116	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   118: aload 11
    //   120: athrow
    //   121: astore 12
    //   123: aload 9
    //   125: astore_2
    //   126: aload 12
    //   128: astore_3
    //   129: getstatic 122	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: ldc 124
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload_3
    //   144: aastore
    //   145: invokestatic 130	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   148: aload 4
    //   150: ifnull -140 -> 10
    //   153: aload 4
    //   155: invokevirtual 93	com/mopub/common/DiskLruCache$Snapshot:close	()V
    //   158: aload_2
    //   159: areturn
    //   160: astore 6
    //   162: aconst_null
    //   163: astore 4
    //   165: aload 6
    //   167: astore 5
    //   169: aload 4
    //   171: ifnull +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 93	com/mopub/common/DiskLruCache$Snapshot:close	()V
    //   179: aload 5
    //   181: athrow
    //   182: astore 5
    //   184: goto -15 -> 169
    //   187: astore_3
    //   188: aconst_null
    //   189: astore_2
    //   190: aconst_null
    //   191: astore 4
    //   193: goto -64 -> 129
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_2
    //   199: goto -70 -> 129
    //
    // Exception table:
    //   from	to	target	type
    //   84	91	111	finally
    //   73	84	121	java/lang/Exception
    //   91	96	121	java/lang/Exception
    //   113	121	121	java/lang/Exception
    //   12	24	160	finally
    //   47	55	182	finally
    //   62	73	182	finally
    //   73	84	182	finally
    //   91	96	182	finally
    //   113	121	182	finally
    //   129	148	182	finally
    //   12	24	187	java/lang/Exception
    //   47	55	196	java/lang/Exception
    //   62	73	196	java/lang/Exception
  }

  public static void getFromDiskCacheAsync(String paramString, DiskLruCacheGetListener paramDiskLruCacheGetListener)
  {
    new a(paramString, paramDiskLruCacheGetListener).execute(new Void[0]);
  }

  public static void initialize(Context paramContext)
  {
    initializeDiskCache(paramContext);
  }

  public static boolean initializeDiskCache(Context paramContext)
  {
    if (paramContext == null);
    File localFile;
    do
    {
      return false;
      if (a != null)
        break;
      localFile = getDiskCacheDirectory(paramContext);
    }
    while (localFile == null);
    long l = DeviceUtils.diskCacheSizeBytes(localFile);
    try
    {
      a = DiskLruCache.open(localFile, 1, 1, l);
      return true;
    }
    catch (IOException localIOException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to create DiskLruCache", localIOException });
    }
    return false;
  }

  public static boolean putToDiskCache(String paramString, InputStream paramInputStream)
  {
    if (a == null);
    DiskLruCache.Editor localEditor;
    do
      while (true)
      {
        return false;
        localEditor = null;
        try
        {
          localEditor = a.edit(createValidDiskCacheKey(paramString));
          if (localEditor != null)
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localEditor.newOutputStream(0));
            Streams.copyContent(paramInputStream, localBufferedOutputStream);
            localBufferedOutputStream.flush();
            localBufferedOutputStream.close();
            a.flush();
            localEditor.commit();
            return true;
          }
        }
        catch (Exception localException)
        {
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to put to DiskLruCache", localException });
        }
      }
    while (localEditor == null);
    try
    {
      localEditor.abort();
      return false;
    }
    catch (IOException localIOException)
    {
    }
    return false;
  }

  public static boolean putToDiskCache(String paramString, byte[] paramArrayOfByte)
  {
    return putToDiskCache(paramString, new ByteArrayInputStream(paramArrayOfByte));
  }

  public static void putToDiskCacheAsync(String paramString, byte[] paramArrayOfByte)
  {
    new b(paramString, paramArrayOfByte).execute(new Void[0]);
  }

  public static abstract interface DiskLruCacheGetListener
  {
    public abstract void onComplete(String paramString, byte[] paramArrayOfByte);
  }

  private static class a extends AsyncTask<Void, Void, byte[]>
  {
    private final CacheService.DiskLruCacheGetListener a;
    private final String b;

    a(String paramString, CacheService.DiskLruCacheGetListener paramDiskLruCacheGetListener)
    {
      this.a = paramDiskLruCacheGetListener;
      this.b = paramString;
    }

    protected void a(byte[] paramArrayOfByte)
    {
      if (isCancelled())
        onCancelled();
      while (this.a == null)
        return;
      this.a.onComplete(this.b, paramArrayOfByte);
    }

    protected byte[] a(Void[] paramArrayOfVoid)
    {
      return CacheService.getFromDiskCache(this.b);
    }

    protected void onCancelled()
    {
      if (this.a != null)
        this.a.onComplete(this.b, null);
    }
  }

  private static class b extends AsyncTask<Void, Void, Void>
  {
    private final String a;
    private final byte[] b;

    b(String paramString, byte[] paramArrayOfByte)
    {
      this.a = paramString;
      this.b = paramArrayOfByte;
    }

    protected Void a(Void[] paramArrayOfVoid)
    {
      CacheService.putToDiskCache(this.a, this.b);
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.CacheService
 * JD-Core Version:    0.6.2
 */