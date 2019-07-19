package com.viber.voip.u.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.ui.ViberListView;

class c extends a
{
  private static final Logger d = ViberEnv.getLogger();
  final a c;
  private View e;
  private int f;
  private int g;
  private int h;
  private int i;

  c(a.a parama, a parama1)
  {
    super(parama);
    this.c = parama1;
  }

  private void a(Animator[] paramArrayOfAnimator)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(a).playTogether(paramArrayOfAnimator);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (c.this.b != null)
          c.this.b.b();
      }
    });
    if (this.b != null)
      this.b.a();
    localAnimatorSet.start();
  }

  private int[] a(View paramView1, View paramView2)
  {
    int j = 0;
    int m;
    for (int k = 0; paramView2 != paramView1; k = m)
    {
      m = k + paramView2.getTop();
      int n = j + paramView2.getLeft();
      paramView2 = (View)paramView2.getParent();
      j = n;
    }
    return new int[] { j, k };
  }

  private b b(ViberListView paramViberListView, View paramView)
  {
    if (!ViewCompat.isLaidOut(paramView))
      return b.c;
    if (paramView.getBottom() <= paramViberListView.getHeight() - paramViberListView.getPaddingBottom())
      return b.a;
    return b.b;
  }

  protected void a(ViberListView paramViberListView)
  {
    k localk = (k)paramViberListView.getAdapter();
    this.e = paramViberListView.b(-1 + (localk.c() + localk.a().getCount()));
    this.f = paramViberListView.getResources().getDimensionPixelSize(R.dimen.list_bottom_padding);
    this.g = paramViberListView.getResources().getDimensionPixelOffset(R.dimen.message_balloon_vertical_padding);
    this.h = paramViberListView.getResources().getDimensionPixelSize(R.dimen.ivm_conversation_circle_border_width);
    this.i = paramViberListView.getResources().getDimensionPixelSize(R.dimen.ivm_conversation_circle_size);
    super.a(paramViberListView);
  }

  @SuppressLint({"NewApi"})
  protected void a(final ViberListView paramViberListView, View paramView)
  {
    k localk = (k)paramViberListView.getAdapter();
    b localb = b(paramViberListView, paramView);
    if (b.c == localb)
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramViberListView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    }
    View localView1 = paramView.findViewById(R.id.ivmPlayer);
    int[] arrayOfInt1 = a(paramView, localView1);
    int[] arrayOfInt2 = new int[2];
    paramViberListView.getLocationOnScreen(arrayOfInt2);
    int j = arrayOfInt2[0] + arrayOfInt1[0];
    Object localObject;
    int i5;
    Animator localAnimator;
    if (b.a == localb)
    {
      localObject = null;
      int[] arrayOfInt5 = new int[2];
      localView1.getLocationOnScreen(arrayOfInt5);
      i5 = arrayOfInt5[1];
      a locala = this.c;
      int[] arrayOfInt3 = { j, i5 };
      int[] arrayOfInt4 = new int[2];
      arrayOfInt4[0] = localView1.getWidth();
      arrayOfInt4[1] = localView1.getHeight();
      localAnimator = locala.a(arrayOfInt3, arrayOfInt4);
      if (localObject != null)
        a(new Animator[] { localAnimator, localObject });
    }
    else
    {
      label205: if (b.c == localb);
      for (int k = 2; ; k = 1)
      {
        final int m = localk.c() + localk.a().getCount() - k;
        View localView2 = paramViberListView.b(m);
        if (localView2 == null)
          break label205;
        final int n = localView2.getTop();
        int i1 = localView2.getBottom() - paramViberListView.getHeight() - paramViberListView.getPaddingBottom() + this.f + this.g;
        if (b.c == localb)
          i1 += paramView.getHeight();
        final int i2 = i1 + paramViberListView.getDividerHeight();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i2 }).setDuration(a);
        if (!com.viber.common.d.a.e())
          localValueAnimator.addListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              paramViberListView.post(new d(paramViberListView, m, n, i2));
            }
          });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          private int e = 0;

          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            if (com.viber.common.d.a.e())
            {
              paramViberListView.scrollListBy(i - this.e);
              this.e = i;
              return;
            }
            paramViberListView.setSelectionFromTop(m, n - i);
          }
        });
        int i3 = arrayOfInt2[1] + paramViberListView.getHeight();
        int i4 = paramView.getHeight() - this.i;
        i5 = i3 - paramView.getHeight() + arrayOfInt1[1] - i4 - 2 * this.h;
        localObject = localValueAnimator;
        break;
      }
    }
    a(new Animator[] { localAnimator });
  }

  protected View b(ViberListView paramViberListView)
  {
    k localk = (k)paramViberListView.getAdapter();
    View localView = paramViberListView.b(-1 + (localk.c() + localk.a().getCount()));
    if (this.e == localView)
      return localk.a().getView(-1 + localk.a().getCount(), null, paramViberListView);
    return localView;
  }

  static abstract interface a
  {
    public abstract Animator a(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.a.c
 * JD-Core Version:    0.6.2
 */