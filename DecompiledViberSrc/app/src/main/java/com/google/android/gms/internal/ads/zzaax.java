package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@zzare
public final class zzaax
{
  private final boolean zzbqn;
  private final int zzcgp;
  private final int zzcgs;
  private final String zzcgt;
  private final String zzcgv;
  private final Bundle zzcgx;
  private final String zzcgz;
  private final boolean zzchb;
  private final int zzchd;
  private final String zzche;
  private final Bundle zzcit;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzciu;
  private final SearchAdRequest zzciv;
  private final Set<String> zzciw;
  private final Set<String> zzcix;
  private final zzdaj zzciy;
  private final Date zzms;
  private final Set<String> zzmu;
  private final Location zzmw;

  public zzaax(zzaay paramzzaay)
  {
    this(paramzzaay, null);
  }

  public zzaax(zzaay paramzzaay, SearchAdRequest paramSearchAdRequest)
  {
    this.zzms = zzaay.zza(paramzzaay);
    this.zzcgv = zzaay.zzb(paramzzaay);
    this.zzcgp = zzaay.zzc(paramzzaay);
    this.zzmu = Collections.unmodifiableSet(zzaay.zzd(paramzzaay));
    this.zzmw = zzaay.zze(paramzzaay);
    this.zzbqn = zzaay.zzf(paramzzaay);
    this.zzcit = zzaay.zzg(paramzzaay);
    this.zzciu = Collections.unmodifiableMap(zzaay.zzh(paramzzaay));
    this.zzcgt = zzaay.zzi(paramzzaay);
    this.zzcgz = zzaay.zzj(paramzzaay);
    this.zzciv = paramSearchAdRequest;
    this.zzcgs = zzaay.zzk(paramzzaay);
    this.zzciw = Collections.unmodifiableSet(zzaay.zzl(paramzzaay));
    this.zzcgx = zzaay.zzm(paramzzaay);
    this.zzcix = Collections.unmodifiableSet(zzaay.zzn(paramzzaay));
    this.zzchb = zzaay.zzo(paramzzaay);
    this.zzciy = null;
    this.zzchd = zzaay.zzp(paramzzaay);
    this.zzche = zzaay.zzq(paramzzaay);
  }

  @Deprecated
  public final Date getBirthday()
  {
    return this.zzms;
  }

  public final String getContentUrl()
  {
    return this.zzcgv;
  }

  public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass)
  {
    Bundle localBundle = this.zzcit.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
    if (localBundle != null)
      return localBundle.getBundle(paramClass.getName());
    return null;
  }

  public final Bundle getCustomTargeting()
  {
    return this.zzcgx;
  }

  @Deprecated
  public final int getGender()
  {
    return this.zzcgp;
  }

  public final Set<String> getKeywords()
  {
    return this.zzmu;
  }

  public final Location getLocation()
  {
    return this.zzmw;
  }

  public final boolean getManualImpressionsEnabled()
  {
    return this.zzbqn;
  }

  public final String getMaxAdContentRating()
  {
    return this.zzche;
  }

  @Deprecated
  public final <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)this.zzciu.get(paramClass);
  }

  public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> paramClass)
  {
    return this.zzcit.getBundle(paramClass.getName());
  }

  public final String getPublisherProvidedId()
  {
    return this.zzcgt;
  }

  @Deprecated
  public final boolean isDesignedForFamilies()
  {
    return this.zzchb;
  }

  public final boolean isTestDevice(Context paramContext)
  {
    Set localSet = this.zzciw;
    zzyr.zzpa();
    return localSet.contains(zzazu.zzbe(paramContext));
  }

  public final String zzpy()
  {
    return this.zzcgz;
  }

  public final SearchAdRequest zzpz()
  {
    return this.zzciv;
  }

  public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqa()
  {
    return this.zzciu;
  }

  public final Bundle zzqb()
  {
    return this.zzcit;
  }

  public final int zzqc()
  {
    return this.zzcgs;
  }

  public final Set<String> zzqd()
  {
    return this.zzcix;
  }

  public final int zzqe()
  {
    return this.zzchd;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaax
 * JD-Core Version:    0.6.2
 */