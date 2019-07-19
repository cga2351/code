package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class ExtendedInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ExtendedInfo> CREATOR = new Parcelable.Creator()
  {
    public ExtendedInfo a(Parcel paramAnonymousParcel)
    {
      return new ExtendedInfo(paramAnonymousParcel);
    }

    public ExtendedInfo[] a(int paramAnonymousInt)
    {
      return new ExtendedInfo[paramAnonymousInt];
    }
  };

  @c(a="descr")
  private String mDescription;

  @c(a="downloadID")
  private String mDownloadId;

  @c(a="ep")
  private String mEncryptionParams;

  @c(a="fileExt")
  private String mFileExt;

  @c(a="lat")
  private String mLat;

  @c(a="lon")
  private String mLng;

  public ExtendedInfo()
  {
  }

  protected ExtendedInfo(Parcel paramParcel)
  {
    this.mDownloadId = paramParcel.readString();
    this.mLat = paramParcel.readString();
    this.mLng = paramParcel.readString();
    this.mFileExt = paramParcel.readString();
    this.mEncryptionParams = paramParcel.readString();
    this.mDescription = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getDescription()
  {
    return this.mDescription;
  }

  public String getDownloadId()
  {
    return this.mDownloadId;
  }

  public String getEncryptionParams()
  {
    return this.mEncryptionParams;
  }

  public String getFileExt()
  {
    return this.mFileExt;
  }

  public String getLat()
  {
    return this.mLat;
  }

  public String getLng()
  {
    return this.mLng;
  }

  public void setDescription(String paramString)
  {
    this.mDescription = paramString;
  }

  public void setDownloadId(String paramString)
  {
    this.mDownloadId = paramString;
  }

  public void setEncriptionParams(String paramString)
  {
    this.mEncryptionParams = paramString;
  }

  public void setFileExt(String paramString)
  {
    this.mFileExt = paramString;
  }

  public void setLat(String paramString)
  {
    this.mLat = paramString;
  }

  public void setLng(String paramString)
  {
    this.mLng = paramString;
  }

  public String toString()
  {
    return "ExtendedInfo{mDownloadId='" + this.mDownloadId + '\'' + ", mLat='" + this.mLat + '\'' + ", mLng='" + this.mLng + '\'' + ", mEncryptionParams='" + this.mEncryptionParams + '\'' + ", mFileExt='" + this.mFileExt + '\'' + ", mDescription='" + this.mDescription + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mDownloadId);
    paramParcel.writeString(this.mLat);
    paramParcel.writeString(this.mLng);
    paramParcel.writeString(this.mFileExt);
    paramParcel.writeString(this.mEncryptionParams);
    paramParcel.writeString(this.mDescription);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.ExtendedInfo
 * JD-Core Version:    0.6.2
 */