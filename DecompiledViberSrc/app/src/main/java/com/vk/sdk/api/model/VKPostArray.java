package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKPostArray extends VKList<VKApiPost>
{
  public static Parcelable.Creator<VKPostArray> CREATOR = new Parcelable.Creator()
  {
    public VKPostArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKPostArray(paramAnonymousParcel);
    }

    public VKPostArray[] newArray(int paramAnonymousInt)
    {
      return new VKPostArray[paramAnonymousInt];
    }
  };

  public VKPostArray()
  {
  }

  public VKPostArray(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiPost.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKPostArray
 * JD-Core Version:    0.6.2
 */