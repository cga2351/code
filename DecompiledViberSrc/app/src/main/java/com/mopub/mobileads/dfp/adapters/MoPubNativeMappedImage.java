package com.mopub.mobileads.dfp.adapters;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;

public class MoPubNativeMappedImage extends NativeAd.Image
{
  private Drawable a;
  private Uri b;
  private double c;

  public MoPubNativeMappedImage(Drawable paramDrawable, String paramString, double paramDouble)
  {
    this.a = paramDrawable;
    this.b = Uri.parse(paramString);
    this.c = paramDouble;
  }

  public Drawable getDrawable()
  {
    return this.a;
  }

  public double getScale()
  {
    return this.c;
  }

  public Uri getUri()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.dfp.adapters.MoPubNativeMappedImage
 * JD-Core Version:    0.6.2
 */