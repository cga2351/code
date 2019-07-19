package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.b;
import android.support.v7.preference.Preference.c;

public class x
{
  private Context a;
  private a b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private Object h;
  private Preference.c i;
  private Preference.b j;
  private CharSequence[] k;
  private CharSequence[] l;
  private Intent m;
  private boolean n = true;
  private boolean o;

  public x(Context paramContext, a parama, String paramString1, String paramString2)
  {
    this.a = paramContext;
    this.c = paramString1;
    this.d = paramString2;
    this.b = parama;
  }

  private void a(Preference paramPreference)
  {
    paramPreference.d(this.c);
    paramPreference.c(this.d);
    if (this.e != null)
      paramPreference.b(this.e);
    if (this.h != null)
      paramPreference.c(this.h);
    if (this.m != null)
      paramPreference.a(this.m);
    paramPreference.a(this.n);
    paramPreference.a(this.i);
    paramPreference.a(this.j);
  }

  private Preference b()
  {
    ViberPreference localViberPreference = new ViberPreference(this.a);
    a(localViberPreference);
    return localViberPreference;
  }

  private ListPreference c()
  {
    ViberListPreference localViberListPreference = new ViberListPreference(this.a);
    a(localViberListPreference);
    if (this.k != null)
      localViberListPreference.a(this.k);
    if (this.l != null)
      localViberListPreference.b(this.l);
    if (this.f != null)
      localViberListPreference.a(this.f);
    if (this.g != null)
      localViberListPreference.b(this.g);
    return localViberListPreference;
  }

  private CheckBoxPreference d()
  {
    ViberCheckboxPreference localViberCheckboxPreference = new ViberCheckboxPreference(this.a);
    a(localViberCheckboxPreference);
    localViberCheckboxPreference.f(this.o);
    return localViberCheckboxPreference;
  }

  private EditTextPreference e()
  {
    ViberEditTextPreference localViberEditTextPreference = new ViberEditTextPreference(this.a);
    a(localViberEditTextPreference);
    return localViberEditTextPreference;
  }

  public Preference a()
  {
    switch (1.a[this.b.ordinal()])
    {
    default:
      return new Preference(this.a);
    case 1:
      return b();
    case 2:
      return c();
    case 3:
      return d();
    case 4:
    }
    return e();
  }

  public x a(Intent paramIntent)
  {
    this.m = paramIntent;
    return this;
  }

  public x a(Preference.b paramb)
  {
    this.j = paramb;
    return this;
  }

  public x a(Preference.c paramc)
  {
    this.i = paramc;
    return this;
  }

  public x a(Object paramObject)
  {
    this.h = paramObject;
    return this;
  }

  public x a(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public x a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }

  public x a(CharSequence[] paramArrayOfCharSequence)
  {
    this.k = paramArrayOfCharSequence;
    return this;
  }

  public x b(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public x b(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }

  public x b(CharSequence[] paramArrayOfCharSequence)
  {
    this.l = paramArrayOfCharSequence;
    return this;
  }

  public x c(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.x
 * JD-Core Version:    0.6.2
 */