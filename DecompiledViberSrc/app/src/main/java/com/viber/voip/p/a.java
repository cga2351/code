package com.viber.voip.p;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;

public abstract class a
{
  protected final Logger a = ViberEnv.getLogger(getClass());
  protected c b;
  private a c;

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    case 2:
    default:
      return;
    case 3:
    case 4:
      this.b.b();
      return;
    case 0:
    }
    this.b.c();
  }

  protected a a()
  {
    return this.c;
  }

  public void a(a parama)
  {
    this.c = parama;
  }

  protected void a(c paramc)
  {
    this.b = paramc;
    if (this.b.a())
    {
      EngineDelegatesManager localEngineDelegatesManager = b().getEngine(false).getDelegatesManager();
      DialerControllerDelegate.DialerPhoneState local1 = new DialerControllerDelegate.DialerPhoneState()
      {
        public void onPhoneStateChanged(int paramAnonymousInt)
        {
          a.a(a.this, paramAnonymousInt);
        }
      };
      localEngineDelegatesManager.getDialerPhoneStateListener().registerDelegate(new DialerControllerDelegate.DialerPhoneState[] { local1 });
    }
  }

  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }

  protected ViberApplication b()
  {
    return ViberApplication.getInstance();
  }

  public static abstract interface a
  {
    public abstract void enableBlackScreen(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.p.a
 * JD-Core Version:    0.6.2
 */