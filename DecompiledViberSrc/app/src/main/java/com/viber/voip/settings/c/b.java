package com.viber.voip.settings.c;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.c.a;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.appboy.b.a.c;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import com.viber.common.b.d;
import com.viber.common.b.e;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g.g.c;
import com.viber.voip.ap;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.aw;
import com.viber.voip.settings.d.bn;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import java.util.concurrent.TimeUnit;

public class b extends m
{
  private PreferenceScreen b;
  private String[] c = new String[com.appboy.b.a.h.values().length];

  public b(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    com.appboy.b.a.h[] arrayOfh = com.appboy.b.a.h.values();
    int i = 0;
    int j = arrayOfh.length;
    while (i < j)
    {
      this.c[i] = arrayOfh[i].name();
      i++;
    }
    this.b = paramPreferenceScreen;
  }

  private String d()
  {
    com.viber.voip.analytics.e.b localb = (com.viber.voip.analytics.e.b)com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.e.b.class);
    StringBuilder localStringBuilder = new StringBuilder().append("Regular events tracking: ");
    if (localb.b());
    for (String str = "ON"; ; str = "OFF")
      return str;
  }

  private void e()
  {
    String str1 = com.viber.voip.analytics.g.a().j();
    g.c localc = new com.viber.voip.analytics.g.g().a(str1);
    c.a locala = new c.a(this.a);
    if (localc != null);
    for (String str2 = localc.toString(); ; str2 = "Parsing error of wasabi config")
    {
      locala.b(str2);
      locala.a("Close", null);
      locala.c();
      return;
    }
  }

  private void f()
  {
    av.a(av.e.f).postDelayed(new Runnable()
    {
      public void run()
      {
        com.appboy.e.m localm = new com.appboy.e.m();
        localm.a(c.a);
        localm.a(5000);
        localm.c("Test InApp banner");
        localm.b(-836034);
        localm.d("");
        localm.a(com.appboy.b.a.h.values()[d.f.k.d()]);
        localm.a(com.appboy.b.a.a.b, Uri.parse("viber://forward?text=Look at: https://www.tut.by&draft=true&forward_tab=2"));
        AppboyInAppMessageManager.getInstance().addInAppMessage(localm);
      }
    }
    , 5000L);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.f.f.c(), "Adjust Single Reporting").a(Boolean.valueOf(d.f.f.f())).a("Report events once a day (except special)").a());
    f(new x(this.a, x.a.a, "pref_mixpanel_stats", "Mixpanel stats").a(d()).a(this).a());
    f(new x(this.a, x.a.c, d.f.j.c(), "Use debug mixpanel account").a(Boolean.valueOf(d.f.j.f())).a("When checked, mixpanel analytics is will use debug account. Release (i.e. prod) account will be used otherwise.").a());
    f(new x(this.a, x.a.a, "pref_show_appboy_banner", "Show appBoy InApp (delay 5 sec)").a(this).a());
    int i = d.f.k.d();
    f(new x(this.a, x.a.b, "pref_appboy_pos", "appBoy InApp banner location").a(this.c).b(this.c).c(this.c[i]).a(this.c[i]).a(this).a());
    f(new x(this.a, x.a.a, "pref_send_appboy_event", "Send debug appboy event").a(this).a());
    f(new x(this.a, x.a.d, d.f.l.c(), "Custom Appboy API KEY").a(d.f.l.d()).a(d.f.l.f()).a(this).a());
    x localx = new x(this.a, x.a.b, d.bn.c.c(), "Wasabi sync period").a(d.p.p.f()).a(new CharSequence[] { "24h", "1h", "5m", "1m" });
    CharSequence[] arrayOfCharSequence = new CharSequence[4];
    arrayOfCharSequence[0] = String.valueOf(TimeUnit.HOURS.toSeconds(24L));
    arrayOfCharSequence[1] = String.valueOf(TimeUnit.HOURS.toSeconds(1L));
    arrayOfCharSequence[2] = String.valueOf(TimeUnit.MINUTES.toSeconds(5L));
    arrayOfCharSequence[3] = String.valueOf(TimeUnit.MINUTES.toSeconds(1L));
    f(localx.b(arrayOfCharSequence).a(this).a());
    f(new x(this.a, x.a.a, "pref_wasabi_fetch_assignments", "Fetch wasabi assignments").a("This will immediately fetch wasabi assignments").a(this).a());
    f(new x(this.a, x.a.a, "pref_wasabi_show_assignments", "Show wasabi assignments").a(this).a());
    f(new x(this.a, x.a.d, d.bn.d.c(), "Wasabi base URL").a(d.bn.d.d()).a(d.bn.d.f()).a(this).a());
    f(new x(this.a, x.a.a, "pref_wasabi_reset_base_url", "Reset Wasabi base URL").a(this).a());
    f(new x(this.a, x.a.a, "pref_wasabi_reset_assignments", "Reset Wasabi assignments").a(this).a());
    f(new x(this.a, x.a.d, d.f.t.c(), "Mixpanel distinct id postfix").a(d.f.t.d()).a(d.f.t.f()).a(this).a());
    f(new x(this.a, x.a.d, d.f.u.c(), "Mixpanel endpoint URL").a(d.f.u.d()).a(d.f.u.f()).a(this).a());
    f(new x(this.a, x.a.a, "prefreset_ab_stat_reported_flag", "Reset Emails AB statistic reported flag").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("analytics_key");
    paramPreferenceGroup.c("Analytics (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if ("pref_mixpanel_stats".equals(paramPreference.C()))
    {
      paramPreference.b(d());
      return true;
    }
    if ("pref_show_appboy_banner".equals(paramPreference.C()))
      f();
    while (true)
    {
      return super.a(paramPreference);
      if ("pref_send_appboy_event".equals(paramPreference.C()))
      {
        com.appboy.a.a(this.a).a("appboy debug event");
      }
      else
      {
        if ("pref_wasabi_fetch_assignments".equals(paramPreference.C()))
        {
          com.viber.voip.analytics.g.a().b().c(false);
          return false;
        }
        if ("pref_wasabi_show_assignments".equals(paramPreference.C()))
        {
          e();
          return false;
        }
        if ("pref_wasabi_reset_base_url".equals(paramPreference.C()))
        {
          String str = ap.p(ap.d());
          d.bn.d.a(str);
          Preference localPreference = this.b.a(d.bn.d.c());
          localPreference.b(str);
          ((EditTextPreference)localPreference).a(str);
          return true;
        }
        if ("pref_wasabi_reset_assignments".equals(paramPreference.C()))
          com.viber.voip.analytics.g.a().d();
        else if ("prefreset_ab_stat_reported_flag".equals(paramPreference.C()))
          d.aw.a.a(false);
      }
    }
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    int i;
    if (paramPreference.C().equals("pref_appboy_pos"))
    {
      i = 0;
      if (i >= this.c.length)
        break label252;
      if (!this.c[i].equals(paramObject));
    }
    while (true)
    {
      paramPreference.b(this.c[i]);
      d.f.k.a(i);
      boolean bool2 = true;
      boolean bool1;
      do
      {
        return bool2;
        i++;
        break;
        if (paramPreference.C().equals(d.f.l.c()))
        {
          paramPreference.b(paramObject.toString());
          ViberApplication.getInstance().showToast("Restart app to reinit Appboy with new key");
          return true;
        }
        if (d.bn.c.c().equals(paramPreference.C()))
        {
          d.bn.c.a((String)paramObject);
          d.bn.b.a(Long.parseLong((String)paramObject));
          ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c(String.valueOf(d.bn.b.d())));
          return false;
        }
        if (d.bn.d.c().equals(paramPreference.C()))
        {
          paramPreference.b(paramObject.toString());
          return true;
        }
        if (d.f.t.c().equals(paramPreference.C()))
        {
          paramPreference.b(paramObject.toString());
          return true;
        }
        bool1 = d.f.u.c().equals(paramPreference.C());
        bool2 = false;
      }
      while (!bool1);
      paramPreference.b(paramObject.toString());
      return true;
      label252: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.b
 * JD-Core Version:    0.6.2
 */