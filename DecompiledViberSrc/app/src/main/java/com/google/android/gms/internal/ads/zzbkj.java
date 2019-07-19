package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

final class zzbkj extends zzcvr
{
  private zzdtt<String> zzeql;
  private zzdtt<zzcey> zzeqn;
  private zzdtt<Map<zzczr, zzcey>> zzeqp;
  private zzdtt<Set<zzbuy<zzczy>>> zzeqr;
  private zzdtt<Set<zzbuy<zzczy>>> zzerb;
  private zzdtt zzerc;
  private zzdtt<zzczs> zzerd;
  private zzdtt<ApplicationInfo> zzese;
  private zzcww zzezh;
  private zzdtt<zzcvn> zzezi;
  private zzdtt<String> zzezj;
  private zzdtt<zzcvx> zzezk;
  private zzdtt<zzcwb> zzezl;
  private zzdtt<zzcwi> zzezm;
  private zzdtt<Boolean> zzezn;
  private zzdtt<zzcwp> zzezo;
  private zzdtt<zzcwt> zzezp;
  private zzdtt<zzcxg> zzezq;
  private zzdtt<zzcey> zzezr;
  private zzdtt<zzcey> zzezs;
  private zzdtt<zzcey> zzezt;

  private zzbkj(zzbkd paramzzbkd, zzcww paramzzcww)
  {
    this.zzezh = paramzzcww;
    this.zzezi = new zzcvq(zzblo.zzafa(), zzbkd.zzd(this.zzeqg), zzbkd.zza(this.zzeqg), zzcyw.zzamw());
    this.zzezj = new zzcwx(paramzzcww);
    this.zzezk = new zzcvz(zzbjz.zzacs(), zzbkd.zzd(this.zzeqg), this.zzezj, zzcyw.zzamw());
    this.zzezl = new zzcwd(zzblk.zzaes(), zzcyw.zzamw(), zzbkd.zzd(this.zzeqg));
    this.zzezm = new zzcwk(zzbll.zzaeu(), zzcyw.zzamw(), this.zzezj);
    this.zzezn = new zzcwz(paramzzcww);
    this.zzese = new zzcwy(paramzzcww);
    this.zzezo = new zzcwr(zzblm.zzaew(), zzbkd.zza(this.zzeqg), this.zzezn, this.zzese);
    this.zzezp = new zzcwv(zzbln.zzaey(), zzbkd.zza(this.zzeqg), zzbkd.zzd(this.zzeqg));
    this.zzezq = new zzcxi(zzcyw.zzamw());
    this.zzeql = new zzcxa(paramzzcww);
    this.zzeqn = zzdtg.zzao(zzces.zzajt());
    this.zzezr = zzdtg.zzao(zzcer.zzajs());
    this.zzezs = zzdtg.zzao(zzcet.zzaju());
    this.zzezt = zzdtg.zzao(zzceu.zzajv());
    this.zzeqp = zzdtj.zzho(4).zza(zzczr.zzgmx, this.zzeqn).zza(zzczr.zzgmz, this.zzezr).zza(zzczr.zzgna, this.zzezs).zza(zzczr.zzgnb, this.zzezt).zzbbf();
    this.zzeqr = zzdtg.zzao(new zzcev(this.zzeql, zzbkd.zzd(this.zzeqg), zzcyw.zzamw(), this.zzeqp));
    this.zzerb = zzdtp.zzao(0, 1).zzar(this.zzeqr).zzbbh();
    this.zzerc = zzdaa.zzan(this.zzerb);
    this.zzerd = zzdtg.zzao(zzczz.zzp(zzcyw.zzamw(), zzbkd.zza(this.zzeqg), this.zzerc));
  }

  private final zzcwm zzadn()
  {
    return new zzcwm(zzblj.zzaer(), zzcyw.zzamx(), (List)zzdtn.zza(this.zzezh.zzamg(), "Cannot return null from a non-@Nullable @Provides method"));
  }

  private final zzcvt zzado()
  {
    return new zzcvt(zzblo.zzafb(), zzcyw.zzamx(), (String)zzdtn.zza(this.zzezh.zzamd(), "Cannot return null from a non-@Nullable @Provides method"), this.zzezh.zzame());
  }

  public final zzcva<JSONObject> zzadp()
  {
    zzbbm localzzbbm = zzcyw.zzamx();
    zzdto localzzdto1 = zzdto.zzhp(11).zzas((zzcuz)zzdtn.zza(new zzcty(new zzcwi(zzbll.zzaev(), zzcyw.zzamx(), zzcwx.zzb(this.zzezh)), 0L, (ScheduledExecutorService)zzbkd.zza(this.zzeqg).get()), "Cannot return null from a non-@Nullable @Provides method"));
    zzcwp localzzcwp = new zzcwp(zzblm.zzaex(), (ScheduledExecutorService)zzbkd.zza(this.zzeqg).get(), this.zzezh.zzamf(), zzcwy.zzc(this.zzezh));
    ScheduledExecutorService localScheduledExecutorService1 = (ScheduledExecutorService)zzbkd.zza(this.zzeqg).get();
    zzaci localzzaci1 = zzact.zzcsr;
    zzdto localzzdto2 = localzzdto1.zzas((zzcuz)zzdtn.zza(new zzcty(localzzcwp, ((Long)zzyr.zzpe().zzd(localzzaci1)).longValue(), localScheduledExecutorService1), "Cannot return null from a non-@Nullable @Provides method"));
    zzcwt localzzcwt = new zzcwt(zzbln.zzaez(), (ScheduledExecutorService)zzbkd.zza(this.zzeqg).get(), zzbjr.zza(zzbkd.zzb(this.zzeqg)));
    ScheduledExecutorService localScheduledExecutorService2 = (ScheduledExecutorService)zzbkd.zza(this.zzeqg).get();
    zzaci localzzaci2 = zzact.zzcth;
    return new zzcva(localzzbbm, localzzdto2.zzas((zzcuz)zzdtn.zza(new zzcty(localzzcwt, ((Long)zzyr.zzpe().zzd(localzzaci2)).longValue(), localScheduledExecutorService2), "Cannot return null from a non-@Nullable @Provides method")).zzas((zzcuz)zzdtn.zza(new zzcty(new zzcvn(zzblo.zzafb(), zzbjr.zza(zzbkd.zzb(this.zzeqg)), (ScheduledExecutorService)zzbkd.zza(this.zzeqg).get(), zzcyw.zzamx()), 0L, (ScheduledExecutorService)zzbkd.zza(this.zzeqg).get()), "Cannot return null from a non-@Nullable @Provides method")).zzas((zzcuz)zzdtn.zza(new zzcty(new zzcxg(zzcyw.zzamx()), 0L, (ScheduledExecutorService)zzbkd.zza(this.zzeqg).get()), "Cannot return null from a non-@Nullable @Provides method")).zzas(zzcxd.zzamj()).zzas(new zzcvx(null, zzbjr.zza(zzbkd.zzb(this.zzeqg)), zzcwx.zzb(this.zzezh), zzcyw.zzamx())).zzas(new zzcwb(zzblk.zzaet(), zzcyw.zzamx(), zzbjr.zza(zzbkd.zzb(this.zzeqg)))).zzas(zzadn()).zzas(zzado()).zzas((zzcuz)zzbkd.zzc(this.zzeqg).get()).zzbbg());
  }

  public final zzcva<JSONObject> zzadq()
  {
    return zzcxe.zza(zzbkd.zzc(this.zzeqg).get(), zzado(), zzadn(), zzdtg.zzap(this.zzezi), zzdtg.zzap(this.zzezk), zzdtg.zzap(this.zzezl), zzdtg.zzap(this.zzezm), zzdtg.zzap(this.zzezo), zzdtg.zzap(this.zzezp), zzdtg.zzap(this.zzezq), zzcyw.zzamx());
  }

  public final zzczs zzadr()
  {
    return (zzczs)this.zzerd.get();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbkj
 * JD-Core Version:    0.6.2
 */