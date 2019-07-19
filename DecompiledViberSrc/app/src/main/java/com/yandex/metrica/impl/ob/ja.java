package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
class ja
  implements ix
{
  private final Context a;

  public ja(Context paramContext)
  {
    this.a = paramContext;
  }

  public List<iy> a()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = this.a.getPackageManager();
    while (true)
    {
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.a.getPackageName(), 4096);
        if (i < localPackageInfo.requestedPermissions.length)
        {
          String str = localPackageInfo.requestedPermissions[i];
          if ((0x2 & localPackageInfo.requestedPermissionsFlags[i]) != 0)
            localArrayList.add(new iy(str, true));
          else
            localArrayList.add(new iy(str, false));
        }
      }
      catch (Exception localException)
      {
      }
      return localArrayList;
      i++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ja
 * JD-Core Version:    0.6.2
 */