package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzah;

final class zzq
  implements Runnable
{
  zzq(WearableListenerService.zzd paramzzd, zzah paramzzah)
  {
  }

  public final void run()
  {
    this.zzao.zzak.onCapabilityChanged(this.zzas);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.zzq
 * JD-Core Version:    0.6.2
 */