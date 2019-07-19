package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiVideo extends VKAttachments.VKApiAttachment
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiVideo> CREATOR = new Parcelable.Creator()
  {
    public VKApiVideo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiVideo(paramAnonymousParcel);
    }

    public VKApiVideo[] newArray(int paramAnonymousInt)
    {
      return new VKApiVideo[paramAnonymousInt];
    }
  };
  public String access_key;
  public int album_id;
  public boolean can_comment;
  public boolean can_repost;
  public int comments;
  public long date;
  public String description;
  public int duration;
  public String external;
  public int id;
  public int likes;
  public String link;
  public String mp4_240;
  public String mp4_360;
  public String mp4_480;
  public String mp4_720;
  public int owner_id;
  public VKPhotoSizes photo = new VKPhotoSizes();
  public String photo_130;
  public String photo_320;
  public String photo_640;
  public String player;
  public int privacy_comment;
  public int privacy_view;
  public boolean repeat;
  public String title;
  public boolean user_likes;
  public int views;

  public VKApiVideo()
  {
  }

  public VKApiVideo(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.owner_id = paramParcel.readInt();
    this.album_id = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.duration = paramParcel.readInt();
    this.link = paramParcel.readString();
    this.date = paramParcel.readLong();
    this.views = paramParcel.readInt();
    this.player = paramParcel.readString();
    this.photo_130 = paramParcel.readString();
    this.photo_320 = paramParcel.readString();
    this.photo_640 = paramParcel.readString();
    this.photo = ((VKPhotoSizes)paramParcel.readParcelable(VKPhotoSizes.class.getClassLoader()));
    this.access_key = paramParcel.readString();
    this.comments = paramParcel.readInt();
    boolean bool2;
    boolean bool3;
    label177: boolean bool4;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.can_comment = bool2;
      if (paramParcel.readByte() == 0)
        break label281;
      bool3 = bool1;
      this.can_repost = bool3;
      if (paramParcel.readByte() == 0)
        break label287;
      bool4 = bool1;
      label193: this.user_likes = bool4;
      if (paramParcel.readByte() == 0)
        break label293;
    }
    while (true)
    {
      this.repeat = bool1;
      this.likes = paramParcel.readInt();
      this.privacy_view = paramParcel.readInt();
      this.privacy_comment = paramParcel.readInt();
      this.mp4_240 = paramParcel.readString();
      this.mp4_360 = paramParcel.readString();
      this.mp4_480 = paramParcel.readString();
      this.mp4_720 = paramParcel.readString();
      this.external = paramParcel.readString();
      return;
      bool2 = false;
      break;
      label281: bool3 = false;
      break label177;
      label287: bool4 = false;
      break label193;
      label293: bool1 = false;
    }
  }

  public VKApiVideo(JSONObject paramJSONObject)
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
    return "video";
  }

  public VKApiVideo parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.owner_id = paramJSONObject.optInt("owner_id");
    this.title = paramJSONObject.optString("title");
    this.description = paramJSONObject.optString("description");
    this.duration = paramJSONObject.optInt("duration");
    this.link = paramJSONObject.optString("link");
    this.date = paramJSONObject.optLong("date");
    this.views = paramJSONObject.optInt("views");
    this.comments = paramJSONObject.optInt("comments");
    this.player = paramJSONObject.optString("player");
    this.access_key = paramJSONObject.optString("access_key");
    this.album_id = paramJSONObject.optInt("album_id");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("likes");
    if (localJSONObject1 != null)
    {
      this.likes = localJSONObject1.optInt("count");
      this.user_likes = ParseUtils.parseBoolean(localJSONObject1, "user_likes");
    }
    this.can_comment = ParseUtils.parseBoolean(paramJSONObject, "can_comment");
    this.can_repost = ParseUtils.parseBoolean(paramJSONObject, "can_repost");
    this.repeat = ParseUtils.parseBoolean(paramJSONObject, "repeat");
    this.privacy_view = VKPrivacy.parsePrivacy(paramJSONObject.optJSONObject("privacy_view"));
    this.privacy_comment = VKPrivacy.parsePrivacy(paramJSONObject.optJSONObject("privacy_comment"));
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("files");
    if (localJSONObject2 != null)
    {
      this.mp4_240 = localJSONObject2.optString("mp4_240");
      this.mp4_360 = localJSONObject2.optString("mp4_360");
      this.mp4_480 = localJSONObject2.optString("mp4_480");
      this.mp4_720 = localJSONObject2.optString("mp4_720");
      this.external = localJSONObject2.optString("external");
    }
    this.photo_130 = paramJSONObject.optString("photo_130");
    if (!TextUtils.isEmpty(this.photo_130))
      this.photo.add(VKApiPhotoSize.create(this.photo_130, 130));
    this.photo_320 = paramJSONObject.optString("photo_320");
    if (!TextUtils.isEmpty(this.photo_320))
      this.photo.add(VKApiPhotoSize.create(this.photo_320, 320));
    this.photo_640 = paramJSONObject.optString("photo_640");
    if (!TextUtils.isEmpty(this.photo_640))
      this.photo.add(VKApiPhotoSize.create(this.photo_640, 640));
    return this;
  }

  public CharSequence toAttachmentString()
  {
    StringBuilder localStringBuilder = new StringBuilder("video").append(this.owner_id).append('_').append(this.id);
    if (!TextUtils.isEmpty(this.access_key))
    {
      localStringBuilder.append('_');
      localStringBuilder.append(this.access_key);
    }
    return localStringBuilder;
  }

  public String toString()
  {
    return this.title;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.owner_id);
    paramParcel.writeInt(this.album_id);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.duration);
    paramParcel.writeString(this.link);
    paramParcel.writeLong(this.date);
    paramParcel.writeInt(this.views);
    paramParcel.writeString(this.player);
    paramParcel.writeString(this.photo_130);
    paramParcel.writeString(this.photo_320);
    paramParcel.writeString(this.photo_640);
    paramParcel.writeParcelable(this.photo, paramInt);
    paramParcel.writeString(this.access_key);
    paramParcel.writeInt(this.comments);
    byte b2;
    byte b3;
    label157: byte b4;
    if (this.can_comment)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.can_repost)
        break label262;
      b3 = b1;
      paramParcel.writeByte(b3);
      if (!this.user_likes)
        break label268;
      b4 = b1;
      label173: paramParcel.writeByte(b4);
      if (!this.repeat)
        break label274;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.likes);
      paramParcel.writeInt(this.privacy_view);
      paramParcel.writeInt(this.privacy_comment);
      paramParcel.writeString(this.mp4_240);
      paramParcel.writeString(this.mp4_360);
      paramParcel.writeString(this.mp4_480);
      paramParcel.writeString(this.mp4_720);
      paramParcel.writeString(this.external);
      return;
      b2 = 0;
      break;
      label262: b3 = 0;
      break label157;
      label268: b4 = 0;
      break label173;
      label274: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiVideo
 * JD-Core Version:    0.6.2
 */