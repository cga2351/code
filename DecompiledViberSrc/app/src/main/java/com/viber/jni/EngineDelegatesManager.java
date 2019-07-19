package com.viber.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import com.viber.a.a;
import com.viber.common.b.g;
import com.viber.dexshared.Logger;
import com.viber.jni.apps.AppDetailsReceiverListener;
import com.viber.jni.apps.AppsAuthentucatorListener;
import com.viber.jni.apps.AppsBlockerListener;
import com.viber.jni.apps.AppsControllerDelegate.AppsDelegate;
import com.viber.jni.apps.AppsSupportListener;
import com.viber.jni.apps.AppsUserAppsReceiverListener;
import com.viber.jni.banner.BannerDelegate;
import com.viber.jni.banner.BannerListener;
import com.viber.jni.block.BlockControllerDelegate.BlockDelegate;
import com.viber.jni.block.BlockPgInvitesListener;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.desktop.HasDesktopDelegate;
import com.viber.jni.desktop.HasDesktopListener;
import com.viber.jni.dialer.DialerCallInterruptionListener;
import com.viber.jni.dialer.DialerCallbackListener;
import com.viber.jni.dialer.DialerControllerDelegate.DialerDelegate;
import com.viber.jni.dialer.DialerEndScreenListener;
import com.viber.jni.dialer.DialerHoldStateListener;
import com.viber.jni.dialer.DialerIncomingScreenListener;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.jni.dialer.DialerMuteStateListener;
import com.viber.jni.dialer.DialerOutgoingScreenListener;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.jni.dialer.DialerRemoteCallStateListener;
import com.viber.jni.dialer.DialerTransferCallListener;
import com.viber.jni.dialer.DialerVideoListener;
import com.viber.jni.gcm.RegisterDelegate;
import com.viber.jni.gcm.RegisterListener;
import com.viber.jni.group.GroupAssignRoleListener;
import com.viber.jni.group.GroupControllerDelegate.GroupDelegate;
import com.viber.jni.group.GroupCreateListener;
import com.viber.jni.group.GroupInfoListener;
import com.viber.jni.im2.Im2JniReceiver;
import com.viber.jni.language.LanguageUpdateDelegate;
import com.viber.jni.language.LanguageUpdateListener;
import com.viber.jni.lastonline.LastOnlineDelegate;
import com.viber.jni.lastonline.LastOnlineListener;
import com.viber.jni.like.GroupLikesListener;
import com.viber.jni.like.LikeControllerDelegate.LikeDelegate;
import com.viber.jni.like.PublicGroupLikesListener;
import com.viber.jni.location.ViberLocationDelegate;
import com.viber.jni.location.ViberLocationListener;
import com.viber.jni.memberid.CRegisteredContactInfo;
import com.viber.jni.memberid.PhoneNumberToMidInfo;
import com.viber.jni.memberid.UsersMemberIdsMigrationDelegate;
import com.viber.jni.memberid.UsersMembersIdsMigrationListener;
import com.viber.jni.messenger.DeleteMessageListener;
import com.viber.jni.messenger.FormattedReceiverListener;
import com.viber.jni.messenger.GroupMessageStatusListener;
import com.viber.jni.messenger.MediaReceiverListener;
import com.viber.jni.messenger.MessageSenderListener;
import com.viber.jni.messenger.MessengerDelegate.DeleteMessages;
import com.viber.jni.messenger.MessengerDelegate.FormattedReceiver;
import com.viber.jni.messenger.MessengerDelegate.GroupMessageStatusReply;
import com.viber.jni.messenger.MessengerDelegate.MessagesReceiver;
import com.viber.jni.messenger.MessengerDelegate.RecentMessagesEnded;
import com.viber.jni.messenger.MessengerDelegate.SyncReceiver;
import com.viber.jni.messenger.PttReceiverListener;
import com.viber.jni.messenger.RecentMessagesEndedListener;
import com.viber.jni.messenger.SyncConversationsListener;
import com.viber.jni.messenger.SyncConversationsReplyListener;
import com.viber.jni.messenger.SyncMessagesListener;
import com.viber.jni.messenger.SyncMessagesReplyListener;
import com.viber.jni.messenger.TextReceiverListener;
import com.viber.jni.messenger.VideoReceiverListener;
import com.viber.jni.mustupgrade.MustUpgradeDelegate;
import com.viber.jni.mustupgrade.MustUpgradeListener;
import com.viber.jni.ptt.VideoPttControllerDelegate.VideoPttDelegate;
import com.viber.jni.ptt.VideoPttPlayerListener;
import com.viber.jni.ptt.VideoPttRecorderListener;
import com.viber.jni.publicaccount.PublicAccountCallbackListener;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountConversationStatusReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountDelegate;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountInfoReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountRefreshTokenReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountSearchReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountSubscribersCountReceiver;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountSubscriptionStatusReceiver;
import com.viber.jni.publicaccount.PublicAccountConversationStatusListener;
import com.viber.jni.publicaccount.PublicAccountFieldValidatorListener;
import com.viber.jni.publicaccount.PublicAccountInfoReceiverListener;
import com.viber.jni.publicaccount.PublicAccountRefreshTokenListener;
import com.viber.jni.publicaccount.PublicAccountSearchListener;
import com.viber.jni.publicaccount.PublicAccountSubscribersCountListener;
import com.viber.jni.publicaccount.PublicAccountSubscriptionStatusListener;
import com.viber.jni.publicgroup.PgAction;
import com.viber.jni.publicgroup.PublicChatsEnabledListener;
import com.viber.jni.publicgroup.PublicGroupControllerDelegate.EnabledDelegate;
import com.viber.jni.publicgroup.PublicGroupControllerDelegate.PublicGroupDelegate;
import com.viber.jni.publicgroup.PublicGroupGetMessagesListener;
import com.viber.jni.publicgroup.PublicGroupInviteSendListener;
import com.viber.jni.remoteconfig.RemoteConfigDelegate;
import com.viber.jni.remoteconfig.RemoteConfigListener;
import com.viber.jni.secure.DeviceManagerDelegate;
import com.viber.jni.secure.DeviceManagerListener;
import com.viber.jni.secure.MustSecureDelegate;
import com.viber.jni.secure.MustSecureListener;
import com.viber.jni.secure.QueryDestOperationSupportDelegate;
import com.viber.jni.secure.QueryDestOperationSupportListener;
import com.viber.jni.secure.SecureMessagesDelegate;
import com.viber.jni.secure.SecureMessagesListener;
import com.viber.jni.secure.SecurePrimaryActivationDelegate;
import com.viber.jni.secure.SecurePrimaryActivationListener;
import com.viber.jni.secure.SecureSecondaryActivationDelegate;
import com.viber.jni.secure.SecureSecondaryActivationListener;
import com.viber.jni.secure.SecureTokenDelegate;
import com.viber.jni.secure.SecureTokenListener;
import com.viber.jni.secure.SecurityAvailableDelegate;
import com.viber.jni.secure.SecurityAvailableListener;
import com.viber.jni.secure.TrustPeerCallsListener;
import com.viber.jni.secure.TrustPeerDelegate.CallsDelegate;
import com.viber.jni.secure.TrustPeerDelegate.MessagesDelegate;
import com.viber.jni.secure.TrustPeerMessagesListener;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateListener;
import com.viber.jni.settings.SettingsControllerDelegate;
import com.viber.jni.settings.SettingsListener;
import com.viber.jni.spam.BlockedUserSplashListener;
import com.viber.jni.spam.SpamControllerDelegate;
import com.viber.jni.spam.SpamControllerListener;
import com.viber.jni.spam.UnknownNumberSaveDelegate;
import com.viber.jni.spam.UnknownNumberSaveListener;
import com.viber.jni.userdata.UserInfoDelegate;
import com.viber.jni.viberid.ViberIdVersionDelegate;
import com.viber.jni.viberid.ViberIdVersionListener;
import com.viber.jni.viberout.ViberOutBalanceDelegate;
import com.viber.jni.viberout.ViberOutBalanceListener;
import com.viber.jni.wallet.WalletControllerDelegate;
import com.viber.jni.wallet.WalletControllerListener;
import com.viber.jni.webrtc.IceCandidate;
import com.viber.jni.webrtc.ProcessedCallback;
import com.viber.jni.webrtc.SdpProcessedCallback;
import com.viber.jni.webrtc.WebRtcDelegate;
import com.viber.jni.webrtc.WebRtcListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.a.b;
import com.viber.voip.util.dq;
import java.nio.ByteBuffer;
import java.util.Map;

public class EngineDelegatesManager extends ControllerListener<PhoneControllerDelegate>
  implements DeprecatedDelegate, PgGeneralQueryReplyDelegate, PhoneControllerDelegate, AppsControllerDelegate.AppsDelegate, BannerDelegate, BlockControllerDelegate.BlockDelegate, ConnectionDelegate, HasDesktopDelegate, DialerControllerDelegate.DialerDelegate, RegisterDelegate, GroupControllerDelegate.GroupDelegate, Im2JniReceiver, LanguageUpdateDelegate, LastOnlineDelegate, LikeControllerDelegate.LikeDelegate, ViberLocationDelegate, UsersMemberIdsMigrationDelegate, MessengerDelegate.DeleteMessages, MessengerDelegate.FormattedReceiver, MessengerDelegate.GroupMessageStatusReply, MessengerDelegate.MessagesReceiver, MessengerDelegate.RecentMessagesEnded, MessengerDelegate.SyncReceiver, MustUpgradeDelegate, VideoPttControllerDelegate.VideoPttDelegate, PublicAccountControllerDelegate.PublicAccountConversationStatusReceiver, PublicAccountControllerDelegate.PublicAccountDelegate, PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver, PublicAccountControllerDelegate.PublicAccountInfoReceiver, PublicAccountControllerDelegate.PublicAccountRefreshTokenReceiver, PublicAccountControllerDelegate.PublicAccountSearchReceiver, PublicAccountControllerDelegate.PublicAccountSubscribersCountReceiver, PublicAccountControllerDelegate.PublicAccountSubscriptionStatusReceiver, PublicGroupControllerDelegate.EnabledDelegate, PublicGroupControllerDelegate.PublicGroupDelegate, RemoteConfigDelegate, DeviceManagerDelegate, MustSecureDelegate, QueryDestOperationSupportDelegate, SecureMessagesDelegate, SecurePrimaryActivationDelegate, SecureSecondaryActivationDelegate, SecureTokenDelegate, SecurityAvailableDelegate, TrustPeerDelegate.CallsDelegate, TrustPeerDelegate.MessagesDelegate, ServiceStateDelegate, SettingsControllerDelegate, SpamControllerDelegate, UnknownNumberSaveDelegate, UserInfoDelegate, ViberIdVersionDelegate, ViberOutBalanceDelegate, WalletControllerDelegate, WebRtcDelegate
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int LOGGER_FABRIC = 45000;
  public static final String SECURE_CATEGORY_PREFIX = "VLIB_INNER_";
  private static final String[] onConnectionStatesStr = { "Disconnected", "Connecting", "Failed connect", "Connected" };
  AppDetailsReceiverListener mAppDetailsReceiverListener = new AppDetailsReceiverListener();
  AppsAuthentucatorListener mAppsAuthentucatorListener = new AppsAuthentucatorListener();
  AppsBlockerListener mAppsBlockerListener = new AppsBlockerListener();
  AppsSupportListener mAppsSupportListener = new AppsSupportListener();
  AppsUserAppsReceiverListener mAppsUserAppsReceiverListener = new AppsUserAppsReceiverListener();
  BannerListener mBannerListener = new BannerListener();
  BlockPgInvitesListener mBlockPgInvitesListener = new BlockPgInvitesListener();
  BlockedUserSplashListener mBlockedUserSplashListener = new BlockedUserSplashListener();
  ConnectionListener mConnectionListener = new ConnectionListener();
  DeleteMessageListener mDeleteMessageListener = new DeleteMessageListener();
  DeviceManagerListener mDeviceManagerListener = new DeviceManagerListener();
  DialerCallInterruptionListener mDialerCallInterruptionListener = new DialerCallInterruptionListener();
  DialerCallbackListener mDialerCallbackListener = new DialerCallbackListener();
  DialerEndScreenListener mDialerEndScreenListener = new DialerEndScreenListener();
  DialerHoldStateListener mDialerHoldStateListener = new DialerHoldStateListener();
  DialerIncomingScreenListener mDialerIncomingScreenListener = new DialerIncomingScreenListener();
  DialerLocalCallStateListener mDialerLocalCallStateListener = new DialerLocalCallStateListener();
  DialerMuteStateListener mDialerMuteStateListener = new DialerMuteStateListener();
  DialerOutgoingScreenListener mDialerOutgoingScreenListener = new DialerOutgoingScreenListener();
  DialerPhoneStateListener mDialerPhoneStateListener = new DialerPhoneStateListener();
  DialerRemoteCallStateListener mDialerRemoteCallStateListener = new DialerRemoteCallStateListener();
  DialerTransferCallListener mDialerTransferCall = new DialerTransferCallListener();
  DialerVideoListener mDialerVideoListener = new DialerVideoListener();
  GroupAssignRoleListener mGroupAssignRoleListener = new GroupAssignRoleListener();
  GroupCreateListener mGroupCreateListener = new GroupCreateListener();
  GroupInfoListener mGroupInfoListener = new GroupInfoListener();
  GroupLikesListener mGroupLikesListener = new GroupLikesListener();
  GroupMessageStatusListener mGroupMessageStatusListener = new GroupMessageStatusListener();
  HasDesktopListener mHasDesktopListener = new HasDesktopListener();
  Im2JniReceiver mIm2JniReceiver;
  LanguageUpdateListener mLanguageUpdateListener = new LanguageUpdateListener();
  LastOnlineListener mLastOnlineListener = new LastOnlineListener();
  MessageSenderListener mMessageSenderListener = new MessageSenderListener();
  FormattedReceiverListener mMessengerFormattedReceiverListener = new FormattedReceiverListener();
  MediaReceiverListener mMessengerMediaReceiverListener = new MediaReceiverListener();
  PttReceiverListener mMessengerPttReceiverListener = new PttReceiverListener();
  RecentMessagesEndedListener mMessengerRecentMessagesEnded = new RecentMessagesEndedListener();
  TextReceiverListener mMessengerTextReceiverListener = new TextReceiverListener();
  VideoReceiverListener mMessengerVideoReceiverListener = new VideoReceiverListener();
  MustSecureListener mMustSecureListener = new MustSecureListener();
  MustUpgradeListener mMustUpgradeListener = new MustUpgradeListener();
  PgGeneralQueryReplyListener mPgGeneralQueryReplyListener = new PgGeneralQueryReplyListener();
  PublicAccountCallbackListener mPublicAccountCallbackListener = new PublicAccountCallbackListener();
  PublicAccountConversationStatusListener mPublicAccountConversationStatusListener = new PublicAccountConversationStatusListener();
  PublicAccountFieldValidatorListener mPublicAccountFieldValidatorListener = new PublicAccountFieldValidatorListener();
  PublicAccountInfoReceiverListener mPublicAccountInfoReceiverListener = new PublicAccountInfoReceiverListener();
  PublicAccountRefreshTokenListener mPublicAccountRefreshTokenListener = new PublicAccountRefreshTokenListener();
  PublicAccountSearchListener mPublicAccountSearchListener = new PublicAccountSearchListener();
  PublicAccountSubscribersCountListener mPublicAccountSubscribersCountListener = new PublicAccountSubscribersCountListener();
  PublicAccountSubscriptionStatusListener mPublicAccountSubscriptionStatusListener = new PublicAccountSubscriptionStatusListener();
  PublicChatsEnabledListener mPublicChatsEnabledListener = new PublicChatsEnabledListener();
  PublicGroupGetMessagesListener mPublicGroupGetMessagesListener = new PublicGroupGetMessagesListener();
  PublicGroupInviteSendListener mPublicGroupInviteSendListener = new PublicGroupInviteSendListener();
  PublicGroupLikesListener mPublicGroupLikesListener = new PublicGroupLikesListener();
  QueryDestOperationSupportListener mQueryDestOperationSupportListener = new QueryDestOperationSupportListener();
  RegisterListener mRegisterListener = new RegisterListener();
  RemoteConfigListener mRemoteConfigListener = new RemoteConfigListener();
  SecureMessagesListener mSecureMessagesListener = new SecureMessagesListener();
  SecurePrimaryActivationListener mSecurePrimaryActivationListener = new SecurePrimaryActivationListener();
  SecureSecondaryActivationListener mSecureSecondaryActivationListener = new SecureSecondaryActivationListener();
  SecureTokenListener mSecureTokenListener = new SecureTokenListener();
  SecurityAvailableListener mSecurityAvailableListener = new SecurityAvailableListener();
  ServiceStateListener mServiceStateListener = new ServiceStateListener();
  SettingsListener mSettingsListener = new SettingsListener();
  SpamControllerListener mSpamControllerListener = new SpamControllerListener();
  SyncConversationsListener mSyncConversationsListener = new SyncConversationsListener();
  SyncConversationsReplyListener mSyncConversationsReplyListener = new SyncConversationsReplyListener();
  SyncMessagesListener mSyncMessagesListener = new SyncMessagesListener();
  SyncMessagesReplyListener mSyncMessagesReplyListener = new SyncMessagesReplyListener();
  TrustPeerCallsListener mTrustPeerCallsListener = new TrustPeerCallsListener();
  TrustPeerMessagesListener mTrustPeerMessagesListener = new TrustPeerMessagesListener();
  UnknownNumberSaveListener mUnknownNumberSaveListener = new UnknownNumberSaveListener();
  UsersMembersIdsMigrationListener mUsersMembersIdsListener = new UsersMembersIdsMigrationListener();
  ViberIdVersionListener mViberIdVersionListener = new ViberIdVersionListener();
  ViberLocationListener mViberLocationListener = new ViberLocationListener();
  ViberOutBalanceListener mViberOutBalanceListener = new ViberOutBalanceListener();
  VideoPttPlayerListener mVideoPttPlayerListener = new VideoPttPlayerListener();
  VideoPttRecorderListener mVideoPttRecorderListener = new VideoPttRecorderListener();
  WalletControllerListener mWalletControllerListener = new WalletControllerListener();
  WebRtcListener mWebRtcListener = new WebRtcListener();

  public boolean IsGSMCallActive()
  {
    return ViberApplication.getInstance().getEngine(false).isGSMCallActive();
  }

  public boolean changePersistentKeys(String paramString, Bundle paramBundle)
  {
    return com.viber.voip.memberid.d.a(paramString, paramBundle);
  }

  public void convertArgbToJpeg(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
    byte[] arrayOfByte = dq.a(localBitmap, Bitmap.CompressFormat.JPEG, 70);
    paramBundle.putByteArray("JpegData", arrayOfByte);
    paramBundle.putInt("JpegSize", arrayOfByte.length);
  }

  public AppDetailsReceiverListener getAppDetailsReceiverListener()
  {
    return this.mAppDetailsReceiverListener;
  }

  public AppsAuthentucatorListener getAppsAuthenticatorListener()
  {
    return this.mAppsAuthentucatorListener;
  }

  public AppsBlockerListener getAppsBlockerListener()
  {
    return this.mAppsBlockerListener;
  }

  public AppsSupportListener getAppsSupportListener()
  {
    return this.mAppsSupportListener;
  }

  public AppsUserAppsReceiverListener getAppsUserAppsReceiverListener()
  {
    return this.mAppsUserAppsReceiverListener;
  }

  public BannerListener getBannerListener()
  {
    return this.mBannerListener;
  }

  public BlockPgInvitesListener getBlockPgInvitesListener()
  {
    return this.mBlockPgInvitesListener;
  }

  public BlockedUserSplashListener getBlockedUserSplashListener()
  {
    return this.mBlockedUserSplashListener;
  }

  public ConnectionListener getConnectionListener()
  {
    return this.mConnectionListener;
  }

  public DeleteMessageListener getDeleteMessageListener()
  {
    return this.mDeleteMessageListener;
  }

  public DeviceManagerListener getDeviceManagerListener()
  {
    return this.mDeviceManagerListener;
  }

  public DialerCallInterruptionListener getDialerCallInterruptionListener()
  {
    return this.mDialerCallInterruptionListener;
  }

  public DialerCallbackListener getDialerCallbackListener()
  {
    return this.mDialerCallbackListener;
  }

  public DialerEndScreenListener getDialerEndScreenListener()
  {
    return this.mDialerEndScreenListener;
  }

  public DialerHoldStateListener getDialerHoldStateListener()
  {
    return this.mDialerHoldStateListener;
  }

  public DialerIncomingScreenListener getDialerIncomingScreenListener()
  {
    return this.mDialerIncomingScreenListener;
  }

  public DialerLocalCallStateListener getDialerLocalCallStateListener()
  {
    return this.mDialerLocalCallStateListener;
  }

  public DialerMuteStateListener getDialerMuteStateListener()
  {
    return this.mDialerMuteStateListener;
  }

  public DialerOutgoingScreenListener getDialerOutgoingScreenListener()
  {
    return this.mDialerOutgoingScreenListener;
  }

  public DialerPhoneStateListener getDialerPhoneStateListener()
  {
    return this.mDialerPhoneStateListener;
  }

  public DialerRemoteCallStateListener getDialerRemoteCallStateListener()
  {
    return this.mDialerRemoteCallStateListener;
  }

  public DialerTransferCallListener getDialerTransferCallListener()
  {
    return this.mDialerTransferCall;
  }

  public DialerVideoListener getDialerVideoListener()
  {
    return this.mDialerVideoListener;
  }

  public GroupAssignRoleListener getGroupAssignRoleListener()
  {
    return this.mGroupAssignRoleListener;
  }

  public GroupCreateListener getGroupCreateListener()
  {
    return this.mGroupCreateListener;
  }

  public GroupInfoListener getGroupInfoListener()
  {
    return this.mGroupInfoListener;
  }

  public GroupLikesListener getGroupLikesListener()
  {
    return this.mGroupLikesListener;
  }

  public GroupMessageStatusListener getGroupMessageStatusListener()
  {
    return this.mGroupMessageStatusListener;
  }

  public HasDesktopListener getHasDesktopListener()
  {
    return this.mHasDesktopListener;
  }

  public LanguageUpdateListener getLanguageUpdateListener()
  {
    return this.mLanguageUpdateListener;
  }

  public LastOnlineListener getLastOnlineListener()
  {
    return this.mLastOnlineListener;
  }

  public MessageSenderListener getMessageSenderListener()
  {
    return this.mMessageSenderListener;
  }

  public FormattedReceiverListener getMessengerFormattedReceiverListener()
  {
    return this.mMessengerFormattedReceiverListener;
  }

  public MediaReceiverListener getMessengerMediaReceiverListener()
  {
    return this.mMessengerMediaReceiverListener;
  }

  public PttReceiverListener getMessengerPttReceiverListener()
  {
    return this.mMessengerPttReceiverListener;
  }

  public RecentMessagesEndedListener getMessengerRecentMessagesEndedListener()
  {
    return this.mMessengerRecentMessagesEnded;
  }

  public TextReceiverListener getMessengerTextReceiverListener()
  {
    return this.mMessengerTextReceiverListener;
  }

  public VideoReceiverListener getMessengerVideoReceiverListener()
  {
    return this.mMessengerVideoReceiverListener;
  }

  public MustSecureListener getMustSecureListener()
  {
    return this.mMustSecureListener;
  }

  public MustUpgradeListener getMustUpgradeListener()
  {
    return this.mMustUpgradeListener;
  }

  public int getPersistentSecureValue(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key");
    String str2 = paramBundle.getString("category");
    String str3 = b.d().d("VLIB_INNER_" + str2, str1);
    if ((str3 == null) || (str3.length() == 0))
      return 6;
    paramBundle.putString("value", str3);
    return 0;
  }

  public int getPersistentValue(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key");
    String str2 = ViberApplication.preferences().a(str1, null);
    if ((str2 == null) || (str2.length() == 0))
      return 6;
    paramBundle.putString("value", str2);
    return 0;
  }

  public PgGeneralQueryReplyListener getPgGeneralQueryReplyListener()
  {
    return this.mPgGeneralQueryReplyListener;
  }

  public PublicAccountCallbackListener getPublicAccountCallbackListener()
  {
    return this.mPublicAccountCallbackListener;
  }

  public PublicAccountConversationStatusListener getPublicAccountConversationStatusListener()
  {
    return this.mPublicAccountConversationStatusListener;
  }

  public PublicAccountFieldValidatorListener getPublicAccountFieldValidatorListener()
  {
    return this.mPublicAccountFieldValidatorListener;
  }

  public PublicAccountInfoReceiverListener getPublicAccountInfoReceiverListener()
  {
    return this.mPublicAccountInfoReceiverListener;
  }

  public PublicAccountRefreshTokenListener getPublicAccountRefreshTokenListener()
  {
    return this.mPublicAccountRefreshTokenListener;
  }

  public PublicAccountSearchListener getPublicAccountSearchListener()
  {
    return this.mPublicAccountSearchListener;
  }

  public PublicAccountSubscribersCountListener getPublicAccountSubscribersCountListener()
  {
    return this.mPublicAccountSubscribersCountListener;
  }

  public PublicAccountSubscriptionStatusListener getPublicAccountSubscriptionStatusListener()
  {
    return this.mPublicAccountSubscriptionStatusListener;
  }

  public PublicChatsEnabledListener getPublicChatsEnabledListener()
  {
    return this.mPublicChatsEnabledListener;
  }

  public PublicGroupGetMessagesListener getPublicGroupGetMessagesListener()
  {
    return this.mPublicGroupGetMessagesListener;
  }

  public PublicGroupInviteSendListener getPublicGroupInviteSendListener()
  {
    return this.mPublicGroupInviteSendListener;
  }

  public PublicGroupLikesListener getPublicGroupLikesListener()
  {
    return this.mPublicGroupLikesListener;
  }

  public QueryDestOperationSupportListener getQueryDestOperationSupportListener()
  {
    return this.mQueryDestOperationSupportListener;
  }

  public RegisterListener getRegisterListener()
  {
    return this.mRegisterListener;
  }

  public RemoteConfigListener getRemoteConfigListener()
  {
    return this.mRemoteConfigListener;
  }

  public SecureMessagesListener getSecureMessagesListener()
  {
    return this.mSecureMessagesListener;
  }

  public SecurePrimaryActivationListener getSecurePrimaryActivationListener()
  {
    return this.mSecurePrimaryActivationListener;
  }

  public SecureSecondaryActivationListener getSecureSecondaryActivationListener()
  {
    return this.mSecureSecondaryActivationListener;
  }

  public SecureTokenListener getSecureTokenListener()
  {
    return this.mSecureTokenListener;
  }

  public SecurityAvailableListener getSecurityAvailableListener()
  {
    return this.mSecurityAvailableListener;
  }

  public ServiceStateListener getServiceStateListener()
  {
    return this.mServiceStateListener;
  }

  public SettingsListener getSettingsListener()
  {
    return this.mSettingsListener;
  }

  public SyncConversationsListener getSyncConversationsListener()
  {
    return this.mSyncConversationsListener;
  }

  public SyncConversationsReplyListener getSyncConversationsReplyListener()
  {
    return this.mSyncConversationsReplyListener;
  }

  public SyncMessagesListener getSyncMessagesListener()
  {
    return this.mSyncMessagesListener;
  }

  public SyncMessagesReplyListener getSyncMessagesReplyListener()
  {
    return this.mSyncMessagesReplyListener;
  }

  public TrustPeerCallsListener getTrustPeerCallsListener()
  {
    return this.mTrustPeerCallsListener;
  }

  public TrustPeerMessagesListener getTrustPeerMessagesListener()
  {
    return this.mTrustPeerMessagesListener;
  }

  public UnknownNumberSaveListener getUnknownNumberSaveListener()
  {
    return this.mUnknownNumberSaveListener;
  }

  public UsersMembersIdsMigrationListener getUsersMembersIdsListener()
  {
    return this.mUsersMembersIdsListener;
  }

  public ViberIdVersionListener getViberIdVersionListener()
  {
    return this.mViberIdVersionListener;
  }

  public ViberLocationListener getViberLocationListener()
  {
    return this.mViberLocationListener;
  }

  @Deprecated
  public ViberOutBalanceListener getViberOutBalanceListener()
  {
    return this.mViberOutBalanceListener;
  }

  public VideoPttPlayerListener getVideoPttPlayerListener()
  {
    return this.mVideoPttPlayerListener;
  }

  public VideoPttRecorderListener getVideoPttRecorderListener()
  {
    return this.mVideoPttRecorderListener;
  }

  public WalletControllerListener getWalletControllerListener()
  {
    return this.mWalletControllerListener;
  }

  public WebRtcListener getWebRtcListener()
  {
    return this.mWebRtcListener;
  }

  public void hideCall(String paramString, boolean paramBoolean)
  {
    this.mDialerOutgoingScreenListener.hideCall(paramString, paramBoolean);
  }

  public void hideCallBack()
  {
    this.mDialerCallbackListener.hideCallBack();
  }

  public void hideEndCall()
  {
    this.mDialerEndScreenListener.hideEndCall();
  }

  public void hideReception()
  {
    this.mDialerIncomingScreenListener.hideReception();
  }

  public void localHold()
  {
    this.mDialerHoldStateListener.localHold();
  }

  public void localUnhold()
  {
    this.mDialerHoldStateListener.localUnhold();
  }

  public void mapMemberIDs(String[] paramArrayOfString, Bundle paramBundle)
  {
    com.viber.voip.memberid.d.a(paramArrayOfString, paramBundle);
  }

  public void mapPhoneNumbers(String[] paramArrayOfString, Bundle paramBundle)
  {
    com.viber.voip.memberid.d.b(paramArrayOfString, paramBundle);
  }

  public void mute()
  {
    this.mDialerMuteStateListener.mute();
  }

  public boolean onAddressBookDeltaUpdate(final CAddressBookEntry[] paramArrayOfCAddressBookEntry1, final CAddressBookEntry[] paramArrayOfCAddressBookEntry2, final String[] paramArrayOfString, final int paramInt, final long paramLong)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onAddressBookDeltaUpdate(paramArrayOfCAddressBookEntry1, paramArrayOfCAddressBookEntry2, paramArrayOfString, paramInt, paramLong);
      }
    });
    return false;
  }

  public boolean onAddressBookUpdate(final int paramInt1, final int paramInt2, final boolean paramBoolean1, final boolean paramBoolean2, final CAddressBookEntry[] paramArrayOfCAddressBookEntry)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onAddressBookUpdate(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramArrayOfCAddressBookEntry);
      }
    });
    return false;
  }

  public void onAppsApiSupported()
  {
    this.mAppsSupportListener.onAppsApiSupported();
  }

  public void onAuthenticateAppReply(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mAppsAuthentucatorListener.onAuthenticateAppReply(paramString, paramInt1, paramInt2, paramInt3);
  }

  public void onBannerOrSplashReceived(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.mBannerListener.onBannerOrSplashReceived(paramLong1, paramString1, paramLong2, paramString2);
  }

  public void onBlockAppReply(int paramInt1, int paramInt2)
  {
    this.mAppsBlockerListener.onBlockAppReply(paramInt1, paramInt2);
  }

  public void onBlockGroupInviteReply(int paramInt1, int paramInt2)
  {
    this.mBlockPgInvitesListener.onBlockGroupInviteReply(paramInt1, paramInt2);
  }

  public void onBlockListReply(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onBlockListReply(paramInt);
      }
    });
  }

  public void onBlockedStatus(String paramString)
  {
    this.mBlockedUserSplashListener.onBlockedStatus(paramString);
  }

  public void onCallEnded(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    this.mDialerLocalCallStateListener.onCallEnded(paramLong, paramBoolean, paramString, paramInt1, paramInt2);
  }

  public void onCallMissed(final long paramLong1, String paramString1, final int paramInt1, final int paramInt2, final String paramString2, final int paramInt3, final String paramString3, final int paramInt4, final String[] paramArrayOfString, final String paramString4, final long paramLong2, final long paramLong3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onCallMissed(paramLong1, paramInt1, paramInt2, paramString2, paramInt3, paramString3, paramInt4, paramArrayOfString, paramString4, paramLong2, paramLong3, this.val$duration);
      }
    });
  }

  public void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.mDialerLocalCallStateListener.onCallStarted(paramBoolean1, paramBoolean2, paramInt);
  }

  public void onChangeConversationSettingsReply(final String paramString, final ConversationSettings paramConversationSettings, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onChangeConversationSettingsReply(paramString, paramConversationSettings, paramInt);
      }
    });
  }

  public void onChangeGroup(final long paramLong1, long paramLong2, final int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onChangeGroup(paramLong1, paramInt1, paramInt3, paramInt4, this.val$revision, this.val$status);
      }
    });
  }

  public void onChangeGroupSettingsReply(final long paramLong, ConversationSettings paramConversationSettings, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onChangeGroupSettingsReply(paramLong, paramInt, this.val$status);
      }
    });
  }

  public void onChangeLastOnlineSettingsReply(int paramInt1, int paramInt2)
  {
    this.mSettingsListener.onChangeLastOnlineSettingsReply(paramInt1, paramInt2);
  }

  public void onChangePublicAccountReply(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPublicAccountCallbackListener.onChangePublicAccountReply(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void onChangeReadNotificationsSettingsReply(int paramInt1, int paramInt2)
  {
    this.mSettingsListener.onChangeReadNotificationsSettingsReply(paramInt1, paramInt2);
  }

  public void onChangeUserActivitySettingsReply(int paramInt1, int paramInt2)
  {
    this.mSettingsListener.onChangeUserActivitySettingsReply(paramInt1, paramInt2);
  }

  public void onClickReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onClickReply(paramInt1, paramInt2);
      }
    });
  }

  public void onClientUpgrade(int paramInt)
  {
    this.mMustUpgradeListener.onClientUpgrade(paramInt);
  }

  public void onCommError(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onCommError(paramInt);
      }
    });
  }

  public void onConferenceDialed()
  {
    this.mWebRtcListener.onConferenceDialed();
  }

  public void onConfigChange(String paramString)
  {
    this.mRemoteConfigListener.onConfigChange(paramString);
  }

  public void onConnect()
  {
    this.mConnectionListener.onConnect();
  }

  public void onConnectionStateChange(int paramInt)
  {
    this.mConnectionListener.onConnectionStateChange(paramInt);
  }

  public void onContactSavedNotificationReply(int paramInt1, int paramInt2)
  {
    this.mUnknownNumberSaveListener.onContactSavedNotificationReply(paramInt1, paramInt2);
  }

  public void onCreateGroupReply(int paramInt1, int paramInt2, long paramLong, Map<String, Integer> paramMap)
  {
    this.mGroupCreateListener.onCreateGroupReply(paramInt1, paramInt2, paramLong, paramMap);
  }

  public void onCreatePublicAccountReply(int paramInt1, int paramInt2, long paramLong, String paramString1, Map<String, Integer> paramMap, String paramString2)
  {
    this.mPublicAccountCallbackListener.onCreatePublicAccountReply(paramInt1, paramInt2, paramLong, paramString1, paramMap, paramString2);
  }

  public void onDataInterruption(boolean paramBoolean)
  {
    this.mDialerCallInterruptionListener.onDataInterruption(paramBoolean);
  }

  public void onDebugInfo(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 45000)
      L.a(new RuntimeException("Error in VoiceLib: " + paramString2), paramString2);
    while (paramInt != 6)
      return;
  }

  public void onDeleteMessageReply(long paramLong, int paramInt1, int paramInt2)
  {
    this.mDeleteMessageListener.onDeleteMessageReply(paramLong, paramInt1, paramInt2);
  }

  public boolean onDeletedGroupMessage(String paramString, long paramLong1, long paramLong2)
  {
    return this.mDeleteMessageListener.onDeletedGroupMessage(paramString, paramLong1, paramLong2);
  }

  public boolean onDeletedMessage(String paramString, long paramLong)
  {
    return this.mDeleteMessageListener.onDeletedMessage(paramString, paramLong);
  }

  public void onEnableGSMCall(final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onEnableGSMCall(paramBoolean);
      }
    });
  }

  public void onEnableMidMapping(boolean paramBoolean)
  {
    this.mUsersMembersIdsListener.onEnableMidMapping(paramBoolean);
  }

  public void onEnableSHICReport(boolean paramBoolean)
  {
    this.mSpamControllerListener.onEnableSHICReport(paramBoolean);
  }

  public void onEnableVOReferrallProgram(final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onEnableVOReferrallProgram(paramBoolean);
      }
    });
  }

  @Deprecated
  public void onEncryptedPhoneNumber(String paramString1, String paramString2)
  {
  }

  public boolean onFormattedMessageReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString3, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return this.mMessengerFormattedReceiverListener.onFormattedMessageReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString3, paramString4, paramInt3, paramInt4, paramInt5, paramInt6);
  }

  public void onGSMCallStateChanged(final int paramInt, final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGSMCallStateChanged(paramInt, paramBoolean);
      }
    });
  }

  public void onGSMStateChange(final int paramInt, final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGSMStateChange(paramInt, paramString);
      }
    });
  }

  public void onGetAppDetails(CGetAppDetails[] paramArrayOfCGetAppDetails, int paramInt1, int paramInt2)
  {
    this.mAppDetailsReceiverListener.onGetAppDetails(paramArrayOfCGetAppDetails, paramInt1, paramInt2);
  }

  public void onGetBillingToken(final long paramLong, String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGetBillingToken(paramLong, this.val$token);
      }
    });
  }

  public boolean onGetGroupMessageStatusReply(long paramLong, int paramInt1, int paramInt2, CGroupMessageStatus[] paramArrayOfCGroupMessageStatus)
  {
    this.mGroupMessageStatusListener.onGetGroupMessageStatusReply(paramLong, paramInt1, paramInt2, paramArrayOfCGroupMessageStatus);
    return false;
  }

  public boolean onGetMissedCalls(final CMissedCall[] paramArrayOfCMissedCall)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGetMissedCalls(paramArrayOfCMissedCall);
      }
    });
    return false;
  }

  public void onGetPersonalProfile(final int paramInt, final long paramLong, String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGetPersonalProfile(paramInt, paramLong, this.val$stickerClusterId);
      }
    });
  }

  public void onGetPublicGroupLikes(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, Map<Integer, PgAction> paramMap, int paramInt3)
  {
    this.mPublicGroupLikesListener.onGetPublicGroupLikes(paramInt1, paramInt2, paramBoolean, paramLong, paramMap, paramInt3);
  }

  public void onGetPublicGroupMessages(int paramInt1, long paramLong, PublicGroupMessage[] paramArrayOfPublicGroupMessage, PublicGroupChangeEvent[] paramArrayOfPublicGroupChangeEvent, int paramInt2)
  {
    this.mPublicGroupGetMessagesListener.onGetPublicGroupMessages(paramInt1, paramLong, paramArrayOfPublicGroupMessage, paramArrayOfPublicGroupChangeEvent, paramInt2);
  }

  public void onGetRecentMessagesEnded(int paramInt)
  {
    this.mMessengerRecentMessagesEnded.onGetRecentMessagesEnded(paramInt);
  }

  public void onGetUserAppsReply(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.mAppsUserAppsReceiverListener.onGetUserAppsReply(paramArrayOfInt, paramInt1, paramInt2);
  }

  public void onGetUserMemberIDsReply(PhoneNumberToMidInfo[] paramArrayOfPhoneNumberToMidInfo, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.mUsersMembersIdsListener.onGetUserMemberIDsReply(paramArrayOfPhoneNumberToMidInfo, paramInt1, paramInt2, paramBoolean, paramInt3);
  }

  public void onGetWalletSecureTokenReply(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mWalletControllerListener.onGetWalletSecureTokenReply(paramString, paramInt1, paramInt2, paramInt3);
  }

  public void onGlobalDeleteMessageReply(final long paramLong1, long paramLong2, final int paramInt1, int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGlobalDeleteMessageReply(paramLong1, paramInt1, this.val$seq, this.val$status);
      }
    });
  }

  public void onGroupAddMembers(final long paramLong1, int paramInt1, final long paramLong2, final int paramInt2, String[] paramArrayOfString, final Map<String, Integer> paramMap, final int paramInt3, final int paramInt4)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGroupAddMembers(paramLong1, paramLong2, paramInt2, paramMap, paramInt3, paramInt4, this.val$status, this.val$revision);
      }
    });
  }

  public void onGroupAssignRole(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, String[] paramArrayOfString, Map<String, Integer> paramMap, int paramInt4, int paramInt5)
  {
    this.mGroupAssignRoleListener.onGroupAssignRole(paramLong1, paramInt1, paramLong2, paramInt2, paramInt3, paramArrayOfString, paramMap, paramInt4, paramInt5);
  }

  public boolean onGroupChanged(final long paramLong1, String paramString1, final long paramLong2, final int paramInt1, long paramLong3, final String paramString2, final String paramString3, int paramInt2, final GroupUserChanged[] paramArrayOfGroupUserChanged, final int paramInt3, final String paramString4)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGroupChanged(paramLong1, paramLong2, paramInt1, paramString2, paramString3, paramArrayOfGroupUserChanged, paramInt3, paramString4, this.val$changedMembers, this.val$changedAttributesFlags, this.val$iconDownloadID);
      }
    });
    return false;
  }

  public void onGroupInfo(int paramInt1, long paramLong, String paramString1, String paramString2, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3)
  {
    this.mGroupInfoListener.onGroupInfo(paramInt1, paramLong, paramString1, paramString2, paramArrayOfGroupUserChanged, paramInt2, paramInt3, paramInt4, paramInt5, paramString3);
  }

  public void onGroupLeave(final long paramLong1, long paramLong2, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGroupLeave(paramLong1, paramInt, this.val$status);
      }
    });
  }

  public boolean onGroupMessageDelivered(final long paramLong1, long paramLong2, final String paramString, long paramLong3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onGroupMessageDelivered(paramLong1, paramString, this.val$deliveredTo, this.val$timeDelivered);
      }
    });
    return false;
  }

  public boolean onGroupMessageLike(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt, boolean paramBoolean)
  {
    return this.mGroupLikesListener.onGroupMessageLike(paramLong1, paramLong2, paramLong3, paramString, paramLong4, paramInt, paramBoolean);
  }

  public void onGroupRemoveMembers(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String[] paramArrayOfString, Map<String, Integer> paramMap, int paramInt3, int paramInt4)
  {
  }

  public boolean onHandleSelfDetails(final long paramLong, String paramString1, final String paramString2, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onHandleSelfDetails(paramLong, paramString2, paramInt, this.val$Flags);
      }
    });
    return false;
  }

  public void onHangup()
  {
    this.mDialerLocalCallStateListener.onHangup();
  }

  public void onHasDesktop(boolean paramBoolean)
  {
    this.mHasDesktopListener.onHasDesktop(paramBoolean);
  }

  public boolean onIM2MessageReceived(long paramLong)
  {
    return this.mIm2JniReceiver.onIM2MessageReceived(paramLong);
  }

  public void onIceCandidateReceivedFromPeer(IceCandidate paramIceCandidate)
  {
    this.mWebRtcListener.onIceCandidateReceivedFromPeer(paramIceCandidate);
  }

  public void onIsOnlineReply(final String paramString, final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onIsOnlineReply(paramString, paramBoolean);
      }
    });
  }

  public void onIsRegistered(int paramInt)
  {
    this.mRegisterListener.onIsRegistered(paramInt);
  }

  public void onJoinPublicGroup(long paramLong, int paramInt1, int paramInt2)
  {
    this.mPublicAccountCallbackListener.onJoinPublicGroup(paramLong, paramInt1, paramInt2);
  }

  public void onKeepaliveReply()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onKeepaliveReply();
      }
    });
  }

  public void onLBServerTime(final long paramLong)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onLBServerTime(paramLong);
      }
    });
  }

  public void onLastOnline(OnlineContactInfo[] paramArrayOfOnlineContactInfo, int paramInt)
  {
    this.mLastOnlineListener.onLastOnline(paramArrayOfOnlineContactInfo, paramInt);
  }

  public void onLikeGroupMessageReply(long paramLong, int paramInt1, int paramInt2)
  {
    this.mGroupLikesListener.onLikeGroupMessageReply(paramLong, paramInt1, paramInt2);
  }

  public void onLikePublicGroupMessage(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong3, int paramInt3)
  {
    this.mPublicGroupLikesListener.onLikePublicGroupMessage(paramLong1, paramLong2, paramInt1, paramBoolean, paramInt2, paramLong3, paramInt3);
  }

  public boolean onMediaReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, EncryptionParams paramEncryptionParams, int paramInt6, int paramInt7)
  {
    return this.mMessengerMediaReceiverListener.onMediaReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramInt3, paramString3, paramString4, paramString5, paramString6, paramInt4, paramInt5, paramString7, paramEncryptionParams, paramInt6, paramInt7);
  }

  public boolean onMessageDelivered(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return this.mMessageSenderListener.onMessageDelivered(paramLong1, paramLong2, paramInt1, paramInt2);
  }

  public boolean onMessageStateUpdate(final long paramLong, int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onMessageStateUpdate(paramLong, this.val$flags);
      }
    });
    return false;
  }

  public void onMustSecure()
  {
    this.mMustSecureListener.onMustSecure();
  }

  @Deprecated
  public boolean onMyMemberID(String paramString1, String paramString2)
  {
    return true;
  }

  public void onOpenMarket()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onOpenMarket();
      }
    });
  }

  public void onPGGeneralQueryReply(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.mPgGeneralQueryReplyListener.onPGGeneralQueryReply(paramInt1, paramLong, paramString, paramInt2);
  }

  public void onPeerBusy()
  {
    this.mDialerRemoteCallStateListener.onPeerBusy();
  }

  public void onPeerCapabilities(int paramInt, boolean paramBoolean)
  {
    this.mWebRtcListener.onPeerCapabilities(paramInt, paramBoolean);
  }

  public void onPeerIdentityBreached(String paramString1, String paramString2, String paramString3)
  {
    this.mTrustPeerMessagesListener.onPeerIdentityBreached(paramString1, paramString2, paramString3);
  }

  public void onPeerRinging()
  {
    this.mDialerRemoteCallStateListener.onPeerRinging();
  }

  public void onPeerTransferred(ProcessedCallback paramProcessedCallback)
  {
    this.mWebRtcListener.onPeerTransferred(paramProcessedCallback);
  }

  public int onPeerVideoEnded(int paramInt)
  {
    return this.mDialerVideoListener.onPeerVideoEnded(paramInt);
  }

  public int onPeerVideoStarted()
  {
    return this.mDialerVideoListener.onPeerVideoStarted();
  }

  public void onPhoneStateChanged(int paramInt)
  {
    this.mDialerPhoneStateListener.onPhoneStateChanged(paramInt);
  }

  public boolean onPttReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString3, int paramInt3, String paramString4, int paramInt4, int paramInt5, String paramString5, int paramInt6, int paramInt7)
  {
    return this.mMessengerPttReceiverListener.onPttReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString3, paramInt3, paramString4, paramInt4, paramInt5, paramString5, paramInt6, paramInt7);
  }

  public void onPublicAccountInfo(int paramInt1, int paramInt2, PublicAccountInfo paramPublicAccountInfo)
  {
    this.mPublicAccountInfoReceiverListener.onPublicAccountInfo(paramInt1, paramInt2, paramPublicAccountInfo);
  }

  public void onPublicAccountRefreshToken(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.mPublicAccountRefreshTokenListener.onPublicAccountRefreshToken(paramInt1, paramInt2, paramString1, paramString2);
  }

  public void onPublicAccountSubscribersCount(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.mPublicAccountSubscribersCountListener.onPublicAccountSubscribersCount(paramInt1, paramInt2, paramString, paramInt3);
  }

  public void onPublicChatSupported(int paramInt)
  {
    this.mPublicChatsEnabledListener.onPublicChatSupported(paramInt);
  }

  public boolean onPublicGroupChanged(long paramLong1, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong2, long paramLong3, int paramInt4, String paramString3, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt5, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString7, String paramString8, int paramInt6, int paramInt7, PublicAccountAttributes paramPublicAccountAttributes, int paramInt8, String paramString9)
  {
    return false;
  }

  @Deprecated
  public void onPublicGroupInfo(int paramInt1, long paramLong, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, String paramString5, String paramString6, String[] paramArrayOfString, PublicGroupUserInfo[] paramArrayOfPublicGroupUserInfo, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
  }

  public boolean onPublicGroupInvite(long paramLong1, String paramString1, long paramLong2, int paramInt1, String paramString2, long paramLong3, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return false;
  }

  public void onPublicGroupsUpdated(final PGLatestParamsWithRole[] paramArrayOfPGLatestParamsWithRole, final long paramLong, Group2LatestParams[] paramArrayOfGroup2LatestParams)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onPublicGroupsUpdated(paramArrayOfPGLatestParamsWithRole, paramLong, this.val$group2LatestParams);
      }
    });
  }

  public void onQueryDestOperationSupportReplyMsg(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.mQueryDestOperationSupportListener.onQueryDestOperationSupportReplyMsg(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }

  public void onRecanonize(final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onRecanonize(paramString);
      }
    });
  }

  public void onRecoverGroupChats(GroupChatInfo[] paramArrayOfGroupChatInfo, int paramInt1, int paramInt2, boolean paramBoolean, Map<Long, Integer> paramMap)
  {
  }

  public void onRecoverPublicAccounts(PublicAccountInfo[] paramArrayOfPublicAccountInfo1, PublicAccountInfo[] paramArrayOfPublicAccountInfo2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
  }

  public boolean onRegisteredNumbers(final boolean paramBoolean1, final boolean paramBoolean2, final CRegisteredContactInfo[] paramArrayOfCRegisteredContactInfo, final int paramInt1, final long paramLong, int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onRegisteredNumbers(paramBoolean1, paramBoolean2, paramArrayOfCRegisteredContactInfo, paramInt1, paramLong, this.val$aBVersion);
      }
    });
    return false;
  }

  public void onSdpAnswerReceivedFromPeer(String paramString, int paramInt, ProcessedCallback paramProcessedCallback)
  {
    this.mWebRtcListener.onSdpAnswerReceivedFromPeer(paramString, paramInt, paramProcessedCallback);
  }

  public void onSdpAnswerableOfferReceivedFromPeer(String paramString, int paramInt, SdpProcessedCallback paramSdpProcessedCallback)
  {
    this.mWebRtcListener.onSdpAnswerableOfferReceivedFromPeer(paramString, paramInt, paramSdpProcessedCallback);
  }

  public void onSdpOfferReceivedFromPeer(String paramString, int paramInt, boolean paramBoolean, SdpProcessedCallback paramSdpProcessedCallback)
  {
    this.mWebRtcListener.onSdpOfferReceivedFromPeer(paramString, paramInt, paramBoolean, paramSdpProcessedCallback);
  }

  public void onSearchPublicAccounts(int paramInt1, PublicAccountInfo[] paramArrayOfPublicAccountInfo, int paramInt2)
  {
    this.mPublicAccountSearchListener.onSearchPublicAccounts(paramInt1, paramArrayOfPublicAccountInfo, paramInt2);
  }

  public void onSearchPublicGroups(int paramInt1, PublicGroupInfo[] paramArrayOfPublicGroupInfo, int paramInt2)
  {
    this.mPublicAccountSearchListener.onSearchPublicGroups(paramInt1, paramArrayOfPublicGroupInfo, paramInt2);
  }

  public void onSecondaryDeviceDetails(CSecondaryDeviceDetails paramCSecondaryDeviceDetails)
  {
    this.mDeviceManagerListener.onSecondaryDeviceDetails(paramCSecondaryDeviceDetails);
  }

  public boolean onSecondaryRegistered(final long paramLong, int paramInt1, final int paramInt2, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onSecondaryRegistered(paramLong, paramInt2, paramInt3, this.val$flags);
      }
    });
    return false;
  }

  public void onSecondaryStartActivation(boolean paramBoolean)
  {
    this.mSecureSecondaryActivationListener.onSecondaryStartActivation(paramBoolean);
  }

  public void onSecureActivationCodeReceived(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mSecureSecondaryActivationListener.onSecureActivationCodeReceived(paramString1, paramString2, paramString3, paramString4);
  }

  public void onSecureCallStateChange(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    this.mTrustPeerCallsListener.onSecureCallStateChange(paramLong, paramInt1, paramArrayOfByte, paramInt2, paramString);
  }

  public void onSecureSecondaryActivationFinished(int paramInt)
  {
    this.mSecureSecondaryActivationListener.onSecureSecondaryActivationFinished(paramInt);
  }

  public void onSecureSecondaryDeviceActivated(byte[] paramArrayOfByte, int paramInt)
  {
    this.mSecurePrimaryActivationListener.onSecureSecondaryDeviceActivated(paramArrayOfByte, paramInt);
  }

  public void onSecureSecondaryRequest(int paramInt)
  {
    this.mSecurePrimaryActivationListener.onSecureSecondaryRequest(paramInt);
  }

  public void onSecureSessionInfo(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mSecureMessagesListener.onSecureSessionInfo(paramString1, paramBoolean, paramString2);
  }

  public void onSecureTokenReply(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    this.mSecureTokenListener.onSecureTokenReply(paramInt, paramLong, paramArrayOfByte);
  }

  public void onSecurityAvailable(boolean paramBoolean)
  {
    this.mSecurityAvailableListener.onSecurityAvailable(paramBoolean);
  }

  public void onSelfVideoEnded(int paramInt)
  {
    this.mDialerVideoListener.onSelfVideoEnded(paramInt);
  }

  public void onSelfVideoStarted()
  {
    this.mDialerVideoListener.onSelfVideoStarted();
  }

  public void onSendConversationStatusReply(String paramString, int paramInt1, int paramInt2)
  {
    this.mPublicAccountConversationStatusListener.onSendConversationStatusReply(paramString, paramInt1, paramInt2);
  }

  public void onSendLocation()
  {
    this.mViberLocationListener.onSendLocation();
  }

  public void onSendMessageReply(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    this.mMessageSenderListener.onSendMessageReply(paramInt1, paramLong, paramInt2, paramInt3, paramString);
  }

  public void onSendPublicGroupInviteReply(int paramInt1, long paramLong, int paramInt2, Map<String, Integer> paramMap)
  {
    this.mPublicGroupInviteSendListener.onSendPublicGroupInviteReply(paramInt1, paramLong, paramInt2, paramMap);
  }

  public void onServiceStateChanged(int paramInt)
  {
    this.mServiceStateListener.onServiceStateChanged(paramInt);
  }

  public void onShareAddressBook()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onShareAddressBook();
      }
    });
  }

  public void onShareAddressBookReply(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onShareAddressBookReply(paramInt1, paramInt2, paramInt3);
      }
    });
  }

  public void onShareAddressBookReplyOld(final boolean paramBoolean, final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onShareAddressBookReplyOld(paramBoolean, paramInt1, paramInt2);
      }
    });
  }

  public boolean onShareSecondaryContact(final CContactInfo paramCContactInfo, final long paramLong)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onShareSecondaryContact(paramCContactInfo, paramLong);
      }
    });
    return false;
  }

  public void onShareSecondaryContactReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onShareSecondaryContactReply(paramInt1, paramInt2);
      }
    });
  }

  public void onShouldRegister()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onShouldRegister();
      }
    });
  }

  public void onSignal(String paramString, int paramInt)
  {
    ViberApplication.getInstance().getCrashHandler().a(paramString, paramInt);
  }

  public void onStartClientMigrateToMid()
  {
    this.mUsersMembersIdsListener.onStartClientMigrateToMid();
  }

  public void onStartRingback(String paramString)
  {
    this.mDialerRemoteCallStateListener.onStartRingback(paramString);
  }

  public void onSubscribeToPublicAccountReply(int paramInt1, int paramInt2)
  {
    this.mPublicAccountSubscriptionStatusListener.onSubscribeToPublicAccountReply(paramInt1, paramInt2);
  }

  public void onSwitchToConferenceCall(long paramLong, String paramString, Map<String, String> paramMap)
  {
    this.mWebRtcListener.onSwitchToConferenceCall(paramLong, paramString, paramMap);
  }

  public boolean onSyncConversation(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.mSyncConversationsListener.onSyncConversation(paramString, paramLong, paramInt1, paramInt2);
    return false;
  }

  public void onSyncConversationReply(String paramString, long paramLong, int paramInt)
  {
    this.mSyncConversationsReplyListener.onSyncConversationReply(paramString, paramLong, paramInt);
  }

  public boolean onSyncGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.mSyncConversationsListener.onSyncGroup(paramLong1, paramLong2, paramInt1, paramInt2);
    return false;
  }

  public void onSyncGroupReply(long paramLong1, long paramLong2, int paramInt)
  {
    this.mSyncConversationsReplyListener.onSyncGroupReply(paramLong1, paramLong2, paramInt);
  }

  public boolean onSyncMessageLike(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3)
  {
    this.mPublicGroupLikesListener.onSyncMessageLike(paramLong1, paramLong2, paramInt, paramBoolean, paramLong3);
    return false;
  }

  public boolean onSyncMessages(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.mSyncMessagesListener.onSyncMessages(paramArrayOfLong1, paramArrayOfLong2);
    return false;
  }

  public void onSyncMessagesReply(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    this.mSyncMessagesReplyListener.onSyncMessagesReply(paramInt1, paramArrayOfLong, paramInt2);
  }

  public boolean onTextReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5, int paramInt6)
  {
    return this.mMessengerTextReceiverListener.onTextReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramString3, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString4, paramInt3, paramInt4, paramString5, paramInt5, paramInt6);
  }

  public void onTransferFailed(int paramInt)
  {
    this.mDialerTransferCall.onTransferFailed(paramInt);
  }

  public void onTransferReplyOK(long paramLong)
  {
    this.mDialerTransferCall.onTransferReplyOK(paramLong);
  }

  public void onUnSubscribeFromPublicAccountReply(int paramInt1, int paramInt2)
  {
    this.mPublicAccountSubscriptionStatusListener.onUnSubscribeFromPublicAccountReply(paramInt1, paramInt2);
  }

  public void onUnregisterAppReply(int paramInt1, int paramInt2)
  {
    this.mAppsAuthentucatorListener.onUnregisterAppReply(paramInt1, paramInt2);
  }

  public boolean onUnregisteredNumber(final String paramString, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onUnregisteredNumber(paramString, paramInt);
      }
    });
    return true;
  }

  public void onUpdateLanguage(int paramInt)
  {
    this.mLanguageUpdateListener.onUpdateLanguage(paramInt);
  }

  public boolean onUpdateUnsavedContactDetails(final long paramLong, String paramString1, final String paramString2, final String paramString3, final int paramInt, final String paramString4)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onUpdateUnsavedContactDetails(paramLong, paramString2, paramString3, paramInt, paramString4, this.val$newPhoneNumber);
      }
    });
    return false;
  }

  public void onUpdateUserName(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onUpdateUserName(paramInt);
      }
    });
  }

  public void onUpdateUserPhoto(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onUpdateUserPhoto(paramInt);
      }
    });
  }

  public void onUpdateViberIdVersion(int paramInt)
  {
    this.mViberIdVersionListener.onUpdateViberIdVersion(paramInt);
  }

  public void onValidatePublicAccountFieldsReply(int paramInt1, PublicAccountFieldStatusMap paramPublicAccountFieldStatusMap, int paramInt2)
  {
    this.mPublicAccountFieldValidatorListener.onValidatePublicAccountFieldsReply(paramInt1, paramPublicAccountFieldStatusMap, paramInt2);
  }

  public void onValidatePublicGroupUri(final String paramString, final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onValidatePublicGroupUri(paramString, paramInt1, paramInt2);
      }
    });
  }

  public boolean onViberOutBalanceChange(long paramLong)
  {
    this.mViberOutBalanceListener.onViberOutBalanceChange(paramLong);
    return false;
  }

  public void onVideoCallEnded()
  {
    this.mDialerVideoListener.onVideoCallEnded();
  }

  public void onVideoCompatibility(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mDialerVideoListener.onVideoCompatibility(paramBoolean1, paramBoolean2);
  }

  public void onVideoPttPlayError(int paramInt1, int paramInt2)
  {
    this.mVideoPttPlayerListener.onVideoPttPlayError(paramInt1, paramInt2);
  }

  public void onVideoPttPlayRestarted(int paramInt)
  {
    this.mVideoPttPlayerListener.onVideoPttPlayRestarted(paramInt);
  }

  public void onVideoPttPlayStarted(int paramInt)
  {
    this.mVideoPttPlayerListener.onVideoPttPlayStarted(paramInt);
  }

  public void onVideoPttPlayStopped(int paramInt)
  {
    this.mVideoPttPlayerListener.onVideoPttPlayStopped(paramInt);
  }

  public void onVideoPttPlayStopping(int paramInt)
  {
    this.mVideoPttPlayerListener.onVideoPttPlayStopping(paramInt);
  }

  public void onVideoPttRecordError(int paramInt)
  {
    this.mVideoPttRecorderListener.onVideoPttRecordError(paramInt);
  }

  public void onVideoPttRecordInited()
  {
    this.mVideoPttRecorderListener.onVideoPttRecordInited();
  }

  public void onVideoPttRecordStarted()
  {
    this.mVideoPttRecorderListener.onVideoPttRecordStarted();
  }

  public void onVideoPttRecordStopped(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.mVideoPttRecorderListener.onVideoPttRecordStopped(paramString, paramBoolean, paramArrayOfByte);
  }

  public boolean onVideoReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, EncryptionParams paramEncryptionParams, int paramInt6, int paramInt7)
  {
    return this.mMessengerVideoReceiverListener.onVideoReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramInt3, paramString3, paramString4, paramString5, paramString6, paramInt4, paramInt5, paramString7, paramEncryptionParams, paramInt6, paramInt7);
  }

  public void onWalletSupported()
  {
    this.mWalletControllerListener.onWalletSupported();
  }

  public boolean onWebNotification(final long paramLong, String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.onWebNotification(paramLong, this.val$notification);
      }
    });
    return false;
  }

  public void peerHold()
  {
    this.mDialerHoldStateListener.peerHold();
  }

  public void peerUnhold()
  {
    this.mDialerHoldStateListener.peerUnhold();
  }

  public void playTone(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.playTone(paramInt);
      }
    });
  }

  public int removeAllPersistentSecureValues(String paramString)
  {
    b.d().c("VLIB_INNER_" + paramString);
    return 0;
  }

  public int setPersistentSecureValue(String paramString1, String paramString2, String paramString3)
  {
    b.d().a("VLIB_INNER_" + paramString1, paramString2, paramString3);
    return 0;
  }

  public int setPersistentValue(String paramString1, String paramString2)
  {
    ViberApplication.preferences().b(paramString1, paramString2);
    return 0;
  }

  public void showCall(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mDialerOutgoingScreenListener.showCall(paramString, paramBoolean1, paramBoolean2);
  }

  public void showCallBack(int paramInt1, int paramInt2)
  {
    this.mDialerCallbackListener.showCallBack(paramInt1, paramInt2);
  }

  public void showCallBlocked(int paramInt1, int paramInt2)
  {
    this.mDialerCallbackListener.showCallBlocked(paramInt1, paramInt2);
  }

  public void showDialog(int paramInt, String paramString)
  {
    this.mDialerCallbackListener.showDialog(paramInt, paramString);
  }

  public void showEndCall()
  {
    this.mDialerEndScreenListener.showEndCall();
  }

  public void showReception(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    this.mDialerIncomingScreenListener.showReception(paramString1, paramString2, paramBoolean, paramInt, paramString3, paramString4, paramMap);
  }

  public void stopTone()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PhoneControllerDelegate paramAnonymousPhoneControllerDelegate)
      {
        paramAnonymousPhoneControllerDelegate.stopTone();
      }
    });
  }

  public void switchToGSM(String paramString)
  {
    this.mDialerCallbackListener.switchToGSM(paramString);
  }

  public void unmute()
  {
    this.mDialerMuteStateListener.unmute();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.EngineDelegatesManager
 * JD-Core Version:    0.6.2
 */