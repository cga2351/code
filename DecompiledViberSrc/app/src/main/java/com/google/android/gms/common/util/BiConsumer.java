package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface BiConsumer<T, U>
{
  @KeepForSdk
  public abstract void accept(T paramT, U paramU);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.BiConsumer
 * JD-Core Version:    0.6.2
 */