package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;

public class FileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FileInfo> CREATOR = new Parcelable.Creator()
  {
    public FileInfo a(Parcel paramAnonymousParcel)
    {
      return new FileInfo(paramAnonymousParcel);
    }

    public FileInfo[] a(int paramAnonymousInt)
    {
      return new FileInfo[paramAnonymousInt];
    }
  };
  public static final String EMPTY_FILE_EXTENSION = "/";

  @c(a="ContentType")
  private a mContentType;

  @c(a="Duration")
  private double mDuration;

  @c(a="FileExt")
  private String mFileExt;

  @c(a="FileHash")
  private String mFileHash;

  @c(a="FileName")
  private String mFileName;

  @c(a="FileSize")
  private UnsignedLong mFileSize;

  @c(a="lifeSpan")
  private UnsignedInt mLifeSpan;

  @c(a="mediaInfo")
  private MediaInfo mMediaInfo;

  @c(a="OrigSize")
  private UnsignedLong mOriginalSize;

  @c(a="Type")
  private b mWinkType;

  public FileInfo()
  {
  }

  FileInfo(Parcel paramParcel)
  {
    this.mFileName = paramParcel.readString();
    this.mFileExt = paramParcel.readString();
    this.mFileHash = paramParcel.readString();
    int i = paramParcel.readInt();
    int j;
    if (i >= 0)
    {
      this.mContentType = a.values()[i];
      j = paramParcel.readInt();
      if (j < 0)
        break label145;
    }
    label145: for (this.mWinkType = b.values()[j]; ; this.mWinkType = null)
    {
      this.mFileSize = ((UnsignedLong)paramParcel.readParcelable(UnsignedLong.class.getClassLoader()));
      this.mOriginalSize = ((UnsignedLong)paramParcel.readParcelable(UnsignedLong.class.getClassLoader()));
      this.mDuration = paramParcel.readDouble();
      this.mLifeSpan = ((UnsignedInt)paramParcel.readParcelable(UnsignedInt.class.getClassLoader()));
      this.mMediaInfo = ((MediaInfo)paramParcel.readParcelable(MediaInfo.class.getClassLoader()));
      return;
      this.mContentType = null;
      break;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public a getContentType()
  {
    return this.mContentType;
  }

  public double getDuration()
  {
    return this.mDuration;
  }

  public String getFileExt()
  {
    return this.mFileExt;
  }

  public String getFileHash()
  {
    return this.mFileHash;
  }

  public String getFileName()
  {
    return this.mFileName;
  }

  public long getFileSize()
  {
    if (this.mFileSize != null)
      return this.mFileSize.get();
    return 0L;
  }

  public int getLifeSpan()
  {
    if (this.mLifeSpan != null)
      return this.mLifeSpan.get();
    return 0;
  }

  public MediaInfo getMediaInfo()
  {
    return this.mMediaInfo;
  }

  public long getOriginalSize()
  {
    if (this.mOriginalSize != null)
      return this.mOriginalSize.get();
    return 0L;
  }

  public b getWinkType()
  {
    return this.mWinkType;
  }

  public boolean isGifImage()
  {
    return (this.mMediaInfo != null) && (this.mMediaInfo.getMediaType() == MediaInfo.a.GIF);
  }

  public boolean isWinkImage()
  {
    return this.mWinkType == b.IMAGE;
  }

  public void setContentType(a parama)
  {
    this.mContentType = parama;
  }

  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }

  public void setDurationMillis(long paramLong)
  {
    setDuration((500L + paramLong) / 1000L);
  }

  public void setFileExt(String paramString)
  {
    this.mFileExt = paramString;
  }

  public void setFileHash(String paramString)
  {
    this.mFileHash = paramString;
  }

  public void setFileName(String paramString)
  {
    this.mFileName = paramString;
  }

  public void setFileSize(long paramLong)
  {
    this.mFileSize = new UnsignedLong(paramLong);
  }

  public void setLifeSpan(int paramInt)
  {
    this.mLifeSpan = new UnsignedInt(paramInt);
  }

  public void setMediaInfo(MediaInfo paramMediaInfo)
  {
    this.mMediaInfo = paramMediaInfo;
  }

  public void setOriginalSize(long paramLong)
  {
    this.mOriginalSize = new UnsignedLong(paramLong);
  }

  public void setWinkType(b paramb)
  {
    this.mWinkType = paramb;
  }

  public String toString()
  {
    return "FileInfo{mFileName='" + this.mFileName + '\'' + ", mFileExt='" + this.mFileExt + '\'' + ", mFileSize=" + this.mFileSize + ", mOriginalSize=" + this.mOriginalSize + ", mFileHash='" + this.mFileHash + '\'' + ", mContentType=" + this.mContentType + ", mDuration=" + this.mDuration + ", mLifeSpan=" + this.mLifeSpan + ", mMediaInfo=" + this.mMediaInfo + ", mWinkType=" + this.mWinkType + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    paramParcel.writeString(this.mFileName);
    paramParcel.writeString(this.mFileExt);
    paramParcel.writeString(this.mFileHash);
    if (this.mContentType != null);
    for (int j = this.mContentType.ordinal(); ; j = i)
    {
      paramParcel.writeInt(j);
      if (this.mWinkType != null)
        i = this.mWinkType.ordinal();
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.mFileSize, paramInt);
      paramParcel.writeParcelable(this.mOriginalSize, paramInt);
      paramParcel.writeDouble(this.mDuration);
      paramParcel.writeParcelable(this.mLifeSpan, paramInt);
      paramParcel.writeParcelable(this.mMediaInfo, paramInt);
      return;
    }
  }

  public static enum a
  {
    final String mTypeName;

    static
    {
      AUDIO = new a("AUDIO", 1, "AUDIO");
      VIDEO = new a("VIDEO", 2, "VIDEO");
      IMAGE = new a("IMAGE", 3, "PIC");
      UNKNOWN = new a("UNKNOWN", 4, "UNKNOWN");
      a[] arrayOfa = new a[5];
      arrayOfa[0] = FILE;
      arrayOfa[1] = AUDIO;
      arrayOfa[2] = VIDEO;
      arrayOfa[3] = IMAGE;
      arrayOfa[4] = UNKNOWN;
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
      return UNKNOWN;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }

  public static enum b
  {
    final String mTypeName;

    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = IMAGE;
      arrayOfb[1] = PHOTO;
      arrayOfb[2] = VIDEO;
    }

    private b(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static b fromName(String paramString)
    {
      b localb;
      if (TextUtils.isEmpty(paramString))
      {
        localb = null;
        return localb;
      }
      b[] arrayOfb = values();
      int i = arrayOfb.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label62;
        localb = arrayOfb[j];
        if (localb.mTypeName.equalsIgnoreCase(paramString))
        {
          if (PHOTO != localb)
            break;
          return IMAGE;
        }
      }
      label62: return VIDEO;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.FileInfo
 * JD-Core Version:    0.6.2
 */