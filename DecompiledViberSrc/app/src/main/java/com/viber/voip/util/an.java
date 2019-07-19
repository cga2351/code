package com.viber.voip.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Window;
import com.viber.common.b.d;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.r;
import java.lang.reflect.Method;
import java.util.Locale;

public final class an
{
  private static final long a = Runtime.getRuntime().maxMemory();
  private static final boolean b;
  private static final int c;

  static
  {
    if (a / 1048576L <= 64L);
    for (boolean bool = true; ; bool = false)
    {
      b = bool;
      c = Runtime.getRuntime().availableProcessors();
      return;
    }
  }

  public static void a(Activity paramActivity)
  {
    Object localObject = paramActivity.getSystemService("input_method");
    a(localObject, "windowDismissed", new b[] { new b(paramActivity.getWindow().getDecorView().getWindowToken(), IBinder.class) });
    a(localObject, "startGettingWindowFocus", new b[] { new b(null, View.class) });
  }

  public static void a(Context paramContext)
  {
    if (a.a())
      a.a(paramContext, true);
  }

  private static void a(Object paramObject, String paramString, b[] paramArrayOfb)
  {
    int i = 0;
    if (paramObject == null)
      return;
    if (paramArrayOfb == null);
    try
    {
      Class[] arrayOfClass = new Class[0];
      if (paramArrayOfb == null);
      for (Object[] arrayOfObject = new Object[0]; ; arrayOfObject = new Object[paramArrayOfb.length])
      {
        if (paramArrayOfb == null)
          break label88;
        int j = arrayOfClass.length;
        while (i < j)
        {
          arrayOfClass[i] = paramArrayOfb[i].b();
          arrayOfObject[i] = paramArrayOfb[i].a();
          i++;
        }
        arrayOfClass = new Class[paramArrayOfb.length];
        break;
      }
      label88: Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, arrayOfClass);
      localMethod.setAccessible(true);
      localMethod.invoke(paramObject, arrayOfObject);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static boolean a()
  {
    return b;
  }

  public static long b()
  {
    return a;
  }

  public static void b(Context paramContext)
  {
    c localc = c.a(paramContext);
    if (com.viber.common.d.a.j())
      if (!localc.a(new String[] { "android.permission.READ_PHONE_STATE" }))
        return;
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      Method localMethod = Class.forName(localTelephonyManager.getClass().getName()).getDeclaredMethod("getITelephony", new Class[0]);
      localMethod.setAccessible(true);
      com.android.a.a.a locala = (com.android.a.a.a)localMethod.invoke(localTelephonyManager, new Object[0]);
      locala.b();
      locala.a();
      return;
    }
    catch (Exception localException)
    {
      ViberEnv.getLogger().a(new Throwable("Dismissing incoming call doesn't work", localException), "Dismissing incoming call doesn't work");
    }
  }

  public static int c()
  {
    return c;
  }

  public static boolean d()
  {
    int j;
    boolean bool2;
    if (com.viber.common.d.a.g())
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      int i = arrayOfString.length;
      j = 0;
      bool2 = false;
      if (j < i)
      {
        if (!"x86".equalsIgnoreCase(arrayOfString[j]))
          break label40;
        bool2 = true;
      }
    }
    label40: boolean bool1;
    do
    {
      return bool2;
      j++;
      break;
      if ("x86".equalsIgnoreCase(Build.CPU_ABI))
        break label72;
      bool1 = "x86".equalsIgnoreCase(Build.CPU_ABI2);
      bool2 = false;
    }
    while (!bool1);
    label72: return true;
  }

  public static boolean e()
  {
    return (com.viber.common.d.a.d()) && (d.r.v.d() != 2);
  }

  public static final class a
  {
    public static boolean a()
    {
      String str = b();
      return (str.toLowerCase(Locale.US).startsWith("emotionui")) || (str.toLowerCase(Locale.US).startsWith("emui")) || (Build.DISPLAY.toLowerCase(Locale.US).contains("emui"));
    }

    public static boolean a(Context paramContext, boolean paramBoolean)
    {
      try
      {
        Object localObject = paramContext.getSystemService("appops");
        if (localObject == null)
          return false;
        Class localClass = localObject.getClass();
        Class[] arrayOfClass = new Class[4];
        arrayOfClass[0] = Integer.TYPE;
        arrayOfClass[1] = Integer.TYPE;
        arrayOfClass[2] = String.class;
        arrayOfClass[3] = Integer.TYPE;
        Method localMethod = localClass.getMethod("setMode", arrayOfClass);
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = Integer.valueOf(24);
        arrayOfObject[1] = Integer.valueOf(Process.myUid());
        arrayOfObject[2] = paramContext.getPackageName();
        if (paramBoolean);
        for (int i = 0; ; i = 1)
        {
          arrayOfObject[3] = Integer.valueOf(i);
          localMethod.invoke(localObject, arrayOfObject);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
      }
      return false;
    }

    private static String b()
    {
      try
      {
        Class localClass = Class.forName("android.os.SystemProperties");
        Object localObject = localClass.getMethod("get", new Class[] { String.class }).invoke(localClass, new Object[] { "ro.build.version.emui" });
        if (!(localObject instanceof String))
          return "";
        String str = (String)localObject;
        return str;
      }
      catch (Throwable localThrowable)
      {
      }
      return "";
    }
  }

  private static final class b
  {
    private final Object a;
    private final Class b;

    public b(Object paramObject, Class paramClass)
    {
      this.a = paramObject;
      this.b = paramClass;
    }

    Object a()
    {
      return this.a;
    }

    Class b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.an
 * JD-Core Version:    0.6.2
 */