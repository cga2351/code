package com.swmansion.gesturehandler;

import android.view.MotionEvent;

public class n extends b<n>
{
  private m d;
  private double e;
  private double f;
  private m.a g = new m.a()
  {
    public boolean a(m paramAnonymousm)
    {
      double d = n.a(n.this);
      n.a(n.this, n.a(n.this) + paramAnonymousm.a());
      long l = paramAnonymousm.b();
      if (l > 0L)
        n.b(n.this, (n.a(n.this) - d) / l);
      if ((Math.abs(n.a(n.this)) >= 0.08726646259971647D) && (n.this.i() == 2))
        n.this.l();
      return true;
    }

    public boolean b(m paramAnonymousm)
    {
      return true;
    }

    public void c(m paramAnonymousm)
    {
      n.this.n();
    }
  };

  public n()
  {
    a(false);
  }

  protected void a(MotionEvent paramMotionEvent)
  {
    int i = i();
    if (i == 0)
    {
      this.f = 0.0D;
      this.e = 0.0D;
      this.d = new m(this.g);
      m();
    }
    if (this.d != null)
      this.d.a(paramMotionEvent);
    if (paramMotionEvent.getActionMasked() == 1)
    {
      if (i == 4)
        n();
    }
    else
      return;
    k();
  }

  protected void b()
  {
    this.d = null;
    this.f = 0.0D;
    this.e = 0.0D;
  }

  public double t()
  {
    return this.e;
  }

  public double u()
  {
    return this.f;
  }

  public float v()
  {
    if (this.d == null)
      return (0.0F / 0.0F);
    return this.d.c();
  }

  public float w()
  {
    if (this.d == null)
      return (0.0F / 0.0F);
    return this.d.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.n
 * JD-Core Version:    0.6.2
 */