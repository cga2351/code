package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
public class PooledExecutorsProvider
{
  private static PooledExecutorFactory zzey;

  @KeepForSdk
  public static PooledExecutorFactory getInstance()
  {
    try
    {
      if (zzey == null)
        zzey = new zza();
      PooledExecutorFactory localPooledExecutorFactory = zzey;
      return localPooledExecutorFactory;
    }
    finally
    {
    }
  }

  public static abstract interface PooledExecutorFactory
  {
    @KeepForSdk
    public abstract ScheduledExecutorService newSingleThreadScheduledExecutor();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.providers.PooledExecutorsProvider
 * JD-Core Version:    0.6.2
 */