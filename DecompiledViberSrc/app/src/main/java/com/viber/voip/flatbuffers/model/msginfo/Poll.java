package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import java.util.Arrays;

public class Poll
  implements Parcelable
{
  public static final Parcelable.Creator<Poll> CREATOR = new Parcelable.Creator()
  {
    public Poll a(Parcel paramAnonymousParcel)
    {
      return new Poll(paramAnonymousParcel);
    }

    public Poll[] a(int paramAnonymousInt)
    {
      return new Poll[paramAnonymousInt];
    }
  };
  public static final String TYPE_OPTION = "option";
  public static final String TYPE_POLL = "poll";

  @c(a="groupID")
  private String mGroupId;

  @c(a="multiple")
  private boolean mMultiple;

  @c(a="options")
  private PollUiOptions[] mOptions;

  @c(a="parentSeq")
  private int mParentSeq;

  @c(a="parentToken")
  private UnsignedLong mParentToken;

  @c(a="senderID")
  private String mSenderId;

  @c(a="tokens")
  private long[] mTokens;

  @c(a="type")
  private String mType;

  public Poll()
  {
  }

  protected Poll(Parcel paramParcel)
  {
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.mType = paramParcel.readString();
    this.mParentToken = ((UnsignedLong)paramParcel.readParcelable(localClassLoader));
    this.mParentSeq = paramParcel.readInt();
    this.mTokens = paramParcel.createLongArray();
    this.mOptions = ((PollUiOptions[])paramParcel.createTypedArray(PollUiOptions.CREATOR));
    if (paramParcel.readByte() > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mMultiple = bool;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getGroupId()
  {
    return this.mGroupId;
  }

  public PollUiOptions[] getOptions()
  {
    return this.mOptions;
  }

  public int getParentSeq()
  {
    return this.mParentSeq;
  }

  public UnsignedLong getParentToken()
  {
    return this.mParentToken;
  }

  public String getSenderId()
  {
    return this.mSenderId;
  }

  public long[] getTokens()
  {
    return this.mTokens;
  }

  public String getType()
  {
    return this.mType;
  }

  public boolean isMultiple()
  {
    return this.mMultiple;
  }

  public void setGroupId(String paramString)
  {
    this.mGroupId = paramString;
  }

  public void setMultiple(boolean paramBoolean)
  {
    this.mMultiple = paramBoolean;
  }

  public void setOptions(PollUiOptions[] paramArrayOfPollUiOptions)
  {
    this.mOptions = paramArrayOfPollUiOptions;
  }

  public void setParentSeq(int paramInt)
  {
    this.mParentSeq = paramInt;
  }

  public void setParentToken(long paramLong)
  {
    this.mParentToken = new UnsignedLong(paramLong);
  }

  public void setSenderId(String paramString)
  {
    this.mSenderId = paramString;
  }

  public void setTokens(long[] paramArrayOfLong)
  {
    this.mTokens = paramArrayOfLong;
  }

  public void setType(String paramString)
  {
    this.mType = paramString;
  }

  public String toString()
  {
    return "Poll{mType='" + this.mType + '\'' + ", mParentToken=" + this.mParentToken + ", mParentSeq=" + this.mParentSeq + ", mTokens=" + Arrays.toString(this.mTokens) + ", mMultiple=" + this.mMultiple + ", mOptions=" + Arrays.toString(this.mOptions) + ", mSenderId='" + this.mSenderId + '\'' + ", mGroupId='" + this.mGroupId + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mType);
    paramParcel.writeParcelable(this.mParentToken, paramInt);
    paramParcel.writeInt(this.mParentSeq);
    paramParcel.writeLongArray(this.mTokens);
    paramParcel.writeTypedArray(this.mOptions, paramInt);
    if (this.mMultiple);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.Poll
 * JD-Core Version:    0.6.2
 */