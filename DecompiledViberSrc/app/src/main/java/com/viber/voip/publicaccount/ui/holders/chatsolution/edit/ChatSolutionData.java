package com.viber.voip.publicaccount.ui.holders.chatsolution.edit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

class ChatSolutionData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<ChatSolutionData> CREATOR = new Parcelable.Creator()
  {
    public ChatSolutionData a(Parcel paramAnonymousParcel)
    {
      return new ChatSolutionData(paramAnonymousParcel);
    }

    public ChatSolutionData[] a(int paramAnonymousInt)
    {
      return new ChatSolutionData[paramAnonymousInt];
    }
  };
  String mAppKey;
  CrmItem mCrm;
  boolean mIsNewAppKeyPending;
  String mPublicAccountId;

  public ChatSolutionData()
  {
  }

  protected ChatSolutionData(Parcel paramParcel)
  {
    this.mPublicAccountId = paramParcel.readString();
    this.mCrm = ((CrmItem)paramParcel.readParcelable(CrmItem.class.getClassLoader()));
    this.mAppKey = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsNewAppKeyPending = bool;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    paramPublicAccount.setCrm(this.mCrm);
    paramPublicAccount.setAuthToken(this.mAppKey);
  }

  public void init(PublicAccount paramPublicAccount)
  {
    this.mPublicAccountId = paramPublicAccount.getPublicAccountId();
    this.mCrm = paramPublicAccount.getCrm();
    this.mAppKey = paramPublicAccount.getAuthToken();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPublicAccountId);
    paramParcel.writeParcelable(this.mCrm, paramInt);
    paramParcel.writeString(this.mAppKey);
    if (this.mIsNewAppKeyPending);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.chatsolution.edit.ChatSolutionData
 * JD-Core Version:    0.6.2
 */