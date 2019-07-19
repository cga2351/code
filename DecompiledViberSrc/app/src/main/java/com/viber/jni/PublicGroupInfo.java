package com.viber.jni;

import java.util.Arrays;

public class PublicGroupInfo
{
  public final String backgroundId;
  public final String countryCode;
  public final int flags;
  public final long groupID;
  public final String groupName;
  public final int groupRole;
  public final String groupUri;
  public final String iconId;
  public final int lastMessageId;
  public final LocationInfo location;
  public final PublicGroupUserInfo[] members;
  public final int publicGroupType;
  public final int revision;
  public final String tagLine;
  public final String[] tags;
  public final int watchersCount;

  public PublicGroupInfo(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, String paramString5, int paramInt3, String paramString6, String[] paramArrayOfString, PublicGroupUserInfo[] paramArrayOfPublicGroupUserInfo, int paramInt4, int paramInt5, int paramInt6)
  {
    this.publicGroupType = paramInt1;
    this.groupID = paramLong;
    this.groupName = paramString1;
    this.revision = paramInt2;
    this.groupUri = paramString2;
    this.iconId = paramString3;
    this.backgroundId = paramString4;
    this.location = paramLocationInfo;
    this.countryCode = paramString5;
    this.groupRole = paramInt3;
    this.tagLine = paramString6;
    this.tags = paramArrayOfString;
    this.members = paramArrayOfPublicGroupUserInfo;
    this.lastMessageId = paramInt4;
    this.flags = paramInt5;
    this.watchersCount = paramInt6;
  }

  public String toString()
  {
    return "PublicGroupInfo [publicGroupType=" + this.publicGroupType + ", groupID=" + this.groupID + ", groupName=" + this.groupName + ", revision=" + this.revision + ", groupUri=" + this.groupUri + ", iconId=" + this.iconId + ", backgroundId=" + this.backgroundId + ", location=" + this.location + ", countryCode=" + this.countryCode + ", groupRole=" + this.groupRole + ", tagLine=" + this.tagLine + ", tags=" + Arrays.toString(this.tags) + ", members=" + Arrays.toString(this.members) + ", lastMessageId=" + this.lastMessageId + ", flags=" + this.flags + ", watchersCount=" + this.watchersCount + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicGroupInfo
 * JD-Core Version:    0.6.2
 */