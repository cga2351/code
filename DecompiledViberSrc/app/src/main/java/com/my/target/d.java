package com.my.target;

import android.content.Context;
import android.graphics.Rect;

public class d
{
  private final Rect a;
  private final Rect b;
  private final Rect c;
  private final Rect d;
  private final Rect e;
  private final Rect f;
  private final Rect g;
  private final Rect h;
  private final bj i;

  private d(Context paramContext)
  {
    this(bj.a(paramContext));
  }

  d(bj parambj)
  {
    this.i = parambj;
    this.a = new Rect();
    this.b = new Rect();
    this.c = new Rect();
    this.d = new Rect();
    this.e = new Rect();
    this.f = new Rect();
    this.g = new Rect();
    this.h = new Rect();
  }

  public static d a(Context paramContext)
  {
    return new d(paramContext);
  }

  private void a(Rect paramRect1, Rect paramRect2)
  {
    paramRect2.set(this.i.e(paramRect1.left), this.i.e(paramRect1.top), this.i.e(paramRect1.right), this.i.e(paramRect1.bottom));
  }

  public Rect a()
  {
    return this.d;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a.set(0, 0, paramInt1, paramInt2);
    a(this.a, this.b);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e.set(paramInt1, paramInt2, paramInt3, paramInt4);
    a(this.e, this.f);
  }

  public Rect b()
  {
    return this.f;
  }

  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.set(paramInt1, paramInt2, paramInt3, paramInt4);
    a(this.c, this.d);
  }

  public Rect c()
  {
    return this.h;
  }

  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g.set(paramInt1, paramInt2, paramInt3, paramInt4);
    a(this.g, this.h);
  }

  public Rect d()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.d
 * JD-Core Version:    0.6.2
 */