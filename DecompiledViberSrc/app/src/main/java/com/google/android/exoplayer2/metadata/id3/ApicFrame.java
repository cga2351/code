package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame
{
  public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator()
  {
    public ApicFrame a(Parcel paramAnonymousParcel)
    {
      return new ApicFrame(paramAnonymousParcel);
    }

    public ApicFrame[] a(int paramAnonymousInt)
    {
      return new ApicFrame[paramAnonymousInt];
    }
  };
  public static final String ID = "APIC";
  public final String description;
  public final String mimeType;
  public final byte[] pictureData;
  public final int pictureType;

  ApicFrame(Parcel paramParcel)
  {
    super("APIC");
    this.mimeType = ((String)ag.a(paramParcel.readString()));
    this.description = ((String)ag.a(paramParcel.readString()));
    this.pictureType = paramParcel.readInt();
    this.pictureData = ((byte[])ag.a(paramParcel.createByteArray()));
  }

  public ApicFrame(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    super("APIC");
    this.mimeType = paramString1;
    this.description = paramString2;
    this.pictureType = paramInt;
    this.pictureData = paramArrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ApicFrame localApicFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localApicFrame = (ApicFrame)paramObject;
    }
    while ((this.pictureType == localApicFrame.pictureType) && (ag.a(this.mimeType, localApicFrame.mimeType)) && (ag.a(this.description, localApicFrame.description)) && (Arrays.equals(this.pictureData, localApicFrame.pictureData)));
    return false;
  }

  public int hashCode()
  {
    int i = 31 * (527 + this.pictureType);
    if (this.mimeType != null);
    for (int j = this.mimeType.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      String str = this.description;
      int m = 0;
      if (str != null)
        m = this.description.hashCode();
      return 31 * (k + m) + Arrays.hashCode(this.pictureData);
    }
  }

  public String toString()
  {
    return this.id + ": mimeType=" + this.mimeType + ", description=" + this.description;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.pictureType);
    paramParcel.writeByteArray(this.pictureData);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ApicFrame
 * JD-Core Version:    0.6.2
 */