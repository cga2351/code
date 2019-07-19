package com.viber.voip.phone.conf.messages;

import com.google.d.a.c;
import com.viber.voip.phone.conf.protocol.ConfInfoNotification;
import com.viber.voip.phone.conf.protocol.PeerInfoNotification;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class MessagePayload
{

  @c(a="ConfInfoNotification")
  @Nullable
  public final ConfInfoNotification confInfo;

  @c(a="PeerInfoNotification")
  @Nullable
  public final PeerInfoNotification peerInfo;

  @c(a="Type")
  @Nonnull
  public final MessagePayloadType type;

  private MessagePayload(@Nonnull MessagePayloadType paramMessagePayloadType, @Nullable ConfInfoNotification paramConfInfoNotification, @Nullable PeerInfoNotification paramPeerInfoNotification)
  {
    this.type = paramMessagePayloadType;
    this.confInfo = paramConfInfoNotification;
    this.peerInfo = paramPeerInfoNotification;
  }

  public static MessagePayload create(ConfInfoNotification paramConfInfoNotification)
  {
    return new MessagePayload(MessagePayloadType.CONFERENCE_INFO_NOTIFICATION, paramConfInfoNotification, null);
  }

  public static MessagePayload create(PeerInfoNotification paramPeerInfoNotification)
  {
    return new MessagePayload(MessagePayloadType.PEER_INFO_NOTIFICATION, null, paramPeerInfoNotification);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.messages.MessagePayload
 * JD-Core Version:    0.6.2
 */