package com.viber.jni;

public class GroupToken
{
  public long groupID = 0L;
  public long token = 0L;

  public GroupToken(long paramLong1, long paramLong2)
  {
    this.token = paramLong1;
    this.groupID = paramLong2;
  }

  public String toString()
  {
    return "tk:" + this.token + " gId:" + this.groupID + "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.GroupToken
 * JD-Core Version:    0.6.2
 */