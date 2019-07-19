package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class at extends m
{
  public at(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.ag.k.c(), "Show notification channel id").a(Boolean.valueOf(d.ag.k.f())).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("notifications_key");
    paramPreferenceGroup.c("Notifications");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.at
 * JD-Core Version:    0.6.2
 */