package com.viber.voip.phone.conf.protocol;

import com.google.d.a.c;

public final class PeerInfoNotification
{

  @c(a="selfId")
  public final PeerID id;

  @c(a="muted")
  public final Boolean isMuted;

  @c(a="protocolVersion")
  public final String protocolVersion;

  @c(a="selfState")
  public final PeerState state;

  public PeerInfoNotification(String paramString, PeerID paramPeerID, PeerState paramPeerState, Boolean paramBoolean)
  {
    this.protocolVersion = paramString;
    this.id = paramPeerID;
    this.state = paramPeerState;
    this.isMuted = paramBoolean;
  }

  public String toString()
  {
    return "PeerInfoNotification(v ='" + this.protocolVersion + '\'' + ", id=" + this.id + ", state=" + this.state + ", muted=" + this.isMuted + ", ...)";
  }

  public static enum PeerState
  {
    static
    {
      CONNECTED = new PeerState("CONNECTED", 1);
      ON_HOLD = new PeerState("ON_HOLD", 2);
      PeerState[] arrayOfPeerState = new PeerState[3];
      arrayOfPeerState[0] = DISCONNECTED;
      arrayOfPeerState[1] = CONNECTED;
      arrayOfPeerState[2] = ON_HOLD;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.protocol.PeerInfoNotification
 * JD-Core Version:    0.6.2
 */