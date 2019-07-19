package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MediaMessage extends BaseMessage
{
  private static final String KEY_BUCKET_NAME = "BucketName";
  public static final String KEY_DOWNLOAD_ID = "DownloadID";
  private static final String KEY_IMAGE_TYPE = "ImageType";
  public static final String KEY_PHOTO_URL = "PhotoUrl";
  final String mBucketName;
  final String mDownloadId;
  final ImageType mImageType;
  final String mPhotoUrl;

  public MediaMessage(int paramInt, MessageType paramMessageType, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, paramMessageType, paramJSONObject);
    this.mBucketName = paramJSONObject.optString("BucketName");
    this.mDownloadId = paramJSONObject.optString("DownloadID");
    this.mPhotoUrl = paramJSONObject.optString("PhotoUrl");
    this.mImageType = ImageType.toEnum(paramJSONObject.optString("ImageType"));
  }

  MediaMessage(Parcel paramParcel)
  {
    super(paramParcel);
    this.mBucketName = paramParcel.readString();
    this.mDownloadId = paramParcel.readString();
    this.mPhotoUrl = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i != -1);
    for (ImageType localImageType = ImageType.values()[i]; ; localImageType = ImageType.REGULAR)
    {
      this.mImageType = localImageType;
      return;
    }
  }

  public String getBucketName()
  {
    return this.mBucketName;
  }

  public String getDownloadId()
  {
    return this.mDownloadId;
  }

  public ImageType getImageType()
  {
    return this.mImageType;
  }

  public String getPhotoUrl()
  {
    return this.mPhotoUrl;
  }

  public int getThumbnailHeight()
  {
    return getHeightPx();
  }

  public int getThumbnailWidth()
  {
    return getWidthPx();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mBucketName);
    paramParcel.writeString(this.mDownloadId);
    paramParcel.writeString(this.mPhotoUrl);
    if (this.mImageType != null);
    for (int i = this.mImageType.ordinal(); ; i = -1)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.MediaMessage
 * JD-Core Version:    0.6.2
 */