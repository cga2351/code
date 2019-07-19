package com.viber.voip.flatbuffers.model.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class CommunityScreenshot
  implements Parcelable
{
  public static final Parcelable.Creator<CommunityScreenshot> CREATOR = new Parcelable.Creator()
  {
    public CommunityScreenshot a(Parcel paramAnonymousParcel)
    {
      return new CommunityScreenshot(paramAnonymousParcel);
    }

    public CommunityScreenshot[] a(int paramAnonymousInt)
    {
      return new CommunityScreenshot[paramAnonymousInt];
    }
  };

  @c(a="Name")
  private String mCommunityName;

  @c(a="Link")
  private String mCommunityShareLink;

  public CommunityScreenshot()
  {
  }

  CommunityScreenshot(Parcel paramParcel)
  {
    this.mCommunityName = paramParcel.readString();
    this.mCommunityShareLink = paramParcel.readString();
  }

  public CommunityScreenshot(String paramString1, String paramString2)
  {
    this.mCommunityName = paramString1;
    this.mCommunityShareLink = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getCommunityShareLink()
  {
    return this.mCommunityShareLink;
  }

  public String getCommunnityName()
  {
    return this.mCommunityName;
  }

  public void setCommunityShareLink(String paramString)
  {
    this.mCommunityShareLink = paramString;
  }

  public void setCommunnityName(String paramString)
  {
    this.mCommunityName = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mCommunityName);
    paramParcel.writeString(this.mCommunityShareLink);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.CommunityScreenshot
 * JD-Core Version:    0.6.2
 */