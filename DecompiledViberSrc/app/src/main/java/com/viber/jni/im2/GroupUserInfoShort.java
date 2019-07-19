package com.viber.jni.im2;

public class GroupUserInfoShort
{
  public final byte groupRole;
  public final String mid;

  public GroupUserInfoShort(String paramString, byte paramByte)
  {
    this.mid = Im2Utils.checkStringValue(paramString);
    this.groupRole = paramByte;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "GroupUserInfoShort{mid='" + this.mid + '\'' + ", groupRole=" + this.groupRole + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.GroupUserInfoShort
 * JD-Core Version:    0.6.2
 */