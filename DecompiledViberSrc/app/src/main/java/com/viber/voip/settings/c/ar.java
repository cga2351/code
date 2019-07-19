package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.settings.d.ab;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class ar extends m
{
  public ar(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.ab.a.c(), "Upload base url manual").a());
    f(new x(this.a, x.a.d, d.ab.c.c(), "Upload base url").a());
    f(new x(this.a, x.a.c, d.ab.b.c(), "Download base url manual").a());
    f(new x(this.a, x.a.d, d.ab.d.c(), "Download base url").a());
    f(new x(this.a, x.a.c, d.ab.e.c(), "Blur conversation media thumbnails").b(d.ab.e.d()).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("media_settings_key");
    paramPreferenceGroup.c("Media");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ar
 * JD-Core Version:    0.6.2
 */