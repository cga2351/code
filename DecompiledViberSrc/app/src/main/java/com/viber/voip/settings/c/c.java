package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.apps.a;
import com.viber.voip.settings.d.g;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import java.util.concurrent.TimeUnit;

public class c extends m
{
  private PreferenceScreen b;

  public c(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramPreferenceScreen;
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.g.a.c(), "Games API").b(d.g.a.d()).a(this).a());
    f(new x(this.a, x.a.c, d.g.d.c(), "Click macro always on").b(d.g.d.f()).a());
    f(new x(this.a, x.a.a, "clear_cached_apps", "Remove all cached applications' info").a(this).a());
    f(new x(this.a, x.a.c, d.g.e.c(), "Check 3rd Party App Authentication").a(Boolean.valueOf(d.g.e.d())).a());
    x localx = new x(this.a, x.a.b, d.g.f.c(), "App/Services info sync period").a(d.g.f.d()).a(new CharSequence[] { "24h", "1h", "30m", "5m", "1m" });
    CharSequence[] arrayOfCharSequence = new CharSequence[5];
    arrayOfCharSequence[0] = String.valueOf(TimeUnit.HOURS.toSeconds(24L));
    arrayOfCharSequence[1] = String.valueOf(TimeUnit.HOURS.toSeconds(1L));
    arrayOfCharSequence[2] = String.valueOf(TimeUnit.MINUTES.toSeconds(30L));
    arrayOfCharSequence[3] = String.valueOf(TimeUnit.MINUTES.toSeconds(5L));
    arrayOfCharSequence[4] = String.valueOf(TimeUnit.MINUTES.toSeconds(1L));
    f(localx.b(arrayOfCharSequence).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("games_api_key");
    paramPreferenceGroup.c("Apps API (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals("clear_cached_apps"))
    {
      new a().d();
      Toast.makeText(this.a, "Cached applications' info have been removed", 0).show();
    }
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if (paramPreference.C().equals(d.g.f.c()))
    {
      d.g.f.a((String)paramObject);
      ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c((String)paramObject));
      Toast.makeText(this.a, "Period's changed. Need to restart Viber for applying it.", 1).show();
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.c
 * JD-Core Version:    0.6.2
 */