package com.facebook.imageutils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.support.v4.util.Pools.SynchronizedPool;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public final class BitmapUtil
{
  public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
  public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
  public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
  private static final Pools.SynchronizedPool<ByteBuffer> DECODE_BUFFERS = new Pools.SynchronizedPool(12);
  private static final int DECODE_BUFFER_SIZE = 16384;
  public static final float MAX_BITMAP_SIZE = 2048.0F;
  private static final int POOL_SIZE = 12;
  public static final int RGB_565_BYTES_PER_PIXEL = 2;

  @Nullable
  public static Pair<Integer, Integer> decodeDimensions(InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream);
    ByteBuffer localByteBuffer = (ByteBuffer)DECODE_BUFFERS.acquire();
    if (localByteBuffer == null)
      localByteBuffer = ByteBuffer.allocate(16384);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      localOptions.inTempStorage = localByteBuffer.array();
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      int i = localOptions.outWidth;
      Object localObject2 = null;
      if (i != -1)
      {
        int j = localOptions.outHeight;
        localObject2 = null;
        if (j != -1)
          break label95;
      }
      while (true)
      {
        return localObject2;
        label95: localObject2 = new Pair(Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight));
      }
    }
    finally
    {
      DECODE_BUFFERS.release(localByteBuffer);
    }
  }

  @Nullable
  public static Pair<Integer, Integer> decodeDimensions(byte[] paramArrayOfByte)
  {
    return decodeDimensions(new ByteArrayInputStream(paramArrayOfByte));
  }

  public static int getPixelSizeForBitmapConfig(Bitmap.Config paramConfig)
  {
    int i = 2;
    switch (1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
    {
    default:
      throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    case 1:
      i = 4;
    case 3:
    case 4:
      return i;
    case 2:
    }
    return 1;
  }

  public static int getSizeInByteForBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * getPixelSizeForBitmapConfig(paramConfig);
  }

  @SuppressLint({"NewApi"})
  public static int getSizeInBytes(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return 0;
    if (Build.VERSION.SDK_INT > 19)
      try
      {
        int i = paramBitmap.getAllocationByteCount();
        return i;
      }
      catch (NullPointerException localNullPointerException)
      {
      }
    if (Build.VERSION.SDK_INT >= 12)
      return paramBitmap.getByteCount();
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imageutils.BitmapUtil
 * JD-Core Version:    0.6.2
 */