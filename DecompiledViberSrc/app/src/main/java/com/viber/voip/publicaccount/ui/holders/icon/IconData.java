package com.viber.voip.publicaccount.ui.holders.icon;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.d.d;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

class IconData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<IconData> CREATOR = new Parcelable.Creator()
  {
    public IconData a(Parcel paramAnonymousParcel)
    {
      return new IconData(paramAnonymousParcel);
    }

    public IconData[] a(int paramAnonymousInt)
    {
      return new IconData[paramAnonymousInt];
    }
  };
  Uri mIconUri;
  boolean mIconValid;
  Uri mImageCameraUri;
  boolean mIsVisibleForUser;

  public IconData()
  {
  }

  protected IconData(Parcel paramParcel)
  {
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mIsVisibleForUser = bool2;
      if (paramParcel.readByte() == 0)
        break label70;
    }
    while (true)
    {
      this.mIconValid = bool1;
      this.mIconUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      this.mImageCameraUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      return;
      bool2 = false;
      break;
      label70: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    paramPublicAccount.setIcon(this.mIconUri);
  }

  public void init(PublicAccount paramPublicAccount)
  {
    this.mIsVisibleForUser = d.d.a(paramPublicAccount.getGroupRole(), paramPublicAccount.getPublicGroupType());
    this.mIconUri = paramPublicAccount.getIcon();
    if (this.mIconUri != null);
    for (boolean bool = true; ; bool = false)
    {
      this.mIconValid = bool;
      return;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    byte b2;
    if (this.mIsVisibleForUser)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.mIconValid)
        break label55;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable(this.mIconUri, paramInt);
      paramParcel.writeParcelable(this.mImageCameraUri, paramInt);
      return;
      b2 = 0;
      break;
      label55: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.icon.IconData
 * JD-Core Version:    0.6.2
 */