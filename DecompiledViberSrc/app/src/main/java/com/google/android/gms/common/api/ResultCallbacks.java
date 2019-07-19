package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(Status paramStatus);

  @KeepForSdk
  public final void onResult(R paramR)
  {
    Status localStatus = paramR.getStatus();
    if (localStatus.isSuccess())
      onSuccess(paramR);
    do
    {
      return;
      onFailure(localStatus);
    }
    while (!(paramR instanceof Releasable));
    try
    {
      ((Releasable)paramR).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      String str = String.valueOf(paramR);
      Log.w("ResultCallbacks", 18 + String.valueOf(str).length() + "Unable to release " + str, localRuntimeException);
    }
  }

  public abstract void onSuccess(R paramR);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.ResultCallbacks
 * JD-Core Version:    0.6.2
 */