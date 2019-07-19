package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;

public abstract interface ProgressiveJpegConfig
{
  public abstract int getNextScanNumberToDecode(int paramInt);

  public abstract QualityInfo getQualityInfo(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
 * JD-Core Version:    0.6.2
 */