package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.publicaccount.d.a;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class bv extends m
{
  private static final Logger b = ViberEnv.getLogger();
  private final String[] c = { "Hidden", "No create", "Full", "Disabled" };

  public bv(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    int i = a.a().c();
    f(new x(this.a, x.a.b, "vibes_key", "Vibes state").a(this.c).b(this.c).c(this.c[i]).a(this.c[i]).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("vibes_settings_key");
    paramPreferenceGroup.c("Vibes (Debug option)");
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    boolean bool1 = paramPreference.C().equals("vibes_key");
    boolean bool2 = false;
    int i;
    if (bool1)
    {
      i = 0;
      if (i >= this.c.length)
        break label75;
      if (!this.c[i].equals(paramObject))
        break label69;
    }
    while (true)
    {
      a.a().a(i);
      paramPreference.b(this.c[i]);
      bool2 = true;
      return bool2;
      label69: i++;
      break;
      label75: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bv
 * JD-Core Version:    0.6.2
 */