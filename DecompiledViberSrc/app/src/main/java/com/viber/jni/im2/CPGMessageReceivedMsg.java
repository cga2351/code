package com.viber.jni.im2;

public class CPGMessageReceivedMsg
{
  public final String bucketName;
  public final String clientName;
  public final String downloadID;
  public final int duration;
  public final String encryptedPhoneNumber;
  public final int flags;
  public final String group2AccessToken;
  public final long groupID;
  public final String groupName;
  public final Integer groupType;
  public final Location location;
  public final int mediaType;
  public final long messageToken;
  public final String msgInfo;
  public final int revision;
  public final String senderDownloadID;
  public final String senderName;
  public final int seqInPG;
  public final String text;
  public final byte[] thumbnail;
  public final long timeSent;
  public final int uploadDuration;

  public CPGMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, long paramLong3, int paramInt3, Location paramLocation, int paramInt4, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt5, int paramInt6)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.revision = paramInt2;
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.text = Im2Utils.checkStringValue(paramString4);
    this.timeSent = paramLong3;
    this.flags = paramInt3;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = paramInt4;
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = paramInt5;
    this.uploadDuration = paramInt6;
    this.msgInfo = null;
    this.groupType = null;
    this.group2AccessToken = null;
    this.senderDownloadID = null;
    this.senderName = null;
    init();
  }

  public CPGMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, long paramLong3, int paramInt3, Location paramLocation, int paramInt4, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt5, int paramInt6, String paramString7)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.revision = paramInt2;
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.text = Im2Utils.checkStringValue(paramString4);
    this.timeSent = paramLong3;
    this.flags = paramInt3;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = paramInt4;
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = paramInt5;
    this.uploadDuration = paramInt6;
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.groupType = null;
    this.group2AccessToken = null;
    this.senderDownloadID = null;
    this.senderName = null;
    init();
  }

  public CPGMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, long paramLong3, int paramInt3, Location paramLocation, int paramInt4, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt5, int paramInt6, String paramString7, int paramInt7)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.revision = paramInt2;
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.text = Im2Utils.checkStringValue(paramString4);
    this.timeSent = paramLong3;
    this.flags = paramInt3;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = paramInt4;
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = paramInt5;
    this.uploadDuration = paramInt6;
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.groupType = Integer.valueOf(paramInt7);
    this.group2AccessToken = null;
    this.senderDownloadID = null;
    this.senderName = null;
    init();
  }

  public CPGMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, long paramLong3, int paramInt3, Location paramLocation, int paramInt4, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt5, int paramInt6, String paramString7, int paramInt7, String paramString8)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.revision = paramInt2;
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.text = Im2Utils.checkStringValue(paramString4);
    this.timeSent = paramLong3;
    this.flags = paramInt3;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = paramInt4;
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = paramInt5;
    this.uploadDuration = paramInt6;
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.groupType = Integer.valueOf(paramInt7);
    this.group2AccessToken = Im2Utils.checkStringValue(paramString8);
    this.senderDownloadID = null;
    this.senderName = null;
    init();
  }

  public CPGMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, long paramLong3, int paramInt3, Location paramLocation, int paramInt4, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt5, int paramInt6, String paramString7, int paramInt7, String paramString8, String paramString9)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.revision = paramInt2;
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.text = Im2Utils.checkStringValue(paramString4);
    this.timeSent = paramLong3;
    this.flags = paramInt3;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = paramInt4;
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = paramInt5;
    this.uploadDuration = paramInt6;
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.groupType = Integer.valueOf(paramInt7);
    this.group2AccessToken = Im2Utils.checkStringValue(paramString8);
    this.senderDownloadID = Im2Utils.checkStringValue(paramString9);
    this.senderName = null;
    init();
  }

  public CPGMessageReceivedMsg(long paramLong1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, long paramLong3, int paramInt3, Location paramLocation, int paramInt4, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt5, int paramInt6, String paramString7, int paramInt7, String paramString8, String paramString9, String paramString10)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.revision = paramInt2;
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.text = Im2Utils.checkStringValue(paramString4);
    this.timeSent = paramLong3;
    this.flags = paramInt3;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = paramInt4;
    this.bucketName = Im2Utils.checkStringValue(paramString5);
    this.downloadID = Im2Utils.checkStringValue(paramString6);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.duration = paramInt5;
    this.uploadDuration = paramInt6;
    this.msgInfo = Im2Utils.checkStringValue(paramString7);
    this.groupType = Integer.valueOf(paramInt7);
    this.group2AccessToken = Im2Utils.checkStringValue(paramString8);
    this.senderDownloadID = Im2Utils.checkStringValue(paramString9);
    this.senderName = Im2Utils.checkStringValue(paramString10);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCPGMessageReceivedMsg(CPGMessageReceivedMsg paramCPGMessageReceivedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CPGMessageReceivedMsg
 * JD-Core Version:    0.6.2
 */