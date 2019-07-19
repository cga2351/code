package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

public final class UnsupportedApiCallException extends UnsupportedOperationException
{
  private final Feature zzar;

  @KeepForSdk
  public UnsupportedApiCallException(Feature paramFeature)
  {
    this.zzar = paramFeature;
  }

  public final String getMessage()
  {
    String str = String.valueOf(this.zzar);
    return 8 + String.valueOf(str).length() + "Missing " + str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.UnsupportedApiCallException
 * JD-Core Version:    0.6.2
 */