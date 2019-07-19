package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzcxz
{
  public static void zzc(Throwable paramThrowable, String paramString)
  {
    int i = zzcgl.zze(paramThrowable);
    zzaxa.zzeo(31 + "Ad failed to load : " + i);
    zzaxa.zza(paramString, paramThrowable);
    if (zzcgl.zze(paramThrowable) == 3)
      return;
    zzk.zzlk().zzb(paramThrowable, paramString);
  }

  public static void zze(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      zzaxa.zzeo("This request is sent from a test device.");
      return;
    }
    zzyr.zzpa();
    String str = zzazu.zzbe(paramContext);
    zzaxa.zzeo(71 + String.valueOf(str).length() + "Use AdRequest.Builder.addTestDevice(\"" + str + "\") to get test ads on this device.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxz
 * JD-Core Version:    0.6.2
 */