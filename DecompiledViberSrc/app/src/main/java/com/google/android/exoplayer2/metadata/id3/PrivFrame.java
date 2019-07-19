package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame
{
  public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator()
  {
    public PrivFrame a(Parcel paramAnonymousParcel)
    {
      return new PrivFrame(paramAnonymousParcel);
    }

    public PrivFrame[] a(int paramAnonymousInt)
    {
      return new PrivFrame[paramAnonymousInt];
    }
  };
  public static final String ID = "PRIV";
  public final String owner;
  public final byte[] privateData;

  PrivFrame(Parcel paramParcel)
  {
    super("PRIV");
    this.owner = ((String)ag.a(paramParcel.readString()));
    this.privateData = ((byte[])ag.a(paramParcel.createByteArray()));
  }

  public PrivFrame(String paramString, byte[] paramArrayOfByte)
  {
    super("PRIV");
    this.owner = paramString;
    this.privateData = paramArrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PrivFrame localPrivFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localPrivFrame = (PrivFrame)paramObject;
    }
    while ((ag.a(this.owner, localPrivFrame.owner)) && (Arrays.equals(this.privateData, localPrivFrame.privateData)));
    return false;
  }

  public int hashCode()
  {
    if (this.owner != null);
    for (int i = this.owner.hashCode(); ; i = 0)
      return 31 * (i + 527) + Arrays.hashCode(this.privateData);
  }

  public String toString()
  {
    return this.id + ": owner=" + this.owner;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.owner);
    paramParcel.writeByteArray(this.privateData);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.PrivFrame
 * JD-Core Version:    0.6.2
 */