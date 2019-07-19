package com.viber.voip.notif.e;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.service.VoipConnectorService.StartMode;
import com.viber.service.VoipConnectorService.a;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.d.e;
import com.viber.voip.notif.d.e.a;
import com.viber.voip.notif.d.e.b;
import com.viber.voip.notif.d.j;
import com.viber.voip.notif.f;
import com.viber.voip.settings.d;
import com.viber.voip.settings.d.al;
import com.viber.voip.util.ViberActionRunner.bo;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class u
  implements ServiceStateDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final Engine c;
  private final Handler d;
  private final com.viber.common.b.b e;
  private final j f;
  private final dagger.a<f> g;
  private d.al h;

  public u(Context paramContext, Engine paramEngine, Handler paramHandler, com.viber.common.b.b paramb, j paramj, dagger.a<f> parama)
  {
    this.b = paramContext;
    this.c = paramEngine;
    this.d = paramHandler;
    this.e = paramb;
    this.f = paramj;
    this.g = parama;
  }

  public void a(ServiceStateDelegate.ServiceState paramServiceState)
  {
    final com.viber.voip.notif.b.g.b localb;
    if (this.e.d())
      switch (3.b[paramServiceState.ordinal()])
      {
      default:
        localb = new com.viber.voip.notif.b.g.b(this.b.getText(R.string.service_disconnected_text), R.drawable.status_disconnected);
      case 1:
      case 2:
      }
    while (true)
    {
      localb.a(this.b, this.f).a((f)this.g.get(), new e.a()
      {
        public void a(Notification paramAnonymousNotification)
        {
          ViberActionRunner.bo.a(u.c(u.this), paramAnonymousNotification, localb.a());
        }
      });
      return;
      localb = new com.viber.voip.notif.b.g.b(this.b.getText(R.string.service_connected_text), R.drawable.status_connected);
      continue;
      localb = new com.viber.voip.notif.b.g.b(this.b.getText(R.string.service_connecting_text), R.drawable.status_connecting);
    }
  }

  public void a(EventBus paramEventBus)
  {
    this.c.getDelegatesManager().getServiceStateListener().registerDelegate(new ServiceStateDelegate[] { this });
    paramEventBus.register(this);
    Handler localHandler = this.d;
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = this.e;
    d.al local1 = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        if (paramAnonymousa.c().equals(u.a(u.this).c()))
        {
          if (u.a(u.this).d())
            u.this.a(u.b(u.this).getServiceState());
        }
        else
          return;
        ViberActionRunner.bo.a(u.c(u.this));
      }
    };
    this.h = local1;
    d.a(local1);
  }

  @Subscribe
  public void onEvent(VoipConnectorService.a parama)
  {
    switch (3.a[parama.a.ordinal()])
    {
    default:
      return;
    case 1:
    }
    if (this.e.d())
    {
      a(this.c.getServiceState());
      return;
    }
    ViberActionRunner.bo.b(this.b);
  }

  public void onServiceStateChanged(int paramInt)
  {
    a(ServiceStateDelegate.ServiceState.resolveEnum(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.u
 * JD-Core Version:    0.6.2
 */