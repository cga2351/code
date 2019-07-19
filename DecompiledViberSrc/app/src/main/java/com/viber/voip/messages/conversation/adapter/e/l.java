package com.viber.voip.messages.conversation.adapter.e;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.GestureDetectorCompat;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f;
import com.viber.voip.ui.style.UserMentionSpan;

public class l extends LinkMovementMethod
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = ViewConfiguration.getPressedStateDuration();
  private static final long c = ViewConfiguration.getTapTimeout();
  private final TextView d;
  private final f e;
  private final GestureDetectorCompat f;
  private final Handler g;
  private final Runnable h = new m(this);
  private final Runnable i = new n(this);
  private final GestureDetector.SimpleOnGestureListener j = new GestureDetector.SimpleOnGestureListener()
  {
    public void onLongPress(MotionEvent paramAnonymousMotionEvent)
    {
      l.a(l.this, paramAnonymousMotionEvent);
    }

    public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
    {
      return l.b(l.this, paramAnonymousMotionEvent);
    }
  };

  public l(TextView paramTextView, f paramf)
  {
    this.d = paramTextView;
    this.e = paramf;
    this.g = new Handler(Looper.getMainLooper());
    this.f = new GestureDetectorCompat(paramTextView.getContext(), this.j);
  }

  private void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 2:
    default:
      return;
    case 0:
      this.g.postDelayed(this.h, c);
      return;
    case 1:
      this.g.removeCallbacks(this.h);
      if (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= c)
      {
        a(true);
        this.g.postDelayed(this.i, b);
        return;
      }
      a(false);
      return;
    case 3:
    case 4:
    }
    this.g.removeCallbacks(this.h);
    a(false);
  }

  private void a(boolean paramBoolean)
  {
    if (this.e != null)
    {
      this.e.a(paramBoolean);
      return;
    }
    this.d.setPressed(paramBoolean);
  }

  private ClickableSpan[] a(CharSequence paramCharSequence, MotionEvent paramMotionEvent)
  {
    if (!(paramCharSequence instanceof Spannable))
      return null;
    Spannable localSpannable = (Spannable)paramCharSequence;
    int k = (int)paramMotionEvent.getX();
    int m = (int)paramMotionEvent.getY();
    int n = k - this.d.getTotalPaddingLeft();
    int i1 = m - this.d.getTotalPaddingTop();
    int i2 = n + this.d.getScrollX();
    int i3 = i1 + this.d.getScrollY();
    Layout localLayout = this.d.getLayout();
    int i4 = localLayout.getLineForVertical(i3);
    if ((i2 < localLayout.getLineLeft(i4)) || (i2 > localLayout.getLineRight(i4)))
      return new ClickableSpan[0];
    float f1 = i2;
    try
    {
      int i5 = localLayout.getOffsetForHorizontal(i4, f1);
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])localSpannable.getSpans(i5, i5, ClickableSpan.class);
      return arrayOfClickableSpan;
    }
    catch (Exception localException)
    {
    }
    return new ClickableSpan[0];
  }

  private void b(MotionEvent paramMotionEvent)
  {
    if (this.e != null)
    {
      this.e.a(paramMotionEvent.getX(), paramMotionEvent.getY());
      return;
    }
    if (a.k())
    {
      this.d.performLongClick(paramMotionEvent.getX(), paramMotionEvent.getY());
      return;
    }
    this.d.performLongClick();
  }

  private boolean c(MotionEvent paramMotionEvent)
  {
    ClickableSpan[] arrayOfClickableSpan = a(this.d.getText(), paramMotionEvent);
    if ((arrayOfClickableSpan == null) || (arrayOfClickableSpan.length == 0))
      return false;
    ClickableSpan localClickableSpan1 = arrayOfClickableSpan[0];
    int k = arrayOfClickableSpan.length;
    int m = 0;
    ClickableSpan localClickableSpan2;
    if (m < k)
    {
      localClickableSpan2 = arrayOfClickableSpan[m];
      if (!(localClickableSpan2 instanceof UserMentionSpan));
    }
    while (true)
    {
      localClickableSpan2.onClick(this.d);
      return false;
      m++;
      break;
      localClickableSpan2 = localClickableSpan1;
    }
  }

  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    return (this.f.onTouchEvent(paramMotionEvent)) || (Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.l
 * JD-Core Version:    0.6.2
 */