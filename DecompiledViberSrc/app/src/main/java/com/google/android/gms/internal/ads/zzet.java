package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public final class zzet
  implements Callable
{
  private final zzdy zzvd;
  private final zzbp.zza.zza zzzm;

  public zzet(zzdy paramzzdy, zzbp.zza.zza paramzza)
  {
    this.zzvd = paramzzdy;
    this.zzzm = paramzza;
  }

  private final Void zzcz()
    throws Exception
  {
    if (this.zzvd.zzcq() != null)
      this.zzvd.zzcq().get();
    zzbp.zza localzza = this.zzvd.zzcp();
    if (localzza != null)
      try
      {
        synchronized (this.zzzm)
        {
          zzbp.zza.zza localzza2 = this.zzzm;
          byte[] arrayOfByte = localzza.toByteArray();
          zzdnn localzzdnn = zzdnn.zzaxe();
          localzza2.zza(arrayOfByte, 0, arrayOfByte.length, localzzdnn);
        }
      }
      catch (zzdoj localzzdoj)
      {
      }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzet
 * JD-Core Version:    0.6.2
 */