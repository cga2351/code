package com.viber.voip.messages.conversation.ui.presenter.banners.top;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

public class TopBannerState extends State
{
  public static final Parcelable.Creator<TopBannerState> CREATOR = new Parcelable.Creator()
  {
    public TopBannerState a(Parcel paramAnonymousParcel)
    {
      return new TopBannerState(paramAnonymousParcel);
    }

    public TopBannerState[] a(int paramAnonymousInt)
    {
      return new TopBannerState[paramAnonymousInt];
    }
  };
  private final long mConversationId;

  public TopBannerState(long paramLong)
  {
    this.mConversationId = paramLong;
  }

  TopBannerState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mConversationId = paramParcel.readLong();
  }

  public long getConversationId()
  {
    return this.mConversationId;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mConversationId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.top.TopBannerState
 * JD-Core Version:    0.6.2
 */