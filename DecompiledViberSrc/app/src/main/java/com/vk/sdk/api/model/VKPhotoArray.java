package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKPhotoArray extends VKList<VKApiPhoto>
{
  public static Parcelable.Creator<VKPhotoArray> CREATOR = new Parcelable.Creator()
  {
    public VKPhotoArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKPhotoArray(paramAnonymousParcel);
    }

    public VKPhotoArray[] newArray(int paramAnonymousInt)
    {
      return new VKPhotoArray[paramAnonymousInt];
    }
  };

  public VKPhotoArray()
  {
  }

  public VKPhotoArray(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiPhoto.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKPhotoArray
 * JD-Core Version:    0.6.2
 */