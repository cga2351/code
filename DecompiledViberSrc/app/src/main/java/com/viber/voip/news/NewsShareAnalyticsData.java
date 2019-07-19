package com.viber.voip.news;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.da;

public class NewsShareAnalyticsData
  implements Parcelable
{
  public static final Parcelable.Creator<NewsShareAnalyticsData> CREATOR = new Parcelable.Creator()
  {
    public NewsShareAnalyticsData a(Parcel paramAnonymousParcel)
    {
      return new NewsShareAnalyticsData(paramAnonymousParcel);
    }

    public NewsShareAnalyticsData[] a(int paramAnonymousInt)
    {
      return new NewsShareAnalyticsData[paramAnonymousInt];
    }
  };
  public final String baseProviderUrl;
  public final int newsProviderId;
  public final String origin;

  public NewsShareAnalyticsData(int paramInt, String paramString1, String paramString2)
  {
    this.newsProviderId = paramInt;
    this.baseProviderUrl = paramString1;
    this.origin = paramString2;
  }

  protected NewsShareAnalyticsData(Parcel paramParcel)
  {
    this.newsProviderId = paramParcel.readInt();
    this.baseProviderUrl = paramParcel.readString();
    this.origin = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean isValid()
  {
    return (!da.a(this.baseProviderUrl)) && (!da.a(this.origin));
  }

  public String toString()
  {
    return "NewsShareAnalyticsData{newsProviderId=" + this.newsProviderId + "baseProviderUrl='" + this.baseProviderUrl + '\'' + ", origin='" + this.origin + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.newsProviderId);
    paramParcel.writeString(this.baseProviderUrl);
    paramParcel.writeString(this.origin);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.NewsShareAnalyticsData
 * JD-Core Version:    0.6.2
 */