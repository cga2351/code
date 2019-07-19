package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzee extends zzea.zzb
{
  zzee(zzea paramzzea, Activity paramActivity, String paramString1, String paramString2)
  {
    super(paramzzea);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzb(this.zzadv).setCurrentScreen(ObjectWrapper.wrap(this.val$activity), this.zzaeb, this.zzaec, this.timestamp);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzee
 * JD-Core Version:    0.6.2
 */