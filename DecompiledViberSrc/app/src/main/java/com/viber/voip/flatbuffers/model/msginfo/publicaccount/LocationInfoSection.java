package com.viber.voip.flatbuffers.model.msginfo.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public final class LocationInfoSection
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfoSection> CREATOR = new Parcelable.Creator()
  {
    public LocationInfoSection a(Parcel paramAnonymousParcel)
    {
      return new LocationInfoSection(paramAnonymousParcel, null);
    }

    public LocationInfoSection[] a(int paramAnonymousInt)
    {
      return new LocationInfoSection[paramAnonymousInt];
    }
  };

  @c(a="lat")
  private double mLat;

  @c(a="lon")
  private double mLon;

  public LocationInfoSection()
  {
  }

  private LocationInfoSection(Parcel paramParcel)
  {
    this.mLat = paramParcel.readDouble();
    this.mLon = paramParcel.readDouble();
  }

  public int describeContents()
  {
    return 0;
  }

  public double getLat()
  {
    return this.mLat;
  }

  public double getLon()
  {
    return this.mLon;
  }

  public void setLat(Double paramDouble)
  {
    this.mLat = paramDouble.doubleValue();
  }

  public void setLon(Double paramDouble)
  {
    this.mLon = paramDouble.doubleValue();
  }

  public String toString()
  {
    return "LocationInfoSection{mLat=" + this.mLat + ", mLon=" + this.mLon + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.mLat);
    paramParcel.writeDouble(this.mLon);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.LocationInfoSection
 * JD-Core Version:    0.6.2
 */