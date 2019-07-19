package com.viber.jni.im2;

public class Group2UserChanged
{
  public final int role;
  public final Group2UserInfo user;

  public Group2UserChanged(Group2UserInfo paramGroup2UserInfo, int paramInt)
  {
    this.user = ((Group2UserInfo)Im2Utils.checkStructValue(paramGroup2UserInfo));
    this.role = paramInt;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "Group2UserChanged{user=" + this.user + ", role=" + this.role + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Group2UserChanged
 * JD-Core Version:    0.6.2
 */