package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class af extends m
{
  public af(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.ad.n.c(), "Use v1 (old)").a(Boolean.valueOf(d.ad.n.f())).a("Will use google maps v1 (deprecated from google)").a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("google_maps_key");
    paramPreferenceGroup.c("Goolge Maps Version (Debug option)");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.af
 * JD-Core Version:    0.6.2
 */