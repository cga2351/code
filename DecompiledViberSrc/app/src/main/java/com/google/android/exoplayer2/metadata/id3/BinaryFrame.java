package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame
{
  public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator()
  {
    public BinaryFrame a(Parcel paramAnonymousParcel)
    {
      return new BinaryFrame(paramAnonymousParcel);
    }

    public BinaryFrame[] a(int paramAnonymousInt)
    {
      return new BinaryFrame[paramAnonymousInt];
    }
  };
  public final byte[] data;

  BinaryFrame(Parcel paramParcel)
  {
    super((String)ag.a(paramParcel.readString()));
    this.data = ((byte[])ag.a(paramParcel.createByteArray()));
  }

  public BinaryFrame(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString);
    this.data = paramArrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    BinaryFrame localBinaryFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localBinaryFrame = (BinaryFrame)paramObject;
    }
    while ((this.id.equals(localBinaryFrame.id)) && (Arrays.equals(this.data, localBinaryFrame.data)));
    return false;
  }

  public int hashCode()
  {
    return 31 * (527 + this.id.hashCode()) + Arrays.hashCode(this.data);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeByteArray(this.data);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.BinaryFrame
 * JD-Core Version:    0.6.2
 */