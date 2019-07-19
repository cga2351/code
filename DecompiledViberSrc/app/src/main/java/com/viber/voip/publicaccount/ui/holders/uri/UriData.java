package com.viber.voip.publicaccount.ui.holders.uri;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

class UriData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<UriData> CREATOR = new Parcelable.Creator()
  {
    public UriData a(Parcel paramAnonymousParcel)
    {
      return new UriData(paramAnonymousParcel);
    }

    public UriData[] a(int paramAnonymousInt)
    {
      return new UriData[paramAnonymousInt];
    }
  };
  int mGroupRole;
  String mGroupUri;
  int mPublicGroupType;

  public UriData()
  {
  }

  protected UriData(Parcel paramParcel)
  {
    this.mGroupUri = paramParcel.readString();
    this.mGroupRole = paramParcel.readInt();
    this.mPublicGroupType = paramParcel.readInt();
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
    this.mGroupUri = paramPublicAccount.getGroupUri();
    this.mGroupRole = paramPublicAccount.getGroupRole();
    this.mPublicGroupType = paramPublicAccount.getPublicGroupType();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mGroupUri);
    paramParcel.writeInt(this.mGroupRole);
    paramParcel.writeInt(this.mPublicGroupType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.uri.UriData
 * JD-Core Version:    0.6.2
 */