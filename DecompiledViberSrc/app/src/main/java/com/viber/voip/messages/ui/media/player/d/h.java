package com.viber.voip.messages.ui.media.player.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import com.viber.common.a.e;
import com.viber.common.d.a;
import com.viber.voip.R.dimen;
import com.viber.voip.R.fraction;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.util.dj;

public class h
  implements m
{
  private static final e a = ViberEnv.getLogger();
  private final Context b;
  private final Resources c;
  private final boolean d;
  private boolean e;
  private final float f;
  private final e.a g;
  private final int h;
  private final Rect i = new Rect();
  private final Rect j = new Rect();
  private final Rect k = new Rect();
  private final RectF l = new RectF();
  private final Matrix m = new Matrix();
  private int n;
  private int o;
  private final i p;
  private final d q;
  private final c r;

  public h(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, Point paramPoint, e.a parama)
  {
    this.b = paramContext;
    this.c = paramContext.getResources();
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramFloat;
    this.g = parama;
    this.h = this.c.getDimensionPixelSize(R.dimen.player_minimized_min_scale_delta);
    this.p = new i(paramContext.getResources(), new i.a()
    {
      public void a(int paramAnonymousInt)
      {
        h.a(h.this, paramAnonymousInt);
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = h.a(h.this).left;
        int j = h.a(h.this).top;
        h.a(h.this).offsetTo(paramAnonymousInt1, paramAnonymousInt2);
        h.a(h.this, i, j, h.a(h.this).left, h.a(h.this).top);
      }

      public void b(int paramAnonymousInt)
      {
        int i = h.a(h.this).top;
        h.a(h.this).offsetTo(h.a(h.this).left, paramAnonymousInt);
        h.a(h.this, i, h.a(h.this).top);
      }
    }
    , dj.i(this.b));
    this.q = new d(new d.a()
    {
      public void a(int paramAnonymousInt)
      {
        h.a(h.this, paramAnonymousInt);
      }

      public void a(boolean paramAnonymousBoolean)
      {
        h.b(h.this).a(paramAnonymousBoolean);
      }
    });
    a(paramPoint);
    this.r = l();
  }

  private int a(int paramInt)
  {
    return (int)(paramInt * this.f);
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
      this.g.a(paramInt3, paramInt4);
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    float f1 = paramInt / this.i.width();
    this.m.reset();
    this.m.postScale(f1, f1, this.i.left, this.i.top);
    this.l.set(this.i);
    this.m.mapRect(this.l);
    int i1 = a(paramInt);
    this.i.left = Math.round(this.l.left);
    this.i.top = Math.round(this.l.top);
    this.i.right = (paramInt + this.i.left);
    this.i.bottom = (i1 + this.i.top);
    m();
    if (!paramBoolean)
      this.g.a(paramInt, i1, f());
  }

  private void a(Point paramPoint)
  {
    this.j.set(0, 0, paramPoint.x, paramPoint.y);
    this.o = p();
    this.n = o();
    this.p.a(this.j);
  }

  private int b(Rect paramRect)
  {
    int i3;
    if (this.i.left < paramRect.left)
      i3 = paramRect.left - this.i.left;
    int i1;
    int i2;
    do
    {
      return i3;
      i1 = this.i.right;
      i2 = paramRect.right;
      i3 = 0;
    }
    while (i1 <= i2);
    return paramRect.right - this.i.right;
  }

  private void b(int paramInt)
  {
    int i1 = this.i.left;
    this.i.offsetTo(paramInt, this.i.top);
    b(i1, this.i.left);
  }

  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
      this.g.a(paramInt2, this.i.top);
  }

  private int c(int paramInt)
  {
    if (paramInt < this.o)
      paramInt = this.o;
    while (paramInt <= this.n)
      return paramInt;
    return this.n;
  }

  private int c(Rect paramRect)
  {
    int i3;
    if (this.i.top < paramRect.top)
      i3 = paramRect.top - this.i.top;
    int i1;
    int i2;
    do
    {
      return i3;
      i1 = this.i.bottom;
      i2 = paramRect.bottom;
      i3 = 0;
    }
    while (i1 <= i2);
    return paramRect.bottom - this.i.bottom;
  }

  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
      this.g.a(this.i.left, paramInt2);
  }

  private void d(Rect paramRect)
  {
    this.i.offset(b(paramRect), c(paramRect));
  }

  private c l()
  {
    if (a.g())
      return new b(null);
    return new a(av.e.a.a());
  }

  private void m()
  {
    int i1 = this.i.width() / 2;
    this.k.set(this.j.left - i1, this.j.top, i1 + this.j.right, this.j.bottom);
  }

  private void n()
  {
    this.p.c();
    this.q.a();
  }

  private int o()
  {
    return (int)(this.c.getFraction(R.fraction.player_minimized_width_percentage_max, 1, 1) * this.j.width());
  }

  private int p()
  {
    return (int)(this.c.getFraction(R.fraction.player_minimized_width_percentage_min, 1, 1) * this.j.width());
  }

  public Rect a()
  {
    int i1 = (int)(this.c.getFraction(R.fraction.player_minimized_width_percentage_default, 1, 1) * this.j.width());
    int i2 = a(i1);
    int i3;
    int i4;
    if ((this.e) || (this.d))
    {
      i3 = this.j.width() - i1 - this.p.b();
      if (this.d)
        i4 = dj.i(this.b) + this.p.a();
    }
    while (true)
    {
      return new Rect(i3, i4, i1 + i3, i2 + i4);
      i4 = this.p.a();
      continue;
      i3 = (this.j.width() - i1) / 2;
      i4 = dj.i(this.b) + this.p.a();
    }
  }

  public void a(Rect paramRect)
  {
    this.i.set(paramRect);
    a(c(this.i.width()), true);
    int i1 = this.p.b(paramRect);
    int i2 = this.p.c(paramRect);
    this.i.offset(i1, i2);
    m();
  }

  public void a(j paramj, int paramInt)
  {
    this.r.b(paramj, paramInt);
  }

  public void a(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      n();
      this.e = paramBoolean;
      a(this.g.a());
      int i1 = this.i.width();
      int i2 = c(i1);
      if (i2 == i1)
        break label68;
      a(i2, false);
    }
    while (true)
    {
      this.p.a(this.i, false);
      return;
      label68: m();
    }
  }

  public boolean a(float paramFloat, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    n();
    int i1 = this.i.left;
    int i2 = this.i.top;
    int i3 = this.i.width();
    int i4 = Math.round(paramFloat * i3);
    boolean bool2;
    if (Math.abs(i3 - i4) > this.h)
    {
      bool2 = bool1;
      if (i4 <= this.n)
        break label151;
      i4 = this.n;
    }
    while (true)
    {
      if ((Math.abs(i3 - i4) > this.h) || ((bool1) && (i3 != i4)))
      {
        a(i4, false);
        d(this.j);
        a(i1, i2, this.i.left, this.i.top);
      }
      return bool2;
      bool2 = false;
      break;
      label151: if (i4 < this.o)
        i4 = this.o;
      else
        bool1 = false;
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    n();
    int i1 = this.i.left;
    int i2 = this.i.top;
    this.i.offset(paramInt1, paramInt2);
    d(this.k);
    a(i1, i2, this.i.left, this.i.top);
    return true;
  }

  public int b()
  {
    return this.i.left;
  }

  public int c()
  {
    return this.i.top;
  }

  public int d()
  {
    return this.i.width();
  }

  public int e()
  {
    return this.i.height();
  }

  public float f()
  {
    float f1 = this.n - this.o;
    return (this.i.width() - this.o) / f1;
  }

  public void g()
  {
    this.p.a(this.i, true);
  }

  public float h()
  {
    int i1 = Math.max(this.j.left - this.i.left, this.i.right - this.j.right);
    int i2 = this.i.width();
    if ((i1 > 0) && (i2 > 0))
      return Math.min(1.0F, i1 / i2);
    return 0.0F;
  }

  public void i()
  {
    n();
  }

  public void j()
  {
    n();
    this.q.a(this.i, this.j);
  }

  public boolean k()
  {
    return this.q.b();
  }

  private class a extends h.c
  {
    private final Handler c;

    public a(Handler arg2)
    {
      super(null);
      Object localObject;
      this.c = localObject;
    }

    public void a(final j paramj, final int paramInt)
    {
      paramj.a();
      b();
      this.c.post(new Runnable()
      {
        public void run()
        {
          if (h.g(h.this).b())
            return;
          h.a.this.a(paramInt);
          paramj.b();
        }
      });
    }
  }

  private class b extends h.c
  {
    private b()
    {
      super(null);
    }

    public void a(j paramj, int paramInt)
    {
      b();
      a(paramInt);
    }
  }

  private abstract class c
  {
    private c()
    {
    }

    protected void a(int paramInt)
    {
      if (paramInt == 1)
      {
        h.a(h.this).offsetTo(h.a(h.this).left, 0);
        h.a(h.this, h.f(h.this));
        h.c(h.this).a(h.a(h.this), false);
      }
      while ((h.a(h.this).left >= h.f(h.this).right - h.a(h.this).width()) && (h.a(h.this).top <= h.f(h.this).top))
        return;
      h.a(h.this).offsetTo(h.f(h.this).right - h.a(h.this).width(), 0);
      h.a(h.this, h.f(h.this));
      h.c(h.this).a(h.a(h.this), false);
    }

    protected abstract void a(j paramj, int paramInt);

    protected boolean a()
    {
      return h.a(h.this).width() == h.d(h.this);
    }

    protected void b()
    {
      h.a(h.this, h.e(h.this), false);
    }

    public final void b(j paramj, int paramInt)
    {
      if (a())
      {
        h.c(h.this).c();
        a(paramj, paramInt);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.h
 * JD-Core Version:    0.6.2
 */