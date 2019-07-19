package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiSchool extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiSchool> CREATOR = new Parcelable.Creator()
  {
    public VKApiSchool createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiSchool(paramAnonymousParcel);
    }

    public VKApiSchool[] newArray(int paramAnonymousInt)
    {
      return new VKApiSchool[paramAnonymousInt];
    }
  };
  public int city_id;
  public String clazz;
  public int country_id;
  private String fullName;
  public int id;
  public String name;
  public String speciality;
  public int year_from;
  public int year_graduated;
  public int year_to;

  public VKApiSchool()
  {
  }

  public VKApiSchool(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.country_id = paramParcel.readInt();
    this.city_id = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.year_from = paramParcel.readInt();
    this.year_to = paramParcel.readInt();
    this.year_graduated = paramParcel.readInt();
    this.clazz = paramParcel.readString();
    this.speciality = paramParcel.readString();
  }

  public VKApiSchool(JSONObject paramJSONObject)
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

  public VKApiSchool parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.country_id = paramJSONObject.optInt("country_id");
    this.city_id = paramJSONObject.optInt("city_id");
    this.name = paramJSONObject.optString("name");
    this.year_from = paramJSONObject.optInt("year_from");
    this.year_to = paramJSONObject.optInt("year_to");
    this.year_graduated = paramJSONObject.optInt("year_graduated");
    this.clazz = paramJSONObject.optString("class");
    this.speciality = paramJSONObject.optString("speciality");
    return this;
  }

  public String toString()
  {
    if (this.fullName == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.name);
      if (this.year_graduated != 0)
      {
        localStringBuilder.append(" '");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(this.year_graduated % 100);
        localStringBuilder.append(String.format("%02d", arrayOfObject));
      }
      if ((this.year_from != 0) && (this.year_to != 0))
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(this.year_from);
        localStringBuilder.append('-');
        localStringBuilder.append(this.year_to);
      }
      if (!TextUtils.isEmpty(this.clazz))
      {
        localStringBuilder.append('(');
        localStringBuilder.append(this.clazz);
        localStringBuilder.append(')');
      }
      if (!TextUtils.isEmpty(this.speciality))
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(this.speciality);
      }
      this.fullName = localStringBuilder.toString();
    }
    return this.fullName;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.country_id);
    paramParcel.writeInt(this.city_id);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.year_from);
    paramParcel.writeInt(this.year_to);
    paramParcel.writeInt(this.year_graduated);
    paramParcel.writeString(this.clazz);
    paramParcel.writeString(this.speciality);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiSchool
 * JD-Core Version:    0.6.2
 */