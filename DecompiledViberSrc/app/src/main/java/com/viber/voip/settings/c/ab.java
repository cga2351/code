package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.voip.settings.d.s;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class ab extends m
{
  public ab(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.s.a.c(), "Don't keep scene state").a(Boolean.valueOf(d.s.a.f())).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("doodle2000_key");
    paramPreferenceGroup.c("Doodle2000 (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals(d.s.a.c()))
    {
      boolean bool = ((CheckBoxPreference)paramPreference).b();
      d.s.a.a(bool);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ab
 * JD-Core Version:    0.6.2
 */