package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import javax.annotation.Nullable;

final class zzau extends UnregisterListenerMethod<zzhg, ChannelClient.ChannelCallback>
{

  @Nullable
  private final String zzce;
  private final ChannelApi.ChannelListener zzcf;

  zzau(ChannelApi.ChannelListener paramChannelListener, @Nullable String paramString, ListenerHolder.ListenerKey<ChannelClient.ChannelCallback> paramListenerKey)
  {
    super(paramListenerKey);
    this.zzcf = paramChannelListener;
    this.zzce = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzau
 * JD-Core Version:    0.6.2
 */