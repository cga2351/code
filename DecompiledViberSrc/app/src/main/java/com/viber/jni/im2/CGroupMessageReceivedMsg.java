package com.viber.jni.im2;

public class CGroupMessageReceivedMsg
{
  public final String bucketName;
  public final Integer chatType;
  public final String clientName;
  public final String downloadID;
  public final Integer duration;
  public final int flags;
  public final String group2AccessToken;
  public final long groupID;
  public final String groupName;
  public final Integer groupType;
  public final Location location;
  public final Integer mediaType;
  public final int messageSeq;
  public final long messageToken;
  public final String msgInfo;
  public final String originPhoneNumber;
  public final Integer seqInPG;
  public final Long serverTime;
  public final String text;
  public final byte[] thumbnail;
  public final long timeSent;
  public final Integer timebombInSec;
  public final Integer uploadDuration;

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = null;
    this.location = null;
    this.mediaType = null;
    this.bucketName = null;
    this.downloadID = null;
    this.thumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = null;
    this.mediaType = null;
    this.bucketName = null;
    this.downloadID = null;
    this.thumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = null;
    this.bucketName = null;
    this.downloadID = null;
    this.thumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = null;
    this.downloadID = null;
    this.thumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = null;
    this.thumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = null;
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = null;
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5, String paramString7)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.seqInPG = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5, String paramString7, int paramInt6)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.seqInPG = Integer.valueOf(paramInt6);
    this.chatType = null;
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5, String paramString7, int paramInt6, int paramInt7)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.seqInPG = Integer.valueOf(paramInt6);
    this.chatType = Integer.valueOf(paramInt7);
    this.timebombInSec = null;
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5, String paramString7, int paramInt6, int paramInt7, int paramInt8)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.seqInPG = Integer.valueOf(paramInt6);
    this.chatType = Integer.valueOf(paramInt7);
    this.timebombInSec = Integer.valueOf(paramInt8);
    this.groupType = null;
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5, String paramString7, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.seqInPG = Integer.valueOf(paramInt6);
    this.chatType = Integer.valueOf(paramInt7);
    this.timebombInSec = Integer.valueOf(paramInt8);
    this.groupType = Integer.valueOf(paramInt9);
    this.group2AccessToken = null;
    init();
  }

  public CGroupMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, String paramString4, long paramLong4, Location paramLocation, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5, String paramString7, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString8)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.text = Im2Utils.checkStringValue(paramString3);
    this.timeSent = paramLong3;
    this.flags = paramInt1;
    this.messageSeq = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.serverTime = Long.valueOf(paramLong4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt3);
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.seqInPG = Integer.valueOf(paramInt6);
    this.chatType = Integer.valueOf(paramInt7);
    this.timebombInSec = Integer.valueOf(paramInt8);
    this.groupType = Integer.valueOf(paramInt9);
    this.group2AccessToken = Im2Utils.checkStringValue(paramString8);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupMessageReceivedMsg(CGroupMessageReceivedMsg paramCGroupMessageReceivedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupMessageReceivedMsg
 * JD-Core Version:    0.6.2
 */