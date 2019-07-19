package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L>
{
  private final ListenerHolder<L> zajt;
  private final Feature[] zaju;
  private final boolean zajv;

  @KeepForSdk
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder)
  {
    this.zajt = paramListenerHolder;
    this.zaju = null;
    this.zajv = false;
  }

  @KeepForSdk
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    this.zajt = paramListenerHolder;
    this.zaju = paramArrayOfFeature;
    this.zajv = paramBoolean;
  }

  @KeepForSdk
  public void clearListener()
  {
    this.zajt.clear();
  }

  @KeepForSdk
  public ListenerHolder.ListenerKey<L> getListenerKey()
  {
    return this.zajt.getListenerKey();
  }

  @KeepForSdk
  public Feature[] getRequiredFeatures()
  {
    return this.zaju;
  }

  @KeepForSdk
  protected abstract void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws RemoteException;

  public final boolean shouldAutoResolveMissingFeatures()
  {
    return this.zajv;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.RegisterListenerMethod
 * JD-Core Version:    0.6.2
 */