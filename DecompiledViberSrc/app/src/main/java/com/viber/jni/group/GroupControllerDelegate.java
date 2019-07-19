package com.viber.jni.group;

import com.viber.jni.GroupUserChanged;
import java.util.Map;

public abstract interface GroupControllerDelegate
{
  public static abstract interface AssignRole
  {
    public abstract void onGroupAssignRole(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, String[] paramArrayOfString, Map<String, Integer> paramMap, int paramInt4, int paramInt5);
  }

  public static abstract interface GroupCreate
  {
    public abstract void onCreateGroupReply(int paramInt1, int paramInt2, long paramLong, Map<String, Integer> paramMap);
  }

  public static abstract interface GroupDelegate extends GroupControllerDelegate.AssignRole, GroupControllerDelegate.GroupCreate, GroupControllerDelegate.GroupInfo
  {
  }

  public static abstract interface GroupInfo
  {
    public abstract void onGroupInfo(int paramInt1, long paramLong, String paramString1, String paramString2, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.group.GroupControllerDelegate
 * JD-Core Version:    0.6.2
 */