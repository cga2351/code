package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final class zah extends zad<Boolean>
{
  private final ListenerHolder.ListenerKey<?> zacs;

  public zah(ListenerHolder.ListenerKey<?> paramListenerKey, TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    super(4, paramTaskCompletionSource);
    this.zacs = paramListenerKey;
  }

  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa)
  {
    zabw localzabw = (zabw)paramzaa.zabk().get(this.zacs);
    if (localzabw == null)
      return null;
    return localzabw.zajw.getRequiredFeatures();
  }

  public final boolean zac(GoogleApiManager.zaa<?> paramzaa)
  {
    zabw localzabw = (zabw)paramzaa.zabk().get(this.zacs);
    return (localzabw != null) && (localzabw.zajw.shouldAutoResolveMissingFeatures());
  }

  public final void zad(GoogleApiManager.zaa<?> paramzaa)
    throws RemoteException
  {
    zabw localzabw = (zabw)paramzaa.zabk().remove(this.zacs);
    if (localzabw != null)
    {
      localzabw.zajx.unregisterListener(paramzaa.zaab(), this.zacm);
      localzabw.zajw.clearListener();
      return;
    }
    this.zacm.trySetResult(Boolean.valueOf(false));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zah
 * JD-Core Version:    0.6.2
 */