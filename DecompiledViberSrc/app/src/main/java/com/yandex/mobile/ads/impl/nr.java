package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public final class nr
{
  private final String a;
  private final PackageManager b;

  public nr(Context paramContext)
  {
    this.a = paramContext.getPackageName();
    this.b = paramContext.getPackageManager();
  }

  public final boolean a(Intent paramIntent)
  {
    List localList = this.b.queryIntentActivities(paramIntent, 0);
    boolean bool1 = false;
    if (localList != null)
    {
      boolean bool2 = localList.isEmpty();
      bool1 = false;
      if (!bool2)
        bool1 = true;
    }
    return bool1;
  }

  public final boolean a(String paramString)
  {
    try
    {
      int i = this.b.checkPermission(paramString, this.a);
      boolean bool = false;
      if (i == 0)
        bool = true;
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nr
 * JD-Core Version:    0.6.2
 */