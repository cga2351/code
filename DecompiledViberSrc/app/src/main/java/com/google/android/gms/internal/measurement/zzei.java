package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzcx;

final class zzei extends zzea.zzb
{
  zzei(zzea paramzzea, zzcx paramzzcx)
  {
    super(paramzzea);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzb(this.zzadv).setEventInterceptor(new zzea.zzc(this.zzaef));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzei
 * JD-Core Version:    0.6.2
 */