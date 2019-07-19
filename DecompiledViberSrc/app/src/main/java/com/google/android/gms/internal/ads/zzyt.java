package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzare
public class zzyt extends AdListener
{
  private final Object lock = new Object();
  private AdListener zzcip;

  public void onAdClosed()
  {
    synchronized (this.lock)
    {
      if (this.zzcip != null)
        this.zzcip.onAdClosed();
      return;
    }
  }

  public void onAdFailedToLoad(int paramInt)
  {
    synchronized (this.lock)
    {
      if (this.zzcip != null)
        this.zzcip.onAdFailedToLoad(paramInt);
      return;
    }
  }

  public void onAdLeftApplication()
  {
    synchronized (this.lock)
    {
      if (this.zzcip != null)
        this.zzcip.onAdLeftApplication();
      return;
    }
  }

  public void onAdLoaded()
  {
    synchronized (this.lock)
    {
      if (this.zzcip != null)
        this.zzcip.onAdLoaded();
      return;
    }
  }

  public void onAdOpened()
  {
    synchronized (this.lock)
    {
      if (this.zzcip != null)
        this.zzcip.onAdOpened();
      return;
    }
  }

  public final void zza(AdListener paramAdListener)
  {
    synchronized (this.lock)
    {
      this.zzcip = paramAdListener;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzyt
 * JD-Core Version:    0.6.2
 */