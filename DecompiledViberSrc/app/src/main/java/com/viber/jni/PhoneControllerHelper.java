package com.viber.jni;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.Cdr;
import com.viber.jni.im2.MessageWrite;
import com.viber.jni.webrtc.IceCandidate;
import com.viber.jni.webrtc.ProcessedCallback;
import com.viber.jni.webrtc.SdpProcessedCallback;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;

public class PhoneControllerHelper
  implements EngineBackend
{
  private static final Logger L = ViberEnv.getLogger();
  private static PhoneControllerDelegate mDelegate;
  private static boolean mInitialized = false;
  private static volatile PhoneControllerHelper mInstance;
  private static boolean mReady = false;
  private Host mHost;

  public PhoneControllerHelper(Host paramHost)
  {
    this.mHost = paramHost;
  }

  private void exit()
  {
    this.mHost.exit();
  }

  private native int init(PhoneControllerInitializer paramPhoneControllerInitializer);

  public int Init(PhoneControllerInitializer paramPhoneControllerInitializer)
  {
    try
    {
      boolean bool = mInitialized;
      int i = 0;
      if (!bool)
      {
        i = init(paramPhoneControllerInitializer);
        mDelegate = paramPhoneControllerInitializer._delegate;
        if (i == 0)
          break label72;
        Logger localLogger = L;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i);
        localLogger.e("PhoneControllerHelper INIT FAIL Status=?", arrayOfObject);
        exit();
      }
      while (true)
      {
        return i;
        label72: mInitialized = true;
      }
    }
    finally
    {
    }
  }

  public native void answerCreated(String paramString);

  public native int bunzip2(String paramString1, String paramString2, boolean paramBoolean);

  public native boolean bzip2_supported();

  public native String canonizePhoneNumber(String paramString);

  public native String canonizePhoneNumberForCountryCode(int paramInt, String paramString);

  public native void changePhoneNumberInfo(int paramInt, String paramString1, String paramString2);

  public native int changeUDID(byte[] paramArrayOfByte);

  public native void connect();

  public native int connectivityTest(IVoipServiceConnectivityTestCallback paramIVoipServiceConnectivityTestCallback);

  @Deprecated
  public native void crashLibrary();

  public native boolean deleteAllSecurityInfo();

  public native void disconnect();

  public native int done();

  public native String encodeCurrency(String paramString1, String paramString2);

  public native int generateSequence();

  public native int getBICC(String paramString);

  public native String[] getBreachedPeersList();

  public native int getCountryCode(String paramString);

  public native CountryNameInfo getCountryName(String paramString);

  public native int getDefaultProtocolVersion();

  public native String getDownloadURL(String paramString1, String paramString2, String paramString3);

  public native String getExternalAppPhone(int paramInt);

  public native int getFileOwnerUid(String paramString);

  public native String getHashForReRegister(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public native boolean getIsVoTrialCall();

  public native long getMyCID();

  public native long getMyVersion();

  public native String getPGDownloadURL(String paramString1, String paramString2, String paramString3, int paramInt);

  public native String getPhoneProvider(String paramString);

  public native int getPhoneState();

  public native long getPhoneType();

  public native String getPhotoDownloadURL(String paramString1, String paramString2, int paramInt);

  public native String getSecureKeyforQR();

  public native String[] getTrustedPeersList();

  public native void handleAddToConferenceCall(String paramString);

  public native void handleAnswer(boolean paramBoolean);

  public native void handleAppModeChanged(int paramInt);

  public native boolean handleAuthenticateApp(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean);

  public native void handleBannerOrSplashAck(long paramLong, int paramInt);

  public native boolean handleBlockApp(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);

  public native boolean handleBlockGroupInvite(long paramLong, boolean paramBoolean, int paramInt);

  public native void handleBlockListByReason(BlockListInfo[] paramArrayOfBlockListInfo, int paramInt, boolean paramBoolean);

  public native void handleCallMissed(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, boolean paramBoolean);

  public native void handleCallReceived(long paramLong1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, String paramString4, String paramString5, String paramString6, Bundle paramBundle);

  public void handleCallReceived(long paramLong1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, String paramString4, String paramString5, String paramString6, ConferenceMembers paramConferenceMembers)
  {
    handleCallReceived(paramLong1, paramString1, paramString2, paramBoolean1, paramBoolean2, paramString3, paramLong2, paramInt1, paramInt2, paramInt3, paramLong3, paramString4, paramString5, paramString6, paramConferenceMembers.toBundle());
  }

  public native void handleCallStarted();

  public native boolean handleChangeConversationSettings(String paramString, ConversationSettings paramConversationSettings);

  public native boolean handleChangeGroup(long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2);

  public native boolean handleChangeGroupSettings(long paramLong, ConversationSettings paramConversationSettings);

  public native boolean handleChangeLastOnlineSettings(int paramInt);

  public native boolean handleChangePublicAccount(long paramLong1, String paramString1, long paramLong2, long paramLong3, String paramString2, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4);

  public native boolean handleChangeReadNotificationsSettings(int paramInt);

  public native boolean handleChangeUserActivitySettings(int paramInt);

  public native int handleClearSecureCallStorage();

  public native void handleClose();

  public native void handleCommError(int paramInt);

  public native void handleConnectReject(long paramLong, int paramInt);

  public native void handleConnectivityChange(int paramInt);

  public native boolean handleCreateGroup(int paramInt1, String[] paramArrayOfString, String paramString, long paramLong, int paramInt2, int paramInt3);

  public native boolean handleCreateGroup2(int paramInt, String[] paramArrayOfString, String paramString1, long paramLong, String paramString2);

  public native boolean handleCreatePublicAccount(int paramInt, String paramString1, LocationInfo paramLocationInfo, String paramString2, String paramString3, long paramLong1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString4, long paramLong2, boolean paramBoolean, String paramString5, String paramString6, String paramString7, String paramString8);

  public native boolean handleCryptBufferFinish(int paramInt, EncryptionParams paramEncryptionParams);

  public native boolean handleCryptBufferUpdate(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3);

  public native void handleDataInterruption(boolean paramBoolean);

  public native void handleDecline();

  public native boolean handleDeleteGroupMessage(long paramLong1, long paramLong2, int paramInt);

  public native boolean handleDeleteMessage(String paramString, long paramLong, int paramInt1, int paramInt2);

  public native boolean handleDeletedMessageAck(long paramLong);

  public native void handleDial(String paramString1, String paramString2, boolean paramBoolean);

  public void handleDial(String paramString, boolean paramBoolean)
  {
  }

  public native void handleDialConference(long paramLong, boolean paramBoolean);

  public void handleDialViberOut(String paramString)
  {
  }

  public native void handleDialViberOut(String paramString1, String paramString2);

  public native void handleDialogReply(int paramInt, String paramString);

  public native boolean handleDoneClientMigrationToMid();

  public native boolean handleDoneMidMapping();

  public native void handleGSMStateChange(int paramInt);

  public native boolean handleGeneralPGWSFormattedRequest(int paramInt, long paramLong, String paramString1, String paramString2);

  public native boolean handleGetAppDetails(int[] paramArrayOfInt, int paramInt);

  public native boolean handleGetBillingToken();

  public native long handleGetCallToken();

  public native boolean handleGetGroupInfo(int paramInt, long paramLong);

  public native boolean handleGetGroupMessageStatus(long paramLong, int paramInt, CGroupMessageData[] paramArrayOfCGroupMessageData);

  public native boolean handleGetLastOnline(String[] paramArrayOfString, int paramInt);

  public native GetMD5CryptedFileResult handleGetMD5CryptedFile(String paramString);

  public native String handleGetMySignature();

  public native boolean handleGetPersonalProfile();

  public native String[] handleGetPublicAccountCategoryItem(String paramString1, String paramString2);

  public native boolean handleGetPublicAccountInfoAccountId(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4);

  public native boolean handleGetPublicAccountInfoChatId(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);

  public native boolean handleGetPublicAccountInfoChatUri(int paramInt, String paramString);

  public native boolean handleGetPublicAccountSubscribersCount(int paramInt, String paramString);

  public native boolean handleGetPublicAccountsMetaData(CategoryMap paramCategoryMap, ArrayList paramArrayList);

  @Deprecated
  public native boolean handleGetPublicGroupInfo(int paramInt1, long paramLong, int paramInt2, int paramInt3);

  public native boolean handleGetPublicGroupLikes(int paramInt1, long paramLong, int paramInt2, int paramInt3);

  public native boolean handleGetPublicGroupMessages(int paramInt1, long paramLong, int paramInt2);

  public native boolean handleGetSecondaryDeviceDetails();

  public native int handleGetSecureSessionInfo(String paramString);

  public native boolean handleGetUserApps(String paramString, int paramInt);

  public native boolean handleGetUserMemberIDs(String[] paramArrayOfString, int paramInt);

  public native boolean handleGetWalletSecureToken(int paramInt1, String paramString1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2, int paramInt5, String paramString2, String paramString3);

  public native boolean handleGlobalDeleteMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2);

  public native boolean handleGroupAddMember(long paramLong, String paramString, int paramInt);

  public native boolean handleGroupAddMembers(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3);

  public native boolean handleGroupAssignRole(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2);

  public native boolean handleGroupLeave(long paramLong);

  public native boolean handleGroupMessageLikeAck(long paramLong);

  public native boolean handleGroupRemoveMembers(long paramLong, int paramInt, String[] paramArrayOfString);

  public native void handleHangup();

  public native void handleHangupReply(boolean paramBoolean, long paramLong, int paramInt);

  public native int handleInitDecryptionContext(byte[] paramArrayOfByte);

  public native int handleInitEncryptionContext();

  public native void handleInitVideoPttRecord();

  public native boolean handleInitiateSecureSyncWithPrimary();

  public native boolean handleIsOnline(String paramString);

  public native boolean handleJoinPublicGroup(long paramLong1, int paramInt, String paramString, long paramLong2);

  public native void handleLocalHold();

  public native void handleLocalUnhold();

  public native void handleMute();

  public native void handleNetworkError(int paramInt, boolean paramBoolean);

  public native boolean handleOnClick(String paramString1, String paramString2, int paramInt1, int paramInt2);

  public native boolean handleRecanonizeAck(String paramString);

  public native boolean handleRecoverGroupChats();

  public native boolean handleRecoverPublicAccounts();

  public native void handleRedial(String paramString);

  public native boolean handleRefreshPublicAccountToken(int paramInt, String paramString);

  public native boolean handleReportBannerStatistics(long paramLong, int paramInt, String paramString);

  public native boolean handleReportCdr(Cdr paramCdr);

  public native boolean handleReportForwardPublicGroupContentStatistics(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);

  public native boolean handleReportGenericPushStatistics(long paramLong, int paramInt1, int paramInt2, String paramString);

  public native boolean handleReportPublicGroupStatistics(long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2, String paramString3);

  public native boolean handleReportPurchaseErrorStatistics(String paramString, int paramInt);

  public native boolean handleReportSO(String paramString);

  public native void handleReportStatistics(CallStatistics paramCallStatistics);

  public native boolean handleReportWatchActivationStatistics(String paramString1, String paramString2, int paramInt, String paramString3);

  public native boolean handleReportWatchDailyStatistics(String paramString1, String paramString2, int paramInt, long paramLong, String paramString3);

  public native boolean handleSearchPublicAccountsByParams(int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle);

  public native boolean handleSearchPublicGroupsForCountry(int paramInt1, String paramString, int paramInt2);

  public native void handleSecondaryDevicePush();

  public native boolean handleSecondaryQRPhotographed(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt);

  public native boolean handleSecondaryRegisteredAck(long paramLong);

  public native void handleSecureCallVerified(int paramInt, byte[] paramArrayOfByte);

  public native boolean handleSecureTokenRequest(int paramInt);

  public native boolean handleSendContactSavedNotification(String paramString, int paramInt);

  public native boolean handleSendConversationStatus(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, boolean paramBoolean, String paramString6);

  public native void handleSendGroupChangedAck(long paramLong, boolean paramBoolean);

  public native boolean handleSendIM2Message(MessageWrite paramMessageWrite);

  public native void handleSendIceCandidates(IceCandidate[] paramArrayOfIceCandidate);

  public native void handleSendMessageDeliveredAck(long paramLong);

  public native void handleSendMessageReplyAck(long paramLong);

  public native boolean handleSendMissedCallsAck(long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt);

  public native boolean handleSendPublicGroupInvite(int paramInt1, String[] paramArrayOfString, long paramLong, int paramInt2);

  public native boolean handleSendPublicGroupInviteToGroup(int paramInt1, long paramLong1, long paramLong2, int paramInt2);

  public native void handleSendPublicGroupsUpdatedAck(long paramLong);

  public native boolean handleSendQueryDestOperationSupport(int paramInt, String paramString, long paramLong);

  public native void handleSendSdpAnswer(String paramString, ProcessedCallback paramProcessedCallback);

  public native void handleSendSdpOffer(String paramString, SdpProcessedCallback paramSdpProcessedCallback);

  public native void handleSendSdpOfferToHs(String paramString);

  public native boolean handleSendSyncConversationAck(String paramString, long paramLong, int paramInt);

  public native boolean handleSendSyncGroupAck(long paramLong1, long paramLong2, int paramInt);

  public native void handleSendSyncMessageLikeAck(long paramLong);

  public native boolean handleSendSyncMessagesAck(long[] paramArrayOfLong1, long[] paramArrayOfLong2);

  public native boolean handleSendUpdateSelfUserDetailsAck(long paramLong);

  public native boolean handleSendUpdateUnsavedContactDetailsAck(long paramLong);

  public native void handleSendViberOutBalanceChangeAck(long paramLong);

  public native void handleSendWebNotificationAck(long paramLong);

  public native boolean handleSetCanonizationRules(String paramString);

  public native int handleSetEncryptionContext(byte[] paramArrayOfByte);

  public native void handleSetLocation(LocationEx paramLocationEx);

  public native void handleSetRemoteSdp(String paramString);

  public native boolean handleShareDeltaAddressBook(CContactInfo[] paramArrayOfCContactInfo1, CContactInfo[] paramArrayOfCContactInfo2, String[] paramArrayOfString, int paramInt1, int paramInt2);

  public native boolean handleShareFullAddressBook(CContactInfo[] paramArrayOfCContactInfo, int paramInt);

  public native boolean handleShareSecondaryContact(CContactInfo paramCContactInfo, int paramInt);

  public native void handleShareSecondaryContactAck(long paramLong);

  public native void handleStartVideoPttRecord(Object paramObject, String paramString);

  public native void handleStopVideoPttRecord();

  public native boolean handleSubscribeToPublicAccount(int paramInt, String paramString);

  public native void handleSwitchToGSM(String paramString);

  public native void handleSwitchedToConference(long paramLong);

  public native boolean handleSyncConversation(String paramString, long paramLong, int paramInt1, int paramInt2);

  public native String handleSyncDataFromMyOtherDevicePreview(String paramString);

  public native void handleSyncDataFromOtherDeviceAck(long paramLong);

  public native boolean handleSyncDataToMyDevices(String paramString, int paramInt1, long paramLong, int paramInt2);

  public native boolean handleSyncDeletedMessages(ConversationToken[] paramArrayOfConversationToken, GroupToken[] paramArrayOfGroupToken, int paramInt);

  public native boolean handleSyncGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString);

  public native boolean handleSyncMessageLikeAck(long paramLong);

  public native void handleTransfer(boolean paramBoolean);

  public native boolean handleTrustPeer(String paramString, boolean paramBoolean);

  public native boolean handleUnSubscribeFromPublicAccount(int paramInt, String paramString);

  public native void handleUnmute();

  public native boolean handleUnregisterApp(int paramInt1, int paramInt2);

  public native boolean handleUpdateBadge(int paramInt);

  public native void handleUpdateClientConfiguration(String paramString);

  public native boolean handleUpdateLanguage(String paramString);

  public native boolean handleUpdateUserName(String paramString);

  public native boolean handleUpdateUserPhoto(long paramLong);

  public native boolean handleValidatePublicAccountFields(int paramInt, PublicAccountFieldValueMap paramPublicAccountFieldValueMap);

  public native boolean handleValidatePublicGroupUri(int paramInt, String paramString);

  public native boolean isConnected();

  public native boolean isGroupSecure(long paramLong);

  public boolean isInitialized()
  {
    return mInitialized;
  }

  public native boolean isNullEncryptionParams(EncryptionParams paramEncryptionParams);

  public native PeerTrustState isPeerTrusted(String paramString);

  public native boolean isPublicAccountId(String paramString);

  public native boolean isRakutenPhone(String paramString);

  public boolean isReady()
  {
    return mReady;
  }

  public native boolean isShortStandardBackgroundID(String paramString);

  public native boolean isVideoSupported();

  public native int lengthenStandartBackgroundID(String paramString, String[] paramArrayOfString);

  public native void notifyActivityOnForeground(boolean paramBoolean);

  public native void requestShutdown();

  public native void resetDeviceKey();

  public native void setCaptureDeviceName(String paramString);

  public native void setDeviceKey(byte[] paramArrayOfByte);

  public native int setDeviceOrientation(int paramInt1, int paramInt2, int paramInt3);

  public native void setEnableVideo(boolean paramBoolean);

  public native void setIsVoTrialCall(boolean paramBoolean);

  public native void setPixieMode(int paramInt);

  public native void setupVoiceQuality(int paramInt);

  public native int shortenStandardBackgroundID(String paramString, long[] paramArrayOfLong);

  public native int startRecvVideo();

  public native int startSendVideo();

  public native int stopRecvVideo();

  public native int stopSendVideo();

  public native void testConnection(int paramInt);

  public native boolean updatePushToken(String paramString);

  public static abstract interface Host
  {
    public abstract void exit();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PhoneControllerHelper
 * JD-Core Version:    0.6.2
 */