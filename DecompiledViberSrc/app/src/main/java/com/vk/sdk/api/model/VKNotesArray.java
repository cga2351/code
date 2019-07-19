package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKNotesArray extends VKList<VKApiNote>
{
  public static Parcelable.Creator<VKNotesArray> CREATOR = new Parcelable.Creator()
  {
    public VKNotesArray createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKNotesArray(paramAnonymousParcel);
    }

    public VKNotesArray[] newArray(int paramAnonymousInt)
    {
      return new VKNotesArray[paramAnonymousInt];
    }
  };

  public VKNotesArray()
  {
  }

  public VKNotesArray(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    fill(paramJSONObject, VKApiNote.class);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKNotesArray
 * JD-Core Version:    0.6.2
 */