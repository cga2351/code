package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;

public class PollUiOptions
  implements Parcelable
{
  public static final Parcelable.Creator<PollUiOptions> CREATOR = new Parcelable.Creator()
  {
    public PollUiOptions a(Parcel paramAnonymousParcel)
    {
      return new PollUiOptions(paramAnonymousParcel);
    }

    public PollUiOptions[] a(int paramAnonymousInt)
    {
      return new PollUiOptions[paramAnonymousInt];
    }
  };

  @c(a="isLiked")
  private boolean mLiked;

  @c(a="count")
  private int mLikesCount;

  @c(a="messageId")
  private int mMessageId;

  @c(a="name")
  private String mName;

  @c(a="seq")
  private int mSeq;

  @c(a="token")
  private UnsignedLong mToken;

  public PollUiOptions()
  {
  }

  protected PollUiOptions(Parcel paramParcel)
  {
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.mSeq = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mToken = ((UnsignedLong)paramParcel.readParcelable(localClassLoader));
    this.mLikesCount = paramParcel.readInt();
    if (paramParcel.readByte() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.mLiked = bool;
      this.mMessageId = paramParcel.readInt();
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    PollUiOptions localPollUiOptions;
    boolean bool5;
    do
    {
      boolean bool3;
      boolean bool4;
      do
      {
        int i;
        int j;
        do
        {
          Class localClass1;
          Class localClass2;
          do
          {
            do
            {
              return bool2;
              bool2 = false;
            }
            while (paramObject == null);
            localClass1 = getClass();
            localClass2 = paramObject.getClass();
            bool2 = false;
          }
          while (localClass1 != localClass2);
          localPollUiOptions = (PollUiOptions)paramObject;
          i = this.mLikesCount;
          j = localPollUiOptions.mLikesCount;
          bool2 = false;
        }
        while (i != j);
        bool3 = this.mLiked;
        bool4 = localPollUiOptions.mLiked;
        bool2 = false;
      }
      while (bool3 != bool4);
      if (this.mName == null)
        break;
      bool5 = this.mName.equals(localPollUiOptions.mName);
      bool2 = false;
    }
    while (!bool5);
    if (this.mToken != null)
      bool1 = this.mToken.equals(localPollUiOptions.mToken);
    while (true)
    {
      return bool1;
      if (localPollUiOptions.mName == null)
        break;
      return false;
      if (localPollUiOptions.mToken != null)
        bool1 = false;
    }
  }

  public int getLikesCount()
  {
    return this.mLikesCount;
  }

  public int getLikesCountForUi()
  {
    if ((this.mLiked) && (this.mLikesCount == 0))
      return 1;
    return this.mLikesCount;
  }

  public int getMessageId()
  {
    return this.mMessageId;
  }

  public String getName()
  {
    return this.mName;
  }

  public int getSeq()
  {
    return this.mSeq;
  }

  public long getToken()
  {
    if (this.mToken != null)
      return this.mToken.longValue();
    return 0L;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.mName != null)
    {
      i = this.mName.hashCode();
      j = i * 31;
      if (this.mToken == null)
        break label79;
    }
    label79: for (int k = this.mToken.hashCode(); ; k = 0)
    {
      int m = 31 * (31 * (k + j) + this.mLikesCount);
      boolean bool = this.mLiked;
      int n = 0;
      if (bool)
        n = 1;
      return m + n;
      i = 0;
      break;
    }
  }

  public boolean isLiked()
  {
    return this.mLiked;
  }

  public void setLiked(boolean paramBoolean)
  {
    this.mLiked = paramBoolean;
  }

  public void setLikesCount(int paramInt)
  {
    this.mLikesCount = paramInt;
  }

  public void setMessageId(int paramInt)
  {
    this.mMessageId = paramInt;
  }

  public void setName(String paramString)
  {
    this.mName = paramString;
  }

  public void setSeq(int paramInt)
  {
    this.mSeq = paramInt;
  }

  public void setToken(long paramLong)
  {
    this.mToken = new UnsignedLong(paramLong);
  }

  public String toString()
  {
    return "PollUiOptions{mSeq=" + this.mSeq + ", mName='" + this.mName + '\'' + ", mMessageId=" + this.mMessageId + ", mToken=" + this.mToken + ", mLikesCount=" + this.mLikesCount + ", mLiked=" + this.mLiked + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mSeq);
    paramParcel.writeString(this.mName);
    paramParcel.writeParcelable(this.mToken, paramInt);
    paramParcel.writeInt(this.mLikesCount);
    if (this.mLiked);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.mMessageId);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.PollUiOptions
 * JD-Core Version:    0.6.2
 */