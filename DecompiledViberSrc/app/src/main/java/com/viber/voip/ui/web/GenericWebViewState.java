package com.viber.voip.ui.web;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

public class GenericWebViewState extends State
{
  public static final Parcelable.Creator<GenericWebViewState> CREATOR = new Parcelable.Creator()
  {
    public GenericWebViewState a(Parcel paramAnonymousParcel)
    {
      return new GenericWebViewState(paramAnonymousParcel);
    }

    public GenericWebViewState[] a(int paramAnonymousInt)
    {
      return new GenericWebViewState[paramAnonymousInt];
    }
  };

  public GenericWebViewState()
  {
  }

  protected GenericWebViewState(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.web.GenericWebViewState
 * JD-Core Version:    0.6.2
 */