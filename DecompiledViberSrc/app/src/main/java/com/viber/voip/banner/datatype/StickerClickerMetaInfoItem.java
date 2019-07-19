package com.viber.voip.banner.datatype;

import com.google.d.a.c;
import java.util.Arrays;

public final class StickerClickerMetaInfoItem
{

  @c(a="adType")
  private String mAdType;

  @c(a="reportClickUrls")
  private String[] mClickUrls;

  @c(a="clickerImageUrl")
  private String mClickerImageUrl;

  @c(a="clickerUrl")
  private String mClickerUrl;

  @c(a="id")
  private String mId;

  @c(a="impressionUrls")
  private String[] mImpressionUrls;

  @c(a="landingPageClickUrls")
  private String[] mLandingPageClickUrls;

  @c(a="landingPageImpUrls")
  private String[] mLandingPageImpUrls;

  @c(a="landingPageViewUrls")
  private String[] mLandingPageViewUrls;

  @c(a="sessionId")
  private String mSessionId;

  @c(a="ttl")
  private Long mTtl;

  @c(a="uuid")
  private String mUuid;

  @c(a="viewUrls")
  private String[] mViewUrls;

  public String getAdType()
  {
    return this.mAdType;
  }

  public String[] getClickUrls()
  {
    return this.mClickUrls;
  }

  public String getClickerImageUrl()
  {
    return this.mClickerImageUrl;
  }

  public String getClickerUrl()
  {
    return this.mClickerUrl;
  }

  public String getId()
  {
    return this.mId;
  }

  public String[] getImpressionUrls()
  {
    return this.mImpressionUrls;
  }

  public String[] getLandingPageClickUrls()
  {
    return this.mLandingPageClickUrls;
  }

  public String[] getLandingPageImpUrls()
  {
    return this.mLandingPageImpUrls;
  }

  public String[] getLandingPageViewUrls()
  {
    return this.mLandingPageViewUrls;
  }

  public String getSessionId()
  {
    return this.mSessionId;
  }

  public Long getTtl()
  {
    return this.mTtl;
  }

  public String getUuid()
  {
    return this.mUuid;
  }

  public String[] getViewUrls()
  {
    return this.mViewUrls;
  }

  public void removeTtl()
  {
    this.mTtl = null;
  }

  public void setAdType(String paramString)
  {
    this.mAdType = paramString;
  }

  public void setClickUrls(String[] paramArrayOfString)
  {
    this.mClickUrls = paramArrayOfString;
  }

  public void setClickerImageUrl(String paramString)
  {
    this.mClickerImageUrl = paramString;
  }

  public void setClickerUrl(String paramString)
  {
    this.mClickerUrl = paramString;
  }

  public void setId(String paramString)
  {
    this.mId = paramString;
  }

  public void setImpressionUrls(String[] paramArrayOfString)
  {
    this.mImpressionUrls = paramArrayOfString;
  }

  public void setTtl(Long paramLong)
  {
    this.mTtl = paramLong;
  }

  public void setUuid(String paramString)
  {
    this.mUuid = paramString;
  }

  public String toString()
  {
    return "StickerClickerMetaInfoItem{mId='" + this.mId + '\'' + ", mUuid='" + this.mUuid + '\'' + ", mTtl=" + this.mTtl + ", mClickerImageUrl='" + this.mClickerImageUrl + '\'' + ", mClickerUrl='" + this.mClickerUrl + '\'' + ", mImpressionUrls=" + Arrays.toString(this.mImpressionUrls) + ", mViewUrls=" + Arrays.toString(this.mViewUrls) + ", mClickUrls=" + Arrays.toString(this.mClickUrls) + ", mAdType='" + this.mAdType + '\'' + ", mLandingPageImpUrls=" + Arrays.toString(this.mLandingPageImpUrls) + ", mLandingPageClickUrls=" + Arrays.toString(this.mLandingPageClickUrls) + ", mLandingPageViewUrls=" + Arrays.toString(this.mLandingPageViewUrls) + ", mSessionId=" + this.mSessionId + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.StickerClickerMetaInfoItem
 * JD-Core Version:    0.6.2
 */