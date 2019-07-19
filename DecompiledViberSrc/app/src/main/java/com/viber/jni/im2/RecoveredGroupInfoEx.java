package com.viber.jni.im2;

public class RecoveredGroupInfoEx
{
  public final byte flags;
  public final long groupID;
  public final String groupName;
  public final byte groupRole;
  public final String iconDownloadID;
  public final PublicGroupUserInfoShort[] members;

  public RecoveredGroupInfoEx(long paramLong, String paramString1, PublicGroupUserInfoShort[] paramArrayOfPublicGroupUserInfoShort, String paramString2, byte paramByte1, byte paramByte2)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.members = ((PublicGroupUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfPublicGroupUserInfoShort, [Lcom.viber.jni.im2.PublicGroupUserInfoShort.class));
    this.iconDownloadID = Im2Utils.checkStringValue(paramString2);
    this.flags = paramByte1;
    this.groupRole = paramByte2;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.RecoveredGroupInfoEx
 * JD-Core Version:    0.6.2
 */