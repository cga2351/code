package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import com.viber.voip.R.attr;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.ViberTextView;

public class PercentTextView extends ViberTextView
{
  private v a;

  public PercentTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public PercentTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public PercentTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    this.a = new v(paramContext, R.styleable.PercentTextView, R.attr.percentTextViewStyle, R.styleable.PercentTextView_percent_width_max);
    this.a.a(paramAttributeSet);
  }

  public float getPercent()
  {
    return this.a.b();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.a(paramConfiguration);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a.a();
    super.onMeasure(this.a.a(paramInt1), this.a.b(paramInt2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PercentTextView
 * JD-Core Version:    0.6.2
 */