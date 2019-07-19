package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class zzaay
{
  private boolean zzbqn = false;
  private int zzcgp = -1;
  private int zzcgs = -1;
  private String zzcgt;
  private String zzcgv;
  private final Bundle zzcgx = new Bundle();
  private String zzcgz;
  private boolean zzchb;
  private int zzchd = -1;
  private String zzche;
  private final Bundle zzcit = new Bundle();
  private final HashSet<String> zzciz = new HashSet();
  private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzcja = new HashMap();
  private final HashSet<String> zzcjb = new HashSet();
  private final HashSet<String> zzcjc = new HashSet();
  private Date zzms;
  private Location zzmw;

  public final void setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.zzbqn = paramBoolean;
  }

  public final void zza(Location paramLocation)
  {
    this.zzmw = paramLocation;
  }

  @Deprecated
  public final void zza(NetworkExtras paramNetworkExtras)
  {
    if ((paramNetworkExtras instanceof AdMobExtras))
    {
      zza(AdMobAdapter.class, ((AdMobExtras)paramNetworkExtras).getExtras());
      return;
    }
    this.zzcja.put(paramNetworkExtras.getClass(), paramNetworkExtras);
  }

  public final void zza(Class<? extends MediationExtrasReceiver> paramClass, Bundle paramBundle)
  {
    this.zzcit.putBundle(paramClass.getName(), paramBundle);
  }

  @Deprecated
  public final void zza(Date paramDate)
  {
    this.zzms = paramDate;
  }

  public final void zzb(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
  {
    if (this.zzcit.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null)
      this.zzcit.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
    this.zzcit.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(paramClass.getName(), paramBundle);
  }

  public final void zzbw(String paramString)
  {
    this.zzciz.add(paramString);
  }

  public final void zzbx(String paramString)
  {
    this.zzcjb.add(paramString);
  }

  public final void zzby(String paramString)
  {
    this.zzcjb.remove(paramString);
  }

  public final void zzbz(String paramString)
  {
    this.zzcgv = paramString;
  }

  public final void zzca(String paramString)
  {
    this.zzcgt = paramString;
  }

  public final void zzcb(String paramString)
  {
    this.zzcgz = paramString;
  }

  public final void zzcc(String paramString)
  {
    this.zzcjc.add(paramString);
  }

  public final void zzcd(String paramString)
  {
    if (("G".equals(paramString)) || ("PG".equals(paramString)) || ("T".equals(paramString)) || ("MA".equals(paramString)))
      this.zzche = paramString;
  }

  @Deprecated
  public final void zzcn(int paramInt)
  {
    this.zzcgp = paramInt;
  }

  public final void zzco(int paramInt)
  {
    if ((paramInt == -1) || (paramInt == 0) || (paramInt == 1))
      this.zzchd = paramInt;
  }

  public final void zze(String paramString1, String paramString2)
  {
    this.zzcgx.putString(paramString1, paramString2);
  }

  public final void zzt(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      this.zzcgs = i;
      return;
    }
  }

  @Deprecated
  public final void zzu(boolean paramBoolean)
  {
    this.zzchb = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaay
 * JD-Core Version:    0.6.2
 */