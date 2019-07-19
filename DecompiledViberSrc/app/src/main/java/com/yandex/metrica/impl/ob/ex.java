package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.text.TextUtils;

public class ex
{
  private Context a;
  private ServiceConnection b;

  public ex(Context paramContext)
  {
    this(paramContext, new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
      }

      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
      }
    });
  }

  ex(Context paramContext, ServiceConnection paramServiceConnection)
  {
    this.a = paramContext;
    this.b = paramServiceConnection;
  }

  private static Intent a(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      Intent localIntent1 = new Intent("com.yandex.metrica.IMetricaService", Uri.parse("metrica://" + paramContext.getPackageName()));
      if (Build.VERSION.SDK_INT >= 12)
        localIntent1.addFlags(32);
      ResolveInfo localResolveInfo = localPackageManager.resolveService(localIntent1.setPackage(paramString), 0);
      Object localObject = null;
      if (localResolveInfo != null)
      {
        Intent localIntent2 = new Intent().setClassName(localResolveInfo.serviceInfo.packageName, localResolveInfo.serviceInfo.name).setAction("com.yandex.metrica.ACTION_C_BG_L");
        localObject = localIntent2;
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public void a()
  {
    this.a.unbindService(this.b);
  }

  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = a(this.a, paramString);
      if (localIntent != null)
        this.a.bindService(localIntent, this.b, 1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ex
 * JD-Core Version:    0.6.2
 */