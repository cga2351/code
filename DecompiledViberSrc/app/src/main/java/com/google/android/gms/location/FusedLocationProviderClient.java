package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.location.zzad;
import com.google.android.gms.internal.location.zzaj;
import com.google.android.gms.internal.location.zzak;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.internal.location.zzbm;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class FusedLocationProviderClient extends GoogleApi<Api.ApiOptions.NoOptions>
{
  public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

  public FusedLocationProviderClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.API, null, new ApiExceptionMapper());
  }

  public FusedLocationProviderClient(Context paramContext)
  {
    super(paramContext, LocationServices.API, null, new ApiExceptionMapper());
  }

  private final zzaj zza(TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    return new zzp(this, paramTaskCompletionSource);
  }

  public Task<Void> flushLocations()
  {
    return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.flushLocations(asGoogleApiClient()));
  }

  public Task<Location> getLastLocation()
  {
    return doRead(new zzl(this));
  }

  public Task<LocationAvailability> getLocationAvailability()
  {
    return doRead(new zzm(this));
  }

  public Task<Void> removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.removeLocationUpdates(asGoogleApiClient(), paramPendingIntent));
  }

  public Task<Void> removeLocationUpdates(LocationCallback paramLocationCallback)
  {
    return TaskUtil.toVoidTaskThatFailsOnFalse(doUnregisterEventListener(ListenerHolders.createListenerKey(paramLocationCallback, LocationCallback.class.getSimpleName())));
  }

  public Task<Void> requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.requestLocationUpdates(asGoogleApiClient(), paramLocationRequest, paramPendingIntent));
  }

  public Task<Void> requestLocationUpdates(LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper)
  {
    zzbd localzzbd = zzbd.zza(paramLocationRequest);
    ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramLocationCallback, zzbm.zza(paramLooper), LocationCallback.class.getSimpleName());
    return doRegisterEventListener(new zzn(this, localListenerHolder, localzzbd, localListenerHolder), new zzo(this, localListenerHolder.getListenerKey()));
  }

  public Task<Void> setMockLocation(Location paramLocation)
  {
    return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.setMockLocation(asGoogleApiClient(), paramLocation));
  }

  public Task<Void> setMockMode(boolean paramBoolean)
  {
    return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.setMockMode(asGoogleApiClient(), paramBoolean));
  }

  private static final class zza extends zzak
  {
    private final TaskCompletionSource<Void> zzac;

    public zza(TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      this.zzac = paramTaskCompletionSource;
    }

    public final void zza(zzad paramzzad)
    {
      TaskUtil.setResultOrApiException(paramzzad.getStatus(), this.zzac);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.FusedLocationProviderClient
 * JD-Core Version:    0.6.2
 */