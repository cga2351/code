package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.a.a;
import com.viber.voip.av.e;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class bx extends m
{
  private final g b;

  public bx(Context paramContext, PreferenceScreen paramPreferenceScreen, g paramg)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramg;
  }

  protected void a()
  {
    for (a.a locala : a.a.values())
    {
      String str1 = locala.a();
      String str2 = this.b.a(locala, false);
      f(new x(this.a, x.a.d, "wasabi_debug_" + str1, str1).a(str2).a(this).a());
    }
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("wasabi_ab_tests");
    paramPreferenceGroup.c("Wasabi AB Tests (Debug option)");
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    a.a locala = a.a.a(paramPreference.y().toString());
    if (locala != null)
      av.e.f.a().post(new by(this, locala, paramObject));
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bx
 * JD-Core Version:    0.6.2
 */