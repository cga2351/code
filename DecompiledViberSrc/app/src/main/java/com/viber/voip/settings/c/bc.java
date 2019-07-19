package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.h;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class bc extends m
{
  public bc(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private String d()
  {
    String str = d.r.r.d();
    if ((str == null) || (str.equals("")))
      str = a.c.name();
    return "Home Country: " + str;
  }

  private String e()
  {
    String str = d.r.s.d();
    if ((str == null) || (str.equals("")))
      str = b.c.name();
    return "Server Env: " + str;
  }

  protected void a()
  {
    f(new x(this.a, x.a.b, d.r.r.c(), "Override home country").a(d()).a(a.a()).b(a.a()).a(this).a());
    f(new x(this.a, x.a.b, d.r.s.c(), "Override server environment").a(e()).a(b.a()).b(b.a()).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("share_and_shop_key");
    paramPreferenceGroup.c("Share & Shop (Debug options)");
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if (paramPreference.C().equals(d.r.r.c()))
    {
      String str2 = (String)paramObject;
      d.r.r.a(str2);
      paramPreference.b(d());
    }
    while (true)
    {
      return super.a(paramPreference, paramObject);
      if (paramPreference.C().equals(d.r.s.c()))
      {
        String str1 = (String)paramObject;
        d.r.s.a(str1);
        paramPreference.b(e());
      }
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }

    public static String[] a()
    {
      String[] arrayOfString = new String[values().length];
      for (int i = 0; i < values().length; i++)
        arrayOfString[i] = values()[i].name();
      return arrayOfString;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }

    public static String[] a()
    {
      String[] arrayOfString = new String[values().length];
      for (int i = 0; i < values().length; i++)
        arrayOfString[i] = values()[i].name();
      return arrayOfString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bc
 * JD-Core Version:    0.6.2
 */