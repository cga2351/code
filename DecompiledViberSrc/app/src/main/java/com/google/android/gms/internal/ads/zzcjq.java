package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcjq
{
  private zzbaj zzdlf;
  private zzcjb zzfyx;
  private zzwh zzfzh;
  private Context zzlj;

  public zzcjq(Context paramContext, zzbaj paramzzbaj, zzwh paramzzwh, zzcjb paramzzcjb)
  {
    this.zzlj = paramContext;
    this.zzdlf = paramzzbaj;
    this.zzfzh = paramzzwh;
    this.zzfyx = paramzzcjb;
  }

  public final void zzakp()
  {
    String str1;
    try
    {
      this.zzfyx.zza(new zzcjr(this));
      return;
    }
    catch (Exception localException)
    {
      str1 = String.valueOf(localException.getMessage());
      if (str1.length() == 0);
    }
    for (String str2 = "Error in offline signals database startup: ".concat(str1); ; str2 = new String("Error in offline signals database startup: "))
    {
      zzaxa.zzen(str2);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjq
 * JD-Core Version:    0.6.2
 */