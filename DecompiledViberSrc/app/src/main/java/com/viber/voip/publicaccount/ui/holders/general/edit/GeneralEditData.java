package com.viber.voip.publicaccount.ui.holders.general.edit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.general.base.GeneralData;

class GeneralEditData extends GeneralData
{
  public static final Parcelable.Creator<GeneralEditData> CREATOR = new Parcelable.Creator()
  {
    public GeneralEditData a(Parcel paramAnonymousParcel)
    {
      return new GeneralEditData(paramAnonymousParcel);
    }

    public GeneralEditData[] a(int paramAnonymousInt)
    {
      return new GeneralEditData[paramAnonymousInt];
    }
  };
  String[] mTags;

  public GeneralEditData()
  {
  }

  protected GeneralEditData(Parcel paramParcel)
  {
    super(paramParcel);
    this.mTags = paramParcel.createStringArray();
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    super.fill(paramPublicAccount);
    paramPublicAccount.setTags(this.mTags);
  }

  public void init(PublicAccount paramPublicAccount)
  {
    super.init(paramPublicAccount);
    this.mTags = paramPublicAccount.getTags();
    if (this.mTags == null)
      this.mTags = new String[0];
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeStringArray(this.mTags);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.edit.GeneralEditData
 * JD-Core Version:    0.6.2
 */