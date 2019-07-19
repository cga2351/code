package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiUser extends VKApiOwner
  implements Parcelable
{
  public static Parcelable.Creator<VKApiUser> CREATOR = new Parcelable.Creator()
  {
    public VKApiUser createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiUser(paramAnonymousParcel);
    }

    public VKApiUser[] newArray(int paramAnonymousInt)
    {
      return new VKApiUser[paramAnonymousInt];
    }
  };
  public static final String FIELDS_DEFAULT = TextUtils.join(",", new String[] { "online", "online_mobile", "photo_50", "photo_100", "photo_200" });
  public static final String FIELD_ONLINE = "online";
  public static final String FIELD_ONLINE_MOBILE = "online_mobile";
  public static final String FIELD_PHOTO_100 = "photo_100";
  public static final String FIELD_PHOTO_200 = "photo_200";
  public static final String FIELD_PHOTO_400_ORIGIN = "photo_400_orig";
  public static final String FIELD_PHOTO_50 = "photo_50";
  public static final String FIELD_PHOTO_BIG = "photo_big";
  public static final String FIELD_PHOTO_MAX = "photo_max";
  public static final String FIELD_PHOTO_MAX_ORIGIN = "photo_max_orig";
  public String first_name = "DELETED";
  private String full_name;
  public String last_name = "DELETED";
  public boolean online;
  public boolean online_mobile;
  public VKPhotoSizes photo = new VKPhotoSizes();
  public String photo_100 = "http://vk.com/images/camera_b.gif";
  public String photo_200 = "http://vk.com/images/camera_a.gif";
  public String photo_200_orig = "http://vk.com/images/camera_a.gif";
  public String photo_400_orig = "";
  public String photo_50 = "http://vk.com/images/camera_c.gif";
  public String photo_big = "";
  public String photo_max = "http://vk.com/images/camera_b.gif";
  public String photo_max_orig = "http://vk.com/images/camera_a.gif";

  public VKApiUser()
  {
  }

  public VKApiUser(Parcel paramParcel)
  {
    super(paramParcel);
    this.first_name = paramParcel.readString();
    this.last_name = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.online = bool2;
      if (paramParcel.readByte() == 0)
        break label206;
    }
    while (true)
    {
      this.online_mobile = bool1;
      this.photo_50 = paramParcel.readString();
      this.photo_100 = paramParcel.readString();
      this.photo_200 = paramParcel.readString();
      this.photo = ((VKPhotoSizes)paramParcel.readParcelable(VKPhotoSizes.class.getClassLoader()));
      this.full_name = paramParcel.readString();
      this.photo_400_orig = paramParcel.readString();
      this.photo_max = paramParcel.readString();
      this.photo_max_orig = paramParcel.readString();
      this.photo_big = paramParcel.readString();
      return;
      bool2 = false;
      break;
      label206: bool1 = false;
    }
  }

  public VKApiUser(JSONObject paramJSONObject)
    throws JSONException
  {
    parse(paramJSONObject);
  }

  protected String addSquarePhoto(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
      this.photo.add(VKApiPhotoSize.create(paramString, paramInt));
    return paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public VKApiUser parse(JSONObject paramJSONObject)
  {
    super.parse(paramJSONObject);
    this.first_name = paramJSONObject.optString("first_name", this.first_name);
    this.last_name = paramJSONObject.optString("last_name", this.last_name);
    this.online = ParseUtils.parseBoolean(paramJSONObject, "online");
    this.online_mobile = ParseUtils.parseBoolean(paramJSONObject, "online_mobile");
    this.photo_50 = addSquarePhoto(paramJSONObject.optString("photo_50", this.photo_50), 50);
    this.photo_100 = addSquarePhoto(paramJSONObject.optString("photo_100", this.photo_100), 100);
    this.photo_200 = addSquarePhoto(paramJSONObject.optString("photo_200", this.photo_200), 200);
    this.photo_400_orig = paramJSONObject.optString("photo_400_orig", this.photo_400_orig);
    this.photo_max = paramJSONObject.optString("photo_max", this.photo_max);
    this.photo_max_orig = paramJSONObject.optString("photo_max_orig", this.photo_max_orig);
    this.photo_big = paramJSONObject.optString("photo_big", this.photo_big);
    this.photo.sort();
    return this;
  }

  public String toString()
  {
    if (this.full_name == null)
      this.full_name = (this.first_name + ' ' + this.last_name);
    return this.full_name;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.first_name);
    paramParcel.writeString(this.last_name);
    byte b2;
    if (this.online)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.online_mobile)
        break label132;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.photo_50);
      paramParcel.writeString(this.photo_100);
      paramParcel.writeString(this.photo_200);
      paramParcel.writeParcelable(this.photo, paramInt);
      paramParcel.writeString(this.full_name);
      paramParcel.writeString(this.photo_400_orig);
      paramParcel.writeString(this.photo_max);
      paramParcel.writeString(this.photo_max_orig);
      paramParcel.writeString(this.photo_big);
      return;
      b2 = 0;
      break;
      label132: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiUser
 * JD-Core Version:    0.6.2
 */