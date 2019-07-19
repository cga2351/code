package com.viber.common.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Map;
import java.util.Set;

public class f
  implements g
{
  protected final SharedPreferences a;
  private SharedPreferences.Editor b;

  public f(SharedPreferences paramSharedPreferences)
  {
    this.a = paramSharedPreferences;
  }

  private SharedPreferences.Editor c()
  {
    if (this.b == null)
      this.b = this.a.edit();
    return this.b;
  }

  public float a(String paramString, float paramFloat)
  {
    return this.a.getFloat(paramString, paramFloat);
  }

  public int a(String paramString, int paramInt)
  {
    return this.a.getInt(paramString, paramInt);
  }

  public long a(String paramString, long paramLong)
  {
    return this.a.getLong(paramString, paramLong);
  }

  public String a(String paramString1, String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }

  public Set<String> a(String paramString, Set<String> paramSet)
  {
    return this.a.getStringSet(paramString, paramSet);
  }

  public void a()
  {
    throw new UnsupportedOperationException("unsupported");
  }

  public boolean a(String paramString)
  {
    return this.a.contains(paramString);
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    return this.a.getBoolean(paramString, paramBoolean);
  }

  public Map<String, ? extends Object> b()
  {
    throw new UnsupportedOperationException("unsupported");
  }

  public void b(String paramString)
  {
    c().remove(paramString).apply();
  }

  public void b(String paramString, float paramFloat)
  {
    c().putFloat(paramString, paramFloat).apply();
  }

  public void b(String paramString, int paramInt)
  {
    c().putInt(paramString, paramInt).apply();
  }

  public void b(String paramString, long paramLong)
  {
    c().putLong(paramString, paramLong).apply();
  }

  public void b(String paramString1, String paramString2)
  {
    c().putString(paramString1, paramString2).apply();
  }

  public void b(String paramString, Set<String> paramSet)
  {
    c().putStringSet(paramString, paramSet).apply();
  }

  public void b(String paramString, boolean paramBoolean)
  {
    c().putBoolean(paramString, paramBoolean).apply();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.b.f
 * JD-Core Version:    0.6.2
 */