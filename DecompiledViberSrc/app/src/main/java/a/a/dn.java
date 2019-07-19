package a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.appboy.f.c;
import com.google.android.gms.common.GoogleApiAvailability;

public final class dn
{
  private static final String a = c.a(dn.class);

  public static boolean a(Context paramContext)
  {
    int i;
    try
    {
      Class.forName("com.google.android.gms.common.GoogleApiAvailability");
      i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(paramContext);
      if (i == 0)
      {
        c.b(a, "Google Play Services is available.");
        return true;
      }
    }
    catch (Exception localException)
    {
      c.b(a, "Google Play Services Availability API not found. Google Play Services not enabled.", localException);
      return false;
    }
    c.c(a, "Google Play Services is unavailable. Connection result: " + i);
    return false;
  }

  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
      return true;
    }
    catch (Exception localException)
    {
      c.e(a, "Unexpected exception while checking for com.google.android.gsf");
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dn
 * JD-Core Version:    0.6.2
 */