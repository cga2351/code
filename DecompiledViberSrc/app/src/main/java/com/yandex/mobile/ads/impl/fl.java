package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.util.Collection;

public final class fl
{
  private static Boolean a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences.contains(paramString))
      return Boolean.valueOf(paramSharedPreferences.getBoolean(paramString, false));
    return null;
  }

  public static void a(Context paramContext, et paramet)
  {
    try
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("YadPreferenceFile", 0).edit().putString("SdkConfigurationLibraryVersion", paramet.h()).putBoolean("SdkConfigurationSensitiveModeDisabled", paramet.c()).putLong("SdkConfigurationExpiredDate", paramet.a()).putString("SdkConfigurationMraidUrl", paramet.e()).putBoolean("CustomClickHandlingEnabled", paramet.b());
      Boolean localBoolean1 = paramet.i();
      Boolean localBoolean2 = paramet.f();
      Boolean localBoolean3 = Boolean.valueOf(paramet.g());
      Boolean localBoolean4 = paramet.d();
      a(localEditor, "SdkConfigurationVisibilityErrorIndicatorEnabled", localBoolean1);
      a(localEditor, "SdkConfigurationMediationSensitiveModeDisabled", localBoolean2);
      a(localEditor, "SdkConfigurationCustomUserAgentEnabled", localBoolean3);
      a(localEditor, "SdkConfigurationUserConsent", localBoolean4);
      localEditor.apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static void a(SharedPreferences.Editor paramEditor, String paramString, Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      paramEditor.putBoolean(paramString, paramBoolean.booleanValue());
      return;
    }
    paramEditor.remove(paramString);
  }

  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }

  public static boolean a(Context paramContext)
  {
    return (0x2 & paramContext.getApplicationInfo().flags) != 0;
  }

  public static boolean a(Collection[] paramArrayOfCollection)
  {
    for (Collection localCollection : (Collection[])a(paramArrayOfCollection))
      if ((localCollection == null) || (localCollection.isEmpty()))
        return true;
    return false;
  }

  public static <T> T[] a(T[] paramArrayOfT)
  {
    if (paramArrayOfT == null)
      return (Object[])new Object[0];
    return paramArrayOfT;
  }

  public static et b(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("YadPreferenceFile", 0);
      long l = localSharedPreferences.getLong("SdkConfigurationExpiredDate", 0L);
      Boolean localBoolean1 = a(localSharedPreferences, "SdkConfigurationVisibilityErrorIndicatorEnabled");
      boolean bool1 = l < 0L;
      Object localObject2 = null;
      if (bool1)
      {
        Boolean localBoolean2 = a(localSharedPreferences, "SdkConfigurationMediationSensitiveModeDisabled");
        boolean bool2 = localSharedPreferences.getBoolean("SdkConfigurationCustomUserAgentEnabled", false);
        Boolean localBoolean3 = a(localSharedPreferences, "SdkConfigurationUserConsent");
        String str1 = localSharedPreferences.getString("SdkConfigurationLibraryVersion", null);
        String str2 = localSharedPreferences.getString("SdkConfigurationMraidUrl", null);
        boolean bool3 = localSharedPreferences.getBoolean("CustomClickHandlingEnabled", false);
        boolean bool4 = localSharedPreferences.getBoolean("SdkConfigurationSensitiveModeDisabled", false);
        et localet = new et.a().b(str1).c(localBoolean3).a(l).b(localBoolean2).c(bool2).b(bool4).a(str2).a(bool3).a(localBoolean1).a();
        localObject2 = localet;
      }
      return localObject2;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fl
 * JD-Core Version:    0.6.2
 */