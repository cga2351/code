package com.viber.jni;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

@Deprecated
public class CAddressBookInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CAddressBookInfo> CREATOR = new Parcelable.Creator()
  {
    public CAddressBookInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CAddressBookInfo(paramAnonymousParcel);
    }

    public CAddressBookInfo[] newArray(int paramAnonymousInt)
    {
      return new CAddressBookInfo[paramAnonymousInt];
    }
  };
  private final long _id;
  private final String clientName;
  private final String[] clientPhones;
  private final String clientSortName;

  public CAddressBookInfo(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    this.clientName = paramString1;
    this.clientPhones = paramArrayOfString;
    this.clientSortName = paramString2;
    this._id = paramLong;
  }

  public CAddressBookInfo(Parcel paramParcel)
  {
    this.clientName = paramParcel.readString();
    this.clientSortName = paramParcel.readString();
    this.clientPhones = new String[paramParcel.readInt()];
    paramParcel.readStringArray(this.clientPhones);
    this._id = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getClientName()
  {
    return this.clientName;
  }

  public String[] getClientPhones()
  {
    return this.clientPhones;
  }

  public String getClientSortName()
  {
    return this.clientSortName;
  }

  public long getId()
  {
    return this._id;
  }

  public String toString()
  {
    return "CAddressBookInfo [clientName=" + this.clientName + ", clientPhones=" + Arrays.toString(this.clientPhones) + ", clientSortName=" + this.clientSortName + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.clientName);
    paramParcel.writeString(this.clientSortName);
    paramParcel.writeInt(this.clientPhones.length);
    paramParcel.writeStringArray(this.clientPhones);
    paramParcel.writeLong(this._id);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CAddressBookInfo
 * JD-Core Version:    0.6.2
 */