package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzl;

final class zzr
  implements Runnable
{
  zzr(WearableListenerService.zzd paramzzd, zzl paramzzl)
  {
  }

  public final void run()
  {
    this.zzao.zzak.onNotificationReceived(this.zzat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.zzr
 * JD-Core Version:    0.6.2
 */