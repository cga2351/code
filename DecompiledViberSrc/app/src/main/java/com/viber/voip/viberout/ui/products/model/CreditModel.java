package com.viber.voip.viberout.ui.products.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CreditModel
  implements Parcelable
{
  public static final Parcelable.Creator<CreditModel> CREATOR = new Parcelable.Creator()
  {
    public CreditModel a(Parcel paramAnonymousParcel)
    {
      return new CreditModel(paramAnonymousParcel);
    }

    public CreditModel[] a(int paramAnonymousInt)
    {
      return new CreditModel[paramAnonymousInt];
    }
  };
  public static final CreditModel STUB = new CreditModel(0.0D, "$0.00", false, null, "", null);
  private double mAmount;
  private String mBuyAction;
  private String mExtraFormattedAmount;
  private String mFormattedAmount;
  private String mInfoAction;
  private boolean mIsRecommended;

  public CreditModel()
  {
  }

  CreditModel(double paramDouble, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    this.mAmount = paramDouble;
    this.mFormattedAmount = paramString1;
    this.mIsRecommended = paramBoolean;
    this.mInfoAction = paramString2;
    this.mBuyAction = paramString3;
    this.mExtraFormattedAmount = paramString4;
  }

  protected CreditModel(Parcel paramParcel)
  {
    this.mAmount = paramParcel.readDouble();
    this.mFormattedAmount = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsRecommended = bool;
      this.mInfoAction = paramParcel.readString();
      this.mBuyAction = paramParcel.readString();
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public double getAmount()
  {
    return this.mAmount;
  }

  public String getBuyAction()
  {
    return this.mBuyAction;
  }

  public String getExtraFormattedAmount()
  {
    return this.mExtraFormattedAmount;
  }

  public String getFormattedAmount()
  {
    return this.mFormattedAmount;
  }

  public String getInfoAction()
  {
    return this.mInfoAction;
  }

  public boolean isRecommended()
  {
    return this.mIsRecommended;
  }

  void setAmount(double paramDouble)
  {
    this.mAmount = paramDouble;
  }

  void setBuyAction(String paramString)
  {
    this.mBuyAction = paramString;
  }

  void setExtraFormattedAmount(String paramString)
  {
    this.mExtraFormattedAmount = paramString;
  }

  void setFormattedAmount(String paramString)
  {
    this.mFormattedAmount = paramString;
  }

  void setInfoAction(String paramString)
  {
    this.mInfoAction = paramString;
  }

  void setRecommended(boolean paramBoolean)
  {
    this.mIsRecommended = paramBoolean;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.mAmount);
    paramParcel.writeString(this.mFormattedAmount);
    if (this.mIsRecommended);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.mInfoAction);
      paramParcel.writeString(this.mBuyAction);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.model.CreditModel
 * JD-Core Version:    0.6.2
 */