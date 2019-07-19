package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

final class zzaw
  implements ProxyApi.ProxyResult
{
  private Status mStatus;
  private ProxyResponse zzch;

  public zzaw(ProxyResponse paramProxyResponse)
  {
    this.zzch = paramProxyResponse;
    this.mStatus = Status.RESULT_SUCCESS;
  }

  public zzaw(Status paramStatus)
  {
    this.mStatus = paramStatus;
  }

  public final ProxyResponse getResponse()
  {
    return this.zzch;
  }

  public final Status getStatus()
  {
    return this.mStatus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzaw
 * JD-Core Version:    0.6.2
 */