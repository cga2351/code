package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.settings.d.bj;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class bn extends m
{
  public bn(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.m.e.c(), "ViberIn force").b(d.m.e.d()).a(this).a());
    f(new x(this.a, x.a.c, d.m.g.c(), "ViberIn dialog shown").b(d.m.g.d()).a(this).a());
    f(new x(this.a, x.a.c, d.m.i.c(), "NotViber all numbers").b(d.m.i.d()).a(this).a());
    f(new x(this.a, x.a.d, d.bj.c.c(), "set VO account host").a(d.bj.c.f()).a(this).a(ap.c().e()).a());
    f(new x(this.a, x.a.c, d.bj.i.c(), "Always use legacy purchase dialog").a(Boolean.valueOf(d.bj.i.f())).a());
    f(new x(this.a, x.a.c, d.bj.q.c(), "Referral Api enabled").a(Boolean.valueOf(d.bj.q.f())).a("Soft launch").a());
    f(new x(this.a, x.a.c, d.bj.j.c(), "Always show more plans").a(Boolean.valueOf(d.bj.j.f())).a());
    f(new x(this.a, x.a.c, d.bj.k.c(), "Always show free offers").a(Boolean.valueOf(d.bj.k.f())).a());
    f(new x(this.a, x.a.d, d.bj.l.c(), "Set VO top countries").a(d.bj.l.f()).a(d.bj.l.d()).a(this).a(ap.c().e()).a());
    f(new x(this.a, x.a.d, d.bj.n.c(), "Set VO top free calls countries").a(d.bj.n.f()).a(d.bj.n.d()).a(this).a(ap.c().e()).a());
    f(new x(this.a, x.a.d, d.bj.m.c(), "Set VO top viber out calls countries").a(d.bj.m.f()).a(d.bj.m.d()).a(this).a(ap.c().e()).a());
    f(new x(this.a, x.a.c, d.bj.p.c(), "Show world credits tooltip").a(Boolean.valueOf(d.bj.p.f())).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("viber_in_out_key");
    paramPreferenceGroup.c("ViberOut & ViberIn (Debug option)");
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (str.equals(d.bj.c.c()))
    {
      if (paramObject != null)
        ap.c().a();
      return true;
    }
    if (str.equals(d.bj.l.c()))
    {
      paramPreference.b(d.bj.l.d());
      return true;
    }
    if (str.equals(d.bj.n.c()))
    {
      paramPreference.b(d.bj.n.d());
      return true;
    }
    if (str.equals(d.bj.m.c()))
    {
      paramPreference.b(d.bj.m.d());
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bn
 * JD-Core Version:    0.6.2
 */