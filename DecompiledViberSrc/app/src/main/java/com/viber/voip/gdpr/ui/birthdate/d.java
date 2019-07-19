package com.viber.voip.gdpr.ui.birthdate;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.gdpr.e;
import com.viber.voip.gdpr.f;
import com.viber.voip.util.cl;
import java.text.DateFormat;

class d
  implements a.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final f b;
  private com.viber.common.b.d c;
  private a.b d;
  private DateFormat e;
  private a.c f;
  private e g;

  d(a.b paramb, DateFormat paramDateFormat, f paramf, com.viber.common.b.d paramd)
  {
    this.d = paramb;
    this.e = paramDateFormat;
    this.b = paramf;
    this.c = paramd;
    this.f = ((a.c)cl.b(a.c.class));
  }

  private void e()
  {
    this.f.a(com.viber.voip.gdpr.d.c, com.viber.voip.gdpr.d.d, com.viber.voip.gdpr.d.e, com.viber.voip.gdpr.d.d(), com.viber.voip.gdpr.d.e());
  }

  public void a()
  {
    this.f = ((a.c)cl.b(a.c.class));
  }

  public void a(int paramInt)
  {
    this.c.a(2);
    this.b.a(paramInt);
    this.d.a();
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = e.a(paramInt1, paramInt2, paramInt3);
    this.f.a(this.g.a(this.e));
  }

  public void a(a.c paramc, boolean paramBoolean)
  {
    this.f = paramc;
    try
    {
      e();
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
    }
  }

  public void b()
  {
    this.c.a(2);
    this.b.a(this.g.b());
    this.d.a();
  }

  public void c()
  {
    this.f.a();
  }

  public void d()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.birthdate.d
 * JD-Core Version:    0.6.2
 */