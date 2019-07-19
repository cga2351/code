package com.viber.voip.settings.c;

import android.content.Context;
import android.content.Intent;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.voip.settings.d.bk;
import com.viber.voip.settings.ui.ViberWalletUrlSettingsActivity;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class bu extends m
{
  public bu(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "choose_wallet_url", "Viber Wallet base url").a(new Intent(this.a, ViberWalletUrlSettingsActivity.class)).a());
    f(new x(this.a, x.a.c, d.bk.b.c(), "Use test page").a("bridge-test.html").a());
    f(new x(this.a, x.a.c, d.bk.c.c(), "Use JS bridge security").a(Boolean.valueOf(d.bk.c.f())).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("viber_wallet_settings_key");
    paramPreferenceGroup.c("Viber Wallet");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bu
 * JD-Core Version:    0.6.2
 */