package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationAdConfiguration
{
  public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
  public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
  public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
  private final String zzche;
  private final int zzdgc;
  private final String zzemw;
  private final Bundle zzemx;
  private final Bundle zzemy;
  private final int zzemz;
  private final Context zzlj;
  private final boolean zzmv;
  private final Location zzmw;

  public MediationAdConfiguration(Context paramContext, String paramString1, Bundle paramBundle1, Bundle paramBundle2, boolean paramBoolean, @Nullable Location paramLocation, int paramInt1, int paramInt2, @Nullable String paramString2)
  {
    this.zzemw = paramString1;
    this.zzemx = paramBundle1;
    this.zzemy = paramBundle2;
    this.zzlj = paramContext;
    this.zzmv = paramBoolean;
    this.zzmw = paramLocation;
    this.zzdgc = paramInt1;
    this.zzemz = paramInt2;
    this.zzche = paramString2;
  }

  public String getBidResponse()
  {
    return this.zzemw;
  }

  public Context getContext()
  {
    return this.zzlj;
  }

  public Location getLocation()
  {
    return this.zzmw;
  }

  @Nullable
  public String getMaxAdContentRating()
  {
    return this.zzche;
  }

  public Bundle getMediationExtras()
  {
    return this.zzemy;
  }

  public Bundle getServerParameters()
  {
    return this.zzemx;
  }

  public boolean isTestRequest()
  {
    return this.zzmv;
  }

  public int taggedForChildDirectedTreatment()
  {
    return this.zzdgc;
  }

  public int taggedForUnderAgeTreatment()
  {
    return this.zzemz;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface TagForChildDirectedTreatment
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationAdConfiguration
 * JD-Core Version:    0.6.2
 */