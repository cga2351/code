package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;

public class lp extends lm
{
  private String a;

  public String C()
  {
    return this.a;
  }

  void k(String paramString)
  {
    this.a = paramString;
  }

  public String toString()
  {
    return "CoreRequestConfig{mAppDebuggable='" + this.a + '\'' + super.toString() + '}';
  }

  protected static abstract class a<T extends lp, A extends lm.a> extends lm.b<T, A>
  {
    protected a(Context paramContext, String paramString)
    {
      super(paramString);
    }

    private static String a(ApplicationInfo paramApplicationInfo)
    {
      if ((0x2 & paramApplicationInfo.flags) != 0)
        return "1";
      return "0";
    }

    public T b(lm.c<A> paramc)
    {
      lp locallp = (lp)super.c(paramc);
      String str = this.a.getPackageName();
      try
      {
        locallp.k(a(c()));
        return locallp;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        if (TextUtils.equals(str, this.b))
        {
          locallp.k(a(this.a.getApplicationInfo()));
          return locallp;
        }
        locallp.k("0");
      }
      return locallp;
    }

    ApplicationInfo c()
      throws PackageManager.NameNotFoundException
    {
      return this.a.getPackageManager().getApplicationInfo(this.b, 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lp
 * JD-Core Version:    0.6.2
 */