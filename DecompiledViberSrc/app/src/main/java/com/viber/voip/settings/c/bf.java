package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class bf extends m
{
  public bf(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.ax.v.c(), "Emulate sticker load out of memory error").a(Boolean.valueOf(d.ax.v.f())).a());
    f(new x(this.a, x.a.c, d.r.w.c(), "Sticker search blue icon (Menu)").b(d.r.w.d()).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("sticker_key");
    paramPreferenceGroup.c("Stickers (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals(d.ax.v.c()))
    {
      boolean bool = ((CheckBoxPreference)paramPreference).b();
      d.ax.v.a(bool);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bf
 * JD-Core Version:    0.6.2
 */