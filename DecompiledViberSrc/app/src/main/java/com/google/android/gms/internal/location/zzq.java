package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

@VisibleForTesting
public final class zzq
  implements FusedLocationProviderApi
{
  public final PendingResult<Status> flushLocations(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.execute(new zzv(this, paramGoogleApiClient));
  }

  public final Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    zzaz localzzaz = LocationServices.zza(paramGoogleApiClient);
    try
    {
      Location localLocation = localzzaz.getLastLocation();
      return localLocation;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final LocationAvailability getLocationAvailability(GoogleApiClient paramGoogleApiClient)
  {
    zzaz localzzaz = LocationServices.zza(paramGoogleApiClient);
    try
    {
      LocationAvailability localLocationAvailability = localzzaz.zza();
      return localLocationAvailability;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzaa(this, paramGoogleApiClient, paramPendingIntent));
  }

  public final PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationCallback paramLocationCallback)
  {
    return paramGoogleApiClient.execute(new zzs(this, paramGoogleApiClient, paramLocationCallback));
  }

  public final PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener)
  {
    return paramGoogleApiClient.execute(new zzz(this, paramGoogleApiClient, paramLocationListener));
  }

  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzy(this, paramGoogleApiClient, paramLocationRequest, paramPendingIntent));
  }

  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper)
  {
    return paramGoogleApiClient.execute(new zzx(this, paramGoogleApiClient, paramLocationRequest, paramLocationCallback, paramLooper));
  }

  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    Preconditions.checkNotNull(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
    return paramGoogleApiClient.execute(new zzr(this, paramGoogleApiClient, paramLocationRequest, paramLocationListener));
  }

  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    return paramGoogleApiClient.execute(new zzw(this, paramGoogleApiClient, paramLocationRequest, paramLocationListener, paramLooper));
  }

  public final PendingResult<Status> setMockLocation(GoogleApiClient paramGoogleApiClient, Location paramLocation)
  {
    return paramGoogleApiClient.execute(new zzu(this, paramGoogleApiClient, paramLocation));
  }

  public final PendingResult<Status> setMockMode(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return paramGoogleApiClient.execute(new zzt(this, paramGoogleApiClient, paramBoolean));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzq
 * JD-Core Version:    0.6.2
 */