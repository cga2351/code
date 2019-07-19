package com.google.android.gms.ads.mediation;

import android.location.Location;
import java.util.Date;
import java.util.Set;

public abstract interface MediationAdRequest
{
  public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
  public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
  public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;

  @Deprecated
  public abstract Date getBirthday();

  @Deprecated
  public abstract int getGender();

  public abstract Set<String> getKeywords();

  public abstract Location getLocation();

  @Deprecated
  public abstract boolean isDesignedForFamilies();

  public abstract boolean isTesting();

  public abstract int taggedForChildDirectedTreatment();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationAdRequest
 * JD-Core Version:    0.6.2
 */