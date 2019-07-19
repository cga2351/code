package com.viber.voip.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MessageTextView extends PercentTextView
{
  public MessageTextView(Context paramContext)
  {
    super(paramContext);
  }

  public MessageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public MessageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    MovementMethod localMovementMethod = getMovementMethod();
    if ((localMovementMethod != null) && (isEnabled()) && ((getText() instanceof Spannable)))
      return localMovementMethod.onTouchEvent(this, (Spannable)getText(), paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.MessageTextView
 * JD-Core Version:    0.6.2
 */