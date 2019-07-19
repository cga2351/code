package com.viber.voip.settings.c;

import android.app.Activity;
import android.content.Context;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.settings.d.bc;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.j.av;
import com.viber.voip.ui.j.ax;

public class bh extends m
{
  private final Preference[] b;
  private final av c;

  public bh(Context paramContext, PreferenceScreen paramPreferenceScreen, av paramav)
  {
    super(paramContext, paramPreferenceScreen);
    this.c = paramav;
    int i = 1 + ax.values().length;
    this.b = new Preference[i];
    Preference localPreference1 = new x(this.a, x.a.c, d.bc.c.c(), "Display button for quick theme switching").a(new bi(this)).a();
    this.b[0] = localPreference1;
    for (int j = 1; j < i; j++)
    {
      ax localax = ax.values()[(j - 1)];
      Preference localPreference2 = new x(this.a, x.a.c, localax.b(), localax.c()).a(new bj(this, localax)).b(localax.a().equals(d.bc.a.d())).a();
      this.b[j] = localPreference2;
    }
  }

  private void b(ax paramax, Preference paramPreference)
  {
    d.bc.a.a(paramax.a());
    Preference[] arrayOfPreference = this.b;
    int i = arrayOfPreference.length;
    int j = 0;
    if (j < i)
    {
      Preference localPreference = arrayOfPreference[j];
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)localPreference;
      if (localPreference == paramPreference);
      for (boolean bool = true; ; bool = false)
      {
        localCheckBoxPreference.f(bool);
        j++;
        break;
      }
    }
    this.c.a(paramax);
    if ((this.a instanceof Activity))
      ((Activity)this.a).finish();
  }

  protected void a()
  {
    Preference[] arrayOfPreference = this.b;
    int i = arrayOfPreference.length;
    for (int j = 0; j < i; j++)
      f(arrayOfPreference[j]);
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("switch_theme");
    paramPreferenceGroup.c("Switch Theme (Debug option)");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bh
 * JD-Core Version:    0.6.2
 */