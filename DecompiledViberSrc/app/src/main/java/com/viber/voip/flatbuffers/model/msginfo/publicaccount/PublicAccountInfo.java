package com.viber.voip.flatbuffers.model.msginfo.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.d.a.c;

public class PublicAccountInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PublicAccountInfo> CREATOR = new Parcelable.Creator()
  {
    public PublicAccountInfo a(Parcel paramAnonymousParcel)
    {
      return new PublicAccountInfo(paramAnonymousParcel);
    }

    public PublicAccountInfo[] a(int paramAnonymousInt)
    {
      return new PublicAccountInfo[paramAnonymousInt];
    }
  };

  @c(a="ignore_pa_info")
  private boolean mIgnorePaInfo;

  @c(a="id")
  private String mPaId;

  @c(a="name")
  private String mPaName;

  @c(a="uri")
  private String mUri;

  public PublicAccountInfo()
  {
  }

  protected PublicAccountInfo(Parcel paramParcel)
  {
    this.mPaId = paramParcel.readString();
    this.mPaName = paramParcel.readString();
    this.mUri = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIgnorePaInfo = bool;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getPaId()
  {
    return this.mPaId;
  }

  public String getPaName()
  {
    return this.mPaName;
  }

  public String getUri()
  {
    return this.mUri;
  }

  public boolean isIgnorePaInfo()
  {
    return (this.mIgnorePaInfo) || (TextUtils.isEmpty(this.mPaId));
  }

  public void setIgnorePaInfo(boolean paramBoolean)
  {
    this.mIgnorePaInfo = paramBoolean;
  }

  public void setPaId(String paramString)
  {
    this.mPaId = paramString;
  }

  public void setPaName(String paramString)
  {
    this.mPaName = paramString;
  }

  public void setUri(String paramString)
  {
    this.mUri = paramString;
  }

  public String toString()
  {
    return "InlineMessage{mPaId='" + this.mPaId + '\'' + ", mPaName='" + this.mPaName + '\'' + ", mUri='" + this.mUri + '\'' + ", mIgnorePaInfo=" + this.mIgnorePaInfo + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPaId);
    paramParcel.writeString(this.mPaName);
    paramParcel.writeString(this.mUri);
    if (this.mIgnorePaInfo);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountInfo
 * JD-Core Version:    0.6.2
 */