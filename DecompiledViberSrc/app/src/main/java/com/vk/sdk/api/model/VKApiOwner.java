package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiOwner extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiOwner> CREATOR = new Parcelable.Creator()
  {
    public VKApiOwner createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiOwner(paramAnonymousParcel);
    }

    public VKApiOwner[] newArray(int paramAnonymousInt)
    {
      return new VKApiOwner[paramAnonymousInt];
    }
  };
  public int id;

  public VKApiOwner()
  {
  }

  public VKApiOwner(int paramInt)
  {
    this.id = paramInt;
  }

  public VKApiOwner(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
  }

  public VKApiOwner(JSONObject paramJSONObject)
    throws JSONException
  {
    parse(paramJSONObject);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getId()
  {
    return this.id;
  }

  public VKApiOwner parse(JSONObject paramJSONObject)
  {
    this.fields = paramJSONObject;
    this.id = paramJSONObject.optInt("id");
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiOwner
 * JD-Core Version:    0.6.2
 */