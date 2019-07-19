package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

final class zzwb
  implements BaseGmsClient.BaseConnectionCallbacks
{
  zzwb(zzvz paramzzvz, zzvt paramzzvt, zzbbs paramzzbbs)
  {
  }

  public final void onConnected(Bundle paramBundle)
  {
    zzvs localzzvs;
    synchronized (zzvz.zzb(this.zzbxb))
    {
      if (zzvz.zzc(this.zzbxb))
        return;
      zzvz.zza(this.zzbxb, true);
      localzzvs = zzvz.zzd(this.zzbxb);
      if (localzzvs == null)
        return;
    }
    zzbbi localzzbbi = zzaxh.zzc(new zzwc(this, localzzvs, this.zzbxc, this.zzbxd));
    this.zzbxd.zza(new zzwd(this.zzbxd, localzzbbi), zzbbn.zzeah);
  }

  public final void onConnectionSuspended(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzwb
 * JD-Core Version:    0.6.2
 */