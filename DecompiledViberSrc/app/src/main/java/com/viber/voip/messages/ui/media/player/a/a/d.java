package com.viber.voip.messages.ui.media.player.a.a;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.viber.voip.ui.b.a;
import com.viber.voip.util.ch;
import com.viber.voip.util.dj;

public final class d extends b
{
  private static final Interpolator h = new DecelerateInterpolator();
  private static final Interpolator i = new AccelerateInterpolator();
  protected final View g;

  public d(View paramView)
  {
    this(paramView, b, c);
  }

  public d(View paramView, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
    this.g = paramView;
  }

  protected void c()
  {
    super.c();
    if (ch.d(this.a))
      this.g.setAlpha(1.0F);
    View[] arrayOfView = new View[1];
    if (ch.d(this.a));
    for (View localView = this.g; ; localView = null)
    {
      arrayOfView[0] = localView;
      a(true, arrayOfView);
      return;
    }
  }

  protected void e()
  {
    super.e();
    View[] arrayOfView = new View[1];
    if (!ch.c(this.a, true));
    for (View localView = this.g; ; localView = null)
    {
      arrayOfView[0] = localView;
      a(false, arrayOfView);
      return;
    }
  }

  public final boolean f()
  {
    return this.g.getVisibility() == 0;
  }

  protected void h()
  {
    if (ch.d(this.a))
      a.a(this.g, this.e, h);
  }

  protected void i()
  {
    if (ch.c(this.a, true))
      return;
    if (ch.d(this.a))
    {
      a.b(this.g, this.e, i);
      return;
    }
    dj.b(this.g, false);
  }

  protected void j()
  {
    View[] arrayOfView = new View[1];
    arrayOfView[0] = this.g;
    a(arrayOfView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.a.d
 * JD-Core Version:    0.6.2
 */