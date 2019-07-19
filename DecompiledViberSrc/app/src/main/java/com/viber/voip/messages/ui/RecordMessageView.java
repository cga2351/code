package com.viber.voip.messages.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.clock.FiniteClock;
import com.viber.svg.jni.clock.FiniteClock.AnimationEndListener;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.ui.d.f;
import com.viber.voip.util.bp;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.l;
import com.viber.voip.widget.l.a;

public class RecordMessageView extends FrameLayout
  implements RecordTimerView.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final l.a b = new l.a();
  private a c;
  private ValueAnimator d;
  private ViberTextView e;
  private TextView f;
  private int g;
  private int h;
  private ImageView i;
  private RecordTimerView j;
  private int k;
  private f l;
  private FiniteClock m;
  private FiniteClock.AnimationEndListener n;
  private boolean o;
  private long p = 300L;
  private Animator.AnimatorListener q;

  public RecordMessageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public RecordMessageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public RecordMessageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(float paramFloat1, float paramFloat2, View[] paramArrayOfView)
  {
    int i1 = paramArrayOfView.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = paramArrayOfView[i2];
      localView.setAlpha(paramFloat1);
      localView.setTranslationX(paramFloat2);
    }
  }

  private void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.record_message_view, this, true);
    this.e = ((ViberTextView)localView.findViewById(R.id.slide_to_cancel_label));
    this.e.setText(b(paramContext));
    this.f = ((TextView)localView.findViewById(R.id.cancel_record));
    this.i = ((ImageView)localView.findViewById(R.id.icon_trashcan));
    this.j = ((RecordTimerView)localView.findViewById(R.id.time_counter));
    this.j.a(this);
    this.g = dc.d(paramContext, R.attr.conversationPttPreviewSlideToCancelColor);
    this.h = ContextCompat.getColor(paramContext, R.color.grey_light);
    this.q = new com.viber.voip.widget.c()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!this.b)
          dj.b(RecordMessageView.this, false);
      }
    };
    this.l = new f("svg/record_msg_trashcan.svg");
    this.l.a(dc.d(paramContext, R.attr.conversationPttTrashIconColor));
    this.m = new FiniteClock(this.l.b());
    this.n = new cj(this);
    this.l.a(this.m);
    this.k = getResources().getDimensionPixelSize(R.dimen.record_message_slide_to_cancel_max_distance);
  }

  private String b(Context paramContext)
  {
    String str = paramContext.getString(R.string.voice_msg_slide_to_cancel);
    boolean bool = com.viber.common.d.c.a();
    if ((bp.a(paramContext)) || (bool))
    {
      if (bool)
        str = str + " >";
    }
    else
      return str;
    return "< " + str;
  }

  private void g()
  {
    animate().cancel();
    h();
    this.j.b();
  }

  private void h()
  {
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d.removeAllListeners();
      this.d = null;
    }
  }

  private void i()
  {
    String str = this.e.getText().toString();
    float f1 = this.e.getPaint().measureText(str);
    SpannableString localSpannableString = new SpannableString(str);
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = this.g;
    arrayOfInt[1] = this.g;
    arrayOfInt[2] = this.h;
    arrayOfInt[3] = this.g;
    arrayOfInt[4] = this.g;
    l locall = new l(f1, arrayOfInt);
    localSpannableString.setSpan(locall, 0, str.length(), 33);
    if (this.d != null)
      h();
    this.d = ObjectAnimator.ofFloat(locall, b, new float[] { 1.0F, 0.0F });
    this.d.setEvaluator(new FloatEvaluator());
    this.d.addUpdateListener(new cl(this, localSpannableString));
    this.d.setInterpolator(new LinearInterpolator());
    this.d.setDuration(1500L);
    this.d.setRepeatCount(-1);
    this.d.start();
  }

  public void a()
  {
    c();
  }

  public void a(long paramLong)
  {
    setAlpha(0.0F);
    View[] arrayOfView = new View[2];
    arrayOfView[0] = this.e;
    arrayOfView[1] = this.j;
    a(1.0F, 0.0F, arrayOfView);
    this.j.a();
    dj.b(this.e, true);
    dj.b(this.i, false);
    dj.b(this.f, false);
    this.i.setImageDrawable(null);
    animate().cancel();
    dj.b(this, true);
    animate().alpha(1.0F).setDuration(paramLong).setListener(null);
    i();
  }

  public void a(SendButton.b.a parama, float paramFloat)
  {
    if (paramFloat == 0.0F)
      return;
    if (parama == SendButton.b.a.c)
    {
      float f2 = 0.0F - this.k;
      float f3 = this.e.getTranslationX() - paramFloat;
      ViberTextView localViberTextView2 = this.e;
      if (f3 >= f2);
      while (true)
      {
        localViberTextView2.setTranslationX(f3);
        return;
        f3 = f2;
      }
    }
    float f1 = paramFloat + this.e.getTranslationX();
    ViberTextView localViberTextView1 = this.e;
    if (f1 <= 0.0F);
    while (true)
    {
      localViberTextView1.setTranslationX(f1);
      return;
      f1 = 0.0F;
    }
  }

  public void a(cm paramcm)
  {
    this.j.a(paramcm, null);
  }

  public void a(Runnable paramRunnable)
  {
    dj.b(this.i, false);
    dj.b(this.e, false);
    dj.b(this.f, true);
    this.f.setOnClickListener(new ck(paramRunnable));
  }

  public void b()
  {
    this.j.b();
    setAlpha(1.0F);
    dj.b(this.i, true);
    this.o = true;
    this.m.reset();
    this.m.setAnimationEndListener(this.n);
    this.i.setImageDrawable(this.l);
    this.e.animate().alpha(0.0F).setDuration(100L);
    this.j.animate().alpha(0.0F).setDuration(100L);
  }

  public void c()
  {
    g();
    animate().alpha(0.0F).setDuration(this.p).setListener(this.q);
  }

  public void d()
  {
    if (!this.o)
      c();
  }

  public void e()
  {
  }

  public long getCurrentTimeInMillis()
  {
    return this.j.getCurrentTimeInMillis();
  }

  protected void onDetachedFromWindow()
  {
    h();
    super.onDetachedFromWindow();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.LayoutParams localLayoutParams = this.e.getLayoutParams();
    if (localLayoutParams.width == -2)
    {
      int i1 = this.e.getMeasuredWidth();
      int i2 = this.e.getMeasuredHeight();
      localLayoutParams.width = i1;
      localLayoutParams.height = i2;
      this.e.setLayoutParams(localLayoutParams);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setHideAnimationDurationMillis(long paramLong)
  {
    this.p = paramLong;
  }

  public void setRecordMessageViewListener(a parama)
  {
    this.c = parama;
  }

  public static abstract interface a
  {
    public abstract void y();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.RecordMessageView
 * JD-Core Version:    0.6.2
 */