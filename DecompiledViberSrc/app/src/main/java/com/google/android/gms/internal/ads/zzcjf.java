package com.google.android.gms.internal.ads;

public final class zzcjf
  implements zzbrn, zzbsq
{
  private static final Object zzfyh = new Object();
  private static int zzfyi = 0;
  private final zzcjl zzfyj;

  public zzcjf(zzcjl paramzzcjl)
  {
    this.zzfyj = paramzzcjl;
  }

  private static void zzakj()
  {
    synchronized (zzfyh)
    {
      zzfyi = 1 + zzfyi;
      return;
    }
  }

  private static boolean zzakk()
  {
    while (true)
    {
      synchronized (zzfyh)
      {
        int i = zzfyi;
        zzaci localzzaci = zzact.zzcwu;
        if (i < ((Integer)zzyr.zzpe().zzd(localzzaci)).intValue())
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    zzaci localzzaci = zzact.zzcwt;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (zzakk()))
    {
      this.zzfyj.zzba(false);
      zzakj();
    }
  }

  public final void onAdLoaded()
  {
    zzaci localzzaci = zzact.zzcwt;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (zzakk()))
    {
      this.zzfyj.zzba(true);
      zzakj();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjf
 * JD-Core Version:    0.6.2
 */