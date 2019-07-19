package com.viber.voip.publicaccount.ui.holders.separator;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;

public class SeparatorData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<SeparatorData> CREATOR = new Parcelable.Creator()
  {
    public SeparatorData a(Parcel paramAnonymousParcel)
    {
      return new SeparatorData(paramAnonymousParcel);
    }

    public SeparatorData[] a(int paramAnonymousInt)
    {
      return new SeparatorData[paramAnonymousInt];
    }
  };
  boolean mShowSeparator;

  public SeparatorData()
  {
  }

  protected SeparatorData(Parcel paramParcel)
  {
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.mShowSeparator = i;
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
    this.mShowSeparator = paramPublicAccount.hasPublicChat();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mShowSeparator);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.separator.SeparatorData
 * JD-Core Version:    0.6.2
 */