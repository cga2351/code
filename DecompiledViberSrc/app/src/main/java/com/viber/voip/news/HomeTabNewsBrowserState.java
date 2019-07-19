package com.viber.voip.news;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class HomeTabNewsBrowserState extends NewsBrowserState
{
  public static final Parcelable.Creator<HomeTabNewsBrowserState> CREATOR = new Parcelable.Creator()
  {
    public HomeTabNewsBrowserState a(Parcel paramAnonymousParcel)
    {
      return new HomeTabNewsBrowserState(paramAnonymousParcel);
    }

    public HomeTabNewsBrowserState[] a(int paramAnonymousInt)
    {
      return new HomeTabNewsBrowserState[paramAnonymousInt];
    }
  };
  private final boolean mIsVisible;

  HomeTabNewsBrowserState(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsVisible = bool;
      return;
    }
  }

  HomeTabNewsBrowserState(boolean paramBoolean, NewsBrowserState paramNewsBrowserState)
  {
    super(paramNewsBrowserState.getLoadedUrl(), paramNewsBrowserState.getUrlToShare(), paramNewsBrowserState.isArticlePage(), paramNewsBrowserState.isSessionWillBeContinuedOnAnotherScreen());
    this.mIsVisible = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean isVisible()
  {
    return this.mIsVisible;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.mIsVisible);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.HomeTabNewsBrowserState
 * JD-Core Version:    0.6.2
 */