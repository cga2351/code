package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiPlace extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiPlace> CREATOR = new Parcelable.Creator()
  {
    public VKApiPlace createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiPlace(paramAnonymousParcel);
    }

    public VKApiPlace[] newArray(int paramAnonymousInt)
    {
      return new VKApiPlace[paramAnonymousInt];
    }
  };
  public String address;
  public int checkins;
  public int city_id;
  public int country_id;
  public long created;
  public int id;
  public double latitude;
  public double longitude;
  public String title;
  public long updated;

  public VKApiPlace()
  {
  }

  public VKApiPlace(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.latitude = paramParcel.readDouble();
    this.longitude = paramParcel.readDouble();
    this.created = paramParcel.readLong();
    this.checkins = paramParcel.readInt();
    this.updated = paramParcel.readLong();
    this.country_id = paramParcel.readInt();
    this.city_id = paramParcel.readInt();
    this.address = paramParcel.readString();
  }

  public VKApiPlace(JSONObject paramJSONObject)
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

  public VKApiPlace parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.title = paramJSONObject.optString("title");
    this.latitude = paramJSONObject.optDouble("latitude");
    this.longitude = paramJSONObject.optDouble("longitude");
    this.created = paramJSONObject.optLong("created");
    this.checkins = paramJSONObject.optInt("checkins");
    this.updated = paramJSONObject.optLong("updated");
    this.country_id = paramJSONObject.optInt("country");
    this.city_id = paramJSONObject.optInt("city");
    this.address = paramJSONObject.optString("address");
    return this;
  }

  public String toString()
  {
    return this.address;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.title);
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeLong(this.created);
    paramParcel.writeInt(this.checkins);
    paramParcel.writeLong(this.updated);
    paramParcel.writeInt(this.country_id);
    paramParcel.writeInt(this.city_id);
    paramParcel.writeString(this.address);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiPlace
 * JD-Core Version:    0.6.2
 */