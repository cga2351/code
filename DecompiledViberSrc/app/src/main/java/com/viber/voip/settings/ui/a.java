package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import com.viber.dexshared.Logger;
import com.viber.voip.R.xml;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.l;
import com.viber.voip.i.c.a;
import com.viber.voip.i.f;
import com.viber.voip.registration.DeactivateActivity;
import com.viber.voip.registration.DeactivateSecondaryActivity;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.settings.d.a;
import com.viber.voip.util.ViberActionRunner.l;

public class a extends SettingsHeadersActivity.a
{
  private static final Logger b = ViberEnv.getLogger();

  public boolean a(Preference paramPreference)
  {
    Bundle localBundle = null;
    String str = paramPreference.C();
    Object localObject;
    if (d.a.a.c().equals(str))
      localObject = BackupSettingsActivity.class;
    while (true)
      if (localObject != null)
      {
        Intent localIntent = new Intent(getActivity(), (Class)localObject);
        if (localBundle != null)
          localIntent.putExtras(localBundle);
        startActivity(localIntent);
        return true;
        if (d.a.b.c().equals(str))
        {
          localObject = ManageSecondariesSettingsActivity.class;
          localBundle = new Bundle(1);
          localBundle.putString("extra entry point", "Settings Menu");
        }
        else
        {
          if (d.a.c.c().equals(str))
          {
            startActivity(ViberActionRunner.l.a(getContext(), "Change Phone Number"));
            return true;
          }
          if (e.a.q.c().equals(paramPreference.C()))
          {
            if (ao.f())
            {
              localObject = DeactivateSecondaryActivity.class;
              localBundle = null;
            }
            else
            {
              localObject = DeactivateActivity.class;
              localBundle = null;
            }
          }
          else if (d.a.g.c().equals(str))
          {
            localObject = PurchasesSettingsActivity.class;
            localBundle = null;
          }
        }
      }
      else
      {
        return super.a(paramPreference);
        localBundle = null;
        localObject = null;
      }
  }

  protected void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_account, paramString);
  }

  public void i()
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Context localContext = getContext();
    PreferenceScreen localPreferenceScreen = b();
    if (!l.a(localContext))
      localPreferenceScreen.d(a(d.a.a.c()));
    if (!c.a.a.e())
      localPreferenceScreen.d(a(d.a.c.c()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.a
 * JD-Core Version:    0.6.2
 */