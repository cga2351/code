package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbtu
{
  private final Set<zzbuy<zzxp>> zzfko;
  private final Set<zzbuy<zzbrk>> zzfkp;
  private final Set<zzbuy<zzbrv>> zzfkq;
  private final Set<zzbuy<zzbsq>> zzfkr;
  private final Set<zzbuy<zzbrn>> zzfks;
  private final Set<zzbuy<zzbrr>> zzfkt;
  private final Set<zzbuy<AdMetadataListener>> zzfku;
  private final Set<zzbuy<AppEventListener>> zzfkv;
  private zzbrl zzfkw;
  private zzcmt zzfkx;

  private zzbtu(zza paramzza)
  {
    this.zzfko = zza.zza(paramzza);
    this.zzfkq = zza.zzb(paramzza);
    this.zzfkp = zza.zzc(paramzza);
    this.zzfkr = zza.zzd(paramzza);
    this.zzfks = zza.zze(paramzza);
    this.zzfkt = zza.zzf(paramzza);
    this.zzfku = zza.zzg(paramzza);
    this.zzfkv = zza.zzh(paramzza);
  }

  public final zzcmt zza(Clock paramClock)
  {
    if (this.zzfkx == null)
      this.zzfkx = new zzcmt(paramClock);
    return this.zzfkx;
  }

  public final Set<zzbuy<zzbrk>> zzagl()
  {
    return this.zzfkp;
  }

  public final Set<zzbuy<zzbsq>> zzagm()
  {
    return this.zzfkr;
  }

  public final Set<zzbuy<zzbrn>> zzagn()
  {
    return this.zzfks;
  }

  public final Set<zzbuy<zzbrr>> zzago()
  {
    return this.zzfkt;
  }

  public final Set<zzbuy<AdMetadataListener>> zzagp()
  {
    return this.zzfku;
  }

  public final Set<zzbuy<AppEventListener>> zzagq()
  {
    return this.zzfkv;
  }

  public final Set<zzbuy<zzxp>> zzagr()
  {
    return this.zzfko;
  }

  public final Set<zzbuy<zzbrv>> zzags()
  {
    return this.zzfkq;
  }

  public final zzbrl zzc(Set<zzbuy<zzbrn>> paramSet)
  {
    if (this.zzfkw == null)
      this.zzfkw = new zzbrl(paramSet);
    return this.zzfkw;
  }

  public static final class zza
  {
    private Set<zzbuy<zzxp>> zzfko = new HashSet();
    private Set<zzbuy<zzbrk>> zzfkp = new HashSet();
    private Set<zzbuy<zzbrv>> zzfkq = new HashSet();
    private Set<zzbuy<zzbsq>> zzfkr = new HashSet();
    private Set<zzbuy<zzbrn>> zzfks = new HashSet();
    private Set<zzbuy<zzbrr>> zzfkt = new HashSet();
    private Set<zzbuy<AdMetadataListener>> zzfku = new HashSet();
    private Set<zzbuy<AppEventListener>> zzfkv = new HashSet();

    public final zza zza(AppEventListener paramAppEventListener, Executor paramExecutor)
    {
      this.zzfkv.add(new zzbuy(paramAppEventListener, paramExecutor));
      return this;
    }

    public final zza zza(AdMetadataListener paramAdMetadataListener, Executor paramExecutor)
    {
      this.zzfku.add(new zzbuy(paramAdMetadataListener, paramExecutor));
      return this;
    }

    public final zza zza(zzbrk paramzzbrk, Executor paramExecutor)
    {
      this.zzfkp.add(new zzbuy(paramzzbrk, paramExecutor));
      return this;
    }

    public final zza zza(zzbrn paramzzbrn, Executor paramExecutor)
    {
      this.zzfks.add(new zzbuy(paramzzbrn, paramExecutor));
      return this;
    }

    public final zza zza(zzbrr paramzzbrr, Executor paramExecutor)
    {
      this.zzfkt.add(new zzbuy(paramzzbrr, paramExecutor));
      return this;
    }

    public final zza zza(zzbrv paramzzbrv, Executor paramExecutor)
    {
      this.zzfkq.add(new zzbuy(paramzzbrv, paramExecutor));
      return this;
    }

    public final zza zza(zzbsq paramzzbsq, Executor paramExecutor)
    {
      this.zzfkr.add(new zzbuy(paramzzbsq, paramExecutor));
      return this;
    }

    public final zza zza(zzxp paramzzxp, Executor paramExecutor)
    {
      this.zzfko.add(new zzbuy(paramzzxp, paramExecutor));
      return this;
    }

    public final zza zza(zzzq paramzzzq, Executor paramExecutor)
    {
      if (this.zzfkv != null)
      {
        zzcpx localzzcpx = new zzcpx();
        localzzcpx.zzb(paramzzzq);
        this.zzfkv.add(new zzbuy(localzzcpx, paramExecutor));
      }
      return this;
    }

    public final zzbtu zzagt()
    {
      return new zzbtu(this, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbtu
 * JD-Core Version:    0.6.2
 */