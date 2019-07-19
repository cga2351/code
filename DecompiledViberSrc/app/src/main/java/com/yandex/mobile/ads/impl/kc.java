package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.nativeads.NativeAdLoaderConfiguration;
import com.yandex.mobile.ads.nativeads.bf;
import com.yandex.mobile.ads.nativeads.d;
import com.yandex.mobile.ads.nativeads.h;
import com.yandex.mobile.ads.nativeads.o;
import com.yandex.mobile.ads.nativeads.s;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class kc
{
  private final Executor a;
  private final eo b;
  private final kd c;
  private final kg d;
  private final NativeAdLoaderConfiguration e;

  public kc(Context paramContext, eo parameo, NativeAdLoaderConfiguration paramNativeAdLoaderConfiguration)
  {
    this.b = parameo;
    this.e = paramNativeAdLoaderConfiguration;
    this.c = new kd(parameo);
    this.d = new kg(this.c, new h(paramContext));
    this.a = Executors.newSingleThreadExecutor(new dc("YandexMobileAds.BaseController"));
  }

  public final void a(Context paramContext, v<lm> paramv, s params, kb paramkb)
  {
    this.a.execute(new a(paramContext, paramv, params, paramkb));
  }

  final class a
    implements Runnable
  {
    private final s b;
    private final WeakReference<Context> c;
    private final v<lm> d;
    private final kb e;

    a(v<lm> params, s paramkb, kb arg4)
    {
      this.d = paramkb;
      Object localObject1;
      this.b = localObject1;
      this.c = new WeakReference(params);
      Object localObject2;
      this.e = localObject2;
    }

    public final void run()
    {
      Context localContext = (Context)this.c.get();
      if (localContext != null)
      {
        lm locallm;
        try
        {
          locallm = (lm)this.d.r();
          if (locallm == null)
          {
            this.e.a(t.e);
            return;
          }
          Collection[] arrayOfCollection = new Collection[1];
          arrayOfCollection[0] = locallm.c();
          if (fl.a(arrayOfCollection))
          {
            this.e.a(t.j);
            return;
          }
        }
        catch (Exception localException)
        {
          this.e.a(t.e);
          return;
        }
        o localo = new o(locallm, this.d, kc.a(kc.this));
        kb localkb = this.e;
        if (kc.b(kc.this).shouldLoadImagesAutomatically())
        {
          bf localbf = new bf();
          kc.c(kc.this).a(localContext, localo, localbf, this.b, localkb);
          return;
        }
        d locald = new d(localContext);
        kc.d(kc.this).a(localContext, localo, locald, this.b, localkb);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kc
 * JD-Core Version:    0.6.2
 */