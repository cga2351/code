package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class QuickContactProfileImageMessage extends ImageMessage
{
  public static final Parcelable.Creator<QuickContactProfileImageMessage> CREATOR = new Parcelable.Creator()
  {
    public QuickContactProfileImageMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new QuickContactProfileImageMessage(paramAnonymousParcel);
    }

    public QuickContactProfileImageMessage[] newArray(int paramAnonymousInt)
    {
      return new QuickContactProfileImageMessage[paramAnonymousInt];
    }
  };

  public QuickContactProfileImageMessage(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, paramJSONObject);
  }

  QuickContactProfileImageMessage(Parcel paramParcel)
  {
    super(paramParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.QuickContactProfileImageMessage
 * JD-Core Version:    0.6.2
 */