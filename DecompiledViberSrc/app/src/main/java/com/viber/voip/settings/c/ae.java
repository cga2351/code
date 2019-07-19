package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.voip.gdpr.f;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.v;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class ae extends m
{
  public ae(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    x localx1 = new x(this.a, x.a.b, "pref_gdpr_request_my_data_response", "Request Your Data: default response").a(new String[] { "USE SERVER", "OK", "FAILED", "TIMEOUT", "NOT_REG", "ALREADY_IN_PROCESS", "LIMIT_EXCEEDED" });
    String[] arrayOfString1 = new String[7];
    arrayOfString1[0] = String.valueOf(d.v.e.f());
    arrayOfString1[1] = String.valueOf(0);
    arrayOfString1[2] = String.valueOf(1);
    arrayOfString1[3] = String.valueOf(2);
    arrayOfString1[4] = String.valueOf(3);
    arrayOfString1[5] = String.valueOf(4);
    arrayOfString1[6] = String.valueOf(5);
    f(localx1.b(arrayOfString1).a(String.valueOf(d.v.e.f())).a(this).a());
    x localx2 = new x(this.a, x.a.b, "pref_gdpr_delete_my_data_response", "Delete Your Data: default response").a(new String[] { "USE SERVER", "OK", "FAILED", "TIMEOUT", "NOT_REG", "ALREADY_IN_PROCESS", "LIMIT_EXCEEDED" });
    String[] arrayOfString2 = new String[7];
    arrayOfString2[0] = String.valueOf(d.v.f.f());
    arrayOfString2[1] = String.valueOf(0);
    arrayOfString2[2] = String.valueOf(1);
    arrayOfString2[3] = String.valueOf(2);
    arrayOfString2[4] = String.valueOf(3);
    arrayOfString2[5] = String.valueOf(4);
    arrayOfString2[6] = String.valueOf(5);
    f(localx2.b(arrayOfString2).a(String.valueOf(d.v.f.f())).a(this).a());
    x localx3 = new x(this.a, x.a.b, "pref_gdpr_user_age_kind_options_list", "Set user's age kind").a(new String[] { "Unknown", "Minor", "Major" });
    String[] arrayOfString3 = new String[3];
    arrayOfString3[0] = String.valueOf(0);
    arrayOfString3[1] = String.valueOf(1);
    arrayOfString3[2] = String.valueOf(2);
    f(localx3.b(arrayOfString3).a(String.valueOf(d.v.h.f())).a(this).a());
    if (ao.f())
      f(new x(this.a, x.a.c, d.v.o.c(), "Use short request data timeout").a(Boolean.valueOf(d.v.o.f())).a("Timeout will be set to 1 minute").a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("gdpr_key");
    paramPreferenceGroup.c("GDPR");
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if (paramPreference.C().equals("pref_gdpr_request_my_data_response"))
    {
      int j = Integer.parseInt((String)paramObject);
      d.v.e.a(j);
      ((ListPreference)paramPreference).b((String)paramObject);
    }
    while (true)
    {
      return false;
      if (paramPreference.C().equals("pref_gdpr_delete_my_data_response"))
      {
        int i = Integer.parseInt((String)paramObject);
        d.v.f.a(i);
        ((ListPreference)paramPreference).b((String)paramObject);
      }
      else if (paramPreference.C().equals("pref_gdpr_user_age_kind_options_list"))
      {
        f.a(this.a).a(Integer.parseInt((String)paramObject));
        ((ListPreference)paramPreference).b((String)paramObject);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ae
 * JD-Core Version:    0.6.2
 */