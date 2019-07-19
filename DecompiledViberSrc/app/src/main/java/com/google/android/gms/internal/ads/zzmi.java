package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

final class zzmi extends Thread
{
  zzmi(zzmh paramzzmh, AudioTrack paramAudioTrack)
  {
  }

  public final void run()
  {
    try
    {
      this.zzahd.flush();
      this.zzahd.release();
      return;
    }
    finally
    {
      zzmh.zza(this.zzaxb).open();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmi
 * JD-Core Version:    0.6.2
 */