package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.ActionFactory;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseMessage
  implements Parcelable
{
  public static final String KEY_ACTION = "Action";
  public static final String KEY_INVISIBLE = "Invisible";
  private static final String KEY_MESSAGE_WIDTH = "Width";
  final Action mAction;
  private String mCdrAction;
  final int mElementIndex;
  final MessageType mType;
  final MessageWidth mWidth;

  public BaseMessage(int paramInt, MessageType paramMessageType, JSONObject paramJSONObject)
    throws JSONException
  {
    this.mType = paramMessageType;
    this.mWidth = MessageWidth.toEnum(paramJSONObject.optInt("Width", MessageWidth.FULL.ordinal()));
    this.mAction = ActionFactory.createAction(paramJSONObject.optJSONObject("Action"));
    this.mElementIndex = paramInt;
    validate();
  }

  BaseMessage(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.mType = MessageType.values()[i];
    int j = paramParcel.readInt();
    if (j != -1);
    for (MessageWidth localMessageWidth = MessageWidth.values()[j]; ; localMessageWidth = MessageWidth.FULL)
    {
      this.mWidth = localMessageWidth;
      this.mAction = ((Action)paramParcel.readParcelable(BaseMessage.class.getClassLoader()));
      this.mCdrAction = paramParcel.readString();
      this.mElementIndex = paramParcel.readInt();
      return;
    }
  }

  private void validate()
    throws JSONException
  {
    if ((this.mType == MessageType.BUTTON) && (this.mAction == null))
      throw new JSONException("Invalid JSON. Button action is mandatory.");
  }

  public int describeContents()
  {
    return 0;
  }

  public Action getAction()
  {
    return this.mAction;
  }

  public String getCdrAction()
  {
    return this.mCdrAction;
  }

  public int getElementIndex()
  {
    return this.mElementIndex;
  }

  public int getGravity(boolean paramBoolean)
  {
    return 0;
  }

  public int getHeightPx()
  {
    return -2;
  }

  public MessageType getType()
  {
    return this.mType;
  }

  public MessageWidth getWidth()
  {
    return this.mWidth;
  }

  public int getWidthPx()
  {
    return getWidthPx(false);
  }

  public int getWidthPx(boolean paramBoolean)
  {
    return -1;
  }

  void setCdrAction(String paramString)
  {
    this.mCdrAction = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mType.ordinal());
    if (this.mWidth != null);
    for (int i = this.mWidth.ordinal(); ; i = -1)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.mAction, paramInt);
      paramParcel.writeString(this.mCdrAction);
      paramParcel.writeInt(this.mElementIndex);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.BaseMessage
 * JD-Core Version:    0.6.2
 */