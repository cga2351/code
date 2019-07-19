package com.viber.voip.flatbuffers.model.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class UnsignedInt extends Number
  implements Parcelable
{
  public static final Parcelable.Creator<UnsignedInt> CREATOR = new Parcelable.Creator()
  {
    public UnsignedInt a(Parcel paramAnonymousParcel)
    {
      return new UnsignedInt(paramAnonymousParcel);
    }

    public UnsignedInt[] a(int paramAnonymousInt)
    {
      return new UnsignedInt[paramAnonymousInt];
    }
  };
  public static final int MAX_VALUE = 2147483647;
  public static final int MIN_VALUE;
  private volatile int mValue;

  public UnsignedInt(int paramInt)
  {
    if (paramInt < 0)
      paramInt = 0;
    this.mValue = paramInt;
  }

  UnsignedInt(Parcel paramParcel)
  {
    this.mValue = paramParcel.readInt();
  }

  public int decrement()
  {
    if (this.mValue > 0);
    for (int i = -1 + this.mValue; ; i = 0)
    {
      this.mValue = i;
      return this.mValue;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public double doubleValue()
  {
    return this.mValue;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof UnsignedInt)) && (((UnsignedInt)paramObject).mValue == this.mValue);
  }

  public float floatValue()
  {
    return this.mValue;
  }

  public int get()
  {
    return this.mValue;
  }

  public int hashCode()
  {
    return this.mValue;
  }

  public int increment()
  {
    int i = 2147483647;
    if (this.mValue < i)
      i = 1 + this.mValue;
    this.mValue = i;
    return this.mValue;
  }

  public int intValue()
  {
    return this.mValue;
  }

  public long longValue()
  {
    return this.mValue;
  }

  public String toString()
  {
    return Integer.toString(this.mValue);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mValue);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.util.UnsignedInt
 * JD-Core Version:    0.6.2
 */