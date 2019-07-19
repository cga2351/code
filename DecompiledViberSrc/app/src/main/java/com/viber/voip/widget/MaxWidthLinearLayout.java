package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.viber.voip.R.styleable;

public class MaxWidthLinearLayout extends LinearLayout
{
  private int a = 2147483647;

  public MaxWidthLinearLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public MaxWidthLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public MaxWidthLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MaxWidthLinearLayout);
    try
    {
      this.a = localTypedArray.getDimensionPixelSize(R.styleable.MaxWidthLinearLayout_maxWidth, 2147483647);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getSize(paramInt1) > this.a)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.a, i);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.MaxWidthLinearLayout
 * JD-Core Version:    0.6.2
 */