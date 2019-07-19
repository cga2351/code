package com.viber.voip.analytics.a;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;
import com.adjust.sdk.OnAttributionChangedListener;
import com.viber.dexshared.Logger;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.u;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.r;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class b
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final g c;
  private final a.a d;
  private final u e;
  private boolean f;
  private final OnAttributionChangedListener g = c.a;

  public b(Context paramContext, a.a parama, EventBus paramEventBus, Im2Exchanger paramIm2Exchanger)
  {
    this.b = paramContext.getApplicationContext();
    this.d = parama;
    this.e = new u(paramIm2Exchanger, d.bf.p);
    this.c = new g();
    paramEventBus.register(this);
  }

  private void c()
  {
    if (this.f)
      return;
    AdjustConfig localAdjustConfig = new AdjustConfig(this.b, "vzpmna78ud8m", "production");
    localAdjustConfig.setAppSecret(2L, 601211123L, 268244986L, 908279975L, 1890999221L);
    localAdjustConfig.setEventBufferingEnabled(Boolean.valueOf(true));
    localAdjustConfig.setLogLevel(LogLevel.SUPRESS);
    localAdjustConfig.setOnAttributionChangedListener(this.g);
    localAdjustConfig.setOnDeeplinkResponseListener(new d(this));
    if (!d.f.i.d())
    {
      this.c.b();
      d.f.i.a(true);
    }
    Adjust.onCreate(localAdjustConfig);
    String str = ViberApplication.getInstance().getFcmTokenController().c();
    if (!da.a(str))
      a(str);
    d();
    this.f = true;
  }

  private void d()
  {
    if (d.r.h.d())
      this.e.a();
  }

  public void a()
  {
    Adjust.onPause();
  }

  public void a(Uri paramUri)
  {
    Adjust.appWillOpenUrl(paramUri);
  }

  public void a(h paramh)
  {
    if (!paramh.b());
    do
    {
      return;
      if (!paramh.d())
        break;
    }
    while (ae.a(this.c.b(paramh)));
    this.c.a(paramh);
    Adjust.trackEvent(paramh.c());
  }

  public void a(String paramString)
  {
    Adjust.setPushToken(paramString);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      c();
      if (this.f)
        Adjust.setEnabled(paramBoolean);
      return;
    }
    finally
    {
    }
  }

  public void b()
  {
    Adjust.onResume();
  }

  public boolean f()
  {
    return true;
  }

  @Subscribe
  public void onEvent(com.viber.voip.fcm.a parama)
  {
    a(parama.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.a.b
 * JD-Core Version:    0.6.2
 */