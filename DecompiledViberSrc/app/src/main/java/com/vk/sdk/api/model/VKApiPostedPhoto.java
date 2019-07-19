package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class VKApiPostedPhoto extends VKApiPhoto
{
  public static Parcelable.Creator<VKApiPostedPhoto> CREATOR = new Parcelable.Creator()
  {
    public VKApiPostedPhoto createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiPostedPhoto(paramAnonymousParcel);
    }

    public VKApiPostedPhoto[] newArray(int paramAnonymousInt)
    {
      return new VKApiPostedPhoto[paramAnonymousInt];
    }
  };

  public VKApiPostedPhoto()
  {
  }

  public VKApiPostedPhoto(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public String getType()
  {
    return "posted_photo";
  }

  public VKApiPostedPhoto parse(JSONObject paramJSONObject)
  {
    super.parse(paramJSONObject);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiPostedPhoto
 * JD-Core Version:    0.6.2
 */