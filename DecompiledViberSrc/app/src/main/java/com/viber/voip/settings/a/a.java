package com.viber.voip.settings.a;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class a
{
  private static d a = b.a;
  private static c b = c.a;
  private static a c = d.a;
  private static a d = e.a;
  private final int e;
  private final int f;
  private final d g;
  private final d h;
  private final c i;
  private final d j;
  private final a k;
  private final a l;
  private final a m;
  private final a n;

  private a(b paramb)
  {
    this.e = b.a(paramb);
    this.g = b.b(paramb);
    this.h = b.c(paramb);
    this.i = b.d(paramb);
    this.j = b.e(paramb);
    this.k = b.f(paramb);
    this.l = b.g(paramb);
    this.m = b.h(paramb);
    this.n = b.i(paramb);
    this.f = b.j(paramb);
  }

  public int a()
  {
    return this.e;
  }

  public CharSequence b()
  {
    return this.g.getText();
  }

  public CharSequence c()
  {
    return this.h.getText();
  }

  public Drawable d()
  {
    return this.i.a();
  }

  public CharSequence e()
  {
    return this.j.getText();
  }

  public boolean f()
  {
    return this.j.getText() != null;
  }

  public boolean g()
  {
    return this.k.get();
  }

  public boolean h()
  {
    return this.l.get();
  }

  public boolean i()
  {
    return this.m.get();
  }

  public boolean j()
  {
    return this.n.get();
  }

  public int k()
  {
    return this.f;
  }

  public static abstract interface a
  {
    public abstract boolean get();
  }

  public static class b
  {
    private final Context a;
    private final int b;
    private final int c;
    private a.d d = a.p();
    private a.d e = a.p();
    private a.c f = a.q();
    private a.d g = a.p();
    private a.a h = a.r();
    private a.a i = a.s();
    private a.a j = a.s();
    private a.a k = a.s();

    public b(Context paramContext, int paramInt)
    {
      this(paramContext, paramInt, 0);
    }

    public b(Context paramContext, int paramInt1, int paramInt2)
    {
      this.a = paramContext;
      this.b = paramInt1;
      this.c = paramInt2;
    }

    public b a(int paramInt)
    {
      return a(new f(this, paramInt));
    }

    public b a(a.a parama)
    {
      this.h = parama;
      return this;
    }

    public b a(a.c paramc)
    {
      this.f = paramc;
      return this;
    }

    public b a(a.d paramd)
    {
      this.d = paramd;
      return this;
    }

    public b a(boolean paramBoolean)
    {
      return a(new i(paramBoolean));
    }

    public a a()
    {
      return new a(this, null);
    }

    public b b(int paramInt)
    {
      return b(new g(this, paramInt));
    }

    public b b(a.a parama)
    {
      this.i = parama;
      return this;
    }

    public b b(a.d paramd)
    {
      this.e = paramd;
      return this;
    }

    public b c(int paramInt)
    {
      return a(new h(this, paramInt));
    }

    public b c(a.a parama)
    {
      this.j = parama;
      return this;
    }

    public b c(a.d paramd)
    {
      this.g = paramd;
      return this;
    }

    public b d(a.a parama)
    {
      this.k = parama;
      return this;
    }
  }

  public static abstract interface c
  {
    public abstract Drawable a();
  }

  public static abstract interface d
  {
    public abstract CharSequence getText();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.a.a
 * JD-Core Version:    0.6.2
 */