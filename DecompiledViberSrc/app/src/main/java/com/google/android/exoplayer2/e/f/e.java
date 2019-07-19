package com.google.android.exoplayer2.e.f;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.g.a;

final class e
{
  private String a;
  private int b;
  private boolean c;
  private int d;
  private boolean e;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private float k;
  private String l;
  private e m;
  private Layout.Alignment n;

  private e a(e parame, boolean paramBoolean)
  {
    if (parame != null)
    {
      if ((!this.c) && (parame.c))
        a(parame.b);
      if (this.h == -1)
        this.h = parame.h;
      if (this.i == -1)
        this.i = parame.i;
      if (this.a == null)
        this.a = parame.a;
      if (this.f == -1)
        this.f = parame.f;
      if (this.g == -1)
        this.g = parame.g;
      if (this.n == null)
        this.n = parame.n;
      if (this.j == -1)
      {
        this.j = parame.j;
        this.k = parame.k;
      }
      if ((paramBoolean) && (!this.e) && (parame.e))
        b(parame.d);
    }
    return this;
  }

  public int a()
  {
    if ((this.h == -1) && (this.i == -1))
      return -1;
    if (this.h == 1);
    for (int i1 = 1; ; i1 = 0)
    {
      int i2 = this.i;
      int i3 = 0;
      if (i2 == 1)
        i3 = 2;
      return i1 | i3;
    }
  }

  public e a(float paramFloat)
  {
    this.k = paramFloat;
    return this;
  }

  public e a(int paramInt)
  {
    if (this.m == null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.b = paramInt;
      this.c = true;
      return this;
    }
  }

  public e a(Layout.Alignment paramAlignment)
  {
    this.n = paramAlignment;
    return this;
  }

  public e a(e parame)
  {
    return a(parame, true);
  }

  public e a(String paramString)
  {
    if (this.m == null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.a = paramString;
      return this;
    }
  }

  public e a(boolean paramBoolean)
  {
    int i1 = 1;
    boolean bool;
    if (this.m == null)
    {
      bool = i1;
      a.b(bool);
      if (!paramBoolean)
        break label31;
    }
    while (true)
    {
      this.f = i1;
      return this;
      bool = false;
      break;
      label31: i1 = 0;
    }
  }

  public e b(int paramInt)
  {
    this.d = paramInt;
    this.e = true;
    return this;
  }

  public e b(String paramString)
  {
    this.l = paramString;
    return this;
  }

  public e b(boolean paramBoolean)
  {
    int i1 = 1;
    boolean bool;
    if (this.m == null)
    {
      bool = i1;
      a.b(bool);
      if (!paramBoolean)
        break label31;
    }
    while (true)
    {
      this.g = i1;
      return this;
      bool = false;
      break;
      label31: i1 = 0;
    }
  }

  public boolean b()
  {
    return this.f == 1;
  }

  public e c(int paramInt)
  {
    this.j = paramInt;
    return this;
  }

  public e c(boolean paramBoolean)
  {
    int i1 = 1;
    boolean bool;
    if (this.m == null)
    {
      bool = i1;
      a.b(bool);
      if (!paramBoolean)
        break label31;
    }
    while (true)
    {
      this.h = i1;
      return this;
      bool = false;
      break;
      label31: i1 = 0;
    }
  }

  public boolean c()
  {
    return this.g == 1;
  }

  public e d(boolean paramBoolean)
  {
    int i1 = 1;
    boolean bool;
    if (this.m == null)
    {
      bool = i1;
      a.b(bool);
      if (!paramBoolean)
        break label31;
    }
    while (true)
    {
      this.i = i1;
      return this;
      bool = false;
      break;
      label31: i1 = 0;
    }
  }

  public String d()
  {
    return this.a;
  }

  public int e()
  {
    if (!this.c)
      throw new IllegalStateException("Font color has not been defined.");
    return this.b;
  }

  public boolean f()
  {
    return this.c;
  }

  public int g()
  {
    if (!this.e)
      throw new IllegalStateException("Background color has not been defined.");
    return this.d;
  }

  public boolean h()
  {
    return this.e;
  }

  public String i()
  {
    return this.l;
  }

  public Layout.Alignment j()
  {
    return this.n;
  }

  public int k()
  {
    return this.j;
  }

  public float l()
  {
    return this.k;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.f.e
 * JD-Core Version:    0.6.2
 */