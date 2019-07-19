package com.crashlytics.android.a;

import java.util.Map;

public abstract class d<T extends d>
{
  final e b = new e(20, 100, c.a.a.a.c.h());
  final c c = new c(this.b);

  public T a(String paramString, Number paramNumber)
  {
    this.c.a(paramString, paramNumber);
    return this;
  }

  public T a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
    return this;
  }

  Map<String, Object> b()
  {
    return this.c.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.d
 * JD-Core Version:    0.6.2
 */