package com.viber.voip.contacts.ui;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ads.b.c.a.b;
import com.viber.voip.ads.b.c.a.i;
import com.viber.voip.ui.b.a.b;
import com.viber.voip.util.dj;

public class bg
{
  private ViewGroup a;
  private View b;
  private com.viber.voip.ads.b.c.a.a<com.viber.voip.ads.b.c.c.c> c;

  private void a(final View paramView)
  {
    dj.b(paramView, true);
    paramView.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    localViewPropertyAnimator.cancel();
    localViewPropertyAnimator.alpha(1.0F);
    localViewPropertyAnimator.setDuration(500L);
    localViewPropertyAnimator.setInterpolator(com.viber.voip.ui.b.c.a);
    localViewPropertyAnimator.setListener(new a.b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        paramView.setAlpha(1.0F);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(0);
      }
    });
    localViewPropertyAnimator.start();
  }

  private void a(final View paramView, long paramLong, Interpolator paramInterpolator)
  {
    paramView.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    localViewPropertyAnimator.cancel();
    if (com.viber.common.d.a.a())
      localViewPropertyAnimator.withLayer();
    localViewPropertyAnimator.alpha(0.0F);
    if (paramLong >= 0L)
      localViewPropertyAnimator.setDuration(paramLong);
    localViewPropertyAnimator.setInterpolator(paramInterpolator);
    localViewPropertyAnimator.setListener(new a.b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        if (bg.a(bg.this) != null)
          bg.a(bg.this).removeView(paramView);
        paramView.setAlpha(1.0F);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (bg.a(bg.this) != null)
          bg.a(bg.this).removeView(paramView);
        paramView.setAlpha(1.0F);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(0);
      }
    });
    localViewPropertyAnimator.start();
  }

  public View a()
  {
    return this.a;
  }

  public void a(int paramInt, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, i parami, com.viber.voip.ads.b.b.b.c paramc, b paramb)
  {
    if (this.a == null)
    {
      this.a = ((ViewGroup)paramLayoutInflater.inflate(R.layout.view_calls_tab_ad_cell, paramViewGroup, false));
      this.c = paramb.a(paramc, this.a, parami);
    }
    View localView = paramLayoutInflater.inflate(paramInt, this.a, false);
    this.a.addView(localView, 0);
    this.b = localView;
  }

  public void a(com.viber.voip.ads.b.c.c.c paramc)
  {
    if ((this.c != null) && (this.a != null))
    {
      this.a.setTag(R.id.calls_tab_ad_tag, paramc);
      this.c.a(paramc);
      if ((this.b != null) && (this.b.getVisibility() != 8))
        com.viber.voip.ui.b.a.b(this.b, 500L, com.viber.voip.ui.b.c.a);
    }
  }

  public void a(boolean paramBoolean)
  {
    if (this.a == null);
    do
    {
      return;
      if (!paramBoolean)
        break;
    }
    while ((this.b == null) || (this.b.getVisibility() == 0));
    View localView2 = this.a.findViewById(R.id.overflowButton);
    if (localView2 != null)
      com.viber.voip.ui.b.a.b(localView2, 500L, com.viber.voip.ui.b.c.a);
    View localView3 = this.a.findViewById(R.id.adProviderView);
    if ((localView3 != null) && (localView3.getVisibility() == 0))
      com.viber.voip.ui.b.a.b(localView3, 500L, com.viber.voip.ui.b.c.a);
    View localView4 = this.a.findViewById(R.id.googleAdView);
    if (localView4 == null)
      localView4 = this.a.findViewById(R.id.adViewContainer);
    if (localView4 != null)
      a(localView4, 500L, com.viber.voip.ui.b.c.a);
    a(this.b);
    return;
    dj.b(this.a.findViewById(R.id.overflowButton), false);
    dj.b(this.a.findViewById(R.id.adProviderView), false);
    View localView1 = this.a.findViewById(R.id.googleAdView);
    if (localView1 == null)
      localView1 = this.a.findViewById(R.id.adViewContainer);
    if (localView1 != null)
      this.a.removeView(localView1);
    dj.b(this.b, true);
  }

  public View b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.bg
 * JD-Core Version:    0.6.2
 */