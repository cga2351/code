package com.viber.voip.settings.c;

import android.content.Context;
import android.content.Intent;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.i.c.i;
import com.viber.voip.i.f;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.t;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.ViberActionRunner.s;
import com.viber.voip.util.da;
import java.util.concurrent.TimeUnit;

public class ac extends m
{
  public ac(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    x localx1 = new x(this.a, x.a.b, "pref_say_hi_default_media_type", "Engagement: default media").a(new String[] { "Stickers", "GIFs" });
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(1);
    arrayOfString[1] = String.valueOf(0);
    f(localx1.b(arrayOfString).a(String.valueOf(d.t.a.f())).a(this).a());
    f(new x(this.a, x.a.c, d.t.b.c(), "Engagement: suggested contacts").a(Boolean.valueOf(d.t.b.f())).a("Say hi screen: show suggested contacts").a());
    f(new x(this.a, x.a.d, d.t.d.c(), "Set JSON url").a(d.t.d.f()).a());
    x localx2 = new x(this.a, x.a.b, d.t.e.c(), "JSON sync period").a(d.t.e.f()).a(new CharSequence[] { "24h", "1h", "5m", "1m" });
    CharSequence[] arrayOfCharSequence1 = new CharSequence[4];
    arrayOfCharSequence1[0] = String.valueOf(TimeUnit.HOURS.toSeconds(24L));
    arrayOfCharSequence1[1] = String.valueOf(TimeUnit.HOURS.toSeconds(1L));
    arrayOfCharSequence1[2] = String.valueOf(TimeUnit.MINUTES.toSeconds(5L));
    arrayOfCharSequence1[3] = String.valueOf(TimeUnit.MINUTES.toSeconds(1L));
    f(localx2.b(arrayOfCharSequence1).a(this).a());
    f(new x(this.a, x.a.c, d.t.g.c(), "User sent smth using 'Say Hi' screen").a(Boolean.valueOf(d.t.g.f())).a());
    f(new x(this.a, x.a.a, d.t.h.c(), "Reset count of displayed automatically").a(Integer.valueOf(d.t.h.f())).a("Count = " + d.t.h.d()).a(this).a());
    x localx3 = new x(this.a, x.a.b, d.t.j.c(), "Period between autoshow `Say hi` screen").a(d.t.j.f()).a(new CharSequence[] { "24h", "1h", "5m", "1m", "10sec" });
    CharSequence[] arrayOfCharSequence2 = new CharSequence[5];
    arrayOfCharSequence2[0] = String.valueOf(TimeUnit.HOURS.toMillis(24L));
    arrayOfCharSequence2[1] = String.valueOf(TimeUnit.HOURS.toMillis(1L));
    arrayOfCharSequence2[2] = String.valueOf(TimeUnit.MINUTES.toMillis(5L));
    arrayOfCharSequence2[3] = String.valueOf(TimeUnit.MINUTES.toMillis(1L));
    arrayOfCharSequence2[4] = String.valueOf(TimeUnit.SECONDS.toMillis(10L));
    f(localx3.b(arrayOfCharSequence2).a(this).a());
    f(new x(this.a, x.a.a, "pref_debug_open_say_hi_screen", "Open \"Say hi to friends\" screen").a("If screen doesn't work as expected, check original flow before create a bug.").a(this).a());
    f(new x(this.a, x.a.d, d.t.k.c(), "Set Marketing JSON url").a("Url should be ended on \"/\"").a(d.t.k.f()).a());
    f(new x(this.a, x.a.d, "pref_debug_open_marketing_screen", "Open \"Marketing engagement\" screen").a("Enter url encoded campaign name to open screen").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("engagements_key");
    paramPreferenceGroup.c("Engagement");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (d.t.h.c().equals(str))
    {
      d.t.h.e();
      paramPreference.b("Count = 0");
    }
    while (true)
    {
      return super.a(paramPreference);
      if ("pref_debug_open_say_hi_screen".equals(str))
        if (c.i.b.e())
          ViberActionRunner.s.a(this.a);
        else
          Toast.makeText(this.a, "Failed: \"Say hi to friends\" screen can't be displayed.\n\nRequirements:\n\t- Feature is enabled;\n\t- Json is downloaded;\n\t- Contacts permission is granted.", 1).show();
    }
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str1 = paramPreference.C();
    if (d.t.e.c().equals(str1))
    {
      d.t.e.a((String)paramObject);
      ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c(d.t.e.d()));
      p.a.e.c(ViberApplication.getApplication());
      ViberApplication.exit(null, true);
    }
    while (true)
    {
      return false;
      if (paramPreference.C().equals("pref_say_hi_default_media_type"))
      {
        int i = Integer.parseInt((String)paramObject);
        d.t.a.a(i);
        ((ListPreference)paramPreference).b((String)paramObject);
      }
      else if (d.t.j.c().equals(str1))
      {
        d.t.j.a((String)paramObject);
        ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c(d.t.j.d()));
      }
      else if ("pref_debug_open_marketing_screen".equals(str1))
      {
        String str2 = (String)paramObject;
        if (da.a(str2))
        {
          Toast.makeText(this.a, "Failed: \"Engagement\" screen can't be displayed.\n\nCampaign mustn't be an empty string.\n", 1).show();
        }
        else
        {
          Intent localIntent = ViberActionRunner.s.a(this.a, null, Boolean.valueOf(true), Boolean.valueOf(true), str2, null, null, null);
          this.a.startActivity(localIntent);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ac
 * JD-Core Version:    0.6.2
 */