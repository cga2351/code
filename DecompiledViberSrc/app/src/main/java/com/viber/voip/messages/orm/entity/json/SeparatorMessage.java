package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class SeparatorMessage extends BaseMessage
{
  public static final Parcelable.Creator<SeparatorMessage> CREATOR = new Parcelable.Creator()
  {
    public SeparatorMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new SeparatorMessage(paramAnonymousParcel);
    }

    public SeparatorMessage[] newArray(int paramAnonymousInt)
    {
      return new SeparatorMessage[paramAnonymousInt];
    }
  };

  public SeparatorMessage(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, MessageType.SEPARATOR, paramJSONObject);
  }

  SeparatorMessage(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Separator [").append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.SeparatorMessage
 * JD-Core Version:    0.6.2
 */