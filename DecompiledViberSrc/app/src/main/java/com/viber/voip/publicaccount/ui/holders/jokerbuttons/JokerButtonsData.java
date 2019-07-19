package com.viber.voip.publicaccount.ui.holders.jokerbuttons;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

class JokerButtonsData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<JokerButtonsData> CREATOR = new Parcelable.Creator()
  {
    public JokerButtonsData a(Parcel paramAnonymousParcel)
    {
      return new JokerButtonsData(paramAnonymousParcel);
    }

    public JokerButtonsData[] a(int paramAnonymousInt)
    {
      return new JokerButtonsData[paramAnonymousInt];
    }
  };
  PublicAccount.ExtraInfo.JokerButton mJokerButton2;
  PublicAccount.ExtraInfo.JokerButton mJokerButton3;
  PublicAccount.ExtraInfo.JokerButton mJokerButton4;
  int mPublicGroupType;
  int mRole = 3;

  public JokerButtonsData()
  {
  }

  protected JokerButtonsData(Parcel paramParcel)
  {
    this.mRole = paramParcel.readInt();
    this.mPublicGroupType = paramParcel.readInt();
    this.mJokerButton2 = ((PublicAccount.ExtraInfo.JokerButton)paramParcel.readParcelable(PublicAccount.ExtraInfo.JokerButton.class.getClassLoader()));
    this.mJokerButton3 = ((PublicAccount.ExtraInfo.JokerButton)paramParcel.readParcelable(PublicAccount.ExtraInfo.JokerButton.class.getClassLoader()));
    this.mJokerButton4 = ((PublicAccount.ExtraInfo.JokerButton)paramParcel.readParcelable(PublicAccount.ExtraInfo.JokerButton.class.getClassLoader()));
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
    PublicAccount.ExtraInfo localExtraInfo = paramPublicAccount.getExtraInfo();
    if (localExtraInfo != null)
    {
      PublicAccount.ExtraInfo.JokerButton[] arrayOfJokerButton = localExtraInfo.getJokerButtons();
      PublicAccount.ExtraInfo.JokerButton localJokerButton1;
      if (arrayOfJokerButton.length > 1)
      {
        localJokerButton1 = arrayOfJokerButton[1];
        this.mJokerButton2 = localJokerButton1;
        if (arrayOfJokerButton.length <= 2)
          break label95;
      }
      label95: for (PublicAccount.ExtraInfo.JokerButton localJokerButton2 = arrayOfJokerButton[2]; ; localJokerButton2 = null)
      {
        this.mJokerButton3 = localJokerButton2;
        int i = arrayOfJokerButton.length;
        PublicAccount.ExtraInfo.JokerButton localJokerButton3 = null;
        if (i > 3)
          localJokerButton3 = arrayOfJokerButton[3];
        this.mJokerButton4 = localJokerButton3;
        return;
        localJokerButton1 = null;
        break;
      }
    }
    this.mJokerButton2 = null;
    this.mJokerButton3 = null;
    this.mJokerButton4 = null;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mRole);
    paramParcel.writeInt(this.mPublicGroupType);
    paramParcel.writeParcelable(this.mJokerButton2, paramInt);
    paramParcel.writeParcelable(this.mJokerButton3, paramInt);
    paramParcel.writeParcelable(this.mJokerButton4, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.jokerbuttons.JokerButtonsData
 * JD-Core Version:    0.6.2
 */