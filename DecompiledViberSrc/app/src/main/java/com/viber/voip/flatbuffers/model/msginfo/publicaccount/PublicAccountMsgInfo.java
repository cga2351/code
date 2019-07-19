package com.viber.voip.flatbuffers.model.msginfo.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;

public class PublicAccountMsgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PublicAccountMsgInfo> CREATOR = new Parcelable.Creator()
  {
    public PublicAccountMsgInfo a(Parcel paramAnonymousParcel)
    {
      return new PublicAccountMsgInfo(paramAnonymousParcel, null);
    }

    public PublicAccountMsgInfo[] a(int paramAnonymousInt)
    {
      return new PublicAccountMsgInfo[paramAnonymousInt];
    }
  };
  public static final String PA_MEDIA_KEY = "media";

  @c(a="chat_background")
  private String mChatBackground;

  @c(a="contact")
  private ContactInfoSection mContact;

  @c(a="duration")
  private double mDuration;

  @c(a="file_name")
  private String mFileName;

  @c(a="keyboard")
  private BotReplyConfig mKeyboard;

  @c(a="location")
  private LocationInfoSection mLocation;

  @c(a="media")
  private String mMedia;

  @c(a="min_api_version")
  private int mMinApiVersion = 1;

  @c(a="pa_info")
  private PublicAccountInfo mPublicAccountInfo;

  @c(a="rich_media")
  private BotReplyConfig mRichMedia;

  @c(a="rich_media_sig")
  private String mRichMediaSignature;

  @c(a="sender")
  private Sender mSender;

  @c(a="size")
  private UnsignedLong mSize;

  @c(a="sound")
  private String mSound;

  @c(a="sticker_id")
  private long mStickerId;

  @c(a="text")
  private String mText;

  @c(a="thumbnail")
  private String mThumbnailUrl;

  @c(a="tracking_data")
  private String mTrackingData;

  @c(a="type")
  private String mType;

  public PublicAccountMsgInfo()
  {
  }

  private PublicAccountMsgInfo(Parcel paramParcel)
  {
    this.mType = paramParcel.readString();
    this.mText = paramParcel.readString();
    this.mTrackingData = paramParcel.readString();
    this.mMedia = paramParcel.readString();
    this.mThumbnailUrl = paramParcel.readString();
    this.mFileName = paramParcel.readString();
    this.mDuration = paramParcel.readDouble();
    this.mStickerId = paramParcel.readLong();
    this.mSender = ((Sender)paramParcel.readParcelable(Sender.class.getClassLoader()));
    this.mLocation = ((LocationInfoSection)paramParcel.readParcelable(LocationInfoSection.class.getClassLoader()));
    this.mSize = ((UnsignedLong)paramParcel.readParcelable(UnsignedLong.class.getClassLoader()));
    this.mContact = ((ContactInfoSection)paramParcel.readParcelable(ContactInfoSection.class.getClassLoader()));
    this.mKeyboard = ((BotReplyConfig)paramParcel.readParcelable(BotReplyConfig.class.getClassLoader()));
    this.mRichMedia = ((BotReplyConfig)paramParcel.readParcelable(BotReplyConfig.class.getClassLoader()));
    this.mMinApiVersion = paramParcel.readInt();
    this.mPublicAccountInfo = ((PublicAccountInfo)paramParcel.readParcelable(PublicAccountInfo.class.getClassLoader()));
    this.mRichMediaSignature = paramParcel.readString();
    this.mChatBackground = paramParcel.readString();
    this.mSound = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getChatBackground()
  {
    return this.mChatBackground;
  }

  public ContactInfoSection getContact()
  {
    return this.mContact;
  }

  public long getDuration()
  {
    return ()this.mDuration;
  }

  public String getFileName()
  {
    return this.mFileName;
  }

  public BotReplyConfig getKeyboard()
  {
    return this.mKeyboard;
  }

  public LocationInfoSection getLocation()
  {
    return this.mLocation;
  }

  public String getMedia()
  {
    return this.mMedia;
  }

  public int getMinApiVersion()
  {
    return this.mMinApiVersion;
  }

  public PublicAccountInfo getPublicAccountInfo()
  {
    return this.mPublicAccountInfo;
  }

  public BotReplyConfig getRichMedia()
  {
    return this.mRichMedia;
  }

  public String getRichMediaSignature()
  {
    return this.mRichMediaSignature;
  }

  public Sender getSender()
  {
    return this.mSender;
  }

  public long getSize()
  {
    if (this.mSize != null)
      return this.mSize.get();
    return 0L;
  }

  public String getSound()
  {
    return this.mSound;
  }

  public long getStickerId()
  {
    return this.mStickerId;
  }

  public String getText()
  {
    return this.mText;
  }

  public String getThumbnailUrl()
  {
    return this.mThumbnailUrl;
  }

  public String getTrackingData()
  {
    return this.mTrackingData;
  }

  public String getType()
  {
    return this.mType;
  }

  public boolean hasBotReply()
  {
    return this.mKeyboard != null;
  }

  public void setChatBackground(String paramString)
  {
    this.mChatBackground = paramString;
  }

  public void setContact(ContactInfoSection paramContactInfoSection)
  {
    this.mContact = paramContactInfoSection;
  }

  public void setDuration(double paramDouble)
  {
    this.mDuration = paramDouble;
  }

  public void setFileName(String paramString)
  {
    this.mFileName = paramString;
  }

  public void setKeyboard(BotReplyConfig paramBotReplyConfig)
  {
    this.mKeyboard = paramBotReplyConfig;
  }

  public void setLocation(LocationInfoSection paramLocationInfoSection)
  {
    this.mLocation = paramLocationInfoSection;
  }

  public void setMedia(String paramString)
  {
    this.mMedia = paramString;
  }

  public void setMinApiVersion(int paramInt)
  {
    this.mMinApiVersion = paramInt;
  }

  public void setPublicAccountInfo(PublicAccountInfo paramPublicAccountInfo)
  {
    this.mPublicAccountInfo = paramPublicAccountInfo;
  }

  public void setRichMedia(BotReplyConfig paramBotReplyConfig)
  {
    this.mRichMedia = paramBotReplyConfig;
  }

  public void setRichMediaSignature(String paramString)
  {
    this.mRichMediaSignature = paramString;
  }

  public void setSender(Sender paramSender)
  {
    this.mSender = paramSender;
  }

  public void setSize(long paramLong)
  {
    this.mSize = new UnsignedLong(paramLong);
  }

  public void setSound(String paramString)
  {
    this.mSound = paramString;
  }

  public void setStickerId(long paramLong)
  {
    this.mStickerId = paramLong;
  }

  public void setText(String paramString)
  {
    this.mText = paramString;
  }

  public void setThumbnailUrl(String paramString)
  {
    this.mThumbnailUrl = paramString;
  }

  public void setTrackingData(String paramString)
  {
    this.mTrackingData = paramString;
  }

  public void setType(String paramString)
  {
    this.mType = paramString;
  }

  public String toString()
  {
    return "PublicAccountMsgInfo{  mKeyboard=" + this.mKeyboard + ", mSender=" + this.mSender + ", mContact=" + this.mContact + ", mLocation=" + this.mLocation + ", mType='" + this.mType + '\'' + ", mText='" + this.mText + '\'' + ", mTrackingData='" + this.mTrackingData + '\'' + ", mMedia='" + this.mMedia + '\'' + ", mSize=" + this.mSize + ", mStickerId=" + this.mStickerId + ", mThumbnailUrl='" + this.mThumbnailUrl + '\'' + ", mDuration=" + this.mDuration + ", mFileName='" + this.mFileName + '\'' + ", mRichMedia='" + this.mRichMedia + '\'' + ", mMinApiVersion='" + this.mMinApiVersion + '\'' + ", mInlineMessage='" + this.mPublicAccountInfo + '\'' + ", mRichMediaSignature=" + this.mRichMediaSignature + ", mChatBackground='" + this.mChatBackground + '\'' + ", mSound='" + this.mSound + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mType);
    paramParcel.writeString(this.mText);
    paramParcel.writeString(this.mTrackingData);
    paramParcel.writeString(this.mMedia);
    paramParcel.writeString(this.mThumbnailUrl);
    paramParcel.writeString(this.mFileName);
    paramParcel.writeDouble(this.mDuration);
    paramParcel.writeLong(this.mStickerId);
    paramParcel.writeParcelable(this.mSender, paramInt);
    paramParcel.writeParcelable(this.mLocation, paramInt);
    paramParcel.writeParcelable(this.mSize, paramInt);
    paramParcel.writeParcelable(this.mContact, paramInt);
    paramParcel.writeParcelable(this.mKeyboard, paramInt);
    paramParcel.writeParcelable(this.mRichMedia, paramInt);
    paramParcel.writeInt(this.mMinApiVersion);
    paramParcel.writeParcelable(this.mPublicAccountInfo, paramInt);
    paramParcel.writeString(this.mRichMediaSignature);
    paramParcel.writeString(this.mChatBackground);
    paramParcel.writeString(this.mSound);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo
 * JD-Core Version:    0.6.2
 */