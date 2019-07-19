package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;

public class ActivityRecognitionClient extends GoogleApi<Api.ApiOptions.NoOptions>
{
  public ActivityRecognitionClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.API, null, new ApiExceptionMapper());
  }

  public ActivityRecognitionClient(Context paramContext)
  {
    super(paramContext, LocationServices.API, null, new ApiExceptionMapper());
  }

  public Task<Void> removeActivityTransitionUpdates(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(ActivityRecognition.ActivityRecognitionApi.zza(asGoogleApiClient(), paramPendingIntent));
  }

  public Task<Void> removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(asGoogleApiClient(), paramPendingIntent));
  }

  public Task<Void> requestActivityTransitionUpdates(ActivityTransitionRequest paramActivityTransitionRequest, PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(ActivityRecognition.ActivityRecognitionApi.zza(asGoogleApiClient(), paramActivityTransitionRequest, paramPendingIntent));
  }

  public Task<Void> requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(asGoogleApiClient(), paramLong, paramPendingIntent));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionClient
 * JD-Core Version:    0.6.2
 */