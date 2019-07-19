package com.d.a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint.Align;
import android.view.ContextThemeWrapper;

public class e
{
  private int a;
  private int b;
  private int c;
  private a d = a.a;
  private float e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private Paint.Align m;

  public e()
  {
    n();
  }

  private void n()
  {
    this.a = -1;
    this.b = -1;
    this.c = -12303292;
    this.e = 30.0F;
    this.i = 120;
    this.j = 10;
    this.k = 10;
    this.l = 0;
    this.m = Paint.Align.LEFT;
  }

  public int a()
  {
    return this.c;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(Context paramContext)
  {
    if ((paramContext instanceof ContextThemeWrapper))
    {
      TypedArray localTypedArray = ((ContextThemeWrapper)paramContext).getTheme().obtainStyledAttributes(new int[] { 16842806 });
      int n = localTypedArray.getColor(0, l());
      localTypedArray.recycle();
      c(n);
      a(n);
    }
  }

  public a b()
  {
    return this.d;
  }

  public void b(int paramInt)
  {
    this.i = paramInt;
  }

  public int c()
  {
    return this.b;
  }

  public void c(int paramInt)
  {
    this.a = paramInt;
  }

  public int d()
  {
    return this.j;
  }

  public int e()
  {
    return this.k;
  }

  public int f()
  {
    return this.i;
  }

  public int g()
  {
    return this.l;
  }

  public int h()
  {
    return this.h;
  }

  public int i()
  {
    return this.g;
  }

  public float j()
  {
    return this.e;
  }

  public Paint.Align k()
  {
    return this.m;
  }

  public int l()
  {
    return this.a;
  }

  public int m()
  {
    return this.f;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }

    public boolean a()
    {
      return (this == a) || ((this == b) && (this != d));
    }

    public boolean b()
    {
      return (this == a) || ((this == c) && (this != d));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.d.a.e
 * JD-Core Version:    0.6.2
 */