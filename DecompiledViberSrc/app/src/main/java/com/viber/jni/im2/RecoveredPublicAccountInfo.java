package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class RecoveredPublicAccountInfo
{
  public final String authToken;
  public final String backgroundDownloadID;
  public final String category;
  public final String country;
  public final String crmName;
  public final String email;
  public final int groupFlags;
  public final String groupName;
  public final byte groupType;
  public final String groupUri;
  public final String iconDownloadID;
  public final JokerButton[] jokerButtons;
  public final int lastMsgSeqID;
  public final Location location;
  public final PublicAccountUserInfoShort[] members;
  public final String publicAccountID;
  public final long publicChatId;
  public final int revision;
  public final String subCategory;
  public final int subscribersCount;
  public final String tagLine;
  public final String[] tags;
  public final short userFlags;
  public final byte userRole;
  public final byte userSubscribeState;
  public final int watchersCount;
  public final boolean webhookExists;
  public final String website;

  public RecoveredPublicAccountInfo(long paramLong, String paramString1, byte paramByte1, PublicAccountUserInfoShort[] paramArrayOfPublicAccountUserInfoShort, byte paramByte2, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt5, String paramString8, String paramString9, String paramString10, boolean paramBoolean, byte paramByte3)
  {
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramByte1;
    this.members = ((PublicAccountUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfPublicAccountUserInfoShort, [Lcom.viber.jni.im2.PublicAccountUserInfoShort.class));
    this.userRole = paramByte2;
    this.userFlags = paramShort;
    this.watchersCount = paramInt1;
    this.subscribersCount = paramInt2;
    this.lastMsgSeqID = paramInt3;
    this.revision = paramInt4;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt5;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.userSubscribeState = paramByte3;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.crmName = null;
    init();
  }

  public RecoveredPublicAccountInfo(long paramLong, String paramString1, byte paramByte1, PublicAccountUserInfoShort[] paramArrayOfPublicAccountUserInfoShort, byte paramByte2, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt5, String paramString8, String paramString9, String paramString10, boolean paramBoolean, byte paramByte3, String paramString11)
  {
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramByte1;
    this.members = ((PublicAccountUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfPublicAccountUserInfoShort, [Lcom.viber.jni.im2.PublicAccountUserInfoShort.class));
    this.userRole = paramByte2;
    this.userFlags = paramShort;
    this.watchersCount = paramInt1;
    this.subscribersCount = paramInt2;
    this.lastMsgSeqID = paramInt3;
    this.revision = paramInt4;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt5;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.userSubscribeState = paramByte3;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = null;
    this.jokerButtons = null;
    this.crmName = null;
    init();
  }

  public RecoveredPublicAccountInfo(long paramLong, String paramString1, byte paramByte1, PublicAccountUserInfoShort[] paramArrayOfPublicAccountUserInfoShort, byte paramByte2, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt5, String paramString8, String paramString9, String paramString10, boolean paramBoolean, byte paramByte3, String paramString11, String paramString12)
  {
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramByte1;
    this.members = ((PublicAccountUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfPublicAccountUserInfoShort, [Lcom.viber.jni.im2.PublicAccountUserInfoShort.class));
    this.userRole = paramByte2;
    this.userFlags = paramShort;
    this.watchersCount = paramInt1;
    this.subscribersCount = paramInt2;
    this.lastMsgSeqID = paramInt3;
    this.revision = paramInt4;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt5;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.userSubscribeState = paramByte3;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = null;
    this.crmName = null;
    init();
  }

  public RecoveredPublicAccountInfo(long paramLong, String paramString1, byte paramByte1, PublicAccountUserInfoShort[] paramArrayOfPublicAccountUserInfoShort, byte paramByte2, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt5, String paramString8, String paramString9, String paramString10, boolean paramBoolean, byte paramByte3, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton)
  {
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramByte1;
    this.members = ((PublicAccountUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfPublicAccountUserInfoShort, [Lcom.viber.jni.im2.PublicAccountUserInfoShort.class));
    this.userRole = paramByte2;
    this.userFlags = paramShort;
    this.watchersCount = paramInt1;
    this.subscribersCount = paramInt2;
    this.lastMsgSeqID = paramInt3;
    this.revision = paramInt4;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt5;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.userSubscribeState = paramByte3;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = null;
    init();
  }

  public RecoveredPublicAccountInfo(long paramLong, String paramString1, byte paramByte1, PublicAccountUserInfoShort[] paramArrayOfPublicAccountUserInfoShort, byte paramByte2, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt5, String paramString8, String paramString9, String paramString10, boolean paramBoolean, byte paramByte3, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13)
  {
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramByte1;
    this.members = ((PublicAccountUserInfoShort[])Im2Utils.checkArrayValue(paramArrayOfPublicAccountUserInfoShort, [Lcom.viber.jni.im2.PublicAccountUserInfoShort.class));
    this.userRole = paramByte2;
    this.userFlags = paramShort;
    this.watchersCount = paramInt1;
    this.subscribersCount = paramInt2;
    this.lastMsgSeqID = paramInt3;
    this.revision = paramInt4;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt5;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.userSubscribeState = paramByte3;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "RecoveredPublicAccountInfo{publicChatId=" + this.publicChatId + ", publicAccountID='" + this.publicAccountID + '\'' + ", groupType=" + this.groupType + ", members=" + Arrays.toString(this.members) + ", userRole=" + this.userRole + ", userFlags=" + this.userFlags + ", watchersCount=" + this.watchersCount + ", subscribersCount=" + this.subscribersCount + ", lastMsgSeqID=" + this.lastMsgSeqID + ", revision=" + this.revision + ", groupName='" + this.groupName + '\'' + ", groupUri='" + this.groupUri + '\'' + ", iconDownloadID='" + this.iconDownloadID + '\'' + ", backgroundDownloadID='" + this.backgroundDownloadID + '\'' + ", tagLine='" + this.tagLine + '\'' + ", tags=" + Arrays.toString(this.tags) + ", location=" + this.location + ", country='" + this.country + '\'' + ", groupFlags=" + this.groupFlags + ", category='" + this.category + '\'' + ", subCategory='" + this.subCategory + '\'' + ", authToken='" + this.authToken + '\'' + ", webhookExists=" + this.webhookExists + ", userSubscribeState=" + this.userSubscribeState + ", website='" + this.website + '\'' + ", email='" + this.email + '\'' + ", jokerButtons=" + Arrays.toString(this.jokerButtons) + ", crmName='" + this.crmName + '\'' + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface SubscribeState
  {
    public static final int ROLE_ONLY = 0;
    public static final int SUBSCRIBE_AND_ROLE = 2;
    public static final int SUBSCRIBE_ONLY = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.RecoveredPublicAccountInfo
 * JD-Core Version:    0.6.2
 */