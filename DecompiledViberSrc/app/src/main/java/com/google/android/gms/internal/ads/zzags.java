package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd.UnconfirmedClickListener;

public final class zzags extends zzagd
{
  private final UnifiedNativeAd.UnconfirmedClickListener zzczn;

  public zzags(UnifiedNativeAd.UnconfirmedClickListener paramUnconfirmedClickListener)
  {
    this.zzczn = paramUnconfirmedClickListener;
  }

  public final void onUnconfirmedClickCancelled()
  {
    this.zzczn.onUnconfirmedClickCancelled();
  }

  public final void onUnconfirmedClickReceived(String paramString)
  {
    this.zzczn.onUnconfirmedClickReceived(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzags
 * JD-Core Version:    0.6.2
 */