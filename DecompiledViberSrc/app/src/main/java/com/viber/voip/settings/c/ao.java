package com.viber.voip.settings.c;

import android.app.Activity;
import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.a.a;
import com.viber.common.a.e.a;
import com.viber.common.b.h;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.y;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.at;
import java.io.File;

public class ao extends m
{
  private Activity b;

  public ao(Activity paramActivity, Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramActivity;
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "clean_logs_pref", "Clean logs folder").a(this).a());
    f(new x(this.a, x.a.b, d.y.b.c(), "Log level").a(d.y.b.d()).a(d.y.b.f()).a(e.a.a()).b(e.a.a()).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("logging_key");
    paramPreferenceGroup.c("Log Options");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals("clean_logs_pref"))
    {
      at.h(ViberEnv.getLoggerFactory().getLoggerConfig().a().getParentFile());
      ViberApplication.exit(this.b, true);
      return true;
    }
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if (paramPreference.C().equals(d.y.b.c()))
    {
      ViberEnv.getLoggerFactory().setLogLevel(e.a.valueOf((String)paramObject));
      paramPreference.b((CharSequence)paramObject);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ao
 * JD-Core Version:    0.6.2
 */