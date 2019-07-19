package com.viber.voip.publicaccount.ui.holders.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

public class ManageStorageUiData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<ManageStorageUiData> CREATOR = new Parcelable.Creator()
  {
    public ManageStorageUiData a(Parcel paramAnonymousParcel)
    {
      return new ManageStorageUiData(paramAnonymousParcel);
    }

    public ManageStorageUiData[] a(int paramAnonymousInt)
    {
      return new ManageStorageUiData[paramAnonymousInt];
    }
  };

  public ManageStorageUiData()
  {
  }

  protected ManageStorageUiData(Parcel paramParcel)
  {
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
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.storage.ManageStorageUiData
 * JD-Core Version:    0.6.2
 */