package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcga
{
  private final Executor zzffu;
  private final Executor zzfiv;
  private final ScheduledExecutorService zzfkf;
  private boolean zzfuz = false;
  private boolean zzfva = false;
  private final long zzfvb;
  private final zzbbs<Boolean> zzfvc = new zzbbs();
  private final zzclb zzfvd;
  private Map<String, zzain> zzfve = new ConcurrentHashMap();
  private final Context zzlj;

  public zzcga(Executor paramExecutor1, Context paramContext, Executor paramExecutor2, zzclb paramzzclb, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzfvd = paramzzclb;
    this.zzlj = paramContext;
    this.zzfiv = paramExecutor2;
    this.zzfkf = paramScheduledExecutorService;
    this.zzffu = paramExecutor1;
    this.zzfvb = zzk.zzln().elapsedRealtime();
    zza("com.google.android.gms.ads.MobileAds", false, "", 0);
  }

  private final void zza(String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    this.zzfve.put(paramString1, new zzain(paramString1, paramBoolean, paramInt, paramString2));
  }

  private final void zzajz()
  {
    try
    {
      if (!this.zzfva)
      {
        zzk.zzlk().zzvc().zzb(new zzcgd(this));
        this.zzfva = true;
        ScheduledExecutorService localScheduledExecutorService = this.zzfkf;
        zzcge localzzcge = new zzcge(this);
        zzaci localzzaci = zzact.zzcrb;
        localScheduledExecutorService.schedule(localzzcge, ((Long)zzyr.zzpe().zzd(localzzaci)).longValue(), TimeUnit.SECONDS);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzajx()
  {
    zzaci localzzaci = zzact.zzcqz;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
    while (this.zzfuz)
      return;
    try
    {
      if (this.zzfuz)
        return;
    }
    finally
    {
    }
    String str = zzk.zzlk().zzvc().zzvr().zzus();
    if (TextUtils.isEmpty(str))
    {
      zzajz();
      return;
    }
    this.zzfuz = true;
    zza("com.google.android.gms.ads.MobileAds", true, "", (int)(zzk.zzln().elapsedRealtime() - this.zzfvb));
    this.zzfiv.execute(new zzcgc(this, str));
  }

  public final List<zzain> zzajy()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzfve.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zzain localzzain = (zzain)this.zzfve.get(str);
      localArrayList.add(new zzain(str, localzzain.zzdbb, localzzain.zzdbc, localzzain.description));
    }
    return localArrayList;
  }

  public final void zzb(zzais paramzzais)
  {
    this.zzfvc.zza(new zzcgb(this, paramzzais), this.zzffu);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcga
 * JD-Core Version:    0.6.2
 */