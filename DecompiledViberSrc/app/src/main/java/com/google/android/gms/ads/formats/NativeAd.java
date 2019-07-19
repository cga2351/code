package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

public abstract class NativeAd
{
  public static final String ASSET_ADCHOICES_CONTAINER_VIEW = "1098";

  @Deprecated
  @KeepForSdk
  public abstract void performClick(Bundle paramBundle);

  @Deprecated
  @KeepForSdk
  public abstract boolean recordImpression(Bundle paramBundle);

  @Deprecated
  @KeepForSdk
  public abstract void reportTouchEvent(Bundle paramBundle);

  protected abstract Object zzkq();

  public static abstract class AdChoicesInfo
  {
    public abstract List<NativeAd.Image> getImages();

    public abstract CharSequence getText();
  }

  public static abstract class Image
  {
    public abstract Drawable getDrawable();

    public int getHeight()
    {
      return -1;
    }

    public abstract double getScale();

    public abstract Uri getUri();

    public int getWidth()
    {
      return -1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAd
 * JD-Core Version:    0.6.2
 */