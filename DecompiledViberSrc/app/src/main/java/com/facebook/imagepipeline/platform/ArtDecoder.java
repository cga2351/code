package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class ArtDecoder
  implements PlatformDecoder
{
  private static final int DECODE_BUFFER_SIZE = 16384;
  private static final byte[] EOI_TAIL = { -1, -39 };
  private static final Class<?> TAG = ArtDecoder.class;
  private final BitmapPool mBitmapPool;

  @VisibleForTesting
  final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;

  public ArtDecoder(BitmapPool paramBitmapPool, int paramInt, Pools.SynchronizedPool paramSynchronizedPool)
  {
    this.mBitmapPool = paramBitmapPool;
    this.mDecodeBuffers = paramSynchronizedPool;
    for (int i = 0; i < paramInt; i++)
      this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
  }

  private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage paramEncodedImage, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramEncodedImage.getSampleSize();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramEncodedImage.getInputStream(), null, localOptions);
    if ((localOptions.outWidth == -1) || (localOptions.outHeight == -1))
      throw new IllegalArgumentException();
    localOptions.inJustDecodeBounds = false;
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inMutable = true;
    return localOptions;
  }

  public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect)
  {
    BitmapFactory.Options localOptions = getDecodeOptionsForStream(paramEncodedImage, paramConfig);
    int i;
    if (localOptions.inPreferredConfig != Bitmap.Config.ARGB_8888)
      i = 1;
    try
    {
      while (true)
      {
        CloseableReference localCloseableReference = decodeStaticImageFromStream(paramEncodedImage.getInputStream(), localOptions, paramRect);
        return localCloseableReference;
        i = 0;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (i != 0)
        return decodeFromEncodedImage(paramEncodedImage, Bitmap.Config.ARGB_8888, paramRect);
      throw localRuntimeException;
    }
  }

  public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, int paramInt)
  {
    boolean bool = paramEncodedImage.isCompleteAt(paramInt);
    BitmapFactory.Options localOptions = getDecodeOptionsForStream(paramEncodedImage, paramConfig);
    InputStream localInputStream = paramEncodedImage.getInputStream();
    Preconditions.checkNotNull(localInputStream);
    if (paramEncodedImage.getSize() > paramInt);
    for (Object localObject1 = new LimitedInputStream(localInputStream, paramInt); ; localObject1 = localInputStream)
    {
      if (!bool);
      for (Object localObject2 = new TailAppendingInputStream((InputStream)localObject1, EOI_TAIL); ; localObject2 = localObject1)
      {
        int i;
        if (localOptions.inPreferredConfig != Bitmap.Config.ARGB_8888)
          i = 1;
        try
        {
          while (true)
          {
            CloseableReference localCloseableReference = decodeStaticImageFromStream((InputStream)localObject2, localOptions, paramRect);
            return localCloseableReference;
            i = 0;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          if (i != 0)
            return decodeFromEncodedImage(paramEncodedImage, Bitmap.Config.ARGB_8888, paramRect);
          throw localRuntimeException;
        }
      }
    }
  }

  // ERROR //
  protected CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream paramInputStream, BitmapFactory.Options paramOptions, @Nullable Rect paramRect)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 129	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: getfield 83	android/graphics/BitmapFactory$Options:outWidth	I
    //   9: istore 5
    //   11: aload_2
    //   12: getfield 86	android/graphics/BitmapFactory$Options:outHeight	I
    //   15: istore 6
    //   17: aload_3
    //   18: ifnull +392 -> 410
    //   21: aload_3
    //   22: invokevirtual 149	android/graphics/Rect:width	()I
    //   25: istore 32
    //   27: aload_3
    //   28: invokevirtual 152	android/graphics/Rect:height	()I
    //   31: istore 7
    //   33: iload 32
    //   35: istore 8
    //   37: iload 8
    //   39: iload 7
    //   41: aload_2
    //   42: getfield 96	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   45: invokestatic 158	com/facebook/imageutils/BitmapUtil:getSizeInByteForBitmap	(IILandroid/graphics/Bitmap$Config;)I
    //   48: istore 9
    //   50: aload_0
    //   51: getfield 38	com/facebook/imagepipeline/platform/ArtDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   54: iload 9
    //   56: invokevirtual 164	com/facebook/imagepipeline/memory/BitmapPool:get	(I)Ljava/lang/Object;
    //   59: checkcast 166	android/graphics/Bitmap
    //   62: astore 10
    //   64: aload 10
    //   66: ifnonnull +13 -> 79
    //   69: new 168	java/lang/NullPointerException
    //   72: dup
    //   73: ldc 170
    //   75: invokespecial 173	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: aload_2
    //   80: aload 10
    //   82: putfield 177	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   85: aload_0
    //   86: getfield 40	com/facebook/imagepipeline/platform/ArtDecoder:mDecodeBuffers	Landroid/support/v4/util/Pools$SynchronizedPool;
    //   89: invokevirtual 181	android/support/v4/util/Pools$SynchronizedPool:acquire	()Ljava/lang/Object;
    //   92: checkcast 42	java/nio/ByteBuffer
    //   95: astore 11
    //   97: aload 11
    //   99: ifnonnull +304 -> 403
    //   102: sipush 16384
    //   105: invokestatic 46	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   108: astore 12
    //   110: aload_2
    //   111: aload 12
    //   113: invokevirtual 185	java/nio/ByteBuffer:array	()[B
    //   116: putfield 188	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   119: aload_3
    //   120: ifnull +270 -> 390
    //   123: aload 10
    //   125: iload 8
    //   127: iload 7
    //   129: aload_2
    //   130: getfield 96	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   133: invokevirtual 192	android/graphics/Bitmap:reconfigure	(IILandroid/graphics/Bitmap$Config;)V
    //   136: aload_1
    //   137: iconst_1
    //   138: invokestatic 198	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   141: astore 29
    //   143: aload 29
    //   145: astore 27
    //   147: aload 27
    //   149: aload_3
    //   150: aload_2
    //   151: invokevirtual 202	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   154: astore 31
    //   156: aload 27
    //   158: ifnull +238 -> 396
    //   161: aload 27
    //   163: invokevirtual 205	android/graphics/BitmapRegionDecoder:recycle	()V
    //   166: aload 31
    //   168: astore 21
    //   170: aload 21
    //   172: ifnonnull +15 -> 187
    //   175: aload_1
    //   176: aconst_null
    //   177: aload_2
    //   178: invokestatic 80	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   181: astore 22
    //   183: aload 22
    //   185: astore 21
    //   187: aload_0
    //   188: getfield 40	com/facebook/imagepipeline/platform/ArtDecoder:mDecodeBuffers	Landroid/support/v4/util/Pools$SynchronizedPool;
    //   191: aload 12
    //   193: invokevirtual 52	android/support/v4/util/Pools$SynchronizedPool:release	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: aload 10
    //   199: aload 21
    //   201: if_acmpeq +161 -> 362
    //   204: aload_0
    //   205: getfield 38	com/facebook/imagepipeline/platform/ArtDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   208: aload 10
    //   210: invokevirtual 208	com/facebook/imagepipeline/memory/BitmapPool:release	(Ljava/lang/Object;)V
    //   213: aload 21
    //   215: invokevirtual 209	android/graphics/Bitmap:recycle	()V
    //   218: new 211	java/lang/IllegalStateException
    //   221: dup
    //   222: invokespecial 212	java/lang/IllegalStateException:<init>	()V
    //   225: athrow
    //   226: astore 26
    //   228: aconst_null
    //   229: astore 27
    //   231: getstatic 28	com/facebook/imagepipeline/platform/ArtDecoder:TAG	Ljava/lang/Class;
    //   234: ldc 214
    //   236: iconst_1
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload_3
    //   243: aastore
    //   244: invokestatic 220	com/facebook/common/logging/FLog:e	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload 27
    //   249: ifnull +141 -> 390
    //   252: aload 27
    //   254: invokevirtual 205	android/graphics/BitmapRegionDecoder:recycle	()V
    //   257: aconst_null
    //   258: astore 21
    //   260: goto -90 -> 170
    //   263: aload 25
    //   265: ifnull +8 -> 273
    //   268: aload 25
    //   270: invokevirtual 205	android/graphics/BitmapRegionDecoder:recycle	()V
    //   273: aload 24
    //   275: athrow
    //   276: astore 16
    //   278: aload_0
    //   279: getfield 38	com/facebook/imagepipeline/platform/ArtDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   282: aload 10
    //   284: invokevirtual 208	com/facebook/imagepipeline/memory/BitmapPool:release	(Ljava/lang/Object;)V
    //   287: aload_1
    //   288: invokevirtual 225	java/io/InputStream:reset	()V
    //   291: aload_1
    //   292: invokestatic 228	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   295: astore 18
    //   297: aload 18
    //   299: ifnonnull +26 -> 325
    //   302: aload 16
    //   304: athrow
    //   305: astore 17
    //   307: aload 16
    //   309: athrow
    //   310: astore 14
    //   312: aload_0
    //   313: getfield 40	com/facebook/imagepipeline/platform/ArtDecoder:mDecodeBuffers	Landroid/support/v4/util/Pools$SynchronizedPool;
    //   316: aload 12
    //   318: invokevirtual 52	android/support/v4/util/Pools$SynchronizedPool:release	(Ljava/lang/Object;)Z
    //   321: pop
    //   322: aload 14
    //   324: athrow
    //   325: aload 18
    //   327: invokestatic 234	com/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser:getInstance	()Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;
    //   330: invokestatic 240	com/facebook/common/references/CloseableReference:of	(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)Lcom/facebook/common/references/CloseableReference;
    //   333: astore 19
    //   335: aload_0
    //   336: getfield 40	com/facebook/imagepipeline/platform/ArtDecoder:mDecodeBuffers	Landroid/support/v4/util/Pools$SynchronizedPool;
    //   339: aload 12
    //   341: invokevirtual 52	android/support/v4/util/Pools$SynchronizedPool:release	(Ljava/lang/Object;)Z
    //   344: pop
    //   345: aload 19
    //   347: areturn
    //   348: astore 13
    //   350: aload_0
    //   351: getfield 38	com/facebook/imagepipeline/platform/ArtDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   354: aload 10
    //   356: invokevirtual 208	com/facebook/imagepipeline/memory/BitmapPool:release	(Ljava/lang/Object;)V
    //   359: aload 13
    //   361: athrow
    //   362: aload 21
    //   364: aload_0
    //   365: getfield 38	com/facebook/imagepipeline/platform/ArtDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   368: invokestatic 240	com/facebook/common/references/CloseableReference:of	(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)Lcom/facebook/common/references/CloseableReference;
    //   371: areturn
    //   372: astore 28
    //   374: aload 27
    //   376: astore 25
    //   378: aload 28
    //   380: astore 24
    //   382: goto -119 -> 263
    //   385: astore 30
    //   387: goto -156 -> 231
    //   390: aconst_null
    //   391: astore 21
    //   393: goto -223 -> 170
    //   396: aload 31
    //   398: astore 21
    //   400: goto -230 -> 170
    //   403: aload 11
    //   405: astore 12
    //   407: goto -297 -> 110
    //   410: iload 6
    //   412: istore 7
    //   414: iload 5
    //   416: istore 8
    //   418: goto -381 -> 37
    //   421: astore 24
    //   423: aconst_null
    //   424: astore 25
    //   426: goto -163 -> 263
    //
    // Exception table:
    //   from	to	target	type
    //   123	143	226	java/io/IOException
    //   110	119	276	java/lang/IllegalArgumentException
    //   161	166	276	java/lang/IllegalArgumentException
    //   175	183	276	java/lang/IllegalArgumentException
    //   252	257	276	java/lang/IllegalArgumentException
    //   268	273	276	java/lang/IllegalArgumentException
    //   273	276	276	java/lang/IllegalArgumentException
    //   287	297	305	java/io/IOException
    //   302	305	305	java/io/IOException
    //   325	335	305	java/io/IOException
    //   110	119	310	finally
    //   161	166	310	finally
    //   175	183	310	finally
    //   252	257	310	finally
    //   268	273	310	finally
    //   273	276	310	finally
    //   278	287	310	finally
    //   287	297	310	finally
    //   302	305	310	finally
    //   307	310	310	finally
    //   325	335	310	finally
    //   350	362	310	finally
    //   110	119	348	java/lang/RuntimeException
    //   161	166	348	java/lang/RuntimeException
    //   175	183	348	java/lang/RuntimeException
    //   252	257	348	java/lang/RuntimeException
    //   268	273	348	java/lang/RuntimeException
    //   273	276	348	java/lang/RuntimeException
    //   147	156	372	finally
    //   231	247	372	finally
    //   147	156	385	java/io/IOException
    //   123	143	421	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.platform.ArtDecoder
 * JD-Core Version:    0.6.2
 */