package com.viber.jni;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CContactInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CContactInfo> CREATOR = new Parcelable.Creator()
  {
    public CContactInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CContactInfo(paramAnonymousParcel);
    }

    public CContactInfo[] newArray(int paramAnonymousInt)
    {
      return new CContactInfo[paramAnonymousInt];
    }
  };
  private final String clientName;
  private final String clientPhone;
  private final String clientSortName;

  public CContactInfo(Parcel paramParcel)
  {
    this.clientName = paramParcel.readString();
    this.clientSortName = paramParcel.readString();
    this.clientPhone = paramParcel.readString();
  }

  public CContactInfo(String paramString1, String paramString2, String paramString3)
  {
    this.clientName = paramString1;
    this.clientPhone = paramString2;
    this.clientSortName = paramString3;
  }

  public static boolean isSameName(CContactInfo paramCContactInfo1, CContactInfo paramCContactInfo2)
  {
    if (((paramCContactInfo1.clientName == null) && (paramCContactInfo2.clientName == null)) || ((paramCContactInfo1.clientName != null) && (paramCContactInfo1.clientName.equals(paramCContactInfo2.clientName))));
    for (int i = 1; ; i = 0)
    {
      if (((paramCContactInfo1.clientSortName == null) && (paramCContactInfo2.clientSortName == null)) || ((paramCContactInfo1.clientSortName != null) && (paramCContactInfo1.clientSortName.equals(paramCContactInfo2.clientSortName))));
      for (int j = 1; ; j = 0)
        return (i != 0) && (j != 0);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    String str;
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof CContactInfo)))
        return false;
      str = ((CContactInfo)paramObject).getClientPhone();
    }
    while (((this.clientPhone == null) && (str == null)) || ((this.clientPhone != null) && (this.clientPhone.equals(str))));
    return false;
  }

  public String getClientName()
  {
    return this.clientName;
  }

  public String getClientPhone()
  {
    return this.clientPhone;
  }

  public String getClientSortName()
  {
    return this.clientSortName;
  }

  public int hashCode()
  {
    if (this.clientPhone == null);
    for (int i = 0; ; i = this.clientPhone.hashCode())
      return i + 31;
  }

  public String toString()
  {
    return "CContactInfo [clientName=" + this.clientName + ", clientPhone=" + this.clientPhone + ", clientSortName=" + this.clientSortName + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.clientName);
    paramParcel.writeString(this.clientSortName);
    paramParcel.writeString(this.clientPhone);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CContactInfo
 * JD-Core Version:    0.6.2
 */