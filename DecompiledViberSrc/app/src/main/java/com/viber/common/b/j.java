package com.viber.common.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

public class j
{
  private static final j a = new j();
  private Context b;
  private String c;
  private SharedPreferences d;
  private SharedPreferences.Editor e;
  private g f;
  private g g;

  public static g a()
  {
    return a.g;
  }

  public static void a(Context paramContext, String paramString, g paramg)
  {
    a.b = paramContext.getApplicationContext();
    a.c = paramString;
    a.d = a.b.getSharedPreferences(paramString, 0);
    a.g = new f(a.d);
    if (paramg == null)
    {
      a.f = a.g;
      return;
    }
    a.f = paramg;
  }

  public static void a(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    a.d.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }

  public static g b()
  {
    return a.f;
  }

  public static void b(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    a.d.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }

  public static SharedPreferences c()
  {
    return a.d;
  }

  public static SharedPreferences.Editor d()
  {
    if (a.e == null)
      a.e = a.d.edit();
    return a.e;
  }

  public static void e()
  {
    d().clear().commit();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.b.j
 * JD-Core Version:    0.6.2
 */