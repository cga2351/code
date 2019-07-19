package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ForwardingImageOriginListener
  implements ImageOriginListener
{
  private static final String TAG = "ForwardingImageOriginListener";
  private final List<ImageOriginListener> mImageOriginListeners;

  public ForwardingImageOriginListener(Set<ImageOriginListener> paramSet)
  {
    this.mImageOriginListeners = new ArrayList(paramSet);
  }

  public ForwardingImageOriginListener(ImageOriginListener[] paramArrayOfImageOriginListener)
  {
    this.mImageOriginListeners = new ArrayList(paramArrayOfImageOriginListener.length);
    Collections.addAll(this.mImageOriginListeners, paramArrayOfImageOriginListener);
  }

  public void addImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    try
    {
      this.mImageOriginListeners.add(paramImageOriginListener);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onImageLoaded(String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      int i = this.mImageOriginListeners.size();
      int j = 0;
      while (true)
        if (j < i)
        {
          ImageOriginListener localImageOriginListener = (ImageOriginListener)this.mImageOriginListeners.get(j);
          try
          {
            localImageOriginListener.onImageLoaded(paramString, paramInt, paramBoolean);
            j++;
          }
          catch (Exception localException)
          {
            while (true)
              FLog.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", localException);
          }
        }
    }
    finally
    {
    }
  }

  public void removeImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    try
    {
      this.mImageOriginListeners.remove(paramImageOriginListener);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener
 * JD-Core Version:    0.6.2
 */