package com.swmansion.gesturehandler;

import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import java.util.Arrays;

public class b<T extends b>
{
  private static int d = 11;
  private static MotionEvent.PointerProperties[] e;
  private static MotionEvent.PointerCoords[] f;
  int a;
  boolean b;
  boolean c;
  private final int[] g = new int[d];
  private int h = 0;
  private int i;
  private View j;
  private int k = 0;
  private float l;
  private float m;
  private boolean n;
  private boolean o = true;
  private float[] p;
  private float q;
  private float r;
  private float s;
  private float t;
  private boolean u;
  private int v = 0;
  private d w;
  private i<T> x;
  private c y;

  private static void a(int paramInt)
  {
    if (e == null)
    {
      e = new MotionEvent.PointerProperties[d];
      f = new MotionEvent.PointerCoords[d];
    }
    while ((paramInt > 0) && (e[(paramInt - 1)] == null))
    {
      e[(paramInt - 1)] = new MotionEvent.PointerProperties();
      f[(paramInt - 1)] = new MotionEvent.PointerCoords();
      paramInt--;
    }
  }

  private static boolean a(float paramFloat)
  {
    return !Float.isNaN(paramFloat);
  }

  private void b(int paramInt)
  {
    if (this.k == paramInt)
      return;
    int i1 = this.k;
    this.k = paramInt;
    this.w.a(this, paramInt, i1);
    b(paramInt, i1);
  }

  private boolean d(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (paramMotionEvent.getPointerCount() != this.h)
    {
      bool = true;
      return bool;
    }
    for (int i1 = 0; ; i1++)
    {
      int i2 = this.g.length;
      bool = false;
      if (i1 >= i2)
        break;
      if ((this.g[i1] != -1) && (this.g[i1] != i1))
        return true;
    }
  }

  private MotionEvent e(MotionEvent paramMotionEvent)
  {
    if (!d(paramMotionEvent))
      return paramMotionEvent;
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = -1;
    int i5;
    if ((i1 == 0) || (i1 == 5))
    {
      int i3 = paramMotionEvent.getActionIndex();
      int i4 = paramMotionEvent.getPointerId(i3);
      if (this.g[i4] != -1)
        if (this.h == 1)
        {
          i5 = 0;
          i1 = i5;
          i2 = i3;
        }
    }
    int i6;
    float f1;
    float f2;
    int i8;
    while (true)
    {
      a(this.h);
      i6 = 0;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent.setLocation(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
      int i7 = paramMotionEvent.getPointerCount();
      i8 = i1;
      for (int i9 = 0; i9 < i7; i9++)
      {
        int i10 = paramMotionEvent.getPointerId(i9);
        if (this.g[i10] != -1)
        {
          paramMotionEvent.getPointerProperties(i9, e[i6]);
          e[i6].id = this.g[i10];
          paramMotionEvent.getPointerCoords(i9, f[i6]);
          if (i9 == i2)
            i8 |= i6 << 8;
          i6++;
        }
      }
      i5 = 5;
      break;
      i5 = 2;
      break;
      if ((i1 == 1) || (i1 == 6))
      {
        int i11 = paramMotionEvent.getActionIndex();
        int i12 = paramMotionEvent.getPointerId(i11);
        if (this.g[i12] != -1)
        {
          if (this.h == 1);
          for (int i13 = 1; ; i13 = 6)
          {
            i1 = i13;
            i2 = i11;
            break;
          }
        }
        i1 = 2;
        i2 = i11;
      }
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), i8, i6, e, f, paramMotionEvent.getMetaState(), paramMotionEvent.getButtonState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags(), paramMotionEvent.getSource(), paramMotionEvent.getFlags());
    paramMotionEvent.setLocation(f1, f2);
    localMotionEvent.setLocation(f1, f2);
    return localMotionEvent;
  }

  private int t()
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 < this.h);
      for (int i2 = 0; ; i2++)
        if ((i2 >= this.g.length) || (this.g[i2] == i1))
        {
          if (i2 != this.g.length)
            break;
          return i1;
        }
    }
  }

  public T a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.p == null)
      this.p = new float[6];
    this.p[0] = paramFloat1;
    this.p[1] = paramFloat2;
    this.p[2] = paramFloat3;
    this.p[3] = paramFloat4;
    this.p[4] = paramFloat5;
    this.p[5] = paramFloat6;
    if ((a(paramFloat5)) && (a(paramFloat1)) && (a(paramFloat3)))
      throw new IllegalArgumentException("Cannot have all of left, right and width defined");
    if ((a(paramFloat5)) && (!a(paramFloat1)) && (!a(paramFloat3)))
      throw new IllegalArgumentException("When width is set one of left or right pads need to be defined");
    if ((a(paramFloat6)) && (a(paramFloat4)) && (a(paramFloat2)))
      throw new IllegalArgumentException("Cannot have all of top, bottom and height defined");
    if ((a(paramFloat6)) && (!a(paramFloat4)) && (!a(paramFloat2)))
      throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined");
    return this;
  }

  public T a(c paramc)
  {
    this.y = paramc;
    return this;
  }

  public b a(i<T> parami)
  {
    this.x = parami;
    return this;
  }

  public T a(boolean paramBoolean)
  {
    this.u = paramBoolean;
    return this;
  }

  protected void a()
  {
  }

  void a(int paramInt1, int paramInt2)
  {
    if (this.x != null)
      this.x.a(this, paramInt1, paramInt2);
  }

  protected void a(MotionEvent paramMotionEvent)
  {
    b(1);
  }

  public final void a(View paramView, d paramd)
  {
    if ((this.j != null) || (this.w != null))
      throw new IllegalStateException("Already prepared or hasn't been reset");
    Arrays.fill(this.g, -1);
    this.h = 0;
    this.k = 0;
    this.j = paramView;
    this.w = paramd;
  }

  public boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    float f1 = paramView.getWidth();
    float f2 = paramView.getHeight();
    float f5;
    float f7;
    float f3;
    float f4;
    float f9;
    float f10;
    if (this.p != null)
    {
      f5 = this.p[0];
      float f6 = this.p[1];
      f7 = this.p[2];
      float f8 = this.p[3];
      if (a(f5))
      {
        f3 = 0.0F - f5;
        boolean bool = a(f6);
        f4 = 0.0F;
        if (bool)
          f4 = 0.0F - f8;
        if (a(f7))
          f1 += f7;
        if (a(f8))
          f2 += f8;
        f9 = this.p[4];
        f10 = this.p[5];
        if (a(f9))
        {
          if (!a(f5))
            f3 = f7 - f9;
        }
        else
          label157: if (a(f10))
          {
            if (a(f4))
              break label228;
            f4 = f2 - f10;
          }
      }
    }
    while (true)
    {
      if ((paramFloat1 >= f3) && (paramFloat1 <= f1) && (paramFloat2 >= f4) && (paramFloat2 <= f2))
      {
        return true;
        if (a(f7))
          break label157;
        f1 = f5 + f9;
        break label157;
        label228: if (a(f2))
          continue;
        f2 = f4 + f10;
        continue;
      }
      return false;
      f3 = 0.0F;
      break;
      f3 = 0.0F;
      f4 = 0.0F;
    }
  }

  public boolean a(b paramb)
  {
    for (int i1 = 0; ; i1++)
    {
      int i2 = this.g.length;
      boolean bool = false;
      if (i1 < i2)
      {
        if ((this.g[i1] != -1) && (paramb.g[i1] != -1))
          bool = true;
      }
      else
        return bool;
    }
  }

  public T b(boolean paramBoolean)
  {
    if (this.j != null)
      j();
    this.o = paramBoolean;
    return this;
  }

  protected void b()
  {
  }

  protected void b(int paramInt1, int paramInt2)
  {
  }

  void b(MotionEvent paramMotionEvent)
  {
    if (this.x != null)
      this.x.a(this, paramMotionEvent);
  }

  public boolean b(b paramb)
  {
    if ((paramb != this) && (this.y != null))
      return this.y.b(this, paramb);
    return false;
  }

  public void c(int paramInt)
  {
    this.i = paramInt;
  }

  public final void c(MotionEvent paramMotionEvent)
  {
    if ((!this.o) || (this.k == 3) || (this.k == 1) || (this.k == 5) || (this.h < 1));
    MotionEvent localMotionEvent;
    do
    {
      do
      {
        return;
        localMotionEvent = e(paramMotionEvent);
        this.l = localMotionEvent.getX();
        this.m = localMotionEvent.getY();
        this.v = localMotionEvent.getPointerCount();
        this.n = a(this.j, this.l, this.m);
        if ((!this.u) || (this.n))
          break;
        if (this.k == 4)
        {
          j();
          return;
        }
      }
      while (this.k != 2);
      k();
      return;
      this.q = f.a(localMotionEvent, true);
      this.r = f.b(localMotionEvent, true);
      this.s = (localMotionEvent.getRawX() - localMotionEvent.getX());
      this.t = (localMotionEvent.getRawY() - localMotionEvent.getY());
      a(localMotionEvent);
    }
    while (localMotionEvent == paramMotionEvent);
    localMotionEvent.recycle();
  }

  public boolean c()
  {
    return this.o;
  }

  public boolean c(b paramb)
  {
    if ((paramb != this) && (this.y != null))
      return this.y.a(this, paramb);
    return false;
  }

  public int d()
  {
    return this.i;
  }

  public void d(int paramInt)
  {
    if (this.g[paramInt] == -1)
    {
      this.g[paramInt] = t();
      this.h = (1 + this.h);
    }
  }

  public boolean d(b paramb)
  {
    if (paramb == this)
      return true;
    if (this.y != null)
      return this.y.c(this, paramb);
    return false;
  }

  public View e()
  {
    return this.j;
  }

  public void e(int paramInt)
  {
    if (this.g[paramInt] != -1)
    {
      this.g[paramInt] = -1;
      this.h = (-1 + this.h);
    }
  }

  public boolean e(b paramb)
  {
    if (paramb == this);
    while (this.y == null)
      return false;
    return this.y.d(this, paramb);
  }

  public int f()
  {
    return this.v;
  }

  public boolean g()
  {
    return this.n;
  }

  public boolean h()
  {
    return (this.o) && (this.k != 1) && (this.k != 3) && (this.k != 5) && (this.h > 0);
  }

  public int i()
  {
    return this.k;
  }

  public final void j()
  {
    if ((this.k == 4) || (this.k == 0) || (this.k == 2))
    {
      a();
      b(3);
    }
  }

  public final void k()
  {
    if ((this.k == 4) || (this.k == 0) || (this.k == 2))
      b(1);
  }

  public final void l()
  {
    if ((this.k == 0) || (this.k == 2))
      b(4);
  }

  public final void m()
  {
    if (this.k == 0)
      b(2);
  }

  public final void n()
  {
    if ((this.k == 2) || (this.k == 4))
      b(5);
  }

  public final void o()
  {
    this.j = null;
    this.w = null;
    Arrays.fill(this.g, -1);
    this.h = 0;
    b();
  }

  public float p()
  {
    return this.q;
  }

  public float q()
  {
    return this.r;
  }

  public float r()
  {
    return this.q - this.s;
  }

  public float s()
  {
    return this.r - this.t;
  }

  public String toString()
  {
    if (this.j == null);
    for (String str = null; ; str = this.j.getClass().getSimpleName())
      return getClass().getSimpleName() + "@[" + this.i + "]:" + str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.b
 * JD-Core Version:    0.6.2
 */