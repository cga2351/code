package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzbm;
import com.google.android.gms.measurement.internal.zzbp;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver
  implements zzbp
{
  private zzbm zzadb;

  public final BroadcastReceiver.PendingResult doGoAsync()
  {
    return goAsync();
  }

  public final void doStartService(Context paramContext, Intent paramIntent)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.zzadb == null)
      this.zzadb = new zzbm(this);
    this.zzadb.onReceive(paramContext, paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementInstallReferrerReceiver
 * JD-Core Version:    0.6.2
 */