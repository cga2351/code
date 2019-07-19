package com.viber.voip.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;

public class q
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final Logger a = ViberEnv.getLogger();
  private final View b;
  private final a c;
  private final float d;
  private int e;
  private final float f;
  private boolean g;

  public q(View paramView, float paramFloat, a parama)
  {
    this.b = paramView;
    this.c = parama;
    this.d = j.a(50.0F);
    this.f = paramFloat;
  }

  private void a(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      if (paramBoolean)
        this.c.a();
    }
    else
    {
      return;
    }
    this.c.b();
  }

  private int c()
  {
    if (this.e == 0)
      d();
    return this.e;
  }

  private void d()
  {
    Rect localRect = new Rect();
    this.b.getWindowVisibleDisplayFrame(localRect);
    this.e = ((int)((localRect.bottom - localRect.top) * this.f));
  }

  public void a()
  {
    dj.a(this.b, this);
  }

  public void b()
  {
    dj.b(this.b, this);
  }

  public void onGlobalLayout()
  {
    int i = c() - this.b.getHeight();
    if (i < 0)
      d();
    if (i > this.d);
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.q
 * JD-Core Version:    0.6.2
 */