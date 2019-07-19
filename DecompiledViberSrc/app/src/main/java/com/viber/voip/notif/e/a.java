package com.viber.voip.notif.e;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.support.v4.app.ServiceCompat;
import com.viber.voip.notif.b.j.b;
import com.viber.voip.notif.b.j.c;
import com.viber.voip.notif.d.e;
import com.viber.voip.notif.d.e.a;
import com.viber.voip.notif.d.e.b;
import com.viber.voip.notif.d.j;
import com.viber.voip.notif.f;

public class a
{
  private final Context a;
  private final j b;
  private final dagger.a<f> c;

  public a(Context paramContext, j paramj, dagger.a<f> parama)
  {
    this.a = paramContext;
    this.b = paramj;
    this.c = parama;
  }

  private void a(e parame, e.a parama)
  {
    e.b localb = parame.a(this.a, this.b);
    if (parama != null)
    {
      localb.a((f)this.c.get(), parama);
      return;
    }
    localb.a((f)this.c.get());
  }

  public void a()
  {
    a(new b(), null);
  }

  public void a(int paramInt)
  {
    a(new c(paramInt), null);
  }

  public void a(final Service paramService)
  {
    final c localc = new c(0);
    a(localc, new e.a()
    {
      public void a(Notification paramAnonymousNotification)
      {
        paramService.startForeground(localc.a(), paramAnonymousNotification);
      }
    });
  }

  public void b(Service paramService)
  {
    ServiceCompat.stopForeground(paramService, 2);
    ((f)this.c.get()).a(new c(100).a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.a
 * JD-Core Version:    0.6.2
 */