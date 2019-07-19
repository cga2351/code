package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class Metadata
  implements Parcelable
{
  public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator()
  {
    public Metadata a(Parcel paramAnonymousParcel)
    {
      return new Metadata(paramAnonymousParcel);
    }

    public Metadata[] a(int paramAnonymousInt)
    {
      return new Metadata[0];
    }
  };
  private final Entry[] entries;

  Metadata(Parcel paramParcel)
  {
    this.entries = new Entry[paramParcel.readInt()];
    for (int i = 0; i < this.entries.length; i++)
      this.entries[i] = ((Entry)paramParcel.readParcelable(Entry.class.getClassLoader()));
  }

  public Metadata(List<? extends Entry> paramList)
  {
    if (paramList != null)
    {
      this.entries = new Entry[paramList.size()];
      paramList.toArray(this.entries);
      return;
    }
    this.entries = new Entry[0];
  }

  public Metadata(Entry[] paramArrayOfEntry)
  {
    if (paramArrayOfEntry == null)
      paramArrayOfEntry = new Entry[0];
    this.entries = paramArrayOfEntry;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    Metadata localMetadata = (Metadata)paramObject;
    return Arrays.equals(this.entries, localMetadata.entries);
  }

  public Entry get(int paramInt)
  {
    return this.entries[paramInt];
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.entries);
  }

  public int length()
  {
    return this.entries.length;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.entries.length);
    Entry[] arrayOfEntry = this.entries;
    int i = arrayOfEntry.length;
    for (int j = 0; j < i; j++)
      paramParcel.writeParcelable(arrayOfEntry[j], 0);
  }

  public static abstract interface Entry extends Parcelable
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.Metadata
 * JD-Core Version:    0.6.2
 */