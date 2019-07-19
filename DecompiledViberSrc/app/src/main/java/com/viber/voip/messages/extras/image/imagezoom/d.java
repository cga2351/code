package com.viber.voip.messages.extras.image.imagezoom;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class d
{
  private final Context a;
  private final a b;
  private boolean c;
  private MotionEvent d;
  private MotionEvent e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private long q;
  private final float r;
  private float s;
  private float t;
  private boolean u;

  public d(Context paramContext, a parama)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.a = paramContext;
    this.b = parama;
    this.r = localViewConfiguration.getScaledEdgeSlop();
  }

  private static float a(MotionEvent paramMotionEvent, int paramInt)
  {
    if (paramMotionEvent.getPointerCount() > paramInt);
    while (true)
    {
      return paramMotionEvent.getX() - paramMotionEvent.getRawX() + paramMotionEvent.getX(paramInt);
      paramInt = 0;
    }
  }

  private static float b(MotionEvent paramMotionEvent, int paramInt)
  {
    if (paramMotionEvent.getPointerCount() > paramInt);
    while (true)
    {
      return paramMotionEvent.getY() - paramMotionEvent.getRawY() + paramMotionEvent.getY(paramInt);
      paramInt = 0;
    }
  }

  private void b(MotionEvent paramMotionEvent)
  {
    if (this.e != null)
      this.e.recycle();
    this.e = MotionEvent.obtain(paramMotionEvent);
    this.l = -1.0F;
    this.m = -1.0F;
    this.n = -1.0F;
    MotionEvent localMotionEvent = this.d;
    float f1 = localMotionEvent.getX(0);
    float f2 = localMotionEvent.getY(0);
    float f3 = localMotionEvent.getX(1);
    float f4 = localMotionEvent.getY(1);
    float f5 = paramMotionEvent.getX(0);
    float f6 = paramMotionEvent.getY(0);
    float f7 = paramMotionEvent.getX(1);
    float f8 = paramMotionEvent.getY(1);
    float f9 = f3 - f1;
    float f10 = f4 - f2;
    float f11 = f7 - f5;
    float f12 = f8 - f6;
    this.h = f9;
    this.i = f10;
    this.j = f11;
    this.k = f12;
    this.f = (f5 + f11 * 0.5F);
    this.g = (f6 + f12 * 0.5F);
    this.q = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
    this.o = (paramMotionEvent.getPressure(0) + paramMotionEvent.getPressure(1));
    this.p = (localMotionEvent.getPressure(0) + localMotionEvent.getPressure(1));
  }

  private void g()
  {
    if (this.d != null)
    {
      this.d.recycle();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.recycle();
      this.e = null;
    }
    this.u = false;
    this.c = false;
  }

  public boolean a()
  {
    return this.c;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (!this.c)
      switch (i1 & 0xFF)
      {
      case 3:
      case 4:
      default:
      case 5:
      case 2:
      case 6:
      }
    while (true)
    {
      return true;
      DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
      this.s = (localDisplayMetrics.widthPixels - this.r);
      this.t = (localDisplayMetrics.heightPixels - this.r);
      g();
      this.d = MotionEvent.obtain(paramMotionEvent);
      this.q = 0L;
      try
      {
        b(paramMotionEvent);
        float f8 = this.r;
        float f9 = this.s;
        float f10 = this.t;
        float f11 = paramMotionEvent.getRawX();
        float f12 = paramMotionEvent.getRawY();
        float f13 = a(paramMotionEvent, 1);
        float f14 = b(paramMotionEvent, 1);
        int i8;
        if ((f11 < f8) || (f12 < f8) || (f11 > f9) || (f12 > f10))
        {
          i8 = 1;
          if ((f13 >= f8) && (f14 >= f8) && (f13 <= f9) && (f14 <= f10))
            break label267;
        }
        label267: for (int i9 = 1; ; i9 = 0)
        {
          if ((i8 == 0) || (i9 == 0))
            break label273;
          this.f = -1.0F;
          this.g = -1.0F;
          this.u = true;
          return true;
          i8 = 0;
          break;
        }
        label273: if ((i8 != 0) && (paramMotionEvent.getPointerCount() >= 2))
        {
          this.f = paramMotionEvent.getX(1);
          this.g = paramMotionEvent.getY(1);
          this.u = true;
          return true;
        }
        if (i9 != 0)
        {
          this.f = paramMotionEvent.getX(0);
          this.g = paramMotionEvent.getY(0);
          this.u = true;
          return true;
        }
        this.c = this.b.b(this);
        return true;
        if (!this.u)
          continue;
        float f1 = this.r;
        float f2 = this.s;
        float f3 = this.t;
        float f4 = paramMotionEvent.getRawX();
        float f5 = paramMotionEvent.getRawY();
        float f6 = a(paramMotionEvent, 1);
        float f7 = b(paramMotionEvent, 1);
        int i6;
        if ((f4 < f1) || (f5 < f1) || (f4 > f2) || (f5 > f3))
        {
          i6 = 1;
          if ((f6 >= f1) && (f7 >= f1) && (f6 <= f2) && (f7 <= f3))
            break label508;
        }
        label508: for (int i7 = 1; ; i7 = 0)
        {
          if ((i6 == 0) || (i7 == 0))
            break label514;
          this.f = -1.0F;
          this.g = -1.0F;
          return true;
          i6 = 0;
          break;
        }
        label514: if ((i6 != 0) && (paramMotionEvent.getPointerCount() >= 2))
        {
          this.f = paramMotionEvent.getX(1);
          this.g = paramMotionEvent.getY(1);
          return true;
        }
        if (i7 != 0)
        {
          this.f = paramMotionEvent.getX(0);
          this.g = paramMotionEvent.getY(0);
          return true;
        }
        this.u = false;
        this.c = this.b.b(this);
        return true;
        if (!this.u)
          continue;
        int i4 = (i1 & 0xFF00) >> 8;
        int i5 = 0;
        if (i4 == 0)
          i5 = 1;
        this.f = paramMotionEvent.getX(i5);
        this.g = paramMotionEvent.getY(i5);
        return true;
        switch (i1 & 0xFF)
        {
        case 4:
        case 5:
        default:
          return true;
        case 2:
        case 6:
        case 3:
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException3)
      {
        try
        {
          while (true)
          {
            b(paramMotionEvent);
            label687: if ((this.o / this.p <= 0.67F) || (!this.b.a(this)))
              break;
            this.d.recycle();
            this.d = MotionEvent.obtain(paramMotionEvent);
            return true;
            try
            {
              b(paramMotionEvent);
              label737: int i2 = (i1 & 0xFF00) >> 8;
              int i3 = 0;
              if (i2 == 0)
                i3 = 1;
              this.f = paramMotionEvent.getX(i3);
              this.g = paramMotionEvent.getY(i3);
              if (!this.u)
                this.b.c(this);
              g();
              return true;
              if (!this.u)
                this.b.c(this);
              g();
              return true;
              localIllegalArgumentException3 = localIllegalArgumentException3;
            }
            catch (IllegalArgumentException localIllegalArgumentException1)
            {
              break label737;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          break label687;
        }
      }
    }
  }

  public float b()
  {
    return this.f;
  }

  public float c()
  {
    return this.g;
  }

  public float d()
  {
    if (this.l == -1.0F)
    {
      float f1 = this.j;
      float f2 = this.k;
      this.l = ((float)Math.sqrt(f1 * f1 + f2 * f2));
    }
    return this.l;
  }

  public float e()
  {
    if (this.m == -1.0F)
    {
      float f1 = this.h;
      float f2 = this.i;
      this.m = ((float)Math.sqrt(f1 * f1 + f2 * f2));
    }
    return this.m;
  }

  public float f()
  {
    if (this.n == -1.0F)
      this.n = (d() / e());
    return this.n;
  }

  public static abstract interface a
  {
    public abstract boolean a(d paramd);

    public abstract boolean b(d paramd);

    public abstract void c(d paramd);
  }

  public static class b
    implements d.a
  {
    public boolean a(d paramd)
    {
      return false;
    }

    public boolean b(d paramd)
    {
      return true;
    }

    public void c(d paramd)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.image.imagezoom.d
 * JD-Core Version:    0.6.2
 */