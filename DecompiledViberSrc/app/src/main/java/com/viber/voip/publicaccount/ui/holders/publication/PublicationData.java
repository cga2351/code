package com.viber.voip.publicaccount.ui.holders.publication;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

class PublicationData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<PublicationData> CREATOR = new Parcelable.Creator()
  {
    public PublicationData a(Parcel paramAnonymousParcel)
    {
      return new PublicationData(paramAnonymousParcel);
    }

    public PublicationData[] a(int paramAnonymousInt)
    {
      return new PublicationData[paramAnonymousInt];
    }
  };
  boolean mIsPublished;
  boolean mShouldShowUnpublishWarningMessage;

  public PublicationData()
  {
    this.mShouldShowUnpublishWarningMessage = true;
  }

  protected PublicationData(Parcel paramParcel)
  {
    this.mShouldShowUnpublishWarningMessage = bool1;
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mShouldShowUnpublishWarningMessage = bool2;
      if (paramParcel.readByte() == 0)
        break label43;
    }
    while (true)
    {
      this.mIsPublished = bool1;
      return;
      bool2 = false;
      break;
      label43: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    paramPublicAccount.setIsPublished(this.mIsPublished);
  }

  public void init(PublicAccount paramPublicAccount)
  {
    this.mIsPublished = paramPublicAccount.isPublished();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    byte b2;
    if (this.mShouldShowUnpublishWarningMessage)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.mIsPublished)
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
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.publication.PublicationData
 * JD-Core Version:    0.6.2
 */