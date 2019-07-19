package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageMessage extends MediaMessage
{
  public static final Parcelable.Creator<ImageMessage> CREATOR = new Parcelable.Creator()
  {
    public ImageMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ImageMessage(paramAnonymousParcel);
    }

    public ImageMessage[] newArray(int paramAnonymousInt)
    {
      return new ImageMessage[paramAnonymousInt];
    }
  };
  public static final String KEY_DISPLAY_HEIGHT = "DisplayHeight";
  public static final String KEY_DISPLAY_WIDTH = "DisplayWidth";
  public static final String KEY_IMAGE_URL = "ImageUrl";
  private final int mDisplayHeight;
  private final int mDisplayWidth;
  private final String mImageUrl;

  public ImageMessage(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, MessageType.IMAGE, paramJSONObject);
    this.mImageUrl = paramJSONObject.optString("ImageUrl");
    this.mDisplayWidth = paramJSONObject.getInt("DisplayWidth");
    this.mDisplayHeight = paramJSONObject.getInt("DisplayHeight");
  }

  ImageMessage(Parcel paramParcel)
  {
    super(paramParcel);
    this.mImageUrl = paramParcel.readString();
    this.mDisplayWidth = paramParcel.readInt();
    this.mDisplayHeight = paramParcel.readInt();
  }

  public int getHeightPx()
  {
    return this.mDisplayHeight;
  }

  public ImageType getImageType()
  {
    return this.mImageType;
  }

  public String getImageUrl()
  {
    return this.mImageUrl;
  }

  public int getWidthPx()
  {
    return this.mDisplayWidth;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Image [displayWidth=").append(this.mDisplayWidth).append(", displayHeight=").append(this.mDisplayHeight).append(", imageUrl=").append(this.mImageUrl).append(", bucketName=").append(this.mBucketName).append(", downloadId=").append(this.mDownloadId).append(", width=").append(this.mWidth).append(", action=").append(this.mAction).append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mImageUrl);
    paramParcel.writeInt(this.mDisplayWidth);
    paramParcel.writeInt(this.mDisplayHeight);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.ImageMessage
 * JD-Core Version:    0.6.2
 */