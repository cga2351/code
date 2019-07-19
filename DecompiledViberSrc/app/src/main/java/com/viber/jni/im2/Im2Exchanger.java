package com.viber.jni.im2;

import android.os.Handler;

public class Im2Exchanger
  implements Im2Sender
{
  private Im2Dispatcher mDispatcher;
  private Im2Sender mSender;

  public Im2Exchanger(Im2Sender paramIm2Sender, Im2Dispatcher paramIm2Dispatcher)
  {
    this.mSender = paramIm2Sender;
    this.mDispatcher = paramIm2Dispatcher;
  }

  public Im2Receiver getIm2Receiver()
  {
    return this.mDispatcher;
  }

  public void handleCAcceptGroupInviteMsg(CAcceptGroupInviteMsg paramCAcceptGroupInviteMsg)
  {
    this.mSender.handleCAcceptGroupInviteMsg(paramCAcceptGroupInviteMsg);
  }

  public void handleCActOnViberIdPasswordMsg(CActOnViberIdPasswordMsg paramCActOnViberIdPasswordMsg)
  {
    this.mSender.handleCActOnViberIdPasswordMsg(paramCActOnViberIdPasswordMsg);
  }

  public void handleCAddressBookDeltaUpdateAckMsg(CAddressBookDeltaUpdateAckMsg paramCAddressBookDeltaUpdateAckMsg)
  {
    this.mSender.handleCAddressBookDeltaUpdateAckMsg(paramCAddressBookDeltaUpdateAckMsg);
  }

  public void handleCAddressBookForSecondaryAckMsg(CAddressBookForSecondaryAckMsg paramCAddressBookForSecondaryAckMsg)
  {
    this.mSender.handleCAddressBookForSecondaryAckMsg(paramCAddressBookForSecondaryAckMsg);
  }

  public void handleCAuthenticateAppMsg(CAuthenticateAppMsg paramCAuthenticateAppMsg)
  {
    this.mSender.handleCAuthenticateAppMsg(paramCAuthenticateAppMsg);
  }

  public void handleCBillingTokenByMidMsg(CBillingTokenByMidMsg paramCBillingTokenByMidMsg)
  {
    this.mSender.handleCBillingTokenByMidMsg(paramCBillingTokenByMidMsg);
  }

  public void handleCBillingTokenMsg(CBillingTokenMsg paramCBillingTokenMsg)
  {
    this.mSender.handleCBillingTokenMsg(paramCBillingTokenMsg);
  }

  public void handleCBlockAppMsg(CBlockAppMsg paramCBlockAppMsg)
  {
    this.mSender.handleCBlockAppMsg(paramCBlockAppMsg);
  }

  public void handleCBlockGroupInviteMsg(CBlockGroupInviteMsg paramCBlockGroupInviteMsg)
  {
    this.mSender.handleCBlockGroupInviteMsg(paramCBlockGroupInviteMsg);
  }

  public void handleCChangeConversationSettingsMsg(CChangeConversationSettingsMsg paramCChangeConversationSettingsMsg)
  {
    this.mSender.handleCChangeConversationSettingsMsg(paramCChangeConversationSettingsMsg);
  }

  public void handleCChangeGroupAttributesMsg(CChangeGroupAttributesMsg paramCChangeGroupAttributesMsg)
  {
    this.mSender.handleCChangeGroupAttributesMsg(paramCChangeGroupAttributesMsg);
  }

  public void handleCChangeGroupSettingsMsg(CChangeGroupSettingsMsg paramCChangeGroupSettingsMsg)
  {
    this.mSender.handleCChangeGroupSettingsMsg(paramCChangeGroupSettingsMsg);
  }

  public void handleCChangeLastOnlineSettingsMsg(CChangeLastOnlineSettingsMsg paramCChangeLastOnlineSettingsMsg)
  {
    this.mSender.handleCChangeLastOnlineSettingsMsg(paramCChangeLastOnlineSettingsMsg);
  }

  public void handleCChangeReadNotificationsSettingsMsg(CChangeReadNotificationsSettingsMsg paramCChangeReadNotificationsSettingsMsg)
  {
    this.mSender.handleCChangeReadNotificationsSettingsMsg(paramCChangeReadNotificationsSettingsMsg);
  }

  public void handleCChangeSettingsMsg(CChangeSettingsMsg paramCChangeSettingsMsg)
  {
    this.mSender.handleCChangeSettingsMsg(paramCChangeSettingsMsg);
  }

  public void handleCChangeUserActivitySettingsMsg(CChangeUserActivitySettingsMsg paramCChangeUserActivitySettingsMsg)
  {
    this.mSender.handleCChangeUserActivitySettingsMsg(paramCChangeUserActivitySettingsMsg);
  }

  public void handleCChangeViberIdEmailMsg(CChangeViberIdEmailMsg paramCChangeViberIdEmailMsg)
  {
    this.mSender.handleCChangeViberIdEmailMsg(paramCChangeViberIdEmailMsg);
  }

  public void handleCCheckAllowsM2MChatMsg(CCheckAllowsM2MChatMsg paramCCheckAllowsM2MChatMsg)
  {
    this.mSender.handleCCheckAllowsM2MChatMsg(paramCCheckAllowsM2MChatMsg);
  }

  public void handleCCheckEmailStatusMsg(CCheckEmailStatusMsg paramCCheckEmailStatusMsg)
  {
    this.mSender.handleCCheckEmailStatusMsg(paramCCheckEmailStatusMsg);
  }

  public void handleCCheckGroup2InviteMsg(CCheckGroup2InviteMsg paramCCheckGroup2InviteMsg)
  {
    this.mSender.handleCCheckGroup2InviteMsg(paramCCheckGroup2InviteMsg);
  }

  public void handleCConfirmOrRevokeEmailMsg(CConfirmOrRevokeEmailMsg paramCConfirmOrRevokeEmailMsg)
  {
    this.mSender.handleCConfirmOrRevokeEmailMsg(paramCConfirmOrRevokeEmailMsg);
  }

  public void handleCContactSavedInConversationNotificationMsg(CContactSavedInConversationNotificationMsg paramCContactSavedInConversationNotificationMsg)
  {
    this.mSender.handleCContactSavedInConversationNotificationMsg(paramCContactSavedInConversationNotificationMsg);
  }

  public void handleCConversationSynchedAckMsg(CConversationSynchedAckMsg paramCConversationSynchedAckMsg)
  {
    this.mSender.handleCConversationSynchedAckMsg(paramCConversationSynchedAckMsg);
  }

  public void handleCCreateConferenceCallMsg(CCreateConferenceCallMsg paramCCreateConferenceCallMsg)
  {
    this.mSender.handleCCreateConferenceCallMsg(paramCCreateConferenceCallMsg);
  }

  public void handleCCreateGroup2InviteMsg(CCreateGroup2InviteMsg paramCCreateGroup2InviteMsg)
  {
    this.mSender.handleCCreateGroup2InviteMsg(paramCCreateGroup2InviteMsg);
  }

  public void handleCCreateGroupInviteMsg(CCreateGroupInviteMsg paramCCreateGroupInviteMsg)
  {
    this.mSender.handleCCreateGroupInviteMsg(paramCCreateGroupInviteMsg);
  }

  public void handleCCreateGroupMsg(CCreateGroupMsg paramCCreateGroupMsg)
  {
    this.mSender.handleCCreateGroupMsg(paramCCreateGroupMsg);
  }

  public void handleCDeleteAllUserMessagesMsg(CDeleteAllUserMessagesMsg paramCDeleteAllUserMessagesMsg)
  {
    this.mSender.handleCDeleteAllUserMessagesMsg(paramCDeleteAllUserMessagesMsg);
  }

  public void handleCDeleteGlobalMessageMsg(CDeleteGlobalMessageMsg paramCDeleteGlobalMessageMsg)
  {
    this.mSender.handleCDeleteGlobalMessageMsg(paramCDeleteGlobalMessageMsg);
  }

  public void handleCDeleteMessageMsg(CDeleteMessageMsg paramCDeleteMessageMsg)
  {
    this.mSender.handleCDeleteMessageMsg(paramCDeleteMessageMsg);
  }

  public void handleCDeletedMessageAckMsg(CDeletedMessageAckMsg paramCDeletedMessageAckMsg)
  {
    this.mSender.handleCDeletedMessageAckMsg(paramCDeletedMessageAckMsg);
  }

  public void handleCGdprCommandMsg(CGdprCommandMsg paramCGdprCommandMsg)
  {
    this.mSender.handleCGdprCommandMsg(paramCGdprCommandMsg);
  }

  public void handleCGetAdInfoMsg(CGetAdInfoMsg paramCGetAdInfoMsg)
  {
    this.mSender.handleCGetAdInfoMsg(paramCGetAdInfoMsg);
  }

  public void handleCGetCommonCommunitiesMsg(CGetCommonCommunitiesMsg paramCGetCommonCommunitiesMsg)
  {
    this.mSender.handleCGetCommonCommunitiesMsg(paramCGetCommonCommunitiesMsg);
  }

  public void handleCGetDownloadDetailsMsg(CGetDownloadDetailsMsg paramCGetDownloadDetailsMsg)
  {
    this.mSender.handleCGetDownloadDetailsMsg(paramCGetDownloadDetailsMsg);
  }

  public void handleCGetEncryptedMIDsMsg(CGetEncryptedMIDsMsg paramCGetEncryptedMIDsMsg)
  {
    this.mSender.handleCGetEncryptedMIDsMsg(paramCGetEncryptedMIDsMsg);
  }

  public void handleCGetGroup2AccessTokenMsg(CGetGroup2AccessTokenMsg paramCGetGroup2AccessTokenMsg)
  {
    this.mSender.handleCGetGroup2AccessTokenMsg(paramCGetGroup2AccessTokenMsg);
  }

  public void handleCGetGroupInfoMsg(CGetGroupInfoMsg paramCGetGroupInfoMsg)
  {
    this.mSender.handleCGetGroupInfoMsg(paramCGetGroupInfoMsg);
  }

  public void handleCGetGroupMessageStatusMsg(CGetGroupMessageStatusMsg paramCGetGroupMessageStatusMsg)
  {
    this.mSender.handleCGetGroupMessageStatusMsg(paramCGetGroupMessageStatusMsg);
  }

  public void handleCGetInviteLinksMsg(CGetInviteLinksMsg paramCGetInviteLinksMsg)
  {
    this.mSender.handleCGetInviteLinksMsg(paramCGetInviteLinksMsg);
  }

  public void handleCGetLastOnlineMsg(CGetLastOnlineMsg paramCGetLastOnlineMsg)
  {
    this.mSender.handleCGetLastOnlineMsg(paramCGetLastOnlineMsg);
  }

  public void handleCGetMyCommunitySettingsMsg(CGetMyCommunitySettingsMsg paramCGetMyCommunitySettingsMsg)
  {
    this.mSender.handleCGetMyCommunitySettingsMsg(paramCGetMyCommunitySettingsMsg);
  }

  public void handleCGetPersonalDetailsMsg(CGetPersonalDetailsMsg paramCGetPersonalDetailsMsg)
  {
    this.mSender.handleCGetPersonalDetailsMsg(paramCGetPersonalDetailsMsg);
  }

  public void handleCGetPublicAccountInfoMsg(CGetPublicAccountInfoMsg paramCGetPublicAccountInfoMsg)
  {
    this.mSender.handleCGetPublicAccountInfoMsg(paramCGetPublicAccountInfoMsg);
  }

  public void handleCGetPublicGroupInfoMsg(CGetPublicGroupInfoMsg paramCGetPublicGroupInfoMsg)
  {
    this.mSender.handleCGetPublicGroupInfoMsg(paramCGetPublicGroupInfoMsg);
  }

  public void handleCGetUserActivityMsg(CGetUserActivityMsg paramCGetUserActivityMsg)
  {
    this.mSender.handleCGetUserActivityMsg(paramCGetUserActivityMsg);
  }

  public void handleCGetUserAppsMsg(CGetUserAppsMsg paramCGetUserAppsMsg)
  {
    this.mSender.handleCGetUserAppsMsg(paramCGetUserAppsMsg);
  }

  public void handleCGetUserDateOfBirthMsg(CGetUserDateOfBirthMsg paramCGetUserDateOfBirthMsg)
  {
    this.mSender.handleCGetUserDateOfBirthMsg(paramCGetUserDateOfBirthMsg);
  }

  public void handleCGetUsersDetailsV2Msg(CGetUsersDetailsV2Msg paramCGetUsersDetailsV2Msg)
  {
    this.mSender.handleCGetUsersDetailsV2Msg(paramCGetUsersDetailsV2Msg);
  }

  public void handleCGetViberIdMsg(CGetViberIdMsg paramCGetViberIdMsg)
  {
    this.mSender.handleCGetViberIdMsg(paramCGetViberIdMsg);
  }

  public void handleCGroupAddMemberMsg(CGroupAddMemberMsg paramCGroupAddMemberMsg)
  {
    this.mSender.handleCGroupAddMemberMsg(paramCGroupAddMemberMsg);
  }

  public void handleCGroupAddMembersMsg(CGroupAddMembersMsg paramCGroupAddMembersMsg)
  {
    this.mSender.handleCGroupAddMembersMsg(paramCGroupAddMembersMsg);
  }

  public void handleCGroupAddWatchersMsg(CGroupAddWatchersMsg paramCGroupAddWatchersMsg)
  {
    this.mSender.handleCGroupAddWatchersMsg(paramCGroupAddWatchersMsg);
  }

  public void handleCGroupAssignRoleMsg(CGroupAssignRoleMsg paramCGroupAssignRoleMsg)
  {
    this.mSender.handleCGroupAssignRoleMsg(paramCGroupAssignRoleMsg);
  }

  public void handleCGroupBanUserMsg(CGroupBanUserMsg paramCGroupBanUserMsg)
  {
    this.mSender.handleCGroupBanUserMsg(paramCGroupBanUserMsg);
  }

  public void handleCGroupChangedAckMsg(CGroupChangedAckMsg paramCGroupChangedAckMsg)
  {
    this.mSender.handleCGroupChangedAckMsg(paramCGroupChangedAckMsg);
  }

  public void handleCGroupLeaveMsg(CGroupLeaveMsg paramCGroupLeaveMsg)
  {
    this.mSender.handleCGroupLeaveMsg(paramCGroupLeaveMsg);
  }

  public void handleCGroupMessageLikeAck(CGroupMessageLikeAck paramCGroupMessageLikeAck)
  {
    this.mSender.handleCGroupMessageLikeAck(paramCGroupMessageLikeAck);
  }

  public void handleCGroupRemoveMembersMsg(CGroupRemoveMembersMsg paramCGroupRemoveMembersMsg)
  {
    this.mSender.handleCGroupRemoveMembersMsg(paramCGroupRemoveMembersMsg);
  }

  public void handleCGroupSynchedAckMsg(CGroupSynchedAckMsg paramCGroupSynchedAckMsg)
  {
    this.mSender.handleCGroupSynchedAckMsg(paramCGroupSynchedAckMsg);
  }

  public void handleCGroupUserIsTypingMsg(CGroupUserIsTypingMsg paramCGroupUserIsTypingMsg)
  {
    this.mSender.handleCGroupUserIsTypingMsg(paramCGroupUserIsTypingMsg);
  }

  public void handleCInviteToConferenceMsg(CInviteToConferenceMsg paramCInviteToConferenceMsg)
  {
    this.mSender.handleCInviteToConferenceMsg(paramCInviteToConferenceMsg);
  }

  public void handleCIsOnlineMsg(CIsOnlineMsg paramCIsOnlineMsg)
  {
    this.mSender.handleCIsOnlineMsg(paramCIsOnlineMsg);
  }

  public void handleCIsRegisteredNumberMsg(CIsRegisteredNumberMsg paramCIsRegisteredNumberMsg)
  {
    this.mSender.handleCIsRegisteredNumberMsg(paramCIsRegisteredNumberMsg);
  }

  public void handleCJoinConfCallMsg(CJoinConfCallMsg paramCJoinConfCallMsg)
  {
    this.mSender.handleCJoinConfCallMsg(paramCJoinConfCallMsg);
  }

  public void handleCLateErrorOnReceivedMessageMsg(CLateErrorOnReceivedMessageMsg paramCLateErrorOnReceivedMessageMsg)
  {
    this.mSender.handleCLateErrorOnReceivedMessageMsg(paramCLateErrorOnReceivedMessageMsg);
  }

  public void handleCLikeGroupMessage(CLikeGroupMessage paramCLikeGroupMessage)
  {
    this.mSender.handleCLikeGroupMessage(paramCLikeGroupMessage);
  }

  public void handleCMessageDeliveredAckMsg(CMessageDeliveredAckMsg paramCMessageDeliveredAckMsg)
  {
    this.mSender.handleCMessageDeliveredAckMsg(paramCMessageDeliveredAckMsg);
  }

  public void handleCMessageReceivedAckMsg(CMessageReceivedAckMsg paramCMessageReceivedAckMsg)
  {
    this.mSender.handleCMessageReceivedAckMsg(paramCMessageReceivedAckMsg);
  }

  public void handleCMessageReceivedReplyableAckMsg(CMessageReceivedReplyableAckMsg paramCMessageReceivedReplyableAckMsg)
  {
    this.mSender.handleCMessageReceivedReplyableAckMsg(paramCMessageReceivedReplyableAckMsg);
  }

  public void handleCMessagesSynchedAckMsg(CMessagesSynchedAckMsg paramCMessagesSynchedAckMsg)
  {
    this.mSender.handleCMessagesSynchedAckMsg(paramCMessagesSynchedAckMsg);
  }

  public void handleCOnClickMsg(COnClickMsg paramCOnClickMsg)
  {
    this.mSender.handleCOnClickMsg(paramCOnClickMsg);
  }

  public void handleCPublicAccountSubscriberUpdateMsg(CPublicAccountSubscriberUpdateMsg paramCPublicAccountSubscriberUpdateMsg)
  {
    this.mSender.handleCPublicAccountSubscriberUpdateMsg(paramCPublicAccountSubscriberUpdateMsg);
  }

  public void handleCQueryDestOperationSupportMsg(CQueryDestOperationSupportMsg paramCQueryDestOperationSupportMsg)
  {
    this.mSender.handleCQueryDestOperationSupportMsg(paramCQueryDestOperationSupportMsg);
  }

  public void handleCRecoverGroupChatsMsg(CRecoverGroupChatsMsg paramCRecoverGroupChatsMsg)
  {
    this.mSender.handleCRecoverGroupChatsMsg(paramCRecoverGroupChatsMsg);
  }

  public void handleCRecoverGroupsMsg(CRecoverGroupsMsg paramCRecoverGroupsMsg)
  {
    this.mSender.handleCRecoverGroupsMsg(paramCRecoverGroupsMsg);
  }

  public void handleCRecoverPublicAccountsMsg(CRecoverPublicAccountsMsg paramCRecoverPublicAccountsMsg)
  {
    this.mSender.handleCRecoverPublicAccountsMsg(paramCRecoverPublicAccountsMsg);
  }

  public void handleCRecvInternalMsgAck(CRecvInternalMsgAck paramCRecvInternalMsgAck)
  {
    this.mSender.handleCRecvInternalMsgAck(paramCRecvInternalMsgAck);
  }

  public void handleCRefreshPublicAccountTokenMsg(CRefreshPublicAccountTokenMsg paramCRefreshPublicAccountTokenMsg)
  {
    this.mSender.handleCRefreshPublicAccountTokenMsg(paramCRefreshPublicAccountTokenMsg);
  }

  public void handleCRegisterViberIdMsg(CRegisterViberIdMsg paramCRegisterViberIdMsg)
  {
    this.mSender.handleCRegisterViberIdMsg(paramCRegisterViberIdMsg);
  }

  public void handleCRegisteredNumbersAckMsg(CRegisteredNumbersAckMsg paramCRegisteredNumbersAckMsg)
  {
    this.mSender.handleCRegisteredNumbersAckMsg(paramCRegisteredNumbersAckMsg);
  }

  public void handleCRevokeGroup2InviteMsg(CRevokeGroup2InviteMsg paramCRevokeGroup2InviteMsg)
  {
    this.mSender.handleCRevokeGroup2InviteMsg(paramCRevokeGroup2InviteMsg);
  }

  public void handleCRevokeGroupInviteMsg(CRevokeGroupInviteMsg paramCRevokeGroupInviteMsg)
  {
    this.mSender.handleCRevokeGroupInviteMsg(paramCRevokeGroupInviteMsg);
  }

  public void handleCSecretChatReceivedEventAckMsg(CSecretChatReceivedEventAckMsg paramCSecretChatReceivedEventAckMsg)
  {
    this.mSender.handleCSecretChatReceivedEventAckMsg(paramCSecretChatReceivedEventAckMsg);
  }

  public void handleCSecretChatSendEventMsg(CSecretChatSendEventMsg paramCSecretChatSendEventMsg)
  {
    this.mSender.handleCSecretChatSendEventMsg(paramCSecretChatSendEventMsg);
  }

  public void handleCSendActionOnPGMsg(CSendActionOnPGMsg paramCSendActionOnPGMsg)
  {
    this.mSender.handleCSendActionOnPGMsg(paramCSendActionOnPGMsg);
  }

  public void handleCSendActionToBotMsg(CSendActionToBotMsg paramCSendActionToBotMsg)
  {
    this.mSender.handleCSendActionToBotMsg(paramCSendActionToBotMsg);
  }

  public void handleCSendBackAckBase(CSendBackAckBase paramCSendBackAckBase)
  {
    this.mSender.handleCSendBackAckBase(paramCSendBackAckBase);
  }

  public void handleCSendBannerToClientAckMsg(CSendBannerToClientAckMsg paramCSendBannerToClientAckMsg)
  {
    this.mSender.handleCSendBannerToClientAckMsg(paramCSendBannerToClientAckMsg);
  }

  public void handleCSendConversationStatusMsg(CSendConversationStatusMsg paramCSendConversationStatusMsg)
  {
    this.mSender.handleCSendConversationStatusMsg(paramCSendConversationStatusMsg);
  }

  public void handleCSendGroupMsg(CSendGroupMsg paramCSendGroupMsg)
  {
    this.mSender.handleCSendGroupMsg(paramCSendGroupMsg);
  }

  public void handleCSendInternalMsg(CSendInternalMsg paramCSendInternalMsg)
  {
    this.mSender.handleCSendInternalMsg(paramCSendInternalMsg);
  }

  public void handleCSendMessageMsg(CSendMessageMsg paramCSendMessageMsg)
  {
    this.mSender.handleCSendMessageMsg(paramCSendMessageMsg);
  }

  public void handleCSendPublicGroupInviteMsg(CSendPublicGroupInviteMsg paramCSendPublicGroupInviteMsg)
  {
    this.mSender.handleCSendPublicGroupInviteMsg(paramCSendPublicGroupInviteMsg);
  }

  public void handleCShareAddressBook2Msg(CShareAddressBook2Msg paramCShareAddressBook2Msg)
  {
    this.mSender.handleCShareAddressBook2Msg(paramCShareAddressBook2Msg);
  }

  public void handleCShareDeltaAddressBookMsg(CShareDeltaAddressBookMsg paramCShareDeltaAddressBookMsg)
  {
    this.mSender.handleCShareDeltaAddressBookMsg(paramCShareDeltaAddressBookMsg);
  }

  public void handleCSyncActionOnPGAckMsg(CSyncActionOnPGAckMsg paramCSyncActionOnPGAckMsg)
  {
    this.mSender.handleCSyncActionOnPGAckMsg(paramCSyncActionOnPGAckMsg);
  }

  public void handleCSyncConversationMsg(CSyncConversationMsg paramCSyncConversationMsg)
  {
    this.mSender.handleCSyncConversationMsg(paramCSyncConversationMsg);
  }

  public void handleCSyncDataFromMyOtherDeviceAckMsg(CSyncDataFromMyOtherDeviceAckMsg paramCSyncDataFromMyOtherDeviceAckMsg)
  {
    this.mSender.handleCSyncDataFromMyOtherDeviceAckMsg(paramCSyncDataFromMyOtherDeviceAckMsg);
  }

  public void handleCSyncDataToMyDevicesMsg(CSyncDataToMyDevicesMsg paramCSyncDataToMyDevicesMsg)
  {
    this.mSender.handleCSyncDataToMyDevicesMsg(paramCSyncDataToMyDevicesMsg);
  }

  public void handleCSyncGroupMsg(CSyncGroupMsg paramCSyncGroupMsg)
  {
    this.mSender.handleCSyncGroupMsg(paramCSyncGroupMsg);
  }

  public void handleCSyncMessagesMsg(CSyncMessagesMsg paramCSyncMessagesMsg)
  {
    this.mSender.handleCSyncMessagesMsg(paramCSyncMessagesMsg);
  }

  public void handleCUnlinkViberIdMsg(CUnlinkViberIdMsg paramCUnlinkViberIdMsg)
  {
    this.mSender.handleCUnlinkViberIdMsg(paramCUnlinkViberIdMsg);
  }

  public void handleCUnregisterAppMsg(CUnregisterAppMsg paramCUnregisterAppMsg)
  {
    this.mSender.handleCUnregisterAppMsg(paramCUnregisterAppMsg);
  }

  public void handleCUpdateBlockListMsg(CUpdateBlockListMsg paramCUpdateBlockListMsg)
  {
    this.mSender.handleCUpdateBlockListMsg(paramCUpdateBlockListMsg);
  }

  public void handleCUpdateCommunityPrivilegesMsg(CUpdateCommunityPrivilegesMsg paramCUpdateCommunityPrivilegesMsg)
  {
    this.mSender.handleCUpdateCommunityPrivilegesMsg(paramCUpdateCommunityPrivilegesMsg);
  }

  public void handleCUpdateCommunitySettingsMsg(CUpdateCommunitySettingsMsg paramCUpdateCommunitySettingsMsg)
  {
    this.mSender.handleCUpdateCommunitySettingsMsg(paramCUpdateCommunitySettingsMsg);
  }

  public void handleCUpdateLanguageMsg(CUpdateLanguageMsg paramCUpdateLanguageMsg)
  {
    this.mSender.handleCUpdateLanguageMsg(paramCUpdateLanguageMsg);
  }

  public void handleCUpdateMyCommunitySettingsMsg(CUpdateMyCommunitySettingsMsg paramCUpdateMyCommunitySettingsMsg)
  {
    this.mSender.handleCUpdateMyCommunitySettingsMsg(paramCUpdateMyCommunitySettingsMsg);
  }

  public void handleCUpdatePersonalDetailsMsg(CUpdatePersonalDetailsMsg paramCUpdatePersonalDetailsMsg)
  {
    this.mSender.handleCUpdatePersonalDetailsMsg(paramCUpdatePersonalDetailsMsg);
  }

  public void handleCUpdateSelfUserDetailsAckMsg(CUpdateSelfUserDetailsAckMsg paramCUpdateSelfUserDetailsAckMsg)
  {
    this.mSender.handleCUpdateSelfUserDetailsAckMsg(paramCUpdateSelfUserDetailsAckMsg);
  }

  public void handleCUpdateUnsavedContactDetailsAckMsg(CUpdateUnsavedContactDetailsAckMsg paramCUpdateUnsavedContactDetailsAckMsg)
  {
    this.mSender.handleCUpdateUnsavedContactDetailsAckMsg(paramCUpdateUnsavedContactDetailsAckMsg);
  }

  public void handleCUpdateUserDateOfBirthMsg(CUpdateUserDateOfBirthMsg paramCUpdateUserDateOfBirthMsg)
  {
    this.mSender.handleCUpdateUserDateOfBirthMsg(paramCUpdateUserDateOfBirthMsg);
  }

  public void handleCUpdateUserNameMsg(CUpdateUserNameMsg paramCUpdateUserNameMsg)
  {
    this.mSender.handleCUpdateUserNameMsg(paramCUpdateUserNameMsg);
  }

  public void handleCUpdateUserPhotoMsg(CUpdateUserPhotoMsg paramCUpdateUserPhotoMsg)
  {
    this.mSender.handleCUpdateUserPhotoMsg(paramCUpdateUserPhotoMsg);
  }

  public void handleCUserIsTypingMsg(CUserIsTypingMsg paramCUserIsTypingMsg)
  {
    this.mSender.handleCUserIsTypingMsg(paramCUserIsTypingMsg);
  }

  public void handleCValidateGroupUriMsg(CValidateGroupUriMsg paramCValidateGroupUriMsg)
  {
    this.mSender.handleCValidateGroupUriMsg(paramCValidateGroupUriMsg);
  }

  public void handleCWebNotificationAckMsg(CWebNotificationAckMsg paramCWebNotificationAckMsg)
  {
    this.mSender.handleCWebNotificationAckMsg(paramCWebNotificationAckMsg);
  }

  public void registerDelegate(Im2ReceiverBase paramIm2ReceiverBase, Handler paramHandler)
  {
    this.mDispatcher.registerDelegate(paramIm2ReceiverBase, paramHandler);
  }

  public void registerDelegate(Im2ReceiverBase[] paramArrayOfIm2ReceiverBase)
  {
    this.mDispatcher.registerDelegate(paramArrayOfIm2ReceiverBase);
  }

  public void removeDelegate(Im2ReceiverBase paramIm2ReceiverBase)
  {
    this.mDispatcher.removeDelegate(paramIm2ReceiverBase);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Im2Exchanger
 * JD-Core Version:    0.6.2
 */