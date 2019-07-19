package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.e;
import com.viber.common.b.h;
import com.viber.voip.ads.b.a.a.a.b;
import com.viber.voip.settings.d.c;
import com.viber.voip.settings.d.d;
import com.viber.voip.settings.d.v;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.ViberActionRunner.y;
import com.viber.voip.util.ae;

public class a extends m
{
  private final String b = "pref_reset_accepted_consent";
  private final String c = "debug_get_latest_adinfo";
  private final String d = "debug_change_gender";
  private final String e = "debug_ads_native_error";
  private final String f = "debug_option_google_mediation_sdk";
  private final String g = "debug_option_ad_expiration_time";
  private final String[] h;
  private final String[] i;
  private final String[] j;

  public a(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    String[] arrayOfString1 = new String[3];
    arrayOfString1[0] = com.viber.voip.ads.a.d.UNKNOWN.name();
    arrayOfString1[1] = com.viber.voip.ads.a.d.MALE.name();
    arrayOfString1[2] = com.viber.voip.ads.a.d.FEMALE.name();
    this.h = arrayOfString1;
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = a.b.a.name();
    arrayOfString2[1] = a.b.b.name();
    this.i = arrayOfString2;
    this.j = new String[] { "NONE", "MyTarget", "Yandex", "MoPub" };
  }

  private String d()
  {
    return "Next update will be on " + ae.a(this.a, d.c.c.d(), true);
  }

  private String e()
  {
    return "Current Gender: " + d.c.a.d();
  }

  private String f()
  {
    return "Current error: " + d.d.d.d();
  }

  private String g()
  {
    String str = d.d.f.d();
    StringBuilder localStringBuilder = new StringBuilder().append("Mediation is requested via SDK: ");
    if (str != null);
    while (true)
    {
      return str;
      str = "NONE";
    }
  }

  private String h()
  {
    int k = d.d.g.d();
    StringBuilder localStringBuilder = new StringBuilder().append("Ad expriration time: ");
    if (k > 0);
    for (String str = k + " min"; ; str = "1 hour (default)")
      return str;
  }

  protected void a()
  {
    f(new x(this.a, x.a.b, "debug_option_ad_expiration_time", "Ad Expiration time").a(h()).a("DEFAULT").a(new String[] { "1 min", "5 min", "10 min", "DEFAULT (1 hour)" }).b(new String[] { "1", "5", "10", "-1" }).a(this).a());
    f(new x(this.a, x.a.b, "debug_option_google_mediation_sdk", "Googe Ads Mediation SDK").a(g()).a("NONE").a(this.j).b(this.j).a(this).a());
    f(new x(this.a, x.a.c, d.d.e.c(), "Google Ad: NO IMAGE").a("Simulate Google Ad response without image").a());
    f(new x(this.a, x.a.b, "debug_ads_native_error", "AdsNative provider error").a(f()).a(this.i).b(this.i).a(this).a());
    f(new x(this.a, x.a.a, "debug_get_latest_adinfo", "Set next AdInfo update for now").a(this).a(d()).a());
    f(new x(this.a, x.a.b, "debug_change_gender", "Change current Gender").a(e()).a(this.h).b(this.h).a(this).a());
    f(new x(this.a, x.a.c, d.d.a.c(), "Enable AppNexus Logging").a("Apply after Viber restart").a());
    f(new x(this.a, x.a.c, d.d.b.c(), "Use AppNexus sdk browser").a("Otherwise use device browser(default behaviour)").a());
    f(new x(this.a, x.a.c, d.d.c.c(), "Show video ads button").a("Show test video button in sticker market").a());
    f(new x(this.a, x.a.d, d.c.b.c(), "Change current Age (format=dd-MM-yyyy)").a("Current age: " + d.c.b.d()).a(d.c.b.f()).a(this).a());
    f(new x(this.a, x.a.d, d.v.q.c(), "IAB consent string").a("Gdpr consent string in base64").a(d.v.q.d()).a());
    f(new x(this.a, x.a.a, "pref_reset_accepted_consent", "Reset accepted consent").a(this).a());
    f(new x(this.a, x.a.c, d.v.t.c(), "consent string test page").a("Enable gdpr iab consent string test page").a());
    f(new x(this.a, x.a.a, d.v.d.c(), "Show manage ads screen").a(this).a());
    new String[] { "AppNexusBanner", "AppNexusNative", "Server" };
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("ads_key");
    paramPreferenceGroup.c("Ads (Debug options)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals("debug_get_latest_adinfo"))
    {
      d.c.c.a(System.currentTimeMillis());
      paramPreference.b(d());
    }
    while (true)
    {
      return super.a(paramPreference);
      if (paramPreference.C().equals("pref_reset_accepted_consent"))
        d.v.s.a(0);
      else if (paramPreference.C().equals(d.v.d.c()))
        ViberActionRunner.y.b(this.a, 2);
    }
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if (paramPreference.C().equals("debug_change_gender"))
    {
      String str4 = (String)paramObject;
      d.c.a.a(com.viber.voip.ads.a.d.valueOf(str4).ordinal());
      paramPreference.b(e());
    }
    while (true)
    {
      return super.a(paramPreference, paramObject);
      if (paramPreference.C().equals(d.c.b.c()))
      {
        d.c.b.a((String)paramObject);
        paramPreference.b("Current age: " + d.c.b.d());
      }
      else if (paramPreference.C().equals("debug_ads_native_error"))
      {
        String str3 = (String)paramObject;
        d.d.d.a(a.b.valueOf(str3).ordinal());
        paramPreference.b(f());
      }
      else if (paramPreference.C().equals("debug_option_google_mediation_sdk"))
      {
        String str2 = (String)paramObject;
        if ("NONE".equals(str2))
          str2 = null;
        d.d.f.a(str2);
        paramPreference.b(g());
      }
      else if ("debug_option_ad_expiration_time".equals(paramPreference.C()))
      {
        String str1 = (String)paramObject;
        try
        {
          int k = Integer.parseInt(str1);
          d.d.g.a(k);
          paramPreference.b(h());
        }
        catch (Exception localException)
        {
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.a
 * JD-Core Version:    0.6.2
 */