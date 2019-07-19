package com.viber.voip.settings.ui.personal.request;

import com.viber.voip.gdpr.a.a.b.a;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;

class c
{
  private final a a;
  private final cj b;
  private a.a c;
  private a.b d;

  c(a.a parama, a parama1, cj paramcj)
  {
    this.b = paramcj;
    this.a = parama1;
    this.c = parama;
    this.d = ((a.b)cl.b(a.b.class));
  }

  public void a()
  {
    this.d = ((a.b)cl.b(a.b.class));
    this.c = ((a.a)cl.b(a.a.class));
  }

  public void a(a.b paramb, boolean paramBoolean)
  {
    this.d = paramb;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b.b())
      {
        this.a.b();
        this.c.a();
      }
    }
    else
      return;
    this.d.a();
  }

  public void b()
  {
    if (this.b.b())
    {
      this.d.b();
      return;
    }
    this.d.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.personal.request.c
 * JD-Core Version:    0.6.2
 */