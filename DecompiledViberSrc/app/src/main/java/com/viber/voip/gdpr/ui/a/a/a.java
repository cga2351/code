package com.viber.voip.gdpr.ui.a.a;

import android.content.Context;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;
import com.viber.voip.ui.dialogs.a.c.b;
import com.viber.voip.ui.dialogs.j;

public class a
  implements com.viber.voip.gdpr.ui.a.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;

  public a(Context paramContext)
  {
    this.b = paramContext;
  }

  public void a()
  {
    j.e().d();
  }

  public void a(int paramInt)
  {
    g.a(this.b).a().c(paramInt);
  }

  public void a(int paramInt, String paramString)
  {
    g.a(this.b).a().b(paramInt, paramString);
  }

  public void a(int paramInt1, String paramString, int paramInt2)
  {
    g.a(this.b).a().b(paramInt1, paramString, paramInt2);
  }

  public void a(String paramString)
  {
    j.a(paramString).a(new c.b()).d();
  }

  public void a(String paramString, int paramInt)
  {
    j.b(paramString, paramInt).a(new c.b()).d();
  }

  public void b()
  {
    j.b().a(new c.b()).d();
  }

  public void b(int paramInt)
  {
    g.a(this.b).a().d(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.a.a.a
 * JD-Core Version:    0.6.2
 */