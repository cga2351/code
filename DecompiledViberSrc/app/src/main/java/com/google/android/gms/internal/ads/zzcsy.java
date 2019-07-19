package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzcsy
  implements zzcuz<zzcsx>
{
  private final zzcxu zzfjp;
  private final zzbbm zzfqw;

  public zzcsy(zzbbm paramzzbbm, zzcxu paramzzcxu)
  {
    this.zzfqw = paramzzbbm;
    this.zzfjp = paramzzcxu;
  }

  private static int zzc(zzzw paramzzzw)
  {
    long l1 = 0L;
    if (paramzzzw != null);
    try
    {
      long l2 = paramzzzw.getValue();
      l1 = l2;
      return (int)l1;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzaxa.zzep("Cannot get correlation id, default to 0.");
    }
  }

  public final zzbbi<zzcsx> zzalm()
  {
    return this.zzfqw.zza(new zzcsz(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcsy
 * JD-Core Version:    0.6.2
 */