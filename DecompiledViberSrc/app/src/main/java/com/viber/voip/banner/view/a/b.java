package com.viber.voip.banner.view.a;

import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.ads.d.j;
import com.viber.voip.ads.d.p;
import com.viber.voip.ads.d.q;
import com.viber.voip.banner.datatype.AdsAfterCallBanner;
import com.viber.voip.banner.datatype.Banner;
import com.viber.voip.banner.datatype.Banner.Background;
import com.viber.voip.banner.datatype.Banner.Size;
import com.viber.voip.banner.datatype.ButtonBannerItem;
import com.viber.voip.banner.datatype.ImageBannerItem;
import com.viber.voip.banner.datatype.ImageBannerItem.Size;
import com.viber.voip.banner.datatype.MediaBannerItem;
import com.viber.voip.banner.datatype.TextBannerItem;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.List;

public class b extends c
{
  private final int b;
  private int c;
  private int d;

  protected b(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext.getResources().getInteger(R.integer.ads_default_item_padding);
  }

  public static b a(Context paramContext)
  {
    return new b(paramContext);
  }

  protected AdsAfterCallBanner a(j paramj)
  {
    AdsAfterCallBanner localAdsAfterCallBanner = new AdsAfterCallBanner();
    localAdsAfterCallBanner.setAdCallType(this.c);
    localAdsAfterCallBanner.setAdCallProvider(this.d);
    localAdsAfterCallBanner.orientVertically();
    if ((paramj instanceof p))
      localAdsAfterCallBanner.setShouldSetClickListeners(false);
    int i;
    boolean bool;
    label63: ArrayList localArrayList;
    Object localObject;
    label117: String str2;
    label291: String str3;
    TextBannerItem localTextBannerItem2;
    if (this.c == 2)
    {
      i = 1;
      if (dj.a(this.a))
        break label550;
      bool = true;
      localArrayList = new ArrayList();
      localAdsAfterCallBanner.setSize(Banner.Size.ADS_AFTER_CALL_INTERNAL);
      localAdsAfterCallBanner.setBackground(Banner.Background.transparent());
      localAdsAfterCallBanner.setAd(paramj);
      if (!paramj.z())
        break label556;
      localObject = new MediaBannerItem();
      ((ImageBannerItem)localObject).setViewId(R.id.after_call_ad_media);
      ((ImageBannerItem)localObject).setSize(ImageBannerItem.Size.ADS_AFTER_CALL_INTERNAL);
      ((ImageBannerItem)localObject).setMargins(new int[] { 0, 0 });
      ((ImageBannerItem)localObject).setUrl(paramj.n());
      localArrayList.add(localObject);
      String str1 = paramj.r();
      if (!da.a(str1))
      {
        ImageBannerItem localImageBannerItem = new ImageBannerItem();
        localImageBannerItem.setSize(ImageBannerItem.Size.MEDIUM);
        localImageBannerItem.setMargins(new int[] { 0, 0 });
        localImageBannerItem.setUrl(str1);
        localImageBannerItem.setViewId(R.id.after_call_ad_app_icon);
        localArrayList.add(localImageBannerItem);
      }
      str2 = paramj.o();
      if (!da.a(str2))
      {
        TextBannerItem localTextBannerItem1 = new TextBannerItem();
        int[] arrayOfInt1 = new int[2];
        arrayOfInt1[0] = this.b;
        arrayOfInt1[1] = 0;
        localTextBannerItem1.setMargins(arrayOfInt1);
        if (!bool)
          break label576;
        localTextBannerItem1.setText(str2);
        localTextBannerItem1.setWidgetTuner(new com.viber.voip.banner.view.b.c(bool));
        localTextBannerItem1.setViewId(R.id.after_call_ad_title);
        localArrayList.add(localTextBannerItem1);
      }
      str3 = paramj.p();
      if ((!da.a(str3)) && (bool))
      {
        localTextBannerItem2 = new TextBannerItem();
        localTextBannerItem2.setMargins(new int[] { 0, 0 });
        localTextBannerItem2.setPaddingTop(this.b);
        if (i == 0)
          break label588;
        label389: localTextBannerItem2.setText(str3);
        if (i == 0)
          break label600;
      }
    }
    label550: label556: label576: label588: label600: for (int j = 2; ; j = -1)
    {
      localTextBannerItem2.setWidgetTuner(new com.viber.voip.banner.view.b.b(j));
      localTextBannerItem2.setViewId(R.id.after_call_ad_text);
      localArrayList.add(localTextBannerItem2);
      String str4 = paramj.q();
      if ((i == 0) && (!da.a(str4)) && (bool))
      {
        ButtonBannerItem localButtonBannerItem = new ButtonBannerItem();
        int[] arrayOfInt2 = new int[2];
        arrayOfInt2[0] = this.b;
        arrayOfInt2[1] = 7;
        localButtonBannerItem.setMargins(arrayOfInt2);
        localButtonBannerItem.setCaption(da.c(str4, 30));
        localButtonBannerItem.setWidgetTuner(new com.viber.voip.banner.view.b.a());
        localButtonBannerItem.setViewId(R.id.remote_banner_button);
        localArrayList.add(localButtonBannerItem);
      }
      localAdsAfterCallBanner.setItems(localArrayList);
      return localAdsAfterCallBanner;
      i = 0;
      break;
      bool = false;
      break label63;
      localObject = new ImageBannerItem();
      ((ImageBannerItem)localObject).setViewId(R.id.after_call_ad_image);
      break label117;
      str2 = da.c(str2, 36);
      break label291;
      str3 = da.c(str3, 90);
      break label389;
    }
  }

  protected Banner a(String paramString)
  {
    return a(new q(com.viber.voip.banner.e.a.f(paramString)));
  }

  public void a(j paramj, c.a parama, com.viber.voip.banner.view.b paramb, int paramInt)
  {
    this.c = paramInt;
    this.d = paramj.x();
    a(a(paramj), parama, paramb);
  }

  protected void a(Banner paramBanner)
  {
  }

  protected boolean a()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.a.b
 * JD-Core Version:    0.6.2
 */