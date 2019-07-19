package com.viber.voip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.AndroidSvgObject;
import com.viber.svg.jni.TimeAware;
import com.viber.svg.jni.TimeAware.Clock;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.ct;
import java.io.File;

public class ag extends View
{
  private static Logger c = ViberEnv.getLogger();
  protected g[] a = new g[2];
  protected b b;

  public ag(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public ag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public ag(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    setLayerType(1, null);
  }

  protected TimeAware.Clock b(double paramDouble)
  {
    if (this.b == null)
      this.b = new b(paramDouble);
    while (true)
    {
      return this.b;
      this.b.a(paramDouble);
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.a.length;
    for (int j = 0; j < i; j++)
    {
      g localg = this.a[j];
      if (localg != null)
      {
        localg.a(paramCanvas, 0, 0, getWidth(), getHeight());
        if (localg.c())
          invalidate();
      }
    }
  }

  protected static abstract class a
    implements TimeAware.Clock
  {
    protected double a = 0.0D;
    protected double b = 1.0D;

    a(double paramDouble)
    {
      this.b = paramDouble;
    }

    a(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }

    protected double a()
    {
      return this.b;
    }

    public a a(double paramDouble)
    {
      this.b = paramDouble;
      return this;
    }
  }

  public static class b extends ag.a
  {
    private long c = SystemClock.elapsedRealtime();

    public b(double paramDouble)
    {
      super();
    }

    public double getCurrentTime()
    {
      return (SystemClock.elapsedRealtime() - this.c) / 1000.0D % this.b + this.a;
    }

    public boolean isTimeFrozen()
    {
      return false;
    }
  }

  public static class c extends ag.a
  {
    protected double c = SystemClock.elapsedRealtime();
    protected boolean d = false;
    private a e;

    public c(double paramDouble)
    {
      super();
    }

    public c(double paramDouble1, double paramDouble2)
    {
      super(paramDouble2);
    }

    public c a(a parama)
    {
      this.e = parama;
      return this;
    }

    public void b()
    {
      this.c = SystemClock.elapsedRealtime();
      this.d = false;
    }

    protected double c()
    {
      return this.a + (SystemClock.elapsedRealtime() - this.c) / 1000.0D;
    }

    public double getCurrentTime()
    {
      if (!isTimeFrozen())
        return c();
      return this.a + this.b;
    }

    public boolean isTimeFrozen()
    {
      if ((!this.d) && (c() < this.a + this.b))
        return false;
      if ((!this.d) && (this.e != null))
        this.e.onAnimationEnd();
      this.d = true;
      return true;
    }

    public static abstract interface a
    {
      public abstract void onAnimationEnd();
    }
  }

  protected static class d extends ag.a
  {
    private double c = 0.0D;

    public d(double paramDouble)
    {
      super();
    }

    public d(double paramDouble1, double paramDouble2)
    {
      super(paramDouble2);
    }

    public d b(double paramDouble)
    {
      this.c = paramDouble;
      return this;
    }

    public double getCurrentTime()
    {
      return this.a + this.c * this.b;
    }

    public boolean isTimeFrozen()
    {
      return true;
    }
  }

  protected static class e extends ag.c
  {
    public e(double paramDouble)
    {
      super();
    }

    public e(double paramDouble1, double paramDouble2)
    {
      super(paramDouble2);
    }

    public double getCurrentTime()
    {
      return this.a + a() - (super.getCurrentTime() - this.a);
    }
  }

  protected static class f
    implements TimeAware.Clock
  {
    protected final double a;

    public f(double paramDouble)
    {
      this.a = paramDouble;
    }

    public double getCurrentTime()
    {
      return this.a;
    }

    public boolean isTimeFrozen()
    {
      return true;
    }
  }

  public static class g extends ag.i
  {
    public g(String paramString)
    {
      this(paramString, false);
    }

    public g(String paramString, boolean paramBoolean)
    {
      super(paramBoolean);
    }

    private void d()
    {
      if (this.b == null)
        if (!this.f)
          break label39;
      label39: for (AndroidSvgObject localAndroidSvgObject = ct.b(this.c); ; localAndroidSvgObject = ct.a(this.c))
      {
        this.b = localAndroidSvgObject;
        this.d = this.b.getMaxTime();
        return;
      }
    }

    public double a()
    {
      d();
      return this.d;
    }

    public void a(int paramInt)
    {
      d();
      this.b.setCurrentColor(paramInt);
    }

    public void a(Canvas paramCanvas, double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      d();
      double d = 0.0D;
      try
      {
        if (this.e != null)
          d = this.e.getCurrentTime();
        this.b.renderToArea(paramCanvas, paramDouble, paramInt1, paramInt2, paramInt3, paramInt4, d);
        return;
      }
      finally
      {
      }
    }
  }

  public static class h extends ag.i
  {
    boolean a;
    private Handler g = av.a(av.e.f);
    private Handler h = av.a(av.e.a);

    public h(String paramString, boolean paramBoolean)
    {
      super(paramBoolean);
    }

    private void e()
    {
      if (this.b == null)
        if (!this.f)
          break label39;
      label39: for (AndroidSvgObject localAndroidSvgObject = ct.b(this.c); ; localAndroidSvgObject = ct.a(this.c))
      {
        this.b = localAndroidSvgObject;
        this.d = this.b.getMaxTime();
        return;
      }
    }

    public double a()
    {
      if (this.b == null)
        return 0.0D;
      return this.d;
    }

    public void a(Canvas paramCanvas, double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.b == null)
        return;
      double d = 0.0D;
      try
      {
        if (this.e != null)
          d = this.e.getCurrentTime();
        this.b.renderToArea(paramCanvas, paramDouble, paramInt1, paramInt2, paramInt3, paramInt4, d);
        return;
      }
      finally
      {
      }
    }

    public void a(final a parama)
    {
      if (this.b != null)
        parama.a();
      this.g.post(new Runnable()
      {
        public void run()
        {
          if ((ag.h.this.f) && (!new File(ag.h.this.c).exists()))
          {
            ag.h.a(ag.h.this).post(new Runnable()
            {
              public void run()
              {
                ag.h.1.this.a.b();
              }
            });
            return;
          }
          ag.h.b(ag.h.this);
          ag.h.a(ag.h.this).post(new Runnable()
          {
            public void run()
            {
              ag.h.this.a = true;
              ag.h.1.this.a.a();
            }
          });
        }
      });
    }

    public boolean d()
    {
      return this.a;
    }

    public static abstract interface a
    {
      public abstract void a();

      public abstract void b();
    }
  }

  protected static abstract class i
    implements TimeAware
  {
    protected volatile AndroidSvgObject b;
    protected final String c;
    protected volatile double d = 1.0D;
    protected TimeAware.Clock e;
    protected boolean f;

    public i(String paramString, boolean paramBoolean)
    {
      this.c = paramString;
      this.f = paramBoolean;
    }

    abstract void a(Canvas paramCanvas, double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      a(paramCanvas, 1.0D, paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public TimeAware.Clock b()
    {
      return this.e;
    }

    public boolean c()
    {
      try
      {
        if (this.e != null)
        {
          boolean bool2 = this.e.isTimeFrozen();
          if (!bool2)
          {
            bool1 = true;
            return bool1;
          }
        }
        boolean bool1 = false;
      }
      finally
      {
      }
    }

    public void setClock(TimeAware.Clock paramClock)
    {
      try
      {
        this.e = paramClock;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ag
 * JD-Core Version:    0.6.2
 */