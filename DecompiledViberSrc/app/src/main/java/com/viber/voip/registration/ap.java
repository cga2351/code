package com.viber.voip.registration;

import android.os.Handler;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.s;
import com.viber.voip.contacts.c.a;
import com.viber.voip.messages.k;
import com.viber.voip.user.age.UserAgeController;
import java.util.concurrent.TimeUnit;

public class ap
{
  private static final Logger a = ViberEnv.getLogger();
  private static final int b = (int)TimeUnit.SECONDS.toMillis(10L);
  private final s c;
  private final Handler d;
  private final ViberApplication e;
  private final d f;
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      ap.a(ap.this).getMessagesManager().A().startFetchUserBirthdate();
    }
  };
  private final Runnable h = new Runnable()
  {
    private boolean a()
    {
      int i = ap.b(ap.this).d();
      if (2 == i)
      {
        ap.c(ap.this).a(3);
        return true;
      }
      if (3 == i)
      {
        ap.c(ap.this).a(2);
        return true;
      }
      return false;
    }

    public void run()
    {
      if (a())
        return;
      Engine localEngine = ap.a(ap.this).getEngine(true);
      if (localEngine.getConnectionController().isConnected())
      {
        a.a(new aq(this));
        return;
      }
      localEngine.getDelegatesManager().getServiceStateListener().registerDelegate(ap.d(ap.this), ap.e(ap.this));
      ap.e(ap.this).postDelayed(ap.f(ap.this), ap.b());
    }
  };
  private final Runnable i = new Runnable()
  {
    public void run()
    {
      ap.a(ap.this).getEngine(false).getDelegatesManager().getServiceStateListener().removeDelegate(ap.d(ap.this));
      ap.c(ap.this).a(2);
      if (ap.b(ap.this).d() == 0)
        ap.b(ap.this).a(1);
    }
  };
  private final ServiceStateDelegate j = new ServiceStateDelegate()
  {
    public void onServiceStateChanged(int paramAnonymousInt)
    {
      ServiceStateDelegate.ServiceState localServiceState = ServiceStateDelegate.ServiceState.resolveEnum(paramAnonymousInt);
      switch (ap.5.a[localServiceState.ordinal()])
      {
      default:
        return;
      case 1:
      }
      ap.a(ap.this).getEngine(false).getDelegatesManager().getServiceStateListener().removeDelegate(this);
      ap.e(ap.this).removeCallbacks(ap.f(ap.this));
      ap.g(ap.this).run();
    }
  };

  ap(s params, Handler paramHandler, ViberApplication paramViberApplication, d paramd)
  {
    this.c = params;
    this.d = paramHandler;
    this.e = paramViberApplication;
    this.f = paramd;
  }

  void a()
  {
    this.c.a(1);
    this.d.post(this.g);
    this.c.b();
    this.d.post(this.h);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ap
 * JD-Core Version:    0.6.2
 */