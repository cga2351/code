package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;

public abstract class CloseableImage
  implements ImageInfo, Closeable
{
  private static final String TAG = "CloseableImage";

  public abstract void close();

  protected void finalize()
    throws Throwable
  {
    if (isClosed())
      return;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = getClass().getSimpleName();
    arrayOfObject[1] = Integer.valueOf(System.identityHashCode(this));
    FLog.w("CloseableImage", "finalize: %s %x still open.", arrayOfObject);
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  public QualityInfo getQualityInfo()
  {
    return ImmutableQualityInfo.FULL_QUALITY;
  }

  public abstract int getSizeInBytes();

  public abstract boolean isClosed();

  public boolean isStateful()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.image.CloseableImage
 * JD-Core Version:    0.6.2
 */