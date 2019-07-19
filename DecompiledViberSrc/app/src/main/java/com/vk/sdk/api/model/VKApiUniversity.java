package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiUniversity extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiUniversity> CREATOR = new Parcelable.Creator()
  {
    public VKApiUniversity createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiUniversity(paramAnonymousParcel);
    }

    public VKApiUniversity[] newArray(int paramAnonymousInt)
    {
      return new VKApiUniversity[paramAnonymousInt];
    }
  };
  public int chair;
  public String chair_name;
  public int city_id;
  public int country_id;
  public String education_form;
  public String education_status;
  public String faculty;
  public String faculty_name;
  private String fullName;
  public int graduation;
  public int id;
  public String name;

  public VKApiUniversity()
  {
  }

  public VKApiUniversity(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.country_id = paramParcel.readInt();
    this.city_id = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.faculty = paramParcel.readString();
    this.faculty_name = paramParcel.readString();
    this.chair = paramParcel.readInt();
    this.chair_name = paramParcel.readString();
    this.graduation = paramParcel.readInt();
    this.education_form = paramParcel.readString();
    this.education_status = paramParcel.readString();
  }

  public VKApiUniversity(JSONObject paramJSONObject)
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

  public VKApiUniversity parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.country_id = paramJSONObject.optInt("country_id");
    this.city_id = paramJSONObject.optInt("city_id");
    this.name = paramJSONObject.optString("name");
    this.faculty = paramJSONObject.optString("faculty");
    this.faculty_name = paramJSONObject.optString("faculty_name");
    this.chair = paramJSONObject.optInt("chair");
    this.chair_name = paramJSONObject.optString("chair_name");
    this.graduation = paramJSONObject.optInt("graduation");
    this.education_form = paramJSONObject.optString("education_form");
    this.education_status = paramJSONObject.optString("education_status");
    return this;
  }

  public String toString()
  {
    if (this.fullName == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.name);
      localStringBuilder.append(" '");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.graduation % 100);
      localStringBuilder.append(String.format("%02d", arrayOfObject));
      if (!TextUtils.isEmpty(this.faculty_name))
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(this.faculty_name);
      }
      if (!TextUtils.isEmpty(this.chair_name))
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(this.chair_name);
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
    paramParcel.writeString(this.faculty);
    paramParcel.writeString(this.faculty_name);
    paramParcel.writeInt(this.chair);
    paramParcel.writeString(this.chair_name);
    paramParcel.writeInt(this.graduation);
    paramParcel.writeString(this.education_form);
    paramParcel.writeString(this.education_status);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiUniversity
 * JD-Core Version:    0.6.2
 */