package com.viber.voip.flatbuffers.model.msginfo.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public final class ContactInfoSection
  implements Parcelable
{
  public static final Parcelable.Creator<ContactInfoSection> CREATOR = new Parcelable.Creator()
  {
    public ContactInfoSection a(Parcel paramAnonymousParcel)
    {
      return new ContactInfoSection(paramAnonymousParcel, null);
    }

    public ContactInfoSection[] a(int paramAnonymousInt)
    {
      return new ContactInfoSection[paramAnonymousInt];
    }
  };

  @c(a="name")
  private String mName;

  @c(a="phone_number")
  private String mPhoneNumber;

  public ContactInfoSection()
  {
  }

  private ContactInfoSection(Parcel paramParcel)
  {
    this.mName = paramParcel.readString();
    this.mPhoneNumber = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getName()
  {
    return this.mName;
  }

  public String getPhoneNumber()
  {
    return this.mPhoneNumber;
  }

  public void setName(String paramString)
  {
    this.mName = paramString;
  }

  public void setPhoneNumber(String paramString)
  {
    this.mPhoneNumber = paramString;
  }

  public String toString()
  {
    return "ContactInfoSection{mName=" + this.mName + ", mPhoneNumber=" + this.mPhoneNumber + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mPhoneNumber);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.ContactInfoSection
 * JD-Core Version:    0.6.2
 */