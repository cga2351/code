package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class zzew
  implements Runnable
{
  zzew(zzes paramzzes)
  {
  }

  public final void run()
  {
    zzeb localzzeb = this.zzasu.zzasl;
    Context localContext = this.zzasu.zzasl.getContext();
    this.zzasu.zzasl.zzgw();
    zzeb.zza(localzzeb, new ComponentName(localContext, "com.google.android.gms.measurement.AppMeasurementService"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzew
 * JD-Core Version:    0.6.2
 */