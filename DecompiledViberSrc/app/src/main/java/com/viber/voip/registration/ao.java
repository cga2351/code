package com.viber.voip.registration;

import android.app.Application;
import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.bf;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.settings.b.e.a.a;
import com.viber.voip.settings.b.f;
import com.viber.voip.util.ce;
import com.viber.voip.util.z;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ao
{
  private static final Logger a = ViberEnv.getLogger();
  private static a b = null;
  private static final Set<String> c = new HashSet();
  private static Boolean d;

  static
  {
    k();
  }

  private static String a(Context paramContext, String paramString, int paramInt)
    throws Exception
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Class localClass = Class.forName(localTelephonyManager.getClass().getName());
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Integer.TYPE;
    Method localMethod = localClass.getMethod(paramString, arrayOfClass);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Object localObject = localMethod.invoke(localTelephonyManager, arrayOfObject);
    if (localObject != null)
      return localObject.toString();
    return null;
  }

  public static void a(boolean paramBoolean)
  {
    try
    {
      if ((c.a.a.a.c.i()) && ("secondary".equals(e.a.a.a.d()) != paramBoolean))
        com.crashlytics.android.a.a("Secondary state was changed to " + paramBoolean);
      f localf = e.a.a.a;
      if (paramBoolean);
      for (String str = "secondary"; ; str = "primary")
      {
        localf.a(str);
        d = null;
        ViberApplication.getInstance().getComponentsManager().b(g());
        return;
      }
    }
    finally
    {
    }
  }

  public static void b(String paramString)
  {
    if (b == null)
      b = new a(null);
    b.a = paramString;
  }

  public static String c()
  {
    Application localApplication = ViberApplication.getApplication();
    Object localObject;
    if (com.viber.common.d.a.o())
    {
      localObject = d();
      return localObject;
    }
    TelephonyManager localTelephonyManager;
    if (com.viber.common.permission.c.a(localApplication).a(new String[] { "android.permission.READ_PHONE_STATE" }))
      localTelephonyManager = (TelephonyManager)localApplication.getSystemService("phone");
    while (true)
    {
      try
      {
        String str3 = localTelephonyManager.getDeviceId();
        localObject = str3;
        if (localObject != null)
          break;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          String str2 = a(localApplication, "getDeviceIdGemini", 0);
          return str2;
          localThrowable = localThrowable;
          localObject = null;
        }
        catch (Exception localException1)
        {
          try
          {
            String str1 = a(localApplication, "getDeviceId", 0);
            return str1;
          }
          catch (Exception localException2)
          {
            return localObject;
          }
        }
      }
      localObject = null;
    }
  }

  public static void c(String paramString)
  {
    if (b == null)
      b = new a(null);
    b.b = paramString;
  }

  public static String d()
  {
    return Settings.Secure.getString(ViberApplication.getApplication().getContentResolver(), "android_id");
  }

  public static boolean f()
  {
    try
    {
      if (d == null)
        d = Boolean.valueOf("secondary".equals(e.a.a.a.d()));
      boolean bool = d.booleanValue();
      return bool;
    }
    finally
    {
    }
  }

  public static boolean g()
  {
    return !f();
  }

  public static String i()
  {
    if (b == null)
      return "";
    return b.a;
  }

  public static String j()
  {
    if (b == null)
      return "";
    return b.b;
  }

  private static void k()
  {
    c.add("351602000525820");
    c.add("012345678901234");
    c.add("000000011234564");
    c.add("351751045421180");
    c.add("000000000000000");
    c.add("357242042804044");
    c.add("356531044590531");
    c.add("004999010640000");
    c.add("350305260000001");
    c.add("357242041834521");
    c.add("358537040040544");
    c.add("351751044067398");
  }

  public String a()
  {
    Object localObject1 = "";
    try
    {
      boolean bool = f();
      if ((e.a.l.a()) && (!bool))
      {
        localObject1 = e.a.l.d();
        if (((String)localObject1).equals(""))
        {
          if ((ViberApplication.isActivated()) && (c.a.a.a.c.i()))
          {
            String str2 = e.a.l.d();
            String str3 = e.a.a.c.d();
            StringBuilder localStringBuilder = new StringBuilder("getUdid failed for activated user {primaryUdid = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(", secondaryUdid = ");
            localStringBuilder.append(str3);
            localStringBuilder.append("; isSecondaryDevice = ");
            localStringBuilder.append(bool);
            com.crashlytics.android.a.a(localStringBuilder.toString());
          }
          if (!bool)
            break label194;
          localObject1 = a(b.d);
          if ((localObject1 == null) || (((String)localObject1).equals("")))
            break label186;
          e.a.a.c.a((String)localObject1);
        }
      }
      while (true)
      {
        return localObject1;
        if ((!e.a.a.c.a()) || (!bool))
          break;
        localObject1 = e.a.a.c.d();
        break;
        label186: localObject1 = b();
        continue;
        label194: String str1 = b();
        localObject1 = str1;
      }
    }
    finally
    {
    }
  }

  public String a(b paramb)
  {
    String str = s.a(paramb);
    if (!"".equals(str));
    return str;
  }

  public void a(b paramb, String paramString)
  {
    s.a(paramb, paramString);
  }

  public void a(String paramString)
  {
    if (f())
    {
      e.a.a.b.a(paramString);
      return;
    }
    e.a.k.a(paramString);
  }

  String b()
  {
    if (ViberApplication.isActivated())
      a.a(new IllegalStateException("Generate UDID when activated"), "");
    ActivationController localActivationController = ViberApplication.getInstance().getActivationController();
    String str1 = localActivationController.getCountryCode();
    String str2 = localActivationController.getRegNumber();
    if ((str1.equals("0")) && (str2.equals("0")))
      return "viber";
    String str3 = "" + str1 + str2;
    String str4 = c();
    boolean bool = f();
    if ((bool) || (TextUtils.isEmpty(str4)) || (c.contains(str4)))
    {
      SecureRandom localSecureRandom = new SecureRandom();
      str4 = "" + localSecureRandom.nextLong() + localSecureRandom.nextLong();
    }
    String str5;
    if (bool)
      str5 = str3 + str4 + "SECONDARY";
    String str6;
    try
    {
      while (true)
      {
        str6 = z.a(str5);
        if (ce.q.matcher(str6).matches())
          break;
        throw new IllegalStateException("error generating UDID - pattern doesn't match!");
        str5 = str3 + str4;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new IllegalStateException("error generating UDID");
    }
    if (bool)
    {
      e.a.a.c.a(str6);
      return str6;
    }
    e.a.l.a(str6);
    return str6;
  }

  public String e()
  {
    boolean bool = f();
    String str2;
    if ((e.a.k.a()) && (!bool))
    {
      str2 = e.a.k.d();
      if (!str2.equals(""));
    }
    String str1;
    do
    {
      return null;
      return str2;
      if ((!e.a.a.b.a()) || (!bool))
        break;
      str1 = e.a.a.b.d();
    }
    while (str1.equals(""));
    return str1;
    return "";
  }

  public byte h()
  {
    return s.e();
  }

  private static class a
  {
    String a;
    String b;
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[6];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ao
 * JD-Core Version:    0.6.2
 */