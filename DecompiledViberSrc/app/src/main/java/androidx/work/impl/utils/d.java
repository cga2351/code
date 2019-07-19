package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.i;

public class d
{
  private static final String a = i.a("PackageManagerHelper");

  public static void a(Context paramContext, Class paramClass, boolean paramBoolean)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      ComponentName localComponentName = new ComponentName(paramContext, paramClass.getName());
      if (paramBoolean)
      {
        i = 1;
        localPackageManager.setComponentEnabledSetting(localComponentName, i, 1);
        i locali2 = i.a();
        String str3 = a;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = paramClass.getName();
        if (paramBoolean);
        for (String str4 = "enabled"; ; str4 = "disabled")
        {
          arrayOfObject2[1] = str4;
          locali2.b(str3, String.format("%s %s", arrayOfObject2), new Throwable[0]);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        i locali1 = i.a();
        String str1 = a;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = paramClass.getName();
        if (paramBoolean);
        for (String str2 = "enabled"; ; str2 = "disabled")
        {
          arrayOfObject1[1] = str2;
          locali1.b(str1, String.format("%s could not be %s", arrayOfObject1), new Throwable[] { localException });
          return;
        }
        int i = 2;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.d
 * JD-Core Version:    0.6.2
 */