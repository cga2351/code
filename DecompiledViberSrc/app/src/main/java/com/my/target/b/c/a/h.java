package com.my.target.b.c.a;

import com.my.target.common.a.b;
import com.my.target.j;
import com.my.target.q;
import java.util.ArrayList;
import java.util.List;

public final class h extends e
{
  private final List<b> C = new ArrayList();
  private final List<b> D = new ArrayList();
  private b E;
  private b F;

  public static h H()
  {
    return new h();
  }

  public static h a(j paramj)
  {
    h localh = H();
    localh.j(paramj.k());
    String str = paramj.E();
    if (str != null)
    {
      localh.f(b.a(str, paramj.u(), paramj.i()));
      localh.y().a(paramj.y(), 0.0F);
      localh.A = paramj.A;
    }
    return localh;
  }

  public final List<b> I()
  {
    return new ArrayList(this.C);
  }

  public final List<b> J()
  {
    return new ArrayList(this.D);
  }

  public final b K()
  {
    return this.E;
  }

  public final b L()
  {
    return this.F;
  }

  public final void d(b paramb)
  {
    this.E = paramb;
  }

  public final void e(b paramb)
  {
    this.F = paramb;
  }

  public final void f(b paramb)
  {
    this.C.add(paramb);
  }

  public final void g(b paramb)
  {
    this.D.add(paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.c.a.h
 * JD-Core Version:    0.6.2
 */