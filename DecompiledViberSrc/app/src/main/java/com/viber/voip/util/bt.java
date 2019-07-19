package com.viber.voip.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.method.BaseMovementMethod;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;

public class bt
{
  private static final Logger a = ViberEnv.getLogger();
  private final TextView b;
  private ValueAnimator c;
  private boolean d;
  private boolean e;

  public bt(TextView paramTextView)
  {
    this.b = paramTextView;
  }

  public void a()
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (bt.a(bt.this));
        Layout localLayout;
        Layout.Alignment localAlignment;
        do
        {
          do
          {
            return;
            bt.a(bt.this, true);
            bt.b(bt.this, false);
            localLayout = bt.b(bt.this).getLayout();
          }
          while ((localLayout == null) || (localLayout.getLineCount() > 1));
          localAlignment = localLayout.getAlignment();
        }
        while ((Layout.Alignment.ALIGN_NORMAL != localAlignment) && (Layout.Alignment.ALIGN_OPPOSITE != localAlignment));
        bt.b(bt.this).setEllipsize(null);
        bt.b(bt.this).setHorizontallyScrolling(true);
        bt.b(bt.this).setMovementMethod(new BaseMovementMethod());
        int i;
        label150: int i5;
        if (((Layout.Alignment.ALIGN_NORMAL == localAlignment) && (-1 == localLayout.getParagraphDirection(0))) || ((Layout.Alignment.ALIGN_OPPOSITE == localAlignment) && (1 == localLayout.getParagraphDirection(0))))
        {
          i = 1;
          if (i == 0)
            break label453;
          int i1 = bt.b(bt.this).getRight();
          int i2 = bt.b(bt.this).getLeft();
          int i3 = bt.b(bt.this).getCompoundPaddingLeft();
          int i4 = bt.b(bt.this).getCompoundPaddingRight();
          i5 = i1 - i2 - i3 - i4;
        }
        label453: for (final int j = (int)Math.ceil(localLayout.getLineRight(0)) - i5; ; j = 0)
        {
          bt.b(bt.this).setScrollX(j);
          String str = bt.b(bt.this).getText().toString();
          int k = bt.b(bt.this).getWidth();
          float f = bt.b(bt.this).getPaint().measureText(str);
          int m = 200 * (int)(str.length() - k / (f / str.length()));
          if (k >= f)
            break;
          int n = Math.round(f) - k;
          bt localbt = bt.this;
          int[] arrayOfInt = new int[2];
          arrayOfInt[0] = j;
          arrayOfInt[1] = Math.abs(j - n);
          bt.a(localbt, ValueAnimator.ofInt(arrayOfInt).setDuration(m));
          bt.c(bt.this).setInterpolator(new LinearInterpolator());
          bt.c(bt.this).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
              bt.b(bt.this).setScrollX(i);
            }
          });
          bt.c(bt.this).addListener(new AnimatorListenerAdapter()
          {
            public void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              bt.b(bt.this).setScrollX(j);
              bt.b(bt.this).setMovementMethod(null);
            }

            public void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              bt.a(bt.this, false);
            }
          });
          bt.c(bt.this).start();
          return;
          i = 0;
          break label150;
        }
      }
    };
    if (this.b.getWidth() == 0)
    {
      dj.b(this.b, local1);
      return;
    }
    local1.run();
  }

  public void b()
  {
    if ((this.e) || (this.c == null));
    while (true)
    {
      return;
      this.d = false;
      this.e = true;
      if ((this.c.isStarted()) || (this.c.isRunning()))
        break;
      ArrayList localArrayList = this.c.getListeners();
      if (localArrayList != null)
      {
        int i = localArrayList.size();
        for (int j = 0; j < i; j++)
          ((Animator.AnimatorListener)localArrayList.get(j)).onAnimationCancel(this.c);
      }
    }
    this.c.cancel();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bt
 * JD-Core Version:    0.6.2
 */