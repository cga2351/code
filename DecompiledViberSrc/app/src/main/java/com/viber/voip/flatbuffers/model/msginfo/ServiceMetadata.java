package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class ServiceMetadata
  implements Parcelable
{
  public static final Parcelable.Creator<ServiceMetadata> CREATOR = new Parcelable.Creator()
  {
    public ServiceMetadata a(Parcel paramAnonymousParcel)
    {
      return new ServiceMetadata(paramAnonymousParcel);
    }

    public ServiceMetadata[] a(int paramAnonymousInt)
    {
      return new ServiceMetadata[paramAnonymousInt];
    }
  };

  @c(a="Silent")
  private boolean mSilent;

  @c(a="TrackingData")
  private String mTrackingData;

  public ServiceMetadata()
  {
  }

  ServiceMetadata(Parcel paramParcel)
  {
    this.mTrackingData = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getTrackingData()
  {
    return this.mTrackingData;
  }

  public boolean isSilent()
  {
    return this.mSilent;
  }

  public void setSilent(boolean paramBoolean)
  {
    this.mSilent = paramBoolean;
  }

  public void setTrackingData(String paramString)
  {
    this.mTrackingData = paramString;
  }

  public String toString()
  {
    return "ServiceMetadata{mTrackingData='" + this.mTrackingData + '\'' + "mSilent=" + this.mSilent + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTrackingData);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.ServiceMetadata
 * JD-Core Version:    0.6.2
 */