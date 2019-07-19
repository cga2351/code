package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class bg
  implements Parcelable
{
  public static final Parcelable.Creator<bg> CREATOR = new Parcelable.Creator()
  {
  };
  private final String a;

  protected bg(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public bg(String paramString)
  {
    this.a = paramString;
  }

  public final String a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bg
 * JD-Core Version:    0.6.2
 */