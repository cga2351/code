package com.viber.voip.secondary;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.jni.CSecondaryDeviceDetails.CSecondaryDeviceDetailsElement;
import com.viber.voip.util.z;

public class SecondaryDevice
  implements Parcelable
{
  public static final Parcelable.Creator<SecondaryDevice> CREATOR = new Parcelable.Creator()
  {
    public SecondaryDevice a(Parcel paramAnonymousParcel)
    {
      return new SecondaryDevice(paramAnonymousParcel);
    }

    public SecondaryDevice[] a(int paramAnonymousInt)
    {
      return new SecondaryDevice[paramAnonymousInt];
    }
  };
  private long lastLoginDate;
  private String location;
  private String locationCode;
  private String platform;
  private String platformVersion;
  private int systemId;
  private String systemName;
  private String udid;
  private String viberVersion;

  public SecondaryDevice()
  {
  }

  SecondaryDevice(Parcel paramParcel)
  {
    this.udid = paramParcel.readString();
    this.locationCode = paramParcel.readString();
    this.location = paramParcel.readString();
    this.platform = paramParcel.readString();
    this.platformVersion = paramParcel.readString();
    this.lastLoginDate = paramParcel.readLong();
    this.viberVersion = paramParcel.readString();
    this.systemId = paramParcel.readInt();
    this.systemName = paramParcel.readString();
  }

  public static SecondaryDevice valueOf(CSecondaryDeviceDetails.CSecondaryDeviceDetailsElement paramCSecondaryDeviceDetailsElement)
  {
    SecondaryDevice localSecondaryDevice = new SecondaryDevice();
    localSecondaryDevice.udid = z.a(paramCSecondaryDeviceDetailsElement.udid);
    localSecondaryDevice.locationCode = paramCSecondaryDeviceDetailsElement.location;
    localSecondaryDevice.platform = paramCSecondaryDeviceDetailsElement.osName;
    localSecondaryDevice.platformVersion = paramCSecondaryDeviceDetailsElement.osVersion;
    localSecondaryDevice.lastLoginDate = paramCSecondaryDeviceDetailsElement.lastLogin;
    localSecondaryDevice.viberVersion = paramCSecondaryDeviceDetailsElement.viberVersion;
    localSecondaryDevice.systemId = paramCSecondaryDeviceDetailsElement.system;
    localSecondaryDevice.systemName = paramCSecondaryDeviceDetailsElement.systemName;
    return localSecondaryDevice;
  }

  public int describeContents()
  {
    return 0;
  }

  public long getLastLoginDate()
  {
    return this.lastLoginDate;
  }

  public String getLocation(Context paramContext)
  {
    int i;
    if (this.location == null)
    {
      i = paramContext.getResources().getIdentifier(this.locationCode, "string", paramContext.getPackageName());
      if (i <= 0)
        break label45;
    }
    label45: for (String str = paramContext.getString(i); ; str = this.locationCode)
    {
      this.location = str;
      return this.location;
    }
  }

  public String getLocationCode()
  {
    return this.locationCode;
  }

  public String getPlatform()
  {
    return this.platform;
  }

  public String getPlatformVersion()
  {
    return this.platformVersion;
  }

  public int getSystemId()
  {
    return this.systemId;
  }

  public String getSystemName()
  {
    return this.systemName;
  }

  public String getUdid()
  {
    return this.udid;
  }

  public String getViberVersion()
  {
    return this.viberVersion;
  }

  public String toString()
  {
    return "SecondaryDevice{udid='" + this.udid + '\'' + ", locationCode='" + this.locationCode + '\'' + ", location='" + this.location + "', platform='" + this.platform + '\'' + ", platformVersion='" + this.platformVersion + "', lastLoginDate=" + this.lastLoginDate + ", viberVersion='" + this.viberVersion + "', systemId=" + this.systemId + ", systemName='" + this.systemName + "'" + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.udid);
    paramParcel.writeString(this.locationCode);
    paramParcel.writeString(this.location);
    paramParcel.writeString(this.platform);
    paramParcel.writeString(this.platformVersion);
    paramParcel.writeLong(this.lastLoginDate);
    paramParcel.writeString(this.viberVersion);
    paramParcel.writeInt(this.systemId);
    paramParcel.writeString(this.systemName);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.secondary.SecondaryDevice
 * JD-Core Version:    0.6.2
 */