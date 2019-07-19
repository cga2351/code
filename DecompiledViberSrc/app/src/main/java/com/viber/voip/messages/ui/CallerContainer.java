package com.viber.voip.messages.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.viber.voip.util.dj;

public class CallerContainer extends cz
{
  public CallerContainer(Context paramContext)
  {
    super(paramContext);
  }

  public CallerContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CallerContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(int paramInt)
  {
    super.a(paramInt);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getMeasuredHeight();
    super.onMeasure(paramInt1, paramInt2);
    if ((getMeasuredHeight() < i) && (dj.c(getContext())) && (i - getMeasuredHeight() >= 2 * dj.c()))
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.CallerContainer
 * JD-Core Version:    0.6.2
 */