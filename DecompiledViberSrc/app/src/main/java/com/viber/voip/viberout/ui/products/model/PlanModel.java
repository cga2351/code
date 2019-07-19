package com.viber.voip.viberout.ui.products.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

public class PlanModel
  implements Parcelable
{
  public static final Parcelable.Creator<PlanModel> CREATOR = new Parcelable.Creator()
  {
    public PlanModel a(Parcel paramAnonymousParcel)
    {
      return new PlanModel(paramAnonymousParcel);
    }

    public PlanModel[] a(int paramAnonymousInt)
    {
      return new PlanModel[paramAnonymousInt];
    }
  };
  private String mBuyAction;
  private String mBuyButtonText;
  private String mBuyButtonTextNonLocalized;
  private String mCountry;
  private String mCountryCode;

  @Nullable
  private Uri mCountryIcon;
  private String mDescription;
  private int mDestinationCountriesCount;
  private String mDestinations;
  private String mDiscount;
  private int mDiscountValue;
  private boolean mHasIntroductory;
  private String mInfoAction;
  private boolean mIsMultipleDestinations;
  private boolean mIsUnlimited;
  private String mOffer;
  private String mType;

  public PlanModel()
  {
  }

  protected PlanModel(Parcel paramParcel)
  {
    this.mType = paramParcel.readString();
    this.mCountry = paramParcel.readString();
    this.mCountryCode = paramParcel.readString();
    this.mCountryIcon = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.mDiscount = paramParcel.readString();
    this.mDiscountValue = paramParcel.readInt();
    this.mOffer = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mIsUnlimited = bool2;
      this.mDestinations = paramParcel.readString();
      this.mBuyButtonText = paramParcel.readString();
      this.mBuyButtonTextNonLocalized = paramParcel.readString();
      this.mDescription = paramParcel.readString();
      this.mInfoAction = paramParcel.readString();
      this.mBuyAction = paramParcel.readString();
      if (paramParcel.readByte() == 0)
        break label150;
    }
    while (true)
    {
      this.mHasIntroductory = bool1;
      return;
      bool2 = false;
      break;
      label150: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getBuyAction()
  {
    return this.mBuyAction;
  }

  public String getBuyButtonText()
  {
    return this.mBuyButtonText;
  }

  public String getBuyButtonTextNonLocalized()
  {
    return this.mBuyButtonTextNonLocalized;
  }

  public String getCountry()
  {
    return this.mCountry;
  }

  public String getCountryCode()
  {
    return this.mCountryCode;
  }

  @Nullable
  public Uri getCountryIcon()
  {
    return this.mCountryIcon;
  }

  public String getDescription()
  {
    return this.mDescription;
  }

  public int getDestinationCountriesCount()
  {
    return this.mDestinationCountriesCount;
  }

  public String getDestinations()
  {
    return this.mDestinations;
  }

  public String getDiscount()
  {
    return this.mDiscount;
  }

  public int getDiscountValue()
  {
    return this.mDiscountValue;
  }

  public String getInfoAction()
  {
    return this.mInfoAction;
  }

  public String getOffer()
  {
    return this.mOffer;
  }

  public String getType()
  {
    return this.mType;
  }

  public boolean hasIntroductory()
  {
    return this.mHasIntroductory;
  }

  public boolean isCallingPlan()
  {
    return "calling_plan".equals(this.mType);
  }

  public boolean isMultipleDestinations()
  {
    return this.mIsMultipleDestinations;
  }

  public boolean isSubscription()
  {
    return "subscription".equals(this.mType);
  }

  public boolean isUnlimited()
  {
    return this.mIsUnlimited;
  }

  public void setBuyAction(String paramString)
  {
    this.mBuyAction = paramString;
  }

  public void setBuyButtonText(String paramString)
  {
    this.mBuyButtonText = paramString;
  }

  public void setBuyButtonTextNonLocalized(String paramString)
  {
    this.mBuyButtonTextNonLocalized = paramString;
  }

  public void setCountry(String paramString)
  {
    this.mCountry = paramString;
  }

  public void setCountryCode(String paramString)
  {
    this.mCountryCode = paramString;
  }

  public void setCountryIcon(@Nullable Uri paramUri)
  {
    this.mCountryIcon = paramUri;
  }

  public void setDescription(String paramString)
  {
    this.mDescription = paramString;
  }

  public void setDestinationCountriesCount(int paramInt)
  {
    this.mDestinationCountriesCount = paramInt;
  }

  public void setDestinations(String paramString)
  {
    this.mDestinations = paramString;
  }

  public void setDiscount(String paramString)
  {
    this.mDiscount = paramString;
  }

  public void setDiscountValue(int paramInt)
  {
    this.mDiscountValue = paramInt;
  }

  public void setHasIntroductory(boolean paramBoolean)
  {
    this.mHasIntroductory = paramBoolean;
  }

  public void setInfoAction(String paramString)
  {
    this.mInfoAction = paramString;
  }

  public void setMultipleDestinations(boolean paramBoolean)
  {
    this.mIsMultipleDestinations = paramBoolean;
  }

  public void setOffer(String paramString)
  {
    this.mOffer = paramString;
  }

  public void setType(String paramString)
  {
    this.mType = paramString;
  }

  public void setUnlimited(boolean paramBoolean)
  {
    this.mIsUnlimited = paramBoolean;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.mType);
    paramParcel.writeString(this.mCountry);
    paramParcel.writeString(this.mCountryCode);
    paramParcel.writeParcelable(this.mCountryIcon, paramInt);
    paramParcel.writeString(this.mDiscount);
    paramParcel.writeInt(this.mDiscountValue);
    paramParcel.writeString(this.mOffer);
    int j;
    if (this.mIsUnlimited)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      paramParcel.writeString(this.mDestinations);
      paramParcel.writeString(this.mBuyButtonText);
      paramParcel.writeString(this.mBuyButtonTextNonLocalized);
      paramParcel.writeString(this.mDescription);
      paramParcel.writeString(this.mInfoAction);
      paramParcel.writeString(this.mBuyAction);
      if (!this.mHasIntroductory)
        break label144;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      return;
      j = 0;
      break;
      label144: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.model.PlanModel
 * JD-Core Version:    0.6.2
 */