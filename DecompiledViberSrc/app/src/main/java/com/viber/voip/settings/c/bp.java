package com.viber.voip.settings.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.common.d.a;
import com.viber.voip.settings.d.bb;
import com.viber.voip.settings.d.bi;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.da;
import com.viber.voip.util.n;
import java.util.Locale;

public class bp extends m
{
  private static final String b = d.bi.d.c() + "_string";
  private EditTextPreference c;
  private ListPreference d;
  private EditTextPreference e;
  private EditTextPreference f;
  private EditTextPreference g;

  public bp(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private String c(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return "Sony";
    case 1:
    }
    return "Yandex Zen";
  }

  private String d()
  {
    if (!d.bb.f.a())
      return "News badge is not initialized";
    if (d.bb.f.d())
      return "News badge should be displayed";
    return "News badge is cleared";
  }

  @SuppressLint({"SwitchIntDef"})
  private String d(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 1:
      return "more screen";
    case 2:
      return "tab";
    case 3:
    }
    return "more screen + tab";
  }

  private String e(int paramInt)
  {
    if (paramInt > 0)
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      return String.format(localLocale, "Cache time: %d m", arrayOfObject);
    }
    return "No cache";
  }

  private void e()
  {
    Toast.makeText(this.a, "Applying changes requires exit from Viber app.", 1).show();
  }

  protected void a()
  {
    boolean bool = a.g();
    if (!bool)
      f(new x(this.a, x.a.a, "debug_news_feature_disabled", "News feature is disabled on Android 4.x").a());
    this.e = ((EditTextPreference)new x(this.a, x.a.d, "wasabi_cache_viberNewsSony", "Wasabi Sony News payload").a(bool).a(this).a());
    f(this.e);
    this.f = ((EditTextPreference)new x(this.a, x.a.d, "wasabi_cache_viberNewsZen", "Wasabi Yandex Zen payload").a(bool).a(this).a());
    f(this.f);
    f(new x(this.a, x.a.a, "debug_reset_news_badge", "Reset news badge state").a(d()).a(bool).a(this).a());
    this.c = ((EditTextPreference)new x(this.a, x.a.d, d.bi.b.c(), "Debug News Provider: initial URL").a("Change viber news endpoint").a(bool).a());
    this.c.a(this);
    f(this.c);
    Integer[] arrayOfInteger1 = new Integer[2];
    arrayOfInteger1[0] = Integer.valueOf(0);
    arrayOfInteger1[1] = Integer.valueOf(1);
    this.d = ((ListPreference)new x(this.a, x.a.b, "debug_news_behaviour_selector", "Debug News Provider: behaviour").a((CharSequence[])n.a(String.class, arrayOfInteger1, new bq(this))).b((CharSequence[])n.a(String.class, arrayOfInteger1, br.a)).c(Integer.toString(d.bi.a.d())).a(Integer.toString(d.bi.a.d())).a(c(d.bi.a.d())).a(bool).a(this).a());
    f(this.d);
    Integer[] arrayOfInteger2 = new Integer[3];
    arrayOfInteger2[0] = Integer.valueOf(1);
    arrayOfInteger2[1] = Integer.valueOf(2);
    arrayOfInteger2[2] = Integer.valueOf(3);
    f(new x(this.a, x.a.b, "debug_news_entry_point_selector", "Debug News Provider: Entry point").a((CharSequence[])n.a(String.class, arrayOfInteger2, new bs(this))).b((CharSequence[])n.a(String.class, arrayOfInteger2, bt.a)).a(Integer.toString(d.bi.g.d())).a(d(d.bi.g.d())).a(bool).a(this).a());
    this.g = ((EditTextPreference)new x(this.a, x.a.d, b, "Debug News Provider: News tab browser cache time").a(e(d.bi.d.d())).c(Integer.toString(d.bi.d.d())).a(bool).a(this).a());
    f(this.g);
    f(new x(this.a, x.a.a, "debug_reset_news_url", "Debug News Provider: reset initial URL").a(bool).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("viber_news_debug_settings_key");
    paramPreferenceGroup.c("Viber News");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("debug_reset_news_url"))
    {
      this.c.a(d.bi.b.f());
      e();
      return true;
    }
    if ("debug_reset_news_badge".equals(str))
    {
      d.bb.f.a(true);
      paramPreference.b(d());
      return true;
    }
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if (d.bi.b.c().equals(paramPreference.C()))
    {
      String str1 = (String)paramObject;
      if ((!da.a(str1)) && (!str1.startsWith("http")))
      {
        String str2 = "https://" + str1;
        this.c.a(str2);
        return false;
      }
      e();
      this.d.H();
      return true;
    }
    int m;
    boolean bool;
    label157: int n;
    if ("debug_news_behaviour_selector".equals(paramPreference.C()))
    {
      int k = Integer.parseInt((String)paramObject);
      d.bi.a.a(k);
      paramPreference.b(c(k));
      if (k == 0)
      {
        m = 1;
        d.bi.c.a(m);
        b localb = d.bi.e;
        if (k != 1)
          break label206;
        bool = true;
        localb.a(bool);
        n = 0;
        if (k != 0)
          break label212;
        label172: d.bi.f.a(n);
        this.d.b(k);
        e();
      }
    }
    label206: label212: 
    do
      while (true)
      {
        return super.a(paramPreference, paramObject);
        m = -1;
        break;
        bool = false;
        break label157;
        n = 1;
        break label172;
        if ("debug_news_entry_point_selector".equals(paramPreference.C()))
        {
          int j = Integer.parseInt((String)paramObject);
          d.bi.g.a(j);
          paramPreference.b(d(j));
          e();
          return true;
        }
        if (this.e.C().equals(paramPreference.C()))
        {
          this.e.a((String)paramObject);
        }
        else
        {
          if (!this.f.C().equals(paramPreference.C()))
            break label325;
          this.f.a((String)paramObject);
        }
      }
    while (!b.equals(paramPreference.C()));
    try
    {
      label325: int i = Integer.parseInt((String)paramObject);
      this.g.a(Integer.toString(i));
      this.g.b(e(i));
      d.bi.d.a(i);
      e();
      return true;
    }
    catch (Exception localException)
    {
      this.g.a(Integer.toString(0));
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bp
 * JD-Core Version:    0.6.2
 */