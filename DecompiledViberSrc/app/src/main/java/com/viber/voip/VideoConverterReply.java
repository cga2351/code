package com.viber.voip;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoConverterReply
  implements Parcelable
{
  public static final Parcelable.Creator<VideoConverterReply> CREATOR = new Parcelable.Creator()
  {
    public VideoConverterReply a(Parcel paramAnonymousParcel)
    {
      return new VideoConverterReply(paramAnonymousParcel, null);
    }

    public VideoConverterReply[] a(int paramAnonymousInt)
    {
      return new VideoConverterReply[paramAnonymousInt];
    }
  };
  private static String TAG = "VideoConverterReply";
  private Uri _fileToUse;
  private a _status;

  public VideoConverterReply(Uri paramUri, a parama)
  {
    this._fileToUse = paramUri;
    this._status = parama;
  }

  private VideoConverterReply(Parcel paramParcel)
  {
    this._fileToUse = Uri.parse(paramParcel.readString());
    this._status = a.valueOf(paramParcel.readString());
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof VideoConverterReply)) && (paramObject.toString().equals(toString()));
  }

  public final Uri fileToUse()
  {
    return this._fileToUse;
  }

  public int hashCode()
  {
    return toString().hashCode();
  }

  public final a status()
  {
    return this._status;
  }

  public String toString()
  {
    return "(" + this._fileToUse + " " + this._status.name() + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this._fileToUse != null);
    for (String str = this._fileToUse.toString(); ; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(this._status.name());
      return;
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.VideoConverterReply
 * JD-Core Version:    0.6.2
 */