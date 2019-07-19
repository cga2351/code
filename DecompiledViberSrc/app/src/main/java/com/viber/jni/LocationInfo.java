package com.viber.jni;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR = new Parcelable.Creator()
  {
    public LocationInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LocationInfo(paramAnonymousParcel);
    }

    public LocationInfo[] newArray(int paramAnonymousInt)
    {
      return new LocationInfo[paramAnonymousInt];
    }
  };
  private final int latitude;
  private final int longitude;

  public LocationInfo(int paramInt1, int paramInt2)
  {
    this.latitude = paramInt1;
    this.longitude = paramInt2;
  }

  public LocationInfo(Parcel paramParcel)
  {
    this.latitude = paramParcel.readInt();
    this.longitude = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationInfo localLocationInfo;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationInfo = (LocationInfo)paramObject;
      if (this.latitude != localLocationInfo.latitude)
        return false;
    }
    while (this.longitude == localLocationInfo.longitude);
    return false;
  }

  public double getLatitude()
  {
    return this.latitude / 10000000.0D;
  }

  public double getLongitude()
  {
    return this.longitude / 10000000.0D;
  }

  public int getNativeLatitude()
  {
    return this.latitude;
  }

  public int getNativeLongitude()
  {
    return this.longitude;
  }

  public boolean isZero()
  {
    return (this.latitude == 0) && (this.longitude == 0);
  }

  public double lat()
  {
    return getLatitude();
  }

  public double lng()
  {
    return getLongitude();
  }

  public String toString()
  {
    return "LocationInfo [lat:" + lat() + "; lng:" + lng() + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.latitude);
    paramParcel.writeInt(this.longitude);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.LocationInfo
 * JD-Core Version:    0.6.2
 */