package com.viber.jni;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class GroupUserChanged
{
  private static final Logger L = ViberEnv.getLogger();
  private int role;
  private GroupUserInfo user;

  public GroupUserChanged(GroupUserInfo paramGroupUserInfo, int paramInt)
  {
    Logger localLogger = L;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramGroupUserInfo;
    arrayOfObject[1] = Integer.valueOf(this.role);
    localLogger.c("GroupUserChanged ctor user:? role:?", arrayOfObject);
    this.user = paramGroupUserInfo;
    this.role = paramInt;
  }

  public int getRole()
  {
    return this.role;
  }

  public GroupUserInfo getUser()
  {
    return this.user;
  }

  public String toString()
  {
    return "GroupUserChanged{user='" + this.user + '\'' + ", role='" + this.role + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.GroupUserChanged
 * JD-Core Version:    0.6.2
 */