package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.mixpanel.android.b.f;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import java.util.List;

class c
{
  public static String a = "MixpanelAPI.ConfigurationChecker";
  private static Boolean b;

  public static boolean a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = paramContext.getPackageName();
    if ((localPackageManager == null) || (str == null))
    {
      f.d(a, "Can't check configuration when using a Context with null packageManager or packageName");
      return false;
    }
    if (localPackageManager.checkPermission("android.permission.INTERNET", str) != 0)
    {
      f.d(a, "Package does not have permission android.permission.INTERNET - Mixpanel will not work at all!");
      f.c(a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
      return false;
    }
    return true;
  }

  public static boolean b(Context paramContext)
  {
    if (b == null)
    {
      if (Build.VERSION.SDK_INT < 16)
      {
        b = Boolean.valueOf(false);
        return b.booleanValue();
      }
      Intent localIntent = new Intent(paramContext, TakeoverInAppActivity.class);
      localIntent.addFlags(268435456);
      localIntent.addFlags(131072);
      if (paramContext.getPackageManager().queryIntentActivities(localIntent, 0).size() == 0)
      {
        f.d(a, TakeoverInAppActivity.class.getName() + " is not registered as an activity in your application, so takeover in-apps can't be shown.");
        f.c(a, "Please add the child tag <activity android:name=\"com.mixpanel.android.takeoverinapp.TakeoverInAppActivity\" /> to your <application> tag.");
        b = Boolean.valueOf(false);
        return b.booleanValue();
      }
      b = Boolean.valueOf(true);
    }
    return b.booleanValue();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.c
 * JD-Core Version:    0.6.2
 */