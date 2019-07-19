package com.viber.voip.gdpr.ui.a.b;

import android.content.Context;
import com.viber.common.dialogs.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;
import com.viber.voip.ui.dialogs.a.c.c;
import com.viber.voip.ui.dialogs.a.c.d;
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
    j.d().d();
  }

  public void a(int paramInt)
  {
    g.a(this.b).a().a(paramInt);
  }

  public void a(int paramInt1, int paramInt2)
  {
    g.a(this.b).a().a(paramInt1, paramInt2);
  }

  public void a(int paramInt, String paramString)
  {
    g.a(this.b).a().a(paramInt, paramString);
  }

  public void a(int paramInt1, String paramString, int paramInt2)
  {
    g.a(this.b).a().a(paramInt1, paramString, paramInt2);
  }

  public void a(String paramString)
  {
    j.a(paramString).a(new c.d()).d();
  }

  public void a(String paramString, int paramInt)
  {
    j.a(paramString, paramInt).a(new c.d()).d();
  }

  public void b()
  {
    j.b().a(new c.d()).d();
  }

  public void b(int paramInt)
  {
    g.a(this.b).a().b(paramInt);
  }

  public void c(int paramInt)
  {
    j.a(paramInt).a(new c.c()).d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.a.b.a
 * JD-Core Version:    0.6.2
 */