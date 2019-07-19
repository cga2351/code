package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VkVideoArray extends VKList<VKApiVideo>
{
  public static Parcelable.Creator<VkVideoArray> CREATOR = new Parcelable.Creator()
  {
    public VkVideoArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VkVideoArray(paramAnonymousParcel);
    }

    public VkVideoArray[] newArray(int paramAnonymousInt)
    {
      return new VkVideoArray[paramAnonymousInt];
    }
  };

  public VkVideoArray()
  {
  }

  public VkVideoArray(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiVideo.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VkVideoArray
 * JD-Core Version:    0.6.2
 */