package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class SpliceNullCommand extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceNullCommand> CREATOR = new Parcelable.Creator()
  {
    public SpliceNullCommand a(Parcel paramAnonymousParcel)
    {
      return new SpliceNullCommand();
    }

    public SpliceNullCommand[] a(int paramAnonymousInt)
    {
      return new SpliceNullCommand[paramAnonymousInt];
    }
  };

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand
 * JD-Core Version:    0.6.2
 */