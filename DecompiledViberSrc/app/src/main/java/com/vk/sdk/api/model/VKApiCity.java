package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class VKApiCity extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiCity> CREATOR = new Parcelable.Creator()
  {
    public VKApiCity createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiCity(paramAnonymousParcel);
    }

    public VKApiCity[] newArray(int paramAnonymousInt)
    {
      return new VKApiCity[paramAnonymousInt];
    }
  };
  public int id;
  public String title;

  public VKApiCity()
  {
  }

  public VKApiCity(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.title = paramParcel.readString();
  }

  public VKApiCity(JSONObject paramJSONObject)
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

  public VKApiCity parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.title = paramJSONObject.optString("title");
    return this;
  }

  public String toString()
  {
    return this.title;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.title);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiCity
 * JD-Core Version:    0.6.2
 */