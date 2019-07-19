package com.viber.voip.flatbuffers.model.quote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.a;
import java.util.Arrays;

public class QuotedMessageData
  implements Parcelable, a
{
  public static final Parcelable.Creator<QuotedMessageData> CREATOR = new Parcelable.Creator()
  {
    public QuotedMessageData a(Parcel paramAnonymousParcel)
    {
      return new QuotedMessageData(paramAnonymousParcel);
    }

    public QuotedMessageData[] a(int paramAnonymousInt)
    {
      return new QuotedMessageData[paramAnonymousInt];
    }
  };

  @c(a="body")
  private String mBody;
  private transient CharSequence mCachedAuthorName;
  private transient CharSequence mCachedSpannableText;

  @c(a="downloadId")
  private String mDownloadId;

  @c(a="encryptedPhoneNumber")
  private String mEncryptedPhoneNumber;

  @c(a="flags")
  private long mFlags;

  @c(a="isFromPublicAccount")
  private boolean mIsFromPublicAccount;

  @c(a="memberId")
  private String mMemberId;

  @c(a="messageId")
  private int mMessageId;

  @c(a="url")
  private String mMessageUrl;

  @c(a="previewText")
  private String mPreviewText;

  @c(a="replySource")
  private int mReplySource;

  @c(a="senderName")
  private String mSenderName;

  @c(a="spans")
  private String mSpans;

  @c(a="textMetaInfo")
  private TextMetaInfo[] mTextMetaInfos;

  @c(a="token")
  private long mToken;

  @c(a="type")
  private int mType;

  public QuotedMessageData()
  {
  }

  public QuotedMessageData(Parcel paramParcel)
  {
    this.mBody = paramParcel.readString();
    this.mDownloadId = paramParcel.readString();
    this.mMemberId = paramParcel.readString();
    this.mType = paramParcel.readInt();
    this.mToken = paramParcel.readLong();
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.mIsFromPublicAccount = i;
      this.mPreviewText = paramParcel.readString();
      this.mSenderName = paramParcel.readString();
      this.mFlags = paramParcel.readLong();
      this.mMessageId = paramParcel.readInt();
      this.mMessageUrl = paramParcel.readString();
      this.mSpans = paramParcel.readString();
      this.mEncryptedPhoneNumber = paramParcel.readString();
      this.mReplySource = paramParcel.readInt();
      this.mTextMetaInfos = ((TextMetaInfo[])paramParcel.createTypedArray(TextMetaInfo.CREATOR));
      return;
      i = 0;
    }
  }

  public void addFlag(long paramLong)
  {
    this.mFlags |= 1 << (int)paramLong;
  }

  public boolean containFlag(long paramLong)
  {
    return (this.mFlags & 1 << (int)paramLong) != 0L;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getBody()
  {
    return this.mBody;
  }

  public CharSequence getCachedAuthorName()
  {
    return this.mCachedAuthorName;
  }

  public CharSequence getCachedSpannableText()
  {
    return this.mCachedSpannableText;
  }

  public String getDownloadId()
  {
    return this.mDownloadId;
  }

  public String getEncryptedPhoneNumber()
  {
    return this.mEncryptedPhoneNumber;
  }

  public long getFlags()
  {
    return this.mFlags;
  }

  public String getMemberId()
  {
    return this.mMemberId;
  }

  public int getMessageId()
  {
    return this.mMessageId;
  }

  public String getMessageUrl()
  {
    return this.mMessageUrl;
  }

  public String getPreviewText()
  {
    return this.mPreviewText;
  }

  public int getReplySource()
  {
    return this.mReplySource;
  }

  public String getSenderName()
  {
    return this.mSenderName;
  }

  public String getSpans()
  {
    return this.mSpans;
  }

  public TextMetaInfo[] getTextMetaInfo()
  {
    return this.mTextMetaInfos;
  }

  public long getToken()
  {
    return this.mToken;
  }

  public int getType()
  {
    return this.mType;
  }

  public boolean isFromPublicAccount()
  {
    return this.mIsFromPublicAccount;
  }

  public boolean isGif()
  {
    return containFlag(1L);
  }

  public boolean isOriginalMessageExists()
  {
    return containFlag(2L);
  }

  public boolean isOriginalMessageWithMention()
  {
    return containFlag(3L);
  }

  public void removeFlag(long paramLong)
  {
    this.mFlags &= (0xFFFFFFFF ^ 1 << (int)paramLong);
  }

  public void setBody(String paramString)
  {
    this.mBody = paramString;
  }

  public void setCachedAuthorName(CharSequence paramCharSequence)
  {
    this.mCachedAuthorName = paramCharSequence;
  }

  public void setCachedSpannableText(CharSequence paramCharSequence)
  {
    this.mCachedSpannableText = paramCharSequence;
  }

  public void setDownloadId(String paramString)
  {
    this.mDownloadId = paramString;
  }

  public void setEncryptedPhoneNumber(String paramString)
  {
    this.mEncryptedPhoneNumber = paramString;
  }

  public void setFlags(long paramLong)
  {
    this.mFlags = paramLong;
  }

  public void setFromPublicAccount(boolean paramBoolean)
  {
    this.mIsFromPublicAccount = paramBoolean;
  }

  public void setMemberId(String paramString)
  {
    this.mMemberId = paramString;
  }

  public void setMessageId(int paramInt)
  {
    this.mMessageId = paramInt;
  }

  public void setMessageUrl(String paramString)
  {
    this.mMessageUrl = paramString;
  }

  public void setPreviewText(String paramString)
  {
    this.mPreviewText = paramString;
  }

  public void setReplySource(int paramInt)
  {
    this.mReplySource = paramInt;
  }

  public void setSenderName(String paramString)
  {
    this.mSenderName = paramString;
  }

  public void setSpans(String paramString)
  {
    this.mSpans = paramString;
  }

  public void setTextMetaInfo(TextMetaInfo[] paramArrayOfTextMetaInfo)
  {
    this.mTextMetaInfos = paramArrayOfTextMetaInfo;
  }

  public void setToken(long paramLong)
  {
    this.mToken = paramLong;
  }

  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }

  public String toString()
  {
    return "QuotedMessageData{mBody='" + this.mBody + '\'' + ", mType=" + this.mType + ", mDownloadId='" + this.mDownloadId + '\'' + ", mSenderName='" + this.mSenderName + '\'' + ", mToken=" + this.mToken + ", mMemberId='" + this.mMemberId + '\'' + ", mIsFromPublicAccount=" + this.mIsFromPublicAccount + ", mPreviewText='" + this.mPreviewText + '\'' + ", mFlags=" + this.mFlags + ", mMessageId=" + this.mMessageId + ", mMessageUrl='" + this.mMessageUrl + '\'' + ", mSpans='" + this.mSpans + '\'' + ", mEncryptedPhoneNumber='" + this.mEncryptedPhoneNumber + '\'' + ", mCachedAuthorName=" + this.mCachedAuthorName + ", mCachedSpannableText=" + this.mCachedSpannableText + ", mReplySource=" + this.mReplySource + ", mTextMetaInfos=" + Arrays.toString(this.mTextMetaInfos) + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mBody);
    paramParcel.writeString(this.mDownloadId);
    paramParcel.writeString(this.mMemberId);
    paramParcel.writeInt(this.mType);
    paramParcel.writeLong(this.mToken);
    if (this.mIsFromPublicAccount);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.mPreviewText);
      paramParcel.writeString(this.mSenderName);
      paramParcel.writeLong(this.mFlags);
      paramParcel.writeInt(this.mMessageId);
      paramParcel.writeString(this.mMessageUrl);
      paramParcel.writeString(this.mSpans);
      paramParcel.writeString(this.mEncryptedPhoneNumber);
      paramParcel.writeInt(this.mReplySource);
      paramParcel.writeTypedArray(this.mTextMetaInfos, paramInt);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.quote.QuotedMessageData
 * JD-Core Version:    0.6.2
 */