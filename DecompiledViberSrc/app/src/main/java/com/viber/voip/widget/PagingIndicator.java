package com.viber.voip.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.viber.voip.R.styleable;
import com.viber.voip.util.e.j;

public class PagingIndicator extends View
{
  private int a;
  private int b;
  private Drawable c;
  private int d;
  private int e;
  private Drawable f;
  private int g;
  private int h;
  private int i;

  public PagingIndicator(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public PagingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public PagingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  @TargetApi(21)
  public PagingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int j = j.a(6.0F);
    int k = j.a(5.0F);
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PagingIndicator);
    while (true)
    {
      try
      {
        this.f = localTypedArray.getDrawable(R.styleable.PagingIndicator_idleDrawable);
        this.c = localTypedArray.getDrawable(R.styleable.PagingIndicator_selectedDrawable);
        this.i = localTypedArray.getDimensionPixelOffset(R.styleable.PagingIndicator_indicatorsDistance, k);
        localTypedArray.recycle();
        if (this.c != null)
          break label149;
        this.c = new ColorDrawable(-16777216);
        this.e = j;
        this.d = j;
        if (this.f != null)
          break;
        this.f = new ColorDrawable(-1);
        this.h = j;
        this.g = j;
        return;
      }
      finally
      {
        localTypedArray.recycle();
      }
      this.i = k;
      continue;
      label149: this.d = this.c.getIntrinsicWidth();
      this.e = this.c.getIntrinsicHeight();
    }
    this.g = this.f.getIntrinsicWidth();
    this.h = this.f.getIntrinsicHeight();
  }

  public int getCount()
  {
    return this.a;
  }

  public int getCurrentPage()
  {
    return this.b;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = 0;
    if (m < this.a)
    {
      if (m > 0)
        j += this.i;
      if (m == this.b)
      {
        this.c.setBounds(j, k, j + this.d, k + this.e);
        this.c.draw(paramCanvas);
        j += this.d;
      }
      while (true)
      {
        m++;
        break;
        this.f.setBounds(j, k, j + this.g, k + this.h);
        this.f.draw(paramCanvas);
        j += this.g;
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    int i5;
    if (j == 1073741824)
    {
      if (k == 1073741824)
      {
        i5 = n;
        label40: setMeasuredDimension(m, i5);
      }
    }
    else
      if (this.a <= 0)
        break label177;
    label177: for (int i1 = (-1 + this.a) * (this.g + this.i) + this.d; ; i1 = 0)
    {
      int i2 = i1 + (getPaddingLeft() + getPaddingRight());
      if (j == -2147483648)
      {
        m = Math.min(i2, m);
        break;
        int i3 = this.a;
        int i4 = 0;
        if (i3 > 0)
          i4 = Math.max(this.e, this.h);
        i5 = i4 + (getPaddingTop() + getPaddingBottom());
        if (j != -2147483648)
          break label40;
        i5 = Math.min(i5, n);
        break label40;
      }
      m = i2;
      break;
    }
  }

  public void setCount(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      if (this.b >= paramInt)
        this.b = (paramInt - 1);
      requestLayout();
    }
  }

  public void setCurrentPage(int paramInt)
  {
    if ((this.b != paramInt) && (paramInt >= 0) && (paramInt < this.a))
    {
      this.b = paramInt;
      invalidate();
    }
  }

  public void setIdleDrawable(Drawable paramDrawable)
  {
    if (this.f != paramDrawable)
    {
      this.f = paramDrawable;
      this.g = this.f.getIntrinsicWidth();
      this.h = this.f.getIntrinsicHeight();
      requestLayout();
    }
  }

  public void setIndicatorsDistance(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      requestLayout();
    }
  }

  public void setSelectedDrawable(Drawable paramDrawable)
  {
    if (this.c != paramDrawable)
    {
      this.c = paramDrawable;
      this.d = this.c.getIntrinsicWidth();
      this.e = this.c.getIntrinsicHeight();
      requestLayout();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PagingIndicator
 * JD-Core Version:    0.6.2
 */