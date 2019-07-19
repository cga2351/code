package com.viber.jni.im2;

public class CSendGroupMsg
{
  public final String bucket;
  public final Short chatType;
  public final Long clientMediaType;
  public final String downloadID;
  public final Integer duration;
  public final Long exFlags;
  public final Byte flags;
  public final long groupID;
  public final byte[] largeThumbnail;
  public final Location location;
  public final Byte mediaType;
  public final String mediaTypeExtraData;
  public final int messageSeq;
  public final String msgInfo;
  public final Long objectID;
  public final String text;
  public final byte[] thumbnail;
  public final Integer timebombInSec;
  public final Integer uploadDuration;

  public CSendGroupMsg(long paramLong, int paramInt, String paramString)
  {
    this.groupID = paramLong;
    this.messageSeq = paramInt;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = null;
    this.mediaType = null;
    this.objectID = null;
    this.thumbnail = null;
    this.flags = null;
    this.largeThumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong, int paramInt, String paramString, Location paramLocation)
  {
    this.groupID = paramLong;
    this.messageSeq = paramInt;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = null;
    this.objectID = null;
    this.thumbnail = null;
    this.flags = null;
    this.largeThumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong, int paramInt, String paramString, Location paramLocation, byte paramByte)
  {
    this.groupID = paramLong;
    this.messageSeq = paramInt;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte);
    this.objectID = null;
    this.thumbnail = null;
    this.flags = null;
    this.largeThumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt, String paramString, Location paramLocation, byte paramByte, long paramLong2)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = null;
    this.flags = null;
    this.largeThumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt, String paramString, Location paramLocation, byte paramByte, long paramLong2, byte[] paramArrayOfByte)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.flags = null;
    this.largeThumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt, String paramString, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte, byte paramByte2)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = null;
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt, String paramString, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = null;
    this.uploadDuration = null;
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = null;
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = null;
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString1, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString1);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString1, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString1);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.downloadID = Im2Utils.checkStringValue(paramString3);
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString1, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString1);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.downloadID = Im2Utils.checkStringValue(paramString3);
    this.bucket = Im2Utils.checkStringValue(paramString4);
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString1, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, short paramShort)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString1);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.downloadID = Im2Utils.checkStringValue(paramString3);
    this.bucket = Im2Utils.checkStringValue(paramString4);
    this.chatType = Short.valueOf(paramShort);
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString1, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, short paramShort, int paramInt4)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString1);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.downloadID = Im2Utils.checkStringValue(paramString3);
    this.bucket = Im2Utils.checkStringValue(paramString4);
    this.chatType = Short.valueOf(paramShort);
    this.timebombInSec = Integer.valueOf(paramInt4);
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString1, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, short paramShort, int paramInt4, long paramLong3)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString1);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.downloadID = Im2Utils.checkStringValue(paramString3);
    this.bucket = Im2Utils.checkStringValue(paramString4);
    this.chatType = Short.valueOf(paramShort);
    this.timebombInSec = Integer.valueOf(paramInt4);
    this.exFlags = Long.valueOf(paramLong3);
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString1, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, short paramShort, int paramInt4, long paramLong3, long paramLong4)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString1);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.downloadID = Im2Utils.checkStringValue(paramString3);
    this.bucket = Im2Utils.checkStringValue(paramString4);
    this.chatType = Short.valueOf(paramShort);
    this.timebombInSec = Integer.valueOf(paramInt4);
    this.exFlags = Long.valueOf(paramLong3);
    this.clientMediaType = Long.valueOf(paramLong4);
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendGroupMsg(long paramLong1, int paramInt1, String paramString1, Location paramLocation, byte paramByte1, long paramLong2, byte[] paramArrayOfByte1, byte paramByte2, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, short paramShort, int paramInt4, long paramLong3, long paramLong4, String paramString5)
  {
    this.groupID = paramLong1;
    this.messageSeq = paramInt1;
    this.text = Im2Utils.checkStringValue(paramString1);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Byte.valueOf(paramByte1);
    this.objectID = Long.valueOf(paramLong2);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Byte.valueOf(paramByte2);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt2);
    this.uploadDuration = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.downloadID = Im2Utils.checkStringValue(paramString3);
    this.bucket = Im2Utils.checkStringValue(paramString4);
    this.chatType = Short.valueOf(paramShort);
    this.timebombInSec = Integer.valueOf(paramInt4);
    this.exFlags = Long.valueOf(paramLong3);
    this.clientMediaType = Long.valueOf(paramLong4);
    this.mediaTypeExtraData = Im2Utils.checkStringValue(paramString5);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendGroupMsg(CSendGroupMsg paramCSendGroupMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendGroupMsg
 * JD-Core Version:    0.6.2
 */