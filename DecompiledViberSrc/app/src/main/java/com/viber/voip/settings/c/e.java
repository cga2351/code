package com.viber.voip.settings.c;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.ui.aj;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.ViberActionRunner.ac;

public class e extends m
{
  public e(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "pref_import_contacts", "Import Contacts from Contacts.VCF").a(this).a());
    f(new x(this.a, x.a.a, "pref_simulate_deactivation", "Simulate deactivation from server").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("automation_screens");
    paramPreferenceGroup.c("Automation Tests Screens (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -343688815:
    case -1230309002:
    }
    while (true)
      switch (i)
      {
      default:
        return false;
        if (str.equals("pref_import_contacts"))
        {
          i = 0;
          continue;
          if (str.equals("pref_simulate_deactivation"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    Toast.makeText(this.a, "Removing contacts", 0);
    new aj(this.a).e();
    if (ViberActionRunner.ac.a(this.a))
    {
      Toast.makeText(this.a, this.a.getResources().getString(R.string.please_wait), 0);
      return false;
    }
    Toast.makeText(this.a, "Something went wrong. Please try again later.", 0);
    return false;
    ViberApplication.getInstance().getEngine(true).getDelegatesManager().onShouldRegister();
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.e
 * JD-Core Version:    0.6.2
 */