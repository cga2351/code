package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.viber.voip.R.styleable;

public class ProportionalLayout extends ViewGroup
{
  private a a;
  private float b;

  public ProportionalLayout(Context paramContext)
  {
    super(paramContext);
  }

  public ProportionalLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ProportionalLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ProportionalLayout);
    if (!isInEditMode());
    for (this.a = a.a(localTypedArray.getString(R.styleable.ProportionalLayout_direction)); ; this.a = a.a)
    {
      this.b = localTypedArray.getFloat(R.styleable.ProportionalLayout_ratio, 1.0F);
      localTypedArray.recycle();
      return;
    }
  }

  public a getDirection()
  {
    return this.a;
  }

  public float getRatio()
  {
    return this.b;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() != 1)
      throw new IllegalStateException("ProportionalLayout requires exactly one child");
    getChildAt(0).layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getChildCount() != 1)
      throw new IllegalStateException("ProportionalLayout requires exactly one child");
    View localView = getChildAt(0);
    measureChild(localView, paramInt1, paramInt2);
    int i = localView.getMeasuredWidth();
    int j = localView.getMeasuredHeight();
    if (this.a == a.b)
      i = Math.round(j * this.b);
    while (true)
    {
      measureChild(localView, View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
      setMeasuredDimension(resolveSize(i, paramInt1), resolveSize(j, paramInt2));
      return;
      j = Math.round(i * this.b);
    }
  }

  public void setDirection(a parama)
  {
    this.a = parama;
  }

  public void setRatio(float paramFloat)
  {
    this.b = paramFloat;
  }

  public static enum a
  {
    public final String c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    private a(String paramString)
    {
      this.c = paramString;
    }

    public static a a(String paramString)
    {
      if (a.c.equals(paramString))
        return a;
      if (b.c.equals(paramString))
        return b;
      throw new IllegalStateException("direction must be either " + a.c + " or " + b.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ProportionalLayout
 * JD-Core Version:    0.6.2
 */