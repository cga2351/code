package com.viber.voip.ads.mediated;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.appnexus.opensdk.MediatedNativeAd;
import com.appnexus.opensdk.MediatedNativeAdController;
import com.appnexus.opensdk.NativeAdEventListener;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.NativeAdResponse.Network;
import com.appnexus.opensdk.NativeAdResponse.Rating;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.TargetingParameters;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.q.a;
import com.viber.voip.ads.r;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.a.a.d;
import com.viber.voip.banner.a.a.f;
import com.viber.voip.banner.a.a.g;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.e.a;
import com.viber.voip.messages.k;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AdsNativeNativeAd
  implements MediatedNativeAd
{
  private static final Logger L = ViberEnv.getLogger();
  protected static String STATIC_AD = "{  \n   \"ads\":[  \n      {  \n         \"adType\":\"story\",\n         \"adProvider\":\"Viber-test\",\n         \"title\":\"This is a test ad from AdsNative that was injected into AppNexus\",\n         \"landingUrl\":\"https://techcrunch.com/2016/06/29/its-official-kleiner-just-pulled-off-a-1-4-billion-fundraise/?ncid=rss&6f96f06d1b7a438597150c38a7a1f7ee_ab6e1da5\",\n         \"imageUrl\":\"https://ads.cdn.viber.com/media/734/3aa9b52a-bc03-48c5-a6e1-029b658937e0.jpg\",\n         \"text\":\"Checking summary text12344342342342342342342Checking summary text12344342342342342342342Checking s\",\n         \"impressionUrls\":[  \n            \"https://bevo-eu-west-1.adsnative.com/im.gif?data=Yjc3N2M3NDFmMjYxOTUwMGNhNDE0YWE2NjJkOTJiZGM3MWI1OWUxZGVhNTQxNDI4NTJiNGVlODQxMDliNjY1NzIwNzNjOGNiMmVlYjk4MjY4NTY3NDgwMTUyZDJiNDE2OTliOGY5NWU5MDcxOTdkOGU3MjUxZWE0ODZmMWM5MjkwZDA5ZmNkZDE1OGE5ZWI0NGRlYzllNWE5ZTg1MmZkZTY2ZDk3ZmJjZWM1ZWI2ZmMyOGJiMGYzZDIxMTc2MTA2ZmFhZDMyNDg1YmE2MTMyYzBmOWZiNzAzZGUzZGVmM2JhMzIwODY0YWJlM2Q4NzgzNmNhNzkyNDhiMjFmYWI0YjNiZjZhMjZiM2EzNzYwM2MwMzhhMzQzNDg4YTYxNzM0MTIyM2RjZjcwZDI3MDE1ZWViZTQxM2E5NTM1YjcyNjJiMDhjMmQ2ZWRiNjQyZTgzNjVhMjAyZDUwZmZmN2NjZA%3D%3D&sid=6f96f06d1b7a438597150c38a7a1f7ee_ab6e1da5\"\n         ],\n         \"viewUrls\":[  \n            \"https://bevo-eu-west-1.adsnative.com/vi.gif?data=Yjc3N2M3NDFmMjYxOTUwMGNhNDE0YWE2NjJkOTJiZGM3MWI1OWUxZGVhNTQxNDI4NTJiNGVlODQxMDliNjY1NzIwNzNjOGNiMmVlYjk4MjY4NTY3NDgwMTUyZDJiNDE2OTliOGY5NWU5MDcxOTdkOGU3MjUxZWE0ODZmMWM5MjkwZDA5ZmNkZDE1OGE5ZWI0NGRlYzllNWE5ZTg1MmZkZTY2ZDk3ZmJjZWM1ZWI2ZmMyOGJiMGYzZDIxMTc2MTA2ZmFhZDMyNDg1YmE2MTMyYzBmOWZiNzAzZGUzZGVmM2JhMzIwODY0YWJlM2Q4NzgzNmNhNzkyNDhiMjFmYWI0YjNiZjZhMjZiM2EzNzYwM2MwMzhhMzQzNDg4YTYxNzM0MTIyM2RjZjcwZDI3MDE1ZWViZTQxM2E5NTM1YjcyNjJiMDhjMmQ2ZWRiNjQyZTgzNjVhMjAyZDUwZmZmN2NjZA%3D%3D&sid=6f96f06d1b7a438597150c38a7a1f7ee_ab6e1da5\"\n         ],\n         \"reportClickUrls\":[  \n            \"https://bevo-eu-west-1.adsnative.com/ck?nr=1&data=ODY0NzY3OThiMjljM2FiNGJhN2VjOTM0Yjg2ODYyNGJiNzM2NWU5MmU2ZGM2Nzc1NjY3YjNhMmMxYWZmNWU1OWQ4NGZjYWQ0NGFhOTNmNzY1YzJjMDA4NTQ3YmEzNWRiNTA1OGFhMjhkNDdjMzk5MmUxNTRlZDg4MDFiM2E0NWM1OTA1ODhiMDRhYTg1MTQzMTBhN2M4NmZiYmNjNjcwODBkMzEwOTI5MTQzYzc1MDRkZjk1YzZhNmRlYzk3ZmFiNmQyMjI4YzM2YWE4NjBhNjAwMzY2NDgyYzYwZjA4MjY1ZDI4OTNkMWNhMTMxZDhhZDk0ZDFkMDdmN2VhZWQ4YTQyNzFiZWM5ZDUwMWQ2OTZlNGRiYTEyMTg4NzFlOTM4ZTAwZjVlYWRjZGE0ZDY0ZDljZmZkYzZhODJlODNhNTFiM2Y3Yzc2NThlZjBmMWVmMjIyNWY5MDM2N2QzZTRkNw%3D%3D&sid=6f96f06d1b7a438597150c38a7a1f7ee_ab6e1da5\"\n         ],\n         \"ctaText\":\"\",\n         \"promotedByTag\":\"Sponsored\",\n         \"timer\":5,\n         \"id\":\"992PJMQ9\",\n         \"uuid\":\"cd311fa6-ea08-4807-872c-eb9b244977e2\",\n         \"sessionId\":\"6f96f06d1b7a438597150c38a7a1f7ee\",\n         \"campaignId\":\"Y6M9DYY9\",\n         \"ttl\":600\n      }\n   ]\n}";
  protected static final boolean USE_FAKE_AD_ON_NO_FILL;
  protected com.viber.voip.ads.q adsNativeFetcher = new r(ViberApplication.getInstance().getDownloadValve());
  protected g adsUrlProvider = new g(1);

  public void handleAdLoaded(com.viber.voip.ads.d.q paramq)
  {
    ViberApplication.getInstance().getMessagesManager().i().a(1).a(paramq.k());
  }

  public void handleAdOnClickAction(com.viber.voip.ads.d.q paramq)
  {
    new OpenUrlAction(paramq.m()).execute(ViberApplication.getApplication().getApplicationContext(), null);
    ViberApplication.getInstance().getMessagesManager().i().a(1).a(paramq.l());
  }

  public void requestNativeAd(Context paramContext, String paramString1, String paramString2, final MediatedNativeAdController paramMediatedNativeAdController, TargetingParameters paramTargetingParameters)
  {
    if (paramMediatedNativeAdController != null)
      av.a(av.e.e).post(new Runnable()
      {
        public void run()
        {
          Uri localUri = AdsNativeNativeAd.this.adsUrlProvider.a(17);
          q.a locala = AdsNativeNativeAd.this.adsNativeFetcher.a(localUri);
          if (locala.b != 0)
          {
            paramMediatedNativeAdController.onAdFailed(ResultCode.INTERNAL_ERROR);
            return;
          }
          AdsCallMetaInfo localAdsCallMetaInfo = a.e(locala.a);
          if (localAdsCallMetaInfo.getItem(0) == null)
          {
            paramMediatedNativeAdController.onAdFailed(ResultCode.UNABLE_TO_FILL);
            return;
          }
          com.viber.voip.ads.d.q localq = new com.viber.voip.ads.d.q(localAdsCallMetaInfo.getItem(0));
          AdsNativeNativeAd.a locala1 = new AdsNativeNativeAd.a(AdsNativeNativeAd.this, localq);
          paramMediatedNativeAdController.onAdLoaded(locala1);
        }
      });
  }

  public class a
    implements View.OnClickListener, NativeAdResponse
  {
    com.viber.voip.ads.d.q a;
    Bitmap b = null;
    private NativeAdEventListener d = null;
    private View e = null;
    private List<View> f = null;

    public a(com.viber.voip.ads.d.q arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    public void destroy()
    {
      this.b = null;
    }

    public NativeAdResponse.Rating getAdStarRating()
    {
      return null;
    }

    public String getCallToAction()
    {
      return this.a.q();
    }

    public String getCreativeId()
    {
      return this.a.d();
    }

    public String getDescription()
    {
      return this.a.p();
    }

    public String getFullText()
    {
      return null;
    }

    public Bitmap getIcon()
    {
      return null;
    }

    public String getIconUrl()
    {
      return this.a.r();
    }

    public Bitmap getImage()
    {
      return this.b;
    }

    public String getImageUrl()
    {
      return this.a.n();
    }

    public List<String> getImpressionTrackers()
    {
      return Arrays.asList(this.a.k());
    }

    public HashMap<String, Object> getNativeElements()
    {
      return null;
    }

    public NativeAdResponse.Network getNetworkIdentifier()
    {
      return NativeAdResponse.Network.CUSTOM;
    }

    public String getOriginalResponse()
    {
      return null;
    }

    public String getSocialContext()
    {
      return null;
    }

    public String getSponsoredBy()
    {
      return null;
    }

    public String getTitle()
    {
      return this.a.o();
    }

    public boolean hasExpired()
    {
      return false;
    }

    public void onClick(View paramView)
    {
      if (this.d != null)
      {
        AdsNativeNativeAd.this.handleAdOnClickAction(this.a);
        this.d.onAdWasClicked();
      }
    }

    public boolean registerView(View paramView, NativeAdEventListener paramNativeAdEventListener)
    {
      this.d = paramNativeAdEventListener;
      if (this.e != null)
        unregisterViews();
      this.e = paramView;
      this.e.setOnClickListener(this);
      return true;
    }

    public boolean registerViewList(View paramView, List<View> paramList, NativeAdEventListener paramNativeAdEventListener)
    {
      this.d = paramNativeAdEventListener;
      if (this.f != null)
        unregisterViews();
      this.f = paramList;
      if (this.f != null)
      {
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext())
          ((View)localIterator.next()).setOnClickListener(this);
      }
      return true;
    }

    public void setCreativeId(String paramString)
    {
    }

    public void setIcon(Bitmap paramBitmap)
    {
    }

    public void setImage(Bitmap paramBitmap)
    {
      this.b = paramBitmap;
    }

    public void unregisterViews()
    {
      if (this.e != null)
        this.e.setOnClickListener(null);
      if (this.f != null)
      {
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext())
          ((View)localIterator.next()).setOnClickListener(null);
      }
      this.f = null;
      this.e = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.mediated.AdsNativeNativeAd
 * JD-Core Version:    0.6.2
 */