package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class ag
{
  final Intent a;
  private final BroadcastReceiver.PendingResult b;
  private boolean c = false;
  private final ScheduledFuture<?> d;

  ag(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.a = paramIntent;
    this.b = paramPendingResult;
    this.d = paramScheduledExecutorService.schedule(new af(this, paramIntent), 9000L, TimeUnit.MILLISECONDS);
  }

  final void a()
  {
    try
    {
      if (!this.c)
      {
        this.b.finish();
        this.d.cancel(false);
        this.c = true;
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
 * Qualified Name:     com.google.firebase.iid.ag
 * JD-Core Version:    0.6.2
 */