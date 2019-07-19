package com.viber.voip.widget;

import android.content.Context;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.l;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class LongSummaryCheckbBoxPreference extends CheckBoxPreference
{
  private View.OnClickListener b;
  private final x c = new x();

  public LongSummaryCheckbBoxPreference(Context paramContext)
  {
    super(paramContext);
  }

  public LongSummaryCheckbBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public LongSummaryCheckbBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(l paraml)
  {
    super.a(paraml);
    TextView localTextView = (TextView)paraml.a(16908304);
    this.c.a(this.b);
    localTextView.setOnTouchListener(this.c);
    localTextView.setMaxLines(10);
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.LongSummaryCheckbBoxPreference
 * JD-Core Version:    0.6.2
 */