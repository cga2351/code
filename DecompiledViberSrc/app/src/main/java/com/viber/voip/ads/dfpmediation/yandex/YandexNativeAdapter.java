package com.viber.voip.ads.dfpmediation.yandex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventNative;
import com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.c;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequest.Builder;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeAdEventListener;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import com.yandex.mobile.ads.nativeads.NativeAdLoader;
import com.yandex.mobile.ads.nativeads.NativeAdLoader.OnImageAdLoadListener;
import com.yandex.mobile.ads.nativeads.NativeAdLoaderConfiguration;
import com.yandex.mobile.ads.nativeads.NativeAdLoaderConfiguration.Builder;
import com.yandex.mobile.ads.nativeads.NativeAppInstallAd;
import com.yandex.mobile.ads.nativeads.NativeContentAd;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import com.yandex.mobile.ads.nativeads.NativeImageAd;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

public class YandexNativeAdapter
  implements CustomEventNative
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private CustomEventNativeListener b;
  private NativeAdLoader c;
  private Context d;
  private ArrayList<f> e = new ArrayList();
  private NativeAdLoader.OnImageAdLoadListener f = new NativeAdLoader.OnImageAdLoadListener()
  {
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
        if (YandexNativeAdapter.b(YandexNativeAdapter.this) != null)
          YandexNativeAdapter.b(YandexNativeAdapter.this).onAdFailedToLoad(i);
        return;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
      }
    }

    public void onAppInstallAdLoaded(NativeAppInstallAd paramAnonymousNativeAppInstallAd)
    {
      YandexNativeAdapter.a(YandexNativeAdapter.this, paramAnonymousNativeAppInstallAd, new YandexNativeAdapter.d(paramAnonymousNativeAppInstallAd, new b(this), YandexNativeAdapter.a(YandexNativeAdapter.this), YandexNativeAdapter.b(YandexNativeAdapter.this)));
    }

    public void onContentAdLoaded(NativeContentAd paramAnonymousNativeContentAd)
    {
      YandexNativeAdapter.a(YandexNativeAdapter.this, paramAnonymousNativeContentAd, new YandexNativeAdapter.e(paramAnonymousNativeContentAd, new c(this), YandexNativeAdapter.a(YandexNativeAdapter.this), YandexNativeAdapter.b(YandexNativeAdapter.this)));
    }

    public void onImageAdLoaded(NativeImageAd paramAnonymousNativeImageAd)
    {
      YandexNativeAdapter.a(YandexNativeAdapter.this, paramAnonymousNativeImageAd, new YandexNativeAdapter.g(paramAnonymousNativeImageAd, new a(this), YandexNativeAdapter.a(YandexNativeAdapter.this), YandexNativeAdapter.b(YandexNativeAdapter.this)));
    }
  };

  private void a(NativeGenericAd paramNativeGenericAd, NativeAdMapper paramNativeAdMapper)
  {
    paramNativeGenericAd.setAdEventListener(new NativeAdEventListener()
    {
      public void onAdClosed()
      {
        if (YandexNativeAdapter.b(YandexNativeAdapter.this) != null)
          YandexNativeAdapter.b(YandexNativeAdapter.this).onAdClosed();
      }

      public void onAdLeftApplication()
      {
        if (YandexNativeAdapter.b(YandexNativeAdapter.this) != null)
        {
          YandexNativeAdapter.b(YandexNativeAdapter.this).onAdClicked();
          YandexNativeAdapter.b(YandexNativeAdapter.this).onAdLeftApplication();
          YandexNativeAdapter.b(YandexNativeAdapter.this).onAdOpened();
        }
      }

      public void onAdOpened()
      {
        if (YandexNativeAdapter.b(YandexNativeAdapter.this) != null)
        {
          YandexNativeAdapter.b(YandexNativeAdapter.this).onAdClicked();
          YandexNativeAdapter.b(YandexNativeAdapter.this).onAdOpened();
        }
      }
    });
    paramNativeGenericAd.shouldOpenLinksInApp(false);
    if (this.b != null)
      this.b.onAdLoaded(paramNativeAdMapper);
  }

  public void onDestroy()
  {
    this.b = null;
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((f)localIterator.next()).a();
  }

  public void onPause()
  {
  }

  public void onResume()
  {
  }

  public void requestNativeAd(Context paramContext, CustomEventNativeListener paramCustomEventNativeListener, String paramString, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle)
  {
    this.d = paramContext;
    this.b = paramCustomEventNativeListener;
    if (paramString == null)
    {
      if (paramCustomEventNativeListener != null)
        paramCustomEventNativeListener.onAdFailedToLoad(1);
      return;
    }
    NativeAdLoaderConfiguration localNativeAdLoaderConfiguration = new NativeAdLoaderConfiguration.Builder(paramString, true).build();
    AdRequest.Builder localBuilder = AdRequest.builder();
    com.viber.voip.ads.a.d locald = com.viber.voip.util.k.a.a(d.c.a, paramNativeMediationAdRequest);
    if (locald != com.viber.voip.ads.a.d.UNKNOWN)
      localBuilder.withGender(locald.toYandexTargetingParamGender());
    Calendar localCalendar = com.viber.voip.util.k.a.a(paramNativeMediationAdRequest);
    if (localCalendar != null)
    {
      int i = Calendar.getInstance().get(1) - localCalendar.get(1);
      if (i >= 0)
        localBuilder.withAge(String.valueOf(i));
    }
    this.c = new NativeAdLoader(paramContext, localNativeAdLoaderConfiguration);
    this.c.setOnLoadListener(this.f);
    this.c.loadAd(localBuilder.build());
  }

  private static class a extends AppCompatButton
  {
    public a(Context paramContext)
    {
      super();
    }

    public boolean isShown()
    {
      return true;
    }
  }

  private static class b extends AppCompatTextView
  {
    public b(Context paramContext)
    {
      super();
    }

    public boolean isShown()
    {
      return true;
    }
  }

  private static abstract interface c
  {
    public abstract void a(YandexNativeAdapter.f paramf);
  }

  private static class d extends NativeAppInstallAdMapper
  {
    private NativeAppInstallAd a;
    private WeakReference<CustomEventNativeListener> b = new WeakReference(null);

    d(NativeAppInstallAd paramNativeAppInstallAd, YandexNativeAdapter.c paramc, Context paramContext, CustomEventNativeListener paramCustomEventNativeListener)
    {
      if (paramCustomEventNativeListener != null)
        this.b = new WeakReference(paramCustomEventNativeListener);
      this.a = paramNativeAppInstallAd;
      NativeAdAssets localNativeAdAssets = paramNativeAppInstallAd.getAdAssets();
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
      setBody(localNativeAdAssets.getBody());
      setCallToAction(localNativeAdAssets.getCallToAction());
      setHeadline(localNativeAdAssets.getTitle());
      Object localObject = localNativeAdAssets.getIcon();
      if ((localObject != null) && (((NativeAdImage)localObject).getBitmap() != null))
      {
        YandexNativeAdapter.f localf2 = new YandexNativeAdapter.f((NativeAdImage)localObject, paramContext.getResources());
        paramc.a(localf2);
        setIcon(localf2);
      }
      NativeAdImage localNativeAdImage = localNativeAdAssets.getImage();
      if (localNativeAdImage == null);
      while (true)
      {
        if ((localObject != null) && (((NativeAdImage)localObject).getBitmap() != null))
        {
          ArrayList localArrayList = new ArrayList();
          YandexNativeAdapter.f localf1 = new YandexNativeAdapter.f((NativeAdImage)localObject, paramContext.getResources());
          paramc.a(localf1);
          localArrayList.add(localf1);
          setImages(localArrayList);
        }
        if (localNativeAdAssets.getRating() != null)
          setStarRating(localNativeAdAssets.getRating().floatValue());
        setStore(null);
        if (localNativeAdAssets.getPrice() != null)
          setPrice(localNativeAdAssets.getPrice());
        return;
        localObject = localNativeAdImage;
      }
    }

    public void trackViews(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      paramView.post(new d(this, paramView));
    }
  }

  private static class e extends NativeContentAdMapper
  {
    private NativeContentAd a;
    private WeakReference<CustomEventNativeListener> b = new WeakReference(null);

    e(NativeContentAd paramNativeContentAd, YandexNativeAdapter.c paramc, Context paramContext, CustomEventNativeListener paramCustomEventNativeListener)
    {
      if (paramCustomEventNativeListener != null)
        this.b = new WeakReference(paramCustomEventNativeListener);
      this.a = paramNativeContentAd;
      NativeAdAssets localNativeAdAssets = paramNativeContentAd.getAdAssets();
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
      setBody(localNativeAdAssets.getBody());
      setCallToAction(localNativeAdAssets.getCallToAction());
      setHeadline(localNativeAdAssets.getTitle());
      Object localObject = localNativeAdAssets.getIcon();
      if ((localObject != null) && (((NativeAdImage)localObject).getBitmap() != null))
      {
        YandexNativeAdapter.f localf2 = new YandexNativeAdapter.f((NativeAdImage)localObject, paramContext.getResources());
        paramc.a(localf2);
        setLogo(localf2);
      }
      NativeAdImage localNativeAdImage = localNativeAdAssets.getImage();
      if (localNativeAdImage == null);
      while (true)
      {
        if ((localObject != null) && (((NativeAdImage)localObject).getBitmap() != null))
        {
          ArrayList localArrayList = new ArrayList();
          YandexNativeAdapter.f localf1 = new YandexNativeAdapter.f((NativeAdImage)localObject, paramContext.getResources());
          paramc.a(localf1);
          localArrayList.add(localf1);
          setImages(localArrayList);
        }
        return;
        localObject = localNativeAdImage;
      }
    }

    public void trackViews(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      paramView.post(new e(this, paramView));
    }
  }

  private static class f extends NativeAd.Image
  {
    private final Uri a;
    private Drawable b;

    f(NativeAdImage paramNativeAdImage, Resources paramResources)
    {
      Bitmap localBitmap = paramNativeAdImage.getBitmap();
      if (localBitmap != null)
        this.b = new BitmapDrawable(paramResources, localBitmap);
      this.a = a(ViberApplication.getApplication(), localBitmap);
    }

    // ERROR //
    public Uri a(Context paramContext, Bitmap paramBitmap)
    {
      // Byte code:
      //   0: new 41	java/io/ByteArrayOutputStream
      //   3: dup
      //   4: invokespecial 42	java/io/ByteArrayOutputStream:<init>	()V
      //   7: astore_3
      //   8: aload_2
      //   9: getstatic 48	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   12: bipush 100
      //   14: aload_3
      //   15: invokevirtual 54	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   18: pop
      //   19: getstatic 60	com/viber/voip/util/dv:h	Lcom/viber/voip/util/dv;
      //   22: aload_1
      //   23: aconst_null
      //   24: iconst_0
      //   25: invokevirtual 63	com/viber/voip/util/dv:b	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
      //   28: astore 9
      //   30: new 65	java/io/FileOutputStream
      //   33: dup
      //   34: aload 9
      //   36: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   39: astore 6
      //   41: aload_3
      //   42: aload 6
      //   44: invokevirtual 72	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
      //   47: aload 9
      //   49: invokestatic 78	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
      //   52: astore 11
      //   54: aload 6
      //   56: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
      //   59: aload 11
      //   61: areturn
      //   62: astore 8
      //   64: aconst_null
      //   65: astore 6
      //   67: aload 6
      //   69: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
      //   72: aconst_null
      //   73: areturn
      //   74: astore 5
      //   76: aconst_null
      //   77: astore 6
      //   79: aload 5
      //   81: astore 7
      //   83: aload 6
      //   85: invokestatic 83	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
      //   88: aload 7
      //   90: athrow
      //   91: astore 7
      //   93: goto -10 -> 83
      //   96: astore 10
      //   98: goto -31 -> 67
      //
      // Exception table:
      //   from	to	target	type
      //   19	41	62	java/io/IOException
      //   19	41	74	finally
      //   41	54	91	finally
      //   41	54	96	java/io/IOException
    }

    public void a()
    {
      File localFile = new File(this.a.getPath());
      if (localFile.exists())
        localFile.delete();
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

  private static class g extends NativeContentAdMapper
  {
    private NativeImageAd a;
    private WeakReference<CustomEventNativeListener> b = new WeakReference(null);

    g(NativeImageAd paramNativeImageAd, YandexNativeAdapter.c paramc, Context paramContext, CustomEventNativeListener paramCustomEventNativeListener)
    {
      if (paramCustomEventNativeListener != null)
        this.b = new WeakReference(paramCustomEventNativeListener);
      this.a = paramNativeImageAd;
      NativeAdAssets localNativeAdAssets = paramNativeImageAd.getAdAssets();
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
      setBody(localNativeAdAssets.getBody());
      setCallToAction(localNativeAdAssets.getCallToAction());
      setHeadline(localNativeAdAssets.getTitle());
      Object localObject = localNativeAdAssets.getIcon();
      if ((localObject != null) && (((NativeAdImage)localObject).getBitmap() != null))
      {
        YandexNativeAdapter.f localf2 = new YandexNativeAdapter.f((NativeAdImage)localObject, paramContext.getResources());
        paramc.a(localf2);
        setLogo(localf2);
      }
      NativeAdImage localNativeAdImage = localNativeAdAssets.getImage();
      if (localNativeAdImage == null);
      while (true)
      {
        if ((localObject != null) && (((NativeAdImage)localObject).getBitmap() != null))
        {
          ArrayList localArrayList = new ArrayList();
          YandexNativeAdapter.f localf1 = new YandexNativeAdapter.f((NativeAdImage)localObject, paramContext.getResources());
          paramc.a(localf1);
          localArrayList.add(localf1);
          setImages(localArrayList);
        }
        return;
        localObject = localNativeAdImage;
      }
    }

    public void trackViews(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      paramView.post(new f(this, paramView));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.dfpmediation.yandex.YandexNativeAdapter
 * JD-Core Version:    0.6.2
 */