package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzgc
  implements ChannelApi.ChannelListener
{
  private final String zzce;
  private final ChannelApi.ChannelListener zzeq;

  zzgc(String paramString, ChannelApi.ChannelListener paramChannelListener)
  {
    this.zzce = ((String)Preconditions.checkNotNull(paramString));
    this.zzeq = ((ChannelApi.ChannelListener)Preconditions.checkNotNull(paramChannelListener));
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzgc localzzgc;
    do
    {
      return true;
      if (!(paramObject instanceof zzgc))
        return false;
      localzzgc = (zzgc)paramObject;
    }
    while ((this.zzeq.equals(localzzgc.zzeq)) && (this.zzce.equals(localzzgc.zzce)));
    return false;
  }

  public final int hashCode()
  {
    return 31 * this.zzce.hashCode() + this.zzeq.hashCode();
  }

  public final void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzeq.onChannelClosed(paramChannel, paramInt1, paramInt2);
  }

  public final void onChannelOpened(Channel paramChannel)
  {
    this.zzeq.onChannelOpened(paramChannel);
  }

  public final void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzeq.onInputClosed(paramChannel, paramInt1, paramInt2);
  }

  public final void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzeq.onOutputClosed(paramChannel, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgc
 * JD-Core Version:    0.6.2
 */