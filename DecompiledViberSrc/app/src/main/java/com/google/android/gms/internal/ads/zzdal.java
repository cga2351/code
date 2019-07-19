package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzdal
  implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener
{
  private final String packageName;
  private final HandlerThread zzdxu;

  @VisibleForTesting
  private zzdaz zzgny;
  private final String zzgnz;
  private final LinkedBlockingQueue<zzbp.zza> zzgoa;

  public zzdal(Context paramContext, String paramString1, String paramString2)
  {
    this.packageName = paramString1;
    this.zzgnz = paramString2;
    this.zzdxu = new HandlerThread("GassClient");
    this.zzdxu.start();
    this.zzgny = new zzdaz(paramContext, this.zzdxu.getLooper(), this, this);
    this.zzgoa = new LinkedBlockingQueue();
    this.zzgny.checkAvailabilityAndConnect();
  }

  private final void zzakh()
  {
    if ((this.zzgny != null) && ((this.zzgny.isConnected()) || (this.zzgny.isConnecting())))
      this.zzgny.disconnect();
  }

  private final zzdbe zzanf()
  {
    try
    {
      zzdbe localzzdbe = this.zzgny.zzanm();
      return localzzdbe;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      return null;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      label11: break label11;
    }
  }

  @VisibleForTesting
  private static zzbp.zza zzang()
  {
    return (zzbp.zza)zzbp.zza.zzam().zzau(32768L).zzaya();
  }

  // ERROR //
  public final void onConnected(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 111	com/google/android/gms/internal/ads/zzdal:zzanf	()Lcom/google/android/gms/internal/ads/zzdbe;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +50 -> 56
    //   9: aload_2
    //   10: new 113	com/google/android/gms/internal/ads/zzdba
    //   13: dup
    //   14: aload_0
    //   15: getfield 26	com/google/android/gms/internal/ads/zzdal:packageName	Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 28	com/google/android/gms/internal/ads/zzdal:zzgnz	Ljava/lang/String;
    //   22: invokespecial 116	com/google/android/gms/internal/ads/zzdba:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: invokeinterface 122 2 0
    //   30: invokevirtual 127	com/google/android/gms/internal/ads/zzdbc:zzann	()Lcom/google/android/gms/internal/ads/zzbp$zza;
    //   33: astore 8
    //   35: aload_0
    //   36: getfield 56	com/google/android/gms/internal/ads/zzdal:zzgoa	Ljava/util/concurrent/LinkedBlockingQueue;
    //   39: aload 8
    //   41: invokevirtual 131	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   44: aload_0
    //   45: invokespecial 133	com/google/android/gms/internal/ads/zzdal:zzakh	()V
    //   48: aload_0
    //   49: getfield 37	com/google/android/gms/internal/ads/zzdal:zzdxu	Landroid/os/HandlerThread;
    //   52: invokevirtual 136	android/os/HandlerThread:quit	()Z
    //   55: pop
    //   56: return
    //   57: astore 5
    //   59: aload_0
    //   60: getfield 56	com/google/android/gms/internal/ads/zzdal:zzgoa	Ljava/util/concurrent/LinkedBlockingQueue;
    //   63: invokestatic 138	com/google/android/gms/internal/ads/zzdal:zzang	()Lcom/google/android/gms/internal/ads/zzbp$zza;
    //   66: invokevirtual 131	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   69: aload_0
    //   70: invokespecial 133	com/google/android/gms/internal/ads/zzdal:zzakh	()V
    //   73: aload_0
    //   74: getfield 37	com/google/android/gms/internal/ads/zzdal:zzdxu	Landroid/os/HandlerThread;
    //   77: invokevirtual 136	android/os/HandlerThread:quit	()Z
    //   80: pop
    //   81: return
    //   82: astore_3
    //   83: aload_0
    //   84: invokespecial 133	com/google/android/gms/internal/ads/zzdal:zzakh	()V
    //   87: aload_0
    //   88: getfield 37	com/google/android/gms/internal/ads/zzdal:zzdxu	Landroid/os/HandlerThread;
    //   91: invokevirtual 136	android/os/HandlerThread:quit	()Z
    //   94: pop
    //   95: aload_3
    //   96: athrow
    //   97: astore 6
    //   99: goto -30 -> 69
    //
    // Exception table:
    //   from	to	target	type
    //   9	44	57	java/lang/Throwable
    //   9	44	82	finally
    //   59	69	82	finally
    //   59	69	97	java/lang/InterruptedException
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    try
    {
      this.zzgoa.put(zzang());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public final void onConnectionSuspended(int paramInt)
  {
    try
    {
      this.zzgoa.put(zzang());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public final zzbp.zza zzdr(int paramInt)
  {
    try
    {
      localzza = (zzbp.zza)this.zzgoa.poll(5000L, TimeUnit.MILLISECONDS);
      if (localzza == null)
        localzza = zzang();
      return localzza;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        zzbp.zza localzza = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdal
 * JD-Core Version:    0.6.2
 */