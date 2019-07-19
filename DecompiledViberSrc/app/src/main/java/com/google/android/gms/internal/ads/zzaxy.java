package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;

@TargetApi(26)
public class zzaxy extends zzaxx
{
  public final zzwv zza(Context paramContext, TelephonyManager paramTelephonyManager)
  {
    zzk.zzlg();
    if (zzaxj.zzp(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
    {
      if (paramTelephonyManager.isDataEnabled())
        return zzwv.zzcak;
      return zzwv.zzcaj;
    }
    return zzwv.zzcaj;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxy
 * JD-Core Version:    0.6.2
 */