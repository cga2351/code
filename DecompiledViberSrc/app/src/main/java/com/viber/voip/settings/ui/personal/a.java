package com.viber.voip.settings.ui.personal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.xml;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.j;
import com.viber.voip.i.f;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.v;
import com.viber.voip.settings.ui.SettingsHeadersActivity.a;
import com.viber.voip.settings.ui.al;
import com.viber.voip.settings.ui.al.a;
import com.viber.voip.util.ViberActionRunner.ay;
import com.viber.voip.util.ViberActionRunner.y;

public class a extends SettingsHeadersActivity.a
  implements m.c, al.a
{
  private static final Logger b = ViberEnv.getLogger();
  private al c;

  public void a(String paramString, boolean paramBoolean)
  {
    b(paramString, paramBoolean);
  }

  public boolean a(Preference paramPreference)
  {
    if (d.v.a.c().equals(paramPreference.C()))
    {
      ViberActionRunner.ay.d(getContext());
      return true;
    }
    if (d.v.b.c().equals(paramPreference.C()))
    {
      ViberActionRunner.ay.j(getContext());
      return true;
    }
    if (d.v.d.c().equals(paramPreference.C()))
    {
      ViberActionRunner.y.b(getContext(), 2);
      return true;
    }
    return super.a(paramPreference);
  }

  protected void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_personal_data, paramString);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = new al(this, this);
    if (c.j.b.e())
      b().d(a(d.f.d.c()));
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    this.c.onDialogAction(paramm, paramInt);
  }

  public void onResume()
  {
    super.onResume();
    this.c.a();
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
    this.c.onSharedPreferenceChanged(paramSharedPreferences, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.personal.a
 * JD-Core Version:    0.6.2
 */