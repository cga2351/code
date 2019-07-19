package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

final class zzhr extends Thread
{
  zzhr(zzhq paramzzhq, AudioTrack paramAudioTrack)
  {
  }

  public final void run()
  {
    try
    {
      this.zzahd.release();
      return;
    }
    finally
    {
      zzhq.zza(this.zzahe).open();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzhr
 * JD-Core Version:    0.6.2
 */