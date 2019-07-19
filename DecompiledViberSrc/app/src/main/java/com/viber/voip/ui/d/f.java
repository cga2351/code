package com.viber.voip.ui.d;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.TimeAware.Clock;
import com.viber.voip.ViberEnv;
import com.viber.voip.widget.ag.b;
import com.viber.voip.widget.ag.c;
import com.viber.voip.widget.ag.g;

public class f extends e
{
  private static Logger a = ViberEnv.getLogger();
  private final ag.g b;
  private ag.b c;

  public f(String paramString)
  {
    this(paramString, false);
  }

  public f(String paramString, boolean paramBoolean)
  {
    this.b = new ag.g(paramString, paramBoolean);
    this.b.setClock(a(this.b.a()));
  }

  private TimeAware.Clock a(double paramDouble)
  {
    if (this.c == null)
      this.c = new ag.b(paramDouble);
    while (true)
    {
      return this.c;
      this.c.a(paramDouble);
    }
  }

  public void a()
  {
    double d = this.b.a();
    this.b.setClock(new ag.c(d));
  }

  public void a(int paramInt)
  {
    this.b.a(paramInt);
    invalidateSelf();
  }

  public void a(TimeAware.Clock paramClock)
  {
    this.b.setClock(paramClock);
  }

  public double b()
  {
    return this.b.a();
  }

  public void draw(Canvas paramCanvas)
  {
    this.b.a(paramCanvas, this.d, 0, 0, getBounds().width(), getBounds().height());
    if (this.b.c())
      invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.d.f
 * JD-Core Version:    0.6.2
 */