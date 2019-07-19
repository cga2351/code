package com.yandex.metrica.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ob.u;

public final class bp
{
  public static Intent a(Context paramContext)
  {
    Intent localIntent1 = new Intent(IMetricaService.class.getName(), new Uri.Builder().scheme("metrica").authority(paramContext.getPackageName()).build());
    if (Build.VERSION.SDK_INT > 11);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        localIntent1.addFlags(32);
      Intent localIntent2 = localIntent1.putExtras(b(paramContext));
      localIntent2.setData(localIntent2.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", u.a).build());
      return localIntent2.setPackage(paramContext.getApplicationContext().getPackageName());
    }
  }

  private static Bundle b(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(str, 128).metaData;
      if (localBundle == null)
        localBundle = new Bundle();
      return localBundle;
    }
    catch (Exception localException)
    {
    }
    return new Bundle();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bp
 * JD-Core Version:    0.6.2
 */