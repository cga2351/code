package com.my.target;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Property;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.my.target.b.c.a.i;
import com.my.target.common.a.b;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
public final class de extends ViewGroup
{
  private static final int a = bj.a();
  private static final int b = bj.a();
  private static final int c = bj.a();
  private static final int d = bj.a();
  private static final int e = bj.a();
  private static final int f = bj.a();
  private static final int g = bj.a();
  private final TextView h;
  private final cv i;
  private final TextView j;
  private final LinearLayout k;
  private final ay l;
  private final TextView m;
  private final TextView n;
  private final Button o;
  private final ax p;
  private final bj q;
  private final int r;
  private final int s;
  private final int t;

  public de(Context paramContext, bj parambj)
  {
    super(paramContext);
    this.q = parambj;
    this.o = new Button(paramContext);
    this.o.setId(b);
    bj.a(this.o, "cta_button");
    this.p = new ax(paramContext);
    this.p.setId(a);
    bj.a(this.p, "icon_image");
    this.i = new cv(paramContext);
    this.i.setId(g);
    this.h = new TextView(paramContext);
    this.h.setId(c);
    bj.a(this.h, "description_text");
    this.j = new TextView(paramContext);
    bj.a(this.j, "disclaimer_text");
    this.k = new LinearLayout(paramContext);
    this.l = new ay(paramContext);
    this.l.setId(e);
    bj.a(this.l, "stars_view");
    this.m = new TextView(paramContext);
    this.m.setId(f);
    bj.a(this.m, "votes_text");
    this.n = new TextView(paramContext);
    bj.a(this.n, "domain_text");
    this.n.setId(d);
    this.r = parambj.c(16);
    this.t = parambj.c(8);
    this.s = parambj.c(64);
  }

  private void a(int paramInt, View[] paramArrayOfView)
  {
    int i1 = this.p.getHeight();
    int i2 = getHeight();
    int i3 = this.o.getWidth();
    int i4 = this.o.getHeight();
    int i5 = this.p.getWidth();
    this.p.setPivotX(0.0F);
    this.p.setPivotY(i1 / 2.0F);
    this.o.setPivotX(i3);
    this.o.setPivotY(i4 / 2.0F);
    float f1 = 0.3F * i2;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this.o, View.SCALE_X, new float[] { 0.7F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.o, View.SCALE_Y, new float[] { 0.7F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.p, View.SCALE_X, new float[] { 0.7F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.p, View.SCALE_Y, new float[] { 0.7F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.h, View.ALPHA, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.j, View.ALPHA, new float[] { 0.0F }));
    if (this.k.isEnabled())
      localArrayList.add(ObjectAnimator.ofFloat(this.k, View.ALPHA, new float[] { 1.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this, View.ALPHA, new float[] { 0.6F }));
    float f2 = -(0.3F * i5);
    localArrayList.add(ObjectAnimator.ofFloat(this.i, View.TRANSLATION_X, new float[] { f2 }));
    localArrayList.add(ObjectAnimator.ofFloat(this.k, View.TRANSLATION_X, new float[] { f2 }));
    localArrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_X, new float[] { f2 }));
    localArrayList.add(ObjectAnimator.ofFloat(this.h, View.TRANSLATION_X, new float[] { f2 }));
    localArrayList.add(ObjectAnimator.ofFloat(this.j, View.TRANSLATION_X, new float[] { f2 }));
    localArrayList.add(ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[] { f1 }));
    Button localButton = this.o;
    Property localProperty1 = View.TRANSLATION_Y;
    float[] arrayOfFloat1 = new float[1];
    arrayOfFloat1[0] = (-f1 / 2.0F);
    localArrayList.add(ObjectAnimator.ofFloat(localButton, localProperty1, arrayOfFloat1));
    ax localax = this.p;
    Property localProperty2 = View.TRANSLATION_Y;
    float[] arrayOfFloat2 = new float[1];
    arrayOfFloat2[0] = (-f1 / 2.0F);
    localArrayList.add(ObjectAnimator.ofFloat(localax, localProperty2, arrayOfFloat2));
    int i6 = paramArrayOfView.length;
    for (int i7 = 0; i7 < i6; i7++)
      localArrayList.add(ObjectAnimator.ofFloat(paramArrayOfView[i7], View.TRANSLATION_Y, new float[] { f1 }));
    if (this.k.isEnabled())
      this.k.setVisibility(0);
    if (this.n.isEnabled())
      this.n.setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        de.a(de.this).setVisibility(8);
        de.b(de.this).setVisibility(8);
      }

      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.setDuration(paramInt);
    localAnimatorSet.start();
  }

  public final void a()
  {
    setBackgroundColor(1711276032);
    this.h.setTextColor(-2236963);
    this.h.setEllipsize(TextUtils.TruncateAt.END);
    this.n.setTextColor(-6710887);
    this.n.setVisibility(8);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(0);
    localGradientDrawable.setStroke(1, -3355444);
    this.j.setPadding(this.q.c(4), this.q.c(4), this.q.c(4), this.q.c(4));
    this.j.setBackgroundDrawable(localGradientDrawable);
    this.j.setTextSize(2, 12.0F);
    this.j.setTextColor(-3355444);
    this.j.setVisibility(8);
    this.k.setOrientation(0);
    this.k.setGravity(16);
    this.k.setVisibility(8);
    this.m.setTextColor(-6710887);
    this.m.setGravity(16);
    this.m.setTextSize(2, 14.0F);
    this.o.setPadding(this.q.c(15), 0, this.q.c(15), 0);
    this.o.setMinimumWidth(this.q.c(100));
    this.o.setTransformationMethod(null);
    this.o.setTextSize(2, 22.0F);
    this.o.setMaxEms(10);
    this.o.setSingleLine();
    this.o.setEllipsize(TextUtils.TruncateAt.END);
    at localat = this.i.getRightBorderedView();
    localat.a(1, -7829368);
    localat.setPadding(this.q.c(2), 0, 0, 0);
    localat.setTextColor(-1118482);
    localat.a(1, -1118482, this.q.c(3));
    localat.setBackgroundColor(1711276032);
    this.l.setStarSize(this.q.c(12));
    this.k.addView(this.l);
    this.k.addView(this.m);
    this.k.setVisibility(8);
    this.n.setVisibility(8);
    addView(this.i);
    addView(this.k);
    addView(this.n);
    addView(this.h);
    addView(this.j);
    addView(this.p);
    addView(this.o);
  }

  public final void a(g paramg, View.OnClickListener paramOnClickListener)
  {
    if (paramg.o)
    {
      setOnClickListener(paramOnClickListener);
      this.o.setOnClickListener(paramOnClickListener);
      return;
    }
    if (paramg.i)
    {
      this.o.setOnClickListener(paramOnClickListener);
      if (!paramg.n)
        break label171;
      setOnClickListener(paramOnClickListener);
      label48: if (!paramg.c)
        break label179;
      this.i.getLeftText().setOnClickListener(paramOnClickListener);
      label66: if (!paramg.j)
        break label193;
      this.i.getRightBorderedView().setOnClickListener(paramOnClickListener);
      label84: if (!paramg.e)
        break label207;
      this.p.setOnClickListener(paramOnClickListener);
      label99: if (!paramg.d)
        break label218;
      this.h.setOnClickListener(paramOnClickListener);
      label114: if (!paramg.g)
        break label229;
      this.l.setOnClickListener(paramOnClickListener);
      label129: if (!paramg.h)
        break label240;
      this.m.setOnClickListener(paramOnClickListener);
    }
    while (true)
    {
      if (!paramg.l)
        break label251;
      this.n.setOnClickListener(paramOnClickListener);
      return;
      this.o.setEnabled(false);
      break;
      label171: setOnClickListener(null);
      break label48;
      label179: this.i.getLeftText().setOnClickListener(null);
      break label66;
      label193: this.i.getRightBorderedView().setOnClickListener(null);
      break label84;
      label207: this.p.setOnClickListener(null);
      break label99;
      label218: this.h.setOnClickListener(null);
      break label114;
      label229: this.l.setOnClickListener(null);
      break label129;
      label240: this.m.setOnClickListener(null);
    }
    label251: this.n.setOnClickListener(null);
  }

  public final void a(View[] paramArrayOfView)
  {
    if (getVisibility() == 0)
      a(0, paramArrayOfView);
  }

  final void b(View[] paramArrayOfView)
  {
    if (getVisibility() == 0)
      a(300, paramArrayOfView);
  }

  final void c(View[] paramArrayOfView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this.o, View.SCALE_Y, new float[] { 1.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.o, View.SCALE_X, new float[] { 1.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.p, View.SCALE_Y, new float[] { 1.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.p, View.SCALE_X, new float[] { 1.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.h, View.ALPHA, new float[] { 1.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.j, View.ALPHA, new float[] { 1.0F }));
    if (this.k.isEnabled())
      localArrayList.add(ObjectAnimator.ofFloat(this.k, View.ALPHA, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this, View.ALPHA, new float[] { 1.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.i, View.TRANSLATION_X, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.k, View.TRANSLATION_X, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_X, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.h, View.TRANSLATION_X, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.j, View.TRANSLATION_X, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.o, View.TRANSLATION_Y, new float[] { 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.p, View.TRANSLATION_Y, new float[] { 0.0F }));
    for (int i1 = 0; i1 <= 0; i1++)
      localArrayList.add(ObjectAnimator.ofFloat(paramArrayOfView[0], View.TRANSLATION_Y, new float[] { 0.0F }));
    if (!TextUtils.isEmpty(this.j.getText().toString()))
      this.j.setVisibility(0);
    this.h.setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (de.c(de.this).isEnabled())
          de.c(de.this).setVisibility(8);
        if (de.d(de.this).isEnabled())
          de.d(de.this).setVisibility(8);
      }

      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.start();
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getMeasuredWidth();
    int i2 = getMeasuredHeight();
    int i3 = this.p.getMeasuredHeight();
    int i4 = this.p.getMeasuredWidth();
    int i5 = (i2 - i3) / 2;
    this.p.layout(this.r, i5, i4 + this.r, i3 + i5);
    int i6 = this.o.getMeasuredWidth();
    int i7 = this.o.getMeasuredHeight();
    int i8 = (i2 - i7) / 2;
    int i9 = i1 - i6 - this.r;
    this.o.layout(i9, i8, i1 - this.r, i7 + i8);
    int i10 = i4 + this.r + this.r;
    this.i.layout(i10, this.t, i10 + this.i.getMeasuredWidth(), this.t + this.i.getMeasuredHeight());
    this.k.layout(i10, this.i.getBottom(), i10 + this.k.getMeasuredWidth(), this.i.getBottom() + this.k.getMeasuredHeight());
    this.n.layout(i10, this.i.getBottom(), i10 + this.n.getMeasuredWidth(), this.i.getBottom() + this.n.getMeasuredHeight());
    this.h.layout(i10, this.i.getBottom(), i10 + this.h.getMeasuredWidth(), this.i.getBottom() + this.h.getMeasuredHeight());
    this.j.layout(i10, this.h.getBottom(), i10 + this.j.getMeasuredWidth(), this.h.getBottom() + this.j.getMeasuredHeight());
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2) / 4;
    int i3 = i1 - 2 * this.r;
    int i4 = i2 - 2 * this.t;
    int i5 = Math.min(i4, this.s);
    this.p.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
    this.o.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i5 - 2 * this.t, 1073741824));
    int i6 = i3 - this.p.getMeasuredWidth() - this.o.getMeasuredWidth() - 2 * this.r;
    this.i.measure(View.MeasureSpec.makeMeasureSpec(i6, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.k.measure(View.MeasureSpec.makeMeasureSpec(i6, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.n.measure(View.MeasureSpec.makeMeasureSpec(i6, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.h.measure(View.MeasureSpec.makeMeasureSpec(i6, -2147483648), View.MeasureSpec.makeMeasureSpec(i4 - this.i.getMeasuredHeight(), -2147483648));
    this.j.measure(View.MeasureSpec.makeMeasureSpec(i6, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    int i7 = this.i.getMeasuredHeight() + Math.max(this.h.getMeasuredHeight(), this.k.getMeasuredHeight()) + 2 * this.t;
    if (this.j.getVisibility() == 0)
      i7 += this.j.getMeasuredHeight();
    setMeasuredDimension(i1, Math.max(this.o.getMeasuredHeight(), Math.max(this.p.getMeasuredHeight(), i7)) + 2 * this.t);
  }

  public final void setBanner(i parami)
  {
    this.i.getLeftText().setText(parami.p());
    this.h.setText(parami.f());
    String str1 = parami.g();
    if (!TextUtils.isEmpty(str1))
    {
      this.j.setVisibility(0);
      this.j.setText(str1);
      b localb = parami.j();
      if (localb == null)
        break label280;
      this.p.setVisibility(0);
      this.p.setImageData(localb);
      label78: this.o.setText(parami.d());
      if ("".equals(parami.a()))
        break label292;
      this.i.getRightBorderedView().setText(parami.a());
      label116: int i1 = parami.M();
      int i2 = parami.N();
      int i3 = parami.O();
      bj.a(this.o, i1, i2, this.q.c(2));
      this.o.setTextColor(i3);
      if (!"store".equals(parami.m()))
        break label327;
      if ((parami.t() == 0) || (parami.n() <= 0.0F))
        break label307;
      this.k.setEnabled(true);
      this.l.setRating(parami.n());
      this.m.setText(String.valueOf(parami.t()));
    }
    while (true)
    {
      this.n.setEnabled(false);
      if ((parami.I() == null) || (!parami.I().K()))
      {
        this.k.setVisibility(8);
        this.n.setVisibility(8);
      }
      return;
      this.j.setVisibility(8);
      break;
      label280: this.p.setVisibility(8);
      break label78;
      label292: this.i.getRightBorderedView().setVisibility(8);
      break label116;
      label307: this.k.setEnabled(false);
      this.k.setVisibility(8);
    }
    label327: String str2 = parami.h();
    if (!TextUtils.isEmpty(str2))
    {
      this.n.setEnabled(true);
      this.n.setText(str2);
    }
    while (true)
    {
      this.k.setEnabled(false);
      break;
      this.n.setEnabled(false);
      this.n.setVisibility(8);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.de
 * JD-Core Version:    0.6.2
 */