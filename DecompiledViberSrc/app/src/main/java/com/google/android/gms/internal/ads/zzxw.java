package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

@zzare
public final class zzxw extends zzzo
{
  private final AdMetadataListener zzcgn;

  public zzxw(AdMetadataListener paramAdMetadataListener)
  {
    this.zzcgn = paramAdMetadataListener;
  }

  public final void onAdMetadataChanged()
  {
    if (this.zzcgn != null)
      this.zzcgn.onAdMetadataChanged();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxw
 * JD-Core Version:    0.6.2
 */