package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class SquareFrameLayout extends FrameLayout
{
  public SquareFrameLayout(Context paramContext)
  {
    super(paramContext);
  }

  public SquareFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SquareFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getSize(paramInt1) > View.MeasureSpec.getSize(paramInt2));
    while (true)
    {
      super.onMeasure(paramInt2, paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.SquareFrameLayout
 * JD-Core Version:    0.6.2
 */