package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@SuppressLint({"ApplySharedPref"})
public class bg
{
  private static volatile bg a;
  private final SharedPreferences b;

  private bg(SharedPreferences paramSharedPreferences)
  {
    this.b = paramSharedPreferences;
  }

  public static bg a(Context paramContext)
  {
    bg localbg1 = a;
    if (localbg1 == null)
      try
      {
        bg localbg2 = a;
        if (localbg2 == null)
        {
          localbg2 = new bg(paramContext.getSharedPreferences("mytarget_prefs", 0));
          a = localbg2;
        }
        return localbg2;
      }
      finally
      {
      }
    return localbg1;
  }

  private void a(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.b.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        dp.c("PrefsCache exception: " + localThrowable);
    }
    finally
    {
    }
  }

  private String b(String paramString)
  {
    try
    {
      String str2 = this.b.getString(paramString, "");
      str1 = str2;
      return str1;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        dp.c("PrefsCache exception: " + localThrowable);
        String str1 = "";
      }
    }
    finally
    {
    }
  }

  public String a()
  {
    return b("mrgsDeviceId");
  }

  public void a(String paramString)
  {
    a("mrgsDeviceId", paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bg
 * JD-Core Version:    0.6.2
 */