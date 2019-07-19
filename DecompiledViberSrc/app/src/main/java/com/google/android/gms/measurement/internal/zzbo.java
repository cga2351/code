package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Bundle;

final class zzbo
  implements Runnable
{
  zzbo(zzbm paramzzbm, zzbw paramzzbw, long paramLong, Bundle paramBundle, Context paramContext, zzas paramzzas, BroadcastReceiver.PendingResult paramPendingResult)
  {
  }

  public final void run()
  {
    long l1 = this.zzaoh.zzgu().zzanh.get();
    long l2 = this.zzaoj;
    if ((l1 > 0L) && ((l2 >= l1) || (l2 <= 0L)))
      l2 = l1 - 1L;
    if (l2 > 0L)
      this.zzaok.putLong("click_timestamp", l2);
    this.zzaok.putString("_cis", "referrer broadcast");
    zzbw.zza(this.val$context, null).zzgj().logEvent("auto", "_cmp", this.zzaok);
    this.zzaoi.zzjo().zzby("Install campaign recorded");
    if (this.zzrf != null)
      this.zzrf.finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbo
 * JD-Core Version:    0.6.2
 */