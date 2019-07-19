package com.viber.voip.flatbuffers.model.msginfo.keyboard;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class BrowserData
  implements Parcelable
{
  public static final Parcelable.Creator<BrowserData> CREATOR = new Parcelable.Creator()
  {
    public BrowserData a(Parcel paramAnonymousParcel)
    {
      return new BrowserData(paramAnonymousParcel);
    }

    public BrowserData[] a(int paramAnonymousInt)
    {
      return new BrowserData[paramAnonymousInt];
    }
  };

  @c(a="action_reply_data")
  private String mActionReplyData;

  @c(a="is_original_url")
  private boolean mIsOriginalUrl;

  @c(a="title")
  private String mTitle;

  @c(a="url")
  private String mUrl;

  public BrowserData()
  {
  }

  protected BrowserData(Parcel paramParcel)
  {
    this.mUrl = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mActionReplyData = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsOriginalUrl = bool;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    BrowserData localBrowserData;
    boolean bool5;
    do
    {
      boolean bool6;
      do
      {
        boolean bool3;
        boolean bool4;
        do
        {
          Class localClass1;
          Class localClass2;
          do
          {
            do
            {
              return bool2;
              bool2 = false;
            }
            while (paramObject == null);
            localClass1 = getClass();
            localClass2 = paramObject.getClass();
            bool2 = false;
          }
          while (localClass1 != localClass2);
          localBrowserData = (BrowserData)paramObject;
          bool3 = isOriginalUrl();
          bool4 = localBrowserData.isOriginalUrl();
          bool2 = false;
        }
        while (bool3 != bool4);
        if (getUrl() == null)
          break;
        bool6 = getUrl().equals(localBrowserData.getUrl());
        bool2 = false;
      }
      while (!bool6);
      if (getTitle() == null)
        break label154;
      bool5 = getTitle().equals(localBrowserData.getTitle());
      bool2 = false;
    }
    while (!bool5);
    label122: if (getActionReplyData() != null)
      bool1 = getActionReplyData().equals(localBrowserData.getActionReplyData());
    while (true)
    {
      return bool1;
      if (localBrowserData.getUrl() == null)
        break;
      return false;
      label154: if (localBrowserData.getTitle() == null)
        break label122;
      return false;
      if (localBrowserData.getActionReplyData() != null)
        bool1 = false;
    }
  }

  public String getActionReplyData()
  {
    return this.mActionReplyData;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public String getUrl()
  {
    return this.mUrl;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (getUrl() != null)
    {
      i = getUrl().hashCode();
      int j = i * 31;
      if (getTitle() == null)
        break label97;
      k = getTitle().hashCode();
      m = 31 * (k + j);
      if (getActionReplyData() == null)
        break label102;
    }
    label97: label102: for (int n = getActionReplyData().hashCode(); ; n = 0)
    {
      int i1 = 31 * (n + m);
      boolean bool = isOriginalUrl();
      int i2 = 0;
      if (bool)
        i2 = 1;
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  public boolean isOriginalUrl()
  {
    return this.mIsOriginalUrl;
  }

  public void setActionReplyData(String paramString)
  {
    this.mActionReplyData = paramString;
  }

  public void setOriginalUrl(boolean paramBoolean)
  {
    this.mIsOriginalUrl = paramBoolean;
  }

  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }

  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }

  public String toString()
  {
    return "BrowserData{mUrl='" + this.mUrl + '\'' + ", mTitle='" + this.mTitle + '\'' + ", mActionReplyData='" + this.mActionReplyData + '\'' + ", mIsOriginalUrl=" + this.mIsOriginalUrl + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mActionReplyData);
    if (this.mIsOriginalUrl);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.keyboard.BrowserData
 * JD-Core Version:    0.6.2
 */