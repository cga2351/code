package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public class ev
{
  private final Context a;
  private final PackageManager b;

  public ev(Context paramContext)
  {
    this(paramContext, paramContext.getPackageManager());
  }

  ev(Context paramContext, PackageManager paramPackageManager)
  {
    this.a = paramContext;
    this.b = paramPackageManager;
  }

  public int a()
  {
    try
    {
      Intent localIntent = new Intent().setAction("com.yandex.metrica.configuration.ACTION_INIT").setPackage(this.a.getPackageName());
      List localList = this.b.queryIntentServices(localIntent, 128);
      if (localList == null);
      int i;
      for (int j = 0; ; j = i)
      {
        return Math.max(1, j);
        i = localList.size();
      }
    }
    catch (Exception localException)
    {
    }
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ev
 * JD-Core Version:    0.6.2
 */