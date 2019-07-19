package com.google.android.exoplayer2.extractor.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import java.util.Arrays;

public final class MdtaMetadataEntry
  implements Metadata.Entry
{
  public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new Parcelable.Creator()
  {
    public MdtaMetadataEntry a(Parcel paramAnonymousParcel)
    {
      return new MdtaMetadataEntry(paramAnonymousParcel, null);
    }

    public MdtaMetadataEntry[] a(int paramAnonymousInt)
    {
      return new MdtaMetadataEntry[paramAnonymousInt];
    }
  };
  public final String key;
  public final int localeIndicator;
  public final int typeIndicator;
  public final byte[] value;

  private MdtaMetadataEntry(Parcel paramParcel)
  {
    this.key = ((String)ag.a(paramParcel.readString()));
    this.value = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.value);
    this.localeIndicator = paramParcel.readInt();
    this.typeIndicator = paramParcel.readInt();
  }

  public MdtaMetadataEntry(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.key = paramString;
    this.value = paramArrayOfByte;
    this.localeIndicator = paramInt1;
    this.typeIndicator = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MdtaMetadataEntry localMdtaMetadataEntry;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMdtaMetadataEntry = (MdtaMetadataEntry)paramObject;
    }
    while ((this.key.equals(localMdtaMetadataEntry.key)) && (Arrays.equals(this.value, localMdtaMetadataEntry.value)) && (this.localeIndicator == localMdtaMetadataEntry.localeIndicator) && (this.typeIndicator == localMdtaMetadataEntry.typeIndicator));
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (527 + this.key.hashCode()) + Arrays.hashCode(this.value)) + this.localeIndicator) + this.typeIndicator;
  }

  public String toString()
  {
    return "mdta: key=" + this.key;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.key);
    paramParcel.writeInt(this.value.length);
    paramParcel.writeByteArray(this.value);
    paramParcel.writeInt(this.localeIndicator);
    paramParcel.writeInt(this.typeIndicator);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry
 * JD-Core Version:    0.6.2
 */