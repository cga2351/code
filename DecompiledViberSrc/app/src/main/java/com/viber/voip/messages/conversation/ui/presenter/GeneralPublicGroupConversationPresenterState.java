package com.viber.voip.messages.conversation.ui.presenter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.common.d.i;
import com.viber.voip.mvp.core.State;

public class GeneralPublicGroupConversationPresenterState extends State
{
  public static final Parcelable.Creator<GeneralPublicGroupConversationPresenterState> CREATOR = new Parcelable.Creator()
  {
    public GeneralPublicGroupConversationPresenterState a(Parcel paramAnonymousParcel)
    {
      return new GeneralPublicGroupConversationPresenterState(paramAnonymousParcel);
    }

    public GeneralPublicGroupConversationPresenterState[] a(int paramAnonymousInt)
    {
      return new GeneralPublicGroupConversationPresenterState[paramAnonymousInt];
    }
  };
  private i mActiveScreenTimer;
  private long mTrackedGroupId;

  protected GeneralPublicGroupConversationPresenterState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mActiveScreenTimer = ((i)paramParcel.readSerializable());
    this.mTrackedGroupId = paramParcel.readLong();
  }

  public GeneralPublicGroupConversationPresenterState(i parami, long paramLong)
  {
    this.mActiveScreenTimer = parami;
    this.mTrackedGroupId = paramLong;
  }

  public i getActiveScreenTimer()
  {
    return this.mActiveScreenTimer;
  }

  public long getTrackedGroupId()
  {
    return this.mTrackedGroupId;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeSerializable(this.mActiveScreenTimer);
    paramParcel.writeLong(this.mTrackedGroupId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.GeneralPublicGroupConversationPresenterState
 * JD-Core Version:    0.6.2
 */