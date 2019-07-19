package com.viber.jni.controller;

import com.viber.jni.BlockListInfo;
import com.viber.jni.CContactInfo;
import com.viber.jni.CGroupMessageData;
import com.viber.jni.ConversationSettings;
import com.viber.jni.ConversationToken;
import com.viber.jni.CountryNameInfo;
import com.viber.jni.GroupToken;
import com.viber.jni.IVoipServiceConnectivityTestCallback;
import com.viber.jni.LocationEx;
import com.viber.jni.LocationInfo;
import com.viber.jni.cdr.Cdr;

public abstract interface PhoneController
{
  public static final int NO_SEQUENCE = -1;

  public abstract String canonizePhoneNumber(String paramString);

  public abstract String canonizePhoneNumberForCountryCode(int paramInt, String paramString);

  public abstract void changePhoneNumberInfo(int paramInt, String paramString1, String paramString2);

  public abstract int changeUDID(byte[] paramArrayOfByte);

  public abstract void connect();

  public abstract int connectivityTest(IVoipServiceConnectivityTestCallback paramIVoipServiceConnectivityTestCallback);

  public abstract void crashLibrary();

  public abstract void disconnect();

  public abstract int done();

  public abstract String encodeCurrency(String paramString1, String paramString2);

  public abstract int generateSequence();

  public abstract int getBICC(String paramString);

  public abstract int getCountryCode(String paramString);

  public abstract CountryNameInfo getCountryName(String paramString);

  public abstract int getDefaultProtocolVersion();

  public abstract String getDownloadURL(String paramString1, String paramString2, String paramString3);

  public abstract String getExternalAppPhone(int paramInt);

  public abstract int getFileOwnerUid(String paramString);

  public abstract String getHashForReRegister(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public abstract long getMyCID();

  public abstract long getMyVersion();

  public abstract String getPGDownloadURL(String paramString1, String paramString2, String paramString3, int paramInt);

  public abstract String getPhoneProvider(String paramString);

  public abstract long getPhoneType();

  public abstract String getPhotoDownloadURL(String paramString1, String paramString2, int paramInt);

  public abstract void handleAddToConferenceCall(String paramString);

  public abstract void handleAppModeChanged(int paramInt);

  public abstract boolean handleBlockGroupInvite(long paramLong, boolean paramBoolean, int paramInt);

  public abstract void handleBlockListByReason(BlockListInfo[] paramArrayOfBlockListInfo, int paramInt, boolean paramBoolean);

  public abstract boolean handleChangeConversationSettings(String paramString, ConversationSettings paramConversationSettings);

  public abstract boolean handleChangeGroup(long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2);

  public abstract boolean handleChangeGroupSettings(long paramLong, ConversationSettings paramConversationSettings);

  public abstract void handleCommError(int paramInt);

  public abstract void handleConnectReject(long paramLong, int paramInt);

  public abstract void handleConnectivityChange(int paramInt);

  public abstract boolean handleCreateGroup(int paramInt1, String[] paramArrayOfString, String paramString, long paramLong, int paramInt2, int paramInt3);

  public abstract boolean handleCreateGroup2(int paramInt, String[] paramArrayOfString, String paramString1, long paramLong, String paramString2);

  public abstract boolean handleCreatePublicAccount(int paramInt, String paramString1, LocationInfo paramLocationInfo, String paramString2, String paramString3, long paramLong1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString4, long paramLong2, boolean paramBoolean, String paramString5, String paramString6, String paramString7, String paramString8);

  public abstract void handleDataInterruption(boolean paramBoolean);

  public abstract boolean handleDeleteGroupMessage(long paramLong1, long paramLong2, int paramInt);

  public abstract boolean handleDeleteMessage(String paramString, long paramLong, int paramInt1, int paramInt2);

  public abstract boolean handleDeletedMessageAck(long paramLong);

  public abstract void handleGSMStateChange(int paramInt);

  public abstract boolean handleGeneralPGWSFormattedRequest(int paramInt, long paramLong, String paramString1, String paramString2);

  public abstract boolean handleGetAppDetails(int[] paramArrayOfInt, int paramInt);

  public abstract boolean handleGetBillingToken();

  public abstract long handleGetCallToken();

  public abstract boolean handleGetGroupMessageStatus(long paramLong, int paramInt, CGroupMessageData[] paramArrayOfCGroupMessageData);

  public abstract String handleGetMySignature();

  public abstract boolean handleGetPersonalProfile();

  public abstract boolean handleGetPublicAccountInfoAccountId(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4);

  public abstract boolean handleGetPublicAccountInfoChatId(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);

  public abstract boolean handleGetPublicAccountInfoChatUri(int paramInt, String paramString);

  public abstract boolean handleGlobalDeleteMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2);

  @Deprecated
  public abstract boolean handleGroupAddMember(long paramLong, String paramString, int paramInt);

  public abstract boolean handleGroupLeave(long paramLong);

  public abstract boolean handleGroupMessageLikeAck(long paramLong);

  public abstract boolean handleIsOnline(String paramString);

  public abstract void handleNetworkError(int paramInt, boolean paramBoolean);

  public abstract boolean handleOnClick(String paramString1, String paramString2, int paramInt1, int paramInt2);

  public abstract boolean handleRecanonizeAck(String paramString);

  public abstract boolean handleReportBannerStatistics(long paramLong, int paramInt, String paramString);

  public abstract boolean handleReportCdr(Cdr paramCdr);

  public abstract boolean handleReportForwardPublicGroupContentStatistics(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);

  public abstract boolean handleReportGenericPushStatistics(long paramLong, int paramInt1, int paramInt2, String paramString);

  public abstract boolean handleReportPurchaseErrorStatistics(String paramString, int paramInt);

  public abstract boolean handleReportSO(String paramString);

  public abstract boolean handleReportWatchActivationStatistics(String paramString1, String paramString2, int paramInt, String paramString3);

  public abstract boolean handleReportWatchDailyStatistics(String paramString1, String paramString2, int paramInt, long paramLong, String paramString3);

  public abstract boolean handleSecondaryRegisteredAck(long paramLong);

  public abstract boolean handleSecureTokenRequest(int paramInt);

  public abstract boolean handleSendContactSavedNotification(String paramString, int paramInt);

  public abstract void handleSendGroupChangedAck(long paramLong, boolean paramBoolean);

  public abstract void handleSendMessageDeliveredAck(long paramLong);

  public abstract void handleSendMessageReplyAck(long paramLong);

  public abstract boolean handleSendMissedCallsAck(long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt);

  public abstract boolean handleSendQueryDestOperationSupport(int paramInt, String paramString, long paramLong);

  public abstract boolean handleSendSyncConversationAck(String paramString, long paramLong, int paramInt);

  public abstract boolean handleSendSyncGroupAck(long paramLong1, long paramLong2, int paramInt);

  public abstract boolean handleSendSyncMessagesAck(long[] paramArrayOfLong1, long[] paramArrayOfLong2);

  public abstract boolean handleSendUpdateSelfUserDetailsAck(long paramLong);

  public abstract boolean handleSendUpdateUnsavedContactDetailsAck(long paramLong);

  public abstract void handleSendViberOutBalanceChangeAck(long paramLong);

  public abstract void handleSendWebNotificationAck(long paramLong);

  public abstract boolean handleSetCanonizationRules(String paramString);

  public abstract void handleSetLocation(LocationEx paramLocationEx);

  public abstract boolean handleShareDeltaAddressBook(CContactInfo[] paramArrayOfCContactInfo1, CContactInfo[] paramArrayOfCContactInfo2, String[] paramArrayOfString, int paramInt1, int paramInt2);

  public abstract boolean handleShareFullAddressBook(CContactInfo[] paramArrayOfCContactInfo, int paramInt);

  public abstract boolean handleShareSecondaryContact(CContactInfo paramCContactInfo, int paramInt);

  public abstract void handleShareSecondaryContactAck(long paramLong);

  public abstract boolean handleSyncConversation(String paramString, long paramLong, int paramInt1, int paramInt2);

  public abstract String handleSyncDataFromMyOtherDevicePreview(String paramString);

  public abstract void handleSyncDataFromOtherDeviceAck(long paramLong);

  public abstract boolean handleSyncDataToMyDevices(String paramString, int paramInt1, long paramLong, int paramInt2);

  public abstract boolean handleSyncDeletedMessages(ConversationToken[] paramArrayOfConversationToken, GroupToken[] paramArrayOfGroupToken, int paramInt);

  public abstract boolean handleSyncGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString);

  public abstract boolean handleUpdateBadge(int paramInt);

  public abstract void handleUpdateClientConfiguration(String paramString);

  public abstract boolean handleUpdateUserName(String paramString);

  public abstract boolean handleUpdateUserPhoto(long paramLong);

  public abstract boolean isConnected();

  public abstract boolean isGroupSecure(long paramLong);

  public abstract boolean isPublicAccountId(String paramString);

  public abstract boolean isRakutenPhone(String paramString);

  public abstract boolean isShortStandardBackgroundID(String paramString);

  public abstract boolean isVideoSupported();

  public abstract int lengthenStandartBackgroundID(String paramString, String[] paramArrayOfString);

  public abstract void notifyActivityOnForeground(boolean paramBoolean);

  public abstract void requestShutdown();

  public abstract void resetDeviceKey();

  public abstract void setDeviceKey(byte[] paramArrayOfByte);

  public abstract int setDeviceOrientation(int paramInt1, int paramInt2, int paramInt3);

  public abstract void setEnableVideo(boolean paramBoolean);

  public abstract void setPixieMode(int paramInt);

  public abstract int shortenStandardBackgroundID(String paramString, long[] paramArrayOfLong);

  public abstract void testConnection(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.controller.PhoneController
 * JD-Core Version:    0.6.2
 */