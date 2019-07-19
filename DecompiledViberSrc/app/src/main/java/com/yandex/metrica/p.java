package com.yandex.metrica;

import android.content.Context;
import android.location.Location;
import com.yandex.metrica.impl.by;
import com.yandex.metrica.impl.interact.DeviceInfo;
import java.util.Map;
import java.util.concurrent.Future;

public final class p
{
  public static void a(Context paramContext, IIdentifierCallback paramIIdentifierCallback)
  {
    by.a(paramContext, paramIIdentifierCallback);
  }

  @Deprecated
  public static void a(IIdentifierCallback paramIIdentifierCallback)
  {
    by.a(paramIIdentifierCallback);
  }

  @Deprecated
  public static YandexMetricaConfig cpcwh(YandexMetricaConfig paramYandexMetricaConfig, String paramString)
  {
    return by.a(paramYandexMetricaConfig, paramString);
  }

  @Deprecated
  public static Integer gbc(Context paramContext)
  {
    return by.c(paramContext.getApplicationContext());
  }

  public static String gcni(Context paramContext)
  {
    return by.b(paramContext);
  }

  public static DeviceInfo gdi(Context paramContext)
  {
    return by.a(paramContext);
  }

  public static String gdid(Context paramContext)
  {
    return by.e(paramContext);
  }

  @Deprecated
  public static Location glkl(Context paramContext)
  {
    return by.g(paramContext);
  }

  public static String gmsvn(int paramInt)
  {
    return by.a(paramInt);
  }

  @Deprecated
  public static String guid()
  {
    return by.c();
  }

  public static String guid(Context paramContext)
  {
    return by.d(paramContext);
  }

  public static boolean iifa()
  {
    return by.a();
  }

  public static String mpn(Context paramContext)
  {
    return by.f(paramContext);
  }

  public static String pgai()
  {
    try
    {
      String str = (String)by.b().get();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Boolean plat()
  {
    try
    {
      Boolean localBoolean = (Boolean)by.d().get();
      return localBoolean;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static void rce(int paramInt, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    by.a(paramInt, paramString1, paramString2, paramMap);
  }

  @Deprecated
  public static void rolu(Context paramContext, Object paramObject)
  {
    by.f();
  }

  public static void seb()
  {
    by.e();
  }

  public static String u(String paramString)
  {
    return by.a(paramString);
  }

  @Deprecated
  public static void urolu(Context paramContext, Object paramObject)
  {
    by.g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.p
 * JD-Core Version:    0.6.2
 */