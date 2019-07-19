package com.viber.voip.viberout.ui.products.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RateModel
  implements Parcelable
{
  public static final Parcelable.Creator<RateModel> CREATOR = new Parcelable.Creator()
  {
    public RateModel a(Parcel paramAnonymousParcel)
    {
      return new RateModel(paramAnonymousParcel);
    }

    public RateModel[] a(int paramAnonymousInt)
    {
      return new RateModel[paramAnonymousInt];
    }
  };
  private Uri mCountryIcon;
  private String mCountryName;
  private List<DestinationModel> mDestinations;
  private boolean mExpanded;
  private boolean mIsLast;
  private int mMaxMinutes;
  private CharSequence mRateEquation;

  public RateModel()
  {
  }

  protected RateModel(Parcel paramParcel)
  {
    this.mCountryIcon = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.mCountryName = paramParcel.readString();
    this.mDestinations = paramParcel.createTypedArrayList(DestinationModel.CREATOR);
    this.mMaxMinutes = paramParcel.readInt();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mIsLast = bool2;
      if (paramParcel.readByte() == 0)
        break label81;
    }
    while (true)
    {
      this.mExpanded = bool1;
      return;
      bool2 = false;
      break;
      label81: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri getCountryIcon()
  {
    return this.mCountryIcon;
  }

  public String getCountryName()
  {
    return this.mCountryName;
  }

  public List<DestinationModel> getDestinations()
  {
    return this.mDestinations;
  }

  public int getMaxMinutes()
  {
    return this.mMaxMinutes;
  }

  public CharSequence getRateEquation()
  {
    return this.mRateEquation;
  }

  public boolean isExpanded()
  {
    return this.mExpanded;
  }

  public boolean isLast()
  {
    return this.mIsLast;
  }

  void setCountryIcon(Uri paramUri)
  {
    this.mCountryIcon = paramUri;
  }

  void setCountryName(String paramString)
  {
    this.mCountryName = paramString;
  }

  void setDestinations(List<DestinationModel> paramList)
  {
    this.mDestinations = paramList;
  }

  public void setExpanded(boolean paramBoolean)
  {
    this.mExpanded = paramBoolean;
  }

  void setLast(boolean paramBoolean)
  {
    this.mIsLast = paramBoolean;
  }

  public void setMaxMinutes(int paramInt)
  {
    this.mMaxMinutes = paramInt;
  }

  void setRateEquation(CharSequence paramCharSequence)
  {
    this.mRateEquation = paramCharSequence;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeParcelable(this.mCountryIcon, paramInt);
    paramParcel.writeString(this.mCountryName);
    paramParcel.writeTypedList(this.mDestinations);
    paramParcel.writeInt(this.mMaxMinutes);
    int j;
    if (this.mIsLast)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.mExpanded)
        break label72;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      return;
      j = 0;
      break;
      label72: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.model.RateModel
 * JD-Core Version:    0.6.2
 */