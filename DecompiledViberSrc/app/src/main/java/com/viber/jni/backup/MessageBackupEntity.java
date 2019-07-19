package com.viber.jni.backup;

import com.viber.jni.EncryptionParams;
import com.viber.jni.LocationInfo;

public class MessageBackupEntity extends BackupEntity
{
  private String body;
  private String bucket;
  private long date;
  private String downloadId;
  private long duration;
  private EncryptionParams encryptionParams;
  private int flags;
  private int latitude;
  private int longitude;
  private int mediaType;
  private String memberId;
  private int messageSeq;
  private long messageToken;
  private String msgInfo;
  private String phoneNumber;
  private byte[] thumbnailByteArray;

  public String getBody()
  {
    return this.body;
  }

  public String getBucket()
  {
    return this.bucket;
  }

  public long getDate()
  {
    return this.date;
  }

  public String getDownloadId()
  {
    return this.downloadId;
  }

  public long getDuration()
  {
    return this.duration;
  }

  public EncryptionParams getEncryptionParams()
  {
    return this.encryptionParams;
  }

  public int getFlags()
  {
    return this.flags;
  }

  public int getLatitude()
  {
    return this.latitude;
  }

  public LocationInfo getLocation()
  {
    return new LocationInfo(getLatitude(), getLongitude());
  }

  public int getLongitude()
  {
    return this.longitude;
  }

  public int getMediaType()
  {
    return this.mediaType;
  }

  public String getMemberId()
  {
    return this.memberId;
  }

  public int getMessageSeq()
  {
    return this.messageSeq;
  }

  public long getMessageToken()
  {
    return this.messageToken;
  }

  public String getMsgInfo()
  {
    return this.msgInfo;
  }

  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }

  public byte[] getThumbnailByteArray()
  {
    return this.thumbnailByteArray;
  }

  public void setBody(String paramString)
  {
    this.body = paramString;
  }

  public void setBucket(String paramString)
  {
    this.bucket = paramString;
  }

  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }

  public void setDownloadId(String paramString)
  {
    this.downloadId = paramString;
  }

  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }

  public void setEncryptionParams(EncryptionParams paramEncryptionParams)
  {
    this.encryptionParams = paramEncryptionParams;
  }

  public void setFlags(int paramInt)
  {
    this.flags = paramInt;
  }

  public void setLatitude(int paramInt)
  {
    this.latitude = paramInt;
  }

  public void setLongitude(int paramInt)
  {
    this.longitude = paramInt;
  }

  public void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }

  public void setMemberId(String paramString)
  {
    this.memberId = paramString;
  }

  public void setMessageSeq(int paramInt)
  {
    this.messageSeq = paramInt;
  }

  public void setMessageToken(long paramLong)
  {
    this.messageToken = paramLong;
  }

  public void setMsgInfo(String paramString)
  {
    this.msgInfo = paramString;
  }

  public void setPhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
  }

  public void setThumbnailByteArray(byte[] paramArrayOfByte)
  {
    this.thumbnailByteArray = paramArrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.backup.MessageBackupEntity
 * JD-Core Version:    0.6.2
 */