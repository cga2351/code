package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.viber.voip.R.styleable;

public class FormattedMessageLayout extends LinearLayout
{
  private int a;

  public FormattedMessageLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public FormattedMessageLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, null);
  }

  public FormattedMessageLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, null);
  }

  public FormattedMessageLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, null);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormattedMessageLayout);
    try
    {
      this.a = localTypedArray.getDimensionPixelSize(R.styleable.FormattedMessageLayout_maximumWidth, 2147483647);
      localTypedArray.recycle();
      setOrientation(1);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  protected int a(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt), this.a), i);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(a(paramInt1), paramInt2);
  }

  public void setMaximumWidth(int paramInt)
  {
    if (paramInt != this.a)
    {
      this.a = paramInt;
      requestLayout();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.FormattedMessageLayout
 * JD-Core Version:    0.6.2
 */