package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@zzare
public final class zzyd extends zzzr
{
  private final AppEventListener zzbqp;

  public zzyd(AppEventListener paramAppEventListener)
  {
    this.zzbqp = paramAppEventListener;
  }

  public final AppEventListener getAppEventListener()
  {
    return this.zzbqp;
  }

  public final void onAppEvent(String paramString1, String paramString2)
  {
    this.zzbqp.onAppEvent(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzyd
 * JD-Core Version:    0.6.2
 */