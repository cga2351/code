package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.wearable.DataClient.OnDataChangedListener;

final class zzcw extends UnregisterListenerMethod<zzhg, DataClient.OnDataChangedListener>
{
  private final DataClient.OnDataChangedListener zzdk;

  private zzcw(DataClient.OnDataChangedListener paramOnDataChangedListener, ListenerHolder.ListenerKey<DataClient.OnDataChangedListener> paramListenerKey)
  {
    super(paramListenerKey);
    this.zzdk = paramOnDataChangedListener;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcw
 * JD-Core Version:    0.6.2
 */