package com.viber.voip.ui;

import android.content.Context;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.ViberActionRunner.bq;
import com.viber.voip.util.an;

public class am
{
  private static final Logger a = ViberEnv.getLogger();
  private final z b;
  private final Context c;
  private final ViberActionRunner.bq d;
  private volatile boolean e = false;
  private final d.a f = new d.a()
  {
    public void a()
    {
    }

    public void b()
    {
    }

    public void c()
    {
      am.a(am.this).a();
    }
  };

  public am(Context paramContext, z paramz, ViberActionRunner.bq parambq)
  {
    this.c = paramContext;
    this.b = paramz;
    this.d = parambq;
  }

  private void h()
  {
    ad.v().d();
  }

  private void i()
  {
    com.viber.common.dialogs.z.a(this.c, DialogCode.D_SYNCING_HISTORY_TO_DESKTOP);
  }

  public void a()
  {
    if (this.e)
      return;
    this.e = true;
    this.b.a();
    this.b.registerCallback(this.f);
  }

  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }

  public void a(String paramString)
  {
  }

  public void b()
  {
    g.a(this.c).a().f();
  }

  public void b(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    do
    {
      return;
      this.b.hideAlertWindow();
      i();
      return;
      this.b.hideAlertWindow();
      return;
      i();
      return;
      an.a(this.c);
      this.b.showAlertWindow();
      return;
    }
    while (this.b.isAlertWindowPendingVisible());
    h();
  }

  public void c()
  {
    g.a(this.c).a().h();
  }

  public void d()
  {
    g.a(this.c).a().j();
  }

  public void e()
  {
    g.a(this.c).a().k();
  }

  public void f()
  {
    ad.u().d();
  }

  public void g()
  {
    com.viber.common.dialogs.z.a(this.c, DialogCode.D_APPROVE_SYNC_HISTORY_TO_DESKTOP);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.am
 * JD-Core Version:    0.6.2
 */