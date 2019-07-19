package com.viber.voip.flatbuffers.model.msginfo.keyboard;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class PickerLocation
  implements Parcelable
{
  public static final Parcelable.Creator<PickerLocation> CREATOR = new Parcelable.Creator()
  {
    public PickerLocation a(Parcel paramAnonymousParcel)
    {
      return new PickerLocation(paramAnonymousParcel);
    }

    public PickerLocation[] a(int paramAnonymousInt)
    {
      return new PickerLocation[paramAnonymousInt];
    }
  };

  @c(a="address")
  private String mAddress;

  @c(a="lat")
  private String mLat;

  @c(a="lon")
  private String mLon;

  public PickerLocation()
  {
  }

  protected PickerLocation(Parcel paramParcel)
  {
    this.mLat = paramParcel.readString();
    this.mLon = paramParcel.readString();
    this.mAddress = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    PickerLocation localPickerLocation;
    boolean bool3;
    do
    {
      boolean bool4;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool2;
            bool2 = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool2 = false;
        }
        while (localClass1 != localClass2);
        localPickerLocation = (PickerLocation)paramObject;
        if (getLat() == null)
          break;
        bool4 = getLat().equals(localPickerLocation.getLat());
        bool2 = false;
      }
      while (!bool4);
      if (getLon() == null)
        break label132;
      bool3 = getLon().equals(localPickerLocation.getLon());
      bool2 = false;
    }
    while (!bool3);
    label100: if (getAddress() != null)
      bool1 = getAddress().equals(localPickerLocation.getAddress());
    while (true)
    {
      return bool1;
      if (localPickerLocation.getLat() == null)
        break;
      return false;
      label132: if (localPickerLocation.getLon() == null)
        break label100;
      return false;
      if (localPickerLocation.getAddress() != null)
        bool1 = false;
    }
  }

  public String getAddress()
  {
    return this.mAddress;
  }

  public String getLat()
  {
    return this.mLat;
  }

  public String getLon()
  {
    return this.mLon;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (getLat() != null)
    {
      i = getLat().hashCode();
      j = i * 31;
      if (getLon() == null)
        break label77;
    }
    label77: for (int k = getLon().hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      String str = getAddress();
      int n = 0;
      if (str != null)
        n = getAddress().hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public void setAddress(String paramString)
  {
    this.mAddress = paramString;
  }

  public void setLat(double paramDouble)
  {
    this.mLat = String.valueOf(paramDouble);
  }

  public void setLat(String paramString)
  {
    this.mLat = paramString;
  }

  public void setLon(double paramDouble)
  {
    this.mLon = String.valueOf(paramDouble);
  }

  public void setLon(String paramString)
  {
    this.mLon = paramString;
  }

  public String toString()
  {
    return "PickerLocation{mLat='" + this.mLat + '\'' + ", mLon='" + this.mLon + '\'' + ", mAddress='" + this.mAddress + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mLat);
    paramParcel.writeString(this.mLon);
    paramParcel.writeString(this.mAddress);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.keyboard.PickerLocation
 * JD-Core Version:    0.6.2
 */