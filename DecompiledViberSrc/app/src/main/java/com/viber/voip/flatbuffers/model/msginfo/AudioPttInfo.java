package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class AudioPttInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AudioPttInfo> CREATOR = new Parcelable.Creator()
  {
    public AudioPttInfo a(Parcel paramAnonymousParcel)
    {
      return new AudioPttInfo(paramAnonymousParcel);
    }

    public AudioPttInfo[] a(int paramAnonymousInt)
    {
      return new AudioPttInfo[paramAnonymousInt];
    }
  };

  @c(a="duration")
  private long mDuration;

  @c(a="bars_info")
  private String mSoundBarsInfo;

  public AudioPttInfo()
  {
  }

  AudioPttInfo(Parcel paramParcel)
  {
    this.mSoundBarsInfo = paramParcel.readString();
    this.mDuration = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public long getDuration()
  {
    return this.mDuration;
  }

  public String getSoundBarsInfo()
  {
    return this.mSoundBarsInfo;
  }

  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }

  public void setSoundBarsInfo(String paramString)
  {
    this.mSoundBarsInfo = paramString;
  }

  public String toString()
  {
    return "AudioPttInfo{mSoundBarsInfo='" + this.mSoundBarsInfo + '\'' + ", mDuration=" + this.mDuration + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mSoundBarsInfo);
    paramParcel.writeLong(this.mDuration);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.AudioPttInfo
 * JD-Core Version:    0.6.2
 */