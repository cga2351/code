package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;

public final class zzas
  implements ChannelApi.ChannelListener
{
  private final ChannelClient.ChannelCallback zzch;

  public zzas(ChannelClient.ChannelCallback paramChannelCallback)
  {
    this.zzch = paramChannelCallback;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    zzas localzzas = (zzas)paramObject;
    return this.zzch.equals(localzzas.zzch);
  }

  public final int hashCode()
  {
    return this.zzch.hashCode();
  }

  public final void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzch.onChannelClosed(zzao.zzb(paramChannel), paramInt1, paramInt2);
  }

  public final void onChannelOpened(Channel paramChannel)
  {
    this.zzch.onChannelOpened(zzao.zzb(paramChannel));
  }

  public final void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzch.onInputClosed(zzao.zzb(paramChannel), paramInt1, paramInt2);
  }

  public final void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzch.onOutputClosed(zzao.zzb(paramChannel), paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzas
 * JD-Core Version:    0.6.2
 */