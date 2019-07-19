package com.viber.voip.contacts.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.o.a;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.ui.SettingsHeadersActivity.a;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner.aa;
import com.viber.voip.util.cj;
import com.viber.voip.util.dl;

public class ao extends SettingsHeadersActivity.a
  implements m.c
{
  private static final Logger b = ViberEnv.getLogger();
  private boolean c;

  private void j()
  {
    if (!cj.c(getActivity()))
      return;
    String str = dl.j(dl.b(ap.c().aI));
    GenericWebViewActivity.a(getActivity(), str, getString(R.string.hidden_chats_title));
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public boolean a(Preference paramPreference)
  {
    if (d.ad.v.c().equals(paramPreference.C()))
    {
      ViberActionRunner.aa.a(this, getChildFragmentManager(), o.a.a);
      return true;
    }
    if (d.ad.w.c().equals(paramPreference.C()))
    {
      ViberActionRunner.aa.a(this, getChildFragmentManager(), o.a.g);
      return true;
    }
    if (d.ad.u.c().equals(paramPreference.C()))
    {
      j();
      return true;
    }
    return super.a(paramPreference);
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_hidden_chats, paramString);
    if (paramBundle != null)
      this.c = paramBundle.getBoolean("enable_settings");
    b().b(0).a(this.c);
    b().b(1).a(this.c);
  }

  public void i()
  {
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof ViberFragmentActivity))
      ((ViberFragmentActivity)localFragmentActivity).setupAndShowPinDialog(this);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (paramm.c().equals(DialogCode.D_PIN))
    {
      Bundle localBundle = (Bundle)paramm.d();
      if ((localBundle != null) && (localBundle.getInt("screen_mode", 0) == o.a.g.ordinal()) && (paramInt == -1))
      {
        a(false);
        if ((b() != null) && (b().b(0) != null) && (b().b(1) != null))
        {
          b().b(0).a(this.c);
          b().b(1).a(this.c);
        }
      }
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("enable_settings", this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ao
 * JD-Core Version:    0.6.2
 */