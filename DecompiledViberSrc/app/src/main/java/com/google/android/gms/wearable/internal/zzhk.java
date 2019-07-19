package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import java.util.List;
import javax.annotation.Nullable;

@VisibleForTesting
public final class zzhk<T> extends zzen
{
  private final IntentFilter[] zzba;

  @Nullable
  private final String zzbb;
  private ListenerHolder<Object> zzfj;
  private ListenerHolder<Object> zzfk;
  private ListenerHolder<DataApi.DataListener> zzfl;
  private ListenerHolder<MessageApi.MessageListener> zzfm;
  private ListenerHolder<Object> zzfn;
  private ListenerHolder<Object> zzfo;
  private ListenerHolder<ChannelApi.ChannelListener> zzfp;
  private ListenerHolder<CapabilityApi.CapabilityListener> zzfq;

  private zzhk(IntentFilter[] paramArrayOfIntentFilter, @Nullable String paramString)
  {
    this.zzba = ((IntentFilter[])Preconditions.checkNotNull(paramArrayOfIntentFilter));
    this.zzbb = paramString;
  }

  public static zzhk<ChannelApi.ChannelListener> zza(ListenerHolder<ChannelApi.ChannelListener> paramListenerHolder, String paramString, IntentFilter[] paramArrayOfIntentFilter)
  {
    zzhk localzzhk = new zzhk(paramArrayOfIntentFilter, (String)Preconditions.checkNotNull(paramString));
    localzzhk.zzfp = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    return localzzhk;
  }

  public static zzhk<DataApi.DataListener> zza(ListenerHolder<DataApi.DataListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    zzhk localzzhk = new zzhk(paramArrayOfIntentFilter, null);
    localzzhk.zzfl = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    return localzzhk;
  }

  private static void zza(ListenerHolder<?> paramListenerHolder)
  {
    if (paramListenerHolder != null)
      paramListenerHolder.clear();
  }

  public static zzhk<MessageApi.MessageListener> zzb(ListenerHolder<MessageApi.MessageListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    zzhk localzzhk = new zzhk(paramArrayOfIntentFilter, null);
    localzzhk.zzfm = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    return localzzhk;
  }

  public static zzhk<ChannelApi.ChannelListener> zzc(ListenerHolder<ChannelApi.ChannelListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    zzhk localzzhk = new zzhk(paramArrayOfIntentFilter, null);
    localzzhk.zzfp = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    return localzzhk;
  }

  public static zzhk<CapabilityApi.CapabilityListener> zzd(ListenerHolder<CapabilityApi.CapabilityListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    zzhk localzzhk = new zzhk(paramArrayOfIntentFilter, null);
    localzzhk.zzfq = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    return localzzhk;
  }

  public final void clear()
  {
    zza(null);
    this.zzfj = null;
    zza(null);
    this.zzfk = null;
    zza(this.zzfl);
    this.zzfl = null;
    zza(this.zzfm);
    this.zzfm = null;
    zza(null);
    this.zzfn = null;
    zza(null);
    this.zzfo = null;
    zza(this.zzfp);
    this.zzfp = null;
    zza(this.zzfq);
    this.zzfq = null;
  }

  public final void onConnectedNodes(List<zzfo> paramList)
  {
  }

  public final void zza(DataHolder paramDataHolder)
  {
    if (this.zzfl != null)
    {
      this.zzfl.notifyListener(new zzhl(paramDataHolder));
      return;
    }
    paramDataHolder.close();
  }

  public final void zza(zzah paramzzah)
  {
    if (this.zzfq != null)
      this.zzfq.notifyListener(new zzho(paramzzah));
  }

  public final void zza(zzaw paramzzaw)
  {
    if (this.zzfp != null)
      this.zzfp.notifyListener(new zzhn(paramzzaw));
  }

  public final void zza(zzfe paramzzfe)
  {
    if (this.zzfm != null)
      this.zzfm.notifyListener(new zzhm(paramzzfe));
  }

  public final void zza(zzfo paramzzfo)
  {
  }

  public final void zza(zzi paramzzi)
  {
  }

  public final void zza(zzl paramzzl)
  {
  }

  public final void zzb(zzfo paramzzfo)
  {
  }

  public final IntentFilter[] zze()
  {
    return this.zzba;
  }

  @Nullable
  public final String zzf()
  {
    return this.zzbb;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhk
 * JD-Core Version:    0.6.2
 */