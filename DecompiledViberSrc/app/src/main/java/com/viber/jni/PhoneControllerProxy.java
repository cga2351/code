package com.viber.jni;

import com.viber.dexshared.Logger;
import com.viber.jni.cdr.Cdr;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.controller.PhoneControllerCaller;
import com.viber.jni.controller.PhoneControllerCaller.MultiCallerCallback;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;

class PhoneControllerProxy extends PhoneControllerCaller<PhoneController>
  implements PhoneController
{
  private static final Logger L = ViberEnv.getLogger();
  private Engine mEngine;
  private EngineBackend mEngineBackend;

  PhoneControllerProxy(Engine paramEngine, EngineBackend paramEngineBackend)
  {
    super(paramEngineBackend, paramEngineBackend);
    this.mEngine = paramEngine;
    this.mEngineBackend = paramEngineBackend;
  }

  public String canonizePhoneNumber(String paramString)
  {
    if (da.a(paramString))
      return "";
    return this.mEngineBackend.canonizePhoneNumber(paramString);
  }

  public String canonizePhoneNumberForCountryCode(int paramInt, String paramString)
  {
    return this.mEngineBackend.canonizePhoneNumberForCountryCode(paramInt, paramString);
  }

  public void changePhoneNumberInfo(int paramInt, String paramString1, String paramString2)
  {
    this.mEngineBackend.changePhoneNumberInfo(paramInt, paramString1, paramString2);
  }

  public int changeUDID(byte[] paramArrayOfByte)
  {
    return this.mEngineBackend.changeUDID(paramArrayOfByte);
  }

  public void connect()
  {
    this.mEngineBackend.connect();
  }

  public int connectivityTest(IVoipServiceConnectivityTestCallback paramIVoipServiceConnectivityTestCallback)
  {
    return this.mEngineBackend.connectivityTest(paramIVoipServiceConnectivityTestCallback);
  }

  @Deprecated
  public void crashLibrary()
  {
    this.mEngineBackend.crashLibrary();
  }

  public void disconnect()
  {
    this.mEngineBackend.disconnect();
  }

  public int done()
  {
    return this.mEngineBackend.done();
  }

  public String encodeCurrency(String paramString1, String paramString2)
  {
    return this.mEngineBackend.encodeCurrency(paramString1, paramString2);
  }

  public int generateSequence()
  {
    int i = this.mEngineBackend.generateSequence();
    if (i > 0)
      return i;
    return (int)(System.currentTimeMillis() / 1000L);
  }

  public int getBICC(String paramString)
  {
    return this.mEngineBackend.getBICC(paramString);
  }

  public int getCountryCode(String paramString)
  {
    return this.mEngineBackend.getCountryCode(paramString);
  }

  public CountryNameInfo getCountryName(String paramString)
  {
    return this.mEngineBackend.getCountryName(paramString);
  }

  public int getDefaultProtocolVersion()
  {
    return this.mEngineBackend.getDefaultProtocolVersion();
  }

  public String getDownloadURL(String paramString1, String paramString2, String paramString3)
  {
    return this.mEngineBackend.getDownloadURL(paramString1, paramString2, paramString3);
  }

  public String getExternalAppPhone(int paramInt)
  {
    return this.mEngineBackend.getExternalAppPhone(paramInt);
  }

  public int getFileOwnerUid(String paramString)
  {
    return this.mEngineBackend.getFileOwnerUid(paramString);
  }

  public String getHashForReRegister(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return this.mEngineBackend.getHashForReRegister(paramArrayOfByte1, paramArrayOfByte2);
  }

  public long getMyCID()
  {
    return this.mEngineBackend.getMyCID();
  }

  public long getMyVersion()
  {
    return this.mEngineBackend.getMyVersion();
  }

  public String getPGDownloadURL(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return this.mEngineBackend.getPGDownloadURL(paramString1, paramString2, paramString3, paramInt);
  }

  public String getPhoneProvider(String paramString)
  {
    return this.mEngineBackend.getPhoneProvider(paramString);
  }

  public long getPhoneType()
  {
    return this.mEngineBackend.getPhoneType();
  }

  public String getPhotoDownloadURL(String paramString1, String paramString2, int paramInt)
  {
    return this.mEngineBackend.getPhotoDownloadURL(paramString1, paramString2, paramInt);
  }

  public void handleAddToConferenceCall(String paramString)
  {
    this.mEngineBackend.handleAddToConferenceCall(paramString);
  }

  public void handleAppModeChanged(int paramInt)
  {
    if (this.mEngine.isInitialized())
      this.mEngineBackend.handleAppModeChanged(paramInt);
  }

  public boolean handleBlockGroupInvite(long paramLong, boolean paramBoolean, int paramInt)
  {
    return this.mEngineBackend.handleBlockGroupInvite(paramLong, paramBoolean, paramInt);
  }

  public void handleBlockListByReason(BlockListInfo[] paramArrayOfBlockListInfo, int paramInt, boolean paramBoolean)
  {
    this.mEngineBackend.handleBlockListByReason(paramArrayOfBlockListInfo, paramInt, paramBoolean);
  }

  public boolean handleChangeConversationSettings(String paramString, ConversationSettings paramConversationSettings)
  {
    return this.mEngineBackend.handleChangeConversationSettings(paramString, paramConversationSettings);
  }

  public boolean handleChangeGroup(long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2)
  {
    return this.mEngineBackend.handleChangeGroup(paramLong1, paramString, paramLong2, paramInt1, paramInt2);
  }

  public boolean handleChangeGroupSettings(long paramLong, ConversationSettings paramConversationSettings)
  {
    return this.mEngineBackend.handleChangeGroupSettings(paramLong, paramConversationSettings);
  }

  public void handleCommError(int paramInt)
  {
    this.mEngineBackend.handleCommError(paramInt);
  }

  public void handleConnectReject(long paramLong, int paramInt)
  {
    this.mEngineBackend.handleConnectReject(paramLong, paramInt);
  }

  public void handleConnectivityChange(int paramInt)
  {
    this.mEngineBackend.handleConnectivityChange(paramInt);
  }

  public boolean handleCreateGroup(final int paramInt1, final String[] paramArrayOfString, final String paramString, final long paramLong, int paramInt2, final int paramInt3)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleCreateGroup(paramInt1, paramArrayOfString, paramString, paramLong, paramInt3, this.val$timebombInSec);
      }
    });
  }

  public boolean handleCreateGroup2(int paramInt, String[] paramArrayOfString, String paramString1, long paramLong, String paramString2)
  {
    return this.mEngineBackend.handleCreateGroup2(paramInt, paramArrayOfString, paramString1, paramLong, paramString2);
  }

  public boolean handleCreatePublicAccount(int paramInt, String paramString1, LocationInfo paramLocationInfo, String paramString2, String paramString3, long paramLong1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString4, long paramLong2, boolean paramBoolean, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return this.mEngineBackend.handleCreatePublicAccount(paramInt, paramString1, paramLocationInfo, paramString2, paramString3, paramLong1, paramArrayOfString1, paramArrayOfString2, paramString4, paramLong2, paramBoolean, paramString5, paramString6, paramString7, paramString8);
  }

  public void handleDataInterruption(boolean paramBoolean)
  {
    this.mEngineBackend.handleDataInterruption(paramBoolean);
  }

  public boolean handleDeleteGroupMessage(long paramLong1, long paramLong2, int paramInt)
  {
    return this.mEngineBackend.handleDeleteGroupMessage(paramLong1, paramLong2, paramInt);
  }

  public boolean handleDeleteMessage(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    return this.mEngineBackend.handleDeleteMessage(paramString, paramLong, paramInt1, paramInt2);
  }

  public boolean handleDeletedMessageAck(long paramLong)
  {
    return this.mEngineBackend.handleDeletedMessageAck(paramLong);
  }

  public void handleGSMStateChange(int paramInt)
  {
    this.mEngineBackend.handleGSMStateChange(paramInt);
  }

  public boolean handleGeneralPGWSFormattedRequest(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    return this.mEngineBackend.handleGeneralPGWSFormattedRequest(paramInt, paramLong, paramString1, paramString2);
  }

  public boolean handleGetAppDetails(int[] paramArrayOfInt, int paramInt)
  {
    return this.mEngineBackend.handleGetAppDetails(paramArrayOfInt, paramInt);
  }

  public boolean handleGetBillingToken()
  {
    return this.mEngineBackend.handleGetBillingToken();
  }

  public long handleGetCallToken()
  {
    return this.mEngineBackend.handleGetCallToken();
  }

  public boolean handleGetGroupMessageStatus(long paramLong, int paramInt, CGroupMessageData[] paramArrayOfCGroupMessageData)
  {
    return this.mEngineBackend.handleGetGroupMessageStatus(paramLong, paramInt, paramArrayOfCGroupMessageData);
  }

  public String handleGetMySignature()
  {
    return this.mEngineBackend.handleGetMySignature();
  }

  public boolean handleGetPersonalProfile()
  {
    return this.mEngineBackend.handleGetPersonalProfile();
  }

  public boolean handleGetPublicAccountInfoAccountId(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mEngineBackend.handleGetPublicAccountInfoAccountId(paramInt1, paramString, paramInt2, paramInt3, paramInt4);
  }

  public boolean handleGetPublicAccountInfoChatId(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mEngineBackend.handleGetPublicAccountInfoChatId(paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
  }

  public boolean handleGetPublicAccountInfoChatUri(int paramInt, String paramString)
  {
    return this.mEngineBackend.handleGetPublicAccountInfoChatUri(paramInt, paramString);
  }

  public boolean handleGlobalDeleteMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return this.mEngineBackend.handleGlobalDeleteMessage(paramLong1, paramLong2, paramInt1, paramInt2);
  }

  public boolean handleGroupAddMember(long paramLong, String paramString, int paramInt)
  {
    return this.mEngineBackend.handleGroupAddMember(paramLong, paramString, paramInt);
  }

  public boolean handleGroupLeave(final long paramLong)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleGroupLeave(paramLong);
      }
    });
  }

  public boolean handleGroupMessageLikeAck(long paramLong)
  {
    return this.mEngineBackend.handleGroupMessageLikeAck(paramLong);
  }

  public boolean handleIsOnline(String paramString)
  {
    return this.mEngineBackend.handleIsOnline(paramString);
  }

  public void handleNetworkError(int paramInt, boolean paramBoolean)
  {
    this.mEngineBackend.handleNetworkError(paramInt, paramBoolean);
  }

  public boolean handleOnClick(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return this.mEngineBackend.handleOnClick(paramString1, paramString2, paramInt1, paramInt2);
  }

  public boolean handleRecanonizeAck(String paramString)
  {
    return this.mEngineBackend.handleRecanonizeAck(paramString);
  }

  public boolean handleReportBannerStatistics(long paramLong, int paramInt, String paramString)
  {
    return this.mEngineBackend.handleReportBannerStatistics(paramLong, paramInt, paramString);
  }

  public boolean handleReportCdr(Cdr paramCdr)
  {
    return this.mEngineBackend.handleReportCdr(paramCdr);
  }

  public boolean handleReportForwardPublicGroupContentStatistics(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return this.mEngineBackend.handleReportForwardPublicGroupContentStatistics(paramLong1, paramLong2, paramLong3, paramInt1, paramInt2, paramInt3, paramBoolean);
  }

  public boolean handleReportGenericPushStatistics(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    return this.mEngineBackend.handleReportGenericPushStatistics(paramLong, paramInt1, paramInt2, paramString);
  }

  public boolean handleReportPurchaseErrorStatistics(String paramString, int paramInt)
  {
    return this.mEngineBackend.handleReportPurchaseErrorStatistics(paramString, paramInt);
  }

  public boolean handleReportSO(String paramString)
  {
    return this.mEngineBackend.handleReportSO(paramString);
  }

  public boolean handleReportWatchActivationStatistics(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return this.mEngineBackend.handleReportWatchActivationStatistics(paramString1, paramString2, paramInt, paramString3);
  }

  public boolean handleReportWatchDailyStatistics(String paramString1, String paramString2, int paramInt, long paramLong, String paramString3)
  {
    return this.mEngineBackend.handleReportWatchDailyStatistics(paramString1, paramString2, paramInt, paramLong, paramString3);
  }

  public boolean handleSecondaryRegisteredAck(long paramLong)
  {
    return this.mEngineBackend.handleSecondaryRegisteredAck(paramLong);
  }

  public boolean handleSecureTokenRequest(int paramInt)
  {
    return this.mEngineBackend.handleSecureTokenRequest(paramInt);
  }

  public boolean handleSendContactSavedNotification(String paramString, int paramInt)
  {
    return this.mEngineBackend.handleSendContactSavedNotification(paramString, paramInt);
  }

  public void handleSendGroupChangedAck(long paramLong, boolean paramBoolean)
  {
    this.mEngineBackend.handleSendGroupChangedAck(paramLong, paramBoolean);
  }

  public void handleSendMessageDeliveredAck(long paramLong)
  {
    this.mEngineBackend.handleSendMessageDeliveredAck(paramLong);
  }

  public void handleSendMessageReplyAck(long paramLong)
  {
    this.mEngineBackend.handleSendMessageReplyAck(paramLong);
  }

  public boolean handleSendMissedCallsAck(final long[] paramArrayOfLong1, final long[] paramArrayOfLong2, final int[] paramArrayOfInt)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleSendMissedCallsAck(paramArrayOfLong1, paramArrayOfLong2, paramArrayOfInt);
      }
    });
  }

  public boolean handleSendQueryDestOperationSupport(int paramInt, String paramString, long paramLong)
  {
    return this.mEngineBackend.handleSendQueryDestOperationSupport(paramInt, paramString, paramLong);
  }

  public boolean handleSendSyncConversationAck(final String paramString, final long paramLong, int paramInt)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleSendSyncConversationAck(paramString, paramLong, this.val$multDevState);
      }
    });
  }

  public boolean handleSendSyncGroupAck(final long paramLong1, long paramLong2, final int paramInt)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleSendSyncGroupAck(paramLong1, paramInt, this.val$multDevState);
      }
    });
  }

  public boolean handleSendSyncMessagesAck(final long[] paramArrayOfLong1, final long[] paramArrayOfLong2)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleSendSyncMessagesAck(paramArrayOfLong1, paramArrayOfLong2);
      }
    });
  }

  public boolean handleSendUpdateSelfUserDetailsAck(final long paramLong)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleSendUpdateSelfUserDetailsAck(paramLong);
      }
    });
  }

  public boolean handleSendUpdateUnsavedContactDetailsAck(long paramLong)
  {
    return this.mEngineBackend.handleSendUpdateUnsavedContactDetailsAck(paramLong);
  }

  public void handleSendViberOutBalanceChangeAck(long paramLong)
  {
    this.mEngineBackend.handleSendViberOutBalanceChangeAck(paramLong);
  }

  public void handleSendWebNotificationAck(long paramLong)
  {
    this.mEngineBackend.handleSendWebNotificationAck(paramLong);
  }

  public boolean handleSetCanonizationRules(String paramString)
  {
    return this.mEngineBackend.handleSetCanonizationRules(paramString);
  }

  public void handleSetLocation(LocationEx paramLocationEx)
  {
    this.mEngineBackend.handleSetLocation(paramLocationEx);
  }

  public boolean handleShareDeltaAddressBook(CContactInfo[] paramArrayOfCContactInfo1, CContactInfo[] paramArrayOfCContactInfo2, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    return this.mEngineBackend.handleShareDeltaAddressBook(paramArrayOfCContactInfo1, paramArrayOfCContactInfo2, paramArrayOfString, paramInt1, paramInt2);
  }

  public boolean handleShareFullAddressBook(CContactInfo[] paramArrayOfCContactInfo, int paramInt)
  {
    return this.mEngineBackend.handleShareFullAddressBook(paramArrayOfCContactInfo, paramInt);
  }

  public boolean handleShareSecondaryContact(CContactInfo paramCContactInfo, int paramInt)
  {
    return this.mEngineBackend.handleShareSecondaryContact(paramCContactInfo, paramInt);
  }

  public void handleShareSecondaryContactAck(long paramLong)
  {
    this.mEngineBackend.handleShareSecondaryContactAck(paramLong);
  }

  public boolean handleSyncConversation(final String paramString, final long paramLong, int paramInt1, final int paramInt2)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleSyncConversation(paramString, paramLong, paramInt2, this.val$chatType);
      }
    });
  }

  public String handleSyncDataFromMyOtherDevicePreview(String paramString)
  {
    return this.mEngineBackend.handleSyncDataFromMyOtherDevicePreview(paramString);
  }

  public void handleSyncDataFromOtherDeviceAck(long paramLong)
  {
    this.mEngineBackend.handleSyncDataFromOtherDeviceAck(paramLong);
  }

  public boolean handleSyncDataToMyDevices(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.mEngineBackend.handleSyncDataToMyDevices(paramString, paramInt1, paramLong, paramInt2);
  }

  public boolean handleSyncDeletedMessages(final ConversationToken[] paramArrayOfConversationToken, final GroupToken[] paramArrayOfGroupToken, final int paramInt)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleSyncDeletedMessages(paramArrayOfConversationToken, paramArrayOfGroupToken, paramInt);
      }
    });
  }

  public boolean handleSyncGroup(final long paramLong1, long paramLong2, final int paramInt1, int paramInt2, final String[] paramArrayOfString)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleSyncGroup(paramLong1, paramInt1, paramArrayOfString, this.val$multDevState, this.val$senders);
      }
    });
  }

  public boolean handleUpdateBadge(int paramInt)
  {
    return this.mEngineBackend.handleUpdateBadge(paramInt);
  }

  public void handleUpdateClientConfiguration(String paramString)
  {
    this.mEngineBackend.handleUpdateClientConfiguration(paramString);
  }

  public boolean handleUpdateUserName(final String paramString)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleUpdateUserName(paramString);
      }
    });
  }

  public boolean handleUpdateUserPhoto(final long paramLong)
  {
    return multyMethodCall(new PhoneControllerCaller.MultiCallerCallback()
    {
      public boolean call(PhoneController paramAnonymousPhoneController)
      {
        return paramAnonymousPhoneController.handleUpdateUserPhoto(paramLong);
      }
    });
  }

  public boolean isConnected()
  {
    return this.mEngineBackend.isConnected();
  }

  public boolean isGroupSecure(long paramLong)
  {
    return this.mEngineBackend.isGroupSecure(paramLong);
  }

  public boolean isPublicAccountId(String paramString)
  {
    return this.mEngineBackend.isPublicAccountId(paramString);
  }

  @Deprecated
  public boolean isRakutenPhone(String paramString)
  {
    return this.mEngineBackend.isRakutenPhone(paramString);
  }

  public boolean isShortStandardBackgroundID(String paramString)
  {
    return this.mEngineBackend.isShortStandardBackgroundID(paramString);
  }

  public boolean isVideoSupported()
  {
    return this.mEngineBackend.isVideoSupported();
  }

  public int lengthenStandartBackgroundID(String paramString, String[] paramArrayOfString)
  {
    return this.mEngineBackend.lengthenStandartBackgroundID(paramString, paramArrayOfString);
  }

  public void notifyActivityOnForeground(boolean paramBoolean)
  {
  }

  public void requestShutdown()
  {
    this.mEngineBackend.requestShutdown();
  }

  public void resetDeviceKey()
  {
    this.mEngineBackend.resetDeviceKey();
  }

  public void setDeviceKey(byte[] paramArrayOfByte)
  {
    this.mEngineBackend.setDeviceKey(paramArrayOfByte);
  }

  public int setDeviceOrientation(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mEngineBackend.setDeviceOrientation(paramInt1, paramInt2, paramInt3);
  }

  public void setEnableVideo(boolean paramBoolean)
  {
    this.mEngineBackend.setEnableVideo(paramBoolean);
  }

  public void setPixieMode(int paramInt)
  {
    this.mEngineBackend.setPixieMode(paramInt);
  }

  public int shortenStandardBackgroundID(String paramString, long[] paramArrayOfLong)
  {
    return this.mEngineBackend.shortenStandardBackgroundID(paramString, paramArrayOfLong);
  }

  public void testConnection(int paramInt)
  {
    this.mEngineBackend.testConnection(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PhoneControllerProxy
 * JD-Core Version:    0.6.2
 */