package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import javax.annotation.Nullable;

final class zzam
  implements ChannelApi.OpenChannelResult
{
  private final Channel zzcd;
  private final Status zzp;

  zzam(Status paramStatus, @Nullable Channel paramChannel)
  {
    this.zzp = ((Status)Preconditions.checkNotNull(paramStatus));
    this.zzcd = paramChannel;
  }

  @Nullable
  public final Channel getChannel()
  {
    return this.zzcd;
  }

  public final Status getStatus()
  {
    return this.zzp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzam
 * JD-Core Version:    0.6.2
 */