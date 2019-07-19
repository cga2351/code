package com.crashlytics.android.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

class ac
  implements ax
{
  private final Context a;
  private final String b;

  public ac(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }

  public String a()
  {
    PackageManager localPackageManager = this.a.getPackageManager();
    try
    {
      Bundle localBundle = localPackageManager.getApplicationInfo(this.b, 128).metaData;
      Object localObject = null;
      if (localBundle != null)
      {
        String str = localBundle.getString("io.fabric.unity.crashlytics.version");
        localObject = str;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ac
 * JD-Core Version:    0.6.2
 */