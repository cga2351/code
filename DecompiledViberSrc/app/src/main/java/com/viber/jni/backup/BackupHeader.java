package com.viber.jni.backup;

public class BackupHeader
{
  private int mGroupMessageCount;
  private int mMessageCount;
  private String mPhoneNumber;
  private int mVersion;

  public int getGroupMessageCount()
  {
    return this.mGroupMessageCount;
  }

  public int getMessageCount()
  {
    return this.mMessageCount;
  }

  public String getPhoneNumber()
  {
    return this.mPhoneNumber;
  }

  public int getVersion()
  {
    return this.mVersion;
  }

  void setGroupMessageCount(int paramInt)
  {
    this.mGroupMessageCount = paramInt;
  }

  void setMessageCount(int paramInt)
  {
    this.mMessageCount = paramInt;
  }

  void setPhoneNumber(String paramString)
  {
    this.mPhoneNumber = paramString;
  }

  void setVersion(int paramInt)
  {
    this.mVersion = paramInt;
  }

  public String toString()
  {
    return "BackupHeader [version=" + this.mVersion + ", phoneNumber=" + this.mPhoneNumber + ", messageCount=" + this.mMessageCount + ", groupMessageCount=" + this.mGroupMessageCount + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.backup.BackupHeader
 * JD-Core Version:    0.6.2
 */