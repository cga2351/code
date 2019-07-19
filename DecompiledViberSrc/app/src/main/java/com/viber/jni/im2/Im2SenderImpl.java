package com.viber.jni.im2;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class Im2SenderImpl
  implements Im2Sender
{
  private static final Logger L = ViberEnv.getLogger();
  private Im2JniSender mSender;

  public Im2SenderImpl(Im2JniSender paramIm2JniSender)
  {
    this.mSender = paramIm2JniSender;
  }

  private void handleException(Exception paramException)
  {
    L.a(paramException, paramException.getMessage());
  }

  private void sendMessage(MessageWrite paramMessageWrite)
  {
    if (!paramMessageWrite.isValid())
      throw new IllegalArgumentException("Invalid IM2 message! see native VoiceLib HandleSendIM2Message logs");
    if (!this.mSender.handleSendIM2Message(paramMessageWrite))
      L.e("Failed sending IM2 message! see native VoiceLib HandleSendIM2Message logs", new Object[0]);
  }

  public void handleCAcceptGroupInviteMsg(CAcceptGroupInviteMsg paramCAcceptGroupInviteMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CAcceptGroupInviteMsg(paramCAcceptGroupInviteMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCActOnViberIdPasswordMsg(CActOnViberIdPasswordMsg paramCActOnViberIdPasswordMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CActOnViberIdPasswordMsg(paramCActOnViberIdPasswordMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCAddressBookDeltaUpdateAckMsg(CAddressBookDeltaUpdateAckMsg paramCAddressBookDeltaUpdateAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CAddressBookDeltaUpdateAckMsg(paramCAddressBookDeltaUpdateAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCAddressBookForSecondaryAckMsg(CAddressBookForSecondaryAckMsg paramCAddressBookForSecondaryAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CAddressBookForSecondaryAckMsg(paramCAddressBookForSecondaryAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCAuthenticateAppMsg(CAuthenticateAppMsg paramCAuthenticateAppMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CAuthenticateAppMsg(paramCAuthenticateAppMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCBillingTokenByMidMsg(CBillingTokenByMidMsg paramCBillingTokenByMidMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CBillingTokenByMidMsg(paramCBillingTokenByMidMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCBillingTokenMsg(CBillingTokenMsg paramCBillingTokenMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CBillingTokenMsg(paramCBillingTokenMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCBlockAppMsg(CBlockAppMsg paramCBlockAppMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CBlockAppMsg(paramCBlockAppMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCBlockGroupInviteMsg(CBlockGroupInviteMsg paramCBlockGroupInviteMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CBlockGroupInviteMsg(paramCBlockGroupInviteMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCChangeConversationSettingsMsg(CChangeConversationSettingsMsg paramCChangeConversationSettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CChangeConversationSettingsMsg(paramCChangeConversationSettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCChangeGroupAttributesMsg(CChangeGroupAttributesMsg paramCChangeGroupAttributesMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CChangeGroupAttributesMsg(paramCChangeGroupAttributesMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCChangeGroupSettingsMsg(CChangeGroupSettingsMsg paramCChangeGroupSettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CChangeGroupSettingsMsg(paramCChangeGroupSettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCChangeLastOnlineSettingsMsg(CChangeLastOnlineSettingsMsg paramCChangeLastOnlineSettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CChangeLastOnlineSettingsMsg(paramCChangeLastOnlineSettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCChangeReadNotificationsSettingsMsg(CChangeReadNotificationsSettingsMsg paramCChangeReadNotificationsSettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CChangeReadNotificationsSettingsMsg(paramCChangeReadNotificationsSettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCChangeSettingsMsg(CChangeSettingsMsg paramCChangeSettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CChangeSettingsMsg(paramCChangeSettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCChangeUserActivitySettingsMsg(CChangeUserActivitySettingsMsg paramCChangeUserActivitySettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CChangeUserActivitySettingsMsg(paramCChangeUserActivitySettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCChangeViberIdEmailMsg(CChangeViberIdEmailMsg paramCChangeViberIdEmailMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CChangeViberIdEmailMsg(paramCChangeViberIdEmailMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCCheckAllowsM2MChatMsg(CCheckAllowsM2MChatMsg paramCCheckAllowsM2MChatMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CCheckAllowsM2MChatMsg(paramCCheckAllowsM2MChatMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCCheckEmailStatusMsg(CCheckEmailStatusMsg paramCCheckEmailStatusMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CCheckEmailStatusMsg(paramCCheckEmailStatusMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCCheckGroup2InviteMsg(CCheckGroup2InviteMsg paramCCheckGroup2InviteMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CCheckGroup2InviteMsg(paramCCheckGroup2InviteMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCConfirmOrRevokeEmailMsg(CConfirmOrRevokeEmailMsg paramCConfirmOrRevokeEmailMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CConfirmOrRevokeEmailMsg(paramCConfirmOrRevokeEmailMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCContactSavedInConversationNotificationMsg(CContactSavedInConversationNotificationMsg paramCContactSavedInConversationNotificationMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CContactSavedInConversationNotificationMsg(paramCContactSavedInConversationNotificationMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCConversationSynchedAckMsg(CConversationSynchedAckMsg paramCConversationSynchedAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CConversationSynchedAckMsg(paramCConversationSynchedAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCCreateConferenceCallMsg(CCreateConferenceCallMsg paramCCreateConferenceCallMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CCreateConferenceCallMsg(paramCCreateConferenceCallMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCCreateGroup2InviteMsg(CCreateGroup2InviteMsg paramCCreateGroup2InviteMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CCreateGroup2InviteMsg(paramCCreateGroup2InviteMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCCreateGroupInviteMsg(CCreateGroupInviteMsg paramCCreateGroupInviteMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CCreateGroupInviteMsg(paramCCreateGroupInviteMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCCreateGroupMsg(CCreateGroupMsg paramCCreateGroupMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CCreateGroupMsg(paramCCreateGroupMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCDeleteAllUserMessagesMsg(CDeleteAllUserMessagesMsg paramCDeleteAllUserMessagesMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CDeleteAllUserMessagesMsg(paramCDeleteAllUserMessagesMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCDeleteGlobalMessageMsg(CDeleteGlobalMessageMsg paramCDeleteGlobalMessageMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CDeleteGlobalMessageMsg(paramCDeleteGlobalMessageMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCDeleteMessageMsg(CDeleteMessageMsg paramCDeleteMessageMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CDeleteMessageMsg(paramCDeleteMessageMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCDeletedMessageAckMsg(CDeletedMessageAckMsg paramCDeletedMessageAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CDeletedMessageAckMsg(paramCDeletedMessageAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGdprCommandMsg(CGdprCommandMsg paramCGdprCommandMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGdprCommandMsg(paramCGdprCommandMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetAdInfoMsg(CGetAdInfoMsg paramCGetAdInfoMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetAdInfoMsg(paramCGetAdInfoMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetCommonCommunitiesMsg(CGetCommonCommunitiesMsg paramCGetCommonCommunitiesMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetCommonCommunitiesMsg(paramCGetCommonCommunitiesMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetDownloadDetailsMsg(CGetDownloadDetailsMsg paramCGetDownloadDetailsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetDownloadDetailsMsg(paramCGetDownloadDetailsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetEncryptedMIDsMsg(CGetEncryptedMIDsMsg paramCGetEncryptedMIDsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetEncryptedMIDsMsg(paramCGetEncryptedMIDsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetGroup2AccessTokenMsg(CGetGroup2AccessTokenMsg paramCGetGroup2AccessTokenMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetGroup2AccessTokenMsg(paramCGetGroup2AccessTokenMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetGroupInfoMsg(CGetGroupInfoMsg paramCGetGroupInfoMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetGroupInfoMsg(paramCGetGroupInfoMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetGroupMessageStatusMsg(CGetGroupMessageStatusMsg paramCGetGroupMessageStatusMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetGroupMessageStatusMsg(paramCGetGroupMessageStatusMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetInviteLinksMsg(CGetInviteLinksMsg paramCGetInviteLinksMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetInviteLinksMsg(paramCGetInviteLinksMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetLastOnlineMsg(CGetLastOnlineMsg paramCGetLastOnlineMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetLastOnlineMsg(paramCGetLastOnlineMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetMyCommunitySettingsMsg(CGetMyCommunitySettingsMsg paramCGetMyCommunitySettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetMyCommunitySettingsMsg(paramCGetMyCommunitySettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetPersonalDetailsMsg(CGetPersonalDetailsMsg paramCGetPersonalDetailsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetPersonalDetailsMsg(paramCGetPersonalDetailsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetPublicAccountInfoMsg(CGetPublicAccountInfoMsg paramCGetPublicAccountInfoMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetPublicAccountInfoMsg(paramCGetPublicAccountInfoMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetPublicGroupInfoMsg(CGetPublicGroupInfoMsg paramCGetPublicGroupInfoMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetPublicGroupInfoMsg(paramCGetPublicGroupInfoMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetUserActivityMsg(CGetUserActivityMsg paramCGetUserActivityMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetUserActivityMsg(paramCGetUserActivityMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetUserAppsMsg(CGetUserAppsMsg paramCGetUserAppsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetUserAppsMsg(paramCGetUserAppsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetUserDateOfBirthMsg(CGetUserDateOfBirthMsg paramCGetUserDateOfBirthMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetUserDateOfBirthMsg(paramCGetUserDateOfBirthMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetUsersDetailsV2Msg(CGetUsersDetailsV2Msg paramCGetUsersDetailsV2Msg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetUsersDetailsV2Msg(paramCGetUsersDetailsV2Msg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGetViberIdMsg(CGetViberIdMsg paramCGetViberIdMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGetViberIdMsg(paramCGetViberIdMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupAddMemberMsg(CGroupAddMemberMsg paramCGroupAddMemberMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupAddMemberMsg(paramCGroupAddMemberMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupAddMembersMsg(CGroupAddMembersMsg paramCGroupAddMembersMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupAddMembersMsg(paramCGroupAddMembersMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupAddWatchersMsg(CGroupAddWatchersMsg paramCGroupAddWatchersMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupAddWatchersMsg(paramCGroupAddWatchersMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupAssignRoleMsg(CGroupAssignRoleMsg paramCGroupAssignRoleMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupAssignRoleMsg(paramCGroupAssignRoleMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupBanUserMsg(CGroupBanUserMsg paramCGroupBanUserMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupBanUserMsg(paramCGroupBanUserMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupChangedAckMsg(CGroupChangedAckMsg paramCGroupChangedAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupChangedAckMsg(paramCGroupChangedAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupLeaveMsg(CGroupLeaveMsg paramCGroupLeaveMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupLeaveMsg(paramCGroupLeaveMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupMessageLikeAck(CGroupMessageLikeAck paramCGroupMessageLikeAck)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupMessageLikeAck(paramCGroupMessageLikeAck));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupRemoveMembersMsg(CGroupRemoveMembersMsg paramCGroupRemoveMembersMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupRemoveMembersMsg(paramCGroupRemoveMembersMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupSynchedAckMsg(CGroupSynchedAckMsg paramCGroupSynchedAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupSynchedAckMsg(paramCGroupSynchedAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCGroupUserIsTypingMsg(CGroupUserIsTypingMsg paramCGroupUserIsTypingMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CGroupUserIsTypingMsg(paramCGroupUserIsTypingMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCInviteToConferenceMsg(CInviteToConferenceMsg paramCInviteToConferenceMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CInviteToConferenceMsg(paramCInviteToConferenceMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCIsOnlineMsg(CIsOnlineMsg paramCIsOnlineMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CIsOnlineMsg(paramCIsOnlineMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCIsRegisteredNumberMsg(CIsRegisteredNumberMsg paramCIsRegisteredNumberMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CIsRegisteredNumberMsg(paramCIsRegisteredNumberMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCJoinConfCallMsg(CJoinConfCallMsg paramCJoinConfCallMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CJoinConfCallMsg(paramCJoinConfCallMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCLateErrorOnReceivedMessageMsg(CLateErrorOnReceivedMessageMsg paramCLateErrorOnReceivedMessageMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CLateErrorOnReceivedMessageMsg(paramCLateErrorOnReceivedMessageMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCLikeGroupMessage(CLikeGroupMessage paramCLikeGroupMessage)
  {
    try
    {
      sendMessage(Im2Bridge.write_CLikeGroupMessage(paramCLikeGroupMessage));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCMessageDeliveredAckMsg(CMessageDeliveredAckMsg paramCMessageDeliveredAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CMessageDeliveredAckMsg(paramCMessageDeliveredAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCMessageReceivedAckMsg(CMessageReceivedAckMsg paramCMessageReceivedAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CMessageReceivedAckMsg(paramCMessageReceivedAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCMessageReceivedReplyableAckMsg(CMessageReceivedReplyableAckMsg paramCMessageReceivedReplyableAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CMessageReceivedReplyableAckMsg(paramCMessageReceivedReplyableAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCMessagesSynchedAckMsg(CMessagesSynchedAckMsg paramCMessagesSynchedAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CMessagesSynchedAckMsg(paramCMessagesSynchedAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCOnClickMsg(COnClickMsg paramCOnClickMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_COnClickMsg(paramCOnClickMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCPublicAccountSubscriberUpdateMsg(CPublicAccountSubscriberUpdateMsg paramCPublicAccountSubscriberUpdateMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CPublicAccountSubscriberUpdateMsg(paramCPublicAccountSubscriberUpdateMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCQueryDestOperationSupportMsg(CQueryDestOperationSupportMsg paramCQueryDestOperationSupportMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CQueryDestOperationSupportMsg(paramCQueryDestOperationSupportMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRecoverGroupChatsMsg(CRecoverGroupChatsMsg paramCRecoverGroupChatsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRecoverGroupChatsMsg(paramCRecoverGroupChatsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRecoverGroupsMsg(CRecoverGroupsMsg paramCRecoverGroupsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRecoverGroupsMsg(paramCRecoverGroupsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRecoverPublicAccountsMsg(CRecoverPublicAccountsMsg paramCRecoverPublicAccountsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRecoverPublicAccountsMsg(paramCRecoverPublicAccountsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRecvInternalMsgAck(CRecvInternalMsgAck paramCRecvInternalMsgAck)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRecvInternalMsgAck(paramCRecvInternalMsgAck));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRefreshPublicAccountTokenMsg(CRefreshPublicAccountTokenMsg paramCRefreshPublicAccountTokenMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRefreshPublicAccountTokenMsg(paramCRefreshPublicAccountTokenMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRegisterViberIdMsg(CRegisterViberIdMsg paramCRegisterViberIdMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRegisterViberIdMsg(paramCRegisterViberIdMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRegisteredNumbersAckMsg(CRegisteredNumbersAckMsg paramCRegisteredNumbersAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRegisteredNumbersAckMsg(paramCRegisteredNumbersAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRevokeGroup2InviteMsg(CRevokeGroup2InviteMsg paramCRevokeGroup2InviteMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRevokeGroup2InviteMsg(paramCRevokeGroup2InviteMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCRevokeGroupInviteMsg(CRevokeGroupInviteMsg paramCRevokeGroupInviteMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CRevokeGroupInviteMsg(paramCRevokeGroupInviteMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSecretChatReceivedEventAckMsg(CSecretChatReceivedEventAckMsg paramCSecretChatReceivedEventAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSecretChatReceivedEventAckMsg(paramCSecretChatReceivedEventAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSecretChatSendEventMsg(CSecretChatSendEventMsg paramCSecretChatSendEventMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSecretChatSendEventMsg(paramCSecretChatSendEventMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendActionOnPGMsg(CSendActionOnPGMsg paramCSendActionOnPGMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendActionOnPGMsg(paramCSendActionOnPGMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendActionToBotMsg(CSendActionToBotMsg paramCSendActionToBotMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendActionToBotMsg(paramCSendActionToBotMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendBackAckBase(CSendBackAckBase paramCSendBackAckBase)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendBackAckBase(paramCSendBackAckBase));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendBannerToClientAckMsg(CSendBannerToClientAckMsg paramCSendBannerToClientAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendBannerToClientAckMsg(paramCSendBannerToClientAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendConversationStatusMsg(CSendConversationStatusMsg paramCSendConversationStatusMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendConversationStatusMsg(paramCSendConversationStatusMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendGroupMsg(CSendGroupMsg paramCSendGroupMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendGroupMsg(paramCSendGroupMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendInternalMsg(CSendInternalMsg paramCSendInternalMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendInternalMsg(paramCSendInternalMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendMessageMsg(CSendMessageMsg paramCSendMessageMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendMessageMsg(paramCSendMessageMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSendPublicGroupInviteMsg(CSendPublicGroupInviteMsg paramCSendPublicGroupInviteMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSendPublicGroupInviteMsg(paramCSendPublicGroupInviteMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCShareAddressBook2Msg(CShareAddressBook2Msg paramCShareAddressBook2Msg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CShareAddressBook2Msg(paramCShareAddressBook2Msg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCShareDeltaAddressBookMsg(CShareDeltaAddressBookMsg paramCShareDeltaAddressBookMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CShareDeltaAddressBookMsg(paramCShareDeltaAddressBookMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSyncActionOnPGAckMsg(CSyncActionOnPGAckMsg paramCSyncActionOnPGAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSyncActionOnPGAckMsg(paramCSyncActionOnPGAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSyncConversationMsg(CSyncConversationMsg paramCSyncConversationMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSyncConversationMsg(paramCSyncConversationMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSyncDataFromMyOtherDeviceAckMsg(CSyncDataFromMyOtherDeviceAckMsg paramCSyncDataFromMyOtherDeviceAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSyncDataFromMyOtherDeviceAckMsg(paramCSyncDataFromMyOtherDeviceAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSyncDataToMyDevicesMsg(CSyncDataToMyDevicesMsg paramCSyncDataToMyDevicesMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSyncDataToMyDevicesMsg(paramCSyncDataToMyDevicesMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSyncGroupMsg(CSyncGroupMsg paramCSyncGroupMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSyncGroupMsg(paramCSyncGroupMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCSyncMessagesMsg(CSyncMessagesMsg paramCSyncMessagesMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CSyncMessagesMsg(paramCSyncMessagesMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUnlinkViberIdMsg(CUnlinkViberIdMsg paramCUnlinkViberIdMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUnlinkViberIdMsg(paramCUnlinkViberIdMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUnregisterAppMsg(CUnregisterAppMsg paramCUnregisterAppMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUnregisterAppMsg(paramCUnregisterAppMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateBlockListMsg(CUpdateBlockListMsg paramCUpdateBlockListMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateBlockListMsg(paramCUpdateBlockListMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateCommunityPrivilegesMsg(CUpdateCommunityPrivilegesMsg paramCUpdateCommunityPrivilegesMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateCommunityPrivilegesMsg(paramCUpdateCommunityPrivilegesMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateCommunitySettingsMsg(CUpdateCommunitySettingsMsg paramCUpdateCommunitySettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateCommunitySettingsMsg(paramCUpdateCommunitySettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateLanguageMsg(CUpdateLanguageMsg paramCUpdateLanguageMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateLanguageMsg(paramCUpdateLanguageMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateMyCommunitySettingsMsg(CUpdateMyCommunitySettingsMsg paramCUpdateMyCommunitySettingsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateMyCommunitySettingsMsg(paramCUpdateMyCommunitySettingsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdatePersonalDetailsMsg(CUpdatePersonalDetailsMsg paramCUpdatePersonalDetailsMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdatePersonalDetailsMsg(paramCUpdatePersonalDetailsMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateSelfUserDetailsAckMsg(CUpdateSelfUserDetailsAckMsg paramCUpdateSelfUserDetailsAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateSelfUserDetailsAckMsg(paramCUpdateSelfUserDetailsAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateUnsavedContactDetailsAckMsg(CUpdateUnsavedContactDetailsAckMsg paramCUpdateUnsavedContactDetailsAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateUnsavedContactDetailsAckMsg(paramCUpdateUnsavedContactDetailsAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateUserDateOfBirthMsg(CUpdateUserDateOfBirthMsg paramCUpdateUserDateOfBirthMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateUserDateOfBirthMsg(paramCUpdateUserDateOfBirthMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateUserNameMsg(CUpdateUserNameMsg paramCUpdateUserNameMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateUserNameMsg(paramCUpdateUserNameMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUpdateUserPhotoMsg(CUpdateUserPhotoMsg paramCUpdateUserPhotoMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUpdateUserPhotoMsg(paramCUpdateUserPhotoMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCUserIsTypingMsg(CUserIsTypingMsg paramCUserIsTypingMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CUserIsTypingMsg(paramCUserIsTypingMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCValidateGroupUriMsg(CValidateGroupUriMsg paramCValidateGroupUriMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CValidateGroupUriMsg(paramCValidateGroupUriMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }

  public void handleCWebNotificationAckMsg(CWebNotificationAckMsg paramCWebNotificationAckMsg)
  {
    try
    {
      sendMessage(Im2Bridge.write_CWebNotificationAckMsg(paramCWebNotificationAckMsg));
      return;
    }
    catch (Exception localException)
    {
      handleException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Im2SenderImpl
 * JD-Core Version:    0.6.2
 */