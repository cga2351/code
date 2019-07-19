package com.viber.voip.flatbuffers.model.msginfo.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public final class Sender
  implements Parcelable
{
  public static final Parcelable.Creator<Sender> CREATOR = new Parcelable.Creator()
  {
    public Sender a(Parcel paramAnonymousParcel)
    {
      return new Sender(paramAnonymousParcel, null);
    }

    public Sender[] a(int paramAnonymousInt)
    {
      return new Sender[paramAnonymousInt];
    }
  };

  @c(a="avatar")
  private String mAvatar;

  @c(a="name")
  private String mName;

  public Sender()
  {
  }

  private Sender(Parcel paramParcel)
  {
    this.mName = paramParcel.readString();
    this.mAvatar = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAvatar()
  {
    return this.mAvatar;
  }

  public String getName()
  {
    return this.mName;
  }

  public void setAvatar(String paramString)
  {
    this.mAvatar = paramString;
  }

  public void setName(String paramString)
  {
    this.mName = paramString;
  }

  public String toString()
  {
    return "Sender{mName='" + this.mName + '\'' + ", mAvatar='" + this.mAvatar + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mAvatar);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.Sender
 * JD-Core Version:    0.6.2
 */