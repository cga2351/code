package com.viber.voip.publicaccount.ui.holders.about;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.jni.LocationInfo;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

class AboutData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<AboutData> CREATOR = new Parcelable.Creator()
  {
    public AboutData a(Parcel paramAnonymousParcel)
    {
      return new AboutData(paramAnonymousParcel);
    }

    public AboutData[] a(int paramAnonymousInt)
    {
      return new AboutData[paramAnonymousInt];
    }
  };
  String mAbout;
  String mAddress;
  long mConversationId;
  long mGroupId;
  int mGroupRole;
  boolean mIsAgeRestricted;
  boolean mIsPublished;
  LocationInfo mLocationInfo;
  int mPublicGroupType;
  String mWebsite;

  public AboutData()
  {
  }

  protected AboutData(Parcel paramParcel)
  {
    this.mGroupId = paramParcel.readLong();
    this.mConversationId = paramParcel.readLong();
    this.mGroupRole = paramParcel.readInt();
    this.mPublicGroupType = paramParcel.readInt();
    this.mAbout = paramParcel.readString();
    this.mAddress = paramParcel.readString();
    this.mLocationInfo = ((LocationInfo)paramParcel.readParcelable(LocationInfo.class.getClassLoader()));
    this.mWebsite = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mIsAgeRestricted = bool2;
      if (paramParcel.readByte() == 0)
        break label110;
    }
    while (true)
    {
      this.mIsPublished = bool1;
      return;
      bool2 = false;
      break;
      label110: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
  }

  public void init(PublicAccount paramPublicAccount)
  {
    this.mAbout = paramPublicAccount.getTagLines();
    this.mAddress = paramPublicAccount.getAdressString();
    this.mLocationInfo = paramPublicAccount.getLocation();
    this.mWebsite = paramPublicAccount.getWebsite();
    this.mGroupId = paramPublicAccount.getGroupID();
    this.mConversationId = paramPublicAccount.getConversationId();
    this.mGroupRole = paramPublicAccount.getGroupRole();
    this.mPublicGroupType = paramPublicAccount.getPublicGroupType();
    this.mIsAgeRestricted = paramPublicAccount.isAgeRestricted();
    this.mIsPublished = paramPublicAccount.isPublished();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeLong(this.mGroupId);
    paramParcel.writeLong(this.mConversationId);
    paramParcel.writeInt(this.mGroupRole);
    paramParcel.writeInt(this.mPublicGroupType);
    paramParcel.writeString(this.mAbout);
    paramParcel.writeString(this.mAddress);
    paramParcel.writeParcelable(this.mLocationInfo, paramInt);
    paramParcel.writeString(this.mWebsite);
    byte b2;
    if (this.mIsAgeRestricted)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.mIsPublished)
        break label102;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label102: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.about.AboutData
 * JD-Core Version:    0.6.2
 */