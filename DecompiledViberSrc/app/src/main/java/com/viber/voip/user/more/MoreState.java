package com.viber.voip.user.more;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

public class MoreState extends State
{
  public static final Parcelable.Creator<MoreState> CREATOR = new Parcelable.Creator()
  {
    public MoreState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MoreState(paramAnonymousParcel);
    }

    public MoreState[] newArray(int paramAnonymousInt)
    {
      return new MoreState[paramAnonymousInt];
    }
  };

  public MoreState()
  {
  }

  protected MoreState(Parcel paramParcel)
  {
    super(paramParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreState
 * JD-Core Version:    0.6.2
 */