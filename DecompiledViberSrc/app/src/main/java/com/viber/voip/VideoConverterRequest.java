package com.viber.voip;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoConverterRequest
  implements Parcelable
{
  public static final Parcelable.Creator<VideoConverterRequest> CREATOR = new Parcelable.Creator()
  {
    public VideoConverterRequest a(Parcel paramAnonymousParcel)
    {
      return new VideoConverterRequest(paramAnonymousParcel, null);
    }

    public VideoConverterRequest[] a(int paramAnonymousInt)
    {
      return new VideoConverterRequest[paramAnonymousInt];
    }
  };
  private static String TAG = "VideoConverterRequest";
  private String _debugHints;
  private long _desiredFilesize;
  private Uri _dst;
  private Uri _src;

  public VideoConverterRequest(Uri paramUri1, Uri paramUri2, long paramLong, String paramString)
  {
    this._src = paramUri1;
    this._dst = paramUri2;
    this._desiredFilesize = paramLong;
    this._debugHints = paramString;
  }

  private VideoConverterRequest(Parcel paramParcel)
  {
    this._src = Uri.parse(paramParcel.readString());
    this._dst = Uri.parse(paramParcel.readString());
    this._desiredFilesize = paramParcel.readLong();
    paramParcel.readInt();
    this._debugHints = paramParcel.readString();
  }

  public String debugHints()
  {
    return this._debugHints;
  }

  public int describeContents()
  {
    return 0;
  }

  public long desiredFilesize()
  {
    return this._desiredFilesize;
  }

  public final Uri destination()
  {
    return this._dst;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof VideoConverterRequest)) && (paramObject.toString().equals(toString()));
  }

  public int hashCode()
  {
    return toString().hashCode();
  }

  public final Uri source()
  {
    return this._src;
  }

  public String toString()
  {
    return "(" + this._src + " -> " + this._dst + " targetsize=" + this._desiredFilesize + " debughints=" + this._debugHints + " )";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str1;
    String str2;
    if (this._src != null)
    {
      str1 = this._src.toString();
      paramParcel.writeString(str1);
      if (this._dst == null)
        break label81;
      str2 = this._dst.toString();
      label36: paramParcel.writeString(str2);
      paramParcel.writeLong(this._desiredFilesize);
      paramParcel.writeInt(0);
      if (this._debugHints == null)
        break label88;
    }
    label81: label88: for (String str3 = this._debugHints; ; str3 = "")
    {
      paramParcel.writeString(str3);
      return;
      str1 = "";
      break;
      str2 = "";
      break label36;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.VideoConverterRequest
 * JD-Core Version:    0.6.2
 */