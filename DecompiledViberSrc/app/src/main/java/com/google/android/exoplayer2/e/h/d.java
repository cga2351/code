package com.google.android.exoplayer2.e.h;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class d
{
  private String a;
  private String b;
  private List<String> c;
  private String d;
  private String e;
  private int f;
  private boolean g;
  private int h;
  private boolean i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private float o;
  private Layout.Alignment p;

  public d()
  {
    a();
  }

  private static int a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    int i1 = -1;
    if ((paramString1.isEmpty()) || (paramInt1 == i1))
      i1 = paramInt1;
    while (!paramString1.equals(paramString2))
      return i1;
    return paramInt1 + paramInt2;
  }

  public int a(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    int i2;
    if ((this.a.isEmpty()) && (this.b.isEmpty()) && (this.c.isEmpty()) && (this.d.isEmpty()))
    {
      boolean bool2 = paramString2.isEmpty();
      i2 = 0;
      if (bool2)
        i2 = 1;
    }
    int i1;
    boolean bool1;
    do
    {
      do
      {
        return i2;
        i1 = a(a(a(0, this.a, paramString1, 1073741824), this.b, paramString2, 2), this.d, paramString3, 4);
        i2 = 0;
      }
      while (i1 == -1);
      bool1 = Arrays.asList(paramArrayOfString).containsAll(this.c);
      i2 = 0;
    }
    while (!bool1);
    return i1 + 4 * this.c.size();
  }

  public d a(int paramInt)
  {
    this.f = paramInt;
    this.g = true;
    return this;
  }

  public d a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      this.k = i1;
      return this;
    }
  }

  public void a()
  {
    this.a = "";
    this.b = "";
    this.c = Collections.emptyList();
    this.d = "";
    this.e = null;
    this.g = false;
    this.i = false;
    this.j = -1;
    this.k = -1;
    this.l = -1;
    this.m = -1;
    this.n = -1;
    this.p = null;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void a(String[] paramArrayOfString)
  {
    this.c = Arrays.asList(paramArrayOfString);
  }

  public int b()
  {
    if ((this.l == -1) && (this.m == -1))
      return -1;
    if (this.l == 1);
    for (int i1 = 1; ; i1 = 0)
    {
      int i2 = this.m;
      int i3 = 0;
      if (i2 == 1)
        i3 = 2;
      return i1 | i3;
    }
  }

  public d b(int paramInt)
  {
    this.h = paramInt;
    this.i = true;
    return this;
  }

  public d b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      this.l = i1;
      return this;
    }
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public d c(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      this.m = i1;
      return this;
    }
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }

  public boolean c()
  {
    return this.j == 1;
  }

  public d d(String paramString)
  {
    this.e = ag.d(paramString);
    return this;
  }

  public boolean d()
  {
    return this.k == 1;
  }

  public String e()
  {
    return this.e;
  }

  public int f()
  {
    if (!this.g)
      throw new IllegalStateException("Font color not defined");
    return this.f;
  }

  public boolean g()
  {
    return this.g;
  }

  public int h()
  {
    if (!this.i)
      throw new IllegalStateException("Background color not defined.");
    return this.h;
  }

  public boolean i()
  {
    return this.i;
  }

  public Layout.Alignment j()
  {
    return this.p;
  }

  public int k()
  {
    return this.n;
  }

  public float l()
  {
    return this.o;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h.d
 * JD-Core Version:    0.6.2
 */