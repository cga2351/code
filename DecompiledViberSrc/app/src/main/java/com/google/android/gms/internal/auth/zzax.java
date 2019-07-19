package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class zzax
  implements ProxyApi.SpatulaHeaderResult
{
  private Status mStatus;
  private String zzci;

  public zzax(@Nonnull Status paramStatus)
  {
    this.mStatus = ((Status)Preconditions.checkNotNull(paramStatus));
  }

  public zzax(@Nonnull String paramString)
  {
    this.zzci = ((String)Preconditions.checkNotNull(paramString));
    this.mStatus = Status.RESULT_SUCCESS;
  }

  @Nullable
  public final String getSpatulaHeader()
  {
    return this.zzci;
  }

  @Nullable
  public final Status getStatus()
  {
    return this.mStatus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzax
 * JD-Core Version:    0.6.2
 */