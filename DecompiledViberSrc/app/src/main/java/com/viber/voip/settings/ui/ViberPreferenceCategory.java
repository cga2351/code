package com.viber.voip.settings.ui;

import android.content.Context;
import android.support.v7.preference.PreferenceCategory;
import android.util.AttributeSet;
import com.viber.voip.R.layout;

public class ViberPreferenceCategory extends PreferenceCategory
{
  public ViberPreferenceCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i();
  }

  private void i()
  {
    c(R.layout.pref_category);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ViberPreferenceCategory
 * JD-Core Version:    0.6.2
 */