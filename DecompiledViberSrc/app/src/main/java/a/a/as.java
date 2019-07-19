package a.a;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.appboy.a.b;
import com.appboy.f.c;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

public class as
  implements av
{
  private static final String a = c.a(as.class);
  private final Context b;
  private final aw c;
  private final cu d;
  private String e;
  private final b f;

  public as(Context paramContext, b paramb, aw paramaw, cu paramcu)
  {
    if (paramContext == null)
      throw new NullPointerException();
    this.b = paramContext;
    this.f = paramb;
    this.c = paramaw;
    this.d = paramcu;
  }

  static String a(DisplayMetrics paramDisplayMetrics, boolean paramBoolean)
  {
    int i = paramDisplayMetrics.widthPixels;
    int j = paramDisplayMetrics.heightPixels;
    if (paramBoolean)
      return j + "x" + i;
    return i + "x" + j;
  }

  static String a(Locale paramLocale)
  {
    return paramLocale.toString();
  }

  private String f()
  {
    return String.valueOf(Build.VERSION.SDK_INT);
  }

  private String g()
  {
    Object localObject;
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)this.b.getSystemService("phone");
      switch (localTelephonyManager.getPhoneType())
      {
      default:
        c.d(a, "Unknown phone type");
        localObject = null;
        break;
      case 1:
      case 2:
        String str = localTelephonyManager.getNetworkOperatorName();
        localObject = str;
      case 0:
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      c.d(a, "Caught resources not found exception while reading the phone carrier name.", localNotFoundException);
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      c.d(a, "Caught security exception while reading the phone carrier name.", localSecurityException);
      return null;
    }
    while (true)
    {
      return localObject;
      localObject = null;
    }
  }

  private String h()
  {
    return Build.MODEL;
  }

  private Locale i()
  {
    return Locale.getDefault();
  }

  private TimeZone j()
  {
    return TimeZone.getDefault();
  }

  private DisplayMetrics k()
  {
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  private boolean l()
  {
    int i = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay().getRotation();
    return (i == 1) || (i == 3);
  }

  private boolean m()
  {
    if (Build.VERSION.SDK_INT < 28)
      return false;
    try
    {
      boolean bool = ((ActivityManager)this.b.getSystemService("activity")).isBackgroundRestricted();
      return bool;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to collect background restriction information from Activity Manager", localException);
    }
    return false;
  }

  public bl a()
  {
    return new bl(this.f, f(), g(), h(), a(i()), j().getID(), a(k(), l()), Boolean.valueOf(d()), Boolean.valueOf(m()));
  }

  public bl b()
  {
    this.d.a(a());
    return (bl)this.d.b();
  }

  public String c()
  {
    String str = this.c.a();
    if (str == null)
      c.e(a, "Error reading deviceId, received a null value.");
    return str;
  }

  boolean d()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      NotificationManager localNotificationManager = (NotificationManager)this.b.getSystemService("notification");
      if (localNotificationManager != null)
        return localNotificationManager.areNotificationsEnabled();
      return true;
    }
    if (Build.VERSION.SDK_INT >= 19)
      try
      {
        Method localMethod1 = du.a("android.support.v4.app.NotificationManagerCompat", "from", new Class[] { Context.class });
        if (localMethod1 == null)
        {
          localMethod1 = du.a("androidx.core.app.NotificationManagerCompat", "from", new Class[] { Context.class });
          if (localMethod1 == null)
            return true;
        }
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.b;
        Object localObject1 = du.a(null, localMethod1, arrayOfObject);
        if (localObject1 == null)
          return true;
        Method localMethod2 = du.a(localObject1.getClass(), "areNotificationsEnabled", new Class[0]);
        if (localMethod2 == null)
          return true;
        Object localObject2 = du.a(localObject1, localMethod2, new Object[0]);
        if ((localObject2 instanceof Boolean))
        {
          boolean bool = ((Boolean)localObject2).booleanValue();
          return bool;
        }
        return true;
      }
      catch (Exception localException)
      {
        c.d(a, "Failed to read notifications enabled state from NotificationManagerCompat.", localException);
        return true;
      }
    return true;
  }

  public String e()
  {
    if (this.e != null)
      return this.e;
    String str = this.b.getPackageName();
    try
    {
      PackageInfo localPackageInfo2 = this.b.getPackageManager().getPackageInfo(str, 0);
      localPackageInfo1 = localPackageInfo2;
      if (localPackageInfo1 == null)
      {
        ApplicationInfo localApplicationInfo = this.b.getApplicationInfo();
        localPackageInfo1 = this.b.getPackageManager().getPackageArchiveInfo(localApplicationInfo.sourceDir, 0);
      }
      if (localPackageInfo1 != null)
      {
        this.e = localPackageInfo1.versionName;
        return this.e;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        c.d(a, "Unable to inspect package [" + str + "]", localNameNotFoundException);
        PackageInfo localPackageInfo1 = null;
      }
      c.b(a, "App version could not be read. Returning null");
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.as
 * JD-Core Version:    0.6.2
 */