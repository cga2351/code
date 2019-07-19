package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.viber.voip.R.styleable;

public class RecyclerViewWithMaxHeight extends RecyclerView
{
  private int a = -1;

  public RecyclerViewWithMaxHeight(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public RecyclerViewWithMaxHeight(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public RecyclerViewWithMaxHeight(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerViewWithMaxHeight);
    try
    {
      this.a = localTypedArray.getDimensionPixelSize(R.styleable.RecyclerViewWithMaxHeight_maxHeight, -1);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() > this.a)
      setMeasuredDimension(getMeasuredWidth(), this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.RecyclerViewWithMaxHeight
 * JD-Core Version:    0.6.2
 */