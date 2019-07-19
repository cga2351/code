package com.yandex.mobile.ads.video.models.ad;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaFile
  implements Parcelable
{
  public static final Parcelable.Creator<MediaFile> CREATOR = new Parcelable.Creator()
  {
  };
  public int mBitrate;
  private DeliveryMethod mDeliveryMethod;
  private int mHeight;
  private String mId;
  private String mMimeType;
  private String mUri;
  private int mWidth;

  private MediaFile()
  {
  }

  private MediaFile(Parcel paramParcel)
  {
    this.mId = paramParcel.readString();
    this.mUri = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i == -1);
    for (DeliveryMethod localDeliveryMethod = null; ; localDeliveryMethod = DeliveryMethod.values()[i])
    {
      this.mDeliveryMethod = localDeliveryMethod;
      this.mHeight = paramParcel.readInt();
      this.mWidth = paramParcel.readInt();
      this.mMimeType = paramParcel.readString();
      return;
    }
  }

  private void setBitrate(String paramString)
  {
    try
    {
      this.mBitrate = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void setDeliveryMethod(String paramString)
  {
    this.mDeliveryMethod = DeliveryMethod.getByMethod(paramString);
  }

  private void setHeight(String paramString)
  {
    try
    {
      this.mHeight = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void setId(String paramString)
  {
    this.mId = paramString;
  }

  private void setUri(String paramString)
  {
    this.mUri = paramString;
  }

  private void setWidth(String paramString)
  {
    try
    {
      this.mWidth = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MediaFile localMediaFile;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMediaFile = (MediaFile)paramObject;
      if (this.mHeight != localMediaFile.mHeight)
        return false;
      if (this.mWidth != localMediaFile.mWidth)
        return false;
      if (this.mDeliveryMethod != localMediaFile.mDeliveryMethod)
        return false;
      if (this.mId != null)
      {
        if (this.mId.equals(localMediaFile.mId));
      }
      else
        while (localMediaFile.mId != null)
          return false;
      if (this.mMimeType != null)
      {
        if (this.mMimeType.equals(localMediaFile.mMimeType));
      }
      else
        while (localMediaFile.mMimeType != null)
          return false;
      if (this.mUri == null)
        break;
    }
    while (this.mUri.equals(localMediaFile.mUri));
    while (true)
    {
      return false;
      if (localMediaFile.mUri == null)
        break;
    }
  }

  public int getBitrate()
  {
    return this.mBitrate;
  }

  public DeliveryMethod getDeliveryMethod()
  {
    return this.mDeliveryMethod;
  }

  public int getHeight()
  {
    return this.mHeight;
  }

  public String getId()
  {
    return this.mId;
  }

  public String getMimeType()
  {
    return this.mMimeType;
  }

  public String getUri()
  {
    return this.mUri;
  }

  public int getWidth()
  {
    return this.mWidth;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.mId != null)
    {
      i = this.mId.hashCode();
      int j = i * 31;
      if (this.mUri == null)
        break label119;
      k = this.mUri.hashCode();
      m = 31 * (k + j);
      if (this.mDeliveryMethod == null)
        break label124;
    }
    label119: label124: for (int n = this.mDeliveryMethod.hashCode(); ; n = 0)
    {
      int i1 = 31 * (31 * (31 * (n + m) + this.mHeight) + this.mWidth);
      String str = this.mMimeType;
      int i2 = 0;
      if (str != null)
        i2 = this.mMimeType.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  public void setMimeType(String paramString)
  {
    this.mMimeType = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mId);
    paramParcel.writeString(this.mUri);
    if (this.mDeliveryMethod == null);
    for (int i = -1; ; i = this.mDeliveryMethod.ordinal())
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.mHeight);
      paramParcel.writeInt(this.mWidth);
      paramParcel.writeString(this.mMimeType);
      return;
    }
  }

  public static enum DeliveryMethod
  {
    private String mDeliveryMethod;

    static
    {
      PROGRESSIVE = new DeliveryMethod("PROGRESSIVE", 1, "progressive");
      DeliveryMethod[] arrayOfDeliveryMethod = new DeliveryMethod[2];
      arrayOfDeliveryMethod[0] = STREAMING;
      arrayOfDeliveryMethod[1] = PROGRESSIVE;
    }

    private DeliveryMethod(String paramString)
    {
      this.mDeliveryMethod = paramString;
    }

    public static DeliveryMethod getByMethod(String paramString)
    {
      for (DeliveryMethod localDeliveryMethod : values())
        if (localDeliveryMethod.mDeliveryMethod.equals(paramString))
          return localDeliveryMethod;
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.models.ad.MediaFile
 * JD-Core Version:    0.6.2
 */