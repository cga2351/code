package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzep extends zzea.zzb
{
  zzep(zzea paramzzea, boolean paramBoolean, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    super(paramzzea, false);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzb(this.zzadv).logHealthData(this.zzaeh, this.zzaei, ObjectWrapper.wrap(this.zzaej), ObjectWrapper.wrap(this.zzaek), ObjectWrapper.wrap(this.zzael));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzep
 * JD-Core Version:    0.6.2
 */