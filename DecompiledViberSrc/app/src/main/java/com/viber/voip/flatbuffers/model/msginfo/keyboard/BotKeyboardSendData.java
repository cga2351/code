package com.viber.voip.flatbuffers.model.msginfo.keyboard;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class BotKeyboardSendData
  implements Parcelable
{
  public static final Parcelable.Creator<BotKeyboardSendData> CREATOR = new Parcelable.Creator()
  {
    public BotKeyboardSendData a(Parcel paramAnonymousParcel)
    {
      return new BotKeyboardSendData(paramAnonymousParcel);
    }

    public BotKeyboardSendData[] a(int paramAnonymousInt)
    {
      return new BotKeyboardSendData[paramAnonymousInt];
    }
  };

  @c(a="internal_browser")
  private BrowserData mBrowserData;

  @c(a="location")
  private PickerLocation mLocation;

  @c(a="phone")
  private String mPhone;

  public BotKeyboardSendData()
  {
  }

  protected BotKeyboardSendData(Parcel paramParcel)
  {
    this.mLocation = ((PickerLocation)paramParcel.readParcelable(PickerLocation.class.getClassLoader()));
    this.mPhone = paramParcel.readString();
    this.mBrowserData = ((BrowserData)paramParcel.readParcelable(BrowserData.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject)
      bool3 = bool1;
    BotKeyboardSendData localBotKeyboardSendData;
    boolean bool4;
    do
    {
      boolean bool5;
      do
      {
        boolean bool2;
        do
        {
          return bool3;
          bool2 = paramObject instanceof BotKeyboardSendData;
          bool3 = false;
        }
        while (!bool2);
        localBotKeyboardSendData = (BotKeyboardSendData)paramObject;
        if (getLocation() == null)
          break;
        bool5 = getLocation().equals(localBotKeyboardSendData.getLocation());
        bool3 = false;
      }
      while (!bool5);
      if (getPhone() == null)
        break label121;
      bool4 = getPhone().equals(localBotKeyboardSendData.getPhone());
      bool3 = false;
    }
    while (bool4);
    label89: if (getBrowserData() != null)
      bool1 = getBrowserData().equals(localBotKeyboardSendData.getBrowserData());
    while (true)
    {
      return bool1;
      if (localBotKeyboardSendData.getLocation() == null)
        break;
      return false;
      label121: if (localBotKeyboardSendData.getPhone() != null)
        break label89;
      return false;
      if (localBotKeyboardSendData.getBrowserData() != null)
        bool1 = false;
    }
  }

  public BrowserData getBrowserData()
  {
    return this.mBrowserData;
  }

  public PickerLocation getLocation()
  {
    return this.mLocation;
  }

  public String getPhone()
  {
    return this.mPhone;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (getLocation() != null)
    {
      i = getLocation().hashCode();
      j = i * 31;
      if (getPhone() == null)
        break label77;
    }
    label77: for (int k = getPhone().hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      BrowserData localBrowserData = getBrowserData();
      int n = 0;
      if (localBrowserData != null)
        n = getBrowserData().hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public void setBrowserData(BrowserData paramBrowserData)
  {
    this.mBrowserData = paramBrowserData;
  }

  public void setLocation(PickerLocation paramPickerLocation)
  {
    this.mLocation = paramPickerLocation;
  }

  public void setPhone(String paramString)
  {
    this.mPhone = paramString;
  }

  public String toString()
  {
    return "BotKeyboardSendData{mLocation=" + this.mLocation + ", mPhone='" + this.mPhone + '\'' + ", mBrowserData='" + this.mBrowserData + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mLocation, paramInt);
    paramParcel.writeString(this.mPhone);
    paramParcel.writeParcelable(this.mBrowserData, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.keyboard.BotKeyboardSendData
 * JD-Core Version:    0.6.2
 */