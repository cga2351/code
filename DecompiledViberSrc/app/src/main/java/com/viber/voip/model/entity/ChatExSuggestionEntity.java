package com.viber.voip.model.entity;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ChatExSuggestionEntity extends b
  implements Parcelable
{
  public static final Parcelable.Creator<ChatExSuggestionEntity> CREATOR = new Parcelable.Creator()
  {
    public ChatExSuggestionEntity a(Parcel paramAnonymousParcel)
    {
      return new ChatExSuggestionEntity(paramAnonymousParcel);
    }

    public ChatExSuggestionEntity[] a(int paramAnonymousInt)
    {
      return new ChatExSuggestionEntity[paramAnonymousInt];
    }
  };
  private static final int INDX_COUNTRY = 3;
  private static final int INDX_ID = 0;
  private static final int INDX_KEYWORD = 1;
  private static final int INDX_SERVICE_URI = 2;
  private static final int INDX_TIMEFRAME_FROM = 4;
  private static final int INDX_TIMEFRAME_TO = 5;
  public static final String[] PROJECTIONS = { "chatex_suggestions._id", "chatex_suggestions.keyword", "chatex_suggestions.service_uri", "chatex_suggestions.country", "chatex_suggestions.timeframe_from", "chatex_suggestions.timeframe_to" };
  private String mCountry;
  private String mKeyword;
  private String mServiceUri;
  private long mTimeframeFrom;
  private long mTimeframeTo;

  public ChatExSuggestionEntity(Cursor paramCursor)
  {
    this.id = paramCursor.getLong(0);
    this.mKeyword = paramCursor.getString(1);
    this.mServiceUri = paramCursor.getString(2);
    this.mCountry = paramCursor.getString(3);
    this.mTimeframeFrom = paramCursor.getLong(4);
    this.mTimeframeTo = paramCursor.getLong(5);
  }

  protected ChatExSuggestionEntity(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.mKeyword = paramParcel.readString();
    this.mServiceUri = paramParcel.readString();
    this.mCountry = paramParcel.readString();
    this.mTimeframeFrom = paramParcel.readLong();
    this.mTimeframeTo = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getCountry()
  {
    return this.mCountry;
  }

  public String getKeyword()
  {
    return this.mKeyword;
  }

  public String getServiceUri()
  {
    return this.mServiceUri;
  }

  public long getTimeframeFrom()
  {
    return this.mTimeframeFrom;
  }

  public long getTimeframeTo()
  {
    return this.mTimeframeTo;
  }

  public void setCountry(String paramString)
  {
    this.mCountry = paramString;
  }

  public void setKeyword(String paramString)
  {
    this.mKeyword = paramString;
  }

  public void setServiceUri(String paramString)
  {
    this.mServiceUri = paramString;
  }

  public void setTimeframeFrom(long paramLong)
  {
    this.mTimeframeFrom = paramLong;
  }

  public void setTimeframeTo(long paramLong)
  {
    this.mTimeframeTo = paramLong;
  }

  public String toString()
  {
    return "ChatExSuggestionEntity{mKeyword='" + this.mKeyword + '\'' + ", mServiceUri='" + this.mServiceUri + '\'' + ", mCountry='" + this.mCountry + '\'' + ", mTimeframeFrom=" + this.mTimeframeFrom + ", mTimeframeTo=" + this.mTimeframeTo + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.mKeyword);
    paramParcel.writeString(this.mServiceUri);
    paramParcel.writeString(this.mCountry);
    paramParcel.writeLong(this.mTimeframeFrom);
    paramParcel.writeLong(this.mTimeframeTo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.ChatExSuggestionEntity
 * JD-Core Version:    0.6.2
 */