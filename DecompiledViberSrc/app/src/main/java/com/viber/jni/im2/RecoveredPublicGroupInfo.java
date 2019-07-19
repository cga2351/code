package com.viber.jni.im2;

public class RecoveredPublicGroupInfo
{
  public final String backgroundDownloadID;
  public final String countryCode;
  public final byte flags;
  public final long groupID;
  public final String groupName;
  public final byte groupRole;
  public final String groupUri;
  public final String iconDownloadID;
  public final int lastMessageID;
  public final Location location;
  public final PublicGroupUserInfoShort[] members;
  public final byte publicGroupType;
  public final int revision;
  public final String tagLine;
  public final String[] tags;
  public final int watchersCount;

  public RecoveredPublicGroupInfo(long paramLong, String paramString1, PublicGroupUserInfoShort[] paramArrayOfPublicGroupUserInfoShort, byte paramByte1, byte paramByte2, int paramInt1, String paramString2, String paramString3, String paramString4, Location paramLocation, String paramString5, byte paramByte3, String paramString6, String[] paramArrayOfString, int paramInt2, int paramInt3)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.members = ((PublicGroupUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfPublicGroupUserInfoShort, [Lcom.viber.jni.im2.PublicGroupUserInfoShort.class));
    this.flags = paramByte1;
    this.publicGroupType = paramByte2;
    this.revision = paramInt1;
    this.groupUri = Im2Utils.checkStringValue(paramString2);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString3);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString4);
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.countryCode = Im2Utils.checkStringValue(paramString5);
    this.groupRole = paramByte3;
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.lastMessageID = paramInt2;
    this.watchersCount = paramInt3;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.RecoveredPublicGroupInfo
 * JD-Core Version:    0.6.2
 */