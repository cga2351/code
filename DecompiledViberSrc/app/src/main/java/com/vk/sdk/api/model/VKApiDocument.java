package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiDocument extends VKAttachments.VKApiAttachment
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiDocument> CREATOR = new Parcelable.Creator()
  {
    public VKApiDocument createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiDocument(paramAnonymousParcel);
    }

    public VKApiDocument[] newArray(int paramAnonymousInt)
    {
      return new VKApiDocument[paramAnonymousInt];
    }
  };
  public String access_key;
  public String ext;
  public int id;
  private boolean mIsGif;
  private boolean mIsImage;
  public int owner_id;
  public VKPhotoSizes photo = new VKPhotoSizes();
  public String photo_100;
  public String photo_130;
  public long size;
  public String title;
  public String url;

  public VKApiDocument()
  {
  }

  public VKApiDocument(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.owner_id = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.size = paramParcel.readLong();
    this.ext = paramParcel.readString();
    this.url = paramParcel.readString();
    this.photo_100 = paramParcel.readString();
    this.photo_130 = paramParcel.readString();
    this.photo = ((VKPhotoSizes)paramParcel.readParcelable(VKPhotoSizes.class.getClassLoader()));
    this.access_key = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mIsImage = bool2;
      if (paramParcel.readByte() == 0)
        break label137;
    }
    while (true)
    {
      this.mIsGif = bool1;
      return;
      bool2 = false;
      break;
      label137: bool1 = false;
    }
  }

  public VKApiDocument(JSONObject paramJSONObject)
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
    return "doc";
  }

  public boolean isGif()
  {
    if ((this.mIsGif) || ("gif".equals(this.ext)));
    for (boolean bool = true; ; bool = false)
    {
      this.mIsGif = bool;
      return this.mIsGif;
    }
  }

  public boolean isImage()
  {
    if ((this.mIsImage) || ("jpg".equals(this.ext)) || ("jpeg".equals(this.ext)) || ("png".equals(this.ext)) || ("bmp".equals(this.ext)));
    for (boolean bool = true; ; bool = false)
    {
      this.mIsImage = bool;
      return this.mIsImage;
    }
  }

  public VKApiDocument parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.owner_id = paramJSONObject.optInt("owner_id");
    this.title = paramJSONObject.optString("title");
    this.size = paramJSONObject.optLong("size");
    this.ext = paramJSONObject.optString("ext");
    this.url = paramJSONObject.optString("url");
    this.access_key = paramJSONObject.optString("access_key");
    this.photo_100 = paramJSONObject.optString("photo_100");
    if (!TextUtils.isEmpty(this.photo_100))
      this.photo.add(VKApiPhotoSize.create(this.photo_100, 100, 75));
    this.photo_130 = paramJSONObject.optString("photo_130");
    if (!TextUtils.isEmpty(this.photo_130))
      this.photo.add(VKApiPhotoSize.create(this.photo_130, 130, 100));
    this.photo.sort();
    return this;
  }

  public CharSequence toAttachmentString()
  {
    StringBuilder localStringBuilder = new StringBuilder("doc").append(this.owner_id).append('_').append(this.id);
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
    paramParcel.writeString(this.title);
    paramParcel.writeLong(this.size);
    paramParcel.writeString(this.ext);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.photo_100);
    paramParcel.writeString(this.photo_130);
    paramParcel.writeParcelable(this.photo, paramInt);
    paramParcel.writeString(this.access_key);
    byte b2;
    if (this.mIsImage)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.mIsGif)
        break label118;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label118: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiDocument
 * JD-Core Version:    0.6.2
 */