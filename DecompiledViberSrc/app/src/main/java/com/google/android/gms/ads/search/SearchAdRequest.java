package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzaax;
import com.google.android.gms.internal.ads.zzaay;

@Deprecated
public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final zzaax zzaam;
  private final String zzckg;

  private SearchAdRequest(Builder paramBuilder)
  {
    this.zzckg = Builder.zza(paramBuilder);
    this.zzaam = new zzaax(Builder.zzb(paramBuilder), this);
  }

  @Deprecated
  public final int getAnchorTextColor()
  {
    return 0;
  }

  @Deprecated
  public final int getBackgroundColor()
  {
    return 0;
  }

  @Deprecated
  public final int getBackgroundGradientBottom()
  {
    return 0;
  }

  @Deprecated
  public final int getBackgroundGradientTop()
  {
    return 0;
  }

  @Deprecated
  public final int getBorderColor()
  {
    return 0;
  }

  @Deprecated
  public final int getBorderThickness()
  {
    return 0;
  }

  @Deprecated
  public final int getBorderType()
  {
    return 0;
  }

  @Deprecated
  public final int getCallButtonColor()
  {
    return 0;
  }

  @Deprecated
  public final String getCustomChannels()
  {
    return null;
  }

  public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.zzaam.getCustomEventExtrasBundle(paramClass);
  }

  @Deprecated
  public final int getDescriptionTextColor()
  {
    return 0;
  }

  @Deprecated
  public final String getFontFace()
  {
    return null;
  }

  @Deprecated
  public final int getHeaderTextColor()
  {
    return 0;
  }

  @Deprecated
  public final int getHeaderTextSize()
  {
    return 0;
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

  public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.zzaam.getNetworkExtrasBundle(paramClass);
  }

  public final String getQuery()
  {
    return this.zzckg;
  }

  public final boolean isTestDevice(Context paramContext)
  {
    return this.zzaam.isTestDevice(paramContext);
  }

  final zzaax zzde()
  {
    return this.zzaam;
  }

  public static final class Builder
  {
    private final zzaay zzaan = new zzaay();
    private String zzckg;

    public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.zzaan.zzb(paramClass, paramBundle);
      return this;
    }

    public final Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.zzaan.zza(paramNetworkExtras);
      return this;
    }

    public final Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.zzaan.zza(paramClass, paramBundle);
      return this;
    }

    public final Builder addTestDevice(String paramString)
    {
      this.zzaan.zzbx(paramString);
      return this;
    }

    public final SearchAdRequest build()
    {
      return new SearchAdRequest(this, null);
    }

    @Deprecated
    public final Builder setAnchorTextColor(int paramInt)
    {
      return this;
    }

    @Deprecated
    public final Builder setBackgroundColor(int paramInt)
    {
      return this;
    }

    @Deprecated
    public final Builder setBackgroundGradient(int paramInt1, int paramInt2)
    {
      return this;
    }

    @Deprecated
    public final Builder setBorderColor(int paramInt)
    {
      return this;
    }

    @Deprecated
    public final Builder setBorderThickness(int paramInt)
    {
      return this;
    }

    @Deprecated
    public final Builder setBorderType(int paramInt)
    {
      return this;
    }

    @Deprecated
    public final Builder setCallButtonColor(int paramInt)
    {
      return this;
    }

    @Deprecated
    public final Builder setCustomChannels(String paramString)
    {
      return this;
    }

    @Deprecated
    public final Builder setDescriptionTextColor(int paramInt)
    {
      return this;
    }

    @Deprecated
    public final Builder setFontFace(String paramString)
    {
      return this;
    }

    @Deprecated
    public final Builder setHeaderTextColor(int paramInt)
    {
      return this;
    }

    @Deprecated
    public final Builder setHeaderTextSize(int paramInt)
    {
      return this;
    }

    public final Builder setLocation(Location paramLocation)
    {
      this.zzaan.zza(paramLocation);
      return this;
    }

    public final Builder setQuery(String paramString)
    {
      this.zzckg = paramString;
      return this;
    }

    public final Builder setRequestAgent(String paramString)
    {
      this.zzaan.zzcb(paramString);
      return this;
    }

    public final Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.zzaan.zzt(paramBoolean);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.search.SearchAdRequest
 * JD-Core Version:    0.6.2
 */