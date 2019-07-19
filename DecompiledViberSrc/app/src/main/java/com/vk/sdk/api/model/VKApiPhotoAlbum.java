package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiPhotoAlbum extends VKAttachments.VKApiAttachment
  implements Parcelable, Identifiable
{
  public static final String COVER_M = "http://vk.com/images/m_noalbum.png";
  public static final String COVER_S = "http://vk.com/images/s_noalbum.png";
  public static final String COVER_X = "http://vk.com/images/x_noalbum.png";
  public static Parcelable.Creator<VKApiPhotoAlbum> CREATOR = new Parcelable.Creator()
  {
    public VKApiPhotoAlbum createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiPhotoAlbum(paramAnonymousParcel);
    }

    public VKApiPhotoAlbum[] newArray(int paramAnonymousInt)
    {
      return new VKApiPhotoAlbum[paramAnonymousInt];
    }
  };
  public boolean can_upload;
  public long created;
  public String description;
  public int id;
  public int owner_id;
  public VKPhotoSizes photo = new VKPhotoSizes();
  public int privacy;
  public int size;
  public int thumb_id;
  public String thumb_src;
  public String title;
  public long updated;

  public VKApiPhotoAlbum()
  {
  }

  public VKApiPhotoAlbum(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.size = paramParcel.readInt();
    this.privacy = paramParcel.readInt();
    this.description = paramParcel.readString();
    this.owner_id = paramParcel.readInt();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.can_upload = bool;
      this.updated = paramParcel.readLong();
      this.created = paramParcel.readLong();
      this.thumb_id = paramParcel.readInt();
      this.thumb_src = paramParcel.readString();
      this.photo = ((VKPhotoSizes)paramParcel.readParcelable(VKPhotoSizes.class.getClassLoader()));
      return;
    }
  }

  public VKApiPhotoAlbum(JSONObject paramJSONObject)
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
    return "album";
  }

  public boolean isClosed()
  {
    return this.privacy != 0;
  }

  public VKApiPhotoAlbum parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.thumb_id = paramJSONObject.optInt("thumb_id");
    this.owner_id = paramJSONObject.optInt("owner_id");
    this.title = paramJSONObject.optString("title");
    this.description = paramJSONObject.optString("description");
    this.created = paramJSONObject.optLong("created");
    this.updated = paramJSONObject.optLong("updated");
    this.size = paramJSONObject.optInt("size");
    this.can_upload = ParseUtils.parseBoolean(paramJSONObject, "can_upload");
    this.thumb_src = paramJSONObject.optString("thumb_src");
    if (paramJSONObject.has("privacy"));
    for (this.privacy = paramJSONObject.optInt("privacy"); ; this.privacy = VKPrivacy.parsePrivacy(paramJSONObject.optJSONObject("privacy_view")))
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("sizes");
      if (localJSONArray == null)
        break;
      this.photo.fill(localJSONArray);
      return this;
    }
    this.photo.add(VKApiPhotoSize.create("http://vk.com/images/s_noalbum.png", 75, 55));
    this.photo.add(VKApiPhotoSize.create("http://vk.com/images/m_noalbum.png", 130, 97));
    this.photo.add(VKApiPhotoSize.create("http://vk.com/images/x_noalbum.png", 432, 249));
    this.photo.sort();
    return this;
  }

  public CharSequence toAttachmentString()
  {
    return new StringBuilder("album").append(this.owner_id).append('_').append(this.id);
  }

  public String toString()
  {
    return this.title;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.title);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.privacy);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.owner_id);
    if (this.can_upload);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.updated);
      paramParcel.writeLong(this.created);
      paramParcel.writeInt(this.thumb_id);
      paramParcel.writeString(this.thumb_src);
      paramParcel.writeParcelable(this.photo, paramInt);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiPhotoAlbum
 * JD-Core Version:    0.6.2
 */