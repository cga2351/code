package com.viber.voip.model.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class ChatExtensionEntity extends b
  implements Parcelable
{
  public static final Parcelable.Creator<ChatExtensionEntity> CREATOR = new Parcelable.Creator()
  {
    public ChatExtensionEntity a(Parcel paramAnonymousParcel)
    {
      return new ChatExtensionEntity(paramAnonymousParcel);
    }

    public ChatExtensionEntity[] a(int paramAnonymousInt)
    {
      return new ChatExtensionEntity[paramAnonymousInt];
    }
  };
  private int mChatExtensionFlags;
  private int mFeaturedIndex;
  private int mFlags;
  private String mHeaderText;
  private String mIcon;
  private String mIconOld;
  private long mLastUseTime;
  private String mName;
  private int mOrderKey;
  private String mPublicAccountId;
  private String mSearchHint;
  private String mUri;

  public ChatExtensionEntity()
  {
  }

  protected ChatExtensionEntity(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.mPublicAccountId = paramParcel.readString();
    this.mName = paramParcel.readString();
    this.mUri = paramParcel.readString();
    this.mSearchHint = paramParcel.readString();
    this.mIcon = paramParcel.readString();
    this.mIconOld = paramParcel.readString();
    this.mHeaderText = paramParcel.readString();
    this.mFlags = paramParcel.readInt();
    this.mLastUseTime = paramParcel.readLong();
    this.mFeaturedIndex = paramParcel.readInt();
    this.mOrderKey = paramParcel.readInt();
    this.mChatExtensionFlags = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public int getChatExtensionFlags()
  {
    return this.mChatExtensionFlags;
  }

  public int getFeaturedIndex()
  {
    return this.mFeaturedIndex;
  }

  public int getFlags()
  {
    return this.mFlags;
  }

  public String getHeaderText()
  {
    return this.mHeaderText;
  }

  public String getIcon()
  {
    return this.mIcon;
  }

  public String getIconOld()
  {
    return this.mIconOld;
  }

  public Uri getIconOldUri()
  {
    if (!TextUtils.isEmpty(this.mIconOld))
      return Uri.parse(this.mIconOld);
    return null;
  }

  public Uri getIconUri()
  {
    if (!TextUtils.isEmpty(this.mIcon))
      return Uri.parse(this.mIcon);
    return null;
  }

  public long getLastUseTime()
  {
    return this.mLastUseTime;
  }

  public String getName()
  {
    return this.mName;
  }

  public int getOrderKey()
  {
    return this.mOrderKey;
  }

  public String getPublicAccountId()
  {
    return this.mPublicAccountId;
  }

  public String getSearchHint()
  {
    return this.mSearchHint;
  }

  public String getUri()
  {
    return this.mUri;
  }

  public boolean isFeatured()
  {
    return this.mFeaturedIndex != 2147483647;
  }

  public void setChatExtensionFlags(int paramInt)
  {
    this.mChatExtensionFlags = paramInt;
  }

  public void setFeaturedIndex(int paramInt)
  {
    this.mFeaturedIndex = paramInt;
  }

  public void setFlags(int paramInt)
  {
    this.mFlags = paramInt;
  }

  public void setHeaderText(String paramString)
  {
    this.mHeaderText = paramString;
  }

  public void setIcon(String paramString)
  {
    this.mIcon = paramString;
  }

  public void setIconOld(String paramString)
  {
    this.mIconOld = paramString;
  }

  public void setLastUseTime(long paramLong)
  {
    this.mLastUseTime = paramLong;
  }

  public void setName(String paramString)
  {
    this.mName = paramString;
  }

  public void setOrderKey(int paramInt)
  {
    this.mOrderKey = paramInt;
  }

  public void setPublicAccountId(String paramString)
  {
    this.mPublicAccountId = paramString;
  }

  public void setSearchHint(String paramString)
  {
    this.mSearchHint = paramString;
  }

  public void setUri(String paramString)
  {
    this.mUri = paramString;
  }

  public String toString()
  {
    return "ChatExtensionEntity{id=" + this.id + ", mName='" + this.mName + '\'' + ", mPublicAccountId='" + this.mPublicAccountId + '\'' + ", mUri='" + this.mUri + '\'' + ", mHeaderText='" + this.mHeaderText + '\'' + ", mHint='" + this.mSearchHint + '\'' + ", mIcon='" + this.mIcon + '\'' + ", mIconOld='" + this.mIconOld + '\'' + ", mFlags=" + this.mFlags + ", mChatExtensionFlags=" + this.mChatExtensionFlags + ", mLastUseTime=" + this.mLastUseTime + ", mFeaturedIndex=" + this.mFeaturedIndex + ", mOrderKey=" + this.mOrderKey + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.mPublicAccountId);
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mUri);
    paramParcel.writeString(this.mSearchHint);
    paramParcel.writeString(this.mIcon);
    paramParcel.writeString(this.mIconOld);
    paramParcel.writeString(this.mHeaderText);
    paramParcel.writeInt(this.mFlags);
    paramParcel.writeLong(this.mLastUseTime);
    paramParcel.writeInt(this.mFeaturedIndex);
    paramParcel.writeInt(this.mOrderKey);
    paramParcel.writeInt(this.mChatExtensionFlags);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.ChatExtensionEntity
 * JD-Core Version:    0.6.2
 */