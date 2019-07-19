package com.viber.jni;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OnlineContactInfo
  implements Parcelable
{
  public static final Parcelable.Creator<OnlineContactInfo> CREATOR = new Parcelable.Creator()
  {
    public OnlineContactInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OnlineContactInfo(paramAnonymousParcel);
    }

    public OnlineContactInfo[] newArray(int paramAnonymousInt)
    {
      return new OnlineContactInfo[paramAnonymousInt];
    }
  };
  private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
  public boolean isOnLine = false;
  public String memberId = "";
  public long time = 0L;

  public OnlineContactInfo(Parcel paramParcel)
  {
    this.memberId = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.isOnLine = i;
      this.time = paramParcel.readLong();
      return;
      i = 0;
    }
  }

  public OnlineContactInfo(String paramString, boolean paramBoolean, long paramLong)
  {
    this.memberId = paramString;
    this.isOnLine = paramBoolean;
    this.time = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "OnlineContactInfo memberId:" + this.memberId + " isOnLine:" + this.isOnLine + " timeStamp:" + formatter.format(new Date(this.time));
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.memberId);
    if (this.isOnLine);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeLong(this.time);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.OnlineContactInfo
 * JD-Core Version:    0.6.2
 */