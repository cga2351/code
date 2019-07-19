package com.viber.voip.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IntPair
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public IntPair a(Parcel paramAnonymousParcel)
    {
      return new IntPair(paramAnonymousParcel);
    }

    public IntPair[] a(int paramAnonymousInt)
    {
      return new IntPair[paramAnonymousInt];
    }
  };
  public int first;
  public int second;

  public IntPair(int paramInt1, int paramInt2)
  {
    this.first = paramInt1;
    this.second = paramInt2;
  }

  public IntPair(Parcel paramParcel)
  {
    this.first = paramParcel.readInt();
    this.second = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.first);
    paramParcel.writeInt(this.second);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.IntPair
 * JD-Core Version:    0.6.2
 */