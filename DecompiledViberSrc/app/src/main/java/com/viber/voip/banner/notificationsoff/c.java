package com.viber.voip.banner.notificationsoff;

import android.content.Context;
import android.os.Handler;
import com.viber.common.b.b;
import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.f;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.k;
import com.viber.voip.util.ViberActionRunner.z;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;
import dagger.a;

public class c
  implements h, d.b
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final a<f> c;
  private final Handler d;
  private boolean e;
  private final d.al f;

  public c(Context paramContext, a<f> parama, Handler paramHandler)
  {
    this.b = paramContext.getApplicationContext();
    this.c = parama;
    this.d = paramHandler;
    this.f = null;
    this.e = b();
  }

  public void a()
  {
    if (d.k.h.d())
      return;
    long l = 86400000L + System.currentTimeMillis();
    d.k.f.a(l);
  }

  public boolean b()
  {
    return (!d.k.h.d()) && (!((f)this.c.get()).b()) && (ViberApplication.isActivated());
  }

  public Handler c()
  {
    return this.d;
  }

  public void onAppStopped()
  {
    if (!ViberApplication.isActivated())
      return;
    this.e = true;
  }

  public void onBackground()
  {
    i.a(this);
  }

  public void onForeground()
  {
    if (!b());
    long l;
    do
    {
      do
        return;
      while (!this.e);
      this.e = false;
      l = System.currentTimeMillis();
    }
    while (d.k.f.d() - l > 0L);
    ViberActionRunner.z.a(this.b);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.notificationsoff.c
 * JD-Core Version:    0.6.2
 */