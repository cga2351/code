package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
final class zzht extends zzhs
{
  private final AudioTimestamp zzahj = new AudioTimestamp();
  private long zzahk;
  private long zzahl;
  private long zzahm;

  public zzht()
  {
    super(null);
  }

  public final void zza(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    super.zza(paramAudioTrack, paramBoolean);
    this.zzahk = 0L;
    this.zzahl = 0L;
    this.zzahm = 0L;
  }

  public final boolean zzex()
  {
    boolean bool = this.zzagg.getTimestamp(this.zzahj);
    if (bool)
    {
      long l = this.zzahj.framePosition;
      if (this.zzahl > l)
        this.zzahk = (1L + this.zzahk);
      this.zzahl = l;
      this.zzahm = (l + (this.zzahk << 32));
    }
    return bool;
  }

  public final long zzey()
  {
    return this.zzahj.nanoTime;
  }

  public final long zzez()
  {
    return this.zzahm;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzht
 * JD-Core Version:    0.6.2
 */