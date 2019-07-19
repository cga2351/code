package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.viber.voip.R.styleable;

public final class a extends FrameLayout
{
  private float a;
  private int b = 0;

  public a(Context paramContext)
  {
    this(paramContext, null);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
      localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
    try
    {
      this.b = localTypedArray.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public int getResizeMode()
  {
    return this.b;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.b == 3) || (this.a <= 0.0F));
    int i;
    int j;
    float f2;
    do
    {
      return;
      i = getMeasuredWidth();
      j = getMeasuredHeight();
      float f1 = i / j;
      f2 = this.a / f1 - 1.0F;
    }
    while (Math.abs(f2) <= 0.01F);
    switch (this.b)
    {
    case 3:
    default:
      if (f2 > 0.0F)
        j = (int)(i / this.a);
      break;
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
      return;
      j = (int)(i / this.a);
      continue;
      i = (int)(j * this.a);
      continue;
      if (f2 > 0.0F)
      {
        i = (int)(j * this.a);
      }
      else
      {
        j = (int)(i / this.a);
        continue;
        i = (int)(j * this.a);
      }
    }
  }

  public void setAspectRatio(float paramFloat)
  {
    if (this.a != paramFloat)
    {
      this.a = paramFloat;
      requestLayout();
    }
  }

  public void setResizeMode(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      requestLayout();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.a
 * JD-Core Version:    0.6.2
 */