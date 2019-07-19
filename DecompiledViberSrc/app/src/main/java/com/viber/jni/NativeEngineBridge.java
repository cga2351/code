package com.viber.jni;

import android.os.Bundle;
import com.viber.jni.cdr.Cdr;
import com.viber.jni.im2.MessageWrite;
import com.viber.jni.webrtc.IceCandidate;
import com.viber.jni.webrtc.ProcessedCallback;
import com.viber.jni.webrtc.SdpProcessedCallback;
import java.util.ArrayList;

public class NativeEngineBridge
  implements EngineBackend
{
  final Host host;
  final PhoneControllerHelper target;

  NativeEngineBridge(PhoneControllerHelper paramPhoneControllerHelper, Host paramHost)
  {
    this.host = paramHost;
    this.target = paramPhoneControllerHelper;
  }

  private void check()
  {
    this.host.ensureInitialized();
  }

  public void answerCreated(String paramString)
  {
    check();
    this.target.answerCreated(paramString);
  }

  public String canonizePhoneNumber(String paramString)
  {
    check();
    return this.target.canonizePhoneNumber(paramString);
  }

  public String canonizePhoneNumberForCountryCode(int paramInt, String paramString)
  {
    check();
    return this.target.canonizePhoneNumberForCountryCode(paramInt, paramString);
  }

  public void changePhoneNumberInfo(int paramInt, String paramString1, String paramString2)
  {
    check();
    this.target.changePhoneNumberInfo(paramInt, paramString1, paramString2);
  }

  public int changeUDID(byte[] paramArrayOfByte)
  {
    check();
    return this.target.changeUDID(paramArrayOfByte);
  }

  public void connect()
  {
    check();
    this.target.connect();
  }

  public int connectivityTest(IVoipServiceConnectivityTestCallback paramIVoipServiceConnectivityTestCallback)
  {
    check();
    return this.target.connectivityTest(paramIVoipServiceConnectivityTestCallback);
  }

  public void crashLibrary()
  {
    check();
    this.target.crashLibrary();
  }

  public boolean deleteAllSecurityInfo()
  {
    check();
    return this.target.deleteAllSecurityInfo();
  }

  public void disconnect()
  {
    check();
    this.target.disconnect();
  }

  public int done()
  {
    check();
    return this.target.done();
  }

  public String encodeCurrency(String paramString1, String paramString2)
  {
    check();
    return this.target.encodeCurrency(paramString1, paramString2);
  }

  public int generateSequence()
  {
    check();
    return this.target.generateSequence();
  }

  public int getBICC(String paramString)
  {
    check();
    return this.target.getBICC(paramString);
  }

  public String[] getBreachedPeersList()
  {
    check();
    return this.target.getBreachedPeersList();
  }

  public int getCountryCode(String paramString)
  {
    check();
    return this.target.getCountryCode(paramString);
  }

  public CountryNameInfo getCountryName(String paramString)
  {
    check();
    return this.target.getCountryName(paramString);
  }

  public int getDefaultProtocolVersion()
  {
    check();
    return this.target.getDefaultProtocolVersion();
  }

  public String getDownloadURL(String paramString1, String paramString2, String paramString3)
  {
    check();
    return this.target.getDownloadURL(paramString1, paramString2, paramString3);
  }

  public String getExternalAppPhone(int paramInt)
  {
    check();
    return this.target.getExternalAppPhone(paramInt);
  }

  public int getFileOwnerUid(String paramString)
  {
    return this.target.getFileOwnerUid(paramString);
  }

  public String getHashForReRegister(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    check();
    return this.target.getHashForReRegister(paramArrayOfByte1, paramArrayOfByte2);
  }

  public long getMyCID()
  {
    check();
    return this.target.getMyCID();
  }

  public long getMyVersion()
  {
    check();
    return this.target.getMyVersion();
  }

  public String getPGDownloadURL(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    check();
    return this.target.getPGDownloadURL(paramString1, paramString2, paramString3, paramInt);
  }

  public String getPhoneProvider(String paramString)
  {
    check();
    return this.target.getPhoneProvider(paramString);
  }

  public int getPhoneState()
  {
    check();
    return this.target.getPhoneState();
  }

  public long getPhoneType()
  {
    check();
    return this.target.getPhoneType();
  }

  public String getPhotoDownloadURL(String paramString1, String paramString2, int paramInt)
  {
    check();
    return this.target.getPhotoDownloadURL(paramString1, paramString2, paramInt);
  }

  public String getSecureKeyforQR()
  {
    check();
    return this.target.getSecureKeyforQR();
  }

  public String[] getTrustedPeersList()
  {
    check();
    return this.target.getTrustedPeersList();
  }

  public void handleAddToConferenceCall(String paramString)
  {
    check();
    this.target.handleAddToConferenceCall(paramString);
  }

  public void handleAnswer(boolean paramBoolean)
  {
    check();
    this.target.handleAnswer(paramBoolean);
  }

  public void handleAppModeChanged(int paramInt)
  {
    check();
    this.target.handleAppModeChanged(paramInt);
  }

  public boolean handleAuthenticateApp(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    check();
    return this.target.handleAuthenticateApp(paramInt1, paramString, paramInt2, paramInt3, paramBoolean);
  }

  public void handleBannerOrSplashAck(long paramLong, int paramInt)
  {
    check();
    this.target.handleBannerOrSplashAck(paramLong, paramInt);
  }

  public boolean handleBlockApp(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    check();
    return this.target.handleBlockApp(paramInt1, paramBoolean, paramInt2, paramInt3);
  }

  public boolean handleBlockGroupInvite(long paramLong, boolean paramBoolean, int paramInt)
  {
    check();
    return this.target.handleBlockGroupInvite(paramLong, paramBoolean, paramInt);
  }

  public void handleBlockListByReason(BlockListInfo[] paramArrayOfBlockListInfo, int paramInt, boolean paramBoolean)
  {
    check();
    this.target.handleBlockListByReason(paramArrayOfBlockListInfo, paramInt, paramBoolean);
  }

  public void handleCallMissed(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, boolean paramBoolean)
  {
    check();
    this.target.handleCallMissed(paramLong, paramString1, paramInt1, paramInt2, paramString2, paramInt3, paramBoolean);
  }

  public void handleCallReceived(long paramLong1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, String paramString4, String paramString5, String paramString6, ConferenceMembers paramConferenceMembers)
  {
    check();
    this.target.handleCallReceived(paramLong1, paramString1, paramString2, paramBoolean1, paramBoolean2, paramString3, paramLong2, paramInt1, paramInt2, paramInt3, paramLong3, paramString4, paramString5, paramString6, paramConferenceMembers);
  }

  public void handleCallStarted()
  {
    check();
    this.target.handleCallStarted();
  }

  public boolean handleChangeConversationSettings(String paramString, ConversationSettings paramConversationSettings)
  {
    check();
    return this.target.handleChangeConversationSettings(paramString, paramConversationSettings);
  }

  public boolean handleChangeGroup(long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2)
  {
    check();
    return this.target.handleChangeGroup(paramLong1, paramString, paramLong2, paramInt1, paramInt2);
  }

  public boolean handleChangeGroupSettings(long paramLong, ConversationSettings paramConversationSettings)
  {
    check();
    return this.target.handleChangeGroupSettings(paramLong, paramConversationSettings);
  }

  public boolean handleChangeLastOnlineSettings(int paramInt)
  {
    check();
    return this.target.handleChangeLastOnlineSettings(paramInt);
  }

  public boolean handleChangePublicAccount(long paramLong1, String paramString1, long paramLong2, long paramLong3, String paramString2, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4)
  {
    check();
    return this.target.handleChangePublicAccount(paramLong1, paramString1, paramLong2, paramLong3, paramString2, paramArrayOfString, paramLocationInfo, paramString3, paramInt1, paramInt2, paramInt3, paramBoolean, paramString4, paramString5, paramString6, paramString7, paramInt4);
  }

  public boolean handleChangeReadNotificationsSettings(int paramInt)
  {
    check();
    return this.target.handleChangeReadNotificationsSettings(paramInt);
  }

  public boolean handleChangeUserActivitySettings(int paramInt)
  {
    check();
    return this.target.handleChangeUserActivitySettings(paramInt);
  }

  public int handleClearSecureCallStorage()
  {
    check();
    return this.target.handleClearSecureCallStorage();
  }

  public void handleClose()
  {
    check();
    this.target.handleClose();
  }

  public void handleCommError(int paramInt)
  {
    check();
    this.target.handleCommError(paramInt);
  }

  public void handleConnectReject(long paramLong, int paramInt)
  {
    check();
    this.target.handleConnectReject(paramLong, paramInt);
  }

  public void handleConnectivityChange(int paramInt)
  {
    check();
    this.target.handleConnectivityChange(paramInt);
  }

  public boolean handleCreateGroup(int paramInt1, String[] paramArrayOfString, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    check();
    return this.target.handleCreateGroup(paramInt1, paramArrayOfString, paramString, paramLong, paramInt2, paramInt3);
  }

  public boolean handleCreateGroup2(int paramInt, String[] paramArrayOfString, String paramString1, long paramLong, String paramString2)
  {
    check();
    return this.target.handleCreateGroup2(paramInt, paramArrayOfString, paramString1, paramLong, paramString2);
  }

  public boolean handleCreatePublicAccount(int paramInt, String paramString1, LocationInfo paramLocationInfo, String paramString2, String paramString3, long paramLong1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString4, long paramLong2, boolean paramBoolean, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    check();
    return this.target.handleCreatePublicAccount(paramInt, paramString1, paramLocationInfo, paramString2, paramString3, paramLong1, paramArrayOfString1, paramArrayOfString2, paramString4, paramLong2, paramBoolean, paramString5, paramString6, paramString7, paramString8);
  }

  public boolean handleCryptBufferFinish(int paramInt, EncryptionParams paramEncryptionParams)
  {
    check();
    return this.target.handleCryptBufferFinish(paramInt, paramEncryptionParams);
  }

  public boolean handleCryptBufferUpdate(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    check();
    return this.target.handleCryptBufferUpdate(paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramInt2, paramInt3);
  }

  public void handleDataInterruption(boolean paramBoolean)
  {
    check();
    this.target.handleDataInterruption(paramBoolean);
  }

  public void handleDecline()
  {
    check();
    this.target.handleDecline();
  }

  public boolean handleDeleteGroupMessage(long paramLong1, long paramLong2, int paramInt)
  {
    check();
    return this.target.handleDeleteGroupMessage(paramLong1, paramLong2, paramInt);
  }

  public boolean handleDeleteMessage(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    check();
    return this.target.handleDeleteMessage(paramString, paramLong, paramInt1, paramInt2);
  }

  public boolean handleDeletedMessageAck(long paramLong)
  {
    check();
    return this.target.handleDeletedMessageAck(paramLong);
  }

  public void handleDial(String paramString1, String paramString2, boolean paramBoolean)
  {
    check();
    this.target.handleDial(paramString1, paramString2, paramBoolean);
  }

  public void handleDial(String paramString, boolean paramBoolean)
  {
    check();
    this.target.handleDial(paramString, paramBoolean);
  }

  public void handleDialConference(long paramLong, boolean paramBoolean)
  {
    check();
    this.target.handleDialConference(paramLong, paramBoolean);
  }

  public void handleDialViberOut(String paramString)
  {
    check();
    this.target.handleDialViberOut(paramString);
  }

  public void handleDialViberOut(String paramString1, String paramString2)
  {
    check();
    this.target.handleDialViberOut(paramString1, paramString2);
  }

  public void handleDialogReply(int paramInt, String paramString)
  {
    check();
    this.target.handleDialogReply(paramInt, paramString);
  }

  public boolean handleDoneClientMigrationToMid()
  {
    check();
    return this.target.handleDoneClientMigrationToMid();
  }

  public boolean handleDoneMidMapping()
  {
    check();
    return this.target.handleDoneMidMapping();
  }

  public void handleGSMStateChange(int paramInt)
  {
    check();
    this.target.handleGSMStateChange(paramInt);
  }

  public boolean handleGeneralPGWSFormattedRequest(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    return this.target.handleGeneralPGWSFormattedRequest(paramInt, paramLong, paramString1, paramString2);
  }

  public boolean handleGetAppDetails(int[] paramArrayOfInt, int paramInt)
  {
    check();
    return this.target.handleGetAppDetails(paramArrayOfInt, paramInt);
  }

  public boolean handleGetBillingToken()
  {
    check();
    return this.target.handleGetBillingToken();
  }

  public long handleGetCallToken()
  {
    check();
    return this.target.handleGetCallToken();
  }

  public boolean handleGetGroupInfo(int paramInt, long paramLong)
  {
    check();
    return this.target.handleGetGroupInfo(paramInt, paramLong);
  }

  public boolean handleGetGroupMessageStatus(long paramLong, int paramInt, CGroupMessageData[] paramArrayOfCGroupMessageData)
  {
    check();
    return this.target.handleGetGroupMessageStatus(paramLong, paramInt, paramArrayOfCGroupMessageData);
  }

  public boolean handleGetLastOnline(String[] paramArrayOfString, int paramInt)
  {
    check();
    return this.target.handleGetLastOnline(paramArrayOfString, paramInt);
  }

  public GetMD5CryptedFileResult handleGetMD5CryptedFile(String paramString)
  {
    check();
    return this.target.handleGetMD5CryptedFile(paramString);
  }

  public String handleGetMySignature()
  {
    check();
    return this.target.handleGetMySignature();
  }

  public boolean handleGetPersonalProfile()
  {
    check();
    return this.target.handleGetPersonalProfile();
  }

  public String[] handleGetPublicAccountCategoryItem(String paramString1, String paramString2)
  {
    check();
    return this.target.handleGetPublicAccountCategoryItem(paramString1, paramString2);
  }

  public boolean handleGetPublicAccountInfoAccountId(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    check();
    return this.target.handleGetPublicAccountInfoAccountId(paramInt1, paramString, paramInt2, paramInt3, paramInt4);
  }

  public boolean handleGetPublicAccountInfoChatId(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    check();
    return this.target.handleGetPublicAccountInfoChatId(paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
  }

  public boolean handleGetPublicAccountInfoChatUri(int paramInt, String paramString)
  {
    check();
    return this.target.handleGetPublicAccountInfoChatUri(paramInt, paramString);
  }

  public boolean handleGetPublicAccountSubscribersCount(int paramInt, String paramString)
  {
    check();
    return this.target.handleGetPublicAccountSubscribersCount(paramInt, paramString);
  }

  public boolean handleGetPublicAccountsMetaData(CategoryMap paramCategoryMap, ArrayList paramArrayList)
  {
    check();
    return this.target.handleGetPublicAccountsMetaData(paramCategoryMap, paramArrayList);
  }

  public boolean handleGetPublicGroupLikes(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    check();
    return this.target.handleGetPublicGroupLikes(paramInt1, paramLong, paramInt2, paramInt3);
  }

  public boolean handleGetPublicGroupMessages(int paramInt1, long paramLong, int paramInt2)
  {
    check();
    return this.target.handleGetPublicGroupMessages(paramInt1, paramLong, paramInt2);
  }

  public boolean handleGetSecondaryDeviceDetails()
  {
    check();
    return this.target.handleGetSecondaryDeviceDetails();
  }

  public int handleGetSecureSessionInfo(String paramString)
  {
    check();
    return this.target.handleGetSecureSessionInfo(paramString);
  }

  public boolean handleGetUserApps(String paramString, int paramInt)
  {
    check();
    return this.target.handleGetUserApps(paramString, paramInt);
  }

  public boolean handleGetUserMemberIDs(String[] paramArrayOfString, int paramInt)
  {
    check();
    return this.target.handleGetUserMemberIDs(paramArrayOfString, paramInt);
  }

  public boolean handleGetWalletSecureToken(int paramInt1, String paramString1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2, int paramInt5, String paramString2, String paramString3)
  {
    check();
    return this.target.handleGetWalletSecureToken(paramInt1, paramString1, paramInt2, paramInt3, paramBoolean1, paramInt4, paramBoolean2, paramInt5, paramString2, paramString3);
  }

  public boolean handleGlobalDeleteMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    check();
    return this.target.handleGlobalDeleteMessage(paramLong1, paramLong2, paramInt1, paramInt2);
  }

  public boolean handleGroupAddMember(long paramLong, String paramString, int paramInt)
  {
    check();
    return this.target.handleGroupAddMember(paramLong, paramString, paramInt);
  }

  public boolean handleGroupAddMembers(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3)
  {
    check();
    return this.target.handleGroupAddMembers(paramLong, paramInt1, paramArrayOfString, paramInt2, paramInt3);
  }

  public boolean handleGroupAssignRole(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    check();
    return this.target.handleGroupAssignRole(paramLong, paramInt1, paramArrayOfString, paramInt2);
  }

  public boolean handleGroupLeave(long paramLong)
  {
    check();
    return this.target.handleGroupLeave(paramLong);
  }

  public boolean handleGroupMessageLikeAck(long paramLong)
  {
    check();
    return this.target.handleGroupMessageLikeAck(paramLong);
  }

  public boolean handleGroupRemoveMembers(long paramLong, int paramInt, String[] paramArrayOfString)
  {
    check();
    return this.target.handleGroupRemoveMembers(paramLong, paramInt, paramArrayOfString);
  }

  public void handleHangup()
  {
    check();
    this.target.handleHangup();
  }

  public void handleHangupReply(boolean paramBoolean, long paramLong, int paramInt)
  {
    check();
    this.target.handleHangupReply(paramBoolean, paramLong, paramInt);
  }

  public int handleInitDecryptionContext(byte[] paramArrayOfByte)
  {
    check();
    return this.target.handleInitDecryptionContext(paramArrayOfByte);
  }

  public int handleInitEncryptionContext()
  {
    check();
    return this.target.handleInitEncryptionContext();
  }

  public void handleInitVideoPttRecord()
  {
    check();
    this.target.handleInitVideoPttRecord();
  }

  public boolean handleInitiateSecureSyncWithPrimary()
  {
    check();
    return this.target.handleInitiateSecureSyncWithPrimary();
  }

  public boolean handleIsOnline(String paramString)
  {
    check();
    return this.target.handleIsOnline(paramString);
  }

  public boolean handleJoinPublicGroup(long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    check();
    return this.target.handleJoinPublicGroup(paramLong1, paramInt, paramString, paramLong2);
  }

  public void handleLocalHold()
  {
    check();
    this.target.handleLocalHold();
  }

  public void handleLocalUnhold()
  {
    check();
    this.target.handleLocalUnhold();
  }

  public void handleMute()
  {
    check();
    this.target.handleMute();
  }

  public void handleNetworkError(int paramInt, boolean paramBoolean)
  {
    check();
    this.target.handleNetworkError(paramInt, paramBoolean);
  }

  public boolean handleOnClick(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    check();
    return this.target.handleOnClick(paramString1, paramString2, paramInt1, paramInt2);
  }

  public boolean handleRecanonizeAck(String paramString)
  {
    check();
    return this.target.handleRecanonizeAck(paramString);
  }

  public boolean handleRecoverGroupChats()
  {
    check();
    return this.target.handleRecoverGroupChats();
  }

  public boolean handleRecoverPublicAccounts()
  {
    check();
    return this.target.handleRecoverPublicAccounts();
  }

  public void handleRedial(String paramString)
  {
    check();
    this.target.handleRedial(paramString);
  }

  public boolean handleRefreshPublicAccountToken(int paramInt, String paramString)
  {
    check();
    return this.target.handleRefreshPublicAccountToken(paramInt, paramString);
  }

  public boolean handleReportBannerStatistics(long paramLong, int paramInt, String paramString)
  {
    check();
    return this.target.handleReportBannerStatistics(paramLong, paramInt, paramString);
  }

  public boolean handleReportCdr(Cdr paramCdr)
  {
    check();
    return this.target.handleReportCdr(paramCdr);
  }

  public boolean handleReportForwardPublicGroupContentStatistics(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    check();
    return this.target.handleReportForwardPublicGroupContentStatistics(paramLong1, paramLong2, paramLong3, paramInt1, paramInt2, paramInt3, paramBoolean);
  }

  public boolean handleReportGenericPushStatistics(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    check();
    return this.target.handleReportGenericPushStatistics(paramLong, paramInt1, paramInt2, paramString);
  }

  public boolean handleReportPublicGroupStatistics(long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    check();
    return this.target.handleReportPublicGroupStatistics(paramLong1, paramLong2, paramString1, paramBoolean, paramString2, paramString3);
  }

  public boolean handleReportPurchaseErrorStatistics(String paramString, int paramInt)
  {
    check();
    return this.target.handleReportPurchaseErrorStatistics(paramString, paramInt);
  }

  public boolean handleReportSO(String paramString)
  {
    check();
    return this.target.handleReportSO(paramString);
  }

  public void handleReportStatistics(CallStatistics paramCallStatistics)
  {
    check();
    this.target.handleReportStatistics(paramCallStatistics);
  }

  public boolean handleReportWatchActivationStatistics(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    check();
    return this.target.handleReportWatchActivationStatistics(paramString1, paramString2, paramInt, paramString3);
  }

  public boolean handleReportWatchDailyStatistics(String paramString1, String paramString2, int paramInt, long paramLong, String paramString3)
  {
    check();
    return this.target.handleReportWatchDailyStatistics(paramString1, paramString2, paramInt, paramLong, paramString3);
  }

  public boolean handleSearchPublicAccountsByParams(int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
  {
    check();
    return this.target.handleSearchPublicAccountsByParams(paramInt1, paramString1, paramString2, paramInt2, paramBundle);
  }

  public boolean handleSearchPublicGroupsForCountry(int paramInt1, String paramString, int paramInt2)
  {
    check();
    return this.target.handleSearchPublicGroupsForCountry(paramInt1, paramString, paramInt2);
  }

  public void handleSecondaryDevicePush()
  {
    check();
    this.target.handleSecondaryDevicePush();
  }

  public boolean handleSecondaryQRPhotographed(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    check();
    return this.target.handleSecondaryQRPhotographed(paramArrayOfByte, paramString, paramBoolean, paramInt);
  }

  public boolean handleSecondaryRegisteredAck(long paramLong)
  {
    check();
    return this.target.handleSecondaryRegisteredAck(paramLong);
  }

  public void handleSecureCallVerified(int paramInt, byte[] paramArrayOfByte)
  {
    check();
    this.target.handleSecureCallVerified(paramInt, paramArrayOfByte);
  }

  public boolean handleSecureTokenRequest(int paramInt)
  {
    check();
    return this.target.handleSecureTokenRequest(paramInt);
  }

  public boolean handleSendContactSavedNotification(String paramString, int paramInt)
  {
    check();
    return this.target.handleSendContactSavedNotification(paramString, paramInt);
  }

  public boolean handleSendConversationStatus(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, boolean paramBoolean, String paramString6)
  {
    check();
    return this.target.handleSendConversationStatus(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramLong, paramString5, paramBoolean, paramString6);
  }

  public void handleSendGroupChangedAck(long paramLong, boolean paramBoolean)
  {
    check();
    this.target.handleSendGroupChangedAck(paramLong, paramBoolean);
  }

  public boolean handleSendIM2Message(MessageWrite paramMessageWrite)
  {
    check();
    return this.target.handleSendIM2Message(paramMessageWrite);
  }

  public void handleSendIceCandidates(IceCandidate[] paramArrayOfIceCandidate)
  {
    check();
    this.target.handleSendIceCandidates(paramArrayOfIceCandidate);
  }

  public void handleSendMessageDeliveredAck(long paramLong)
  {
    check();
    this.target.handleSendMessageDeliveredAck(paramLong);
  }

  public void handleSendMessageReplyAck(long paramLong)
  {
    check();
    this.target.handleSendMessageReplyAck(paramLong);
  }

  public boolean handleSendMissedCallsAck(long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt)
  {
    check();
    return this.target.handleSendMissedCallsAck(paramArrayOfLong1, paramArrayOfLong2, paramArrayOfInt);
  }

  public boolean handleSendPublicGroupInvite(int paramInt1, String[] paramArrayOfString, long paramLong, int paramInt2)
  {
    check();
    return this.target.handleSendPublicGroupInvite(paramInt1, paramArrayOfString, paramLong, paramInt2);
  }

  public boolean handleSendPublicGroupInviteToGroup(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    check();
    return this.target.handleSendPublicGroupInviteToGroup(paramInt1, paramLong1, paramLong2, paramInt2);
  }

  public void handleSendPublicGroupsUpdatedAck(long paramLong)
  {
    check();
    this.target.handleSendPublicGroupsUpdatedAck(paramLong);
  }

  public boolean handleSendQueryDestOperationSupport(int paramInt, String paramString, long paramLong)
  {
    check();
    return this.target.handleSendQueryDestOperationSupport(paramInt, paramString, paramLong);
  }

  public void handleSendSdpAnswer(String paramString, ProcessedCallback paramProcessedCallback)
  {
    check();
    this.target.handleSendSdpAnswer(paramString, paramProcessedCallback);
  }

  public void handleSendSdpOffer(String paramString, SdpProcessedCallback paramSdpProcessedCallback)
  {
    check();
    this.target.handleSendSdpOffer(paramString, paramSdpProcessedCallback);
  }

  public void handleSendSdpOfferToHs(String paramString)
  {
    check();
    this.target.handleSendSdpOfferToHs(paramString);
  }

  public boolean handleSendSyncConversationAck(String paramString, long paramLong, int paramInt)
  {
    check();
    return this.target.handleSendSyncConversationAck(paramString, paramLong, paramInt);
  }

  public boolean handleSendSyncGroupAck(long paramLong1, long paramLong2, int paramInt)
  {
    check();
    return this.target.handleSendSyncGroupAck(paramLong1, paramLong2, paramInt);
  }

  public void handleSendSyncMessageLikeAck(long paramLong)
  {
    check();
    this.target.handleSendSyncMessageLikeAck(paramLong);
  }

  public boolean handleSendSyncMessagesAck(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    check();
    return this.target.handleSendSyncMessagesAck(paramArrayOfLong1, paramArrayOfLong2);
  }

  public boolean handleSendUpdateSelfUserDetailsAck(long paramLong)
  {
    check();
    return this.target.handleSendUpdateSelfUserDetailsAck(paramLong);
  }

  public boolean handleSendUpdateUnsavedContactDetailsAck(long paramLong)
  {
    check();
    return this.target.handleSendUpdateUnsavedContactDetailsAck(paramLong);
  }

  public void handleSendViberOutBalanceChangeAck(long paramLong)
  {
    check();
    this.target.handleSendViberOutBalanceChangeAck(paramLong);
  }

  public void handleSendWebNotificationAck(long paramLong)
  {
    check();
    this.target.handleSendWebNotificationAck(paramLong);
  }

  public boolean handleSetCanonizationRules(String paramString)
  {
    check();
    return this.target.handleSetCanonizationRules(paramString);
  }

  public int handleSetEncryptionContext(byte[] paramArrayOfByte)
  {
    check();
    return this.target.handleSetEncryptionContext(paramArrayOfByte);
  }

  public void handleSetLocation(LocationEx paramLocationEx)
  {
    check();
    this.target.handleSetLocation(paramLocationEx);
  }

  public void handleSetRemoteSdp(String paramString)
  {
    check();
    this.target.handleSetRemoteSdp(paramString);
  }

  public boolean handleShareDeltaAddressBook(CContactInfo[] paramArrayOfCContactInfo1, CContactInfo[] paramArrayOfCContactInfo2, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    check();
    return this.target.handleShareDeltaAddressBook(paramArrayOfCContactInfo1, paramArrayOfCContactInfo2, paramArrayOfString, paramInt1, paramInt2);
  }

  public boolean handleShareFullAddressBook(CContactInfo[] paramArrayOfCContactInfo, int paramInt)
  {
    check();
    return this.target.handleShareFullAddressBook(paramArrayOfCContactInfo, paramInt);
  }

  public boolean handleShareSecondaryContact(CContactInfo paramCContactInfo, int paramInt)
  {
    check();
    return this.target.handleShareSecondaryContact(paramCContactInfo, paramInt);
  }

  public void handleShareSecondaryContactAck(long paramLong)
  {
    check();
    this.target.handleShareSecondaryContactAck(paramLong);
  }

  public void handleStartVideoPttRecord(Object paramObject, String paramString)
  {
    check();
    this.target.handleStartVideoPttRecord(paramObject, paramString);
  }

  public void handleStopVideoPttRecord()
  {
    check();
    this.target.handleStopVideoPttRecord();
  }

  public boolean handleSubscribeToPublicAccount(int paramInt, String paramString)
  {
    check();
    return this.target.handleSubscribeToPublicAccount(paramInt, paramString);
  }

  public void handleSwitchToGSM(String paramString)
  {
    check();
    this.target.handleSwitchToGSM(paramString);
  }

  public void handleSwitchedToConference(long paramLong)
  {
    check();
    this.target.handleSwitchedToConference(paramLong);
  }

  public boolean handleSyncConversation(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    check();
    return this.target.handleSyncConversation(paramString, paramLong, paramInt1, paramInt2);
  }

  public String handleSyncDataFromMyOtherDevicePreview(String paramString)
  {
    return this.target.handleSyncDataFromMyOtherDevicePreview(paramString);
  }

  public void handleSyncDataFromOtherDeviceAck(long paramLong)
  {
    this.target.handleSyncDataFromOtherDeviceAck(paramLong);
  }

  public boolean handleSyncDataToMyDevices(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.target.handleSyncDataToMyDevices(paramString, paramInt1, paramLong, paramInt2);
  }

  public boolean handleSyncDeletedMessages(ConversationToken[] paramArrayOfConversationToken, GroupToken[] paramArrayOfGroupToken, int paramInt)
  {
    check();
    return this.target.handleSyncDeletedMessages(paramArrayOfConversationToken, paramArrayOfGroupToken, paramInt);
  }

  public boolean handleSyncGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    check();
    return this.target.handleSyncGroup(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfString);
  }

  public boolean handleSyncMessageLikeAck(long paramLong)
  {
    check();
    return this.target.handleSyncMessageLikeAck(paramLong);
  }

  public void handleTransfer(boolean paramBoolean)
  {
    check();
    this.target.handleTransfer(paramBoolean);
  }

  public boolean handleTrustPeer(String paramString, boolean paramBoolean)
  {
    check();
    return this.target.handleTrustPeer(paramString, paramBoolean);
  }

  public boolean handleUnSubscribeFromPublicAccount(int paramInt, String paramString)
  {
    check();
    return this.target.handleUnSubscribeFromPublicAccount(paramInt, paramString);
  }

  public void handleUnmute()
  {
    check();
    this.target.handleUnmute();
  }

  public boolean handleUnregisterApp(int paramInt1, int paramInt2)
  {
    check();
    return this.target.handleUnregisterApp(paramInt1, paramInt2);
  }

  public boolean handleUpdateBadge(int paramInt)
  {
    check();
    return this.target.handleUpdateBadge(paramInt);
  }

  public void handleUpdateClientConfiguration(String paramString)
  {
    this.target.handleUpdateClientConfiguration(paramString);
  }

  public boolean handleUpdateLanguage(String paramString)
  {
    check();
    return this.target.handleUpdateLanguage(paramString);
  }

  public boolean handleUpdateUserName(String paramString)
  {
    check();
    return this.target.handleUpdateUserName(paramString);
  }

  public boolean handleUpdateUserPhoto(long paramLong)
  {
    check();
    return this.target.handleUpdateUserPhoto(paramLong);
  }

  public boolean handleValidatePublicAccountFields(int paramInt, PublicAccountFieldValueMap paramPublicAccountFieldValueMap)
  {
    check();
    return this.target.handleValidatePublicAccountFields(paramInt, paramPublicAccountFieldValueMap);
  }

  public boolean handleValidatePublicGroupUri(int paramInt, String paramString)
  {
    check();
    return this.target.handleValidatePublicGroupUri(paramInt, paramString);
  }

  public boolean isConnected()
  {
    check();
    return this.target.isConnected();
  }

  public boolean isGroupSecure(long paramLong)
  {
    check();
    return this.target.isGroupSecure(paramLong);
  }

  public boolean isNullEncryptionParams(EncryptionParams paramEncryptionParams)
  {
    check();
    return this.target.isNullEncryptionParams(paramEncryptionParams);
  }

  public PeerTrustState isPeerTrusted(String paramString)
  {
    check();
    return this.target.isPeerTrusted(paramString);
  }

  public boolean isPublicAccountId(String paramString)
  {
    check();
    return this.target.isPublicAccountId(paramString);
  }

  public boolean isRakutenPhone(String paramString)
  {
    check();
    return this.target.isRakutenPhone(paramString);
  }

  public boolean isShortStandardBackgroundID(String paramString)
  {
    check();
    return this.target.isShortStandardBackgroundID(paramString);
  }

  public boolean isVideoSupported()
  {
    check();
    return this.target.isVideoSupported();
  }

  public int lengthenStandartBackgroundID(String paramString, String[] paramArrayOfString)
  {
    check();
    return this.target.lengthenStandartBackgroundID(paramString, paramArrayOfString);
  }

  public void notifyActivityOnForeground(boolean paramBoolean)
  {
    check();
    this.target.notifyActivityOnForeground(paramBoolean);
  }

  public void requestShutdown()
  {
    check();
    this.target.requestShutdown();
  }

  public void resetDeviceKey()
  {
    check();
    this.target.resetDeviceKey();
  }

  public void setCaptureDeviceName(String paramString)
  {
    check();
    this.target.setCaptureDeviceName(paramString);
  }

  public void setDeviceKey(byte[] paramArrayOfByte)
  {
    check();
    this.target.setDeviceKey(paramArrayOfByte);
  }

  public int setDeviceOrientation(int paramInt1, int paramInt2, int paramInt3)
  {
    check();
    return this.target.setDeviceOrientation(paramInt1, paramInt2, paramInt3);
  }

  public void setEnableVideo(boolean paramBoolean)
  {
    check();
    this.target.setEnableVideo(paramBoolean);
  }

  public void setPixieMode(int paramInt)
  {
    check();
    this.target.setPixieMode(paramInt);
  }

  public void setupVoiceQuality(int paramInt)
  {
    check();
    this.target.setupVoiceQuality(paramInt);
  }

  public int shortenStandardBackgroundID(String paramString, long[] paramArrayOfLong)
  {
    check();
    return this.target.shortenStandardBackgroundID(paramString, paramArrayOfLong);
  }

  public int startRecvVideo()
  {
    check();
    return this.target.startRecvVideo();
  }

  public int startSendVideo()
  {
    check();
    return this.target.startSendVideo();
  }

  public int stopRecvVideo()
  {
    check();
    return this.target.stopRecvVideo();
  }

  public int stopSendVideo()
  {
    check();
    return this.target.stopSendVideo();
  }

  public void testConnection(int paramInt)
  {
    check();
    this.target.testConnection(paramInt);
  }

  public boolean updatePushToken(String paramString)
  {
    check();
    return this.target.updatePushToken(paramString);
  }

  public static abstract interface Host
  {
    public abstract void ensureInitialized();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.NativeEngineBridge
 * JD-Core Version:    0.6.2
 */