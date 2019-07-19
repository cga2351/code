package com.viber.voip.viberout.ui.products.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BalanceViewModel
  implements Parcelable
{
  public static final Parcelable.Creator<BalanceViewModel> CREATOR = new Parcelable.Creator()
  {
    public BalanceViewModel a(Parcel paramAnonymousParcel)
    {
      return new BalanceViewModel(paramAnonymousParcel);
    }

    public BalanceViewModel[] a(int paramAnonymousInt)
    {
      return new BalanceViewModel[paramAnonymousInt];
    }
  };
  private final int mColor;
  private final String mFormattedAmount;

  public BalanceViewModel(int paramInt, String paramString)
  {
    this.mColor = paramInt;
    this.mFormattedAmount = paramString;
  }

  protected BalanceViewModel(Parcel paramParcel)
  {
    this.mColor = paramParcel.readInt();
    this.mFormattedAmount = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public int getBalanceColor()
  {
    return this.mColor;
  }

  public String getFormattedBalance()
  {
    return this.mFormattedAmount;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mColor);
    paramParcel.writeString(this.mFormattedAmount);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.BalanceViewModel
 * JD-Core Version:    0.6.2
 */