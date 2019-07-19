package com.viber.voip.util.links;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class e extends LinkMovementMethod
{
  private static e a;
  private boolean b = true;
  private int c = 0;

  @Deprecated
  public static e a()
  {
    if (a == null)
      a = new e();
    return a;
  }

  public static void a(TextView paramTextView)
  {
    if (!(paramTextView.getMovementMethod() instanceof LinkMovementMethod))
    {
      if (paramTextView.getLinksClickable())
        paramTextView.setMovementMethod(a());
    }
    else
      return;
    b(paramTextView);
  }

  public static ClickableSpan[] a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = i - paramTextView.getTotalPaddingLeft();
    int m = j - paramTextView.getTotalPaddingTop();
    int n = k + paramTextView.getScrollX();
    int i1 = m + paramTextView.getScrollY();
    Layout localLayout = paramTextView.getLayout();
    int i2 = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(i1), n);
    return (ClickableSpan[])paramSpannable.getSpans(i2, i2, ClickableSpan.class);
  }

  public static void b(TextView paramTextView)
  {
    paramTextView.setMovementMethod(null);
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean);
    for (this.c = paramInt; ; this.c = 0)
    {
      this.b = paramBoolean;
      do
        return;
      while ((this.b) && (this.c != paramInt));
    }
  }

  public boolean canSelectArbitrarily()
  {
    return true;
  }

  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    return (this.b) && (super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.links.e
 * JD-Core Version:    0.6.2
 */