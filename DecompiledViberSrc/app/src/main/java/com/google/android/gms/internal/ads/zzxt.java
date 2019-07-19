package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzare
public final class zzxt extends zzyy
{
  private final AdListener zzcgm;

  public zzxt(AdListener paramAdListener)
  {
    this.zzcgm = paramAdListener;
  }

  public final AdListener getAdListener()
  {
    return this.zzcgm;
  }

  public final void onAdClicked()
  {
    this.zzcgm.onAdClicked();
  }

  public final void onAdClosed()
  {
    this.zzcgm.onAdClosed();
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    this.zzcgm.onAdFailedToLoad(paramInt);
  }

  public final void onAdImpression()
  {
    this.zzcgm.onAdImpression();
  }

  public final void onAdLeftApplication()
  {
    this.zzcgm.onAdLeftApplication();
  }

  public final void onAdLoaded()
  {
    this.zzcgm.onAdLoaded();
  }

  public final void onAdOpened()
  {
    this.zzcgm.onAdOpened();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxt
 * JD-Core Version:    0.6.2
 */