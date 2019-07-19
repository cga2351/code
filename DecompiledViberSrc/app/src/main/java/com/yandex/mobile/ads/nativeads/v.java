package com.yandex.mobile.ads.nativeads;

import android.os.Handler;
import android.os.Looper;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.t;

final class v
  implements t.b
{
  private static final Object a = new Object();
  private final Handler b = new Handler(Looper.getMainLooper());
  private NativeAdLoader.OnLoadListener c;

  final void a()
  {
    this.b.removeCallbacksAndMessages(null);
  }

  public final void a(final AdRequestError paramAdRequestError)
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (v.b())
        {
          if (v.a(v.this) != null)
            v.a(v.this).onAdFailedToLoad(paramAdRequestError);
          return;
        }
      }
    });
  }

  public final void a(NativeAdLoader.OnLoadListener paramOnLoadListener)
  {
    synchronized (a)
    {
      this.c = paramOnLoadListener;
      return;
    }
  }

  public final void a(final NativeGenericAd paramNativeGenericAd)
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        while (true)
        {
          synchronized (v.b())
          {
            if (v.a(v.this) != null)
            {
              if ((paramNativeGenericAd instanceof NativeContentAd))
                v.a(v.this).onContentAdLoaded((NativeContentAd)paramNativeGenericAd);
            }
            else
              return;
            if ((paramNativeGenericAd instanceof NativeAppInstallAd))
              v.a(v.this).onAppInstallAdLoaded((NativeAppInstallAd)paramNativeGenericAd);
          }
          if (((paramNativeGenericAd instanceof NativeImageAd)) && ((v.a(v.this) instanceof NativeAdLoader.OnImageAdLoadListener)))
            ((NativeAdLoader.OnImageAdLoadListener)v.a(v.this)).onImageAdLoaded((NativeImageAd)paramNativeGenericAd);
          else if (((paramNativeGenericAd instanceof az)) && ((v.a(v.this) instanceof be)))
            v.a(v.this);
          else
            v.a(v.this).onAdFailedToLoad(t.a);
        }
      }
    });
  }

  public final void a(final y paramy)
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (v.b())
        {
          if (v.a(v.this) != null)
          {
            if ((v.a(v.this) instanceof be))
              v.a(v.this);
          }
          else
            return;
          v.a(v.this).onAdFailedToLoad(t.a);
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.v
 * JD-Core Version:    0.6.2
 */