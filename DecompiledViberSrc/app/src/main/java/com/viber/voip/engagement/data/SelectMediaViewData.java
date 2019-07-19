package com.viber.voip.engagement.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SelectMediaViewData
  implements Parcelable
{
  public static final Parcelable.Creator<SelectMediaViewData> CREATOR = new Parcelable.Creator()
  {
    public SelectMediaViewData a(Parcel paramAnonymousParcel)
    {
      return new SelectMediaViewData(paramAnonymousParcel);
    }

    public SelectMediaViewData[] a(int paramAnonymousInt)
    {
      return new SelectMediaViewData[paramAnonymousInt];
    }
  };
  private final GifsMediaViewData mGifsMediaViewData;
  private final String mRichMessageMsgInfo;
  private final StickersMediaViewData mStickersMediaViewData;

  public SelectMediaViewData()
  {
    this(new GifsMediaViewData(), new StickersMediaViewData(), null);
  }

  protected SelectMediaViewData(Parcel paramParcel)
  {
    this.mGifsMediaViewData = ((GifsMediaViewData)paramParcel.readParcelable(GifsMediaViewData.class.getClassLoader()));
    this.mStickersMediaViewData = ((StickersMediaViewData)paramParcel.readParcelable(StickersMediaViewData.class.getClassLoader()));
    this.mRichMessageMsgInfo = paramParcel.readString();
  }

  public SelectMediaViewData(GifsMediaViewData paramGifsMediaViewData, StickersMediaViewData paramStickersMediaViewData, String paramString)
  {
    this.mGifsMediaViewData = paramGifsMediaViewData;
    this.mStickersMediaViewData = paramStickersMediaViewData;
    this.mRichMessageMsgInfo = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public GifsMediaViewData getGifsMediaViewData()
  {
    return this.mGifsMediaViewData;
  }

  public String getRichMessageMsgInfo()
  {
    return this.mRichMessageMsgInfo;
  }

  public StickersMediaViewData getStickersMediaViewData()
  {
    return this.mStickersMediaViewData;
  }

  public boolean isEmpty()
  {
    return (this.mGifsMediaViewData.isEmpty()) && (this.mStickersMediaViewData.isEmpty());
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mGifsMediaViewData, paramInt);
    paramParcel.writeParcelable(this.mStickersMediaViewData, paramInt);
    paramParcel.writeString(this.mRichMessageMsgInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.data.SelectMediaViewData
 * JD-Core Version:    0.6.2
 */