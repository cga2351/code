package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;

public class oq
{
  public static float a(Float paramFloat, float paramFloat1)
  {
    Float localFloat = Float.valueOf(paramFloat1);
    if (paramFloat == null);
    while (true)
    {
      return ((Float)localFloat).floatValue();
      localFloat = paramFloat;
    }
  }

  public static int a(Integer paramInteger, int paramInt)
  {
    Integer localInteger = Integer.valueOf(paramInt);
    if (paramInteger == null);
    while (true)
    {
      return ((Integer)localInteger).intValue();
      localInteger = paramInteger;
    }
  }

  public static long a(Long paramLong, long paramLong1)
  {
    Long localLong = Long.valueOf(paramLong1);
    if (paramLong == null);
    while (true)
    {
      return ((Long)localLong).longValue();
      localLong = paramLong;
    }
  }

  public static long a(Long paramLong, TimeUnit paramTimeUnit, long paramLong1)
  {
    if (paramLong == null)
      return paramLong1;
    return paramTimeUnit.toMillis(paramLong.longValue());
  }

  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return paramString2;
    return paramString1;
  }

  public static boolean a(Boolean paramBoolean, boolean paramBoolean1)
  {
    Boolean localBoolean = Boolean.valueOf(paramBoolean1);
    if (paramBoolean == null);
    while (true)
    {
      return ((Boolean)localBoolean).booleanValue();
      localBoolean = paramBoolean;
    }
  }

  public static String b(String paramString1, String paramString2)
  {
    if (paramString1 == null);
    for (String str = paramString2; ; str = paramString1)
      return (String)str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.oq
 * JD-Core Version:    0.6.2
 */