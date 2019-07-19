package com.crashlytics.android.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import c.a.a.a.a.b.j.a;
import c.a.a.a.a.b.j.b;
import c.a.a.a.a.b.r;
import c.a.a.a.a.g.q;
import c.a.a.a.a.g.t;
import c.a.a.a.c;
import java.io.File;

public class b extends c.a.a.a.i<Boolean>
{
  boolean a = false;
  ab b;

  private void a(String paramString)
  {
    c.g().d("Answers", "Method " + paramString + " is not supported when using Crashlytics through Firebase.");
  }

  public static b c()
  {
    return (b)c.a(b.class);
  }

  public String a()
  {
    return "1.4.7.32";
  }

  public void a(j.a parama)
  {
    if (this.b != null)
      this.b.a(parama.a(), parama.b());
  }

  public void a(j.b paramb)
  {
    if (this.b != null)
      this.b.a(paramb.a());
  }

  public void a(m paramm)
  {
    if (paramm == null)
      throw new NullPointerException("event must not be null");
    if (this.a)
      a("logCustom");
    while (this.b == null)
      return;
    this.b.a(paramm);
  }

  public String b()
  {
    return "com.crashlytics.sdk.android:answers";
  }

  protected Boolean e()
  {
    if (!c.a.a.a.a.b.l.a(r()).a())
    {
      c.g().a("Fabric", "Analytics collection disabled, because data collection is disabled by Firebase.");
      this.b.c();
      return Boolean.valueOf(false);
    }
    try
    {
      t localt = q.a().b();
      if (localt == null)
      {
        c.g().e("Answers", "Failed to retrieve settings");
        return Boolean.valueOf(false);
      }
      if (localt.d.d)
      {
        c.g().a("Answers", "Analytics collection enabled");
        this.b.a(localt.e, g());
        return Boolean.valueOf(true);
      }
      c.g().a("Answers", "Analytics collection disabled");
      this.b.c();
      Boolean localBoolean = Boolean.valueOf(false);
      return localBoolean;
    }
    catch (Exception localException)
    {
      c.g().e("Answers", "Error dealing with settings", localException);
    }
    return Boolean.valueOf(false);
  }

  @SuppressLint({"NewApi"})
  protected boolean f_()
  {
    try
    {
      Context localContext = r();
      PackageManager localPackageManager = localContext.getPackageManager();
      String str1 = localContext.getPackageName();
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str1, 0);
      String str2 = Integer.toString(localPackageInfo.versionCode);
      String str3;
      if (localPackageInfo.versionName == null)
      {
        str3 = "0.0";
        if (Build.VERSION.SDK_INT < 9)
          break label115;
      }
      label115: long l1;
      for (long l2 = localPackageInfo.firstInstallTime; ; l2 = l1)
      {
        this.b = ab.a(this, localContext, q(), str2, str3, l2);
        this.b.b();
        this.a = new r().b(localContext);
        return true;
        str3 = localPackageInfo.versionName;
        break;
        l1 = new File(localPackageManager.getApplicationInfo(str1, 0).sourceDir).lastModified();
      }
    }
    catch (Exception localException)
    {
      c.g().e("Answers", "Error retrieving app properties", localException);
    }
    return false;
  }

  String g()
  {
    return c.a.a.a.a.b.i.b(r(), "com.crashlytics.ApiEndpoint");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.b
 * JD-Core Version:    0.6.2
 */