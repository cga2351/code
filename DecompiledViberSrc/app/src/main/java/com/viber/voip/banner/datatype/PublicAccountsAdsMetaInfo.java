package com.viber.voip.banner.datatype;

import com.google.d.a.a;
import com.google.d.a.c;
import java.util.Arrays;

public class PublicAccountsAdsMetaInfo
{

  @a
  @c(a="ads")
  public Item[] items;

  public static class Item
  {

    @a
    @c(a="adProvider")
    public String adProvider;

    @a
    @c(a="adType")
    public String adType;

    @a
    @c(a="ctaTitle")
    public String ctaTitle;

    @a
    @c(a="ctaUrl")
    public String ctaUrl;

    @a
    @c(a="hideOption")
    public boolean hideOption;

    @a
    @c(a="iconUrl")
    public String iconUrl;

    @a
    @c(a="id")
    public String id;

    @a
    @c(a="imageUrl")
    public String imageUrl;

    @a
    @c(a="impressionUrls")
    public String[] impressionUrls;

    @a
    @c(a="landingUrl")
    public String landingUrl;

    @a
    @c(a="paURI")
    public String paURI;

    @a
    @c(a="promotedByTag")
    public String promotedByTag;

    @a
    @c(a="adProviderIconUrl")
    public String providerIconUrl;

    @a
    @c(a="adProviderTargetUrl")
    public String providerTargetUrl;

    @a
    @c(a="reportClickUrls")
    public String[] reportClickUrls;

    @a
    @c(a="reportOption")
    public boolean reportOption;

    @a
    @c(a="sessionId")
    public String sessionId;

    @a
    @c(a="sponsoredOption")
    public boolean sponsoredOption;

    @a
    @c(a="text")
    public String text;

    @a
    @c(a="title")
    public String title;

    @a
    @c(a="ttl")
    public long ttl;

    @a
    @c(a="uuid")
    public String uuid;

    @a
    @c(a="viewUrls")
    public String[] viewUrls;

    public String toString()
    {
      return "Item{id='" + this.id + '\'' + ", uuid='" + this.uuid + '\'' + ", sessionId='" + this.sessionId + '\'' + ", title='" + this.title + '\'' + ", promotedByTag='" + this.promotedByTag + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", reportClickUrls=" + Arrays.toString(this.reportClickUrls) + ", landingUrl='" + this.landingUrl + '\'' + ", impressionUrls=" + Arrays.toString(this.impressionUrls) + ", viewUrls=" + Arrays.toString(this.viewUrls) + ", ttl=" + this.ttl + ", adType='" + this.adType + '\'' + ", text='" + this.text + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", ctaTitle='" + this.ctaTitle + '\'' + ", ctaUrl='" + this.ctaUrl + '\'' + ", paURI='" + this.paURI + '\'' + ", hideOption=" + this.hideOption + ", reportOption=" + this.reportOption + ", sponsoredOption=" + this.sponsoredOption + ", adProvider='" + this.adProvider + '\'' + ", providerIconUrl='" + this.providerIconUrl + '\'' + ", providerTargetUrl='" + this.providerTargetUrl + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo
 * JD-Core Version:    0.6.2
 */