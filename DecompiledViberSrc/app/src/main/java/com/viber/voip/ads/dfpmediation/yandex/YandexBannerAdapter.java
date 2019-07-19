package com.viber.voip.ads.dfpmediation.yandex;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.a.d;
import com.viber.voip.settings.d.c;
import com.viber.voip.util.k.a;
import com.yandex.mobile.ads.AdEventListener;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequest.Builder;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.AdView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

public class YandexBannerAdapter
  implements CustomEventBanner
{
  private static final e a = ViberEnv.getLogger();
  private String b;
  private String c;
  private AdView d;
  private String e;
  private boolean f;
  private CustomEventBannerListener g;
  private AdEventListener h = new AdEventListener()
  {
    public void onAdClosed()
    {
      YandexBannerAdapter.a(YandexBannerAdapter.this).onAdClosed();
    }

    public void onAdFailedToLoad(AdRequestError paramAnonymousAdRequestError)
    {
      int i = 3;
      switch (paramAnonymousAdRequestError.getCode())
      {
      case 4:
      default:
      case 1:
      case 5:
      case 2:
      case 3:
      }
      while (true)
      {
        YandexBannerAdapter.a(YandexBannerAdapter.this).onAdFailedToLoad(i);
        return;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
      }
    }

    public void onAdLeftApplication()
    {
      YandexBannerAdapter.a(YandexBannerAdapter.this).onAdClicked();
      YandexBannerAdapter.a(YandexBannerAdapter.this).onAdLeftApplication();
      YandexBannerAdapter.a(YandexBannerAdapter.this).onAdOpened();
    }

    public void onAdLoaded()
    {
      YandexBannerAdapter.a(YandexBannerAdapter.this).onAdLoaded(YandexBannerAdapter.b(YandexBannerAdapter.this));
    }

    public void onAdOpened()
    {
      YandexBannerAdapter.a(YandexBannerAdapter.this).onAdClicked();
      YandexBannerAdapter.a(YandexBannerAdapter.this).onAdOpened();
    }
  };

  private AdRequest a(MediationAdRequest paramMediationAdRequest)
  {
    AdRequest.Builder localBuilder = AdRequest.builder();
    HashMap localHashMap = new HashMap();
    localHashMap.put("mediation_network", "admob");
    localBuilder.withParameters(localHashMap);
    if (paramMediationAdRequest != null)
    {
      localBuilder.withLocation(paramMediationAdRequest.getLocation());
      d locald = a.a(d.c.a, paramMediationAdRequest);
      if (locald != d.UNKNOWN)
        localBuilder.withGender(locald.toYandexTargetingParamGender());
      Calendar localCalendar = a.a(paramMediationAdRequest);
      if (localCalendar != null)
      {
        int i = Calendar.getInstance().get(1) - localCalendar.get(1);
        if (i >= 0)
          localBuilder.withAge(String.valueOf(i));
      }
      Set localSet = paramMediationAdRequest.getKeywords();
      if (localSet != null)
        localBuilder.withContextTags(new ArrayList(localSet));
    }
    return localBuilder.build();
  }

  private com.yandex.mobile.ads.AdSize a(com.google.android.gms.ads.AdSize paramAdSize)
  {
    try
    {
      com.yandex.mobile.ads.AdSize localAdSize = new com.yandex.mobile.ads.AdSize(Integer.parseInt(this.b), Integer.parseInt(this.c));
      return localAdSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramAdSize == null);
    }
    for (int i = paramAdSize.getWidth(); ; i = 0)
    {
      int j = 0;
      if (paramAdSize != null)
        j = paramAdSize.getHeight();
      return new com.yandex.mobile.ads.AdSize(i, j);
    }
  }

  private static boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }

  private void b(String paramString)
    throws JSONException
  {
    this.e = paramString;
  }

  public void onDestroy()
  {
    if (this.d != null)
    {
      this.d.destroy();
      this.d = null;
    }
  }

  public void onPause()
  {
    if (this.d != null)
      this.d.pause();
  }

  public void onResume()
  {
    if (this.d != null)
      this.d.resume();
  }

  public void requestBannerAd(Context paramContext, CustomEventBannerListener paramCustomEventBannerListener, String paramString, com.google.android.gms.ads.AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle)
  {
    this.g = paramCustomEventBannerListener;
    if (this.g == null)
    {
      Log.w("Yandex AdMob Adapter", "customEventBannerListener must not be null");
      return;
    }
    if (a(paramString))
      try
      {
        b(paramString);
        com.yandex.mobile.ads.AdSize localAdSize = a(paramAdSize);
        AdRequest localAdRequest = a(paramMediationAdRequest);
        this.d = new AdView(paramContext);
        this.d.setAdSize(localAdSize);
        this.d.setBlockId(this.e);
        this.d.shouldOpenLinksInApp(this.f);
        this.d.setAdEventListener(this.h);
        this.d.loadAd(localAdRequest);
        return;
      }
      catch (JSONException localJSONException)
      {
        this.g.onAdFailedToLoad(3);
        return;
      }
    this.g.onAdFailedToLoad(3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.dfpmediation.yandex.YandexBannerAdapter
 * JD-Core Version:    0.6.2
 */