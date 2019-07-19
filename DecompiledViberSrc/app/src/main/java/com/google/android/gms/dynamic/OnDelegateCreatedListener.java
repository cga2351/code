package com.google.android.gms.dynamic;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface OnDelegateCreatedListener<T extends LifecycleDelegate>
{
  @KeepForSdk
  public abstract void onDelegateCreated(T paramT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.OnDelegateCreatedListener
 * JD-Core Version:    0.6.2
 */