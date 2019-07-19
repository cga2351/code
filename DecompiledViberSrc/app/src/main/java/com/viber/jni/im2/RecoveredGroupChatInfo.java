package com.viber.jni.im2;

import java.util.Arrays;

public class RecoveredGroupChatInfo
{
  public final byte flags;
  public final long groupID;
  public final String groupName;
  public final byte groupRole;
  public final String iconDownloadID;
  public final GroupUserInfoShort[] members;

  public RecoveredGroupChatInfo(long paramLong, String paramString1, GroupUserInfoShort[] paramArrayOfGroupUserInfoShort, String paramString2, byte paramByte1, byte paramByte2)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.members = ((GroupUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfoShort, [Lcom.viber.jni.im2.GroupUserInfoShort.class));
    this.iconDownloadID = Im2Utils.checkStringValue(paramString2);
    this.flags = paramByte1;
    this.groupRole = paramByte2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "RecoveredGroupChatInfo{groupID=" + this.groupID + ", groupName='" + this.groupName + '\'' + ", members=" + Arrays.toString(this.members) + ", iconDownloadID='" + this.iconDownloadID + '\'' + ", flags=" + this.flags + ", groupRole=" + this.groupRole + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.RecoveredGroupChatInfo
 * JD-Core Version:    0.6.2
 */