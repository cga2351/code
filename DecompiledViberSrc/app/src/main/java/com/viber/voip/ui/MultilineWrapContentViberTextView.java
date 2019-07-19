package com.viber.voip.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class MultilineWrapContentViberTextView extends ViberTextView
{
  public MultilineWrapContentViberTextView(Context paramContext)
  {
    super(paramContext);
  }

  public MultilineWrapContentViberTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public MultilineWrapContentViberTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private int a(Layout paramLayout)
  {
    float f1 = 0.0F;
    int i = paramLayout.getLineCount();
    int j = 0;
    float f2;
    if (j < i)
    {
      f2 = paramLayout.getLineMax(j);
      if (f2 <= f1)
        break label45;
    }
    while (true)
    {
      j++;
      f1 = f2;
      break;
      return Math.round(f1);
      label45: f2 = f1;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) == -2147483648)
    {
      Layout localLayout = getLayout();
      if (localLayout != null)
      {
        int i = a(localLayout) + getCompoundPaddingLeft() + getCompoundPaddingRight();
        if (i < getMeasuredWidth())
          super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), paramInt2);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.MultilineWrapContentViberTextView
 * JD-Core Version:    0.6.2
 */