package com.viber.voip.phone.conf;

import com.google.d.f;
import com.google.d.l;
import com.google.d.o;
import com.google.d.q;
import com.google.d.u;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.conf.messages.EndpointMessage;
import com.viber.voip.phone.conf.messages.MessagePayload;
import com.viber.voip.phone.conf.messages.MessagePayloadType;
import com.viber.voip.phone.conf.protocol.ConfInfoNotification;
import com.viber.voip.phone.conf.protocol.PeerID;
import com.viber.voip.phone.conf.protocol.PeerInfo;
import com.viber.voip.phone.conf.protocol.PeerInfo.PeerState;
import com.viber.voip.phone.conf.protocol.PeerInfoNotification;
import com.viber.voip.phone.conf.protocol.PeerInfoNotification.PeerState;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.webrtc.DataChannel;
import org.webrtc.DataChannel.Buffer;
import org.webrtc.DataChannel.Observer;

class DataChannelCoordinator
{
  public static final String JITSI_MESSAGE_COLIBRI_CLASS = "colibriClass";
  public static final String JITSI_MESSAGE_PARAM_MSG_PAYLOAD = "msgPayload";
  private static final Logger L = ViberEnv.getLogger();
  private static final String PROTOCOL_VERSION = "1.0";
  private static final String SUPERVISOR_PREFIX = "Supervisor-";
  private boolean mAlreadyStartedCall = false;
  private String mConferenceId;
  private final DataChannel mDataChannel;
  private f mGson = new f();
  private boolean mHelloWasNotSent = true;
  private boolean mIsMuted = false;
  private boolean mIsOnHold = false;
  private ArrayList<String> mLocalAudioTracks = new ArrayList();
  private String mLocalOfferSdpProto = "";
  private final long mMyCid;
  private final String mMyMemberId;
  private final DccObserver mObserver;

  DataChannelCoordinator(DataChannel paramDataChannel, DccObserver paramDccObserver, String paramString, long paramLong)
  {
    this.mDataChannel = paramDataChannel;
    this.mObserver = paramDccObserver;
    this.mMyMemberId = paramString;
    this.mMyCid = paramLong;
    if (this.mDataChannel != null)
      this.mDataChannel.registerObserver(new DataChannel.Observer()
      {
        public void onBufferedAmountChange(long paramAnonymousLong)
        {
        }

        public void onMessage(DataChannel.Buffer paramAnonymousBuffer)
        {
          byte[] arrayOfByte = new byte[paramAnonymousBuffer.data.remaining()];
          paramAnonymousBuffer.data.get(arrayOfByte);
          String str = new String(arrayOfByte, Charset.forName("UTF-8"));
          DataChannelCoordinator.this.processMessage(str);
        }

        public void onStateChange()
        {
        }
      });
  }

  private String createPeerInfoNotification(PeerInfoNotification.PeerState paramPeerState)
  {
    PeerInfoNotification localPeerInfoNotification = new PeerInfoNotification("1.0", new PeerID(this.mMyMemberId, (int)this.mMyCid), paramPeerState, Boolean.valueOf(this.mIsMuted));
    EndpointMessage localEndpointMessage = new EndpointMessage(null, "Supervisor-" + this.mConferenceId, this.mGson.a(MessagePayload.create(localPeerInfoNotification)));
    return this.mGson.b(localEndpointMessage);
  }

  private void hello()
  {
    if (this.mIsOnHold)
    {
      packMsgToBufferAndSend(createPeerInfoNotification(PeerInfoNotification.PeerState.ON_HOLD));
      return;
    }
    packMsgToBufferAndSend(createPeerInfoNotification(PeerInfoNotification.PeerState.CONNECTED));
  }

  private void notifyAboutConferenceStarted(String paramString)
  {
    if (this.mAlreadyStartedCall)
      return;
    this.mAlreadyStartedCall = true;
    this.mObserver.onFirstPeerMessage(paramString);
  }

  private void packMsgToBufferAndSend(String paramString)
  {
    if (paramString.isEmpty())
      return;
    DataChannel.Buffer localBuffer = new DataChannel.Buffer(ByteBuffer.wrap(paramString.getBytes(Charset.forName("UTF-8"))), false);
    this.mDataChannel.send(localBuffer);
  }

  private void processConfInfoNotification(String paramString, ConfInfoNotification paramConfInfoNotification)
    throws u
  {
    if ((paramConfInfoNotification.peers.size() >= 1) && (!this.mAlreadyStartedCall))
    {
      Iterator localIterator = paramConfInfoNotification.peers.iterator();
      while (localIterator.hasNext())
      {
        PeerInfo localPeerInfo = (PeerInfo)localIterator.next();
        if ((!this.mMyMemberId.equals(localPeerInfo.peerID.memberID)) && (localPeerInfo.peerState == PeerInfo.PeerState.CONNECTED))
          notifyAboutConferenceStarted(localPeerInfo.peerID.memberID);
      }
    }
    if (paramConfInfoNotification.sdpOffer != null)
      this.mObserver.onSdpUpdateRequest(paramConfInfoNotification.sdpOffer);
    this.mObserver.onStateChanged(paramConfInfoNotification.peers);
  }

  private void processMessage(String paramString)
  {
    if (this.mLocalOfferSdpProto.isEmpty());
    while (true)
    {
      return;
      if (this.mHelloWasNotSent)
      {
        this.mHelloWasNotSent = false;
        hello();
      }
      try
      {
        o localo = new q().a(paramString).k();
        if ((localo.c("colibriClass") != null) && (localo.c("msgPayload") != null))
        {
          EndpointMessage localEndpointMessage = (EndpointMessage)this.mGson.a(localo, EndpointMessage.class);
          MessagePayload localMessagePayload = (MessagePayload)this.mGson.a(localEndpointMessage.payload, MessagePayload.class);
          if (localMessagePayload.type.equals(MessagePayloadType.CONFERENCE_INFO_NOTIFICATION))
          {
            processConfInfoNotification(localEndpointMessage.fromEndpoint, localMessagePayload.confInfo);
            return;
          }
        }
      }
      catch (u localu)
      {
      }
    }
  }

  public void bye()
  {
    packMsgToBufferAndSend(createPeerInfoNotification(PeerInfoNotification.PeerState.DISCONNECTED));
  }

  public void dispose()
  {
    this.mLocalOfferSdpProto = "";
    if (this.mDataChannel != null)
    {
      this.mDataChannel.unregisterObserver();
      this.mDataChannel.close();
    }
  }

  public void hold()
  {
    this.mIsOnHold = true;
    packMsgToBufferAndSend(createPeerInfoNotification(PeerInfoNotification.PeerState.ON_HOLD));
  }

  public boolean isOnHold()
  {
    return this.mIsOnHold;
  }

  public void mute()
  {
    this.mIsMuted = true;
    if (this.mIsOnHold);
    for (PeerInfoNotification.PeerState localPeerState = PeerInfoNotification.PeerState.ON_HOLD; ; localPeerState = PeerInfoNotification.PeerState.CONNECTED)
    {
      packMsgToBufferAndSend(createPeerInfoNotification(localPeerState));
      return;
    }
  }

  public void setConferenceId(String paramString)
  {
    this.mConferenceId = paramString;
  }

  public void setLocalOfferSdp(String paramString, List<String> paramList)
  {
    this.mLocalOfferSdpProto = paramString;
    this.mLocalAudioTracks.clear();
    this.mLocalAudioTracks.addAll(paramList);
  }

  public void unhold()
  {
    this.mIsOnHold = false;
    packMsgToBufferAndSend(createPeerInfoNotification(PeerInfoNotification.PeerState.CONNECTED));
  }

  public void unmute()
  {
    this.mIsMuted = false;
    if (this.mIsOnHold);
    for (PeerInfoNotification.PeerState localPeerState = PeerInfoNotification.PeerState.ON_HOLD; ; localPeerState = PeerInfoNotification.PeerState.CONNECTED)
    {
      packMsgToBufferAndSend(createPeerInfoNotification(localPeerState));
      return;
    }
  }

  static abstract interface DccObserver
  {
    public abstract void onFirstPeerMessage(String paramString);

    public abstract void onSdpUpdateRequest(String paramString);

    public abstract void onStateChanged(Collection<PeerInfo> paramCollection);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.DataChannelCoordinator
 * JD-Core Version:    0.6.2
 */