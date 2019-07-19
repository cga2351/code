package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

final class zzawp extends zzaww
{
  zzawp(zzawn paramzzawn)
  {
  }

  public final void zzto()
  {
    zzacw localzzacw = new zzacw(zzawn.zza(this.zzdtz), zzawn.zzb(this.zzdtz).zzbsy);
    synchronized (zzawn.zzc(this.zzdtz))
    {
      try
      {
        zzk.zzlp();
        zzacz.zza(zzawn.zzd(this.zzdtz), localzzacw);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          zzaxa.zzd("Cannot config CSI reporter.", localIllegalArgumentException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawp
 * JD-Core Version:    0.6.2
 */