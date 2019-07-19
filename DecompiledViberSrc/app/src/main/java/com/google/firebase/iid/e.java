package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzb;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class e
{

  @GuardedBy("MessengerIpcClient.class")
  private static e a;
  private final Context b;
  private final ScheduledExecutorService c;

  @GuardedBy("this")
  private f d = new f(this, null);

  @GuardedBy("this")
  private int e = 1;

  private e(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.c = paramScheduledExecutorService;
    this.b = paramContext.getApplicationContext();
  }

  private final int a()
  {
    try
    {
      int i = this.e;
      this.e = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private final <T> Task<T> a(o<T> paramo)
  {
    try
    {
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        String str = String.valueOf(paramo);
        Log.d("MessengerIpcClient", 9 + String.valueOf(str).length() + "Queueing " + str);
      }
      if (!this.d.a(paramo))
      {
        this.d = new f(this, null);
        this.d.a(paramo);
      }
      Task localTask = paramo.b.getTask();
      return localTask;
    }
    finally
    {
    }
  }

  public static e a(Context paramContext)
  {
    try
    {
      if (a == null)
        a = new e(paramContext, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zze));
      e locale = a;
      return locale;
    }
    finally
    {
    }
  }

  public final Task<Void> a(int paramInt, Bundle paramBundle)
  {
    return a(new l(a(), 2, paramBundle));
  }

  public final Task<Bundle> b(int paramInt, Bundle paramBundle)
  {
    return a(new q(a(), 1, paramBundle));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.e
 * JD-Core Version:    0.6.2
 */