package com.viber.voip.ui.d;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.TimeAware.Clock;
import com.viber.voip.ViberEnv;
import com.viber.voip.widget.ag.c;
import com.viber.voip.widget.ag.h;
import com.viber.voip.widget.ag.h.a;

public class d extends e
{
  private static Logger a = ViberEnv.getLogger();
  private final ag.h b;

  public d(String paramString, boolean paramBoolean)
  {
    this.b = new ag.h(paramString, paramBoolean);
  }

  public void a()
  {
    if (!this.b.d())
      return;
    a(new ag.c(this.b.a()));
  }

  public void a(TimeAware.Clock paramClock)
  {
    if (!this.b.d())
      return;
    this.b.setClock(paramClock);
    invalidateSelf();
  }

  public void a(ag.h.a parama)
  {
    this.b.a(parama);
  }

  public void draw(Canvas paramCanvas)
  {
    if (!this.b.d());
    do
    {
      return;
      this.b.a(paramCanvas, this.d, 0, 0, getBounds().width(), getBounds().height());
    }
    while (!this.b.c());
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.d.d
 * JD-Core Version:    0.6.2
 */