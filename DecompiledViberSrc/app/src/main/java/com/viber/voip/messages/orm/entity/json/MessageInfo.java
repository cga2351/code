package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MessageInfo> CREATOR = new Parcelable.Creator()
  {
    public MessageInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MessageInfo(paramAnonymousParcel);
    }

    public MessageInfo[] newArray(int paramAnonymousInt)
    {
      return new MessageInfo[paramAnonymousInt];
    }
  };
  private static final String KEY_CDR_ACTION = "OnClick";
  private static final String KEY_FM_TYPE = "FmType";
  public static final String KEY_PREVIEW_TEXT = "PreviewText";
  private static final String KEY_PREVIEW_TEXT_INDEX = "PreviewTextIndex";
  public static final String KEY_PUSH_ENTRY = "PushEntry";
  public static final String KEY_PUSH_TEXT = "PushText";
  private static final String KEY_PUSH_TEXT_INDEX = "PushTextIndex";
  private static final String KEY_TRACKING_DATA = "TrackingData";
  private String mCdrAction;

  @MessageInfoFmType
  private String mFmType;
  private String mPreviewText;
  private int mPreviewTextIndex;
  private String mPushText;
  private int mPushTextIndex;
  private String mTrackingData;
  private MessageType mType;

  MessageInfo(Parcel paramParcel)
  {
    this.mType = MessageType.values()[paramParcel.readInt()];
    this.mCdrAction = paramParcel.readString();
    this.mPreviewText = paramParcel.readString();
    this.mPushText = paramParcel.readString();
    this.mPreviewTextIndex = paramParcel.readInt();
    this.mPushTextIndex = paramParcel.readInt();
    this.mTrackingData = paramParcel.readString();
  }

  public MessageInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.mType = MessageType.INFO;
    this.mCdrAction = paramJSONObject.optString("OnClick");
    this.mPreviewText = paramJSONObject.optString("PreviewText");
    this.mPushText = paramJSONObject.optString("PushText");
    this.mPreviewTextIndex = paramJSONObject.optInt("PreviewTextIndex", -1);
    this.mPushTextIndex = paramJSONObject.optInt("PushTextIndex", -1);
    this.mTrackingData = paramJSONObject.optString("TrackingData");
    this.mFmType = paramJSONObject.optString("FmType");
  }

  public int describeContents()
  {
    return 0;
  }

  public String getCdrAction()
  {
    return this.mCdrAction;
  }

  @MessageInfoFmType
  public String getFmType()
  {
    return this.mFmType;
  }

  String getPreviewText()
  {
    return this.mPreviewText;
  }

  int getPreviewTextIndex()
  {
    return this.mPreviewTextIndex;
  }

  String getPushText()
  {
    return this.mPushText;
  }

  int getPushTextIndex()
  {
    return this.mPushTextIndex;
  }

  public String getTrackingData()
  {
    return this.mTrackingData;
  }

  public MessageType getType()
  {
    return this.mType;
  }

  public void setTrackingData(String paramString)
  {
    this.mTrackingData = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Info [PreviewText=").append(this.mPreviewText).append(", PushText=").append(this.mPushText).append(", OnClick=").append(this.mCdrAction).append(", PreviewTextIndex=").append(this.mPreviewTextIndex).append(", PushTextIndex=").append(this.mPushTextIndex).append(", TrackingData=").append(this.mTrackingData).append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mType.ordinal());
    paramParcel.writeString(this.mCdrAction);
    paramParcel.writeString(this.mPreviewText);
    paramParcel.writeString(this.mPushText);
    paramParcel.writeInt(this.mPreviewTextIndex);
    paramParcel.writeInt(this.mPushTextIndex);
    paramParcel.writeString(this.mTrackingData);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.MessageInfo
 * JD-Core Version:    0.6.2
 */