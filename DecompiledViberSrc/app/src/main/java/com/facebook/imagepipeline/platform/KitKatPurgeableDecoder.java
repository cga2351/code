package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(19)
@ThreadSafe
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder
{
  private final FlexByteArrayPool mFlexByteArrayPool;

  public KitKatPurgeableDecoder(FlexByteArrayPool paramFlexByteArrayPool)
  {
    this.mFlexByteArrayPool = paramFlexByteArrayPool;
  }

  private static void putEOI(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = -1;
    paramArrayOfByte[(paramInt + 1)] = -39;
  }

  protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions)
  {
    PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramCloseableReference.get();
    int i = localPooledByteBuffer.size();
    CloseableReference localCloseableReference = this.mFlexByteArrayPool.get(i);
    try
    {
      byte[] arrayOfByte = (byte[])localCloseableReference.get();
      localPooledByteBuffer.read(0, arrayOfByte, 0, i);
      Bitmap localBitmap = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeByteArray(arrayOfByte, 0, i, paramOptions), "BitmapFactory returned null");
      return localBitmap;
    }
    finally
    {
      CloseableReference.closeSafely(localCloseableReference);
    }
  }

  protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions)
  {
    byte[] arrayOfByte1;
    if (endsWithEOI(paramCloseableReference, paramInt))
      arrayOfByte1 = null;
    while (true)
    {
      PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramCloseableReference.get();
      int i = localPooledByteBuffer.size();
      boolean bool = false;
      if (paramInt <= i)
        bool = true;
      Preconditions.checkArgument(bool);
      CloseableReference localCloseableReference = this.mFlexByteArrayPool.get(paramInt + 2);
      try
      {
        byte[] arrayOfByte2 = (byte[])localCloseableReference.get();
        localPooledByteBuffer.read(0, arrayOfByte2, 0, paramInt);
        if (arrayOfByte1 != null)
        {
          putEOI(arrayOfByte2, paramInt);
          paramInt += 2;
        }
        Bitmap localBitmap = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeByteArray(arrayOfByte2, 0, paramInt, paramOptions), "BitmapFactory returned null");
        return localBitmap;
        arrayOfByte1 = EOI;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.platform.KitKatPurgeableDecoder
 * JD-Core Version:    0.6.2
 */