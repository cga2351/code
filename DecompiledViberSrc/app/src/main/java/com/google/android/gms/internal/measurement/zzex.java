package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzex extends zzea.zzb
{
  zzex(zzea.zze paramzze, Activity paramActivity, Bundle paramBundle)
  {
    super(paramzze.zzadv);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzb(this.zzafa.zzadv).onActivityCreated(ObjectWrapper.wrap(this.val$activity), this.zzaez, this.zzaev);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzex
 * JD-Core Version:    0.6.2
 */