package com.viber.voip.settings.c;

import android.app.Activity;
import android.content.Context;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.settings.d.be;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.bn;
import com.viber.voip.ui.dialogs.e;

public class bl extends m
{
  private final Activity b;

  public bl(Context paramContext, PreferenceScreen paramPreferenceScreen, Activity paramActivity)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramActivity;
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.be.f.c(), "Disable request update").a("Disable request updat").a(Boolean.valueOf(d.be.f.f())).a(this).a());
    f(new x(this.a, x.a.c, d.be.g.c(), "Disable cancelable update dialog").a("Disable possibility to cancel (it exists only on DEBUG mode) \"Required Update\" dialog").a(Boolean.valueOf(d.be.g.f())).a(this).a());
    f(new x(this.a, x.a.a, "key_require_update", "Dummy \"Require update\"").a("Simulate \"Require update\" callback from voiceLib").a(this).a());
    f(new x(this.a, x.a.a, "key_suggest_update", "Dummy \"Suggest update\"").a("Simulate \"Suggest update\" callback from voiceLib").a(this).a());
    f(new x(this.a, x.a.a, "key_debug_require_accept_privacy", "Dummy \"Require accept privacy\"").a("Start \"Require accept terms and privacy policy\" flow").a(this).a());
    f(new x(this.a, x.a.c, d.be.e.c(), "Is Viber banned on GP").a("It simulate the situation of being in a restricted country").a(Boolean.valueOf(d.be.e.f())).a(this).a());
    f(new x(this.a, x.a.a, "key_show_require_update", "Show \"Require update\" dialog").a("Show \"Require update\" dialog").a(this).a());
    f(new x(this.a, x.a.a, "key_show_suggest_update", "Show \"Suggest update\" dialog").a("Show \"Suggest update\" dialog").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("update_key");
    paramPreferenceGroup.c("Update Viber (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("key_require_update"))
      com.viber.voip.notif.h.a().e();
    while (true)
    {
      return false;
      if (str.equals("key_suggest_update"))
      {
        d.be.a.e();
        com.viber.voip.notif.h.a().f();
      }
      else if (str.equals("key_debug_require_accept_privacy"))
      {
        com.viber.voip.notif.h.a().g();
      }
      else if (str.equals(d.be.e.c()))
      {
        boolean bool3 = ((CheckBoxPreference)paramPreference).b();
        d.be.e.a(bool3);
      }
      else if (str.equals(d.be.f.c()))
      {
        boolean bool2 = ((CheckBoxPreference)paramPreference).b();
        d.be.f.a(bool2);
      }
      else if (str.equals(d.be.g.c()))
      {
        boolean bool1 = ((CheckBoxPreference)paramPreference).b();
        d.be.g.a(bool1);
      }
      else if (str.equals("key_show_suggest_update"))
      {
        e.d().a(new ViberDialogHandlers.bn()).a(this.b);
      }
      else if (str.equals("key_show_require_update"))
      {
        e.c().a(new ViberDialogHandlers.bn()).a(this.b);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bl
 * JD-Core Version:    0.6.2
 */