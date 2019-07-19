package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L>
{
  public final RegisterListenerMethod<A, L> zajy;
  public final UnregisterListenerMethod<A, L> zajz;

  private RegistrationMethods(RegisterListenerMethod<A, L> paramRegisterListenerMethod, UnregisterListenerMethod<A, L> paramUnregisterListenerMethod)
  {
    this.zajy = paramRegisterListenerMethod;
    this.zajz = paramUnregisterListenerMethod;
  }

  @KeepForSdk
  public static <A extends Api.AnyClient, L> Builder<A, L> builder()
  {
    return new Builder(null);
  }

  @KeepForSdk
  public static class Builder<A extends Api.AnyClient, L>
  {
    private boolean zajv = true;
    private RemoteCall<A, TaskCompletionSource<Void>> zaka;
    private RemoteCall<A, TaskCompletionSource<Boolean>> zakb;
    private ListenerHolder<L> zakc;
    private Feature[] zakd;

    @KeepForSdk
    public RegistrationMethods<A, L> build()
    {
      boolean bool1 = true;
      boolean bool2;
      boolean bool3;
      if (this.zaka != null)
      {
        bool2 = bool1;
        Preconditions.checkArgument(bool2, "Must set register function");
        if (this.zakb == null)
          break label94;
        bool3 = bool1;
        label26: Preconditions.checkArgument(bool3, "Must set unregister function");
        if (this.zakc == null)
          break label99;
      }
      while (true)
      {
        Preconditions.checkArgument(bool1, "Must set holder");
        return new RegistrationMethods(new zaca(this, this.zakc, this.zakd, this.zajv), new zacb(this, this.zakc.getListenerKey()), null);
        bool2 = false;
        break;
        label94: bool3 = false;
        break label26;
        label99: bool1 = false;
      }
    }

    @KeepForSdk
    public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> paramRemoteCall)
    {
      this.zaka = paramRemoteCall;
      return this;
    }

    @Deprecated
    @KeepForSdk
    public Builder<A, L> register(BiConsumer<A, TaskCompletionSource<Void>> paramBiConsumer)
    {
      this.zaka = new zaby(paramBiConsumer);
      return this;
    }

    @KeepForSdk
    public Builder<A, L> setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      this.zajv = paramBoolean;
      return this;
    }

    @KeepForSdk
    public Builder<A, L> setFeatures(Feature[] paramArrayOfFeature)
    {
      this.zakd = paramArrayOfFeature;
      return this;
    }

    @KeepForSdk
    public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> paramRemoteCall)
    {
      this.zakb = paramRemoteCall;
      return this;
    }

    @Deprecated
    @KeepForSdk
    public Builder<A, L> unregister(BiConsumer<A, TaskCompletionSource<Boolean>> paramBiConsumer)
    {
      this.zaka = new zabz(this);
      return this;
    }

    @KeepForSdk
    public Builder<A, L> withHolder(ListenerHolder<L> paramListenerHolder)
    {
      this.zakc = paramListenerHolder;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.RegistrationMethods
 * JD-Core Version:    0.6.2
 */