package com.viber.voip.messages.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.a.c.a.i.a;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.widget.r;
import com.viber.voip.widget.r.a;

public class AnimatedLikesView extends FrameLayout
{
  private r a;
  private TextView b;
  private int c;
  private int d;
  private int e;
  private int f;
  private b g;
  private String h;
  private AnimatorSet i;
  private AnimatorSet j;
  private AnimatorSet k;
  private AnimatorSet l;
  private boolean m;
  private boolean n;
  private boolean o;
  private r.a p;

  public AnimatedLikesView(Context paramContext)
  {
    super(paramContext);
    this.p = new a(this);
    a(null);
  }

  public AnimatedLikesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.p = new b(this);
    a(paramAttributeSet);
  }

  public AnimatedLikesView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.p = new c(this);
    a(paramAttributeSet);
  }

  private Animator a(View paramView, boolean paramBoolean, int paramInt)
  {
    float[] arrayOfFloat = new float[1];
    if (paramBoolean);
    for (float f1 = -paramInt + this.f; ; f1 = 0.0F)
    {
      arrayOfFloat[0] = f1;
      return ObjectAnimator.ofFloat(paramView, "translationY", arrayOfFloat);
    }
  }

  private void a(Animator paramAnimator)
  {
    if ((paramAnimator != null) && (paramAnimator.isRunning()))
      paramAnimator.end();
  }

  private void a(AttributeSet paramAttributeSet)
  {
    this.e = getResources().getDimensionPixelSize(R.dimen.additional_like_text_padding);
    this.f = getResources().getDimensionPixelSize(R.dimen.additional_like_heart_padding);
    this.b = new ViberTextView(getContext());
    this.b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.b.setIncludeFontPadding(false);
    this.b.setShadowLayer(1.0F, 0.0F, 1.0F, ContextCompat.getColor(getContext(), R.color.solid_25));
    this.b.setTextColor(ContextCompat.getColor(getContext(), R.color.negative));
    int i1 = getResources().getDimensionPixelSize(R.dimen.like_counter_text_size);
    this.b.setTextSize(0, i1);
    dj.c(this.b, 8);
    addView(this.b);
    int i2 = getResources().getDimensionPixelSize(R.dimen.heart_like_size);
    this.a = new r(getContext());
    this.a.setLayoutParams(new FrameLayout.LayoutParams(i2, i2, 17));
    addView(this.a);
    b(paramAttributeSet);
    dj.b(this.b, new d(this));
  }

  private Animator b(View paramView, boolean paramBoolean, int paramInt)
  {
    float[] arrayOfFloat = new float[1];
    if (paramBoolean);
    for (float f1 = 0.0F; ; f1 = paramInt + this.e)
    {
      arrayOfFloat[0] = f1;
      return ObjectAnimator.ofFloat(paramView, "translationY", arrayOfFloat);
    }
  }

  private void b(AttributeSet paramAttributeSet)
  {
    int i1 = 1;
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
      localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.AnimatedLikesView);
    try
    {
      if (localTypedArray.getInt(R.styleable.AnimatedLikesView_layoutOrientation, 0) == i1);
      while (true)
      {
        this.o = i1;
        localTypedArray.recycle();
        this.d = this.a.getLayoutParams().width;
        if (this.o)
        {
          ((FrameLayout.LayoutParams)this.a.getLayoutParams()).gravity = 19;
          ((FrameLayout.LayoutParams)this.b.getLayoutParams()).gravity = 19;
          this.b.setTranslationX(this.d);
        }
        return;
        i1 = 0;
      }
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private Animator c(View paramView, boolean paramBoolean, int paramInt)
  {
    TextView localTextView = this.b;
    float[] arrayOfFloat = new float[1];
    if (paramBoolean);
    for (float f1 = 0.0F; ; f1 = 1.0F)
    {
      arrayOfFloat[0] = f1;
      return ObjectAnimator.ofFloat(localTextView, "alpha", arrayOfFloat);
    }
  }

  private void d()
  {
    if (!da.a(this.h))
      if (!this.o)
      {
        this.a.setTranslationY(-this.c / 2 + this.f);
        this.b.setTranslationY(this.c / 2 + this.e);
      }
    while (true)
    {
      k();
      return;
      if (!this.o)
      {
        this.a.setTranslationY(0.0F);
        this.b.setTranslationY(0.0F);
      }
    }
  }

  private void e()
  {
    if (!da.a(this.h))
    {
      dj.c(this.b, 0);
      this.b.setText(this.h);
    }
    while (true)
    {
      this.b.setAlpha(1.0F);
      return;
      dj.c(this.b, 8);
    }
  }

  private void f()
  {
    if (this.g == null)
      this.g = b.a;
    switch (5.b[this.g.ordinal()])
    {
    default:
      return;
    case 1:
      this.a.a(false, null);
      return;
    case 2:
    }
    this.a.b(false, null);
  }

  private boolean g()
  {
    if ((this.a != null) && (this.a.a()));
    while (((this.i != null) && (this.i.isRunning())) || ((this.k != null) && (this.k.isRunning())) || ((this.j != null) && (this.j.isRunning())) || ((this.l != null) && (this.l.isRunning())))
      return true;
    return false;
  }

  private void h()
  {
    int i1 = this.c / 2;
    this.i = new AnimatorSet();
    this.i.setDuration(200L);
    this.i.setInterpolator(new LinearInterpolator());
    this.i.play(a(this.a, true, i1)).with(b(this.b, false, i1));
    this.i.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        super.onAnimationStart(paramAnonymousAnimator);
        AnimatedLikesView.a(AnimatedLikesView.this);
      }
    });
    this.k = new AnimatorSet();
    this.k.setDuration(200L);
    this.k.setInterpolator(new LinearInterpolator());
    this.k.play(a(this.a, false, i1)).with(b(this.b, true, i1));
    this.k.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        super.onAnimationStart(paramAnonymousAnimator);
        AnimatedLikesView.b(AnimatedLikesView.this);
        AnimatedLikesView.c(AnimatedLikesView.this).setText("");
        AnimatedLikesView.a(AnimatedLikesView.this, "");
      }
    });
    int i2 = this.d;
    this.j = new AnimatorSet();
    this.j.setDuration(200L);
    this.j.setInterpolator(new DecelerateInterpolator());
    this.j.play(c(this.b, true, i2));
    this.j.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        super.onAnimationStart(paramAnonymousAnimator);
        AnimatedLikesView.b(AnimatedLikesView.this);
      }
    });
    this.l = new AnimatorSet();
    this.l.setDuration(200L);
    this.l.setInterpolator(new AccelerateInterpolator());
    this.l.play(c(this.b, false, i2));
    this.l.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        super.onAnimationStart(paramAnonymousAnimator);
        AnimatedLikesView.a(AnimatedLikesView.this);
      }
    });
  }

  private void i()
  {
    this.a.b(true, this.p);
  }

  private void j()
  {
    this.a.a(true, this.p);
  }

  private void k()
  {
    f();
    e();
  }

  public void a()
  {
    if ((this.a != null) && (this.a.a()))
      this.a.b();
    a(this.i);
    a(this.k);
    a(this.j);
    a(this.l);
    d();
  }

  public void a(a parama)
  {
    if (g())
      return;
    switch (5.a[parama.ordinal()])
    {
    default:
      return;
    case 1:
      i();
      return;
    case 2:
      this.k.start();
      return;
    case 3:
      this.i.start();
      return;
    case 4:
      this.j.start();
      return;
    case 5:
      e();
      this.b.setAlpha(0.0F);
      this.l.start();
      return;
    case 6:
    }
    j();
  }

  public void a(String paramString, b paramb)
  {
    if ((this.h == null) || (this.g == null))
      this.m = true;
    this.h = paramString;
    this.g = paramb;
    if (g())
      return;
    k();
    d();
  }

  public void a(boolean paramBoolean)
  {
    if (this.n != paramBoolean)
    {
      this.n = paramBoolean;
      this.a.setUseStrokeColor(this.n);
      f();
    }
  }

  public void setCounterTextColor(int paramInt)
  {
    if ((this.b != null) && (this.b.getCurrentTextColor() != paramInt))
    {
      this.b.setTextColor(paramInt);
      this.b.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
  }

  public void setCounterTextColor(i.a parama)
  {
    int i1 = parama.a;
    if ((this.b != null) && (this.b.getCurrentTextColor() != i1))
    {
      this.b.setTextColor(i1);
      this.b.setShadowLayer(parama.b, parama.c, parama.d, parama.e);
    }
  }

  @Deprecated
  public void setCounterTextColor(i parami)
  {
    setCounterTextColor(parami.I());
  }

  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.a.setEnabled(paramBoolean);
  }

  public void setLikesClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }

  public void setStrokeColor(int paramInt)
  {
    this.a.setStrokeColor(paramInt);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.AnimatedLikesView
 * JD-Core Version:    0.6.2
 */