package com.viber.voip.phone.conf.protocol;

import com.google.d.a.c;
import java.util.List;

public final class PeerInfo
{

  @c(a="audioTracks")
  public final List<String> audioTracks;

  @c(a="connectionStatus")
  public final PeerInfo.PeerState.ConnectionStatus connectionStatus;

  @c(a="disconnectionReason")
  public final PeerInfo.PeerState.DisconnectionReason disconnectionReason;

  @c(a="dominant")
  public final Boolean isDominant;

  @c(a="muted")
  public final Boolean isMuted;

  @c(a="peerId")
  public final PeerID peerID;

  @c(a="peerState")
  public final PeerState peerState;

  @c(a="videoTracks")
  public final List<String> videoTracks;

  public PeerInfo(PeerID paramPeerID, PeerInfo.PeerState.DisconnectionReason paramDisconnectionReason)
  {
    this.peerID = paramPeerID;
    this.isDominant = null;
    this.isMuted = null;
    this.audioTracks = null;
    this.videoTracks = null;
    this.peerState = PeerState.DISCONNECTED;
    this.connectionStatus = null;
    this.disconnectionReason = paramDisconnectionReason;
  }

  public PeerInfo(PeerID paramPeerID, List<String> paramList1, List<String> paramList2, Boolean paramBoolean1, Boolean paramBoolean2, PeerInfo.PeerState.ConnectionStatus paramConnectionStatus)
  {
    this.peerID = paramPeerID;
    this.audioTracks = paramList1;
    this.videoTracks = paramList2;
    this.isMuted = paramBoolean1;
    this.isDominant = paramBoolean2;
    this.peerState = PeerState.CONNECTED;
    this.connectionStatus = paramConnectionStatus;
    this.disconnectionReason = null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PeerInfo{");
    localStringBuilder.append("peerID=").append(this.peerID);
    localStringBuilder.append(", audioTracks=").append(this.audioTracks);
    localStringBuilder.append(", videoTracks=").append(this.videoTracks);
    localStringBuilder.append(", peerState=").append(this.peerState);
    localStringBuilder.append(", connectionStatus=").append(this.connectionStatus);
    localStringBuilder.append(", disconnectionReason=").append(this.disconnectionReason);
    localStringBuilder.append(", isMuted=").append(this.isMuted);
    localStringBuilder.append(", isDominant=").append(this.isDominant);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  public static enum PeerState
  {
    static
    {
      PeerState[] arrayOfPeerState = new PeerState[2];
      arrayOfPeerState[0] = CONNECTED;
      arrayOfPeerState[1] = DISCONNECTED;
    }

    public static enum ConnectionStatus
    {
      static
      {
        ConnectionStatus[] arrayOfConnectionStatus = new ConnectionStatus[4];
        arrayOfConnectionStatus[0] = CONNECTING;
        arrayOfConnectionStatus[1] = ON_AIR;
        arrayOfConnectionStatus[2] = ON_HOLD;
        arrayOfConnectionStatus[3] = RECONNECTING;
      }
    }

    public static enum DisconnectionReason
    {
      static
      {
        INVITED = new DisconnectionReason("INVITED", 1);
        BUSY = new DisconnectionReason("BUSY", 2);
        DECLINED = new DisconnectionReason("DECLINED", 3);
        UNAVAILABLE = new DisconnectionReason("UNAVAILABLE", 4);
        HUNG_UP = new DisconnectionReason("HUNG_UP", 5);
        CONNECTION_LOST = new DisconnectionReason("CONNECTION_LOST", 6);
        DisconnectionReason[] arrayOfDisconnectionReason = new DisconnectionReason[7];
        arrayOfDisconnectionReason[0] = UNKNOWN;
        arrayOfDisconnectionReason[1] = INVITED;
        arrayOfDisconnectionReason[2] = BUSY;
        arrayOfDisconnectionReason[3] = DECLINED;
        arrayOfDisconnectionReason[4] = UNAVAILABLE;
        arrayOfDisconnectionReason[5] = HUNG_UP;
        arrayOfDisconnectionReason[6] = CONNECTION_LOST;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.protocol.PeerInfo
 * JD-Core Version:    0.6.2
 */