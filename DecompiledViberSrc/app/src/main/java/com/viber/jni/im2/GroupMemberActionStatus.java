package com.viber.jni.im2;

public class GroupMemberActionStatus
{
  public final String phoneNumber;
  public final int status;

  public GroupMemberActionStatus(String paramString, int paramInt)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString);
    this.status = paramInt;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "GroupMemberActionStatus{phoneNumber='" + this.phoneNumber + '\'' + ", status=" + this.status + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.GroupMemberActionStatus
 * JD-Core Version:    0.6.2
 */