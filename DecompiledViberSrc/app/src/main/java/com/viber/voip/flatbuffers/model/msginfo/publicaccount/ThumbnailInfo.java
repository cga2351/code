package com.viber.voip.flatbuffers.model.msginfo.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class ThumbnailInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ThumbnailInfo> CREATOR = new Parcelable.Creator()
  {
    public ThumbnailInfo a(Parcel paramAnonymousParcel)
    {
      return new ThumbnailInfo(paramAnonymousParcel);
    }

    public ThumbnailInfo[] a(int paramAnonymousInt)
    {
      return new ThumbnailInfo[paramAnonymousInt];
    }
  };

  @c(a="ThumbnailEP")
  private String mThumbnailEP;

  public ThumbnailInfo()
  {
  }

  public ThumbnailInfo(Parcel paramParcel)
  {
    this.mThumbnailEP = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getThumbnailEP()
  {
    return this.mThumbnailEP;
  }

  public void setThumbnailEP(String paramString)
  {
    this.mThumbnailEP = paramString;
  }

  public String toString()
  {
    return "ThumbnailInfo{mThumbnailEP='" + this.mThumbnailEP + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mThumbnailEP);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.ThumbnailInfo
 * JD-Core Version:    0.6.2
 */