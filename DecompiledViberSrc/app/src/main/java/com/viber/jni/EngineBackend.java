package com.viber.jni;

import com.viber.jni.apps.AppsController;
import com.viber.jni.banner.BannerController;
import com.viber.jni.block.BlockController;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.WebRtcDialerController;
import com.viber.jni.gcm.GcmController;
import com.viber.jni.group.GroupController;
import com.viber.jni.im2.Im2JniSender;
import com.viber.jni.language.LanguageController;
import com.viber.jni.lastonline.LastOnlineController;
import com.viber.jni.like.LikeController;
import com.viber.jni.memberid.MemberIdMigrationController;
import com.viber.jni.ptt.VideoPttController;
import com.viber.jni.publicaccount.PublicAccountConversationStatusController;
import com.viber.jni.publicaccount.PublicAccountSubscribersCountController;
import com.viber.jni.publicaccount.PublicAccountSubscriptionController;
import com.viber.jni.publicgroup.PublicGroupController;
import com.viber.jni.secure.DeviceManagerController;
import com.viber.jni.secure.SecureActivationController;
import com.viber.jni.secure.SecureMessagesController;
import com.viber.jni.secure.TrustPeerController;
import com.viber.jni.settings.SettingsController;
import com.viber.jni.spam.UnknownNumberReportController;
import com.viber.jni.wallet.WalletController;

public abstract interface EngineBackend extends AppsController, BannerController, BlockController, ConnectionController, PhoneController, DialerController, WebRtcDialerController, GcmController, GroupController, Im2JniSender, LanguageController, LastOnlineController, LikeController, MemberIdMigrationController, VideoPttController, PublicAccountConversationStatusController, PublicAccountSubscribersCountController, PublicAccountSubscriptionController, PublicGroupController, DeviceManagerController, SecureActivationController, SecureMessagesController, TrustPeerController, SettingsController, UnknownNumberReportController, WalletController
{
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.EngineBackend
 * JD-Core Version:    0.6.2
 */