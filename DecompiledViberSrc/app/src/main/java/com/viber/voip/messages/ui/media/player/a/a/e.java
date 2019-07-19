package com.viber.voip.messages.ui.media.player.a.a;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class e extends a
{
  private static final Interpolator a = new DecelerateInterpolator();
  private static final Interpolator h = new AccelerateInterpolator();
  protected final View g;

  public e(View paramView)
  {
    this(paramView, b, c);
  }

  public e(View paramView, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
    this.g = paramView;
  }

  protected void c()
  {
    this.g.animate().cancel();
    this.g.setAlpha(1.0F);
    this.g.setVisibility(0);
  }

  protected void e()
  {
    this.g.animate().cancel();
    this.g.setVisibility(8);
  }

  public final boolean f()
  {
    return this.g.getVisibility() == 0;
  }

  protected void h()
  {
    com.viber.voip.ui.b.a.a(this.g, this.e, a);
  }

  protected void i()
  {
    com.viber.voip.ui.b.a.b(this.g, this.e, h);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.a.e
 * JD-Core Version:    0.6.2
 */