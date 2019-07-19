package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class MediaMetadata
  implements Parcelable
{
  public static final Parcelable.Creator<MediaMetadata> CREATOR = new Parcelable.Creator()
  {
    public MediaMetadata a(Parcel paramAnonymousParcel)
    {
      return new MediaMetadata(paramAnonymousParcel);
    }

    public MediaMetadata[] a(int paramAnonymousInt)
    {
      return new MediaMetadata[paramAnonymousInt];
    }
  };
  public static final String MEDIA_ENCRYPTION_PARAMS_PARAMS_JSON_KEY = "EncParams";
  public static final String MEDIA_METADATA_JSON_KEY = "MediaMetadata";

  @c(a="EncParams")
  private final String mEncParams;

  public MediaMetadata(Parcel paramParcel)
  {
    this.mEncParams = paramParcel.readString();
  }

  private MediaMetadata(String paramString)
  {
    this.mEncParams = paramString;
  }

  public a buildUpon()
  {
    return new a(this, null);
  }

  public int describeContents()
  {
    return 0;
  }

  public String getEncParams()
  {
    return this.mEncParams;
  }

  public boolean isEmpty()
  {
    return this.mEncParams == null;
  }

  public String toString()
  {
    return "MediaMetadata{mEncParams='" + this.mEncParams + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mEncParams);
  }

  public static class a
  {
    private String a;

    public a()
    {
    }

    private a(MediaMetadata paramMediaMetadata)
    {
      this.a = paramMediaMetadata.mEncParams;
    }

    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public MediaMetadata a()
    {
      return new MediaMetadata(this.a, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.MediaMetadata
 * JD-Core Version:    0.6.2
 */