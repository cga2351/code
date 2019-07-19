package com.viber.jni.im2;

import com.viber.jni.PublicAccountAttributes;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CGroupChangedMsg
{
  public final Integer attributeChangeType;
  public final String authenticationToken;
  public final CGroupAttributesChanged changedAttributes;
  public final String chatBackground;
  public final String clientName;
  public final String crmName;
  public final Integer displayInvitationLink;
  public final String email;
  public final int flags;
  public final String group2AccessToken;
  public final Group2UserChanged[] group2Members;
  public final long groupID;
  public final String groupName;
  public final String groupOldName;
  public final Integer groupType;
  public final Byte isSubscribed;
  public final JokerButton[] jokerButtons;
  public final GroupUserChanged[] members;
  public final long messageToken;
  public final int messageType;
  public final Integer numWatchers;
  public final String originPhoneNumber;
  public final String paCategory;
  public final String paSubCategory;
  public final Integer pgAndSearchFlags;
  public final Integer seqInPG;
  public final long timeChanged;
  public final Byte webHookExists;
  public final String website;

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = null;
    this.changedAttributes = null;
    this.members = null;
    this.seqInPG = null;
    this.groupType = null;
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
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = null;
    this.members = null;
    this.seqInPG = null;
    this.groupType = null;
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
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = null;
    this.seqInPG = null;
    this.groupType = null;
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
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = null;
    this.groupType = null;
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
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = null;
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
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
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
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
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
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = null;
    this.webHookExists = null;
    this.crmName = null;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = null;
    this.crmName = null;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = null;
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte, String paramString7)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = null;
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte, String paramString7, String paramString8)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = null;
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte, String paramString7, String paramString8, String paramString9)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = null;
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = null;
    this.isSubscribed = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton, String paramString10)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString10);
    this.isSubscribed = null;
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte1, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton, String paramString10, byte paramByte2)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString10);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.group2Members = null;
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte1, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton, String paramString10, byte paramByte2, Group2UserChanged[] paramArrayOfGroup2UserChanged)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString10);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = null;
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte1, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton, String paramString10, byte paramByte2, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString11)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString10);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString11);
    this.displayInvitationLink = null;
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte1, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton, String paramString10, byte paramByte2, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString11, int paramInt6)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString10);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString11);
    this.displayInvitationLink = Integer.valueOf(paramInt6);
    this.numWatchers = null;
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte1, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton, String paramString10, byte paramByte2, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString11, int paramInt6, int paramInt7)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString10);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString11);
    this.displayInvitationLink = Integer.valueOf(paramInt6);
    this.numWatchers = Integer.valueOf(paramInt7);
    this.attributeChangeType = null;
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte1, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton, String paramString10, byte paramByte2, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString11, int paramInt6, int paramInt7, int paramInt8)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString10);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString11);
    this.displayInvitationLink = Integer.valueOf(paramInt6);
    this.numWatchers = Integer.valueOf(paramInt7);
    this.attributeChangeType = Integer.valueOf(paramInt8);
    this.chatBackground = null;
    init();
  }

  public CGroupChangedMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, byte paramByte1, String paramString7, String paramString8, String paramString9, JokerButton[] paramArrayOfJokerButton, String paramString10, byte paramByte2, Group2UserChanged[] paramArrayOfGroup2UserChanged, String paramString11, int paramInt6, int paramInt7, int paramInt8, String paramString12)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeChanged = paramLong3;
    this.flags = paramInt1;
    this.originPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.messageType = paramInt2;
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.groupName = Im2Utils.checkStringValue(paramString3);
    this.groupOldName = Im2Utils.checkStringValue(paramString4);
    this.changedAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.members = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.seqInPG = Integer.valueOf(paramInt3);
    this.groupType = Integer.valueOf(paramInt4);
    this.pgAndSearchFlags = Integer.valueOf(paramInt5);
    this.paCategory = Im2Utils.checkStringValue(paramString5);
    this.paSubCategory = Im2Utils.checkStringValue(paramString6);
    this.webHookExists = Byte.valueOf(paramByte1);
    this.crmName = Im2Utils.checkStringValue(paramString7);
    this.website = Im2Utils.checkStringValue(paramString8);
    this.email = Im2Utils.checkStringValue(paramString9);
    this.jokerButtons = ((JokerButton[])Im2Utils.checkArrayValue(paramArrayOfJokerButton, [Lcom.viber.jni.im2.JokerButton.class));
    this.authenticationToken = Im2Utils.checkStringValue(paramString10);
    this.isSubscribed = Byte.valueOf(paramByte2);
    this.group2Members = ((Group2UserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroup2UserChanged, [Lcom.viber.jni.im2.Group2UserChanged.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString11);
    this.displayInvitationLink = Integer.valueOf(paramInt6);
    this.numWatchers = Integer.valueOf(paramInt7);
    this.attributeChangeType = Integer.valueOf(paramInt8);
    this.chatBackground = Im2Utils.checkStringValue(paramString12);
    init();
  }

  private void init()
  {
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
    return "CGroupChangedMsg{groupID=" + this.groupID + ", messageToken=" + this.messageToken + ", timeChanged=" + this.timeChanged + ", flags=" + this.flags + ", originPhoneNumber='" + this.originPhoneNumber + '\'' + ", messageType=" + this.messageType + ", clientName='" + this.clientName + '\'' + ", groupName='" + this.groupName + '\'' + ", groupOldName='" + this.groupOldName + '\'' + ", changedAttributes=" + this.changedAttributes + ", members=" + Arrays.toString(this.members) + ", seqInPG=" + this.seqInPG + ", groupType=" + this.groupType + ", pgAndSearchFlags=" + this.pgAndSearchFlags + ", paCategory='" + this.paCategory + '\'' + ", paSubCategory='" + this.paSubCategory + '\'' + ", webHookExists=" + this.webHookExists + ", crmName='" + this.crmName + '\'' + ", website='" + this.website + '\'' + ", email='" + this.email + '\'' + ", jokerButtons=" + Arrays.toString(this.jokerButtons) + ", authenticationToken='" + this.authenticationToken + '\'' + ", isSubscribed=" + this.isSubscribed + ", group2Members=" + Arrays.toString(this.group2Members) + ", group2AccessToken='" + this.group2AccessToken + '\'' + ", displayInvitationLink=" + this.displayInvitationLink + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EGroupChanged
  {
    public static final int CE_CHANGE_ATTRIBUTES = 20;
    public static final int COMMUNITY_DISPLAY_INVITATION_LINK = 17;
    public static final int COMMUNITY_PRIVILEGES_CHANGED = 18;
    public static final int GROUP_BLOCK = 7;
    public static final int GROUP_CHANGE_ATTRIBUTES = 3;
    public static final int GROUP_CHANGE_NAME = 0;
    public static final int GROUP_DELETE_ALL_MESSAGES_FROM_USER = 16;
    public static final int GROUP_DELETE_MESSAGE = 9;
    public static final int GROUP_INVALID_CHANGE = 99;
    public static final int GROUP_MEMBER_ADDED = 1;
    public static final int GROUP_MEMBER_ADDED_MEMBERS = 4;
    public static final int GROUP_MEMBER_ADDED_WATCHER = 5;
    public static final int GROUP_MEMBER_BAN_STATE_CHANGED = 19;
    public static final int GROUP_MEMBER_IDENTITY_CHANGED = 14;
    public static final int GROUP_MEMBER_LEFT = 2;
    public static final int GROUP_MEMBER_LEFT_WATCHER = 6;
    public static final int GROUP_MEMBER_REMOVED = 11;
    public static final int GROUP_MEMBER_ROLE_CHANGED = 10;
    public static final int GROUP_MEMBER_SUBSCRIPTION_CHANGED = 15;
    public static final int GROUP_MEMBER_UPDATE_PHOTO = 8;
    public static final int GROUP_RECOVER_SECURITY = 13;
    public static final int GROUP_SECURITY_CHANGED = 12;
    public static final int MY_COMMUNITY_SETTINGS_CHANGED = 21;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupChangedMsg(CGroupChangedMsg paramCGroupChangedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupChangedMsg
 * JD-Core Version:    0.6.2
 */