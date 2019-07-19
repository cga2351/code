package com.viber.voip.phone.viber.conference.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerDetailedState;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerInfo;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerState;

public class ConferenceCallStatus
  implements Parcelable
{
  public static final Parcelable.Creator<ConferenceCallStatus> CREATOR = new Parcelable.Creator()
  {
    public ConferenceCallStatus createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ConferenceCallStatus(paramAnonymousParcel);
    }

    public ConferenceCallStatus[] newArray(int paramAnonymousInt)
    {
      return new ConferenceCallStatus[paramAnonymousInt];
    }
  };
  public static final ConferenceCallStatus UNKNOWN = new ConferenceCallStatus(IConferenceCall.UiDelegate.PeerState.DISCONNECTED, IConferenceCall.UiDelegate.PeerDetailedState.UNKNOWN);
  public final IConferenceCall.UiDelegate.PeerDetailedState detailedState;
  public final IConferenceCall.UiDelegate.PeerState state;

  protected ConferenceCallStatus(Parcel paramParcel)
  {
    this.state = IConferenceCall.UiDelegate.PeerState.values()[paramParcel.readInt()];
    this.detailedState = IConferenceCall.UiDelegate.PeerDetailedState.values()[paramParcel.readInt()];
  }

  public ConferenceCallStatus(IConferenceCall.UiDelegate.PeerState paramPeerState, IConferenceCall.UiDelegate.PeerDetailedState paramPeerDetailedState)
  {
    this.state = paramPeerState;
    this.detailedState = paramPeerDetailedState;
  }

  public static ConferenceCallStatus from(IConferenceCall.UiDelegate.PeerInfo paramPeerInfo)
  {
    if (paramPeerInfo != null)
      return new ConferenceCallStatus(paramPeerInfo.state, paramPeerInfo.detailedState);
    return UNKNOWN;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean isSame(IConferenceCall.UiDelegate.PeerInfo paramPeerInfo)
  {
    if (paramPeerInfo == null)
      if ((UNKNOWN.state != this.state) || (UNKNOWN.detailedState != this.detailedState));
    while ((this.state == paramPeerInfo.state) && (this.detailedState == paramPeerInfo.detailedState))
    {
      return true;
      return false;
    }
    return false;
  }

  public String toString()
  {
    return "ConferenceCallStatus{state=" + this.state + ", detailedState=" + this.detailedState + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.state.ordinal());
    paramParcel.writeInt(this.detailedState.ordinal());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.model.ConferenceCallStatus
 * JD-Core Version:    0.6.2
 */