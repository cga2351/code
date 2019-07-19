package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class Map
  implements Parcelable
{
  public static final Parcelable.Creator<Map> CREATOR = new Parcelable.Creator()
  {
    public Map a(Parcel paramAnonymousParcel)
    {
      return new Map(paramAnonymousParcel);
    }

    public Map[] a(int paramAnonymousInt)
    {
      return new Map[paramAnonymousInt];
    }
  };

  @c(a="Latitude")
  private Double mLatitude;

  @c(a="Longitude")
  private Double mLongitude;

  public Map()
  {
  }

  protected Map(Parcel paramParcel)
  {
    this.mLatitude = Double.valueOf(paramParcel.readDouble());
    this.mLongitude = Double.valueOf(paramParcel.readDouble());
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Map localMap;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMap = (Map)paramObject;
      if (this.mLatitude != null)
      {
        if (this.mLatitude.equals(localMap.mLatitude));
      }
      else
        while (localMap.mLatitude != null)
          return false;
      if (this.mLongitude != null)
        return this.mLongitude.equals(localMap.mLongitude);
    }
    while (localMap.mLongitude == null);
    return false;
  }

  public Double getLatitude()
  {
    return this.mLatitude;
  }

  public Double getLongitude()
  {
    return this.mLongitude;
  }

  public int hashCode()
  {
    if (this.mLatitude != null);
    for (int i = this.mLatitude.hashCode(); ; i = 0)
    {
      int j = i * 31;
      Double localDouble = this.mLongitude;
      int k = 0;
      if (localDouble != null)
        k = this.mLongitude.hashCode();
      return j + k;
    }
  }

  public void setLatitude(Double paramDouble)
  {
    this.mLatitude = paramDouble;
  }

  public void setLongitude(Double paramDouble)
  {
    this.mLongitude = paramDouble;
  }

  public String toString()
  {
    return "Map{mLatitude='" + this.mLatitude + '\'' + ", mLongitude='" + this.mLongitude + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.mLatitude.doubleValue());
    paramParcel.writeDouble(this.mLongitude.doubleValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Map
 * JD-Core Version:    0.6.2
 */