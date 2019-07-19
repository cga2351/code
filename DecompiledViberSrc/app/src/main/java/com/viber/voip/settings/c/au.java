package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.voip.settings.d.ah;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class au extends m
{
  private final String[] b = { "Use Google Play", "Use Amazon Store" };

  public au(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    int i = d.ah.a.d();
    f(new x(this.a, x.a.b, d.ah.b.c(), "OpenIAB Preffered Store").a(this.b).b(this.b).c(this.b[i]).a(this).a());
    x localx = new x(this.a, x.a.c, d.ah.d.c(), "Use Google billing client").b(d.ah.d.d());
    if (i == 0);
    for (boolean bool = true; ; bool = false)
    {
      f(localx.a(bool).a());
      f(new x(this.a, x.a.c, d.ah.c.c(), "Enable Product Cache").b(d.ah.c.d()).a());
      f(new x(this.a, x.a.c, d.ah.e.c(), "Subscriptions Support").b(d.ah.e.d()).a());
      return;
    }
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("openiab_store_key");
    paramPreferenceGroup.c("OpenIAB Store (Debug option)");
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    boolean bool1 = paramPreference.C().equals(d.ah.b.c());
    boolean bool2 = false;
    int i;
    if (bool1)
    {
      i = 0;
      if (i >= this.b.length)
        break label79;
      if (!this.b[i].equals(paramObject))
        break label73;
    }
    while (true)
    {
      paramPreference.b(this.b[i]);
      d.ah.a.a(i);
      bool2 = true;
      return bool2;
      label73: i++;
      break;
      label79: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.au
 * JD-Core Version:    0.6.2
 */