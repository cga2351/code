package com.viber.voip.settings.ui;

import android.content.Context;
import android.support.v7.preference.ListPreference;
import android.util.AttributeSet;
import com.viber.voip.R.layout;

public class ViberListPreference extends ListPreference
{
  public ViberListPreference(Context paramContext)
  {
    super(paramContext);
    b();
  }

  public ViberListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  private void b()
  {
    c(R.layout._ics_custom_preference_layout);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ViberListPreference
 * JD-Core Version:    0.6.2
 */