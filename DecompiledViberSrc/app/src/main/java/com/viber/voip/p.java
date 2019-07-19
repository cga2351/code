package com.viber.voip;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import com.viber.common.b.b;
import com.viber.jni.Version;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class p
{
  public static final String a;

  static
  {
    if (!p.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      b = bool;
      a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "viber" + "/";
      return;
    }
  }

  private p()
  {
    if (!b)
      throw new AssertionError();
  }

  public static String a()
  {
    return a(ViberApplication.getApplication());
  }

  public static String a(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath() + "/.viber";
  }

  public static long b()
  {
    if (d.ad.E.d())
      return TimeUnit.MINUTES.toMillis(1L);
    return TimeUnit.MINUTES.toMillis(10L);
  }

  public static String c()
  {
    return "";
  }

  public static String d()
  {
    String str = f();
    if (Version.parseVersionString(str).Major > 0)
      return str;
    return "";
  }

  public static String e()
  {
    Version localVersion = Version.parseVersionString(f());
    if (localVersion.Major == 0)
      localVersion = Version.parseVersionString("");
    return localVersion.Major + "." + localVersion.Minor + "." + localVersion.MinorMinor;
  }

  public static String f()
  {
    return "11.0.1.0";
  }

  public static String g()
  {
    String str = f();
    Version localVersion = Version.parseVersionString(str);
    if (localVersion.FddFeature == null)
      str = "" + localVersion.Major + '.' + localVersion.Minor + '.' + localVersion.MinorMinor;
    if (localVersion.FddFeature != null)
      str = "feature/" + str;
    ap.d();
    return "Version " + str + c() + "";
  }

  public static String h()
  {
    return ViberApplication.getApplication().getFilesDir().getAbsolutePath() + "/" + "crash" + "/";
  }

  public static String i()
  {
    if (ao.f())
      return "AndroidTablet";
    return "Android";
  }

  public static int j()
  {
    if (ao.f())
      return 21;
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.p
 * JD-Core Version:    0.6.2
 */