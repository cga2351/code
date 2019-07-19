package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiCountry extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiCountry> CREATOR = new Parcelable.Creator()
  {
    public VKApiCountry createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiCountry(paramAnonymousParcel);
    }

    public VKApiCountry[] newArray(int paramAnonymousInt)
    {
      return new VKApiCountry[paramAnonymousInt];
    }
  };
  public int id;
  public String title;

  public VKApiCountry()
  {
  }

  public VKApiCountry(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.title = paramParcel.readString();
  }

  public VKApiCountry(JSONObject paramJSONObject)
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

  public VKApiCountry parse(JSONObject paramJSONObject)
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
 * Qualified Name:     com.vk.sdk.api.model.VKApiCountry
 * JD-Core Version:    0.6.2
 */