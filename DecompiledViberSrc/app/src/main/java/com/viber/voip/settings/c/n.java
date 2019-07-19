package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.d;
import com.viber.common.dialogs.l.a;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.dialogs.ad;

public class n extends m
{
  public n(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, d.r.A.c(), "Broadcast list max recipients").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("broadcast_list_key");
    paramPreferenceGroup.c("Broadcast List");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals(d.r.A.c()))
      ad.s().d();
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.n
 * JD-Core Version:    0.6.2
 */