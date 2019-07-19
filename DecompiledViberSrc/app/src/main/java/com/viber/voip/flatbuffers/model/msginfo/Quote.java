package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.google.d.f;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import java.util.Arrays;

public class Quote
  implements Parcelable
{
  public static final Parcelable.Creator<Quote> CREATOR = new Parcelable.Creator()
  {
    public Quote a(Parcel paramAnonymousParcel)
    {
      return new Quote(paramAnonymousParcel);
    }

    public Quote[] a(int paramAnonymousInt)
    {
      return new Quote[paramAnonymousInt];
    }
  };

  @c(a="type")
  private int mMediaType;

  @c(a="memberID")
  private String mMemberId;

  @c(a="messageID")
  private int mMessageId;

  @c(a="replySource")
  private int mReplySource;

  @c(a="text")
  private String mText;

  @c(a="textMetaInfo")
  private TextMetaInfo[] mTextMetaInfos;

  @c(a="token")
  private long mToken;

  public Quote()
  {
  }

  Quote(Parcel paramParcel)
  {
    this.mToken = paramParcel.readLong();
    this.mMediaType = paramParcel.readInt();
    this.mMemberId = paramParcel.readString();
    this.mText = paramParcel.readString();
    this.mMessageId = paramParcel.readInt();
    this.mReplySource = paramParcel.readInt();
    this.mTextMetaInfos = ((TextMetaInfo[])paramParcel.createTypedArray(TextMetaInfo.CREATOR));
  }

  public int describeContents()
  {
    return 0;
  }

  public int getMediaType()
  {
    return this.mMediaType;
  }

  public String getMemberId()
  {
    return this.mMemberId;
  }

  public int getMessageId()
  {
    return this.mMessageId;
  }

  public int getReplySource()
  {
    return this.mReplySource;
  }

  public String getText()
  {
    return this.mText;
  }

  public TextMetaInfo[] getTextMetaInfo()
  {
    return this.mTextMetaInfos;
  }

  public long getToken()
  {
    return this.mToken;
  }

  public void setMediaType(int paramInt)
  {
    this.mMediaType = paramInt;
  }

  public void setMemberId(String paramString)
  {
    this.mMemberId = paramString;
  }

  public void setMessageId(int paramInt)
  {
    this.mMessageId = paramInt;
  }

  public void setReplySource(int paramInt)
  {
    this.mReplySource = paramInt;
  }

  public void setText(String paramString)
  {
    this.mText = paramString;
  }

  public void setTextMetaInfo(TextMetaInfo[] paramArrayOfTextMetaInfo)
  {
    this.mTextMetaInfos = paramArrayOfTextMetaInfo;
  }

  public void setToken(long paramLong)
  {
    this.mToken = paramLong;
  }

  public String toJson()
  {
    return new f().b(this);
  }

  public String toString()
  {
    return "Quote{mToken=" + this.mToken + ", mMediaType=" + this.mMediaType + ", mText='" + this.mText + '\'' + ", mMemberId='" + this.mMemberId + '\'' + ", mMessageId='" + this.mMessageId + '\'' + ", mTextMetaInfos='" + Arrays.toString(this.mTextMetaInfos) + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mToken);
    paramParcel.writeInt(this.mMediaType);
    paramParcel.writeString(this.mMemberId);
    paramParcel.writeString(this.mText);
    paramParcel.writeInt(this.mMessageId);
    paramParcel.writeInt(this.mReplySource);
    paramParcel.writeTypedArray(this.mTextMetaInfos, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.Quote
 * JD-Core Version:    0.6.2
 */