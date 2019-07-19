package com.viber.voip.stickers.ui;

import com.viber.dexshared.Logger;
import com.viber.svg.jni.TimeAware.Clock;
import com.viber.voip.ViberEnv;

public class b
  implements TimeAware.Clock
{
  private static final Logger b = ViberEnv.getLogger();
  a a;
  private long c;
  private long d;
  private double e;
  private boolean f = false;
  private int g = 0;

  public b(double paramDouble, a parama)
  {
    this.d = (()Math.floor(1000.0D * paramDouble));
    a(parama);
  }

  public void a()
  {
    if (this.c == 0L)
      this.c = System.currentTimeMillis();
    long l = System.currentTimeMillis() - this.c;
    if (l >= this.d)
    {
      l = this.d;
      if (this.a != null)
        this.a.a();
    }
    this.e = (l / 1000.0D);
  }

  public void a(a parama)
  {
    this.a = parama;
  }

  public void b()
  {
    this.f = true;
    this.e = (this.d / 1000.0D);
  }

  public void c()
  {
    if (this.f)
      return;
    this.f = true;
  }

  public void d()
  {
    if (!this.f)
      return;
    this.c = (System.currentTimeMillis() - ()(1000.0D * this.e));
    this.f = false;
  }

  public double getCurrentTime()
  {
    double d1 = this.e;
    if (!isTimeFrozen())
    {
      this.g = (1 + this.g);
      a();
    }
    return d1;
  }

  public boolean isTimeFrozen()
  {
    return this.f;
  }

  static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.ui.b
 * JD-Core Version:    0.6.2
 */