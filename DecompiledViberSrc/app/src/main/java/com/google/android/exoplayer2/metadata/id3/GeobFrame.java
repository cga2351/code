package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame
{
  public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator()
  {
    public GeobFrame a(Parcel paramAnonymousParcel)
    {
      return new GeobFrame(paramAnonymousParcel);
    }

    public GeobFrame[] a(int paramAnonymousInt)
    {
      return new GeobFrame[paramAnonymousInt];
    }
  };
  public static final String ID = "GEOB";
  public final byte[] data;
  public final String description;
  public final String filename;
  public final String mimeType;

  GeobFrame(Parcel paramParcel)
  {
    super("GEOB");
    this.mimeType = ((String)ag.a(paramParcel.readString()));
    this.filename = ((String)ag.a(paramParcel.readString()));
    this.description = ((String)ag.a(paramParcel.readString()));
    this.data = ((byte[])ag.a(paramParcel.createByteArray()));
  }

  public GeobFrame(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    super("GEOB");
    this.mimeType = paramString1;
    this.filename = paramString2;
    this.description = paramString3;
    this.data = paramArrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    GeobFrame localGeobFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localGeobFrame = (GeobFrame)paramObject;
    }
    while ((ag.a(this.mimeType, localGeobFrame.mimeType)) && (ag.a(this.filename, localGeobFrame.filename)) && (ag.a(this.description, localGeobFrame.description)) && (Arrays.equals(this.data, localGeobFrame.data)));
    return false;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.mimeType != null)
    {
      i = this.mimeType.hashCode();
      j = 31 * (i + 527);
      if (this.filename == null)
        break label92;
    }
    label92: for (int k = this.filename.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      String str = this.description;
      int n = 0;
      if (str != null)
        n = this.description.hashCode();
      return 31 * (m + n) + Arrays.hashCode(this.data);
      i = 0;
      break;
    }
  }

  public String toString()
  {
    return this.id + ": mimeType=" + this.mimeType + ", filename=" + this.filename + ", description=" + this.description;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.filename);
    paramParcel.writeString(this.description);
    paramParcel.writeByteArray(this.data);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.GeobFrame
 * JD-Core Version:    0.6.2
 */