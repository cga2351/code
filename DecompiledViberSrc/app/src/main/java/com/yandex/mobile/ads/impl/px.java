package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.video.BlocksInfoRequest;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.VideoAdRequest;
import com.yandex.mobile.ads.video.tracking.Tracker.ErrorListener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class px
{
  private static final Object a = new Object();
  private static volatile px b;
  private final eo c;
  private final ex d;
  private qc e;
  private final pv f;
  private final Executor g;

  private px(Context paramContext)
  {
    ow localow = new ow(new ph(paramContext, new po()).a());
    oj localoj = new oj(new pe(), localow);
    localoj.a();
    this.e = new qc(localoj);
    this.c = new eo(b.e);
    this.d = new ex(this.c);
    this.f = new pv(this.c);
    this.g = Executors.newSingleThreadExecutor(new dc("YandexMobileAds.VideoAdsImpl"));
  }

  public static px a(Context paramContext)
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new px(paramContext);
      return b;
    }
  }

  private void a(final Context paramContext, final ew paramew, final pu parampu)
  {
    this.g.execute(new Runnable()
    {
      public final void run()
      {
        px.b(px.this).a(paramew, new ex.a()
        {
          public final void a()
          {
            px.a(px.this, px.3.this.b, px.3.this.c);
          }

          public final void b()
          {
            if (pt.a() != null)
            {
              px.a(px.this, px.3.this.b, px.3.this.c);
              return;
            }
            px.3.this.c.b();
          }
        });
      }
    });
  }

  private void a(Context paramContext, pu parampu)
  {
    a(paramContext, eu.a(paramContext), parampu);
  }

  public final void a(Context paramContext, final BlocksInfoRequest paramBlocksInfoRequest)
  {
    a(paramContext, new pu()
    {
      public final void a()
      {
        px.a(px.this).a(paramBlocksInfoRequest);
      }

      public final void b()
      {
        RequestListener localRequestListener = paramBlocksInfoRequest.getRequestListener();
        if (localRequestListener != null)
          localRequestListener.onFailure(VideoAdError.createInternalError("Internal state wasn't completely configured"));
      }
    });
  }

  public final void a(Context paramContext, final VideoAdRequest paramVideoAdRequest)
  {
    a(paramContext, new pu()
    {
      public final void a()
      {
        px.a(px.this).a(paramVideoAdRequest);
      }

      public final void b()
      {
        RequestListener localRequestListener = paramVideoAdRequest.getRequestListener();
        if (localRequestListener != null)
          localRequestListener.onFailure(VideoAdError.createInternalError("Internal state wasn't completely configured"));
      }
    });
  }

  public final void a(String paramString, Tracker.ErrorListener paramErrorListener)
  {
    this.e.a(paramString, paramErrorListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.px
 * JD-Core Version:    0.6.2
 */