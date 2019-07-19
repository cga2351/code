package com.viber.voip.engagement.contacts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ui.ViberButton;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dj;

public class SendHiButtonView extends FrameLayout
{
  private ViberButton a;
  private ImageView b;
  private a c;

  public SendHiButtonView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }

  public SendHiButtonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }

  public SendHiButtonView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    View localView = inflate(paramContext, R.layout.layout_send_hi_button, this);
    this.a = ((ViberButton)localView.findViewById(R.id.send_button));
    this.b = ((ImageView)localView.findViewById(R.id.image_view));
    Drawable localDrawable = df.a(ContextCompat.getDrawable(paramContext, R.drawable.ic_check_mark), dc.d(paramContext, R.attr.sayHiSendIconColor), false);
    this.b.setImageDrawable(localDrawable);
  }

  private void b(boolean paramBoolean)
  {
    int i = 255;
    if ((this.c != null) && (this.c.b()))
      this.c.c();
    ViberButton localViberButton = this.a;
    int j = this.a.getCurrentTextColor();
    int k;
    ImageView localImageView;
    if (paramBoolean)
    {
      k = 0;
      localViberButton.setTextColor(ColorUtils.setAlphaComponent(j, k));
      localImageView = this.b;
      if (!paramBoolean)
        break label91;
    }
    while (true)
    {
      localImageView.setImageAlpha(i);
      dj.c(this.b, paramBoolean);
      return;
      k = i;
      break;
      label91: i = 0;
    }
  }

  public void a()
  {
    if (this.c == null)
      this.c = new a(this.a, this.b);
    this.c.a();
    this.a.setEnabled(false);
  }

  public void a(boolean paramBoolean)
  {
    b(false);
    this.a.setEnabled(paramBoolean);
  }

  public void b()
  {
    if ((this.c != null) && (this.c.b()))
      return;
    b(true);
    this.a.setEnabled(false);
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.a != null)
      this.a.setOnClickListener(paramOnClickListener);
  }

  private class a
  {
    private ViberButton b;
    private ImageView c;
    private int d;
    private ValueAnimator e;
    private ValueAnimator f;
    private AnimatorSet g;
    private final ValueAnimator.AnimatorUpdateListener h = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        SendHiButtonView.a.b(SendHiButtonView.a.this).setTextColor(ColorUtils.setAlphaComponent(SendHiButtonView.a.a(SendHiButtonView.a.this), i));
      }
    };
    private final ValueAnimator.AnimatorUpdateListener i = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        SendHiButtonView.a.c(SendHiButtonView.a.this).setImageAlpha(i);
      }
    };

    public a(ViberButton paramImageView, ImageView arg3)
    {
      this.b = paramImageView;
      Object localObject;
      this.c = localObject;
      this.d = paramImageView.getCurrentTextColor();
      this.f = ValueAnimator.ofInt(new int[] { 255, 0 });
      this.f.setDuration(200L);
      this.f.addUpdateListener(this.h);
      this.e = ValueAnimator.ofInt(new int[] { 0, 255 });
      this.e.setDuration(200L);
      this.e.addUpdateListener(this.i);
      this.e.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          SendHiButtonView.a(SendHiButtonView.this, true);
          super.onAnimationEnd(paramAnonymousAnimator);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          SendHiButtonView.a.c(SendHiButtonView.a.this).setImageAlpha(0);
          dj.b(SendHiButtonView.a.c(SendHiButtonView.a.this), true);
          super.onAnimationStart(paramAnonymousAnimator);
        }
      });
      this.g = new AnimatorSet();
      AnimatorSet localAnimatorSet = this.g;
      Animator[] arrayOfAnimator = new Animator[2];
      arrayOfAnimator[0] = this.f;
      arrayOfAnimator[1] = this.e;
      localAnimatorSet.playSequentially(arrayOfAnimator);
    }

    public void a()
    {
      this.g.start();
    }

    public boolean b()
    {
      return this.g.isRunning();
    }

    public void c()
    {
      this.g.cancel();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.SendHiButtonView
 * JD-Core Version:    0.6.2
 */