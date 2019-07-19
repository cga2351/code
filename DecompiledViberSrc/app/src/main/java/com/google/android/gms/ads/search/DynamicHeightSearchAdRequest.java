package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzaax;

public final class DynamicHeightSearchAdRequest
{
  private final SearchAdRequest zzgnv;

  private DynamicHeightSearchAdRequest(Builder paramBuilder)
  {
    this.zzgnv = Builder.zza(paramBuilder).build();
  }

  public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.zzgnv.getCustomEventExtrasBundle(paramClass);
  }

  @Deprecated
  public final <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.zzgnv.getNetworkExtras(paramClass);
  }

  public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.zzgnv.getNetworkExtrasBundle(paramClass);
  }

  public final String getQuery()
  {
    return this.zzgnv.getQuery();
  }

  public final boolean isTestDevice(Context paramContext)
  {
    return this.zzgnv.isTestDevice(paramContext);
  }

  final zzaax zzde()
  {
    return this.zzgnv.zzde();
  }

  public static final class Builder
  {
    private final SearchAdRequest.Builder zzgnw = new SearchAdRequest.Builder();
    private final Bundle zzgnx = new Bundle();

    public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.zzgnw.addCustomEventExtrasBundle(paramClass, paramBundle);
      return this;
    }

    public final Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.zzgnw.addNetworkExtras(paramNetworkExtras);
      return this;
    }

    public final Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.zzgnw.addNetworkExtrasBundle(paramClass, paramBundle);
      return this;
    }

    public final DynamicHeightSearchAdRequest build()
    {
      this.zzgnw.addNetworkExtrasBundle(AdMobAdapter.class, this.zzgnx);
      return new DynamicHeightSearchAdRequest(this, null);
    }

    public final Builder setAdBorderSelectors(String paramString)
    {
      this.zzgnx.putString("csa_adBorderSelectors", paramString);
      return this;
    }

    public final Builder setAdTest(boolean paramBoolean)
    {
      Bundle localBundle = this.zzgnx;
      if (paramBoolean);
      for (String str = "on"; ; str = "off")
      {
        localBundle.putString("csa_adtest", str);
        return this;
      }
    }

    public final Builder setAdjustableLineHeight(int paramInt)
    {
      this.zzgnx.putString("csa_adjustableLineHeight", Integer.toString(paramInt));
      return this;
    }

    public final Builder setAdvancedOptionValue(String paramString1, String paramString2)
    {
      this.zzgnx.putString(paramString1, paramString2);
      return this;
    }

    public final Builder setAttributionSpacingBelow(int paramInt)
    {
      this.zzgnx.putString("csa_attributionSpacingBelow", Integer.toString(paramInt));
      return this;
    }

    public final Builder setBorderSelections(String paramString)
    {
      this.zzgnx.putString("csa_borderSelections", paramString);
      return this;
    }

    public final Builder setChannel(String paramString)
    {
      this.zzgnx.putString("csa_channel", paramString);
      return this;
    }

    public final Builder setColorAdBorder(String paramString)
    {
      this.zzgnx.putString("csa_colorAdBorder", paramString);
      return this;
    }

    public final Builder setColorAdSeparator(String paramString)
    {
      this.zzgnx.putString("csa_colorAdSeparator", paramString);
      return this;
    }

    public final Builder setColorAnnotation(String paramString)
    {
      this.zzgnx.putString("csa_colorAnnotation", paramString);
      return this;
    }

    public final Builder setColorAttribution(String paramString)
    {
      this.zzgnx.putString("csa_colorAttribution", paramString);
      return this;
    }

    public final Builder setColorBackground(String paramString)
    {
      this.zzgnx.putString("csa_colorBackground", paramString);
      return this;
    }

    public final Builder setColorBorder(String paramString)
    {
      this.zzgnx.putString("csa_colorBorder", paramString);
      return this;
    }

    public final Builder setColorDomainLink(String paramString)
    {
      this.zzgnx.putString("csa_colorDomainLink", paramString);
      return this;
    }

    public final Builder setColorText(String paramString)
    {
      this.zzgnx.putString("csa_colorText", paramString);
      return this;
    }

    public final Builder setColorTitleLink(String paramString)
    {
      this.zzgnx.putString("csa_colorTitleLink", paramString);
      return this;
    }

    public final Builder setCssWidth(int paramInt)
    {
      this.zzgnx.putString("csa_width", Integer.toString(paramInt));
      return this;
    }

    public final Builder setDetailedAttribution(boolean paramBoolean)
    {
      this.zzgnx.putString("csa_detailedAttribution", Boolean.toString(paramBoolean));
      return this;
    }

    public final Builder setFontFamily(String paramString)
    {
      this.zzgnx.putString("csa_fontFamily", paramString);
      return this;
    }

    public final Builder setFontFamilyAttribution(String paramString)
    {
      this.zzgnx.putString("csa_fontFamilyAttribution", paramString);
      return this;
    }

    public final Builder setFontSizeAnnotation(int paramInt)
    {
      this.zzgnx.putString("csa_fontSizeAnnotation", Integer.toString(paramInt));
      return this;
    }

    public final Builder setFontSizeAttribution(int paramInt)
    {
      this.zzgnx.putString("csa_fontSizeAttribution", Integer.toString(paramInt));
      return this;
    }

    public final Builder setFontSizeDescription(int paramInt)
    {
      this.zzgnx.putString("csa_fontSizeDescription", Integer.toString(paramInt));
      return this;
    }

    public final Builder setFontSizeDomainLink(int paramInt)
    {
      this.zzgnx.putString("csa_fontSizeDomainLink", Integer.toString(paramInt));
      return this;
    }

    public final Builder setFontSizeTitle(int paramInt)
    {
      this.zzgnx.putString("csa_fontSizeTitle", Integer.toString(paramInt));
      return this;
    }

    public final Builder setHostLanguage(String paramString)
    {
      this.zzgnx.putString("csa_hl", paramString);
      return this;
    }

    public final Builder setIsClickToCallEnabled(boolean paramBoolean)
    {
      this.zzgnx.putString("csa_clickToCall", Boolean.toString(paramBoolean));
      return this;
    }

    public final Builder setIsLocationEnabled(boolean paramBoolean)
    {
      this.zzgnx.putString("csa_location", Boolean.toString(paramBoolean));
      return this;
    }

    public final Builder setIsPlusOnesEnabled(boolean paramBoolean)
    {
      this.zzgnx.putString("csa_plusOnes", Boolean.toString(paramBoolean));
      return this;
    }

    public final Builder setIsSellerRatingsEnabled(boolean paramBoolean)
    {
      this.zzgnx.putString("csa_sellerRatings", Boolean.toString(paramBoolean));
      return this;
    }

    public final Builder setIsSiteLinksEnabled(boolean paramBoolean)
    {
      this.zzgnx.putString("csa_siteLinks", Boolean.toString(paramBoolean));
      return this;
    }

    public final Builder setIsTitleBold(boolean paramBoolean)
    {
      this.zzgnx.putString("csa_titleBold", Boolean.toString(paramBoolean));
      return this;
    }

    public final Builder setIsTitleUnderlined(boolean paramBoolean)
    {
      Bundle localBundle = this.zzgnx;
      if (!paramBoolean);
      for (boolean bool = true; ; bool = false)
      {
        localBundle.putString("csa_noTitleUnderline", Boolean.toString(bool));
        return this;
      }
    }

    public final Builder setLocationColor(String paramString)
    {
      this.zzgnx.putString("csa_colorLocation", paramString);
      return this;
    }

    public final Builder setLocationFontSize(int paramInt)
    {
      this.zzgnx.putString("csa_fontSizeLocation", Integer.toString(paramInt));
      return this;
    }

    public final Builder setLongerHeadlines(boolean paramBoolean)
    {
      this.zzgnx.putString("csa_longerHeadlines", Boolean.toString(paramBoolean));
      return this;
    }

    public final Builder setNumber(int paramInt)
    {
      this.zzgnx.putString("csa_number", Integer.toString(paramInt));
      return this;
    }

    public final Builder setPage(int paramInt)
    {
      this.zzgnx.putString("csa_adPage", Integer.toString(paramInt));
      return this;
    }

    public final Builder setQuery(String paramString)
    {
      this.zzgnw.setQuery(paramString);
      return this;
    }

    public final Builder setVerticalSpacing(int paramInt)
    {
      this.zzgnx.putString("csa_verticalSpacing", Integer.toString(paramInt));
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.search.DynamicHeightSearchAdRequest
 * JD-Core Version:    0.6.2
 */