package com.viber.voip.messages.conversation.ui.presenter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

public class BottomPanelPresenterState extends State
{
  public static final Parcelable.Creator<BottomPanelPresenterState> CREATOR = new Parcelable.Creator()
  {
    public BottomPanelPresenterState a(Parcel paramAnonymousParcel)
    {
      return new BottomPanelPresenterState(paramAnonymousParcel);
    }

    public BottomPanelPresenterState[] a(int paramAnonymousInt)
    {
      return new BottomPanelPresenterState[paramAnonymousInt];
    }
  };
  private long mConversationId;
  private long mDate;
  private int mExpanderState;

  public BottomPanelPresenterState(int paramInt, long paramLong1, long paramLong2)
  {
    this.mConversationId = paramLong1;
    this.mExpanderState = paramInt;
    this.mDate = paramLong2;
  }

  protected BottomPanelPresenterState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mExpanderState = paramParcel.readInt();
    this.mConversationId = paramParcel.readLong();
    this.mDate = paramParcel.readLong();
  }

  public long getConversationId()
  {
    return this.mConversationId;
  }

  public long getDate()
  {
    return this.mDate;
  }

  public int getExpanderState()
  {
    return this.mExpanderState;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mExpanderState);
    paramParcel.writeLong(this.mConversationId);
    paramParcel.writeLong(this.mDate);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.BottomPanelPresenterState
 * JD-Core Version:    0.6.2
 */