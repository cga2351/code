package com.viber.voip.publicaccount.ui.holders.general.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.jni.LocationInfo;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;
import com.viber.voip.validation.FormValidator.InstanceState;
import com.viber.voip.widget.ViewWithDescription.ValidationState;
import com.viber.voip.widget.ViewWithDescription.a;

public class GeneralData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<GeneralData> CREATOR = new Parcelable.Creator()
  {
    public GeneralData a(Parcel paramAnonymousParcel)
    {
      return new GeneralData(paramAnonymousParcel);
    }

    public GeneralData[] a(int paramAnonymousInt)
    {
      return new GeneralData[paramAnonymousInt];
    }
  };
  String mAbout;
  ViewWithDescription.ValidationState mAboutViewState;
  String mAddress;
  boolean mAllFieldsValid;
  String mCountryCode;
  String mEmail;
  ViewWithDescription.ValidationState mEmailViewState;
  LocationInfo mLocationInfo;
  ViewWithDescription.a mLocationStatus = ViewWithDescription.a.a;
  boolean mValidLocation;
  FormValidator.InstanceState mValidatorState;
  String mWebsite;
  ViewWithDescription.ValidationState mWebsiteViewState;

  public GeneralData()
  {
  }

  protected GeneralData(Parcel paramParcel)
  {
    this.mAbout = paramParcel.readString();
    this.mAddress = paramParcel.readString();
    this.mCountryCode = paramParcel.readString();
    this.mLocationInfo = ((LocationInfo)paramParcel.readParcelable(LocationInfo.class.getClassLoader()));
    int i = paramParcel.readInt();
    ViewWithDescription.a locala;
    boolean bool2;
    if (i == -1)
    {
      locala = null;
      this.mLocationStatus = locala;
      this.mWebsite = paramParcel.readString();
      this.mEmail = paramParcel.readString();
      this.mValidatorState = ((FormValidator.InstanceState)paramParcel.readParcelable(FormValidator.InstanceState.class.getClassLoader()));
      if (paramParcel.readByte() == 0)
        break label191;
      bool2 = bool1;
      label114: this.mAllFieldsValid = bool2;
      if (paramParcel.readByte() == 0)
        break label197;
    }
    while (true)
    {
      this.mValidLocation = bool1;
      this.mAboutViewState = ((ViewWithDescription.ValidationState)paramParcel.readParcelable(ViewWithDescription.ValidationState.class.getClassLoader()));
      this.mWebsiteViewState = ((ViewWithDescription.ValidationState)paramParcel.readParcelable(ViewWithDescription.ValidationState.class.getClassLoader()));
      this.mEmailViewState = ((ViewWithDescription.ValidationState)paramParcel.readParcelable(ViewWithDescription.ValidationState.class.getClassLoader()));
      return;
      locala = ViewWithDescription.a.values()[i];
      break;
      label191: bool2 = false;
      break label114;
      label197: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    paramPublicAccount.setTagLines(this.mAbout);
    paramPublicAccount.setLocation(this.mLocationInfo);
    paramPublicAccount.setAdressString(this.mAddress);
    paramPublicAccount.setCountryCode(this.mCountryCode);
    paramPublicAccount.setEmail(this.mEmail);
    paramPublicAccount.setWebsite(this.mWebsite);
  }

  public void init(PublicAccount paramPublicAccount)
  {
    this.mAbout = paramPublicAccount.getTagLines();
    this.mLocationInfo = paramPublicAccount.getLocation();
    this.mAddress = paramPublicAccount.getAdressString();
    this.mCountryCode = paramPublicAccount.getCountryCode();
    this.mLocationStatus = ViewWithDescription.a.a;
    this.mWebsite = paramPublicAccount.getWebsite();
    this.mEmail = paramPublicAccount.getEmail();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeString(this.mAbout);
    paramParcel.writeString(this.mAddress);
    paramParcel.writeString(this.mCountryCode);
    paramParcel.writeParcelable(this.mLocationInfo, paramInt);
    int i;
    byte b2;
    if (this.mLocationStatus == null)
    {
      i = -1;
      paramParcel.writeInt(i);
      paramParcel.writeString(this.mWebsite);
      paramParcel.writeString(this.mEmail);
      paramParcel.writeParcelable(this.mValidatorState, paramInt);
      if (!this.mAllFieldsValid)
        break label144;
      b2 = b1;
      label86: paramParcel.writeByte(b2);
      if (!this.mValidLocation)
        break label150;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable(this.mAboutViewState, paramInt);
      paramParcel.writeParcelable(this.mWebsiteViewState, paramInt);
      paramParcel.writeParcelable(this.mEmailViewState, paramInt);
      return;
      i = this.mLocationStatus.ordinal();
      break;
      label144: b2 = 0;
      break label86;
      label150: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.base.GeneralData
 * JD-Core Version:    0.6.2
 */