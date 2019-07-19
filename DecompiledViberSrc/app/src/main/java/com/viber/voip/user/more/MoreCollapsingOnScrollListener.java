package com.viber.voip.user.more;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.viber.voip.widget.ObservableCollapsingToolbarLayout.c;
import com.viber.voip.widget.e;

class MoreCollapsingOnScrollListener extends e
{
  private final MoreToolbar mMoreToolbar;

  MoreCollapsingOnScrollListener(Drawable paramDrawable, View paramView, MoreToolbar paramMoreToolbar)
  {
    super(paramDrawable, paramView, paramMoreToolbar);
    this.mMoreToolbar = paramMoreToolbar;
  }

  public boolean adjustGradient()
  {
    return false;
  }

  protected float getAlpha(float paramFloat)
  {
    return Math.min(1.0F, paramFloat + paramFloat * (0.5F * paramFloat));
  }

  public void onScroll(float paramFloat, ObservableCollapsingToolbarLayout.c paramc)
  {
    super.onScroll(paramFloat, paramc);
    MoreToolbar localMoreToolbar = this.mMoreToolbar;
    if (paramFloat >= 0.8D);
    for (boolean bool = true; ; bool = false)
    {
      localMoreToolbar.consumeTouchEvents(bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreCollapsingOnScrollListener
 * JD-Core Version:    0.6.2
 */