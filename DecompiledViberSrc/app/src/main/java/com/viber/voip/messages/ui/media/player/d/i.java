package com.viber.voip.messages.ui.media.player.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.viber.voip.R.fraction;
import java.util.ArrayList;

public class i
{
  private final Resources a;
  private final int b;
  private final a c;
  private final Rect d = new Rect();
  private final Rect e = new Rect();
  private AnimatorSet f;
  private final ValueAnimator g;
  private final ValueAnimator h;
  private final ArrayList<Animator> i = new ArrayList(2);
  private int j;
  private int k;

  public i(Resources paramResources, a parama, int paramInt)
  {
    this.a = paramResources;
    this.c = parama;
    this.b = paramInt;
    this.g = d();
    this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        i.a(i.this).a(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
    this.h = d();
    this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        i.a(i.this).b(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
  }

  private ValueAnimator d()
  {
    ValueAnimator localValueAnimator = new ValueAnimator().setDuration(150L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    return localValueAnimator;
  }

  public int a()
  {
    return this.j;
  }

  public void a(Rect paramRect)
  {
    int m = (int)(paramRect.width() * this.a.getFraction(R.fraction.player_minimized_sticky_area_offset, 1, 1));
    this.k = m;
    this.j = m;
    this.d.set(m, m, paramRect.right - m, paramRect.bottom - m);
    int n = (int)(paramRect.width() * this.a.getFraction(R.fraction.player_minimized_inner_sticky_area_offset, 1, 1));
    if (this.b > 0)
      n = Math.min(n, this.b);
    this.e.set(n, n, paramRect.right - n, paramRect.bottom - n);
  }

  public void a(Rect paramRect, boolean paramBoolean)
  {
    c();
    int m = b(paramRect);
    int n = c(paramRect);
    if (paramBoolean)
    {
      this.i.clear();
      if (m != 0)
      {
        localValueAnimator2 = this.g;
        arrayOfInt2 = new int[2];
        arrayOfInt2[0] = paramRect.left;
        arrayOfInt2[1] = (m + paramRect.left);
        localValueAnimator2.setIntValues(arrayOfInt2);
        this.i.add(this.g);
      }
      if (n != 0)
      {
        localValueAnimator1 = this.h;
        arrayOfInt1 = new int[2];
        arrayOfInt1[0] = paramRect.top;
        arrayOfInt1[1] = (n + paramRect.top);
        localValueAnimator1.setIntValues(arrayOfInt1);
        this.i.add(this.h);
      }
      if (!this.i.isEmpty())
      {
        this.f = new AnimatorSet();
        this.f.playTogether(this.i);
        this.f.start();
      }
    }
    while ((m == 0) && (n == 0))
    {
      ValueAnimator localValueAnimator2;
      int[] arrayOfInt2;
      ValueAnimator localValueAnimator1;
      int[] arrayOfInt1;
      return;
    }
    this.c.a(m + paramRect.left, n + paramRect.top);
  }

  public int b()
  {
    return this.k;
  }

  int b(Rect paramRect)
  {
    int i1;
    if (paramRect.left < this.e.left)
      i1 = this.d.left - paramRect.left;
    int m;
    int n;
    do
    {
      return i1;
      m = paramRect.right;
      n = this.e.right;
      i1 = 0;
    }
    while (m <= n);
    return this.d.right - paramRect.right;
  }

  int c(Rect paramRect)
  {
    int i1;
    if (paramRect.top < this.e.top)
      i1 = this.d.top - paramRect.top;
    int m;
    int n;
    do
    {
      return i1;
      m = paramRect.bottom;
      n = this.e.bottom;
      i1 = 0;
    }
    while (m <= n);
    return this.d.bottom - paramRect.bottom;
  }

  public void c()
  {
    if (this.f != null)
    {
      if (this.f.isRunning())
        this.f.cancel();
      this.f = null;
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, int paramInt2);

    public abstract void b(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.i
 * JD-Core Version:    0.6.2
 */