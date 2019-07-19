package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.viber.voip.R.attr;
import com.viber.voip.R.styleable;

public class PercentConstraintLayout extends ConstraintLayout
{
  private float g = 1.0F;

  public PercentConstraintLayout(Context paramContext)
  {
    super(paramContext);
    b(null);
  }

  public PercentConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramAttributeSet);
  }

  public PercentConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramAttributeSet);
  }

  private void b(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.PercentConstraintLayout);
      setPercent(localTypedArray);
      localTypedArray.recycle();
    }
  }

  private void setPercent(TypedArray paramTypedArray)
  {
    this.g = paramTypedArray.getFloat(R.styleable.PercentTextView_percent_width_max, 1.0F);
    if ((this.g <= 0.0F) || (this.g > 1.0F))
      this.g = 1.0F;
  }

  public float getPercent()
  {
    return this.g;
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.PercentConstraintLayout, R.attr.percentConstraintLayout, 0);
    setPercent(localTypedArray);
    localTypedArray.recycle();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.g != 1.0F) && (getLayoutParams().width != 0))
    {
      int i = View.MeasureSpec.getSize(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt1);
      if (j != 0)
        paramInt1 = View.MeasureSpec.makeMeasureSpec((int)(i * this.g), j);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PercentConstraintLayout
 * JD-Core Version:    0.6.2
 */