package com.viber.voip.fcm;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.messenger.MessengerDelegate.RecentMessagesEnded;
import com.viber.jni.messenger.RecentMessagesEndedListener;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.service.VoipConnectorService.StartMode;
import com.viber.service.VoipConnectorService.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.c.a;
import com.viber.voip.notif.e.m;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean b = false;
  private final Context c;
  private final EventBus d;
  private final m e;
  private final ServiceStateListener f;
  private final RecentMessagesEndedListener g;
  private final PhoneController h;
  private final a i;
  private final ServiceStateDelegate j = new ServiceStateDelegate()
  {
    public void onServiceStateChanged(int paramAnonymousInt)
    {
      ServiceStateDelegate.ServiceState localServiceState = ServiceStateDelegate.ServiceState.resolveEnum(paramAnonymousInt);
      switch (f.3.a[localServiceState.ordinal()])
      {
      default:
        return;
      case 1:
      }
      f.this.a();
    }
  };
  private final MessengerDelegate.RecentMessagesEnded k = new MessengerDelegate.RecentMessagesEnded()
  {
    public void onGetRecentMessagesEnded(int paramAnonymousInt)
    {
      f.this.a();
    }
  };

  public f(Context paramContext, EventBus paramEventBus, m paramm, ServiceStateListener paramServiceStateListener, RecentMessagesEndedListener paramRecentMessagesEndedListener, PhoneController paramPhoneController, a parama)
  {
    this.c = paramContext;
    this.d = paramEventBus;
    this.e = paramm;
    this.f = paramServiceStateListener;
    this.g = paramRecentMessagesEndedListener;
    this.h = paramPhoneController;
    this.i = parama;
  }

  private void b()
  {
    this.h.testConnection(0);
  }

  public void a()
  {
    if (!this.b)
      return;
    this.f.removeDelegate(this.j);
    this.g.removeDelegate(this.k);
    this.e.m();
    this.b = false;
  }

  public void a(Map paramMap)
  {
    if (this.b)
      return;
    this.b = true;
    if (!this.d.isRegistered(this))
      this.d.register(this);
    ServiceStateListener localServiceStateListener = this.f;
    ServiceStateDelegate[] arrayOfServiceStateDelegate = new ServiceStateDelegate[1];
    arrayOfServiceStateDelegate[0] = this.j;
    localServiceStateListener.registerDelegate(arrayOfServiceStateDelegate);
    this.g.registerDelegate(this.k, null);
    this.e.l();
    this.i.a(this.c, paramMap);
  }

  @Subscribe
  public void onEvent(VoipConnectorService.a parama)
  {
    switch (3.b[parama.a.ordinal()])
    {
    default:
      return;
    case 1:
    }
    if (this.d.isRegistered(this))
      this.d.unregister(this);
    b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.fcm.f
 * JD-Core Version:    0.6.2
 */