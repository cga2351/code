package com.viber.voip.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.util.ArraySet;
import android.support.v4.util.Pair;
import android.widget.Toast;
import com.firebase.jobdispatcher.v;
import com.google.android.gms.maps.MapsInitializer;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.jni.Engine;
import com.viber.jni.cdr.CdrConst.ShareMediaTypes;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.PublicAccountInteraction;
import com.viber.service.ViberPhoneService;
import com.viber.service.VoipConnectorService;
import com.viber.service.VoipConnectorService.StartMode;
import com.viber.service.VoipConnectorService.a;
import com.viber.service.contacts.sync.ContactsSyncAccountService;
import com.viber.voip.AcceptTermsAndPoliciesWebActivity;
import com.viber.voip.AddFriendActivity;
import com.viber.voip.AddFriendPreviewActivity;
import com.viber.voip.BaseAddFriendActivity.ContactDetails;
import com.viber.voip.BringAppToFrontActivity;
import com.viber.voip.MessageInfoActivity;
import com.viber.voip.MyQRCodeActivity;
import com.viber.voip.R.anim;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.SplashActivity;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberConnectActivity;
import com.viber.voip.ViberEnv;
import com.viber.voip.WakeUpViberActivity;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.api.InternalActionActivity;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.apps.model.AuthInfo;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.auto.service.AutoBackupService;
import com.viber.voip.backup.ui.RestoreActivity;
import com.viber.voip.backup.ui.promotion.AutoBackupPromotionActivity;
import com.viber.voip.banner.notificationsoff.GlobalNotificationSplashActivity;
import com.viber.voip.banner.view.BlockedUserSplashActivity;
import com.viber.voip.billing.Carrier;
import com.viber.voip.calls.ui.GroupCallDetailsActivity;
import com.viber.voip.calls.ui.RecentCallsActivity;
import com.viber.voip.camrecorder.CustomCamTakeVideoActivity;
import com.viber.voip.contacts.b.b;
import com.viber.voip.contacts.model.ExtraActionAfterContactIsAdded;
import com.viber.voip.contacts.ui.AdminSelectorActivity;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.ParticipantSelector.f;
import com.viber.voip.contacts.ui.list.GroupCallStartParticipantsActivity;
import com.viber.voip.contacts.ui.list.ParticipantsListActivity;
import com.viber.voip.engagement.SayHiToFriendsActivity;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser.b;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.preview.PhotoPreviewActivity;
import com.viber.voip.gallery.selection.AddMoreGallery;
import com.viber.voip.gallery.selection.SelectionGallery;
import com.viber.voip.gdpr.ui.birthdate.UserBirthdateActivity;
import com.viber.voip.gdpr.ui.iabconsent.ConsentActivity;
import com.viber.voip.group.participants.ban.BannedParticipantsListActivity;
import com.viber.voip.group.participants.settings.ParticipantsSettingsActivity;
import com.viber.voip.i.c.l;
import com.viber.voip.invitelinks.CommunityFollowerData;
import com.viber.voip.invitelinks.f.a;
import com.viber.voip.invitelinks.linkscreen.InviteLinkData;
import com.viber.voip.invitelinks.linkscreen.ShareCommunityFollowerLinkActivity;
import com.viber.voip.invitelinks.linkscreen.ShareGroupLinkActivity;
import com.viber.voip.market.ExplorePublicGroupsActivity;
import com.viber.voip.market.MarketApi.c;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.commongroups.CommonGroupsActivity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.ShareScreenshotActivity;
import com.viber.voip.messages.conversation.ui.edit.group.AddGroupDetailsPresenter.AddDetailsGoNextAction;
import com.viber.voip.messages.conversation.ui.edit.group.GroupAddDetailsActivity;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.conversation.ui.vote.ForwardCreatePollActivity;
import com.viber.voip.messages.conversation.ui.vote.VoteActivity;
import com.viber.voip.messages.extensions.activity.ChatExInternalBrowserActivity;
import com.viber.voip.messages.extensions.activity.ChatExInternalBrowserPartialSizeActivity;
import com.viber.voip.messages.extensions.activity.ChatExtensionPanelActivity;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.o.a;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.shopchat.ShopChatPanelActivity;
import com.viber.voip.messages.translation.SelectLanguageActivity;
import com.viber.voip.messages.translation.SelectUiLanguageActivity;
import com.viber.voip.messages.ui.forward.sharelink.ShareLinkActivity;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.messages.ui.media.GoogleApiMapPreviewActivityV2;
import com.viber.voip.messages.ui.media.LocationMessageActivityV2;
import com.viber.voip.messages.ui.media.ViewMediaActivity;
import com.viber.voip.messages.ui.media.WebMapPreViewActivity;
import com.viber.voip.messages.ui.media.WinkViewMediaActivity;
import com.viber.voip.messages.ui.media.player.FullScreenVideoPlayerActivity;
import com.viber.voip.messages.ui.media.player.MediaPlayer;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.messages.ui.media.player.VideoPlayerScreenSpec;
import com.viber.voip.messages.ui.media.simple.SimpleMediaViewItem;
import com.viber.voip.messages.ui.media.simple.ViewMediaSimpleActivity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.news.NewsSession;
import com.viber.voip.news.NewsShareAnalyticsData;
import com.viber.voip.news.ViberNewsArticleBrowserActivity;
import com.viber.voip.news.ViberNewsWebActivity;
import com.viber.voip.notif.receivers.NotificationsBroadcastReceiver;
import com.viber.voip.notif.receivers.PendingIntentBroadcastReceiver;
import com.viber.voip.permissions.IsolatedPermissionHandlerActivity;
import com.viber.voip.phone.PhoneFragmentActivity;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton.Action;
import com.viber.voip.publicaccount.wizard.SetupInboxWizardActivity;
import com.viber.voip.qrcode.ScannerActivity;
import com.viber.voip.rakuten.RakutenAccountWebViewActivity;
import com.viber.voip.react.ReactContextManager;
import com.viber.voip.react.ReactContextManager.a;
import com.viber.voip.registration.ActivationController.ActivationCode;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.RegistrationActivity;
import com.viber.voip.registration.RegistrationReminderMessageReceiver;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.registration.changephonenumber.ChangePhoneNumberActivity;
import com.viber.voip.services.inbox.screen.BusinessInboxActivity;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.au;
import com.viber.voip.settings.d.bh;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.settings.d.j;
import com.viber.voip.settings.d.n;
import com.viber.voip.settings.ui.BackupSettingsActivity;
import com.viber.voip.settings.ui.ManageStorageActivity;
import com.viber.voip.settings.ui.personal.PersonalDataSettingsActivity;
import com.viber.voip.settings.ui.personal.delete.DeleteYourDataSettingsActivity;
import com.viber.voip.settings.ui.personal.request.RequestYourDataSettingsActivity;
import com.viber.voip.shareviber.invitescreen.InviteActivity;
import com.viber.voip.storage.conversation.ManageConversationStorageActivity;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.KeyguardUnlockWaitActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cj;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.i;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.user.EditInfoActivity;
import com.viber.voip.user.InvitationCreator;
import com.viber.voip.user.PublicGroupParticipantDetailsActivity;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.more.MoreActivity;
import com.viber.voip.user.more.MoreDialogActivity;
import com.viber.voip.user.viberid.connectaccount.ViberIdConnectActivity;
import com.viber.voip.util.links.MessageOpenUrlSpec;
import com.viber.voip.util.links.SimpleOpenUrlSpec;
import com.viber.voip.viberout.ui.CheckPurchaseActivity;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import com.viber.voip.viberout.ui.products.ViberOutProductsActivity;
import com.viber.voip.viberout.ui.products.countryplans.ViberOutCountryPlansActivity;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import com.viber.voip.vln.VlnActivity;
import com.viber.voip.vln.ui.SmsInboxActivity;
import com.viber.voip.wallet.wu.WesternUnionWebActivity;
import com.viber.voip.y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

public class ViberActionRunner
{
  private static final Logger a = ViberEnv.getLogger();

  public static Intent a(Context paramContext, int paramInt)
  {
    if ((c(paramContext)) && (MapsInitializer.initialize(ViberApplication.getApplication()) == 0));
    while (true)
    {
      try
      {
        localIntent = new Intent(paramContext, LocationMessageActivityV2.class);
        if (localIntent != null)
          localIntent.putExtra("extra_location_format", paramInt);
        return localIntent;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        localIntent = null;
        continue;
      }
      Intent localIntent = null;
    }
  }

  public static Intent a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = a(paramContext, paramInt);
    if (localIntent != null)
      localIntent.putExtra("localityAccuracy", paramBoolean);
    return localIntent;
  }

  public static Intent a(Context paramContext, Intent paramIntent)
  {
    if (!(paramContext instanceof Activity))
      paramIntent.addFlags(268435456);
    return paramIntent;
  }

  public static Intent a(Intent paramIntent, CharSequence paramCharSequence, Intent[] paramArrayOfIntent)
  {
    Intent localIntent = new Intent("android.intent.action.CHOOSER");
    localIntent.putExtra("android.intent.extra.INTENT", paramIntent);
    if (paramCharSequence != null)
      localIntent.putExtra("android.intent.extra.TITLE", paramCharSequence);
    if ((paramArrayOfIntent != null) && (paramArrayOfIntent.length > 0))
      localIntent.putExtra("android.intent.extra.INITIAL_INTENTS", paramArrayOfIntent);
    return localIntent;
  }

  public static Uri a(Uri paramUri, Context paramContext)
  {
    if (dk.b(paramUri));
    try
    {
      Uri localUri = FileProvider.getUriForFile(paramContext, "com.viber.voip.provider.file", new File(paramUri.getPath()));
      paramUri = localUri;
      return paramUri;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      do
        a.a(localIllegalArgumentException, "toSafeExternalUri: failed to provide ");
      while (!com.viber.common.d.a.k());
    }
    return null;
  }

  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramActivity.startActivity(com.viber.voip.messages.m.a(paramString1, paramString2, paramString3, false, false, false, paramBoolean));
  }

  public static void a(Context paramContext)
  {
    ProcessPhoenix.a(paramContext, new Intent[] { b(paramContext) });
  }

  public static void a(Context paramContext, long paramLong)
  {
    new ar(paramContext).a(paramLong).a();
  }

  public static void a(Context paramContext, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool1 = c(paramContext);
    if (bool1)
      if (MapsInitializer.initialize(ViberApplication.getApplication()) != 0);
    while (true)
    {
      try
      {
        a(GoogleApiMapPreviewActivityV2.class, paramContext, paramLong1, paramInt1, paramInt2, paramLong2, paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
        bool2 = bool1;
        if (!bool2)
          a(WebMapPreViewActivity.class, paramContext, paramLong1, paramInt1, paramInt2, paramLong2, paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
        return;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        bool2 = false;
        continue;
      }
      boolean bool2 = false;
      continue;
      bool2 = bool1;
    }
  }

  public static void a(Context paramContext, long paramLong, String paramString)
  {
    new ar(paramContext).a(paramLong).a(paramString).a(2).a();
  }

  public static void a(Context paramContext, Intent paramIntent, Uri paramUri)
  {
    if (com.viber.common.d.a.g())
      paramIntent.addFlags(3);
    while (true)
    {
      return;
      if (com.viber.common.d.a.a())
      {
        paramIntent.setClipData(ClipData.newUri(paramContext.getContentResolver(), "", paramUri));
        paramIntent.addFlags(3);
        return;
      }
      Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).iterator();
      while (localIterator.hasNext())
        paramContext.grantUriPermission(((ResolveInfo)localIterator.next()).activityInfo.packageName, paramUri, 3);
    }
  }

  public static void a(Context paramContext, aa paramaa, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramaa.j();
    int j = paramaa.k();
    long l1 = paramaa.e();
    String str1 = paramaa.D();
    if ((paramaa.az()) || (paramaa.aA()))
      str1 = null;
    long l2 = paramaa.a();
    int m;
    String str2;
    if (paramaa.ay())
      if (paramaa.ao())
      {
        m = R.string.incoming_location_header;
        str2 = paramContext.getString(m);
      }
    while (true)
    {
      a(paramContext, l2, i, j, l1, str2, str1, paramBoolean2, paramBoolean1, false, paramaa.ag());
      return;
      m = R.string.outgoing_location_header;
      break;
      if (paramaa.ap())
      {
        str2 = paramContext.getString(R.string.msg_your_location);
      }
      else
      {
        int k = R.string.users_location;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramaa.bp();
        str2 = com.viber.common.d.c.b(paramContext.getString(k, arrayOfObject));
      }
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = com.viber.voip.messages.m.a(paramString1, paramString2, paramString3, false, false, false, false);
    localIntent.putExtra("go_up", true);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  public static void a(Context paramContext, ArrayList<String> paramArrayList, Carrier paramCarrier, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder;
    if ((paramBoolean1) && (!paramArrayList.isEmpty()))
      try
      {
        localStringBuilder = new StringBuilder();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          JSONObject localJSONObject = new JSONObject((String)localIterator.next());
          if (localJSONObject.has("product_id"))
            localStringBuilder.append(localJSONObject.getString("product_id")).append(",");
        }
      }
      catch (Exception localException)
      {
      }
    while (true)
    {
      Intent localIntent = new Intent(paramContext, CheckPurchaseActivity.class);
      localIntent.putStringArrayListExtra("products", paramArrayList);
      localIntent.putExtra("show_vo_special_dialog", paramBoolean1);
      localIntent.putExtra("show_vo_screen_on_complete", paramBoolean2);
      if (paramCarrier != null)
        localIntent.putExtra("carrier", paramCarrier);
      if (!(paramContext instanceof Activity))
        localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
      if (!da.a(localStringBuilder))
      {
        String str = localStringBuilder.substring(0, -1 + localStringBuilder.length());
        new com.viber.voip.analytics.story.m.g(com.viber.voip.analytics.g.a()).e(str);
      }
    }
  }

  public static void a(Fragment paramFragment, long paramLong, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.viber.voip.action.SAVE_FILE_TO_DIR");
    if (paramBoolean)
      localIntent = com.viber.voip.ui.c.c.a(localIntent);
    localIntent.putExtra("seq_extra", paramLong);
    localIntent.putExtra("extra_file_name", paramString);
    paramFragment.startActivityForResult(localIntent, 12);
  }

  public static void a(Fragment paramFragment, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.viber.voip.action.SEND_FILE");
    if (paramBoolean)
      localIntent = com.viber.voip.ui.c.c.a(localIntent);
    paramFragment.startActivityForResult(localIntent, 11);
  }

  public static void a(ConversationFragment paramConversationFragment, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramConversationFragment.getContext(), CustomCamTakeVideoActivity.class);
    ConversationData localConversationData = paramConversationFragment.P();
    if (localConversationData != null)
    {
      localIntent.putExtra("com.viber.voip.conversation_data", localConversationData);
      localIntent.putExtra("options", paramBundle);
      paramConversationFragment.startActivityForResult(localIntent, 103);
    }
  }

  private static void a(Class<?> paramClass, Context paramContext, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Intent localIntent = new Intent(paramContext, paramClass);
    localIntent.putExtra("message_id", paramLong1);
    localIntent.putExtra("user_lat", paramInt1);
    localIntent.putExtra("user_lng", paramInt2);
    localIntent.putExtra("location_date", paramLong2);
    localIntent.putExtra("user_name", paramString1);
    localIntent.putExtra("bucket_text", paramString2);
    localIntent.putExtra("show_bucket", paramBoolean1);
    localIntent.putExtra("show_share_menu", paramBoolean2);
    localIntent.putExtra("localityAccuracy", paramBoolean3);
    if (paramBoolean4)
      localIntent = com.viber.voip.ui.c.c.a(localIntent);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    dz.a(paramContext, localIntent);
  }

  public static boolean a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent);
    if (a(paramIntent, paramActivity))
    {
      paramActivity.startActivityForResult(paramIntent, paramInt);
      return true;
    }
    return false;
  }

  @SuppressLint({"MissingPermission"})
  public static boolean a(Activity paramActivity, Uri paramUri, int paramInt)
  {
    if (paramUri == null);
    Uri localUri;
    do
    {
      return false;
      localUri = a(paramUri, paramActivity);
    }
    while (localUri == null);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", localUri);
    a(paramActivity, localIntent, localUri);
    try
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(paramActivity, R.string.photo_no_camera, 0).show();
    }
    return false;
  }

  public static boolean a(Context paramContext, String paramString)
  {
    return (!da.a(paramString)) && (b(paramContext, new Intent("android.intent.action.VIEW", Uri.parse(paramString))));
  }

  public static boolean a(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null)
      paramContext = ViberApplication.getApplication();
    List localList = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (localList != null) && (localList.size() > 0);
  }

  @SuppressLint({"MissingPermission"})
  public static boolean a(Fragment paramFragment, Uri paramUri, int paramInt)
  {
    if (paramUri == null);
    Uri localUri;
    do
    {
      return false;
      localUri = a(paramUri, paramFragment.getActivity());
    }
    while (localUri == null);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", localUri);
    a(paramFragment.getActivity(), localIntent, localUri);
    try
    {
      paramFragment.startActivityForResult(localIntent, paramInt);
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(paramFragment.getActivity(), R.string.photo_no_camera, 0).show();
    }
    return false;
  }

  public static Intent b(Context paramContext)
  {
    Intent localIntent = new Intent().setAction("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").addFlags(32768);
    if (y.e());
    for (Class localClass = y.d(); ; localClass = y.a())
      return localIntent.setClass(paramContext, localClass);
  }

  public static void b(Context paramContext, long paramLong, String paramString)
  {
    new ar(paramContext).a(paramLong).a(paramString).a(3).a();
  }

  public static boolean b(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent);
    if (a(paramIntent, paramContext))
    {
      paramContext.startActivity(paramIntent);
      return true;
    }
    return false;
  }

  public static void c(Context paramContext, long paramLong, String paramString)
  {
    new ar(paramContext).a(paramString).a(paramLong).a(1).a();
  }

  public static void c(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
      return;
    try
    {
      if ((!ViberApplication.getInstance().getHardwareParameters().isGsmSupported()) && (("android.intent.action.CALL".equals(paramIntent.getAction())) || ("android.intent.action.SENDTO".equals(paramIntent.getAction())) || ("android.intent.action.VIEW".equals(paramIntent.getAction()))))
      {
        k.c().a(paramContext);
        return;
      }
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
    }
  }

  private static boolean c(Context paramContext)
  {
    if (ax.b(paramContext) == 0);
    for (int i = 1; ; i = 0)
    {
      boolean bool = d.ad.n.d();
      if ((i == 0) || (bool))
        break;
      return true;
    }
    return false;
  }

  public static final class PublicAccountInviteData
    implements Parcelable
  {
    public static final Parcelable.Creator<PublicAccountInviteData> CREATOR = new Parcelable.Creator()
    {
      public ViberActionRunner.PublicAccountInviteData a(Parcel paramAnonymousParcel)
      {
        return new ViberActionRunner.PublicAccountInviteData(paramAnonymousParcel);
      }

      public ViberActionRunner.PublicAccountInviteData[] a(int paramAnonymousInt)
      {
        return new ViberActionRunner.PublicAccountInviteData[paramAnonymousInt];
      }
    };
    public static final String EXTRA_PA_INVITE_DATA = "pa_invite_data";
    private int invitedTo;
    private long mGroupId;
    private String mGroupUri;

    public PublicAccountInviteData()
    {
    }

    protected PublicAccountInviteData(Parcel paramParcel)
    {
      this.mGroupId = paramParcel.readLong();
      this.mGroupUri = paramParcel.readString();
      this.invitedTo = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    public long getGroupId()
    {
      return this.mGroupId;
    }

    public String getGroupUri()
    {
      return this.mGroupUri;
    }

    public int getInvitedTo()
    {
      return this.invitedTo;
    }

    public void setGroupId(long paramLong)
    {
      this.mGroupId = paramLong;
    }

    public void setGroupUri(String paramString)
    {
      this.mGroupUri = paramString;
    }

    public void setInvitedTo(int paramInt)
    {
      this.invitedTo = paramInt;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.mGroupId);
      paramParcel.writeString(this.mGroupUri);
      paramParcel.writeInt(this.invitedTo);
    }
  }

  public static abstract interface a
  {
    public abstract void a(Context paramContext);
  }

  public static class aa
  {
    public static void a(Fragment paramFragment, FragmentManager paramFragmentManager, o.a parama)
    {
      a(paramFragment, paramFragmentManager, parama, Bundle.EMPTY);
    }

    public static void a(Fragment paramFragment, FragmentManager paramFragmentManager, o.a parama, Bundle paramBundle)
    {
      if ((paramFragment != null) && (!ViberApplication.isTablet(ViberApplication.getApplication())))
      {
        FragmentActivity localFragmentActivity = paramFragment.getActivity();
        com.viber.voip.n.a.d(localFragmentActivity);
        if (((localFragmentActivity instanceof ViberFragmentActivity)) && (localFragmentActivity.getResources().getConfiguration().orientation != 1))
        {
          Bundle localBundle2 = new Bundle();
          localBundle2.putBundle("pin_dialog_data", paramBundle);
          localBundle2.putInt("pin_dialog_mode", parama.ordinal());
          ((ViberFragmentActivity)localFragmentActivity).setPinDialogData(localBundle2);
          return;
        }
      }
      Bundle localBundle1 = new Bundle();
      localBundle1.putInt("screen_mode", parama.ordinal());
      localBundle1.putBundle("bundle_data", paramBundle);
      if (paramFragmentManager == null)
        paramFragmentManager = paramFragment.getFragmentManager();
      if (paramFragment == null)
      {
        t.l().a(new ViberDialogHandlers.cj()).a(localBundle1).a(paramFragmentManager);
        return;
      }
      t.l().a(paramFragment).a(localBundle1).b(paramFragment);
    }
  }

  public static class ab
  {
    public static Intent a()
    {
      return new Intent("com.viber.voip.action.NEWS");
    }

    public static Intent a(Context paramContext)
    {
      return new Intent("com.viber.voip.action.MESSAGES");
    }

    public static Intent a(Context paramContext, CommunityFollowerData paramCommunityFollowerData)
    {
      return a(paramContext).putExtra("extra_community_follower_data", paramCommunityFollowerData);
    }

    public static Intent a(String paramString, Context paramContext)
    {
      Intent localIntent = new Intent("com.viber.voip.action.DIALER");
      localIntent.putExtra("open_keypad_number", paramString);
      return localIntent;
    }

    public static Class a(boolean paramBoolean)
    {
      if ((paramBoolean) && (y.c()))
        return y.b();
      return y.a();
    }

    public static void a(Context paramContext, boolean paramBoolean)
    {
      Intent localIntent = new Intent(paramContext, a(paramBoolean));
      localIntent.setAction("android.intent.action.MAIN");
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      paramContext.startActivity(localIntent);
    }

    public static Intent b(Context paramContext)
    {
      Intent localIntent = new Intent("com.viber.voip.action.CONTACTS");
      localIntent.putExtra("filter", b.b.b.ordinal());
      return localIntent;
    }

    public static Intent c(Context paramContext)
    {
      Intent localIntent = new Intent("com.viber.voip.action.CONTACTS");
      localIntent.putExtra("filter", b.b.a.ordinal());
      return localIntent;
    }

    public static Intent d(Context paramContext)
    {
      Intent localIntent = new Intent("com.viber.voip.action.CONTACTS");
      localIntent.putExtra("scroll_to_my_number", true);
      return localIntent;
    }

    public static Intent e(Context paramContext)
    {
      return new Intent("com.viber.voip.action.DIALER");
    }

    public static Intent f(Context paramContext)
    {
      return new Intent(paramContext, RecentCallsActivity.class);
    }
  }

  public static class ac
  {
    public static boolean a(Context paramContext)
    {
      File localFile = new File(Environment.getExternalStorageDirectory() + "/contacts.vcf");
      if (!localFile.exists());
      Intent localIntent;
      Uri localUri;
      do
      {
        return false;
        localIntent = new Intent("android.intent.action.VIEW");
        localUri = com.viber.common.d.d.a(Uri.fromFile(localFile), paramContext, "com.viber.voip.provider.file");
      }
      while (localUri == null);
      localIntent.setDataAndType(localUri, "text/x-vcard");
      localIntent.addFlags(1);
      return ViberActionRunner.b(paramContext, localIntent);
    }
  }

  public static class ad
    implements ViberActionRunner.a
  {
    private int a;
    private Intent b;

    public ad(Intent paramIntent)
    {
      this(paramIntent, 0);
    }

    public ad(Intent paramIntent, int paramInt)
    {
      this.b = paramIntent;
      this.a = paramInt;
    }

    public void a(Context paramContext)
    {
      Intent localIntent = new Intent(this.b);
      switch (this.a)
      {
      case 2:
      default:
        if (!(paramContext instanceof Activity))
          this.b.addFlags(268435456);
        a(paramContext, this.b);
        return;
      case 3:
        paramContext.sendBroadcast(localIntent);
        return;
      case 1:
      }
      com.viber.common.app.a.b(paramContext, localIntent);
    }

    protected void a(Context paramContext, Intent paramIntent)
    {
      paramContext.startActivity(paramIntent);
    }
  }

  public static class ae
  {
    public static void a(Context paramContext, boolean paramBoolean, Action paramAction)
    {
      Intent localIntent = new Intent(paramContext, InternalActionActivity.class);
      if (!(paramContext instanceof Activity))
        localIntent.addFlags(268435456);
      localIntent.putExtra("is_hidden", paramBoolean);
      localIntent.putExtra("internal_action", paramAction);
      paramContext.startActivity(localIntent);
    }
  }

  public static class af
  {
    public static Intent a(Context paramContext, String paramString1, String paramString2)
    {
      Intent localIntent = new Intent(paramContext, InviteActivity.class);
      if (paramString1 != null)
        localIntent.putExtra("text", paramString1);
      localIntent.putExtra("source_extra", paramString2);
      return localIntent;
    }

    public static Intent a(Context paramContext, String paramString, boolean paramBoolean)
    {
      if (paramBoolean);
      for (int i = R.string.join_community_on_viber; ; i = R.string.share_group_text)
      {
        String str = paramContext.getString(i, new Object[] { paramString });
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setType("text/plain");
        localIntent.putExtra("android.intent.extra.TEXT", str);
        return localIntent;
      }
    }

    public static void a(Activity paramActivity, long paramLong1, long paramLong2, int paramInt, String paramString, boolean paramBoolean)
    {
      Object localObject;
      if (paramInt == 5)
      {
        localObject = ShareCommunityFollowerLinkActivity.class;
        if (!paramBoolean)
          break label43;
      }
      label43: for (int i = 100; ; i = -1)
      {
        a(paramActivity, (Class)localObject, paramLong1, paramLong2, paramInt, paramString, paramBoolean, i);
        return;
        localObject = ShareGroupLinkActivity.class;
        break;
      }
    }

    public static void a(Activity paramActivity, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
    {
      a(paramActivity, paramConversationItemLoaderEntity.getGroupId(), paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getConversationType(), null, false);
    }

    public static void a(Activity paramActivity, ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString, boolean paramBoolean)
    {
      a(paramActivity, paramConversationItemLoaderEntity.getGroupId(), paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getConversationType(), paramString, paramBoolean);
    }

    private static void a(Activity paramActivity, Class<? extends Activity> paramClass, long paramLong1, long paramLong2, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      Intent localIntent = new Intent(paramActivity, paramClass);
      new InviteLinkData(paramLong1, paramLong2, paramInt1, paramBoolean).writeTo(localIntent);
      if (paramString != null)
        localIntent.putExtra("share_entry_point_extra_key", paramString);
      if (paramBoolean)
      {
        ViberActionRunner.a(paramActivity, localIntent, paramInt2);
        return;
      }
      ViberActionRunner.b(paramActivity, localIntent);
    }

    public static void a(Context paramContext, long paramLong, AddGroupDetailsPresenter.AddDetailsGoNextAction paramAddDetailsGoNextAction)
    {
      Intent localIntent = new Intent(paramContext, GroupAddDetailsActivity.class);
      localIntent.putExtra("conversation_id", paramLong);
      localIntent.putExtra("add_details_action", paramAddDetailsGoNextAction);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void a(Context paramContext, String paramString)
    {
      Intent localIntent = new InvitationCreator(paramContext).createShareInviteIntent(paramString, R.string.invite_mail_subject, true);
      if (localIntent != null)
      {
        if (!com.viber.common.d.a.h())
        {
          com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.h(""));
          com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.i(""));
          ViberApplication.getInstance().getEngine(false).getCdrController().handleReportShareInvitationNativeMenu(null, 1);
        }
        ViberActionRunner.b(paramContext, localIntent);
      }
    }

    public static void a(Context paramContext, List<String> paramList)
    {
      a(paramContext, paramList, null);
    }

    public static void a(Context paramContext, List<String> paramList, String paramString)
    {
      Intent localIntent = InvitationCreator.createShareSmsIntent(paramContext, paramList, paramString);
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.h("sms"));
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.i("sms"));
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.b.a("sms"));
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportShareInvitationNativeMenu("sms", 1);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static Intent b(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("text/plain");
      localIntent.putExtra("android.intent.extra.TEXT", paramString);
      return localIntent;
    }

    public static void c(Context paramContext, String paramString)
    {
      ViberActionRunner.b(paramContext, a(paramContext, null, paramString));
    }
  }

  public static class ag
  {
    public static int a(Context paramContext, PublicAccount.ExtraInfo.JokerButton.Action paramAction)
    {
      int i = -1;
      if (paramAction != null)
      {
        if (!paramAction.isWebType())
          break label36;
        if (!da.a(paramAction.getUrl()))
        {
          GenericWebViewActivity.a(paramContext, paramAction.getUrl(), null);
          i = 1;
        }
      }
      label36: 
      while ((!paramAction.isAppType()) || (da.a(paramAction.getPackageName())))
        return i;
      if (cc.a().contains(paramAction.getPackageName()))
      {
        if (!da.a(paramAction.getUrl()))
        {
          localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramAction.getUrl()));
          localIntent.addFlags(268435456);
          if (ViberActionRunner.a(localIntent, null));
        }
        for (Intent localIntent = cc.a(paramAction.getPackageName()); ; localIntent = cc.a(paramAction.getPackageName()))
        {
          ViberApplication.getApplication().startActivity(localIntent);
          return 2;
        }
      }
      ViberActionRunner.f.a(ViberApplication.getApplication(), paramAction.getPackageName());
      return 3;
    }
  }

  public static class ah
  {
    public static void a(Context paramContext, PendingIntent paramPendingIntent, long paramLong1, long paramLong2)
    {
      paramContext.startActivity(new Intent(paramContext, KeyguardUnlockWaitActivity.class).putExtra("pending_intent", paramPendingIntent).putExtra("conversation_id", paramLong1).putExtra("contact_id", paramLong2).addFlags(335577088));
    }
  }

  public static class ai
  {
    public static void a(Context paramContext, com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Map paramMap)
    {
      if (paramMap == null)
        return;
      String str1 = Double.toString(paramMap.getLatitude().doubleValue());
      String str2 = Double.toString(paramMap.getLongitude().doubleValue());
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.US, "geo:%s,%s?q=%s,%s", new Object[] { str1, str2, str1, str2 })));
      if (localIntent.resolveActivity(paramContext.getPackageManager()) == null)
        localIntent.setData(Uri.parse(String.format(Locale.US, "http://maps.google.com/maps?ll=%s,%s", new Object[] { str1, str2 })));
      paramContext.startActivity(ViberActionRunner.a(paramContext, localIntent));
    }

    public static boolean a(Fragment paramFragment, BotReplyRequest paramBotReplyRequest)
    {
      Intent localIntent = ViberActionRunner.a(paramFragment.getContext(), 2);
      if (localIntent == null)
        return false;
      localIntent.putExtra("fromConversation", true);
      localIntent.putExtra("extra_bot_reply_pending_request", paramBotReplyRequest);
      if (paramBotReplyRequest.isSystemConversation)
        localIntent = com.viber.voip.ui.c.c.a(localIntent);
      paramFragment.startActivityForResult(localIntent, 105);
      return true;
    }
  }

  public static class aj
  {
    public static boolean a(Context paramContext, MediaPlayer paramMediaPlayer)
    {
      return (paramMediaPlayer != null) && (1 == paramMediaPlayer.getPlayerType()) && (paramMediaPlayer.d()) && (ViberActionRunner.a(paramContext, paramMediaPlayer.getSourceUrl()));
    }

    public static boolean b(Context paramContext, MediaPlayer paramMediaPlayer)
    {
      return (paramMediaPlayer != null) && (1 == paramMediaPlayer.getPlayerType()) && (ViberActionRunner.a(paramContext, paramMediaPlayer.getSourceUrl()));
    }
  }

  public static class ak
  {
    public static void a(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent(paramContext, MyQRCodeActivity.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("analytics_add_contact_entry_point", paramString);
      paramContext.startActivity(localIntent);
    }
  }

  public static class al
  {
    private static Intent a(Uri paramUri)
    {
      return new Intent("android.intent.action.EDIT", paramUri);
    }

    private static void a(Context paramContext, Intent paramIntent)
    {
      try
      {
        paramContext.startActivity(paramIntent);
        return;
      }
      catch (Exception localException)
      {
        Toast.makeText(paramContext, R.string.action_not_supported, 1).show();
      }
    }

    public static void a(Context paramContext, Uri paramUri)
    {
      a(paramContext, a(paramUri));
    }

    public static void a(Context paramContext, Uri paramUri, String paramString)
    {
      Intent localIntent = a(paramUri);
      localIntent.putExtra("phone", paramString);
      localIntent.putExtra("phone_type", 2);
      a(paramContext, localIntent);
    }
  }

  public static class am
  {
    public static Intent a(Context paramContext)
    {
      Intent localIntent = new Intent(paramContext, NotificationsBroadcastReceiver.class);
      localIntent.setAction("com.viber.voip.action.APPROVE_SYNC_HISTORY_TO_DESKTOP_NOTIFICATION_CANCELED_ACTION");
      return localIntent;
    }

    public static Intent a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
    {
      Intent localIntent = new Intent(paramContext, NotificationsBroadcastReceiver.class);
      localIntent.setAction("com.viber.voip.action.COMMUNITY_MESSAGE_NOTIFICATION_CANCELED_ACTION");
      localIntent.putExtra("extra_group_id", paramLong1);
      localIntent.putExtra("conversation_id", paramLong2);
      localIntent.putExtra("unread_message_ids", paramInt);
      return localIntent;
    }

    public static Intent a(Context paramContext, Intent paramIntent, int paramInt)
    {
      Intent localIntent = new Intent(paramContext, PendingIntentBroadcastReceiver.class);
      localIntent.addFlags(268435456);
      localIntent.setAction("com.viber.voip.action.NOTIFICATION_INTENT_ACTION");
      localIntent.putExtra("extra_real_intent", com.viber.common.d.g.a(paramIntent));
      localIntent.putExtra("extra_intent_type", paramInt);
      return localIntent;
    }

    public static Intent a(Context paramContext, Member paramMember, MessageEntity paramMessageEntity)
    {
      Intent localIntent = new Intent(paramContext, NotificationsBroadcastReceiver.class);
      localIntent.setAction("com.viber.voip.action.INLINE_SEND_MESSAGE_ACTION");
      localIntent.putExtra("member_id", paramMember.getId());
      localIntent.putExtra("conversation_type", 0);
      localIntent.putExtra("latest_message", paramMessageEntity);
      return localIntent;
    }

    public static Intent a(Context paramContext, MessageEntity paramMessageEntity)
    {
      Intent localIntent = new Intent(paramContext, NotificationsBroadcastReceiver.class);
      localIntent.setAction("com.viber.voip.action.SEND_LIKE");
      localIntent.putExtra("message_entity", paramMessageEntity);
      return localIntent;
    }

    public static Intent a(Context paramContext, com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity)
    {
      Intent localIntent = new Intent(paramContext, NotificationsBroadcastReceiver.class);
      localIntent.setAction("com.viber.voip.action.INLINE_REPLY_MESSAGE_ACTION");
      localIntent.putExtra("conversation_id", paramh.getId());
      localIntent.putExtra("group_id", paramh.k());
      localIntent.putExtra("conversation_type", paramh.j());
      localIntent.putExtra("member_id", paramm.a());
      localIntent.putExtra("latest_message", paramMessageEntity);
      return localIntent;
    }

    public static Intent a(Context paramContext, LongSparseSet paramLongSparseSet)
    {
      Intent localIntent = new Intent(paramContext, NotificationsBroadcastReceiver.class);
      localIntent.setAction("com.viber.voip.action.LIKE_NOTIFICATION_CANCELED");
      localIntent.putExtra("unread_conversation_ids", paramLongSparseSet.toArray());
      return localIntent;
    }

    public static void a(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
      localIntent.putExtra("android.provider.extra.CHANNEL_ID", paramString);
      localIntent.putExtra("android.provider.extra.APP_PACKAGE", paramContext.getPackageName());
      paramContext.startActivity(localIntent);
    }

    public static Intent b(Context paramContext, MessageEntity paramMessageEntity)
    {
      Intent localIntent = new Intent(paramContext, NotificationsBroadcastReceiver.class);
      localIntent.setAction("com.viber.voip.action.MARK_AS_READ");
      localIntent.putExtra("message_entity", paramMessageEntity);
      return localIntent;
    }

    public static Intent b(Context paramContext, LongSparseSet paramLongSparseSet)
    {
      Intent localIntent = new Intent(paramContext, NotificationsBroadcastReceiver.class);
      localIntent.setAction("com.viber.voip.action.MESSAGE_NOTIFICATION_CANCELED_ACTION");
      localIntent.putExtra("unread_message_ids", paramLongSparseSet.toArray());
      return localIntent;
    }
  }

  public static class an
  {
    public static void a(Context paramContext, long paramLong)
    {
      Intent localIntent = new Intent(paramContext, BannedParticipantsListActivity.class);
      localIntent.putExtra("extra_conversation_id", paramLong);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void a(Context paramContext, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
    {
      Intent localIntent = new Intent(paramContext, ParticipantsSettingsActivity.class);
      localIntent.putExtra("thread_id", paramConversationItemLoaderEntity.getId());
      localIntent.putExtra("extra_group_id", paramConversationItemLoaderEntity.getGroupId());
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void b(Context paramContext, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
    {
      Intent localIntent = new Intent(paramContext, ParticipantsListActivity.class);
      localIntent.putExtra("extra_conversation_id", paramConversationItemLoaderEntity.getId());
      localIntent.putExtra("extra_conversation_type", paramConversationItemLoaderEntity.getConversationType());
      localIntent.putExtra("extra_group_role", paramConversationItemLoaderEntity.getGroupRole());
      localIntent.putExtra("extra_group_id", paramConversationItemLoaderEntity.getGroupId());
      ViberActionRunner.b(paramContext, localIntent);
    }
  }

  public static class ao
  {
    public static void a(Context paramContext, String[] paramArrayOfString, int paramInt, PendingIntent paramPendingIntent)
    {
      paramContext.startActivity(new Intent(paramContext, IsolatedPermissionHandlerActivity.class).putExtra("permissions", paramArrayOfString).putExtra("request_code", paramInt).putExtra("on_permission_granted_intent", paramPendingIntent).addFlags(268435456));
    }
  }

  public static class ap
  {
    public static Intent a(com.viber.voip.model.entity.h paramh)
    {
      Intent localIntent = new Intent("com.viber.voip.action.MESSAGE_POPUP");
      localIntent.setFlags(268435456);
      localIntent.putExtra("conversation_id_extra", paramh.getId());
      return localIntent;
    }

    public static Intent a(com.viber.voip.model.entity.h paramh, boolean paramBoolean)
    {
      Intent localIntent = a(paramh);
      localIntent.putExtra("open_keyboard_extra", paramBoolean);
      return localIntent;
    }

    public static void a(Context paramContext, com.viber.voip.model.entity.h paramh)
    {
      com.viber.common.app.a.a(paramContext, a(paramh));
    }
  }

  public static final class aq
  {
    public static Intent a()
    {
      return b(-1L);
    }

    public static Intent a(long paramLong)
    {
      Intent localIntent = new Intent("com.viber.voip.action.EDIT_PUBLIC_ACCOUNT");
      localIntent.putExtra("thread_id", paramLong);
      return localIntent;
    }

    private static Intent a(Context paramContext, long paramLong)
    {
      Intent localIntent = new Intent("com.viber.voip.action.INFO_PUBLIC_ACCOUNT");
      localIntent.putExtra("thread_id", paramLong);
      ViberActionRunner.a(paramContext, localIntent);
      return localIntent;
    }

    public static Intent a(Context paramContext, com.viber.voip.model.entity.h paramh)
    {
      return a(paramContext, paramh.getId());
    }

    public static Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, PublicGroupConversationData paramPublicGroupConversationData)
    {
      if (paramBoolean2)
        return com.viber.voip.messages.m.a(paramPublicGroupConversationData, paramBoolean1);
      return c(paramContext, paramPublicGroupConversationData.publicGroupInfo.getGroupUri());
    }

    public static Intent a(String paramString)
    {
      return new Intent("android.intent.action.VIEW", Uri.parse(com.viber.voip.api.scheme.i.b(paramString)));
    }

    public static void a(Activity paramActivity)
    {
      if (paramActivity == null)
        return;
      a(new a(paramActivity));
    }

    public static void a(Activity paramActivity, Parcelable paramParcelable, ae paramae, int paramInt)
    {
      String str = ap.c().aK;
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Locale.getDefault().getLanguage();
      Intent localIntent = TermsAndConditionsActivity.a(paramActivity, String.format(localLocale, str, arrayOfObject), paramActivity.getResources().getString(R.string.dialog_button_view_terms_of_use), null, null, TermsAndConditionsActivity.a.f, paramae);
      localIntent.putExtra("data", paramParcelable);
      dz.a(paramActivity, localIntent, paramInt);
    }

    public static void a(final Activity paramActivity, com.viber.voip.analytics.c.a.a parama)
    {
      av.a(av.e.f).post(new Runnable()
      {
        public void run()
        {
          boolean bool1 = true;
          if (ab.b().C() > 0L);
          for (boolean bool2 = bool1; (bool2) && (this.a != com.viber.voip.analytics.c.a.a.b); bool2 = false)
          {
            Intent localIntent = ViberActionRunner.aq.b();
            paramActivity.startActivity(localIntent);
            paramActivity.overridePendingTransition(0, 0);
            return;
          }
          if ((c.l.a.e()) && (!bool2));
          while (true)
          {
            ViberActionRunner.aq.a(paramActivity, null, bool1, 0);
            return;
            bool1 = false;
          }
        }
      });
    }

    public static void a(Context paramContext)
    {
      a(paramContext, null, c.l.a.e(), 0);
    }

    public static void a(Context paramContext, ConversationData paramConversationData)
    {
      paramContext.startActivity(b(paramContext, paramConversationData));
    }

    public static void a(Context paramContext, PublicAccount paramPublicAccount)
    {
      paramContext.startActivity(a(paramPublicAccount.getGroupUri()));
    }

    public static void a(Context paramContext, PublicAccount paramPublicAccount, String paramString)
    {
      Intent localIntent = ViberActionRunner.be.b(paramContext, paramString);
      paramContext.startActivities(new Intent[] { c(paramContext, paramPublicAccount), localIntent });
    }

    public static void a(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent(paramContext, SetupInboxWizardActivity.class);
      localIntent.putExtra("extra_public_account_id", paramString);
      paramContext.startActivity(localIntent);
    }

    public static void a(Context paramContext, String paramString, int paramInt, Intent paramIntent)
    {
      int i = cd.j(paramInt);
      com.viber.voip.model.entity.m localm = com.viber.voip.messages.d.c.c().c(paramString, i);
      if (localm == null)
        return;
      Intent localIntent = PublicGroupParticipantDetailsActivity.buildIntentForSingleShowing(paramContext, com.viber.voip.messages.d.c.c().a(paramString, i), localm.a(2, 1));
      localIntent.putExtra("action_intent", paramIntent);
      ViberActionRunner.a(paramContext, localIntent);
      paramContext.startActivity(localIntent);
    }

    public static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
    {
      if (paramContext != null)
      {
        Intent localIntent = ExplorePublicGroupsActivity.a(paramString, paramBoolean, false, null);
        localIntent.addFlags(paramInt);
        dz.a(paramContext, localIntent);
      }
    }

    public static void a(Fragment paramFragment, long paramLong)
    {
      if (com.viber.voip.publicaccount.d.e.a(paramFragment, true))
      {
        Intent localIntent = a(paramLong);
        ViberActionRunner.a(paramFragment.getActivity(), localIntent);
        paramFragment.startActivity(localIntent);
      }
    }

    public static void a(b paramb)
    {
      UserData localUserData = UserManager.from(paramb.c()).getUserData();
      if ((da.a(localUserData.getViberName())) || (da.a(localUserData.getViberImage())))
      {
        paramb.a();
        return;
      }
      paramb.b();
    }

    public static Intent b()
    {
      return new Intent("com.viber.voip.action.PUBLIC_GROUP");
    }

    public static Intent b(long paramLong)
    {
      Intent localIntent = new Intent("com.viber.voip.action.CREATE_PUBLIC_ACCOUNT");
      localIntent.putExtra("extra_creation_started_timestamp", paramLong);
      return localIntent;
    }

    private static Intent b(Context paramContext, ConversationData paramConversationData)
    {
      return a(paramContext, paramConversationData.conversationId);
    }

    public static void b(Activity paramActivity)
    {
      a(paramActivity, null);
    }

    public static void b(Context paramContext, com.viber.voip.model.entity.h paramh)
    {
      paramContext.startActivity(a(paramContext, paramh));
    }

    public static void b(Context paramContext, PublicAccount paramPublicAccount)
    {
      paramContext.startActivity(c(paramContext, paramPublicAccount));
    }

    public static void b(Context paramContext, String paramString)
    {
      paramContext.startActivity(a(paramString));
    }

    private static Intent c(Context paramContext, PublicAccount paramPublicAccount)
    {
      Intent localIntent = a(paramContext, paramPublicAccount.getConversationId());
      localIntent.putExtra("extra_public_account", paramPublicAccount);
      return localIntent;
    }

    public static Intent c(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent("com.viber.voip.action.INFO_PUBLIC_ACCOUNT");
      localIntent.putExtra("extra_public_account_uri", paramString);
      ViberActionRunner.a(paramContext, localIntent);
      return localIntent;
    }

    public static void d(Context paramContext, String paramString)
    {
      paramContext.startActivity(c(paramContext, paramString));
    }

    public static class a
      implements ViberActionRunner.aq.b
    {
      protected final Context a;
      protected final long b;

      public a(Context paramContext)
      {
        this(paramContext, -1L);
      }

      public a(Context paramContext, long paramLong)
      {
        this.a = paramContext;
        this.b = paramLong;
      }

      public void a()
      {
        com.viber.common.dialogs.a.a locala = r.h().a(new ViberDialogHandlers.i());
        if ((this.a instanceof FragmentActivity))
        {
          locala.a(this.a);
          return;
        }
        locala.d();
      }

      public void b()
      {
        Intent localIntent = ViberActionRunner.aq.b(this.b);
        ViberActionRunner.a(this.a, localIntent);
        this.a.startActivity(localIntent);
      }

      public Context c()
      {
        return this.a;
      }
    }

    public static abstract interface b
    {
      public abstract void a();

      public abstract void b();

      public abstract Context c();
    }
  }

  private static final class ar
  {
    private Context a;
    private ViberActionRunner.PublicAccountInviteData b = new ViberActionRunner.PublicAccountInviteData();

    ar(Context paramContext)
    {
      this.a = paramContext;
    }

    ar a(int paramInt)
    {
      this.b.setInvitedTo(paramInt);
      return this;
    }

    ar a(long paramLong)
    {
      this.b.setGroupId(paramLong);
      return this;
    }

    ar a(String paramString)
    {
      this.b.setGroupUri(paramString);
      return this;
    }

    void a()
    {
      Intent localIntent = new Intent("com.viber.voip.action.INVITE_TO_PUBLIC_GROUP");
      localIntent.putExtra("pa_invite_data", this.b);
      if (!da.a(this.b.mGroupUri));
      for (boolean bool = true; ; bool = false)
      {
        localIntent.putExtra("enable_communities_extra", bool);
        this.a.startActivity(localIntent);
        return;
      }
    }
  }

  public static class as
  {
    public static void a(Context paramContext)
    {
      if (com.viber.voip.notif.i.i.a())
        return;
      Intent localIntent = new Intent(paramContext, WakeUpViberActivity.class);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent, ActivityOptionsCompat.makeCustomAnimation(paramContext, 0, 0).toBundle());
    }
  }

  public static class at
  {
    public static void a(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent(paramContext, RakutenAccountWebViewActivity.class);
      localIntent.putExtra("url", paramString);
      dz.a(paramContext, localIntent);
    }
  }

  public static class au
  {
    public static Intent a(Context paramContext)
    {
      return new Intent(paramContext, RegistrationReminderMessageReceiver.class);
    }

    public static Intent a(ActivationController.ActivationCode paramActivationCode, Context paramContext)
    {
      Intent localIntent = b(paramContext);
      if (!ActivationController.ActivationCode.isEmpty(paramActivationCode))
        localIntent.putExtra("activation_code", paramActivationCode);
      return localIntent;
    }

    private static void a(Intent paramIntent, Context paramContext)
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }

    public static void a(boolean paramBoolean, Context paramContext)
    {
      Intent localIntent = b(paramContext);
      localIntent.putExtra("came_from_secondary", paramBoolean);
      a(localIntent, paramContext);
    }

    public static Intent b(Context paramContext)
    {
      return new Intent(paramContext, RegistrationActivity.class);
    }

    public static void b(ActivationController.ActivationCode paramActivationCode, Context paramContext)
    {
      a(a(paramActivationCode, paramContext), paramContext);
    }

    public static void c(Context paramContext)
    {
      a(b(paramContext), paramContext);
    }
  }

  public static class av
  {
    public static void a()
    {
      com.viber.voip.fcm.f localf = ViberApplication.getInstance().getRetrieveDataOnRestrictBGHandler(null);
      if (localf != null)
        localf.a();
    }

    public static void a(com.viber.voip.c.a parama, java.util.Map paramMap)
    {
      com.viber.voip.fcm.f localf = ViberApplication.getInstance().getRetrieveDataOnRestrictBGHandler(parama);
      if (localf != null)
        localf.a(paramMap);
    }
  }

  public static class aw
  {
    public static Intent a(boolean paramBoolean, String paramString1, String paramString2, Context paramContext)
    {
      Intent localIntent = new Intent(paramContext, ScannerActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("show_my_qr_code_link", paramBoolean);
      localBundle.putString("analytics_add_contact_entry_point", paramString1);
      localBundle.putString("analytics_connect_secondary_entry_point", paramString2);
      localIntent.putExtras(localBundle);
      localIntent.addFlags(67108864);
      if (!(paramContext instanceof Activity))
        localIntent.addFlags(268435456);
      return localIntent;
    }

    public static void a(Context paramContext, String paramString1, String paramString2)
    {
      a(false, paramContext, paramString1, paramString2);
    }

    public static void a(boolean paramBoolean, Context paramContext, String paramString1, String paramString2)
    {
      paramContext.startActivity(a(paramBoolean, paramString1, paramString2, paramContext));
    }

    public static Intent b(Context paramContext, String paramString1, String paramString2)
    {
      return a(false, paramString1, paramString2, paramContext);
    }
  }

  public static class ax
  {
    public static void a(Fragment paramFragment, int paramInt, String paramString, long paramLong)
    {
      Intent localIntent = new Intent(paramFragment.getActivity(), SelectLanguageActivity.class);
      localIntent.putExtra("selected_lang", paramString);
      localIntent.putExtra("selected_msg", paramLong);
      paramFragment.startActivityForResult(localIntent, paramInt);
    }

    public static void a(Fragment paramFragment, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      Intent localIntent = new Intent(paramFragment.getActivity(), SelectUiLanguageActivity.class);
      localIntent.putExtra("selected_lang", paramString);
      localIntent.putExtra("from_url_scheme", paramBoolean1);
      localIntent.putExtra("from_url_scheme_with_language", paramBoolean2);
      paramFragment.startActivityForResult(localIntent, paramInt);
    }
  }

  public static class ay
  {
    public static void a(Context paramContext)
    {
      ViberActionRunner.c(paramContext, new Intent("com.viber.voip.action.ABOUT"));
    }

    public static void a(Context paramContext, int paramInt)
    {
      Intent localIntent = new Intent(paramContext, ManageStorageActivity.class);
      localIntent.putExtra("extra_source", paramInt);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void a(Context paramContext, long paramLong, int paramInt)
    {
      Intent localIntent = new Intent(paramContext, ManageConversationStorageActivity.class);
      localIntent.putExtra("extra_conversation_id", paramLong);
      localIntent.putExtra("extra_source", paramInt);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void b(Context paramContext)
    {
      av.e.f.a().post(new Runnable()
      {
        public void run()
        {
          ad.b().a(R.id.message, "Preparing logs...").b(false).d();
          try
          {
            cv.a().h();
            label24: ViberEnv.getLoggerFactory().flush();
            try
            {
              String str1 = this.a.getResources().getString(R.string.crash_mail_subj);
              String str2 = this.a.getResources().getString(R.string.crash_mail_body);
              com.viber.a.a.a.a(this.a, str1, str2);
              label71: z.a(ViberApplication.getApplication(), DialogCode.D_PROGRESS);
              return;
            }
            catch (Exception localException2)
            {
              break label71;
            }
          }
          catch (Exception localException1)
          {
            break label24;
          }
        }
      });
    }

    public static void c(Context paramContext)
    {
      if (com.viber.common.d.a.j())
      {
        localIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + paramContext.getPackageName()));
        if (ViberActionRunner.a(localIntent, paramContext));
      }
      for (Intent localIntent = new Intent("android.settings.SETTINGS"); ; localIntent = new Intent("android.settings.SETTINGS"))
      {
        ViberActionRunner.a(paramContext, localIntent);
        paramContext.startActivity(localIntent);
        return;
      }
    }

    public static void d(Context paramContext)
    {
      ViberActionRunner.b(paramContext, new Intent(paramContext, RequestYourDataSettingsActivity.class));
    }

    public static void e(Context paramContext)
    {
      paramContext.startActivity(f(paramContext));
    }

    public static Intent f(Context paramContext)
    {
      return ViberActionRunner.a(paramContext, new Intent(paramContext, PersonalDataSettingsActivity.class)).addFlags(67108864);
    }

    public static Intent g(Context paramContext)
    {
      Intent localIntent = new Intent("com.viber.voip.action.SETTINGS");
      localIntent.putExtra("selected_item", R.string.pref_category_calls_and_messages_key);
      return ViberActionRunner.a(paramContext, localIntent).addFlags(67108864);
    }

    public static void h(Context paramContext)
    {
      paramContext.startActivity(i(paramContext));
    }

    public static Intent i(Context paramContext)
    {
      return ViberActionRunner.a(paramContext, new Intent(paramContext, RequestYourDataSettingsActivity.class)).addFlags(67108864);
    }

    public static void j(Context paramContext)
    {
      ViberActionRunner.b(paramContext, new Intent(paramContext, DeleteYourDataSettingsActivity.class));
    }

    public static void k(Context paramContext)
    {
      paramContext.startActivity(l(paramContext));
    }

    public static Intent l(Context paramContext)
    {
      return ViberActionRunner.a(paramContext, new Intent(paramContext, DeleteYourDataSettingsActivity.class)).addFlags(67108864);
    }
  }

  public static class az
  {
    @SuppressLint({"NewApi"})
    public static void a(Context paramContext, int paramInt, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MsgInfo paramMsgInfo, boolean paramBoolean, PublicAccountInteraction paramPublicAccountInteraction, d paramd, NewsShareAnalyticsData paramNewsShareAnalyticsData)
    {
      int i;
      int j;
      label17: String str6;
      if (8 == paramInt)
      {
        i = 1;
        if (3 != paramInt)
          break label128;
        j = 1;
        if ((8 != paramInt) || ((1005 != paramInt) || (paramd == null)))
          paramd = new b(paramContext);
        if (paramString1 == null)
          break label141;
        if (j == 0)
          break label134;
        str6 = "video/*";
      }
      label59: ArrayList localArrayList;
      Intent localIntent1;
      Uri localUri2;
      label128: label134: label141: for (String str1 = str6; ; str1 = "text/*")
      {
        localArrayList = new ArrayList();
        localIntent1 = new Intent("android.intent.action.SEND");
        localIntent1.setType(str1);
        if (paramString1 == null)
          break label438;
        localUri2 = ViberActionRunner.a(Uri.parse(paramString1), paramContext);
        if (localUri2 != null)
          break label148;
        ViberApplication.getInstance().showToast(R.string.file_not_found);
        return;
        i = 0;
        break;
        j = 0;
        break label17;
        str6 = "image/*";
        break label59;
      }
      label148: localIntent1.putExtra("android.intent.extra.STREAM", localUri2);
      Uri localUri1 = localUri2;
      List localList = paramContext.getPackageManager().queryIntentActivities(localIntent1, 0);
      ArraySet localArraySet = InvitationCreator.getSmsHandlers(paramContext.getPackageManager());
      af localaf = UserManager.from(paramContext).getRegistrationValues();
      boolean bool;
      label212: String str2;
      label228: String str3;
      Intent localIntent3;
      int m;
      String str5;
      if ((localaf.p()) || (d.au.b.d()))
      {
        bool = true;
        str2 = localaf.n();
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext())
          break label517;
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        str3 = localResolveInfo.activityInfo.packageName;
        String str4 = localResolveInfo.activityInfo.name;
        localIntent3 = new Intent("android.intent.action.SEND");
        localIntent3.setType(str1);
        localIntent3.setPackage(str3);
        localIntent3.setClassName(str3, str4);
        if (str1.equals("text/*"))
          break label478;
        localIntent3.putExtra("android.intent.extra.STREAM", localUri1);
        if (!str3.equals("com.viber.voip"))
        {
          m = InvitationCreator.getInviteSource(localArraySet, localResolveInfo.activityInfo.packageName);
          if (localArraySet.contains(localResolveInfo.activityInfo.packageName))
            break label460;
          str5 = paramd.a(str2, m, false);
          label382: localIntent3.putExtra("android.intent.extra.TEXT", str5);
          ViberActionRunner.a(paramContext, localIntent3, localUri1);
        }
      }
      while (true)
      {
        if ((paramNewsShareAnalyticsData != null) && ("com.viber.voip".equals(str3)))
          localIntent3.putExtra("news_provider_base_url", paramNewsShareAnalyticsData);
        localArrayList.add(localIntent3);
        break label228;
        label438: localIntent1.putExtra("android.intent.extra.TEXT", paramString5);
        localUri1 = null;
        break;
        bool = false;
        break label212;
        label460: str5 = paramd.a(str2, m, bool);
        break label382;
        label478: if ((i != 0) && (paramMsgInfo != null))
          localIntent3.putExtra("android.intent.extra.TEXT", paramMsgInfo.getUrl());
        else
          localIntent3.putExtra("android.intent.extra.TEXT", paramString5);
      }
      label517: int k = CdrConst.ShareMediaTypes.fromMediaType(paramInt);
      if ((!da.a(paramString1)) && ((3 == paramInt) || (1 == paramInt) || (1005 == paramInt)));
      for (long l = at.c(paramContext, Uri.parse(paramString1)); ; l = 0L)
      {
        Bundle localBundle1;
        if (com.viber.common.d.a.h())
        {
          localBundle1 = new Bundle(3);
          localBundle1.putInt("media_type", k);
          localBundle1.putInt("file_size", (int)l);
          if (paramPublicAccountInteraction != null)
            localBundle1.putParcelable("public_account_cdr_interaction", paramPublicAccountInteraction);
        }
        for (Bundle localBundle2 = localBundle1; ; localBundle2 = null)
        {
          Intent localIntent2 = dw.a(paramContext, (Intent)localArrayList.remove(0), paramContext.getString(R.string.msg_options_take_video), "share_type_public_account", localBundle2);
          localIntent2.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Parcelable[0]));
          if (!ViberActionRunner.a(localIntent2, paramContext))
            break;
          paramContext.startActivity(localIntent2);
          if (com.viber.common.d.a.h())
            break;
          ICdrController localICdrController = ViberApplication.getInstance().getEngine(false).getCdrController();
          localICdrController.handleReportShareNativeMenu(k, null, (int)l, 1);
          if (paramPublicAccountInteraction == null)
            break;
          localICdrController.handleReportPAInteractions(paramPublicAccountInteraction.publicAccountId, paramPublicAccountInteraction.publicAccountCategory, paramPublicAccountInteraction.publicAccountSubcategory, paramPublicAccountInteraction.publicAccountCountryCode, paramPublicAccountInteraction.publicAccountLocationInfo, paramPublicAccountInteraction.publicChatSessionToken, paramPublicAccountInteraction.messageMediaType, paramPublicAccountInteraction.messageUrl, null, paramPublicAccountInteraction.isGifMessage, paramPublicAccountInteraction.messageStickerNumber, paramPublicAccountInteraction.messageToken, paramPublicAccountInteraction.messageSequence, paramPublicAccountInteraction.publicAccountUserRole);
          return;
        }
      }
    }

    public static void a(Context paramContext, aa paramaa, boolean paramBoolean, PublicAccountInteraction paramPublicAccountInteraction, d paramd)
    {
      a(paramContext, paramaa.q(), paramaa.a(), paramaa.o(), paramaa.D(), paramaa.i(), paramaa.B(), paramaa.h(), paramaa.bx(), paramBoolean, paramPublicAccountInteraction, paramd, null);
    }

    public static class a extends ViberActionRunner.az.b
    {
      private final String b;
      private final String c;

      public a(Context paramContext, String paramString1, String paramString2)
      {
        super();
        this.b = paramString1;
        this.c = paramString2;
      }

      public String a(String paramString, int paramInt, boolean paramBoolean)
      {
        Context localContext = this.a;
        int i = R.string.share_media_community_invite_text;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.c;
        arrayOfObject[1] = this.b;
        return localContext.getString(i, arrayOfObject);
      }
    }

    public static class b
      implements ViberActionRunner.az.d
    {
      final Context a;

      public b(Context paramContext)
      {
        this.a = paramContext;
      }

      public String a(String paramString, int paramInt, boolean paramBoolean)
      {
        return InvitationCreator.getInviteText(this.a, paramString, paramInt, paramBoolean, R.string.share_media_invite_text);
      }
    }

    public static class c
    {
      private static final Logger a = ViberEnv.getLogger();
      private final Context b;
      private final ai c;
      private final com.viber.voip.invitelinks.f d;

      public c(Context paramContext, ai paramai, com.viber.voip.invitelinks.f paramf)
      {
        this.b = paramContext;
        this.c = paramai;
        this.d = paramf;
      }

      private void a(long paramLong, ViberActionRunner.az.c.a.a parama)
      {
        if (paramLong <= 0L)
        {
          parama.a(null, null);
          return;
        }
        this.c.a(paramLong, new do(this, parama));
      }

      public void a(long paramLong, int paramInt, String paramString)
      {
        a(paramLong, new dp(this, paramInt, paramString));
      }

      public void a(long paramLong, aa paramaa, boolean paramBoolean, PublicAccountInteraction paramPublicAccountInteraction)
      {
        a(paramLong, new dn(this, paramaa, paramBoolean, paramPublicAccountInteraction));
      }

      static class a
        implements f.a
      {
        private final a a;

        a(a parama)
        {
          this.a = parama;
        }

        public void a()
        {
          this.a.a(null, null);
        }

        public void a(long paramLong, String paramString)
        {
          com.viber.voip.invitelinks.g.a(this, paramLong, paramString);
        }

        public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, String paramString)
        {
          this.a.a(paramPublicGroupConversationItemLoaderEntity, paramString);
        }

        public void b()
        {
          this.a.a(null, null);
        }

        public void c()
        {
          this.a.a(null, null);
        }

        public void d()
        {
          this.a.a(null, null);
        }

        static abstract interface a
        {
          public abstract void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, String paramString);
        }
      }
    }

    public static abstract interface d
    {
      public abstract String a(String paramString, int paramInt, boolean paramBoolean);
    }
  }

  public static class b
  {
    public static void a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
    {
      Intent localIntent = new Intent(paramActivity, AddFriendActivity.class);
      localIntent.putExtra("phone_number", paramString1);
      localIntent.putExtra("entry_point", paramString2);
      paramActivity.startActivityForResult(localIntent, paramInt);
    }

    public static void a(Context paramContext, String paramString)
    {
      a(paramContext, null, paramString);
    }

    public static void a(Context paramContext, String paramString1, String paramString2)
    {
      Intent localIntent = new Intent(paramContext, AddFriendActivity.class);
      localIntent.putExtra("phone_number", paramString1);
      localIntent.putExtra("entry_point", paramString2);
      paramContext.startActivity(localIntent);
    }
  }

  public static class ba
  {
    public static Intent a(Context paramContext, ScreenshotConversationData paramScreenshotConversationData)
    {
      Intent localIntent = new Intent(paramContext, ShareScreenshotActivity.class);
      localIntent.putExtra("screenshot_data_extra", paramScreenshotConversationData);
      return localIntent;
    }

    public static void b(Context paramContext, ScreenshotConversationData paramScreenshotConversationData)
    {
      ViberActionRunner.b(paramContext, a(paramContext, paramScreenshotConversationData));
    }
  }

  public static class bb
  {
    private static Intent a(Context paramContext, OpenShopChatPanelData paramOpenShopChatPanelData)
    {
      Intent localIntent = new Intent(paramContext, ShopChatPanelActivity.class);
      localIntent.putExtra("data", paramOpenShopChatPanelData);
      return localIntent;
    }

    public static Intent a(String paramString)
    {
      Intent localIntent = new Intent("com.viber.voip.action.ACTION_FORWARD");
      localIntent.putExtra("open_share_and_shop_product_id", da.h(paramString));
      return localIntent;
    }

    public static void a(Fragment paramFragment, OpenShopChatPanelData paramOpenShopChatPanelData, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        paramFragment.getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in_fast, 0, 0, R.anim.fade_out_fast).replace(R.id.chatexPanelContainer, com.viber.voip.messages.shopchat.b.a(paramOpenShopChatPanelData)).addToBackStack(null).commit();
        return;
      }
      paramFragment.startActivity(a(paramFragment.requireContext(), paramOpenShopChatPanelData));
    }
  }

  public static class bc
  {
    public static Intent a(Context paramContext, String paramString)
    {
      return new Intent(paramContext, SmsInboxActivity.class).putExtra("to_number", paramString);
    }
  }

  public static class bd
  {
    public static void a(Context paramContext)
    {
      Intent localIntent = new Intent(paramContext, SplashActivity.class);
      if (!ViberApplication.isTablet(paramContext))
        localIntent.setFlags(1073741824);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
    }
  }

  public static abstract class be
  {
    public static String a(String paramString1, String paramString2)
    {
      if (paramString1 != null)
      {
        if (da.a(Uri.parse(paramString1).getScheme()))
          paramString1 = paramString2 + paramString1;
        return paramString1;
      }
      return null;
    }

    public static void a(Context paramContext, String paramString, GroupReferralInfo paramGroupReferralInfo)
    {
      com.viber.voip.api.scheme.e locale = com.viber.voip.api.scheme.e.s;
      Pair[] arrayOfPair = new Pair[2];
      arrayOfPair[0] = Pair.create("data", paramString);
      arrayOfPair[1] = Pair.create("openHome", Boolean.FALSE.toString());
      Intent localIntent = new Intent("android.intent.action.VIEW", com.viber.voip.api.scheme.i.a(locale, arrayOfPair));
      localIntent.putExtra("group_referral_info_extra", paramGroupReferralInfo);
      localIntent.setPackage(paramContext.getPackageName());
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static boolean a(Context paramContext, SimpleOpenUrlSpec paramSimpleOpenUrlSpec)
    {
      boolean bool1 = false;
      if (paramContext != null)
      {
        boolean bool2 = da.a(paramSimpleOpenUrlSpec.url);
        bool1 = false;
        if (!bool2);
      }
      else
      {
        return bool1;
      }
      if (b(paramSimpleOpenUrlSpec))
        return ViberActionRunner.b(paramContext, new Intent("com.viber.voip.action.DIALER", paramSimpleOpenUrlSpec.uri));
      if (a(paramSimpleOpenUrlSpec))
      {
        Uri localUri;
        if (dk.i(paramSimpleOpenUrlSpec.uri))
        {
          String[] arrayOfString = paramSimpleOpenUrlSpec.url.split("&");
          if (arrayOfString.length > 1)
            localUri = Uri.parse(arrayOfString[0]);
        }
        label91: for (Intent localIntent = new Intent("android.intent.action.DIAL", localUri); ; localIntent = b(paramContext, paramSimpleOpenUrlSpec.url))
        {
          if ((com.viber.voip.api.scheme.d.J.a(paramSimpleOpenUrlSpec.uri, com.viber.voip.api.scheme.d.C)) && ((paramSimpleOpenUrlSpec instanceof MessageOpenUrlSpec)))
            localIntent.putExtra("message_open_url_spec_extra", paramSimpleOpenUrlSpec);
          bool1 = ViberActionRunner.a(localIntent, paramContext);
          if ((!bool1) && (paramSimpleOpenUrlSpec.url.startsWith("market://details?id=")))
          {
            String str = paramSimpleOpenUrlSpec.url.substring("market://details?id=".length());
            localIntent = b(paramContext, "https://play.google.com/store/apps/details?id=" + str);
            bool1 = ViberActionRunner.a(localIntent, paramContext);
          }
          if (!bool1)
            break;
          paramContext.startActivity(ViberActionRunner.a(paramContext, localIntent));
          return bool1;
          localUri = paramSimpleOpenUrlSpec.uri;
          break label91;
        }
      }
      if ((paramSimpleOpenUrlSpec instanceof MessageOpenUrlSpec))
      {
        ViberActionRunner.m.a(paramContext, (MessageOpenUrlSpec)paramSimpleOpenUrlSpec);
        return true;
      }
      GenericWebViewActivity.a(paramContext, paramSimpleOpenUrlSpec.url, null, false, false, paramSimpleOpenUrlSpec.orientation);
      return true;
    }

    public static boolean a(Context paramContext, String paramString)
    {
      return a(paramContext, new SimpleOpenUrlSpec(paramString, true, false));
    }

    public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
    {
      return a(paramContext, new SimpleOpenUrlSpec(paramString, true, paramBoolean));
    }

    private static boolean a(SimpleOpenUrlSpec paramSimpleOpenUrlSpec)
    {
      return ((dl.p(paramSimpleOpenUrlSpec.url)) && (paramSimpleOpenUrlSpec.urlOrigin != 1)) || (paramSimpleOpenUrlSpec.shouldOpenExternally) || (paramSimpleOpenUrlSpec.isInternalAppUrlScheme());
    }

    public static Intent b(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      localIntent.putExtra("com.android.browser.application_id", paramContext.getPackageName());
      return localIntent;
    }

    private static boolean b(SimpleOpenUrlSpec paramSimpleOpenUrlSpec)
    {
      if ((!ce.l.matcher(paramSimpleOpenUrlSpec.url).matches()) && (!dk.i(paramSimpleOpenUrlSpec.uri)));
      com.viber.voip.model.entity.g localg;
      do
      {
        return false;
        String str = paramSimpleOpenUrlSpec.uri.getSchemeSpecificPart();
        localg = ViberApplication.getInstance().getContactManager().c().a(str);
      }
      while ((localg == null) || (!localg.p()));
      return true;
    }
  }

  public static class bf
  {
    public static void a(Activity paramActivity)
    {
      Intent localIntent = new Intent(paramActivity, EditInfoActivity.class);
      localIntent.putExtra("extra_entry_point", "Other");
      paramActivity.startActivity(localIntent);
    }

    public static void a(Activity paramActivity, Bundle paramBundle)
    {
      Intent localIntent = new Intent(paramActivity, EditInfoActivity.class);
      localIntent.putExtras(paramBundle);
      if (!localIntent.hasExtra("extra_entry_point"))
        localIntent.putExtra("extra_entry_point", "Other");
      paramActivity.startActivity(localIntent);
    }

    public static void a(Activity paramActivity, boolean paramBoolean)
    {
      if (paramBoolean);
      for (String str = "com.viber.voip.action.MORE_DIALOG"; ; str = "com.viber.voip.action.MORE")
      {
        paramActivity.startActivity(new Intent(str));
        return;
      }
    }

    public static void b(Activity paramActivity)
    {
      a(paramActivity, false);
    }
  }

  public static class bg
  {
    public static void a(Context paramContext, AuthInfo paramAuthInfo)
    {
      paramContext.startActivity(b(paramContext, paramAuthInfo));
    }

    public static Intent b(Context paramContext, AuthInfo paramAuthInfo)
    {
      Intent localIntent = new Intent(paramContext, ViberConnectActivity.class);
      localIntent.putExtra("auth_info", paramAuthInfo);
      return localIntent;
    }
  }

  public static class bh
  {
    public static void a(Activity paramActivity)
    {
      paramActivity.startActivity(new Intent(paramActivity, ViberIdConnectActivity.class));
    }
  }

  public static class bi
  {
    public static void a(Context paramContext, String paramString1, String paramString2)
    {
      d.bh.a.a(false);
      paramContext.startActivity(b(paramContext, paramString1, paramString2));
    }

    private static void a(Intent paramIntent, String paramString1, String paramString2)
    {
      paramIntent.putExtra("com.viber.voip.ReactContextFactoryParams", ReactContextManager.a("ReactVLN", true).a(paramString1).b(paramString2).a());
    }

    public static Intent b(Context paramContext, String paramString1, String paramString2)
    {
      Intent localIntent = new Intent(paramContext, VlnActivity.class);
      a(localIntent, paramString1, paramString2);
      return localIntent;
    }
  }

  public static class bj
  {
    public static Intent a(Context paramContext)
    {
      return new Intent(paramContext, ViberNewsWebActivity.class);
    }

    public static void a(Activity paramActivity, Fragment paramFragment, int paramInt, String paramString, NewsSession paramNewsSession, NewsShareAnalyticsData paramNewsShareAnalyticsData)
    {
      Intent localIntent = new Intent(paramActivity, ViberNewsArticleBrowserActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("news_session", paramNewsSession);
      localIntent.putExtra("news_analytics_data", paramNewsShareAnalyticsData);
      localIntent.putExtra("extra_url", paramString);
      localIntent.putExtra("extra_title", dl.a(Uri.parse(paramString)));
      localIntent.putExtra("extra_ignore_history", false);
      localIntent.putExtra("extra_use_host_for_title", true);
      localIntent.putExtra("extra_orientation", -1);
      localIntent.putExtra("extra_conversation_id", -1L);
      localIntent.putExtra("extra_conversation_type", -1);
      dz.a(paramActivity, paramFragment, localIntent, paramInt);
    }

    public static void b(Context paramContext)
    {
      dz.a(paramContext, a(paramContext));
    }
  }

  public static class bk
  {
    public static Intent a(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent(paramContext, ViberOutProductsActivity.class);
      localIntent.putExtra("show_tab", paramString);
      return localIntent;
    }

    public static Intent a(Context paramContext, String paramString1, String paramString2)
    {
      return c(paramContext, paramString1, paramString2);
    }

    public static void a(Context paramContext, CountryModel paramCountryModel, String paramString)
    {
      Intent localIntent = new Intent(paramContext, ViberOutCountryPlansActivity.class);
      localIntent.putExtra("country_model", paramCountryModel);
      localIntent.putExtra("selected_tab", paramString);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void b(Context paramContext, String paramString1, String paramString2)
    {
      ViberActionRunner.b(paramContext, a(paramContext, paramString1, paramString2));
    }

    public static Intent c(Context paramContext, String paramString1, String paramString2)
    {
      Intent localIntent = new Intent(paramContext, ViberOutProductsActivity.class);
      localIntent.putExtra("analytics_entry_point", paramString1);
      localIntent.putExtra("referral", paramString2);
      return localIntent;
    }
  }

  public static class bl
  {
    public static Intent a(String paramString)
    {
      return new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    }

    public static void a(Context paramContext)
    {
      Intent localIntent = e(paramContext);
      localIntent.putExtra("go_to_splash", true);
      dz.a(paramContext, localIntent);
    }

    public static void b(Context paramContext)
    {
      dz.a(paramContext, e(paramContext));
    }

    public static void c(Context paramContext)
    {
      Intent localIntent = new Intent(paramContext, AcceptTermsAndPoliciesWebActivity.class);
      if (!(paramContext instanceof Activity))
        localIntent.addFlags(268435456);
      localIntent.putExtra("extra_url", ap.c().f());
      localIntent.putExtra("extra_title", paramContext.getString(R.string.t_and_p_text));
      dz.a(paramContext, localIntent);
    }

    public static void d(Context paramContext)
    {
      Intent localIntent = new Intent(paramContext, GenericWebViewActivity.class);
      localIntent.putExtra("go_to_splash", true);
      localIntent.putExtra("extra_url", ap.c().aS);
      dz.a(paramContext, localIntent);
    }

    private static Intent e(Context paramContext)
    {
      String str = Locale.getDefault().getLanguage();
      if ((!da.a(str)) && (str.length() > 2))
        str = str.substring(0, 2);
      return GenericWebViewActivity.b(paramContext, dl.j(paramContext.getString(R.string.url_privacy_policy, new Object[] { str })), paramContext.getString(R.string.pref_more_tab_privacy_policy_title));
    }
  }

  public static class bm
  {
    public static Intent a(Context paramContext, long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      Intent localIntent = new Intent(paramContext, ViewMediaActivity.class);
      localIntent.putExtra("thread_id", paramLong1);
      localIntent.putExtra("conversation_type", paramInt1);
      localIntent.putExtra("is_secret_conversation", paramBoolean1);
      localIntent.putExtra("is_share_and_forward_available", paramBoolean2);
      localIntent.putExtra("msg_id", paramLong2);
      localIntent.putExtra("screen_title", paramString);
      localIntent.putExtra("participant_role", paramInt2);
      localIntent.putExtra("navigated_to_conversation_after_send_doodle", paramBoolean3);
      return localIntent;
    }

    private static Intent a(Context paramContext, long paramLong1, int paramInt1, long paramLong2, String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2, boolean paramBoolean5)
    {
      if (paramConversationItemLoaderEntity != null);
      for (int i = paramConversationItemLoaderEntity.getGroupRole(); ; i = paramInt2)
      {
        Intent localIntent = a(paramContext, paramLong1, paramInt1, paramLong2, paramString, i, paramBoolean3, paramBoolean4, paramBoolean5);
        if (!(paramContext instanceof Activity))
          localIntent.addFlags(268435456);
        if (paramBoolean1)
          localIntent.addFlags(67108864);
        localIntent.setFlags(536870912);
        if (paramBoolean2)
          paramContext.startActivity(localIntent);
        return localIntent;
      }
    }

    private static void a(Context paramContext, long paramLong1, int paramInt, long paramLong2, String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
    {
      boolean bool1 = paramConversationItemLoaderEntity.isSecret();
      if (!paramConversationItemLoaderEntity.isNotShareablePublicAccount());
      for (boolean bool2 = true; ; bool2 = false)
      {
        Intent localIntent = a(paramContext, paramLong1, paramInt, paramLong2, paramString, paramConversationItemLoaderEntity, false, false, bool1, bool2, paramConversationItemLoaderEntity.getGroupRole(), false);
        localIntent.setClass(paramContext, WinkViewMediaActivity.class);
        localIntent.putExtra("extra_play", false);
        paramContext.startActivity(localIntent);
        return;
      }
    }

    public static void a(Context paramContext, long paramLong1, int paramInt1, long paramLong2, String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, boolean paramBoolean4)
    {
      a(paramContext, paramLong1, paramInt1, paramLong2, paramString, paramConversationItemLoaderEntity, paramBoolean1, true, paramBoolean2, paramBoolean3, paramInt2, paramBoolean4);
    }

    public static void a(Context paramContext, long paramLong, int paramInt, List<SimpleMediaViewItem> paramList)
    {
      Intent localIntent = new Intent(paramContext, ViewMediaSimpleActivity.class);
      localIntent.putExtra("extra_simple_media_viewer_conversation_id", paramLong);
      localIntent.putExtra("extra_simple_media_viewer_focused_item_position", paramInt);
      ArrayList localArrayList = new ArrayList(paramList.size());
      localArrayList.addAll(paramList);
      localIntent.putParcelableArrayListExtra("extra_simple_media_viewer_items", localArrayList);
      localIntent.setFlags(536870912);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void a(Context paramContext, long paramLong, int paramInt, SimpleMediaViewItem[] paramArrayOfSimpleMediaViewItem)
    {
      a(paramContext, paramLong, paramInt, Arrays.asList(paramArrayOfSimpleMediaViewItem));
    }

    public static void a(Context paramContext, long paramLong, SimpleMediaViewItem[] paramArrayOfSimpleMediaViewItem)
    {
      a(paramContext, paramLong, -1, paramArrayOfSimpleMediaViewItem);
    }

    public static void a(Context paramContext, String paramString, int paramInt, long paramLong)
    {
      a(paramContext, paramString, paramInt, paramLong, -1L, 0L, 0, false);
    }

    public static void a(Context paramContext, String paramString, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, boolean paramBoolean)
    {
      SimpleMediaViewItem[] arrayOfSimpleMediaViewItem = new SimpleMediaViewItem[1];
      arrayOfSimpleMediaViewItem[0] = new SimpleMediaViewItem(paramString, paramInt1, paramLong2, paramLong3, paramInt2, paramBoolean, null);
      a(paramContext, paramLong1, arrayOfSimpleMediaViewItem);
    }

    public static void a(Context paramContext, boolean paramBoolean, long paramLong, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
    {
      String str = dg.b(paramConversationItemLoaderEntity);
      if (paramBoolean)
      {
        a(paramContext, paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getConversationType(), paramLong, str, paramConversationItemLoaderEntity);
        return;
      }
      long l = paramConversationItemLoaderEntity.getId();
      int i = paramConversationItemLoaderEntity.getConversationType();
      boolean bool1 = paramConversationItemLoaderEntity.isSecret();
      if (!paramConversationItemLoaderEntity.isNotShareablePublicAccount());
      for (boolean bool2 = true; ; bool2 = false)
      {
        paramContext.startActivity(a(paramContext, l, i, paramLong, str, paramConversationItemLoaderEntity, false, false, bool1, bool2, paramConversationItemLoaderEntity.getGroupRole(), false));
        return;
      }
    }
  }

  public static class bn
  {
    public static void a(Context paramContext, int paramInt, long paramLong)
    {
      Intent localIntent = new Intent(paramContext, MessageInfoActivity.class);
      localIntent.putExtra("message_token", paramLong);
      localIntent.putExtra("extra_participant_counts", paramInt);
      localIntent.putExtra("view_likes_mode", 2);
      localIntent.putExtra("android.intent.extra.TITLE", paramContext.getString(R.string.title_votes));
      localIntent.addFlags(536870912);
      paramContext.startActivity(localIntent);
    }

    public static void a(Context paramContext, aa paramaa, int paramInt1, int paramInt2)
    {
      Intent localIntent = new Intent(paramContext, MessageInfoActivity.class);
      if (paramaa.aU())
        localIntent.putExtra("extra_broadcast_msg_id", paramaa.a());
      label195: 
      while (true)
      {
        paramContext.startActivity(localIntent);
        return;
        localIntent.putExtra("message_time", paramaa.e());
        localIntent.putExtra("message_token", paramaa.y());
        localIntent.putExtra("group_id", paramaa.c());
        localIntent.putExtra("extra_participant_counts", paramInt1);
        localIntent.putExtra("extra_is_incoming", paramaa.ao());
        localIntent.putExtra("extra_conversation_type", paramaa.A());
        localIntent.putExtra("extra_message_global_id", paramaa.F());
        localIntent.putExtra("extra_group_role", paramInt2);
        localIntent.putExtra("extra_conversation_id", paramaa.b());
        if (paramaa.ao())
          localIntent.putExtra("extra_sender_member_id", paramaa.d());
        while (true)
        {
          if (!paramaa.ag())
            break label195;
          localIntent = com.viber.voip.ui.c.c.a(localIntent);
          break;
          localIntent.putExtra("extra_sender_member_id", UserManager.from(paramContext).getRegistrationValues().l());
        }
      }
    }
  }

  public static class bo
  {
    public static void a(Context paramContext)
    {
      if ((com.viber.common.d.a.m()) && (!ViberApplication.getInstance().isOnForeground()))
      {
        b(paramContext);
        com.viber.voip.h.a.b().post(new VoipConnectorService.a(VoipConnectorService.StartMode.BACKGROUND));
        return;
      }
      Intent localIntent = new Intent(paramContext, VoipConnectorService.class);
      localIntent.putExtra("service_start_mode", VoipConnectorService.StartMode.BACKGROUND);
      com.viber.common.app.a.b(paramContext, localIntent);
    }

    public static void a(Context paramContext, Notification paramNotification, int paramInt)
    {
      Intent localIntent = new Intent(paramContext, VoipConnectorService.class);
      localIntent.putExtra("service_start_mode", VoipConnectorService.StartMode.FOREGROUND);
      localIntent.putExtra("notification", paramNotification);
      localIntent.putExtra("notification_id", paramInt);
      com.viber.common.app.a.c(paramContext, localIntent);
    }

    public static void b(Context paramContext)
    {
      paramContext.stopService(new Intent(paramContext, VoipConnectorService.class));
    }
  }

  public static class bp
  {
    public static Intent a(Context paramContext)
    {
      return new Intent(paramContext, ForwardCreatePollActivity.class);
    }

    public static Intent a(Context paramContext, long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
    {
      Intent localIntent = new Intent(paramContext, VoteActivity.class);
      localIntent.putExtra("extra_conversation_id", paramLong1);
      localIntent.putExtra("extra_group_id", paramLong2);
      localIntent.putExtra("extra_member_id", paramString);
      localIntent.putExtra("extra_conversation_type", paramInt1);
      localIntent.putExtra("extra_native_chat_type", paramInt2);
      localIntent.putExtra("extra_send_message_options", paramBundle);
      localIntent.addFlags(67108864);
      return localIntent;
    }
  }

  public static class bq
  {
    private final Context a;

    public bq(Context paramContext)
    {
      this.a = paramContext;
    }

    public static void a(Context paramContext)
    {
      paramContext.startActivity(b(paramContext));
    }

    public static Intent b(Context paramContext)
    {
      Intent localIntent1 = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
      Intent localIntent2 = Intent.makeMainActivity(localIntent1.getComponent());
      localIntent2.addFlags(268435456);
      localIntent2.addFlags(2097152);
      return localIntent1;
    }

    public static Intent c(Context paramContext)
    {
      return f(paramContext).putExtra("approve_sync_history_to_desktop_notification", true);
    }

    public static Intent d(Context paramContext)
    {
      return f(paramContext).putExtra("syncing_history_to_desktop_notification", true);
    }

    public static void e(Context paramContext)
    {
      Intent localIntent = f(paramContext);
      localIntent.putExtra("syncing_history_to_desktop_minimized_window", true);
      ViberActionRunner.b(paramContext, localIntent);
    }

    private static Intent f(Context paramContext)
    {
      Intent localIntent = new Intent(paramContext, BringAppToFrontActivity.class);
      localIntent.addFlags(131072);
      return localIntent;
    }

    public void a()
    {
      e(this.a);
    }
  }

  public static class br
  {
    private static void a(int paramInt)
    {
      new com.viber.voip.market.b.d().a(new MarketApi.c()
      {
        public void a(String paramAnonymousString)
        {
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
        {
          ViberApplication.getInstance().getEngine(false).getCdrController().handleReportWalletEntryFrom(paramAnonymousString2, this.a, "rb");
        }
      }
      , true);
    }

    public static void a(Context paramContext)
    {
      new ViberActionRunner.bs(new Intent("android.intent.action.VIEW", Uri.parse(com.viber.voip.api.scheme.i.b()))).a(paramContext);
    }

    private static void a(Context paramContext, Intent paramIntent, boolean paramBoolean)
    {
      if (!d.bm.a.c.d());
      new ViberActionRunner.bs(paramIntent).a(paramContext);
    }

    public static void a(Context paramContext, String paramString, int paramInt)
    {
      a(paramInt);
      if (cc.a().contains(paramContext.getString(R.string.rakuten_bank_app_package_name)))
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        if (paramString == null);
        for (String str = paramContext.getString(R.string.rakuten_bank_open_url_scheme); ; str = paramContext.getString(R.string.rakuten_bank_send_money_url_scheme, new Object[] { paramString }))
        {
          localIntent.setData(Uri.parse(str));
          if (!ViberActionRunner.a(localIntent, null))
            break;
          paramContext.startActivity(localIntent);
          return;
        }
        b(paramContext);
        return;
      }
      b(paramContext);
    }

    public static void a(Context paramContext, String paramString, a parama)
    {
      a(paramContext, paramString, parama, false);
    }

    public static void a(Context paramContext, String paramString, a parama, boolean paramBoolean)
    {
      Intent localIntent = new Intent(paramContext, WesternUnionWebActivity.class);
      localIntent.putExtra("token", paramString);
      localIntent.putExtra("origin", a.a(parama));
      if (paramBoolean)
        localIntent = com.viber.voip.ui.c.c.a(localIntent);
      a(paramContext, localIntent, paramBoolean);
    }

    private static void b(Context paramContext)
    {
      GenericWebViewActivity.a(paramContext, paramContext.getString(R.string.rakuten_bank_send_money_redirect_url), null);
    }

    public static enum a
    {
      private String f;

      static
      {
        a[] arrayOfa = new a[5];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
        arrayOfa[3] = d;
        arrayOfa[4] = e;
      }

      private a(String paramString)
      {
        this.f = paramString;
      }

      public String a()
      {
        return this.f;
      }
    }
  }

  public static class bs extends ViberActionRunner.ad
  {
    public bs(Intent paramIntent)
    {
      super();
    }

    protected void a(Context paramContext, Intent paramIntent)
    {
      dz.a(paramContext, paramIntent);
    }
  }

  public static class bt
  {
    public static Intent a(Context paramContext)
    {
      if (ViberApplication.isTablet(paramContext))
        return c(paramContext);
      return b(paramContext);
    }

    public static Intent b(Context paramContext)
    {
      if (ViberApplication.isTablet(paramContext))
        return new Intent("com.viber.voip.action.MORE");
      return new Intent(paramContext, MoreActivity.class);
    }

    public static Intent c(Context paramContext)
    {
      return new Intent(paramContext, MoreDialogActivity.class);
    }

    public static void d(Context paramContext)
    {
      paramContext.startActivity(a(paramContext));
    }

    public static void e(Context paramContext)
    {
      paramContext.startActivity(b(paramContext));
    }
  }

  public static class c
  {
    public static Intent a(Context paramContext, String paramString1, BaseAddFriendActivity.ContactDetails paramContactDetails, boolean paramBoolean, String paramString2, String paramString3)
    {
      Intent localIntent = new Intent(paramContext, AddFriendPreviewActivity.class);
      localIntent.putExtra("phone_number", paramString1);
      localIntent.putExtra("contact_details", paramContactDetails);
      localIntent.putExtra("send_boomerang", paramBoolean);
      localIntent.putExtra("analytics_add_type", paramString2);
      localIntent.putExtra("entry_point", paramString3);
      return localIntent;
    }

    public static Intent a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4)
    {
      Intent localIntent = new Intent(paramContext, AddFriendPreviewActivity.class);
      localIntent.putExtra("member_id", paramString1);
      localIntent.putExtra("phone_number", paramString2);
      localIntent.putExtra("invite_not_viber", paramBoolean1);
      localIntent.putExtra("send_boomerang", paramBoolean2);
      localIntent.putExtra("analytics_add_type", paramString3);
      localIntent.putExtra("entry_point", paramString4);
      return localIntent;
    }

    public static void a(Context paramContext, String paramString1, BaseAddFriendActivity.ContactDetails paramContactDetails, String paramString2, String paramString3)
    {
      paramContext.startActivity(c(paramContext, paramString1, paramContactDetails, paramString2, paramString3));
    }

    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      paramContext.startActivity(a(paramContext, null, paramString1, true, false, paramString2, paramString3));
    }

    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      paramContext.startActivity(c(paramContext, paramString1, paramString2, paramString3, paramString4));
    }

    public static void b(Context paramContext, String paramString1, BaseAddFriendActivity.ContactDetails paramContactDetails, String paramString2, String paramString3)
    {
      paramContext.startActivity(a(paramContext, paramString1, paramContactDetails, true, paramString2, paramString3));
    }

    public static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      paramContext.startActivity(c(paramContext, null, paramString1, paramString2, paramString3));
    }

    public static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      Intent localIntent = c(paramContext, null, paramString1, paramString3, paramString4);
      localIntent.putExtra("contact_name", paramString2);
      paramContext.startActivity(localIntent);
    }

    public static Intent c(Context paramContext, String paramString1, BaseAddFriendActivity.ContactDetails paramContactDetails, String paramString2, String paramString3)
    {
      return a(paramContext, paramString1, paramContactDetails, false, paramString2, paramString3);
    }

    public static Intent c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      return a(paramContext, paramString1, paramString2, false, false, paramString3, paramString4);
    }
  }

  public static class d
  {
    public static Intent a()
    {
      Intent localIntent = new Intent("com.viber.voip.action.CREATE_COMMUNITY");
      localIntent.putExtra("members_extra", new GroupController.GroupMember[0]);
      return localIntent;
    }

    private static Intent a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, Uri paramUri, int paramInt)
    {
      Intent localIntent1 = new Intent("com.viber.voip.action.ACTION_CONTACT_LIST_SELECTABLE2");
      localIntent1.putExtra("thread_id", paramLong1);
      localIntent1.putExtra("extra_group_id", paramLong2);
      localIntent1.putExtra("extra_group_name", paramString);
      localIntent1.putExtra("participants_count", paramInt);
      Intent localIntent3;
      if (paramBoolean1)
      {
        localIntent3 = com.viber.voip.ui.c.c.a(localIntent1);
        localIntent3.putExtra("extra_participants_selector_mode", ParticipantSelector.f.c.ordinal());
      }
      for (Intent localIntent2 = localIntent3; ; localIntent2 = localIntent1)
      {
        if (paramBoolean2)
          localIntent2.putExtra("title", ViberApplication.getApplication().getResources().getString(R.string.add_admins_title));
        localIntent2.putExtra("can_share_group_link", paramBoolean4);
        localIntent2.putExtra("open_native_link_share", paramBoolean5);
        int i;
        if (paramBoolean3)
          i = 1;
        while (true)
        {
          localIntent2.putExtra("compose_chat_mode_multiple", i);
          localIntent2.putExtra("is_public_group_compose", paramBoolean6);
          localIntent2.putExtra("group_icon_uri", paramUri);
          localIntent2.putExtra("group_role", 1);
          return localIntent2;
          if (paramBoolean2)
            i = 2;
          else
            i = 0;
        }
      }
    }

    public static Intent a(Context paramContext, String paramString1, String paramString2)
    {
      Intent localIntent = new Intent(paramContext, ShareLinkActivity.class);
      localIntent.putExtra("share_text", paramString2);
      localIntent.putExtra("invite_link", paramString1);
      localIntent.putExtra("title", ViberApplication.getApplication().getResources().getString(R.string.join_community_link_msg_title));
      localIntent.setAction("com.viber.voip.action.ACTION_CONTACT_LIST_SHARE_COMMUNITY_LINK");
      return localIntent;
    }

    public static Intent a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt)
    {
      boolean bool = bi.a(paramConversationItemLoaderEntity);
      return a(paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getGroupId(), paramConversationItemLoaderEntity.getGroupName(), paramConversationItemLoaderEntity.isSecret(), paramConversationItemLoaderEntity.isCommunityType(), paramConversationItemLoaderEntity.isBroadcastListType(), bool, a(bool, paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getGroupRole()), paramConversationItemLoaderEntity.isPublicGroupType(), paramConversationItemLoaderEntity.getIconUri(), paramInt);
    }

    public static Intent a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2)
    {
      Intent localIntent = a(paramConversationItemLoaderEntity, paramInt1);
      localIntent.putExtra("group_role", paramInt2);
      return localIntent;
    }

    private static Intent a(com.viber.voip.model.entity.h paramh, int paramInt, boolean paramBoolean)
    {
      return a(paramh.getId(), paramh.k(), paramh.o(), paramh.R(), paramh.g(), paramh.h(), paramBoolean, a(paramBoolean, paramh.j(), paramh.p()), paramh.d(), paramh.q(), paramInt);
    }

    public static Intent a(com.viber.voip.model.entity.h paramh, boolean paramBoolean)
    {
      Intent localIntent = a(paramh, 1, paramBoolean);
      localIntent.putExtra("extra_participants_selector_mode", ParticipantSelector.f.d.ordinal());
      localIntent.putExtra("title", ViberApplication.getApplication().getResources().getString(R.string.chat_info_add_members_header));
      return localIntent;
    }

    public static Intent a(String paramString)
    {
      Intent localIntent = new Intent("com.viber.voip.action.ACTION_CONTACT_LIST_SELECTABLE2");
      localIntent.putExtra("title", paramString);
      return localIntent;
    }

    public static void a(Fragment paramFragment, ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt)
    {
      boolean bool = true;
      if ((!paramConversationItemLoaderEntity.isPublicGroupType()) || (com.viber.voip.publicaccount.d.e.a(paramFragment, bool)));
      while (true)
      {
        if (bool)
        {
          Intent localIntent = a(paramConversationItemLoaderEntity, paramInt);
          localIntent.putExtra("extra_participants_selector_mode", ParticipantSelector.f.d.ordinal());
          localIntent.putExtra("title", ViberApplication.getApplication().getResources().getString(R.string.chat_info_add_members_header));
          paramFragment.startActivityForResult(localIntent, 12);
        }
        return;
        bool = false;
      }
    }

    public static void a(Fragment paramFragment, ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2)
    {
      boolean bool = true;
      if ((!paramConversationItemLoaderEntity.isPublicGroupType()) || (com.viber.voip.publicaccount.d.e.a(paramFragment, bool)))
        if (bool)
          if (!cd.c(paramInt2))
            break label54;
      label54: for (int i = 10; ; i = 11)
      {
        paramFragment.startActivityForResult(a(paramConversationItemLoaderEntity, paramInt1, paramInt2), i);
        return;
        bool = false;
        break;
      }
    }

    public static boolean a(Fragment paramFragment, int paramInt1, int paramInt2)
    {
      if (cd.j(paramInt1, paramInt2))
        return true;
      if (com.viber.voip.messages.m.c(paramInt1))
        com.viber.voip.ui.dialogs.l.o().b(paramFragment);
      while (true)
      {
        return false;
        if (com.viber.voip.messages.m.b(paramInt1))
          com.viber.voip.ui.dialogs.d.j().b(paramFragment);
        else
          com.viber.voip.ui.dialogs.l.a().b(paramFragment);
      }
    }

    private static boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      return (paramBoolean) && (com.viber.voip.messages.m.b(paramInt1)) && (!cd.c(paramInt2));
    }

    public static Intent b(String paramString)
    {
      Intent localIntent = new Intent("com.viber.voip.action.ACTION_CONTACT_LIST_SELECTABLE2");
      localIntent.putExtra("title", paramString);
      localIntent.putExtra("compose_chat_mode_multiple", 1);
      return localIntent;
    }
  }

  public static class e
  {
    public static void a(Fragment paramFragment, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt2)
    {
      boolean bool = true;
      if ((!com.viber.voip.messages.m.a(paramInt2)) || (com.viber.voip.publicaccount.d.e.a(paramFragment, bool)));
      while (true)
      {
        if (bool)
        {
          Intent localIntent = new Intent(paramFragment.getActivity(), AdminSelectorActivity.class);
          localIntent.putExtra("conversation_id", paramLong1);
          localIntent.putExtra("group_id", paramLong2);
          if (paramBoolean)
            localIntent = com.viber.voip.ui.c.c.a(localIntent);
          paramFragment.startActivityForResult(localIntent, paramInt1);
        }
        return;
        bool = false;
      }
    }
  }

  public static class f
  {
    public static void a(Context paramContext, String paramString)
    {
      String str;
      if (paramString != null)
        str = "market://details?id=" + paramString;
      try
      {
        paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + paramString));
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
      }
    }

    public static void b(Context paramContext, String paramString)
    {
      try
      {
        String str = URLEncoder.encode(paramString, "UTF-8");
        paramString = str;
        label11: Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.US, "market://search?q=%s&c=apps", new Object[] { paramString })));
        if (!ViberActionRunner.a(localIntent, paramContext))
          localIntent = ViberActionRunner.be.b(paramContext, String.format(Locale.US, "https://play.google.com/store/search?q=%s&c=apps", new Object[] { paramString }));
        ViberActionRunner.b(paramContext, localIntent);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label11;
      }
    }
  }

  public static class g
  {
    public static void a(Context paramContext, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
    {
      Intent localIntent = new Intent("com.viber.voip.action.SELECT_COMMUNITY_BACKGROUND");
      localIntent.putExtra("thread_id", paramConversationItemLoaderEntity.getId());
      if (paramConversationItemLoaderEntity.isSecret())
        localIntent = com.viber.voip.ui.c.c.a(localIntent);
      paramContext.startActivity(ViberActionRunner.a(paramContext, localIntent));
    }
  }

  public static class h
  {
    public static Intent a(Context paramContext)
    {
      return new Intent(paramContext, BackupSettingsActivity.class);
    }

    public static void a(Activity paramActivity, String paramString1, String paramString2)
    {
      d.j.n.a(false);
      Intent localIntent = new Intent(paramActivity, RestoreActivity.class);
      localIntent.putExtra("account", paramString1);
      localIntent.putExtra("drive_file_id", paramString2);
      paramActivity.startActivity(localIntent);
    }

    public static void a(Context paramContext, com.viber.voip.backup.a parama)
    {
      ContextCompat.startForegroundService(paramContext, AutoBackupService.a(paramContext, parama));
    }

    public static void a(BackupInfo paramBackupInfo)
    {
      if ((paramBackupInfo.getAccount() != null) && (paramBackupInfo.getDriveFileId() != null))
        t.a(paramBackupInfo.getAccount(), paramBackupInfo.getDriveFileId(), paramBackupInfo.getUpdateTime(), paramBackupInfo.getSize()).d();
    }

    public static void b(Context paramContext)
    {
      ViberActionRunner.b(paramContext, new Intent(paramContext, AutoBackupPromotionActivity.class));
    }
  }

  public static class i
  {
    public static Intent a(Context paramContext, boolean paramBoolean)
    {
      Intent localIntent = new Intent(paramContext, UserBirthdateActivity.class);
      localIntent.putExtra("UserBirthdateActivity.AllowBackNavigation", paramBoolean);
      return ViberActionRunner.a(paramContext, localIntent);
    }

    public static void b(Context paramContext, boolean paramBoolean)
    {
      paramContext.startActivity(a(paramContext, paramBoolean));
    }
  }

  public static class j
  {
    public static void a(Context paramContext, String paramString)
    {
      paramContext.startActivity(c(paramContext, paramString));
    }

    public static void b(Context paramContext, String paramString)
    {
      Intent localIntent = c(paramContext, paramString);
      localIntent.putExtra("com.viber.voip.IS_FOR_DEBUG", true);
      paramContext.startActivity(localIntent);
    }

    private static Intent c(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent(paramContext, BlockedUserSplashActivity.class);
      localIntent.putExtra("com.viber.voip.CAPTCHA_URL_EXTRA", paramString);
      localIntent.addFlags(67108864);
      if (!(paramContext instanceof Activity))
        localIntent.addFlags(268435456);
      return localIntent;
    }
  }

  public static class k
  {
    public static Intent a(Context paramContext)
    {
      return new Intent(paramContext, BusinessInboxActivity.class);
    }
  }

  public static class l
  {
    public static Intent a(Context paramContext, ActivationController.ActivationCode paramActivationCode)
    {
      Intent localIntent = a(paramContext, (String)null);
      if (!ActivationController.ActivationCode.isEmpty(paramActivationCode))
        localIntent.putExtra("activation_code", paramActivationCode);
      return localIntent;
    }

    public static Intent a(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent(paramContext, ChangePhoneNumberActivity.class);
      if (paramString != null)
        localIntent.putExtra("entry_point", paramString);
      return localIntent;
    }
  }

  public static class m
  {
    private static Intent a()
    {
      return new Intent("android.intent.action.VIEW", Uri.parse(com.viber.voip.api.scheme.i.c(d.n.j.d())));
    }

    public static Intent a(Context paramContext, ConversationItemLoaderEntity paramConversationItemLoaderEntity, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString1, boolean paramBoolean, String paramString2)
    {
      Intent localIntent = new Intent(paramContext, ChatExtensionPanelActivity.class);
      localIntent.putExtra("conversation_data", paramConversationItemLoaderEntity);
      localIntent.putExtra("chat_extension", paramChatExtensionLoaderEntity);
      localIntent.putExtra("chat_extension_query", paramString1);
      localIntent.putExtra("chat_extension_silent_query", paramBoolean);
      localIntent.putExtra("chat_extension_entry_point", paramString2);
      localIntent.addFlags(536870912);
      return localIntent;
    }

    public static void a(Context paramContext)
    {
      Intent localIntent = a();
      localIntent.putExtra("cdr_open_trigger_extra", 12);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void a(Context paramContext, Uri paramUri, long paramLong, int paramInt1, InternalBrowser paramInternalBrowser, BotReplyRequest paramBotReplyRequest, int paramInt2)
    {
      if ((paramInternalBrowser != null) && (InternalBrowser.b.PARTIAL_SIZE == paramInternalBrowser.getOpenMode()));
      for (Intent localIntent = new Intent(paramContext, ChatExInternalBrowserPartialSizeActivity.class); ; localIntent = new Intent(paramContext, ChatExInternalBrowserActivity.class))
      {
        localIntent.putExtra("extra_url", paramUri.toString());
        localIntent.putExtra("extra_title", dl.a(paramUri));
        localIntent.putExtra("extra_ignore_history", false);
        localIntent.putExtra("extra_use_host_for_title", true);
        if (paramInternalBrowser == null)
          localIntent.putExtra("extra_orientation", paramInt2);
        localIntent.putExtra("extra_conversation_id", paramLong);
        localIntent.putExtra("extra_conversation_type", paramInt1);
        localIntent.putExtra("extra_browser_config", paramInternalBrowser);
        localIntent.putExtra("extra_pending_bot_reply_request", paramBotReplyRequest);
        new ViberActionRunner.bs(localIntent).a(paramContext);
        return;
      }
    }

    public static void a(Context paramContext, MessageOpenUrlSpec paramMessageOpenUrlSpec)
    {
      a(paramContext, paramMessageOpenUrlSpec.uri, paramMessageOpenUrlSpec.conversationId, paramMessageOpenUrlSpec.conversationType, null, null, paramMessageOpenUrlSpec.orientation);
    }

    public static void a(Fragment paramFragment, ConversationItemLoaderEntity paramConversationItemLoaderEntity, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString1, boolean paramBoolean, String paramString2)
    {
      a(paramFragment, paramConversationItemLoaderEntity, paramChatExtensionLoaderEntity, paramString1, false, paramBoolean, paramString2);
    }

    public static void a(Fragment paramFragment, ConversationItemLoaderEntity paramConversationItemLoaderEntity, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
    {
      if (paramBoolean2)
      {
        paramFragment.getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in_fast, 0, 0, R.anim.fade_out_fast).replace(R.id.chatexPanelContainer, com.viber.voip.messages.extensions.b.i.a(paramConversationItemLoaderEntity, paramChatExtensionLoaderEntity, paramString1, paramBoolean1, paramString2)).addToBackStack(null).commit();
        return;
      }
      paramFragment.startActivity(a(paramFragment.requireContext(), paramConversationItemLoaderEntity, paramChatExtensionLoaderEntity, paramString1, paramBoolean1, paramString2));
    }

    public static void a(Fragment paramFragment, ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean, String paramString)
    {
      a(paramFragment, paramConversationItemLoaderEntity, null, null, paramBoolean, paramString);
    }
  }

  public static class n
  {
    public static boolean a(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent(paramContext, CommonGroupsActivity.class);
      localIntent.putExtra("members_id", paramString);
      return ViberActionRunner.b(paramContext, localIntent);
    }
  }

  public static class o
  {
    public static Intent a(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, boolean paramBoolean, long paramLong2, String paramString5)
    {
      Intent localIntent = new Intent("com.viber.voip.action.VIEW_CALL_LOG");
      localIntent.putExtra("con_number", paramString2);
      localIntent.putExtra("is_viber", paramBoolean);
      localIntent.putExtra("photo_uri", paramUri);
      localIntent.putExtra("name", paramString4);
      localIntent.putExtra("contact_id", paramLong1);
      localIntent.putExtra("lookup_key", paramString1);
      localIntent.putExtra("viber_number", paramString3);
      localIntent.putExtra("aggregated_hash", paramLong2);
      localIntent.putExtra("member_id", paramString5);
      return localIntent;
    }

    public static Intent a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
    {
      if (ViberApplication.isTablet(paramContext));
      for (String str = "com.viber.voip.action.VIEW_CONTACT_DIALOG"; ; str = "com.viber.voip.action.VIEW_CONTACT")
      {
        Intent localIntent = new Intent(str);
        localIntent.putExtra("con_number", paramString1);
        localIntent.putExtra("is_viber", paramBoolean);
        if (paramBoolean)
          localIntent.putExtra("viber_number", paramString1);
        localIntent.putExtra("member_id", paramString2);
        return localIntent;
      }
    }

    public static Intent a(ParticipantSelector.Participant paramParticipant, com.viber.voip.model.entity.g paramg, boolean paramBoolean)
    {
      Intent localIntent = new Intent("com.viber.voip.action.VIEW_CONTACT");
      if (paramBoolean)
        localIntent.putExtra("EXTRA_RETURN_TO_HOME", true);
      localIntent.putExtra("con_number", paramParticipant.getNumber());
      Member localMember;
      if (paramg != null)
      {
        localMember = (Member)paramg.d().get(paramParticipant.getNumber());
        if (localMember != null)
          break label86;
      }
      label86: for (String str = ""; ; str = localMember.getId())
      {
        localIntent.putExtra("member_id", str);
        localIntent.putExtra("name", paramg.k());
        return localIntent;
      }
    }

    public static Intent a(String paramString, boolean paramBoolean, long paramLong)
    {
      Intent localIntent = new Intent("com.viber.voip.action.VIEW_CALL_LOG");
      localIntent.putExtra("con_number", paramString);
      localIntent.putExtra("is_viber", paramBoolean);
      localIntent.putExtra("unknown", true);
      localIntent.putExtra("aggregated_hash", paramLong);
      return localIntent;
    }

    public static Intent a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, Uri paramUri, String paramString3, String paramString4, String paramString5)
    {
      Intent localIntent = new Intent();
      if (paramBoolean);
      for (String str = "com.viber.voip.action.VIEW_CONTACT_DIALOG"; ; str = "com.viber.voip.action.VIEW_CONTACT")
      {
        localIntent.setAction(str);
        localIntent.putExtra("contact_id", paramLong);
        localIntent.putExtra("lookup_key", paramString2);
        localIntent.putExtra("name", paramString1);
        localIntent.putExtra("photo_uri", paramUri);
        localIntent.putExtra("con_number", paramString3);
        localIntent.putExtra("viber_number", paramString4);
        localIntent.putExtra("member_id", paramString5);
        return localIntent;
      }
    }

    public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong, int paramInt3)
    {
      com.viber.voip.model.entity.m localm = com.viber.voip.messages.d.c.c().b(paramLong);
      com.viber.voip.model.h localh = null;
      if (localm != null)
        localh = com.viber.voip.model.entity.m.a(paramInt3, false, localm);
      a(paramContext, paramInt1, paramInt2, localh);
    }

    public static void a(Context paramContext, int paramInt1, int paramInt2, com.viber.voip.model.h paramh)
    {
      boolean bool1 = true;
      boolean bool2 = ViberApplication.isTablet(paramContext);
      if ((paramh == null) || ((!da.a(paramh.h())) && ("viber".equals(paramh.h().toLowerCase()))))
        return;
      if ((paramh.g() > 0L) && ((com.viber.voip.messages.m.b(paramInt1)) || (!cd.f(paramInt2))))
      {
        paramContext.startActivity(a(bool2, paramh.g(), paramh.getContactName(), "", paramh.j(), paramh.getNumber(), null, paramh.h()));
        return;
      }
      String str1 = paramh.getNumber();
      boolean bool3;
      boolean bool4;
      label168: String str2;
      Uri localUri;
      if ((!da.a(str1)) && (ce.l.matcher(str1).matches()))
      {
        bool3 = bool1;
        if ((!com.viber.voip.messages.m.a(paramInt1)) || (!bool3) || (!cd.c(paramInt2)))
          break label237;
        bool4 = bool1;
        if ((com.viber.voip.messages.m.e(paramInt1)) && (!bool4))
          break label249;
        str2 = paramh.a(paramInt2, paramInt1);
        localUri = paramh.j();
        if (cg.c(paramh.getNumber()))
          break label243;
      }
      while (true)
      {
        a(paramContext, bool2, str1, str2, localUri, bool1, paramh.h());
        return;
        bool3 = false;
        break;
        label237: bool4 = false;
        break label168;
        label243: bool1 = false;
      }
      label249: if ((com.viber.voip.messages.m.b(paramInt1)) && (cd.b(paramh.a())));
      while (true)
      {
        Intent localIntent = PublicGroupParticipantDetailsActivity.buildIntentForSingleShowing(paramContext, paramh.j(), paramh.a(paramInt2, paramInt1), bool1);
        if (!(paramContext instanceof Activity))
          localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
        return;
        bool1 = false;
      }
    }

    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      if (!da.a(paramString3));
      for (Uri localUri = Uri.parse(paramString3); ; localUri = null)
      {
        a(paramContext, null, false, paramString1, paramString2, localUri);
        return;
      }
    }

    public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3, Uri paramUri)
    {
      Intent localIntent = a(paramContext, paramString1, paramBoolean, paramString2);
      localIntent.putExtra("name", paramString3);
      localIntent.putExtra("photo_uri", paramUri);
      ViberActionRunner.b(paramContext, localIntent);
    }

    public static void a(Context paramContext, boolean paramBoolean, long paramLong, String paramString1, String paramString2, Uri paramUri)
    {
      paramContext.startActivity(a(paramBoolean, paramLong, paramString1, paramString2, paramUri, null, null, null));
    }

    public static void a(Context paramContext, boolean paramBoolean1, String paramString1, String paramString2, Uri paramUri, boolean paramBoolean2, String paramString3)
    {
      a(paramContext, paramBoolean1, paramString1, paramString2, paramUri, paramBoolean2, paramString3, null);
    }

    public static void a(Context paramContext, boolean paramBoolean1, String paramString1, String paramString2, Uri paramUri, boolean paramBoolean2, String paramString3, ExtraActionAfterContactIsAdded paramExtraActionAfterContactIsAdded)
    {
      Intent localIntent = new Intent();
      if (paramBoolean1);
      for (String str = "com.viber.voip.action.VIEW_CONTACT_DIALOG"; ; str = "com.viber.voip.action.VIEW_CONTACT")
      {
        localIntent.setAction(str);
        localIntent.putExtra("con_number", paramString1);
        localIntent.putExtra("is_viber", paramBoolean2);
        localIntent.putExtra("photo_uri", paramUri);
        localIntent.putExtra("name", paramString2);
        localIntent.putExtra("member_id", paramString3);
        if (paramExtraActionAfterContactIsAdded != null)
          localIntent.putExtra("action_after_contact_is_added", paramExtraActionAfterContactIsAdded);
        paramContext.startActivity(localIntent);
        return;
      }
    }
  }

  public static class p
  {
    public static void a()
    {
      a("sync_account_remove", 0L);
    }

    public static void a(long paramLong)
    {
      a("sync_account_check", paramLong);
    }

    public static void a(String paramString, long paramLong)
    {
      if (!ao.g())
        return;
      com.firebase.jobdispatcher.e locale = ViberApplication.getInstance().getFirebaseJobDispatcher();
      locale.a(locale.a().a(ContactsSyncAccountService.class).a(paramString).a(true).a(v.a((int)(paramLong / 1000L), (int)(paramLong / 1000L))).j());
    }

    public static void b()
    {
      a("sync_account_rename", 0L);
    }

    public static void b(long paramLong)
    {
      a("sync_account_sync", paramLong);
    }
  }

  public static class q
  {
    public static Intent a(Context paramContext)
    {
      if ((com.viber.common.d.a.g()) && ((!dj.d()) || (!com.viber.common.d.a.l())))
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        localIntent.putExtra("app_package", paramContext.getPackageName());
        localIntent.putExtra("app_uid", paramContext.getApplicationInfo().uid);
        localIntent.putExtra("android.provider.extra.APP_PACKAGE", paramContext.getPackageName());
        if (!ViberActionRunner.a(localIntent, paramContext))
          localIntent = b(paramContext);
        return localIntent;
      }
      return b(paramContext);
    }

    public static Intent b(Context paramContext)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.parse("package:" + paramContext.getPackageName()));
      return localIntent;
    }
  }

  public static class r
  {
    public static Intent a()
    {
      return new Intent("com.viber.voip.action.CALL");
    }

    public static Intent a(Context paramContext)
    {
      return new Intent("com.viber.voip.action.REJECT_CALL").setClass(paramContext, ViberPhoneService.class);
    }

    public static Intent a(Context paramContext, long paramLong, ConferenceInfo paramConferenceInfo, String paramString)
    {
      Intent localIntent = new Intent(paramContext, GroupCallDetailsActivity.class);
      localIntent.putExtra("aggregated_hash", paramLong);
      localIntent.putExtra("conference_info", paramConferenceInfo);
      localIntent.putExtra("analytics_entry_point", paramString);
      return localIntent;
    }

    public static Intent a(Context paramContext, Uri paramUri)
    {
      Intent localIntent = a();
      localIntent.setData(paramUri);
      localIntent.setClass(paramContext, PhoneFragmentActivity.class);
      return localIntent;
    }

    public static Intent a(Context paramContext, ConferenceInfo paramConferenceInfo, long paramLong, String paramString)
    {
      Intent localIntent = new Intent(paramContext, GroupCallStartParticipantsActivity.class);
      localIntent.putExtra("conference_info", paramConferenceInfo);
      localIntent.putExtra("associated_conversation_id", paramLong);
      localIntent.putExtra("analytics_entry_point", paramString);
      return localIntent;
    }

    public static Intent a(Context paramContext, ConferenceInfo paramConferenceInfo, String paramString)
    {
      return a(paramContext, paramConferenceInfo, -1L, paramString);
    }

    public static Intent a(Context paramContext, OngoingConferenceCallModel paramOngoingConferenceCallModel)
    {
      Intent localIntent = a();
      localIntent.putExtra("conference", paramOngoingConferenceCallModel);
      localIntent.setClass(paramContext, PhoneFragmentActivity.class);
      return localIntent;
    }

    public static Intent a(Context paramContext, boolean paramBoolean)
    {
      Intent localIntent = new Intent(paramContext, PhoneFragmentActivity.class);
      if (paramBoolean);
      for (String str = "com.viber.voip.action.CALL"; ; str = "com.viber.voip.action.CALL_FROM_BACKGROUND")
      {
        localIntent.setAction(str);
        localIntent.addFlags(327684);
        return localIntent;
      }
    }

    public static Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new Intent("com.viber.voip.action.ACCEPT_CALL").putExtra("is_video_call", paramBoolean1).putExtra("is_conference_call", paramBoolean2).setClass(paramContext, PhoneFragmentActivity.class);
    }

    public static ViberActionRunner.a a(Context paramContext, boolean paramBoolean, CallInfo paramCallInfo)
    {
      if (com.viber.voip.notif.i.i.a())
        return ViberActionRunner.v.a;
      return new ViberActionRunner.ad(a(paramContext, paramBoolean), 0);
    }

    public static void a(Fragment paramFragment, String paramString, int paramInt)
    {
      Intent localIntent = new Intent("com.viber.voip.action.CREATE_CONFERENCE_WITH_1ON1_PARTICIPANTS");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ParticipantSelector.Participant(paramString, true));
      localIntent.putParcelableArrayListExtra("already_added_participants", localArrayList);
      localIntent.putExtra("group_role", 1);
      localIntent.putExtra("max_participant_count", paramInt);
      paramFragment.startActivityForResult(localIntent, 108);
    }

    public static void a(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
    {
      Intent localIntent = new Intent("com.viber.voip.action.ADD_PARTICIPANTS_TO_CONFERENCE");
      ArrayList localArrayList = new ArrayList();
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
        localArrayList.add(new ParticipantSelector.Participant(paramArrayOfString[j], true));
      localIntent.putParcelableArrayListExtra("already_added_participants", localArrayList);
      localIntent.putExtra("title", paramFragment.getResources().getString(R.string.add_to_call));
      localIntent.putExtra("max_participant_count", paramInt);
      paramFragment.startActivityForResult(localIntent, 108);
    }

    public static ViberActionRunner.ad b(Context paramContext, boolean paramBoolean)
    {
      if ((paramBoolean) && (y.c()));
      for (Intent localIntent = new Intent(paramContext, y.b()); ; localIntent = new Intent(paramContext, PhoneFragmentActivity.class))
      {
        localIntent.addFlags(327684);
        return new ViberActionRunner.ad(localIntent, 0);
      }
    }
  }

  public static class s
  {
    public static Intent a(Context paramContext, Integer paramInteger1, Boolean paramBoolean1, Boolean paramBoolean2, String paramString, Integer paramInteger2, Integer paramInteger3, Boolean paramBoolean3)
    {
      Intent localIntent = new Intent(paramContext, SayHiToFriendsActivity.class);
      if (paramInteger1 != null)
        localIntent.putExtra("default_media_type", paramInteger1.intValue());
      if (paramBoolean1 != null)
        localIntent.putExtra("suggested_section", paramBoolean1);
      if (paramBoolean2 != null)
        localIntent.putExtra("show_groups", paramBoolean2);
      if (paramString != null)
        localIntent.putExtra("campaign", paramString);
      if (paramInteger2 != null)
        localIntent.putExtra("suggestion_type", paramInteger2.intValue());
      if (paramInteger3 != null)
        localIntent.putExtra("min_last_seen_days", paramInteger3.intValue());
      if (paramBoolean3 != null)
        localIntent.putExtra("from_url_scheme", paramBoolean3);
      return localIntent;
    }

    public static void a(Context paramContext)
    {
      paramContext.startActivity(a(paramContext, null, null, null, null, null, null, null));
    }
  }

  public static class t
  {
    public static void a(Context paramContext, Uri paramUri, String paramString, boolean paramBoolean)
    {
      if ((paramContext == null) || (paramUri == null))
        ViberApplication.getInstance().showToast(R.string.file_not_found);
      do
      {
        return;
        Intent localIntent;
        Uri localUri;
        try
        {
          paramContext.getContentResolver().openInputStream(paramUri).close();
          localIntent = new Intent("android.intent.action.VIEW");
          localUri = ViberActionRunner.a(paramUri, paramContext);
          if (localUri == null)
          {
            ViberApplication.getInstance().showToast(R.string.file_not_found);
            return;
          }
        }
        catch (IOException localIOException)
        {
          ViberApplication.getInstance().showToast(R.string.file_not_found);
          return;
        }
        localIntent.setDataAndType(localUri, paramString);
        localIntent.addFlags(1);
        if (ViberActionRunner.a(localIntent, paramContext))
        {
          paramContext.startActivity(localIntent);
          return;
        }
      }
      while (!paramBoolean);
      ViberApplication.getInstance().showToast(R.string.dialog_306_message);
    }
  }

  public static class u
  {
    public static Intent a()
    {
      Intent localIntent = a(new int[] { 0 });
      localIntent.putExtra("show_ivm_promotion", true);
      return localIntent;
    }

    public static Intent a(int paramInt1, int paramInt2)
    {
      Intent localIntent = a(new int[] { 5 });
      localIntent.putExtra("is_forward_only_locations", true);
      localIntent.putExtra("forward_locations_lat", paramInt1);
      localIntent.putExtra("forward_locations_lng", paramInt2);
      return localIntent;
    }

    public static Intent a(long paramLong, int paramInt)
    {
      Intent localIntent = a(new int[] { paramInt });
      localIntent.putExtra("default_message_forward_array", new long[] { paramLong });
      return localIntent;
    }

    public static Intent a(Intent paramIntent, Bundle paramBundle)
    {
      return paramIntent.putExtra("options", paramBundle);
    }

    public static Intent a(Uri paramUri)
    {
      return a(paramUri.toString(), com.viber.voip.messages.l.a(at.g(paramUri)));
    }

    public static Intent a(aa paramaa)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = paramaa.q();
      Intent localIntent = a(arrayOfInt);
      long[] arrayOfLong = new long[1];
      arrayOfLong[0] = paramaa.a();
      localIntent.putExtra("default_message_forward_array", arrayOfLong);
      return localIntent;
    }

    public static Intent a(ComposeDataContainer paramComposeDataContainer)
    {
      Intent localIntent = a(new int[] { 9 });
      localIntent.putExtra("compose_data_extra", paramComposeDataContainer);
      localIntent.putExtra("extra_forward_contact", true);
      return localIntent;
    }

    public static Intent a(String paramString, int paramInt)
    {
      Intent localIntent = a(new int[] { paramInt });
      localIntent.putExtra("share_uri", paramString);
      localIntent.putExtra("media_type", paramInt);
      return localIntent;
    }

    public static Intent a(String paramString, NewsShareAnalyticsData paramNewsShareAnalyticsData)
    {
      Intent localIntent = a(paramString, false);
      localIntent.putExtra("alter_extra_up", true);
      localIntent.putExtra("news_provider_base_url", paramNewsShareAnalyticsData);
      return localIntent;
    }

    public static Intent a(String paramString, boolean paramBoolean)
    {
      Intent localIntent = a(new int[] { 0 });
      if (paramBoolean)
      {
        localIntent.putExtra("forward _draft", paramString);
        return localIntent;
      }
      localIntent.putExtra("share_text", paramString);
      return localIntent;
    }

    public static Intent a(ArrayList<Uri> paramArrayList, CharSequence paramCharSequence)
    {
      int[] arrayOfInt = new int[paramArrayList.size()];
      for (int i = 0; i < arrayOfInt.length; i++)
        arrayOfInt[i] = com.viber.voip.messages.l.a(at.g((Uri)paramArrayList.get(i)));
      Intent localIntent = a(arrayOfInt);
      localIntent.putExtra("share_files_uri", paramArrayList);
      if (!da.a(paramCharSequence))
        localIntent.putExtra("share_text", paramCharSequence);
      return localIntent;
    }

    public static Intent a(List<aa> paramList)
    {
      long[] arrayOfLong = new long[paramList.size()];
      int[] arrayOfInt = new int[paramList.size()];
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        aa localaa = (aa)paramList.get(j);
        arrayOfLong[j] = localaa.a();
        arrayOfInt[j] = localaa.q();
      }
      Intent localIntent = a(arrayOfInt);
      localIntent.putExtra("default_message_forward_array", arrayOfLong);
      return localIntent;
    }

    public static Intent a(int[] paramArrayOfInt)
    {
      Intent localIntent = new Intent("com.viber.voip.action.ACTION_FORWARD");
      localIntent.putExtra("show_public_accounts_extra", com.viber.voip.publicaccount.d.e.a(paramArrayOfInt));
      localIntent.putExtra("show_middle_state_communities_extra", false);
      return localIntent;
    }
  }

  public static class v
    implements ViberActionRunner.a
  {
    public static final v a = new v(dm.a);
    private final Runnable b;
    private final Handler c;

    public v(Handler paramHandler, Runnable paramRunnable)
    {
      this.b = paramRunnable;
      this.c = paramHandler;
    }

    public v(Runnable paramRunnable)
    {
      this(null, paramRunnable);
    }

    public void a(Context paramContext)
    {
      if (this.c != null)
      {
        dd.a(this.c, this.b);
        return;
      }
      this.b.run();
    }
  }

  public static class w
  {
    public static Intent a(Context paramContext, MediaPlayer.VisualSpec paramVisualSpec, MediaPlayerControls.VisualSpec paramVisualSpec1, Rect paramRect)
    {
      Intent localIntent = new Intent(paramContext, FullScreenVideoPlayerActivity.class);
      localIntent.putExtra("video_player_spec", new VideoPlayerScreenSpec(paramVisualSpec, paramVisualSpec1, paramRect));
      return localIntent;
    }

    public static void a(Context paramContext, BotReplyRequest paramBotReplyRequest, MediaPlayer.VisualSpec paramVisualSpec, MediaPlayerControls.VisualSpec paramVisualSpec1, Rect paramRect)
    {
      Intent localIntent = a(paramContext, paramVisualSpec, paramVisualSpec1, paramRect);
      localIntent.putExtra("bot_reply_request", paramBotReplyRequest);
      ViberActionRunner.a(paramContext, localIntent);
      paramContext.startActivity(localIntent);
    }

    public static void b(Context paramContext, MediaPlayer.VisualSpec paramVisualSpec, MediaPlayerControls.VisualSpec paramVisualSpec1, Rect paramRect)
    {
      Intent localIntent = a(paramContext, paramVisualSpec, paramVisualSpec1, paramRect);
      ViberActionRunner.a(paramContext, localIntent);
      paramContext.startActivity(localIntent);
    }
  }

  public static class x
  {
    public static Intent a(Context paramContext, ConversationData paramConversationData, ArrayList<GalleryItem> paramArrayList, Bundle paramBundle)
    {
      Intent localIntent = new Intent(paramContext, PhotoPreviewActivity.class);
      localIntent.putParcelableArrayListExtra("image_list", paramArrayList);
      localIntent.putExtra("extra_conversation_data", paramConversationData);
      localIntent.putExtra("options", paramBundle);
      return localIntent;
    }

    public static Intent a(Context paramContext, ArrayList<GalleryItem> paramArrayList, ConversationData paramConversationData)
    {
      Intent localIntent = new Intent(paramContext, AddMoreGallery.class);
      localIntent.putExtra("extra_multiple_selection", true);
      localIntent.putExtra("extra_conversation_data", paramConversationData);
      localIntent.putParcelableArrayListExtra("extra_selected_images", paramArrayList);
      return localIntent;
    }

    public static void a(Context paramContext, ConversationData paramConversationData, Bundle paramBundle)
    {
      paramContext.startActivity(b(paramContext, paramConversationData, paramBundle));
    }

    public static Intent b(Context paramContext, ConversationData paramConversationData, Bundle paramBundle)
    {
      Intent localIntent = new Intent(paramContext, SelectionGallery.class);
      localIntent.putExtra("extra_conversation_data", paramConversationData);
      localIntent.putExtra("options", paramBundle);
      return localIntent;
    }
  }

  public static class y
  {
    public static Intent a(Context paramContext, int paramInt)
    {
      Intent localIntent = new Intent(paramContext, ConsentActivity.class);
      localIntent.putExtra("ConsentActivity.ScreenId", paramInt);
      return ViberActionRunner.a(paramContext, localIntent);
    }

    public static void b(Context paramContext, int paramInt)
    {
      paramContext.startActivity(a(paramContext, paramInt));
    }
  }

  public static class z
  {
    public static void a(Context paramContext)
    {
      a(paramContext, false);
    }

    public static void a(Context paramContext, boolean paramBoolean)
    {
      Intent localIntent = new Intent(paramContext, GlobalNotificationSplashActivity.class);
      localIntent.setFlags(872415232);
      localIntent.putExtra("debug_mode_extra", paramBoolean);
      paramContext.startActivity(localIntent);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ViberActionRunner
 * JD-Core Version:    0.6.2
 */