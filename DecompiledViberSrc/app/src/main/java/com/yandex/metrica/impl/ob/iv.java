package com.yandex.metrica.impl.ob;

import android.content.Context;

public class iv
{
  private it a;

  public iv(it paramit)
  {
    this.a = paramit;
  }

  public it a()
  {
    return this.a;
  }

  public void a(it paramit)
  {
    this.a = paramit;
  }

  public boolean a(Context paramContext)
  {
    return a(paramContext, "android.permission.ACCESS_COARSE_LOCATION");
  }

  public boolean a(Context paramContext, String paramString)
  {
    if (!a().a(paramString));
    while (true)
    {
      return false;
      try
      {
        int i = paramContext.checkCallingOrSelfPermission(paramString);
        if (i == 0)
          return true;
      }
      catch (Exception localException)
      {
      }
    }
    return false;
  }

  public boolean b(Context paramContext)
  {
    return a(paramContext, "android.permission.ACCESS_FINE_LOCATION");
  }

  public boolean c(Context paramContext)
  {
    return (a(paramContext)) || (b(paramContext));
  }

  public boolean d(Context paramContext)
  {
    return a(paramContext, "android.permission.READ_PHONE_STATE");
  }

  public boolean e(Context paramContext)
  {
    return a(paramContext, "android.permission.ACCESS_WIFI_STATE");
  }

  public boolean f(Context paramContext)
  {
    return a(paramContext, "android.permission.CHANGE_WIFI_STATE");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.iv
 * JD-Core Version:    0.6.2
 */