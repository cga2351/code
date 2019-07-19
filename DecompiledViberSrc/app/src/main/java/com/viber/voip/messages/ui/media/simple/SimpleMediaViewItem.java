package com.viber.voip.messages.ui.media.simple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.da;

public class SimpleMediaViewItem
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleMediaViewItem> CREATOR = new Parcelable.Creator()
  {
    public SimpleMediaViewItem a(Parcel paramAnonymousParcel)
    {
      return new SimpleMediaViewItem(paramAnonymousParcel);
    }

    public SimpleMediaViewItem[] a(int paramAnonymousInt)
    {
      return new SimpleMediaViewItem[paramAnonymousInt];
    }
  };
  private boolean mIsSecretMode;
  private int mMediaType;
  private String mMediaUrl;
  private long mMessageDate;
  private long mMessageId;
  private int mMessageType;
  private String mUrlToFavorite;

  public SimpleMediaViewItem()
  {
  }

  protected SimpleMediaViewItem(Parcel paramParcel)
  {
    this.mMediaUrl = paramParcel.readString();
    this.mUrlToFavorite = paramParcel.readString();
    this.mMediaType = paramParcel.readInt();
    this.mMessageId = paramParcel.readLong();
    this.mMessageDate = paramParcel.readLong();
    this.mMessageType = paramParcel.readInt();
    if (i == paramParcel.readByte());
    while (true)
    {
      this.mIsSecretMode = i;
      return;
      i = 0;
    }
  }

  public SimpleMediaViewItem(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1L, 0L, 0, false, null);
  }

  public SimpleMediaViewItem(String paramString1, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean, String paramString2)
  {
    this.mMediaUrl = paramString1;
    this.mMediaType = paramInt1;
    this.mMessageId = paramLong1;
    this.mMessageDate = paramLong2;
    this.mMessageType = paramInt2;
    this.mIsSecretMode = paramBoolean;
    this.mUrlToFavorite = paramString2;
  }

  public SimpleMediaViewItem(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    this(paramString, paramInt, paramLong, 0L, 0, paramBoolean, null);
  }

  public static boolean isImageOrGifType(int paramInt)
  {
    return (1 == paramInt) || (1005 == paramInt);
  }

  public static boolean isVideoType(int paramInt)
  {
    return 3 == paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getMediaType()
  {
    return this.mMediaType;
  }

  public String getMediaUrl()
  {
    return this.mMediaUrl;
  }

  public long getMessageDate()
  {
    return this.mMessageDate;
  }

  public long getMessageId()
  {
    return this.mMessageId;
  }

  public int getMessageType()
  {
    return this.mMessageType;
  }

  public String getUrlToFavorite()
  {
    return this.mUrlToFavorite;
  }

  public boolean isGifFile()
  {
    return 1005 == this.mMediaType;
  }

  public boolean isImageOrGifType()
  {
    return isImageOrGifType(this.mMediaType);
  }

  public boolean isImageType()
  {
    return 1 == this.mMediaType;
  }

  public boolean isSecretMode()
  {
    return this.mIsSecretMode;
  }

  public boolean isValid()
  {
    return (!da.a(this.mMediaUrl)) && ((isImageOrGifType()) || (isVideoType()));
  }

  public boolean isVideoType()
  {
    return isVideoType(this.mMediaType);
  }

  public String toString()
  {
    return "SimpleMediaViewItem{mMediaUrl='" + this.mMediaUrl + '\'' + ", mUrlToFavorite='" + this.mUrlToFavorite + '\'' + ", mMediaType='" + this.mMediaType + '\'' + ", mMessageId=" + this.mMessageId + ", mIsSecretMode=" + this.mIsSecretMode + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mMediaUrl);
    paramParcel.writeString(this.mUrlToFavorite);
    paramParcel.writeInt(this.mMediaType);
    paramParcel.writeLong(this.mMessageId);
    paramParcel.writeLong(this.mMessageDate);
    paramParcel.writeInt(this.mMessageType);
    if (this.mIsSecretMode);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.simple.SimpleMediaViewItem
 * JD-Core Version:    0.6.2
 */