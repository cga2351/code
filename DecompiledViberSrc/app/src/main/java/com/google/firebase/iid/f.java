package com.google.firebase.iid;

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
import com.google.android.gms.internal.firebase_messaging.zze;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class f
  implements ServiceConnection
{

  @GuardedBy("this")
  int a = 0;
  final Messenger b = new Messenger(new zze(Looper.getMainLooper(), new i(this)));
  m c;

  @GuardedBy("this")
  final Queue<o<?>> d = new ArrayDeque();

  @GuardedBy("this")
  final SparseArray<o<?>> e = new SparseArray();

  private f(e parame)
  {
  }

  private final void c()
  {
    e.b(this.f).execute(new k(this));
  }

  final void a()
  {
    try
    {
      if ((this.a == 2) && (this.d.isEmpty()) && (this.e.size() == 0))
      {
        if (Log.isLoggable("MessengerIpcClient", 2))
          Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
        this.a = 3;
        ConnectionTracker.getInstance().unbindService(e.a(this.f), this);
      }
      return;
    }
    finally
    {
    }
  }

  final void a(int paramInt)
  {
    try
    {
      o localo = (o)this.e.get(paramInt);
      if (localo != null)
      {
        Log.w("MessengerIpcClient", 31 + "Timing out request: " + paramInt);
        this.e.remove(paramInt);
        localo.a(new n(3, "Timed out waiting for response"));
        a();
      }
      return;
    }
    finally
    {
    }
  }

  final void a(int paramInt, String paramString)
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
          switch (this.a)
          {
          default:
            int j = this.a;
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
    this.a = 4;
    ConnectionTracker.getInstance().unbindService(e.a(this.f), this);
    n localn = new n(paramInt, paramString);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      ((o)localIterator.next()).a(localn);
    this.d.clear();
    for (int i = 0; i < this.e.size(); i++)
      ((o)this.e.valueAt(i)).a(localn);
    this.e.clear();
    while (true)
    {
      return;
      this.a = 4;
    }
  }

  final boolean a(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (Log.isLoggable("MessengerIpcClient", 3))
      Log.d("MessengerIpcClient", 41 + "Received response to request: " + i);
    o localo;
    Bundle localBundle;
    try
    {
      localo = (o)this.e.get(i);
      if (localo == null)
      {
        Log.w("MessengerIpcClient", 50 + "Received response for unknown request: " + i);
        return true;
      }
      this.e.remove(i);
      a();
      localBundle = paramMessage.getData();
      if (localBundle.getBoolean("unsupported", false))
      {
        localo.a(new n(4, "Not supported by GmsCore"));
        return true;
      }
    }
    finally
    {
    }
    localo.a(localBundle);
    return true;
  }

  final boolean a(o paramo)
  {
    boolean bool1 = true;
    try
    {
      switch (this.a)
      {
      default:
        int j = this.a;
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
    this.d.add(paramo);
    int i = this.a;
    boolean bool2 = false;
    if (i == 0)
      bool2 = bool1;
    Preconditions.checkState(bool2);
    if (Log.isLoggable("MessengerIpcClient", 2))
      Log.v("MessengerIpcClient", "Starting bind to GmsCore");
    this.a = 1;
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage("com.google.android.gms");
    if (!ConnectionTracker.getInstance().bindService(e.a(this.f), localIntent, this, 1))
      a(0, "Unable to bind to service");
    while (true)
    {
      return bool1;
      e.b(this.f).schedule(new h(this), 30L, TimeUnit.SECONDS);
      continue;
      this.d.add(paramo);
      continue;
      this.d.add(paramo);
      c();
      continue;
      bool1 = false;
    }
  }

  final void b()
  {
    try
    {
      if (this.a == 1)
        a(1, "Timed out while binding");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  public final void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 94
    //   4: iconst_2
    //   5: invokestatic 100	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   8: ifeq +12 -> 20
    //   11: ldc 94
    //   13: ldc_w 293
    //   16: invokestatic 106	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   19: pop
    //   20: aload_2
    //   21: ifnonnull +14 -> 35
    //   24: aload_0
    //   25: iconst_0
    //   26: ldc_w 295
    //   29: invokevirtual 268	com/google/firebase/iid/f:a	(ILjava/lang/String;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: new 297	com/google/firebase/iid/m
    //   39: dup
    //   40: aload_2
    //   41: invokespecial 300	com/google/firebase/iid/m:<init>	(Landroid/os/IBinder;)V
    //   44: putfield 302	com/google/firebase/iid/f:c	Lcom/google/firebase/iid/m;
    //   47: aload_0
    //   48: iconst_2
    //   49: putfield 32	com/google/firebase/iid/f:a	I
    //   52: aload_0
    //   53: invokespecial 285	com/google/firebase/iid/f:c	()V
    //   56: goto -24 -> 32
    //   59: astore_3
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_3
    //   63: athrow
    //   64: astore 4
    //   66: aload_0
    //   67: iconst_0
    //   68: aload 4
    //   70: invokevirtual 305	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 268	com/google/firebase/iid/f:a	(ILjava/lang/String;)V
    //   76: goto -44 -> 32
    //
    // Exception table:
    //   from	to	target	type
    //   2	20	59	finally
    //   24	32	59	finally
    //   35	47	59	finally
    //   47	56	59	finally
    //   66	76	59	finally
    //   35	47	64	android/os/RemoteException
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (Log.isLoggable("MessengerIpcClient", 2))
        Log.v("MessengerIpcClient", "Service disconnected");
      a(2, "Service disconnected");
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.f
 * JD-Core Version:    0.6.2
 */