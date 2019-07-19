package com.viber.jni.im2;

import com.viber.jni.PublicAccountInfo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CGetPublicAccountInfoReplyMsg
{
  public final String authToken;
  public final String backgroundDownloadID;
  public final String category;
  public final String chatBackground;
  public final Integer chunkID;
  public final Long communityPrivileges;
  public final String country;
  public final String crmName;
  public final DeleteAllUserMessagesInfo[] deleteAllUserMessagesInfos;
  public final Integer displayInvitationLink;
  public final String email;
  public final String group2AccessToken;
  public final int groupFlags;
  public final String groupName;
  public final int groupType;
  public final String groupUri;
  public final String iconDownloadID;
  public final String invitationLink;
  public final JokerButton[] jokerButtons;
  public final Boolean lastMsg;
  public final int lastMsgSeqID;
  public final Location location;
  public final ChatUserInfo[] members;
  public final PinInfo[] pinsInfo;
  public final String publicAccountID;
  public final long publicChatId;
  public final int revision;
  public final int seq;
  public final int status;
  public final String subCategory;
  public final int subscribersCount;
  public final String tagLine;
  public final String[] tags;
  public final short userFlags;
  public final byte userRole;
  public final int watchersCount;
  public final boolean webhookExists;
  public final String website;

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.crmName = null;
    this.pinsInfo = null;
    this.invitationLink = null;
    this.deleteAllUserMessagesInfos = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = null;
    this.jokerButtons = null;
    this.crmName = null;
    this.pinsInfo = null;
    this.invitationLink = null;
    this.deleteAllUserMessagesInfos = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = null;
    this.crmName = null;
    this.pinsInfo = null;
    this.invitationLink = null;
    this.deleteAllUserMessagesInfos = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = null;
    this.pinsInfo = null;
    this.invitationLink = null;
    this.deleteAllUserMessagesInfos = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = null;
    this.invitationLink = null;
    this.deleteAllUserMessagesInfos = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = null;
    this.deleteAllUserMessagesInfos = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = Im2Utils.checkStringValue(paramString14);
    this.deleteAllUserMessagesInfos = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = Im2Utils.checkStringValue(paramString14);
    this.deleteAllUserMessagesInfos = ((DeleteAllUserMessagesInfo[])Im2Utils.checkArrayValue(paramArrayOfDeleteAllUserMessagesInfo, [Lcom.viber.jni.im2.DeleteAllUserMessagesInfo.class));
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo, String paramString15)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = Im2Utils.checkStringValue(paramString14);
    this.deleteAllUserMessagesInfos = ((DeleteAllUserMessagesInfo[])Im2Utils.checkArrayValue(paramArrayOfDeleteAllUserMessagesInfo, [Lcom.viber.jni.im2.DeleteAllUserMessagesInfo.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString15);
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo, String paramString15, int paramInt9)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = Im2Utils.checkStringValue(paramString14);
    this.deleteAllUserMessagesInfos = ((DeleteAllUserMessagesInfo[])Im2Utils.checkArrayValue(paramArrayOfDeleteAllUserMessagesInfo, [Lcom.viber.jni.im2.DeleteAllUserMessagesInfo.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString15);
    this.displayInvitationLink = Integer.valueOf(paramInt9);
    this.communityPrivileges = null;
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong1, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo, String paramString15, int paramInt9, long paramLong2)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong1;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = Im2Utils.checkStringValue(paramString14);
    this.deleteAllUserMessagesInfos = ((DeleteAllUserMessagesInfo[])Im2Utils.checkArrayValue(paramArrayOfDeleteAllUserMessagesInfo, [Lcom.viber.jni.im2.DeleteAllUserMessagesInfo.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString15);
    this.displayInvitationLink = Integer.valueOf(paramInt9);
    this.communityPrivileges = Long.valueOf(paramLong2);
    this.chunkID = null;
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong1, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo, String paramString15, int paramInt9, long paramLong2, int paramInt10)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong1;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = Im2Utils.checkStringValue(paramString14);
    this.deleteAllUserMessagesInfos = ((DeleteAllUserMessagesInfo[])Im2Utils.checkArrayValue(paramArrayOfDeleteAllUserMessagesInfo, [Lcom.viber.jni.im2.DeleteAllUserMessagesInfo.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString15);
    this.displayInvitationLink = Integer.valueOf(paramInt9);
    this.communityPrivileges = Long.valueOf(paramLong2);
    this.chunkID = Integer.valueOf(paramInt10);
    this.lastMsg = null;
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong1, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean1, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo, String paramString15, int paramInt9, long paramLong2, int paramInt10, boolean paramBoolean2)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong1;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean1;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = Im2Utils.checkStringValue(paramString14);
    this.deleteAllUserMessagesInfos = ((DeleteAllUserMessagesInfo[])Im2Utils.checkArrayValue(paramArrayOfDeleteAllUserMessagesInfo, [Lcom.viber.jni.im2.DeleteAllUserMessagesInfo.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString15);
    this.displayInvitationLink = Integer.valueOf(paramInt9);
    this.communityPrivileges = Long.valueOf(paramLong2);
    this.chunkID = Integer.valueOf(paramInt10);
    this.lastMsg = Boolean.valueOf(paramBoolean2);
    this.chatBackground = null;
    init();
  }

  public CGetPublicAccountInfoReplyMsg(int paramInt1, int paramInt2, long paramLong1, String paramString1, int paramInt3, ChatUserInfo[] paramArrayOfChatUserInfo, byte paramByte, short paramShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, Location paramLocation, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean1, String paramString11, String paramString12, JokerButton[] paramArrayOfJokerButton, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo, String paramString15, int paramInt9, long paramLong2, int paramInt10, boolean paramBoolean2, String paramString16)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicChatId = paramLong1;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.groupType = paramInt3;
    this.members = ((ChatUserInfo[])Im2Utils.checkArrayValue(paramArrayOfChatUserInfo, [Lcom.viber.jni.im2.ChatUserInfo.class));
    this.userRole = paramByte;
    this.userFlags = paramShort;
    this.watchersCount = paramInt4;
    this.subscribersCount = paramInt5;
    this.lastMsgSeqID = paramInt6;
    this.revision = paramInt7;
    this.groupName = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString4);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString5);
    this.tagLine = Im2Utils.checkStringValue(paramString6);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString7);
    this.groupFlags = paramInt8;
    this.category = Im2Utils.checkStringValue(paramString8);
    this.subCategory = Im2Utils.checkStringValue(paramString9);
    this.authToken = Im2Utils.checkStringValue(paramString10);
    this.webhookExists = paramBoolean1;
    this.website = Im2Utils.checkStringValue(paramString11);
    this.email = Im2Utils.checkStringValue(paramString12);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.crmName = Im2Utils.checkStringValue(paramString13);
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.invitationLink = Im2Utils.checkStringValue(paramString14);
    this.deleteAllUserMessagesInfos = ((DeleteAllUserMessagesInfo[])Im2Utils.checkArrayValue(paramArrayOfDeleteAllUserMessagesInfo, [Lcom.viber.jni.im2.DeleteAllUserMessagesInfo.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString15);
    this.displayInvitationLink = Integer.valueOf(paramInt9);
    this.communityPrivileges = Long.valueOf(paramLong2);
    this.chunkID = Integer.valueOf(paramInt10);
    this.lastMsg = Boolean.valueOf(paramBoolean2);
    this.chatBackground = Im2Utils.checkStringValue(paramString16);
    init();
  }

  private void init()
  {
  }

  public PublicAccountInfo toLegacyPublicAccountInfo()
  {
    com.viber.jni.ChatUserInfo[] arrayOfChatUserInfo = new com.viber.jni.ChatUserInfo[this.members.length];
    for (int i = 0; i < this.members.length; i++)
      arrayOfChatUserInfo[i] = this.members[i].toLegacyChatUserInfo();
    com.viber.jni.JokerButton[] arrayOfJokerButton = new com.viber.jni.JokerButton[this.jokerButtons.length];
    for (int j = 0; j < this.jokerButtons.length; j++)
      arrayOfJokerButton[j] = this.jokerButtons[j].toLegacyJokerButton();
    com.viber.jni.PinInfo[] arrayOfPinInfo = new com.viber.jni.PinInfo[this.pinsInfo.length];
    for (int k = 0; k < this.pinsInfo.length; k++)
      arrayOfPinInfo[k] = this.pinsInfo[k].toLegacyPinInfo();
    com.viber.jni.DeleteAllUserMessagesInfo[] arrayOfDeleteAllUserMessagesInfo = new com.viber.jni.DeleteAllUserMessagesInfo[this.deleteAllUserMessagesInfos.length];
    for (int m = 0; m < this.deleteAllUserMessagesInfos.length; m++)
      arrayOfDeleteAllUserMessagesInfo[m] = this.deleteAllUserMessagesInfos[m].toLegacyDeleteAllUserMessagesInfo();
    return new PublicAccountInfo(this.publicChatId, this.publicAccountID, this.groupType, arrayOfChatUserInfo, this.userRole, this.userFlags, this.watchersCount, this.subscribersCount, this.lastMsgSeqID, this.revision, this.groupName, this.groupUri, this.iconDownloadID, this.backgroundDownloadID, this.tagLine, this.tags, this.location.toLegacyLocation(), this.country, this.groupFlags, this.category, this.subCategory, this.authToken, this.webhookExists, arrayOfJokerButton, this.email, this.website, this.crmName, arrayOfPinInfo, this.invitationLink, arrayOfDeleteAllUserMessagesInfo, this.displayInvitationLink.intValue(), this.communityPrivileges.longValue(), this.group2AccessToken, this.chatBackground);
  }

  public String toString()
  {
    return "CGetPublicAccountInfoReplyMsg{status=" + this.status + ", seq=" + this.seq + ", publicChatId=" + this.publicChatId + ", publicAccountID='" + this.publicAccountID + '\'' + ", groupType=" + this.groupType + ", members=" + Arrays.toString(this.members) + ", userRole=" + this.userRole + ", userFlags=" + this.userFlags + ", watchersCount=" + this.watchersCount + ", subscribersCount=" + this.subscribersCount + ", lastMsgSeqID=" + this.lastMsgSeqID + ", revision=" + this.revision + ", groupName='" + this.groupName + '\'' + ", groupUri='" + this.groupUri + '\'' + ", iconDownloadID='" + this.iconDownloadID + '\'' + ", backgroundDownloadID='" + this.backgroundDownloadID + '\'' + ", tagLine='" + this.tagLine + '\'' + ", tags=" + Arrays.toString(this.tags) + ", location=" + this.location + ", country='" + this.country + '\'' + ", groupFlags=" + this.groupFlags + ", category='" + this.category + '\'' + ", subCategory='" + this.subCategory + '\'' + ", authToken='" + this.authToken + '\'' + ", webhookExists=" + this.webhookExists + ", website='" + this.website + '\'' + ", email='" + this.email + '\'' + ", jokerButtons=" + Arrays.toString(this.jokerButtons) + ", crmName='" + this.crmName + '\'' + ", pinsInfo=" + Arrays.toString(this.pinsInfo) + ", invitationLink='" + this.invitationLink + '\'' + ", deleteAllUserMessagesInfos=" + Arrays.toString(this.deleteAllUserMessagesInfos) + ", group2AccessToken='" + this.group2AccessToken + '\'' + ", displayInvitationLink=" + this.displayInvitationLink + ", communityPrivileges=" + this.communityPrivileges + ", chunkID=" + this.chunkID + ", lastMsg=" + this.lastMsg + ", chatBackground=" + this.chatBackground + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 2;
    public static final int NOT_AUTH = 4;
    public static final int NOT_IN_GROUP = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetPublicAccountInfoReplyMsg(CGetPublicAccountInfoReplyMsg paramCGetPublicAccountInfoReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetPublicAccountInfoReplyMsg
 * JD-Core Version:    0.6.2
 */