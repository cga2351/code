package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class zzcif extends zzaro
{
  private final Executor zzffu;
  private final zzasn zzfxl;
  private final zzasm zzfxm;
  private final zzblq zzfxn;
  private final Context zzlj;

  public zzcif(Context paramContext, Executor paramExecutor, zzasn paramzzasn, zzblq paramzzblq, zzasm paramzzasm)
  {
    zzact.initialize(paramContext);
    this.zzlj = paramContext;
    this.zzffu = paramExecutor;
    this.zzfxl = paramzzasn;
    this.zzfxm = paramzzasm;
    this.zzfxn = paramzzblq;
  }

  private final void zza(zzbbi<InputStream> paramzzbbi, zzars paramzzars)
  {
    zzbas.zza(zzbas.zza(paramzzbbi, new zzcio(this), zzaxh.zzdvr), new zzcip(this, paramzzars), zzbbn.zzeah);
  }

  public final zzarj zza(zzarh paramzzarh)
    throws RemoteException
  {
    return null;
  }

  public final void zza(zzarh paramzzarh, zzarq paramzzarq)
    throws RemoteException
  {
  }

  public final void zza(zzary paramzzary, zzars paramzzars)
  {
    zzbbi localzzbbi = zzh(paramzzary);
    zza(localzzbbi, paramzzars);
    localzzbbi.zza(new zzcim(this), this.zzffu);
  }

  public final void zzb(zzary paramzzary, zzars paramzzars)
  {
    zzals localzzals = zzk.zzlt().zza(this.zzlj, zzbaj.zzxc());
    zzaci localzzaci = zzact.zzcwd;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
    zzcvr localzzcvr;
    zzcva localzzcva;
    zzalk localzzalk;
    for (Object localObject = zzbas.zzd(new Exception("Signal collection disabled.")); ; localObject = localzzcvr.zzadr().zza(zzczr.zzgnc, zzbas.zzm(paramzzary.zzdov)).zza(new zzcin(localzzcva)).zzx(zzczr.zzgnd).zza(localzzalk).zzane())
    {
      zza((zzbbi)localObject, paramzzars);
      return;
      localzzcvr = this.zzfxn.zza(paramzzary);
      localzzcva = this.zzfxn.zza(paramzzary).zzadq();
      localzzalk = localzzals.zza("google.afma.request.getSignals", zzalp.zzddk, zzalp.zzddl);
    }
  }

  public final zzbbi<InputStream> zzh(zzary paramzzary)
  {
    zzals localzzals = zzk.zzlt().zza(this.zzlj, zzbaj.zzxc());
    zzcvr localzzcvr = this.zzfxn.zza(paramzzary);
    zzcig localzzcig = new zzcig(localzzcvr);
    zzczb localzzczb = zzcih.zzfvz;
    zzalk localzzalk1 = localzzals.zza("AFMA_getAdDictionary", zzalp.zzddk, zzcii.zzddm);
    zzalk localzzalk2 = localzzals.zza("google.afma.response.normalize", zzciq.zzfxv, zzalp.zzddl);
    zzcit localzzcit = new zzcit(this.zzlj, paramzzary.zzdlf.zzbsy, this.zzfxl, paramzzary.zzdmk);
    zzczs localzzczs = localzzcvr.zzadr();
    zzczd localzzczd1 = localzzczs.zza(zzczr.zzgmx, zzbas.zzm(paramzzary.zzdov)).zza(localzzcig).zzb(localzzczb).zzane();
    zzaci localzzaci = zzact.zzcvq;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
    {
      zzalk localzzalk3 = localzzals.zza("google.afma.request.getAdResponse", zzalp.zzddk, zzalp.zzddk);
      return localzzczs.zza(zzczr.zzgmy, localzzczd1).zza(localzzalk3).zzb(zzcij.zzfvz).zzane();
    }
    zzczd localzzczd2 = localzzczs.zza(zzczr.zzgmz, localzzczd1).zza(localzzalk1).zzane();
    zzczd localzzczd3 = localzzczs.zza(zzczr.zzgna, new zzbbi[] { localzzczd2, localzzczd1 }).zzc(new zzcik(localzzczd1, localzzczd2)).zzb(localzzcit).zzane();
    return localzzczs.zza(zzczr.zzgnb, new zzbbi[] { localzzczd1, localzzczd2, localzzczd3 }).zzc(new zzcil(localzzczd3, localzzczd1, localzzczd2)).zza(localzzalk2).zzane();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcif
 * JD-Core Version:    0.6.2
 */