package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R>
{
  private final Activity mActivity;
  private final int zzan;

  protected ResolvingResultCallbacks(Activity paramActivity, int paramInt)
  {
    this.mActivity = ((Activity)Preconditions.checkNotNull(paramActivity, "Activity must not be null"));
    this.zzan = paramInt;
  }

  @KeepForSdk
  public final void onFailure(Status paramStatus)
  {
    if (paramStatus.hasResolution())
      try
      {
        paramStatus.startResolutionForResult(this.mActivity, this.zzan);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        Log.e("ResolvingResultCallback", "Failed to start resolution", localSendIntentException);
        onUnresolvableFailure(new Status(8));
        return;
      }
    onUnresolvableFailure(paramStatus);
  }

  public abstract void onSuccess(R paramR);

  public abstract void onUnresolvableFailure(Status paramStatus);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.ResolvingResultCallbacks
 * JD-Core Version:    0.6.2
 */