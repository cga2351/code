package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzacc;
import com.google.android.gms.internal.ads.zzare;

@zzare
public final class VideoOptions
{
  private final boolean zzaax;
  private final boolean zzaay;
  private final boolean zzaaz;

  private VideoOptions(Builder paramBuilder)
  {
    this.zzaax = Builder.zza(paramBuilder);
    this.zzaay = Builder.zzb(paramBuilder);
    this.zzaaz = Builder.zzc(paramBuilder);
  }

  public VideoOptions(zzacc paramzzacc)
  {
    this.zzaax = paramzzacc.zzaax;
    this.zzaay = paramzzacc.zzaay;
    this.zzaaz = paramzzacc.zzaaz;
  }

  public final boolean getClickToExpandRequested()
  {
    return this.zzaaz;
  }

  public final boolean getCustomControlsRequested()
  {
    return this.zzaay;
  }

  public final boolean getStartMuted()
  {
    return this.zzaax;
  }

  public static final class Builder
  {
    private boolean zzaax = true;
    private boolean zzaay = false;
    private boolean zzaaz = false;

    public final VideoOptions build()
    {
      return new VideoOptions(this, null);
    }

    public final Builder setClickToExpandRequested(boolean paramBoolean)
    {
      this.zzaaz = paramBoolean;
      return this;
    }

    public final Builder setCustomControlsRequested(boolean paramBoolean)
    {
      this.zzaay = paramBoolean;
      return this;
    }

    public final Builder setStartMuted(boolean paramBoolean)
    {
      this.zzaax = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.VideoOptions
 * JD-Core Version:    0.6.2
 */