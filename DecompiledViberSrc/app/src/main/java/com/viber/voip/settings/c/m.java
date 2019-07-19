package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.b;
import android.support.v7.preference.Preference.c;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.voip.settings.ui.ViberPreferenceCategoryExpandable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class m
  implements Preference.b, Preference.c
{
  protected Context a;
  private List<Preference> b = new ArrayList();
  private PreferenceGroup c;
  private ViberPreferenceCategoryExpandable d;

  public m(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    this.a = paramContext;
    this.c = c();
    a(this.c);
    paramPreferenceScreen.c(this.c);
    if ((this.c instanceof ViberPreferenceCategoryExpandable))
      this.d = ((ViberPreferenceCategoryExpandable)this.c);
  }

  private void d()
  {
    if (this.d != null)
      this.d.i();
  }

  protected abstract void a();

  protected abstract void a(PreferenceGroup paramPreferenceGroup);

  public boolean a(Preference paramPreference)
  {
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    return false;
  }

  public void b()
  {
    a();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Preference localPreference = (Preference)localIterator.next();
      localPreference.b(false);
      this.c.c(localPreference);
    }
    this.b.clear();
  }

  protected PreferenceGroup c()
  {
    ViberPreferenceCategoryExpandable localViberPreferenceCategoryExpandable = new ViberPreferenceCategoryExpandable(this.a);
    localViberPreferenceCategoryExpandable.a(new Preference.c()
    {
      public boolean a(Preference paramAnonymousPreference)
      {
        m.a(m.this);
        return true;
      }
    });
    return localViberPreferenceCategoryExpandable;
  }

  protected void f(Preference paramPreference)
  {
    this.b.add(paramPreference);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.m
 * JD-Core Version:    0.6.2
 */