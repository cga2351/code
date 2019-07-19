package com.google.android.gms.measurement.internal;

final class zzat
  implements Runnable
{
  zzat(zzas paramzzas, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
  }

  public final void run()
  {
    zzbd localzzbd = this.zzamk.zzada.zzgu();
    if (!localzzbd.isInitialized())
    {
      this.zzamk.zza(6, "Persisted config not initialized. Not logging error/warn");
      return;
    }
    if (zzas.zza(this.zzamk) == 0)
    {
      if (!this.zzamk.zzgv().zzdw())
        break label240;
      zzas localzzas2 = this.zzamk;
      this.zzamk.zzgw();
      zzas.zza(localzzas2, 'C');
    }
    while (true)
    {
      if (zzas.zzb(this.zzamk) < 0L)
        zzas.zza(this.zzamk, this.zzamk.zzgv().zzhh());
      char c1 = "01VDIWEA?".charAt(this.zzamf);
      char c2 = zzas.zza(this.zzamk);
      long l = zzas.zzb(this.zzamk);
      String str1 = zzas.zza(true, this.zzamg, this.zzamh, this.zzami, this.zzamj);
      String str2 = 24 + String.valueOf(str1).length() + "2" + c1 + c2 + l + ":" + str1;
      if (str2.length() > 1024)
        str2 = this.zzamg.substring(0, 1024);
      localzzbd.zzanb.zzc(str2, 1L);
      return;
      label240: zzas localzzas1 = this.zzamk;
      this.zzamk.zzgw();
      zzas.zza(localzzas1, 'c');
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzat
 * JD-Core Version:    0.6.2
 */