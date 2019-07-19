package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

final class zzdan
  implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener
{
  private final Object lock = new Object();
  private boolean zzfxf = false;
  private boolean zzfxg = false;
  private final zzdaz zzgoc;
  private final zzdat zzgod;

  zzdan(Context paramContext, Looper paramLooper, zzdat paramzzdat)
  {
    this.zzgod = paramzzdat;
    this.zzgoc = new zzdaz(paramContext, paramLooper, this, this);
  }

  private final void zzakh()
  {
    synchronized (this.lock)
    {
      if ((this.zzgoc.isConnected()) || (this.zzgoc.isConnecting()))
        this.zzgoc.disconnect();
      Binder.flushPendingCommands();
      return;
    }
  }

  // ERROR //
  public final void onConnected(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/google/android/gms/internal/ads/zzdan:lock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 28	com/google/android/gms/internal/ads/zzdan:zzfxg	Z
    //   11: ifeq +6 -> 17
    //   14: aload_2
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 28	com/google/android/gms/internal/ads/zzdan:zzfxg	Z
    //   22: aload_0
    //   23: getfield 37	com/google/android/gms/internal/ads/zzdan:zzgoc	Lcom/google/android/gms/internal/ads/zzdaz;
    //   26: invokevirtual 61	com/google/android/gms/internal/ads/zzdaz:zzanm	()Lcom/google/android/gms/internal/ads/zzdbe;
    //   29: new 63	com/google/android/gms/internal/ads/zzdax
    //   32: dup
    //   33: aload_0
    //   34: getfield 30	com/google/android/gms/internal/ads/zzdan:zzgod	Lcom/google/android/gms/internal/ads/zzdat;
    //   37: invokevirtual 69	com/google/android/gms/internal/ads/zzdmh:toByteArray	()[B
    //   40: invokespecial 72	com/google/android/gms/internal/ads/zzdax:<init>	([B)V
    //   43: invokeinterface 78 2 0
    //   48: aload_0
    //   49: invokespecial 80	com/google/android/gms/internal/ads/zzdan:zzakh	()V
    //   52: aload_2
    //   53: monitorexit
    //   54: return
    //   55: astore_3
    //   56: aload_2
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    //   60: astore 5
    //   62: aload_0
    //   63: invokespecial 80	com/google/android/gms/internal/ads/zzdan:zzakh	()V
    //   66: goto -14 -> 52
    //   69: astore 4
    //   71: aload_0
    //   72: invokespecial 80	com/google/android/gms/internal/ads/zzdan:zzakh	()V
    //   75: aload 4
    //   77: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   7	16	55	finally
    //   17	22	55	finally
    //   48	52	55	finally
    //   52	54	55	finally
    //   56	58	55	finally
    //   62	66	55	finally
    //   71	78	55	finally
    //   22	48	60	java/lang/Exception
    //   22	48	69	finally
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
  }

  public final void onConnectionSuspended(int paramInt)
  {
  }

  final void zzanh()
  {
    synchronized (this.lock)
    {
      if (!this.zzfxf)
      {
        this.zzfxf = true;
        this.zzgoc.checkAvailabilityAndConnect();
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdan
 * JD-Core Version:    0.6.2
 */