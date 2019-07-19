package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;

public class ImagePerfImageOriginListener
  implements ImageOriginListener
{
  private final ImagePerfMonitor mImagePerfMonitor;
  private final ImagePerfState mImagePerfState;

  public ImagePerfImageOriginListener(ImagePerfState paramImagePerfState, ImagePerfMonitor paramImagePerfMonitor)
  {
    this.mImagePerfState = paramImagePerfState;
    this.mImagePerfMonitor = paramImagePerfMonitor;
  }

  public void onImageLoaded(String paramString, int paramInt, boolean paramBoolean)
  {
    this.mImagePerfState.setImageOrigin(paramInt);
    this.mImagePerfState.setSuccessful(paramBoolean);
    this.mImagePerfMonitor.notifyListeners(this.mImagePerfState, 1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener
 * JD-Core Version:    0.6.2
 */