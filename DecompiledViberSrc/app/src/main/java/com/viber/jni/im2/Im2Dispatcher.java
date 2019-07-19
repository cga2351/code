package com.viber.jni.im2;

import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import java.util.HashMap;

public class Im2Dispatcher extends Im2DispatcherBase
  implements Im2Receiver
{
  private CAcceptGroupInviteReplyMsg_dispatcher mCAcceptGroupInviteReplyMsg_dispatcher = new CAcceptGroupInviteReplyMsg_dispatcher(null);
  private CActOnViberIdPasswordReplyMsg_dispatcher mCActOnViberIdPasswordReplyMsg_dispatcher = new CActOnViberIdPasswordReplyMsg_dispatcher(null);
  private CAddressBookDeltaUpdateV2Msg_dispatcher mCAddressBookDeltaUpdateV2Msg_dispatcher = new CAddressBookDeltaUpdateV2Msg_dispatcher(null);
  private CAddressBookForSecondaryV2Msg_dispatcher mCAddressBookForSecondaryV2Msg_dispatcher = new CAddressBookForSecondaryV2Msg_dispatcher(null);
  private CAuthenticateAppReplyMsg_dispatcher mCAuthenticateAppReplyMsg_dispatcher = new CAuthenticateAppReplyMsg_dispatcher(null);
  private CBillingTokenByMidReplyMsg_dispatcher mCBillingTokenByMidReplyMsg_dispatcher = new CBillingTokenByMidReplyMsg_dispatcher(null);
  private CBillingTokenReplyMsg_dispatcher mCBillingTokenReplyMsg_dispatcher = new CBillingTokenReplyMsg_dispatcher(null);
  private CBlockAppReplyMsg_dispatcher mCBlockAppReplyMsg_dispatcher = new CBlockAppReplyMsg_dispatcher(null);
  private CBlockGroupInviteReplyMsg_dispatcher mCBlockGroupInviteReplyMsg_dispatcher = new CBlockGroupInviteReplyMsg_dispatcher(null);
  private CChangeConversationSettingsReplyMsg_dispatcher mCChangeConversationSettingsReplyMsg_dispatcher = new CChangeConversationSettingsReplyMsg_dispatcher(null);
  private CChangeGroupAttributesReplyMsg_dispatcher mCChangeGroupAttributesReplyMsg_dispatcher = new CChangeGroupAttributesReplyMsg_dispatcher(null);
  private CChangeGroupSettingsReplyMsg_dispatcher mCChangeGroupSettingsReplyMsg_dispatcher = new CChangeGroupSettingsReplyMsg_dispatcher(null);
  private CChangeLastOnlineSettingsReplyMsg_dispatcher mCChangeLastOnlineSettingsReplyMsg_dispatcher = new CChangeLastOnlineSettingsReplyMsg_dispatcher(null);
  private CChangeReadNotificationsSettingsReplyMsg_dispatcher mCChangeReadNotificationsSettingsReplyMsg_dispatcher = new CChangeReadNotificationsSettingsReplyMsg_dispatcher(null);
  private CChangeSettingsReplyMsg_dispatcher mCChangeSettingsReplyMsg_dispatcher = new CChangeSettingsReplyMsg_dispatcher(null);
  private CChangeUserActivitySettingsReplyMsg_dispatcher mCChangeUserActivitySettingsReplyMsg_dispatcher = new CChangeUserActivitySettingsReplyMsg_dispatcher(null);
  private CChangeViberIdEmailReplyMsg_dispatcher mCChangeViberIdEmailReplyMsg_dispatcher = new CChangeViberIdEmailReplyMsg_dispatcher(null);
  private CCheckAllowsM2MChatReplyMsg_dispatcher mCCheckAllowsM2MChatReplyMsg_dispatcher = new CCheckAllowsM2MChatReplyMsg_dispatcher(null);
  private CCheckEmailStatusReplyMsg_dispatcher mCCheckEmailStatusReplyMsg_dispatcher = new CCheckEmailStatusReplyMsg_dispatcher(null);
  private CCheckGroup2InviteReplyMsg_dispatcher mCCheckGroup2InviteReplyMsg_dispatcher = new CCheckGroup2InviteReplyMsg_dispatcher(null);
  private CConfirmOrRevokeEmailReplyMsg_dispatcher mCConfirmOrRevokeEmailReplyMsg_dispatcher = new CConfirmOrRevokeEmailReplyMsg_dispatcher(null);
  private CContactSavedInConversationNotificationReplyMsg_dispatcher mCContactSavedInConversationNotificationReplyMsg_dispatcher = new CContactSavedInConversationNotificationReplyMsg_dispatcher(null);
  private CConversationSynchedMsg_dispatcher mCConversationSynchedMsg_dispatcher = new CConversationSynchedMsg_dispatcher(null);
  private CCreateConferenceCallReplyMsg_dispatcher mCCreateConferenceCallReplyMsg_dispatcher = new CCreateConferenceCallReplyMsg_dispatcher(null);
  private CCreateGroup2InviteReplyMsg_dispatcher mCCreateGroup2InviteReplyMsg_dispatcher = new CCreateGroup2InviteReplyMsg_dispatcher(null);
  private CCreateGroupInviteReplyMsg_dispatcher mCCreateGroupInviteReplyMsg_dispatcher = new CCreateGroupInviteReplyMsg_dispatcher(null);
  private CCreateGroupReplyMsg_dispatcher mCCreateGroupReplyMsg_dispatcher = new CCreateGroupReplyMsg_dispatcher(null);
  private CDeleteAllUserMessagesReplyMsg_dispatcher mCDeleteAllUserMessagesReplyMsg_dispatcher = new CDeleteAllUserMessagesReplyMsg_dispatcher(null);
  private CDeleteGlobalMessageReplyMsg_dispatcher mCDeleteGlobalMessageReplyMsg_dispatcher = new CDeleteGlobalMessageReplyMsg_dispatcher(null);
  private CDeleteMessageReplyMsg_dispatcher mCDeleteMessageReplyMsg_dispatcher = new CDeleteMessageReplyMsg_dispatcher(null);
  private CDeletedMessageMsg_dispatcher mCDeletedMessageMsg_dispatcher = new CDeletedMessageMsg_dispatcher(null);
  private CGdprCommandReplyMsg_dispatcher mCGdprCommandReplyMsg_dispatcher = new CGdprCommandReplyMsg_dispatcher(null);
  private CGetAdInfoReplyMsg_dispatcher mCGetAdInfoReplyMsg_dispatcher = new CGetAdInfoReplyMsg_dispatcher(null);
  private CGetCommonCommunitiesReplyMsg_dispatcher mCGetCommonCommunitiesReplyMsg_dispatcher = new CGetCommonCommunitiesReplyMsg_dispatcher(null);
  private CGetDownloadDetailsReplyMsg_dispatcher mCGetDownloadDetailsReplyMsg_dispatcher = new CGetDownloadDetailsReplyMsg_dispatcher(null);
  private CGetEncryptedMIDsReplyMsg_dispatcher mCGetEncryptedMIDsReplyMsg_dispatcher = new CGetEncryptedMIDsReplyMsg_dispatcher(null);
  private CGetGroup2AccessTokenReplyMsg_dispatcher mCGetGroup2AccessTokenReplyMsg_dispatcher = new CGetGroup2AccessTokenReplyMsg_dispatcher(null);
  private CGetGroupInfoReplyMsg_dispatcher mCGetGroupInfoReplyMsg_dispatcher = new CGetGroupInfoReplyMsg_dispatcher(null);
  private CGetGroupMessageStatusReplyMsg_dispatcher mCGetGroupMessageStatusReplyMsg_dispatcher = new CGetGroupMessageStatusReplyMsg_dispatcher(null);
  private CGetInviteLinksReplyMsg_dispatcher mCGetInviteLinksReplyMsg_dispatcher = new CGetInviteLinksReplyMsg_dispatcher(null);
  private CGetLastOnlineReplyMsg_dispatcher mCGetLastOnlineReplyMsg_dispatcher = new CGetLastOnlineReplyMsg_dispatcher(null);
  private CGetMyCommunitySettingsReplyMsg_dispatcher mCGetMyCommunitySettingsReplyMsg_dispatcher = new CGetMyCommunitySettingsReplyMsg_dispatcher(null);
  private CGetPersonalDetailsReplyMsg_dispatcher mCGetPersonalDetailsReplyMsg_dispatcher = new CGetPersonalDetailsReplyMsg_dispatcher(null);
  private CGetPersonalProfileReplyMsg_dispatcher mCGetPersonalProfileReplyMsg_dispatcher = new CGetPersonalProfileReplyMsg_dispatcher(null);
  private CGetPublicAccountInfoReplyMsg_dispatcher mCGetPublicAccountInfoReplyMsg_dispatcher = new CGetPublicAccountInfoReplyMsg_dispatcher(null);
  private CGetPublicGroupInfoReplyMsg_dispatcher mCGetPublicGroupInfoReplyMsg_dispatcher = new CGetPublicGroupInfoReplyMsg_dispatcher(null);
  private CGetSecondaryDeviceDetailsReplyMsg_dispatcher mCGetSecondaryDeviceDetailsReplyMsg_dispatcher = new CGetSecondaryDeviceDetailsReplyMsg_dispatcher(null);
  private CGetUserActivityReplyMsg_dispatcher mCGetUserActivityReplyMsg_dispatcher = new CGetUserActivityReplyMsg_dispatcher(null);
  private CGetUserAppsReplyMsg_dispatcher mCGetUserAppsReplyMsg_dispatcher = new CGetUserAppsReplyMsg_dispatcher(null);
  private CGetUserDateOfBirthReplyMsg_dispatcher mCGetUserDateOfBirthReplyMsg_dispatcher = new CGetUserDateOfBirthReplyMsg_dispatcher(null);
  private CGetUsersDetailsV2ReplyMsg_dispatcher mCGetUsersDetailsV2ReplyMsg_dispatcher = new CGetUsersDetailsV2ReplyMsg_dispatcher(null);
  private CGetViberIdReplyMsg_dispatcher mCGetViberIdReplyMsg_dispatcher = new CGetViberIdReplyMsg_dispatcher(null);
  private CGroupAddMemberReplyMsg_dispatcher mCGroupAddMemberReplyMsg_dispatcher = new CGroupAddMemberReplyMsg_dispatcher(null);
  private CGroupAddMembersReplyMsg_dispatcher mCGroupAddMembersReplyMsg_dispatcher = new CGroupAddMembersReplyMsg_dispatcher(null);
  private CGroupAddWatchersReplyMsg_dispatcher mCGroupAddWatchersReplyMsg_dispatcher = new CGroupAddWatchersReplyMsg_dispatcher(null);
  private CGroupAssignRoleReplyMsg_dispatcher mCGroupAssignRoleReplyMsg_dispatcher = new CGroupAssignRoleReplyMsg_dispatcher(null);
  private CGroupBanUserReplyMsg_dispatcher mCGroupBanUserReplyMsg_dispatcher = new CGroupBanUserReplyMsg_dispatcher(null);
  private CGroupChangedMsg_dispatcher mCGroupChangedMsg_dispatcher = new CGroupChangedMsg_dispatcher(null);
  private CGroupLeaveReplyMsg_dispatcher mCGroupLeaveReplyMsg_dispatcher = new CGroupLeaveReplyMsg_dispatcher(null);
  private CGroupMessageLike_dispatcher mCGroupMessageLike_dispatcher = new CGroupMessageLike_dispatcher(null);
  private CGroupMessageReceivedMsg_dispatcher mCGroupMessageReceivedMsg_dispatcher = new CGroupMessageReceivedMsg_dispatcher(null);
  private CGroupRemoveMembersReplyMsg_dispatcher mCGroupRemoveMembersReplyMsg_dispatcher = new CGroupRemoveMembersReplyMsg_dispatcher(null);
  private CGroupSynchedMsg_dispatcher mCGroupSynchedMsg_dispatcher = new CGroupSynchedMsg_dispatcher(null);
  private CInviteToConferenceReplyMsg_dispatcher mCInviteToConferenceReplyMsg_dispatcher = new CInviteToConferenceReplyMsg_dispatcher(null);
  private CIsOnlineReplyMsg_dispatcher mCIsOnlineReplyMsg_dispatcher = new CIsOnlineReplyMsg_dispatcher(null);
  private CIsRegisteredNumberReplyMsg_dispatcher mCIsRegisteredNumberReplyMsg_dispatcher = new CIsRegisteredNumberReplyMsg_dispatcher(null);
  private CJoinConfCallReplyMsg_dispatcher mCJoinConfCallReplyMsg_dispatcher = new CJoinConfCallReplyMsg_dispatcher(null);
  private CLateErrorOnReceivedMessageReplyMsg_dispatcher mCLateErrorOnReceivedMessageReplyMsg_dispatcher = new CLateErrorOnReceivedMessageReplyMsg_dispatcher(null);
  private CLikeGroupMessageReply_dispatcher mCLikeGroupMessageReply_dispatcher = new CLikeGroupMessageReply_dispatcher(null);
  private CLoginReplyMsg_dispatcher mCLoginReplyMsg_dispatcher = new CLoginReplyMsg_dispatcher(null);
  private CMessageDeliveredMsg_dispatcher mCMessageDeliveredMsg_dispatcher = new CMessageDeliveredMsg_dispatcher(null);
  private CMessageReceivedMsg_dispatcher mCMessageReceivedMsg_dispatcher = new CMessageReceivedMsg_dispatcher(null);
  private CMessageReceivedReplyableAckReplyMsg_dispatcher mCMessageReceivedReplyableAckReplyMsg_dispatcher = new CMessageReceivedReplyableAckReplyMsg_dispatcher(null);
  private CMessagesSynchedMsg_dispatcher mCMessagesSynchedMsg_dispatcher = new CMessagesSynchedMsg_dispatcher(null);
  private COnClickReplyMsg_dispatcher mCOnClickReplyMsg_dispatcher = new COnClickReplyMsg_dispatcher(null);
  private CPGChangeReceivedMsg_dispatcher mCPGChangeReceivedMsg_dispatcher = new CPGChangeReceivedMsg_dispatcher(null);
  private CPGMessageReceivedMsg_dispatcher mCPGMessageReceivedMsg_dispatcher = new CPGMessageReceivedMsg_dispatcher(null);
  private CPublicAccountSubscriberUpdateReplyMsg_dispatcher mCPublicAccountSubscriberUpdateReplyMsg_dispatcher = new CPublicAccountSubscriberUpdateReplyMsg_dispatcher(null);
  private CQueryDestOperationSupportReplyMsg_dispatcher mCQueryDestOperationSupportReplyMsg_dispatcher = new CQueryDestOperationSupportReplyMsg_dispatcher(null);
  private CRecoverGroupChatsReplyMsg_dispatcher mCRecoverGroupChatsReplyMsg_dispatcher = new CRecoverGroupChatsReplyMsg_dispatcher(null);
  private CRecoverGroupsReplyMsg_dispatcher mCRecoverGroupsReplyMsg_dispatcher = new CRecoverGroupsReplyMsg_dispatcher(null);
  private CRecoverPublicAccountsReplyMsg_dispatcher mCRecoverPublicAccountsReplyMsg_dispatcher = new CRecoverPublicAccountsReplyMsg_dispatcher(null);
  private CRecvInternalMsg_dispatcher mCRecvInternalMsg_dispatcher = new CRecvInternalMsg_dispatcher(null);
  private CRefreshPublicAccountTokenReplyMsg_dispatcher mCRefreshPublicAccountTokenReplyMsg_dispatcher = new CRefreshPublicAccountTokenReplyMsg_dispatcher(null);
  private CRegisterViberIdReplyMsg_dispatcher mCRegisterViberIdReplyMsg_dispatcher = new CRegisterViberIdReplyMsg_dispatcher(null);
  private CRegisteredContactsMsg_dispatcher mCRegisteredContactsMsg_dispatcher = new CRegisteredContactsMsg_dispatcher(null);
  private CRevokeGroup2InviteReplyMsg_dispatcher mCRevokeGroup2InviteReplyMsg_dispatcher = new CRevokeGroup2InviteReplyMsg_dispatcher(null);
  private CRevokeGroupInviteReplyMsg_dispatcher mCRevokeGroupInviteReplyMsg_dispatcher = new CRevokeGroupInviteReplyMsg_dispatcher(null);
  private CSecretChatReceivedEventMsg_dispatcher mCSecretChatReceivedEventMsg_dispatcher = new CSecretChatReceivedEventMsg_dispatcher(null);
  private CSecretChatSendEventReplyMsg_dispatcher mCSecretChatSendEventReplyMsg_dispatcher = new CSecretChatSendEventReplyMsg_dispatcher(null);
  private CSecureSecondaryRegistrationFailureMsg_dispatcher mCSecureSecondaryRegistrationFailureMsg_dispatcher = new CSecureSecondaryRegistrationFailureMsg_dispatcher(null);
  private CSendActionOnPGReplyMsg_dispatcher mCSendActionOnPGReplyMsg_dispatcher = new CSendActionOnPGReplyMsg_dispatcher(null);
  private CSendActionToBotReplyMsg_dispatcher mCSendActionToBotReplyMsg_dispatcher = new CSendActionToBotReplyMsg_dispatcher(null);
  private CSendBannerToClientMsg_dispatcher mCSendBannerToClientMsg_dispatcher = new CSendBannerToClientMsg_dispatcher(null);
  private CSendConversationStatusReplyMsg_dispatcher mCSendConversationStatusReplyMsg_dispatcher = new CSendConversationStatusReplyMsg_dispatcher(null);
  private CSendGroupUserIsTypingMsg_dispatcher mCSendGroupUserIsTypingMsg_dispatcher = new CSendGroupUserIsTypingMsg_dispatcher(null);
  private CSendInternalMsgReply_dispatcher mCSendInternalMsgReply_dispatcher = new CSendInternalMsgReply_dispatcher(null);
  private CSendMessageReplyAckMsg_dispatcher mCSendMessageReplyAckMsg_dispatcher = new CSendMessageReplyAckMsg_dispatcher(null);
  private CSendMessageReplyMsg_dispatcher mCSendMessageReplyMsg_dispatcher = new CSendMessageReplyMsg_dispatcher(null);
  private CSendUserIsTypingMsg_dispatcher mCSendUserIsTypingMsg_dispatcher = new CSendUserIsTypingMsg_dispatcher(null);
  private CShareAddressBook2ReplyMsg_dispatcher mCShareAddressBook2ReplyMsg_dispatcher = new CShareAddressBook2ReplyMsg_dispatcher(null);
  private CSyncActionOnPGMsg_dispatcher mCSyncActionOnPGMsg_dispatcher = new CSyncActionOnPGMsg_dispatcher(null);
  private CSyncConversationReplyMsg_dispatcher mCSyncConversationReplyMsg_dispatcher = new CSyncConversationReplyMsg_dispatcher(null);
  private CSyncDataFromMyOtherDeviceMsg_dispatcher mCSyncDataFromMyOtherDeviceMsg_dispatcher = new CSyncDataFromMyOtherDeviceMsg_dispatcher(null);
  private CSyncDataToMyDevicesReplyMsg_dispatcher mCSyncDataToMyDevicesReplyMsg_dispatcher = new CSyncDataToMyDevicesReplyMsg_dispatcher(null);
  private CSyncGroupReplyMsg_dispatcher mCSyncGroupReplyMsg_dispatcher = new CSyncGroupReplyMsg_dispatcher(null);
  private CSyncMessagesReplyMsg_dispatcher mCSyncMessagesReplyMsg_dispatcher = new CSyncMessagesReplyMsg_dispatcher(null);
  private CUnlinkViberIdReplyMsg_dispatcher mCUnlinkViberIdReplyMsg_dispatcher = new CUnlinkViberIdReplyMsg_dispatcher(null);
  private CUnregisterAppReplyMsg_dispatcher mCUnregisterAppReplyMsg_dispatcher = new CUnregisterAppReplyMsg_dispatcher(null);
  private CUpdateBlockListReplyMsg_dispatcher mCUpdateBlockListReplyMsg_dispatcher = new CUpdateBlockListReplyMsg_dispatcher(null);
  private CUpdateCommunityPrivilegesReplyMsg_dispatcher mCUpdateCommunityPrivilegesReplyMsg_dispatcher = new CUpdateCommunityPrivilegesReplyMsg_dispatcher(null);
  private CUpdateCommunitySettingsReplyMsg_dispatcher mCUpdateCommunitySettingsReplyMsg_dispatcher = new CUpdateCommunitySettingsReplyMsg_dispatcher(null);
  private CUpdateLanguageReplyMsg_dispatcher mCUpdateLanguageReplyMsg_dispatcher = new CUpdateLanguageReplyMsg_dispatcher(null);
  private CUpdateMyCommunitySettingsReplyMsg_dispatcher mCUpdateMyCommunitySettingsReplyMsg_dispatcher = new CUpdateMyCommunitySettingsReplyMsg_dispatcher(null);
  private CUpdatePersonalDetailsReplyMsg_dispatcher mCUpdatePersonalDetailsReplyMsg_dispatcher = new CUpdatePersonalDetailsReplyMsg_dispatcher(null);
  private CUpdateSelfUserDetailsMsg_dispatcher mCUpdateSelfUserDetailsMsg_dispatcher = new CUpdateSelfUserDetailsMsg_dispatcher(null);
  private CUpdateUnsavedContactDetailsMsg_dispatcher mCUpdateUnsavedContactDetailsMsg_dispatcher = new CUpdateUnsavedContactDetailsMsg_dispatcher(null);
  private CUpdateUserDateOfBirthReplyMsg_dispatcher mCUpdateUserDateOfBirthReplyMsg_dispatcher = new CUpdateUserDateOfBirthReplyMsg_dispatcher(null);
  private CUpdateUserNameReplyMsg_dispatcher mCUpdateUserNameReplyMsg_dispatcher = new CUpdateUserNameReplyMsg_dispatcher(null);
  private CUpdateUserPhotoReplyMsg_dispatcher mCUpdateUserPhotoReplyMsg_dispatcher = new CUpdateUserPhotoReplyMsg_dispatcher(null);
  private CValidateGroupUriReplyMsg_dispatcher mCValidateGroupUriReplyMsg_dispatcher = new CValidateGroupUriReplyMsg_dispatcher(null);
  private CViberIdChangedMsg_dispatcher mCViberIdChangedMsg_dispatcher = new CViberIdChangedMsg_dispatcher(null);

  public Im2Dispatcher()
  {
    this.mReceiverToRegistratorMap.put(CAcceptGroupInviteReplyMsg.Receiver.class, this.mCAcceptGroupInviteReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CActOnViberIdPasswordReplyMsg.Receiver.class, this.mCActOnViberIdPasswordReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CAddressBookDeltaUpdateV2Msg.Receiver.class, this.mCAddressBookDeltaUpdateV2Msg_dispatcher);
    this.mReceiverToRegistratorMap.put(CAddressBookForSecondaryV2Msg.Receiver.class, this.mCAddressBookForSecondaryV2Msg_dispatcher);
    this.mReceiverToRegistratorMap.put(CAuthenticateAppReplyMsg.Receiver.class, this.mCAuthenticateAppReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CBillingTokenByMidReplyMsg.Receiver.class, this.mCBillingTokenByMidReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CBillingTokenReplyMsg.Receiver.class, this.mCBillingTokenReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CBlockAppReplyMsg.Receiver.class, this.mCBlockAppReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CBlockGroupInviteReplyMsg.Receiver.class, this.mCBlockGroupInviteReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CChangeConversationSettingsReplyMsg.Receiver.class, this.mCChangeConversationSettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CChangeGroupAttributesReplyMsg.Receiver.class, this.mCChangeGroupAttributesReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CChangeGroupSettingsReplyMsg.Receiver.class, this.mCChangeGroupSettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CChangeLastOnlineSettingsReplyMsg.Receiver.class, this.mCChangeLastOnlineSettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CChangeReadNotificationsSettingsReplyMsg.Receiver.class, this.mCChangeReadNotificationsSettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CChangeSettingsReplyMsg.Receiver.class, this.mCChangeSettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CChangeUserActivitySettingsReplyMsg.Receiver.class, this.mCChangeUserActivitySettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CChangeViberIdEmailReplyMsg.Receiver.class, this.mCChangeViberIdEmailReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CCheckAllowsM2MChatReplyMsg.Receiver.class, this.mCCheckAllowsM2MChatReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CCheckEmailStatusReplyMsg.Receiver.class, this.mCCheckEmailStatusReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CCheckGroup2InviteReplyMsg.Receiver.class, this.mCCheckGroup2InviteReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CConfirmOrRevokeEmailReplyMsg.Receiver.class, this.mCConfirmOrRevokeEmailReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CContactSavedInConversationNotificationReplyMsg.Receiver.class, this.mCContactSavedInConversationNotificationReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CConversationSynchedMsg.Receiver.class, this.mCConversationSynchedMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CCreateConferenceCallReplyMsg.Receiver.class, this.mCCreateConferenceCallReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CCreateGroup2InviteReplyMsg.Receiver.class, this.mCCreateGroup2InviteReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CCreateGroupInviteReplyMsg.Receiver.class, this.mCCreateGroupInviteReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CCreateGroupReplyMsg.Receiver.class, this.mCCreateGroupReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CDeleteAllUserMessagesReplyMsg.Receiver.class, this.mCDeleteAllUserMessagesReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CDeleteGlobalMessageReplyMsg.Receiver.class, this.mCDeleteGlobalMessageReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CDeleteMessageReplyMsg.Receiver.class, this.mCDeleteMessageReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CDeletedMessageMsg.Receiver.class, this.mCDeletedMessageMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGdprCommandReplyMsg.Receiver.class, this.mCGdprCommandReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetAdInfoReplyMsg.Receiver.class, this.mCGetAdInfoReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetCommonCommunitiesReplyMsg.Receiver.class, this.mCGetCommonCommunitiesReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetDownloadDetailsReplyMsg.Receiver.class, this.mCGetDownloadDetailsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetEncryptedMIDsReplyMsg.Receiver.class, this.mCGetEncryptedMIDsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetGroup2AccessTokenReplyMsg.Receiver.class, this.mCGetGroup2AccessTokenReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetGroupInfoReplyMsg.Receiver.class, this.mCGetGroupInfoReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetGroupMessageStatusReplyMsg.Receiver.class, this.mCGetGroupMessageStatusReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetInviteLinksReplyMsg.Receiver.class, this.mCGetInviteLinksReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetLastOnlineReplyMsg.Receiver.class, this.mCGetLastOnlineReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetMyCommunitySettingsReplyMsg.Receiver.class, this.mCGetMyCommunitySettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetPersonalDetailsReplyMsg.Receiver.class, this.mCGetPersonalDetailsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetPersonalProfileReplyMsg.Receiver.class, this.mCGetPersonalProfileReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetPublicAccountInfoReplyMsg.Receiver.class, this.mCGetPublicAccountInfoReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetPublicGroupInfoReplyMsg.Receiver.class, this.mCGetPublicGroupInfoReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetSecondaryDeviceDetailsReplyMsg.Receiver.class, this.mCGetSecondaryDeviceDetailsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetUserActivityReplyMsg.Receiver.class, this.mCGetUserActivityReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetUserAppsReplyMsg.Receiver.class, this.mCGetUserAppsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetUserDateOfBirthReplyMsg.Receiver.class, this.mCGetUserDateOfBirthReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetUsersDetailsV2ReplyMsg.Receiver.class, this.mCGetUsersDetailsV2ReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGetViberIdReplyMsg.Receiver.class, this.mCGetViberIdReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupAddMemberReplyMsg.Receiver.class, this.mCGroupAddMemberReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupAddMembersReplyMsg.Receiver.class, this.mCGroupAddMembersReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupAddWatchersReplyMsg.Receiver.class, this.mCGroupAddWatchersReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupAssignRoleReplyMsg.Receiver.class, this.mCGroupAssignRoleReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupBanUserReplyMsg.Receiver.class, this.mCGroupBanUserReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupChangedMsg.Receiver.class, this.mCGroupChangedMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupLeaveReplyMsg.Receiver.class, this.mCGroupLeaveReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupMessageLike.Receiver.class, this.mCGroupMessageLike_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupMessageReceivedMsg.Receiver.class, this.mCGroupMessageReceivedMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupRemoveMembersReplyMsg.Receiver.class, this.mCGroupRemoveMembersReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CGroupSynchedMsg.Receiver.class, this.mCGroupSynchedMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CInviteToConferenceReplyMsg.Receiver.class, this.mCInviteToConferenceReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CIsOnlineReplyMsg.Receiver.class, this.mCIsOnlineReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CIsRegisteredNumberReplyMsg.Receiver.class, this.mCIsRegisteredNumberReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CJoinConfCallReplyMsg.Receiver.class, this.mCJoinConfCallReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CLateErrorOnReceivedMessageReplyMsg.Receiver.class, this.mCLateErrorOnReceivedMessageReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CLikeGroupMessageReply.Receiver.class, this.mCLikeGroupMessageReply_dispatcher);
    this.mReceiverToRegistratorMap.put(CLoginReplyMsg.Receiver.class, this.mCLoginReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CMessageDeliveredMsg.Receiver.class, this.mCMessageDeliveredMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CMessageReceivedMsg.Receiver.class, this.mCMessageReceivedMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CMessageReceivedReplyableAckReplyMsg.Receiver.class, this.mCMessageReceivedReplyableAckReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CMessagesSynchedMsg.Receiver.class, this.mCMessagesSynchedMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(COnClickReplyMsg.Receiver.class, this.mCOnClickReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CPGChangeReceivedMsg.Receiver.class, this.mCPGChangeReceivedMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CPGMessageReceivedMsg.Receiver.class, this.mCPGMessageReceivedMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CPublicAccountSubscriberUpdateReplyMsg.Receiver.class, this.mCPublicAccountSubscriberUpdateReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CQueryDestOperationSupportReplyMsg.Receiver.class, this.mCQueryDestOperationSupportReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRecoverGroupChatsReplyMsg.Receiver.class, this.mCRecoverGroupChatsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRecoverGroupsReplyMsg.Receiver.class, this.mCRecoverGroupsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRecoverPublicAccountsReplyMsg.Receiver.class, this.mCRecoverPublicAccountsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRecvInternalMsg.Receiver.class, this.mCRecvInternalMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRefreshPublicAccountTokenReplyMsg.Receiver.class, this.mCRefreshPublicAccountTokenReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRegisterViberIdReplyMsg.Receiver.class, this.mCRegisterViberIdReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRegisteredContactsMsg.Receiver.class, this.mCRegisteredContactsMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRevokeGroup2InviteReplyMsg.Receiver.class, this.mCRevokeGroup2InviteReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CRevokeGroupInviteReplyMsg.Receiver.class, this.mCRevokeGroupInviteReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSecretChatReceivedEventMsg.Receiver.class, this.mCSecretChatReceivedEventMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSecretChatSendEventReplyMsg.Receiver.class, this.mCSecretChatSendEventReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSecureSecondaryRegistrationFailureMsg.Receiver.class, this.mCSecureSecondaryRegistrationFailureMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendActionOnPGReplyMsg.Receiver.class, this.mCSendActionOnPGReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendActionToBotReplyMsg.Receiver.class, this.mCSendActionToBotReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendBannerToClientMsg.Receiver.class, this.mCSendBannerToClientMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendConversationStatusReplyMsg.Receiver.class, this.mCSendConversationStatusReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendGroupUserIsTypingMsg.Receiver.class, this.mCSendGroupUserIsTypingMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendInternalMsgReply.Receiver.class, this.mCSendInternalMsgReply_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendMessageReplyAckMsg.Receiver.class, this.mCSendMessageReplyAckMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendMessageReplyMsg.Receiver.class, this.mCSendMessageReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSendUserIsTypingMsg.Receiver.class, this.mCSendUserIsTypingMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CShareAddressBook2ReplyMsg.Receiver.class, this.mCShareAddressBook2ReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSyncActionOnPGMsg.Receiver.class, this.mCSyncActionOnPGMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSyncConversationReplyMsg.Receiver.class, this.mCSyncConversationReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSyncDataFromMyOtherDeviceMsg.Receiver.class, this.mCSyncDataFromMyOtherDeviceMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSyncDataToMyDevicesReplyMsg.Receiver.class, this.mCSyncDataToMyDevicesReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSyncGroupReplyMsg.Receiver.class, this.mCSyncGroupReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CSyncMessagesReplyMsg.Receiver.class, this.mCSyncMessagesReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUnlinkViberIdReplyMsg.Receiver.class, this.mCUnlinkViberIdReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUnregisterAppReplyMsg.Receiver.class, this.mCUnregisterAppReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateBlockListReplyMsg.Receiver.class, this.mCUpdateBlockListReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateCommunityPrivilegesReplyMsg.Receiver.class, this.mCUpdateCommunityPrivilegesReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateCommunitySettingsReplyMsg.Receiver.class, this.mCUpdateCommunitySettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateLanguageReplyMsg.Receiver.class, this.mCUpdateLanguageReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateMyCommunitySettingsReplyMsg.Receiver.class, this.mCUpdateMyCommunitySettingsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdatePersonalDetailsReplyMsg.Receiver.class, this.mCUpdatePersonalDetailsReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateSelfUserDetailsMsg.Receiver.class, this.mCUpdateSelfUserDetailsMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateUnsavedContactDetailsMsg.Receiver.class, this.mCUpdateUnsavedContactDetailsMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateUserDateOfBirthReplyMsg.Receiver.class, this.mCUpdateUserDateOfBirthReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateUserNameReplyMsg.Receiver.class, this.mCUpdateUserNameReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CUpdateUserPhotoReplyMsg.Receiver.class, this.mCUpdateUserPhotoReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CValidateGroupUriReplyMsg.Receiver.class, this.mCValidateGroupUriReplyMsg_dispatcher);
    this.mReceiverToRegistratorMap.put(CViberIdChangedMsg.Receiver.class, this.mCViberIdChangedMsg_dispatcher);
  }

  public void onCAcceptGroupInviteReplyMsg(CAcceptGroupInviteReplyMsg paramCAcceptGroupInviteReplyMsg)
  {
    this.mCAcceptGroupInviteReplyMsg_dispatcher.onCAcceptGroupInviteReplyMsg(paramCAcceptGroupInviteReplyMsg);
  }

  public void onCActOnViberIdPasswordReplyMsg(CActOnViberIdPasswordReplyMsg paramCActOnViberIdPasswordReplyMsg)
  {
    this.mCActOnViberIdPasswordReplyMsg_dispatcher.onCActOnViberIdPasswordReplyMsg(paramCActOnViberIdPasswordReplyMsg);
  }

  public void onCAddressBookDeltaUpdateV2Msg(CAddressBookDeltaUpdateV2Msg paramCAddressBookDeltaUpdateV2Msg)
  {
    this.mCAddressBookDeltaUpdateV2Msg_dispatcher.onCAddressBookDeltaUpdateV2Msg(paramCAddressBookDeltaUpdateV2Msg);
  }

  public void onCAddressBookForSecondaryV2Msg(CAddressBookForSecondaryV2Msg paramCAddressBookForSecondaryV2Msg)
  {
    this.mCAddressBookForSecondaryV2Msg_dispatcher.onCAddressBookForSecondaryV2Msg(paramCAddressBookForSecondaryV2Msg);
  }

  public void onCAuthenticateAppReplyMsg(CAuthenticateAppReplyMsg paramCAuthenticateAppReplyMsg)
  {
    this.mCAuthenticateAppReplyMsg_dispatcher.onCAuthenticateAppReplyMsg(paramCAuthenticateAppReplyMsg);
  }

  public void onCBillingTokenByMidReplyMsg(CBillingTokenByMidReplyMsg paramCBillingTokenByMidReplyMsg)
  {
    this.mCBillingTokenByMidReplyMsg_dispatcher.onCBillingTokenByMidReplyMsg(paramCBillingTokenByMidReplyMsg);
  }

  public void onCBillingTokenReplyMsg(CBillingTokenReplyMsg paramCBillingTokenReplyMsg)
  {
    this.mCBillingTokenReplyMsg_dispatcher.onCBillingTokenReplyMsg(paramCBillingTokenReplyMsg);
  }

  public void onCBlockAppReplyMsg(CBlockAppReplyMsg paramCBlockAppReplyMsg)
  {
    this.mCBlockAppReplyMsg_dispatcher.onCBlockAppReplyMsg(paramCBlockAppReplyMsg);
  }

  public void onCBlockGroupInviteReplyMsg(CBlockGroupInviteReplyMsg paramCBlockGroupInviteReplyMsg)
  {
    this.mCBlockGroupInviteReplyMsg_dispatcher.onCBlockGroupInviteReplyMsg(paramCBlockGroupInviteReplyMsg);
  }

  public void onCChangeConversationSettingsReplyMsg(CChangeConversationSettingsReplyMsg paramCChangeConversationSettingsReplyMsg)
  {
    this.mCChangeConversationSettingsReplyMsg_dispatcher.onCChangeConversationSettingsReplyMsg(paramCChangeConversationSettingsReplyMsg);
  }

  public void onCChangeGroupAttributesReplyMsg(CChangeGroupAttributesReplyMsg paramCChangeGroupAttributesReplyMsg)
  {
    this.mCChangeGroupAttributesReplyMsg_dispatcher.onCChangeGroupAttributesReplyMsg(paramCChangeGroupAttributesReplyMsg);
  }

  public void onCChangeGroupSettingsReplyMsg(CChangeGroupSettingsReplyMsg paramCChangeGroupSettingsReplyMsg)
  {
    this.mCChangeGroupSettingsReplyMsg_dispatcher.onCChangeGroupSettingsReplyMsg(paramCChangeGroupSettingsReplyMsg);
  }

  public void onCChangeLastOnlineSettingsReplyMsg(CChangeLastOnlineSettingsReplyMsg paramCChangeLastOnlineSettingsReplyMsg)
  {
    this.mCChangeLastOnlineSettingsReplyMsg_dispatcher.onCChangeLastOnlineSettingsReplyMsg(paramCChangeLastOnlineSettingsReplyMsg);
  }

  public void onCChangeReadNotificationsSettingsReplyMsg(CChangeReadNotificationsSettingsReplyMsg paramCChangeReadNotificationsSettingsReplyMsg)
  {
    this.mCChangeReadNotificationsSettingsReplyMsg_dispatcher.onCChangeReadNotificationsSettingsReplyMsg(paramCChangeReadNotificationsSettingsReplyMsg);
  }

  public void onCChangeSettingsReplyMsg(CChangeSettingsReplyMsg paramCChangeSettingsReplyMsg)
  {
    this.mCChangeSettingsReplyMsg_dispatcher.onCChangeSettingsReplyMsg(paramCChangeSettingsReplyMsg);
  }

  public void onCChangeUserActivitySettingsReplyMsg(CChangeUserActivitySettingsReplyMsg paramCChangeUserActivitySettingsReplyMsg)
  {
    this.mCChangeUserActivitySettingsReplyMsg_dispatcher.onCChangeUserActivitySettingsReplyMsg(paramCChangeUserActivitySettingsReplyMsg);
  }

  public void onCChangeViberIdEmailReplyMsg(CChangeViberIdEmailReplyMsg paramCChangeViberIdEmailReplyMsg)
  {
    this.mCChangeViberIdEmailReplyMsg_dispatcher.onCChangeViberIdEmailReplyMsg(paramCChangeViberIdEmailReplyMsg);
  }

  public void onCCheckAllowsM2MChatReplyMsg(CCheckAllowsM2MChatReplyMsg paramCCheckAllowsM2MChatReplyMsg)
  {
    this.mCCheckAllowsM2MChatReplyMsg_dispatcher.onCCheckAllowsM2MChatReplyMsg(paramCCheckAllowsM2MChatReplyMsg);
  }

  public void onCCheckEmailStatusReplyMsg(CCheckEmailStatusReplyMsg paramCCheckEmailStatusReplyMsg)
  {
    this.mCCheckEmailStatusReplyMsg_dispatcher.onCCheckEmailStatusReplyMsg(paramCCheckEmailStatusReplyMsg);
  }

  public void onCCheckGroup2InviteReplyMsg(CCheckGroup2InviteReplyMsg paramCCheckGroup2InviteReplyMsg)
  {
    this.mCCheckGroup2InviteReplyMsg_dispatcher.onCCheckGroup2InviteReplyMsg(paramCCheckGroup2InviteReplyMsg);
  }

  public void onCConfirmOrRevokeEmailReplyMsg(CConfirmOrRevokeEmailReplyMsg paramCConfirmOrRevokeEmailReplyMsg)
  {
    this.mCConfirmOrRevokeEmailReplyMsg_dispatcher.onCConfirmOrRevokeEmailReplyMsg(paramCConfirmOrRevokeEmailReplyMsg);
  }

  public void onCContactSavedInConversationNotificationReplyMsg(CContactSavedInConversationNotificationReplyMsg paramCContactSavedInConversationNotificationReplyMsg)
  {
    this.mCContactSavedInConversationNotificationReplyMsg_dispatcher.onCContactSavedInConversationNotificationReplyMsg(paramCContactSavedInConversationNotificationReplyMsg);
  }

  public void onCConversationSynchedMsg(CConversationSynchedMsg paramCConversationSynchedMsg)
  {
    this.mCConversationSynchedMsg_dispatcher.onCConversationSynchedMsg(paramCConversationSynchedMsg);
  }

  public void onCCreateConferenceCallReplyMsg(CCreateConferenceCallReplyMsg paramCCreateConferenceCallReplyMsg)
  {
    this.mCCreateConferenceCallReplyMsg_dispatcher.onCCreateConferenceCallReplyMsg(paramCCreateConferenceCallReplyMsg);
  }

  public void onCCreateGroup2InviteReplyMsg(CCreateGroup2InviteReplyMsg paramCCreateGroup2InviteReplyMsg)
  {
    this.mCCreateGroup2InviteReplyMsg_dispatcher.onCCreateGroup2InviteReplyMsg(paramCCreateGroup2InviteReplyMsg);
  }

  public void onCCreateGroupInviteReplyMsg(CCreateGroupInviteReplyMsg paramCCreateGroupInviteReplyMsg)
  {
    this.mCCreateGroupInviteReplyMsg_dispatcher.onCCreateGroupInviteReplyMsg(paramCCreateGroupInviteReplyMsg);
  }

  public void onCCreateGroupReplyMsg(CCreateGroupReplyMsg paramCCreateGroupReplyMsg)
  {
    this.mCCreateGroupReplyMsg_dispatcher.onCCreateGroupReplyMsg(paramCCreateGroupReplyMsg);
  }

  public void onCDeleteAllUserMessagesReplyMsg(CDeleteAllUserMessagesReplyMsg paramCDeleteAllUserMessagesReplyMsg)
  {
    this.mCDeleteAllUserMessagesReplyMsg_dispatcher.onCDeleteAllUserMessagesReplyMsg(paramCDeleteAllUserMessagesReplyMsg);
  }

  public void onCDeleteGlobalMessageReplyMsg(CDeleteGlobalMessageReplyMsg paramCDeleteGlobalMessageReplyMsg)
  {
    this.mCDeleteGlobalMessageReplyMsg_dispatcher.onCDeleteGlobalMessageReplyMsg(paramCDeleteGlobalMessageReplyMsg);
  }

  public void onCDeleteMessageReplyMsg(CDeleteMessageReplyMsg paramCDeleteMessageReplyMsg)
  {
    this.mCDeleteMessageReplyMsg_dispatcher.onCDeleteMessageReplyMsg(paramCDeleteMessageReplyMsg);
  }

  public void onCDeletedMessageMsg(CDeletedMessageMsg paramCDeletedMessageMsg)
  {
    this.mCDeletedMessageMsg_dispatcher.onCDeletedMessageMsg(paramCDeletedMessageMsg);
  }

  public void onCGdprCommandReplyMsg(CGdprCommandReplyMsg paramCGdprCommandReplyMsg)
  {
    this.mCGdprCommandReplyMsg_dispatcher.onCGdprCommandReplyMsg(paramCGdprCommandReplyMsg);
  }

  public void onCGetAdInfoReplyMsg(CGetAdInfoReplyMsg paramCGetAdInfoReplyMsg)
  {
    this.mCGetAdInfoReplyMsg_dispatcher.onCGetAdInfoReplyMsg(paramCGetAdInfoReplyMsg);
  }

  public void onCGetCommonCommunitiesReplyMsg(CGetCommonCommunitiesReplyMsg paramCGetCommonCommunitiesReplyMsg)
  {
    this.mCGetCommonCommunitiesReplyMsg_dispatcher.onCGetCommonCommunitiesReplyMsg(paramCGetCommonCommunitiesReplyMsg);
  }

  public void onCGetDownloadDetailsReplyMsg(CGetDownloadDetailsReplyMsg paramCGetDownloadDetailsReplyMsg)
  {
    this.mCGetDownloadDetailsReplyMsg_dispatcher.onCGetDownloadDetailsReplyMsg(paramCGetDownloadDetailsReplyMsg);
  }

  public void onCGetEncryptedMIDsReplyMsg(CGetEncryptedMIDsReplyMsg paramCGetEncryptedMIDsReplyMsg)
  {
    this.mCGetEncryptedMIDsReplyMsg_dispatcher.onCGetEncryptedMIDsReplyMsg(paramCGetEncryptedMIDsReplyMsg);
  }

  public void onCGetGroup2AccessTokenReplyMsg(CGetGroup2AccessTokenReplyMsg paramCGetGroup2AccessTokenReplyMsg)
  {
    this.mCGetGroup2AccessTokenReplyMsg_dispatcher.onCGetGroup2AccessTokenReplyMsg(paramCGetGroup2AccessTokenReplyMsg);
  }

  public void onCGetGroupInfoReplyMsg(CGetGroupInfoReplyMsg paramCGetGroupInfoReplyMsg)
  {
    this.mCGetGroupInfoReplyMsg_dispatcher.onCGetGroupInfoReplyMsg(paramCGetGroupInfoReplyMsg);
  }

  public void onCGetGroupMessageStatusReplyMsg(CGetGroupMessageStatusReplyMsg paramCGetGroupMessageStatusReplyMsg)
  {
    this.mCGetGroupMessageStatusReplyMsg_dispatcher.onCGetGroupMessageStatusReplyMsg(paramCGetGroupMessageStatusReplyMsg);
  }

  public void onCGetInviteLinksReplyMsg(CGetInviteLinksReplyMsg paramCGetInviteLinksReplyMsg)
  {
    this.mCGetInviteLinksReplyMsg_dispatcher.onCGetInviteLinksReplyMsg(paramCGetInviteLinksReplyMsg);
  }

  public void onCGetLastOnlineReplyMsg(CGetLastOnlineReplyMsg paramCGetLastOnlineReplyMsg)
  {
    this.mCGetLastOnlineReplyMsg_dispatcher.onCGetLastOnlineReplyMsg(paramCGetLastOnlineReplyMsg);
  }

  public void onCGetMyCommunitySettingsReplyMsg(CGetMyCommunitySettingsReplyMsg paramCGetMyCommunitySettingsReplyMsg)
  {
    this.mCGetMyCommunitySettingsReplyMsg_dispatcher.onCGetMyCommunitySettingsReplyMsg(paramCGetMyCommunitySettingsReplyMsg);
  }

  public void onCGetPersonalDetailsReplyMsg(CGetPersonalDetailsReplyMsg paramCGetPersonalDetailsReplyMsg)
  {
    this.mCGetPersonalDetailsReplyMsg_dispatcher.onCGetPersonalDetailsReplyMsg(paramCGetPersonalDetailsReplyMsg);
  }

  public void onCGetPersonalProfileReplyMsg(CGetPersonalProfileReplyMsg paramCGetPersonalProfileReplyMsg)
  {
    this.mCGetPersonalProfileReplyMsg_dispatcher.onCGetPersonalProfileReplyMsg(paramCGetPersonalProfileReplyMsg);
  }

  public void onCGetPublicAccountInfoReplyMsg(CGetPublicAccountInfoReplyMsg paramCGetPublicAccountInfoReplyMsg)
  {
    this.mCGetPublicAccountInfoReplyMsg_dispatcher.onCGetPublicAccountInfoReplyMsg(paramCGetPublicAccountInfoReplyMsg);
  }

  public void onCGetPublicGroupInfoReplyMsg(CGetPublicGroupInfoReplyMsg paramCGetPublicGroupInfoReplyMsg)
  {
    this.mCGetPublicGroupInfoReplyMsg_dispatcher.onCGetPublicGroupInfoReplyMsg(paramCGetPublicGroupInfoReplyMsg);
  }

  public void onCGetSecondaryDeviceDetailsReplyMsg(CGetSecondaryDeviceDetailsReplyMsg paramCGetSecondaryDeviceDetailsReplyMsg)
  {
    this.mCGetSecondaryDeviceDetailsReplyMsg_dispatcher.onCGetSecondaryDeviceDetailsReplyMsg(paramCGetSecondaryDeviceDetailsReplyMsg);
  }

  public void onCGetUserActivityReplyMsg(CGetUserActivityReplyMsg paramCGetUserActivityReplyMsg)
  {
    this.mCGetUserActivityReplyMsg_dispatcher.onCGetUserActivityReplyMsg(paramCGetUserActivityReplyMsg);
  }

  public void onCGetUserAppsReplyMsg(CGetUserAppsReplyMsg paramCGetUserAppsReplyMsg)
  {
    this.mCGetUserAppsReplyMsg_dispatcher.onCGetUserAppsReplyMsg(paramCGetUserAppsReplyMsg);
  }

  public void onCGetUserDateOfBirthReplyMsg(CGetUserDateOfBirthReplyMsg paramCGetUserDateOfBirthReplyMsg)
  {
    this.mCGetUserDateOfBirthReplyMsg_dispatcher.onCGetUserDateOfBirthReplyMsg(paramCGetUserDateOfBirthReplyMsg);
  }

  public void onCGetUsersDetailsV2ReplyMsg(CGetUsersDetailsV2ReplyMsg paramCGetUsersDetailsV2ReplyMsg)
  {
    this.mCGetUsersDetailsV2ReplyMsg_dispatcher.onCGetUsersDetailsV2ReplyMsg(paramCGetUsersDetailsV2ReplyMsg);
  }

  public void onCGetViberIdReplyMsg(CGetViberIdReplyMsg paramCGetViberIdReplyMsg)
  {
    this.mCGetViberIdReplyMsg_dispatcher.onCGetViberIdReplyMsg(paramCGetViberIdReplyMsg);
  }

  public void onCGroupAddMemberReplyMsg(CGroupAddMemberReplyMsg paramCGroupAddMemberReplyMsg)
  {
    this.mCGroupAddMemberReplyMsg_dispatcher.onCGroupAddMemberReplyMsg(paramCGroupAddMemberReplyMsg);
  }

  public void onCGroupAddMembersReplyMsg(CGroupAddMembersReplyMsg paramCGroupAddMembersReplyMsg)
  {
    this.mCGroupAddMembersReplyMsg_dispatcher.onCGroupAddMembersReplyMsg(paramCGroupAddMembersReplyMsg);
  }

  public void onCGroupAddWatchersReplyMsg(CGroupAddWatchersReplyMsg paramCGroupAddWatchersReplyMsg)
  {
    this.mCGroupAddWatchersReplyMsg_dispatcher.onCGroupAddWatchersReplyMsg(paramCGroupAddWatchersReplyMsg);
  }

  public void onCGroupAssignRoleReplyMsg(CGroupAssignRoleReplyMsg paramCGroupAssignRoleReplyMsg)
  {
    this.mCGroupAssignRoleReplyMsg_dispatcher.onCGroupAssignRoleReplyMsg(paramCGroupAssignRoleReplyMsg);
  }

  public void onCGroupBanUserReplyMsg(CGroupBanUserReplyMsg paramCGroupBanUserReplyMsg)
  {
    this.mCGroupBanUserReplyMsg_dispatcher.onCGroupBanUserReplyMsg(paramCGroupBanUserReplyMsg);
  }

  public void onCGroupChangedMsg(CGroupChangedMsg paramCGroupChangedMsg)
  {
    this.mCGroupChangedMsg_dispatcher.onCGroupChangedMsg(paramCGroupChangedMsg);
  }

  public void onCGroupLeaveReplyMsg(CGroupLeaveReplyMsg paramCGroupLeaveReplyMsg)
  {
    this.mCGroupLeaveReplyMsg_dispatcher.onCGroupLeaveReplyMsg(paramCGroupLeaveReplyMsg);
  }

  public void onCGroupMessageLike(CGroupMessageLike paramCGroupMessageLike)
  {
    this.mCGroupMessageLike_dispatcher.onCGroupMessageLike(paramCGroupMessageLike);
  }

  public void onCGroupMessageReceivedMsg(CGroupMessageReceivedMsg paramCGroupMessageReceivedMsg)
  {
    this.mCGroupMessageReceivedMsg_dispatcher.onCGroupMessageReceivedMsg(paramCGroupMessageReceivedMsg);
  }

  public void onCGroupRemoveMembersReplyMsg(CGroupRemoveMembersReplyMsg paramCGroupRemoveMembersReplyMsg)
  {
    this.mCGroupRemoveMembersReplyMsg_dispatcher.onCGroupRemoveMembersReplyMsg(paramCGroupRemoveMembersReplyMsg);
  }

  public void onCGroupSynchedMsg(CGroupSynchedMsg paramCGroupSynchedMsg)
  {
    this.mCGroupSynchedMsg_dispatcher.onCGroupSynchedMsg(paramCGroupSynchedMsg);
  }

  public void onCInviteToConferenceReplyMsg(CInviteToConferenceReplyMsg paramCInviteToConferenceReplyMsg)
  {
    this.mCInviteToConferenceReplyMsg_dispatcher.onCInviteToConferenceReplyMsg(paramCInviteToConferenceReplyMsg);
  }

  public void onCIsOnlineReplyMsg(CIsOnlineReplyMsg paramCIsOnlineReplyMsg)
  {
    this.mCIsOnlineReplyMsg_dispatcher.onCIsOnlineReplyMsg(paramCIsOnlineReplyMsg);
  }

  public void onCIsRegisteredNumberReplyMsg(CIsRegisteredNumberReplyMsg paramCIsRegisteredNumberReplyMsg)
  {
    this.mCIsRegisteredNumberReplyMsg_dispatcher.onCIsRegisteredNumberReplyMsg(paramCIsRegisteredNumberReplyMsg);
  }

  public void onCJoinConfCallReplyMsg(CJoinConfCallReplyMsg paramCJoinConfCallReplyMsg)
  {
    this.mCJoinConfCallReplyMsg_dispatcher.onCJoinConfCallReplyMsg(paramCJoinConfCallReplyMsg);
  }

  public void onCLateErrorOnReceivedMessageReplyMsg(CLateErrorOnReceivedMessageReplyMsg paramCLateErrorOnReceivedMessageReplyMsg)
  {
    this.mCLateErrorOnReceivedMessageReplyMsg_dispatcher.onCLateErrorOnReceivedMessageReplyMsg(paramCLateErrorOnReceivedMessageReplyMsg);
  }

  public void onCLikeGroupMessageReply(CLikeGroupMessageReply paramCLikeGroupMessageReply)
  {
    this.mCLikeGroupMessageReply_dispatcher.onCLikeGroupMessageReply(paramCLikeGroupMessageReply);
  }

  public void onCLoginReplyMsg(CLoginReplyMsg paramCLoginReplyMsg)
  {
    this.mCLoginReplyMsg_dispatcher.onCLoginReplyMsg(paramCLoginReplyMsg);
  }

  public void onCMessageDeliveredMsg(CMessageDeliveredMsg paramCMessageDeliveredMsg)
  {
    this.mCMessageDeliveredMsg_dispatcher.onCMessageDeliveredMsg(paramCMessageDeliveredMsg);
  }

  public void onCMessageReceivedMsg(CMessageReceivedMsg paramCMessageReceivedMsg)
  {
    this.mCMessageReceivedMsg_dispatcher.onCMessageReceivedMsg(paramCMessageReceivedMsg);
  }

  public void onCMessageReceivedReplyableAckReplyMsg(CMessageReceivedReplyableAckReplyMsg paramCMessageReceivedReplyableAckReplyMsg)
  {
    this.mCMessageReceivedReplyableAckReplyMsg_dispatcher.onCMessageReceivedReplyableAckReplyMsg(paramCMessageReceivedReplyableAckReplyMsg);
  }

  public void onCMessagesSynchedMsg(CMessagesSynchedMsg paramCMessagesSynchedMsg)
  {
    this.mCMessagesSynchedMsg_dispatcher.onCMessagesSynchedMsg(paramCMessagesSynchedMsg);
  }

  public void onCOnClickReplyMsg(COnClickReplyMsg paramCOnClickReplyMsg)
  {
    this.mCOnClickReplyMsg_dispatcher.onCOnClickReplyMsg(paramCOnClickReplyMsg);
  }

  public void onCPGChangeReceivedMsg(CPGChangeReceivedMsg paramCPGChangeReceivedMsg)
  {
    this.mCPGChangeReceivedMsg_dispatcher.onCPGChangeReceivedMsg(paramCPGChangeReceivedMsg);
  }

  public void onCPGMessageReceivedMsg(CPGMessageReceivedMsg paramCPGMessageReceivedMsg)
  {
    this.mCPGMessageReceivedMsg_dispatcher.onCPGMessageReceivedMsg(paramCPGMessageReceivedMsg);
  }

  public void onCPublicAccountSubscriberUpdateReplyMsg(CPublicAccountSubscriberUpdateReplyMsg paramCPublicAccountSubscriberUpdateReplyMsg)
  {
    this.mCPublicAccountSubscriberUpdateReplyMsg_dispatcher.onCPublicAccountSubscriberUpdateReplyMsg(paramCPublicAccountSubscriberUpdateReplyMsg);
  }

  public void onCQueryDestOperationSupportReplyMsg(CQueryDestOperationSupportReplyMsg paramCQueryDestOperationSupportReplyMsg)
  {
    this.mCQueryDestOperationSupportReplyMsg_dispatcher.onCQueryDestOperationSupportReplyMsg(paramCQueryDestOperationSupportReplyMsg);
  }

  public void onCRecoverGroupChatsReplyMsg(CRecoverGroupChatsReplyMsg paramCRecoverGroupChatsReplyMsg)
  {
    this.mCRecoverGroupChatsReplyMsg_dispatcher.onCRecoverGroupChatsReplyMsg(paramCRecoverGroupChatsReplyMsg);
  }

  public void onCRecoverGroupsReplyMsg(CRecoverGroupsReplyMsg paramCRecoverGroupsReplyMsg)
  {
    this.mCRecoverGroupsReplyMsg_dispatcher.onCRecoverGroupsReplyMsg(paramCRecoverGroupsReplyMsg);
  }

  public void onCRecoverPublicAccountsReplyMsg(CRecoverPublicAccountsReplyMsg paramCRecoverPublicAccountsReplyMsg)
  {
    this.mCRecoverPublicAccountsReplyMsg_dispatcher.onCRecoverPublicAccountsReplyMsg(paramCRecoverPublicAccountsReplyMsg);
  }

  public void onCRecvInternalMsg(CRecvInternalMsg paramCRecvInternalMsg)
  {
    this.mCRecvInternalMsg_dispatcher.onCRecvInternalMsg(paramCRecvInternalMsg);
  }

  public void onCRefreshPublicAccountTokenReplyMsg(CRefreshPublicAccountTokenReplyMsg paramCRefreshPublicAccountTokenReplyMsg)
  {
    this.mCRefreshPublicAccountTokenReplyMsg_dispatcher.onCRefreshPublicAccountTokenReplyMsg(paramCRefreshPublicAccountTokenReplyMsg);
  }

  public void onCRegisterViberIdReplyMsg(CRegisterViberIdReplyMsg paramCRegisterViberIdReplyMsg)
  {
    this.mCRegisterViberIdReplyMsg_dispatcher.onCRegisterViberIdReplyMsg(paramCRegisterViberIdReplyMsg);
  }

  public void onCRegisteredContactsMsg(CRegisteredContactsMsg paramCRegisteredContactsMsg)
  {
    this.mCRegisteredContactsMsg_dispatcher.onCRegisteredContactsMsg(paramCRegisteredContactsMsg);
  }

  public void onCRevokeGroup2InviteReplyMsg(CRevokeGroup2InviteReplyMsg paramCRevokeGroup2InviteReplyMsg)
  {
    this.mCRevokeGroup2InviteReplyMsg_dispatcher.onCRevokeGroup2InviteReplyMsg(paramCRevokeGroup2InviteReplyMsg);
  }

  public void onCRevokeGroupInviteReplyMsg(CRevokeGroupInviteReplyMsg paramCRevokeGroupInviteReplyMsg)
  {
    this.mCRevokeGroupInviteReplyMsg_dispatcher.onCRevokeGroupInviteReplyMsg(paramCRevokeGroupInviteReplyMsg);
  }

  public void onCSecretChatReceivedEventMsg(CSecretChatReceivedEventMsg paramCSecretChatReceivedEventMsg)
  {
    this.mCSecretChatReceivedEventMsg_dispatcher.onCSecretChatReceivedEventMsg(paramCSecretChatReceivedEventMsg);
  }

  public void onCSecretChatSendEventReplyMsg(CSecretChatSendEventReplyMsg paramCSecretChatSendEventReplyMsg)
  {
    this.mCSecretChatSendEventReplyMsg_dispatcher.onCSecretChatSendEventReplyMsg(paramCSecretChatSendEventReplyMsg);
  }

  public void onCSecureSecondaryRegistrationFailureMsg(CSecureSecondaryRegistrationFailureMsg paramCSecureSecondaryRegistrationFailureMsg)
  {
    this.mCSecureSecondaryRegistrationFailureMsg_dispatcher.onCSecureSecondaryRegistrationFailureMsg(paramCSecureSecondaryRegistrationFailureMsg);
  }

  public void onCSendActionOnPGReplyMsg(CSendActionOnPGReplyMsg paramCSendActionOnPGReplyMsg)
  {
    this.mCSendActionOnPGReplyMsg_dispatcher.onCSendActionOnPGReplyMsg(paramCSendActionOnPGReplyMsg);
  }

  public void onCSendActionToBotReplyMsg(CSendActionToBotReplyMsg paramCSendActionToBotReplyMsg)
  {
    this.mCSendActionToBotReplyMsg_dispatcher.onCSendActionToBotReplyMsg(paramCSendActionToBotReplyMsg);
  }

  public void onCSendBannerToClientMsg(CSendBannerToClientMsg paramCSendBannerToClientMsg)
  {
    this.mCSendBannerToClientMsg_dispatcher.onCSendBannerToClientMsg(paramCSendBannerToClientMsg);
  }

  public void onCSendConversationStatusReplyMsg(CSendConversationStatusReplyMsg paramCSendConversationStatusReplyMsg)
  {
    this.mCSendConversationStatusReplyMsg_dispatcher.onCSendConversationStatusReplyMsg(paramCSendConversationStatusReplyMsg);
  }

  public void onCSendGroupUserIsTypingMsg(CSendGroupUserIsTypingMsg paramCSendGroupUserIsTypingMsg)
  {
    this.mCSendGroupUserIsTypingMsg_dispatcher.onCSendGroupUserIsTypingMsg(paramCSendGroupUserIsTypingMsg);
  }

  public void onCSendInternalMsgReply(CSendInternalMsgReply paramCSendInternalMsgReply)
  {
    this.mCSendInternalMsgReply_dispatcher.onCSendInternalMsgReply(paramCSendInternalMsgReply);
  }

  public void onCSendMessageReplyAckMsg(CSendMessageReplyAckMsg paramCSendMessageReplyAckMsg)
  {
    this.mCSendMessageReplyAckMsg_dispatcher.onCSendMessageReplyAckMsg(paramCSendMessageReplyAckMsg);
  }

  public void onCSendMessageReplyMsg(CSendMessageReplyMsg paramCSendMessageReplyMsg)
  {
    this.mCSendMessageReplyMsg_dispatcher.onCSendMessageReplyMsg(paramCSendMessageReplyMsg);
  }

  public void onCSendUserIsTypingMsg(CSendUserIsTypingMsg paramCSendUserIsTypingMsg)
  {
    this.mCSendUserIsTypingMsg_dispatcher.onCSendUserIsTypingMsg(paramCSendUserIsTypingMsg);
  }

  public void onCShareAddressBook2ReplyMsg(CShareAddressBook2ReplyMsg paramCShareAddressBook2ReplyMsg)
  {
    this.mCShareAddressBook2ReplyMsg_dispatcher.onCShareAddressBook2ReplyMsg(paramCShareAddressBook2ReplyMsg);
  }

  public void onCSyncActionOnPGMsg(CSyncActionOnPGMsg paramCSyncActionOnPGMsg)
  {
    this.mCSyncActionOnPGMsg_dispatcher.onCSyncActionOnPGMsg(paramCSyncActionOnPGMsg);
  }

  public void onCSyncConversationReplyMsg(CSyncConversationReplyMsg paramCSyncConversationReplyMsg)
  {
    this.mCSyncConversationReplyMsg_dispatcher.onCSyncConversationReplyMsg(paramCSyncConversationReplyMsg);
  }

  public void onCSyncDataFromMyOtherDeviceMsg(CSyncDataFromMyOtherDeviceMsg paramCSyncDataFromMyOtherDeviceMsg)
  {
    this.mCSyncDataFromMyOtherDeviceMsg_dispatcher.onCSyncDataFromMyOtherDeviceMsg(paramCSyncDataFromMyOtherDeviceMsg);
  }

  public void onCSyncDataToMyDevicesReplyMsg(CSyncDataToMyDevicesReplyMsg paramCSyncDataToMyDevicesReplyMsg)
  {
    this.mCSyncDataToMyDevicesReplyMsg_dispatcher.onCSyncDataToMyDevicesReplyMsg(paramCSyncDataToMyDevicesReplyMsg);
  }

  public void onCSyncGroupReplyMsg(CSyncGroupReplyMsg paramCSyncGroupReplyMsg)
  {
    this.mCSyncGroupReplyMsg_dispatcher.onCSyncGroupReplyMsg(paramCSyncGroupReplyMsg);
  }

  public void onCSyncMessagesReplyMsg(CSyncMessagesReplyMsg paramCSyncMessagesReplyMsg)
  {
    this.mCSyncMessagesReplyMsg_dispatcher.onCSyncMessagesReplyMsg(paramCSyncMessagesReplyMsg);
  }

  public void onCUnlinkViberIdReplyMsg(CUnlinkViberIdReplyMsg paramCUnlinkViberIdReplyMsg)
  {
    this.mCUnlinkViberIdReplyMsg_dispatcher.onCUnlinkViberIdReplyMsg(paramCUnlinkViberIdReplyMsg);
  }

  public void onCUnregisterAppReplyMsg(CUnregisterAppReplyMsg paramCUnregisterAppReplyMsg)
  {
    this.mCUnregisterAppReplyMsg_dispatcher.onCUnregisterAppReplyMsg(paramCUnregisterAppReplyMsg);
  }

  public void onCUpdateBlockListReplyMsg(CUpdateBlockListReplyMsg paramCUpdateBlockListReplyMsg)
  {
    this.mCUpdateBlockListReplyMsg_dispatcher.onCUpdateBlockListReplyMsg(paramCUpdateBlockListReplyMsg);
  }

  public void onCUpdateCommunityPrivilegesReplyMsg(CUpdateCommunityPrivilegesReplyMsg paramCUpdateCommunityPrivilegesReplyMsg)
  {
    this.mCUpdateCommunityPrivilegesReplyMsg_dispatcher.onCUpdateCommunityPrivilegesReplyMsg(paramCUpdateCommunityPrivilegesReplyMsg);
  }

  public void onCUpdateCommunitySettingsReplyMsg(CUpdateCommunitySettingsReplyMsg paramCUpdateCommunitySettingsReplyMsg)
  {
    this.mCUpdateCommunitySettingsReplyMsg_dispatcher.onCUpdateCommunitySettingsReplyMsg(paramCUpdateCommunitySettingsReplyMsg);
  }

  public void onCUpdateLanguageReplyMsg(CUpdateLanguageReplyMsg paramCUpdateLanguageReplyMsg)
  {
    this.mCUpdateLanguageReplyMsg_dispatcher.onCUpdateLanguageReplyMsg(paramCUpdateLanguageReplyMsg);
  }

  public void onCUpdateMyCommunitySettingsReplyMsg(CUpdateMyCommunitySettingsReplyMsg paramCUpdateMyCommunitySettingsReplyMsg)
  {
    this.mCUpdateMyCommunitySettingsReplyMsg_dispatcher.onCUpdateMyCommunitySettingsReplyMsg(paramCUpdateMyCommunitySettingsReplyMsg);
  }

  public void onCUpdatePersonalDetailsReplyMsg(CUpdatePersonalDetailsReplyMsg paramCUpdatePersonalDetailsReplyMsg)
  {
    this.mCUpdatePersonalDetailsReplyMsg_dispatcher.onCUpdatePersonalDetailsReplyMsg(paramCUpdatePersonalDetailsReplyMsg);
  }

  public void onCUpdateSelfUserDetailsMsg(CUpdateSelfUserDetailsMsg paramCUpdateSelfUserDetailsMsg)
  {
    this.mCUpdateSelfUserDetailsMsg_dispatcher.onCUpdateSelfUserDetailsMsg(paramCUpdateSelfUserDetailsMsg);
  }

  public void onCUpdateUnsavedContactDetailsMsg(CUpdateUnsavedContactDetailsMsg paramCUpdateUnsavedContactDetailsMsg)
  {
    this.mCUpdateUnsavedContactDetailsMsg_dispatcher.onCUpdateUnsavedContactDetailsMsg(paramCUpdateUnsavedContactDetailsMsg);
  }

  public void onCUpdateUserDateOfBirthReplyMsg(CUpdateUserDateOfBirthReplyMsg paramCUpdateUserDateOfBirthReplyMsg)
  {
    this.mCUpdateUserDateOfBirthReplyMsg_dispatcher.onCUpdateUserDateOfBirthReplyMsg(paramCUpdateUserDateOfBirthReplyMsg);
  }

  public void onCUpdateUserNameReplyMsg(CUpdateUserNameReplyMsg paramCUpdateUserNameReplyMsg)
  {
    this.mCUpdateUserNameReplyMsg_dispatcher.onCUpdateUserNameReplyMsg(paramCUpdateUserNameReplyMsg);
  }

  public void onCUpdateUserPhotoReplyMsg(CUpdateUserPhotoReplyMsg paramCUpdateUserPhotoReplyMsg)
  {
    this.mCUpdateUserPhotoReplyMsg_dispatcher.onCUpdateUserPhotoReplyMsg(paramCUpdateUserPhotoReplyMsg);
  }

  public void onCValidateGroupUriReplyMsg(CValidateGroupUriReplyMsg paramCValidateGroupUriReplyMsg)
  {
    this.mCValidateGroupUriReplyMsg_dispatcher.onCValidateGroupUriReplyMsg(paramCValidateGroupUriReplyMsg);
  }

  public void onCViberIdChangedMsg(CViberIdChangedMsg paramCViberIdChangedMsg)
  {
    this.mCViberIdChangedMsg_dispatcher.onCViberIdChangedMsg(paramCViberIdChangedMsg);
  }

  private static class CAcceptGroupInviteReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CAcceptGroupInviteReplyMsg.Receiver>
    implements CAcceptGroupInviteReplyMsg.Receiver
  {
    public void onCAcceptGroupInviteReplyMsg(final CAcceptGroupInviteReplyMsg paramCAcceptGroupInviteReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CAcceptGroupInviteReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCAcceptGroupInviteReplyMsg(paramCAcceptGroupInviteReplyMsg);
        }
      });
    }
  }

  private static class CActOnViberIdPasswordReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CActOnViberIdPasswordReplyMsg.Receiver>
    implements CActOnViberIdPasswordReplyMsg.Receiver
  {
    public void onCActOnViberIdPasswordReplyMsg(final CActOnViberIdPasswordReplyMsg paramCActOnViberIdPasswordReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CActOnViberIdPasswordReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCActOnViberIdPasswordReplyMsg(paramCActOnViberIdPasswordReplyMsg);
        }
      });
    }
  }

  private static class CAddressBookDeltaUpdateV2Msg_dispatcher extends Im2DispatcherBase.DispatcherBase<CAddressBookDeltaUpdateV2Msg.Receiver>
    implements CAddressBookDeltaUpdateV2Msg.Receiver
  {
    public void onCAddressBookDeltaUpdateV2Msg(final CAddressBookDeltaUpdateV2Msg paramCAddressBookDeltaUpdateV2Msg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CAddressBookDeltaUpdateV2Msg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCAddressBookDeltaUpdateV2Msg(paramCAddressBookDeltaUpdateV2Msg);
        }
      });
    }
  }

  private static class CAddressBookForSecondaryV2Msg_dispatcher extends Im2DispatcherBase.DispatcherBase<CAddressBookForSecondaryV2Msg.Receiver>
    implements CAddressBookForSecondaryV2Msg.Receiver
  {
    public void onCAddressBookForSecondaryV2Msg(final CAddressBookForSecondaryV2Msg paramCAddressBookForSecondaryV2Msg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CAddressBookForSecondaryV2Msg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCAddressBookForSecondaryV2Msg(paramCAddressBookForSecondaryV2Msg);
        }
      });
    }
  }

  private static class CAuthenticateAppReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CAuthenticateAppReplyMsg.Receiver>
    implements CAuthenticateAppReplyMsg.Receiver
  {
    public void onCAuthenticateAppReplyMsg(final CAuthenticateAppReplyMsg paramCAuthenticateAppReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CAuthenticateAppReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCAuthenticateAppReplyMsg(paramCAuthenticateAppReplyMsg);
        }
      });
    }
  }

  private static class CBillingTokenByMidReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CBillingTokenByMidReplyMsg.Receiver>
    implements CBillingTokenByMidReplyMsg.Receiver
  {
    public void onCBillingTokenByMidReplyMsg(final CBillingTokenByMidReplyMsg paramCBillingTokenByMidReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CBillingTokenByMidReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCBillingTokenByMidReplyMsg(paramCBillingTokenByMidReplyMsg);
        }
      });
    }
  }

  private static class CBillingTokenReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CBillingTokenReplyMsg.Receiver>
    implements CBillingTokenReplyMsg.Receiver
  {
    public void onCBillingTokenReplyMsg(final CBillingTokenReplyMsg paramCBillingTokenReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CBillingTokenReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCBillingTokenReplyMsg(paramCBillingTokenReplyMsg);
        }
      });
    }
  }

  private static class CBlockAppReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CBlockAppReplyMsg.Receiver>
    implements CBlockAppReplyMsg.Receiver
  {
    public void onCBlockAppReplyMsg(final CBlockAppReplyMsg paramCBlockAppReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CBlockAppReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCBlockAppReplyMsg(paramCBlockAppReplyMsg);
        }
      });
    }
  }

  private static class CBlockGroupInviteReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CBlockGroupInviteReplyMsg.Receiver>
    implements CBlockGroupInviteReplyMsg.Receiver
  {
    public void onCBlockGroupInviteReplyMsg(final CBlockGroupInviteReplyMsg paramCBlockGroupInviteReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CBlockGroupInviteReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCBlockGroupInviteReplyMsg(paramCBlockGroupInviteReplyMsg);
        }
      });
    }
  }

  private static class CChangeConversationSettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CChangeConversationSettingsReplyMsg.Receiver>
    implements CChangeConversationSettingsReplyMsg.Receiver
  {
    public void onCChangeConversationSettingsReplyMsg(final CChangeConversationSettingsReplyMsg paramCChangeConversationSettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CChangeConversationSettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCChangeConversationSettingsReplyMsg(paramCChangeConversationSettingsReplyMsg);
        }
      });
    }
  }

  private static class CChangeGroupAttributesReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CChangeGroupAttributesReplyMsg.Receiver>
    implements CChangeGroupAttributesReplyMsg.Receiver
  {
    public void onCChangeGroupAttributesReplyMsg(final CChangeGroupAttributesReplyMsg paramCChangeGroupAttributesReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CChangeGroupAttributesReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCChangeGroupAttributesReplyMsg(paramCChangeGroupAttributesReplyMsg);
        }
      });
    }
  }

  private static class CChangeGroupSettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CChangeGroupSettingsReplyMsg.Receiver>
    implements CChangeGroupSettingsReplyMsg.Receiver
  {
    public void onCChangeGroupSettingsReplyMsg(final CChangeGroupSettingsReplyMsg paramCChangeGroupSettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CChangeGroupSettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCChangeGroupSettingsReplyMsg(paramCChangeGroupSettingsReplyMsg);
        }
      });
    }
  }

  private static class CChangeLastOnlineSettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CChangeLastOnlineSettingsReplyMsg.Receiver>
    implements CChangeLastOnlineSettingsReplyMsg.Receiver
  {
    public void onCChangeLastOnlineSettingsReplyMsg(final CChangeLastOnlineSettingsReplyMsg paramCChangeLastOnlineSettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CChangeLastOnlineSettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCChangeLastOnlineSettingsReplyMsg(paramCChangeLastOnlineSettingsReplyMsg);
        }
      });
    }
  }

  private static class CChangeReadNotificationsSettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CChangeReadNotificationsSettingsReplyMsg.Receiver>
    implements CChangeReadNotificationsSettingsReplyMsg.Receiver
  {
    public void onCChangeReadNotificationsSettingsReplyMsg(final CChangeReadNotificationsSettingsReplyMsg paramCChangeReadNotificationsSettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CChangeReadNotificationsSettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCChangeReadNotificationsSettingsReplyMsg(paramCChangeReadNotificationsSettingsReplyMsg);
        }
      });
    }
  }

  private static class CChangeSettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CChangeSettingsReplyMsg.Receiver>
    implements CChangeSettingsReplyMsg.Receiver
  {
    public void onCChangeSettingsReplyMsg(final CChangeSettingsReplyMsg paramCChangeSettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CChangeSettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCChangeSettingsReplyMsg(paramCChangeSettingsReplyMsg);
        }
      });
    }
  }

  private static class CChangeUserActivitySettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CChangeUserActivitySettingsReplyMsg.Receiver>
    implements CChangeUserActivitySettingsReplyMsg.Receiver
  {
    public void onCChangeUserActivitySettingsReplyMsg(final CChangeUserActivitySettingsReplyMsg paramCChangeUserActivitySettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CChangeUserActivitySettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCChangeUserActivitySettingsReplyMsg(paramCChangeUserActivitySettingsReplyMsg);
        }
      });
    }
  }

  private static class CChangeViberIdEmailReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CChangeViberIdEmailReplyMsg.Receiver>
    implements CChangeViberIdEmailReplyMsg.Receiver
  {
    public void onCChangeViberIdEmailReplyMsg(final CChangeViberIdEmailReplyMsg paramCChangeViberIdEmailReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CChangeViberIdEmailReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCChangeViberIdEmailReplyMsg(paramCChangeViberIdEmailReplyMsg);
        }
      });
    }
  }

  private static class CCheckAllowsM2MChatReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CCheckAllowsM2MChatReplyMsg.Receiver>
    implements CCheckAllowsM2MChatReplyMsg.Receiver
  {
    public void onCCheckAllowsM2MChatReplyMsg(final CCheckAllowsM2MChatReplyMsg paramCCheckAllowsM2MChatReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CCheckAllowsM2MChatReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCCheckAllowsM2MChatReplyMsg(paramCCheckAllowsM2MChatReplyMsg);
        }
      });
    }
  }

  private static class CCheckEmailStatusReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CCheckEmailStatusReplyMsg.Receiver>
    implements CCheckEmailStatusReplyMsg.Receiver
  {
    public void onCCheckEmailStatusReplyMsg(final CCheckEmailStatusReplyMsg paramCCheckEmailStatusReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CCheckEmailStatusReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCCheckEmailStatusReplyMsg(paramCCheckEmailStatusReplyMsg);
        }
      });
    }
  }

  private static class CCheckGroup2InviteReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CCheckGroup2InviteReplyMsg.Receiver>
    implements CCheckGroup2InviteReplyMsg.Receiver
  {
    public void onCCheckGroup2InviteReplyMsg(final CCheckGroup2InviteReplyMsg paramCCheckGroup2InviteReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CCheckGroup2InviteReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCCheckGroup2InviteReplyMsg(paramCCheckGroup2InviteReplyMsg);
        }
      });
    }
  }

  private static class CConfirmOrRevokeEmailReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CConfirmOrRevokeEmailReplyMsg.Receiver>
    implements CConfirmOrRevokeEmailReplyMsg.Receiver
  {
    public void onCConfirmOrRevokeEmailReplyMsg(final CConfirmOrRevokeEmailReplyMsg paramCConfirmOrRevokeEmailReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CConfirmOrRevokeEmailReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCConfirmOrRevokeEmailReplyMsg(paramCConfirmOrRevokeEmailReplyMsg);
        }
      });
    }
  }

  private static class CContactSavedInConversationNotificationReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CContactSavedInConversationNotificationReplyMsg.Receiver>
    implements CContactSavedInConversationNotificationReplyMsg.Receiver
  {
    public void onCContactSavedInConversationNotificationReplyMsg(final CContactSavedInConversationNotificationReplyMsg paramCContactSavedInConversationNotificationReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CContactSavedInConversationNotificationReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCContactSavedInConversationNotificationReplyMsg(paramCContactSavedInConversationNotificationReplyMsg);
        }
      });
    }
  }

  private static class CConversationSynchedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CConversationSynchedMsg.Receiver>
    implements CConversationSynchedMsg.Receiver
  {
    public void onCConversationSynchedMsg(final CConversationSynchedMsg paramCConversationSynchedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CConversationSynchedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCConversationSynchedMsg(paramCConversationSynchedMsg);
        }
      });
    }
  }

  private static class CCreateConferenceCallReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CCreateConferenceCallReplyMsg.Receiver>
    implements CCreateConferenceCallReplyMsg.Receiver
  {
    public void onCCreateConferenceCallReplyMsg(final CCreateConferenceCallReplyMsg paramCCreateConferenceCallReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CCreateConferenceCallReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCCreateConferenceCallReplyMsg(paramCCreateConferenceCallReplyMsg);
        }
      });
    }
  }

  private static class CCreateGroup2InviteReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CCreateGroup2InviteReplyMsg.Receiver>
    implements CCreateGroup2InviteReplyMsg.Receiver
  {
    public void onCCreateGroup2InviteReplyMsg(final CCreateGroup2InviteReplyMsg paramCCreateGroup2InviteReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CCreateGroup2InviteReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCCreateGroup2InviteReplyMsg(paramCCreateGroup2InviteReplyMsg);
        }
      });
    }
  }

  private static class CCreateGroupInviteReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CCreateGroupInviteReplyMsg.Receiver>
    implements CCreateGroupInviteReplyMsg.Receiver
  {
    public void onCCreateGroupInviteReplyMsg(final CCreateGroupInviteReplyMsg paramCCreateGroupInviteReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CCreateGroupInviteReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCCreateGroupInviteReplyMsg(paramCCreateGroupInviteReplyMsg);
        }
      });
    }
  }

  private static class CCreateGroupReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CCreateGroupReplyMsg.Receiver>
    implements CCreateGroupReplyMsg.Receiver
  {
    public void onCCreateGroupReplyMsg(final CCreateGroupReplyMsg paramCCreateGroupReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CCreateGroupReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCCreateGroupReplyMsg(paramCCreateGroupReplyMsg);
        }
      });
    }
  }

  private static class CDeleteAllUserMessagesReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CDeleteAllUserMessagesReplyMsg.Receiver>
    implements CDeleteAllUserMessagesReplyMsg.Receiver
  {
    public void onCDeleteAllUserMessagesReplyMsg(final CDeleteAllUserMessagesReplyMsg paramCDeleteAllUserMessagesReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CDeleteAllUserMessagesReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCDeleteAllUserMessagesReplyMsg(paramCDeleteAllUserMessagesReplyMsg);
        }
      });
    }
  }

  private static class CDeleteGlobalMessageReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CDeleteGlobalMessageReplyMsg.Receiver>
    implements CDeleteGlobalMessageReplyMsg.Receiver
  {
    public void onCDeleteGlobalMessageReplyMsg(final CDeleteGlobalMessageReplyMsg paramCDeleteGlobalMessageReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CDeleteGlobalMessageReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCDeleteGlobalMessageReplyMsg(paramCDeleteGlobalMessageReplyMsg);
        }
      });
    }
  }

  private static class CDeleteMessageReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CDeleteMessageReplyMsg.Receiver>
    implements CDeleteMessageReplyMsg.Receiver
  {
    public void onCDeleteMessageReplyMsg(final CDeleteMessageReplyMsg paramCDeleteMessageReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CDeleteMessageReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCDeleteMessageReplyMsg(paramCDeleteMessageReplyMsg);
        }
      });
    }
  }

  private static class CDeletedMessageMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CDeletedMessageMsg.Receiver>
    implements CDeletedMessageMsg.Receiver
  {
    public void onCDeletedMessageMsg(final CDeletedMessageMsg paramCDeletedMessageMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CDeletedMessageMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCDeletedMessageMsg(paramCDeletedMessageMsg);
        }
      });
    }
  }

  private static class CGdprCommandReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGdprCommandReplyMsg.Receiver>
    implements CGdprCommandReplyMsg.Receiver
  {
    public void onCGdprCommandReplyMsg(final CGdprCommandReplyMsg paramCGdprCommandReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGdprCommandReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGdprCommandReplyMsg(paramCGdprCommandReplyMsg);
        }
      });
    }
  }

  private static class CGetAdInfoReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetAdInfoReplyMsg.Receiver>
    implements CGetAdInfoReplyMsg.Receiver
  {
    public void onCGetAdInfoReplyMsg(final CGetAdInfoReplyMsg paramCGetAdInfoReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetAdInfoReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetAdInfoReplyMsg(paramCGetAdInfoReplyMsg);
        }
      });
    }
  }

  private static class CGetCommonCommunitiesReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetCommonCommunitiesReplyMsg.Receiver>
    implements CGetCommonCommunitiesReplyMsg.Receiver
  {
    public void onCGetCommonCommunitiesReplyMsg(final CGetCommonCommunitiesReplyMsg paramCGetCommonCommunitiesReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetCommonCommunitiesReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetCommonCommunitiesReplyMsg(paramCGetCommonCommunitiesReplyMsg);
        }
      });
    }
  }

  private static class CGetDownloadDetailsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetDownloadDetailsReplyMsg.Receiver>
    implements CGetDownloadDetailsReplyMsg.Receiver
  {
    public void onCGetDownloadDetailsReplyMsg(final CGetDownloadDetailsReplyMsg paramCGetDownloadDetailsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetDownloadDetailsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetDownloadDetailsReplyMsg(paramCGetDownloadDetailsReplyMsg);
        }
      });
    }
  }

  private static class CGetEncryptedMIDsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetEncryptedMIDsReplyMsg.Receiver>
    implements CGetEncryptedMIDsReplyMsg.Receiver
  {
    public void onCGetEncryptedMIDsReplyMsg(final CGetEncryptedMIDsReplyMsg paramCGetEncryptedMIDsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetEncryptedMIDsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetEncryptedMIDsReplyMsg(paramCGetEncryptedMIDsReplyMsg);
        }
      });
    }
  }

  private static class CGetGroup2AccessTokenReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetGroup2AccessTokenReplyMsg.Receiver>
    implements CGetGroup2AccessTokenReplyMsg.Receiver
  {
    public void onCGetGroup2AccessTokenReplyMsg(final CGetGroup2AccessTokenReplyMsg paramCGetGroup2AccessTokenReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetGroup2AccessTokenReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetGroup2AccessTokenReplyMsg(paramCGetGroup2AccessTokenReplyMsg);
        }
      });
    }
  }

  private static class CGetGroupInfoReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetGroupInfoReplyMsg.Receiver>
    implements CGetGroupInfoReplyMsg.Receiver
  {
    public void onCGetGroupInfoReplyMsg(final CGetGroupInfoReplyMsg paramCGetGroupInfoReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetGroupInfoReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetGroupInfoReplyMsg(paramCGetGroupInfoReplyMsg);
        }
      });
    }
  }

  private static class CGetGroupMessageStatusReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetGroupMessageStatusReplyMsg.Receiver>
    implements CGetGroupMessageStatusReplyMsg.Receiver
  {
    public void onCGetGroupMessageStatusReplyMsg(final CGetGroupMessageStatusReplyMsg paramCGetGroupMessageStatusReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetGroupMessageStatusReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetGroupMessageStatusReplyMsg(paramCGetGroupMessageStatusReplyMsg);
        }
      });
    }
  }

  private static class CGetInviteLinksReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetInviteLinksReplyMsg.Receiver>
    implements CGetInviteLinksReplyMsg.Receiver
  {
    public void onCGetInviteLinksReplyMsg(final CGetInviteLinksReplyMsg paramCGetInviteLinksReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetInviteLinksReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetInviteLinksReplyMsg(paramCGetInviteLinksReplyMsg);
        }
      });
    }
  }

  private static class CGetLastOnlineReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetLastOnlineReplyMsg.Receiver>
    implements CGetLastOnlineReplyMsg.Receiver
  {
    public void onCGetLastOnlineReplyMsg(final CGetLastOnlineReplyMsg paramCGetLastOnlineReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetLastOnlineReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetLastOnlineReplyMsg(paramCGetLastOnlineReplyMsg);
        }
      });
    }
  }

  private static class CGetMyCommunitySettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetMyCommunitySettingsReplyMsg.Receiver>
    implements CGetMyCommunitySettingsReplyMsg.Receiver
  {
    public void onCGetMyCommunitySettingsReplyMsg(final CGetMyCommunitySettingsReplyMsg paramCGetMyCommunitySettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetMyCommunitySettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetMyCommunitySettingsReplyMsg(paramCGetMyCommunitySettingsReplyMsg);
        }
      });
    }
  }

  private static class CGetPersonalDetailsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetPersonalDetailsReplyMsg.Receiver>
    implements CGetPersonalDetailsReplyMsg.Receiver
  {
    public void onCGetPersonalDetailsReplyMsg(final CGetPersonalDetailsReplyMsg paramCGetPersonalDetailsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetPersonalDetailsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetPersonalDetailsReplyMsg(paramCGetPersonalDetailsReplyMsg);
        }
      });
    }
  }

  private static class CGetPersonalProfileReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetPersonalProfileReplyMsg.Receiver>
    implements CGetPersonalProfileReplyMsg.Receiver
  {
    public void onCGetPersonalProfileReplyMsg(final CGetPersonalProfileReplyMsg paramCGetPersonalProfileReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetPersonalProfileReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetPersonalProfileReplyMsg(paramCGetPersonalProfileReplyMsg);
        }
      });
    }
  }

  private static class CGetPublicAccountInfoReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetPublicAccountInfoReplyMsg.Receiver>
    implements CGetPublicAccountInfoReplyMsg.Receiver
  {
    public void onCGetPublicAccountInfoReplyMsg(final CGetPublicAccountInfoReplyMsg paramCGetPublicAccountInfoReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetPublicAccountInfoReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetPublicAccountInfoReplyMsg(paramCGetPublicAccountInfoReplyMsg);
        }
      });
    }
  }

  private static class CGetPublicGroupInfoReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetPublicGroupInfoReplyMsg.Receiver>
    implements CGetPublicGroupInfoReplyMsg.Receiver
  {
    public void onCGetPublicGroupInfoReplyMsg(final CGetPublicGroupInfoReplyMsg paramCGetPublicGroupInfoReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetPublicGroupInfoReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetPublicGroupInfoReplyMsg(paramCGetPublicGroupInfoReplyMsg);
        }
      });
    }
  }

  private static class CGetSecondaryDeviceDetailsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetSecondaryDeviceDetailsReplyMsg.Receiver>
    implements CGetSecondaryDeviceDetailsReplyMsg.Receiver
  {
    public void onCGetSecondaryDeviceDetailsReplyMsg(final CGetSecondaryDeviceDetailsReplyMsg paramCGetSecondaryDeviceDetailsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetSecondaryDeviceDetailsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetSecondaryDeviceDetailsReplyMsg(paramCGetSecondaryDeviceDetailsReplyMsg);
        }
      });
    }
  }

  private static class CGetUserActivityReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetUserActivityReplyMsg.Receiver>
    implements CGetUserActivityReplyMsg.Receiver
  {
    public void onCGetUserActivityReplyMsg(final CGetUserActivityReplyMsg paramCGetUserActivityReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetUserActivityReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetUserActivityReplyMsg(paramCGetUserActivityReplyMsg);
        }
      });
    }
  }

  private static class CGetUserAppsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetUserAppsReplyMsg.Receiver>
    implements CGetUserAppsReplyMsg.Receiver
  {
    public void onCGetUserAppsReplyMsg(final CGetUserAppsReplyMsg paramCGetUserAppsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetUserAppsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetUserAppsReplyMsg(paramCGetUserAppsReplyMsg);
        }
      });
    }
  }

  private static class CGetUserDateOfBirthReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetUserDateOfBirthReplyMsg.Receiver>
    implements CGetUserDateOfBirthReplyMsg.Receiver
  {
    public void onCGetUserDateOfBirthReplyMsg(final CGetUserDateOfBirthReplyMsg paramCGetUserDateOfBirthReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetUserDateOfBirthReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetUserDateOfBirthReplyMsg(paramCGetUserDateOfBirthReplyMsg);
        }
      });
    }
  }

  private static class CGetUsersDetailsV2ReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetUsersDetailsV2ReplyMsg.Receiver>
    implements CGetUsersDetailsV2ReplyMsg.Receiver
  {
    public void onCGetUsersDetailsV2ReplyMsg(final CGetUsersDetailsV2ReplyMsg paramCGetUsersDetailsV2ReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetUsersDetailsV2ReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetUsersDetailsV2ReplyMsg(paramCGetUsersDetailsV2ReplyMsg);
        }
      });
    }
  }

  private static class CGetViberIdReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGetViberIdReplyMsg.Receiver>
    implements CGetViberIdReplyMsg.Receiver
  {
    public void onCGetViberIdReplyMsg(final CGetViberIdReplyMsg paramCGetViberIdReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGetViberIdReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGetViberIdReplyMsg(paramCGetViberIdReplyMsg);
        }
      });
    }
  }

  private static class CGroupAddMemberReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupAddMemberReplyMsg.Receiver>
    implements CGroupAddMemberReplyMsg.Receiver
  {
    public void onCGroupAddMemberReplyMsg(final CGroupAddMemberReplyMsg paramCGroupAddMemberReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupAddMemberReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupAddMemberReplyMsg(paramCGroupAddMemberReplyMsg);
        }
      });
    }
  }

  private static class CGroupAddMembersReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupAddMembersReplyMsg.Receiver>
    implements CGroupAddMembersReplyMsg.Receiver
  {
    public void onCGroupAddMembersReplyMsg(final CGroupAddMembersReplyMsg paramCGroupAddMembersReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupAddMembersReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupAddMembersReplyMsg(paramCGroupAddMembersReplyMsg);
        }
      });
    }
  }

  private static class CGroupAddWatchersReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupAddWatchersReplyMsg.Receiver>
    implements CGroupAddWatchersReplyMsg.Receiver
  {
    public void onCGroupAddWatchersReplyMsg(final CGroupAddWatchersReplyMsg paramCGroupAddWatchersReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupAddWatchersReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupAddWatchersReplyMsg(paramCGroupAddWatchersReplyMsg);
        }
      });
    }
  }

  private static class CGroupAssignRoleReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupAssignRoleReplyMsg.Receiver>
    implements CGroupAssignRoleReplyMsg.Receiver
  {
    public void onCGroupAssignRoleReplyMsg(final CGroupAssignRoleReplyMsg paramCGroupAssignRoleReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupAssignRoleReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupAssignRoleReplyMsg(paramCGroupAssignRoleReplyMsg);
        }
      });
    }
  }

  private static class CGroupBanUserReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupBanUserReplyMsg.Receiver>
    implements CGroupBanUserReplyMsg.Receiver
  {
    public void onCGroupBanUserReplyMsg(final CGroupBanUserReplyMsg paramCGroupBanUserReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupBanUserReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupBanUserReplyMsg(paramCGroupBanUserReplyMsg);
        }
      });
    }
  }

  private static class CGroupChangedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupChangedMsg.Receiver>
    implements CGroupChangedMsg.Receiver
  {
    public void onCGroupChangedMsg(final CGroupChangedMsg paramCGroupChangedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupChangedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupChangedMsg(paramCGroupChangedMsg);
        }
      });
    }
  }

  private static class CGroupLeaveReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupLeaveReplyMsg.Receiver>
    implements CGroupLeaveReplyMsg.Receiver
  {
    public void onCGroupLeaveReplyMsg(final CGroupLeaveReplyMsg paramCGroupLeaveReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupLeaveReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupLeaveReplyMsg(paramCGroupLeaveReplyMsg);
        }
      });
    }
  }

  private static class CGroupMessageLike_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupMessageLike.Receiver>
    implements CGroupMessageLike.Receiver
  {
    public void onCGroupMessageLike(final CGroupMessageLike paramCGroupMessageLike)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupMessageLike.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupMessageLike(paramCGroupMessageLike);
        }
      });
    }
  }

  private static class CGroupMessageReceivedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupMessageReceivedMsg.Receiver>
    implements CGroupMessageReceivedMsg.Receiver
  {
    public void onCGroupMessageReceivedMsg(final CGroupMessageReceivedMsg paramCGroupMessageReceivedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupMessageReceivedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupMessageReceivedMsg(paramCGroupMessageReceivedMsg);
        }
      });
    }
  }

  private static class CGroupRemoveMembersReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupRemoveMembersReplyMsg.Receiver>
    implements CGroupRemoveMembersReplyMsg.Receiver
  {
    public void onCGroupRemoveMembersReplyMsg(final CGroupRemoveMembersReplyMsg paramCGroupRemoveMembersReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupRemoveMembersReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupRemoveMembersReplyMsg(paramCGroupRemoveMembersReplyMsg);
        }
      });
    }
  }

  private static class CGroupSynchedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CGroupSynchedMsg.Receiver>
    implements CGroupSynchedMsg.Receiver
  {
    public void onCGroupSynchedMsg(final CGroupSynchedMsg paramCGroupSynchedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CGroupSynchedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCGroupSynchedMsg(paramCGroupSynchedMsg);
        }
      });
    }
  }

  private static class CInviteToConferenceReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CInviteToConferenceReplyMsg.Receiver>
    implements CInviteToConferenceReplyMsg.Receiver
  {
    public void onCInviteToConferenceReplyMsg(final CInviteToConferenceReplyMsg paramCInviteToConferenceReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CInviteToConferenceReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCInviteToConferenceReplyMsg(paramCInviteToConferenceReplyMsg);
        }
      });
    }
  }

  private static class CIsOnlineReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CIsOnlineReplyMsg.Receiver>
    implements CIsOnlineReplyMsg.Receiver
  {
    public void onCIsOnlineReplyMsg(final CIsOnlineReplyMsg paramCIsOnlineReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CIsOnlineReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCIsOnlineReplyMsg(paramCIsOnlineReplyMsg);
        }
      });
    }
  }

  private static class CIsRegisteredNumberReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CIsRegisteredNumberReplyMsg.Receiver>
    implements CIsRegisteredNumberReplyMsg.Receiver
  {
    public void onCIsRegisteredNumberReplyMsg(final CIsRegisteredNumberReplyMsg paramCIsRegisteredNumberReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CIsRegisteredNumberReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCIsRegisteredNumberReplyMsg(paramCIsRegisteredNumberReplyMsg);
        }
      });
    }
  }

  private static class CJoinConfCallReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CJoinConfCallReplyMsg.Receiver>
    implements CJoinConfCallReplyMsg.Receiver
  {
    public void onCJoinConfCallReplyMsg(final CJoinConfCallReplyMsg paramCJoinConfCallReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CJoinConfCallReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCJoinConfCallReplyMsg(paramCJoinConfCallReplyMsg);
        }
      });
    }
  }

  private static class CLateErrorOnReceivedMessageReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CLateErrorOnReceivedMessageReplyMsg.Receiver>
    implements CLateErrorOnReceivedMessageReplyMsg.Receiver
  {
    public void onCLateErrorOnReceivedMessageReplyMsg(final CLateErrorOnReceivedMessageReplyMsg paramCLateErrorOnReceivedMessageReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CLateErrorOnReceivedMessageReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCLateErrorOnReceivedMessageReplyMsg(paramCLateErrorOnReceivedMessageReplyMsg);
        }
      });
    }
  }

  private static class CLikeGroupMessageReply_dispatcher extends Im2DispatcherBase.DispatcherBase<CLikeGroupMessageReply.Receiver>
    implements CLikeGroupMessageReply.Receiver
  {
    public void onCLikeGroupMessageReply(final CLikeGroupMessageReply paramCLikeGroupMessageReply)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CLikeGroupMessageReply.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCLikeGroupMessageReply(paramCLikeGroupMessageReply);
        }
      });
    }
  }

  private static class CLoginReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CLoginReplyMsg.Receiver>
    implements CLoginReplyMsg.Receiver
  {
    public void onCLoginReplyMsg(final CLoginReplyMsg paramCLoginReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CLoginReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCLoginReplyMsg(paramCLoginReplyMsg);
        }
      });
    }
  }

  private static class CMessageDeliveredMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CMessageDeliveredMsg.Receiver>
    implements CMessageDeliveredMsg.Receiver
  {
    public void onCMessageDeliveredMsg(final CMessageDeliveredMsg paramCMessageDeliveredMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CMessageDeliveredMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCMessageDeliveredMsg(paramCMessageDeliveredMsg);
        }
      });
    }
  }

  private static class CMessageReceivedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CMessageReceivedMsg.Receiver>
    implements CMessageReceivedMsg.Receiver
  {
    public void onCMessageReceivedMsg(final CMessageReceivedMsg paramCMessageReceivedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CMessageReceivedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCMessageReceivedMsg(paramCMessageReceivedMsg);
        }
      });
    }
  }

  private static class CMessageReceivedReplyableAckReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CMessageReceivedReplyableAckReplyMsg.Receiver>
    implements CMessageReceivedReplyableAckReplyMsg.Receiver
  {
    public void onCMessageReceivedReplyableAckReplyMsg(final CMessageReceivedReplyableAckReplyMsg paramCMessageReceivedReplyableAckReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CMessageReceivedReplyableAckReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCMessageReceivedReplyableAckReplyMsg(paramCMessageReceivedReplyableAckReplyMsg);
        }
      });
    }
  }

  private static class CMessagesSynchedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CMessagesSynchedMsg.Receiver>
    implements CMessagesSynchedMsg.Receiver
  {
    public void onCMessagesSynchedMsg(final CMessagesSynchedMsg paramCMessagesSynchedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CMessagesSynchedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCMessagesSynchedMsg(paramCMessagesSynchedMsg);
        }
      });
    }
  }

  private static class COnClickReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<COnClickReplyMsg.Receiver>
    implements COnClickReplyMsg.Receiver
  {
    public void onCOnClickReplyMsg(final COnClickReplyMsg paramCOnClickReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(COnClickReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCOnClickReplyMsg(paramCOnClickReplyMsg);
        }
      });
    }
  }

  private static class CPGChangeReceivedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CPGChangeReceivedMsg.Receiver>
    implements CPGChangeReceivedMsg.Receiver
  {
    public void onCPGChangeReceivedMsg(final CPGChangeReceivedMsg paramCPGChangeReceivedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CPGChangeReceivedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCPGChangeReceivedMsg(paramCPGChangeReceivedMsg);
        }
      });
    }
  }

  private static class CPGMessageReceivedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CPGMessageReceivedMsg.Receiver>
    implements CPGMessageReceivedMsg.Receiver
  {
    public void onCPGMessageReceivedMsg(final CPGMessageReceivedMsg paramCPGMessageReceivedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CPGMessageReceivedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCPGMessageReceivedMsg(paramCPGMessageReceivedMsg);
        }
      });
    }
  }

  private static class CPublicAccountSubscriberUpdateReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CPublicAccountSubscriberUpdateReplyMsg.Receiver>
    implements CPublicAccountSubscriberUpdateReplyMsg.Receiver
  {
    public void onCPublicAccountSubscriberUpdateReplyMsg(final CPublicAccountSubscriberUpdateReplyMsg paramCPublicAccountSubscriberUpdateReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CPublicAccountSubscriberUpdateReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCPublicAccountSubscriberUpdateReplyMsg(paramCPublicAccountSubscriberUpdateReplyMsg);
        }
      });
    }
  }

  private static class CQueryDestOperationSupportReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CQueryDestOperationSupportReplyMsg.Receiver>
    implements CQueryDestOperationSupportReplyMsg.Receiver
  {
    public void onCQueryDestOperationSupportReplyMsg(final CQueryDestOperationSupportReplyMsg paramCQueryDestOperationSupportReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CQueryDestOperationSupportReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCQueryDestOperationSupportReplyMsg(paramCQueryDestOperationSupportReplyMsg);
        }
      });
    }
  }

  private static class CRecoverGroupChatsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRecoverGroupChatsReplyMsg.Receiver>
    implements CRecoverGroupChatsReplyMsg.Receiver
  {
    public void onCRecoverGroupChatsReplyMsg(final CRecoverGroupChatsReplyMsg paramCRecoverGroupChatsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRecoverGroupChatsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRecoverGroupChatsReplyMsg(paramCRecoverGroupChatsReplyMsg);
        }
      });
    }
  }

  private static class CRecoverGroupsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRecoverGroupsReplyMsg.Receiver>
    implements CRecoverGroupsReplyMsg.Receiver
  {
    public void onCRecoverGroupsReplyMsg(final CRecoverGroupsReplyMsg paramCRecoverGroupsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRecoverGroupsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRecoverGroupsReplyMsg(paramCRecoverGroupsReplyMsg);
        }
      });
    }
  }

  private static class CRecoverPublicAccountsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRecoverPublicAccountsReplyMsg.Receiver>
    implements CRecoverPublicAccountsReplyMsg.Receiver
  {
    public void onCRecoverPublicAccountsReplyMsg(final CRecoverPublicAccountsReplyMsg paramCRecoverPublicAccountsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRecoverPublicAccountsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRecoverPublicAccountsReplyMsg(paramCRecoverPublicAccountsReplyMsg);
        }
      });
    }
  }

  private static class CRecvInternalMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRecvInternalMsg.Receiver>
    implements CRecvInternalMsg.Receiver
  {
    public void onCRecvInternalMsg(final CRecvInternalMsg paramCRecvInternalMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRecvInternalMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRecvInternalMsg(paramCRecvInternalMsg);
        }
      });
    }
  }

  private static class CRefreshPublicAccountTokenReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRefreshPublicAccountTokenReplyMsg.Receiver>
    implements CRefreshPublicAccountTokenReplyMsg.Receiver
  {
    public void onCRefreshPublicAccountTokenReplyMsg(final CRefreshPublicAccountTokenReplyMsg paramCRefreshPublicAccountTokenReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRefreshPublicAccountTokenReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRefreshPublicAccountTokenReplyMsg(paramCRefreshPublicAccountTokenReplyMsg);
        }
      });
    }
  }

  private static class CRegisterViberIdReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRegisterViberIdReplyMsg.Receiver>
    implements CRegisterViberIdReplyMsg.Receiver
  {
    public void onCRegisterViberIdReplyMsg(final CRegisterViberIdReplyMsg paramCRegisterViberIdReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRegisterViberIdReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRegisterViberIdReplyMsg(paramCRegisterViberIdReplyMsg);
        }
      });
    }
  }

  private static class CRegisteredContactsMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRegisteredContactsMsg.Receiver>
    implements CRegisteredContactsMsg.Receiver
  {
    public void onCRegisteredContactsMsg(final CRegisteredContactsMsg paramCRegisteredContactsMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRegisteredContactsMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRegisteredContactsMsg(paramCRegisteredContactsMsg);
        }
      });
    }
  }

  private static class CRevokeGroup2InviteReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRevokeGroup2InviteReplyMsg.Receiver>
    implements CRevokeGroup2InviteReplyMsg.Receiver
  {
    public void onCRevokeGroup2InviteReplyMsg(final CRevokeGroup2InviteReplyMsg paramCRevokeGroup2InviteReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRevokeGroup2InviteReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRevokeGroup2InviteReplyMsg(paramCRevokeGroup2InviteReplyMsg);
        }
      });
    }
  }

  private static class CRevokeGroupInviteReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CRevokeGroupInviteReplyMsg.Receiver>
    implements CRevokeGroupInviteReplyMsg.Receiver
  {
    public void onCRevokeGroupInviteReplyMsg(final CRevokeGroupInviteReplyMsg paramCRevokeGroupInviteReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CRevokeGroupInviteReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCRevokeGroupInviteReplyMsg(paramCRevokeGroupInviteReplyMsg);
        }
      });
    }
  }

  private static class CSecretChatReceivedEventMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSecretChatReceivedEventMsg.Receiver>
    implements CSecretChatReceivedEventMsg.Receiver
  {
    public void onCSecretChatReceivedEventMsg(final CSecretChatReceivedEventMsg paramCSecretChatReceivedEventMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSecretChatReceivedEventMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSecretChatReceivedEventMsg(paramCSecretChatReceivedEventMsg);
        }
      });
    }
  }

  private static class CSecretChatSendEventReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSecretChatSendEventReplyMsg.Receiver>
    implements CSecretChatSendEventReplyMsg.Receiver
  {
    public void onCSecretChatSendEventReplyMsg(final CSecretChatSendEventReplyMsg paramCSecretChatSendEventReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSecretChatSendEventReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSecretChatSendEventReplyMsg(paramCSecretChatSendEventReplyMsg);
        }
      });
    }
  }

  private static class CSecureSecondaryRegistrationFailureMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSecureSecondaryRegistrationFailureMsg.Receiver>
    implements CSecureSecondaryRegistrationFailureMsg.Receiver
  {
    public void onCSecureSecondaryRegistrationFailureMsg(final CSecureSecondaryRegistrationFailureMsg paramCSecureSecondaryRegistrationFailureMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSecureSecondaryRegistrationFailureMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSecureSecondaryRegistrationFailureMsg(paramCSecureSecondaryRegistrationFailureMsg);
        }
      });
    }
  }

  private static class CSendActionOnPGReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendActionOnPGReplyMsg.Receiver>
    implements CSendActionOnPGReplyMsg.Receiver
  {
    public void onCSendActionOnPGReplyMsg(final CSendActionOnPGReplyMsg paramCSendActionOnPGReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendActionOnPGReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendActionOnPGReplyMsg(paramCSendActionOnPGReplyMsg);
        }
      });
    }
  }

  private static class CSendActionToBotReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendActionToBotReplyMsg.Receiver>
    implements CSendActionToBotReplyMsg.Receiver
  {
    public void onCSendActionToBotReplyMsg(final CSendActionToBotReplyMsg paramCSendActionToBotReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendActionToBotReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendActionToBotReplyMsg(paramCSendActionToBotReplyMsg);
        }
      });
    }
  }

  private static class CSendBannerToClientMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendBannerToClientMsg.Receiver>
    implements CSendBannerToClientMsg.Receiver
  {
    public void onCSendBannerToClientMsg(final CSendBannerToClientMsg paramCSendBannerToClientMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendBannerToClientMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendBannerToClientMsg(paramCSendBannerToClientMsg);
        }
      });
    }
  }

  private static class CSendConversationStatusReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendConversationStatusReplyMsg.Receiver>
    implements CSendConversationStatusReplyMsg.Receiver
  {
    public void onCSendConversationStatusReplyMsg(final CSendConversationStatusReplyMsg paramCSendConversationStatusReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendConversationStatusReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendConversationStatusReplyMsg(paramCSendConversationStatusReplyMsg);
        }
      });
    }
  }

  private static class CSendGroupUserIsTypingMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendGroupUserIsTypingMsg.Receiver>
    implements CSendGroupUserIsTypingMsg.Receiver
  {
    public void onCSendGroupUserIsTypingMsg(final CSendGroupUserIsTypingMsg paramCSendGroupUserIsTypingMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendGroupUserIsTypingMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendGroupUserIsTypingMsg(paramCSendGroupUserIsTypingMsg);
        }
      });
    }
  }

  private static class CSendInternalMsgReply_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendInternalMsgReply.Receiver>
    implements CSendInternalMsgReply.Receiver
  {
    public void onCSendInternalMsgReply(final CSendInternalMsgReply paramCSendInternalMsgReply)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendInternalMsgReply.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendInternalMsgReply(paramCSendInternalMsgReply);
        }
      });
    }
  }

  private static class CSendMessageReplyAckMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendMessageReplyAckMsg.Receiver>
    implements CSendMessageReplyAckMsg.Receiver
  {
    public void onCSendMessageReplyAckMsg(final CSendMessageReplyAckMsg paramCSendMessageReplyAckMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendMessageReplyAckMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendMessageReplyAckMsg(paramCSendMessageReplyAckMsg);
        }
      });
    }
  }

  private static class CSendMessageReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendMessageReplyMsg.Receiver>
    implements CSendMessageReplyMsg.Receiver
  {
    public void onCSendMessageReplyMsg(final CSendMessageReplyMsg paramCSendMessageReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendMessageReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendMessageReplyMsg(paramCSendMessageReplyMsg);
        }
      });
    }
  }

  private static class CSendUserIsTypingMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSendUserIsTypingMsg.Receiver>
    implements CSendUserIsTypingMsg.Receiver
  {
    public void onCSendUserIsTypingMsg(final CSendUserIsTypingMsg paramCSendUserIsTypingMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSendUserIsTypingMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSendUserIsTypingMsg(paramCSendUserIsTypingMsg);
        }
      });
    }
  }

  private static class CShareAddressBook2ReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CShareAddressBook2ReplyMsg.Receiver>
    implements CShareAddressBook2ReplyMsg.Receiver
  {
    public void onCShareAddressBook2ReplyMsg(final CShareAddressBook2ReplyMsg paramCShareAddressBook2ReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CShareAddressBook2ReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCShareAddressBook2ReplyMsg(paramCShareAddressBook2ReplyMsg);
        }
      });
    }
  }

  private static class CSyncActionOnPGMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSyncActionOnPGMsg.Receiver>
    implements CSyncActionOnPGMsg.Receiver
  {
    public void onCSyncActionOnPGMsg(final CSyncActionOnPGMsg paramCSyncActionOnPGMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSyncActionOnPGMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSyncActionOnPGMsg(paramCSyncActionOnPGMsg);
        }
      });
    }
  }

  private static class CSyncConversationReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSyncConversationReplyMsg.Receiver>
    implements CSyncConversationReplyMsg.Receiver
  {
    public void onCSyncConversationReplyMsg(final CSyncConversationReplyMsg paramCSyncConversationReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSyncConversationReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSyncConversationReplyMsg(paramCSyncConversationReplyMsg);
        }
      });
    }
  }

  private static class CSyncDataFromMyOtherDeviceMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSyncDataFromMyOtherDeviceMsg.Receiver>
    implements CSyncDataFromMyOtherDeviceMsg.Receiver
  {
    public void onCSyncDataFromMyOtherDeviceMsg(final CSyncDataFromMyOtherDeviceMsg paramCSyncDataFromMyOtherDeviceMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSyncDataFromMyOtherDeviceMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSyncDataFromMyOtherDeviceMsg(paramCSyncDataFromMyOtherDeviceMsg);
        }
      });
    }
  }

  private static class CSyncDataToMyDevicesReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSyncDataToMyDevicesReplyMsg.Receiver>
    implements CSyncDataToMyDevicesReplyMsg.Receiver
  {
    public void onCSyncDataToMyDevicesReplyMsg(final CSyncDataToMyDevicesReplyMsg paramCSyncDataToMyDevicesReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSyncDataToMyDevicesReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSyncDataToMyDevicesReplyMsg(paramCSyncDataToMyDevicesReplyMsg);
        }
      });
    }
  }

  private static class CSyncGroupReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSyncGroupReplyMsg.Receiver>
    implements CSyncGroupReplyMsg.Receiver
  {
    public void onCSyncGroupReplyMsg(final CSyncGroupReplyMsg paramCSyncGroupReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSyncGroupReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSyncGroupReplyMsg(paramCSyncGroupReplyMsg);
        }
      });
    }
  }

  private static class CSyncMessagesReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CSyncMessagesReplyMsg.Receiver>
    implements CSyncMessagesReplyMsg.Receiver
  {
    public void onCSyncMessagesReplyMsg(final CSyncMessagesReplyMsg paramCSyncMessagesReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CSyncMessagesReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCSyncMessagesReplyMsg(paramCSyncMessagesReplyMsg);
        }
      });
    }
  }

  private static class CUnlinkViberIdReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUnlinkViberIdReplyMsg.Receiver>
    implements CUnlinkViberIdReplyMsg.Receiver
  {
    public void onCUnlinkViberIdReplyMsg(final CUnlinkViberIdReplyMsg paramCUnlinkViberIdReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUnlinkViberIdReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUnlinkViberIdReplyMsg(paramCUnlinkViberIdReplyMsg);
        }
      });
    }
  }

  private static class CUnregisterAppReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUnregisterAppReplyMsg.Receiver>
    implements CUnregisterAppReplyMsg.Receiver
  {
    public void onCUnregisterAppReplyMsg(final CUnregisterAppReplyMsg paramCUnregisterAppReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUnregisterAppReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUnregisterAppReplyMsg(paramCUnregisterAppReplyMsg);
        }
      });
    }
  }

  private static class CUpdateBlockListReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateBlockListReplyMsg.Receiver>
    implements CUpdateBlockListReplyMsg.Receiver
  {
    public void onCUpdateBlockListReplyMsg(final CUpdateBlockListReplyMsg paramCUpdateBlockListReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateBlockListReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateBlockListReplyMsg(paramCUpdateBlockListReplyMsg);
        }
      });
    }
  }

  private static class CUpdateCommunityPrivilegesReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateCommunityPrivilegesReplyMsg.Receiver>
    implements CUpdateCommunityPrivilegesReplyMsg.Receiver
  {
    public void onCUpdateCommunityPrivilegesReplyMsg(final CUpdateCommunityPrivilegesReplyMsg paramCUpdateCommunityPrivilegesReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateCommunityPrivilegesReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateCommunityPrivilegesReplyMsg(paramCUpdateCommunityPrivilegesReplyMsg);
        }
      });
    }
  }

  private static class CUpdateCommunitySettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateCommunitySettingsReplyMsg.Receiver>
    implements CUpdateCommunitySettingsReplyMsg.Receiver
  {
    public void onCUpdateCommunitySettingsReplyMsg(final CUpdateCommunitySettingsReplyMsg paramCUpdateCommunitySettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateCommunitySettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateCommunitySettingsReplyMsg(paramCUpdateCommunitySettingsReplyMsg);
        }
      });
    }
  }

  private static class CUpdateLanguageReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateLanguageReplyMsg.Receiver>
    implements CUpdateLanguageReplyMsg.Receiver
  {
    public void onCUpdateLanguageReplyMsg(final CUpdateLanguageReplyMsg paramCUpdateLanguageReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateLanguageReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateLanguageReplyMsg(paramCUpdateLanguageReplyMsg);
        }
      });
    }
  }

  private static class CUpdateMyCommunitySettingsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateMyCommunitySettingsReplyMsg.Receiver>
    implements CUpdateMyCommunitySettingsReplyMsg.Receiver
  {
    public void onCUpdateMyCommunitySettingsReplyMsg(final CUpdateMyCommunitySettingsReplyMsg paramCUpdateMyCommunitySettingsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateMyCommunitySettingsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateMyCommunitySettingsReplyMsg(paramCUpdateMyCommunitySettingsReplyMsg);
        }
      });
    }
  }

  private static class CUpdatePersonalDetailsReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdatePersonalDetailsReplyMsg.Receiver>
    implements CUpdatePersonalDetailsReplyMsg.Receiver
  {
    public void onCUpdatePersonalDetailsReplyMsg(final CUpdatePersonalDetailsReplyMsg paramCUpdatePersonalDetailsReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdatePersonalDetailsReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdatePersonalDetailsReplyMsg(paramCUpdatePersonalDetailsReplyMsg);
        }
      });
    }
  }

  private static class CUpdateSelfUserDetailsMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateSelfUserDetailsMsg.Receiver>
    implements CUpdateSelfUserDetailsMsg.Receiver
  {
    public void onCUpdateSelfUserDetailsMsg(final CUpdateSelfUserDetailsMsg paramCUpdateSelfUserDetailsMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateSelfUserDetailsMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateSelfUserDetailsMsg(paramCUpdateSelfUserDetailsMsg);
        }
      });
    }
  }

  private static class CUpdateUnsavedContactDetailsMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateUnsavedContactDetailsMsg.Receiver>
    implements CUpdateUnsavedContactDetailsMsg.Receiver
  {
    public void onCUpdateUnsavedContactDetailsMsg(final CUpdateUnsavedContactDetailsMsg paramCUpdateUnsavedContactDetailsMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateUnsavedContactDetailsMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateUnsavedContactDetailsMsg(paramCUpdateUnsavedContactDetailsMsg);
        }
      });
    }
  }

  private static class CUpdateUserDateOfBirthReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateUserDateOfBirthReplyMsg.Receiver>
    implements CUpdateUserDateOfBirthReplyMsg.Receiver
  {
    public void onCUpdateUserDateOfBirthReplyMsg(final CUpdateUserDateOfBirthReplyMsg paramCUpdateUserDateOfBirthReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateUserDateOfBirthReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateUserDateOfBirthReplyMsg(paramCUpdateUserDateOfBirthReplyMsg);
        }
      });
    }
  }

  private static class CUpdateUserNameReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateUserNameReplyMsg.Receiver>
    implements CUpdateUserNameReplyMsg.Receiver
  {
    public void onCUpdateUserNameReplyMsg(final CUpdateUserNameReplyMsg paramCUpdateUserNameReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateUserNameReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateUserNameReplyMsg(paramCUpdateUserNameReplyMsg);
        }
      });
    }
  }

  private static class CUpdateUserPhotoReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CUpdateUserPhotoReplyMsg.Receiver>
    implements CUpdateUserPhotoReplyMsg.Receiver
  {
    public void onCUpdateUserPhotoReplyMsg(final CUpdateUserPhotoReplyMsg paramCUpdateUserPhotoReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CUpdateUserPhotoReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCUpdateUserPhotoReplyMsg(paramCUpdateUserPhotoReplyMsg);
        }
      });
    }
  }

  private static class CValidateGroupUriReplyMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CValidateGroupUriReplyMsg.Receiver>
    implements CValidateGroupUriReplyMsg.Receiver
  {
    public void onCValidateGroupUriReplyMsg(final CValidateGroupUriReplyMsg paramCValidateGroupUriReplyMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CValidateGroupUriReplyMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCValidateGroupUriReplyMsg(paramCValidateGroupUriReplyMsg);
        }
      });
    }
  }

  private static class CViberIdChangedMsg_dispatcher extends Im2DispatcherBase.DispatcherBase<CViberIdChangedMsg.Receiver>
    implements CViberIdChangedMsg.Receiver
  {
    public void onCViberIdChangedMsg(final CViberIdChangedMsg paramCViberIdChangedMsg)
    {
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void execute(CViberIdChangedMsg.Receiver paramAnonymousReceiver)
        {
          paramAnonymousReceiver.onCViberIdChangedMsg(paramCViberIdChangedMsg);
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Im2Dispatcher
 * JD-Core Version:    0.6.2
 */