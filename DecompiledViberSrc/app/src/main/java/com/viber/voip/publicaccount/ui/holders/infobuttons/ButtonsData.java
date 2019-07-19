package com.viber.voip.publicaccount.ui.holders.infobuttons;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;
import com.viber.voip.util.av;

class ButtonsData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<ButtonsData> CREATOR = new Parcelable.Creator()
  {
    public ButtonsData a(Parcel paramAnonymousParcel)
    {
      return new ButtonsData(paramAnonymousParcel);
    }

    public ButtonsData[] a(int paramAnonymousInt)
    {
      return new ButtonsData[paramAnonymousInt];
    }
  };
  boolean mHasCrm;
  boolean mIsNotSuspendedOrBlocked;
  PublicAccount.ExtraInfo.JokerButton mJokerButton1;
  int mPublicGroupType;
  int mRole = 3;
  boolean mShouldShowNotPublishedBanner;
  boolean mWebhookExists;

  public ButtonsData()
  {
  }

  protected ButtonsData(Parcel paramParcel)
  {
    this.mRole = paramParcel.readInt();
    this.mPublicGroupType = paramParcel.readInt();
    boolean bool2;
    boolean bool3;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mHasCrm = bool2;
      if (paramParcel.readByte() == 0)
        break label91;
      bool3 = bool1;
      label51: this.mIsNotSuspendedOrBlocked = bool3;
      if (paramParcel.readByte() == 0)
        break label97;
    }
    while (true)
    {
      this.mShouldShowNotPublishedBanner = bool1;
      this.mJokerButton1 = ((PublicAccount.ExtraInfo.JokerButton)paramParcel.readParcelable(PublicAccount.ExtraInfo.JokerButton.class.getClassLoader()));
      return;
      bool2 = false;
      break;
      label91: bool3 = false;
      break label51;
      label97: bool1 = false;
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
    boolean bool1 = true;
    this.mRole = paramPublicAccount.getGroupRole();
    this.mPublicGroupType = paramPublicAccount.getPublicGroupType();
    boolean bool2;
    label65: PublicAccount.ExtraInfo.JokerButton[] arrayOfJokerButton;
    if ((!av.d(paramPublicAccount.getFlags(), 512)) && (!av.d(paramPublicAccount.getFlags(), 8)))
    {
      bool2 = bool1;
      this.mIsNotSuspendedOrBlocked = bool2;
      this.mWebhookExists = paramPublicAccount.isWebhookExists();
      if (paramPublicAccount.getCrm() == null)
        break label120;
      this.mHasCrm = bool1;
      this.mShouldShowNotPublishedBanner = paramPublicAccount.shouldShowNotPublishedPublicAccountBanner();
      PublicAccount.ExtraInfo localExtraInfo = paramPublicAccount.getExtraInfo();
      if (localExtraInfo == null)
        break label131;
      arrayOfJokerButton = localExtraInfo.getJokerButtons();
      if (arrayOfJokerButton.length <= 0)
        break label125;
    }
    label120: label125: for (PublicAccount.ExtraInfo.JokerButton localJokerButton = arrayOfJokerButton[0]; ; localJokerButton = null)
    {
      this.mJokerButton1 = localJokerButton;
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label65;
    }
    label131: this.mJokerButton1 = null;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeInt(this.mRole);
    paramParcel.writeInt(this.mPublicGroupType);
    byte b2;
    byte b3;
    if (this.mHasCrm)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.mIsNotSuspendedOrBlocked)
        break label78;
      b3 = b1;
      label44: paramParcel.writeByte(b3);
      if (!this.mShouldShowNotPublishedBanner)
        break label84;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable(this.mJokerButton1, paramInt);
      return;
      b2 = 0;
      break;
      label78: b3 = 0;
      break label44;
      label84: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.infobuttons.ButtonsData
 * JD-Core Version:    0.6.2
 */