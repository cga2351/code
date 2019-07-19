package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.r;

public final class PrivateCommand extends SpliceCommand
{
  public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator()
  {
    public PrivateCommand a(Parcel paramAnonymousParcel)
    {
      return new PrivateCommand(paramAnonymousParcel, null);
    }

    public PrivateCommand[] a(int paramAnonymousInt)
    {
      return new PrivateCommand[paramAnonymousInt];
    }
  };
  public final byte[] commandBytes;
  public final long identifier;
  public final long ptsAdjustment;

  private PrivateCommand(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.ptsAdjustment = paramLong2;
    this.identifier = paramLong1;
    this.commandBytes = paramArrayOfByte;
  }

  private PrivateCommand(Parcel paramParcel)
  {
    this.ptsAdjustment = paramParcel.readLong();
    this.identifier = paramParcel.readLong();
    this.commandBytes = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.commandBytes);
  }

  static PrivateCommand parseFromSection(r paramr, int paramInt, long paramLong)
  {
    long l = paramr.n();
    byte[] arrayOfByte = new byte[paramInt - 4];
    paramr.a(arrayOfByte, 0, arrayOfByte.length);
    return new PrivateCommand(l, arrayOfByte, paramLong);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.ptsAdjustment);
    paramParcel.writeLong(this.identifier);
    paramParcel.writeInt(this.commandBytes.length);
    paramParcel.writeByteArray(this.commandBytes);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.PrivateCommand
 * JD-Core Version:    0.6.2
 */