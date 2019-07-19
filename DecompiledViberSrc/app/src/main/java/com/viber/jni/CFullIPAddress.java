package com.viber.jni;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CFullIPAddress
  implements Parcelable
{
  public static final Parcelable.Creator<CFullIPAddress> CREATOR = new Parcelable.Creator()
  {
    public CFullIPAddress createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CFullIPAddress(paramAnonymousParcel);
    }

    public CFullIPAddress[] newArray(int paramAnonymousInt)
    {
      return new CFullIPAddress[paramAnonymousInt];
    }
  };
  private final String ipAdress;

  public CFullIPAddress(Parcel paramParcel)
  {
    this.ipAdress = paramParcel.readString();
  }

  public CFullIPAddress(String paramString)
  {
    this.ipAdress = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getIpAdress()
  {
    return this.ipAdress;
  }

  public String toString()
  {
    return "CFullIPAddress [ipAdress=" + this.ipAdress + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ipAdress);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CFullIPAddress
 * JD-Core Version:    0.6.2
 */