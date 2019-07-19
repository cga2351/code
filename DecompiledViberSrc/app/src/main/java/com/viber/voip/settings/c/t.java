package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.h;
import com.viber.voip.settings.d.a;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class t extends m
{
  public t(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.d, d.a.d.c(), "SIM serials").a("It overrides last known SIM serials (several SIM serials should be splitted by '/')").a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("change_phone_number");
    paramPreferenceGroup.c("Change phone number (Debug option)");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.t
 * JD-Core Version:    0.6.2
 */