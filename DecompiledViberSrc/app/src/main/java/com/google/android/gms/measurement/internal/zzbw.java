package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzsi;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class zzbw
  implements zzct
{
  private static volatile zzbw zzapj;
  private final boolean zzadg;
  private final String zzadi;
  private final long zzago;
  private final zzn zzaih;
  private final String zzapk;
  private final String zzapl;
  private final zzq zzapm;
  private final zzbd zzapn;
  private final zzas zzapo;
  private final zzbr zzapp;
  private final zzfd zzapq;
  private final AppMeasurement zzapr;
  private final zzfx zzaps;
  private final zzaq zzapt;
  private final zzdy zzapu;
  private final zzda zzapv;
  private final zza zzapw;
  private zzao zzapx;
  private zzeb zzapy;
  private zzaa zzapz;
  private zzam zzaqa;
  private zzbj zzaqb;
  private Boolean zzaqc;
  private long zzaqd;
  private volatile Boolean zzaqe;

  @VisibleForTesting
  private Boolean zzaqf;

  @VisibleForTesting
  private Boolean zzaqg;
  private int zzaqh;
  private AtomicInteger zzaqi = new AtomicInteger(0);
  private final Context zzri;
  private final Clock zzrz;
  private boolean zzvz = false;

  private zzbw(zzcz paramzzcz)
  {
    Preconditions.checkNotNull(paramzzcz);
    this.zzaih = new zzn(paramzzcz.zzri);
    zzai.zza(this.zzaih);
    this.zzri = paramzzcz.zzri;
    this.zzadi = paramzzcz.zzadi;
    this.zzapk = paramzzcz.zzapk;
    this.zzapl = paramzzcz.zzapl;
    this.zzadg = paramzzcz.zzadg;
    this.zzaqe = paramzzcz.zzaqe;
    zzan localzzan = paramzzcz.zzaqz;
    if ((localzzan != null) && (localzzan.zzadj != null))
    {
      Object localObject1 = localzzan.zzadj.get("measurementEnabled");
      if ((localObject1 instanceof Boolean))
        this.zzaqf = ((Boolean)localObject1);
      Object localObject2 = localzzan.zzadj.get("measurementDeactivated");
      if ((localObject2 instanceof Boolean))
        this.zzaqg = ((Boolean)localObject2);
    }
    zzsi.zzae(this.zzri);
    this.zzrz = DefaultClock.getInstance();
    this.zzago = this.zzrz.currentTimeMillis();
    this.zzapm = new zzq(this);
    zzbd localzzbd = new zzbd(this);
    localzzbd.zzq();
    this.zzapn = localzzbd;
    zzas localzzas = new zzas(this);
    localzzas.zzq();
    this.zzapo = localzzas;
    zzfx localzzfx = new zzfx(this);
    localzzfx.zzq();
    this.zzaps = localzzfx;
    zzaq localzzaq = new zzaq(this);
    localzzaq.zzq();
    this.zzapt = localzzaq;
    this.zzapw = new zza(this);
    zzdy localzzdy = new zzdy(this);
    localzzdy.zzq();
    this.zzapu = localzzdy;
    zzda localzzda1 = new zzda(this);
    localzzda1.zzq();
    this.zzapv = localzzda1;
    this.zzapr = new AppMeasurement(this);
    zzfd localzzfd = new zzfd(this);
    localzzfd.zzq();
    this.zzapq = localzzfd;
    zzbr localzzbr = new zzbr(this);
    localzzbr.zzq();
    this.zzapp = localzzbr;
    if ((this.zzri.getApplicationContext() instanceof Application))
    {
      zzda localzzda2 = zzgj();
      if ((localzzda2.getContext().getApplicationContext() instanceof Application))
      {
        Application localApplication = (Application)localzzda2.getContext().getApplicationContext();
        if (localzzda2.zzara == null)
          localzzda2.zzara = new zzdu(localzzda2, null);
        localApplication.unregisterActivityLifecycleCallbacks(localzzda2.zzara);
        localApplication.registerActivityLifecycleCallbacks(localzzda2.zzara);
        localzzda2.zzgt().zzjo().zzby("Registered activity lifecycle callback");
      }
    }
    while (true)
    {
      this.zzapp.zzc(new zzbx(this, paramzzcz));
      return;
      zzgt().zzjj().zzby("Application context is not an Application");
    }
  }

  public static zzbw zza(Context paramContext, zzan paramzzan)
  {
    if ((paramzzan != null) && ((paramzzan.origin == null) || (paramzzan.zzadi == null)))
      paramzzan = new zzan(paramzzan.zzade, paramzzan.zzadf, paramzzan.zzadg, paramzzan.zzadh, null, null, paramzzan.zzadj);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (zzapj == null);
    while (true)
    {
      try
      {
        if (zzapj == null)
          zzapj = new zzbw(new zzcz(paramContext, paramzzan));
        return zzapj;
      }
      finally
      {
      }
      if ((paramzzan != null) && (paramzzan.zzadj != null) && (paramzzan.zzadj.containsKey("dataCollectionDefaultEnabled")))
        zzapj.zzd(paramzzan.zzadj.getBoolean("dataCollectionDefaultEnabled"));
    }
  }

  private static void zza(zzcr paramzzcr)
  {
    if (paramzzcr == null)
      throw new IllegalStateException("Component not created");
  }

  private static void zza(zzcs paramzzcs)
  {
    if (paramzzcs == null)
      throw new IllegalStateException("Component not created");
    if (!paramzzcs.isInitialized())
    {
      String str = String.valueOf(paramzzcs.getClass());
      throw new IllegalStateException(27 + String.valueOf(str).length() + "Component not initialized: " + str);
    }
  }

  private final void zza(zzcz paramzzcz)
  {
    zzgs().zzaf();
    zzq.zzhy();
    zzaa localzzaa = new zzaa(this);
    localzzaa.zzq();
    this.zzapz = localzzaa;
    zzam localzzam = new zzam(this);
    localzzam.zzq();
    this.zzaqa = localzzam;
    zzao localzzao = new zzao(this);
    localzzao.zzq();
    this.zzapx = localzzao;
    zzeb localzzeb = new zzeb(this);
    localzzeb.zzq();
    this.zzapy = localzzeb;
    this.zzaps.zzgx();
    this.zzapn.zzgx();
    this.zzaqb = new zzbj(this);
    this.zzaqa.zzgx();
    zzgt().zzjm().zzg("App measurement is starting up, version", Long.valueOf(this.zzapm.zzhh()));
    zzgt().zzjm().zzby("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
    String str1 = localzzam.zzal();
    zzau localzzau;
    String str3;
    if (TextUtils.isEmpty(this.zzadi))
    {
      if (!zzgr().zzcz(str1))
        break label284;
      localzzau = zzgt().zzjm();
      str3 = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
    }
    while (true)
    {
      localzzau.zzby(str3);
      zzgt().zzjn().zzby("Debug-level message logging enabled");
      if (this.zzaqh != this.zzaqi.get())
        zzgt().zzjg().zze("Not all components initialized", Integer.valueOf(this.zzaqh), Integer.valueOf(this.zzaqi.get()));
      this.zzvz = true;
      return;
      label284: localzzau = zzgt().zzjm();
      String str2 = String.valueOf(str1);
      if (str2.length() != 0)
        str3 = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(str2);
      else
        str3 = new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
    }
  }

  private static void zza(zzf paramzzf)
  {
    if (paramzzf == null)
      throw new IllegalStateException("Component not created");
    if (!paramzzf.isInitialized())
    {
      String str = String.valueOf(paramzzf.getClass());
      throw new IllegalStateException(27 + String.valueOf(str).length() + "Component not initialized: " + str);
    }
  }

  private final void zzcl()
  {
    if (!this.zzvz)
      throw new IllegalStateException("AppMeasurement is not initialized");
  }

  public final Context getContext()
  {
    return this.zzri;
  }

  public final boolean isEnabled()
  {
    boolean bool1 = true;
    zzgs().zzaf();
    zzcl();
    if (this.zzapm.zza(zzai.zzale))
      if (!this.zzapm.zzhz());
    while (this.zzapm.zzhz())
    {
      do
      {
        do
          return false;
        while ((this.zzaqg != null) && (this.zzaqg.booleanValue()));
        Boolean localBoolean2 = zzgu().zzjz();
        if (localBoolean2 != null)
          return localBoolean2.booleanValue();
        Boolean localBoolean3 = this.zzapm.zzia();
        if (localBoolean3 != null)
          return localBoolean3.booleanValue();
        if (this.zzaqf != null)
          return this.zzaqf.booleanValue();
      }
      while (GoogleServices.isMeasurementExplicitlyDisabled());
      if ((this.zzapm.zza(zzai.zzala)) && (this.zzaqe != null))
        return this.zzaqe.booleanValue();
      return bool1;
    }
    Boolean localBoolean1 = this.zzapm.zzia();
    boolean bool2;
    if (localBoolean1 != null)
      bool2 = localBoolean1.booleanValue();
    while (true)
    {
      return zzgu().zzh(bool2);
      if (!GoogleServices.isMeasurementExplicitlyDisabled());
      while (true)
      {
        if ((!bool1) || (this.zzaqe == null) || (!((Boolean)zzai.zzala.get()).booleanValue()))
          break label230;
        bool2 = this.zzaqe.booleanValue();
        break;
        bool1 = false;
      }
      label230: bool2 = bool1;
    }
  }

  protected final void start()
  {
    zzgs().zzaf();
    if (zzgu().zzanc.get() == 0L)
      zzgu().zzanc.set(this.zzrz.currentTimeMillis());
    if (Long.valueOf(zzgu().zzanh.get()).longValue() == 0L)
    {
      zzgt().zzjo().zzg("Persisting first open", Long.valueOf(this.zzago));
      zzgu().zzanh.set(this.zzago);
    }
    if (!zzkv())
      if (isEnabled())
      {
        if (!zzgr().zzx("android.permission.INTERNET"))
          zzgt().zzjg().zzby("App is missing INTERNET permission");
        if (!zzgr().zzx("android.permission.ACCESS_NETWORK_STATE"))
          zzgt().zzjg().zzby("App is missing ACCESS_NETWORK_STATE permission");
        if ((!Wrappers.packageManager(this.zzri).isCallerInstantApp()) && (!this.zzapm.zzif()))
        {
          if (!zzbm.zza(this.zzri))
            zzgt().zzjg().zzby("AppMeasurementReceiver not registered/enabled");
          if (!zzfx.zza(this.zzri, false))
            zzgt().zzjg().zzby("AppMeasurementService not registered/enabled");
        }
        zzgt().zzjg().zzby("Uploading is not possible. App measurement disabled");
      }
    do
    {
      return;
      if ((!TextUtils.isEmpty(zzgk().getGmpAppId())) || (!TextUtils.isEmpty(zzgk().zzhb())))
      {
        zzgr();
        if (zzfx.zza(zzgk().getGmpAppId(), zzgu().zzjv(), zzgk().zzhb(), zzgu().zzjw()))
        {
          zzgt().zzjm().zzby("Rechecking which service to use due to a GMP App Id change");
          zzgu().zzjy();
          zzgn().resetAnalyticsData();
          this.zzapy.disconnect();
          this.zzapy.zzdj();
          zzgu().zzanh.set(this.zzago);
          zzgu().zzanj.zzcd(null);
        }
        zzgu().zzcb(zzgk().getGmpAppId());
        zzgu().zzcc(zzgk().zzhb());
        if (this.zzapm.zzbi(zzgk().zzal()))
          this.zzapq.zzaj(this.zzago);
      }
      zzgj().zzcp(zzgu().zzanj.zzkd());
    }
    while ((TextUtils.isEmpty(zzgk().getGmpAppId())) && (TextUtils.isEmpty(zzgk().zzhb())));
    boolean bool1 = isEnabled();
    if ((!zzgu().zzkc()) && (!this.zzapm.zzhz()))
    {
      zzbd localzzbd = zzgu();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      localzzbd.zzi(bool2);
    }
    if ((!this.zzapm.zzba(zzgk().zzal())) || (bool1))
      zzgj().zzld();
    zzgl().zza(new AtomicReference());
  }

  final void zzb(zzcs paramzzcs)
  {
    this.zzaqh = (1 + this.zzaqh);
  }

  final void zzb(zzf paramzzf)
  {
    this.zzaqh = (1 + this.zzaqh);
  }

  public final Clock zzbx()
  {
    return this.zzrz;
  }

  final void zzd(boolean paramBoolean)
  {
    this.zzaqe = Boolean.valueOf(paramBoolean);
  }

  final void zzgf()
  {
    throw new IllegalStateException("Unexpected call on client side");
  }

  final void zzgg()
  {
  }

  public final zza zzgi()
  {
    if (this.zzapw == null)
      throw new IllegalStateException("Component not created");
    return this.zzapw;
  }

  public final zzda zzgj()
  {
    zza(this.zzapv);
    return this.zzapv;
  }

  public final zzam zzgk()
  {
    zza(this.zzaqa);
    return this.zzaqa;
  }

  public final zzeb zzgl()
  {
    zza(this.zzapy);
    return this.zzapy;
  }

  public final zzdy zzgm()
  {
    zza(this.zzapu);
    return this.zzapu;
  }

  public final zzao zzgn()
  {
    zza(this.zzapx);
    return this.zzapx;
  }

  public final zzfd zzgo()
  {
    zza(this.zzapq);
    return this.zzapq;
  }

  public final zzaa zzgp()
  {
    zza(this.zzapz);
    return this.zzapz;
  }

  public final zzaq zzgq()
  {
    zza(this.zzapt);
    return this.zzapt;
  }

  public final zzfx zzgr()
  {
    zza(this.zzaps);
    return this.zzaps;
  }

  public final zzbr zzgs()
  {
    zza(this.zzapp);
    return this.zzapp;
  }

  public final zzas zzgt()
  {
    zza(this.zzapo);
    return this.zzapo;
  }

  public final zzbd zzgu()
  {
    zza(this.zzapn);
    return this.zzapn;
  }

  public final zzq zzgv()
  {
    return this.zzapm;
  }

  public final zzn zzgw()
  {
    return this.zzaih;
  }

  public final zzas zzkj()
  {
    if ((this.zzapo != null) && (this.zzapo.isInitialized()))
      return this.zzapo;
    return null;
  }

  public final zzbj zzkk()
  {
    return this.zzaqb;
  }

  final zzbr zzkl()
  {
    return this.zzapp;
  }

  public final AppMeasurement zzkm()
  {
    return this.zzapr;
  }

  public final boolean zzkn()
  {
    return TextUtils.isEmpty(this.zzadi);
  }

  public final String zzko()
  {
    return this.zzadi;
  }

  public final String zzkp()
  {
    return this.zzapk;
  }

  public final String zzkq()
  {
    return this.zzapl;
  }

  public final boolean zzkr()
  {
    return this.zzadg;
  }

  public final boolean zzks()
  {
    return (this.zzaqe != null) && (this.zzaqe.booleanValue());
  }

  final long zzkt()
  {
    Long localLong = Long.valueOf(zzgu().zzanh.get());
    if (localLong.longValue() == 0L)
      return this.zzago;
    return Math.min(this.zzago, localLong.longValue());
  }

  final void zzku()
  {
    this.zzaqi.incrementAndGet();
  }

  protected final boolean zzkv()
  {
    zzcl();
    zzgs().zzaf();
    if ((this.zzaqc == null) || (this.zzaqd == 0L) || ((this.zzaqc != null) && (!this.zzaqc.booleanValue()) && (Math.abs(this.zzrz.elapsedRealtime() - this.zzaqd) > 1000L)))
    {
      this.zzaqd = this.zzrz.elapsedRealtime();
      if ((!zzgr().zzx("android.permission.INTERNET")) || (!zzgr().zzx("android.permission.ACCESS_NETWORK_STATE")) || ((!Wrappers.packageManager(this.zzri).isCallerInstantApp()) && (!this.zzapm.zzif()) && ((!zzbm.zza(this.zzri)) || (!zzfx.zza(this.zzri, false)))))
        break label237;
    }
    label237: for (boolean bool1 = true; ; bool1 = false)
    {
      this.zzaqc = Boolean.valueOf(bool1);
      if (this.zzaqc.booleanValue())
      {
        boolean bool2;
        if (!zzgr().zzu(zzgk().getGmpAppId(), zzgk().zzhb()))
        {
          boolean bool3 = TextUtils.isEmpty(zzgk().zzhb());
          bool2 = false;
          if (bool3);
        }
        else
        {
          bool2 = true;
        }
        this.zzaqc = Boolean.valueOf(bool2);
      }
      return this.zzaqc.booleanValue();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbw
 * JD-Core Version:    0.6.2
 */