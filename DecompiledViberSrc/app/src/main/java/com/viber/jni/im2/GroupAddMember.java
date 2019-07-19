package com.viber.jni.im2;

public class GroupAddMember
{
  public final String phoneNumber;
  public final int role;

  public GroupAddMember(String paramString, int paramInt)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString);
    this.role = paramInt;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.GroupAddMember
 * JD-Core Version:    0.6.2
 */