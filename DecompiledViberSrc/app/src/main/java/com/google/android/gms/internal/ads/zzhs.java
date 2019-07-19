package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

class zzhs
{
  private int zzafv;
  protected AudioTrack zzagg;
  private boolean zzahf;
  private long zzahg;
  private long zzahh;
  private long zzahi;

  public void zza(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    this.zzagg = paramAudioTrack;
    this.zzahf = paramBoolean;
    this.zzahg = 0L;
    this.zzahh = 0L;
    this.zzahi = 0L;
    if (paramAudioTrack != null)
      this.zzafv = paramAudioTrack.getSampleRate();
  }

  public final boolean zzeu()
  {
    return (zzkq.SDK_INT <= 22) && (this.zzahf) && (this.zzagg.getPlayState() == 2) && (this.zzagg.getPlaybackHeadPosition() == 0);
  }

  public final long zzev()
  {
    long l = 0xFFFFFFFF & this.zzagg.getPlaybackHeadPosition();
    if ((zzkq.SDK_INT <= 22) && (this.zzahf))
    {
      if (this.zzagg.getPlayState() != 1)
        break label85;
      this.zzahg = l;
    }
    while (true)
    {
      l += this.zzahi;
      if (this.zzahg > l)
        this.zzahh = (1L + this.zzahh);
      this.zzahg = l;
      return l + (this.zzahh << 32);
      label85: if ((this.zzagg.getPlayState() == 2) && (l == 0L))
        this.zzahi = this.zzahg;
    }
  }

  public final long zzew()
  {
    return 1000000L * zzev() / this.zzafv;
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzhs
 * JD-Core Version:    0.6.2
 */