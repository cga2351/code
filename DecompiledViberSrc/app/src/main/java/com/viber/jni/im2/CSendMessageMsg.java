package com.viber.jni.im2;

public class CSendMessageMsg
{
  public final String bucket;
  public final Integer chatType;
  public final Long clientMediaType;
  public final String downloadID;
  public final Integer duration;
  public final Long exFlags;
  public final Integer flags;
  public final byte[] largeThumbnail;
  public final Location location;
  public final Integer mediaType;
  public final String mediaTypeExtraData;
  public final String msgInfo;
  public final Long objectID;
  public final int seq;
  public final String text;
  public final byte[] thumbnail;
  public final Integer timebombInSec;
  public final String toNumber;
  public final Integer uploadDuration;

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt;
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt, Location paramLocation)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt;
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte, int paramInt3)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.flags = Integer.valueOf(paramInt3);
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
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

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, String paramString3)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString3);
    this.downloadID = null;
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, String paramString3, String paramString4)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.bucket = null;
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.bucket = Im2Utils.checkStringValue(paramString5);
    this.chatType = null;
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.bucket = Im2Utils.checkStringValue(paramString5);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = null;
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6, int paramInt7)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.bucket = Im2Utils.checkStringValue(paramString5);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = Integer.valueOf(paramInt7);
    this.exFlags = null;
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong1, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6, int paramInt7, long paramLong2)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong1);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.bucket = Im2Utils.checkStringValue(paramString5);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = Integer.valueOf(paramInt7);
    this.exFlags = Long.valueOf(paramLong2);
    this.clientMediaType = null;
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong1, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6, int paramInt7, long paramLong2, long paramLong3)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong1);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.bucket = Im2Utils.checkStringValue(paramString5);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = Integer.valueOf(paramInt7);
    this.exFlags = Long.valueOf(paramLong2);
    this.clientMediaType = Long.valueOf(paramLong3);
    this.mediaTypeExtraData = null;
    init();
  }

  public CSendMessageMsg(String paramString1, String paramString2, int paramInt1, Location paramLocation, int paramInt2, long paramLong1, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6, int paramInt7, long paramLong2, long paramLong3, String paramString6)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString1);
    this.text = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt1;
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.mediaType = Integer.valueOf(paramInt2);
    this.objectID = Long.valueOf(paramLong1);
    this.thumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.flags = Integer.valueOf(paramInt3);
    this.largeThumbnail = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    this.duration = Integer.valueOf(paramInt4);
    this.uploadDuration = Integer.valueOf(paramInt5);
    this.msgInfo = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.bucket = Im2Utils.checkStringValue(paramString5);
    this.chatType = Integer.valueOf(paramInt6);
    this.timebombInSec = Integer.valueOf(paramInt7);
    this.exFlags = Long.valueOf(paramLong2);
    this.clientMediaType = Long.valueOf(paramLong3);
    this.mediaTypeExtraData = Im2Utils.checkStringValue(paramString6);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendMessageMsg(CSendMessageMsg paramCSendMessageMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendMessageMsg
 * JD-Core Version:    0.6.2
 */