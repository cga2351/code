package android.support.v7.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;

public class j
{
  private Context a;
  private long b = 0L;
  private SharedPreferences c;
  private e d;
  private SharedPreferences.Editor e;
  private boolean f;
  private String g;
  private int h;
  private int i = 0;
  private PreferenceScreen j;
  private d k;
  private c l;
  private a m;
  private b n;

  public j(Context paramContext)
  {
    this.a = paramContext;
    a(a(paramContext));
  }

  private static String a(Context paramContext)
  {
    return paramContext.getPackageName() + "_preferences";
  }

  private void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.e != null))
      this.e.apply();
    this.f = paramBoolean;
  }

  long a()
  {
    try
    {
      long l1 = this.b;
      this.b = (1L + l1);
      return l1;
    }
    finally
    {
    }
  }

  public Preference a(CharSequence paramCharSequence)
  {
    if (this.j == null)
      return null;
    return this.j.a(paramCharSequence);
  }

  public PreferenceScreen a(Context paramContext, int paramInt, PreferenceScreen paramPreferenceScreen)
  {
    a(true);
    PreferenceScreen localPreferenceScreen = (PreferenceScreen)new i(paramContext, this).a(paramInt, paramPreferenceScreen);
    localPreferenceScreen.a(this);
    a(false);
    return localPreferenceScreen;
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
    this.c = null;
  }

  public void a(Preference paramPreference)
  {
    if (this.m != null)
      this.m.b(paramPreference);
  }

  public void a(a parama)
  {
    this.m = parama;
  }

  public void a(b paramb)
  {
    this.n = paramb;
  }

  public void a(c paramc)
  {
    this.l = paramc;
  }

  public void a(String paramString)
  {
    this.g = paramString;
    this.c = null;
  }

  public boolean a(PreferenceScreen paramPreferenceScreen)
  {
    if (paramPreferenceScreen != this.j)
    {
      if (this.j != null)
        this.j.N();
      this.j = paramPreferenceScreen;
      return true;
    }
    return false;
  }

  public e b()
  {
    return this.d;
  }

  public SharedPreferences c()
  {
    if (b() != null)
      return null;
    if (this.c == null)
      switch (this.i)
      {
      default:
      case 1:
      }
    for (Context localContext = this.a; ; localContext = ContextCompat.createDeviceProtectedStorageContext(this.a))
    {
      this.c = localContext.getSharedPreferences(this.g, this.h);
      return this.c;
    }
  }

  public PreferenceScreen d()
  {
    return this.j;
  }

  SharedPreferences.Editor e()
  {
    if (this.d != null)
      return null;
    if (this.f)
    {
      if (this.e == null)
        this.e = c().edit();
      return this.e;
    }
    return c().edit();
  }

  boolean f()
  {
    return !this.f;
  }

  public Context g()
  {
    return this.a;
  }

  public d h()
  {
    return this.k;
  }

  public c i()
  {
    return this.l;
  }

  public b j()
  {
    return this.n;
  }

  public static abstract interface a
  {
    public abstract void b(Preference paramPreference);
  }

  public static abstract interface b
  {
    public abstract void b(PreferenceScreen paramPreferenceScreen);
  }

  public static abstract interface c
  {
    public abstract boolean a(Preference paramPreference);
  }

  public static abstract class d
  {
    public abstract boolean a(Preference paramPreference1, Preference paramPreference2);

    public abstract boolean b(Preference paramPreference1, Preference paramPreference2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.j
 * JD-Core Version:    0.6.2
 */