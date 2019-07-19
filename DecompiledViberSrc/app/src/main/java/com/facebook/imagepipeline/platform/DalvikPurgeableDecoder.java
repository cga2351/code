package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import java.util.Locale;
import javax.annotation.Nullable;

abstract class DalvikPurgeableDecoder
  implements PlatformDecoder
{
  protected static final byte[] EOI = { -1, -39 };
  private final BitmapCounter mUnpooledBitmapsCounter = BitmapCounterProvider.get();

  protected static boolean endsWithEOI(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt)
  {
    PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramCloseableReference.get();
    return (paramInt >= 2) && (localPooledByteBuffer.read(paramInt - 2) == -1) && (localPooledByteBuffer.read(paramInt - 1) == -39);
  }

  private static BitmapFactory.Options getBitmapFactoryOptions(int paramInt, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    if (Build.VERSION.SDK_INT >= 11)
      localOptions.inMutable = true;
    return localOptions;
  }

  abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions);

  public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect)
  {
    BitmapFactory.Options localOptions = getBitmapFactoryOptions(paramEncodedImage.getSampleSize(), paramConfig);
    CloseableReference localCloseableReference1 = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(localCloseableReference1);
    try
    {
      CloseableReference localCloseableReference2 = pinBitmap(decodeByteArrayAsPurgeable(localCloseableReference1, localOptions));
      return localCloseableReference2;
    }
    finally
    {
      CloseableReference.closeSafely(localCloseableReference1);
    }
  }

  abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions);

  public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, int paramInt)
  {
    BitmapFactory.Options localOptions = getBitmapFactoryOptions(paramEncodedImage.getSampleSize(), paramConfig);
    CloseableReference localCloseableReference1 = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(localCloseableReference1);
    try
    {
      CloseableReference localCloseableReference2 = pinBitmap(decodeJPEGByteArrayAsPurgeable(localCloseableReference1, paramInt, localOptions));
      return localCloseableReference2;
    }
    finally
    {
      CloseableReference.closeSafely(localCloseableReference1);
    }
  }

  public CloseableReference<Bitmap> pinBitmap(Bitmap paramBitmap)
  {
    try
    {
      Bitmaps.pinBitmap(paramBitmap);
      if (!this.mUnpooledBitmapsCounter.increase(paramBitmap))
      {
        int i = BitmapUtil.getSizeInBytes(paramBitmap);
        paramBitmap.recycle();
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Integer.valueOf(i);
        arrayOfObject[1] = Integer.valueOf(this.mUnpooledBitmapsCounter.getCount());
        arrayOfObject[2] = Long.valueOf(this.mUnpooledBitmapsCounter.getSize());
        arrayOfObject[3] = Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxCount());
        arrayOfObject[4] = Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxSize());
        throw new TooManyBitmapsException(String.format(localLocale, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", arrayOfObject));
      }
    }
    catch (Exception localException)
    {
      paramBitmap.recycle();
      throw Throwables.propagate(localException);
    }
    return CloseableReference.of(paramBitmap, this.mUnpooledBitmapsCounter.getReleaser());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.platform.DalvikPurgeableDecoder
 * JD-Core Version:    0.6.2
 */