package com.viber.voip.news;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

class NewsBrowserState extends State
{
  public static final Parcelable.Creator<NewsBrowserState> CREATOR = new Parcelable.Creator()
  {
    public NewsBrowserState a(Parcel paramAnonymousParcel)
    {
      return new NewsBrowserState(paramAnonymousParcel);
    }

    public NewsBrowserState[] a(int paramAnonymousInt)
    {
      return new NewsBrowserState[paramAnonymousInt];
    }
  };
  private final boolean mIsArticlePage;
  private final String mLoadedUrl;
  private final boolean mSessionWillBeContinuedOnAnotherScreen;
  private final String mUrlToShare;

  NewsBrowserState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mLoadedUrl = paramParcel.readString();
    this.mUrlToShare = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mIsArticlePage = bool2;
      if (paramParcel.readByte() == 0)
        break label55;
    }
    while (true)
    {
      this.mSessionWillBeContinuedOnAnotherScreen = bool1;
      return;
      bool2 = false;
      break;
      label55: bool1 = false;
    }
  }

  NewsBrowserState(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mLoadedUrl = paramString1;
    this.mUrlToShare = paramString2;
    this.mIsArticlePage = paramBoolean1;
    this.mSessionWillBeContinuedOnAnotherScreen = paramBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getLoadedUrl()
  {
    return this.mLoadedUrl;
  }

  public String getUrlToShare()
  {
    return this.mUrlToShare;
  }

  public boolean isArticlePage()
  {
    return this.mIsArticlePage;
  }

  public boolean isSessionWillBeContinuedOnAnotherScreen()
  {
    return this.mSessionWillBeContinuedOnAnotherScreen;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mLoadedUrl);
    paramParcel.writeString(this.mUrlToShare);
    byte b2;
    if (this.mIsArticlePage)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.mSessionWillBeContinuedOnAnotherScreen)
        break label59;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label59: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.NewsBrowserState
 * JD-Core Version:    0.6.2
 */