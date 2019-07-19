package com.viber.voip.ads.polymorph.dfp;

import android.content.Context;
import android.os.Bundle;
import com.adsnative.ads.ad;
import com.adsnative.ads.v;
import com.adsnative.ads.w;
import com.adsnative.c.i;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;

public class PolymorphBannerAdapter
  implements CustomEventBanner
{
  public void onDestroy()
  {
  }

  public void onPause()
  {
  }

  public void onResume()
  {
  }

  public void requestBannerAd(Context paramContext, CustomEventBannerListener paramCustomEventBannerListener, String paramString, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle)
  {
    if (ad.d() > 0)
    {
      w localw = ad.b();
      if (localw != null)
      {
        new a(paramContext, localw, paramCustomEventBannerListener, paramMediationAdRequest).a();
        return;
      }
    }
    i.b("Couldn't find Prefetched Banner ad");
    paramCustomEventBannerListener.onAdFailedToLoad(3);
  }

  static class a
  {
    private Context a;
    private w b;
    private CustomEventBannerListener c;
    private MediationAdRequest d;

    a(Context paramContext, w paramw, CustomEventBannerListener paramCustomEventBannerListener, MediationAdRequest paramMediationAdRequest)
    {
      this.a = paramContext;
      this.b = paramw;
      this.c = paramCustomEventBannerListener;
      this.d = paramMediationAdRequest;
    }

    void a()
    {
      this.b.setBannerAdListener(new v()
      {
        public void a(w paramAnonymousw)
        {
          i.b("PM Banner ad loaded");
          PolymorphBannerAdapter.a.a(PolymorphBannerAdapter.a.this).onAdLoaded(paramAnonymousw);
        }

        public void a(String paramAnonymousString)
        {
          i.b("PM Banner ad failed");
          i.e(paramAnonymousString);
          PolymorphBannerAdapter.a.a(PolymorphBannerAdapter.a.this).onAdFailedToLoad(3);
        }

        public void b(w paramAnonymousw)
        {
        }

        public void c(w paramAnonymousw)
        {
          i.b("PM Banner ad clicked");
          PolymorphBannerAdapter.a.a(PolymorphBannerAdapter.a.this).onAdClicked();
          PolymorphBannerAdapter.a.a(PolymorphBannerAdapter.a.this).onAdOpened();
          PolymorphBannerAdapter.a.a(PolymorphBannerAdapter.a.this).onAdLeftApplication();
        }
      });
      this.b.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.polymorph.dfp.PolymorphBannerAdapter
 * JD-Core Version:    0.6.2
 */