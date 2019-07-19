package com.viber.voip.phone.conf;

import java.util.Collection;
import java.util.Map;

public abstract interface IConferenceCall
{
  public static abstract interface CreateConferenceCallback
  {
    public abstract void onConferenceCreated(IConferenceCall.UiDelegate.CreationStatus paramCreationStatus, long paramLong, String paramString);
  }

  public static abstract interface JoinConferenceCallback
  {
    public abstract void onJoinConference(boolean paramBoolean);
  }

  public static abstract interface SnConferenceDelegate
  {
    public abstract void handleCreateConferenceCall(String[] paramArrayOfString, String paramString, int paramInt);

    public abstract void handleInviteToConference(long paramLong, String[] paramArrayOfString, String paramString);

    public abstract void handleJoinConferenceCall(long paramLong, String paramString1, String paramString2);

    public abstract void setObserver(IConferenceCall.SnConferenceObserver paramSnConferenceObserver);
  }

  public static abstract interface SnConferenceObserver
  {
    public abstract void onCreateConference(int paramInt, String paramString, long paramLong, Map<String, Integer> paramMap);

    public abstract void onInviteToConverenceReply(int paramInt, Map<String, Integer> paramMap, String paramString);

    public abstract void onJoinConference(int paramInt, String paramString1, long paramLong, String paramString2, String paramString3);

    public static enum UpdateType
    {
      static
      {
        SOMETHING_HAPPEND = new UpdateType("SOMETHING_HAPPEND", 2);
        UpdateType[] arrayOfUpdateType = new UpdateType[3];
        arrayOfUpdateType[0] = USER_JOINED;
        arrayOfUpdateType[1] = USER_LEFT;
        arrayOfUpdateType[2] = SOMETHING_HAPPEND;
      }
    }
  }

  public static abstract interface Ui
  {
    public abstract void addUiDelegate(IConferenceCall.UiDelegate paramUiDelegate);

    public abstract void createConference(String[] paramArrayOfString, int paramInt, IConferenceCall.CreateConferenceCallback paramCreateConferenceCallback);

    public abstract void invitePeers(String[] paramArrayOfString);

    public abstract void joinConference(long paramLong, IConferenceCall.JoinConferenceCallback paramJoinConferenceCallback);

    public abstract void leaveConference();

    public abstract void removeUiDelegate(IConferenceCall.UiDelegate paramUiDelegate);
  }

  public static abstract interface UiDelegate
  {
    public abstract void onConferenceCreated(int paramInt, long paramLong, Map<String, Integer> paramMap);

    public abstract void onDisconnected();

    public abstract void onFirstPeerJoined(ConferenceCall paramConferenceCall, String paramString);

    public abstract void onLastPeerLeft(ConferenceCall paramConferenceCall);

    public abstract void onNewPeerConnectionNeeded();

    public abstract void onPeersChanged(Collection<PeerInfo> paramCollection);

    public abstract void onPeersInvited(int paramInt, Map<String, Integer> paramMap);

    public abstract void onVolumeLevelChanged(Map<String, Float> paramMap, String paramString);

    public static enum CreationStatus
    {
      static
      {
        FAILED_TO_CREATE = new CreationStatus("FAILED_TO_CREATE", 1);
        FAILED_TO_JOIN = new CreationStatus("FAILED_TO_JOIN", 2);
        FAILED_TO_START_PEERCONNECTION = new CreationStatus("FAILED_TO_START_PEERCONNECTION", 3);
        CreationStatus[] arrayOfCreationStatus = new CreationStatus[4];
        arrayOfCreationStatus[0] = SUCCESS;
        arrayOfCreationStatus[1] = FAILED_TO_CREATE;
        arrayOfCreationStatus[2] = FAILED_TO_JOIN;
        arrayOfCreationStatus[3] = FAILED_TO_START_PEERCONNECTION;
      }
    }

    public static enum PeerDetailedState
    {
      static
      {
        INVITED = new PeerDetailedState("INVITED", 5);
        BUSY = new PeerDetailedState("BUSY", 6);
        DECLINED = new PeerDetailedState("DECLINED", 7);
        UNAVAILABLE = new PeerDetailedState("UNAVAILABLE", 8);
        HANG_UP = new PeerDetailedState("HANG_UP", 9);
        CONNECTION_LOST = new PeerDetailedState("CONNECTION_LOST", 10);
        PeerDetailedState[] arrayOfPeerDetailedState = new PeerDetailedState[11];
        arrayOfPeerDetailedState[0] = CONNECTING;
        arrayOfPeerDetailedState[1] = ON_AIR;
        arrayOfPeerDetailedState[2] = ON_HOLD;
        arrayOfPeerDetailedState[3] = RECONNECTING;
        arrayOfPeerDetailedState[4] = UNKNOWN;
        arrayOfPeerDetailedState[5] = INVITED;
        arrayOfPeerDetailedState[6] = BUSY;
        arrayOfPeerDetailedState[7] = DECLINED;
        arrayOfPeerDetailedState[8] = UNAVAILABLE;
        arrayOfPeerDetailedState[9] = HANG_UP;
        arrayOfPeerDetailedState[10] = CONNECTION_LOST;
      }
    }

    public static class PeerInfo
    {
      public IConferenceCall.UiDelegate.PeerDetailedState detailedState;
      public final String memberId;
      public IConferenceCall.UiDelegate.PeerState state;

      public PeerInfo(String paramString, IConferenceCall.UiDelegate.PeerState paramPeerState, IConferenceCall.UiDelegate.PeerDetailedState paramPeerDetailedState)
      {
        this.memberId = paramString;
        this.state = paramPeerState;
        this.detailedState = paramPeerDetailedState;
      }

      public String toString()
      {
        return "PeerInfo{memberId='" + this.memberId + '\'' + ", state=" + this.state + ", detailedState=" + this.detailedState + '}';
      }
    }

    public static enum PeerState
    {
      static
      {
        CONNECTED = new PeerState("CONNECTED", 1);
        DISCONNECTED = new PeerState("DISCONNECTED", 2);
        PeerState[] arrayOfPeerState = new PeerState[3];
        arrayOfPeerState[0] = UNKNOWN;
        arrayOfPeerState[1] = CONNECTED;
        arrayOfPeerState[2] = DISCONNECTED;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.IConferenceCall
 * JD-Core Version:    0.6.2
 */