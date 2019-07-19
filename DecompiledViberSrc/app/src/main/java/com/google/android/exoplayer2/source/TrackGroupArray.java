package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class TrackGroupArray
  implements Parcelable
{
  public static final Parcelable.Creator<TrackGroupArray> CREATOR = new Parcelable.Creator()
  {
    public TrackGroupArray a(Parcel paramAnonymousParcel)
    {
      return new TrackGroupArray(paramAnonymousParcel);
    }

    public TrackGroupArray[] a(int paramAnonymousInt)
    {
      return new TrackGroupArray[paramAnonymousInt];
    }
  };
  public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
  private int hashCode;
  public final int length;
  private final TrackGroup[] trackGroups;

  TrackGroupArray(Parcel paramParcel)
  {
    this.length = paramParcel.readInt();
    this.trackGroups = new TrackGroup[this.length];
    for (int i = 0; i < this.length; i++)
      this.trackGroups[i] = ((TrackGroup)paramParcel.readParcelable(TrackGroup.class.getClassLoader()));
  }

  public TrackGroupArray(TrackGroup[] paramArrayOfTrackGroup)
  {
    this.trackGroups = paramArrayOfTrackGroup;
    this.length = paramArrayOfTrackGroup.length;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TrackGroupArray localTrackGroupArray;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTrackGroupArray = (TrackGroupArray)paramObject;
    }
    while ((this.length == localTrackGroupArray.length) && (Arrays.equals(this.trackGroups, localTrackGroupArray.trackGroups)));
    return false;
  }

  public TrackGroup get(int paramInt)
  {
    return this.trackGroups[paramInt];
  }

  public int hashCode()
  {
    if (this.hashCode == 0)
      this.hashCode = Arrays.hashCode(this.trackGroups);
    return this.hashCode;
  }

  public int indexOf(TrackGroup paramTrackGroup)
  {
    for (int i = 0; i < this.length; i++)
      if (this.trackGroups[i] == paramTrackGroup)
        return i;
    return -1;
  }

  public boolean isEmpty()
  {
    return this.length == 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.length);
    for (int i = 0; i < this.length; i++)
      paramParcel.writeParcelable(this.trackGroups[i], 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.TrackGroupArray
 * JD-Core Version:    0.6.2
 */