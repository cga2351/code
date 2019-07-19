package com.viber.voip.i;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.viber.common.b.a;
import com.viber.voip.settings.d;
import com.viber.voip.settings.d.al;

public abstract class i<T extends a> extends b
{
  private final T a;
  private final SharedPreferences.OnSharedPreferenceChangeListener b;

  public i(T paramT)
  {
    this.a = paramT;
    this.b = c();
    d.a(this.b);
  }

  private d.al c()
  {
    a[] arrayOfa = new a[1];
    arrayOfa[0] = this.a;
    return new d.al(arrayOfa)
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        i.this.b();
      }
    };
  }

  public boolean a()
  {
    return a(this.a);
  }

  protected abstract boolean a(T paramT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.i
 * JD-Core Version:    0.6.2
 */