package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKCommentArray extends VKList<VKApiComment>
{
  public static Parcelable.Creator<VKCommentArray> CREATOR = new Parcelable.Creator()
  {
    public VKCommentArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKCommentArray(paramAnonymousParcel);
    }

    public VKCommentArray[] newArray(int paramAnonymousInt)
    {
      return new VKCommentArray[paramAnonymousInt];
    }
  };

  public VKCommentArray()
  {
  }

  public VKCommentArray(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiComment.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKCommentArray
 * JD-Core Version:    0.6.2
 */