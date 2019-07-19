package com.google.ads.mediation.mytarget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.my.target.c.a.a;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.a.d;
import com.viber.voip.settings.d.c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MyTargetNativeAdapter
  implements MediationNativeAdapter
{
  public static final String EXTRA_KEY_ADVERTISING_LABEL = "advertisingLabel";
  public static final String EXTRA_KEY_AGE_RESTRICTIONS = "ageRestrictions";
  public static final String EXTRA_KEY_CATEGORY = "category";
  public static final String EXTRA_KEY_SUBCATEGORY = "subcategory";
  public static final String EXTRA_KEY_VOTES = "votes";
  private static final e a = ViberEnv.getLogger();
  private MediationNativeListener b;

  private static int b(List<View> paramList, com.my.target.c.b.a parama)
  {
    int i = 0;
    for (int j = 0; j < paramList.size(); j++)
    {
      View localView = (View)paramList.get(j);
      if ((localView instanceof MediaView))
      {
        MediaView localMediaView = (MediaView)localView;
        int k = localMediaView.getChildCount();
        while (i < k)
        {
          if (localMediaView.getChildAt(i) == parama)
            return j;
          i++;
        }
      }
    }
    return -1;
  }

  public void onDestroy()
  {
    this.b = null;
  }

  public void onPause()
  {
  }

  public void onResume()
  {
  }

  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    this.b = paramMediationNativeListener;
    int i = a.a(paramContext, paramBundle1);
    e locale1 = a;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(i);
    locale1.b("Requesting myTarget mediation, slotId: ?", arrayOfObject1);
    if (i < 0)
    {
      if (paramMediationNativeListener != null)
        paramMediationNativeListener.onAdFailedToLoad(this, 1);
      return;
    }
    d locald = d.UNKNOWN;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    NativeAdOptions localNativeAdOptions = null;
    if (paramNativeMediationAdRequest != null)
    {
      localNativeAdOptions = paramNativeMediationAdRequest.getNativeAdOptions();
      locald = com.viber.voip.util.k.a.a(d.c.a, paramNativeMediationAdRequest);
      bool3 = paramNativeMediationAdRequest.isContentAdRequested();
      bool2 = paramNativeMediationAdRequest.isAppInstallAdRequested();
      bool1 = paramNativeMediationAdRequest.isUnifiedNativeAdRequested();
    }
    com.my.target.c.a locala = new com.my.target.c.a(i, paramContext);
    boolean bool4 = true;
    label201: com.my.target.common.b localb;
    if (localNativeAdOptions != null)
      if (!localNativeAdOptions.shouldReturnUrlsForImageAssets())
      {
        bool4 = true;
        e locale4 = a;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Boolean.valueOf(bool4);
        locale4.b("Set autoload images to ?", arrayOfObject4);
        locala.a(localNativeAdOptions.getAdChoicesPlacement());
        locala.a(bool4);
        localb = locala.g();
        a.b("Set gender to ?", new Object[] { locald });
        localb.a(locald.toAdmobGender());
        Calendar localCalendar = com.viber.voip.util.k.a.a(paramNativeMediationAdRequest);
        if (localCalendar != null)
        {
          int j = Calendar.getInstance().get(1) - localCalendar.get(1);
          if (j >= 0)
          {
            localb.b(j);
            e locale3 = a;
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = Integer.valueOf(j);
            locale3.b("Set age to ?", arrayOfObject3);
          }
        }
        e locale2 = a;
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = Boolean.valueOf(bool3);
        arrayOfObject2[1] = Boolean.valueOf(bool2);
        arrayOfObject2[2] = Boolean.valueOf(bool1);
        locale2.b("Content requested: ?, install requested: ?, unified requested: ?", arrayOfObject2);
        if ((!bool1) && ((!bool3) || (!bool2)))
        {
          if (bool3)
            break label445;
          localb.b("at", "1");
        }
      }
    while (true)
    {
      b localb1 = new b(locala, paramNativeMediationAdRequest, paramContext);
      localb.b("mediation", "1");
      locala.a(localb1);
      locala.c();
      return;
      bool4 = false;
      break;
      locala.a(2);
      break label201;
      label445: localb.b("at", "2");
    }
  }

  private static class a extends NativeAd.Image
  {
    private final Uri a;
    private Drawable b;

    a(com.my.target.common.a.b paramb, Resources paramResources)
    {
      Bitmap localBitmap = paramb.e();
      if (localBitmap != null)
        this.b = new BitmapDrawable(paramResources, localBitmap);
      this.a = Uri.parse(paramb.a());
    }

    public Drawable getDrawable()
    {
      return this.b;
    }

    public double getScale()
    {
      return 1.0D;
    }

    public Uri getUri()
    {
      return this.a;
    }
  }

  private class b
    implements a.a
  {
    private final NativeMediationAdRequest b;
    private final com.my.target.c.a c;
    private final Context d;

    b(com.my.target.c.a paramNativeMediationAdRequest, NativeMediationAdRequest paramContext, Context arg4)
    {
      this.c = paramNativeMediationAdRequest;
      this.b = paramContext;
      Object localObject;
      this.d = localObject;
    }

    private void a(com.my.target.c.a parama, com.my.target.c.a.a parama1)
    {
      if (this.b == null)
      {
        MyTargetNativeAdapter.a().b("Failed to load: resources or nativeMediationAdRequest null", new Object[0]);
        if (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) != null)
          MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 0);
      }
      label174: Object localObject;
      label316: 
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              do
              {
                MyTargetNativeAdapter.e locale;
                do
                {
                  do
                  {
                    return;
                    if (!this.b.isUnifiedNativeAdRequested())
                      break label174;
                    if ((parama1.l() != null) && (parama1.a() != null))
                      break;
                    MyTargetNativeAdapter.a().b("No ad: Some of the Always Included assets are not available for the ad", new Object[0]);
                  }
                  while (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) == null);
                  MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 3);
                  return;
                  locale = new MyTargetNativeAdapter.e(parama, this.d);
                  MyTargetNativeAdapter.a().b("Ad loaded successfully", new Object[0]);
                }
                while (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) == null);
                MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdLoaded(MyTargetNativeAdapter.this, locale);
                return;
                str = parama1.k();
                if (!"store".equals(str))
                  break label316;
                if (!this.b.isAppInstallAdRequested())
                  break;
                localObject = new MyTargetNativeAdapter.d(parama, this.d);
                if ((parama1.l() != null) && (parama1.a() != null))
                  break label437;
                MyTargetNativeAdapter.a().b("No ad: Some of the Always Included assets are not available for the ad", new Object[0]);
              }
              while (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) == null);
              MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 3);
              return;
              MyTargetNativeAdapter.a().b("No ad: AdMob request was without install ad flag, but MyTarget responded with ? navigation type", new Object[] { str });
            }
            while (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) == null);
            MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 3);
            return;
            if (!this.b.isContentAdRequested())
              break;
            localObject = new MyTargetNativeAdapter.c(parama, this.d);
            if (parama1.l() != null)
              break label437;
            MyTargetNativeAdapter.a().b("No ad: Some of the Always Included assets are not available for the ad", new Object[0]);
          }
          while (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) == null);
          MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 3);
          return;
          MyTargetNativeAdapter.a().b("No ad: AdMob request was without content ad flag, but MyTarget responded with ? navigation type", new Object[] { str });
        }
        while (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) == null);
        MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 3);
        return;
        MyTargetNativeAdapter.a().b("Ad loaded successfully", new Object[0]);
      }
      while (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) == null);
      label437: MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdLoaded(MyTargetNativeAdapter.this, (NativeAdMapper)localObject);
    }

    public void a(com.my.target.c.a parama)
    {
      com.my.target.c.a.a locala = parama.b();
      if (locala == null)
      {
        MyTargetNativeAdapter.a().b("No ad: MyTarget responded with null banner", new Object[0]);
        if (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) != null)
          MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 3);
      }
      do
      {
        return;
        if (this.c == parama)
          break;
        MyTargetNativeAdapter.a().b("Failed to load: loaded native ad does not match with requested", new Object[0]);
      }
      while (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) == null);
      MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 0);
      return;
      a(parama, locala);
    }

    public void a(String paramString, com.my.target.c.a parama)
    {
      MyTargetNativeAdapter.a().c("No ad: MyTarget callback with reason ?", new Object[] { paramString });
      if (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) != null)
        MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdFailedToLoad(MyTargetNativeAdapter.this, 3);
    }

    public void b(com.my.target.c.a parama)
    {
      MyTargetNativeAdapter.a().b("Ad clicked", new Object[0]);
      if (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) != null)
      {
        MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdClicked(MyTargetNativeAdapter.this);
        MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdOpened(MyTargetNativeAdapter.this);
        MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdLeftApplication(MyTargetNativeAdapter.this);
      }
    }

    public void c(com.my.target.c.a parama)
    {
      MyTargetNativeAdapter.a().b("Ad show", new Object[0]);
      if (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) != null)
        MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onAdImpression(MyTargetNativeAdapter.this);
    }

    public void d(com.my.target.c.a parama)
    {
      MyTargetNativeAdapter.a().b("Play ad video", new Object[0]);
    }

    public void e(com.my.target.c.a parama)
    {
      MyTargetNativeAdapter.a().b("Pause ad video", new Object[0]);
    }

    public void f(com.my.target.c.a parama)
    {
      MyTargetNativeAdapter.a().b("Complete ad video", new Object[0]);
      if (MyTargetNativeAdapter.a(MyTargetNativeAdapter.this) != null)
        MyTargetNativeAdapter.a(MyTargetNativeAdapter.this).onVideoEnd(MyTargetNativeAdapter.this);
    }
  }

  private static class c extends NativeContentAdMapper
  {
    private final com.my.target.c.a a;
    private final com.my.target.c.b.a b;

    c(com.my.target.c.a parama, Context paramContext)
    {
      this.a = parama;
      this.b = new com.my.target.c.b.a(paramContext);
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
      com.my.target.c.a.a locala = parama.b();
      if (locala == null)
        return;
      setBody(locala.c());
      setCallToAction(locala.d());
      setHeadline(locala.b());
      com.my.target.common.a.b localb1 = locala.a();
      if ((localb1 != null) && (!TextUtils.isEmpty(localb1.a())))
        setLogo(new MyTargetNativeAdapter.a(localb1, paramContext.getResources()));
      setHasVideoContent(true);
      setMediaView(this.b);
      com.my.target.common.a.b localb2 = locala.l();
      if ((localb2 != null) && (!TextUtils.isEmpty(localb2.a())))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new MyTargetNativeAdapter.a(localb2, paramContext.getResources()));
        setImages(localArrayList);
      }
      setAdvertiser(locala.j());
      Bundle localBundle = new Bundle();
      String str1 = locala.e();
      if (!TextUtils.isEmpty(str1))
        localBundle.putString("ageRestrictions", str1);
      String str2 = locala.m();
      if (!TextUtils.isEmpty(str2))
        localBundle.putString("advertisingLabel", str2);
      setExtras(localBundle);
    }

    public void trackView(final View paramView)
    {
      paramView.post(new Runnable()
      {
        public void run()
        {
          if ((paramView instanceof NativeContentAdView))
          {
            NativeContentAdView localNativeContentAdView = (NativeContentAdView)paramView;
            ArrayList localArrayList = new ArrayList();
            if (localNativeContentAdView.getHeadlineView() != null)
              localArrayList.add(localNativeContentAdView.getHeadlineView());
            if (localNativeContentAdView.getBodyView() != null)
              localArrayList.add(localNativeContentAdView.getBodyView());
            if (localNativeContentAdView.getCallToActionView() != null)
              localArrayList.add(localNativeContentAdView.getCallToActionView());
            if (localNativeContentAdView.getAdvertiserView() != null)
              localArrayList.add(localNativeContentAdView.getAdvertiserView());
            if (localNativeContentAdView.getImageView() != null)
              localArrayList.add(localNativeContentAdView.getImageView());
            if (localNativeContentAdView.getLogoView() != null)
              localArrayList.add(localNativeContentAdView.getLogoView());
            if (localNativeContentAdView.getMediaView() != null)
              localArrayList.add(MyTargetNativeAdapter.c.a(MyTargetNativeAdapter.c.this));
            MyTargetNativeAdapter.c.b(MyTargetNativeAdapter.c.this).a(paramView, localArrayList);
            return;
          }
          MyTargetNativeAdapter.a().d("Failed to register view for interaction.", new Object[0]);
        }
      });
    }

    public void trackViews(final View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      paramView.post(new Runnable()
      {
        public void run()
        {
          int i = MyTargetNativeAdapter.a(this.a, MyTargetNativeAdapter.c.a(MyTargetNativeAdapter.c.this));
          if (i >= 0)
          {
            this.a.remove(i);
            this.a.add(MyTargetNativeAdapter.c.a(MyTargetNativeAdapter.c.this));
          }
          MyTargetNativeAdapter.c.b(MyTargetNativeAdapter.c.this).a(paramView, this.a);
        }
      });
    }

    public void untrackView(View paramView)
    {
      this.a.d();
    }
  }

  private static class d extends NativeAppInstallAdMapper
  {
    private final com.my.target.c.a a;
    private final com.my.target.c.b.a b;

    d(com.my.target.c.a parama, Context paramContext)
    {
      this.a = parama;
      this.b = new com.my.target.c.b.a(paramContext);
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
      com.my.target.c.a.a locala = parama.b();
      if (locala == null)
        return;
      setBody(locala.c());
      setCallToAction(locala.d());
      setHeadline(locala.b());
      com.my.target.common.a.b localb1 = locala.a();
      if ((localb1 != null) && (!TextUtils.isEmpty(localb1.a())))
        setIcon(new MyTargetNativeAdapter.a(localb1, paramContext.getResources()));
      com.my.target.common.a.b localb2 = locala.l();
      setHasVideoContent(true);
      setMediaView(this.b);
      if ((localb2 != null) && (!TextUtils.isEmpty(localb2.a())))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new MyTargetNativeAdapter.a(localb2, paramContext.getResources()));
        setImages(localArrayList);
      }
      setStarRating(locala.f());
      setStore(null);
      setPrice(null);
      Bundle localBundle = new Bundle();
      String str1 = locala.e();
      if (!TextUtils.isEmpty(str1))
        localBundle.putString("ageRestrictions", str1);
      String str2 = locala.m();
      if (!TextUtils.isEmpty(str2))
        localBundle.putString("advertisingLabel", str2);
      String str3 = locala.h();
      if (!TextUtils.isEmpty(str3))
        localBundle.putString("category", str3);
      String str4 = locala.i();
      if (!TextUtils.isEmpty(str4))
        localBundle.putString("subcategory", str4);
      int i = locala.g();
      if (i > 0)
        localBundle.putInt("votes", i);
      setExtras(localBundle);
    }

    public void trackView(final View paramView)
    {
      paramView.post(new Runnable()
      {
        public void run()
        {
          if ((paramView instanceof NativeAppInstallAdView))
          {
            NativeAppInstallAdView localNativeAppInstallAdView = (NativeAppInstallAdView)paramView;
            ArrayList localArrayList = new ArrayList();
            if (localNativeAppInstallAdView.getHeadlineView() != null)
              localArrayList.add(localNativeAppInstallAdView.getHeadlineView());
            if (localNativeAppInstallAdView.getBodyView() != null)
              localArrayList.add(localNativeAppInstallAdView.getBodyView());
            if (localNativeAppInstallAdView.getCallToActionView() != null)
              localArrayList.add(localNativeAppInstallAdView.getCallToActionView());
            if (localNativeAppInstallAdView.getIconView() != null)
              localArrayList.add(localNativeAppInstallAdView.getIconView());
            if (localNativeAppInstallAdView.getImageView() != null)
              localArrayList.add(localNativeAppInstallAdView.getImageView());
            if (localNativeAppInstallAdView.getPriceView() != null)
              localArrayList.add(localNativeAppInstallAdView.getPriceView());
            if (localNativeAppInstallAdView.getStarRatingView() != null)
              localArrayList.add(localNativeAppInstallAdView.getStarRatingView());
            if (localNativeAppInstallAdView.getStoreView() != null)
              localArrayList.add(localNativeAppInstallAdView.getStoreView());
            if (localNativeAppInstallAdView.getMediaView() != null)
              localArrayList.add(MyTargetNativeAdapter.d.a(MyTargetNativeAdapter.d.this));
            MyTargetNativeAdapter.d.b(MyTargetNativeAdapter.d.this).a(paramView, localArrayList);
            return;
          }
          MyTargetNativeAdapter.a().d("Failed to register view for interaction.", new Object[0]);
        }
      });
    }

    public void trackViews(final View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      paramView.post(new Runnable()
      {
        public void run()
        {
          int i = MyTargetNativeAdapter.a(this.a, MyTargetNativeAdapter.d.a(MyTargetNativeAdapter.d.this));
          if (i >= 0)
          {
            this.a.remove(i);
            this.a.add(MyTargetNativeAdapter.d.a(MyTargetNativeAdapter.d.this));
          }
          MyTargetNativeAdapter.d.b(MyTargetNativeAdapter.d.this).a(paramView, this.a);
        }
      });
    }

    public void untrackView(View paramView)
    {
      this.a.d();
    }
  }

  private static class e extends UnifiedNativeAdMapper
  {
    private final com.my.target.c.a a;
    private final com.my.target.c.b.a b;

    e(com.my.target.c.a parama, Context paramContext)
    {
      this.a = parama;
      this.b = new com.my.target.c.b.a(paramContext);
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
      com.my.target.c.a.a locala = parama.b();
      if (locala == null)
        return;
      setBody(locala.c());
      setCallToAction(locala.d());
      setHeadline(locala.b());
      com.my.target.common.a.b localb1 = locala.a();
      if ((localb1 != null) && (!TextUtils.isEmpty(localb1.a())))
        setIcon(new MyTargetNativeAdapter.a(localb1, paramContext.getResources()));
      com.my.target.common.a.b localb2 = locala.l();
      setHasVideoContent(true);
      setMediaView(this.b);
      if ((localb2 != null) && (!TextUtils.isEmpty(localb2.a())))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new MyTargetNativeAdapter.a(localb2, paramContext.getResources()));
        setImages(localArrayList);
      }
      setAdvertiser(locala.j());
      setStarRating(Double.valueOf(locala.f()));
      setStore(null);
      setPrice(null);
      Bundle localBundle = new Bundle();
      String str1 = locala.e();
      if (!TextUtils.isEmpty(str1))
        localBundle.putString("ageRestrictions", str1);
      String str2 = locala.m();
      if (!TextUtils.isEmpty(str2))
        localBundle.putString("advertisingLabel", str2);
      String str3 = locala.h();
      if (!TextUtils.isEmpty(str3))
        localBundle.putString("category", str3);
      String str4 = locala.i();
      if (!TextUtils.isEmpty(str4))
        localBundle.putString("subcategory", str4);
      int i = locala.g();
      if (i > 0)
        localBundle.putInt("votes", i);
      setExtras(localBundle);
    }

    public void trackViews(final View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      paramView.post(new Runnable()
      {
        public void run()
        {
          int i = MyTargetNativeAdapter.a(this.a, MyTargetNativeAdapter.e.a(MyTargetNativeAdapter.e.this));
          if (i >= 0)
          {
            this.a.remove(i);
            this.a.add(MyTargetNativeAdapter.e.a(MyTargetNativeAdapter.e.this));
          }
          MyTargetNativeAdapter.e.b(MyTargetNativeAdapter.e.this).a(paramView, this.a);
        }
      });
    }

    public void untrackView(View paramView)
    {
      this.a.d();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.mytarget.MyTargetNativeAdapter
 * JD-Core Version:    0.6.2
 */