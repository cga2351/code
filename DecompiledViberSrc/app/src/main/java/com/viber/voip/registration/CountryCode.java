package com.viber.voip.registration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CountryCode
  implements Parcelable, Comparable<CountryCode>
{
  public static final Parcelable.Creator<CountryCode> CREATOR = new Parcelable.Creator()
  {
    public CountryCode a(Parcel paramAnonymousParcel)
    {
      return new CountryCode(paramAnonymousParcel, null);
    }

    public CountryCode[] a(int paramAnonymousInt)
    {
      return new CountryCode[paramAnonymousInt];
    }
  };
  private final String code;
  private String defaultName;
  private final String iddCode;
  private final String localCode;
  private final String name;

  private CountryCode(Parcel paramParcel)
  {
    this.code = paramParcel.readString();
    this.iddCode = paramParcel.readString();
    this.name = paramParcel.readString();
    this.localCode = paramParcel.readString();
    this.defaultName = paramParcel.readString();
  }

  public CountryCode(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.code = paramString1;
    this.iddCode = paramString2;
    this.name = paramString3;
    this.localCode = paramString4;
  }

  public CountryCode(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramString4);
    this.defaultName = paramString5;
  }

  public int compareTo(CountryCode paramCountryCode)
  {
    return this.name.compareTo(paramCountryCode.getName());
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CountryCode localCountryCode;
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localCountryCode = (CountryCode)paramObject;
        if (this.code == null)
        {
          if (localCountryCode.code != null)
            return false;
        }
        else if (!this.code.equals(localCountryCode.code))
          return false;
        if (this.iddCode != null)
          break;
      }
      while (localCountryCode.iddCode == null);
      return false;
    }
    while (this.iddCode.equals(localCountryCode.iddCode));
    return false;
  }

  public String getCode()
  {
    if ((this.code != null) && (this.code.length() > 2))
      return this.code.substring(0, 2);
    return this.code;
  }

  public String getDefaultName()
  {
    return this.defaultName;
  }

  public String getIddCode()
  {
    return this.iddCode;
  }

  public String getLocalCode()
  {
    return this.localCode;
  }

  public String getName()
  {
    return this.name;
  }

  public int hashCode()
  {
    int i;
    int j;
    int k;
    if (this.code == null)
    {
      i = 0;
      j = 31 * (i + 31);
      String str = this.iddCode;
      k = 0;
      if (str != null)
        break label45;
    }
    while (true)
    {
      return j + k;
      i = this.code.hashCode();
      break;
      label45: k = this.iddCode.hashCode();
    }
  }

  public void setDefaultName(String paramString)
  {
    this.defaultName = paramString;
  }

  public String toString()
  {
    return "CountryCode{" + "code='" + this.code + '\'' + ", iddCode='" + this.iddCode + '\'' + ", localCode='" + this.localCode + '\'' + ", name='" + this.name + '\'' + ", defaultName='" + this.defaultName + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.code);
    paramParcel.writeString(this.iddCode);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.localCode);
    paramParcel.writeString(this.defaultName);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.CountryCode
 * JD-Core Version:    0.6.2
 */