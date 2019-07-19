package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import javax.annotation.Nullable;

final class zzan extends zzn<Status>
{
  private final String zzce;
  private ChannelApi.ChannelListener zzcf;

  zzan(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener, @Nullable String paramString)
  {
    super(paramGoogleApiClient);
    this.zzcf = ((ChannelApi.ChannelListener)Preconditions.checkNotNull(paramChannelListener));
    this.zzce = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzan
 * JD-Core Version:    0.6.2
 */