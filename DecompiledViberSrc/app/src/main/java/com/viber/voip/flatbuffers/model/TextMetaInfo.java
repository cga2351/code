package com.viber.voip.flatbuffers.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.b;
import com.google.d.a.c;

public class TextMetaInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TextMetaInfo> CREATOR = new Parcelable.Creator()
  {
    public TextMetaInfo a(Parcel paramAnonymousParcel)
    {
      return new TextMetaInfo(paramAnonymousParcel);
    }

    public TextMetaInfo[] a(int paramAnonymousInt)
    {
      return new TextMetaInfo[paramAnonymousInt];
    }
  };
  public static final int VERSION = 1;

  @c(a="end")
  private int mEndPosition;

  @c(a="memberId")
  private String mMemberId;

  @c(a="start")
  private int mStartPosition;

  @b(a="Lcom/viber/voip/flatbuffers/c/g;")
  @c(a="type")
  private a mType;

  public TextMetaInfo()
  {
  }

  TextMetaInfo(Parcel paramParcel)
  {
    this.mStartPosition = paramParcel.readInt();
    this.mEndPosition = paramParcel.readInt();
    this.mType = a.fromValue(paramParcel.readInt());
    this.mMemberId = paramParcel.readString();
  }

  public TextMetaInfo(TextMetaInfo paramTextMetaInfo)
  {
    this.mStartPosition = paramTextMetaInfo.mStartPosition;
    this.mEndPosition = paramTextMetaInfo.mEndPosition;
    this.mType = paramTextMetaInfo.mType;
    this.mMemberId = paramTextMetaInfo.mMemberId;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getEndPosition()
  {
    return this.mEndPosition;
  }

  public String getMemberId()
  {
    return this.mMemberId;
  }

  public int getStartPosition()
  {
    return this.mStartPosition;
  }

  public a getType()
  {
    if (this.mType == null)
      return a.UNKNOWN;
    return this.mType;
  }

  public void setEndPosition(int paramInt)
  {
    this.mEndPosition = paramInt;
  }

  public void setMemberId(String paramString)
  {
    this.mMemberId = paramString;
  }

  public void setStartPosition(int paramInt)
  {
    this.mStartPosition = paramInt;
  }

  public void setType(a parama)
  {
    this.mType = parama;
  }

  public String toString()
  {
    return "TextMetaInfo{mStartPosition=" + this.mStartPosition + ", mEndPosition=" + this.mEndPosition + ", mType=" + this.mType + ", mMemberId='" + this.mMemberId + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mStartPosition);
    paramParcel.writeInt(this.mEndPosition);
    paramParcel.writeInt(getType().getValue());
    paramParcel.writeString(this.mMemberId);
  }

  public static enum a
  {
    final int mValue;

    static
    {
      MENTION = new a("MENTION", 1, 0);
      a[] arrayOfa = new a[2];
      arrayOfa[0] = UNKNOWN;
      arrayOfa[1] = MENTION;
    }

    private a(int paramInt)
    {
      this.mValue = paramInt;
    }

    public static a fromValue(int paramInt)
    {
      for (a locala : values())
        if (locala.mValue == paramInt)
          return locala;
      return UNKNOWN;
    }

    public int getValue()
    {
      return this.mValue;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.TextMetaInfo
 * JD-Core Version:    0.6.2
 */