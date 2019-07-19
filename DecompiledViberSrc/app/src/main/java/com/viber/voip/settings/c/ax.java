package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.k;
import com.viber.voip.publicaccount.a.a;
import com.viber.voip.settings.d.ao;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import java.util.concurrent.TimeUnit;

public class ax extends m
{
  public ax(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.ao.a.c(), "Enable `age restriction` forcibly").a("Age restricted dialog on sending").a(Boolean.valueOf(d.ao.a.f())).a());
    f(new x(this.a, x.a.c, d.ao.b.c(), "Enable `reply status` suspended forcibly").a("Public account is suspended on sending").a(Boolean.valueOf(d.ao.b.f())).a());
    f(new x(this.a, x.a.c, d.ao.c.c(), "Enable `reply status` deleted forcibly").a("Public account is deleted on sending").a(Boolean.valueOf(d.ao.c.f())).a());
    f(new x(this.a, x.a.c, d.ao.d.c(), "Disable `webhook exist` forcibly").a(Boolean.valueOf(d.ao.d.f())).a("Public account has no 1on1").a());
    f(new x(this.a, x.a.d, d.ao.e.c(), "Bot keyboard config URL").a(d.ao.e.f()).a());
    f(new x(this.a, x.a.d, d.r.p.c(), "Share & Shop Bot's Public Account Id").a("Current Id: " + d.r.p.d()).a(d.r.p.f()).a(this).a());
    f(new x(this.a, x.a.c, d.ao.f.c(), "Use PA ads custom url").b(d.ao.f.d()).a(this).a());
    f(new x(this.a, x.a.d, d.ao.g.c(), "PA ads custom url").a("It overrides url for fetching PA ads").a());
    String str = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(d.ao.i.d()));
    f(new x(this.a, x.a.d, "debug_ads_fetching_timeout_key", "PA ads native timeout").a(str).a("Current timeout: " + str + "sec").a(this).a());
    f(new x(this.a, x.a.a, "pa_ad_reset", "Reset PA ad cache").a(this).a());
    f(new x(this.a, x.a.c, d.ao.h.c(), "Mark all PA as \"bot only PA\" forcibly").a(Boolean.valueOf(d.ao.h.f())).a("All existing PA will have flag \"No PC\"").a());
    f(new x(this.a, x.a.a, "chat_ex_reset", "Reset chat extension cache").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("pref_public_account_group_key");
    paramPreferenceGroup.c("Public Account (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("pa_ad_reset"))
      ViberApplication.getInstance().getMessagesManager().r().f();
    while (!str.equals("chat_ex_reset"))
      return false;
    ViberApplication.getInstance().getChatExtensionsNewDetailsChecker().a("");
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (d.r.p.c().equals(str))
    {
      paramPreference.b("Current Id: " + paramObject);
      return true;
    }
    if ("debug_ads_fetching_timeout_key".equals(str))
      try
      {
        int i = Integer.parseInt((String)paramObject);
        int j = (int)TimeUnit.SECONDS.toMillis(i);
        paramPreference.b("Current timeout: " + i + "sec");
        d.ao.i.a(j);
        return true;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return true;
      }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ax
 * JD-Core Version:    0.6.2
 */