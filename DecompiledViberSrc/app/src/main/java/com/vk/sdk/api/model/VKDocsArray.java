package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKDocsArray extends VKList<VKApiDocument>
{
  public static Parcelable.Creator<VKDocsArray> CREATOR = new Parcelable.Creator()
  {
    public VKDocsArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKDocsArray(paramAnonymousParcel);
    }

    public VKDocsArray[] newArray(int paramAnonymousInt)
    {
      return new VKDocsArray[paramAnonymousInt];
    }
  };

  public VKDocsArray()
  {
  }

  public VKDocsArray(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiDocument.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKDocsArray
 * JD-Core Version:    0.6.2
 */