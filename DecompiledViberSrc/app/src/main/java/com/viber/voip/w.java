package com.viber.voip;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.util.ba;
import com.viber.voip.util.ba.a;
import com.viber.voip.util.cv;
import com.viber.voip.util.cv.a;

public class w
  implements ba.a, cv.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b;
  private final cv c;
  private final ba d;
  private final ProfileNotification e;
  private final boolean f;
  private a g;
  private final Runnable h = new x(this);

  public w(Handler paramHandler, cv paramcv, ba paramba, ProfileNotification paramProfileNotification, boolean paramBoolean)
  {
    this.b = paramHandler;
    this.c = paramcv;
    this.d = paramba;
    this.e = paramProfileNotification;
    this.f = paramBoolean;
  }

  private void d()
  {
    int i = this.c.d();
    if (this.g != null)
      this.g.a(0, i);
  }

  private void e()
  {
    boolean bool = b();
    a locala;
    if (this.g != null)
    {
      locala = this.g;
      if (!bool)
        break label32;
    }
    label32: for (int i = 1; ; i = 0)
    {
      locala.a(2, i);
      return;
    }
  }

  private boolean f()
  {
    return (!this.f) && (this.e.showBadge());
  }

  private void g()
  {
    if (this.c.b());
    for (int i = 1; ; i = 0)
    {
      if (this.g != null)
        this.g.a(3, i);
      return;
    }
  }

  public void a()
  {
    this.d.c();
    this.c.b(this);
    this.g = null;
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    e();
  }

  public void a(a parama)
  {
    this.g = parama;
    this.d.a(this);
    this.c.a(this);
    d();
    e();
    g();
  }

  public boolean b()
  {
    return (this.d.a() > 0) || (!this.d.b()) || (f()) || (this.c.b());
  }

  public void onBadgeValueChanged(int paramInt1, int paramInt2)
  {
    if ((2 == paramInt1) || (paramInt1 == 0) || (3 == paramInt1))
      this.b.post(this.h);
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.w
 * JD-Core Version:    0.6.2
 */