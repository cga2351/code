package com.viber.voip.messages.orm.entity.json;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.util.at;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import org.json.JSONException;
import org.json.JSONObject;

public class GifMessage extends MediaMessage
{
  public static final String ALTERNATE_KEY_GIF_URL = "ImageUrl";
  public static final String ALTERNATE_KEY_THUMBNAIL_HEIGHT = "DisplayHeight";
  public static final String ALTERNATE_KEY_THUMBNAIL_WIDTH = "DisplayWidth";
  public static final Parcelable.Creator<GifMessage> CREATOR = new Parcelable.Creator()
  {
    public GifMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GifMessage(paramAnonymousParcel);
    }

    public GifMessage[] newArray(int paramAnonymousInt)
    {
      return new GifMessage[paramAnonymousInt];
    }
  };
  public static final String KEY_GIF_URL = "GifUrl";
  public static final String KEY_THUMBNAIL_HEIGHT = "ThumbnailHeight";
  public static final String KEY_THUMBNAIL_SIZE_IN_BYTES = "ThumbnailSizeInBytes";
  public static final String KEY_THUMBNAIL_WIDTH = "ThumbnailWidth";
  private final long mGifSize;
  private final String mGifUrl;
  private final int mThumbnailHeight;
  private final int mThumbnailWidth;

  public GifMessage(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, MessageType.GIF, paramJSONObject);
    if (!da.a(this.mDownloadId));
    String str;
    for (this.mGifUrl = dx.a(false, this.mDownloadId, false, null, null, null).toString(); ; this.mGifUrl = str)
    {
      int i = paramJSONObject.optInt("ThumbnailWidth", -1);
      if (i < 0)
        i = paramJSONObject.optInt("DisplayWidth", -1);
      this.mThumbnailWidth = i;
      int j = paramJSONObject.optInt("ThumbnailHeight", -1);
      if (j < 0)
        j = paramJSONObject.optInt("DisplayHeight", -1);
      this.mThumbnailHeight = j;
      this.mGifSize = paramJSONObject.optLong("ThumbnailSizeInBytes", 0L);
      return;
      str = paramJSONObject.optString("GifUrl");
      if (da.a(str))
        str = paramJSONObject.optString("ImageUrl");
    }
  }

  GifMessage(Parcel paramParcel)
  {
    super(paramParcel);
    this.mGifUrl = paramParcel.readString();
    this.mThumbnailWidth = paramParcel.readInt();
    this.mThumbnailHeight = paramParcel.readInt();
    this.mGifSize = paramParcel.readLong();
  }

  public String getBucketName()
  {
    throw new UnsupportedOperationException("Not supported for Gif messages");
  }

  public String getDownloadId()
  {
    throw new UnsupportedOperationException("Not supported for Gif messages");
  }

  public long getGifSize()
  {
    return this.mGifSize;
  }

  public String getGifUrl()
  {
    return this.mGifUrl;
  }

  public int getHeightPx()
  {
    return -2;
  }

  public ImageType getImageType()
  {
    throw new UnsupportedOperationException("Not supported for Gif messages");
  }

  public int getThumbnailHeight()
  {
    return this.mThumbnailHeight;
  }

  public int getThumbnailWidth()
  {
    return this.mThumbnailWidth;
  }

  public int getWidthPx()
  {
    return -2;
  }

  public String toString()
  {
    return "Gif [width=" + this.mWidth + ", action=" + this.mAction + ", gifUrl=" + this.mGifUrl + ", thumbnailWidth=" + this.mThumbnailWidth + ", thumbnailHeight=" + this.mThumbnailHeight + ", gifSize=" + at.a(this.mGifSize) + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mGifUrl);
    paramParcel.writeInt(this.mThumbnailWidth);
    paramParcel.writeInt(this.mThumbnailHeight);
    paramParcel.writeLong(this.mGifSize);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.GifMessage
 * JD-Core Version:    0.6.2
 */