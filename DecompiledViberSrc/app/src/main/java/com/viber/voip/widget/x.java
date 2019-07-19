package com.viber.voip.widget;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class x
  implements View.OnTouchListener
{
  private View.OnClickListener a;

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      CharSequence localCharSequence = ((TextView)paramView).getText();
      Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(localCharSequence);
      TextView localTextView = (TextView)paramView;
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = j - localTextView.getTotalPaddingLeft();
      int n = k - localTextView.getTotalPaddingTop();
      int i1 = m + localTextView.getScrollX();
      int i2 = n + localTextView.getScrollY();
      Layout localLayout = localTextView.getLayout();
      int i3 = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(i2), i1);
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])localSpannable.getSpans(i3, i3, ClickableSpan.class);
      if (arrayOfClickableSpan.length != 0)
      {
        if (i == 1)
        {
          if (this.a == null)
            break label166;
          this.a.onClick(localTextView);
        }
        while (true)
        {
          return true;
          label166: arrayOfClickableSpan[0].onClick(localTextView);
        }
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.x
 * JD-Core Version:    0.6.2
 */