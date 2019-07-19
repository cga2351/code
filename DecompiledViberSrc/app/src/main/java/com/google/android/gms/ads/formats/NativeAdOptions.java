package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.ads.zzare;
import java.lang.annotation.Annotation;

@zzare
public final class NativeAdOptions
{
  public static final int ADCHOICES_BOTTOM_LEFT = 3;
  public static final int ADCHOICES_BOTTOM_RIGHT = 2;
  public static final int ADCHOICES_TOP_LEFT = 0;
  public static final int ADCHOICES_TOP_RIGHT = 1;
  public static final int ORIENTATION_ANY = 0;
  public static final int ORIENTATION_LANDSCAPE = 2;
  public static final int ORIENTATION_PORTRAIT = 1;
  private final boolean zzbqb;
  private final int zzbqc;
  private final int zzbqd;
  private final boolean zzbqe;
  private final int zzbqf;
  private final VideoOptions zzbqg;
  private final boolean zzbqh;

  private NativeAdOptions(Builder paramBuilder)
  {
    this.zzbqb = Builder.zza(paramBuilder);
    this.zzbqc = Builder.zzb(paramBuilder);
    this.zzbqd = 0;
    this.zzbqe = Builder.zzc(paramBuilder);
    this.zzbqf = Builder.zzd(paramBuilder);
    this.zzbqg = Builder.zze(paramBuilder);
    this.zzbqh = Builder.zzf(paramBuilder);
  }

  public final int getAdChoicesPlacement()
  {
    return this.zzbqf;
  }

  public final int getImageOrientation()
  {
    return this.zzbqc;
  }

  public final VideoOptions getVideoOptions()
  {
    return this.zzbqg;
  }

  public final boolean shouldRequestMultipleImages()
  {
    return this.zzbqe;
  }

  public final boolean shouldReturnUrlsForImageAssets()
  {
    return this.zzbqb;
  }

  public final boolean zzkr()
  {
    return this.zzbqh;
  }

  public static @interface AdChoicesPlacement
  {
  }

  public static final class Builder
  {
    private boolean zzbqb = false;
    private int zzbqc = -1;
    private int zzbqd = 0;
    private boolean zzbqe = false;
    private int zzbqf = 1;
    private VideoOptions zzbqg;
    private boolean zzbqh = false;

    public final NativeAdOptions build()
    {
      return new NativeAdOptions(this, null);
    }

    public final Builder setAdChoicesPlacement(@NativeAdOptions.AdChoicesPlacement int paramInt)
    {
      this.zzbqf = paramInt;
      return this;
    }

    public final Builder setImageOrientation(int paramInt)
    {
      this.zzbqc = paramInt;
      return this;
    }

    public final Builder setRequestCustomMuteThisAd(boolean paramBoolean)
    {
      this.zzbqh = paramBoolean;
      return this;
    }

    public final Builder setRequestMultipleImages(boolean paramBoolean)
    {
      this.zzbqe = paramBoolean;
      return this;
    }

    public final Builder setReturnUrlsForImageAssets(boolean paramBoolean)
    {
      this.zzbqb = paramBoolean;
      return this;
    }

    public final Builder setVideoOptions(VideoOptions paramVideoOptions)
    {
      this.zzbqg = paramVideoOptions;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdOptions
 * JD-Core Version:    0.6.2
 */