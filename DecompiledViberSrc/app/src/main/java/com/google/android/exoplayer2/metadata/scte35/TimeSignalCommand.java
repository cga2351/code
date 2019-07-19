package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.r;

public final class TimeSignalCommand extends SpliceCommand
{
  public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator()
  {
    public TimeSignalCommand a(Parcel paramAnonymousParcel)
    {
      return new TimeSignalCommand(paramAnonymousParcel.readLong(), paramAnonymousParcel.readLong(), null);
    }

    public TimeSignalCommand[] a(int paramAnonymousInt)
    {
      return new TimeSignalCommand[paramAnonymousInt];
    }
  };
  public final long playbackPositionUs;
  public final long ptsTime;

  private TimeSignalCommand(long paramLong1, long paramLong2)
  {
    this.ptsTime = paramLong1;
    this.playbackPositionUs = paramLong2;
  }

  static TimeSignalCommand parseFromSection(r paramr, long paramLong, ad paramad)
  {
    long l = parseSpliceTime(paramr, paramLong);
    return new TimeSignalCommand(l, paramad.b(l));
  }

  static long parseSpliceTime(r paramr, long paramLong)
  {
    long l1 = paramr.h();
    long l2 = -9223372036854775807L;
    if ((0x80 & l1) != 0L)
      l2 = 0xFFFFFFFF & paramLong + ((1L & l1) << 32 | paramr.n());
    return l2;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.ptsTime);
    paramParcel.writeLong(this.playbackPositionUs);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand
 * JD-Core Version:    0.6.2
 */