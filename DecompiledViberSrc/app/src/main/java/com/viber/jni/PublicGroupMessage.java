package com.viber.jni;

import android.os.Bundle;

public class PublicGroupMessage
{
  private String bucketName;
  private String downloadId;
  private long duration;
  private int flags;
  private LocationInfo location;
  private int mediaType;
  private int messageID;
  private int messageSeq;
  private long messageToken;
  private String msgInfo;
  private String phoneNumber;
  private String senderDownloadId;
  private String senderName;
  private String text;
  private long timeSent;
  private long uploadDuration;

  PublicGroupMessage(Bundle paramBundle)
  {
    this.messageSeq = paramBundle.getInt("MessageSeq");
    this.messageToken = paramBundle.getLong("MessageToken");
    this.messageID = paramBundle.getInt("MessageID");
    this.phoneNumber = paramBundle.getString("PhoneNumber");
    this.text = paramBundle.getString("Text");
    this.timeSent = paramBundle.getLong("TimeSent");
    this.mediaType = paramBundle.getInt("MediaType");
    this.senderName = paramBundle.getString("SenderName");
    this.location = new LocationInfo(paramBundle.getInt("LocationLat"), paramBundle.getInt("LocationLong"));
    this.bucketName = paramBundle.getString("BucketName");
    this.downloadId = paramBundle.getString("DownloadID");
    this.duration = paramBundle.getLong("Duration");
    this.uploadDuration = paramBundle.getLong("UploadDuration");
    this.msgInfo = paramBundle.getString("MsgInfo");
    this.flags = paramBundle.getInt("Flags");
    this.senderDownloadId = paramBundle.getString("SenderDownloadId");
  }

  public String getBucketName()
  {
    return this.bucketName;
  }

  public String getDownloadId()
  {
    return this.downloadId;
  }

  public long getDuration()
  {
    return this.duration;
  }

  public int getFlags()
  {
    return this.flags;
  }

  public LocationInfo getLocation()
  {
    return this.location;
  }

  public int getMediaType()
  {
    return this.mediaType;
  }

  public int getMessageID()
  {
    return this.messageID;
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

  public String getSenderDownloadId()
  {
    return this.senderDownloadId;
  }

  public String getSenderName()
  {
    return this.senderName;
  }

  public String getText()
  {
    return this.text;
  }

  public long getTimeSent()
  {
    return this.timeSent;
  }

  public long getUploadDuration()
  {
    return this.uploadDuration;
  }

  public String toString()
  {
    return "PublicGroupMessage{messageSeq=" + this.messageSeq + ", messageToken=" + this.messageToken + ", messageID=" + this.messageID + ", phoneNumber='" + this.phoneNumber + '\'' + ", text='" + this.text + '\'' + ", timeSent=" + this.timeSent + ", mediaType=" + this.mediaType + ", senderName='" + this.senderName + '\'' + ", location=" + this.location + ", bucketName='" + this.bucketName + '\'' + ", downloadId='" + this.downloadId + '\'' + ", duration=" + this.duration + ", uploadDuration=" + this.uploadDuration + ", msgInfo='" + this.msgInfo + '\'' + ", flags=" + this.flags + ", senderDownloadId='" + this.senderDownloadId + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicGroupMessage
 * JD-Core Version:    0.6.2
 */