package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final class zaf extends zad<Void>
{
  private final RegisterListenerMethod<Api.AnyClient, ?> zaco;
  private final UnregisterListenerMethod<Api.AnyClient, ?> zacp;

  public zaf(zabw paramzabw, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    super(3, paramTaskCompletionSource);
    this.zaco = paramzabw.zajw;
    this.zacp = paramzabw.zajx;
  }

  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa)
  {
    return this.zaco.getRequiredFeatures();
  }

  public final boolean zac(GoogleApiManager.zaa<?> paramzaa)
  {
    return this.zaco.shouldAutoResolveMissingFeatures();
  }

  public final void zad(GoogleApiManager.zaa<?> paramzaa)
    throws RemoteException
  {
    this.zaco.registerListener(paramzaa.zaab(), this.zacm);
    if (this.zaco.getListenerKey() != null)
      paramzaa.zabk().put(this.zaco.getListenerKey(), new zabw(this.zaco, this.zacp));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaf
 * JD-Core Version:    0.6.2
 */