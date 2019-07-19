package com.viber.voip.settings.ui;

import android.content.Context;
import android.support.v7.preference.EditTextPreference;
import android.util.AttributeSet;
import com.viber.voip.R.layout;

public class ViberEditTextPreference extends EditTextPreference
{
  public ViberEditTextPreference(Context paramContext)
  {
    super(paramContext);
    m();
  }

  public ViberEditTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    m();
  }

  public ViberEditTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    m();
  }

  private void m()
  {
    c(R.layout._ics_custom_preference_layout);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ViberEditTextPreference
 * JD-Core Version:    0.6.2
 */