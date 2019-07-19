package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;

public class jd
  implements ix
{
  private final PackageManager a;
  private final String b;

  public jd(Context paramContext)
  {
    this(paramContext.getPackageManager(), paramContext.getPackageName());
  }

  public jd(PackageManager paramPackageManager, String paramString)
  {
    this.a = paramPackageManager;
    this.b = paramString;
  }

  public List<iy> a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      String[] arrayOfString = this.a.getPackageInfo(this.b, 4096).requestedPermissions;
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        localArrayList.add(new iy(arrayOfString[j], true));
    }
    catch (Exception localException)
    {
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jd
 * JD-Core Version:    0.6.2
 */