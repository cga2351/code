package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataClient.OnDataChangedListener;

final class zzcv extends RegisterListenerMethod<zzhg, DataClient.OnDataChangedListener>
{
  private final IntentFilter[] zzba;
  private final ListenerHolder<DataApi.DataListener> zzbz;
  private final DataClient.OnDataChangedListener zzdk;

  private zzcv(DataClient.OnDataChangedListener paramOnDataChangedListener, IntentFilter[] paramArrayOfIntentFilter, ListenerHolder<DataClient.OnDataChangedListener> paramListenerHolder)
  {
    super(paramListenerHolder);
    this.zzdk = paramOnDataChangedListener;
    this.zzba = paramArrayOfIntentFilter;
    this.zzbz = paramListenerHolder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcv
 * JD-Core Version:    0.6.2
 */