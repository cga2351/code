package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class TechInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TechInfo> CREATOR = new Parcelable.Creator()
  {
    public TechInfo a(Parcel paramAnonymousParcel)
    {
      return new TechInfo(paramAnonymousParcel);
    }

    public TechInfo[] a(int paramAnonymousInt)
    {
      return new TechInfo[paramAnonymousInt];
    }
  };
  public static final String TECH_INFO_JSON_KEY = "tech_info";

  @c(a="seq")
  private int mSeq;

  public TechInfo()
  {
  }

  TechInfo(Parcel paramParcel)
  {
    this.mSeq = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public int getSeq()
  {
    return this.mSeq;
  }

  public void setSeq(int paramInt)
  {
    this.mSeq = paramInt;
  }

  public String toString()
  {
    return "TechInfo{mSeq='" + this.mSeq + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mSeq);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.TechInfo
 * JD-Core Version:    0.6.2
 */