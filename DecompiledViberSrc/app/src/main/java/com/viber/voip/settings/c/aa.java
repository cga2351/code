package com.viber.voip.settings.c;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.view.ContextThemeWrapper;
import android.widget.Toast;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ay;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.da;
import java.util.concurrent.TimeUnit;

public class aa extends m
{
  private static final Logger b = ViberEnv.getLogger();

  public aa(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private static Activity a(Context paramContext)
  {
    if ((paramContext instanceof Activity))
      return (Activity)paramContext;
    if ((paramContext instanceof ContextThemeWrapper))
      return a(((ContextThemeWrapper)paramContext).getBaseContext());
    if ((paramContext instanceof android.support.v7.view.d))
      return a(((android.support.v7.view.d)paramContext).getBaseContext());
    return null;
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.ad.f.c(), "Enable Strict Mode").a(this).a());
    f(new x(this.a, x.a.c, d.ad.g.c(), "Enable detect memory leaks").a(this).a());
    f(new x(this.a, x.a.d, d.ad.H.c(), "Video converter request debug hint").a(d.ad.H.d()).a(d.ad.H.f()).a(this).a());
    f(new x(this.a, x.a.a, "PREF_SIMULATE_ANR", "Simulate ANR").a(this).a());
    f(new x(this.a, x.a.a, "pref_debug_simulate_runtime_app_crash", "Simulate runtime crash").a(this).a());
    f(new x(this.a, x.a.d, "Emoji Key Value", "Test Snappy write/read").a("😃🎍😍 Home of Emoji Meanings 💁👌🎍😍").a("😃🎍😍 Home of Emoji Meanings 💁👌🎍😍").a(this).a());
    f(new x(this.a, x.a.a, "pref_snappy_open_error", "Snappy: simulate open database error").a(this).a());
    f(new x(this.a, x.a.a, "pref_snappy_read_error", "Snappy: simulate get value from db error").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("developer_tool");
    paramPreferenceGroup.c("Developer tool (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals(d.ad.f.c()))
    {
      Activity localActivity2 = a(this.a);
      if (localActivity2 != null)
        ViberApplication.exit(localActivity2, true);
    }
    do
    {
      Activity localActivity1;
      do
      {
        return false;
        if (!paramPreference.C().equals(d.ad.g.c()))
          break;
        localActivity1 = a(this.a);
      }
      while (localActivity1 == null);
      ViberApplication.exit(localActivity1, true);
      return false;
      if (paramPreference.C().equals("PREF_SIMULATE_ANR"))
      {
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(10L));
        return false;
      }
      if (paramPreference.C().equals("pref_debug_simulate_runtime_app_crash"))
        throw new RuntimeException("This is a sample crash");
      if (paramPreference.C().equals("pref_snappy_open_error"))
      {
        d.ay.c.a(true);
        return false;
      }
    }
    while (!paramPreference.C().equals("pref_snappy_read_error"));
    d.ay.d.a(true);
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str1 = paramPreference.C();
    if (str1.equals(d.ad.H.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    if (str1.equals("Emoji Key Value"))
    {
      String str2 = paramObject.toString();
      com.viber.voip.model.a.b.d().a("😃Testcategory 💁👌🎍😍", str2, str2);
      if (!da.a(com.viber.voip.model.a.b.d().d("😃Testcategory 💁👌🎍😍", str2), str2))
      {
        Toast.makeText(this.a, "Test Snappy with Emoji failed", 1).show();
        return true;
      }
      Toast.makeText(this.a, "Test Snappy with Emoji success", 1).show();
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.aa
 * JD-Core Version:    0.6.2
 */