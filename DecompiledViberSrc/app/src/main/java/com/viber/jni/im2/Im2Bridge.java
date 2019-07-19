package com.viber.jni.im2;

import java.util.HashMap;

class Im2Bridge
{
  static final int MSG_ID_CAcceptGroupInviteMsg = 489;
  static final int MSG_ID_CAcceptGroupInviteReplyMsg = 490;
  static final int MSG_ID_CActOnViberIdPasswordMsg = 507;
  static final int MSG_ID_CActOnViberIdPasswordReplyMsg = 508;
  static final int MSG_ID_CAddressBookDeltaUpdateAckMsg = 281;
  static final int MSG_ID_CAddressBookDeltaUpdateV2Msg = 423;
  static final int MSG_ID_CAddressBookForSecondaryAckMsg = 171;
  static final int MSG_ID_CAddressBookForSecondaryV2Msg = 410;
  static final int MSG_ID_CAuthenticateAppMsg = 215;
  static final int MSG_ID_CAuthenticateAppReplyMsg = 216;
  static final int MSG_ID_CBillingTokenByMidMsg = 544;
  static final int MSG_ID_CBillingTokenByMidReplyMsg = 545;
  static final int MSG_ID_CBillingTokenMsg = 175;
  static final int MSG_ID_CBillingTokenReplyMsg = 176;
  static final int MSG_ID_CBlockAppMsg = 247;
  static final int MSG_ID_CBlockAppReplyMsg = 248;
  static final int MSG_ID_CBlockGroupInviteMsg = 186;
  static final int MSG_ID_CBlockGroupInviteReplyMsg = 195;
  static final int MSG_ID_CChangeConversationSettingsMsg = 153;
  static final int MSG_ID_CChangeConversationSettingsReplyMsg = 154;
  static final int MSG_ID_CChangeGroupAttributesMsg = 220;
  static final int MSG_ID_CChangeGroupAttributesReplyMsg = 221;
  static final int MSG_ID_CChangeGroupSettingsMsg = 135;
  static final int MSG_ID_CChangeGroupSettingsReplyMsg = 136;
  static final int MSG_ID_CChangeLastOnlineSettingsMsg = 179;
  static final int MSG_ID_CChangeLastOnlineSettingsReplyMsg = 180;
  static final int MSG_ID_CChangeReadNotificationsSettingsMsg = 189;
  static final int MSG_ID_CChangeReadNotificationsSettingsReplyMsg = 190;
  static final int MSG_ID_CChangeSettingsMsg = 52;
  static final int MSG_ID_CChangeSettingsReplyMsg = 53;
  static final int MSG_ID_CChangeUserActivitySettingsMsg = 255;
  static final int MSG_ID_CChangeUserActivitySettingsReplyMsg = 256;
  static final int MSG_ID_CChangeViberIdEmailMsg = 511;
  static final int MSG_ID_CChangeViberIdEmailReplyMsg = 512;
  static final int MSG_ID_CCheckAllowsM2MChatMsg = 716;
  static final int MSG_ID_CCheckAllowsM2MChatReplyMsg = 717;
  static final int MSG_ID_CCheckEmailStatusMsg = 505;
  static final int MSG_ID_CCheckEmailStatusReplyMsg = 506;
  static final int MSG_ID_CCheckGroup2InviteMsg = 523;
  static final int MSG_ID_CCheckGroup2InviteReplyMsg = 524;
  static final int MSG_ID_CConfirmOrRevokeEmailMsg = 732;
  static final int MSG_ID_CConfirmOrRevokeEmailReplyMsg = 733;
  static final int MSG_ID_CContactSavedInConversationNotificationMsg = 389;
  static final int MSG_ID_CContactSavedInConversationNotificationReplyMsg = 390;
  static final int MSG_ID_CConversationSynchedAckMsg = 165;
  static final int MSG_ID_CConversationSynchedMsg = 166;
  static final int MSG_ID_CCreateConferenceCallMsg = 700;
  static final int MSG_ID_CCreateConferenceCallReplyMsg = 701;
  static final int MSG_ID_CCreateGroup2InviteMsg = 519;
  static final int MSG_ID_CCreateGroup2InviteReplyMsg = 520;
  static final int MSG_ID_CCreateGroupInviteMsg = 487;
  static final int MSG_ID_CCreateGroupInviteReplyMsg = 488;
  static final int MSG_ID_CCreateGroupMsg = 97;
  static final int MSG_ID_CCreateGroupReplyMsg = 98;
  static final int MSG_ID_CDeleteAllUserMessagesMsg = 517;
  static final int MSG_ID_CDeleteAllUserMessagesReplyMsg = 518;
  static final int MSG_ID_CDeleteGlobalMessageMsg = 268;
  static final int MSG_ID_CDeleteGlobalMessageReplyMsg = 269;
  static final int MSG_ID_CDeleteMessageMsg = 360;
  static final int MSG_ID_CDeleteMessageReplyMsg = 361;
  static final int MSG_ID_CDeletedMessageAckMsg = 363;
  static final int MSG_ID_CDeletedMessageMsg = 362;
  static final int MSG_ID_CGdprCommandMsg = 532;
  static final int MSG_ID_CGdprCommandReplyMsg = 533;
  static final int MSG_ID_CGetAdInfoMsg = 542;
  static final int MSG_ID_CGetAdInfoReplyMsg = 543;
  static final int MSG_ID_CGetCommonCommunitiesMsg = 718;
  static final int MSG_ID_CGetCommonCommunitiesReplyMsg = 719;
  static final int MSG_ID_CGetDownloadDetailsMsg = 528;
  static final int MSG_ID_CGetDownloadDetailsReplyMsg = 529;
  static final int MSG_ID_CGetEncryptedMIDsMsg = 536;
  static final int MSG_ID_CGetEncryptedMIDsReplyMsg = 537;
  static final int MSG_ID_CGetGroup2AccessTokenMsg = 525;
  static final int MSG_ID_CGetGroup2AccessTokenReplyMsg = 526;
  static final int MSG_ID_CGetGroupInfoMsg = 104;
  static final int MSG_ID_CGetGroupInfoReplyMsg = 105;
  static final int MSG_ID_CGetGroupMessageStatusMsg = 377;
  static final int MSG_ID_CGetGroupMessageStatusReplyMsg = 378;
  static final int MSG_ID_CGetInviteLinksMsg = 726;
  static final int MSG_ID_CGetInviteLinksReplyMsg = 727;
  static final int MSG_ID_CGetLastOnlineMsg = 158;
  static final int MSG_ID_CGetLastOnlineReplyMsg = 159;
  static final int MSG_ID_CGetMyCommunitySettingsMsg = 720;
  static final int MSG_ID_CGetMyCommunitySettingsReplyMsg = 721;
  static final int MSG_ID_CGetPersonalDetailsMsg = 728;
  static final int MSG_ID_CGetPersonalDetailsReplyMsg = 729;
  static final int MSG_ID_CGetPersonalProfileReplyMsg = 372;
  static final int MSG_ID_CGetPublicAccountInfoMsg = 428;
  static final int MSG_ID_CGetPublicAccountInfoReplyMsg = 429;
  static final int MSG_ID_CGetPublicGroupInfoMsg = 226;
  static final int MSG_ID_CGetPublicGroupInfoReplyMsg = 227;
  static final int MSG_ID_CGetSecondaryDeviceDetailsReplyMsg = 384;
  static final int MSG_ID_CGetUserActivityMsg = 252;
  static final int MSG_ID_CGetUserActivityReplyMsg = 253;
  static final int MSG_ID_CGetUserAppsMsg = 257;
  static final int MSG_ID_CGetUserAppsReplyMsg = 258;
  static final int MSG_ID_CGetUserDateOfBirthMsg = 540;
  static final int MSG_ID_CGetUserDateOfBirthReplyMsg = 541;
  static final int MSG_ID_CGetUsersDetailsV2Msg = 412;
  static final int MSG_ID_CGetUsersDetailsV2ReplyMsg = 413;
  static final int MSG_ID_CGetViberIdMsg = 503;
  static final int MSG_ID_CGetViberIdReplyMsg = 504;
  static final int MSG_ID_CGroupAddMemberMsg = 106;
  static final int MSG_ID_CGroupAddMemberReplyMsg = 107;
  static final int MSG_ID_CGroupAddMembersMsg = 204;
  static final int MSG_ID_CGroupAddMembersReplyMsg = 205;
  static final int MSG_ID_CGroupAddWatchersMsg = 208;
  static final int MSG_ID_CGroupAddWatchersReplyMsg = 209;
  static final int MSG_ID_CGroupAssignRoleMsg = 293;
  static final int MSG_ID_CGroupAssignRoleReplyMsg = 294;
  static final int MSG_ID_CGroupBanUserMsg = 546;
  static final int MSG_ID_CGroupBanUserReplyMsg = 547;
  static final int MSG_ID_CGroupChangedAckMsg = 115;
  static final int MSG_ID_CGroupChangedMsg = 114;
  static final int MSG_ID_CGroupLeaveMsg = 108;
  static final int MSG_ID_CGroupLeaveReplyMsg = 109;
  static final int MSG_ID_CGroupMessageLike = 337;
  static final int MSG_ID_CGroupMessageLikeAck = 338;
  static final int MSG_ID_CGroupMessageReceivedMsg = 101;
  static final int MSG_ID_CGroupRemoveMembersMsg = 295;
  static final int MSG_ID_CGroupRemoveMembersReplyMsg = 271;
  static final int MSG_ID_CGroupSynchedAckMsg = 131;
  static final int MSG_ID_CGroupSynchedMsg = 138;
  static final int MSG_ID_CGroupUserIsTypingMsg = 103;
  static final int MSG_ID_CInviteToConferenceMsg = 707;
  static final int MSG_ID_CInviteToConferenceReplyMsg = 708;
  static final int MSG_ID_CIsOnlineMsg = 150;
  static final int MSG_ID_CIsOnlineReplyMsg = 151;
  static final int MSG_ID_CIsRegisteredNumberMsg = 67;
  static final int MSG_ID_CIsRegisteredNumberReplyMsg = 68;
  static final int MSG_ID_CJoinConfCallMsg = 702;
  static final int MSG_ID_CJoinConfCallReplyMsg = 703;
  static final int MSG_ID_CLateErrorOnReceivedMessageMsg = 471;
  static final int MSG_ID_CLateErrorOnReceivedMessageReplyMsg = 472;
  static final int MSG_ID_CLikeGroupMessage = 335;
  static final int MSG_ID_CLikeGroupMessageReply = 336;
  static final int MSG_ID_CLoginReplyMsg = 2;
  static final int MSG_ID_CMessageDeliveredAckMsg = 86;
  static final int MSG_ID_CMessageDeliveredMsg = 85;
  static final int MSG_ID_CMessageReceivedAckMsg = 76;
  static final int MSG_ID_CMessageReceivedMsg = 75;
  static final int MSG_ID_CMessageReceivedReplyableAckMsg = 724;
  static final int MSG_ID_CMessageReceivedReplyableAckReplyMsg = 725;
  static final int MSG_ID_CMessagesSynchedAckMsg = 128;
  static final int MSG_ID_CMessagesSynchedMsg = 137;
  static final int MSG_ID_COnClickMsg = 8;
  static final int MSG_ID_COnClickReplyMsg = 19;
  static final int MSG_ID_CPGChangeReceivedMsg = 223;
  static final int MSG_ID_CPGMessageReceivedMsg = 222;
  static final int MSG_ID_CPublicAccountSubscriberUpdateMsg = 430;
  static final int MSG_ID_CPublicAccountSubscriberUpdateReplyMsg = 431;
  static final int MSG_ID_CQueryDestOperationSupportMsg = 373;
  static final int MSG_ID_CQueryDestOperationSupportReplyMsg = 374;
  static final int MSG_ID_CRecoverGroupChatsMsg = 449;
  static final int MSG_ID_CRecoverGroupChatsReplyMsg = 450;
  static final int MSG_ID_CRecoverGroupsMsg = 184;
  static final int MSG_ID_CRecoverGroupsReplyMsg = 185;
  static final int MSG_ID_CRecoverPublicAccountsMsg = 451;
  static final int MSG_ID_CRecoverPublicAccountsReplyMsg = 452;
  static final int MSG_ID_CRecvInternalMsg = 711;
  static final int MSG_ID_CRecvInternalMsgAck = 712;
  static final int MSG_ID_CRefreshPublicAccountTokenMsg = 432;
  static final int MSG_ID_CRefreshPublicAccountTokenReplyMsg = 433;
  static final int MSG_ID_CRegisterViberIdMsg = 501;
  static final int MSG_ID_CRegisterViberIdReplyMsg = 502;
  static final int MSG_ID_CRegisteredContactsMsg = 411;
  static final int MSG_ID_CRegisteredNumbersAckMsg = 58;
  static final int MSG_ID_CRevokeGroup2InviteMsg = 521;
  static final int MSG_ID_CRevokeGroup2InviteReplyMsg = 522;
  static final int MSG_ID_CRevokeGroupInviteMsg = 493;
  static final int MSG_ID_CRevokeGroupInviteReplyMsg = 494;
  static final int MSG_ID_CSecretChatReceivedEventAckMsg = 481;
  static final int MSG_ID_CSecretChatReceivedEventMsg = 480;
  static final int MSG_ID_CSecretChatSendEventMsg = 478;
  static final int MSG_ID_CSecretChatSendEventReplyMsg = 479;
  static final int MSG_ID_CSecureSecondaryRegistrationFailureMsg = 722;
  static final int MSG_ID_CSendActionOnPGMsg = 211;
  static final int MSG_ID_CSendActionOnPGReplyMsg = 212;
  static final int MSG_ID_CSendActionToBotMsg = 515;
  static final int MSG_ID_CSendActionToBotReplyMsg = 516;
  static final int MSG_ID_CSendBackAckBase = 723;
  static final int MSG_ID_CSendBannerToClientAckMsg = 370;
  static final int MSG_ID_CSendBannerToClientMsg = 369;
  static final int MSG_ID_CSendConversationStatusMsg = 434;
  static final int MSG_ID_CSendConversationStatusReplyMsg = 435;
  static final int MSG_ID_CSendGroupMsg = 99;
  static final int MSG_ID_CSendGroupUserIsTypingMsg = 102;
  static final int MSG_ID_CSendInternalMsg = 709;
  static final int MSG_ID_CSendInternalMsgReply = 710;
  static final int MSG_ID_CSendMessageMsg = 73;
  static final int MSG_ID_CSendMessageReplyAckMsg = 254;
  static final int MSG_ID_CSendMessageReplyMsg = 74;
  static final int MSG_ID_CSendPublicGroupInviteMsg = 241;
  static final int MSG_ID_CSendUserIsTypingMsg = 43;
  static final int MSG_ID_CShareAddressBook2Msg = 277;
  static final int MSG_ID_CShareAddressBook2ReplyMsg = 279;
  static final int MSG_ID_CShareDeltaAddressBookMsg = 278;
  static final int MSG_ID_CSyncActionOnPGAckMsg = 214;
  static final int MSG_ID_CSyncActionOnPGMsg = 213;
  static final int MSG_ID_CSyncConversationMsg = 163;
  static final int MSG_ID_CSyncConversationReplyMsg = 164;
  static final int MSG_ID_CSyncDataFromMyOtherDeviceAckMsg = 486;
  static final int MSG_ID_CSyncDataFromMyOtherDeviceMsg = 485;
  static final int MSG_ID_CSyncDataToMyDevicesMsg = 483;
  static final int MSG_ID_CSyncDataToMyDevicesReplyMsg = 484;
  static final int MSG_ID_CSyncGroupMsg = 129;
  static final int MSG_ID_CSyncGroupReplyMsg = 130;
  static final int MSG_ID_CSyncMessagesMsg = 127;
  static final int MSG_ID_CSyncMessagesReplyMsg = 144;
  static final int MSG_ID_CUnlinkViberIdMsg = 509;
  static final int MSG_ID_CUnlinkViberIdReplyMsg = 510;
  static final int MSG_ID_CUnregisterAppMsg = 224;
  static final int MSG_ID_CUnregisterAppReplyMsg = 225;
  static final int MSG_ID_CUpdateBlockListMsg = 218;
  static final int MSG_ID_CUpdateBlockListReplyMsg = 219;
  static final int MSG_ID_CUpdateCommunityPrivilegesMsg = 534;
  static final int MSG_ID_CUpdateCommunityPrivilegesReplyMsg = 535;
  static final int MSG_ID_CUpdateCommunitySettingsMsg = 530;
  static final int MSG_ID_CUpdateCommunitySettingsReplyMsg = 531;
  static final int MSG_ID_CUpdateLanguageMsg = 239;
  static final int MSG_ID_CUpdateLanguageReplyMsg = 240;
  static final int MSG_ID_CUpdateMyCommunitySettingsMsg = 714;
  static final int MSG_ID_CUpdateMyCommunitySettingsReplyMsg = 715;
  static final int MSG_ID_CUpdatePersonalDetailsMsg = 730;
  static final int MSG_ID_CUpdatePersonalDetailsReplyMsg = 731;
  static final int MSG_ID_CUpdateSelfUserDetailsAckMsg = 162;
  static final int MSG_ID_CUpdateSelfUserDetailsMsg = 161;
  static final int MSG_ID_CUpdateUnsavedContactDetailsAckMsg = 266;
  static final int MSG_ID_CUpdateUnsavedContactDetailsMsg = 265;
  static final int MSG_ID_CUpdateUserDateOfBirthMsg = 538;
  static final int MSG_ID_CUpdateUserDateOfBirthReplyMsg = 539;
  static final int MSG_ID_CUpdateUserNameMsg = 121;
  static final int MSG_ID_CUpdateUserNameReplyMsg = 122;
  static final int MSG_ID_CUpdateUserPhotoMsg = 117;
  static final int MSG_ID_CUpdateUserPhotoReplyMsg = 118;
  static final int MSG_ID_CUserIsTypingMsg = 42;
  static final int MSG_ID_CValidateGroupUriMsg = 206;
  static final int MSG_ID_CValidateGroupUriReplyMsg = 207;
  static final int MSG_ID_CViberIdChangedMsg = 513;
  static final int MSG_ID_CWebNotificationAckMsg = 260;

  static CAcceptGroupInviteReplyMsg read_CAcceptGroupInviteReplyMsg(MessageRead paramMessageRead)
  {
    return new CAcceptGroupInviteReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU32("Status"), paramMessageRead.getString("GroupName"));
  }

  static CActOnViberIdPasswordReplyMsg read_CActOnViberIdPasswordReplyMsg(MessageRead paramMessageRead)
  {
    return new CActOnViberIdPasswordReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"), paramMessageRead.getU32("Version"));
  }

  static CAddressBookDeltaUpdateV2Msg read_CAddressBookDeltaUpdateV2Msg(MessageRead paramMessageRead)
  {
    int i = 0;
    int j = paramMessageRead.getU32("BaseRevision");
    int k = paramMessageRead.getU32("Revision");
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("NewPhones");
    CAddressBookEntryV2[] arrayOfCAddressBookEntryV21 = new CAddressBookEntryV2[arrayOfMessageRead1.length];
    for (int m = 0; m < arrayOfMessageRead1.length; m++)
      arrayOfCAddressBookEntryV21[m] = read_CAddressBookEntryV2(arrayOfMessageRead1[m]);
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("ChangedPhones");
    CAddressBookEntryV2[] arrayOfCAddressBookEntryV22 = new CAddressBookEntryV2[arrayOfMessageRead2.length];
    while (i < arrayOfMessageRead2.length)
    {
      arrayOfCAddressBookEntryV22[i] = read_CAddressBookEntryV2(arrayOfMessageRead2[i]);
      i++;
    }
    return new CAddressBookDeltaUpdateV2Msg(j, k, arrayOfCAddressBookEntryV21, arrayOfCAddressBookEntryV22, paramMessageRead.getStringArray("DeletedPhones"), paramMessageRead.getU64("MessageToken"));
  }

  static CAddressBookEntryV2 read_CAddressBookEntryV2(MessageRead paramMessageRead)
  {
    return new CAddressBookEntryV2(paramMessageRead.getString("MID"), paramMessageRead.getString("VID"), paramMessageRead.getString("PhoneNumber"), paramMessageRead.getString("ClientName"), paramMessageRead.getString("ClientSortName"), paramMessageRead.getString("DownloadID"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreInfo")), paramMessageRead.getU32("Flags"));
  }

  static CAddressBookForSecondaryV2Msg read_CAddressBookForSecondaryV2Msg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Context");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("AddressBookList");
    CAddressBookEntryV2[] arrayOfCAddressBookEntryV2 = new CAddressBookEntryV2[arrayOfMessageRead.length];
    for (int j = 0; j < arrayOfMessageRead.length; j++)
      arrayOfCAddressBookEntryV2[j] = read_CAddressBookEntryV2(arrayOfMessageRead[j]);
    return new CAddressBookForSecondaryV2Msg(i, arrayOfCAddressBookEntryV2, paramMessageRead.getU16("GenNum"), paramMessageRead.getBoolean("LastMsg"), paramMessageRead.getBoolean("ClearAll"), paramMessageRead.getU32("Seq"));
  }

  static CAuthenticateAppReplyMsg read_CAuthenticateAppReplyMsg(MessageRead paramMessageRead)
  {
    return new CAuthenticateAppReplyMsg(paramMessageRead.getString("AuthenticateToken"), paramMessageRead.getU32("Status"), paramMessageRead.getU32("sequence"), paramMessageRead.getU16("AppId"));
  }

  static CBillingTokenByMidReplyMsg read_CBillingTokenByMidReplyMsg(MessageRead paramMessageRead)
  {
    return new CBillingTokenByMidReplyMsg(0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU8Array("UDID"), paramMessageRead.getU64("Timestamp"), paramMessageRead.getString("Token"));
  }

  static CBillingTokenReplyMsg read_CBillingTokenReplyMsg(MessageRead paramMessageRead)
  {
    return new CBillingTokenReplyMsg(paramMessageRead.getU64("Timestamp"), paramMessageRead.getString("Token"));
  }

  static CBlockAppReplyMsg read_CBlockAppReplyMsg(MessageRead paramMessageRead)
  {
    return new CBlockAppReplyMsg(paramMessageRead.getU32("Status"), paramMessageRead.getU32("sequence"));
  }

  static CBlockGroupInviteReplyMsg read_CBlockGroupInviteReplyMsg(MessageRead paramMessageRead)
  {
    return new CBlockGroupInviteReplyMsg(paramMessageRead.getU32("Status"), paramMessageRead.getU32("Seq"));
  }

  static CChangeConversationSettingsReplyMsg read_CChangeConversationSettingsReplyMsg(MessageRead paramMessageRead)
  {
    String str = paramMessageRead.getString("PeerPhoneNumber");
    boolean bool1 = paramMessageRead.getBoolean("SmartNotifications");
    boolean bool2 = paramMessageRead.getBoolean("IsOK");
    Boolean localBoolean1 = Boolean.valueOf(paramMessageRead.getBoolean("Mute"));
    Boolean localBoolean2 = Boolean.valueOf(paramMessageRead.getBoolean("Hidden"));
    Integer localInteger = Integer.valueOf(0xFF & paramMessageRead.getU8("Status"));
    return new CChangeConversationSettingsReplyMsg(str, bool1, bool2, localBoolean1.booleanValue(), localBoolean2.booleanValue(), localInteger.intValue());
  }

  static CChangeGroupAttributesReplyMsg read_CChangeGroupAttributesReplyMsg(MessageRead paramMessageRead)
  {
    return new CChangeGroupAttributesReplyMsg(paramMessageRead.getU64("GroupID"), 0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU64("MessageToken"), paramMessageRead.getU32("Seq"), paramMessageRead.getU32("GroupRevision"), paramMessageRead.getU32("SeqInPG"), Byte.valueOf(paramMessageRead.getU8("IsChangePa")).byteValue());
  }

  static CChangeGroupSettingsReplyMsg read_CChangeGroupSettingsReplyMsg(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("GroupID");
    boolean bool1 = paramMessageRead.getBoolean("SmartNotifications");
    boolean bool2 = paramMessageRead.getBoolean("IsOK");
    Boolean localBoolean1 = Boolean.valueOf(paramMessageRead.getBoolean("Mute"));
    Boolean localBoolean2 = Boolean.valueOf(paramMessageRead.getBoolean("Hidden"));
    Integer localInteger = Integer.valueOf(0xFF & paramMessageRead.getU8("Status"));
    Boolean localBoolean3 = Boolean.valueOf(paramMessageRead.getBoolean("Recover"));
    return new CChangeGroupSettingsReplyMsg(l, bool1, bool2, localBoolean1.booleanValue(), localBoolean2.booleanValue(), localInteger.intValue(), localBoolean3.booleanValue());
  }

  static CChangeLastOnlineSettingsReplyMsg read_CChangeLastOnlineSettingsReplyMsg(MessageRead paramMessageRead)
  {
    return new CChangeLastOnlineSettingsReplyMsg(0xFF & paramMessageRead.getU8("LastOnlineSetting"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CChangeReadNotificationsSettingsReplyMsg read_CChangeReadNotificationsSettingsReplyMsg(MessageRead paramMessageRead)
  {
    return new CChangeReadNotificationsSettingsReplyMsg(0xFF & paramMessageRead.getU8("ReadNotificationsSetting"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CChangeSettingsReplyMsg read_CChangeSettingsReplyMsg(MessageRead paramMessageRead)
  {
    return new CChangeSettingsReplyMsg(0xFF & paramMessageRead.getU8("Status"), Integer.valueOf(paramMessageRead.getU32("Sequence")).intValue());
  }

  static CChangeUserActivitySettingsReplyMsg read_CChangeUserActivitySettingsReplyMsg(MessageRead paramMessageRead)
  {
    return new CChangeUserActivitySettingsReplyMsg(0xFF & paramMessageRead.getU8("UserActivitySetting"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CChangeViberIdEmailReplyMsg read_CChangeViberIdEmailReplyMsg(MessageRead paramMessageRead)
  {
    return new CChangeViberIdEmailReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"), paramMessageRead.getU32("Flags"), paramMessageRead.getU32("Version"));
  }

  static CCheckAllowsM2MChatReplyMsg read_CCheckAllowsM2MChatReplyMsg(MessageRead paramMessageRead)
  {
    return new CCheckAllowsM2MChatReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"));
  }

  static CCheckEmailStatusReplyMsg read_CCheckEmailStatusReplyMsg(MessageRead paramMessageRead)
  {
    return new CCheckEmailStatusReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"), paramMessageRead.getBoolean("PromotionsAgreed"));
  }

  static CCheckGroup2InviteReplyMsg read_CCheckGroup2InviteReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Seq");
    long l1 = paramMessageRead.getU64("GroupID");
    String str1 = paramMessageRead.getString("GroupName");
    String str2 = paramMessageRead.getString("IconDownloadID");
    String str3 = paramMessageRead.getString("TagLine");
    long l2 = paramMessageRead.getU64("InviteToken");
    int j = paramMessageRead.getU32("Status");
    Long localLong = Long.valueOf(paramMessageRead.getU64("CommunityPrivileges"));
    Integer localInteger = Integer.valueOf(paramMessageRead.getU32("GroupFlags"));
    return new CCheckGroup2InviteReplyMsg(i, l1, str1, str2, str3, l2, j, localLong.longValue(), localInteger.intValue());
  }

  static CConfirmOrRevokeEmailReplyMsg read_CConfirmOrRevokeEmailReplyMsg(MessageRead paramMessageRead)
  {
    return new CConfirmOrRevokeEmailReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"));
  }

  static CContactSavedInConversationNotificationReplyMsg read_CContactSavedInConversationNotificationReplyMsg(MessageRead paramMessageRead)
  {
    return new CContactSavedInConversationNotificationReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"));
  }

  static CConversationSynchedMsg read_CConversationSynchedMsg(MessageRead paramMessageRead)
  {
    byte[] arrayOfByte = paramMessageRead.getU8Array("UDID");
    String str = paramMessageRead.getString("PeerNumber");
    long l = paramMessageRead.getU64("LastMessageToken");
    int i = paramMessageRead.getU32("Flags");
    Short localShort = Short.valueOf(paramMessageRead.getU16("DeviceID"));
    Integer localInteger = Integer.valueOf(0xFFFF & paramMessageRead.getU16("ChatType"));
    Long localLong = Long.valueOf(paramMessageRead.getU64("TimeSent"));
    return new CConversationSynchedMsg(arrayOfByte, str, l, i, localShort.shortValue(), localInteger.intValue(), localLong.longValue());
  }

  static CCreateConferenceCallReplyMsg read_CCreateConferenceCallReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Status");
    int j = paramMessageRead.getU32("Seq");
    long l = paramMessageRead.getU64("CallToken");
    String str1 = paramMessageRead.getString("ConfID");
    String str2 = paramMessageRead.getString("Attachment");
    HashMap localHashMap = new HashMap();
    MessageRead.MapStringToNumberData localMapStringToNumberData = paramMessageRead.getMapStringToNumber("MemberStatus", 2);
    int k = localMapStringToNumberData.keys.length;
    for (int m = 0; m < k; m++)
      localHashMap.put(localMapStringToNumberData.keys[m], Integer.valueOf((int)localMapStringToNumberData.values[m]));
    return new CCreateConferenceCallReplyMsg(i, j, l, str1, str2, localHashMap);
  }

  static CCreateGroup2InviteReplyMsg read_CCreateGroup2InviteReplyMsg(MessageRead paramMessageRead)
  {
    return new CCreateGroup2InviteReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU32("Status"), paramMessageRead.getString("InviteLink"));
  }

  static CCreateGroupInviteReplyMsg read_CCreateGroupInviteReplyMsg(MessageRead paramMessageRead)
  {
    return new CCreateGroupInviteReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU32("Status"), paramMessageRead.getString("inviteLinkData"));
  }

  static CCreateGroupReplyMsg read_CCreateGroupReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Status");
    int j = paramMessageRead.getU32("Context");
    long l = paramMessageRead.getU64("GroupID");
    HashMap localHashMap = new HashMap();
    MessageRead.MapStringToNumberData localMapStringToNumberData = paramMessageRead.getMapStringToNumber("NotFoundMembers", 2);
    int k = localMapStringToNumberData.keys.length;
    for (int m = 0; m < k; m++)
      localHashMap.put(localMapStringToNumberData.keys[m], Integer.valueOf((int)localMapStringToNumberData.values[m]));
    return new CCreateGroupReplyMsg(i, j, l, localHashMap);
  }

  static CDeleteAllUserMessagesReplyMsg read_CDeleteAllUserMessagesReplyMsg(MessageRead paramMessageRead)
  {
    return new CDeleteAllUserMessagesReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("Token"), paramMessageRead.getU32("SeqInPG"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CDeleteGlobalMessageReplyMsg read_CDeleteGlobalMessageReplyMsg(MessageRead paramMessageRead)
  {
    return new CDeleteGlobalMessageReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU64("MessageToken"), paramMessageRead.getU32("SeqInPG"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CDeleteMessageReplyMsg read_CDeleteMessageReplyMsg(MessageRead paramMessageRead)
  {
    return new CDeleteMessageReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("MessageToken"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CDeletedMessageMsg read_CDeletedMessageMsg(MessageRead paramMessageRead)
  {
    return new CDeletedMessageMsg(paramMessageRead.getString("PeerPhone"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU64("MessageToken"), Long.valueOf(paramMessageRead.getU64("TimeSent")).longValue());
  }

  static CGdprCommandReplyMsg read_CGdprCommandReplyMsg(MessageRead paramMessageRead)
  {
    return new CGdprCommandReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getString("JobId"), paramMessageRead.getU32("ProcessDays"), paramMessageRead.getString("RequestDate"), 0xFF & paramMessageRead.getU8("Status"), 0xFF & paramMessageRead.getU8("CommandType"), paramMessageRead.getU32("LimitDays"));
  }

  static CGetAdInfoReplyMsg read_CGetAdInfoReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetAdInfoReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"), paramMessageRead.getString("AdInfo"), Long.valueOf(paramMessageRead.getU64("WaitIntervalForNextQuery")).longValue());
  }

  static CGetCommonCommunitiesReplyMsg read_CGetCommonCommunitiesReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetCommonCommunitiesReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"), paramMessageRead.getU64Array("Groups"));
  }

  static CGetDownloadDetailsReplyMsg read_CGetDownloadDetailsReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Seq");
    int j = paramMessageRead.getU32("Status");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("DownloadDetailsList");
    DownloadDetails[] arrayOfDownloadDetails = new DownloadDetails[arrayOfMessageRead.length];
    for (int k = 0; k < arrayOfMessageRead.length; k++)
      arrayOfDownloadDetails[k] = read_DownloadDetails(arrayOfMessageRead[k]);
    return new CGetDownloadDetailsReplyMsg(i, j, arrayOfDownloadDetails);
  }

  static CGetEncryptedMIDsReplyMsg read_CGetEncryptedMIDsReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Seq");
    int j = paramMessageRead.getU32("Status");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("EncryptedMids");
    EncryptedMIDMap[] arrayOfEncryptedMIDMap = new EncryptedMIDMap[arrayOfMessageRead.length];
    for (int k = 0; k < arrayOfMessageRead.length; k++)
      arrayOfEncryptedMIDMap[k] = read_EncryptedMIDMap(arrayOfMessageRead[k]);
    return new CGetEncryptedMIDsReplyMsg(i, j, arrayOfEncryptedMIDMap);
  }

  static CGetGroup2AccessTokenReplyMsg read_CGetGroup2AccessTokenReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetGroup2AccessTokenReplyMsg(paramMessageRead.getU64("GroupId"), paramMessageRead.getU32("Seq"), paramMessageRead.getString("Key"), paramMessageRead.getU32("Status"));
  }

  static CGetGroupInfoReplyMsg read_CGetGroupInfoReplyMsg(MessageRead paramMessageRead)
  {
    int i = 0;
    long l = paramMessageRead.getU64("GroupID");
    String str = paramMessageRead.getString("GroupName");
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("Members");
    GroupUserInfo[] arrayOfGroupUserInfo = new GroupUserInfo[arrayOfMessageRead1.length];
    for (int j = 0; j < arrayOfMessageRead1.length; j++)
      arrayOfGroupUserInfo[j] = read_GroupUserInfo(arrayOfMessageRead1[j]);
    int k = 0xFF & paramMessageRead.getU8("Status");
    Integer localInteger1 = Integer.valueOf(0xFF & paramMessageRead.getU8("flags"));
    Integer localInteger2 = Integer.valueOf(paramMessageRead.getU32("Seq"));
    CGroupAttributesChanged localCGroupAttributesChanged = read_CGroupAttributesChanged(paramMessageRead.getMessage("GroupAttributes"));
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("MembersWithRole");
    GroupUserChanged[] arrayOfGroupUserChanged = new GroupUserChanged[arrayOfMessageRead2.length];
    while (i < arrayOfMessageRead2.length)
    {
      arrayOfGroupUserChanged[i] = read_GroupUserChanged(arrayOfMessageRead2[i]);
      i++;
    }
    Integer localInteger3 = Integer.valueOf(paramMessageRead.getU32("GroupRole"));
    Integer localInteger4 = Integer.valueOf(paramMessageRead.getU32("TimebombInSec"));
    byte[] arrayOfByte1 = paramMessageRead.getU8Array("InviteLinkEnc");
    byte[] arrayOfByte2 = paramMessageRead.getU8Array("Tag");
    return new CGetGroupInfoReplyMsg(l, str, arrayOfGroupUserInfo, k, localInteger1.intValue(), localInteger2.intValue(), localCGroupAttributesChanged, arrayOfGroupUserChanged, localInteger3.intValue(), localInteger4.intValue(), arrayOfByte1, arrayOfByte2);
  }

  static CGetGroupMessageStatusReplyMsg read_CGetGroupMessageStatusReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Seq");
    long l = paramMessageRead.getU64("GroupId");
    int j = paramMessageRead.getU32("Status");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Messages");
    CGroupMessageStatus[] arrayOfCGroupMessageStatus = new CGroupMessageStatus[arrayOfMessageRead.length];
    for (int k = 0; k < arrayOfMessageRead.length; k++)
      arrayOfCGroupMessageStatus[k] = read_CGroupMessageStatus(arrayOfMessageRead[k]);
    return new CGetGroupMessageStatusReplyMsg(i, l, j, arrayOfCGroupMessageStatus);
  }

  static CGetInviteLinksReplyMsg read_CGetInviteLinksReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Seq");
    int j = paramMessageRead.getU32("Status");
    String str = paramMessageRead.getString("GroupInviteLink");
    HashMap localHashMap = new HashMap();
    MessageRead.MapStringToStringData localMapStringToStringData = paramMessageRead.getMapStringToString("InviteLinks");
    int k = localMapStringToStringData.keys.length;
    for (int m = 0; m < k; m++)
      localHashMap.put(localMapStringToStringData.keys[m], localMapStringToStringData.values[m]);
    return new CGetInviteLinksReplyMsg(i, j, str, localHashMap);
  }

  static CGetLastOnlineReplyMsg read_CGetLastOnlineReplyMsg(MessageRead paramMessageRead)
  {
    HashMap localHashMap = new HashMap();
    MessageRead.MapStringToMessageData localMapStringToMessageData = paramMessageRead.getMapStringToMessage("LastOnlineData");
    int i = localMapStringToMessageData.keys.length;
    for (int j = 0; j < i; j++)
      localHashMap.put(localMapStringToMessageData.keys[j], read_OnlineData(new MessageRead(localMapStringToMessageData.values[j], true)));
    return new CGetLastOnlineReplyMsg(localHashMap, paramMessageRead.getU32("Seq"), Integer.valueOf(0xFF & paramMessageRead.getU8("Status")).intValue());
  }

  static CGetMyCommunitySettingsReplyMsg read_CGetMyCommunitySettingsReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetMyCommunitySettingsReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"), paramMessageRead.getString("Settings"));
  }

  static CGetPersonalDetailsReplyMsg read_CGetPersonalDetailsReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetPersonalDetailsReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"), paramMessageRead.getString("Email"), paramMessageRead.getU32("EmailFlags"));
  }

  static CGetPersonalProfileReplyMsg read_CGetPersonalProfileReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetPersonalProfileReplyMsg(0xFF & paramMessageRead.getU8("status"), paramMessageRead.getS32("recallAfter"), paramMessageRead.getString("stickerClusterId"));
  }

  static CGetPublicAccountInfoReplyMsg read_CGetPublicAccountInfoReplyMsg(MessageRead paramMessageRead)
  {
    int i = 0xFF & paramMessageRead.getU8("Status");
    int j = paramMessageRead.getU32("Seq");
    long l = paramMessageRead.getU64("PublicChatId");
    String str1 = paramMessageRead.getString("PublicAccountID");
    int k = 0xFF & paramMessageRead.getU8("GroupType");
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("Members");
    ChatUserInfo[] arrayOfChatUserInfo = new ChatUserInfo[arrayOfMessageRead1.length];
    for (int m = 0; m < arrayOfMessageRead1.length; m++)
      arrayOfChatUserInfo[m] = read_ChatUserInfo(arrayOfMessageRead1[m]);
    byte b = paramMessageRead.getU8("UserRole");
    short s = paramMessageRead.getU16("UserFlags");
    int n = paramMessageRead.getU32("WatchersCount");
    int i1 = paramMessageRead.getU32("SubscribersCount");
    int i2 = paramMessageRead.getU32("LastMsgSeqID");
    int i3 = paramMessageRead.getU32("Revision");
    String str2 = paramMessageRead.getString("GroupName");
    String str3 = paramMessageRead.getString("GroupUri");
    String str4 = paramMessageRead.getString("IconDownloadID");
    String str5 = paramMessageRead.getString("BackgroundDownloadID");
    String str6 = paramMessageRead.getString("TagLine");
    String[] arrayOfString = paramMessageRead.getStringArray("Tags");
    Location localLocation = read_Location(paramMessageRead.getMessage("location"));
    String str7 = paramMessageRead.getString("Country");
    int i4 = paramMessageRead.getU32("GroupFlags");
    String str8 = paramMessageRead.getString("Category");
    String str9 = paramMessageRead.getString("SubCategory");
    String str10 = paramMessageRead.getString("AuthToken");
    boolean bool = paramMessageRead.getBoolean("WebhookExists");
    String str11 = paramMessageRead.getString("website");
    String str12 = paramMessageRead.getString("email");
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("jokerButtons");
    JokerButton[] arrayOfJokerButton = new JokerButton[arrayOfMessageRead2.length];
    for (int i5 = 0; i5 < arrayOfMessageRead2.length; i5++)
      arrayOfJokerButton[i5] = read_JokerButton(arrayOfMessageRead2[i5]);
    String str13 = paramMessageRead.getString("crmName");
    MessageRead[] arrayOfMessageRead3 = paramMessageRead.getMessageArray("PinsInfo");
    PinInfo[] arrayOfPinInfo = new PinInfo[arrayOfMessageRead3.length];
    for (int i6 = 0; i6 < arrayOfMessageRead3.length; i6++)
      arrayOfPinInfo[i6] = read_PinInfo(arrayOfMessageRead3[i6]);
    String str14 = paramMessageRead.getString("InvitationLink");
    MessageRead[] arrayOfMessageRead4 = paramMessageRead.getMessageArray("deleteAllUserMessagesInfos");
    DeleteAllUserMessagesInfo[] arrayOfDeleteAllUserMessagesInfo = new DeleteAllUserMessagesInfo[arrayOfMessageRead4.length];
    for (int i7 = 0; i7 < arrayOfMessageRead4.length; i7++)
      arrayOfDeleteAllUserMessagesInfo[i7] = read_DeleteAllUserMessagesInfo(arrayOfMessageRead4[i7]);
    String str15 = paramMessageRead.getString("Group2AccessToken");
    Integer localInteger1 = Integer.valueOf(0xFF & paramMessageRead.getU8("DisplayInvitationLink"));
    Long localLong = Long.valueOf(paramMessageRead.getU64("CommunityPrivileges"));
    Integer localInteger2 = Integer.valueOf(paramMessageRead.getU32("ChunkID"));
    Boolean localBoolean = Boolean.valueOf(paramMessageRead.getBoolean("LastMsg"));
    String str16 = paramMessageRead.getString("ChatBackground");
    return new CGetPublicAccountInfoReplyMsg(i, j, l, str1, k, arrayOfChatUserInfo, b, s, n, i1, i2, i3, str2, str3, str4, str5, str6, arrayOfString, localLocation, str7, i4, str8, str9, str10, bool, str11, str12, arrayOfJokerButton, str13, arrayOfPinInfo, str14, arrayOfDeleteAllUserMessagesInfo, str15, localInteger1.intValue(), localLong.longValue(), localInteger2.intValue(), localBoolean.booleanValue(), str16);
  }

  static CGetPublicGroupInfoReplyMsg read_CGetPublicGroupInfoReplyMsg(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("GroupID");
    byte b = paramMessageRead.getU8("GroupType");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    PublicGroupUserInfo[] arrayOfPublicGroupUserInfo = new PublicGroupUserInfo[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfPublicGroupUserInfo[i] = read_PublicGroupUserInfo(arrayOfMessageRead[i]);
    return new CGetPublicGroupInfoReplyMsg(l, b, arrayOfPublicGroupUserInfo, paramMessageRead.getU8("GroupRole"), paramMessageRead.getU32("WatchersCount"), paramMessageRead.getU32("MessageID"), 0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU32("Seq"), paramMessageRead.getU8("Flags"), read_CGroupAttributesChanged(paramMessageRead.getMessage("GroupAttributes")), Short.valueOf(paramMessageRead.getU16("GroupFlags")).shortValue());
  }

  static CGetSecondaryDeviceDetailsReplyMsg read_CGetSecondaryDeviceDetailsReplyMsg(MessageRead paramMessageRead)
  {
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("devices");
    CSecondaryDeviceDetailsElement[] arrayOfCSecondaryDeviceDetailsElement = new CSecondaryDeviceDetailsElement[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfCSecondaryDeviceDetailsElement[i] = read_CSecondaryDeviceDetailsElement(arrayOfMessageRead[i]);
    return new CGetSecondaryDeviceDetailsReplyMsg(arrayOfCSecondaryDeviceDetailsElement, Integer.valueOf(paramMessageRead.getU32("Status")).intValue());
  }

  static CGetUserActivityReplyMsg read_CGetUserActivityReplyMsg(MessageRead paramMessageRead)
  {
    HashMap localHashMap = new HashMap();
    MessageRead.MapStringToNumberData localMapStringToNumberData = paramMessageRead.getMapStringToNumber("UserActivityData", 1);
    int i = localMapStringToNumberData.keys.length;
    for (int j = 0; j < i; j++)
      localHashMap.put(localMapStringToNumberData.keys[j], Short.valueOf((short)(int)localMapStringToNumberData.values[j]));
    return new CGetUserActivityReplyMsg(localHashMap, paramMessageRead.getU32("Seq"));
  }

  static CGetUserAppsReplyMsg read_CGetUserAppsReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetUserAppsReplyMsg(paramMessageRead.getU16Array("Apps"), paramMessageRead.getU32("Seq"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CGetUserDateOfBirthReplyMsg read_CGetUserDateOfBirthReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetUserDateOfBirthReplyMsg(paramMessageRead.getU8("Day"), paramMessageRead.getU8("Month"), paramMessageRead.getU16("Year"), paramMessageRead.getU32("Seq"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CGetUserDetailsV2 read_CGetUserDetailsV2(MessageRead paramMessageRead)
  {
    return new CGetUserDetailsV2(paramMessageRead.getString("PhoneNumber"), paramMessageRead.getString("MID"), paramMessageRead.getString("VID"), paramMessageRead.getString("DownloadID"), paramMessageRead.getString("Name"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreInfo")), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CGetUsersDetailsV2ReplyMsg read_CGetUsersDetailsV2ReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Status");
    int j = paramMessageRead.getU32("Seq");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("UsersDetails");
    CGetUserDetailsV2[] arrayOfCGetUserDetailsV2 = new CGetUserDetailsV2[arrayOfMessageRead.length];
    for (int k = 0; k < arrayOfMessageRead.length; k++)
      arrayOfCGetUserDetailsV2[k] = read_CGetUserDetailsV2(arrayOfMessageRead[k]);
    return new CGetUsersDetailsV2ReplyMsg(i, j, arrayOfCGetUserDetailsV2, 0xFF & paramMessageRead.getU8("InputType"));
  }

  static CGetViberIdReplyMsg read_CGetViberIdReplyMsg(MessageRead paramMessageRead)
  {
    return new CGetViberIdReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"), paramMessageRead.getU32("Version"), paramMessageRead.getU32("Flags"), paramMessageRead.getString("Email"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreUserInfo")));
  }

  static CGroupAddMemberReplyMsg read_CGroupAddMemberReplyMsg(MessageRead paramMessageRead)
  {
    return new CGroupAddMemberReplyMsg(paramMessageRead.getU64("GroupID"), paramMessageRead.getString("ClientPhone"), 0xFF & paramMessageRead.getU8("Status"), Long.valueOf(paramMessageRead.getU64("MessageToken")).longValue());
  }

  static CGroupAddMembersReplyMsg read_CGroupAddMembersReplyMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("GroupID");
    int i = paramMessageRead.getU32("Seq");
    int j = 0xFF & paramMessageRead.getU8("Status");
    long l2 = paramMessageRead.getU64("MessageToken");
    int k = paramMessageRead.getU32("GroupRevision");
    int m = paramMessageRead.getU32("SeqInPG");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    GroupMemberActionStatus[] arrayOfGroupMemberActionStatus = new GroupMemberActionStatus[arrayOfMessageRead.length];
    for (int n = 0; n < arrayOfMessageRead.length; n++)
      arrayOfGroupMemberActionStatus[n] = read_GroupMemberActionStatus(arrayOfMessageRead[n]);
    return new CGroupAddMembersReplyMsg(l1, i, j, l2, k, m, arrayOfGroupMemberActionStatus);
  }

  static CGroupAddWatchersReplyMsg read_CGroupAddWatchersReplyMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("GroupID");
    int i = paramMessageRead.getU32("Seq");
    int j = 0xFF & paramMessageRead.getU8("Status");
    long l2 = paramMessageRead.getU64("MessageToken");
    boolean bool = paramMessageRead.getBoolean("IsJoinReply");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Watchers");
    GroupAddWatchersStatus[] arrayOfGroupAddWatchersStatus = new GroupAddWatchersStatus[arrayOfMessageRead.length];
    for (int k = 0; k < arrayOfMessageRead.length; k++)
      arrayOfGroupAddWatchersStatus[k] = read_GroupAddWatchersStatus(arrayOfMessageRead[k]);
    return new CGroupAddWatchersReplyMsg(l1, i, j, l2, bool, arrayOfGroupAddWatchersStatus, paramMessageRead.getString("Group2AccessToken"));
  }

  static CGroupAssignRoleReplyMsg read_CGroupAssignRoleReplyMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("GroupID");
    int i = paramMessageRead.getU32("Seq");
    int j = 0xFF & paramMessageRead.getU8("Status");
    int k = paramMessageRead.getU32("Role");
    long l2 = paramMessageRead.getU64("MessageToken");
    int m = paramMessageRead.getU32("GroupRevision");
    int n = paramMessageRead.getU32("SeqInPG");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    GroupMemberActionStatus[] arrayOfGroupMemberActionStatus = new GroupMemberActionStatus[arrayOfMessageRead.length];
    for (int i1 = 0; i1 < arrayOfMessageRead.length; i1++)
      arrayOfGroupMemberActionStatus[i1] = read_GroupMemberActionStatus(arrayOfMessageRead[i1]);
    return new CGroupAssignRoleReplyMsg(l1, i, j, k, l2, m, n, arrayOfGroupMemberActionStatus);
  }

  static CGroupAttributesChanged read_CGroupAttributesChanged(MessageRead paramMessageRead)
  {
    return new CGroupAttributesChanged(paramMessageRead.getString("GroupName"), paramMessageRead.getString("GroupUri"), paramMessageRead.getString("IconDownloadID"), paramMessageRead.getString("BackgroundDownloadID"), paramMessageRead.getString("TagLine"), paramMessageRead.getStringArray("Tags"), read_Location(paramMessageRead.getMessage("location")), paramMessageRead.getString("Country"), paramMessageRead.getU32("GroupType"), paramMessageRead.getU32("Revision"), 0xFFFF & paramMessageRead.getU16("Flags"));
  }

  static CGroupBanUserReplyMsg read_CGroupBanUserReplyMsg(MessageRead paramMessageRead)
  {
    return new CGroupBanUserReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"), paramMessageRead.getU64("MessageToken"), paramMessageRead.getU32("GroupRevision"), paramMessageRead.getU32("NumWatchers"));
  }

  static CGroupChangedMsg read_CGroupChangedMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("GroupID");
    long l2 = paramMessageRead.getU64("MessageToken");
    long l3 = paramMessageRead.getU64("TimeChanged");
    int i = paramMessageRead.getU32("Flags");
    String str1 = paramMessageRead.getString("OriginPhoneNumber");
    int j = paramMessageRead.getU32("MessageType");
    String str2 = paramMessageRead.getString("ClientName");
    String str3 = paramMessageRead.getString("GroupName");
    String str4 = paramMessageRead.getString("GroupOldName");
    CGroupAttributesChanged localCGroupAttributesChanged = read_CGroupAttributesChanged(paramMessageRead.getMessage("ChangedAttributes"));
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("Members");
    GroupUserChanged[] arrayOfGroupUserChanged = new GroupUserChanged[arrayOfMessageRead1.length];
    for (int k = 0; k < arrayOfMessageRead1.length; k++)
      arrayOfGroupUserChanged[k] = read_GroupUserChanged(arrayOfMessageRead1[k]);
    Integer localInteger1 = Integer.valueOf(paramMessageRead.getU32("SeqInPG"));
    Integer localInteger2 = Integer.valueOf(0xFF & paramMessageRead.getU8("GroupType"));
    Integer localInteger3 = Integer.valueOf(paramMessageRead.getU32("PgAndSearchFlags"));
    String str5 = paramMessageRead.getString("paCategory");
    String str6 = paramMessageRead.getString("paSubCategory");
    Byte localByte1 = Byte.valueOf(paramMessageRead.getU8("webHookExists"));
    String str7 = paramMessageRead.getString("crmName");
    String str8 = paramMessageRead.getString("website");
    String str9 = paramMessageRead.getString("email");
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("jokerButtons");
    JokerButton[] arrayOfJokerButton = new JokerButton[arrayOfMessageRead2.length];
    for (int m = 0; m < arrayOfMessageRead2.length; m++)
      arrayOfJokerButton[m] = read_JokerButton(arrayOfMessageRead2[m]);
    String str10 = paramMessageRead.getString("authenticationToken");
    Byte localByte2 = Byte.valueOf(paramMessageRead.getU8("isSubscribed"));
    MessageRead[] arrayOfMessageRead3 = paramMessageRead.getMessageArray("Group2Members");
    Group2UserChanged[] arrayOfGroup2UserChanged = new Group2UserChanged[arrayOfMessageRead3.length];
    for (int n = 0; n < arrayOfMessageRead3.length; n++)
      arrayOfGroup2UserChanged[n] = read_Group2UserChanged(arrayOfMessageRead3[n]);
    String str11 = paramMessageRead.getString("Group2AccessToken");
    Integer localInteger4 = Integer.valueOf(0xFF & paramMessageRead.getU8("DisplayInvitationLink"));
    Integer localInteger5 = Integer.valueOf(paramMessageRead.getU32("NumWatchers"));
    Integer localInteger6 = Integer.valueOf(paramMessageRead.getU32("AttributeChangeType"));
    String str12 = paramMessageRead.getString("ChatBackground");
    return new CGroupChangedMsg(l1, l2, l3, i, str1, j, str2, str3, str4, localCGroupAttributesChanged, arrayOfGroupUserChanged, localInteger1.intValue(), localInteger2.intValue(), localInteger3.intValue(), str5, str6, localByte1.byteValue(), str7, str8, str9, arrayOfJokerButton, str10, localByte2.byteValue(), arrayOfGroup2UserChanged, str11, localInteger4.intValue(), localInteger5.intValue(), localInteger6.intValue(), str12);
  }

  static CGroupLeaveReplyMsg read_CGroupLeaveReplyMsg(MessageRead paramMessageRead)
  {
    return new CGroupLeaveReplyMsg(paramMessageRead.getU64("GroupID"), 0xFF & paramMessageRead.getU8("Status"), Long.valueOf(paramMessageRead.getU64("MessageToken")).longValue());
  }

  static CGroupMessageLike read_CGroupMessageLike(MessageRead paramMessageRead)
  {
    return new CGroupMessageLike(paramMessageRead.getU64("GroupId"), paramMessageRead.getU64("LikeToken"), paramMessageRead.getU64("MessageToken"), paramMessageRead.getString("LikeSenderPhoneNumber"), paramMessageRead.getU32("Flags"), paramMessageRead.getBoolean("Action"), paramMessageRead.getU64("TimeSent"));
  }

  static CGroupMessageReceivedMsg read_CGroupMessageReceivedMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("GroupID");
    String str1 = paramMessageRead.getString("GroupName");
    long l2 = paramMessageRead.getU64("MessageToken");
    String str2 = paramMessageRead.getString("OriginPhoneNumber");
    String str3 = paramMessageRead.getString("Text");
    long l3 = paramMessageRead.getU64("TimeSent");
    int i = paramMessageRead.getU32("Flags");
    int j = paramMessageRead.getU32("MessageSeq");
    String str4 = paramMessageRead.getString("ClientName");
    Long localLong = Long.valueOf(paramMessageRead.getU64("ServerTime"));
    Location localLocation = read_Location(paramMessageRead.getMessage("location"));
    Integer localInteger1 = Integer.valueOf(0xFF & paramMessageRead.getU8("mediaType"));
    String str5 = paramMessageRead.getString("BucketName");
    String str6 = paramMessageRead.getString("DownloadID");
    byte[] arrayOfByte = paramMessageRead.getU8Array("Thumbnail");
    Integer localInteger2 = Integer.valueOf(paramMessageRead.getU32("Duration"));
    Integer localInteger3 = Integer.valueOf(paramMessageRead.getU32("UploadDuration"));
    String str7 = paramMessageRead.getString("MsgInfo");
    Integer localInteger4 = Integer.valueOf(paramMessageRead.getU32("SeqInPG"));
    Integer localInteger5 = Integer.valueOf(0xFFFF & paramMessageRead.getU16("ChatType"));
    Integer localInteger6 = Integer.valueOf(paramMessageRead.getU32("TimebombInSec"));
    Integer localInteger7 = Integer.valueOf(0xFF & paramMessageRead.getU8("GroupType"));
    String str8 = paramMessageRead.getString("Group2AccessToken");
    return new CGroupMessageReceivedMsg(l1, str1, l2, str2, str3, l3, i, j, str4, localLong.longValue(), localLocation, localInteger1.intValue(), str5, str6, arrayOfByte, localInteger2.intValue(), localInteger3.intValue(), str7, localInteger4.intValue(), localInteger5.intValue(), localInteger6.intValue(), localInteger7.intValue(), str8);
  }

  static CGroupMessageStatus read_CGroupMessageStatus(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("Token");
    int i = paramMessageRead.getU32("Status");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Users");
    CReadData[] arrayOfCReadData = new CReadData[arrayOfMessageRead.length];
    for (int j = 0; j < arrayOfMessageRead.length; j++)
      arrayOfCReadData[j] = read_CReadData(arrayOfMessageRead[j]);
    return new CGroupMessageStatus(l, i, arrayOfCReadData);
  }

  static CGroupRemoveMembersReplyMsg read_CGroupRemoveMembersReplyMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("GroupID");
    int i = paramMessageRead.getU32("Seq");
    int j = 0xFF & paramMessageRead.getU8("Status");
    long l2 = paramMessageRead.getU64("MessageToken");
    int k = paramMessageRead.getU32("GroupRevision");
    int m = paramMessageRead.getU32("SeqInPG");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    GroupMemberActionStatus[] arrayOfGroupMemberActionStatus = new GroupMemberActionStatus[arrayOfMessageRead.length];
    for (int n = 0; n < arrayOfMessageRead.length; n++)
      arrayOfGroupMemberActionStatus[n] = read_GroupMemberActionStatus(arrayOfMessageRead[n]);
    return new CGroupRemoveMembersReplyMsg(l1, i, j, l2, k, m, arrayOfGroupMemberActionStatus, Integer.valueOf(paramMessageRead.getU32("NumWatchers")).intValue());
  }

  static CGroupSynchedMsg read_CGroupSynchedMsg(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("GroupID");
    int i = paramMessageRead.getU32("Flags");
    Long localLong = Long.valueOf(paramMessageRead.getU64("LastMessageToken"));
    Integer localInteger = Integer.valueOf(paramMessageRead.getU32("SeqInPG"));
    return new CGroupSynchedMsg(l, i, localLong.longValue(), localInteger.intValue());
  }

  static CInviteToConferenceReplyMsg read_CInviteToConferenceReplyMsg(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("CallToken");
    int i = paramMessageRead.getU32("Status");
    String str = paramMessageRead.getString("Attachment");
    HashMap localHashMap = new HashMap();
    MessageRead.MapStringToNumberData localMapStringToNumberData = paramMessageRead.getMapStringToNumber("MemberStatus", 2);
    int j = localMapStringToNumberData.keys.length;
    for (int k = 0; k < j; k++)
      localHashMap.put(localMapStringToNumberData.keys[k], Integer.valueOf((int)localMapStringToNumberData.values[k]));
    return new CInviteToConferenceReplyMsg(l, i, str, localHashMap, paramMessageRead.getU32("Seq"));
  }

  static CIsOnlineReplyMsg read_CIsOnlineReplyMsg(MessageRead paramMessageRead)
  {
    return new CIsOnlineReplyMsg(paramMessageRead.getString("PhoneNumber"), paramMessageRead.getBoolean("Online"));
  }

  static CIsRegisteredNumberReplyMsg read_CIsRegisteredNumberReplyMsg(MessageRead paramMessageRead)
  {
    return new CIsRegisteredNumberReplyMsg(paramMessageRead.getString("ToNumber"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CJoinConfCallReplyMsg read_CJoinConfCallReplyMsg(MessageRead paramMessageRead)
  {
    return new CJoinConfCallReplyMsg(paramMessageRead.getU32("Status"), paramMessageRead.getU64("CallToken"), paramMessageRead.getU8Array("CompressedSdpAnswer"), paramMessageRead.getString("Attachment"), paramMessageRead.getString("ConfID"), paramMessageRead.getU32("Seq"));
  }

  static CLateErrorOnReceivedMessageReplyMsg read_CLateErrorOnReceivedMessageReplyMsg(MessageRead paramMessageRead)
  {
    return new CLateErrorOnReceivedMessageReplyMsg(paramMessageRead.getU32("Sequence"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CLikeGroupMessageReply read_CLikeGroupMessageReply(MessageRead paramMessageRead)
  {
    return new CLikeGroupMessageReply(paramMessageRead.getU64("LikeToken"), paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"));
  }

  static CLoginReplyMsg read_CLoginReplyMsg(MessageRead paramMessageRead)
  {
    int i = 0xFFFF & paramMessageRead.getU16("LoginStatus");
    Integer localInteger1 = Integer.valueOf(0xFF & paramMessageRead.getU8("VOGroup"));
    Integer localInteger2 = Integer.valueOf(0xFF & paramMessageRead.getU8("Flags"));
    String str1 = paramMessageRead.getString("NewNumber");
    String str2 = paramMessageRead.getString("EncryptedPhoneNumber");
    CMediaUrlFormatters localCMediaUrlFormatters = read_CMediaUrlFormatters(paramMessageRead.getMessage("MediaUrlFormatters"));
    String str3 = paramMessageRead.getString("PGEncryptedPhoneNumber");
    Integer localInteger3 = Integer.valueOf(paramMessageRead.getU32("ExtFlags"));
    Integer localInteger4 = Integer.valueOf(0xFFFF & paramMessageRead.getU16("SuggestUpgradeState"));
    Integer localInteger5 = Integer.valueOf(paramMessageRead.getU32("RecommendedVersion"));
    String str4 = paramMessageRead.getString("MemberId");
    String str5 = paramMessageRead.getString("ClientConfiguration");
    String str6 = paramMessageRead.getString("SpammerBlockStatus");
    Boolean localBoolean1 = Boolean.valueOf(paramMessageRead.getBoolean("HasDesktop"));
    Integer localInteger6 = Integer.valueOf(paramMessageRead.getU32("ViberIdVersion"));
    String str7 = paramMessageRead.getString("EncryptedMemberID");
    Boolean localBoolean2 = Boolean.valueOf(paramMessageRead.getBoolean("VlnSubscription"));
    return new CLoginReplyMsg(i, localInteger1.intValue(), localInteger2.intValue(), str1, str2, localCMediaUrlFormatters, str3, localInteger3.intValue(), localInteger4.intValue(), localInteger5.intValue(), str4, str5, str6, localBoolean1.booleanValue(), localInteger6.intValue(), str7, localBoolean2.booleanValue());
  }

  static CMediaUrlFormatters read_CMediaUrlFormatters(MessageRead paramMessageRead)
  {
    return new CMediaUrlFormatters(paramMessageRead.getString("DownloadUrl"), paramMessageRead.getString("UnblockerDownloadUrl"), paramMessageRead.getString("DownloadPhotoUrl"), paramMessageRead.getString("UnblockerDownloadPhotoUrl"), paramMessageRead.getString("DownloadPgUrl"), paramMessageRead.getString("UnblockerDownloadPgUrl"));
  }

  static CMessageDeliveredMsg read_CMessageDeliveredMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("MessageToken");
    long l2 = paramMessageRead.getU64("TimeDelivered");
    Integer localInteger1 = Integer.valueOf(paramMessageRead.getU32("MessageSeq"));
    Integer localInteger2 = Integer.valueOf(paramMessageRead.getU32("Flags"));
    String str = paramMessageRead.getString("FromCanonizedNumber");
    Integer localInteger3 = Integer.valueOf(paramMessageRead.getU32("SeqInPG"));
    return new CMessageDeliveredMsg(l1, l2, localInteger1.intValue(), localInteger2.intValue(), str, localInteger3.intValue());
  }

  static CMessageReceivedMsg read_CMessageReceivedMsg(MessageRead paramMessageRead)
  {
    String str1 = paramMessageRead.getString("OriginPhoneNumber");
    long l1 = paramMessageRead.getU64("MessageToken");
    String str2 = paramMessageRead.getString("Text");
    long l2 = paramMessageRead.getU64("TimeSent");
    int i = paramMessageRead.getU32("Flags");
    Integer localInteger1 = Integer.valueOf(paramMessageRead.getU32("MessageSeq"));
    Location localLocation = read_Location(paramMessageRead.getMessage("location"));
    Integer localInteger2 = Integer.valueOf(0xFF & paramMessageRead.getU8("mediaType"));
    String str3 = paramMessageRead.getString("BucketName");
    String str4 = paramMessageRead.getString("DownloadID");
    byte[] arrayOfByte = paramMessageRead.getU8Array("Thumbnail");
    String str5 = paramMessageRead.getString("ClientName");
    Long localLong = Long.valueOf(paramMessageRead.getU64("ServerTime"));
    Integer localInteger3 = Integer.valueOf(paramMessageRead.getU32("Duration"));
    Integer localInteger4 = Integer.valueOf(paramMessageRead.getU32("UploadDuration"));
    String str6 = paramMessageRead.getString("MsgInfo");
    Integer localInteger5 = Integer.valueOf(0xFFFF & paramMessageRead.getU16("ChatType"));
    Integer localInteger6 = Integer.valueOf(paramMessageRead.getU32("TimebombInSec"));
    String str7 = paramMessageRead.getString("ToVLN");
    String str8 = paramMessageRead.getString("PeerEMID");
    return new CMessageReceivedMsg(str1, l1, str2, l2, i, localInteger1.intValue(), localLocation, localInteger2.intValue(), str3, str4, arrayOfByte, str5, localLong.longValue(), localInteger3.intValue(), localInteger4.intValue(), str6, localInteger5.intValue(), localInteger6.intValue(), str7, str8);
  }

  static CMessageReceivedReplyableAckReplyMsg read_CMessageReceivedReplyableAckReplyMsg(MessageRead paramMessageRead)
  {
    return new CMessageReceivedReplyableAckReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("MessageToken"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CMessagesSynchedMsg read_CMessagesSynchedMsg(MessageRead paramMessageRead)
  {
    int i = 0;
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("ReadConversationTokens");
    ConversationToken[] arrayOfConversationToken1 = new ConversationToken[arrayOfMessageRead1.length];
    for (int j = 0; j < arrayOfMessageRead1.length; j++)
      arrayOfConversationToken1[j] = read_ConversationToken(arrayOfMessageRead1[j]);
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("DeletedConversationTokens");
    ConversationToken[] arrayOfConversationToken2 = new ConversationToken[arrayOfMessageRead2.length];
    for (int k = 0; k < arrayOfMessageRead2.length; k++)
      arrayOfConversationToken2[k] = read_ConversationToken(arrayOfMessageRead2[k]);
    MessageRead[] arrayOfMessageRead3 = paramMessageRead.getMessageArray("ReadGroupTokens");
    GroupToken[] arrayOfGroupToken1 = new GroupToken[arrayOfMessageRead3.length];
    for (int m = 0; m < arrayOfMessageRead3.length; m++)
      arrayOfGroupToken1[m] = read_GroupToken(arrayOfMessageRead3[m]);
    MessageRead[] arrayOfMessageRead4 = paramMessageRead.getMessageArray("DeletedGroupTokens");
    GroupToken[] arrayOfGroupToken2 = new GroupToken[arrayOfMessageRead4.length];
    while (i < arrayOfMessageRead4.length)
    {
      arrayOfGroupToken2[i] = read_GroupToken(arrayOfMessageRead4[i]);
      i++;
    }
    return new CMessagesSynchedMsg(arrayOfConversationToken1, arrayOfConversationToken2, arrayOfGroupToken1, arrayOfGroupToken2);
  }

  static CMoreUserInfo read_CMoreUserInfo(MessageRead paramMessageRead)
  {
    HashMap localHashMap = new HashMap();
    MessageRead.MapNumberToStringData localMapNumberToStringData = paramMessageRead.getMapNumberToString("data", 2);
    int i = localMapNumberToStringData.keys.length;
    for (int j = 0; j < i; j++)
      localHashMap.put(Integer.valueOf((int)localMapNumberToStringData.keys[j]), localMapNumberToStringData.values[j]);
    return new CMoreUserInfo(localHashMap);
  }

  static COnClickReplyMsg read_COnClickReplyMsg(MessageRead paramMessageRead)
  {
    return new COnClickReplyMsg(paramMessageRead.getU32("Seq"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CPGChangeReceivedMsg read_CPGChangeReceivedMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("GroupID");
    String str1 = paramMessageRead.getString("GroupName");
    String str2 = paramMessageRead.getString("ClientName");
    String str3 = paramMessageRead.getString("EncryptedPhone");
    long l2 = paramMessageRead.getU64("Timesent");
    int i = paramMessageRead.getU32("Revision");
    long l3 = paramMessageRead.getU64("Token");
    int j = paramMessageRead.getU32("SeqInPG");
    short s = paramMessageRead.getU16("Flags");
    int k = 0xFF & paramMessageRead.getU8("MsgType");
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("Members");
    GroupUserChanged[] arrayOfGroupUserChanged = new GroupUserChanged[arrayOfMessageRead1.length];
    for (int m = 0; m < arrayOfMessageRead1.length; m++)
      arrayOfGroupUserChanged[m] = read_GroupUserChanged(arrayOfMessageRead1[m]);
    CGroupAttributesChanged localCGroupAttributesChanged = read_CGroupAttributesChanged(paramMessageRead.getMessage("Attributes"));
    int n = paramMessageRead.getU32("NumWatchers");
    Integer localInteger1 = Integer.valueOf(paramMessageRead.getU32("PgAndSearchFlags"));
    String str4 = paramMessageRead.getString("paCategory");
    String str5 = paramMessageRead.getString("paSubCategory");
    Byte localByte1 = Byte.valueOf(paramMessageRead.getU8("webHookExists"));
    String str6 = paramMessageRead.getString("crmName");
    String str7 = paramMessageRead.getString("website");
    String str8 = paramMessageRead.getString("email");
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("jokerButtons");
    JokerButton[] arrayOfJokerButton = new JokerButton[arrayOfMessageRead2.length];
    for (int i1 = 0; i1 < arrayOfMessageRead2.length; i1++)
      arrayOfJokerButton[i1] = read_JokerButton(arrayOfMessageRead2[i1]);
    String str9 = paramMessageRead.getString("authenticationToken");
    Byte localByte2 = Byte.valueOf(paramMessageRead.getU8("isSubscribed"));
    Integer localInteger2 = Integer.valueOf(0xFF & paramMessageRead.getU8("GroupType"));
    MessageRead[] arrayOfMessageRead3 = paramMessageRead.getMessageArray("Group2Members");
    Group2UserChanged[] arrayOfGroup2UserChanged = new Group2UserChanged[arrayOfMessageRead3.length];
    for (int i2 = 0; i2 < arrayOfMessageRead3.length; i2++)
      arrayOfGroup2UserChanged[i2] = read_Group2UserChanged(arrayOfMessageRead3[i2]);
    String str10 = paramMessageRead.getString("Group2AccessToken");
    Integer localInteger3 = Integer.valueOf(0xFF & paramMessageRead.getU8("DisplayInvitationLink"));
    Long localLong = Long.valueOf(paramMessageRead.getU64("CommunityPrivileges"));
    Integer localInteger4 = Integer.valueOf(paramMessageRead.getU32("AttributeChangeType"));
    String str11 = paramMessageRead.getString("ChatBackground");
    return new CPGChangeReceivedMsg(l1, str1, str2, str3, l2, i, l3, j, s, k, arrayOfGroupUserChanged, localCGroupAttributesChanged, n, localInteger1.intValue(), str4, str5, localByte1.byteValue(), str6, str7, str8, arrayOfJokerButton, str9, localByte2.byteValue(), localInteger2.intValue(), arrayOfGroup2UserChanged, str10, localInteger3.intValue(), localLong.longValue(), localInteger4.intValue(), str11);
  }

  static CPGMessageReceivedMsg read_CPGMessageReceivedMsg(MessageRead paramMessageRead)
  {
    long l1 = paramMessageRead.getU64("GroupID");
    String str1 = paramMessageRead.getString("GroupName");
    long l2 = paramMessageRead.getU64("MessageToken");
    int i = paramMessageRead.getU32("SeqInPG");
    int j = paramMessageRead.getU32("Revision");
    String str2 = paramMessageRead.getString("EncryptedPhoneNumber");
    String str3 = paramMessageRead.getString("ClientName");
    String str4 = paramMessageRead.getString("Text");
    long l3 = paramMessageRead.getU64("TimeSent");
    int k = paramMessageRead.getU32("Flags");
    Location localLocation = read_Location(paramMessageRead.getMessage("location"));
    int m = 0xFF & paramMessageRead.getU8("mediaType");
    String str5 = paramMessageRead.getString("BucketName");
    String str6 = paramMessageRead.getString("DownloadID");
    byte[] arrayOfByte = paramMessageRead.getU8Array("Thumbnail");
    int n = paramMessageRead.getU32("Duration");
    int i1 = paramMessageRead.getU32("UploadDuration");
    String str7 = paramMessageRead.getString("MsgInfo");
    Integer localInteger = Integer.valueOf(0xFF & paramMessageRead.getU8("GroupType"));
    String str8 = paramMessageRead.getString("Group2AccessToken");
    String str9 = paramMessageRead.getString("SenderDownloadID");
    String str10 = paramMessageRead.getString("SenderName");
    return new CPGMessageReceivedMsg(l1, str1, l2, i, j, str2, str3, str4, l3, k, localLocation, m, str5, str6, arrayOfByte, n, i1, str7, localInteger.intValue(), str8, str9, str10);
  }

  static CPublicAccountSubscriberUpdateReplyMsg read_CPublicAccountSubscriberUpdateReplyMsg(MessageRead paramMessageRead)
  {
    return new CPublicAccountSubscriberUpdateReplyMsg(paramMessageRead.getU32("Seq"), 0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU64("MessageToken"), paramMessageRead.getU32("SubscriberOperation"));
  }

  static CQueryDestOperationSupportReplyMsg read_CQueryDestOperationSupportReplyMsg(MessageRead paramMessageRead)
  {
    return new CQueryDestOperationSupportReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"), paramMessageRead.getU32("Flags"));
  }

  static CReadData read_CReadData(MessageRead paramMessageRead)
  {
    return new CReadData(paramMessageRead.getString("PhoneNumber"), paramMessageRead.getU64("TimeSeen"));
  }

  static CRecoverGroupChatsReplyMsg read_CRecoverGroupChatsReplyMsg(MessageRead paramMessageRead)
  {
    int i = 0;
    int j = 0xFF & paramMessageRead.getU8("Status");
    int k = paramMessageRead.getU32("Seq");
    byte b = paramMessageRead.getU8("ChunkSeq");
    boolean bool = paramMessageRead.getBoolean("Last");
    HashMap localHashMap = new HashMap();
    MessageRead.MapStringToMessageData localMapStringToMessageData = paramMessageRead.getMapStringToMessage("Users");
    int m = localMapStringToMessageData.keys.length;
    for (int n = 0; n < m; n++)
      localHashMap.put(localMapStringToMessageData.keys[n], read_ChatUserInfo(new MessageRead(localMapStringToMessageData.values[n], true)));
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("GroupChats");
    RecoveredGroupChatInfo[] arrayOfRecoveredGroupChatInfo = new RecoveredGroupChatInfo[arrayOfMessageRead1.length];
    for (int i1 = 0; i1 < arrayOfMessageRead1.length; i1++)
      arrayOfRecoveredGroupChatInfo[i1] = read_RecoveredGroupChatInfo(arrayOfMessageRead1[i1]);
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("SecureGroupChats");
    RecoveredSecureGroupChatInfo[] arrayOfRecoveredSecureGroupChatInfo = new RecoveredSecureGroupChatInfo[arrayOfMessageRead2.length];
    while (i < arrayOfMessageRead2.length)
    {
      arrayOfRecoveredSecureGroupChatInfo[i] = read_RecoveredSecureGroupChatInfo(arrayOfMessageRead2[i]);
      i++;
    }
    return new CRecoverGroupChatsReplyMsg(j, k, b, bool, localHashMap, arrayOfRecoveredGroupChatInfo, arrayOfRecoveredSecureGroupChatInfo);
  }

  static CRecoverGroupsReplyMsg read_CRecoverGroupsReplyMsg(MessageRead paramMessageRead)
  {
    int i = 0;
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("Groups");
    RecoveredGroupInfo[] arrayOfRecoveredGroupInfo = new RecoveredGroupInfo[arrayOfMessageRead1.length];
    for (int j = 0; j < arrayOfMessageRead1.length; j++)
      arrayOfRecoveredGroupInfo[j] = read_RecoveredGroupInfo(arrayOfMessageRead1[j]);
    HashMap localHashMap1 = new HashMap();
    MessageRead.MapStringToMessageData localMapStringToMessageData = paramMessageRead.getMapStringToMessage("Users");
    int k = localMapStringToMessageData.keys.length;
    for (int m = 0; m < k; m++)
      localHashMap1.put(localMapStringToMessageData.keys[m], read_GroupUserInfo(new MessageRead(localMapStringToMessageData.values[m], true)));
    int n = 0xFF & paramMessageRead.getU8("Status");
    Integer localInteger = Integer.valueOf(paramMessageRead.getU32("Seq"));
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("PublicGroups");
    RecoveredPublicGroupInfo[] arrayOfRecoveredPublicGroupInfo = new RecoveredPublicGroupInfo[arrayOfMessageRead2.length];
    for (int i1 = 0; i1 < arrayOfMessageRead2.length; i1++)
      arrayOfRecoveredPublicGroupInfo[i1] = read_RecoveredPublicGroupInfo(arrayOfMessageRead2[i1]);
    HashMap localHashMap2 = new HashMap();
    MessageRead.MapStringToStringData localMapStringToStringData = paramMessageRead.getMapStringToString("Phone2Encrypted");
    int i2 = localMapStringToStringData.keys.length;
    for (int i3 = 0; i3 < i2; i3++)
      localHashMap2.put(localMapStringToStringData.keys[i3], localMapStringToStringData.values[i3]);
    Byte localByte = Byte.valueOf(paramMessageRead.getU8("ChunkSeq"));
    Boolean localBoolean = Boolean.valueOf(paramMessageRead.getBoolean("Last"));
    MessageRead[] arrayOfMessageRead3 = paramMessageRead.getMessageArray("GroupsEx");
    RecoveredGroupInfoEx[] arrayOfRecoveredGroupInfoEx = new RecoveredGroupInfoEx[arrayOfMessageRead3.length];
    for (int i4 = 0; i4 < arrayOfMessageRead3.length; i4++)
      arrayOfRecoveredGroupInfoEx[i4] = read_RecoveredGroupInfoEx(arrayOfMessageRead3[i4]);
    MessageRead[] arrayOfMessageRead4 = paramMessageRead.getMessageArray("SecureGroups");
    RecoveredSecureGroupInfo[] arrayOfRecoveredSecureGroupInfo = new RecoveredSecureGroupInfo[arrayOfMessageRead4.length];
    while (i < arrayOfMessageRead4.length)
    {
      arrayOfRecoveredSecureGroupInfo[i] = read_RecoveredSecureGroupInfo(arrayOfMessageRead4[i]);
      i++;
    }
    return new CRecoverGroupsReplyMsg(arrayOfRecoveredGroupInfo, localHashMap1, n, localInteger.intValue(), arrayOfRecoveredPublicGroupInfo, localHashMap2, localByte.byteValue(), localBoolean.booleanValue(), arrayOfRecoveredGroupInfoEx, arrayOfRecoveredSecureGroupInfo);
  }

  static CRecoverPublicAccountsReplyMsg read_CRecoverPublicAccountsReplyMsg(MessageRead paramMessageRead)
  {
    int i = 0;
    int j = 0xFF & paramMessageRead.getU8("Status");
    int k = paramMessageRead.getU32("Seq");
    byte b = paramMessageRead.getU8("ChunkSeq");
    boolean bool = paramMessageRead.getBoolean("Last");
    HashMap localHashMap = new HashMap();
    MessageRead.MapStringToMessageData localMapStringToMessageData = paramMessageRead.getMapStringToMessage("Users");
    int m = localMapStringToMessageData.keys.length;
    for (int n = 0; n < m; n++)
      localHashMap.put(localMapStringToMessageData.keys[n], read_ChatUserInfo(new MessageRead(localMapStringToMessageData.values[n], true)));
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("PublicAccounts");
    RecoveredPublicAccountInfo[] arrayOfRecoveredPublicAccountInfo = new RecoveredPublicAccountInfo[arrayOfMessageRead1.length];
    for (int i1 = 0; i1 < arrayOfMessageRead1.length; i1++)
      arrayOfRecoveredPublicAccountInfo[i1] = read_RecoveredPublicAccountInfo(arrayOfMessageRead1[i1]);
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("PublicAccountsMoreInfo");
    RecoveredPublicAccountMoreInfo[] arrayOfRecoveredPublicAccountMoreInfo = new RecoveredPublicAccountMoreInfo[arrayOfMessageRead2.length];
    for (int i2 = 0; i2 < arrayOfMessageRead2.length; i2++)
      arrayOfRecoveredPublicAccountMoreInfo[i2] = read_RecoveredPublicAccountMoreInfo(arrayOfMessageRead2[i2]);
    MessageRead[] arrayOfMessageRead3 = paramMessageRead.getMessageArray("PublicAccountsDeleteAllUsersMessages");
    RecoveredPublicAccountDeleteAllUsersMessages[] arrayOfRecoveredPublicAccountDeleteAllUsersMessages = new RecoveredPublicAccountDeleteAllUsersMessages[arrayOfMessageRead3.length];
    while (i < arrayOfMessageRead3.length)
    {
      arrayOfRecoveredPublicAccountDeleteAllUsersMessages[i] = read_RecoveredPublicAccountDeleteAllUsersMessages(arrayOfMessageRead3[i]);
      i++;
    }
    return new CRecoverPublicAccountsReplyMsg(j, k, b, bool, localHashMap, arrayOfRecoveredPublicAccountInfo, arrayOfRecoveredPublicAccountMoreInfo, arrayOfRecoveredPublicAccountDeleteAllUsersMessages);
  }

  static CRecvInternalMsg read_CRecvInternalMsg(MessageRead paramMessageRead)
  {
    return new CRecvInternalMsg(paramMessageRead.getU64("Token"), paramMessageRead.getString("SrcMID"), paramMessageRead.getU32("SrcCID"), paramMessageRead.getString("Data"));
  }

  static CRefreshPublicAccountTokenReplyMsg read_CRefreshPublicAccountTokenReplyMsg(MessageRead paramMessageRead)
  {
    return new CRefreshPublicAccountTokenReplyMsg(0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU32("Seq"), paramMessageRead.getString("PublicAccountID"), paramMessageRead.getString("AuthToken"));
  }

  static CRegisterViberIdReplyMsg read_CRegisterViberIdReplyMsg(MessageRead paramMessageRead)
  {
    return new CRegisterViberIdReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"), paramMessageRead.getU32("Version"));
  }

  static CRegisteredContactInfo read_CRegisteredContactInfo(MessageRead paramMessageRead)
  {
    return new CRegisteredContactInfo(paramMessageRead.getString("MID"), paramMessageRead.getString("VID"), paramMessageRead.getString("PhoneNumber"), paramMessageRead.getString("DownloadID"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreInfo")), paramMessageRead.getU32("Flags"));
  }

  static CRegisteredContactsMsg read_CRegisteredContactsMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Seq");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("RegisteredContacts");
    CRegisteredContactInfo[] arrayOfCRegisteredContactInfo = new CRegisteredContactInfo[arrayOfMessageRead.length];
    for (int j = 0; j < arrayOfMessageRead.length; j++)
      arrayOfCRegisteredContactInfo[j] = read_CRegisteredContactInfo(arrayOfMessageRead[j]);
    return new CRegisteredContactsMsg(i, arrayOfCRegisteredContactInfo, paramMessageRead.getU64("Token"), paramMessageRead.getU16("ABRevision"), paramMessageRead.getBoolean("ClearAll"), paramMessageRead.getBoolean("LastMsg"));
  }

  static CRevokeGroup2InviteReplyMsg read_CRevokeGroup2InviteReplyMsg(MessageRead paramMessageRead)
  {
    return new CRevokeGroup2InviteReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU32("Status"));
  }

  static CRevokeGroupInviteReplyMsg read_CRevokeGroupInviteReplyMsg(MessageRead paramMessageRead)
  {
    return new CRevokeGroupInviteReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU32("Status"));
  }

  static CSecondaryDeviceDetailsElement read_CSecondaryDeviceDetailsElement(MessageRead paramMessageRead)
  {
    return new CSecondaryDeviceDetailsElement(paramMessageRead.getString("OSName"), paramMessageRead.getString("OSVersion"), paramMessageRead.getString("ViberVersion"), paramMessageRead.getU32("System"), paramMessageRead.getString("SystemName"), paramMessageRead.getU64("LastLogin"), paramMessageRead.getString("Location"));
  }

  static CSecretChatReceivedEventMsg read_CSecretChatReceivedEventMsg(MessageRead paramMessageRead)
  {
    return new CSecretChatReceivedEventMsg(paramMessageRead.getString("MID"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU64("Token"), 0xFF & paramMessageRead.getU8("EventType"), paramMessageRead.getU32("TimebombInSec"), paramMessageRead.getU32("Flags"));
  }

  static CSecretChatSendEventReplyMsg read_CSecretChatSendEventReplyMsg(MessageRead paramMessageRead)
  {
    return new CSecretChatSendEventReplyMsg(0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU32("Seq"), paramMessageRead.getU64("Token"));
  }

  static CSecureSecondaryRegistrationFailureMsg read_CSecureSecondaryRegistrationFailureMsg(MessageRead paramMessageRead)
  {
    return new CSecureSecondaryRegistrationFailureMsg(paramMessageRead.getU64("Token"), paramMessageRead.getU32("Status"));
  }

  static CSendActionOnPGReplyMsg read_CSendActionOnPGReplyMsg(MessageRead paramMessageRead)
  {
    return new CSendActionOnPGReplyMsg(0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU64("GroupID"), paramMessageRead.getU64("MessageToken"), paramMessageRead.getU32("SeqInPG"), 0xFF & paramMessageRead.getU8("ClientAction"), paramMessageRead.getU32("Context"), paramMessageRead.getU64("ActionToken"));
  }

  static CSendActionToBotReplyMsg read_CSendActionToBotReplyMsg(MessageRead paramMessageRead)
  {
    return new CSendActionToBotReplyMsg(paramMessageRead.getString("PublicAccountId"), paramMessageRead.getU32("Seq"), paramMessageRead.getString("MsgInfo"), paramMessageRead.getU64("MessageToken"), 0xFFFF & paramMessageRead.getU16("Status"));
  }

  static CSendBannerToClientMsg read_CSendBannerToClientMsg(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("MessageToken");
    String str1 = paramMessageRead.getString("BannerInfo");
    Long localLong = Long.valueOf(paramMessageRead.getU64("EndTime"));
    String str2 = paramMessageRead.getString("Tag");
    return new CSendBannerToClientMsg(l, str1, localLong.longValue(), str2);
  }

  static CSendConversationStatusReplyMsg read_CSendConversationStatusReplyMsg(MessageRead paramMessageRead)
  {
    return new CSendConversationStatusReplyMsg(0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getString("PublicAccountId"), paramMessageRead.getU32("Seq"));
  }

  static CSendGroupUserIsTypingMsg read_CSendGroupUserIsTypingMsg(MessageRead paramMessageRead)
  {
    return new CSendGroupUserIsTypingMsg(paramMessageRead.getU64("GroupID"), paramMessageRead.getString("FromNumber"), paramMessageRead.getBoolean("Active"), Short.valueOf(paramMessageRead.getU16("DeviceID")).shortValue());
  }

  static CSendInternalMsgReply read_CSendInternalMsgReply(MessageRead paramMessageRead)
  {
    return new CSendInternalMsgReply(paramMessageRead.getU32("Seq"), paramMessageRead.getU64("Token"), paramMessageRead.getU32("Status"));
  }

  static CSendMessageReplyAckMsg read_CSendMessageReplyAckMsg(MessageRead paramMessageRead)
  {
    return new CSendMessageReplyAckMsg(paramMessageRead.getU64("MessageToken"));
  }

  static CSendMessageReplyMsg read_CSendMessageReplyMsg(MessageRead paramMessageRead)
  {
    int i = paramMessageRead.getU32("Seq");
    long l = paramMessageRead.getU64("MessageToken");
    int j = 0xFF & paramMessageRead.getU8("Status");
    Integer localInteger1 = Integer.valueOf(paramMessageRead.getU32("SeqInPG"));
    String str = paramMessageRead.getString("MsgInfo");
    Integer localInteger2 = Integer.valueOf(0xFFFF & paramMessageRead.getU16("SecurityStatus"));
    return new CSendMessageReplyMsg(i, l, j, localInteger1.intValue(), str, localInteger2.intValue());
  }

  static CSendUserIsTypingMsg read_CSendUserIsTypingMsg(MessageRead paramMessageRead)
  {
    String str = paramMessageRead.getString("FromNumber");
    Boolean localBoolean = Boolean.valueOf(paramMessageRead.getBoolean("Active"));
    Integer localInteger1 = Integer.valueOf(0xFFFF & paramMessageRead.getU16("DeviceID"));
    Integer localInteger2 = Integer.valueOf(0xFFFF & paramMessageRead.getU16("ChatType"));
    return new CSendUserIsTypingMsg(str, localBoolean.booleanValue(), localInteger1.intValue(), localInteger2.intValue());
  }

  static CShareAddressBook2ReplyMsg read_CShareAddressBook2ReplyMsg(MessageRead paramMessageRead)
  {
    return new CShareAddressBook2ReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU16("Revision"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CSyncActionOnPGMsg read_CSyncActionOnPGMsg(MessageRead paramMessageRead)
  {
    return new CSyncActionOnPGMsg(paramMessageRead.getU64("GroupID"), paramMessageRead.getU64("MessageToken"), paramMessageRead.getU32("SeqInPG"), 0xFF & paramMessageRead.getU8("ClientAction"), paramMessageRead.getU64("ActionToken"));
  }

  static CSyncConversationReplyMsg read_CSyncConversationReplyMsg(MessageRead paramMessageRead)
  {
    return new CSyncConversationReplyMsg(paramMessageRead.getU8Array("UDID"), paramMessageRead.getString("PeerNumber"), paramMessageRead.getU64("LastMessageToken"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CSyncDataFromMyOtherDeviceMsg read_CSyncDataFromMyOtherDeviceMsg(MessageRead paramMessageRead)
  {
    return new CSyncDataFromMyOtherDeviceMsg(paramMessageRead.getU8Array("EncryptedData"), paramMessageRead.getU32("FromCID"), 0xFFFF & paramMessageRead.getU16("OpCode"), paramMessageRead.getU64("Token"), paramMessageRead.getU64("SyncFlags"), paramMessageRead.getString("DownloadID"));
  }

  static CSyncDataToMyDevicesReplyMsg read_CSyncDataToMyDevicesReplyMsg(MessageRead paramMessageRead)
  {
    return new CSyncDataToMyDevicesReplyMsg(0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU32("Seq"), paramMessageRead.getU64("Token"));
  }

  static CSyncGroupReplyMsg read_CSyncGroupReplyMsg(MessageRead paramMessageRead)
  {
    return new CSyncGroupReplyMsg(paramMessageRead.getU8Array("UDID"), paramMessageRead.getU64("GroupID"), 0xFF & paramMessageRead.getU8("Status"), Long.valueOf(paramMessageRead.getU64("LastMessageToken")).longValue());
  }

  static CSyncMessagesReplyMsg read_CSyncMessagesReplyMsg(MessageRead paramMessageRead)
  {
    return new CSyncMessagesReplyMsg(paramMessageRead.getU32("Sequence"), paramMessageRead.getU64Array("Tokens"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CUnlinkViberIdReplyMsg read_CUnlinkViberIdReplyMsg(MessageRead paramMessageRead)
  {
    return new CUnlinkViberIdReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"), paramMessageRead.getU32("Version"));
  }

  static CUnregisterAppReplyMsg read_CUnregisterAppReplyMsg(MessageRead paramMessageRead)
  {
    return new CUnregisterAppReplyMsg(paramMessageRead.getU32("Status"), paramMessageRead.getU32("sequence"));
  }

  static CUpdateBlockListReplyMsg read_CUpdateBlockListReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdateBlockListReplyMsg(0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getU32("sequence"));
  }

  static CUpdateCommunityPrivilegesReplyMsg read_CUpdateCommunityPrivilegesReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdateCommunityPrivilegesReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"));
  }

  static CUpdateCommunitySettingsReplyMsg read_CUpdateCommunitySettingsReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdateCommunitySettingsReplyMsg(paramMessageRead.getU32("Seq"), 0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getString("InvitationLink"));
  }

  static CUpdateLanguageReplyMsg read_CUpdateLanguageReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdateLanguageReplyMsg(paramMessageRead.getU32("Status"));
  }

  static CUpdateMyCommunitySettingsReplyMsg read_CUpdateMyCommunitySettingsReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdateMyCommunitySettingsReplyMsg(paramMessageRead.getU32("Seq"), paramMessageRead.getU32("Status"));
  }

  static CUpdatePersonalDetailsReplyMsg read_CUpdatePersonalDetailsReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdatePersonalDetailsReplyMsg(paramMessageRead.getU32("Seq"), 0xFFFF & paramMessageRead.getU16("Status"));
  }

  static CUpdateSelfUserDetailsMsg read_CUpdateSelfUserDetailsMsg(MessageRead paramMessageRead)
  {
    return new CUpdateSelfUserDetailsMsg(paramMessageRead.getU64("Token"), paramMessageRead.getString("DownloadID"), paramMessageRead.getString("Name"), 0xFF & paramMessageRead.getU8("Flags"));
  }

  static CUpdateUnsavedContactDetailsMsg read_CUpdateUnsavedContactDetailsMsg(MessageRead paramMessageRead)
  {
    return new CUpdateUnsavedContactDetailsMsg(paramMessageRead.getU64("Token"), paramMessageRead.getString("PhoneNumber"), paramMessageRead.getString("DownloadID"), paramMessageRead.getString("ClientName"), 0xFF & paramMessageRead.getU8("Flags"), paramMessageRead.getString("NewPhoneNumber"));
  }

  static CUpdateUserDateOfBirthReplyMsg read_CUpdateUserDateOfBirthReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdateUserDateOfBirthReplyMsg(paramMessageRead.getU32("Seq"), 0xFF & paramMessageRead.getU8("Status"));
  }

  static CUpdateUserNameReplyMsg read_CUpdateUserNameReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdateUserNameReplyMsg(0xFF & paramMessageRead.getU8("Status"));
  }

  static CUpdateUserPhotoReplyMsg read_CUpdateUserPhotoReplyMsg(MessageRead paramMessageRead)
  {
    return new CUpdateUserPhotoReplyMsg(0xFF & paramMessageRead.getU8("Status"));
  }

  static CValidateGroupUriReplyMsg read_CValidateGroupUriReplyMsg(MessageRead paramMessageRead)
  {
    return new CValidateGroupUriReplyMsg(0xFF & paramMessageRead.getU8("Status"), paramMessageRead.getString("GroupUri"), paramMessageRead.getU32("Context"));
  }

  static CViberIdChangedMsg read_CViberIdChangedMsg(MessageRead paramMessageRead)
  {
    return new CViberIdChangedMsg(paramMessageRead.getString("Email"), paramMessageRead.getU32("Flags"), paramMessageRead.getU32("Version"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreUserInfo")));
  }

  static ChatUserInfo read_ChatUserInfo(MessageRead paramMessageRead)
  {
    return new ChatUserInfo(paramMessageRead.getString("MID"), paramMessageRead.getString("VID"), paramMessageRead.getString("PhoneNumber"), paramMessageRead.getString("ClientName"), paramMessageRead.getString("DownloadID"), paramMessageRead.getString("EncryptedPhoneNumber"), paramMessageRead.getU8("GroupRole"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreInfo")));
  }

  static ConversationToken read_ConversationToken(MessageRead paramMessageRead)
  {
    return new ConversationToken(paramMessageRead.getU64("Token"), paramMessageRead.getString("PeerNum"));
  }

  static DeleteAllUserMessagesInfo read_DeleteAllUserMessagesInfo(MessageRead paramMessageRead)
  {
    return new DeleteAllUserMessagesInfo(paramMessageRead.getU64("Token"), paramMessageRead.getU32("SeqInPG"), paramMessageRead.getString("User"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreInfo")));
  }

  static DownloadDetails read_DownloadDetails(MessageRead paramMessageRead)
  {
    return new DownloadDetails(paramMessageRead.getU64("ObjectID"), paramMessageRead.getString("DownloadID"), paramMessageRead.getString("BucketName"));
  }

  static EncryptedMIDMap read_EncryptedMIDMap(MessageRead paramMessageRead)
  {
    return new EncryptedMIDMap(paramMessageRead.getString("MID"), paramMessageRead.getString("EncryptedMID"));
  }

  static Group2UserChanged read_Group2UserChanged(MessageRead paramMessageRead)
  {
    return new Group2UserChanged(read_Group2UserInfo(paramMessageRead.getMessage("User")), paramMessageRead.getU32("Role"));
  }

  static Group2UserInfo read_Group2UserInfo(MessageRead paramMessageRead)
  {
    return new Group2UserInfo(paramMessageRead.getString("RealPhoneNumber"), paramMessageRead.getString("MID"), paramMessageRead.getString("EncryptedPhoneNumber"), paramMessageRead.getString("ClientName"), paramMessageRead.getString("DownloadID"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreUserInfo")));
  }

  static GroupAddWatchersStatus read_GroupAddWatchersStatus(MessageRead paramMessageRead)
  {
    return new GroupAddWatchersStatus(paramMessageRead.getString("PhoneNumber"), paramMessageRead.getU32("Status"));
  }

  static GroupMemberActionStatus read_GroupMemberActionStatus(MessageRead paramMessageRead)
  {
    return new GroupMemberActionStatus(paramMessageRead.getString("PhoneNumber"), paramMessageRead.getU32("Status"));
  }

  static GroupToken read_GroupToken(MessageRead paramMessageRead)
  {
    return new GroupToken(paramMessageRead.getU64("Token"), paramMessageRead.getU64("GroupID"));
  }

  static GroupUserChanged read_GroupUserChanged(MessageRead paramMessageRead)
  {
    return new GroupUserChanged(read_GroupUserInfo(paramMessageRead.getMessage("User")), paramMessageRead.getU32("Role"));
  }

  static GroupUserInfo read_GroupUserInfo(MessageRead paramMessageRead)
  {
    return new GroupUserInfo(paramMessageRead.getString("PhoneNumber"), paramMessageRead.getString("ClientName"), paramMessageRead.getString("DownloadID"));
  }

  static GroupUserInfoShort read_GroupUserInfoShort(MessageRead paramMessageRead)
  {
    return new GroupUserInfoShort(paramMessageRead.getString("MID"), paramMessageRead.getU8("GroupRole"));
  }

  static JokerButton read_JokerButton(MessageRead paramMessageRead)
  {
    return new JokerButton(paramMessageRead.getString("iconUrl"), paramMessageRead.getString("action"), paramMessageRead.getString("buttonTxt"));
  }

  static Location read_Location(MessageRead paramMessageRead)
  {
    return new Location(paramMessageRead.getS32("longitude"), paramMessageRead.getS32("latitude"));
  }

  static OnlineData read_OnlineData(MessageRead paramMessageRead)
  {
    return new OnlineData(paramMessageRead.getBoolean("IsOnline"), paramMessageRead.getU64("LastOnlineTime"));
  }

  static PinInfo read_PinInfo(MessageRead paramMessageRead)
  {
    return new PinInfo(paramMessageRead.getU64("Token"), paramMessageRead.getU32("SeqInPG"), paramMessageRead.getString("MsgInfo"), paramMessageRead.getU64("PinTime"), read_CMoreUserInfo(paramMessageRead.getMessage("MoreInfo")));
  }

  static PublicAccountUserInfoShort read_PublicAccountUserInfoShort(MessageRead paramMessageRead)
  {
    return new PublicAccountUserInfoShort(paramMessageRead.getString("MID"), paramMessageRead.getU8("GroupRole"));
  }

  static PublicGroupUserInfo read_PublicGroupUserInfo(MessageRead paramMessageRead)
  {
    return new PublicGroupUserInfo(paramMessageRead.getString("PhoneNumber"), paramMessageRead.getString("EncryptedPhoneNumber"), paramMessageRead.getString("ClientName"), paramMessageRead.getString("DownloadID"), paramMessageRead.getU8("GroupRole"));
  }

  static PublicGroupUserInfoShort read_PublicGroupUserInfoShort(MessageRead paramMessageRead)
  {
    return new PublicGroupUserInfoShort(paramMessageRead.getString("PhoneNumber"), paramMessageRead.getU8("GroupRole"));
  }

  static RecoveredGroupChatInfo read_RecoveredGroupChatInfo(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("GroupID");
    String str = paramMessageRead.getString("GroupName");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    GroupUserInfoShort[] arrayOfGroupUserInfoShort = new GroupUserInfoShort[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfGroupUserInfoShort[i] = read_GroupUserInfoShort(arrayOfMessageRead[i]);
    return new RecoveredGroupChatInfo(l, str, arrayOfGroupUserInfoShort, paramMessageRead.getString("IconDownloadID"), paramMessageRead.getU8("Flags"), paramMessageRead.getU8("GroupRole"));
  }

  static RecoveredGroupInfo read_RecoveredGroupInfo(MessageRead paramMessageRead)
  {
    return new RecoveredGroupInfo(paramMessageRead.getU64("GroupID"), paramMessageRead.getString("GroupName"), paramMessageRead.getStringArray("Members"), paramMessageRead.getU8("Flags"));
  }

  static RecoveredGroupInfoEx read_RecoveredGroupInfoEx(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("GroupID");
    String str = paramMessageRead.getString("GroupName");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    PublicGroupUserInfoShort[] arrayOfPublicGroupUserInfoShort = new PublicGroupUserInfoShort[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfPublicGroupUserInfoShort[i] = read_PublicGroupUserInfoShort(arrayOfMessageRead[i]);
    return new RecoveredGroupInfoEx(l, str, arrayOfPublicGroupUserInfoShort, paramMessageRead.getString("IconDownloadID"), paramMessageRead.getU8("Flags"), paramMessageRead.getU8("GroupRole"));
  }

  static RecoveredPublicAccountDeleteAllUsersMessages read_RecoveredPublicAccountDeleteAllUsersMessages(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("PublicChatId");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("DeleteAllUsersMessagesInfo");
    DeleteAllUserMessagesInfo[] arrayOfDeleteAllUserMessagesInfo = new DeleteAllUserMessagesInfo[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfDeleteAllUserMessagesInfo[i] = read_DeleteAllUserMessagesInfo(arrayOfMessageRead[i]);
    return new RecoveredPublicAccountDeleteAllUsersMessages(l, arrayOfDeleteAllUserMessagesInfo);
  }

  static RecoveredPublicAccountInfo read_RecoveredPublicAccountInfo(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("PublicChatId");
    String str1 = paramMessageRead.getString("PublicAccountID");
    byte b1 = paramMessageRead.getU8("GroupType");
    MessageRead[] arrayOfMessageRead1 = paramMessageRead.getMessageArray("Members");
    PublicAccountUserInfoShort[] arrayOfPublicAccountUserInfoShort = new PublicAccountUserInfoShort[arrayOfMessageRead1.length];
    for (int i = 0; i < arrayOfMessageRead1.length; i++)
      arrayOfPublicAccountUserInfoShort[i] = read_PublicAccountUserInfoShort(arrayOfMessageRead1[i]);
    byte b2 = paramMessageRead.getU8("UserRole");
    short s = paramMessageRead.getU16("UserFlags");
    int j = paramMessageRead.getU32("WatchersCount");
    int k = paramMessageRead.getU32("SubscribersCount");
    int m = paramMessageRead.getU32("LastMsgSeqID");
    int n = paramMessageRead.getU32("Revision");
    String str2 = paramMessageRead.getString("GroupName");
    String str3 = paramMessageRead.getString("GroupUri");
    String str4 = paramMessageRead.getString("IconDownloadID");
    String str5 = paramMessageRead.getString("BackgroundDownloadID");
    String str6 = paramMessageRead.getString("TagLine");
    String[] arrayOfString = paramMessageRead.getStringArray("Tags");
    Location localLocation = read_Location(paramMessageRead.getMessage("location"));
    String str7 = paramMessageRead.getString("Country");
    int i1 = paramMessageRead.getU32("GroupFlags");
    String str8 = paramMessageRead.getString("Category");
    String str9 = paramMessageRead.getString("SubCategory");
    String str10 = paramMessageRead.getString("AuthToken");
    boolean bool = paramMessageRead.getBoolean("WebhookExists");
    byte b3 = paramMessageRead.getU8("UserSubscribeState");
    String str11 = paramMessageRead.getString("Website");
    String str12 = paramMessageRead.getString("Email");
    MessageRead[] arrayOfMessageRead2 = paramMessageRead.getMessageArray("JokerButtons");
    JokerButton[] arrayOfJokerButton = new JokerButton[arrayOfMessageRead2.length];
    for (int i2 = 0; i2 < arrayOfMessageRead2.length; i2++)
      arrayOfJokerButton[i2] = read_JokerButton(arrayOfMessageRead2[i2]);
    return new RecoveredPublicAccountInfo(l, str1, b1, arrayOfPublicAccountUserInfoShort, b2, s, j, k, m, n, str2, str3, str4, str5, str6, arrayOfString, localLocation, str7, i1, str8, str9, str10, bool, b3, str11, str12, arrayOfJokerButton, paramMessageRead.getString("CrmName"));
  }

  static RecoveredPublicAccountMoreInfo read_RecoveredPublicAccountMoreInfo(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("PublicChatId");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("PinsInfo");
    PinInfo[] arrayOfPinInfo = new PinInfo[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfPinInfo[i] = read_PinInfo(arrayOfMessageRead[i]);
    return new RecoveredPublicAccountMoreInfo(l, arrayOfPinInfo, read_CMoreUserInfo(paramMessageRead.getMessage("MoreInfo")));
  }

  static RecoveredPublicGroupInfo read_RecoveredPublicGroupInfo(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("GroupID");
    String str = paramMessageRead.getString("GroupName");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    PublicGroupUserInfoShort[] arrayOfPublicGroupUserInfoShort = new PublicGroupUserInfoShort[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfPublicGroupUserInfoShort[i] = read_PublicGroupUserInfoShort(arrayOfMessageRead[i]);
    return new RecoveredPublicGroupInfo(l, str, arrayOfPublicGroupUserInfoShort, paramMessageRead.getU8("Flags"), paramMessageRead.getU8("PublicGroupType"), paramMessageRead.getU32("Revision"), paramMessageRead.getString("GroupUri"), paramMessageRead.getString("IconDownloadID"), paramMessageRead.getString("BackgroundDownloadID"), read_Location(paramMessageRead.getMessage("location")), paramMessageRead.getString("CountryCode"), paramMessageRead.getU8("GroupRole"), paramMessageRead.getString("TagLine"), paramMessageRead.getStringArray("Tags"), paramMessageRead.getU32("LastMessageID"), paramMessageRead.getU32("WatchersCount"));
  }

  static RecoveredSecureGroupChatInfo read_RecoveredSecureGroupChatInfo(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("GroupID");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    GroupUserInfoShort[] arrayOfGroupUserInfoShort = new GroupUserInfoShort[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfGroupUserInfoShort[i] = read_GroupUserInfoShort(arrayOfMessageRead[i]);
    return new RecoveredSecureGroupChatInfo(l, arrayOfGroupUserInfoShort, paramMessageRead.getU8("Flags"), paramMessageRead.getU8("GroupRole"));
  }

  static RecoveredSecureGroupInfo read_RecoveredSecureGroupInfo(MessageRead paramMessageRead)
  {
    long l = paramMessageRead.getU64("GroupID");
    MessageRead[] arrayOfMessageRead = paramMessageRead.getMessageArray("Members");
    PublicGroupUserInfoShort[] arrayOfPublicGroupUserInfoShort = new PublicGroupUserInfoShort[arrayOfMessageRead.length];
    for (int i = 0; i < arrayOfMessageRead.length; i++)
      arrayOfPublicGroupUserInfoShort[i] = read_PublicGroupUserInfoShort(arrayOfMessageRead[i]);
    return new RecoveredSecureGroupInfo(l, arrayOfPublicGroupUserInfoShort, paramMessageRead.getU8("Flags"), paramMessageRead.getU8("GroupRole"));
  }

  static MessageWrite write_CAcceptGroupInviteMsg(CAcceptGroupInviteMsg paramCAcceptGroupInviteMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(489);
    localMessageWrite.setString("InvitationString", paramCAcceptGroupInviteMsg.invitationString);
    localMessageWrite.setU32("Seq", paramCAcceptGroupInviteMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CActOnViberIdPasswordMsg(CActOnViberIdPasswordMsg paramCActOnViberIdPasswordMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(507);
    localMessageWrite.setU32("Seq", paramCActOnViberIdPasswordMsg.seq);
    localMessageWrite.setU8("Action", (byte)paramCActOnViberIdPasswordMsg.action);
    if (paramCActOnViberIdPasswordMsg.oldPassword != null)
      localMessageWrite.setString("OldPassword", paramCActOnViberIdPasswordMsg.oldPassword);
    if (paramCActOnViberIdPasswordMsg.newPassword != null)
      localMessageWrite.setString("NewPassword", paramCActOnViberIdPasswordMsg.newPassword);
    if (paramCActOnViberIdPasswordMsg.email != null)
      localMessageWrite.setString("Email", paramCActOnViberIdPasswordMsg.email);
    return localMessageWrite;
  }

  static MessageWrite write_CAddressBookDeltaUpdateAckMsg(CAddressBookDeltaUpdateAckMsg paramCAddressBookDeltaUpdateAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(281);
    localMessageWrite.setU64("MessageToken", paramCAddressBookDeltaUpdateAckMsg.messageToken);
    if (paramCAddressBookDeltaUpdateAckMsg.revision != null)
      localMessageWrite.setU32("Revision", paramCAddressBookDeltaUpdateAckMsg.revision.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CAddressBookForSecondaryAckMsg(CAddressBookForSecondaryAckMsg paramCAddressBookForSecondaryAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(171);
    localMessageWrite.setU16("GenNum", paramCAddressBookForSecondaryAckMsg.genNum);
    localMessageWrite.setBoolean("LastMsg", paramCAddressBookForSecondaryAckMsg.lastMsg);
    localMessageWrite.setU32("Seq", paramCAddressBookForSecondaryAckMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CAuthenticateAppMsg(CAuthenticateAppMsg paramCAuthenticateAppMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(215);
    localMessageWrite.setU16("AppId", paramCAuthenticateAppMsg.appId);
    localMessageWrite.setU16("Permissions", paramCAuthenticateAppMsg.permissions);
    localMessageWrite.setU32("sequence", paramCAuthenticateAppMsg.sequence);
    localMessageWrite.setString("Identifier", paramCAuthenticateAppMsg.identifier);
    if (paramCAuthenticateAppMsg.replyToServer != null)
      localMessageWrite.setBoolean("replyToServer", paramCAuthenticateAppMsg.replyToServer.booleanValue());
    return localMessageWrite;
  }

  static MessageWrite write_CBillingTokenByMidMsg(CBillingTokenByMidMsg paramCBillingTokenByMidMsg)
  {
    return new MessageWrite(544);
  }

  static MessageWrite write_CBillingTokenMsg(CBillingTokenMsg paramCBillingTokenMsg)
  {
    return new MessageWrite(175);
  }

  static MessageWrite write_CBlockAppMsg(CBlockAppMsg paramCBlockAppMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(247);
    localMessageWrite.setU16("AppId", paramCBlockAppMsg.appId);
    localMessageWrite.setU32("sequence", paramCBlockAppMsg.sequence);
    localMessageWrite.setBoolean("Block", paramCBlockAppMsg.block);
    if (paramCBlockAppMsg.flags != null)
      localMessageWrite.setU32("Flags", paramCBlockAppMsg.flags.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CBlockGroupInviteMsg(CBlockGroupInviteMsg paramCBlockGroupInviteMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(186);
    localMessageWrite.setU64("GroupID", paramCBlockGroupInviteMsg.groupID);
    localMessageWrite.setU32("Seq", paramCBlockGroupInviteMsg.seq);
    localMessageWrite.setBoolean("Block", paramCBlockGroupInviteMsg.block);
    return localMessageWrite;
  }

  static MessageWrite write_CBlockedUserInfo(CBlockedUserInfo paramCBlockedUserInfo)
  {
    MessageWrite localMessageWrite = new MessageWrite("CBlockedUserInfo");
    localMessageWrite.setString("blockedNumber", paramCBlockedUserInfo.blockedNumber);
    localMessageWrite.setU32("blockingFlag", paramCBlockedUserInfo.blockingFlag);
    return localMessageWrite;
  }

  static MessageWrite write_CChangeConversationSettingsMsg(CChangeConversationSettingsMsg paramCChangeConversationSettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(153);
    localMessageWrite.setString("PeerPhoneNumber", paramCChangeConversationSettingsMsg.peerPhoneNumber);
    localMessageWrite.setBoolean("SmartNotifications", paramCChangeConversationSettingsMsg.smartNotifications);
    if (paramCChangeConversationSettingsMsg.mute != null)
      localMessageWrite.setBoolean("Mute", paramCChangeConversationSettingsMsg.mute.booleanValue());
    if (paramCChangeConversationSettingsMsg.hidden != null)
      localMessageWrite.setBoolean("Hidden", paramCChangeConversationSettingsMsg.hidden.booleanValue());
    return localMessageWrite;
  }

  static MessageWrite write_CChangeGroupAttributesMsg(CChangeGroupAttributesMsg paramCChangeGroupAttributesMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(220);
    localMessageWrite.setU64("GroupID", paramCChangeGroupAttributesMsg.groupID);
    localMessageWrite.setU32("Seq", paramCChangeGroupAttributesMsg.seq);
    localMessageWrite.setU32("CurRevision", paramCChangeGroupAttributesMsg.curRevision);
    localMessageWrite.setU16("ChangedFlags", (short)paramCChangeGroupAttributesMsg.changedFlags);
    localMessageWrite.setMessage("GroupAttributes", write_CGroupAttributes(paramCChangeGroupAttributesMsg.groupAttributes));
    if (paramCChangeGroupAttributesMsg.isChangePa != null)
      localMessageWrite.setU8("IsChangePa", paramCChangeGroupAttributesMsg.isChangePa.byteValue());
    if (paramCChangeGroupAttributesMsg.categoryId != null)
      localMessageWrite.setString("CategoryId", paramCChangeGroupAttributesMsg.categoryId);
    if (paramCChangeGroupAttributesMsg.subCategoryId != null)
      localMessageWrite.setString("SubCategoryId", paramCChangeGroupAttributesMsg.subCategoryId);
    if (paramCChangeGroupAttributesMsg.website != null)
      localMessageWrite.setString("Website", paramCChangeGroupAttributesMsg.website);
    if (paramCChangeGroupAttributesMsg.email != null)
      localMessageWrite.setString("Email", paramCChangeGroupAttributesMsg.email);
    return localMessageWrite;
  }

  static MessageWrite write_CChangeGroupSettingsMsg(CChangeGroupSettingsMsg paramCChangeGroupSettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(135);
    localMessageWrite.setU64("GroupID", paramCChangeGroupSettingsMsg.groupID);
    localMessageWrite.setBoolean("SmartNotifications", paramCChangeGroupSettingsMsg.smartNotifications);
    if (paramCChangeGroupSettingsMsg.mute != null)
      localMessageWrite.setBoolean("Mute", paramCChangeGroupSettingsMsg.mute.booleanValue());
    if (paramCChangeGroupSettingsMsg.hidden != null)
      localMessageWrite.setBoolean("Hidden", paramCChangeGroupSettingsMsg.hidden.booleanValue());
    return localMessageWrite;
  }

  static MessageWrite write_CChangeLastOnlineSettingsMsg(CChangeLastOnlineSettingsMsg paramCChangeLastOnlineSettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(179);
    localMessageWrite.setU8("LastOnlineSetting", (byte)paramCChangeLastOnlineSettingsMsg.lastOnlineSetting);
    return localMessageWrite;
  }

  static MessageWrite write_CChangeReadNotificationsSettingsMsg(CChangeReadNotificationsSettingsMsg paramCChangeReadNotificationsSettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(189);
    localMessageWrite.setU8("ReadNotificationsSetting", (byte)paramCChangeReadNotificationsSettingsMsg.readNotificationsSetting);
    return localMessageWrite;
  }

  static MessageWrite write_CChangeSettingsMsg(CChangeSettingsMsg paramCChangeSettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(52);
    localMessageWrite.setBoolean("JoinNotification", paramCChangeSettingsMsg.joinNotification);
    localMessageWrite.setBoolean("ShowText", paramCChangeSettingsMsg.showText);
    if (paramCChangeSettingsMsg.disableViberIn != null)
      localMessageWrite.setBoolean("DisableViberIn", paramCChangeSettingsMsg.disableViberIn.booleanValue());
    if (paramCChangeSettingsMsg.sequence != null)
      localMessageWrite.setU32("Sequence", paramCChangeSettingsMsg.sequence.intValue());
    if (paramCChangeSettingsMsg.showMyPhoto != null)
      localMessageWrite.setBoolean("ShowMyPhoto", paramCChangeSettingsMsg.showMyPhoto.booleanValue());
    if (paramCChangeSettingsMsg.disableServices != null)
      localMessageWrite.setBoolean("DisableServices", paramCChangeSettingsMsg.disableServices.booleanValue());
    if (paramCChangeSettingsMsg.gdprPrivacyFlag != null)
      localMessageWrite.setU64("GdprPrivacyFlag", paramCChangeSettingsMsg.gdprPrivacyFlag.longValue());
    if (paramCChangeSettingsMsg.disabledP2P != null)
      localMessageWrite.setBoolean("DisabledP2P", paramCChangeSettingsMsg.disabledP2P.booleanValue());
    return localMessageWrite;
  }

  static MessageWrite write_CChangeUserActivitySettingsMsg(CChangeUserActivitySettingsMsg paramCChangeUserActivitySettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(255);
    localMessageWrite.setU8("UserActivitySetting", (byte)paramCChangeUserActivitySettingsMsg.userActivitySetting);
    return localMessageWrite;
  }

  static MessageWrite write_CChangeViberIdEmailMsg(CChangeViberIdEmailMsg paramCChangeViberIdEmailMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(511);
    localMessageWrite.setU32("Seq", paramCChangeViberIdEmailMsg.seq);
    localMessageWrite.setString("NewEmail", paramCChangeViberIdEmailMsg.newEmail);
    localMessageWrite.setString("Password", paramCChangeViberIdEmailMsg.password);
    return localMessageWrite;
  }

  static MessageWrite write_CCheckAllowsM2MChatMsg(CCheckAllowsM2MChatMsg paramCCheckAllowsM2MChatMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(716);
    localMessageWrite.setU32("Seq", paramCCheckAllowsM2MChatMsg.seq);
    localMessageWrite.setU64("GroupId", paramCCheckAllowsM2MChatMsg.groupId);
    localMessageWrite.setString("ToEMID", paramCCheckAllowsM2MChatMsg.toEMID);
    return localMessageWrite;
  }

  static MessageWrite write_CCheckEmailStatusMsg(CCheckEmailStatusMsg paramCCheckEmailStatusMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(505);
    localMessageWrite.setU32("Seq", paramCCheckEmailStatusMsg.seq);
    localMessageWrite.setString("Email", paramCCheckEmailStatusMsg.email);
    return localMessageWrite;
  }

  static MessageWrite write_CCheckGroup2InviteMsg(CCheckGroup2InviteMsg paramCCheckGroup2InviteMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(523);
    localMessageWrite.setString("InvitationString", paramCCheckGroup2InviteMsg.invitationString);
    localMessageWrite.setU32("Seq", paramCCheckGroup2InviteMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CConfirmOrRevokeEmailMsg(CConfirmOrRevokeEmailMsg paramCConfirmOrRevokeEmailMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(732);
    localMessageWrite.setU32("Seq", paramCConfirmOrRevokeEmailMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CContactInfo(CContactInfo paramCContactInfo)
  {
    MessageWrite localMessageWrite = new MessageWrite("CContactInfo");
    localMessageWrite.setString("ClientPhone", paramCContactInfo.clientPhone);
    localMessageWrite.setString("ClientName", paramCContactInfo.clientName);
    localMessageWrite.setString("ClientSortName", paramCContactInfo.clientSortName);
    return localMessageWrite;
  }

  static MessageWrite write_CContactSavedInConversationNotificationMsg(CContactSavedInConversationNotificationMsg paramCContactSavedInConversationNotificationMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(389);
    localMessageWrite.setString("SavedPhone", paramCContactSavedInConversationNotificationMsg.savedPhone);
    localMessageWrite.setU32("Seq", paramCContactSavedInConversationNotificationMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CConversationSynchedAckMsg(CConversationSynchedAckMsg paramCConversationSynchedAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(165);
    localMessageWrite.setString("PeerNumber", paramCConversationSynchedAckMsg.peerNumber);
    localMessageWrite.setU64("LastMessageToken", paramCConversationSynchedAckMsg.lastMessageToken);
    if (paramCConversationSynchedAckMsg.flags != null)
      localMessageWrite.setU32("Flags", paramCConversationSynchedAckMsg.flags.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CCreateConferenceCallMsg(CCreateConferenceCallMsg paramCCreateConferenceCallMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(700);
    localMessageWrite.setU32("Seq", paramCCreateConferenceCallMsg.seq);
    localMessageWrite.setStringArray("MemberIDs", paramCCreateConferenceCallMsg.memberIDs);
    localMessageWrite.setString("Attachment", paramCCreateConferenceCallMsg.attachment);
    localMessageWrite.setU32("PeerCID", paramCCreateConferenceCallMsg.peerCID);
    return localMessageWrite;
  }

  static MessageWrite write_CCreateGroup2InviteMsg(CCreateGroup2InviteMsg paramCCreateGroup2InviteMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(519);
    localMessageWrite.setU32("Seq", paramCCreateGroup2InviteMsg.seq);
    localMessageWrite.setU64("GroupID", paramCCreateGroup2InviteMsg.groupID);
    return localMessageWrite;
  }

  static MessageWrite write_CCreateGroupInviteMsg(CCreateGroupInviteMsg paramCCreateGroupInviteMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(487);
    localMessageWrite.setU32("Seq", paramCCreateGroupInviteMsg.seq);
    localMessageWrite.setU64("GroupID", paramCCreateGroupInviteMsg.groupID);
    localMessageWrite.setString("GroupName", paramCCreateGroupInviteMsg.groupName);
    return localMessageWrite;
  }

  static MessageWrite write_CCreateGroupMsg(CCreateGroupMsg paramCCreateGroupMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(97);
    localMessageWrite.setU32("Context", paramCCreateGroupMsg.context);
    localMessageWrite.setStringArray("Members", paramCCreateGroupMsg.members);
    localMessageWrite.setMessage("GroupAttributes", write_CGroupAttributes(paramCCreateGroupMsg.groupAttributes));
    if (paramCCreateGroupMsg.chatType != null)
      localMessageWrite.setU16("ChatType", (short)paramCCreateGroupMsg.chatType.intValue());
    if (paramCCreateGroupMsg.timebombInSec != null)
      localMessageWrite.setU32("TimebombInSec", paramCCreateGroupMsg.timebombInSec.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CDeleteAllUserMessagesMsg(CDeleteAllUserMessagesMsg paramCDeleteAllUserMessagesMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(517);
    localMessageWrite.setU32("Seq", paramCDeleteAllUserMessagesMsg.seq);
    localMessageWrite.setU64("GroupID", paramCDeleteAllUserMessagesMsg.groupID);
    localMessageWrite.setString("User", paramCDeleteAllUserMessagesMsg.user);
    return localMessageWrite;
  }

  static MessageWrite write_CDeleteGlobalMessageMsg(CDeleteGlobalMessageMsg paramCDeleteGlobalMessageMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(268);
    localMessageWrite.setU32("Seq", paramCDeleteGlobalMessageMsg.seq);
    localMessageWrite.setU64("GroupID", paramCDeleteGlobalMessageMsg.groupID);
    localMessageWrite.setU64("MessageToken", paramCDeleteGlobalMessageMsg.messageToken);
    localMessageWrite.setU32("SeqInPG", paramCDeleteGlobalMessageMsg.seqInPG);
    return localMessageWrite;
  }

  static MessageWrite write_CDeleteMessageMsg(CDeleteMessageMsg paramCDeleteMessageMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(360);
    localMessageWrite.setU32("Seq", paramCDeleteMessageMsg.seq);
    localMessageWrite.setString("PeerPhone", paramCDeleteMessageMsg.peerPhone);
    localMessageWrite.setU64("GroupID", paramCDeleteMessageMsg.groupID);
    localMessageWrite.setU64("MessageToken", paramCDeleteMessageMsg.messageToken);
    if (paramCDeleteMessageMsg.chatType != null)
      localMessageWrite.setU16("ChatType", (short)paramCDeleteMessageMsg.chatType.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CDeletedMessageAckMsg(CDeletedMessageAckMsg paramCDeletedMessageAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(363);
    localMessageWrite.setU64("MessageToken", paramCDeletedMessageAckMsg.messageToken);
    return localMessageWrite;
  }

  static MessageWrite write_CGdprCommandMsg(CGdprCommandMsg paramCGdprCommandMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(532);
    localMessageWrite.setU32("Seq", paramCGdprCommandMsg.seq);
    localMessageWrite.setU8("CommandType", (byte)paramCGdprCommandMsg.commandType);
    return localMessageWrite;
  }

  static MessageWrite write_CGetAdInfoMsg(CGetAdInfoMsg paramCGetAdInfoMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(542);
    localMessageWrite.setU32("Seq", paramCGetAdInfoMsg.seq);
    localMessageWrite.setString("MID", paramCGetAdInfoMsg.mid);
    return localMessageWrite;
  }

  static MessageWrite write_CGetCommonCommunitiesMsg(CGetCommonCommunitiesMsg paramCGetCommonCommunitiesMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(718);
    localMessageWrite.setU32("Seq", paramCGetCommonCommunitiesMsg.seq);
    localMessageWrite.setString("PeerEMID", paramCGetCommonCommunitiesMsg.peerEMID);
    return localMessageWrite;
  }

  static MessageWrite write_CGetDownloadDetailsMsg(CGetDownloadDetailsMsg paramCGetDownloadDetailsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(528);
    localMessageWrite.setU32("Seq", paramCGetDownloadDetailsMsg.seq);
    MessageWrite[] arrayOfMessageWrite = new MessageWrite[paramCGetDownloadDetailsMsg.mediaObjectList.length];
    for (int i = 0; i < arrayOfMessageWrite.length; i++)
      arrayOfMessageWrite[i] = write_MediaObjectDetails(paramCGetDownloadDetailsMsg.mediaObjectList[i]);
    localMessageWrite.setMessageArray("MediaObjectList", arrayOfMessageWrite);
    return localMessageWrite;
  }

  static MessageWrite write_CGetEncryptedMIDsMsg(CGetEncryptedMIDsMsg paramCGetEncryptedMIDsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(536);
    localMessageWrite.setU32("Seq", paramCGetEncryptedMIDsMsg.seq);
    localMessageWrite.setStringArray("MIDsList", paramCGetEncryptedMIDsMsg.mIDsList);
    return localMessageWrite;
  }

  static MessageWrite write_CGetGroup2AccessTokenMsg(CGetGroup2AccessTokenMsg paramCGetGroup2AccessTokenMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(525);
    localMessageWrite.setU64("GroupId", paramCGetGroup2AccessTokenMsg.groupId);
    localMessageWrite.setU32("Seq", paramCGetGroup2AccessTokenMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGetGroupInfoMsg(CGetGroupInfoMsg paramCGetGroupInfoMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(104);
    localMessageWrite.setU64("GroupID", paramCGetGroupInfoMsg.groupID);
    if (paramCGetGroupInfoMsg.seq != null)
      localMessageWrite.setU32("Seq", paramCGetGroupInfoMsg.seq.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CGetGroupMessageStatusMsg(CGetGroupMessageStatusMsg paramCGetGroupMessageStatusMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(377);
    localMessageWrite.setU32("Seq", paramCGetGroupMessageStatusMsg.seq);
    localMessageWrite.setU64("GroupId", paramCGetGroupMessageStatusMsg.groupId);
    MessageWrite[] arrayOfMessageWrite = new MessageWrite[paramCGetGroupMessageStatusMsg.messagesWS.length];
    for (int i = 0; i < arrayOfMessageWrite.length; i++)
      arrayOfMessageWrite[i] = write_CGroupMessageDataWithSender(paramCGetGroupMessageStatusMsg.messagesWS[i]);
    localMessageWrite.setMessageArray("MessagesWS", arrayOfMessageWrite);
    return localMessageWrite;
  }

  static MessageWrite write_CGetInviteLinksMsg(CGetInviteLinksMsg paramCGetInviteLinksMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(726);
    localMessageWrite.setU32("Seq", paramCGetInviteLinksMsg.seq);
    localMessageWrite.setU64("GroupID", paramCGetInviteLinksMsg.groupID);
    localMessageWrite.setStringArray("MemberIDs", paramCGetInviteLinksMsg.memberIDs);
    return localMessageWrite;
  }

  static MessageWrite write_CGetLastOnlineMsg(CGetLastOnlineMsg paramCGetLastOnlineMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(158);
    localMessageWrite.setStringArray("ContactPhones", paramCGetLastOnlineMsg.contactPhones);
    localMessageWrite.setU32("Seq", paramCGetLastOnlineMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGetMyCommunitySettingsMsg(CGetMyCommunitySettingsMsg paramCGetMyCommunitySettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(720);
    localMessageWrite.setU32("Seq", paramCGetMyCommunitySettingsMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGetPersonalDetailsMsg(CGetPersonalDetailsMsg paramCGetPersonalDetailsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(728);
    localMessageWrite.setU32("Seq", paramCGetPersonalDetailsMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGetPublicAccountInfoMsg(CGetPublicAccountInfoMsg paramCGetPublicAccountInfoMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(428);
    localMessageWrite.setU32("Seq", paramCGetPublicAccountInfoMsg.seq);
    localMessageWrite.setU64("PublicChatId", paramCGetPublicAccountInfoMsg.publicChatId);
    return localMessageWrite;
  }

  static MessageWrite write_CGetPublicGroupInfoMsg(CGetPublicGroupInfoMsg paramCGetPublicGroupInfoMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(226);
    localMessageWrite.setU64("GroupID", paramCGetPublicGroupInfoMsg.groupID);
    if (paramCGetPublicGroupInfoMsg.seq != null)
      localMessageWrite.setU32("Seq", paramCGetPublicGroupInfoMsg.seq.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CGetUserActivityMsg(CGetUserActivityMsg paramCGetUserActivityMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(252);
    localMessageWrite.setStringArray("ContactPhones", paramCGetUserActivityMsg.contactPhones);
    localMessageWrite.setU32("Seq", paramCGetUserActivityMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGetUserAppsMsg(CGetUserAppsMsg paramCGetUserAppsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(257);
    localMessageWrite.setString("PhoneNumber", paramCGetUserAppsMsg.phoneNumber);
    localMessageWrite.setU32("Seq", paramCGetUserAppsMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGetUserDateOfBirthMsg(CGetUserDateOfBirthMsg paramCGetUserDateOfBirthMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(540);
    localMessageWrite.setU32("Seq", paramCGetUserDateOfBirthMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGetUsersDetailsV2Msg(CGetUsersDetailsV2Msg paramCGetUsersDetailsV2Msg)
  {
    MessageWrite localMessageWrite = new MessageWrite(412);
    localMessageWrite.setStringArray("UserIDs", paramCGetUsersDetailsV2Msg.userIDs);
    localMessageWrite.setU8("InputType", (byte)paramCGetUsersDetailsV2Msg.inputType);
    localMessageWrite.setU32("Seq", paramCGetUsersDetailsV2Msg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGetViberIdMsg(CGetViberIdMsg paramCGetViberIdMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(503);
    localMessageWrite.setU32("Seq", paramCGetViberIdMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CGroupAddMemberMsg(CGroupAddMemberMsg paramCGroupAddMemberMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(106);
    localMessageWrite.setU64("GroupID", paramCGroupAddMemberMsg.groupID);
    localMessageWrite.setString("ClientPhone", paramCGroupAddMemberMsg.clientPhone);
    if (paramCGroupAddMemberMsg.chatType != null)
      localMessageWrite.setU16("ChatType", (short)paramCGroupAddMemberMsg.chatType.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CGroupAddMembersMsg(CGroupAddMembersMsg paramCGroupAddMembersMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(204);
    localMessageWrite.setU64("GroupID", paramCGroupAddMembersMsg.groupID);
    localMessageWrite.setU32("Seq", paramCGroupAddMembersMsg.seq);
    MessageWrite[] arrayOfMessageWrite = new MessageWrite[paramCGroupAddMembersMsg.members.length];
    for (int i = 0; i < arrayOfMessageWrite.length; i++)
      arrayOfMessageWrite[i] = write_GroupAddMember(paramCGroupAddMembersMsg.members[i]);
    localMessageWrite.setMessageArray("Members", arrayOfMessageWrite);
    if (paramCGroupAddMembersMsg.chatType != null)
      localMessageWrite.setU16("ChatType", (short)paramCGroupAddMembersMsg.chatType.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CGroupAddWatchersMsg(CGroupAddWatchersMsg paramCGroupAddWatchersMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(208);
    localMessageWrite.setU64("GroupID", paramCGroupAddWatchersMsg.groupID);
    localMessageWrite.setU32("Seq", paramCGroupAddWatchersMsg.seq);
    localMessageWrite.setBoolean("IsJoin", paramCGroupAddWatchersMsg.isJoin);
    localMessageWrite.setStringArray("Watchers", paramCGroupAddWatchersMsg.watchers);
    localMessageWrite.setString("InviterPhonerNumber", paramCGroupAddWatchersMsg.inviterPhonerNumber);
    localMessageWrite.setU64("InvitationToken", paramCGroupAddWatchersMsg.invitationToken);
    if (paramCGroupAddWatchersMsg.source != null)
      localMessageWrite.setU32("Source", paramCGroupAddWatchersMsg.source.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CGroupAssignRoleMsg(CGroupAssignRoleMsg paramCGroupAssignRoleMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(293);
    localMessageWrite.setU64("GroupID", paramCGroupAssignRoleMsg.groupID);
    localMessageWrite.setU32("Seq", paramCGroupAssignRoleMsg.seq);
    localMessageWrite.setStringArray("Members", paramCGroupAssignRoleMsg.members);
    localMessageWrite.setU32("Role", paramCGroupAssignRoleMsg.role);
    return localMessageWrite;
  }

  static MessageWrite write_CGroupAttributes(CGroupAttributes paramCGroupAttributes)
  {
    MessageWrite localMessageWrite = new MessageWrite("CGroupAttributes");
    localMessageWrite.setString("GroupName", paramCGroupAttributes.groupName);
    if (paramCGroupAttributes.filler != null)
      localMessageWrite.setString("Filler", paramCGroupAttributes.filler);
    if (paramCGroupAttributes.groupUri != null)
      localMessageWrite.setString("GroupUri", paramCGroupAttributes.groupUri);
    if (paramCGroupAttributes.iconID != null)
      localMessageWrite.setU64("IconID", paramCGroupAttributes.iconID.longValue());
    if (paramCGroupAttributes.backgroundID != null)
      localMessageWrite.setU64("BackgroundID", paramCGroupAttributes.backgroundID.longValue());
    if (paramCGroupAttributes.tagLine != null)
      localMessageWrite.setString("TagLine", paramCGroupAttributes.tagLine);
    if (paramCGroupAttributes.tags != null)
      localMessageWrite.setStringArray("Tags", paramCGroupAttributes.tags);
    if (paramCGroupAttributes.location != null)
      localMessageWrite.setMessage("location", write_Location(paramCGroupAttributes.location));
    if (paramCGroupAttributes.country != null)
      localMessageWrite.setString("Country", paramCGroupAttributes.country);
    if (paramCGroupAttributes.groupType != null)
      localMessageWrite.setU32("GroupType", paramCGroupAttributes.groupType.intValue());
    if (paramCGroupAttributes.pgAndSearchFlags != null)
      localMessageWrite.setU32("PgAndSearchFlags", paramCGroupAttributes.pgAndSearchFlags.intValue());
    if (paramCGroupAttributes.pgAndSearchFlagsToSet != null)
      localMessageWrite.setU32("PgAndSearchFlagsToSet", paramCGroupAttributes.pgAndSearchFlagsToSet.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CGroupBanUserMsg(CGroupBanUserMsg paramCGroupBanUserMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(546);
    localMessageWrite.setU32("Seq", paramCGroupBanUserMsg.seq);
    localMessageWrite.setString("EMID", paramCGroupBanUserMsg.emid);
    localMessageWrite.setU64("GroupID", paramCGroupBanUserMsg.groupID);
    localMessageWrite.setU32("Type", paramCGroupBanUserMsg.type);
    return localMessageWrite;
  }

  static MessageWrite write_CGroupChangedAckMsg(CGroupChangedAckMsg paramCGroupChangedAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(115);
    localMessageWrite.setU64("MessageToken", paramCGroupChangedAckMsg.messageToken);
    if (paramCGroupChangedAckMsg.flags != null)
      localMessageWrite.setU16("Flags", (short)paramCGroupChangedAckMsg.flags.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CGroupLeaveMsg(CGroupLeaveMsg paramCGroupLeaveMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(108);
    localMessageWrite.setU64("GroupID", paramCGroupLeaveMsg.groupID);
    return localMessageWrite;
  }

  static MessageWrite write_CGroupMessageDataWithSender(CGroupMessageDataWithSender paramCGroupMessageDataWithSender)
  {
    MessageWrite localMessageWrite = new MessageWrite("CGroupMessageDataWithSender");
    localMessageWrite.setU64("Token", paramCGroupMessageDataWithSender.token);
    localMessageWrite.setU64("TimeSent", paramCGroupMessageDataWithSender.timeSent);
    localMessageWrite.setString("SenderPhoneNumber", paramCGroupMessageDataWithSender.senderPhoneNumber);
    return localMessageWrite;
  }

  static MessageWrite write_CGroupMessageLikeAck(CGroupMessageLikeAck paramCGroupMessageLikeAck)
  {
    MessageWrite localMessageWrite = new MessageWrite(338);
    localMessageWrite.setU64("LikeToken", paramCGroupMessageLikeAck.likeToken);
    return localMessageWrite;
  }

  static MessageWrite write_CGroupRemoveMembersMsg(CGroupRemoveMembersMsg paramCGroupRemoveMembersMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(295);
    localMessageWrite.setU64("GroupID", paramCGroupRemoveMembersMsg.groupID);
    localMessageWrite.setU32("Seq", paramCGroupRemoveMembersMsg.seq);
    localMessageWrite.setStringArray("Members", paramCGroupRemoveMembersMsg.members);
    return localMessageWrite;
  }

  static MessageWrite write_CGroupSynchedAckMsg(CGroupSynchedAckMsg paramCGroupSynchedAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(131);
    localMessageWrite.setU8Array("UDID", paramCGroupSynchedAckMsg.udid);
    localMessageWrite.setU64("GroupID", paramCGroupSynchedAckMsg.groupID);
    if (paramCGroupSynchedAckMsg.lastMessageToken != null)
      localMessageWrite.setU64("LastMessageToken", paramCGroupSynchedAckMsg.lastMessageToken.longValue());
    if (paramCGroupSynchedAckMsg.flags != null)
      localMessageWrite.setU32("Flags", paramCGroupSynchedAckMsg.flags.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CGroupUserIsTypingMsg(CGroupUserIsTypingMsg paramCGroupUserIsTypingMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(103);
    localMessageWrite.setU64("GroupID", paramCGroupUserIsTypingMsg.groupID);
    localMessageWrite.setBoolean("Active", paramCGroupUserIsTypingMsg.active);
    return localMessageWrite;
  }

  static MessageWrite write_CInviteToConferenceMsg(CInviteToConferenceMsg paramCInviteToConferenceMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(707);
    localMessageWrite.setU64("CallToken", paramCInviteToConferenceMsg.callToken);
    localMessageWrite.setStringArray("MemberIDs", paramCInviteToConferenceMsg.memberIDs);
    localMessageWrite.setString("Attachment", paramCInviteToConferenceMsg.attachment);
    localMessageWrite.setU32("Seq", paramCInviteToConferenceMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CIsOnlineMsg(CIsOnlineMsg paramCIsOnlineMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(150);
    localMessageWrite.setString("PhoneNumber", paramCIsOnlineMsg.phoneNumber);
    return localMessageWrite;
  }

  static MessageWrite write_CIsRegisteredNumberMsg(CIsRegisteredNumberMsg paramCIsRegisteredNumberMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(67);
    localMessageWrite.setString("ToNumber", paramCIsRegisteredNumberMsg.toNumber);
    return localMessageWrite;
  }

  static MessageWrite write_CJoinConfCallMsg(CJoinConfCallMsg paramCJoinConfCallMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(702);
    localMessageWrite.setU64("CallToken", paramCJoinConfCallMsg.callToken);
    localMessageWrite.setU8Array("SdpOffer", paramCJoinConfCallMsg.sdpOffer);
    localMessageWrite.setString("Attachment", paramCJoinConfCallMsg.attachment);
    localMessageWrite.setU32("SdpPlan", paramCJoinConfCallMsg.sdpPlan);
    localMessageWrite.setU32("Seq", paramCJoinConfCallMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CLateErrorOnReceivedMessageMsg(CLateErrorOnReceivedMessageMsg paramCLateErrorOnReceivedMessageMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(471);
    localMessageWrite.setU32("Sequence", paramCLateErrorOnReceivedMessageMsg.sequence);
    localMessageWrite.setU64("MessageToken", paramCLateErrorOnReceivedMessageMsg.messageToken);
    localMessageWrite.setString("PublicAccountID", paramCLateErrorOnReceivedMessageMsg.publicAccountID);
    localMessageWrite.setU16("ClientStatus", (short)paramCLateErrorOnReceivedMessageMsg.clientStatus);
    localMessageWrite.setString("ClientStatusInfo", paramCLateErrorOnReceivedMessageMsg.clientStatusInfo);
    return localMessageWrite;
  }

  static MessageWrite write_CLikeGroupMessage(CLikeGroupMessage paramCLikeGroupMessage)
  {
    MessageWrite localMessageWrite = new MessageWrite(335);
    localMessageWrite.setString("MessageSenderPhoneNumber", paramCLikeGroupMessage.messageSenderPhoneNumber);
    localMessageWrite.setU64("MessageToken", paramCLikeGroupMessage.messageToken);
    localMessageWrite.setU64("GroupId", paramCLikeGroupMessage.groupId);
    localMessageWrite.setU32("Seq", paramCLikeGroupMessage.seq);
    localMessageWrite.setBoolean("Action", paramCLikeGroupMessage.action);
    return localMessageWrite;
  }

  static MessageWrite write_CMessageDeliveredAckMsg(CMessageDeliveredAckMsg paramCMessageDeliveredAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(86);
    localMessageWrite.setU64("MessageToken", paramCMessageDeliveredAckMsg.messageToken);
    return localMessageWrite;
  }

  static MessageWrite write_CMessageReceivedAckMsg(CMessageReceivedAckMsg paramCMessageReceivedAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(76);
    localMessageWrite.setU64("MessageToken", paramCMessageReceivedAckMsg.messageToken);
    if (paramCMessageReceivedAckMsg.flags != null)
      localMessageWrite.setU16("Flags", (short)paramCMessageReceivedAckMsg.flags.intValue());
    if (paramCMessageReceivedAckMsg.decryptionStatus != null)
      localMessageWrite.setU16("DecryptionStatus", paramCMessageReceivedAckMsg.decryptionStatus.shortValue());
    if (paramCMessageReceivedAckMsg.clientStatus != null)
      localMessageWrite.setU16("ClientStatus", (short)paramCMessageReceivedAckMsg.clientStatus.intValue());
    if (paramCMessageReceivedAckMsg.clientStatusInfo != null)
      localMessageWrite.setString("ClientStatusInfo", paramCMessageReceivedAckMsg.clientStatusInfo);
    if (paramCMessageReceivedAckMsg.messageContentDetails != null)
      localMessageWrite.setString("MessageContentDetails", paramCMessageReceivedAckMsg.messageContentDetails);
    return localMessageWrite;
  }

  static MessageWrite write_CMessageReceivedReplyableAckMsg(CMessageReceivedReplyableAckMsg paramCMessageReceivedReplyableAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(724);
    localMessageWrite.setU32("Seq", paramCMessageReceivedReplyableAckMsg.seq);
    localMessageWrite.setU64("MessageToken", paramCMessageReceivedReplyableAckMsg.messageToken);
    localMessageWrite.setU16("Flags", (short)paramCMessageReceivedReplyableAckMsg.flags);
    localMessageWrite.setU16("ClientStatus", (short)paramCMessageReceivedReplyableAckMsg.clientStatus);
    localMessageWrite.setString("ClientStatusInfo", paramCMessageReceivedReplyableAckMsg.clientStatusInfo);
    return localMessageWrite;
  }

  static MessageWrite write_CMessagesSynchedAckMsg(CMessagesSynchedAckMsg paramCMessagesSynchedAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(128);
    localMessageWrite.setU8Array("UDID", paramCMessagesSynchedAckMsg.udid);
    localMessageWrite.setU64Array("AckedReadTokens", paramCMessagesSynchedAckMsg.ackedReadTokens);
    if (paramCMessagesSynchedAckMsg.ackedDeletedTokens != null)
      localMessageWrite.setU64Array("AckedDeletedTokens", paramCMessagesSynchedAckMsg.ackedDeletedTokens);
    return localMessageWrite;
  }

  static MessageWrite write_COnClickMsg(COnClickMsg paramCOnClickMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(8);
    localMessageWrite.setString("OnClickStr", paramCOnClickMsg.onClickStr);
    localMessageWrite.setU32("ElementIndex", paramCOnClickMsg.elementIndex);
    localMessageWrite.setU32("Seq", paramCOnClickMsg.seq);
    localMessageWrite.setString("SenderNum", paramCOnClickMsg.senderNum);
    return localMessageWrite;
  }

  static MessageWrite write_CPublicAccountSubscriberUpdateMsg(CPublicAccountSubscriberUpdateMsg paramCPublicAccountSubscriberUpdateMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(430);
    localMessageWrite.setString("PublicAccountID", paramCPublicAccountSubscriberUpdateMsg.publicAccountID);
    localMessageWrite.setU32("Seq", paramCPublicAccountSubscriberUpdateMsg.seq);
    localMessageWrite.setU32("SubscriberOperation", paramCPublicAccountSubscriberUpdateMsg.subscriberOperation);
    return localMessageWrite;
  }

  static MessageWrite write_CQueryDestOperationSupportMsg(CQueryDestOperationSupportMsg paramCQueryDestOperationSupportMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(373);
    localMessageWrite.setString("DestPhoneNumber", paramCQueryDestOperationSupportMsg.destPhoneNumber);
    localMessageWrite.setU32("Seq", paramCQueryDestOperationSupportMsg.seq);
    localMessageWrite.setU64("Operation", paramCQueryDestOperationSupportMsg.operation);
    if (paramCQueryDestOperationSupportMsg.hasE2ESession != null)
      localMessageWrite.setBoolean("HasE2ESession", paramCQueryDestOperationSupportMsg.hasE2ESession.booleanValue());
    return localMessageWrite;
  }

  static MessageWrite write_CRecoverGroupChatsMsg(CRecoverGroupChatsMsg paramCRecoverGroupChatsMsg)
  {
    return new MessageWrite(449);
  }

  static MessageWrite write_CRecoverGroupsMsg(CRecoverGroupsMsg paramCRecoverGroupsMsg)
  {
    return new MessageWrite(184);
  }

  static MessageWrite write_CRecoverPublicAccountsMsg(CRecoverPublicAccountsMsg paramCRecoverPublicAccountsMsg)
  {
    return new MessageWrite(451);
  }

  static MessageWrite write_CRecvInternalMsgAck(CRecvInternalMsgAck paramCRecvInternalMsgAck)
  {
    MessageWrite localMessageWrite = new MessageWrite(712);
    localMessageWrite.setU64("Token", paramCRecvInternalMsgAck.token);
    return localMessageWrite;
  }

  static MessageWrite write_CRefreshPublicAccountTokenMsg(CRefreshPublicAccountTokenMsg paramCRefreshPublicAccountTokenMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(432);
    localMessageWrite.setU32("Seq", paramCRefreshPublicAccountTokenMsg.seq);
    localMessageWrite.setString("PublicAccountID", paramCRefreshPublicAccountTokenMsg.publicAccountID);
    return localMessageWrite;
  }

  static MessageWrite write_CRegisterViberIdMsg(CRegisterViberIdMsg paramCRegisterViberIdMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(501);
    localMessageWrite.setU32("Seq", paramCRegisterViberIdMsg.seq);
    localMessageWrite.setString("Email", paramCRegisterViberIdMsg.email);
    localMessageWrite.setString("EmailPassword", paramCRegisterViberIdMsg.emailPassword);
    localMessageWrite.setBoolean("PromotionsAgreed", paramCRegisterViberIdMsg.promotionsAgreed);
    return localMessageWrite;
  }

  static MessageWrite write_CRegisteredNumbersAckMsg(CRegisteredNumbersAckMsg paramCRegisteredNumbersAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(58);
    if (paramCRegisteredNumbersAckMsg.token != null)
      localMessageWrite.setU64("Token", paramCRegisteredNumbersAckMsg.token.longValue());
    return localMessageWrite;
  }

  static MessageWrite write_CRevokeGroup2InviteMsg(CRevokeGroup2InviteMsg paramCRevokeGroup2InviteMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(521);
    localMessageWrite.setU32("Seq", paramCRevokeGroup2InviteMsg.seq);
    localMessageWrite.setU64("GroupID", paramCRevokeGroup2InviteMsg.groupID);
    return localMessageWrite;
  }

  static MessageWrite write_CRevokeGroupInviteMsg(CRevokeGroupInviteMsg paramCRevokeGroupInviteMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(493);
    localMessageWrite.setU32("Seq", paramCRevokeGroupInviteMsg.seq);
    localMessageWrite.setU64("GroupID", paramCRevokeGroupInviteMsg.groupID);
    return localMessageWrite;
  }

  static MessageWrite write_CSecretChatReceivedEventAckMsg(CSecretChatReceivedEventAckMsg paramCSecretChatReceivedEventAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(481);
    localMessageWrite.setU64("Token", paramCSecretChatReceivedEventAckMsg.token);
    localMessageWrite.setU16("Flags", (short)paramCSecretChatReceivedEventAckMsg.flags);
    return localMessageWrite;
  }

  static MessageWrite write_CSecretChatSendEventMsg(CSecretChatSendEventMsg paramCSecretChatSendEventMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(478);
    localMessageWrite.setU32("Seq", paramCSecretChatSendEventMsg.seq);
    localMessageWrite.setString("MID", paramCSecretChatSendEventMsg.mid);
    localMessageWrite.setU64("GroupID", paramCSecretChatSendEventMsg.groupID);
    localMessageWrite.setU8("EventType", (byte)paramCSecretChatSendEventMsg.eventType);
    localMessageWrite.setU32("TimebombInSec", paramCSecretChatSendEventMsg.timebombInSec);
    return localMessageWrite;
  }

  static MessageWrite write_CSendActionOnPGMsg(CSendActionOnPGMsg paramCSendActionOnPGMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(211);
    localMessageWrite.setU64("GroupID", paramCSendActionOnPGMsg.groupID);
    localMessageWrite.setU64("MessageToken", paramCSendActionOnPGMsg.messageToken);
    localMessageWrite.setU32("SeqInPG", paramCSendActionOnPGMsg.seqInPG);
    localMessageWrite.setU8("ClientAction", (byte)paramCSendActionOnPGMsg.clientAction);
    localMessageWrite.setU32("Context", paramCSendActionOnPGMsg.context);
    localMessageWrite.setU64("MessageTime", paramCSendActionOnPGMsg.messageTime);
    if (paramCSendActionOnPGMsg.messageSenderMID != null)
      localMessageWrite.setString("MessageSenderMID", paramCSendActionOnPGMsg.messageSenderMID);
    return localMessageWrite;
  }

  static MessageWrite write_CSendActionToBotMsg(CSendActionToBotMsg paramCSendActionToBotMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(515);
    localMessageWrite.setString("PublicAccountId", paramCSendActionToBotMsg.publicAccountId);
    localMessageWrite.setU32("Flags", paramCSendActionToBotMsg.flags);
    localMessageWrite.setU32("Seq", paramCSendActionToBotMsg.seq);
    localMessageWrite.setString("MsgInfo", paramCSendActionToBotMsg.msgInfo);
    return localMessageWrite;
  }

  static MessageWrite write_CSendBackAckBase(CSendBackAckBase paramCSendBackAckBase)
  {
    MessageWrite localMessageWrite = new MessageWrite(723);
    localMessageWrite.setU64("MessageToken", paramCSendBackAckBase.messageToken);
    return localMessageWrite;
  }

  static MessageWrite write_CSendBannerToClientAckMsg(CSendBannerToClientAckMsg paramCSendBannerToClientAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(370);
    localMessageWrite.setU64("MessageToken", paramCSendBannerToClientAckMsg.messageToken);
    localMessageWrite.setU8("Status", (byte)paramCSendBannerToClientAckMsg.status);
    return localMessageWrite;
  }

  static MessageWrite write_CSendConversationStatusMsg(CSendConversationStatusMsg paramCSendConversationStatusMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(434);
    localMessageWrite.setString("PublicAccountId", paramCSendConversationStatusMsg.publicAccountId);
    localMessageWrite.setU32("ConversationStatusFlags", paramCSendConversationStatusMsg.conversationStatusFlags);
    localMessageWrite.setString("Context", paramCSendConversationStatusMsg.context);
    localMessageWrite.setU32("Seq", paramCSendConversationStatusMsg.seq);
    if (paramCSendConversationStatusMsg.trackingData != null)
      localMessageWrite.setString("TrackingData", paramCSendConversationStatusMsg.trackingData);
    if (paramCSendConversationStatusMsg.peerMID != null)
      localMessageWrite.setString("PeerMID", paramCSendConversationStatusMsg.peerMID);
    if (paramCSendConversationStatusMsg.groupId != null)
      localMessageWrite.setU64("GroupId", paramCSendConversationStatusMsg.groupId.longValue());
    if (paramCSendConversationStatusMsg.replyType != null)
      localMessageWrite.setString("ReplyType", paramCSendConversationStatusMsg.replyType);
    if (paramCSendConversationStatusMsg.silent != null)
      localMessageWrite.setU8("Silent", paramCSendConversationStatusMsg.silent.byteValue());
    if (paramCSendConversationStatusMsg.msgInfo != null)
      localMessageWrite.setString("msgInfo", paramCSendConversationStatusMsg.msgInfo);
    return localMessageWrite;
  }

  static MessageWrite write_CSendGroupMsg(CSendGroupMsg paramCSendGroupMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(99);
    localMessageWrite.setU64("GroupID", paramCSendGroupMsg.groupID);
    localMessageWrite.setU32("MessageSeq", paramCSendGroupMsg.messageSeq);
    localMessageWrite.setString("Text", paramCSendGroupMsg.text);
    if (paramCSendGroupMsg.location != null)
      localMessageWrite.setMessage("location", write_Location(paramCSendGroupMsg.location));
    if (paramCSendGroupMsg.mediaType != null)
      localMessageWrite.setU8("mediaType", paramCSendGroupMsg.mediaType.byteValue());
    if (paramCSendGroupMsg.objectID != null)
      localMessageWrite.setU64("ObjectID", paramCSendGroupMsg.objectID.longValue());
    if (paramCSendGroupMsg.thumbnail != null)
      localMessageWrite.setU8Array("Thumbnail", paramCSendGroupMsg.thumbnail);
    if (paramCSendGroupMsg.flags != null)
      localMessageWrite.setU8("Flags", paramCSendGroupMsg.flags.byteValue());
    if (paramCSendGroupMsg.largeThumbnail != null)
      localMessageWrite.setU8Array("LargeThumbnail", paramCSendGroupMsg.largeThumbnail);
    if (paramCSendGroupMsg.duration != null)
      localMessageWrite.setU32("Duration", paramCSendGroupMsg.duration.intValue());
    if (paramCSendGroupMsg.uploadDuration != null)
      localMessageWrite.setU32("UploadDuration", paramCSendGroupMsg.uploadDuration.intValue());
    if (paramCSendGroupMsg.msgInfo != null)
      localMessageWrite.setString("MsgInfo", paramCSendGroupMsg.msgInfo);
    if (paramCSendGroupMsg.downloadID != null)
      localMessageWrite.setString("DownloadID", paramCSendGroupMsg.downloadID);
    if (paramCSendGroupMsg.bucket != null)
      localMessageWrite.setString("Bucket", paramCSendGroupMsg.bucket);
    if (paramCSendGroupMsg.chatType != null)
      localMessageWrite.setU16("ChatType", paramCSendGroupMsg.chatType.shortValue());
    if (paramCSendGroupMsg.timebombInSec != null)
      localMessageWrite.setU32("TimebombInSec", paramCSendGroupMsg.timebombInSec.intValue());
    if (paramCSendGroupMsg.exFlags != null)
      localMessageWrite.setU64("ExFlags", paramCSendGroupMsg.exFlags.longValue());
    if (paramCSendGroupMsg.clientMediaType != null)
      localMessageWrite.setU64("ClientMediaType", paramCSendGroupMsg.clientMediaType.longValue());
    if (paramCSendGroupMsg.mediaTypeExtraData != null)
      localMessageWrite.setString("MediaTypeExtraData", paramCSendGroupMsg.mediaTypeExtraData);
    return localMessageWrite;
  }

  static MessageWrite write_CSendInternalMsg(CSendInternalMsg paramCSendInternalMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(709);
    localMessageWrite.setU32("Seq", paramCSendInternalMsg.seq);
    localMessageWrite.setString("ToMID", paramCSendInternalMsg.toMID);
    localMessageWrite.setString("Data", paramCSendInternalMsg.data);
    return localMessageWrite;
  }

  static MessageWrite write_CSendMessageMsg(CSendMessageMsg paramCSendMessageMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(73);
    localMessageWrite.setString("ToNumber", paramCSendMessageMsg.toNumber);
    localMessageWrite.setString("Text", paramCSendMessageMsg.text);
    localMessageWrite.setU32("Seq", paramCSendMessageMsg.seq);
    if (paramCSendMessageMsg.location != null)
      localMessageWrite.setMessage("location", write_Location(paramCSendMessageMsg.location));
    if (paramCSendMessageMsg.mediaType != null)
      localMessageWrite.setU8("mediaType", (byte)paramCSendMessageMsg.mediaType.intValue());
    if (paramCSendMessageMsg.objectID != null)
      localMessageWrite.setU64("ObjectID", paramCSendMessageMsg.objectID.longValue());
    if (paramCSendMessageMsg.thumbnail != null)
      localMessageWrite.setU8Array("Thumbnail", paramCSendMessageMsg.thumbnail);
    if (paramCSendMessageMsg.flags != null)
      localMessageWrite.setU8("Flags", (byte)paramCSendMessageMsg.flags.intValue());
    if (paramCSendMessageMsg.largeThumbnail != null)
      localMessageWrite.setU8Array("LargeThumbnail", paramCSendMessageMsg.largeThumbnail);
    if (paramCSendMessageMsg.duration != null)
      localMessageWrite.setU32("Duration", paramCSendMessageMsg.duration.intValue());
    if (paramCSendMessageMsg.uploadDuration != null)
      localMessageWrite.setU32("UploadDuration", paramCSendMessageMsg.uploadDuration.intValue());
    if (paramCSendMessageMsg.msgInfo != null)
      localMessageWrite.setString("MsgInfo", paramCSendMessageMsg.msgInfo);
    if (paramCSendMessageMsg.downloadID != null)
      localMessageWrite.setString("DownloadID", paramCSendMessageMsg.downloadID);
    if (paramCSendMessageMsg.bucket != null)
      localMessageWrite.setString("Bucket", paramCSendMessageMsg.bucket);
    if (paramCSendMessageMsg.chatType != null)
      localMessageWrite.setU16("ChatType", (short)paramCSendMessageMsg.chatType.intValue());
    if (paramCSendMessageMsg.timebombInSec != null)
      localMessageWrite.setU32("TimebombInSec", paramCSendMessageMsg.timebombInSec.intValue());
    if (paramCSendMessageMsg.exFlags != null)
      localMessageWrite.setU64("ExFlags", paramCSendMessageMsg.exFlags.longValue());
    if (paramCSendMessageMsg.clientMediaType != null)
      localMessageWrite.setU64("ClientMediaType", paramCSendMessageMsg.clientMediaType.longValue());
    if (paramCSendMessageMsg.mediaTypeExtraData != null)
      localMessageWrite.setString("MediaTypeExtraData", paramCSendMessageMsg.mediaTypeExtraData);
    return localMessageWrite;
  }

  static MessageWrite write_CSendPublicGroupInviteMsg(CSendPublicGroupInviteMsg paramCSendPublicGroupInviteMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(241);
    localMessageWrite.setU32("Seq", paramCSendPublicGroupInviteMsg.seq);
    localMessageWrite.setU64("GroupID", paramCSendPublicGroupInviteMsg.groupID);
    localMessageWrite.setStringArray("ToNumbers", paramCSendPublicGroupInviteMsg.toNumbers);
    if (paramCSendPublicGroupInviteMsg.toGroup != null)
      localMessageWrite.setU64("ToGroup", paramCSendPublicGroupInviteMsg.toGroup.longValue());
    if (paramCSendPublicGroupInviteMsg.inviteType != null)
      localMessageWrite.setU16("InviteType", (short)paramCSendPublicGroupInviteMsg.inviteType.intValue());
    if (paramCSendPublicGroupInviteMsg.chatType != null)
      localMessageWrite.setU16("ChatType", (short)paramCSendPublicGroupInviteMsg.chatType.intValue());
    if (paramCSendPublicGroupInviteMsg.timebombInSec != null)
      localMessageWrite.setU32("TimebombInSec", paramCSendPublicGroupInviteMsg.timebombInSec.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CShareAddressBook2Msg(CShareAddressBook2Msg paramCShareAddressBook2Msg)
  {
    MessageWrite localMessageWrite = new MessageWrite(277);
    MessageWrite[] arrayOfMessageWrite = new MessageWrite[paramCShareAddressBook2Msg.addressBookList.length];
    for (int i = 0; i < arrayOfMessageWrite.length; i++)
      arrayOfMessageWrite[i] = write_CContactInfo(paramCShareAddressBook2Msg.addressBookList[i]);
    localMessageWrite.setMessageArray("AddressBookList", arrayOfMessageWrite);
    localMessageWrite.setU32("Seq", paramCShareAddressBook2Msg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CShareDeltaAddressBookMsg(CShareDeltaAddressBookMsg paramCShareDeltaAddressBookMsg)
  {
    int i = 0;
    MessageWrite localMessageWrite = new MessageWrite(278);
    MessageWrite[] arrayOfMessageWrite1 = new MessageWrite[paramCShareDeltaAddressBookMsg.newPhones.length];
    for (int j = 0; j < arrayOfMessageWrite1.length; j++)
      arrayOfMessageWrite1[j] = write_CContactInfo(paramCShareDeltaAddressBookMsg.newPhones[j]);
    localMessageWrite.setMessageArray("NewPhones", arrayOfMessageWrite1);
    MessageWrite[] arrayOfMessageWrite2 = new MessageWrite[paramCShareDeltaAddressBookMsg.changedPhones.length];
    while (i < arrayOfMessageWrite2.length)
    {
      arrayOfMessageWrite2[i] = write_CContactInfo(paramCShareDeltaAddressBookMsg.changedPhones[i]);
      i++;
    }
    localMessageWrite.setMessageArray("ChangedPhones", arrayOfMessageWrite2);
    localMessageWrite.setStringArray("DeletedPhones", paramCShareDeltaAddressBookMsg.deletedPhones);
    localMessageWrite.setU32("Seq", paramCShareDeltaAddressBookMsg.seq);
    localMessageWrite.setU16("Revision", paramCShareDeltaAddressBookMsg.revision);
    return localMessageWrite;
  }

  static MessageWrite write_CSyncActionOnPGAckMsg(CSyncActionOnPGAckMsg paramCSyncActionOnPGAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(214);
    localMessageWrite.setU64("ActionToken", paramCSyncActionOnPGAckMsg.actionToken);
    return localMessageWrite;
  }

  static MessageWrite write_CSyncConversationMsg(CSyncConversationMsg paramCSyncConversationMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(163);
    localMessageWrite.setString("PeerNumber", paramCSyncConversationMsg.peerNumber);
    localMessageWrite.setU64("LastMessageToken", paramCSyncConversationMsg.lastMessageToken);
    localMessageWrite.setU32("Flags", paramCSyncConversationMsg.flags);
    if (paramCSyncConversationMsg.chatType != null)
      localMessageWrite.setU16("ChatType", (short)paramCSyncConversationMsg.chatType.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CSyncDataFromMyOtherDeviceAckMsg(CSyncDataFromMyOtherDeviceAckMsg paramCSyncDataFromMyOtherDeviceAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(486);
    localMessageWrite.setU64("Token", paramCSyncDataFromMyOtherDeviceAckMsg.token);
    return localMessageWrite;
  }

  static MessageWrite write_CSyncDataToMyDevicesMsg(CSyncDataToMyDevicesMsg paramCSyncDataToMyDevicesMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(483);
    localMessageWrite.setU8Array("EncryptedData", paramCSyncDataToMyDevicesMsg.encryptedData);
    localMessageWrite.setU16("OpCode", (short)paramCSyncDataToMyDevicesMsg.opCode);
    localMessageWrite.setU64("SyncFlags", paramCSyncDataToMyDevicesMsg.syncFlags);
    localMessageWrite.setU32("Seq", paramCSyncDataToMyDevicesMsg.seq);
    if (paramCSyncDataToMyDevicesMsg.objectID != null)
      localMessageWrite.setU64("ObjectID", paramCSyncDataToMyDevicesMsg.objectID.longValue());
    return localMessageWrite;
  }

  static MessageWrite write_CSyncGroupMsg(CSyncGroupMsg paramCSyncGroupMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(129);
    localMessageWrite.setU64("GroupID", paramCSyncGroupMsg.groupID);
    localMessageWrite.setU32("Flags", paramCSyncGroupMsg.flags);
    if (paramCSyncGroupMsg.lastMessageToken != null)
      localMessageWrite.setU64("LastMessageToken", paramCSyncGroupMsg.lastMessageToken.longValue());
    if (paramCSyncGroupMsg.seqInPG != null)
      localMessageWrite.setU32("SeqInPG", paramCSyncGroupMsg.seqInPG.intValue());
    if (paramCSyncGroupMsg.senders != null)
      localMessageWrite.setStringSet("Senders", paramCSyncGroupMsg.senders);
    return localMessageWrite;
  }

  static MessageWrite write_CSyncMessagesMsg(CSyncMessagesMsg paramCSyncMessagesMsg)
  {
    int i = 0;
    MessageWrite localMessageWrite = new MessageWrite(127);
    localMessageWrite.setU32("Sequence", paramCSyncMessagesMsg.sequence);
    MessageWrite[] arrayOfMessageWrite1 = new MessageWrite[paramCSyncMessagesMsg.readConversationTokens.length];
    for (int j = 0; j < arrayOfMessageWrite1.length; j++)
      arrayOfMessageWrite1[j] = write_ConversationToken(paramCSyncMessagesMsg.readConversationTokens[j]);
    localMessageWrite.setMessageArray("ReadConversationTokens", arrayOfMessageWrite1);
    MessageWrite[] arrayOfMessageWrite2 = new MessageWrite[paramCSyncMessagesMsg.deletedConversationTokens.length];
    for (int k = 0; k < arrayOfMessageWrite2.length; k++)
      arrayOfMessageWrite2[k] = write_ConversationToken(paramCSyncMessagesMsg.deletedConversationTokens[k]);
    localMessageWrite.setMessageArray("DeletedConversationTokens", arrayOfMessageWrite2);
    MessageWrite[] arrayOfMessageWrite3 = new MessageWrite[paramCSyncMessagesMsg.readGroupTokens.length];
    for (int m = 0; m < arrayOfMessageWrite3.length; m++)
      arrayOfMessageWrite3[m] = write_GroupToken(paramCSyncMessagesMsg.readGroupTokens[m]);
    localMessageWrite.setMessageArray("ReadGroupTokens", arrayOfMessageWrite3);
    MessageWrite[] arrayOfMessageWrite4 = new MessageWrite[paramCSyncMessagesMsg.deletedGroupTokens.length];
    while (i < arrayOfMessageWrite4.length)
    {
      arrayOfMessageWrite4[i] = write_GroupToken(paramCSyncMessagesMsg.deletedGroupTokens[i]);
      i++;
    }
    localMessageWrite.setMessageArray("DeletedGroupTokens", arrayOfMessageWrite4);
    return localMessageWrite;
  }

  static MessageWrite write_CUnlinkViberIdMsg(CUnlinkViberIdMsg paramCUnlinkViberIdMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(509);
    localMessageWrite.setU32("Seq", paramCUnlinkViberIdMsg.seq);
    return localMessageWrite;
  }

  static MessageWrite write_CUnregisterAppMsg(CUnregisterAppMsg paramCUnregisterAppMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(224);
    localMessageWrite.setU16("AppId", paramCUnregisterAppMsg.appId);
    localMessageWrite.setU32("sequence", paramCUnregisterAppMsg.sequence);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateBlockListMsg(CUpdateBlockListMsg paramCUpdateBlockListMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(218);
    localMessageWrite.setU32("sequence", paramCUpdateBlockListMsg.sequence);
    localMessageWrite.setStringArray("blockedNumbers", paramCUpdateBlockListMsg.blockedNumbers);
    if (paramCUpdateBlockListMsg.blockedNumbersWithFlags != null)
    {
      MessageWrite[] arrayOfMessageWrite = new MessageWrite[paramCUpdateBlockListMsg.blockedNumbersWithFlags.length];
      for (int i = 0; i < arrayOfMessageWrite.length; i++)
        arrayOfMessageWrite[i] = write_CBlockedUserInfo(paramCUpdateBlockListMsg.blockedNumbersWithFlags[i]);
      localMessageWrite.setMessageArray("blockedNumbersWithFlags", arrayOfMessageWrite);
    }
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateCommunityPrivilegesMsg(CUpdateCommunityPrivilegesMsg paramCUpdateCommunityPrivilegesMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(534);
    localMessageWrite.setU32("Seq", paramCUpdateCommunityPrivilegesMsg.seq);
    localMessageWrite.setU64("GroupID", paramCUpdateCommunityPrivilegesMsg.groupID);
    localMessageWrite.setU64("GlobalPrivileges", paramCUpdateCommunityPrivilegesMsg.globalPrivileges);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateCommunitySettingsMsg(CUpdateCommunitySettingsMsg paramCUpdateCommunitySettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(530);
    localMessageWrite.setU32("Seq", paramCUpdateCommunitySettingsMsg.seq);
    localMessageWrite.setU64("GroupId", paramCUpdateCommunitySettingsMsg.groupId);
    localMessageWrite.setU8("DisplayInvitationLink", (byte)paramCUpdateCommunitySettingsMsg.displayInvitationLink);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateLanguageMsg(CUpdateLanguageMsg paramCUpdateLanguageMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(239);
    localMessageWrite.setString("OsLanguage", paramCUpdateLanguageMsg.osLanguage);
    if (paramCUpdateLanguageMsg.viberLanguage != null)
      localMessageWrite.setString("ViberLanguage", paramCUpdateLanguageMsg.viberLanguage);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateMyCommunitySettingsMsg(CUpdateMyCommunitySettingsMsg paramCUpdateMyCommunitySettingsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(714);
    localMessageWrite.setU32("Seq", paramCUpdateMyCommunitySettingsMsg.seq);
    localMessageWrite.setU64("GroupId", paramCUpdateMyCommunitySettingsMsg.groupId);
    localMessageWrite.setString("Settings", paramCUpdateMyCommunitySettingsMsg.settings);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdatePersonalDetailsMsg(CUpdatePersonalDetailsMsg paramCUpdatePersonalDetailsMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(730);
    localMessageWrite.setU32("Seq", paramCUpdatePersonalDetailsMsg.seq);
    localMessageWrite.setU16("UpdateType", (short)paramCUpdatePersonalDetailsMsg.updateType);
    if (paramCUpdatePersonalDetailsMsg.email != null)
      localMessageWrite.setString("Email", paramCUpdatePersonalDetailsMsg.email);
    if (paramCUpdatePersonalDetailsMsg.emailIsRemove != null)
      localMessageWrite.setBoolean("EmailIsRemove", paramCUpdatePersonalDetailsMsg.emailIsRemove.booleanValue());
    if (paramCUpdatePersonalDetailsMsg.emailConsent != null)
      localMessageWrite.setBoolean("EmailConsent", paramCUpdatePersonalDetailsMsg.emailConsent.booleanValue());
    if (paramCUpdatePersonalDetailsMsg.emailOrigin != null)
      localMessageWrite.setU32("EmailOrigin", paramCUpdatePersonalDetailsMsg.emailOrigin.intValue());
    if (paramCUpdatePersonalDetailsMsg.emailCampaign != null)
      localMessageWrite.setU32("EmailCampaign", paramCUpdatePersonalDetailsMsg.emailCampaign.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateSelfUserDetailsAckMsg(CUpdateSelfUserDetailsAckMsg paramCUpdateSelfUserDetailsAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(162);
    localMessageWrite.setU64("Token", paramCUpdateSelfUserDetailsAckMsg.token);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateUnsavedContactDetailsAckMsg(CUpdateUnsavedContactDetailsAckMsg paramCUpdateUnsavedContactDetailsAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(266);
    localMessageWrite.setU64("Token", paramCUpdateUnsavedContactDetailsAckMsg.token);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateUserDateOfBirthMsg(CUpdateUserDateOfBirthMsg paramCUpdateUserDateOfBirthMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(538);
    localMessageWrite.setU32("Seq", paramCUpdateUserDateOfBirthMsg.seq);
    localMessageWrite.setU8("Day", paramCUpdateUserDateOfBirthMsg.day);
    localMessageWrite.setU8("Month", paramCUpdateUserDateOfBirthMsg.month);
    localMessageWrite.setU16("Year", paramCUpdateUserDateOfBirthMsg.year);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateUserNameMsg(CUpdateUserNameMsg paramCUpdateUserNameMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(121);
    localMessageWrite.setString("NewName", paramCUpdateUserNameMsg.newName);
    return localMessageWrite;
  }

  static MessageWrite write_CUpdateUserPhotoMsg(CUpdateUserPhotoMsg paramCUpdateUserPhotoMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(117);
    localMessageWrite.setU64("PhotoID", paramCUpdateUserPhotoMsg.photoID);
    return localMessageWrite;
  }

  static MessageWrite write_CUserIsTypingMsg(CUserIsTypingMsg paramCUserIsTypingMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(42);
    localMessageWrite.setString("ToNumber", paramCUserIsTypingMsg.toNumber);
    if (paramCUserIsTypingMsg.active != null)
      localMessageWrite.setBoolean("Active", paramCUserIsTypingMsg.active.booleanValue());
    if (paramCUserIsTypingMsg.chatType != null)
      localMessageWrite.setU16("ChatType", (short)paramCUserIsTypingMsg.chatType.intValue());
    return localMessageWrite;
  }

  static MessageWrite write_CValidateGroupUriMsg(CValidateGroupUriMsg paramCValidateGroupUriMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(206);
    localMessageWrite.setString("GroupUri", paramCValidateGroupUriMsg.groupUri);
    localMessageWrite.setU32("Context", paramCValidateGroupUriMsg.context);
    return localMessageWrite;
  }

  static MessageWrite write_CWebNotificationAckMsg(CWebNotificationAckMsg paramCWebNotificationAckMsg)
  {
    MessageWrite localMessageWrite = new MessageWrite(260);
    localMessageWrite.setU64("Token", paramCWebNotificationAckMsg.token);
    return localMessageWrite;
  }

  static MessageWrite write_ConversationToken(ConversationToken paramConversationToken)
  {
    MessageWrite localMessageWrite = new MessageWrite("ConversationToken");
    localMessageWrite.setU64("Token", paramConversationToken.token);
    localMessageWrite.setString("PeerNum", paramConversationToken.peerNum);
    return localMessageWrite;
  }

  static MessageWrite write_GroupAddMember(GroupAddMember paramGroupAddMember)
  {
    MessageWrite localMessageWrite = new MessageWrite("GroupAddMember");
    localMessageWrite.setString("PhoneNumber", paramGroupAddMember.phoneNumber);
    localMessageWrite.setU32("Role", paramGroupAddMember.role);
    return localMessageWrite;
  }

  static MessageWrite write_GroupToken(GroupToken paramGroupToken)
  {
    MessageWrite localMessageWrite = new MessageWrite("GroupToken");
    localMessageWrite.setU64("Token", paramGroupToken.token);
    localMessageWrite.setU64("GroupID", paramGroupToken.groupID);
    return localMessageWrite;
  }

  static MessageWrite write_Location(Location paramLocation)
  {
    MessageWrite localMessageWrite = new MessageWrite("Location");
    localMessageWrite.setS32("longitude", paramLocation.longitude);
    localMessageWrite.setS32("latitude", paramLocation.latitude);
    return localMessageWrite;
  }

  static MessageWrite write_MediaObjectDetails(MediaObjectDetails paramMediaObjectDetails)
  {
    MessageWrite localMessageWrite = new MessageWrite("MediaObjectDetails");
    localMessageWrite.setU64("ObjectID", paramMediaObjectDetails.objectID);
    localMessageWrite.setU8("MediaType", (byte)paramMediaObjectDetails.mediaType);
    localMessageWrite.setU8("GroupType", (byte)paramMediaObjectDetails.groupType);
    return localMessageWrite;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Im2Bridge
 * JD-Core Version:    0.6.2
 */