package com.appnexus.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;

public class ANGDPRSettings
{
  public static Boolean getConsentRequired(Context paramContext)
  {
    String str = "Nil";
    SharedPreferences localSharedPreferences;
    if (paramContext != null)
    {
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
      if (!localSharedPreferences.contains("ANGDPR_ConsentRequired"))
        break label48;
      str = localSharedPreferences.getString("ANGDPR_ConsentRequired", "Nil");
    }
    while (str.equalsIgnoreCase("1"))
    {
      return Boolean.valueOf(true);
      label48: if (localSharedPreferences.contains("IABConsent_SubjectToGDPR"))
        str = localSharedPreferences.getString("IABConsent_SubjectToGDPR", "Nil");
    }
    if (str.equalsIgnoreCase("0"))
      return Boolean.valueOf(false);
    return null;
  }

  public static String getConsentString(Context paramContext)
  {
    if (paramContext != null)
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
      if (localSharedPreferences.contains("ANGDPR_ConsentString"))
        return localSharedPreferences.getString("ANGDPR_ConsentString", "");
      if (localSharedPreferences.contains("IABConsent_SubjectToGDPR"))
        return localSharedPreferences.getString("IABConsent_ConsentString", "");
    }
    return "";
  }

  public static void reset(Context paramContext)
  {
    if (paramContext != null)
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
      if (localSharedPreferences.contains("ANGDPR_ConsentString"))
        localSharedPreferences.edit().remove("ANGDPR_ConsentString").apply();
      if (localSharedPreferences.contains("ANGDPR_ConsentRequired"))
        localSharedPreferences.edit().remove("ANGDPR_ConsentRequired").apply();
    }
  }

  public static void setConsentRequired(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramBoolean)
        PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("ANGDPR_ConsentRequired", "1").apply();
    }
    else
      return;
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("ANGDPR_ConsentRequired", "0").apply();
  }

  public static void setConsentString(Context paramContext, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null))
      PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("ANGDPR_ConsentString", paramString).apply();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ANGDPRSettings
 * JD-Core Version:    0.6.2
 */