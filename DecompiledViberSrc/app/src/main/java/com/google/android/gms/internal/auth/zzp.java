package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzp
  implements Result
{
  private final Status mStatus;

  public zzp(Status paramStatus)
  {
    this.mStatus = paramStatus;
  }

  public final Status getStatus()
  {
    return this.mStatus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzp
 * JD-Core Version:    0.6.2
 */