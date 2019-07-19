package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import java.util.Arrays;

public class Pin
  implements Parcelable
{
  public static final Parcelable.Creator<Pin> CREATOR = new Parcelable.Creator()
  {
    public Pin a(Parcel paramAnonymousParcel)
    {
      return new Pin(paramAnonymousParcel);
    }

    public Pin[] a(int paramAnonymousInt)
    {
      return new Pin[paramAnonymousInt];
    }
  };
  public static final int POLL_MESSAGE = 1;

  @c(a="action")
  private a mAction;

  @c(a="extended")
  private ExtendedInfo mExtendedInfo;

  @c(a="flags")
  private int mFlags;

  @c(a="type")
  private int mMediaType;

  @c(a="number")
  private String mNumber;

  @c(a="seqInPg")
  private int mSeqInPG;

  @c(a="text")
  private String mText;

  @c(a="textMetaInfo")
  private TextMetaInfo[] mTextMetaInfo;

  @c(a="token")
  private UnsignedLong mToken;

  public Pin()
  {
  }

  protected Pin(Parcel paramParcel)
  {
    this.mText = paramParcel.readString();
    this.mToken = ((UnsignedLong)paramParcel.readParcelable(UnsignedLong.class.getClassLoader()));
    int i = paramParcel.readInt();
    if (i >= 0);
    for (this.mAction = a.values()[i]; ; this.mAction = null)
    {
      this.mNumber = paramParcel.readString();
      this.mSeqInPG = paramParcel.readInt();
      this.mMediaType = paramParcel.readInt();
      this.mFlags = paramParcel.readInt();
      this.mExtendedInfo = ((ExtendedInfo)paramParcel.readParcelable(ExtendedInfo.class.getClassLoader()));
      this.mTextMetaInfo = ((TextMetaInfo[])paramParcel.createTypedArray(TextMetaInfo.CREATOR));
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public a getAction()
  {
    return this.mAction;
  }

  public ExtendedInfo getExtendedInfo()
  {
    return this.mExtendedInfo;
  }

  public int getFlags()
  {
    return this.mFlags;
  }

  public int getMediaType()
  {
    return this.mMediaType;
  }

  public String getNumber()
  {
    return this.mNumber;
  }

  public int getSeqInPG()
  {
    return this.mSeqInPG;
  }

  public String getText()
  {
    return this.mText;
  }

  public TextMetaInfo[] getTextMetaInfo()
  {
    return this.mTextMetaInfo;
  }

  public long getToken()
  {
    if (this.mToken != null)
      return this.mToken.get();
    return 0L;
  }

  public void setAction(a parama)
  {
    this.mAction = parama;
  }

  public void setExtendedInfo(ExtendedInfo paramExtendedInfo)
  {
    this.mExtendedInfo = paramExtendedInfo;
  }

  public void setFlags(int paramInt)
  {
    this.mFlags = paramInt;
  }

  public void setMediaType(int paramInt)
  {
    this.mMediaType = paramInt;
  }

  public void setNumber(String paramString)
  {
    this.mNumber = paramString;
  }

  public void setSeqInPG(int paramInt)
  {
    this.mSeqInPG = paramInt;
  }

  public void setText(String paramString)
  {
    this.mText = paramString;
  }

  public void setTextMetaInfo(TextMetaInfo[] paramArrayOfTextMetaInfo)
  {
    this.mTextMetaInfo = paramArrayOfTextMetaInfo;
  }

  public void setToken(long paramLong)
  {
    this.mToken = new UnsignedLong(paramLong);
  }

  public String toString()
  {
    return "Pin{mText='" + this.mText + '\'' + ", mToken=" + this.mToken + ", mAction=" + this.mAction + ", mNumber='" + this.mNumber + '\'' + ", mSeqInPG='" + this.mSeqInPG + '\'' + ", mMediaType=" + this.mMediaType + ", mExtendedInfo=" + this.mExtendedInfo + ", mFlags=" + this.mFlags + ", mTextMetaInfo=" + Arrays.toString(this.mTextMetaInfo) + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mText);
    paramParcel.writeParcelable(this.mToken, paramInt);
    if (this.mAction != null);
    for (int i = this.mAction.ordinal(); ; i = -1)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.mNumber);
      paramParcel.writeInt(this.mSeqInPG);
      paramParcel.writeInt(this.mMediaType);
      paramParcel.writeInt(this.mFlags);
      paramParcel.writeParcelable(this.mExtendedInfo, paramInt);
      paramParcel.writeTypedArray(this.mTextMetaInfo, paramInt);
      return;
    }
  }

  public static enum a
  {
    final String mTypeName;

    static
    {
      ARCHIVE = new a("ARCHIVE", 3, "archive");
      a[] arrayOfa = new a[4];
      arrayOfa[0] = CREATE;
      arrayOfa[1] = DELETE;
      arrayOfa[2] = EDIT;
      arrayOfa[3] = ARCHIVE;
    }

    private a(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static a fromName(String paramString)
    {
      for (a locala : values())
        if (locala.mTypeName.equalsIgnoreCase(paramString))
          return locala;
      return null;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.Pin
 * JD-Core Version:    0.6.2
 */