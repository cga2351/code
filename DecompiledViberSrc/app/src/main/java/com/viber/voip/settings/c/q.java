package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.settings.d.aj;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class q extends m
{
  public q(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private void d()
  {
    ViberApplication.getInstance().getContactManager().c().a(new r(this));
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.m.n.c(), "Use custom url to fetch ads").a("If enabled then ads is fetched from custom url").a(Boolean.valueOf(d.m.n.f())).a());
    f(new x(this.a, x.a.d, d.m.o.c(), "Ads custom url").a("It makes sense only if fetching from custom url is enabled").a(d.m.o.f()).a());
    f(new x(this.a, x.a.c, d.m.p.c(), "Display after calls ads report status").a("impression - blue, view - red").a(Boolean.valueOf(d.m.p.f())).a());
    f(new x(this.a, x.a.a, d.aj.a.c(), "Reset draw over other apps counter").a("Current value: " + d.aj.a.d()).a(this).a());
    f(new x(this.a, x.a.d, d.m.q.c(), "Ads placement Id").a("Placement id for custom ad provider").a(d.m.q.f()).a());
    f(new x(this.a, x.a.d, d.m.r.c(), "Ads refresh time").a("Time interval to refresh ad (seconds)").a(d.m.r.f()).a());
    f(new x(this.a, x.a.c, d.m.s.c(), "Force obtain user details from participant info").a("Relevant for viber call to saved contact!").a(Boolean.valueOf(d.m.s.f())).a());
    f(new x(this.a, x.a.a, d.m.u.c(), "Reset audio conference number").a("Current value: " + d.m.u.d()).a(this).a());
    f(new x(this.a, x.a.c, d.m.v.c(), "Show conversation group call tooltip").a(Boolean.valueOf(d.m.v.f())).a());
    f(new x(this.a, x.a.d, "debug_conference_max_members", "Conference - Max members").a("Current value: " + d.m.w.d()).a(String.valueOf(d.m.w.f())).a(this).a());
    f(new x(this.a, x.a.a, "key_send_update_link_no_calls_support", "Send 'group calls not supported' update link").a(this).a());
    CharSequence[] arrayOfCharSequence1 = { "6000", "7000", "8000", "9000", "10000", "11000", "12000" };
    f(new x(this.a, x.a.b, d.m.x.c(), "Opus bitrate").a("Current value: " + d.m.x.d()).b("Opus bitrate").a(arrayOfCharSequence1).b(arrayOfCharSequence1).a(this).a(d.m.x.d()).a());
    CharSequence[] arrayOfCharSequence2 = { "60", "120" };
    f(new x(this.a, x.a.b, d.m.z.c(), "ptime").a("Current value: " + d.m.x.d()).b("PTime").a(arrayOfCharSequence2).b(arrayOfCharSequence2).a(this).a(d.m.z.d()).a());
    f(new x(this.a, x.a.c, d.m.y.c(), "Transport cc for audio").a(Boolean.valueOf(d.m.y.f())).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("calls_key");
    paramPreferenceGroup.c("Calls (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals(d.aj.a.c()))
    {
      d.aj.a.e();
      paramPreference.b("Current value: " + d.aj.a.d());
      return true;
    }
    if (paramPreference.C().equals(d.m.u.c()))
    {
      d.m.u.e();
      paramPreference.b("Current value: " + d.m.u.d());
      return true;
    }
    if ("key_send_update_link_no_calls_support".equals(paramPreference.C()))
    {
      d();
      return true;
    }
    return super.a(paramPreference);
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (str.equals("debug_conference_max_members"))
      try
      {
        d.m.w.a(Integer.parseInt((String)paramObject));
        paramPreference.b("Current value: " + d.m.w.d());
        return true;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
      }
    if (str.equals(d.m.x.c()))
      try
      {
        paramPreference.b("Current value: " + paramObject.toString());
        d.m.x.a(paramObject.toString());
        return true;
      }
      catch (NumberFormatException localNumberFormatException3)
      {
      }
    if (str.equals(d.m.z.c()))
      try
      {
        paramPreference.b("Current value: " + paramObject.toString());
        d.m.z.a((String)paramObject);
        return true;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
      }
    if (str.equals(d.m.y.c()))
      try
      {
        paramPreference.b("Current value: " + paramObject.toString());
        d.m.y.a(((Boolean)paramObject).booleanValue());
        return true;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
      }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.q
 * JD-Core Version:    0.6.2
 */