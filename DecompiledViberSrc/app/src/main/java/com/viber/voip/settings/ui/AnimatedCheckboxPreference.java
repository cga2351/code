package com.viber.voip.settings.ui;

import android.content.Context;
import android.support.v7.preference.l;
import android.util.AttributeSet;

public class AnimatedCheckboxPreference extends ViberCheckboxPreference
  implements aq
{
  private aq.a b;

  public AnimatedCheckboxPreference(Context paramContext)
  {
    super(paramContext);
  }

  public AnimatedCheckboxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AnimatedCheckboxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(l paraml)
  {
    super.a(paraml);
    if (this.b != null)
      this.b.a(C(), paraml.itemView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.AnimatedCheckboxPreference
 * JD-Core Version:    0.6.2
 */