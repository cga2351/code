package com.viber.voip.settings.ui.personal.delete;

import com.viber.voip.gdpr.a.a.a.a;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;

public class c
  implements a.a
{
  private final a a;
  private final cj b;
  private a.b c;
  private a.c d;

  c(a parama, cj paramcj, a.b paramb)
  {
    this.a = parama;
    this.b = paramcj;
    this.c = paramb;
    this.d = ((a.c)cl.b(a.c.class));
  }

  public void a()
  {
    this.d = ((a.c)cl.b(a.c.class));
  }

  public void a(a.c paramc, boolean paramBoolean)
  {
    this.d = paramc;
  }

  public void b()
  {
    if (this.b.b())
    {
      this.d.a(this.a.d());
      return;
    }
    this.d.a();
  }

  public void c()
  {
    if (this.b.b())
    {
      this.a.b();
      this.c.a();
      return;
    }
    this.d.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.personal.delete.c
 * JD-Core Version:    0.6.2
 */