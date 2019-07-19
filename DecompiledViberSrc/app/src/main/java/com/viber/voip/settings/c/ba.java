package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.viber.common.b.b;
import com.viber.common.b.g;
import com.viber.voip.ViberApplication;
import com.viber.voip.settings.d.as;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class ba extends m
{
  public ba(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.as.a.c(), "Security features enabled").a(Boolean.valueOf(d.as.a.f())).a("Soft launch").a());
    f(new x(this.a, x.a.a, "create_key_pair", "Secure calls public key editor").a("Create new public/private key pair").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("secutiry_key");
    paramPreferenceGroup.c("Security (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals("create_key_pair"))
    {
      ViberApplication.preferences("sc_data").b("PKEY");
      ViberApplication.preferences("SecureVoice").b("PKEY");
      Toast.makeText(this.a, "New public/private key pair will be created after application restart", 1).show();
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ba
 * JD-Core Version:    0.6.2
 */