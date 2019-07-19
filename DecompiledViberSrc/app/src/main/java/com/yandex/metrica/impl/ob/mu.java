package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.text.TextUtils;
import com.yandex.metrica.impl.bu;
import java.util.List;
import java.util.Map;

public class mu
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private List<String> f;
  private long g;
  private String h;
  private final fv i;

  public mu(fv paramfv)
  {
    this.i = paramfv;
    this.b = this.i.b(null);
    this.d = this.i.d(null);
    this.e = this.i.e(null);
    this.f = this.i.b();
    this.c = this.i.c(null);
    this.a = this.i.a(null);
    this.g = this.i.a(0L);
    this.h = this.i.f(null);
    e();
  }

  private void b(long paramLong)
  {
    try
    {
      this.g = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void b(Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("Uuid");
      if ((TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(str1)))
        this.a = str1;
      String str2 = paramBundle.getString("DeviceId");
      if (!TextUtils.isEmpty(str2))
        a(str2);
      b(paramBundle.getString("DeviceIdHash"));
      return;
    }
    finally
    {
    }
  }

  private void c(Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("AdUrlGet");
      if (!TextUtils.isEmpty(str1))
        c(str1);
      String str2 = paramBundle.getString("AdUrlReport");
      if (!TextUtils.isEmpty(str2))
        d(str2);
      return;
    }
    finally
    {
    }
  }

  private void c(String paramString)
  {
    try
    {
      this.d = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void d(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void e()
  {
    this.i.g(this.a).h(this.b).i(this.c).j(this.d).k(this.e).d(this.g).l(this.h).i();
  }

  private boolean f()
  {
    boolean bool1 = true;
    try
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = this.a;
      arrayOfString[1] = this.b;
      arrayOfString[2] = this.c;
      boolean bool2 = bu.a(arrayOfString);
      if (!bool2)
        return bool1;
      bool1 = false;
    }
    finally
    {
    }
  }

  private boolean g()
  {
    return true;
  }

  private boolean h()
  {
    try
    {
      if (f())
      {
        boolean bool2 = g();
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  void a(long paramLong)
  {
    this.i.e(paramLong).i();
  }

  void a(Bundle paramBundle)
  {
    try
    {
      b(paramBundle);
      c(paramBundle);
      b(paramBundle.getLong("ServerTimeOffset"));
      String str = paramBundle.getString("Clids");
      if (!TextUtils.isEmpty(str))
        this.h = str;
      e();
      return;
    }
    finally
    {
    }
  }

  void a(String paramString)
  {
    try
    {
      this.b = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(List<String> paramList)
  {
    this.f = paramList;
    this.i.a(this.f);
  }

  void a(Map<String, String> paramMap)
  {
    try
    {
      b(paramMap);
      c(paramMap);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean a()
  {
    long l = System.currentTimeMillis() / 1000L - this.i.b(0L);
    return (l > 86400L) || (l < 0L);
  }

  boolean a(a parama)
  {
    try
    {
      boolean bool1;
      if (a.c == parama)
      {
        boolean bool3 = h();
        bool1 = bool3;
      }
      while (true)
      {
        return bool1;
        if (a.a == parama)
        {
          bool1 = f();
        }
        else if (a.b == parama)
        {
          boolean bool2 = g();
          bool1 = bool2;
        }
        else
        {
          bool1 = false;
        }
      }
    }
    finally
    {
    }
  }

  List<String> b()
  {
    return this.f;
  }

  void b(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void b(Map<String, String> paramMap)
  {
    try
    {
      if (!TextUtils.isEmpty(this.a))
        paramMap.put("yandex_mobile_metrica_uuid", this.a);
      if (!TextUtils.isEmpty(this.b))
        paramMap.put("yandex_mobile_metrica_device_id", this.b);
      if (!TextUtils.isEmpty(this.c))
        paramMap.put("appmetrica_device_id_hash", this.c);
      return;
    }
    finally
    {
    }
  }

  String c()
  {
    return this.a;
  }

  void c(Map<String, String> paramMap)
  {
    try
    {
      if (!TextUtils.isEmpty(this.d))
        paramMap.put("yandex_mobile_metrica_get_ad_url", this.d);
      if (!TextUtils.isEmpty(this.e))
        paramMap.put("yandex_mobile_metrica_report_ad_url", this.e);
      return;
    }
    finally
    {
    }
  }

  String d()
  {
    return this.b;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mu
 * JD-Core Version:    0.6.2
 */