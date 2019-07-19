package com.viber.voip.settings.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.g;
import android.text.Html;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.voip.R.string;
import com.viber.voip.i.c.j;
import com.viber.voip.i.f;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.v;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.j;
import com.viber.voip.util.ViberActionRunner.bf;

public class al
  implements SharedPreferences.OnSharedPreferenceChangeListener, m.c
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private final g e;
  private final a f;
  private boolean g;

  public al(g paramg, a parama)
  {
    this.e = paramg;
    this.f = parama;
    this.a = a(d.f.b, R.string.pref_collect_analytics_summary);
    this.b = a(d.f.c, R.string.pref_content_personalization_summary);
    this.c = a(d.f.d, R.string.pref_interest_based_ads_summary);
    this.d = a(d.f.e, R.string.pref_location_based_services_summary);
  }

  private boolean a(b paramb, int paramInt)
  {
    Preference localPreference = this.e.a(paramb.c());
    if (localPreference != null)
    {
      localPreference.b(Html.fromHtml(this.e.getString(paramInt)));
      if ((localPreference instanceof ViberCheckboxPreference))
        ((ViberCheckboxPreference)localPreference).b(new am(this));
    }
    return paramb.d();
  }

  private static boolean a(String paramString)
  {
    return (paramString.equals(d.f.b.c())) || (paramString.equals(d.f.c.c())) || (paramString.equals(d.f.d.c())) || (paramString.equals(d.f.e.c()));
  }

  private boolean a(String paramString, b paramb, boolean paramBoolean)
  {
    if (paramString.equals(paramb.c()))
    {
      boolean bool = paramb.d();
      if (paramBoolean != bool)
      {
        this.f.a(paramString, bool);
        paramBoolean = bool;
      }
    }
    return paramBoolean;
  }

  private boolean b(Preference paramPreference)
  {
    if (a(paramPreference.C()))
    {
      if ((!((CheckBoxPreference)paramPreference).b()) && (1 == d.v.h.d()) && (c.j.c.e()))
      {
        j.f().a(this.e).b(this.e);
        return true;
      }
      if (d.f.e.c().equals(paramPreference.C()))
        d.v.p.a(true);
    }
    return false;
  }

  public void a()
  {
    if (this.g)
    {
      this.a = a(d.f.b.c(), d.f.b, this.a);
      this.b = a(d.f.c.c(), d.f.c, this.b);
      this.c = a(d.f.d.c(), d.f.d, this.c);
      this.d = a(d.f.e.c(), d.f.e, this.d);
      this.g = false;
    }
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D459)) && (-1 == paramInt))
    {
      this.g = true;
      ViberActionRunner.bf.a(paramm.getActivity());
    }
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    this.a = a(paramString, d.f.b, this.a);
    this.b = a(paramString, d.f.c, this.b);
    this.c = a(paramString, d.f.d, this.c);
    this.d = a(paramString, d.f.e, this.d);
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.al
 * JD-Core Version:    0.6.2
 */