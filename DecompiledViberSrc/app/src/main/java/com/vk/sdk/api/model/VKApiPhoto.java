package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiPhoto extends VKAttachments.VKApiAttachment
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiPhoto> CREATOR = new Parcelable.Creator()
  {
    public VKApiPhoto createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiPhoto(paramAnonymousParcel);
    }

    public VKApiPhoto[] newArray(int paramAnonymousInt)
    {
      return new VKApiPhoto[paramAnonymousInt];
    }
  };
  public String access_key;
  public int album_id;
  public boolean can_comment;
  public int comments;
  public long date;
  public int height;
  public int id;
  public int likes;
  public int owner_id;
  public String photo_1280;
  public String photo_130;
  public String photo_2560;
  public String photo_604;
  public String photo_75;
  public String photo_807;
  public VKPhotoSizes src = new VKPhotoSizes();
  public int tags;
  public String text;
  public boolean user_likes;
  public int width;

  public VKApiPhoto()
  {
  }

  public VKApiPhoto(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.album_id = paramParcel.readInt();
    this.owner_id = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.date = paramParcel.readLong();
    this.src = ((VKPhotoSizes)paramParcel.readParcelable(VKPhotoSizes.class.getClassLoader()));
    this.photo_75 = paramParcel.readString();
    this.photo_130 = paramParcel.readString();
    this.photo_604 = paramParcel.readString();
    this.photo_807 = paramParcel.readString();
    this.photo_1280 = paramParcel.readString();
    this.photo_2560 = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.user_likes = bool2;
      if (paramParcel.readByte() == 0)
        break label201;
    }
    while (true)
    {
      this.can_comment = bool1;
      this.likes = paramParcel.readInt();
      this.comments = paramParcel.readInt();
      this.tags = paramParcel.readInt();
      this.access_key = paramParcel.readString();
      return;
      bool2 = false;
      break;
      label201: bool1 = false;
    }
  }

  public VKApiPhoto(String paramString)
  {
    if (paramString.startsWith("photo"))
    {
      String[] arrayOfString = paramString.substring("photo".length()).split("_");
      this.owner_id = Integer.parseInt(arrayOfString[0]);
      this.id = Integer.parseInt(arrayOfString[1]);
    }
  }

  public VKApiPhoto(JSONObject paramJSONObject)
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

  public String getType()
  {
    return "photo";
  }

  public VKApiPhoto parse(JSONObject paramJSONObject)
  {
    this.album_id = paramJSONObject.optInt("album_id");
    this.date = paramJSONObject.optLong("date");
    this.height = paramJSONObject.optInt("height");
    this.width = paramJSONObject.optInt("width");
    this.owner_id = paramJSONObject.optInt("owner_id");
    this.id = paramJSONObject.optInt("id");
    this.text = paramJSONObject.optString("text");
    this.access_key = paramJSONObject.optString("access_key");
    this.photo_75 = paramJSONObject.optString("photo_75");
    this.photo_130 = paramJSONObject.optString("photo_130");
    this.photo_604 = paramJSONObject.optString("photo_604");
    this.photo_807 = paramJSONObject.optString("photo_807");
    this.photo_1280 = paramJSONObject.optString("photo_1280");
    this.photo_2560 = paramJSONObject.optString("photo_2560");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("likes");
    this.likes = ParseUtils.parseInt(localJSONObject, "count");
    this.user_likes = ParseUtils.parseBoolean(localJSONObject, "user_likes");
    this.comments = ParseUtils.parseInt(paramJSONObject.optJSONObject("comments"), "count");
    this.tags = ParseUtils.parseInt(paramJSONObject.optJSONObject("tags"), "count");
    this.can_comment = ParseUtils.parseBoolean(paramJSONObject, "can_comment");
    this.src.setOriginalDimension(this.width, this.height);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sizes");
    if (localJSONArray != null)
    {
      this.src.fill(localJSONArray);
      return this;
    }
    if (!TextUtils.isEmpty(this.photo_75))
      this.src.add(VKApiPhotoSize.create(this.photo_75, 's', this.width, this.height));
    if (!TextUtils.isEmpty(this.photo_130))
      this.src.add(VKApiPhotoSize.create(this.photo_130, 'm', this.width, this.height));
    if (!TextUtils.isEmpty(this.photo_604))
      this.src.add(VKApiPhotoSize.create(this.photo_604, 'x', this.width, this.height));
    if (!TextUtils.isEmpty(this.photo_807))
      this.src.add(VKApiPhotoSize.create(this.photo_807, 'y', this.width, this.height));
    if (!TextUtils.isEmpty(this.photo_1280))
      this.src.add(VKApiPhotoSize.create(this.photo_1280, 'z', this.width, this.height));
    if (!TextUtils.isEmpty(this.photo_2560))
      this.src.add(VKApiPhotoSize.create(this.photo_2560, 'w', this.width, this.height));
    this.src.sort();
    return this;
  }

  public CharSequence toAttachmentString()
  {
    StringBuilder localStringBuilder = new StringBuilder("photo").append(this.owner_id).append('_').append(this.id);
    if (!TextUtils.isEmpty(this.access_key))
    {
      localStringBuilder.append('_');
      localStringBuilder.append(this.access_key);
    }
    return localStringBuilder;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.album_id);
    paramParcel.writeInt(this.owner_id);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.text);
    paramParcel.writeLong(this.date);
    paramParcel.writeParcelable(this.src, paramInt);
    paramParcel.writeString(this.photo_75);
    paramParcel.writeString(this.photo_130);
    paramParcel.writeString(this.photo_604);
    paramParcel.writeString(this.photo_807);
    paramParcel.writeString(this.photo_1280);
    paramParcel.writeString(this.photo_2560);
    byte b2;
    if (this.user_likes)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.can_comment)
        break label182;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.likes);
      paramParcel.writeInt(this.comments);
      paramParcel.writeInt(this.tags);
      paramParcel.writeString(this.access_key);
      return;
      b2 = 0;
      break;
      label182: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiPhoto
 * JD-Core Version:    0.6.2
 */