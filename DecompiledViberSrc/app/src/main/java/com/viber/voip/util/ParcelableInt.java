package com.viber.voip.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableInt
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableInt> CREATOR = new Parcelable.Creator()
  {
    public ParcelableInt a(Parcel paramAnonymousParcel)
    {
      return new ParcelableInt(paramAnonymousParcel, null);
    }

    public ParcelableInt[] a(int paramAnonymousInt)
    {
      return new ParcelableInt[paramAnonymousInt];
    }
  };
  private final int mValue;

  public ParcelableInt(int paramInt)
  {
    this.mValue = paramInt;
  }

  private ParcelableInt(Parcel paramParcel)
  {
    this.mValue = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public int getValue()
  {
    return this.mValue;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mValue);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ParcelableInt
 * JD-Core Version:    0.6.2
 */