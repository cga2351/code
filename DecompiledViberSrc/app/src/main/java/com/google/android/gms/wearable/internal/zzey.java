package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzey
  implements MessageApi.SendMessageResult
{
  private final int zzeh;
  private final Status zzp;

  public zzey(Status paramStatus, int paramInt)
  {
    this.zzp = paramStatus;
    this.zzeh = paramInt;
  }

  public final int getRequestId()
  {
    return this.zzeh;
  }

  public final Status getStatus()
  {
    return this.zzp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzey
 * JD-Core Version:    0.6.2
 */