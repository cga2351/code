package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class ApiExceptionUtil
{
  @KeepForSdk
  public static ApiException fromStatus(Status paramStatus)
  {
    if (paramStatus.hasResolution())
      return new ResolvableApiException(paramStatus);
    return new ApiException(paramStatus);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ApiExceptionUtil
 * JD-Core Version:    0.6.2
 */