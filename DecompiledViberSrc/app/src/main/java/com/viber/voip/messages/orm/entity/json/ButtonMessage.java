package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class ButtonMessage extends BaseMessage
{
  public static final Parcelable.Creator<ButtonMessage> CREATOR = new Parcelable.Creator()
  {
    public ButtonMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ButtonMessage(paramAnonymousParcel);
    }

    public ButtonMessage[] newArray(int paramAnonymousInt)
    {
      return new ButtonMessage[paramAnonymousInt];
    }
  };
  public static final String KEY_BTN_ACTION = "ButtonAction";
  public static final String KEY_BTN_CAPTION = "ButtonCaption";
  public static final String KEY_BUTTON_CAPTION = "Caption";
  private final String mCaption;

  public ButtonMessage(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, MessageType.BUTTON, paramJSONObject);
    this.mCaption = paramJSONObject.getString("Caption");
  }

  ButtonMessage(Parcel paramParcel)
  {
    super(paramParcel);
    this.mCaption = paramParcel.readString();
  }

  public String getCaption()
  {
    return this.mCaption;
  }

  public int getGravity(boolean paramBoolean)
  {
    return 1;
  }

  public int getWidthPx(boolean paramBoolean)
  {
    if (paramBoolean)
      return -2;
    return -1;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Button [caption=").append(this.mCaption).append(", width=").append(this.mWidth).append(", action=").append(this.mAction).append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mCaption);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.ButtonMessage
 * JD-Core Version:    0.6.2
 */