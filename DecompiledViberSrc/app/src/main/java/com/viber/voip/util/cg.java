package com.viber.voip.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import c.b.a.a.i;
import c.b.a.a.j;
import c.b.a.a.j.a;
import com.viber.dexshared.Logger;
import com.viber.jni.CountryNameInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.CountryCode;
import com.viber.voip.registration.af;
import com.viber.voip.registration.changephonenumber.PhoneNumberInfo;
import com.viber.voip.user.UserManager;

public final class cg
{
  public static PhoneNumberInfo a(PhoneController paramPhoneController, String paramString)
  {
    String str1 = "+" + paramString;
    String str2 = String.valueOf(paramPhoneController.getCountryCode(str1));
    if (paramString.startsWith(str2));
    for (String str3 = paramString.substring(str2.length()); ; str3 = paramString)
    {
      CountryNameInfo localCountryNameInfo = paramPhoneController.getCountryName(str1);
      String str4 = "";
      String str5 = "";
      if (localCountryNameInfo != null)
      {
        str4 = localCountryNameInfo.countryShortName;
        str5 = localCountryNameInfo.countryName;
      }
      return new PhoneNumberInfo(new CountryCode(str4, str2, str5, ""), str3, paramString);
    }
  }

  public static PhoneNumberInfo a(af paramaf)
  {
    return new PhoneNumberInfo(new CountryCode(paramaf.e(), paramaf.b(), paramaf.c(), ""), paramaf.f(), paramaf.g());
  }

  public static String a()
  {
    return UserManager.from(ViberApplication.getApplication()).getRegistrationValues().g();
  }

  @SuppressLint({"HardwareIds"})
  public static String a(Context paramContext)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        String str = localTelephonyManager.getSimSerialNumber();
        return str;
      }
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      ViberEnv.getLogger().a(localSecurityException, "SimSerialNumber isn't allowed to receive.");
    }
    return null;
  }

  public static String a(Context paramContext, String paramString)
  {
    if (da.a(paramString))
      return "";
    String str1;
    if (paramString.charAt(0) == '+')
      str1 = paramString;
    try
    {
      while (true)
      {
        j localj = j.a(paramContext);
        String str2 = co.b(localj.a(localj.a(str1, null), j.a.b));
        return str2;
        str1 = "+" + paramString;
      }
    }
    catch (i locali)
    {
    }
    return paramString;
  }

  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (da.a(paramString3))
    {
      if (!da.a(paramString1))
        paramString3 = "+" + paramString1;
      paramString3 = paramString3 + paramString2;
    }
    return a(paramContext, paramString3);
  }

  public static String a(PhoneController paramPhoneController, String paramString, boolean paramBoolean)
  {
    if (paramBoolean);
    while (da.a(paramString))
    {
      return "";
      paramString = paramPhoneController.canonizePhoneNumber(paramString);
    }
    return da.h(a(paramPhoneController, paramString).countryCode.getName());
  }

  public static boolean a(PhoneNumberInfo paramPhoneNumberInfo1, PhoneNumberInfo paramPhoneNumberInfo2)
  {
    return (paramPhoneNumberInfo1.countryCode != null) && (paramPhoneNumberInfo2.countryCode != null) && (paramPhoneNumberInfo1.countryCode.getIddCode().equals(paramPhoneNumberInfo2.countryCode.getIddCode()));
  }

  public static boolean a(String paramString)
  {
    int i = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().d();
    return dr.b(ViberApplication.getInstance(), paramString) != i;
  }

  public static String b(String paramString)
  {
    if ((!da.a(paramString)) && (paramString.charAt(0) == '+'))
      paramString = paramString.substring(1);
    return paramString;
  }

  public static boolean c(String paramString)
  {
    return "unknown_number".equals(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cg
 * JD-Core Version:    0.6.2
 */