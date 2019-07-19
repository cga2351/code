package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.gcm.zzj;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class zzt
  implements ServiceConnection
{

  @GuardedBy("this")
  int state = 0;
  final Messenger zzch = new Messenger(new zzj(Looper.getMainLooper(), new zzu(this)));
  zzy zzci;

  @GuardedBy("this")
  final Queue<zzz<?>> zzcj = new ArrayDeque();

  @GuardedBy("this")
  final SparseArray<zzz<?>> zzck = new SparseArray();

  private zzt(zzr paramzzr)
  {
  }

  private final void zzt()
  {
    zzr.zze(this.zzcl).execute(new zzw(this));
  }

  // ERROR //
  public final void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 90
    //   4: iconst_2
    //   5: invokestatic 96	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   8: ifeq +11 -> 19
    //   11: ldc 90
    //   13: ldc 98
    //   15: invokestatic 102	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_2
    //   20: ifnonnull +13 -> 33
    //   23: aload_0
    //   24: iconst_0
    //   25: ldc 104
    //   27: invokevirtual 108	com/google/android/gms/iid/zzt:zzd	(ILjava/lang/String;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: new 110	com/google/android/gms/iid/zzy
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 113	com/google/android/gms/iid/zzy:<init>	(Landroid/os/IBinder;)V
    //   42: putfield 115	com/google/android/gms/iid/zzt:zzci	Lcom/google/android/gms/iid/zzy;
    //   45: aload_0
    //   46: iconst_2
    //   47: putfield 32	com/google/android/gms/iid/zzt:state	I
    //   50: aload_0
    //   51: invokespecial 117	com/google/android/gms/iid/zzt:zzt	()V
    //   54: goto -24 -> 30
    //   57: astore_3
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_3
    //   61: athrow
    //   62: astore 4
    //   64: aload_0
    //   65: iconst_0
    //   66: aload 4
    //   68: invokevirtual 121	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   71: invokevirtual 108	com/google/android/gms/iid/zzt:zzd	(ILjava/lang/String;)V
    //   74: goto -44 -> 30
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	57	finally
    //   23	30	57	finally
    //   33	45	57	finally
    //   45	54	57	finally
    //   64	74	57	finally
    //   33	45	62	android/os/RemoteException
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (Log.isLoggable("MessengerIpcClient", 2))
        Log.v("MessengerIpcClient", "Service disconnected");
      zzd(2, "Service disconnected");
      return;
    }
    finally
    {
    }
  }

  final void zzd(int paramInt, String paramString)
  {
    while (true)
    {
      try
      {
        if (Log.isLoggable("MessengerIpcClient", 3))
        {
          String str1 = String.valueOf(paramString);
          if (str1.length() != 0)
          {
            str2 = "Disconnected: ".concat(str1);
            Log.d("MessengerIpcClient", str2);
          }
        }
        else
        {
          switch (this.state)
          {
          default:
            int j = this.state;
            throw new IllegalStateException(26 + "Unknown state: " + j);
          case 0:
          case 1:
          case 2:
          case 4:
          case 3:
          }
        }
      }
      finally
      {
      }
      String str2 = new String("Disconnected: ");
    }
    throw new IllegalStateException();
    if (Log.isLoggable("MessengerIpcClient", 2))
      Log.v("MessengerIpcClient", "Unbinding service");
    this.state = 4;
    ConnectionTracker.getInstance().unbindService(zzr.zzd(this.zzcl), this);
    zzaa localzzaa = new zzaa(paramInt, paramString);
    Iterator localIterator = this.zzcj.iterator();
    while (localIterator.hasNext())
      ((zzz)localIterator.next()).zzd(localzzaa);
    this.zzcj.clear();
    for (int i = 0; i < this.zzck.size(); i++)
      ((zzz)this.zzck.valueAt(i)).zzd(localzzaa);
    this.zzck.clear();
    while (true)
    {
      return;
      this.state = 4;
    }
  }

  final boolean zzd(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (Log.isLoggable("MessengerIpcClient", 3))
      Log.d("MessengerIpcClient", 41 + "Received response to request: " + i);
    zzz localzzz;
    Bundle localBundle;
    try
    {
      localzzz = (zzz)this.zzck.get(i);
      if (localzzz == null)
      {
        Log.w("MessengerIpcClient", 50 + "Received response for unknown request: " + i);
        return true;
      }
      this.zzck.remove(i);
      zzu();
      localBundle = paramMessage.getData();
      if (localBundle.getBoolean("unsupported", false))
      {
        localzzz.zzd(new zzaa(4, "Not supported by GmsCore"));
        return true;
      }
    }
    finally
    {
    }
    localzzz.zzh(localBundle);
    return true;
  }

  final boolean zze(zzz paramzzz)
  {
    boolean bool1 = true;
    try
    {
      switch (this.state)
      {
      default:
        int j = this.state;
        throw new IllegalStateException(26 + "Unknown state: " + j);
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    finally
    {
    }
    this.zzcj.add(paramzzz);
    int i = this.state;
    boolean bool2 = false;
    if (i == 0)
      bool2 = bool1;
    Preconditions.checkState(bool2);
    if (Log.isLoggable("MessengerIpcClient", 2))
      Log.v("MessengerIpcClient", "Starting bind to GmsCore");
    this.state = 1;
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage("com.google.android.gms");
    if (!ConnectionTracker.getInstance().bindService(zzr.zzd(this.zzcl), localIntent, this, 1))
      zzd(0, "Unable to bind to service");
    while (true)
    {
      return bool1;
      zzr.zze(this.zzcl).schedule(new zzv(this), 30L, TimeUnit.SECONDS);
      continue;
      this.zzcj.add(paramzzz);
      continue;
      this.zzcj.add(paramzzz);
      zzt();
      continue;
      bool1 = false;
    }
  }

  final void zzg(int paramInt)
  {
    try
    {
      zzz localzzz = (zzz)this.zzck.get(paramInt);
      if (localzzz != null)
      {
        Log.w("MessengerIpcClient", 31 + "Timing out request: " + paramInt);
        this.zzck.remove(paramInt);
        localzzz.zzd(new zzaa(3, "Timed out waiting for response"));
        zzu();
      }
      return;
    }
    finally
    {
    }
  }

  final void zzu()
  {
    try
    {
      if ((this.state == 2) && (this.zzcj.isEmpty()) && (this.zzck.size() == 0))
      {
        if (Log.isLoggable("MessengerIpcClient", 2))
          Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
        this.state = 3;
        ConnectionTracker.getInstance().unbindService(zzr.zzd(this.zzcl), this);
      }
      return;
    }
    finally
    {
    }
  }

  final void zzv()
  {
    try
    {
      if (this.state == 1)
        zzd(1, "Timed out while binding");
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
 * Qualified Name:     com.google.android.gms.iid.zzt
 * JD-Core Version:    0.6.2
 */