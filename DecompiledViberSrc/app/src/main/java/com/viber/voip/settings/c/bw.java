package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.ap;
import com.viber.voip.settings.d.bk;
import com.viber.voip.settings.d.bm;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.wallet.a;

public class bw extends m
{
  public bw(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.bm.a.d.c(), "Wallet enable, debug").a(Boolean.valueOf(ViberApplication.getInstance().getWalletController().b())).a());
    String str1 = "Server callback";
    String str2 = d.bm.a.e.d();
    int i = -1;
    switch (str2.hashCode())
    {
    default:
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      }
      break;
    case 3806:
    case 3738:
    case 3632:
    }
    while (true)
    {
      f(new x(this.a, x.a.b, d.bm.a.e.c(), "Wallet type").a("").b("Wallet Type").a(new CharSequence[] { "Server callback", "Western Union", "Viber Wallet", "Rakuten Bank" }).b(new CharSequence[] { "", "wu", "w1", "rb" }).a(this).a("Current wallet type : " + str1).a());
      f(new x(this.a, x.a.c, d.bm.a.c.c(), "WU Agreement").a());
      f(new x(this.a, x.a.c, d.bm.a.a.c(), "WU First welcome").a());
      f(new x(this.a, x.a.c, d.bm.a.b.c(), "WU First transaction").a());
      f(new x(this.a, x.a.d, d.bm.g.c(), "WU Wallet WEB VIEW base url").a(d.bm.g.f()).a());
      f(new x(this.a, x.a.d, d.bm.h.c(), "Wallet JSON url").a(d.bm.h.f()).a());
      f(new x(this.a, x.a.d, d.bm.k.c(), "Wallet json last modified date").a(d.bm.k.d()).a(d.bm.k.f()).a(this).a());
      f(new x(this.a, x.a.a, "reset_wu_url", "Reset Wallet urls").a(this).a());
      f(new x(this.a, x.a.c, d.bm.i.c(), "Wallet always update").a());
      f(new x(this.a, x.a.c, d.bm.j.c(), "Show Rakuten Wallet New Label").a());
      return;
      if (!str2.equals("wu"))
        break;
      i = 0;
      break;
      if (!str2.equals("w1"))
        break;
      i = 1;
      break;
      if (!str2.equals("rb"))
        break;
      i = 2;
      break;
      str1 = "Western Union";
      continue;
      str1 = "Viber Wallet";
      continue;
      str1 = "Rakuten Bank";
    }
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("wallet_settings_key");
    paramPreferenceGroup.c("Wallet");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals("reset_wu_url"))
    {
      d.bm.h.e();
      d.bm.g.e();
      d.bk.a.a(ap.c(ap.d()));
      return true;
    }
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (str.equals(d.bm.k.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    if (str.equals(d.bm.a.e.c()))
    {
      ViberApplication.getInstance().showToast("wallet type changed to " + paramObject.toString());
      paramPreference.b("Current wallet type : " + paramObject.toString());
      d.bm.c.a(0);
      d.bm.k.a("");
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bw
 * JD-Core Version:    0.6.2
 */