package com.facebook.imagepipeline.cache;

import b.i;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedDiskCache
{
  private static final Class<?> TAG = BufferedDiskCache.class;
  private final FileCache mFileCache;
  private final ImageCacheStatsTracker mImageCacheStatsTracker;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final PooledByteStreams mPooledByteStreams;
  private final Executor mReadExecutor;
  private final StagingArea mStagingArea;
  private final Executor mWriteExecutor;

  public BufferedDiskCache(FileCache paramFileCache, PooledByteBufferFactory paramPooledByteBufferFactory, PooledByteStreams paramPooledByteStreams, Executor paramExecutor1, Executor paramExecutor2, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    this.mFileCache = paramFileCache;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mPooledByteStreams = paramPooledByteStreams;
    this.mReadExecutor = paramExecutor1;
    this.mWriteExecutor = paramExecutor2;
    this.mImageCacheStatsTracker = paramImageCacheStatsTracker;
    this.mStagingArea = StagingArea.getInstance();
  }

  private boolean checkInStagingAreaAndFileCache(CacheKey paramCacheKey)
  {
    EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
    if (localEncodedImage != null)
    {
      localEncodedImage.close();
      FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
      this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
      return true;
    }
    FLog.v(TAG, "Did not find image for %s in staging area", paramCacheKey.getUriString());
    this.mImageCacheStatsTracker.onStagingAreaMiss();
    try
    {
      boolean bool = this.mFileCache.hasKey(paramCacheKey);
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private i<Boolean> containsAsync(final CacheKey paramCacheKey)
  {
    try
    {
      i locali = i.a(new Callable()
      {
        public Boolean call()
          throws Exception
        {
          return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(paramCacheKey));
        }
      }
      , this.mReadExecutor);
      return locali;
    }
    catch (Exception localException)
    {
      Class localClass = TAG;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramCacheKey.getUriString();
      FLog.w(localClass, localException, "Failed to schedule disk-cache read for %s", arrayOfObject);
      return i.a(localException);
    }
  }

  private i<EncodedImage> foundPinnedImage(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
    this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
    return i.a(paramEncodedImage);
  }

  private i<EncodedImage> getAsync(final CacheKey paramCacheKey, final AtomicBoolean paramAtomicBoolean)
  {
    try
    {
      i locali = i.a(new Callable()
      {
        // ERROR //
        public EncodedImage call()
          throws Exception
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 24	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
          //   4: invokevirtual 39	java/util/concurrent/atomic/AtomicBoolean:get	()Z
          //   7: ifeq +11 -> 18
          //   10: new 41	java/util/concurrent/CancellationException
          //   13: dup
          //   14: invokespecial 42	java/util/concurrent/CancellationException:<init>	()V
          //   17: athrow
          //   18: aload_0
          //   19: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   22: invokestatic 46	com/facebook/imagepipeline/cache/BufferedDiskCache:access$100	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/StagingArea;
          //   25: aload_0
          //   26: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   29: invokevirtual 51	com/facebook/imagepipeline/cache/StagingArea:get	(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/imagepipeline/image/EncodedImage;
          //   32: astore_1
          //   33: aload_1
          //   34: ifnull +66 -> 100
          //   37: invokestatic 55	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   40: ldc 57
          //   42: aload_0
          //   43: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   46: invokeinterface 63 1 0
          //   51: invokestatic 69	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   54: aload_0
          //   55: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   58: invokestatic 73	com/facebook/imagepipeline/cache/BufferedDiskCache:access$300	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
          //   61: aload_0
          //   62: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   65: invokeinterface 79 2 0
          //   70: invokestatic 84	java/lang/Thread:interrupted	()Z
          //   73: ifeq +99 -> 172
          //   76: invokestatic 55	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   79: ldc 86
          //   81: invokestatic 89	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;)V
          //   84: aload_1
          //   85: ifnull +7 -> 92
          //   88: aload_1
          //   89: invokevirtual 94	com/facebook/imagepipeline/image/EncodedImage:close	()V
          //   92: new 96	java/lang/InterruptedException
          //   95: dup
          //   96: invokespecial 97	java/lang/InterruptedException:<init>	()V
          //   99: athrow
          //   100: invokestatic 55	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   103: ldc 99
          //   105: aload_0
          //   106: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   109: invokeinterface 63 1 0
          //   114: invokestatic 69	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   117: aload_0
          //   118: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   121: invokestatic 73	com/facebook/imagepipeline/cache/BufferedDiskCache:access$300	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
          //   124: invokeinterface 102 1 0
          //   129: aload_0
          //   130: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   133: aload_0
          //   134: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   137: invokestatic 106	com/facebook/imagepipeline/cache/BufferedDiskCache:access$400	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/common/memory/PooledByteBuffer;
          //   140: invokestatic 112	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
          //   143: astore_3
          //   144: new 91	com/facebook/imagepipeline/image/EncodedImage
          //   147: dup
          //   148: aload_3
          //   149: invokespecial 115	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
          //   152: astore_1
          //   153: aload_3
          //   154: invokestatic 118	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   157: goto -87 -> 70
          //   160: astore 4
          //   162: aload_3
          //   163: invokestatic 118	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   166: aload 4
          //   168: athrow
          //   169: astore_2
          //   170: aconst_null
          //   171: astore_1
          //   172: aload_1
          //   173: areturn
          //
          // Exception table:
          //   from	to	target	type
          //   144	153	160	finally
          //   129	144	169	java/lang/Exception
          //   153	157	169	java/lang/Exception
          //   162	169	169	java/lang/Exception
        }
      }
      , this.mReadExecutor);
      return locali;
    }
    catch (Exception localException)
    {
      Class localClass = TAG;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramCacheKey.getUriString();
      FLog.w(localClass, localException, "Failed to schedule disk-cache read for %s", arrayOfObject);
      return i.a(localException);
    }
  }

  // ERROR //
  private com.facebook.common.memory.PooledByteBuffer readFromDiskCache(CacheKey paramCacheKey)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 24	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   3: ldc 155
    //   5: aload_1
    //   6: invokeinterface 97 1 0
    //   11: invokestatic 103	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 30	com/facebook/imagepipeline/cache/BufferedDiskCache:mFileCache	Lcom/facebook/cache/disk/FileCache;
    //   18: aload_1
    //   19: invokeinterface 159 2 0
    //   24: astore 5
    //   26: aload 5
    //   28: ifnonnull +28 -> 56
    //   31: getstatic 24	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   34: ldc 161
    //   36: aload_1
    //   37: invokeinterface 97 1 0
    //   42: invokestatic 103	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   45: aload_0
    //   46: getfield 40	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   49: invokeinterface 164 1 0
    //   54: aconst_null
    //   55: areturn
    //   56: getstatic 24	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   59: ldc 166
    //   61: aload_1
    //   62: invokeinterface 97 1 0
    //   67: invokestatic 103	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   70: aload_0
    //   71: getfield 40	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   74: invokeinterface 169 1 0
    //   79: aload 5
    //   81: invokeinterface 175 1 0
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 32	com/facebook/imagepipeline/cache/BufferedDiskCache:mPooledByteBufferFactory	Lcom/facebook/common/memory/PooledByteBufferFactory;
    //   92: aload 6
    //   94: aload 5
    //   96: invokeinterface 179 1 0
    //   101: l2i
    //   102: invokeinterface 185 3 0
    //   107: astore 8
    //   109: aload 6
    //   111: invokevirtual 188	java/io/InputStream:close	()V
    //   114: getstatic 24	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   117: ldc 190
    //   119: aload_1
    //   120: invokeinterface 97 1 0
    //   125: invokestatic 103	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   128: aload 8
    //   130: areturn
    //   131: astore_2
    //   132: getstatic 24	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   135: astore_3
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: astore 4
    //   142: aload 4
    //   144: iconst_0
    //   145: aload_1
    //   146: invokeinterface 97 1 0
    //   151: aastore
    //   152: aload_3
    //   153: aload_2
    //   154: ldc 192
    //   156: aload 4
    //   158: invokestatic 138	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_0
    //   162: getfield 40	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   165: invokeinterface 195 1 0
    //   170: aload_2
    //   171: athrow
    //   172: astore 7
    //   174: aload 6
    //   176: invokevirtual 188	java/io/InputStream:close	()V
    //   179: aload 7
    //   181: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	26	131	java/io/IOException
    //   31	54	131	java/io/IOException
    //   56	88	131	java/io/IOException
    //   109	128	131	java/io/IOException
    //   174	182	131	java/io/IOException
    //   88	109	172	finally
  }

  private void writeToDiskCache(CacheKey paramCacheKey, final EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "About to write to disk-cache for key %s", paramCacheKey.getUriString());
    try
    {
      this.mFileCache.insert(paramCacheKey, new WriterCallback()
      {
        public void write(OutputStream paramAnonymousOutputStream)
          throws IOException
        {
          BufferedDiskCache.this.mPooledByteStreams.copy(paramEncodedImage.getInputStream(), paramAnonymousOutputStream);
        }
      });
      FLog.v(TAG, "Successful disk-cache write for key %s", paramCacheKey.getUriString());
      return;
    }
    catch (IOException localIOException)
    {
      Class localClass = TAG;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramCacheKey.getUriString();
      FLog.w(localClass, localIOException, "Failed to write to disk-cache for key %s", arrayOfObject);
    }
  }

  public i<Void> clearAll()
  {
    this.mStagingArea.clearAll();
    try
    {
      i locali = i.a(new Callable()
      {
        public Void call()
          throws Exception
        {
          BufferedDiskCache.this.mStagingArea.clearAll();
          BufferedDiskCache.this.mFileCache.clearAll();
          return null;
        }
      }
      , this.mWriteExecutor);
      return locali;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache clear", new Object[0]);
      return i.a(localException);
    }
  }

  public i<Boolean> contains(CacheKey paramCacheKey)
  {
    if (containsSync(paramCacheKey))
      return i.a(Boolean.valueOf(true));
    return containsAsync(paramCacheKey);
  }

  public boolean containsSync(CacheKey paramCacheKey)
  {
    return (this.mStagingArea.containsKey(paramCacheKey)) || (this.mFileCache.hasKeySync(paramCacheKey));
  }

  public boolean diskCheckSync(CacheKey paramCacheKey)
  {
    if (containsSync(paramCacheKey))
      return true;
    return checkInStagingAreaAndFileCache(paramCacheKey);
  }

  public i<EncodedImage> get(CacheKey paramCacheKey, AtomicBoolean paramAtomicBoolean)
  {
    EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
    if (localEncodedImage != null)
      return foundPinnedImage(paramCacheKey, localEncodedImage);
    return getAsync(paramCacheKey, paramAtomicBoolean);
  }

  public void put(final CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    Preconditions.checkNotNull(paramCacheKey);
    Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
    this.mStagingArea.put(paramCacheKey, paramEncodedImage);
    final EncodedImage localEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
    try
    {
      this.mWriteExecutor.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            BufferedDiskCache.this.writeToDiskCache(paramCacheKey, localEncodedImage);
            return;
          }
          finally
          {
            BufferedDiskCache.this.mStagingArea.remove(paramCacheKey, localEncodedImage);
            EncodedImage.closeSafely(localEncodedImage);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      Class localClass = TAG;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramCacheKey.getUriString();
      FLog.w(localClass, localException, "Failed to schedule disk-cache write for %s", arrayOfObject);
      this.mStagingArea.remove(paramCacheKey, paramEncodedImage);
      EncodedImage.closeSafely(localEncodedImage);
    }
  }

  public i<Void> remove(final CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    this.mStagingArea.remove(paramCacheKey);
    try
    {
      i locali = i.a(new Callable()
      {
        public Void call()
          throws Exception
        {
          BufferedDiskCache.this.mStagingArea.remove(paramCacheKey);
          BufferedDiskCache.this.mFileCache.remove(paramCacheKey);
          return null;
        }
      }
      , this.mWriteExecutor);
      return locali;
    }
    catch (Exception localException)
    {
      Class localClass = TAG;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramCacheKey.getUriString();
      FLog.w(localClass, localException, "Failed to schedule disk-cache remove for %s", arrayOfObject);
      return i.a(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.BufferedDiskCache
 * JD-Core Version:    0.6.2
 */