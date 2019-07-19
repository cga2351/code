package com.viber.voip.publicaccount.ui.holders.restriction.age;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

class AgeRestrictionData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<AgeRestrictionData> CREATOR = new Parcelable.Creator()
  {
    public AgeRestrictionData a(Parcel paramAnonymousParcel)
    {
      return new AgeRestrictionData(paramAnonymousParcel);
    }

    public AgeRestrictionData[] a(int paramAnonymousInt)
    {
      return new AgeRestrictionData[paramAnonymousInt];
    }
  };
  boolean mHasPublicChat;
  boolean mIsAgeRestricted;

  public AgeRestrictionData()
  {
  }

  protected AgeRestrictionData(Parcel paramParcel)
  {
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mIsAgeRestricted = bool2;
      if (paramParcel.readByte() == 0)
        break label38;
    }
    while (true)
    {
      this.mHasPublicChat = bool1;
      return;
      bool2 = false;
      break;
      label38: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    paramPublicAccount.setAgeRestricted(this.mIsAgeRestricted);
  }

  public void init(PublicAccount paramPublicAccount)
  {
    this.mIsAgeRestricted = paramPublicAccount.isAgeRestricted();
    this.mHasPublicChat = paramPublicAccount.hasPublicChat();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    byte b2;
    if (this.mIsAgeRestricted)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.mHasPublicChat)
        break label37;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label37: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.restriction.age.AgeRestrictionData
 * JD-Core Version:    0.6.2
 */