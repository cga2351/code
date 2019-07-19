package com.viber.jni;

import android.os.Bundle;
import com.viber.jni.memberid.CRegisteredContactInfo;
import java.util.Map;

public abstract interface PhoneControllerDelegate
{
  public abstract boolean IsGSMCallActive();

  public abstract boolean changePersistentKeys(String paramString, Bundle paramBundle);

  public abstract int getPersistentSecureValue(Bundle paramBundle);

  public abstract int getPersistentValue(Bundle paramBundle);

  public abstract void mapMemberIDs(String[] paramArrayOfString, Bundle paramBundle);

  public abstract void mapPhoneNumbers(String[] paramArrayOfString, Bundle paramBundle);

  public abstract boolean onAddressBookDeltaUpdate(CAddressBookEntry[] paramArrayOfCAddressBookEntry1, CAddressBookEntry[] paramArrayOfCAddressBookEntry2, String[] paramArrayOfString, int paramInt, long paramLong);

  public abstract boolean onAddressBookUpdate(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, CAddressBookEntry[] paramArrayOfCAddressBookEntry);

  public abstract void onBlockListReply(int paramInt);

  public abstract void onBlockedStatus(String paramString);

  public abstract void onCallMissed(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4, String[] paramArrayOfString, String paramString4, long paramLong2, long paramLong3);

  public abstract void onChangeConversationSettingsReply(String paramString, ConversationSettings paramConversationSettings, int paramInt);

  public abstract void onChangeGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract void onChangeGroupSettingsReply(long paramLong, ConversationSettings paramConversationSettings, int paramInt);

  public abstract void onClickReply(int paramInt1, int paramInt2);

  public abstract void onCommError(int paramInt);

  public abstract void onDebugInfo(int paramInt, String paramString1, String paramString2);

  public abstract void onEnableGSMCall(boolean paramBoolean);

  public abstract void onEnableVOReferrallProgram(boolean paramBoolean);

  public abstract void onGSMCallStateChanged(int paramInt, boolean paramBoolean);

  public abstract void onGSMStateChange(int paramInt, String paramString);

  public abstract void onGetBillingToken(long paramLong, String paramString);

  public abstract boolean onGetMissedCalls(CMissedCall[] paramArrayOfCMissedCall);

  public abstract void onGetPersonalProfile(int paramInt, long paramLong, String paramString);

  public abstract void onGlobalDeleteMessageReply(long paramLong1, long paramLong2, int paramInt1, int paramInt2);

  public abstract void onGroupAddMembers(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String[] paramArrayOfString, Map<String, Integer> paramMap, int paramInt3, int paramInt4);

  public abstract boolean onGroupChanged(long paramLong1, String paramString1, long paramLong2, int paramInt1, long paramLong3, String paramString2, String paramString3, int paramInt2, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, String paramString4);

  public abstract void onGroupLeave(long paramLong1, long paramLong2, int paramInt);

  public abstract boolean onGroupMessageDelivered(long paramLong1, long paramLong2, String paramString, long paramLong3);

  public abstract boolean onHandleSelfDetails(long paramLong, String paramString1, String paramString2, int paramInt);

  public abstract void onIsOnlineReply(String paramString, boolean paramBoolean);

  public abstract void onKeepaliveReply();

  public abstract void onLBServerTime(long paramLong);

  public abstract boolean onMessageDelivered(long paramLong1, long paramLong2, int paramInt1, int paramInt2);

  public abstract boolean onMessageStateUpdate(long paramLong, int paramInt);

  public abstract void onOpenMarket();

  public abstract void onPublicGroupsUpdated(PGLatestParamsWithRole[] paramArrayOfPGLatestParamsWithRole, long paramLong, Group2LatestParams[] paramArrayOfGroup2LatestParams);

  public abstract void onRecanonize(String paramString);

  public abstract boolean onRegisteredNumbers(boolean paramBoolean1, boolean paramBoolean2, CRegisteredContactInfo[] paramArrayOfCRegisteredContactInfo, int paramInt1, long paramLong, int paramInt2);

  public abstract boolean onSecondaryRegistered(long paramLong, int paramInt1, int paramInt2, int paramInt3);

  public abstract void onSendMessageReply(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString);

  public abstract void onShareAddressBook();

  public abstract void onShareAddressBookReply(int paramInt1, int paramInt2, int paramInt3);

  public abstract void onShareAddressBookReplyOld(boolean paramBoolean, int paramInt1, int paramInt2);

  public abstract boolean onShareSecondaryContact(CContactInfo paramCContactInfo, long paramLong);

  public abstract void onShareSecondaryContactReply(int paramInt1, int paramInt2);

  public abstract void onShouldRegister();

  public abstract void onSignal(String paramString, int paramInt);

  public abstract boolean onUnregisteredNumber(String paramString, int paramInt);

  public abstract boolean onUpdateUnsavedContactDetails(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);

  public abstract void onUpdateUserName(int paramInt);

  public abstract void onUpdateUserPhoto(int paramInt);

  public abstract void onValidatePublicGroupUri(String paramString, int paramInt1, int paramInt2);

  public abstract boolean onViberOutBalanceChange(long paramLong);

  public abstract boolean onWebNotification(long paramLong, String paramString);

  public abstract void playTone(int paramInt);

  public abstract int removeAllPersistentSecureValues(String paramString);

  public abstract int setPersistentSecureValue(String paramString1, String paramString2, String paramString3);

  public abstract int setPersistentValue(String paramString1, String paramString2);

  public abstract void stopTone();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PhoneControllerDelegate
 * JD-Core Version:    0.6.2
 */