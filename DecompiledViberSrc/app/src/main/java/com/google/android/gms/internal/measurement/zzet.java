package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Map;

final class zzet extends zzea.zzb
{
  zzet(zzea paramzzea, zzcy paramzzcy)
  {
    super(paramzzea);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzd localzzd = (zzea.zzd)zzea.zzd(this.zzadv).get(this.zzaen);
    if (localzzd == null)
    {
      Log.w(zzea.zzc(this.zzadv), "OnEventListener had not been registered.");
      return;
    }
    zzea.zzb(this.zzadv).unregisterOnMeasurementEventListener(localzzd);
    zzea.zzd(this.zzadv).remove(this.zzaen);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzet
 * JD-Core Version:    0.6.2
 */