package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import com.yandex.metrica.MetricaService;

public class ob
{
  public static final class a
    implements Runnable
  {
    final Context a;

    public a(Context paramContext)
    {
      this.a = paramContext;
    }

    public void run()
    {
      Context localContext = this.a;
      try
      {
        PackageInfo localPackageInfo = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 516);
        if (localPackageInfo.services != null)
          for (ServiceInfo localServiceInfo : localPackageInfo.services)
            if ((MetricaService.class.getName().equals(localServiceInfo.name)) && (!localServiceInfo.enabled))
            {
              ComponentName localComponentName = new ComponentName(localContext, MetricaService.class);
              localContext.getPackageManager().setComponentEnabledSetting(localComponentName, 1, 1);
            }
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ob
 * JD-Core Version:    0.6.2
 */