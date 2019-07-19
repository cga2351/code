package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKUsersArray extends VKList<VKApiUserFull>
{
  public static Parcelable.Creator<VKUsersArray> CREATOR = new Parcelable.Creator()
  {
    public VKUsersArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKUsersArray(paramAnonymousParcel);
    }

    public VKUsersArray[] newArray(int paramAnonymousInt)
    {
      return new VKUsersArray[paramAnonymousInt];
    }
  };

  public VKUsersArray()
  {
  }

  public VKUsersArray(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiUserFull.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKUsersArray
 * JD-Core Version:    0.6.2
 */