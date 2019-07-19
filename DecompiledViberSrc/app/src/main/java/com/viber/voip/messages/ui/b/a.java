package com.viber.voip.messages.ui.b;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;

public class a
{
  private static final e a = ViberEnv.getLogger();
  private int b = 0;
  private final View c;
  private final b d;
  private float e;
  private final a f = new a(null);
  private final a g = new a(null);
  private final Point h = new Point();
  private double i;
  private boolean j = false;

  public a(View paramView, b paramb)
  {
    this.c = paramView;
    this.e = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.d = paramb;
  }

  private double a(a parama1, a parama2)
  {
    return Math.sqrt(Math.pow(parama1.a - parama2.a, 2.0D) + Math.pow(parama1.b - parama2.b, 2.0D));
  }

  private int a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    int k = 0;
    int m = paramMotionEvent.getPointerCount();
    while (k < m)
    {
      int n = paramMotionEvent.getPointerId(k);
      if ((n != paramInt1) && (n != paramInt2))
        return k;
      k++;
    }
    return -1;
  }

  private void a()
  {
    b();
    this.i = a(this.f, this.g);
  }

  private void b()
  {
    this.h.x = Math.round((this.f.a + this.g.a) / 2.0F);
    this.h.y = Math.round((this.f.b + this.g.b) / 2.0F);
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int k = 1;
    int m = paramMotionEvent.getActionMasked();
    if ((!this.j) && (m != 0))
      return false;
    switch (m)
    {
    case 4:
    default:
    case 0:
    case 2:
    case 5:
    case 6:
      while (true)
      {
        return k;
        this.b = 0;
        this.f.a(paramMotionEvent);
        this.g.a();
        this.j = k;
        k = 0;
        continue;
        switch (this.b)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
        while (this.b == 0)
        {
          k = 0;
          break;
          this.g.a(paramMotionEvent);
          int i6 = Math.round(this.g.a - this.f.a);
          int i7 = Math.round(this.g.b - this.f.b);
          if ((Math.abs(i6) >= this.e) || (Math.abs(i7) >= this.e))
          {
            this.b = k;
            this.f.a(this.g);
            continue;
            this.g.a(paramMotionEvent);
            int i4 = Math.round(this.g.a - this.f.a);
            int i5 = Math.round(this.g.b - this.f.b);
            if (((i4 != 0) || (i5 != 0)) && (this.d.onDrag(i4, i5)))
            {
              this.f.a(this.g);
              continue;
              this.f.a(this.c, paramMotionEvent);
              this.g.a(this.c, paramMotionEvent);
              double d1 = a(this.f, this.g);
              if ((this.i > 0.001D) && (d1 > 0.001D))
              {
                float f1 = (float)(d1 / this.i);
                if (this.d.onScale(f1, this.h.x, this.h.y))
                {
                  this.i = d1;
                  b();
                }
              }
            }
          }
        }
        if (this.b != 2)
        {
          if (this.g.b())
            this.f.a(this.g);
          this.g.a(this.c, paramMotionEvent, paramMotionEvent.getActionIndex());
          a();
          this.b = 2;
          continue;
          int n = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
          int i1 = this.f.c;
          int i2 = this.g.c;
          boolean bool;
          if (n == i1)
          {
            this.f.a(this.g);
            this.g.a();
            bool = k;
          }
          while (true)
            if (paramMotionEvent.getPointerCount() > 2)
            {
              if (!bool)
                break;
              int i3 = a(paramMotionEvent, i1, i2);
              if (i3 >= 0)
              {
                this.g.a(this.c, paramMotionEvent, i3);
                a();
                break;
                bool = false;
                if (n != i2)
                  continue;
                this.g.a();
                bool = k;
                continue;
              }
              this.b = k;
              break;
            }
          if (bool)
            this.b = k;
        }
      }
    case 1:
    case 3:
    }
    this.j = false;
    this.f.a();
    this.g.a();
    if (this.b != 0);
    while (true)
    {
      this.b = 0;
      if (k == 0)
        break;
      this.d.onGesturesComplete();
      break;
      k = 0;
    }
  }

  private static class a
  {
    public float a;
    public float b;
    public int c = -1;
    private final int[] d = new int[2];

    private boolean b(View paramView, MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt >= 0)
      {
        paramView.getLocationOnScreen(this.d);
        this.a = (this.d[0] + paramMotionEvent.getX(paramInt));
        this.b = (this.d[1] + paramMotionEvent.getY(paramInt));
        return true;
      }
      return false;
    }

    public void a()
    {
      this.a = 0.0F;
      this.b = 0.0F;
      this.c = -1;
    }

    public void a(MotionEvent paramMotionEvent)
    {
      this.a = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
      this.c = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
    }

    public void a(View paramView, MotionEvent paramMotionEvent)
    {
      b(paramView, paramMotionEvent, paramMotionEvent.findPointerIndex(this.c));
    }

    public void a(View paramView, MotionEvent paramMotionEvent, int paramInt)
    {
      if (b(paramView, paramMotionEvent, paramInt))
        this.c = paramMotionEvent.getPointerId(paramInt);
    }

    public void a(a parama)
    {
      this.a = parama.a;
      this.b = parama.b;
      this.c = parama.c;
    }

    public boolean b()
    {
      return this.c != -1;
    }

    public String toString()
    {
      return "ActiveEvent{x=" + this.a + ", y=" + this.b + ", pointerId=" + this.c + '}';
    }
  }

  public static abstract interface b
  {
    public abstract boolean onDrag(int paramInt1, int paramInt2);

    public abstract void onGesturesComplete();

    public abstract boolean onScale(float paramFloat, int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.b.a
 * JD-Core Version:    0.6.2
 */