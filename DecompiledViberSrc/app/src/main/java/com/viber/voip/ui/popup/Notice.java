package com.viber.voip.ui.popup;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Notice
  implements Parcelable
{
  public static final Parcelable.Creator<Notice> CREATOR = new Parcelable.Creator()
  {
    public Notice a(Parcel paramAnonymousParcel)
    {
      return new Notice(paramAnonymousParcel);
    }

    public Notice[] a(int paramAnonymousInt)
    {
      return new Notice[paramAnonymousInt];
    }
  };
  static final String EXTRA_NOTICES = "com.viber.voip.SAVED_NOTICES";
  final String action;
  final long duration;
  final String message;
  final a.b style;
  final Parcelable token;

  Notice(Parcel paramParcel)
  {
    this.message = paramParcel.readString();
    this.action = paramParcel.readString();
    this.token = paramParcel.readParcelable(Parcelable.class.getClassLoader());
    this.duration = paramParcel.readLong();
    this.style = a.b.valueOf(paramParcel.readString());
  }

  Notice(String paramString1, String paramString2, Parcelable paramParcelable, long paramLong, a.b paramb)
  {
    this.message = paramString1;
    this.action = paramString2;
    this.token = paramParcelable;
    this.duration = paramLong;
    this.style = paramb;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.message);
    paramParcel.writeString(this.action);
    paramParcel.writeParcelable(this.token, 0);
    paramParcel.writeLong(this.duration);
    paramParcel.writeString(this.style.name());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.popup.Notice
 * JD-Core Version:    0.6.2
 */