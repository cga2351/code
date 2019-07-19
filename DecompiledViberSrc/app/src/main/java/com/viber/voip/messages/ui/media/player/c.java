package com.viber.voip.messages.ui.media.player;

import android.os.Handler;
import com.viber.common.a.e;
import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;

public class c extends PhoneControllerDelegateAdapter
  implements DialerControllerDelegate.DialerPhoneState
{
  private static final e a = ViberEnv.getLogger();
  private final Handler b;
  private final Engine c;
  private final DialerPhoneStateListener d;
  private final a e;
  private boolean f;

  public c(Engine paramEngine, DialerPhoneStateListener paramDialerPhoneStateListener, a parama)
  {
    this.c = paramEngine;
    this.d = paramDialerPhoneStateListener;
    this.e = parama;
    this.b = av.e.a.a();
  }

  private void c()
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        c.a(c.this).a();
      }
    });
  }

  public void a()
  {
    try
    {
      if (!this.f)
      {
        this.f = true;
        this.c.registerDelegate(this);
        this.d.registerDelegate(new DialerControllerDelegate.DialerPhoneState[] { this });
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b()
  {
    try
    {
      if (this.f)
      {
        this.f = false;
        this.c.removeDelegate(this);
        this.d.removeDelegate(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onGSMStateChange(int paramInt, String paramString)
  {
    if (paramInt != 0)
      c();
  }

  public void onPhoneStateChanged(int paramInt)
  {
    if (paramInt != 0)
      c();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.c
 * JD-Core Version:    0.6.2
 */