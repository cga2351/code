package com.google.android.gms.internal.ads;

import android.util.Log;

@zzare
public final class zzaxa extends zzbae
{
  public static void zza(String paramString, Throwable paramThrowable)
  {
    if (zzvj())
      Log.v("Ads", paramString, paramThrowable);
  }

  public static void zzds(String paramString)
  {
    if (zzvj())
      Log.v("Ads", paramString);
  }

  public static boolean zzvj()
  {
    if (isLoggable(2))
    {
      zzaci localzzaci = zzact.zzcqh;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxa
 * JD-Core Version:    0.6.2
 */