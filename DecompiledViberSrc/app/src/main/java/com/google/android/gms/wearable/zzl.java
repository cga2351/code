package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;

final class zzl
  implements Runnable
{
  zzl(WearableListenerService.zzd paramzzd, DataHolder paramDataHolder)
  {
  }

  public final void run()
  {
    DataEventBuffer localDataEventBuffer = new DataEventBuffer(this.zzan);
    try
    {
      this.zzao.zzak.onDataChanged(localDataEventBuffer);
      return;
    }
    finally
    {
      localDataEventBuffer.release();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.zzl
 * JD-Core Version:    0.6.2
 */