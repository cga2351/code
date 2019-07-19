package com.viber.voip.ads.b.a.a;

import android.os.Handler;
import android.support.v4.util.Pair;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.viber.voip.ads.b.b.a.d;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class n
  implements l<com.viber.voip.ads.b.a.a.a.c>
{
  private final Handler a;

  n(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  private PublisherAdRequest a(com.viber.voip.ads.b.a.a.a.c paramc)
  {
    PublisherAdRequest.Builder localBuilder = new PublisherAdRequest.Builder();
    if (paramc.e != null)
      localBuilder.setLocation(paramc.e);
    if (paramc.f != null)
    {
      Iterator localIterator = paramc.f.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBuilder.addCustomTargeting((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localBuilder.build();
  }

  private void c(com.viber.voip.ads.b.a.a.a.c paramc, com.viber.voip.ads.b.b.a.c paramc1)
  {
    String str = paramc.c;
    b localb = new b(str, paramc1, paramc1, this.a);
    new AdLoader.Builder(paramc.a, str).forAppInstallAd(localb).forContentAd(localb).withAdListener(localb).withNativeAdOptions(new NativeAdOptions.Builder().setReturnUrlsForImageAssets(false).setAdChoicesPlacement(paramc.g).build()).build().loadAd(a(paramc));
  }

  private void d(com.viber.voip.ads.b.a.a.a.c paramc, com.viber.voip.ads.b.b.a.c paramc1)
  {
    String str = paramc.c;
    AdSize[] arrayOfAdSize = paramc.d;
    PublisherAdView localPublisherAdView = new PublisherAdView(paramc.a);
    localPublisherAdView.setAdUnitId(str);
    localPublisherAdView.setAdSizes(arrayOfAdSize);
    localPublisherAdView.setAdListener(new a(localPublisherAdView, str, paramc1, paramc1, this.a));
    localPublisherAdView.loadAd(a(paramc));
  }

  public int a()
  {
    return 2;
  }

  public void a(com.viber.voip.ads.b.a.a.a.c paramc, com.viber.voip.ads.b.b.a.c paramc1)
  {
    switch (paramc.b)
    {
    default:
      return;
    case 0:
      c(paramc, paramc1);
      return;
    case 1:
    }
    this.a.post(new o(this, paramc, paramc1));
  }

  private static class a extends AdListener
  {
    private PublisherAdView a;
    private final String b;
    private d c;
    private com.viber.voip.ads.b.b.a.a d;
    private final Handler e;

    a(PublisherAdView paramPublisherAdView, String paramString, d paramd, com.viber.voip.ads.b.b.a.a parama, Handler paramHandler)
    {
      this.a = paramPublisherAdView;
      this.b = paramString;
      this.c = paramd;
      this.d = parama;
      this.e = paramHandler;
    }

    public void onAdClosed()
    {
      this.e.post(new s(this));
    }

    public void onAdFailedToLoad(int paramInt)
    {
      int i;
      String str;
      switch (paramInt)
      {
      default:
        i = 1;
        str = "SDK failure";
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        this.e.post(new q(this, i, str));
        return;
        i = 4;
        str = "SDK internal error";
        continue;
        i = 5;
        str = "invalid request";
        continue;
        i = 6;
        str = "network error";
        continue;
        i = 7;
        str = "no fill";
      }
    }

    public void onAdLoaded()
    {
      this.e.post(new p(this));
    }

    public void onAdOpened()
    {
      this.e.post(new r(this));
    }
  }

  private static class b extends AdListener
    implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener
  {
    private final String a;
    private final d b;
    private com.viber.voip.ads.b.b.a.a c;
    private final Handler d;

    b(String paramString, d paramd, com.viber.voip.ads.b.b.a.a parama, Handler paramHandler)
    {
      this.a = paramString;
      this.b = paramd;
      this.c = parama;
      this.d = paramHandler;
    }

    private void b(Pair<Integer, String> paramPair)
    {
      this.d.post(new x(this, paramPair));
    }

    public void onAdClicked()
    {
    }

    public void onAdFailedToLoad(int paramInt)
    {
      b(com.viber.voip.util.k.a.a(paramInt));
    }

    public void onAdImpression()
    {
      this.d.post(new w(this));
    }

    public void onAdOpened()
    {
      this.d.post(new v(this));
    }

    public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
    {
      this.d.post(new t(this, paramNativeAppInstallAd));
    }

    public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
    {
      this.d.post(new u(this, paramNativeContentAd));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.a.n
 * JD-Core Version:    0.6.2
 */