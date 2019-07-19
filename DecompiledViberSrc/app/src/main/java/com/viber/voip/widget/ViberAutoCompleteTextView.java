package com.viber.voip.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;

public class ViberAutoCompleteTextView extends AppCompatAutoCompleteTextView
{
  public ViberAutoCompleteTextView(Context paramContext)
  {
    super(paramContext);
  }

  public ViberAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ViberAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean enoughToFilter()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ViberAutoCompleteTextView
 * JD-Core Version:    0.6.2
 */