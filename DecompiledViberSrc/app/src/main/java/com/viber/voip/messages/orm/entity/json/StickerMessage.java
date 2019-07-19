package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class StickerMessage extends BaseMessage
{
  public static final Parcelable.Creator<StickerMessage> CREATOR = new Parcelable.Creator()
  {
    public StickerMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new StickerMessage(paramAnonymousParcel);
    }

    public StickerMessage[] newArray(int paramAnonymousInt)
    {
      return new StickerMessage[paramAnonymousInt];
    }
  };
  private static final String KEY_STICKER_ID = "StickerID";
  private final int mStickerId;

  public StickerMessage(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, MessageType.STICKER, paramJSONObject);
    this.mStickerId = paramJSONObject.getInt("StickerID");
  }

  StickerMessage(Parcel paramParcel)
  {
    super(paramParcel);
    this.mStickerId = paramParcel.readInt();
  }

  public int getStickerId()
  {
    return this.mStickerId;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StickerMessage [stickerId=").append(this.mStickerId).append(", width=").append(this.mWidth).append(", action=").append(this.mAction).append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mStickerId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.StickerMessage
 * JD-Core Version:    0.6.2
 */