package com.viber.jni.im2;

public class RecoveredGroupInfo
{
  public final byte flags;
  public final long groupID;
  public final String groupName;
  public final String[] members;

  public RecoveredGroupInfo(long paramLong, String paramString, String[] paramArrayOfString, byte paramByte)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.flags = paramByte;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.RecoveredGroupInfo
 * JD-Core Version:    0.6.2
 */