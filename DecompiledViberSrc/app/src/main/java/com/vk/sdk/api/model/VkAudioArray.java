package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VkAudioArray extends VKList<VKApiAudio>
{
  public static Parcelable.Creator<VkAudioArray> CREATOR = new Parcelable.Creator()
  {
    public VkAudioArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VkAudioArray(paramAnonymousParcel);
    }

    public VkAudioArray[] newArray(int paramAnonymousInt)
    {
      return new VkAudioArray[paramAnonymousInt];
    }
  };

  public VkAudioArray()
  {
  }

  public VkAudioArray(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiAudio.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VkAudioArray
 * JD-Core Version:    0.6.2
 */