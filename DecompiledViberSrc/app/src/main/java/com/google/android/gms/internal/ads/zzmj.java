package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

class zzmj
{
  private int zzafv;
  protected AudioTrack zzagg;
  private long zzahg;
  private long zzahh;
  private long zzahi;
  private boolean zzaxc;
  private long zzaxd;
  private long zzaxe;
  private long zzaxf;

  public final void pause()
  {
    if (this.zzaxd != -9223372036854775807L)
      return;
    this.zzagg.pause();
  }

  public void zza(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    this.zzagg = paramAudioTrack;
    this.zzaxc = paramBoolean;
    this.zzaxd = -9223372036854775807L;
    this.zzahg = 0L;
    this.zzahh = 0L;
    this.zzahi = 0L;
    if (paramAudioTrack != null)
      this.zzafv = paramAudioTrack.getSampleRate();
  }

  public final long zzdv()
  {
    return 1000000L * zzev() / this.zzafv;
  }

  public final void zzeh(long paramLong)
  {
    this.zzaxe = zzev();
    this.zzaxd = (1000L * SystemClock.elapsedRealtime());
    this.zzaxf = paramLong;
    this.zzagg.stop();
  }

  public final long zzev()
  {
    if (this.zzaxd != -9223372036854775807L)
    {
      long l2 = (1000L * SystemClock.elapsedRealtime() - this.zzaxd) * this.zzafv / 1000000L;
      return Math.min(this.zzaxf, l2 + this.zzaxe);
    }
    int i = this.zzagg.getPlayState();
    if (i == 1)
      return 0L;
    long l1 = 0xFFFFFFFF & this.zzagg.getPlaybackHeadPosition();
    if (this.zzaxc)
    {
      if ((i == 2) && (l1 == 0L))
        this.zzahi = this.zzahg;
      l1 += this.zzahi;
    }
    if (this.zzahg > l1)
      this.zzahh = (1L + this.zzahh);
    this.zzahg = l1;
    return l1 + (this.zzahh << 32);
  }

  public boolean zzex()
  {
    return false;
  }

  public long zzey()
  {
    throw new UnsupportedOperationException();
  }

  public long zzez()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmj
 * JD-Core Version:    0.6.2
 */