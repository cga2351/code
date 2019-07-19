package com.viber.voip;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Resolution
  implements Parcelable
{
  public static final Parcelable.Creator<Resolution> CREATOR = new Parcelable.Creator()
  {
    public Resolution a(Parcel paramAnonymousParcel)
    {
      return new Resolution(paramAnonymousParcel);
    }

    public Resolution[] a(int paramAnonymousInt)
    {
      return new Resolution[paramAnonymousInt];
    }
  };
  public final int bitrateConstraint;
  public final int height;
  public final int width;

  public Resolution(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 2147483647);
  }

  public Resolution(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.bitrateConstraint = paramInt3;
  }

  public Resolution(Parcel paramParcel)
  {
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.bitrateConstraint = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Resolution)) && (hashCode() == paramObject.hashCode());
  }

  public final double getAspectRatio()
  {
    return 1.0D * this.width / this.height;
  }

  public final int getBitrateConstraint()
  {
    return this.bitrateConstraint;
  }

  public final int hashCode()
  {
    return this.width * this.height;
  }

  public final boolean isMult16()
  {
    return (this.width * this.height > 0) && (this.width % 16 == 0) && (this.height % 16 == 0);
  }

  public Resolution rotate(int paramInt)
  {
    if ((90 == paramInt) || (180 == paramInt))
      this = new Resolution(this.height, this.width);
    return this;
  }

  public final String toString()
  {
    return this.width + "x" + this.height;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.bitrateConstraint);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.Resolution
 * JD-Core Version:    0.6.2
 */