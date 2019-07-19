package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import java.util.Calendar;

class k
{
  private static k a;
  private final Context b;
  private final LocationManager c;
  private final a d = new a();

  k(Context paramContext, LocationManager paramLocationManager)
  {
    this.b = paramContext;
    this.c = paramLocationManager;
  }

  private Location a(String paramString)
  {
    try
    {
      if (this.c.isProviderEnabled(paramString))
      {
        Location localLocation = this.c.getLastKnownLocation(paramString);
        return localLocation;
      }
    }
    catch (Exception localException)
    {
      Log.d("TwilightManager", "Failed to get last known location", localException);
    }
    return null;
  }

  static k a(Context paramContext)
  {
    if (a == null)
    {
      Context localContext = paramContext.getApplicationContext();
      a = new k(localContext, (LocationManager)localContext.getSystemService("location"));
    }
    return a;
  }

  private void a(Location paramLocation)
  {
    a locala = this.d;
    long l1 = System.currentTimeMillis();
    j localj = j.a();
    localj.a(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localj.a;
    localj.a(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localj.c == 1);
    long l3;
    long l4;
    long l5;
    long l6;
    for (boolean bool = true; ; bool = false)
    {
      l3 = localj.b;
      l4 = localj.a;
      localj.a(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localj.b;
      if ((l3 != -1L) && (l4 != -1L))
        break;
      l6 = 43200000L + l1;
      locala.a = bool;
      locala.b = l2;
      locala.c = l3;
      locala.d = l4;
      locala.e = l5;
      locala.f = l6;
      return;
    }
    long l7;
    if (l1 > l4)
      l7 = 0L + l5;
    while (true)
    {
      l6 = l7 + 60000L;
      break;
      if (l1 > l3)
        l7 = 0L + l4;
      else
        l7 = 0L + l3;
    }
  }

  @SuppressLint({"MissingPermission"})
  private Location b()
  {
    if (PermissionChecker.checkSelfPermission(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0);
    for (Object localObject1 = a("network"); ; localObject1 = null)
    {
      int i = PermissionChecker.checkSelfPermission(this.b, "android.permission.ACCESS_FINE_LOCATION");
      Object localObject2 = null;
      if (i == 0)
        localObject2 = a("gps");
      if ((localObject2 != null) && (localObject1 != null))
      {
        if (((Location)localObject2).getTime() > ((Location)localObject1).getTime())
          localObject1 = localObject2;
        return localObject1;
      }
      if (localObject2 != null);
      while (true)
      {
        return localObject2;
        localObject2 = localObject1;
      }
    }
  }

  private boolean c()
  {
    return this.d.f > System.currentTimeMillis();
  }

  boolean a()
  {
    a locala = this.d;
    if (c())
      return locala.a;
    Location localLocation = b();
    if (localLocation != null)
    {
      a(localLocation);
      return locala.a;
    }
    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }

  private static class a
  {
    boolean a;
    long b;
    long c;
    long d;
    long e;
    long f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.k
 * JD-Core Version:    0.6.2
 */