package com.facebook.react.modules.location;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import javax.annotation.Nullable;

@ReactModule(name="LocationObserver")
@SuppressLint({"MissingPermission"})
public class LocationModule extends ReactContextBaseJavaModule
{
  public static final String NAME = "LocationObserver";
  private static final float RCT_DEFAULT_LOCATION_ACCURACY = 100.0F;
  private final LocationListener mLocationListener = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)LocationModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationDidChange", LocationModule.locationToMap(paramAnonymousLocation));
    }

    public void onProviderDisabled(String paramAnonymousString)
    {
    }

    public void onProviderEnabled(String paramAnonymousString)
    {
    }

    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      if (paramAnonymousInt == 0)
        LocationModule.this.emitError(PositionError.POSITION_UNAVAILABLE, "Provider " + paramAnonymousString + " is out of service.");
      while (paramAnonymousInt != 1)
        return;
      LocationModule.this.emitError(PositionError.TIMEOUT, "Provider " + paramAnonymousString + " is temporarily unavailable.");
    }
  };

  @Nullable
  private String mWatchedProvider;

  public LocationModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private void emitError(int paramInt, String paramString)
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationError", PositionError.buildError(paramInt, paramString));
  }

  @Nullable
  private String getValidProvider(LocationManager paramLocationManager, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "gps";
      if (paramLocationManager.isProviderEnabled(str))
        break label51;
      if (!str.equals("gps"))
        break label45;
      str = "network";
      label27: if (paramLocationManager.isProviderEnabled(str))
        break label51;
      str = null;
    }
    label45: label51: int i;
    do
    {
      return str;
      str = "network";
      break;
      str = "gps";
      break label27;
      i = ContextCompat.checkSelfPermission(getReactApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
    }
    while ((!str.equals("gps")) || (i == 0));
    return null;
  }

  private static WritableMap locationToMap(Location paramLocation)
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putDouble("latitude", paramLocation.getLatitude());
    localWritableMap2.putDouble("longitude", paramLocation.getLongitude());
    localWritableMap2.putDouble("altitude", paramLocation.getAltitude());
    localWritableMap2.putDouble("accuracy", paramLocation.getAccuracy());
    localWritableMap2.putDouble("heading", paramLocation.getBearing());
    localWritableMap2.putDouble("speed", paramLocation.getSpeed());
    localWritableMap1.putMap("coords", localWritableMap2);
    localWritableMap1.putDouble("timestamp", paramLocation.getTime());
    if (Build.VERSION.SDK_INT >= 18)
      localWritableMap1.putBoolean("mocked", paramLocation.isFromMockProvider());
    return localWritableMap1;
  }

  private static void throwLocationPermissionMissing(SecurityException paramSecurityException)
  {
    throw new SecurityException("Looks like the app doesn't have the permission to access location.\nAdd the following line to your app's AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_FINE_LOCATION\" />", paramSecurityException);
  }

  @ReactMethod
  public void getCurrentPosition(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    LocationOptions localLocationOptions = LocationOptions.fromReactMap(paramReadableMap);
    LocationManager localLocationManager;
    String str;
    Location localLocation;
    try
    {
      localLocationManager = (LocationManager)getReactApplicationContext().getSystemService("location");
      str = getValidProvider(localLocationManager, localLocationOptions.highAccuracy);
      if (str == null)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = PositionError.buildError(PositionError.POSITION_UNAVAILABLE, "No location provider available.");
        paramCallback2.invoke(arrayOfObject1);
        return;
      }
      localLocation = localLocationManager.getLastKnownLocation(str);
      if ((localLocation != null) && (SystemClock.currentTimeMillis() - localLocation.getTime() < localLocationOptions.maximumAge))
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = locationToMap(localLocation);
        paramCallback1.invoke(arrayOfObject2);
        return;
      }
    }
    catch (SecurityException localSecurityException)
    {
      throwLocationPermissionMissing(localSecurityException);
      return;
    }
    new SingleUpdateRequest(localLocationManager, str, localLocationOptions.timeout, paramCallback1, paramCallback2, null).invoke(localLocation);
  }

  public String getName()
  {
    return "LocationObserver";
  }

  @ReactMethod
  public void startObserving(ReadableMap paramReadableMap)
  {
    if ("gps".equals(this.mWatchedProvider))
      return;
    LocationOptions localLocationOptions = LocationOptions.fromReactMap(paramReadableMap);
    LocationManager localLocationManager;
    String str;
    try
    {
      localLocationManager = (LocationManager)getReactApplicationContext().getSystemService("location");
      str = getValidProvider(localLocationManager, localLocationOptions.highAccuracy);
      if (str == null)
      {
        emitError(PositionError.POSITION_UNAVAILABLE, "No location provider available.");
        return;
      }
    }
    catch (SecurityException localSecurityException)
    {
      throwLocationPermissionMissing(localSecurityException);
      return;
    }
    if (!str.equals(this.mWatchedProvider))
    {
      localLocationManager.removeUpdates(this.mLocationListener);
      localLocationManager.requestLocationUpdates(str, 1000L, localLocationOptions.distanceFilter, this.mLocationListener);
    }
    this.mWatchedProvider = str;
  }

  @ReactMethod
  public void stopObserving()
  {
    ((LocationManager)getReactApplicationContext().getSystemService("location")).removeUpdates(this.mLocationListener);
    this.mWatchedProvider = null;
  }

  private static class LocationOptions
  {
    private final float distanceFilter;
    private final boolean highAccuracy;
    private final double maximumAge;
    private final long timeout;

    private LocationOptions(long paramLong, double paramDouble, boolean paramBoolean, float paramFloat)
    {
      this.timeout = paramLong;
      this.maximumAge = paramDouble;
      this.highAccuracy = paramBoolean;
      this.distanceFilter = paramFloat;
    }

    private static LocationOptions fromReactMap(ReadableMap paramReadableMap)
    {
      long l;
      double d;
      label41: boolean bool;
      if (paramReadableMap.hasKey("timeout"))
      {
        l = ()paramReadableMap.getDouble("timeout");
        if (!paramReadableMap.hasKey("maximumAge"))
          break label109;
        d = paramReadableMap.getDouble("maximumAge");
        if ((!paramReadableMap.hasKey("enableHighAccuracy")) || (!paramReadableMap.getBoolean("enableHighAccuracy")))
          break label116;
        bool = true;
        label66: if (!paramReadableMap.hasKey("distanceFilter"))
          break label122;
      }
      label109: label116: label122: for (float f = (float)paramReadableMap.getDouble("distanceFilter"); ; f = 100.0F)
      {
        return new LocationOptions(l, d, bool, f);
        l = 9223372036854775807L;
        break;
        d = (1.0D / 0.0D);
        break label41;
        bool = false;
        break label66;
      }
    }
  }

  private static class SingleUpdateRequest
  {
    private static final int TWO_MINUTES = 120000;
    private final Callback mError;
    private final Handler mHandler = new Handler();
    private final LocationListener mLocationListener = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        synchronized (LocationModule.SingleUpdateRequest.this)
        {
          if ((!LocationModule.SingleUpdateRequest.this.mTriggered) && (LocationModule.SingleUpdateRequest.this.isBetterLocation(paramAnonymousLocation, LocationModule.SingleUpdateRequest.this.mOldLocation)))
          {
            Callback localCallback = LocationModule.SingleUpdateRequest.this.mSuccess;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = LocationModule.locationToMap(paramAnonymousLocation);
            localCallback.invoke(arrayOfObject);
            LocationModule.SingleUpdateRequest.this.mHandler.removeCallbacks(LocationModule.SingleUpdateRequest.this.mTimeoutRunnable);
            LocationModule.SingleUpdateRequest.access$902(LocationModule.SingleUpdateRequest.this, true);
            LocationModule.SingleUpdateRequest.this.mLocationManager.removeUpdates(LocationModule.SingleUpdateRequest.this.mLocationListener);
          }
          LocationModule.SingleUpdateRequest.access$1302(LocationModule.SingleUpdateRequest.this, paramAnonymousLocation);
          return;
        }
      }

      public void onProviderDisabled(String paramAnonymousString)
      {
      }

      public void onProviderEnabled(String paramAnonymousString)
      {
      }

      public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
      }
    };
    private final LocationManager mLocationManager;
    private Location mOldLocation;
    private final String mProvider;
    private final Callback mSuccess;
    private final long mTimeout;
    private final Runnable mTimeoutRunnable = new Runnable()
    {
      public void run()
      {
        synchronized (LocationModule.SingleUpdateRequest.this)
        {
          if (!LocationModule.SingleUpdateRequest.this.mTriggered)
          {
            Callback localCallback = LocationModule.SingleUpdateRequest.this.mError;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = PositionError.buildError(PositionError.TIMEOUT, "Location request timed out");
            localCallback.invoke(arrayOfObject);
            LocationModule.SingleUpdateRequest.this.mLocationManager.removeUpdates(LocationModule.SingleUpdateRequest.this.mLocationListener);
            FLog.i("ReactNative", "LocationModule: Location request timed out");
            LocationModule.SingleUpdateRequest.access$902(LocationModule.SingleUpdateRequest.this, true);
          }
          return;
        }
      }
    };
    private boolean mTriggered;

    private SingleUpdateRequest(LocationManager paramLocationManager, String paramString, long paramLong, Callback paramCallback1, Callback paramCallback2)
    {
      this.mLocationManager = paramLocationManager;
      this.mProvider = paramString;
      this.mTimeout = paramLong;
      this.mSuccess = paramCallback1;
      this.mError = paramCallback2;
    }

    private boolean isBetterLocation(Location paramLocation1, Location paramLocation2)
    {
      if (paramLocation2 == null);
      label38: int k;
      label65: label71: label75: 
      while (true)
      {
        return true;
        long l = paramLocation1.getTime() - paramLocation2.getTime();
        int i;
        int j;
        if (l > 120000L)
        {
          i = 1;
          if (l >= -120000L)
            break label65;
          j = 1;
          if (l <= 0L)
            break label71;
        }
        for (k = 1; ; k = 0)
        {
          if (i != 0)
            break label75;
          if (j == 0)
            break label77;
          return false;
          i = 0;
          break;
          j = 0;
          break label38;
        }
      }
      label77: int m = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
      int n;
      label97: int i1;
      if (m > 0)
      {
        n = 1;
        if (m >= 0)
          break label168;
        i1 = 1;
        label105: if (m <= 200)
          break label174;
      }
      label168: label174: for (int i2 = 1; ; i2 = 0)
      {
        boolean bool = isSameProvider(paramLocation1.getProvider(), paramLocation2.getProvider());
        if ((i1 != 0) || ((k != 0) && (n == 0)) || ((k != 0) && (i2 == 0) && (bool)))
          break;
        return false;
        n = 0;
        break label97;
        i1 = 0;
        break label105;
      }
    }

    private boolean isSameProvider(String paramString1, String paramString2)
    {
      if (paramString1 == null)
        return paramString2 == null;
      return paramString1.equals(paramString2);
    }

    public void invoke(Location paramLocation)
    {
      this.mOldLocation = paramLocation;
      this.mLocationManager.requestLocationUpdates(this.mProvider, 100L, 1.0F, this.mLocationListener);
      this.mHandler.postDelayed(this.mTimeoutRunnable, this.mTimeout);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.location.LocationModule
 * JD-Core Version:    0.6.2
 */