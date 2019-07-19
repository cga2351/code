package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Map;

final class zzes extends zzea.zzb
{
  zzes(zzea paramzzea, zzcy paramzzcy)
  {
    super(paramzzea);
  }

  final void zzgd()
    throws RemoteException
  {
    if (zzea.zzd(this.zzadv).containsKey(this.zzaen))
    {
      Log.w(zzea.zzc(this.zzadv), "OnEventListener already registered.");
      return;
    }
    zzea.zzd localzzd = new zzea.zzd(this.zzaen);
    zzea.zzd(this.zzadv).put(this.zzaen, localzzd);
    zzea.zzb(this.zzadv).registerOnMeasurementEventListener(localzzd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzes
 * JD-Core Version:    0.6.2
 */