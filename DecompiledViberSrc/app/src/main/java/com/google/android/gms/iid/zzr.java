package com.google.android.gms.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.gcm.zzf;
import com.google.android.gms.internal.gcm.zzg;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzr
{
  private final ScheduledExecutorService zzce;

  @GuardedBy("this")
  private zzt zzcf = new zzt(this, null);

  @GuardedBy("this")
  private int zzcg = 1;
  private final Context zzl;

  public zzr(Context paramContext)
  {
    this(paramContext, zzg.zzaa().zze(1, new NamedThreadFactory("MessengerIpcClient"), 9));
  }

  private zzr(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzl = paramContext.getApplicationContext();
    this.zzce = paramScheduledExecutorService;
  }

  private final <T> Task<T> zzd(zzz<T> paramzzz)
  {
    try
    {
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        String str = String.valueOf(paramzzz);
        Log.d("MessengerIpcClient", 9 + String.valueOf(str).length() + "Queueing " + str);
      }
      if (!this.zzcf.zze(paramzzz))
      {
        this.zzcf = new zzt(this, null);
        this.zzcf.zze(paramzzz);
      }
      Task localTask = paramzzz.zzcq.getTask();
      return localTask;
    }
    finally
    {
    }
  }

  private final int zzs()
  {
    try
    {
      int i = this.zzcg;
      this.zzcg = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final Task<Bundle> zzd(int paramInt, Bundle paramBundle)
  {
    return zzd(new zzab(zzs(), 1, paramBundle));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzr
 * JD-Core Version:    0.6.2
 */