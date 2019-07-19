package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoMessage extends MediaMessage
{
  public static final Parcelable.Creator<VideoMessage> CREATOR = new Parcelable.Creator()
  {
    public VideoMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VideoMessage(paramAnonymousParcel);
    }

    public VideoMessage[] newArray(int paramAnonymousInt)
    {
      return new VideoMessage[paramAnonymousInt];
    }
  };
  private static final String KEY_THUMB_BUCKET_NAME = "ThumbnailBucketName";
  private static final String KEY_THUMB_DOWNLOAD_ID = "ThumbnailDownloadID";
  public static final String KEY_THUMB_URL = "ThumbnailUrl";
  public static final String KEY_VIDEO_URL = "VideoUrl";
  public static final float THUMBNAIL_ASPECT_RATIO = 0.5625F;
  private final String mThumbnailBucketName;
  private final String mThumbnailDownloadId;
  private final int mThumbnailHeight;
  private final String mThumbnailUrl;
  private final int mThumbnailWidth;
  private final String mVideoUrl;

  public VideoMessage(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, MessageType.VIDEO, paramJSONObject);
    this.mThumbnailDownloadId = paramJSONObject.optString("ThumbnailDownloadID");
    this.mThumbnailBucketName = paramJSONObject.optString("ThumbnailBucketName");
    this.mThumbnailUrl = paramJSONObject.optString("ThumbnailUrl");
    this.mVideoUrl = paramJSONObject.optString("VideoUrl");
    this.mThumbnailWidth = paramJSONObject.optInt("ThumbnailWidth", -1);
    this.mThumbnailHeight = paramJSONObject.optInt("ThumbnailHeight", -1);
  }

  VideoMessage(Parcel paramParcel)
  {
    super(paramParcel);
    this.mThumbnailDownloadId = paramParcel.readString();
    this.mThumbnailBucketName = paramParcel.readString();
    this.mThumbnailUrl = paramParcel.readString();
    this.mVideoUrl = paramParcel.readString();
    this.mThumbnailWidth = paramParcel.readInt();
    this.mThumbnailHeight = paramParcel.readInt();
  }

  public int getHeightPx()
  {
    return -2;
  }

  public String getThumbnailBucketName()
  {
    return this.mThumbnailBucketName;
  }

  public String getThumbnailDownloadId()
  {
    return this.mThumbnailDownloadId;
  }

  public int getThumbnailHeight()
  {
    return this.mThumbnailHeight;
  }

  public String getThumbnailUrl()
  {
    return this.mThumbnailUrl;
  }

  public int getThumbnailWidth()
  {
    return this.mThumbnailWidth;
  }

  public String getVideoUrl()
  {
    return this.mVideoUrl;
  }

  public int getWidthPx()
  {
    return -2;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Video [width=").append(this.mWidth).append(", action=").append(this.mAction).append(", bucketName=").append(this.mBucketName).append(", downloadId=").append(this.mDownloadId).append(", videoUrl=").append(this.mVideoUrl).append(", thumbnailBucketName=").append(this.mThumbnailBucketName).append(", thumbnailDownloadId=").append(this.mThumbnailDownloadId).append(", thumbnailUrl=").append(this.mThumbnailUrl).append("| thumbnailWidth=").append(this.mThumbnailWidth).append(", thumbnailHeight=").append(this.mThumbnailHeight).append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mThumbnailDownloadId);
    paramParcel.writeString(this.mThumbnailBucketName);
    paramParcel.writeString(this.mThumbnailUrl);
    paramParcel.writeString(this.mVideoUrl);
    paramParcel.writeInt(this.mThumbnailWidth);
    paramParcel.writeInt(this.mThumbnailHeight);
  }

  public static class InternalKey
  {
    public static final String THUMBNAIL_HEIGHT = "ThumbnailHeight";
    public static final String THUMBNAIL_WIDTH = "ThumbnailWidth";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.VideoMessage
 * JD-Core Version:    0.6.2
 */