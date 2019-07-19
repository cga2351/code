package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

final class zzaim
  implements BaseGmsClient.BaseOnConnectionFailedListener
{
  zzaim(zzaih paramzzaih, zzbbs paramzzbbs)
  {
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzbxd.setException(new RuntimeException("Connection failed."));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaim
 * JD-Core Version:    0.6.2
 */