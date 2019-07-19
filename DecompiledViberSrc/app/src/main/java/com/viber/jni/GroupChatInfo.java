package com.viber.jni;

import android.os.Bundle;
import java.util.Arrays;

public class GroupChatInfo
{
  public final int flags;
  public final long groupID;
  public final String groupName;
  public final int groupRole;
  public final String iconDownloadID;
  public ChatUserInfo[] members;

  private GroupChatInfo(Bundle paramBundle)
  {
    this.groupID = paramBundle.getLong("GroupID");
    this.groupName = paramBundle.getString("GroupName");
    this.iconDownloadID = paramBundle.getString("IconDownloadID");
    this.groupRole = paramBundle.getInt("GroupRole");
    this.flags = paramBundle.getInt("Flags");
    int i = paramBundle.getInt("ChatUserInfoSize");
    this.members = new ChatUserInfo[i];
    for (int j = 0; j < i; j++)
      this.members[j] = new ChatUserInfo(paramBundle.getBundle("Member" + j));
  }

  public String toString()
  {
    return "GroupChatInfo{groupID=" + this.groupID + ", groupName='" + this.groupName + '\'' + ", iconDownloadID='" + this.iconDownloadID + '\'' + ", groupRole=" + this.groupRole + ", flags=" + this.flags + ", members=" + Arrays.toString(this.members) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.GroupChatInfo
 * JD-Core Version:    0.6.2
 */