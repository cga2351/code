package com.viber.voip.engagement;

import com.viber.common.permission.c;
import com.viber.voip.permissions.n;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.cj.b;
import com.viber.voip.util.cl;

class e
{
  private final cj a;
  private final c b;
  private final f c;
  private g d = (g)cl.b(g.class);
  private boolean e;
  private final cj.b f = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      g localg = e.a(e.this);
      if (paramAnonymousInt1 == -1);
      for (boolean bool = true; ; bool = false)
      {
        localg.a(bool);
        return;
      }
    }
  };

  public e(cj paramcj, c paramc, f paramf)
  {
    this.a = paramcj;
    this.b = paramc;
    this.c = paramf;
    this.a.a(this.f);
  }

  public void a()
  {
    if (!this.b.a(n.j))
      this.c.a();
  }

  public void a(g paramg)
  {
    this.d = paramg;
    a();
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void b()
  {
    if (this.e)
      this.d.a();
  }

  public void c()
  {
    this.a.b(this.f);
    this.d = ((g)cl.b(g.class));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.e
 * JD-Core Version:    0.6.2
 */