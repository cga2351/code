package com.viber.jni.im2;

public class RecoveredSecureGroupInfo
{
  public final byte flags;
  public final long groupID;
  public final byte groupRole;
  public final PublicGroupUserInfoShort[] members;

  public RecoveredSecureGroupInfo(long paramLong, PublicGroupUserInfoShort[] paramArrayOfPublicGroupUserInfoShort, byte paramByte1, byte paramByte2)
  {
    this.groupID = paramLong;
    this.members = ((PublicGroupUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfPublicGroupUserInfoShort, [Lcom.viber.jni.im2.PublicGroupUserInfoShort.class));
    this.flags = paramByte1;
    this.groupRole = paramByte2;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.RecoveredSecureGroupInfo
 * JD-Core Version:    0.6.2
 */