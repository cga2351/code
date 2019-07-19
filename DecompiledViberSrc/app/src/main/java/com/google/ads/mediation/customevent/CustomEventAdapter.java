package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.a.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.a;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbae;

@KeepName
public final class CustomEventAdapter
  implements MediationBannerAdapter<CustomEventExtras, d>, MediationInterstitialAdapter<CustomEventExtras, d>
{
  private View a;

  @VisibleForTesting
  private CustomEventBanner b;

  @VisibleForTesting
  private CustomEventInterstitial c;

  private static <T> T a(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      String str = localThrowable.getMessage();
      zzbae.zzep(46 + String.valueOf(paramString).length() + String.valueOf(str).length() + "Could not instantiate custom event adapter: " + paramString + ". " + str);
    }
    return null;
  }

  public final void destroy()
  {
    if (this.b != null)
      this.b.a();
    if (this.c != null)
      this.c.a();
  }

  public final Class<CustomEventExtras> getAdditionalParametersType()
  {
    return CustomEventExtras.class;
  }

  public final View getBannerView()
  {
    return this.a;
  }

  public final Class<d> getServerParametersType()
  {
    return d.class;
  }

  public final void requestBannerAd(com.google.ads.mediation.c paramc, Activity paramActivity, d paramd, com.google.ads.b paramb, a parama, CustomEventExtras paramCustomEventExtras)
  {
    this.b = ((CustomEventBanner)a(paramd.b));
    if (this.b == null)
    {
      paramc.onFailedToReceiveAd(this, a.a.d);
      return;
    }
    if (paramCustomEventExtras == null);
    for (Object localObject = null; ; localObject = paramCustomEventExtras.getExtra(paramd.a))
    {
      this.b.requestBannerAd(new a(this, paramc), paramActivity, paramd.a, paramd.c, paramb, parama, localObject);
      return;
    }
  }

  public final void requestInterstitialAd(com.google.ads.mediation.d paramd, Activity paramActivity, d paramd1, a parama, CustomEventExtras paramCustomEventExtras)
  {
    this.c = ((CustomEventInterstitial)a(paramd1.b));
    if (this.c == null)
    {
      paramd.onFailedToReceiveAd(this, a.a.d);
      return;
    }
    if (paramCustomEventExtras == null);
    for (Object localObject = null; ; localObject = paramCustomEventExtras.getExtra(paramd1.a))
    {
      this.c.requestInterstitialAd(new b(this, paramd), paramActivity, paramd1.a, paramd1.c, parama, localObject);
      return;
    }
  }

  public final void showInterstitial()
  {
    this.c.showInterstitial();
  }

  @VisibleForTesting
  static final class a
    implements b
  {
    private final CustomEventAdapter a;
    private final com.google.ads.mediation.c b;

    public a(CustomEventAdapter paramCustomEventAdapter, com.google.ads.mediation.c paramc)
    {
      this.a = paramCustomEventAdapter;
      this.b = paramc;
    }
  }

  @VisibleForTesting
  final class b
    implements c
  {
    private final CustomEventAdapter a;
    private final com.google.ads.mediation.d b;

    public b(CustomEventAdapter paramd, com.google.ads.mediation.d arg3)
    {
      this.a = paramd;
      Object localObject;
      this.b = localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.customevent.CustomEventAdapter
 * JD-Core Version:    0.6.2
 */