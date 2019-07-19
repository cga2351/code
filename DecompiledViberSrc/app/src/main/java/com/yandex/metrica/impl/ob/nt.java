package com.yandex.metrica.impl.ob;

import android.util.Log;

public abstract class nt
{
  private volatile boolean a = false;

  public nt(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  private static String d(String paramString)
  {
    if (paramString == null)
      paramString = "";
    return paramString;
  }

  private String d(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      String str = f() + c(d(paramString), paramArrayOfObject);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return d();
  }

  public void a()
  {
    this.a = true;
  }

  void a(int paramInt, String paramString)
  {
    if (this.a)
      Log.println(paramInt, e(), f() + d(paramString));
  }

  void a(int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    if (this.a)
      Log.println(paramInt, e(), d(paramString, paramArrayOfObject));
  }

  public void a(String paramString)
  {
    a(4, paramString);
  }

  public void a(String paramString, Object[] paramArrayOfObject)
  {
    a(4, paramString, paramArrayOfObject);
  }

  public void b()
  {
    this.a = false;
  }

  public void b(String paramString)
  {
    a(5, paramString);
  }

  public void b(String paramString, Object[] paramArrayOfObject)
  {
    a(5, paramString, paramArrayOfObject);
  }

  abstract String c(String paramString, Object[] paramArrayOfObject);

  public void c(String paramString)
  {
    a(6, paramString);
  }

  public boolean c()
  {
    return this.a;
  }

  String d()
  {
    return f();
  }

  abstract String e();

  abstract String f();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.nt
 * JD-Core Version:    0.6.2
 */