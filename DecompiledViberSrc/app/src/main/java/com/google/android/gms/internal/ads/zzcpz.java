package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpz
  implements zzbrk, zzbrr
{

  @GuardedBy("this")
  private zzatx zzges;

  @GuardedBy("this")
  private zzauf zzget;

  public final void onAdClosed()
  {
    try
    {
      zzatx localzzatx = this.zzges;
      if (localzzatx != null);
      try
      {
        this.zzges.onRewardedAdClosed();
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

  public final void onAdLeftApplication()
  {
  }

  public final void onAdOpened()
  {
    try
    {
      zzatx localzzatx = this.zzges;
      if (localzzatx != null);
      try
      {
        this.zzges.onRewardedAdOpened();
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

  public final void onRewardedVideoCompleted()
  {
  }

  public final void onRewardedVideoStarted()
  {
  }

  // ERROR //
  public final void zzb(zzass paramzzass, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/google/android/gms/internal/ads/zzcpz:zzges	Lcom/google/android/gms/internal/ads/zzatx;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnull +31 -> 41
    //   13: aload_0
    //   14: getfield 24	com/google/android/gms/internal/ads/zzcpz:zzges	Lcom/google/android/gms/internal/ads/zzatx;
    //   17: new 48	com/google/android/gms/internal/ads/zzauq
    //   20: dup
    //   21: aload_1
    //   22: invokeinterface 54 1 0
    //   27: aload_1
    //   28: invokeinterface 58 1 0
    //   33: invokespecial 61	com/google/android/gms/internal/ads/zzauq:<init>	(Ljava/lang/String;I)V
    //   36: invokeinterface 65 2 0
    //   41: aload_0
    //   42: getfield 67	com/google/android/gms/internal/ads/zzcpz:zzget	Lcom/google/android/gms/internal/ads/zzauf;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +33 -> 82
    //   52: aload_0
    //   53: getfield 67	com/google/android/gms/internal/ads/zzcpz:zzget	Lcom/google/android/gms/internal/ads/zzauf;
    //   56: new 48	com/google/android/gms/internal/ads/zzauq
    //   59: dup
    //   60: aload_1
    //   61: invokeinterface 54 1 0
    //   66: aload_1
    //   67: invokeinterface 58 1 0
    //   72: invokespecial 61	com/google/android/gms/internal/ads/zzauq:<init>	(Ljava/lang/String;I)V
    //   75: aload_2
    //   76: aload_3
    //   77: invokeinterface 72 4 0
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore 8
    //   87: ldc 31
    //   89: aload 8
    //   91: invokestatic 37	com/google/android/gms/internal/ads/zzbae:zze	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: goto -53 -> 41
    //   97: astore 4
    //   99: aload_0
    //   100: monitorexit
    //   101: aload 4
    //   103: athrow
    //   104: astore 7
    //   106: ldc 31
    //   108: aload 7
    //   110: invokestatic 37	com/google/android/gms/internal/ads/zzbae:zze	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: goto -31 -> 82
    //
    // Exception table:
    //   from	to	target	type
    //   13	41	85	android/os/RemoteException
    //   2	8	97	finally
    //   13	41	97	finally
    //   41	47	97	finally
    //   52	82	97	finally
    //   87	94	97	finally
    //   106	113	97	finally
    //   52	82	104	android/os/RemoteException
  }

  public final void zzb(zzatx paramzzatx)
  {
    try
    {
      this.zzges = paramzzatx;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(zzauf paramzzauf)
  {
    try
    {
      this.zzget = paramzzauf;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzcs(int paramInt)
  {
    try
    {
      zzatx localzzatx = this.zzges;
      if (localzzatx != null);
      try
      {
        this.zzges.onRewardedAdFailedToShow(paramInt);
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpz
 * JD-Core Version:    0.6.2
 */