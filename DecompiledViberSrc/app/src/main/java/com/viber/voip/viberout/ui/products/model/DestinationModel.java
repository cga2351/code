package com.viber.voip.viberout.ui.products.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DestinationModel
  implements Parcelable
{
  public static final Parcelable.Creator<DestinationModel> CREATOR = new Parcelable.Creator()
  {
    public DestinationModel a(Parcel paramAnonymousParcel)
    {
      return new DestinationModel(paramAnonymousParcel);
    }

    public DestinationModel[] a(int paramAnonymousInt)
    {
      return new DestinationModel[paramAnonymousInt];
    }
  };
  private int mIconResId;
  private int mMinutes;
  private String mName;
  private String mRateLine1;
  private String mRateLine2;

  public DestinationModel()
  {
  }

  protected DestinationModel(Parcel paramParcel)
  {
    this.mName = paramParcel.readString();
    this.mIconResId = paramParcel.readInt();
    this.mRateLine1 = paramParcel.readString();
    this.mRateLine2 = paramParcel.readString();
    this.mMinutes = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public int getIconResId()
  {
    return this.mIconResId;
  }

  public int getMinutes()
  {
    return this.mMinutes;
  }

  public String getName()
  {
    return this.mName;
  }

  public String getRateLine1()
  {
    return this.mRateLine1;
  }

  public String getRateLine2()
  {
    return this.mRateLine2;
  }

  void setIconResId(int paramInt)
  {
    this.mIconResId = paramInt;
  }

  void setMinutes(int paramInt)
  {
    this.mMinutes = paramInt;
  }

  void setName(String paramString)
  {
    this.mName = paramString;
  }

  void setRateLine1(String paramString)
  {
    this.mRateLine1 = paramString;
  }

  void setRateLine2(String paramString)
  {
    this.mRateLine2 = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIconResId);
    paramParcel.writeString(this.mRateLine1);
    paramParcel.writeString(this.mRateLine2);
    paramParcel.writeInt(this.mMinutes);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.model.DestinationModel
 * JD-Core Version:    0.6.2
 */