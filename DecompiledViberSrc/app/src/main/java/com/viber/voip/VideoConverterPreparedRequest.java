package com.viber.voip;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoConverterPreparedRequest
  implements Parcelable
{
  public static final Parcelable.Creator<VideoConverterPreparedRequest> CREATOR = new Parcelable.Creator()
  {
    public VideoConverterPreparedRequest a(Parcel paramAnonymousParcel)
    {
      return new VideoConverterPreparedRequest(paramAnonymousParcel, null);
    }

    public VideoConverterPreparedRequest[] a(int paramAnonymousInt)
    {
      return new VideoConverterPreparedRequest[paramAnonymousInt];
    }
  };
  private static String TAG = "VideoConverterPreparedRequest";
  String _configuration;
  a _forecast;
  private VideoConverterRequest _request;

  private VideoConverterPreparedRequest(Parcel paramParcel)
  {
    this._configuration = paramParcel.readString();
    this._request = ((VideoConverterRequest)VideoConverterRequest.CREATOR.createFromParcel(paramParcel));
    this._forecast = a.valueOf(paramParcel.readString());
  }

  public VideoConverterPreparedRequest(VideoConverterRequest paramVideoConverterRequest, String paramString, a parama)
  {
    this._request = paramVideoConverterRequest;
    this._configuration = paramString;
    this._forecast = parama;
  }

  public final String configuration()
  {
    return this._configuration;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof VideoConverterPreparedRequest)) && (paramObject.toString().equals(toString()));
  }

  public final a forecast()
  {
    return this._forecast;
  }

  public int hashCode()
  {
    return toString().hashCode();
  }

  public final VideoConverterRequest request()
  {
    return this._request;
  }

  public String toString()
  {
    return "(" + this._forecast.name() + " " + this._request.toString() + " " + this._configuration + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this._configuration != null);
    for (String str = this._configuration.toString(); ; str = "")
    {
      paramParcel.writeString(str);
      this._request.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this._forecast.name());
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
 * Qualified Name:     com.viber.voip.VideoConverterPreparedRequest
 * JD-Core Version:    0.6.2
 */