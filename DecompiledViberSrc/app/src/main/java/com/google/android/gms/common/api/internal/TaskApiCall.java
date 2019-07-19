package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT>
{
  private final Feature[] zakd;
  private final boolean zakk;

  @Deprecated
  @KeepForSdk
  public TaskApiCall()
  {
    this.zakd = null;
    this.zakk = false;
  }

  @KeepForSdk
  private TaskApiCall(Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    this.zakd = paramArrayOfFeature;
    this.zakk = paramBoolean;
  }

  @KeepForSdk
  public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder()
  {
    return new Builder(null);
  }

  @KeepForSdk
  protected abstract void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource)
    throws RemoteException;

  @KeepForSdk
  public boolean shouldAutoResolveMissingFeatures()
  {
    return this.zakk;
  }

  public final Feature[] zabt()
  {
    return this.zakd;
  }

  @KeepForSdk
  public static class Builder<A extends Api.AnyClient, ResultT>
  {
    private Feature[] zakd;
    private boolean zakk = true;
    private RemoteCall<A, TaskCompletionSource<ResultT>> zakl;

    @KeepForSdk
    public TaskApiCall<A, ResultT> build()
    {
      if (this.zakl != null);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool, "execute parameter required");
        return new zack(this, this.zakd, this.zakk);
      }
    }

    @Deprecated
    @KeepForSdk
    public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> paramBiConsumer)
    {
      this.zakl = new zacj(paramBiConsumer);
      return this;
    }

    @KeepForSdk
    public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> paramRemoteCall)
    {
      this.zakl = paramRemoteCall;
      return this;
    }

    @KeepForSdk
    public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      this.zakk = paramBoolean;
      return this;
    }

    @KeepForSdk
    public Builder<A, ResultT> setFeatures(Feature[] paramArrayOfFeature)
    {
      this.zakd = paramArrayOfFeature;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.TaskApiCall
 * JD-Core Version:    0.6.2
 */