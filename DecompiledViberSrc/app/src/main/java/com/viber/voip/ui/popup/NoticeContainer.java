package com.viber.voip.ui.popup;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import java.util.LinkedList;
import java.util.Queue;

public class NoticeContainer extends FrameLayout
{
  private Animation a;
  private Animation b;
  private final Queue<a> c = new LinkedList();
  private Runnable d = new Runnable()
  {
    public void run()
    {
      NoticeContainer.this.bringToFront();
      NoticeContainer.this.requestLayout();
      NoticeContainer.this.invalidate();
    }
  };
  private final Animation.AnimationListener e = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      NoticeContainer.a(NoticeContainer.this);
    }

    public void onAnimationRepeat(Animation paramAnonymousAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnonymousAnimation)
    {
    }
  };
  private final Runnable f = new Runnable()
  {
    public void run()
    {
      if (NoticeContainer.this.getVisibility() == 0)
      {
        NoticeContainer.c(NoticeContainer.this).postDelayed(new Runnable()
        {
          public void run()
          {
            NoticeContainer.this.clearAnimation();
            NoticeContainer.a(NoticeContainer.this);
          }
        }
        , NoticeContainer.b(NoticeContainer.this).getDuration());
        NoticeContainer.this.startAnimation(NoticeContainer.b(NoticeContainer.this));
      }
    }
  };

  public NoticeContainer(Context paramContext)
  {
    super(paramContext);
    b();
  }

  public NoticeContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  NoticeContainer(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    a(paramViewGroup);
    b();
  }

  private ColorStateList a(a.b paramb)
  {
    4.a[paramb.ordinal()];
    return getResources().getColorStateList(R.color.notice_action_color);
  }

  private FrameLayout.LayoutParams a(View paramView, a.b paramb)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramView.getLayoutParams());
    localLayoutParams.gravity = b(paramb);
    return localLayoutParams;
  }

  private void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
    setVisibility(8);
    setId(R.id.notice_container);
  }

  private void a(a parama)
  {
    a(parama, false);
  }

  private void a(a parama, boolean paramBoolean)
  {
    setVisibility(0);
    c(parama);
    addView(parama.a, a(parama.a, parama.e.style));
    d();
    parama.b.setText(parama.e.message);
    parama.c.setTextColor(a(parama.e.style));
    Animation localAnimation;
    if ((!TextUtils.isEmpty(parama.e.action)) && (c(parama.e.style)))
    {
      parama.b.setGravity(19);
      parama.c.setVisibility(0);
      parama.d.setVisibility(8);
      parama.c.setText(parama.e.action);
      localAnimation = this.b;
      if (!paramBoolean)
        break label234;
    }
    label234: for (long l = 0L; ; l = 300L)
    {
      localAnimation.setDuration(l);
      startAnimation(this.b);
      if (parama.e.duration > 0L)
        postDelayed(this.f, parama.e.duration);
      return;
      parama.b.setGravity(17);
      parama.c.setVisibility(8);
      if (!c(parama.e.style))
        break;
      parama.d.setVisibility(0);
      break;
    }
  }

  private int b(a.b paramb)
  {
    switch (4.a[paramb.ordinal()])
    {
    default:
      return 80;
    case 1:
    case 2:
    }
    return 48;
  }

  private void b()
  {
    this.b = AnimationUtils.loadAnimation(getContext(), 17432576);
    this.b.setFillAfter(true);
    this.a = AnimationUtils.loadAnimation(getContext(), 17432577);
    this.a.setFillAfter(true);
    this.a.setDuration(300L);
    this.a.setAnimationListener(this.e);
  }

  private void b(a parama)
  {
    if (parama.f != null)
      parama.f.b(this.c.size());
  }

  private void c()
  {
    e();
    removeAllViews();
    if (!a())
      b((a)this.c.poll());
    if (!a())
    {
      a((a)this.c.peek());
      return;
    }
    setVisibility(8);
  }

  private void c(a parama)
  {
    if (parama.f != null)
      parama.f.a(this.c.size());
  }

  private boolean c(a.b paramb)
  {
    switch (4.a[paramb.ordinal()])
    {
    case 2:
    default:
      return false;
    case 1:
    case 3:
    }
    return true;
  }

  private void d()
  {
    postDelayed(this.d, 300L);
  }

  private void e()
  {
    removeCallbacks(this.d);
  }

  private ViewGroup f()
  {
    return this;
  }

  public boolean a()
  {
    return this.c.isEmpty();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.b.cancel();
    this.a.cancel();
    removeCallbacks(this.f);
    this.c.clear();
  }

  private static class a
  {
    final View a;
    final TextView b;
    final TextView c;
    final TextView d;
    final Notice e;
    final a.a f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.popup.NoticeContainer
 * JD-Core Version:    0.6.2
 */