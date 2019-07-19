package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;

public class ResolvableApiException extends ApiException
{
  public ResolvableApiException(Status paramStatus)
  {
    super(paramStatus);
  }

  public PendingIntent getResolution()
  {
    return this.mStatus.getResolution();
  }

  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    this.mStatus.startResolutionForResult(paramActivity, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.ResolvableApiException
 * JD-Core Version:    0.6.2
 */