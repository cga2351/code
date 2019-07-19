package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzev extends zzea.zzb
{
  zzev(zzea paramzzea, String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    super(paramzzea);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzb(this.zzadv).setUserProperty(this.zzads, this.val$name, ObjectWrapper.wrap(this.zzaes), this.zzaeq, this.timestamp);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzev
 * JD-Core Version:    0.6.2
 */