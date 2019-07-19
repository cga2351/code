package com.viber.voip.ads.b.a.b.c;

import com.viber.voip.ads.b.a.a.y.a;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo.Item;
import com.viber.voip.util.da;
import java.util.Arrays;

public class b extends a<PublicAccountsAdsMetaInfo>
{
  public b(y.a parama, String paramString, PublicAccountsAdsMetaInfo paramPublicAccountsAdsMetaInfo)
  {
    super(parama, paramString, paramPublicAccountsAdsMetaInfo);
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem != null)
      this.b = (System.currentTimeMillis() + 1000L * localItem.ttl);
  }

  private PublicAccountsAdsMetaInfo.Item B()
  {
    if ((this.a == null) || (((PublicAccountsAdsMetaInfo)this.a).items == null) || (((PublicAccountsAdsMetaInfo)this.a).items.length == 0))
      return null;
    return ((PublicAccountsAdsMetaInfo)this.a).items[0];
  }

  public String[] c()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return super.c();
    return (String[])Arrays.copyOf(localItem.impressionUrls, localItem.impressionUrls.length);
  }

  public String[] d()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return super.c();
    return (String[])Arrays.copyOf(localItem.reportClickUrls, localItem.reportClickUrls.length);
  }

  public String[] e()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return super.c();
    return (String[])Arrays.copyOf(localItem.viewUrls, localItem.viewUrls.length);
  }

  public String f()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.id))
      return localItem.id;
    return "";
  }

  public String g()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.adType))
      return localItem.adType;
    return "";
  }

  public String h()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.adProvider))
      return localItem.adProvider;
    return "";
  }

  public String i()
  {
    return "ViberAdServer";
  }

  public String j()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.sessionId))
      return localItem.sessionId;
    return "";
  }

  public String k()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.landingUrl))
      return localItem.landingUrl;
    return "";
  }

  public String l()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.providerTargetUrl))
      return localItem.providerTargetUrl;
    return "";
  }

  public String m()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.ctaUrl))
      return localItem.ctaUrl;
    return "";
  }

  public String o()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.imageUrl))
      return localItem.imageUrl;
    return "";
  }

  public String p()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.providerIconUrl))
      return localItem.providerIconUrl;
    return "";
  }

  public String q()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.title))
      return localItem.title;
    return "";
  }

  public String r()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.text))
      return localItem.text;
    return "";
  }

  public String s()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.promotedByTag))
      return localItem.promotedByTag;
    return "";
  }

  public String t()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return "";
    if (!da.a(localItem.ctaTitle))
      return localItem.ctaTitle;
    return "";
  }

  public boolean u()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return false;
    return localItem.hideOption;
  }

  public boolean v()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null)
      return false;
    return localItem.reportOption;
  }

  public boolean w()
  {
    PublicAccountsAdsMetaInfo.Item localItem = B();
    if (localItem == null);
    while ((!localItem.sponsoredOption) || (da.a(localItem.promotedByTag)))
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.b.c.b
 * JD-Core Version:    0.6.2
 */