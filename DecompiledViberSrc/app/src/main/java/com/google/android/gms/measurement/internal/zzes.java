package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzes
  implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener
{
  private volatile boolean zzasr;
  private volatile zzar zzass;

  protected zzes(zzeb paramzzeb)
  {
  }

  // ERROR //
  public final void onConnected(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 36
    //   2: invokestatic 42	com/google/android/gms/common/internal/Preconditions:checkMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 44	com/google/android/gms/measurement/internal/zzes:zzass	Lcom/google/android/gms/measurement/internal/zzar;
    //   11: invokevirtual 50	com/google/android/gms/measurement/internal/zzar:getService	()Landroid/os/IInterface;
    //   14: checkcast 52	com/google/android/gms/measurement/internal/zzaj
    //   17: astore 5
    //   19: aload_0
    //   20: getfield 21	com/google/android/gms/measurement/internal/zzes:zzasl	Lcom/google/android/gms/measurement/internal/zzeb;
    //   23: invokevirtual 58	com/google/android/gms/measurement/internal/zzcr:zzgs	()Lcom/google/android/gms/measurement/internal/zzbr;
    //   26: new 60	com/google/android/gms/measurement/internal/zzev
    //   29: dup
    //   30: aload_0
    //   31: aload 5
    //   33: invokespecial 63	com/google/android/gms/measurement/internal/zzev:<init>	(Lcom/google/android/gms/measurement/internal/zzes;Lcom/google/android/gms/measurement/internal/zzaj;)V
    //   36: invokevirtual 69	com/google/android/gms/measurement/internal/zzbr:zzc	(Ljava/lang/Runnable;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 44	com/google/android/gms/measurement/internal/zzes:zzass	Lcom/google/android/gms/measurement/internal/zzar;
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 28	com/google/android/gms/measurement/internal/zzes:zzasr	Z
    //   52: goto -13 -> 39
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    //   60: astore_2
    //   61: goto -19 -> 42
    //   64: astore 4
    //   66: goto -24 -> 42
    //
    // Exception table:
    //   from	to	target	type
    //   7	39	55	finally
    //   39	41	55	finally
    //   42	52	55	finally
    //   56	58	55	finally
    //   7	39	60	android/os/DeadObjectException
    //   7	39	64	java/lang/IllegalStateException
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
    zzas localzzas = this.zzasl.zzada.zzkj();
    if (localzzas != null)
      localzzas.zzjj().zzg("Service connection failed", paramConnectionResult);
    try
    {
      this.zzasr = false;
      this.zzass = null;
      this.zzasl.zzgs().zzc(new zzex(this));
      return;
    }
    finally
    {
    }
  }

  public final void onConnectionSuspended(int paramInt)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
    this.zzasl.zzgt().zzjn().zzby("Service connection suspended");
    this.zzasl.zzgs().zzc(new zzew(this));
  }

  // ERROR //
  public final void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: ldc 130
    //   2: invokestatic 42	com/google/android/gms/common/internal/Preconditions:checkMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_2
    //   8: ifnonnull +26 -> 34
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 28	com/google/android/gms/measurement/internal/zzes:zzasr	Z
    //   16: aload_0
    //   17: getfield 21	com/google/android/gms/measurement/internal/zzes:zzasl	Lcom/google/android/gms/measurement/internal/zzeb;
    //   20: invokevirtual 111	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   23: invokevirtual 133	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   26: ldc 135
    //   28: invokevirtual 119	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_2
    //   35: invokeinterface 141 1 0
    //   40: astore 7
    //   42: ldc 143
    //   44: aload 7
    //   46: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: istore 8
    //   51: iload 8
    //   53: ifeq +128 -> 181
    //   56: aload_2
    //   57: ifnonnull +61 -> 118
    //   60: aconst_null
    //   61: astore 4
    //   63: aload_0
    //   64: getfield 21	com/google/android/gms/measurement/internal/zzes:zzasl	Lcom/google/android/gms/measurement/internal/zzeb;
    //   67: invokevirtual 111	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   70: invokevirtual 152	com/google/android/gms/measurement/internal/zzas:zzjo	()Lcom/google/android/gms/measurement/internal/zzau;
    //   73: ldc 154
    //   75: invokevirtual 119	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   78: aload 4
    //   80: ifnonnull +124 -> 204
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 28	com/google/android/gms/measurement/internal/zzes:zzasr	Z
    //   88: invokestatic 160	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   91: aload_0
    //   92: getfield 21	com/google/android/gms/measurement/internal/zzes:zzasl	Lcom/google/android/gms/measurement/internal/zzeb;
    //   95: invokevirtual 164	com/google/android/gms/measurement/internal/zzcr:getContext	()Landroid/content/Context;
    //   98: aload_0
    //   99: getfield 21	com/google/android/gms/measurement/internal/zzes:zzasl	Lcom/google/android/gms/measurement/internal/zzeb;
    //   102: invokestatic 167	com/google/android/gms/measurement/internal/zzeb:zza	(Lcom/google/android/gms/measurement/internal/zzeb;)Lcom/google/android/gms/measurement/internal/zzes;
    //   105: invokevirtual 171	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: astore 5
    //   113: aload_0
    //   114: monitorexit
    //   115: aload 5
    //   117: athrow
    //   118: aload_2
    //   119: ldc 143
    //   121: invokeinterface 175 2 0
    //   126: astore 9
    //   128: aload 9
    //   130: instanceof 52
    //   133: ifeq +13 -> 146
    //   136: aload 9
    //   138: checkcast 52	com/google/android/gms/measurement/internal/zzaj
    //   141: astore 4
    //   143: goto -80 -> 63
    //   146: new 177	com/google/android/gms/measurement/internal/zzal
    //   149: dup
    //   150: aload_2
    //   151: invokespecial 180	com/google/android/gms/measurement/internal/zzal:<init>	(Landroid/os/IBinder;)V
    //   154: astore 4
    //   156: goto -93 -> 63
    //   159: astore_3
    //   160: aconst_null
    //   161: astore 4
    //   163: aload_0
    //   164: getfield 21	com/google/android/gms/measurement/internal/zzes:zzasl	Lcom/google/android/gms/measurement/internal/zzeb;
    //   167: invokevirtual 111	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   170: invokevirtual 133	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   173: ldc 182
    //   175: invokevirtual 119	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   178: goto -100 -> 78
    //   181: aload_0
    //   182: getfield 21	com/google/android/gms/measurement/internal/zzes:zzasl	Lcom/google/android/gms/measurement/internal/zzeb;
    //   185: invokevirtual 111	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   188: invokevirtual 133	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   191: ldc 184
    //   193: aload 7
    //   195: invokevirtual 99	com/google/android/gms/measurement/internal/zzau:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   198: aconst_null
    //   199: astore 4
    //   201: goto -123 -> 78
    //   204: aload_0
    //   205: getfield 21	com/google/android/gms/measurement/internal/zzes:zzasl	Lcom/google/android/gms/measurement/internal/zzeb;
    //   208: invokevirtual 58	com/google/android/gms/measurement/internal/zzcr:zzgs	()Lcom/google/android/gms/measurement/internal/zzbr;
    //   211: new 186	com/google/android/gms/measurement/internal/zzet
    //   214: dup
    //   215: aload_0
    //   216: aload 4
    //   218: invokespecial 187	com/google/android/gms/measurement/internal/zzet:<init>	(Lcom/google/android/gms/measurement/internal/zzes;Lcom/google/android/gms/measurement/internal/zzaj;)V
    //   221: invokevirtual 69	com/google/android/gms/measurement/internal/zzbr:zzc	(Ljava/lang/Runnable;)V
    //   224: goto -116 -> 108
    //   227: astore 6
    //   229: goto -121 -> 108
    //   232: astore 10
    //   234: goto -71 -> 163
    //
    // Exception table:
    //   from	to	target	type
    //   11	33	111	finally
    //   34	51	111	finally
    //   63	78	111	finally
    //   83	88	111	finally
    //   88	108	111	finally
    //   108	110	111	finally
    //   113	115	111	finally
    //   118	143	111	finally
    //   146	156	111	finally
    //   163	178	111	finally
    //   181	198	111	finally
    //   204	224	111	finally
    //   34	51	159	android/os/RemoteException
    //   118	143	159	android/os/RemoteException
    //   146	156	159	android/os/RemoteException
    //   181	198	159	android/os/RemoteException
    //   88	108	227	java/lang/IllegalArgumentException
    //   63	78	232	android/os/RemoteException
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
    this.zzasl.zzgt().zzjn().zzby("Service disconnected");
    this.zzasl.zzgs().zzc(new zzeu(this, paramComponentName));
  }

  public final void zzb(Intent paramIntent)
  {
    this.zzasl.zzaf();
    Context localContext = this.zzasl.getContext();
    ConnectionTracker localConnectionTracker = ConnectionTracker.getInstance();
    try
    {
      if (this.zzasr)
      {
        this.zzasl.zzgt().zzjo().zzby("Connection attempt already in progress");
        return;
      }
      this.zzasl.zzgt().zzjo().zzby("Using local app measurement service");
      this.zzasr = true;
      localConnectionTracker.bindService(localContext, paramIntent, zzeb.zza(this.zzasl), 129);
      return;
    }
    finally
    {
    }
  }

  public final void zzlk()
  {
    if ((this.zzass != null) && ((this.zzass.isConnected()) || (this.zzass.isConnecting())))
      this.zzass.disconnect();
    this.zzass = null;
  }

  public final void zzll()
  {
    this.zzasl.zzaf();
    Context localContext = this.zzasl.getContext();
    try
    {
      if (this.zzasr)
      {
        this.zzasl.zzgt().zzjo().zzby("Connection attempt already in progress");
        return;
      }
      if ((this.zzass != null) && ((this.zzass.isConnecting()) || (this.zzass.isConnected())))
      {
        this.zzasl.zzgt().zzjo().zzby("Already awaiting connection attempt");
        return;
      }
    }
    finally
    {
    }
    this.zzass = new zzar(localContext, Looper.getMainLooper(), this, this);
    this.zzasl.zzgt().zzjo().zzby("Connecting to remote service");
    this.zzasr = true;
    this.zzass.checkAvailabilityAndConnect();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzes
 * JD-Core Version:    0.6.2
 */