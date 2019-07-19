package com.viber.voip;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.i.c.m;
import com.viber.voip.i.f;
import com.viber.voip.i.f.a;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;

class bt
  implements f.a, d.b
{
  private static final Logger a = ViberEnv.getLogger();
  private CallHandler b = ViberApplication.getInstance().getEngine(false).getCallHandler();
  private boolean c;

  private boolean b()
  {
    return this.b.getCallInfo() != null;
  }

  public void a()
  {
    c.m.a.a(this);
    d.c(this);
  }

  public void onAppStopped()
  {
    if ((this.c) && (!b()) && (ViberApplication.getInstance().getActivationController().getStep() != 7) && (ViberApplication.getInstance().getActivationController().getStep() != 15))
    {
      this.c = false;
      ViberApplication.exit(null, true);
    }
  }

  public void onBackground()
  {
    i.a(this);
  }

  public void onFeatureStateChanged(f paramf)
  {
    if (c.m.a.c().equals(paramf.c()))
      this.c = true;
  }

  public void onForeground()
  {
    i.b(this);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bt
 * JD-Core Version:    0.6.2
 */