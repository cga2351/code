package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.voip.i.c;
import com.viber.voip.i.f;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.cl;
import com.viber.voip.util.cl.a;
import com.viber.voip.util.n;
import com.viber.voip.util.u.b;
import java.util.Locale;

public class ad extends m
{
  public ad(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private static int a(CharSequence[] paramArrayOfCharSequence, CharSequence paramCharSequence)
  {
    for (int i = 0; i < paramArrayOfCharSequence.length; i++)
      if (paramCharSequence.equals(paramArrayOfCharSequence[i]))
        return i;
    return -1;
  }

  private void a(f paramf)
  {
    String[] arrayOfString1 = paramf.j();
    String[] arrayOfString2 = c(paramf);
    int i = d(paramf);
    f(new x(this.a, x.a.b, paramf.c(), paramf.d()).a(arrayOfString1).b(arrayOfString2).c(arrayOfString2[i]).a(arrayOfString1[i] + " " + b(paramf)).a(this).a());
  }

  private String b(f paramf)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    if (paramf.e());
    for (String str = "on"; ; str = "off")
    {
      arrayOfObject[0] = str;
      arrayOfObject[1] = Integer.valueOf(paramf.f());
      return String.format(localLocale, "(%s, state=%d)", arrayOfObject);
    }
  }

  private static String[] c(f paramf)
  {
    return (String[])n.a(String.class, n.a(paramf.i()), new u.b()
    {
      public String a(Integer paramAnonymousInteger)
      {
        return String.valueOf(paramAnonymousInteger);
      }
    });
  }

  private static int d(f paramf)
  {
    int[] arrayOfInt = paramf.i();
    int i = paramf.h();
    for (int j = 0; j < arrayOfInt.length; j++)
      if (arrayOfInt[j] == i)
        return j;
    return -1;
  }

  protected void a()
  {
    cl.a(c.class, f.class, new cl.a()
    {
      public void a(f paramAnonymousf)
      {
        ad.a(ad.this, paramAnonymousf);
      }
    });
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("all_features_key");
    paramPreferenceGroup.c("Features (Debug option)");
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    paramPreference.b(((android.support.v7.preference.ListPreference)paramPreference).m()[a(((android.support.v7.preference.ListPreference)paramPreference).n(), (String)paramObject)]);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ad
 * JD-Core Version:    0.6.2
 */