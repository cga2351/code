package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaax;
import com.google.android.gms.internal.ads.zzaay;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.Set;

@VisibleForTesting
public final class AdRequest
{
  public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN = 0;
  public static final String MAX_AD_CONTENT_RATING_G = "G";
  public static final String MAX_AD_CONTENT_RATING_MA = "MA";
  public static final String MAX_AD_CONTENT_RATING_PG = "PG";
  public static final String MAX_AD_CONTENT_RATING_T = "T";
  public static final int MAX_CONTENT_URL_LENGTH = 512;
  public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
  public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
  public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
  private final zzaax zzaam;

  private AdRequest(Builder paramBuilder)
  {
    this.zzaam = new zzaax(Builder.zza(paramBuilder));
  }

  @Deprecated
  public final Date getBirthday()
  {
    return this.zzaam.getBirthday();
  }

  public final String getContentUrl()
  {
    return this.zzaam.getContentUrl();
  }

  public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.zzaam.getCustomEventExtrasBundle(paramClass);
  }

  @Deprecated
  public final int getGender()
  {
    return this.zzaam.getGender();
  }

  public final Set<String> getKeywords()
  {
    return this.zzaam.getKeywords();
  }

  public final Location getLocation()
  {
    return this.zzaam.getLocation();
  }

  @Deprecated
  public final <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.zzaam.getNetworkExtras(paramClass);
  }

  public final <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.zzaam.getNetworkExtrasBundle(paramClass);
  }

  public final boolean isTestDevice(Context paramContext)
  {
    return this.zzaam.isTestDevice(paramContext);
  }

  public final zzaax zzde()
  {
    return this.zzaam;
  }

  @VisibleForTesting
  public static final class Builder
  {
    private final zzaay zzaan = new zzaay();

    public Builder()
    {
      this.zzaan.zzbx("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.zzaan.zzb(paramClass, paramBundle);
      return this;
    }

    public final Builder addKeyword(String paramString)
    {
      this.zzaan.zzbw(paramString);
      return this;
    }

    public final Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.zzaan.zza(paramNetworkExtras);
      return this;
    }

    public final Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> paramClass, Bundle paramBundle)
    {
      this.zzaan.zza(paramClass, paramBundle);
      if ((paramClass.equals(AdMobAdapter.class)) && (paramBundle.getBoolean("_emulatorLiveAds")))
        this.zzaan.zzby("B3EEABB8EE11C2BE770B684D95219ECB");
      return this;
    }

    public final Builder addTestDevice(String paramString)
    {
      this.zzaan.zzbx(paramString);
      return this;
    }

    public final AdRequest build()
    {
      return new AdRequest(this, null);
    }

    @Deprecated
    public final Builder setBirthday(Date paramDate)
    {
      this.zzaan.zza(paramDate);
      return this;
    }

    public final Builder setContentUrl(String paramString)
    {
      Preconditions.checkNotNull(paramString, "Content URL must be non-null.");
      Preconditions.checkNotEmpty(paramString, "Content URL must be non-empty.");
      if (paramString.length() <= 512);
      for (boolean bool = true; ; bool = false)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(512);
        arrayOfObject[1] = Integer.valueOf(paramString.length());
        Preconditions.checkArgument(bool, "Content URL must not exceed %d in length.  Provided length was %d.", arrayOfObject);
        this.zzaan.zzbz(paramString);
        return this;
      }
    }

    @Deprecated
    public final Builder setGender(int paramInt)
    {
      this.zzaan.zzcn(paramInt);
      return this;
    }

    @Deprecated
    public final Builder setIsDesignedForFamilies(boolean paramBoolean)
    {
      this.zzaan.zzu(paramBoolean);
      return this;
    }

    public final Builder setLocation(Location paramLocation)
    {
      this.zzaan.zza(paramLocation);
      return this;
    }

    public final Builder setMaxAdContentRating(String paramString)
    {
      this.zzaan.zzcd(paramString);
      return this;
    }

    public final Builder setRequestAgent(String paramString)
    {
      this.zzaan.zzcb(paramString);
      return this;
    }

    public final Builder setTagForUnderAgeOfConsent(int paramInt)
    {
      this.zzaan.zzco(paramInt);
      return this;
    }

    public final Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.zzaan.zzt(paramBoolean);
      return this;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface MaxAdContentRating
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface TagForUnderAgeOfConsent
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdRequest
 * JD-Core Version:    0.6.2
 */