package com.viber.voip.banner.datatype;

import android.text.TextUtils;
import com.google.d.a.c;
import com.viber.voip.ads.d.p;
import java.util.Arrays;

public final class AdsCallMetaInfo
{

  @c(a="alternateAdsConfig")
  private AltAdsConfig mAltAdsConfig;

  @c(a="ads")
  private AdsAfterCallMetaInfoItem[] mItems;

  public AdsCallMetaInfo(AltAdsConfig paramAltAdsConfig)
  {
    this.mAltAdsConfig = paramAltAdsConfig;
  }

  public AltAdsConfig getAltAdsConfig()
  {
    return this.mAltAdsConfig;
  }

  public AdsAfterCallMetaInfoItem getItem(int paramInt)
  {
    if ((this.mItems == null) || (paramInt >= this.mItems.length))
      return null;
    return this.mItems[paramInt];
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("AdsCallMetaInfo{");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("mItems=");
    if (this.mItems == null);
    for (String str = "null"; ; str = Arrays.asList(this.mItems).toString())
    {
      localStringBuilder2.append(str);
      localStringBuilder1.append(", mAltAdsConfig=").append(this.mAltAdsConfig);
      localStringBuilder1.append('}');
      return localStringBuilder1.toString();
    }
  }

  public static final class AdsAfterCallMetaInfoItem
  {
    public static final String EMPTY_ID = "0";
    private static final String YAHOO_FLURRY_KEYWORD = "flurry";
    private static final String YOUR_AD_CHOICES_KEYWORD = "criteo";

    @c(a="adType")
    private String mAdType;

    @c(a="reportClickUrls")
    private String[] mClickUrls;

    @c(a="ctaText")
    private String mCtaText;

    @c(a="htmlContent")
    private String mHtmlContent;

    @c(a="id")
    private String mId;

    @c(a="imageUrl")
    private String mImageUrl;

    @c(a="impressionUrls")
    private String[] mImpressionUrls;

    @c(a="landingUrl")
    private String mLandingUrl;

    @c(a="promotedByTag")
    private String mPromotedByTag;

    @c(a="adProviderIconUrl")
    private String mProviderIconUrl;

    @c(a="adProvider")
    private String mProviderName;

    @c(a="adProviderTargetUrl")
    private String mProviderTargetUrl;

    @c(a="sessionId")
    private String mSessionId;

    @c(a="text")
    private String mText;

    @c(a="timer")
    private Long mTimer;

    @c(a="title")
    private String mTitle;

    @c(a="ttl")
    private Long mTtl;

    @c(a="viewUrls")
    private String[] mViewUrls;

    public String getAdType()
    {
      return this.mAdType;
    }

    public String[] getClickUrls()
    {
      if (this.mClickUrls == null)
        return null;
      return (String[])Arrays.copyOf(this.mClickUrls, this.mClickUrls.length);
    }

    public String getCtaText()
    {
      return this.mCtaText;
    }

    public String getHtmlContent()
    {
      return this.mHtmlContent;
    }

    public String getId()
    {
      return this.mId;
    }

    public String getImageUrl()
    {
      return this.mImageUrl;
    }

    public String[] getImpressionUrls()
    {
      if (this.mImpressionUrls == null)
        return null;
      return (String[])Arrays.copyOf(this.mImpressionUrls, this.mImpressionUrls.length);
    }

    public String getLandingUrl()
    {
      return this.mLandingUrl;
    }

    public String getPromotedByTag()
    {
      return this.mPromotedByTag;
    }

    public String getProviderIconUrl()
    {
      return this.mProviderIconUrl;
    }

    public String getProviderName()
    {
      if (TextUtils.isEmpty(this.mProviderName))
        return "not received";
      return this.mProviderName;
    }

    public String getProviderTargetUrl()
    {
      return this.mProviderTargetUrl;
    }

    public String getSessionId()
    {
      return this.mSessionId;
    }

    public String getText()
    {
      return this.mText;
    }

    public long getTimer()
    {
      if (this.mTimer == null)
        return 0L;
      return this.mTimer.longValue();
    }

    public String getTitle()
    {
      return this.mTitle;
    }

    public long getTtl()
    {
      if (this.mTtl == null)
        return 0L;
      return this.mTtl.longValue();
    }

    public String[] getViewUrls()
    {
      if (this.mViewUrls == null)
        return null;
      return (String[])Arrays.copyOf(this.mViewUrls, this.mViewUrls.length);
    }

    public boolean hasId()
    {
      return !TextUtils.isEmpty(this.mId);
    }

    public void removeTtl()
    {
      this.mTtl = null;
    }

    public void setLandingUrl(String paramString)
    {
      this.mLandingUrl = paramString;
    }

    public boolean shouldShowProviderIcon()
    {
      return !TextUtils.isEmpty(this.mProviderIconUrl);
    }

    public String toString()
    {
      return "AdsAfterCallMetaInfoItem{mId='" + this.mId + '\'' + ", mTitle='" + this.mTitle + '\'' + ", mText='" + this.mText + '\'' + ", mPromotedByTag='" + this.mPromotedByTag + '\'' + ", mCtaText='" + this.mCtaText + '\'' + ", mImageUrl='" + this.mImageUrl + '\'' + ", mImpressionUrls=" + Arrays.toString(this.mImpressionUrls) + ", mViewUrls=" + Arrays.toString(this.mViewUrls) + ", mClickUrls=" + Arrays.toString(this.mClickUrls) + ", mLandingUrl='" + this.mLandingUrl + '\'' + ", mAdType='" + this.mAdType + '\'' + ", mSessionId='" + this.mSessionId + '\'' + ", mTimer=" + this.mTimer + ", mTtl=" + this.mTtl + ", mProviderName='" + this.mProviderName + '\'' + ", mProviderIconUrl='" + this.mProviderIconUrl + '\'' + ", mProviderTargetUrl=;" + this.mProviderTargetUrl + '\'' + ", mHtmlContent='" + this.mHtmlContent + '\'' + '}';
    }
  }

  public static class AltAdsConfig
  {

    @c(a="adMobAdUnitId")
    private String mAdUnitId;

    @c(a="promotedByTag")
    private String mPromotedByTag;

    @c(a="showAlternateAds")
    private boolean mShowAlternateAds;

    @c(a="timer")
    private Long mTimer;

    public AltAdsConfig(boolean paramBoolean, String paramString1, Long paramLong, String paramString2)
    {
      this.mShowAlternateAds = paramBoolean;
      this.mPromotedByTag = paramString1;
      this.mTimer = paramLong;
      this.mAdUnitId = paramString2;
    }

    public String getAdUnitId()
    {
      return this.mAdUnitId;
    }

    public String getPromotedByTag()
    {
      return this.mPromotedByTag;
    }

    public Long getTimer()
    {
      return this.mTimer;
    }

    public boolean showAlternateAds()
    {
      return this.mShowAlternateAds;
    }

    public String toString()
    {
      return "AltAdsConfig{mShowAlternateAds=" + this.mShowAlternateAds + ", mPromotedByTag='" + this.mPromotedByTag + '\'' + ", mTimer=" + this.mTimer + ", mAdUnitId='" + this.mAdUnitId + '\'' + '}';
    }
  }

  public static class CustomAdsNativesConfig extends AdsCallMetaInfo.AltAdsConfig
  {
    private final String mAdsNativeAdUnitId;
    private final String mAdsNativeGoogleAdUnitId;

    public CustomAdsNativesConfig(String paramString1, String paramString2)
    {
      super("Sponsored", Long.valueOf(p.a), "");
      this.mAdsNativeAdUnitId = paramString1;
      this.mAdsNativeGoogleAdUnitId = paramString2;
    }

    public String getAdsNativeAdUnitId()
    {
      return this.mAdsNativeAdUnitId;
    }

    public String getAdsNativeGoogleAdUnitId()
    {
      return this.mAdsNativeGoogleAdUnitId;
    }
  }

  public static class CustomAppNexusConfig extends AdsCallMetaInfo.AltAdsConfig
  {
    public CustomAppNexusConfig()
    {
      super("Sponsored", Long.valueOf(p.a), "");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.AdsCallMetaInfo
 * JD-Core Version:    0.6.2
 */