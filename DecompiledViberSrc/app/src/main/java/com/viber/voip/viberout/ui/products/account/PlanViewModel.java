package com.viber.voip.viberout.ui.products.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PlanViewModel
  implements Parcelable
{
  public static final Parcelable.Creator<PlanViewModel> CREATOR = new Parcelable.Creator()
  {
    public PlanViewModel a(Parcel paramAnonymousParcel)
    {
      return new PlanViewModel(paramAnonymousParcel);
    }

    public PlanViewModel[] a(int paramAnonymousInt)
    {
      return new PlanViewModel[paramAnonymousInt];
    }
  };
  private static final int PLAN_PROGRESS_THRESHOLD = 10;
  private final String mAction;
  private final boolean mIsUnlimited;
  private final String mMinutesLeft;
  private final int mProgress;
  private final String mTitle;
  private final String mType;

  protected PlanViewModel(Parcel paramParcel)
  {
    this.mTitle = paramParcel.readString();
    this.mProgress = paramParcel.readInt();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsUnlimited = bool;
      this.mMinutesLeft = paramParcel.readString();
      this.mAction = paramParcel.readString();
      this.mType = paramParcel.readString();
      return;
    }
  }

  public PlanViewModel(String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    this.mTitle = paramString1;
    this.mProgress = paramInt;
    this.mIsUnlimited = paramBoolean;
    this.mMinutesLeft = paramString2;
    this.mAction = paramString3;
    this.mType = paramString4;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAction()
  {
    return this.mAction;
  }

  public String getMinutesLeft()
  {
    return this.mMinutesLeft;
  }

  public int getProgress()
  {
    return this.mProgress;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public boolean isCallingPlan()
  {
    return "calling_plan".equals(this.mType);
  }

  public boolean isSubscription()
  {
    return "subscription".equals(this.mType);
  }

  public boolean isUnlimited()
  {
    return this.mIsUnlimited;
  }

  public boolean plentyMinutesLeft()
  {
    return (isUnlimited()) || (getProgress() > 10);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTitle);
    paramParcel.writeInt(this.mProgress);
    if (this.mIsUnlimited);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.mMinutesLeft);
      paramParcel.writeString(this.mAction);
      paramParcel.writeString(this.mType);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.PlanViewModel
 * JD-Core Version:    0.6.2
 */