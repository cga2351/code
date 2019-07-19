package com.viber.jni.backup;

public class GroupMessageBackupEntity extends MessageBackupEntity
{
  private long groupId;
  private String groupName;

  public long getGroupId()
  {
    return this.groupId;
  }

  public String getGroupName()
  {
    return this.groupName;
  }

  public void setGroupId(long paramLong)
  {
    this.groupId = paramLong;
  }

  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.backup.GroupMessageBackupEntity
 * JD-Core Version:    0.6.2
 */