package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class ColorInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator()
  {
    public ColorInfo a(Parcel paramAnonymousParcel)
    {
      return new ColorInfo(paramAnonymousParcel);
    }

    public ColorInfo[] a(int paramAnonymousInt)
    {
      return new ColorInfo[0];
    }
  };
  public final int colorRange;
  public final int colorSpace;
  public final int colorTransfer;
  private int hashCode;
  public final byte[] hdrStaticInfo;

  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.colorSpace = paramInt1;
    this.colorRange = paramInt2;
    this.colorTransfer = paramInt3;
    this.hdrStaticInfo = paramArrayOfByte;
  }

  ColorInfo(Parcel paramParcel)
  {
    this.colorSpace = paramParcel.readInt();
    this.colorRange = paramParcel.readInt();
    this.colorTransfer = paramParcel.readInt();
    if (ag.a(paramParcel));
    for (byte[] arrayOfByte = paramParcel.createByteArray(); ; arrayOfByte = null)
    {
      this.hdrStaticInfo = arrayOfByte;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ColorInfo localColorInfo;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localColorInfo = (ColorInfo)paramObject;
    }
    while ((this.colorSpace == localColorInfo.colorSpace) && (this.colorRange == localColorInfo.colorRange) && (this.colorTransfer == localColorInfo.colorTransfer) && (Arrays.equals(this.hdrStaticInfo, localColorInfo.hdrStaticInfo)));
    return false;
  }

  public int hashCode()
  {
    if (this.hashCode == 0)
      this.hashCode = (31 * (31 * (31 * (527 + this.colorSpace) + this.colorRange) + this.colorTransfer) + Arrays.hashCode(this.hdrStaticInfo));
    return this.hashCode;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ColorInfo(").append(this.colorSpace).append(", ").append(this.colorRange).append(", ").append(this.colorTransfer).append(", ");
    if (this.hdrStaticInfo != null);
    for (boolean bool = true; ; bool = false)
      return bool + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.colorSpace);
    paramParcel.writeInt(this.colorRange);
    paramParcel.writeInt(this.colorTransfer);
    if (this.hdrStaticInfo != null);
    for (boolean bool = true; ; bool = false)
    {
      ag.a(paramParcel, bool);
      if (this.hdrStaticInfo != null)
        paramParcel.writeByteArray(this.hdrStaticInfo);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.6.2
 */