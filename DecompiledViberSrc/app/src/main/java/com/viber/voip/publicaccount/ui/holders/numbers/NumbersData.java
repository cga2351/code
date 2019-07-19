package com.viber.voip.publicaccount.ui.holders.numbers;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

class NumbersData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<NumbersData> CREATOR = new Parcelable.Creator()
  {
    public NumbersData a(Parcel paramAnonymousParcel)
    {
      return new NumbersData(paramAnonymousParcel);
    }

    public NumbersData[] a(int paramAnonymousInt)
    {
      return new NumbersData[paramAnonymousInt];
    }
  };
  int mFollowersCount;
  boolean mHasMedia;
  int mPublicGroupType;
  int mRole = 3;
  int mSubscribersCount;

  public NumbersData()
  {
  }

  protected NumbersData(Parcel paramParcel)
  {
    this.mRole = paramParcel.readInt();
    this.mPublicGroupType = paramParcel.readInt();
    this.mFollowersCount = paramParcel.readInt();
    this.mSubscribersCount = paramParcel.readInt();
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.mHasMedia = i;
      return;
      i = 0;
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
    this.mRole = paramPublicAccount.getGroupRole();
    this.mPublicGroupType = paramPublicAccount.getPublicGroupType();
    this.mFollowersCount = paramPublicAccount.getWatchersCount();
    this.mSubscribersCount = paramPublicAccount.getSubscribersCount();
    if (paramPublicAccount.getMediaCount() > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mHasMedia = bool;
      return;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mRole);
    paramParcel.writeInt(this.mPublicGroupType);
    paramParcel.writeInt(this.mFollowersCount);
    paramParcel.writeInt(this.mSubscribersCount);
    if (this.mHasMedia);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.numbers.NumbersData
 * JD-Core Version:    0.6.2
 */