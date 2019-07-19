package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

final class zzvp
  implements BaseGmsClient.BaseOnConnectionFailedListener
{
  zzvp(zzvl paramzzvl)
  {
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    synchronized (zzvl.zzc(this.zzbwr))
    {
      zzvl.zza(this.zzbwr, null);
      if (zzvl.zzd(this.zzbwr) != null)
        zzvl.zza(this.zzbwr, null);
      zzvl.zzc(this.zzbwr).notifyAll();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvp
 * JD-Core Version:    0.6.2
 */