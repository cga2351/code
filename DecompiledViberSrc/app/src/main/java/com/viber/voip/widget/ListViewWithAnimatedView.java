package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.ViberListView;

public class ListViewWithAnimatedView extends ViberListView
{
  private static final Logger a = ViberEnv.getLogger();
  private c b;
  private b c;
  private Handler d;
  private View e;
  private View f;
  private Animation.AnimationListener g;
  private Animation.AnimationListener h;
  private int i = -2147483648;
  private int j = -2147483648;
  private int k;

  public ListViewWithAnimatedView(Context paramContext)
  {
    super(paramContext);
    e();
  }

  public ListViewWithAnimatedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }

  public ListViewWithAnimatedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }

  private void e()
  {
    this.d = new Handler();
    this.b = new c(getContext(), null);
    this.c = new b(getContext(), null);
    this.k = getResources().getDimensionPixelSize(R.dimen.keyboard_extension_filter_item_height);
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 2)
          ListViewWithAnimatedView.a(ListViewWithAnimatedView.this, ListViewWithAnimatedView.this.getFirstVisiblePosition());
        return false;
      }
    });
  }

  protected void a()
  {
    this.c.run();
    this.d.removeCallbacks(this.b);
    this.d.postDelayed(this.b, 3000L);
  }

  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addFooterView(paramView, paramObject, paramBoolean);
    this.e = paramView;
  }

  protected void c()
  {
    this.b.run();
  }

  protected void d()
  {
    this.d.postDelayed(this.b, 500L);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d.removeCallbacks(this.b);
    this.d.removeCallbacks(this.c);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.i == -2147483648)
      break label18;
    label18: 
    while (this.e == null)
      return;
    View localView = getChildAt(0);
    int m = 0;
    if (localView == null)
    {
      label41: if ((this.e.getBottom() != getHeight()) || (-1 + getCount() != getLastVisiblePosition()))
        break label94;
      d();
    }
    while (true)
    {
      this.i = paramInt1;
      this.j = m;
      return;
      m = localView.getTop();
      break label41;
      label94: if ((this.i == paramInt1) && (Math.abs(this.j - m) < this.k))
        break;
      if ((paramInt1 > this.i) || ((this.i == paramInt1) && (this.j > m)))
        a();
      else if ((paramInt1 < this.i) || ((this.i == paramInt1) && (this.j < m)))
        c();
    }
  }

  public void setAnimatedView(View paramView)
  {
    this.f = paramView;
  }

  public void setSlideInListener(Animation.AnimationListener paramAnimationListener)
  {
    this.g = paramAnimationListener;
  }

  public void setSlideOutListener(Animation.AnimationListener paramAnimationListener)
  {
    this.h = paramAnimationListener;
  }

  private class a
  {
    private a()
    {
    }

    protected void a(final int paramInt, final Animation paramAnimation, final Animation.AnimationListener paramAnimationListener)
    {
      if (ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).getVisibility() == paramInt)
        return;
      Animation localAnimation = ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).getAnimation();
      final Animation.AnimationListener localAnimationListener = (Animation.AnimationListener)ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).getTag();
      if ((localAnimation == null) || (localAnimation.hasEnded()))
      {
        ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).setVisibility(paramInt);
        ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).startAnimation(paramAnimation);
        ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).setTag(paramAnimationListener);
        return;
      }
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (localAnimationListener != null)
            localAnimationListener.onAnimationEnd(paramAnonymousAnimation);
          paramAnonymousAnimation.setAnimationListener(localAnimationListener);
          ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).setVisibility(paramInt);
          ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).startAnimation(paramAnimation);
          ListViewWithAnimatedView.c(ListViewWithAnimatedView.this).setTag(paramAnimationListener);
        }

        public void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          if (localAnimationListener != null)
            localAnimationListener.onAnimationRepeat(paramAnonymousAnimation);
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          if (localAnimationListener != null)
            localAnimationListener.onAnimationStart(paramAnonymousAnimation);
        }
      });
    }
  }

  private class b extends ListViewWithAnimatedView.a
    implements Runnable
  {
    private Animation c;

    private b(Context arg2)
    {
      super(null);
      Context localContext;
      this.c = AnimationUtils.loadAnimation(localContext, R.anim.bottom_slide_out);
      this.c.setDuration(300L);
      this.c.setAnimationListener(ListViewWithAnimatedView.b(ListViewWithAnimatedView.this));
    }

    public void run()
    {
      a(8, this.c, ListViewWithAnimatedView.b(ListViewWithAnimatedView.this));
    }
  }

  private class c extends ListViewWithAnimatedView.a
    implements Runnable
  {
    private Animation c;

    private c(Context arg2)
    {
      super(null);
      Context localContext;
      this.c = AnimationUtils.loadAnimation(localContext, R.anim.bottom_slide_in);
      this.c.setDuration(300L);
      this.c.setAnimationListener(ListViewWithAnimatedView.a(ListViewWithAnimatedView.this));
    }

    public void run()
    {
      a(0, this.c, ListViewWithAnimatedView.a(ListViewWithAnimatedView.this));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ListViewWithAnimatedView
 * JD-Core Version:    0.6.2
 */