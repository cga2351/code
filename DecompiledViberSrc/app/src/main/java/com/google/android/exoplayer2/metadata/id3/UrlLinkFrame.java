package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;

public final class UrlLinkFrame extends Id3Frame
{
  public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator()
  {
    public UrlLinkFrame a(Parcel paramAnonymousParcel)
    {
      return new UrlLinkFrame(paramAnonymousParcel);
    }

    public UrlLinkFrame[] a(int paramAnonymousInt)
    {
      return new UrlLinkFrame[paramAnonymousInt];
    }
  };
  public final String description;
  public final String url;

  UrlLinkFrame(Parcel paramParcel)
  {
    super((String)ag.a(paramParcel.readString()));
    this.description = paramParcel.readString();
    this.url = ((String)ag.a(paramParcel.readString()));
  }

  public UrlLinkFrame(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.description = paramString2;
    this.url = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    UrlLinkFrame localUrlLinkFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localUrlLinkFrame = (UrlLinkFrame)paramObject;
    }
    while ((this.id.equals(localUrlLinkFrame.id)) && (ag.a(this.description, localUrlLinkFrame.description)) && (ag.a(this.url, localUrlLinkFrame.url)));
    return false;
  }

  public int hashCode()
  {
    int i = 31 * (527 + this.id.hashCode());
    if (this.description != null);
    for (int j = this.description.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      String str = this.url;
      int m = 0;
      if (str != null)
        m = this.url.hashCode();
      return k + m;
    }
  }

  public String toString()
  {
    return this.id + ": url=" + this.url;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.url);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.UrlLinkFrame
 * JD-Core Version:    0.6.2
 */