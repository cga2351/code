package c.a.a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import c.a.a.a.c;

public class l
{
  private static l a;
  private static Object b = new Object();
  private final SharedPreferences c;
  private volatile boolean d;
  private volatile boolean e;
  private final p f;
  private boolean g = false;

  private l(Context paramContext)
  {
    if (paramContext == null)
      throw new RuntimeException("null context");
    this.c = paramContext.getSharedPreferences("com.google.firebase.crashlytics.prefs", 0);
    this.f = q.a(paramContext);
    boolean bool2;
    boolean bool3;
    if (this.c.contains("firebase_crashlytics_collection_enabled"))
    {
      bool2 = this.c.getBoolean("firebase_crashlytics_collection_enabled", bool1);
      bool3 = bool1;
      this.e = bool2;
      this.d = bool3;
      if (i.n(paramContext) == null)
        break label196;
    }
    while (true)
    {
      while (true)
      {
        this.g = bool1;
        return;
        try
        {
          PackageManager localPackageManager = paramContext.getPackageManager();
          if (localPackageManager != null)
          {
            ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
            if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null) && (localApplicationInfo.metaData.containsKey("firebase_crashlytics_collection_enabled")))
            {
              boolean bool4 = localApplicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled");
              bool2 = bool4;
              bool3 = bool1;
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          c.g().a("Fabric", "Unable to get PackageManager. Falling through", localNameNotFoundException);
          bool2 = bool1;
          bool3 = false;
        }
      }
      break;
      label196: bool1 = false;
    }
  }

  public static l a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null)
        a = new l(paramContext);
      l locall = a;
      return locall;
    }
  }

  public boolean a()
  {
    if ((this.g) && (this.d))
      return this.e;
    if (this.f != null)
      return this.f.a();
    return true;
  }

  public boolean b()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.l
 * JD-Core Version:    0.6.2
 */