package com.viber.jni.im2;

public class GroupUserChanged
{
  public final int role;
  public final GroupUserInfo user;

  public GroupUserChanged(GroupUserInfo paramGroupUserInfo, int paramInt)
  {
    this.user = ((GroupUserInfo)Im2Utils.checkStructValue(paramGroupUserInfo));
    this.role = paramInt;
    init();
  }

  private void init()
  {
  }

  public com.viber.jni.GroupUserChanged toLegacyGroupUserChanged()
  {
    return new com.viber.jni.GroupUserChanged(this.user.toLegacyGroupUserInfo(), this.role);
  }

  public String toString()
  {
    return "GroupUserChanged{user=" + this.user + ", role=" + this.role + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.GroupUserChanged
 * JD-Core Version:    0.6.2
 */