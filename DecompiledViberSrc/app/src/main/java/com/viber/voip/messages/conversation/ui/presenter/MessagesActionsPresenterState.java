package com.viber.voip.messages.conversation.ui.presenter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

public class MessagesActionsPresenterState extends State
{
  public static final Parcelable.Creator<MessagesActionsPresenterState> CREATOR = new Parcelable.Creator()
  {
    public MessagesActionsPresenterState a(Parcel paramAnonymousParcel)
    {
      return new MessagesActionsPresenterState(paramAnonymousParcel);
    }

    public MessagesActionsPresenterState[] a(int paramAnonymousInt)
    {
      return new MessagesActionsPresenterState[paramAnonymousInt];
    }
  };
  private Long mCrdSessionToken;

  public MessagesActionsPresenterState(long paramLong)
  {
    this.mCrdSessionToken = Long.valueOf(paramLong);
  }

  protected MessagesActionsPresenterState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mCrdSessionToken = Long.valueOf(paramParcel.readLong());
  }

  public long getCdrSessionToken()
  {
    return this.mCrdSessionToken.longValue();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mCrdSessionToken.longValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.MessagesActionsPresenterState
 * JD-Core Version:    0.6.2
 */