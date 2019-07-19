package com.viber.voip.flatbuffers.model.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class UnsignedLong extends Number
  implements Parcelable
{
  public static final Parcelable.Creator<UnsignedLong> CREATOR = new Parcelable.Creator()
  {
    public UnsignedLong a(Parcel paramAnonymousParcel)
    {
      return new UnsignedLong(paramAnonymousParcel);
    }

    public UnsignedLong[] a(int paramAnonymousInt)
    {
      return new UnsignedLong[paramAnonymousInt];
    }
  };
  public static final long MAX_VALUE = 9223372036854775807L;
  public static final long MIN_VALUE;
  private volatile long mValue;

  public UnsignedLong(long paramLong)
  {
    if (paramLong < 0L)
      paramLong = 0L;
    this.mValue = paramLong;
  }

  UnsignedLong(Parcel paramParcel)
  {
    this.mValue = paramParcel.readLong();
  }

  public long decrement()
  {
    long l = 0L;
    if (this.mValue > l)
      l = this.mValue - 1L;
    this.mValue = l;
    return this.mValue;
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
    return ((paramObject instanceof UnsignedLong)) && (((UnsignedLong)paramObject).mValue == this.mValue);
  }

  public float floatValue()
  {
    return (float)this.mValue;
  }

  public long get()
  {
    return this.mValue;
  }

  public int hashCode()
  {
    return (int)(this.mValue ^ this.mValue >>> 32);
  }

  public long increment()
  {
    long l = 9223372036854775807L;
    if (this.mValue < l)
      l = 1L + this.mValue;
    this.mValue = l;
    return this.mValue;
  }

  public int intValue()
  {
    return (int)this.mValue;
  }

  public long longValue()
  {
    return this.mValue;
  }

  public String toString()
  {
    return Long.toString(this.mValue);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mValue);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.util.UnsignedLong
 * JD-Core Version:    0.6.2
 */