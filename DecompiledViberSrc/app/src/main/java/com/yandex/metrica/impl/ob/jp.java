package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class jp
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName() + paramString, 0);
  }

  public static void a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    if ((paramSharedPreferences != null) && (paramSharedPreferences.contains(paramString)));
    try
    {
      long l = paramSharedPreferences.getInt(paramString, paramInt);
      paramSharedPreferences.edit().remove(paramString).putLong(paramString, l).apply();
      return;
    }
    catch (ClassCastException localClassCastException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jp
 * JD-Core Version:    0.6.2
 */