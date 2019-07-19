package com.viber.voip.viberout.ui.products.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CountryModel
  implements Parcelable
{
  public static final Parcelable.Creator<CountryModel> CREATOR = new Parcelable.Creator()
  {
    public CountryModel a(Parcel paramAnonymousParcel)
    {
      return new CountryModel(paramAnonymousParcel, null);
    }

    public CountryModel[] a(int paramAnonymousInt)
    {
      return new CountryModel[paramAnonymousInt];
    }
  };
  private final String mCode;
  private final String mImage;
  private final String mName;

  private CountryModel(Parcel paramParcel)
  {
    this.mName = paramParcel.readString();
    this.mCode = paramParcel.readString();
    this.mImage = paramParcel.readString();
  }

  public CountryModel(String paramString1, String paramString2, String paramString3)
  {
    this.mName = paramString1;
    this.mCode = paramString2;
    this.mImage = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    CountryModel localCountryModel = (CountryModel)paramObject;
    return this.mCode.equals(localCountryModel.mCode);
  }

  public String getCode()
  {
    return this.mCode;
  }

  public String getImage()
  {
    return this.mImage;
  }

  public String getName()
  {
    return this.mName;
  }

  public int hashCode()
  {
    return this.mCode.hashCode();
  }

  public String toString()
  {
    return this.mName;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mCode);
    paramParcel.writeString(this.mImage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.model.CountryModel
 * JD-Core Version:    0.6.2
 */