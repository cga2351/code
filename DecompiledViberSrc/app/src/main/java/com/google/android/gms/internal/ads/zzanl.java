package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzare
public final class zzanl
  implements MediationAdRequest
{
  private final int zzcgp;
  private final boolean zzchb;
  private final String zzche;
  private final int zzdgc;
  private final int zzdgd;
  private final Date zzms;
  private final Set<String> zzmu;
  private final boolean zzmv;
  private final Location zzmw;

  public zzanl(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, String paramString)
  {
    this.zzms = paramDate;
    this.zzcgp = paramInt1;
    this.zzmu = paramSet;
    this.zzmw = paramLocation;
    this.zzmv = paramBoolean1;
    this.zzdgc = paramInt2;
    this.zzchb = paramBoolean2;
    this.zzdgd = paramInt3;
    this.zzche = paramString;
  }

  @Deprecated
  public final Date getBirthday()
  {
    return this.zzms;
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

  @Deprecated
  public final boolean isDesignedForFamilies()
  {
    return this.zzchb;
  }

  public final boolean isTesting()
  {
    return this.zzmv;
  }

  public final int taggedForChildDirectedTreatment()
  {
    return this.zzdgc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanl
 * JD-Core Version:    0.6.2
 */