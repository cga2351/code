package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import java.util.Arrays;

public final class TrackGroup
  implements Parcelable
{
  public static final Parcelable.Creator<TrackGroup> CREATOR = new Parcelable.Creator()
  {
    public TrackGroup a(Parcel paramAnonymousParcel)
    {
      return new TrackGroup(paramAnonymousParcel);
    }

    public TrackGroup[] a(int paramAnonymousInt)
    {
      return new TrackGroup[paramAnonymousInt];
    }
  };
  private final Format[] formats;
  private int hashCode;
  public final int length;

  TrackGroup(Parcel paramParcel)
  {
    this.length = paramParcel.readInt();
    this.formats = new Format[this.length];
    for (int i = 0; i < this.length; i++)
      this.formats[i] = ((Format)paramParcel.readParcelable(Format.class.getClassLoader()));
  }

  public TrackGroup(Format[] paramArrayOfFormat)
  {
    if (paramArrayOfFormat.length > 0);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.formats = paramArrayOfFormat;
      this.length = paramArrayOfFormat.length;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TrackGroup localTrackGroup;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTrackGroup = (TrackGroup)paramObject;
    }
    while ((this.length == localTrackGroup.length) && (Arrays.equals(this.formats, localTrackGroup.formats)));
    return false;
  }

  public Format getFormat(int paramInt)
  {
    return this.formats[paramInt];
  }

  public int hashCode()
  {
    if (this.hashCode == 0)
      this.hashCode = (527 + Arrays.hashCode(this.formats));
    return this.hashCode;
  }

  public int indexOf(Format paramFormat)
  {
    for (int i = 0; i < this.formats.length; i++)
      if (paramFormat == this.formats[i])
        return i;
    return -1;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.length);
    for (int i = 0; i < this.length; i++)
      paramParcel.writeParcelable(this.formats[i], 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.TrackGroup
 * JD-Core Version:    0.6.2
 */