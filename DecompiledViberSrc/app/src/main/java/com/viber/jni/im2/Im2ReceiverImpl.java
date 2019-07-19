package com.viber.jni.im2;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class Im2ReceiverImpl
  implements Im2JniReceiver
{
  private static final Logger L = ViberEnv.getLogger();
  private Im2Receiver mDelegate;

  public Im2ReceiverImpl(Im2Receiver paramIm2Receiver)
  {
    this.mDelegate = paramIm2Receiver;
  }

  private void handleException(Exception paramException)
  {
    L.b(paramException, "Exception when receiving message", new Object[0]);
  }

  private void processMessage(long paramLong)
  {
    MessageRead localMessageRead = new MessageRead(paramLong, false);
    int i = localMessageRead.getMessageId();
    switch (i)
    {
    default:
      throw new IllegalArgumentException("Unexpected message id: " + i);
    case 490:
      this.mDelegate.onCAcceptGroupInviteReplyMsg(Im2Bridge.read_CAcceptGroupInviteReplyMsg(localMessageRead));
      return;
    case 508:
      this.mDelegate.onCActOnViberIdPasswordReplyMsg(Im2Bridge.read_CActOnViberIdPasswordReplyMsg(localMessageRead));
      return;
    case 423:
      this.mDelegate.onCAddressBookDeltaUpdateV2Msg(Im2Bridge.read_CAddressBookDeltaUpdateV2Msg(localMessageRead));
      return;
    case 410:
      this.mDelegate.onCAddressBookForSecondaryV2Msg(Im2Bridge.read_CAddressBookForSecondaryV2Msg(localMessageRead));
      return;
    case 216:
      this.mDelegate.onCAuthenticateAppReplyMsg(Im2Bridge.read_CAuthenticateAppReplyMsg(localMessageRead));
      return;
    case 545:
      this.mDelegate.onCBillingTokenByMidReplyMsg(Im2Bridge.read_CBillingTokenByMidReplyMsg(localMessageRead));
      return;
    case 176:
      this.mDelegate.onCBillingTokenReplyMsg(Im2Bridge.read_CBillingTokenReplyMsg(localMessageRead));
      return;
    case 248:
      this.mDelegate.onCBlockAppReplyMsg(Im2Bridge.read_CBlockAppReplyMsg(localMessageRead));
      return;
    case 195:
      this.mDelegate.onCBlockGroupInviteReplyMsg(Im2Bridge.read_CBlockGroupInviteReplyMsg(localMessageRead));
      return;
    case 154:
      this.mDelegate.onCChangeConversationSettingsReplyMsg(Im2Bridge.read_CChangeConversationSettingsReplyMsg(localMessageRead));
      return;
    case 221:
      this.mDelegate.onCChangeGroupAttributesReplyMsg(Im2Bridge.read_CChangeGroupAttributesReplyMsg(localMessageRead));
      return;
    case 136:
      this.mDelegate.onCChangeGroupSettingsReplyMsg(Im2Bridge.read_CChangeGroupSettingsReplyMsg(localMessageRead));
      return;
    case 180:
      this.mDelegate.onCChangeLastOnlineSettingsReplyMsg(Im2Bridge.read_CChangeLastOnlineSettingsReplyMsg(localMessageRead));
      return;
    case 190:
      this.mDelegate.onCChangeReadNotificationsSettingsReplyMsg(Im2Bridge.read_CChangeReadNotificationsSettingsReplyMsg(localMessageRead));
      return;
    case 53:
      this.mDelegate.onCChangeSettingsReplyMsg(Im2Bridge.read_CChangeSettingsReplyMsg(localMessageRead));
      return;
    case 256:
      this.mDelegate.onCChangeUserActivitySettingsReplyMsg(Im2Bridge.read_CChangeUserActivitySettingsReplyMsg(localMessageRead));
      return;
    case 512:
      this.mDelegate.onCChangeViberIdEmailReplyMsg(Im2Bridge.read_CChangeViberIdEmailReplyMsg(localMessageRead));
      return;
    case 717:
      this.mDelegate.onCCheckAllowsM2MChatReplyMsg(Im2Bridge.read_CCheckAllowsM2MChatReplyMsg(localMessageRead));
      return;
    case 506:
      this.mDelegate.onCCheckEmailStatusReplyMsg(Im2Bridge.read_CCheckEmailStatusReplyMsg(localMessageRead));
      return;
    case 524:
      this.mDelegate.onCCheckGroup2InviteReplyMsg(Im2Bridge.read_CCheckGroup2InviteReplyMsg(localMessageRead));
      return;
    case 733:
      this.mDelegate.onCConfirmOrRevokeEmailReplyMsg(Im2Bridge.read_CConfirmOrRevokeEmailReplyMsg(localMessageRead));
      return;
    case 390:
      this.mDelegate.onCContactSavedInConversationNotificationReplyMsg(Im2Bridge.read_CContactSavedInConversationNotificationReplyMsg(localMessageRead));
      return;
    case 166:
      this.mDelegate.onCConversationSynchedMsg(Im2Bridge.read_CConversationSynchedMsg(localMessageRead));
      return;
    case 701:
      this.mDelegate.onCCreateConferenceCallReplyMsg(Im2Bridge.read_CCreateConferenceCallReplyMsg(localMessageRead));
      return;
    case 520:
      this.mDelegate.onCCreateGroup2InviteReplyMsg(Im2Bridge.read_CCreateGroup2InviteReplyMsg(localMessageRead));
      return;
    case 488:
      this.mDelegate.onCCreateGroupInviteReplyMsg(Im2Bridge.read_CCreateGroupInviteReplyMsg(localMessageRead));
      return;
    case 98:
      this.mDelegate.onCCreateGroupReplyMsg(Im2Bridge.read_CCreateGroupReplyMsg(localMessageRead));
      return;
    case 518:
      this.mDelegate.onCDeleteAllUserMessagesReplyMsg(Im2Bridge.read_CDeleteAllUserMessagesReplyMsg(localMessageRead));
      return;
    case 269:
      this.mDelegate.onCDeleteGlobalMessageReplyMsg(Im2Bridge.read_CDeleteGlobalMessageReplyMsg(localMessageRead));
      return;
    case 361:
      this.mDelegate.onCDeleteMessageReplyMsg(Im2Bridge.read_CDeleteMessageReplyMsg(localMessageRead));
      return;
    case 362:
      this.mDelegate.onCDeletedMessageMsg(Im2Bridge.read_CDeletedMessageMsg(localMessageRead));
      return;
    case 533:
      this.mDelegate.onCGdprCommandReplyMsg(Im2Bridge.read_CGdprCommandReplyMsg(localMessageRead));
      return;
    case 543:
      this.mDelegate.onCGetAdInfoReplyMsg(Im2Bridge.read_CGetAdInfoReplyMsg(localMessageRead));
      return;
    case 719:
      this.mDelegate.onCGetCommonCommunitiesReplyMsg(Im2Bridge.read_CGetCommonCommunitiesReplyMsg(localMessageRead));
      return;
    case 529:
      this.mDelegate.onCGetDownloadDetailsReplyMsg(Im2Bridge.read_CGetDownloadDetailsReplyMsg(localMessageRead));
      return;
    case 537:
      this.mDelegate.onCGetEncryptedMIDsReplyMsg(Im2Bridge.read_CGetEncryptedMIDsReplyMsg(localMessageRead));
      return;
    case 526:
      this.mDelegate.onCGetGroup2AccessTokenReplyMsg(Im2Bridge.read_CGetGroup2AccessTokenReplyMsg(localMessageRead));
      return;
    case 105:
      this.mDelegate.onCGetGroupInfoReplyMsg(Im2Bridge.read_CGetGroupInfoReplyMsg(localMessageRead));
      return;
    case 378:
      this.mDelegate.onCGetGroupMessageStatusReplyMsg(Im2Bridge.read_CGetGroupMessageStatusReplyMsg(localMessageRead));
      return;
    case 727:
      this.mDelegate.onCGetInviteLinksReplyMsg(Im2Bridge.read_CGetInviteLinksReplyMsg(localMessageRead));
      return;
    case 159:
      this.mDelegate.onCGetLastOnlineReplyMsg(Im2Bridge.read_CGetLastOnlineReplyMsg(localMessageRead));
      return;
    case 721:
      this.mDelegate.onCGetMyCommunitySettingsReplyMsg(Im2Bridge.read_CGetMyCommunitySettingsReplyMsg(localMessageRead));
      return;
    case 729:
      this.mDelegate.onCGetPersonalDetailsReplyMsg(Im2Bridge.read_CGetPersonalDetailsReplyMsg(localMessageRead));
      return;
    case 372:
      this.mDelegate.onCGetPersonalProfileReplyMsg(Im2Bridge.read_CGetPersonalProfileReplyMsg(localMessageRead));
      return;
    case 429:
      this.mDelegate.onCGetPublicAccountInfoReplyMsg(Im2Bridge.read_CGetPublicAccountInfoReplyMsg(localMessageRead));
      return;
    case 227:
      this.mDelegate.onCGetPublicGroupInfoReplyMsg(Im2Bridge.read_CGetPublicGroupInfoReplyMsg(localMessageRead));
      return;
    case 384:
      this.mDelegate.onCGetSecondaryDeviceDetailsReplyMsg(Im2Bridge.read_CGetSecondaryDeviceDetailsReplyMsg(localMessageRead));
      return;
    case 253:
      this.mDelegate.onCGetUserActivityReplyMsg(Im2Bridge.read_CGetUserActivityReplyMsg(localMessageRead));
      return;
    case 258:
      this.mDelegate.onCGetUserAppsReplyMsg(Im2Bridge.read_CGetUserAppsReplyMsg(localMessageRead));
      return;
    case 541:
      this.mDelegate.onCGetUserDateOfBirthReplyMsg(Im2Bridge.read_CGetUserDateOfBirthReplyMsg(localMessageRead));
      return;
    case 413:
      this.mDelegate.onCGetUsersDetailsV2ReplyMsg(Im2Bridge.read_CGetUsersDetailsV2ReplyMsg(localMessageRead));
      return;
    case 504:
      this.mDelegate.onCGetViberIdReplyMsg(Im2Bridge.read_CGetViberIdReplyMsg(localMessageRead));
      return;
    case 107:
      this.mDelegate.onCGroupAddMemberReplyMsg(Im2Bridge.read_CGroupAddMemberReplyMsg(localMessageRead));
      return;
    case 205:
      this.mDelegate.onCGroupAddMembersReplyMsg(Im2Bridge.read_CGroupAddMembersReplyMsg(localMessageRead));
      return;
    case 209:
      this.mDelegate.onCGroupAddWatchersReplyMsg(Im2Bridge.read_CGroupAddWatchersReplyMsg(localMessageRead));
      return;
    case 294:
      this.mDelegate.onCGroupAssignRoleReplyMsg(Im2Bridge.read_CGroupAssignRoleReplyMsg(localMessageRead));
      return;
    case 547:
      this.mDelegate.onCGroupBanUserReplyMsg(Im2Bridge.read_CGroupBanUserReplyMsg(localMessageRead));
      return;
    case 114:
      this.mDelegate.onCGroupChangedMsg(Im2Bridge.read_CGroupChangedMsg(localMessageRead));
      return;
    case 109:
      this.mDelegate.onCGroupLeaveReplyMsg(Im2Bridge.read_CGroupLeaveReplyMsg(localMessageRead));
      return;
    case 337:
      this.mDelegate.onCGroupMessageLike(Im2Bridge.read_CGroupMessageLike(localMessageRead));
      return;
    case 101:
      this.mDelegate.onCGroupMessageReceivedMsg(Im2Bridge.read_CGroupMessageReceivedMsg(localMessageRead));
      return;
    case 271:
      this.mDelegate.onCGroupRemoveMembersReplyMsg(Im2Bridge.read_CGroupRemoveMembersReplyMsg(localMessageRead));
      return;
    case 138:
      this.mDelegate.onCGroupSynchedMsg(Im2Bridge.read_CGroupSynchedMsg(localMessageRead));
      return;
    case 708:
      this.mDelegate.onCInviteToConferenceReplyMsg(Im2Bridge.read_CInviteToConferenceReplyMsg(localMessageRead));
      return;
    case 151:
      this.mDelegate.onCIsOnlineReplyMsg(Im2Bridge.read_CIsOnlineReplyMsg(localMessageRead));
      return;
    case 68:
      this.mDelegate.onCIsRegisteredNumberReplyMsg(Im2Bridge.read_CIsRegisteredNumberReplyMsg(localMessageRead));
      return;
    case 703:
      this.mDelegate.onCJoinConfCallReplyMsg(Im2Bridge.read_CJoinConfCallReplyMsg(localMessageRead));
      return;
    case 472:
      this.mDelegate.onCLateErrorOnReceivedMessageReplyMsg(Im2Bridge.read_CLateErrorOnReceivedMessageReplyMsg(localMessageRead));
      return;
    case 336:
      this.mDelegate.onCLikeGroupMessageReply(Im2Bridge.read_CLikeGroupMessageReply(localMessageRead));
      return;
    case 2:
      this.mDelegate.onCLoginReplyMsg(Im2Bridge.read_CLoginReplyMsg(localMessageRead));
      return;
    case 85:
      this.mDelegate.onCMessageDeliveredMsg(Im2Bridge.read_CMessageDeliveredMsg(localMessageRead));
      return;
    case 75:
      this.mDelegate.onCMessageReceivedMsg(Im2Bridge.read_CMessageReceivedMsg(localMessageRead));
      return;
    case 725:
      this.mDelegate.onCMessageReceivedReplyableAckReplyMsg(Im2Bridge.read_CMessageReceivedReplyableAckReplyMsg(localMessageRead));
      return;
    case 137:
      this.mDelegate.onCMessagesSynchedMsg(Im2Bridge.read_CMessagesSynchedMsg(localMessageRead));
      return;
    case 19:
      this.mDelegate.onCOnClickReplyMsg(Im2Bridge.read_COnClickReplyMsg(localMessageRead));
      return;
    case 223:
      this.mDelegate.onCPGChangeReceivedMsg(Im2Bridge.read_CPGChangeReceivedMsg(localMessageRead));
      return;
    case 222:
      this.mDelegate.onCPGMessageReceivedMsg(Im2Bridge.read_CPGMessageReceivedMsg(localMessageRead));
      return;
    case 431:
      this.mDelegate.onCPublicAccountSubscriberUpdateReplyMsg(Im2Bridge.read_CPublicAccountSubscriberUpdateReplyMsg(localMessageRead));
      return;
    case 374:
      this.mDelegate.onCQueryDestOperationSupportReplyMsg(Im2Bridge.read_CQueryDestOperationSupportReplyMsg(localMessageRead));
      return;
    case 450:
      this.mDelegate.onCRecoverGroupChatsReplyMsg(Im2Bridge.read_CRecoverGroupChatsReplyMsg(localMessageRead));
      return;
    case 185:
      this.mDelegate.onCRecoverGroupsReplyMsg(Im2Bridge.read_CRecoverGroupsReplyMsg(localMessageRead));
      return;
    case 452:
      this.mDelegate.onCRecoverPublicAccountsReplyMsg(Im2Bridge.read_CRecoverPublicAccountsReplyMsg(localMessageRead));
      return;
    case 711:
      this.mDelegate.onCRecvInternalMsg(Im2Bridge.read_CRecvInternalMsg(localMessageRead));
      return;
    case 433:
      this.mDelegate.onCRefreshPublicAccountTokenReplyMsg(Im2Bridge.read_CRefreshPublicAccountTokenReplyMsg(localMessageRead));
      return;
    case 502:
      this.mDelegate.onCRegisterViberIdReplyMsg(Im2Bridge.read_CRegisterViberIdReplyMsg(localMessageRead));
      return;
    case 411:
      this.mDelegate.onCRegisteredContactsMsg(Im2Bridge.read_CRegisteredContactsMsg(localMessageRead));
      return;
    case 522:
      this.mDelegate.onCRevokeGroup2InviteReplyMsg(Im2Bridge.read_CRevokeGroup2InviteReplyMsg(localMessageRead));
      return;
    case 494:
      this.mDelegate.onCRevokeGroupInviteReplyMsg(Im2Bridge.read_CRevokeGroupInviteReplyMsg(localMessageRead));
      return;
    case 480:
      this.mDelegate.onCSecretChatReceivedEventMsg(Im2Bridge.read_CSecretChatReceivedEventMsg(localMessageRead));
      return;
    case 479:
      this.mDelegate.onCSecretChatSendEventReplyMsg(Im2Bridge.read_CSecretChatSendEventReplyMsg(localMessageRead));
      return;
    case 722:
      this.mDelegate.onCSecureSecondaryRegistrationFailureMsg(Im2Bridge.read_CSecureSecondaryRegistrationFailureMsg(localMessageRead));
      return;
    case 212:
      this.mDelegate.onCSendActionOnPGReplyMsg(Im2Bridge.read_CSendActionOnPGReplyMsg(localMessageRead));
      return;
    case 516:
      this.mDelegate.onCSendActionToBotReplyMsg(Im2Bridge.read_CSendActionToBotReplyMsg(localMessageRead));
      return;
    case 369:
      this.mDelegate.onCSendBannerToClientMsg(Im2Bridge.read_CSendBannerToClientMsg(localMessageRead));
      return;
    case 435:
      this.mDelegate.onCSendConversationStatusReplyMsg(Im2Bridge.read_CSendConversationStatusReplyMsg(localMessageRead));
      return;
    case 102:
      this.mDelegate.onCSendGroupUserIsTypingMsg(Im2Bridge.read_CSendGroupUserIsTypingMsg(localMessageRead));
      return;
    case 710:
      this.mDelegate.onCSendInternalMsgReply(Im2Bridge.read_CSendInternalMsgReply(localMessageRead));
      return;
    case 254:
      this.mDelegate.onCSendMessageReplyAckMsg(Im2Bridge.read_CSendMessageReplyAckMsg(localMessageRead));
      return;
    case 74:
      this.mDelegate.onCSendMessageReplyMsg(Im2Bridge.read_CSendMessageReplyMsg(localMessageRead));
      return;
    case 43:
      this.mDelegate.onCSendUserIsTypingMsg(Im2Bridge.read_CSendUserIsTypingMsg(localMessageRead));
      return;
    case 279:
      this.mDelegate.onCShareAddressBook2ReplyMsg(Im2Bridge.read_CShareAddressBook2ReplyMsg(localMessageRead));
      return;
    case 213:
      this.mDelegate.onCSyncActionOnPGMsg(Im2Bridge.read_CSyncActionOnPGMsg(localMessageRead));
      return;
    case 164:
      this.mDelegate.onCSyncConversationReplyMsg(Im2Bridge.read_CSyncConversationReplyMsg(localMessageRead));
      return;
    case 485:
      this.mDelegate.onCSyncDataFromMyOtherDeviceMsg(Im2Bridge.read_CSyncDataFromMyOtherDeviceMsg(localMessageRead));
      return;
    case 484:
      this.mDelegate.onCSyncDataToMyDevicesReplyMsg(Im2Bridge.read_CSyncDataToMyDevicesReplyMsg(localMessageRead));
      return;
    case 130:
      this.mDelegate.onCSyncGroupReplyMsg(Im2Bridge.read_CSyncGroupReplyMsg(localMessageRead));
      return;
    case 144:
      this.mDelegate.onCSyncMessagesReplyMsg(Im2Bridge.read_CSyncMessagesReplyMsg(localMessageRead));
      return;
    case 510:
      this.mDelegate.onCUnlinkViberIdReplyMsg(Im2Bridge.read_CUnlinkViberIdReplyMsg(localMessageRead));
      return;
    case 225:
      this.mDelegate.onCUnregisterAppReplyMsg(Im2Bridge.read_CUnregisterAppReplyMsg(localMessageRead));
      return;
    case 219:
      this.mDelegate.onCUpdateBlockListReplyMsg(Im2Bridge.read_CUpdateBlockListReplyMsg(localMessageRead));
      return;
    case 535:
      this.mDelegate.onCUpdateCommunityPrivilegesReplyMsg(Im2Bridge.read_CUpdateCommunityPrivilegesReplyMsg(localMessageRead));
      return;
    case 531:
      this.mDelegate.onCUpdateCommunitySettingsReplyMsg(Im2Bridge.read_CUpdateCommunitySettingsReplyMsg(localMessageRead));
      return;
    case 240:
      this.mDelegate.onCUpdateLanguageReplyMsg(Im2Bridge.read_CUpdateLanguageReplyMsg(localMessageRead));
      return;
    case 715:
      this.mDelegate.onCUpdateMyCommunitySettingsReplyMsg(Im2Bridge.read_CUpdateMyCommunitySettingsReplyMsg(localMessageRead));
      return;
    case 731:
      this.mDelegate.onCUpdatePersonalDetailsReplyMsg(Im2Bridge.read_CUpdatePersonalDetailsReplyMsg(localMessageRead));
      return;
    case 161:
      this.mDelegate.onCUpdateSelfUserDetailsMsg(Im2Bridge.read_CUpdateSelfUserDetailsMsg(localMessageRead));
      return;
    case 265:
      this.mDelegate.onCUpdateUnsavedContactDetailsMsg(Im2Bridge.read_CUpdateUnsavedContactDetailsMsg(localMessageRead));
      return;
    case 539:
      this.mDelegate.onCUpdateUserDateOfBirthReplyMsg(Im2Bridge.read_CUpdateUserDateOfBirthReplyMsg(localMessageRead));
      return;
    case 122:
      this.mDelegate.onCUpdateUserNameReplyMsg(Im2Bridge.read_CUpdateUserNameReplyMsg(localMessageRead));
      return;
    case 118:
      this.mDelegate.onCUpdateUserPhotoReplyMsg(Im2Bridge.read_CUpdateUserPhotoReplyMsg(localMessageRead));
      return;
    case 207:
      this.mDelegate.onCValidateGroupUriReplyMsg(Im2Bridge.read_CValidateGroupUriReplyMsg(localMessageRead));
      return;
    case 513:
    }
    this.mDelegate.onCViberIdChangedMsg(Im2Bridge.read_CViberIdChangedMsg(localMessageRead));
  }

  public boolean onIM2MessageReceived(long paramLong)
  {
    try
    {
      processMessage(paramLong);
      return false;
    }
    catch (Exception localException)
    {
      while (true)
        handleException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Im2ReceiverImpl
 * JD-Core Version:    0.6.2
 */