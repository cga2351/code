package com.google.ads.mediation.mytarget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.my.target.a.a.a;
import com.my.target.a.b.a;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.a.d;
import com.viber.voip.settings.d.c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyTargetAdapter extends MyTargetMediationAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter
{
  private static final e a = ViberEnv.getLogger();
  private com.my.target.a.b b;
  private com.my.target.a.a c;

  private void a(a parama, MediationAdRequest paramMediationAdRequest, int paramInt1, int paramInt2, Context paramContext)
  {
    if (this.b != null)
      this.b.b();
    this.b = new com.my.target.a.b(paramContext);
    this.b.a(paramInt1, paramInt2, false);
    com.my.target.common.b localb = this.b.getCustomParams();
    if (localb != null)
    {
      if (paramMediationAdRequest != null)
      {
        d locald = com.viber.voip.util.k.a.a(d.c.a, paramMediationAdRequest);
        a.b("Set gender to ?", new Object[] { locald });
        localb.a(locald.toAdmobGender());
        Calendar localCalendar = com.viber.voip.util.k.a.a(paramMediationAdRequest);
        if (localCalendar != null)
        {
          int i = Calendar.getInstance().get(1) - localCalendar.get(1);
          if (i >= 0)
          {
            localb.b(i);
            e locale = a;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Integer.valueOf(i);
            locale.b("Set age to ?", arrayOfObject);
          }
        }
      }
      localb.b("mediation", "1");
    }
    this.b.setListener(parama);
    this.b.a();
  }

  AdSize a(Context paramContext, AdSize paramAdSize)
  {
    AdSize localAdSize = new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight());
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(AdSize.BANNER);
    localArrayList.add(AdSize.MEDIUM_RECTANGLE);
    localArrayList.add(AdSize.LEADERBOARD);
    e locale = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localArrayList.toString();
    locale.c("Potential ad sizes: ?", arrayOfObject);
    return a.a(paramContext, localAdSize, localArrayList);
  }

  public View getBannerView()
  {
    return this.b;
  }

  public void onDestroy()
  {
    if (this.b != null)
      this.b.b();
    if (this.c != null)
      this.c.f();
  }

  public void onPause()
  {
  }

  public void onResume()
  {
  }

  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    int i = a.a(paramContext, paramBundle1);
    e locale1 = a;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(i);
    locale1.b("Requesting myTarget banner mediation, slotId: ?", arrayOfObject1);
    if (i < 0)
      if (paramMediationBannerListener != null)
        paramMediationBannerListener.onAdFailedToLoad(this, 1);
    do
    {
      AdSize localAdSize;
      do
      {
        return;
        localAdSize = a(paramContext, paramAdSize);
        if (localAdSize != null)
          break;
        a.d("Failed to request ad, AdSize is null.", new Object[0]);
      }
      while (paramMediationBannerListener == null);
      paramMediationBannerListener.onAdFailedToLoad(this, 1);
      return;
      a locala = null;
      if (paramMediationBannerListener != null)
        locala = new a(paramMediationBannerListener);
      if ((localAdSize.getWidth() == 300) && (localAdSize.getHeight() == 250))
      {
        a.b("Loading myTarget banner, size: 300x250", new Object[0]);
        a(locala, paramMediationAdRequest, i, 1, paramContext);
        return;
      }
      if ((localAdSize.getWidth() == 728) && (localAdSize.getHeight() == 90))
      {
        a.b("Loading myTarget banner, size: 728x90", new Object[0]);
        a(locala, paramMediationAdRequest, i, 2, paramContext);
        return;
      }
      if ((localAdSize.getWidth() == 320) && (localAdSize.getHeight() == 50))
      {
        a.b("Loading myTarget banner, size: 320x50", new Object[0]);
        a(locala, paramMediationAdRequest, i, 0, paramContext);
        return;
      }
      e locale2 = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localAdSize.toString();
      locale2.d("AdSize ? is not currently supported", arrayOfObject2);
    }
    while (paramMediationBannerListener == null);
    paramMediationBannerListener.onAdFailedToLoad(this, 3);
  }

  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    int i = a.a(paramContext, paramBundle1);
    e locale1 = a;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(i);
    locale1.b("Requesting myTarget interstitial mediation, slotId: ?", arrayOfObject1);
    if (i < 0)
    {
      if (paramMediationInterstitialListener != null)
        paramMediationInterstitialListener.onAdFailedToLoad(this, 1);
      return;
    }
    b localb = null;
    if (paramMediationInterstitialListener != null)
      localb = new b(paramMediationInterstitialListener);
    if (this.c != null)
      this.c.f();
    this.c = new com.my.target.a.a(i, paramContext);
    com.my.target.common.b localb1 = this.c.g();
    localb1.b("mediation", "1");
    if (paramMediationAdRequest != null)
    {
      int j = paramMediationAdRequest.getGender();
      e locale2 = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(j);
      locale2.b("Set gender to ?", arrayOfObject2);
      localb1.a(j);
      Date localDate = paramMediationAdRequest.getBirthday();
      if ((localDate != null) && (localDate.getTime() != -1L))
      {
        GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
        GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
        localGregorianCalendar1.setTimeInMillis(localDate.getTime());
        int k = localGregorianCalendar2.get(1) - localGregorianCalendar1.get(1);
        if (k >= 0)
        {
          e locale3 = a;
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = Integer.valueOf(k);
          locale3.b("Set age to ?", arrayOfObject3);
          localb1.b(k);
        }
      }
    }
    this.c.a(localb);
    this.c.d();
  }

  public void showInterstitial()
  {
    if (this.c != null)
      this.c.e();
  }

  private class a
    implements b.a
  {
    private final MediationBannerListener b;

    a(MediationBannerListener arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void a(com.my.target.a.b paramb)
    {
      MyTargetAdapter.a().b("Banner mediation Ad loaded", new Object[0]);
      this.b.onAdLoaded(MyTargetAdapter.this);
    }

    public void a(String paramString, com.my.target.a.b paramb)
    {
      MyTargetAdapter.a().c("Banner mediation Ad failed to load: ?", new Object[] { paramString });
      this.b.onAdFailedToLoad(MyTargetAdapter.this, 3);
    }

    public void b(com.my.target.a.b paramb)
    {
      MyTargetAdapter.a().b("Banner mediation Ad clicked", new Object[0]);
      this.b.onAdClicked(MyTargetAdapter.this);
      this.b.onAdOpened(MyTargetAdapter.this);
      this.b.onAdLeftApplication(MyTargetAdapter.this);
    }
  }

  private class b
    implements a.a
  {
    private final MediationInterstitialListener b;

    b(MediationInterstitialListener arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void onClick(com.my.target.a.a parama)
    {
      MyTargetAdapter.a().b("Interstitial mediation Ad clicked", new Object[0]);
      this.b.onAdClicked(MyTargetAdapter.this);
      this.b.onAdLeftApplication(MyTargetAdapter.this);
    }

    public void onDismiss(com.my.target.a.a parama)
    {
      MyTargetAdapter.a().b("Interstitial mediation Ad dismissed", new Object[0]);
      this.b.onAdClosed(MyTargetAdapter.this);
    }

    public void onDisplay(com.my.target.a.a parama)
    {
      MyTargetAdapter.a().b("Interstitial mediation Ad displayed", new Object[0]);
      this.b.onAdOpened(MyTargetAdapter.this);
    }

    public void onLoad(com.my.target.a.a parama)
    {
      MyTargetAdapter.a().b("Interstitial mediation Ad loaded", new Object[0]);
      this.b.onAdLoaded(MyTargetAdapter.this);
    }

    public void onNoAd(String paramString, com.my.target.a.a parama)
    {
      MyTargetAdapter.a().c("Interstitial mediation Ad failed to load: ?", new Object[] { paramString });
      this.b.onAdFailedToLoad(MyTargetAdapter.this, 3);
    }

    public void onVideoCompleted(com.my.target.a.a parama)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.mytarget.MyTargetAdapter
 * JD-Core Version:    0.6.2
 */