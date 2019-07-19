package com.viber.voip.ads.polymorph.dfp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.adsnative.ads.ab;
import com.adsnative.ads.ad;
import com.adsnative.ads.n;
import com.adsnative.ads.p;
import com.adsnative.c.i;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventNative;
import com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PolymorphAdapter
  implements CustomEventNative
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

  public void requestNativeAd(Context paramContext, CustomEventNativeListener paramCustomEventNativeListener, String paramString, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle)
  {
    if (ad.c() > 0)
    {
      n localn = ad.a();
      if (localn != null)
      {
        new d(paramContext, localn, paramCustomEventNativeListener, paramNativeMediationAdRequest, ad.e()).a();
        return;
      }
    }
    i.b("Couldn't find Prefetched Native ad");
    paramCustomEventNativeListener.onAdFailedToLoad(3);
  }

  static class a extends NativeAd.Image
  {
    private Drawable a;
    private Uri b;
    private double c;

    public a(Drawable paramDrawable, Uri paramUri, double paramDouble)
    {
      this.a = paramDrawable;
      this.b = paramUri;
      this.c = paramDouble;
    }

    public Drawable getDrawable()
    {
      return this.a;
    }

    public double getScale()
    {
      return this.c;
    }

    public Uri getUri()
    {
      return this.b;
    }
  }

  static class b extends NativeAppInstallAdMapper
  {
    private n a;
    private ab b;

    b(n paramn, final CustomEventNativeListener paramCustomEventNativeListener, ab paramab, Context paramContext)
    {
      paramn.a(new p()
      {
        public void a()
        {
          if (PolymorphAdapter.b.this.getOverrideImpressionRecording())
          {
            i.b("Firing DFP impression tracker");
            paramCustomEventNativeListener.onAdImpression();
          }
        }

        public void a(n paramAnonymousn)
        {
        }

        public void a(String paramAnonymousString)
        {
        }

        public boolean b(n paramAnonymousn)
        {
          if (PolymorphAdapter.b.this.getOverrideClickHandling())
          {
            i.b("Firing DFP click tracker");
            paramCustomEventNativeListener.onAdClicked();
          }
          return false;
        }
      });
      this.a = paramn;
      this.b = paramab;
      setHeadline(this.a.a());
      setBody(this.a.b());
      setCallToAction(this.a.s());
      if (this.a.e() != null)
        setIcon(new PolymorphAdapter.a(this.a.f(), Uri.parse(this.a.e()), 1.0D));
      ArrayList localArrayList = new ArrayList();
      if (this.a.c() != null)
        localArrayList.add(new PolymorphAdapter.a(this.a.d(), Uri.parse(this.a.c()), 1.0D));
      if (localArrayList.size() > 0)
        setImages(localArrayList);
      if (this.a.H() != null)
      {
        setMediaView(this.a.H());
        setHasVideoContent(true);
      }
      if (this.a.G() != null)
        setAdChoicesContent(this.a.G());
      Bundle localBundle = new Bundle();
      localBundle.putString("providerName", "polymorph");
      if (!"Flurry API".equalsIgnoreCase(this.a.w()))
        localBundle.putString("adProviderTargetUrl", this.a.j());
      localBundle.putString("adProviderIconUrl", this.a.i());
      setExtras(localBundle);
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
    }

    public void handleClick(View paramView)
    {
      if (!getOverrideClickHandling())
      {
        i.b("Handling PM click");
        this.a.c(paramView);
      }
    }

    public void recordImpression()
    {
      if (!getOverrideImpressionRecording())
      {
        i.b("Firing PM impression tracker");
        this.a.b(null);
      }
    }

    public void trackViews(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      if (getOverrideClickHandling())
      {
        this.a.a(paramView);
        if (this.b != null)
          this.b.a(this.a, paramView);
      }
    }
  }

  static class c extends NativeContentAdMapper
  {
    private n a;
    private ab b;

    c(n paramn, final CustomEventNativeListener paramCustomEventNativeListener, ab paramab, Context paramContext)
    {
      paramn.a(new p()
      {
        public void a()
        {
          if (PolymorphAdapter.c.this.getOverrideImpressionRecording())
          {
            i.b("Firing DFP impression tracker");
            paramCustomEventNativeListener.onAdImpression();
          }
        }

        public void a(n paramAnonymousn)
        {
        }

        public void a(String paramAnonymousString)
        {
        }

        public boolean b(n paramAnonymousn)
        {
          if (PolymorphAdapter.c.this.getOverrideClickHandling())
          {
            i.b("Firing DFP click tracker");
            paramCustomEventNativeListener.onAdClicked();
          }
          return false;
        }
      });
      this.a = paramn;
      this.b = paramab;
      setHeadline(this.a.a());
      setBody(this.a.b());
      setAdvertiser(this.a.h());
      setCallToAction(this.a.s());
      if (this.a.e() != null)
        setLogo(new PolymorphAdapter.a(this.a.f(), Uri.parse(this.a.e()), 1.0D));
      ArrayList localArrayList = new ArrayList();
      if (this.a.c() != null)
        localArrayList.add(new PolymorphAdapter.a(this.a.d(), Uri.parse(this.a.c()), 1.0D));
      if (localArrayList.size() > 0)
        setImages(localArrayList);
      if (this.a.H() != null)
      {
        setMediaView(this.a.H());
        setHasVideoContent(true);
      }
      if (this.a.G() != null)
        setAdChoicesContent(this.a.G());
      Bundle localBundle = new Bundle();
      localBundle.putString("providerName", "polymorph");
      if (!"Flurry API".equalsIgnoreCase(this.a.w()))
        localBundle.putString("adProviderTargetUrl", this.a.j());
      localBundle.putString("adProviderIconUrl", this.a.i());
      setExtras(localBundle);
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
    }

    public void handleClick(View paramView)
    {
      if (!getOverrideClickHandling())
      {
        i.b("Handling PM click");
        this.a.c(paramView);
      }
    }

    public void recordImpression()
    {
      if (!getOverrideImpressionRecording())
      {
        i.b("Firing PM impression tracker");
        this.a.b(null);
      }
    }

    public void trackViews(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      if (getOverrideClickHandling())
      {
        this.a.a(paramView);
        if (this.b != null)
          this.b.a(this.a, paramView);
      }
    }
  }

  static class d
  {
    private Context a;
    private n b;
    private CustomEventNativeListener c;
    private NativeMediationAdRequest d;
    private ab e;

    d(Context paramContext, n paramn, CustomEventNativeListener paramCustomEventNativeListener, NativeMediationAdRequest paramNativeMediationAdRequest, ab paramab)
    {
      this.a = paramContext;
      this.b = paramn;
      this.c = paramCustomEventNativeListener;
      this.d = paramNativeMediationAdRequest;
      this.e = paramab;
    }

    void a()
    {
      a(this.b);
    }

    public void a(n paramn)
    {
      if (((paramn.s() != null) && (!paramn.s().isEmpty()) && (paramn.e() != null)) || (paramn.t().equalsIgnoreCase("facebook")))
      {
        this.c.onAdLoaded(new PolymorphAdapter.b(paramn, this.c, this.e, this.a));
        return;
      }
      this.c.onAdLoaded(new PolymorphAdapter.c(paramn, this.c, this.e, this.a));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.polymorph.dfp.PolymorphAdapter
 * JD-Core Version:    0.6.2
 */