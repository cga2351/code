package com.viber.jni.im2;

public class CMessageReceivedMsg
{
  public final String bucketName;
  public final Integer chatType;
  public final String clientName;
  public final String downloadID;
  public final Integer duration;
  public final int flags;
  public final Location location;
  public final Integer mediaType;
  public final Integer messageSeq;
  public final long messageToken;
  public final String msgInfo;
  public final String originPhoneNumber;
  public final String peerEMID;
  public final Long serverTime;
  public final String text;
  public final byte[] thumbnail;
  public final long timeSent;
  public final Integer timebombInSec;
  public final String toVLN;
  public final Integer uploadDuration;

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt;
    this.messageSeq = null;
    this.location = null;
    this.mediaType = null;
    this.bucketName = null;
    this.downloadID = null;
    this.thumbnail = null;
    this.clientName = null;
    this.serverTime = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = null;
    this.mediaType = null;
    this.bucketName = null;
    this.downloadID = null;
    this.thumbnail = null;
    this.clientName = null;
    this.serverTime = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = null;
    this.bucketName = null;
    this.downloadID = null;
    this.thumbnail = null;
    this.clientName = null;
    this.serverTime = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = null;
    this.downloadID = null;
    this.thumbnail = null;
    this.clientName = null;
    this.serverTime = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = null;
    this.thumbnail = null;
    this.clientName = null;
    this.serverTime = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = null;
    this.clientName = null;
    this.serverTime = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = null;
    this.serverTime = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, long paramLong3)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = Long.valueOf(paramLong3);
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, long paramLong3, int paramInt4)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = Long.valueOf(paramLong3);
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = null;
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, long paramLong3, int paramInt4, int paramInt5)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = Long.valueOf(paramLong3);
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, long paramLong3, int paramInt4, int paramInt5, String paramString6)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = Long.valueOf(paramLong3);
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString6);
    this.chatType = null;
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, long paramLong3, int paramInt4, int paramInt5, String paramString6, int paramInt6)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = Long.valueOf(paramLong3);
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString6);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = null;
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, long paramLong3, int paramInt4, int paramInt5, String paramString6, int paramInt6, int paramInt7)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = Long.valueOf(paramLong3);
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString6);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = Integer.valueOf(paramInt7);
    this.toVLN = null;
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, long paramLong3, int paramInt4, int paramInt5, String paramString6, int paramInt6, int paramInt7, String paramString7)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = Long.valueOf(paramLong3);
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString6);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = Integer.valueOf(paramInt7);
    this.toVLN = Im2Utils.checkStringValue(paramString7);
    this.peerEMID = null;
    init();
  }

  public CMessageReceivedMsg(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, Location paramLocation, int paramInt3, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, long paramLong3, int paramInt4, int paramInt5, String paramString6, int paramInt6, int paramInt7, String paramString7, String paramString8)
  {
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong1;
    this.text = Im2Utils.checkStringValue(paramString2);
    this.timeSent = paramLong2;
    this.flags = paramInt1;
    this.messageSeq = Integer.valueOf(paramInt2);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.clientName = Im2Utils.checkStringValue(paramString5);
    this.serverTime = Long.valueOf(paramLong3);
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString6);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = Integer.valueOf(paramInt7);
    this.toVLN = Im2Utils.checkStringValue(paramString7);
    this.peerEMID = Im2Utils.checkStringValue(paramString8);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCMessageReceivedMsg(CMessageReceivedMsg paramCMessageReceivedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMessageReceivedMsg
 * JD-Core Version:    0.6.2
 */