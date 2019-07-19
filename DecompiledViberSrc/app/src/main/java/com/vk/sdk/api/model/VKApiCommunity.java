package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONObject;

public class VKApiCommunity extends VKApiOwner
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiCommunity> CREATOR = new Parcelable.Creator()
  {
    public VKApiCommunity createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiCommunity(paramAnonymousParcel);
    }

    public VKApiCommunity[] newArray(int paramAnonymousInt)
    {
      return new VKApiCommunity[paramAnonymousInt];
    }
  };
  static final String PHOTO_100 = "http://vk.com/images/community_100.gif";
  static final String PHOTO_50 = "http://vk.com/images/community_50.gif";
  private static final String TYPE_EVENT = "event";
  private static final String TYPE_GROUP = "group";
  private static final String TYPE_PAGE = "page";
  public int admin_level;
  public boolean is_admin;
  public int is_closed;
  public boolean is_member;
  public String name;
  public VKPhotoSizes photo = new VKPhotoSizes();
  public String photo_100;
  public String photo_200;
  public String photo_50;
  public String screen_name;
  public int type;

  public VKApiCommunity()
  {
  }

  public VKApiCommunity(Parcel paramParcel)
  {
    super(paramParcel);
    this.name = paramParcel.readString();
    this.screen_name = paramParcel.readString();
    this.is_closed = paramParcel.readInt();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.is_admin = bool2;
      this.admin_level = paramParcel.readInt();
      if (paramParcel.readByte() == 0)
        break label130;
    }
    while (true)
    {
      this.is_member = bool1;
      this.type = paramParcel.readInt();
      this.photo_50 = paramParcel.readString();
      this.photo_100 = paramParcel.readString();
      this.photo_200 = paramParcel.readString();
      this.photo = ((VKPhotoSizes)paramParcel.readParcelable(VKPhotoSizes.class.getClassLoader()));
      return;
      bool2 = false;
      break;
      label130: bool1 = false;
    }
  }

  public VKApiCommunity(JSONObject paramJSONObject)
  {
    parse(paramJSONObject);
  }

  public int describeContents()
  {
    return 0;
  }

  public VKApiCommunity parse(JSONObject paramJSONObject)
  {
    super.parse(paramJSONObject);
    this.name = paramJSONObject.optString("name");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(Math.abs(this.id));
    this.screen_name = paramJSONObject.optString("screen_name", String.format("club%d", arrayOfObject));
    this.is_closed = paramJSONObject.optInt("is_closed");
    this.is_admin = ParseUtils.parseBoolean(paramJSONObject, "is_admin");
    this.admin_level = paramJSONObject.optInt("admin_level");
    this.is_member = ParseUtils.parseBoolean(paramJSONObject, "is_member");
    this.photo_50 = paramJSONObject.optString("photo_50", "http://vk.com/images/community_50.gif");
    if (!TextUtils.isEmpty(this.photo_50))
      this.photo.add(VKApiPhotoSize.create(this.photo_50, 50));
    this.photo_100 = paramJSONObject.optString("photo_100", "http://vk.com/images/community_100.gif");
    if (!TextUtils.isEmpty(this.photo_100))
      this.photo.add(VKApiPhotoSize.create(this.photo_100, 100));
    this.photo_200 = paramJSONObject.optString("photo_200", null);
    if (!TextUtils.isEmpty(this.photo_200))
      this.photo.add(VKApiPhotoSize.create(this.photo_200, 200));
    this.photo.sort();
    String str = paramJSONObject.optString("type", "group");
    if ("group".equals(str))
      this.type = 0;
    do
    {
      return this;
      if ("page".equals(str))
      {
        this.type = 1;
        return this;
      }
    }
    while (!"event".equals(str));
    this.type = 2;
    return this;
  }

  public String toString()
  {
    return this.name;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.screen_name);
    paramParcel.writeInt(this.is_closed);
    byte b2;
    if (this.is_admin)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      paramParcel.writeInt(this.admin_level);
      if (!this.is_member)
        break label116;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.photo_50);
      paramParcel.writeString(this.photo_100);
      paramParcel.writeString(this.photo_200);
      paramParcel.writeParcelable(this.photo, paramInt);
      return;
      b2 = 0;
      break;
      label116: b1 = 0;
    }
  }

  public static class AdminLevel
  {
    public static final int ADMIN = 3;
    public static final int EDITOR = 2;
    public static final int MODERATOR = 1;
  }

  public static class Status
  {
    public static final int CLOSED = 1;
    public static final int OPEN = 0;
    public static final int PRIVATE = 2;
  }

  public static class Type
  {
    public static final int EVENT = 2;
    public static final int GROUP = 0;
    public static final int PAGE = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiCommunity
 * JD-Core Version:    0.6.2
 */