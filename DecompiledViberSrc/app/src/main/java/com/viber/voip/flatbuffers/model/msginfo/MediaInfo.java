package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;

public class MediaInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaInfo> CREATOR = new Parcelable.Creator()
  {
    public MediaInfo a(Parcel paramAnonymousParcel)
    {
      return new MediaInfo(paramAnonymousParcel);
    }

    public MediaInfo[] a(int paramAnonymousInt)
    {
      return new MediaInfo[paramAnonymousInt];
    }
  };

  @c(a="Height")
  private UnsignedInt mHeight;

  @c(a="MediaType")
  private a mMediaType;

  @c(a="Width")
  private UnsignedInt mWidth;

  public MediaInfo()
  {
  }

  MediaInfo(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i >= 0)
      this.mMediaType = a.values()[i];
    this.mWidth = ((UnsignedInt)paramParcel.readParcelable(UnsignedInt.class.getClassLoader()));
    this.mHeight = ((UnsignedInt)paramParcel.readParcelable(UnsignedInt.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public int getHeight()
  {
    if (this.mHeight != null)
      return this.mHeight.get();
    return 0;
  }

  public a getMediaType()
  {
    return this.mMediaType;
  }

  public int getWidth()
  {
    if (this.mWidth != null)
      return this.mWidth.get();
    return 0;
  }

  public void setHeight(int paramInt)
  {
    this.mHeight = new UnsignedInt(paramInt);
  }

  public void setMediaType(a parama)
  {
    this.mMediaType = parama;
  }

  public void setWidth(int paramInt)
  {
    this.mWidth = new UnsignedInt(paramInt);
  }

  public String toString()
  {
    return "MediaInfo{mMediaType=" + this.mMediaType + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mMediaType != null);
    for (int i = this.mMediaType.ordinal(); ; i = -1)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.mWidth, paramInt);
      paramParcel.writeParcelable(this.mHeight, paramInt);
      return;
    }
  }

  public static enum a
  {
    final String mTypeName;

    static
    {
      UNKNOWN = new a("UNKNOWN", 3, "UNKNOWN");
      a[] arrayOfa = new a[4];
      arrayOfa[0] = GIF;
      arrayOfa[1] = IMAGE;
      arrayOfa[2] = VIDEO;
      arrayOfa[3] = UNKNOWN;
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.MediaInfo
 * JD-Core Version:    0.6.2
 */