package com.viber.jni;

import java.util.Arrays;

public class GroupInfoEx
{
  public final int flags;
  public final long groupId;
  public final String groupName;
  public final String iconID;
  public GroupUserChanged[] members;
  public final int role;

  public GroupInfoEx(long paramLong, String paramString1, String paramString2, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt1, int paramInt2)
  {
    this.groupId = paramLong;
    this.groupName = paramString1;
    this.iconID = paramString2;
    this.members = paramArrayOfGroupUserChanged;
    this.role = paramInt1;
    this.flags = paramInt2;
  }

  public String toString()
  {
    return "GroupInfoEx{groupId='" + this.groupId + '\'' + ", groupName='" + this.groupName + '\'' + ", iconID='" + this.iconID + '\'' + ", Members:'" + Arrays.toString(this.members) + '\'' + ", role='" + this.role + '\'' + ", flags='" + this.flags + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.GroupInfoEx
 * JD-Core Version:    0.6.2
 */