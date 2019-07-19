package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public final class zzcgm
{
  private final zzbbm zzfqw;
  private final zzbbm zzfvr;
  private final zzchu zzfvs;
  private final zzdtd<zzcif> zzfvt;

  public zzcgm(zzbbm paramzzbbm1, zzbbm paramzzbbm2, zzchu paramzzchu, zzdtd<zzcif> paramzzdtd)
  {
    this.zzfvr = paramzzbbm1;
    this.zzfqw = paramzzbbm2;
    this.zzfvs = paramzzchu;
    this.zzfvt = paramzzdtd;
  }

  public final zzbbi<InputStream> zzc(zzary paramzzary)
  {
    String str = paramzzary.packageName;
    zzk.zzlg();
    Object localObject;
    if (zzaxj.zzec(str))
      localObject = zzbas.zzd(new zzcid(0));
    while (true)
    {
      zzbbi localzzbbi = zzbas.zza((zzbbi)localObject, zzcid.class, new zzcgp(this, paramzzary), this.zzfqw);
      zzaci localzzaci2 = zzact.zzcvp;
      if (!((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
        localzzbbi.zza(new zzcgq((zzbbi)localObject), zzbbn.zzeah);
      return localzzbbi;
      zzaci localzzaci1 = zzact.zzcvp;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
        localObject = zzbas.zza(this.zzfvr.zza(new zzcgn(this, paramzzary)), ExecutionException.class, zzcgo.zzbra, this.zzfqw);
      else
        localObject = this.zzfvs.zzf(paramzzary);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcgm
 * JD-Core Version:    0.6.2
 */