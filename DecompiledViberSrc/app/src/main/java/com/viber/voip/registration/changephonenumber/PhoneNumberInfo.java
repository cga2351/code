package com.viber.voip.registration.changephonenumber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.registration.CountryCode;

public class PhoneNumberInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PhoneNumberInfo> CREATOR = new Parcelable.Creator()
  {
    public PhoneNumberInfo a(Parcel paramAnonymousParcel)
    {
      return new PhoneNumberInfo(paramAnonymousParcel);
    }

    public PhoneNumberInfo[] a(int paramAnonymousInt)
    {
      return new PhoneNumberInfo[paramAnonymousInt];
    }
  };
  public final String canonizedPhoneNumber;
  public final CountryCode countryCode;
  public final String phoneNumber;

  protected PhoneNumberInfo(Parcel paramParcel)
  {
    this.countryCode = ((CountryCode)paramParcel.readParcelable(CountryCode.class.getClassLoader()));
    this.phoneNumber = paramParcel.readString();
    this.canonizedPhoneNumber = paramParcel.readString();
  }

  public PhoneNumberInfo(CountryCode paramCountryCode, String paramString1, String paramString2)
  {
    this.countryCode = paramCountryCode;
    this.phoneNumber = paramString1;
    this.canonizedPhoneNumber = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getCanonizedPhoneNumberWithPlus()
  {
    if ((this.canonizedPhoneNumber == null) || (this.canonizedPhoneNumber.startsWith("+")))
      return this.canonizedPhoneNumber;
    return "+" + this.canonizedPhoneNumber;
  }

  public String getCountyIddCode()
  {
    if (this.countryCode != null)
      return this.countryCode.getIddCode();
    return "";
  }

  public String toString()
  {
    return "PhoneNumberInfo{countryCode=" + this.countryCode + ", phoneNumber='" + this.phoneNumber + '\'' + ", canonizedPhoneNumber='" + this.canonizedPhoneNumber + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.countryCode, paramInt);
    paramParcel.writeString(this.phoneNumber);
    paramParcel.writeString(this.canonizedPhoneNumber);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.PhoneNumberInfo
 * JD-Core Version:    0.6.2
 */