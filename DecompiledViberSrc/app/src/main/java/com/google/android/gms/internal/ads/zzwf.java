package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

final class zzwf
  implements BaseGmsClient.BaseOnConnectionFailedListener
{
  zzwf(zzvz paramzzvz, zzbbs paramzzbbs)
  {
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    synchronized (zzvz.zzb(this.zzbxb))
    {
      this.zzbxd.setException(new RuntimeException("Connection failed."));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzwf
 * JD-Core Version:    0.6.2
 */