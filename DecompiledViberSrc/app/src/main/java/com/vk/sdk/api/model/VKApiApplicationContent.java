package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONObject;

public class VKApiApplicationContent extends VKAttachments.VKApiAttachment
  implements Parcelable
{
  public static Parcelable.Creator<VKApiApplicationContent> CREATOR = new Parcelable.Creator()
  {
    public VKApiApplicationContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiApplicationContent(paramAnonymousParcel);
    }

    public VKApiApplicationContent[] newArray(int paramAnonymousInt)
    {
      return new VKApiApplicationContent[paramAnonymousInt];
    }
  };
  public int id;
  public String name;
  public VKPhotoSizes photo = new VKPhotoSizes();
  public String photo_130;
  public String photo_604;

  public VKApiApplicationContent()
  {
  }

  public VKApiApplicationContent(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.photo_130 = paramParcel.readString();
    this.photo_604 = paramParcel.readString();
    this.photo = ((VKPhotoSizes)paramParcel.readParcelable(VKPhotoSizes.class.getClassLoader()));
  }

  public VKApiApplicationContent(JSONObject paramJSONObject)
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
    return "app";
  }

  public VKApiApplicationContent parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.name = paramJSONObject.optString("name");
    this.photo_130 = paramJSONObject.optString("photo_130");
    if (!TextUtils.isEmpty(this.photo_130))
      this.photo.add(VKApiPhotoSize.create(this.photo_130, 130));
    this.photo_604 = paramJSONObject.optString("photo_604");
    if (!TextUtils.isEmpty(this.photo_604))
      this.photo.add(VKApiPhotoSize.create(this.photo_604, 604));
    return this;
  }

  public CharSequence toAttachmentString()
  {
    throw new UnsupportedOperationException("Attaching app info is not supported by VK.com API");
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.photo_130);
    paramParcel.writeString(this.photo_604);
    paramParcel.writeParcelable(this.photo, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiApplicationContent
 * JD-Core Version:    0.6.2
 */