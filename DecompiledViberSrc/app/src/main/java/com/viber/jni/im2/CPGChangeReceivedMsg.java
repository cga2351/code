package com.viber.jni.im2;

import com.viber.jni.PublicAccountAttributes;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CPGChangeReceivedMsg
{
  public final Integer attributeChangeType;
  public final CGroupAttributesChanged attributes;
  public final String authenticationToken;
  public final String chatBackground;
  public final String clientName;
  public final Long communityPrivileges;
  public final String crmName;
  public final Integer displayInvitationLink;
  public final String email;
  public final String encryptedPhone;
  public final short flags;
  public final String group2AccessToken;
  public final Group2UserChanged[] group2Members;
  public final long groupID;
  public final String groupName;
  public final Integer groupType;
  public final Byte isSubscribed;
  public final JokerButton[] jokerButtons;
  public final GroupUserChanged[] members;
  public final int msgType;
  public final int numWatchers;
  public final String paCategory;
  public final String paSubCategory;
  public final Integer pgAndSearchFlags;
  public final int revision;
  public final int seqInPG;
  public final long timesent;
  public final long token;
  public final Byte webHookExists;
  public final String website;

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = null;
    this.paCategory = null;
    this.paSubCategory = null;
    this.webHookExists = null;
    this.crmName = null;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = null;
    this.paSubCategory = null;
    this.webHookExists = null;
    this.crmName = null;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = null;
    this.webHookExists = null;
    this.crmName = null;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = null;
    this.crmName = null;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = null;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte, String paramString6)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte, String paramString6, String paramString7)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte, String paramString6, String paramString7, String paramString8)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = null;
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte1, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9, byte paramByte2)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.groupType = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte1, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9, byte paramByte2, int paramInt6)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.groupType = Integer.valueOf(paramInt6);
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte1, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9, byte paramByte2, int paramInt6, Group2UserChanged[] paramArrayOfGroup2UserChanged)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.groupType = Integer.valueOf(paramInt6);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte1, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9, byte paramByte2, int paramInt6, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString10)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.groupType = Integer.valueOf(paramInt6);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString10);
    this.displayInvitationLink = null;
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte1, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9, byte paramByte2, int paramInt6, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString10, int paramInt7)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.groupType = Integer.valueOf(paramInt6);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString10);
    this.displayInvitationLink = Integer.valueOf(paramInt7);
    this.communityPrivileges = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte1, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9, byte paramByte2, int paramInt6, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString10, int paramInt7, long paramLong4)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.groupType = Integer.valueOf(paramInt6);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString10);
    this.displayInvitationLink = Integer.valueOf(paramInt7);
    this.communityPrivileges = Long.valueOf(paramLong4);
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte1, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9, byte paramByte2, int paramInt6, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString10, int paramInt7, long paramLong4, int paramInt8)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.groupType = Integer.valueOf(paramInt6);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString10);
    this.displayInvitationLink = Integer.valueOf(paramInt7);
    this.communityPrivileges = Long.valueOf(paramLong4);
    this.attributeChangeType = Integer.valueOf(paramInt8);
    this.chatBackground = null;
    init();
  }

  public CPGChangeReceivedMsg(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, long paramLong3, int paramInt2, short paramShort, int paramInt3, GroupUserChanged[] paramArrayOfGroupUserChanged, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4, int paramInt5, String paramString4, String paramString5, byte paramByte1, String paramString6, String paramString7, String paramString8, JokerButton[] paramArrayOfJokerButton, String paramString9, byte paramByte2, int paramInt6, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString10, int paramInt7, long paramLong4, int paramInt8, String paramString11)
  {
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhone = Im2Utils.checkStringValue(paramString3);
    this.timesent = paramLong2;
    this.revision = paramInt1;
    this.token = paramLong3;
    this.seqInPG = paramInt2;
    this.flags = paramShort;
    this.msgType = paramInt3;
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.attributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.numWatchers = paramInt4;
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString4);
    this.paSubCategory = Im2Utils.checkStringValue(paramString5);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString6);
    this.website = Im2Utils.checkStringValue(paramString7);
    this.email = Im2Utils.checkStringValue(paramString8);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString9);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.groupType = Integer.valueOf(paramInt6);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString10);
    this.displayInvitationLink = Integer.valueOf(paramInt7);
    this.communityPrivileges = Long.valueOf(paramLong4);
    this.attributeChangeType = Integer.valueOf(paramInt8);
    this.chatBackground = Im2Utils.checkStringValue(paramString11);
    init();
  }

  private void init()
  {
  }

  public int convertMsgType()
  {
    switch (this.msgType)
    {
    case 99:
    default:
      return 99;
    case 0:
      return 4;
    case 1:
      return 2;
    case 2:
      return 3;
    case 3:
      return 5;
    case 4:
      return 7;
    case 5:
      return 8;
    case 6:
      return 9;
    case 7:
      return 10;
    case 8:
      return 11;
    case 10:
      return 16;
    case 13:
      return 18;
    case 12:
      return 17;
    case 15:
    }
    return 20;
  }

  public PublicAccountAttributes toLegacyPublicAccountAttributes()
  {
    PublicAccountAttributes localPublicAccountAttributes = new PublicAccountAttributes();
    localPublicAccountAttributes.categoryId = this.paCategory;
    localPublicAccountAttributes.subCategoryId = this.paSubCategory;
    localPublicAccountAttributes.webHookExists = this.webHookExists.byteValue();
    localPublicAccountAttributes.crmName = this.crmName;
    localPublicAccountAttributes.website = this.website;
    localPublicAccountAttributes.email = this.email;
    localPublicAccountAttributes.authenticationToken = this.authenticationToken;
    localPublicAccountAttributes.isSubscribed = this.isSubscribed.byteValue();
    localPublicAccountAttributes.jokerButtons = new com.viber.jni.JokerButton[this.jokerButtons.length];
    for (int i = 0; i < this.jokerButtons.length; i++)
      localPublicAccountAttributes.jokerButtons[i] = this.jokerButtons[i].toLegacyJokerButton();
    return localPublicAccountAttributes;
  }

  public String toString()
  {
    return "CPGChangeReceivedMsg{groupID=" + this.groupID + ", groupName='" + this.groupName + '\'' + ", clientName='" + this.clientName + '\'' + ", encryptedPhone='" + this.encryptedPhone + '\'' + ", timesent=" + this.timesent + ", revision=" + this.revision + ", token=" + this.token + ", seqInPG=" + this.seqInPG + ", flags=" + this.flags + ", msgType=" + this.msgType + ", members=" + Arrays.toString(this.members) + ", attributes=" + this.attributes + ", numWatchers=" + this.numWatchers + ", pgAndSearchFlags=" + this.pgAndSearchFlags + ", paCategory='" + this.paCategory + '\'' + ", paSubCategory='" + this.paSubCategory + '\'' + ", webHookExists=" + this.webHookExists + ", crmName='" + this.crmName + '\'' + ", website='" + this.website + '\'' + ", email='" + this.email + '\'' + ", jokerButtons=" + Arrays.toString(this.jokerButtons) + ", authenticationToken='" + this.authenticationToken + '\'' + ", isSubscribed=" + this.isSubscribed + ", groupType=" + this.groupType + ", group2Members=" + Arrays.toString(this.group2Members) + ", group2AccessToken='" + this.group2AccessToken + ", displayInvitationLink=" + this.displayInvitationLink + ", communityPrivileges=" + this.communityPrivileges + '\'' + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EPgChangeType
  {
    public static final int CE_CHANGE_ATTRIBUTES = 15;
    public static final int COMMUNITY_DISPLAY_INVITATION_LINK = 12;
    public static final int COMMUNITY_PRIVILEGES_CHANGED = 13;
    public static final int GROUP_CHANGE_ATTRIBUTES = 2;
    public static final int GROUP_CHANGE_BLOCK = 4;
    public static final int GROUP_CHANGE_DELETE_MESSAGE = 6;
    public static final int GROUP_CHANGE_INVALID = 99;
    public static final int GROUP_CHANGE_KEY = 11;
    public static final int GROUP_CHANGE_LEFT = 1;
    public static final int GROUP_CHANGE_MEMBERS_ADDED = 0;
    public static final int GROUP_CHANGE_MEMBER_UPDATE_PHOTO = 5;
    public static final int GROUP_CHANGE_NUM_WATCHERS = 3;
    public static final int GROUP_DELETE_ALL_MESSAGES_FROM_USER = 10;
    public static final int GROUP_MEMBER_BAN_STATE_CHANGED = 14;
    public static final int GROUP_MEMBER_REMOVED = 8;
    public static final int GROUP_MEMBER_ROLE_CHANGED = 7;
    public static final int GROUP_MEMBER_SUBSCRIPTION_CHANGED = 9;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCPGChangeReceivedMsg(CPGChangeReceivedMsg paramCPGChangeReceivedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CPGChangeReceivedMsg
 * JD-Core Version:    0.6.2
 */