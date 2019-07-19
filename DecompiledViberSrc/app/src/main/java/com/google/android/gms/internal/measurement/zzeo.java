package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzeo extends zzea.zzb
{
  zzeo(zzea paramzzea, String paramString1, String paramString2, boolean paramBoolean, zzea.zza paramzza)
  {
    super(paramzzea);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzb(this.zzadv).getUserProperties(this.zzads, this.zzadz, this.zzaeg, this.zzaea);
  }

  protected final void zzge()
  {
    this.zzaea.zzb(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzeo
 * JD-Core Version:    0.6.2
 */