package com.viber.voip.messages.conversation.ui.view;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ScreenshotConversationData
  implements Parcelable
{
  public static final Parcelable.Creator<ScreenshotConversationData> CREATOR = new Parcelable.Creator()
  {
    public ScreenshotConversationData a(Parcel paramAnonymousParcel)
    {
      return new ScreenshotConversationData(paramAnonymousParcel, null);
    }

    public ScreenshotConversationData[] a(int paramAnonymousInt)
    {
      return new ScreenshotConversationData[paramAnonymousInt];
    }
  };
  private final String mAnalyticsChatType;
  private String mCommunityName;
  private String mCommunityShareLink;
  private long mGroupId;
  private int mGroupRole;
  private boolean mHasDoodle;
  private final int mHeight;
  private boolean mIsCommunity;
  private final Uri mSceenshotUri;
  private final String mScreenshotFileTag;
  private final float mScreenshotRatio;
  private final int mWidth;

  public ScreenshotConversationData(Uri paramUri, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.mSceenshotUri = paramUri;
    this.mScreenshotFileTag = paramString1;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mScreenshotRatio = (paramInt2 / paramInt1);
    this.mAnalyticsChatType = paramString2;
  }

  private ScreenshotConversationData(Parcel paramParcel)
  {
    this.mSceenshotUri = Uri.parse(paramParcel.readString());
    this.mScreenshotFileTag = paramParcel.readString();
    this.mScreenshotRatio = paramParcel.readFloat();
    this.mCommunityName = paramParcel.readString();
    this.mCommunityShareLink = paramParcel.readString();
    this.mGroupId = paramParcel.readLong();
    this.mGroupRole = paramParcel.readInt();
    int j;
    if (paramParcel.readByte() == i)
    {
      j = i;
      this.mIsCommunity = j;
      this.mWidth = paramParcel.readInt();
      this.mHeight = paramParcel.readInt();
      this.mAnalyticsChatType = paramParcel.readString();
      if (paramParcel.readByte() != i)
        break label123;
    }
    while (true)
    {
      this.mHasDoodle = i;
      return;
      j = 0;
      break;
      label123: i = 0;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAnalyticsChatType()
  {
    return this.mAnalyticsChatType;
  }

  public String getCommunityName()
  {
    return this.mCommunityName;
  }

  public String getCommunityShareLink()
  {
    return this.mCommunityShareLink;
  }

  public long getGroupId()
  {
    return this.mGroupId;
  }

  public int getGroupRole()
  {
    return this.mGroupRole;
  }

  public int getHeight()
  {
    return this.mHeight;
  }

  public Uri getSceenshotUri()
  {
    return this.mSceenshotUri;
  }

  public String getScreenshotFileTag()
  {
    return this.mScreenshotFileTag;
  }

  public float getScreenshotRatio()
  {
    return this.mScreenshotRatio;
  }

  public int getWidth()
  {
    return this.mWidth;
  }

  public boolean hasDoodle()
  {
    return this.mHasDoodle;
  }

  public boolean hasNameAndLink()
  {
    return (this.mCommunityName != null) && (this.mCommunityShareLink != null);
  }

  public boolean isCommunity()
  {
    return this.mIsCommunity;
  }

  public void setCommunity(boolean paramBoolean)
  {
    this.mIsCommunity = paramBoolean;
  }

  public void setCommunityName(String paramString)
  {
    this.mCommunityName = paramString;
  }

  public void setCommunityShareLink(String paramString)
  {
    this.mCommunityShareLink = paramString;
  }

  public void setGroupId(long paramLong)
  {
    this.mGroupId = paramLong;
  }

  public void setGroupRole(int paramInt)
  {
    this.mGroupRole = paramInt;
  }

  public void setHasDoodle(boolean paramBoolean)
  {
    this.mHasDoodle = paramBoolean;
  }

  public String toString()
  {
    return "ScreenshotConversationData{mSceenshotUri=" + this.mSceenshotUri + ", mScreenshotFileTag='" + this.mScreenshotFileTag + '\'' + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mScreenshotRatio=" + this.mScreenshotRatio + ", mCommunityName='" + this.mCommunityName + '\'' + ", mCommunityShareLink='" + this.mCommunityShareLink + '\'' + ", mGroupId=" + this.mGroupId + ", mGroupRole=" + this.mGroupRole + ", mIsCommunity=" + this.mIsCommunity + ", mAnalyticsChatType=" + this.mAnalyticsChatType + ", mHasDoodle=" + this.mHasDoodle + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.mSceenshotUri.toString());
    paramParcel.writeString(this.mScreenshotFileTag);
    paramParcel.writeFloat(this.mScreenshotRatio);
    paramParcel.writeString(this.mCommunityName);
    paramParcel.writeString(this.mCommunityShareLink);
    paramParcel.writeLong(this.mGroupId);
    paramParcel.writeInt(this.mGroupRole);
    int j;
    if (this.mIsCommunity)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      paramParcel.writeInt(this.mWidth);
      paramParcel.writeInt(this.mHeight);
      paramParcel.writeString(this.mAnalyticsChatType);
      if (!this.mHasDoodle)
        break label122;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      return;
      j = 0;
      break;
      label122: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData
 * JD-Core Version:    0.6.2
 */