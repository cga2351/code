package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

@SuppressLint({"AppCompatCustomView"})
public class at extends TextView
{
  private final GradientDrawable a = new GradientDrawable();
  private final int b;

  public at(Context paramContext)
  {
    this(paramContext, null);
  }

  public at(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public at(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.setStroke(0, -13421773);
    this.a.setColor(0);
    this.b = ((int)TypedValue.applyDimension(1, 2.0F, paramContext.getResources().getDisplayMetrics()));
  }

  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.setStroke(paramInt1, paramInt2);
    this.a.setCornerRadius(paramInt3);
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.a.setBounds(getPaddingLeft() - this.b, getPaddingTop(), getWidth(), getHeight());
    this.a.draw(paramCanvas);
    super.onDraw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getMeasuredWidth() + 2 * this.b, getMeasuredHeight());
  }

  public void setBackgroundColor(int paramInt)
  {
    this.a.setColor(paramInt);
    invalidate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.at
 * JD-Core Version:    0.6.2
 */