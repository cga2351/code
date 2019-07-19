package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.SystemClock;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import java.math.BigDecimal;

public class LocationService
{
  private static volatile LocationService c;

  @VisibleForTesting
  Location a;

  @VisibleForTesting
  long b;

  @VisibleForTesting
  static Location a(Context paramContext, ValidLocationProvider paramValidLocationProvider)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramValidLocationProvider);
    if (!MoPub.canCollectPersonalInformation())
      return null;
    if (!ValidLocationProvider.a(paramValidLocationProvider, paramContext))
      return null;
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    try
    {
      Location localLocation = localLocationManager.getLastKnownLocation(paramValidLocationProvider.toString());
      return localLocation;
    }
    catch (SecurityException localSecurityException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent3 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = ("Failed to retrieve location from " + paramValidLocationProvider.toString() + " provider: access appears to be disabled.");
      MoPubLog.log(localSdkLogEvent3, arrayOfObject3);
      return null;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = ("Failed to retrieve location: device has no " + paramValidLocationProvider.toString() + " location provider.");
        MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = ("Failed to retrieve location: device has no " + paramValidLocationProvider.toString() + " location provider.");
        MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
      }
    }
  }

  @VisibleForTesting
  static Location a(Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation1 == null)
      paramLocation1 = paramLocation2;
    while ((paramLocation2 == null) || (paramLocation1.getTime() > paramLocation2.getTime()))
      return paramLocation1;
    return paramLocation2;
  }

  @VisibleForTesting
  static LocationService a()
  {
    LocationService localLocationService1 = c;
    if (localLocationService1 == null)
      try
      {
        LocationService localLocationService2 = c;
        if (localLocationService2 == null)
        {
          localLocationService2 = new LocationService();
          c = localLocationService2;
        }
        return localLocationService2;
      }
      finally
      {
      }
    return localLocationService1;
  }

  @VisibleForTesting
  static void a(Location paramLocation, int paramInt)
  {
    if ((paramLocation == null) || (paramInt < 0))
      return;
    paramLocation.setLatitude(BigDecimal.valueOf(paramLocation.getLatitude()).setScale(paramInt, 5).doubleValue());
    paramLocation.setLongitude(BigDecimal.valueOf(paramLocation.getLongitude()).setScale(paramInt, 5).doubleValue());
  }

  private static boolean b()
  {
    LocationService localLocationService = a();
    if (localLocationService.a == null);
    while (SystemClock.elapsedRealtime() - localLocationService.b > MoPub.getMinimumLocationRefreshTimeMillis())
      return false;
    return true;
  }

  @Deprecated
  @VisibleForTesting
  public static void clearLastKnownLocation()
  {
    a().a = null;
  }

  public static Location getLastKnownLocation(Context paramContext, int paramInt, MoPub.LocationAwareness paramLocationAwareness)
  {
    if (!MoPub.canCollectPersonalInformation());
    do
    {
      return null;
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramLocationAwareness);
    }
    while (paramLocationAwareness == MoPub.LocationAwareness.DISABLED);
    LocationService localLocationService = a();
    if (b())
      return localLocationService.a;
    Location localLocation = a(a(paramContext, ValidLocationProvider.GPS), a(paramContext, ValidLocationProvider.NETWORK));
    if (paramLocationAwareness == MoPub.LocationAwareness.TRUNCATED)
      a(localLocation, paramInt);
    localLocationService.a = localLocation;
    localLocationService.b = SystemClock.elapsedRealtime();
    return localLocation;
  }

  public static enum LocationAwareness
  {
    static
    {
      DISABLED = new LocationAwareness("DISABLED", 2);
      LocationAwareness[] arrayOfLocationAwareness = new LocationAwareness[3];
      arrayOfLocationAwareness[0] = NORMAL;
      arrayOfLocationAwareness[1] = TRUNCATED;
      arrayOfLocationAwareness[2] = DISABLED;
    }

    @Deprecated
    public static LocationAwareness fromMoPubLocationAwareness(MoPub.LocationAwareness paramLocationAwareness)
    {
      if (paramLocationAwareness == MoPub.LocationAwareness.DISABLED)
        return DISABLED;
      if (paramLocationAwareness == MoPub.LocationAwareness.TRUNCATED)
        return TRUNCATED;
      return NORMAL;
    }

    @Deprecated
    public MoPub.LocationAwareness getNewLocationAwareness()
    {
      if (this == TRUNCATED)
        return MoPub.LocationAwareness.TRUNCATED;
      if (this == DISABLED)
        return MoPub.LocationAwareness.DISABLED;
      return MoPub.LocationAwareness.NORMAL;
    }
  }

  public static enum ValidLocationProvider
  {
    final String a;

    static
    {
      GPS = new ValidLocationProvider("GPS", 1, "gps");
      ValidLocationProvider[] arrayOfValidLocationProvider = new ValidLocationProvider[2];
      arrayOfValidLocationProvider[0] = NETWORK;
      arrayOfValidLocationProvider[1] = GPS;
    }

    private ValidLocationProvider(String paramString)
    {
      this.a = paramString;
    }

    private boolean a(Context paramContext)
    {
      switch (LocationService.1.a[ordinal()])
      {
      default:
      case 1:
        do
          return false;
        while ((!DeviceUtils.isPermissionGranted(paramContext, "android.permission.ACCESS_FINE_LOCATION")) && (!DeviceUtils.isPermissionGranted(paramContext, "android.permission.ACCESS_COARSE_LOCATION")));
        return true;
      case 2:
      }
      return DeviceUtils.isPermissionGranted(paramContext, "android.permission.ACCESS_FINE_LOCATION");
    }

    public String toString()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.LocationService
 * JD-Core Version:    0.6.2
 */