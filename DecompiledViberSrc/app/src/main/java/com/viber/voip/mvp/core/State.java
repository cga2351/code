package com.viber.voip.mvp.core;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class State
  implements Parcelable
{
  public State()
  {
  }

  protected State(Parcel paramParcel)
  {
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.State
 * JD-Core Version:    0.6.2
 */