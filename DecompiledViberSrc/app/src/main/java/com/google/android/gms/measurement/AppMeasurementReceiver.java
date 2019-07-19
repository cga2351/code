package com.google.android.gms.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzbm;
import com.google.android.gms.measurement.internal.zzbp;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver
  implements zzbp
{
  private zzbm zzadb;

  public final BroadcastReceiver.PendingResult doGoAsync()
  {
    return goAsync();
  }

  public final void doStartService(Context paramContext, Intent paramIntent)
  {
    startWakefulService(paramContext, paramIntent);
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.zzadb == null)
      this.zzadb = new zzbm(this);
    this.zzadb.onReceive(paramContext, paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementReceiver
 * JD-Core Version:    0.6.2
 */