package com.viber.jni;

import android.os.Bundle;
import com.viber.jni.memberid.CRegisteredContactInfo;
import java.util.Map;

public class PhoneControllerDelegateAdapter
  implements PhoneControllerDelegate
{
  public boolean IsGSMCallActive()
  {
    return false;
  }

  public boolean changePersistentKeys(String paramString, Bundle paramBundle)
  {
    return false;
  }

  public int getPersistentSecureValue(Bundle paramBundle)
  {
    return -1;
  }

  public int getPersistentValue(Bundle paramBundle)
  {
    return -1;
  }

  public void mapMemberIDs(String[] paramArrayOfString, Bundle paramBundle)
  {
  }

  public void mapPhoneNumbers(String[] paramArrayOfString, Bundle paramBundle)
  {
  }

  public boolean onAddressBookDeltaUpdate(CAddressBookEntry[] paramArrayOfCAddressBookEntry1, CAddressBookEntry[] paramArrayOfCAddressBookEntry2, String[] paramArrayOfString, int paramInt, long paramLong)
  {
    return false;
  }

  public boolean onAddressBookUpdate(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, CAddressBookEntry[] paramArrayOfCAddressBookEntry)
  {
    return false;
  }

  public void onBlockListReply(int paramInt)
  {
  }

  public void onBlockedStatus(String paramString)
  {
  }

  public void onCallMissed(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4, String[] paramArrayOfString, String paramString4, long paramLong2, long paramLong3)
  {
  }

  public void onChangeConversationSettingsReply(String paramString, ConversationSettings paramConversationSettings, int paramInt)
  {
  }

  public void onChangeGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void onChangeGroupSettingsReply(long paramLong, ConversationSettings paramConversationSettings, int paramInt)
  {
  }

  public void onClickReply(int paramInt1, int paramInt2)
  {
  }

  public void onCommError(int paramInt)
  {
  }

  public void onDebugInfo(int paramInt, String paramString1, String paramString2)
  {
  }

  public void onEnableGSMCall(boolean paramBoolean)
  {
  }

  public void onEnableVOReferrallProgram(boolean paramBoolean)
  {
  }

  public void onGSMCallStateChanged(int paramInt, boolean paramBoolean)
  {
  }

  public void onGSMStateChange(int paramInt, String paramString)
  {
  }

  public void onGetBillingToken(long paramLong, String paramString)
  {
  }

  public boolean onGetMissedCalls(CMissedCall[] paramArrayOfCMissedCall)
  {
    return false;
  }

  public void onGetPersonalProfile(int paramInt, long paramLong, String paramString)
  {
  }

  public void onGlobalDeleteMessageReply(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
  }

  public void onGroupAddMembers(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String[] paramArrayOfString, Map<String, Integer> paramMap, int paramInt3, int paramInt4)
  {
  }

  public boolean onGroupChanged(long paramLong1, String paramString1, long paramLong2, int paramInt1, long paramLong3, String paramString2, String paramString3, int paramInt2, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, String paramString4)
  {
    return false;
  }

  public void onGroupLeave(long paramLong1, long paramLong2, int paramInt)
  {
  }

  public boolean onGroupMessageDelivered(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return false;
  }

  public boolean onHandleSelfDetails(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return false;
  }

  public void onIsOnlineReply(String paramString, boolean paramBoolean)
  {
  }

  public void onKeepaliveReply()
  {
  }

  public void onLBServerTime(long paramLong)
  {
  }

  public boolean onMessageDelivered(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return false;
  }

  public boolean onMessageStateUpdate(long paramLong, int paramInt)
  {
    return false;
  }

  public void onOpenMarket()
  {
  }

  public void onPublicGroupsUpdated(PGLatestParamsWithRole[] paramArrayOfPGLatestParamsWithRole, long paramLong, Group2LatestParams[] paramArrayOfGroup2LatestParams)
  {
  }

  public void onRecanonize(String paramString)
  {
  }

  public boolean onRegisteredNumbers(boolean paramBoolean1, boolean paramBoolean2, CRegisteredContactInfo[] paramArrayOfCRegisteredContactInfo, int paramInt1, long paramLong, int paramInt2)
  {
    return false;
  }

  public boolean onSecondaryRegistered(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }

  public void onSendMessageReply(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
  }

  public void onShareAddressBook()
  {
  }

  public void onShareAddressBookReply(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onShareAddressBookReplyOld(boolean paramBoolean, int paramInt1, int paramInt2)
  {
  }

  public boolean onShareSecondaryContact(CContactInfo paramCContactInfo, long paramLong)
  {
    return false;
  }

  public void onShareSecondaryContactReply(int paramInt1, int paramInt2)
  {
  }

  public void onShouldRegister()
  {
  }

  public void onSignal(String paramString, int paramInt)
  {
  }

  public boolean onUnregisteredNumber(String paramString, int paramInt)
  {
    return false;
  }

  public boolean onUpdateUnsavedContactDetails(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    return false;
  }

  public void onUpdateUserName(int paramInt)
  {
  }

  public void onUpdateUserPhoto(int paramInt)
  {
  }

  public void onValidatePublicGroupUri(String paramString, int paramInt1, int paramInt2)
  {
  }

  public boolean onViberOutBalanceChange(long paramLong)
  {
    return false;
  }

  public boolean onWebNotification(long paramLong, String paramString)
  {
    return false;
  }

  public void playTone(int paramInt)
  {
  }

  public int removeAllPersistentSecureValues(String paramString)
  {
    return -1;
  }

  public int setPersistentSecureValue(String paramString1, String paramString2, String paramString3)
  {
    return -1;
  }

  public int setPersistentValue(String paramString1, String paramString2)
  {
    return -1;
  }

  public void stopTone()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PhoneControllerDelegateAdapter
 * JD-Core Version:    0.6.2
 */