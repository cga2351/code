package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

final class zzail
  implements BaseGmsClient.BaseConnectionCallbacks
{
  zzail(zzaih paramzzaih, zzbbs paramzzbbs)
  {
  }

  public final void onConnected(Bundle paramBundle)
  {
    try
    {
      this.zzbxd.set(zzaih.zzb(this.zzdaz).zzrs());
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.zzbxd.setException(localDeadObjectException);
    }
  }

  public final void onConnectionSuspended(int paramInt)
  {
    this.zzbxd.setException(new RuntimeException(34 + "onConnectionSuspended: " + paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzail
 * JD-Core Version:    0.6.2
 */