package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqb
  implements zzbrk, zzbrn, zzbsq
{

  @GuardedBy("this")
  private zzatc zzgev;

  @GuardedBy("this")
  private zzasv zzgew;

  public final void onAdClosed()
  {
    try
    {
      zzatc localzzatc = this.zzgev;
      if (localzzatc != null);
      try
      {
        this.zzgev.onRewardedVideoAdClosed();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdClosed.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    try
    {
      zzatc localzzatc = this.zzgev;
      if (localzzatc != null);
      try
      {
        this.zzgev.onRewardedVideoAdFailedToLoad(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdFailedToLoad.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdLeftApplication()
  {
    try
    {
      zzatc localzzatc = this.zzgev;
      if (localzzatc != null);
      try
      {
        this.zzgev.onRewardedVideoAdLeftApplication();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdLeftApplication.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdLoaded()
  {
    try
    {
      zzatc localzzatc = this.zzgev;
      if (localzzatc != null);
      try
      {
        this.zzgev.onRewardedVideoAdLoaded();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdLoaded.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdOpened()
  {
    try
    {
      zzatc localzzatc = this.zzgev;
      if (localzzatc != null);
      try
      {
        this.zzgev.onRewardedVideoAdOpened();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdOpened.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onRewardedVideoCompleted()
  {
    try
    {
      zzatc localzzatc = this.zzgev;
      if (localzzatc != null);
      try
      {
        this.zzgev.onRewardedVideoCompleted();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onRewardedVideoStarted()
  {
    try
    {
      zzatc localzzatc = this.zzgev;
      if (localzzatc != null);
      try
      {
        this.zzgev.onRewardedVideoStarted();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onRewardedVideoStarted.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  // ERROR //
  public final void zzb(zzass paramzzass, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/google/android/gms/internal/ads/zzcqb:zzgev	Lcom/google/android/gms/internal/ads/zzatc;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnull +13 -> 23
    //   13: aload_0
    //   14: getfield 26	com/google/android/gms/internal/ads/zzcqb:zzgev	Lcom/google/android/gms/internal/ads/zzatc;
    //   17: aload_1
    //   18: invokeinterface 85 2 0
    //   23: aload_0
    //   24: getfield 87	com/google/android/gms/internal/ads/zzcqb:zzgew	Lcom/google/android/gms/internal/ads/zzasv;
    //   27: astore 6
    //   29: aload 6
    //   31: ifnull +15 -> 46
    //   34: aload_0
    //   35: getfield 87	com/google/android/gms/internal/ads/zzcqb:zzgew	Lcom/google/android/gms/internal/ads/zzasv;
    //   38: aload_1
    //   39: aload_2
    //   40: aload_3
    //   41: invokeinterface 91 4 0
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore 8
    //   51: ldc 93
    //   53: aload 8
    //   55: invokestatic 39	com/google/android/gms/internal/ads/zzaxa:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: goto -35 -> 23
    //   61: astore 4
    //   63: aload_0
    //   64: monitorexit
    //   65: aload 4
    //   67: athrow
    //   68: astore 7
    //   70: ldc 69
    //   72: aload 7
    //   74: invokestatic 74	com/google/android/gms/internal/ads/zzbae:zze	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: goto -31 -> 46
    //
    // Exception table:
    //   from	to	target	type
    //   13	23	49	android/os/RemoteException
    //   2	8	61	finally
    //   13	23	61	finally
    //   23	29	61	finally
    //   34	46	61	finally
    //   51	58	61	finally
    //   70	77	61	finally
    //   34	46	68	android/os/RemoteException
  }

  public final void zzb(zzasv paramzzasv)
  {
    try
    {
      this.zzgew = paramzzasv;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(zzatc paramzzatc)
  {
    try
    {
      this.zzgev = paramzzatc;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqb
 * JD-Core Version:    0.6.2
 */