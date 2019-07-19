package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public abstract interface Clock
{
  @KeepForSdk
  public abstract long currentThreadTimeMillis();

  @KeepForSdk
  public abstract long currentTimeMillis();

  @KeepForSdk
  public abstract long elapsedRealtime();

  @KeepForSdk
  public abstract long nanoTime();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.Clock
 * JD-Core Version:    0.6.2
 */