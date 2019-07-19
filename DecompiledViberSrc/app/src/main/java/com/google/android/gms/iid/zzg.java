package com.google.android.gms.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzg
{
  final Intent intent;
  private final BroadcastReceiver.PendingResult zzbi;
  private boolean zzbj = false;
  private final ScheduledFuture<?> zzbk;

  zzg(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.intent = paramIntent;
    this.zzbi = paramPendingResult;
    this.zzbk = paramScheduledExecutorService.schedule(new zzh(this, paramIntent), 9500L, TimeUnit.MILLISECONDS);
  }

  final void finish()
  {
    try
    {
      if (!this.zzbj)
      {
        this.zzbi.finish();
        this.zzbk.cancel(false);
        this.zzbj = true;
      }
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
 * Qualified Name:     com.google.android.gms.iid.zzg
 * JD-Core Version:    0.6.2
 */