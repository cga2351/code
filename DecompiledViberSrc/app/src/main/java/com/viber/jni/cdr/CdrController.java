package com.viber.jni.cdr;

import com.google.d.c.a;
import com.google.d.f;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.news.NewsSession;
import com.viber.voip.news.ViberNewsProviderSpec;
import com.viber.voip.util.da;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CdrController
  implements ICdrController
{
  private static final String ADDS_AFTER_CALL_ACTION = "AddsAfterCallAction";
  private static final String ADDS_AFTER_CALL_DISPLAY = "AddsAfterCallDisplay";
  private static final String AD_REQUEST_SENT = "ad_request_sent";
  private static final String ANIMATED_GIF = "AnimatedGif";
  private static final String APPS_APPROVAL_PAGE = "AppsApprovalPage";
  private static final String BACKUP = "Backup";
  private static final String BROADCAST_SEND_MESSAGE = "broadcast";
  private static final String CLICK_ON_RICH_MESSAGE = "click_on_rich_message";
  private static final String CLIENT_TRACKING_EVENT = "client_tracking_event";
  private static final String COMMUNITY_VIEW = "community_view";
  private static final String DISCOVER_SCREEN_SESSION = "DiscoverScreenSession";
  private static final String FACEBOOK = "Facebook";
  private static final String FAVORITES = "Favorites";
  private static final String GAME_INVITATION_CLICKED = "GameInvitationClicked";
  private static final String GAME_INVITATION_DISPLAYED = "GameInvitationDisplayed";
  private static final String GAME_REDIRECT = "GameRedirect";
  private static final String GENERAL_CLIENT_CDR = "general_client_cdr";
  private static final String GENERIC_PUSH = "GenericPush";
  private static final String INSTANT_SHOPPING_KEYBOARD_OPEN = "instant_shopping_keyboard_open";
  private static final Logger L = ViberEnv.getLogger();
  private static final String MAKE_MOBILE_CALL = "MakeMobileCall";
  private static final String MEDIA_SCREEN_SEND = "media_screen_send";
  private static final String MISSING_MEMBER_ID = "MissingMemberID";
  private static final String NAME_REPORT_URL_SPAM = "ReportURLSpam";
  private static final String PA_1ON1_MESSAGE_BOT_REPLIED = "PA1On1MessageBotReplied";
  private static final String PA_CREATION_START_ANDLEAVE_PROCESS = "PACreationStartAndLeaveProcess";
  private static final String PA_ENTERING_1ON1_CHAT = "PAEntering1On1Chat";
  private static final String PA_IMPRESSIONS = "PAImpressions";
  private static final String PA_INFO_SCREEN_DISPLAY = "PAInfoScreenDisplay";
  private static final String PA_INTERACTIONS = "PAInteractions";
  public static final int PA_INTERACTIONS_NO_STICKER_NUMBER = -1;
  private static final String PA_TAPPING_ON_WEBSITE = "PATappingOnWebSite";
  private static final String PIN_TO_TOP = "PinToTop";
  private static final String PURCHASE_STATUS = "PurchaseStatus";
  private static final String SCREEN_AD_CLICK = "screen_ad_click";
  private static final String SCREEN_AD_DISPLAY = "screen_ad_display";
  private static final String SCREEN_DISPLAY = "screen_display";
  private static final String SHARE_FROM_STICKER_PRODUCT_PAGE = "ShareFromStickerProductPage";
  private static final String SHARE_NATIVE_MENU = "ShareNativeMenu";
  private static final String SHIFT_KEY_MESSAGE_SENT = "ShiftKeyMessageSent";
  private static final String SHIFT_KEY_SEARCH = "shift_key_search";
  private static final String STICKER_MARKET_ENTRY = "StickerMarketEntry";
  private static final String STICKER_MENU_EXPOSURES = "StickerMenuExposures";
  private static final String STICKER_PACKS_IN_STICKER_MENU = "StickerPacksInStrickerMenu";
  private static final String TAG_ABOUT_VALUE = "AboutValue";
  private static final String TAG_ACCESS_TOKEN = "AccessToken";
  private static final String TAG_ACTION = "Action";
  private static final String TAG_ACTION_DURATION = "ActionDuration";
  private static final String TAG_ACTION_REPLY_TYPE = "ActionReplyType";
  private static final String TAG_ACTION_TYPE = "ActionType";
  private static final String TAG_ADMOB_ADVERTISING_ID = "advertising_id";
  private static final String TAG_ADMOB_RESPONSE_CODE = "ad_response_code";
  private static final String TAG_ADS_LOCATION = "ads_location";
  private static final String TAG_ADS_SDK_VERSION = "ads_sdk_version";
  private static final String TAG_ADVERTISING_ID = "AdvertisingID";
  private static final String TAG_AD_CALL_TOKEN = "call_token";
  private static final String TAG_AD_POSITION_IN_PAGE = "ad_position_in_page";
  private static final String TAG_AD_SERVICE_IND = "ad_service_ind";
  private static final String TAG_AD_TYPE = "ad_type";
  private static final String TAG_AD_TYPE_CALL = "ad_type_call";
  private static final String TAG_AD_TYPE_REQUESTED = "ad_type_requested";
  private static final String TAG_AD_UNIT_ID = "ad_unit_id";
  private static final String TAG_AGE_RESTRICTED = "AgeRestricted";
  private static final String TAG_AMOUNT = "Amount";
  private static final String TAG_APP_ID = "AppID";
  private static final String TAG_APP_NAME = "AppName";
  private static final String TAG_BACKUP_FREQUENCY = "BackupFrequency";
  private static final String TAG_BILLING_TOKEN = "BillingToken";
  private static final String TAG_BLOCKED_COUNTRY_CODE = "BlockedCountryCode";
  private static final String TAG_BLOCKED_MEMBER_ID = "BlockedMemberID";
  private static final String TAG_BLOCKED_PHONE_NUMBER = "BlockedPhoneNumber";
  private static final String TAG_BRODACAST_MEDIA_TYPE = "media_type";
  private static final String TAG_BUTTON = "Button";
  private static final String TAG_CALL_TOKEN = "CallToken";
  private static final String TAG_CATEGORY = "Category";
  private static final String TAG_CATEGORY_VALUE = "CategoryValue";
  private static final String TAG_CHAT_ID = "ChatID";
  private static final String TAG_CHAT_MEMBER_ID = "ChatMemberID";
  private static final String TAG_CHAT_SOLUTION = "ChatSolution";
  private static final String TAG_CHAT_TYPE = "ChatType";
  private static final String TAG_CHUNK = "Chunk";
  private static final String TAG_CHUNK_LOCATION = "ChunkLocation";
  private static final String TAG_CLICK_TIME_STAMP = "ClickTimeStamp";
  private static final String TAG_CLIENT_CALL_TOKEN = "client_call_token";
  private static final String TAG_CLOUD_STORAGE = "CloudStorage";
  private static final String TAG_COMMUNITY_ID = "community_id";
  private static final String TAG_COMMUNITY_VIEW_SOURCE = "community_view_source";
  private static final String TAG_CONTENT_PROVIDER = "ContentProvider";
  private static final String TAG_CONTENT_PROVIDER_POSITION = "ContentProviderPosition";
  private static final String TAG_CONTEXT_CHAT_TYPE = "ContextChatType";
  private static final String TAG_COUNTRY_CODE = "CountryCode";
  private static final String TAG_CREATIVE_ID = "CreativeID";
  private static final String TAG_CURRENCY = "Currency";
  private static final String TAG_DIFFERENCE = "Difference";
  private static final String TAG_DOMAIN = "Domain";
  private static final String TAG_EMAIL_VALUE = "EmailValue";
  private static final String TAG_ENTRY_POINT = "EntryPoint";
  private static final String TAG_ERROR_CODE = "ErrorCode";
  private static final String TAG_ERROR_DISPLAY = "error_display";
  private static final String TAG_EXTERNAL_ID = "ExternalID";
  private static final String TAG_FB_ID = "FBID";
  private static final String TAG_FB_TOKEN = "FBToken";
  private static final String TAG_FILE_SIZE = "FileSize";
  private static final String TAG_FINISHED = "Finished";
  private static final String TAG_FIRST_MESSAGE_USER_TIME_STAMP = "FirstMessageUserTimeStamp";
  private static final String TAG_FIRST_MESSAGE_USER_TOKEN = "FirstMessageUserToken";
  private static final String TAG_FOLLOWING = "Following";
  private static final String TAG_FULL_URL = "FullURL";
  private static final String TAG_GAME_NAME = "GameName";
  private static final String TAG_GIF = "GIF";
  private static final String TAG_GIF_ID = "GifId";
  private static final String TAG_GIF_PROVIDER_ID = "GifProviderId";
  private static final String TAG_GOOGLE_SDK_VERSION = "google_sdk_version";
  private static final String TAG_ICON_TRIGGER = "IconTrigger";
  private static final String TAG_ID_VALUE = "IDValue";
  private static final String TAG_INLINE_BOT_TYPE = "inline_bot_type";
  private static final String TAG_INTERACTION_TYPE = "InteractionType";
  private static final String TAG_IS_INVITATION = "is_invitation";
  private static final String TAG_ITEM_ID = "ItemID";
  private static final String TAG_ITEM_ORIGIN = "ItemOrigin";
  private static final String TAG_ITEM_TYPE = "ItemType";
  private static final String TAG_KEYBOARD_ACTION = "KeyboardAction";
  private static final String TAG_LAST_MESSAGE_TOKEN = "last_message_token";
  private static final String TAG_LEAVE_PROCESS_TIME = "LeaveProcessTime";
  private static final String TAG_LENGTH = "Length";
  private static final String TAG_LINKEDSERVICETYPE = "LinkedServiceType";
  private static final String TAG_LIST_ITEMS_NUMBER = "list_items_number";
  private static final String TAG_LOCATIONC_OUNTRY_VALUE = "LocationCountryValue";
  private static final String TAG_LOCATION_COORDINATION_LAT = "LocationCoordinationLat";
  private static final String TAG_LOCATION_COORDINATION_LONG = "LocationCoordinationLong";
  private static final String TAG_MEDIATION = "mediation";
  private static final String TAG_MEDIA_TYPE = "MediaType";
  private static final String TAG_MENU_3005_FULL = "Menu3005Full";
  private static final String TAG_MESSAGE_BOT_TOKEN = "MessageBotToken";
  private static final String TAG_MESSAGE_DATE_TIME = "MessageDateTime";
  private static final String TAG_MESSAGE_FLAGS = "message_flags";
  private static final String TAG_MESSAGE_SEQUENCE = "MessageSequence";
  private static final String TAG_MESSAGE_TOKEN = "MessageToken";
  private static final String TAG_MUTE_IND = "mute_ind";
  private static final String TAG_NAME_VALUE = "NameValue";
  private static final String TAG_NEW_CHECKSUM = "new_checksum";
  private static final String TAG_NUMBER_LIKES = "NumberLikes";
  private static final String TAG_NUMBER_OF_CONTACTS = "NumberOfContacts";
  private static final String TAG_NUMBER_OF_DOOGLES = "NumberOfDoogles";
  private static final String TAG_NUMBER_OF_GROUPS = "NumberOfGroups";
  private static final String TAG_NUMBER_OF_RECIPIENTS = "number_of_recipients";
  private static final String TAG_OPERATION_ID = "OperationID";
  private static final String TAG_OPT_IN_TOKEN = "OptInToken";
  private static final String TAG_ORIGIN = "Origin";
  private static final String TAG_ORIGIN_ID = "OriginID";
  private static final String TAG_ORIGIN_SCREEN = "OriginScreen";
  private static final String TAG_PACK_ID = "PackID";
  private static final String TAG_PACK_ID_LIST = "PackIDList";
  private static final String TAG_PAGE_LEFT = "PageLeft";
  private static final String TAG_PA_ID = "pa_id";
  private static final String TAG_PRICE = "Price";
  private static final String TAG_PRODUCT_ID = "ProductId";
  private static final String TAG_PROVIDER = "Provider";
  private static final String TAG_PROVIDER_NAME = "provider_name";
  private static final String TAG_PUBLIC_ACCOUNT_ID = "PublicAccountID";
  private static final String TAG_PURCHASESTATUS = "PurchaseStatus";
  private static final String TAG_PURCHASEVIBERSTATUS = "PurchaseViberStatus";
  private static final String TAG_REASON = "Reason";
  private static final String TAG_RESULUTION = "Resolution";
  private static final String TAG_ROLE = "role";
  private static final String TAG_SCREEN_DISPLAY_ORIGIN = "origin_screen";
  private static final String TAG_SCREEN_ID = "screen_id";
  private static final String TAG_SCROLL_BLOCKS = "ScrollBlocks";
  private static final String TAG_SC_CREATIVE_ID = "creative_id";
  private static final String TAG_SEARCH_SUCCESS_IND = "search_success_ind";
  private static final String TAG_SEARCH_TERM = "SearchTerm";
  private static final String TAG_SECONDS_INTO_CALL = "seconds_into_call";
  private static final String TAG_SEQUENCE = "sequence";
  private static final String TAG_SERIAL_BLOCK_NUMBER = "SerialBlockNumber";
  private static final String TAG_SESSION = "Session";
  private static final String TAG_SESSION_TIME = "SessionTime";
  private static final String TAG_SESSION_TOKEN = "SessionToken";
  private static final String TAG_SHARED_APP_NAME = "SharedAppName";
  private static final String TAG_SHIFT_KEY_OBJECT_ID = "ShiftKeyObjectId";
  private static final String TAG_SOURCE = "Source";
  private static final String TAG_SPAM = "Spam";
  private static final String TAG_START_PROCESS_TIME = "StartProcessTime";
  private static final String TAG_STATUS = "Status";
  private static final String TAG_STICKER_NUMBER = "StickerNumber";
  private static final String TAG_SUB_CATEGORY = "Subcategory";
  private static final String TAG_SUB_CATEGORY_VALUE = "SubcategoryValue";
  private static final String TAG_S_ID = "s_id";
  private static final String TAG_TEST_FLAG = "TestFlag";
  private static final String TAG_TEXT = "Text";
  private static final String TAG_TIMEBOMB_LENGTH = "TimebombLength";
  private static final String TAG_TRACKING_EVENT_EXTRA_DATA = "tracking_event_extra_data";
  private static final String TAG_TRACKING_EVENT_ID = "tracking_event_id";
  private static final String TAG_TRACKING_EVENT_VALUE = "tracking_event_value";
  private static final String TAG_TRIGGERED_PACK_ID = "TriggeredPackID";
  private static final String TAG_TYPE = "Type";
  private static final String TAG_UI_DISPLAY_DURATION = "ui_display_duration";
  private static final String TAG_URL = "URL";
  private static final String TAG_USER_ROLE = "UserRole";
  private static final String TAG_USER_TYPE = "UserType";
  private static final String TAG_VIDEO_AD_LENGTH = "video_ad_length";
  private static final String TAG_VIDEO_AD_PROGRESS = "video_ad_progress";
  private static final String TAG_WEBSITE_VALUE = "WebsiteValue";
  private static final String TAG_WEB_AD_ADVERTISING_ID = "advertising_id";
  private static final String TAG_WEB_AD_CLICK = "web_ad_click";
  private static final String TAG_WEB_AD_DISPLAY = "web_ad_display";
  private static final String TAG_WITH_TEXT_IND = "WithTextInd";
  private static final String TERMS_AND_PRIVACY_POLICY = "TermsAndPrivacyPolicy";
  private static final String UI_DISPLAYED_DURING_CALL = "ui_displayed_during_call";
  private static final String VERSION_CHECKSUM_CHANGED = "version_checksum_changed";
  private static final String VOICE_MESSAGE = "VoiceMessage";
  private static final String VO_BANNER_CLICK = "VOBannerClick";
  private static final String VO_BANNER_DISPLAYED = "VOBannerDisplayed";
  private static final String VO_BUY = "VOBuy";
  private static final String VO_DISPLAY = "VODisplay";
  private static final String VO_SEND_CREDIT_SCREEN = "VOSendCreditScreen";
  private static final String VO_SEND_INVITE_SCREEN = "VOSendInviteScreen";
  private static final String WALLET_ENTRY_FROM = "WalletEntryFrom";
  private static final String WALLET_OPT_IN = "WalletOptIn";
  private static final String WEB = "Web";
  private static final String WESTERN_UNION = "WesternUnion";
  private String mAdvertisingId = "";
  private PhoneController mPhoneController;
  private final Map<String, Object> mTrackableObjects = new ConcurrentHashMap();

  public CdrController(PhoneController paramPhoneController)
  {
    this.mPhoneController = paramPhoneController;
  }

  private void addTrackable(String paramString, Object paramObject)
  {
    this.mTrackableObjects.put(paramString, paramObject);
  }

  private Cdr createGeneralCdr(String paramString)
    throws Exception
  {
    Cdr localCdr = Cdr.Create("general_client_cdr");
    localCdr.SetTag(paramString);
    return localCdr;
  }

  public static int getCdrRole(int paramInt)
  {
    switch (paramInt)
    {
    case 3:
    default:
      return 2;
    case 2:
      return 0;
    case 1:
    case 4:
    }
    return 1;
  }

  private <T> T removeTrackable(String paramString)
  {
    return this.mTrackableObjects.remove(paramString);
  }

  public boolean handleChatsScreenScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("frst_cht_itm_app_opn", paramInt1);
      localJSONObject.put("frst_cht_itm_view", paramInt2);
      localJSONObject.put("lst_cht_itm_view", paramInt3);
      localJSONObject.put("nm_chts", paramInt4);
      localJSONObject.put("nm_unrd_chts", paramInt5);
      boolean bool = handleClientTrackingReport(10, "0", localJSONObject.toString());
      return bool;
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }

  public boolean handleClientTrackingReport(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = false;
    try
    {
      Cdr localCdr = createGeneralCdr("client_tracking_event");
      localCdr.SetU32("tracking_event_id", paramInt);
      localCdr.SetString("tracking_event_value", paramString1);
      localCdr.SetString("tracking_event_extra_data", paramString2);
      bool = this.mPhoneController.handleReportCdr(localCdr);
      localCdr.Destroy();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return bool;
  }

  // ERROR //
  public boolean handleCommunityView(long paramLong, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 267
    //   4: invokespecial 775	com/viber/jni/cdr/CdrController:removeTrackable	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 777	java/lang/Integer
    //   10: astore 5
    //   12: aload 5
    //   14: ifnull +83 -> 97
    //   17: aload 5
    //   19: invokevirtual 781	java/lang/Integer:intValue	()I
    //   22: istore 6
    //   24: aload_0
    //   25: ldc 37
    //   27: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   30: astore 8
    //   32: aload 8
    //   34: ldc_w 264
    //   37: lload_1
    //   38: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   41: pop
    //   42: aload 8
    //   44: ldc_w 375
    //   47: aload_3
    //   48: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   51: pop
    //   52: aload 8
    //   54: ldc_w 499
    //   57: iload 4
    //   59: i2l
    //   60: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   63: pop
    //   64: aload 8
    //   66: ldc_w 267
    //   69: iload 6
    //   71: i2l
    //   72: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   80: aload 8
    //   82: invokeinterface 768 2 0
    //   87: istore 13
    //   89: aload 8
    //   91: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   94: iload 13
    //   96: ireturn
    //   97: iconst_0
    //   98: istore 6
    //   100: goto -76 -> 24
    //   103: astore 7
    //   105: iconst_0
    //   106: ireturn
    //   107: astore 14
    //   109: iload 13
    //   111: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   24	89	103	java/lang/Exception
    //   89	94	107	java/lang/Exception
  }

  public boolean handleReportAdRequestSent(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, int paramInt6)
  {
    boolean bool = false;
    try
    {
      Cdr localCdr = createGeneralCdr("ad_request_sent");
      localCdr.SetString("google_sdk_version", paramString1);
      localCdr.SetString("advertising_id", this.mAdvertisingId);
      localCdr.SetU8("ad_response_code", paramInt1);
      localCdr.SetString("call_token", String.valueOf(paramLong));
      localCdr.SetU32("ads_location", paramInt2);
      localCdr.SetU8("ad_service_ind", paramInt4);
      localCdr.SetU8("ad_type_call", paramInt3);
      localCdr.SetU8("ad_type_requested", paramInt5);
      localCdr.SetString("ad_unit_id", paramString2);
      localCdr.SetString("ads_sdk_version", paramString3);
      localCdr.SetU8("mediation", paramInt6);
      bool = this.mPhoneController.handleReportCdr(localCdr);
      localCdr.Destroy();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return bool;
  }

  // ERROR //
  public boolean handleReportAdsAfterCallAction(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 10
    //   3: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 21
    //   8: aload 21
    //   10: ldc_w 529
    //   13: lload_1
    //   14: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 21
    //   20: ldc_w 589
    //   23: iload_3
    //   24: i2l
    //   25: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   28: pop
    //   29: aload 21
    //   31: ldc 228
    //   33: lload 4
    //   35: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   38: pop
    //   39: aload 21
    //   41: ldc 171
    //   43: aload_0
    //   44: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   47: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: aload 21
    //   53: ldc 156
    //   55: iload 6
    //   57: i2l
    //   58: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   61: pop
    //   62: aload 21
    //   64: ldc 165
    //   66: iload 7
    //   68: i2l
    //   69: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   72: pop
    //   73: aload 21
    //   75: ldc_w 511
    //   78: aload 8
    //   80: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   83: pop
    //   84: aload 21
    //   86: ldc 177
    //   88: lconst_0
    //   89: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   92: pop
    //   93: aload 21
    //   95: ldc_w 387
    //   98: lconst_0
    //   99: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   102: pop
    //   103: aload 21
    //   105: ldc_w 565
    //   108: aload 9
    //   110: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   113: pop
    //   114: aload 21
    //   116: ldc 183
    //   118: iload 10
    //   120: i2l
    //   121: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   124: pop
    //   125: iload 12
    //   127: ifle +27 -> 154
    //   130: aload 21
    //   132: ldc_w 607
    //   135: iload 11
    //   137: i2l
    //   138: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   141: pop
    //   142: aload 21
    //   144: ldc_w 604
    //   147: iload 12
    //   149: i2l
    //   150: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   153: pop
    //   154: iload 13
    //   156: iconst_m1
    //   157: if_icmpeq +15 -> 172
    //   160: aload 21
    //   162: ldc_w 423
    //   165: iload 13
    //   167: i2l
    //   168: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   171: pop
    //   172: aload 21
    //   174: ldc 180
    //   176: iload 14
    //   178: i2l
    //   179: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   182: pop
    //   183: aload 21
    //   185: ldc_w 483
    //   188: aload 15
    //   190: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   193: pop
    //   194: aload 21
    //   196: ldc 192
    //   198: aload 16
    //   200: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   203: pop
    //   204: aload 21
    //   206: ldc 168
    //   208: aload 17
    //   210: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   213: pop
    //   214: aload_0
    //   215: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   218: aload 21
    //   220: invokeinterface 768 2 0
    //   225: istore 40
    //   227: iload 40
    //   229: istore 19
    //   231: aload 21
    //   233: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   236: iload 19
    //   238: ireturn
    //   239: astore 18
    //   241: iconst_0
    //   242: istore 19
    //   244: aload 18
    //   246: astore 20
    //   248: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   251: aload 20
    //   253: ldc_w 799
    //   256: invokeinterface 805 3 0
    //   261: iload 19
    //   263: ireturn
    //   264: astore 20
    //   266: goto -18 -> 248
    //
    // Exception table:
    //   from	to	target	type
    //   0	125	239	java/lang/Exception
    //   130	154	239	java/lang/Exception
    //   160	172	239	java/lang/Exception
    //   172	227	239	java/lang/Exception
    //   231	236	264	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportAdsAfterCallDisplay(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 13
    //   3: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 18
    //   8: aload 18
    //   10: ldc_w 529
    //   13: lload_1
    //   14: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 18
    //   20: ldc_w 589
    //   23: iload_3
    //   24: i2l
    //   25: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   28: pop
    //   29: aload 18
    //   31: ldc 228
    //   33: lload 4
    //   35: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   38: pop
    //   39: aload 18
    //   41: ldc 171
    //   43: aload_0
    //   44: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   47: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: aload 18
    //   53: ldc 165
    //   55: iload 6
    //   57: i2l
    //   58: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   61: pop
    //   62: aload 18
    //   64: ldc_w 511
    //   67: aload 7
    //   69: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   72: pop
    //   73: aload 18
    //   75: ldc 177
    //   77: lconst_0
    //   78: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   81: pop
    //   82: aload 18
    //   84: ldc_w 387
    //   87: lconst_0
    //   88: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   91: pop
    //   92: aload 18
    //   94: ldc_w 565
    //   97: aload 8
    //   99: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   102: pop
    //   103: aload 18
    //   105: ldc 183
    //   107: iload 9
    //   109: i2l
    //   110: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   113: pop
    //   114: aload 18
    //   116: ldc_w 303
    //   119: iload 10
    //   121: i2l
    //   122: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   125: pop
    //   126: aload 18
    //   128: ldc 180
    //   130: iload 11
    //   132: i2l
    //   133: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   136: pop
    //   137: aload 18
    //   139: ldc_w 483
    //   142: aload 12
    //   144: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   147: pop
    //   148: aload 18
    //   150: ldc 192
    //   152: aload 13
    //   154: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   157: pop
    //   158: aload 18
    //   160: ldc 168
    //   162: aload 14
    //   164: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   167: pop
    //   168: aload_0
    //   169: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   172: aload 18
    //   174: invokeinterface 768 2 0
    //   179: istore 34
    //   181: iload 34
    //   183: istore 16
    //   185: aload 18
    //   187: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   190: iload 16
    //   192: ireturn
    //   193: astore 15
    //   195: iconst_0
    //   196: istore 16
    //   198: aload 15
    //   200: astore 17
    //   202: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   205: aload 17
    //   207: ldc_w 809
    //   210: invokeinterface 805 3 0
    //   215: iload 16
    //   217: ireturn
    //   218: astore 17
    //   220: goto -18 -> 202
    //
    // Exception table:
    //   from	to	target	type
    //   0	181	193	java/lang/Exception
    //   185	190	218	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportAdsClick(long paramLong, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 10
    //   3: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 17
    //   8: aload 17
    //   10: ldc_w 529
    //   13: lload_1
    //   14: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 17
    //   20: ldc 171
    //   22: aload_0
    //   23: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   26: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   29: pop
    //   30: aload 17
    //   32: ldc 156
    //   34: iload_3
    //   35: i2l
    //   36: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   39: pop
    //   40: aload 17
    //   42: ldc 165
    //   44: iload 13
    //   46: i2l
    //   47: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   50: pop
    //   51: aload 17
    //   53: ldc_w 511
    //   56: aload 4
    //   58: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   61: pop
    //   62: aload 17
    //   64: ldc 177
    //   66: iload 5
    //   68: i2l
    //   69: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   72: pop
    //   73: aload 17
    //   75: ldc_w 387
    //   78: iload 6
    //   80: i2l
    //   81: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   84: pop
    //   85: aload 17
    //   87: ldc_w 565
    //   90: aload 7
    //   92: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   95: pop
    //   96: aload 17
    //   98: ldc 183
    //   100: iload 8
    //   102: i2l
    //   103: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   106: pop
    //   107: aload 17
    //   109: ldc 180
    //   111: iload 9
    //   113: i2l
    //   114: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   117: pop
    //   118: aload 17
    //   120: ldc_w 483
    //   123: aload 10
    //   125: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   128: pop
    //   129: aload 17
    //   131: ldc 192
    //   133: aload 11
    //   135: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   138: pop
    //   139: aload 17
    //   141: ldc 168
    //   143: aload 12
    //   145: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   148: pop
    //   149: aload_0
    //   150: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   153: aload 17
    //   155: invokeinterface 768 2 0
    //   160: istore 31
    //   162: iload 31
    //   164: istore 15
    //   166: aload 17
    //   168: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   171: iload 15
    //   173: ireturn
    //   174: astore 14
    //   176: iconst_0
    //   177: istore 15
    //   179: aload 14
    //   181: astore 16
    //   183: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   186: aload 16
    //   188: ldc_w 813
    //   191: invokeinterface 805 3 0
    //   196: iload 15
    //   198: ireturn
    //   199: astore 16
    //   201: goto -18 -> 183
    //
    // Exception table:
    //   from	to	target	type
    //   0	162	174	java/lang/Exception
    //   166	171	199	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportAdsDisplay(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, int paramInt6)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 13
    //   3: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 17
    //   8: aload 17
    //   10: ldc_w 529
    //   13: lload_1
    //   14: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 17
    //   20: ldc 171
    //   22: aload_0
    //   23: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   26: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   29: pop
    //   30: aload 17
    //   32: ldc 165
    //   34: iload 13
    //   36: i2l
    //   37: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   40: pop
    //   41: aload 17
    //   43: ldc_w 511
    //   46: aload_3
    //   47: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: aload 17
    //   53: ldc 177
    //   55: iload 4
    //   57: i2l
    //   58: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   61: pop
    //   62: aload 17
    //   64: ldc_w 387
    //   67: iload 5
    //   69: i2l
    //   70: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   73: pop
    //   74: aload 17
    //   76: ldc_w 565
    //   79: aload 6
    //   81: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   84: pop
    //   85: aload 17
    //   87: ldc 183
    //   89: iload 7
    //   91: i2l
    //   92: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   95: pop
    //   96: aload 17
    //   98: ldc_w 303
    //   101: iload 8
    //   103: i2l
    //   104: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   107: pop
    //   108: aload 17
    //   110: ldc 180
    //   112: iload 9
    //   114: i2l
    //   115: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   118: pop
    //   119: aload 17
    //   121: ldc_w 483
    //   124: aload 10
    //   126: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   129: pop
    //   130: aload 17
    //   132: ldc 192
    //   134: aload 11
    //   136: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   139: pop
    //   140: aload 17
    //   142: ldc 168
    //   144: aload 12
    //   146: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   149: pop
    //   150: aload_0
    //   151: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   154: aload 17
    //   156: invokeinterface 768 2 0
    //   161: istore 31
    //   163: iload 31
    //   165: istore 15
    //   167: aload 17
    //   169: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   172: iload 15
    //   174: ireturn
    //   175: astore 14
    //   177: iconst_0
    //   178: istore 15
    //   180: aload 14
    //   182: astore 16
    //   184: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   187: aload 16
    //   189: ldc_w 817
    //   192: invokeinterface 805 3 0
    //   197: iload 15
    //   199: ireturn
    //   200: astore 16
    //   202: goto -18 -> 184
    //
    // Exception table:
    //   from	to	target	type
    //   0	163	175	java/lang/Exception
    //   167	172	200	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportAnimatedGif(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 19
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 6
    //   7: aload 6
    //   9: ldc_w 342
    //   12: aload_1
    //   13: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   16: pop
    //   17: aload 6
    //   19: ldc_w 339
    //   22: aload_2
    //   23: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   31: aload 6
    //   33: invokeinterface 768 2 0
    //   38: istore 9
    //   40: iload 9
    //   42: istore 4
    //   44: aload 6
    //   46: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   49: iload 4
    //   51: ireturn
    //   52: astore_3
    //   53: iconst_0
    //   54: istore 4
    //   56: aload_3
    //   57: astore 5
    //   59: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   62: aload 5
    //   64: ldc_w 820
    //   67: invokeinterface 805 3 0
    //   72: iload 4
    //   74: ireturn
    //   75: astore 5
    //   77: goto -18 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   0	40	52	java/lang/Exception
    //   44	49	75	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportAppsApprovalPage(int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc 201
    //   11: iload_1
    //   12: i2l
    //   13: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 7
    //   19: ldc_w 306
    //   22: aload_2
    //   23: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   26: pop
    //   27: aload 7
    //   29: ldc 156
    //   31: iload_3
    //   32: i2l
    //   33: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   36: pop
    //   37: aload_0
    //   38: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   41: aload 7
    //   43: invokeinterface 768 2 0
    //   48: istore 11
    //   50: iload 11
    //   52: istore 5
    //   54: aload 7
    //   56: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   59: iload 5
    //   61: ireturn
    //   62: astore 4
    //   64: iconst_0
    //   65: istore 5
    //   67: aload 4
    //   69: astore 6
    //   71: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   74: aload 6
    //   76: ldc_w 824
    //   79: invokeinterface 805 3 0
    //   84: iload 5
    //   86: ireturn
    //   87: astore 6
    //   89: goto -18 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   0	50	62	java/lang/Exception
    //   54	59	87	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportBackup(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 10
    //   7: aload 10
    //   9: ldc 156
    //   11: iload_1
    //   12: i2l
    //   13: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 10
    //   19: ldc 207
    //   21: iload_2
    //   22: i2l
    //   23: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   26: pop
    //   27: aload 10
    //   29: ldc_w 315
    //   32: iload_3
    //   33: i2l
    //   34: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   37: pop
    //   38: aload 10
    //   40: ldc 150
    //   42: iload 4
    //   44: i2l
    //   45: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   48: pop
    //   49: aload 10
    //   51: ldc_w 261
    //   54: iload 5
    //   56: i2l
    //   57: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   60: pop
    //   61: aload 10
    //   63: ldc_w 496
    //   66: iload 6
    //   68: i2l
    //   69: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   72: pop
    //   73: aload_0
    //   74: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   77: aload 10
    //   79: invokeinterface 768 2 0
    //   84: istore 17
    //   86: iload 17
    //   88: istore 8
    //   90: aload 10
    //   92: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   95: iload 8
    //   97: ireturn
    //   98: astore 7
    //   100: iconst_0
    //   101: istore 8
    //   103: aload 7
    //   105: astore 9
    //   107: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   110: aload 9
    //   112: ldc_w 828
    //   115: invokeinterface 805 3 0
    //   120: iload 8
    //   122: ireturn
    //   123: astore 9
    //   125: goto -18 -> 107
    //
    // Exception table:
    //   from	to	target	type
    //   0	86	98	java/lang/Exception
    //   90	95	123	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportBlockedNumberStatistics(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aload 7
    //   2: invokestatic 836	com/viber/voip/util/cg:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore 15
    //   7: ldc 78
    //   9: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   12: astore 16
    //   14: aload 16
    //   16: ldc_w 411
    //   19: lload_1
    //   20: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   23: pop
    //   24: aload 16
    //   26: ldc_w 420
    //   29: lload_3
    //   30: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   33: pop
    //   34: aload 16
    //   36: ldc_w 447
    //   39: lload 5
    //   41: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   44: pop
    //   45: aload 16
    //   47: ldc 219
    //   49: aload 15
    //   51: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   54: pop
    //   55: aload 8
    //   57: invokestatic 841	com/viber/voip/util/cd:a	(Ljava/lang/String;)Z
    //   60: ifne +11 -> 71
    //   63: aload 8
    //   65: invokestatic 844	com/viber/voip/util/cd:c	(Ljava/lang/String;)Z
    //   68: ifeq +120 -> 188
    //   71: aload 16
    //   73: ldc 216
    //   75: aload 8
    //   77: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   80: pop
    //   81: aload 16
    //   83: ldc 213
    //   85: aload_0
    //   86: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   89: aload 15
    //   91: invokeinterface 848 2 0
    //   96: i2l
    //   97: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   100: pop
    //   101: iload 9
    //   103: ifeq +124 -> 227
    //   106: lconst_1
    //   107: lstore 23
    //   109: aload 16
    //   111: ldc_w 547
    //   114: lload 23
    //   116: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   119: pop
    //   120: aload 16
    //   122: ldc_w 330
    //   125: aload 10
    //   127: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: pop
    //   131: aload 16
    //   133: ldc_w 291
    //   136: aload 10
    //   138: invokestatic 854	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   141: invokevirtual 857	android/net/Uri:getHost	()Ljava/lang/String;
    //   144: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   150: pop
    //   151: aload 16
    //   153: ldc_w 402
    //   156: iload 11
    //   158: i2l
    //   159: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   162: pop
    //   163: aload_0
    //   164: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   167: aload 16
    //   169: invokeinterface 768 2 0
    //   174: istore 29
    //   176: iload 29
    //   178: istore 13
    //   180: aload 16
    //   182: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   185: iload 13
    //   187: ireturn
    //   188: aload 16
    //   190: ldc 216
    //   192: ldc_w 864
    //   195: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   198: pop
    //   199: goto -118 -> 81
    //   202: astore 12
    //   204: iconst_0
    //   205: istore 13
    //   207: aload 12
    //   209: astore 14
    //   211: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   214: aload 14
    //   216: ldc_w 866
    //   219: invokeinterface 805 3 0
    //   224: iload 13
    //   226: ireturn
    //   227: lconst_0
    //   228: lstore 23
    //   230: goto -121 -> 109
    //   233: astore 14
    //   235: goto -24 -> 211
    //
    // Exception table:
    //   from	to	target	type
    //   0	71	202	java/lang/Exception
    //   71	81	202	java/lang/Exception
    //   81	101	202	java/lang/Exception
    //   109	176	202	java/lang/Exception
    //   188	199	202	java/lang/Exception
    //   180	185	233	java/lang/Exception
  }

  public boolean handleReportBroadcastSendMessage(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    boolean bool = false;
    try
    {
      Cdr localCdr = createGeneralCdr("broadcast");
      localCdr.SetU32("media_type", paramLong1);
      localCdr.SetU32("message_flags", paramLong2);
      localCdr.SetU32("number_of_recipients", paramLong3);
      localCdr.SetU32("sequence", paramLong4);
      bool = this.mPhoneController.handleReportCdr(localCdr);
      localCdr.Destroy();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return bool;
  }

  // ERROR //
  public boolean handleReportClickOnRichMessage(int paramInt1, String paramString1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2)
  {
    // Byte code:
    //   0: ldc 31
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 13
    //   7: aload 13
    //   9: ldc_w 276
    //   12: iload_1
    //   13: i2l
    //   14: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 13
    //   20: ldc 237
    //   22: aload_2
    //   23: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   26: pop
    //   27: aload 13
    //   29: ldc_w 420
    //   32: lload_3
    //   33: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   36: pop
    //   37: aload 13
    //   39: ldc_w 372
    //   42: iload 5
    //   44: i2l
    //   45: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   48: pop
    //   49: iload 6
    //   51: ifeq +14 -> 65
    //   54: aload 13
    //   56: ldc 153
    //   58: iload 6
    //   60: i2l
    //   61: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   64: pop
    //   65: aload 13
    //   67: ldc_w 508
    //   70: iload 7
    //   72: i2l
    //   73: invokevirtual 873	com/viber/jni/cdr/Cdr:SetU16	(Ljava/lang/String;J)Z
    //   76: pop
    //   77: aload 13
    //   79: ldc_w 526
    //   82: iload 8
    //   84: i2l
    //   85: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   88: pop
    //   89: aload 13
    //   91: ldc_w 486
    //   94: aload 9
    //   96: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   99: pop
    //   100: aload_0
    //   101: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   104: aload 13
    //   106: invokeinterface 768 2 0
    //   111: istore 22
    //   113: iload 22
    //   115: istore 11
    //   117: aload 13
    //   119: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   122: iload 11
    //   124: ireturn
    //   125: astore 10
    //   127: iconst_0
    //   128: istore 11
    //   130: aload 10
    //   132: astore 12
    //   134: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   137: aload 12
    //   139: ldc_w 875
    //   142: invokeinterface 805 3 0
    //   147: iload 11
    //   149: ireturn
    //   150: astore 12
    //   152: goto -18 -> 134
    //
    // Exception table:
    //   from	to	target	type
    //   0	49	125	java/lang/Exception
    //   54	65	125	java/lang/Exception
    //   65	113	125	java/lang/Exception
    //   117	122	150	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportDiscoverScreenSession(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc_w 535
    //   12: lload_1
    //   13: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 7
    //   19: ldc_w 532
    //   22: iload_3
    //   23: i2l
    //   24: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   27: pop
    //   28: aload_0
    //   29: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   32: aload 7
    //   34: invokeinterface 768 2 0
    //   39: istore 10
    //   41: iload 10
    //   43: istore 5
    //   45: aload 7
    //   47: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   50: iload 5
    //   52: ireturn
    //   53: astore 4
    //   55: iconst_0
    //   56: istore 5
    //   58: aload 4
    //   60: astore 6
    //   62: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   65: aload 6
    //   67: ldc_w 879
    //   70: invokeinterface 805 3 0
    //   75: iload 5
    //   77: ireturn
    //   78: astore 6
    //   80: goto -18 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   0	41	53	java/lang/Exception
    //   45	50	78	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportFacebookStatistics(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc_w 309
    //   12: aload_1
    //   13: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   16: pop
    //   17: aload 7
    //   19: ldc_w 312
    //   22: aload_2
    //   23: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   26: pop
    //   27: aload 7
    //   29: ldc_w 544
    //   32: iload_3
    //   33: i2l
    //   34: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   37: pop
    //   38: aload_0
    //   39: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   42: aload 7
    //   44: invokeinterface 768 2 0
    //   49: istore 11
    //   51: iload 11
    //   53: istore 5
    //   55: aload 7
    //   57: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   60: iload 5
    //   62: ireturn
    //   63: astore 4
    //   65: iconst_0
    //   66: istore 5
    //   68: aload 4
    //   70: astore 6
    //   72: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   75: aload 6
    //   77: ldc_w 883
    //   80: invokeinterface 805 3 0
    //   85: iload 5
    //   87: ireturn
    //   88: astore 6
    //   90: goto -18 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   0	51	63	java/lang/Exception
    //   55	60	88	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportFavorites(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc_w 441
    //   12: iload_1
    //   13: i2l
    //   14: invokevirtual 873	com/viber/jni/cdr/Cdr:SetU16	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 7
    //   20: ldc_w 435
    //   23: iload_2
    //   24: i2l
    //   25: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   28: pop
    //   29: aload 7
    //   31: ldc_w 405
    //   34: iload_3
    //   35: i2l
    //   36: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   39: pop
    //   40: aload_0
    //   41: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   44: aload 7
    //   46: invokeinterface 768 2 0
    //   51: istore 11
    //   53: iload 11
    //   55: istore 5
    //   57: aload 7
    //   59: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   62: iload 5
    //   64: ireturn
    //   65: astore 4
    //   67: iconst_0
    //   68: istore 5
    //   70: aload 4
    //   72: astore 6
    //   74: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   77: aload 6
    //   79: ldc_w 887
    //   82: invokeinterface 805 3 0
    //   87: iload 5
    //   89: ireturn
    //   90: astore 6
    //   92: goto -18 -> 74
    //
    // Exception table:
    //   from	to	target	type
    //   0	53	65	java/lang/Exception
    //   57	62	90	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportGameInvitationClicked(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 8
    //   7: aload 8
    //   9: ldc_w 589
    //   12: iload_1
    //   13: i2l
    //   14: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 8
    //   20: ldc 156
    //   22: iload_3
    //   23: i2l
    //   24: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   27: pop
    //   28: aload 8
    //   30: ldc 201
    //   32: iload_2
    //   33: i2l
    //   34: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   37: pop
    //   38: aload 8
    //   40: ldc_w 333
    //   43: aload 4
    //   45: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   48: pop
    //   49: aload_0
    //   50: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   53: aload 8
    //   55: invokeinterface 768 2 0
    //   60: istore 13
    //   62: iload 13
    //   64: istore 6
    //   66: aload 8
    //   68: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   71: iload 6
    //   73: ireturn
    //   74: astore 5
    //   76: iconst_0
    //   77: istore 6
    //   79: aload 5
    //   81: astore 7
    //   83: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   86: aload 7
    //   88: ldc_w 891
    //   91: invokeinterface 805 3 0
    //   96: iload 6
    //   98: ireturn
    //   99: astore 7
    //   101: goto -18 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   0	62	74	java/lang/Exception
    //   66	71	99	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportGameInvitationDisplayed(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 52
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc_w 589
    //   12: iload_1
    //   13: i2l
    //   14: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 7
    //   20: ldc 201
    //   22: iload_2
    //   23: i2l
    //   24: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   27: pop
    //   28: aload 7
    //   30: ldc_w 333
    //   33: aload_3
    //   34: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   37: pop
    //   38: aload_0
    //   39: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   42: aload 7
    //   44: invokeinterface 768 2 0
    //   49: istore 11
    //   51: iload 11
    //   53: istore 5
    //   55: aload 7
    //   57: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   60: iload 5
    //   62: ireturn
    //   63: astore 4
    //   65: iconst_0
    //   66: istore 5
    //   68: aload 4
    //   70: astore 6
    //   72: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   75: aload 6
    //   77: ldc_w 895
    //   80: invokeinterface 805 3 0
    //   85: iload 5
    //   87: ireturn
    //   88: astore 6
    //   90: goto -18 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   0	51	63	java/lang/Exception
    //   55	60	88	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportGameRedirect(int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: ldc 55
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc 171
    //   11: aload_0
    //   12: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   15: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   18: pop
    //   19: aload 7
    //   21: ldc 201
    //   23: iload_1
    //   24: i2l
    //   25: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   28: pop
    //   29: aload 7
    //   31: ldc_w 453
    //   34: aload_2
    //   35: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   38: pop
    //   39: aload 7
    //   41: ldc_w 493
    //   44: iload_3
    //   45: i2l
    //   46: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   49: pop
    //   50: aload_0
    //   51: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   54: aload 7
    //   56: invokeinterface 768 2 0
    //   61: istore 12
    //   63: iload 12
    //   65: istore 5
    //   67: aload 7
    //   69: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   72: iload 5
    //   74: ireturn
    //   75: astore 4
    //   77: iconst_0
    //   78: istore 5
    //   80: aload 4
    //   82: astore 6
    //   84: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   87: aload 6
    //   89: ldc_w 898
    //   92: invokeinterface 805 3 0
    //   97: iload 5
    //   99: ireturn
    //   100: astore 6
    //   102: goto -18 -> 84
    //
    // Exception table:
    //   from	to	target	type
    //   0	63	75	java/lang/Exception
    //   67	72	100	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportInstantKeyboardOpen(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 9
    //   7: iload_1
    //   8: ifeq +14 -> 22
    //   11: aload 9
    //   13: ldc_w 348
    //   16: iload_1
    //   17: i2l
    //   18: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   21: pop
    //   22: aload 9
    //   24: ldc_w 270
    //   27: aload_2
    //   28: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   31: pop
    //   32: aload 9
    //   34: ldc_w 273
    //   37: iload_3
    //   38: i2l
    //   39: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   42: pop
    //   43: aload 9
    //   45: ldc_w 354
    //   48: iload 4
    //   50: i2l
    //   51: invokevirtual 873	com/viber/jni/cdr/Cdr:SetU16	(Ljava/lang/String;J)Z
    //   54: pop
    //   55: aload 9
    //   57: ldc_w 471
    //   60: aload 5
    //   62: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   65: pop
    //   66: aload_0
    //   67: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   70: aload 9
    //   72: invokeinterface 768 2 0
    //   77: istore 15
    //   79: iload 15
    //   81: istore 7
    //   83: aload 9
    //   85: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   88: iload 7
    //   90: ireturn
    //   91: astore 6
    //   93: iconst_0
    //   94: istore 7
    //   96: aload 6
    //   98: astore 8
    //   100: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   103: aload 8
    //   105: ldc_w 902
    //   108: invokeinterface 805 3 0
    //   113: iload 7
    //   115: ireturn
    //   116: astore 8
    //   118: goto -18 -> 100
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	91	java/lang/Exception
    //   11	22	91	java/lang/Exception
    //   22	79	91	java/lang/Exception
    //   83	88	116	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportMakeMobileCall(int paramInt1, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 8
    //   7: aload 8
    //   9: ldc 156
    //   11: iload_2
    //   12: i2l
    //   13: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 8
    //   19: ldc_w 601
    //   22: iload_1
    //   23: i2l
    //   24: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   27: pop
    //   28: aload 8
    //   30: ldc 228
    //   32: lload_3
    //   33: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   36: pop
    //   37: aload_0
    //   38: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   41: aload 8
    //   43: invokeinterface 768 2 0
    //   48: istore 12
    //   50: iload 12
    //   52: istore 6
    //   54: aload 8
    //   56: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   59: iload 6
    //   61: ireturn
    //   62: astore 5
    //   64: iconst_0
    //   65: istore 6
    //   67: aload 5
    //   69: astore 7
    //   71: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   74: aload 7
    //   76: ldc_w 906
    //   79: invokeinterface 805 3 0
    //   84: iload 6
    //   86: ireturn
    //   87: astore 7
    //   89: goto -18 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   0	50	62	java/lang/Exception
    //   54	59	87	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportMediaScreenSend(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc 72
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 9
    //   7: aload 9
    //   9: ldc_w 402
    //   12: iload_1
    //   13: i2l
    //   14: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 9
    //   20: ldc_w 465
    //   23: aload_2
    //   24: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   27: pop
    //   28: aload 9
    //   30: ldc_w 620
    //   33: iload_3
    //   34: i2l
    //   35: invokevirtual 873	com/viber/jni/cdr/Cdr:SetU16	(Ljava/lang/String;J)Z
    //   38: pop
    //   39: aload 9
    //   41: ldc_w 438
    //   44: iload 4
    //   46: i2l
    //   47: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   50: pop
    //   51: aload 9
    //   53: ldc_w 574
    //   56: iload 5
    //   58: i2l
    //   59: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   62: pop
    //   63: aload_0
    //   64: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   67: aload 9
    //   69: invokeinterface 768 2 0
    //   74: istore 15
    //   76: iload 15
    //   78: istore 7
    //   80: aload 9
    //   82: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   85: iload 7
    //   87: ireturn
    //   88: astore 6
    //   90: iconst_0
    //   91: istore 7
    //   93: aload 6
    //   95: astore 8
    //   97: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   100: aload 8
    //   102: ldc_w 910
    //   105: invokeinterface 805 3 0
    //   110: iload 7
    //   112: ireturn
    //   113: astore 8
    //   115: goto -18 -> 97
    //
    // Exception table:
    //   from	to	target	type
    //   0	76	88	java/lang/Exception
    //   80	85	113	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPA1On1MessageBotReplied(String paramString1, String paramString2, String paramString3, String paramString4, com.viber.jni.LocationInfo paramLocationInfo, String paramString5, String paramString6, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 14
    //   7: aload 14
    //   9: ldc_w 486
    //   12: aload_1
    //   13: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   16: pop
    //   17: aload 14
    //   19: ldc 231
    //   21: aload_2
    //   22: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   28: pop
    //   29: aload 14
    //   31: ldc_w 559
    //   34: aload_3
    //   35: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   41: pop
    //   42: aload 14
    //   44: ldc_w 279
    //   47: aload 4
    //   49: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   52: pop
    //   53: aload 14
    //   55: ldc_w 396
    //   58: aload 5
    //   60: invokevirtual 918	com/viber/jni/LocationInfo:getLongitude	()D
    //   63: iconst_0
    //   64: invokestatic 924	android/location/Location:convert	(DI)Ljava/lang/String;
    //   67: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   70: pop
    //   71: aload 14
    //   73: ldc_w 393
    //   76: aload 5
    //   78: invokevirtual 927	com/viber/jni/LocationInfo:getLatitude	()D
    //   81: iconst_0
    //   82: invokestatic 924	android/location/Location:convert	(DI)Ljava/lang/String;
    //   85: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   88: pop
    //   89: aload 14
    //   91: ldc_w 408
    //   94: aload 6
    //   96: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   99: pop
    //   100: aload 14
    //   102: ldc_w 324
    //   105: aload 7
    //   107: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   110: pop
    //   111: aload 14
    //   113: ldc_w 321
    //   116: lload 8
    //   118: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   121: pop
    //   122: aload 14
    //   124: ldc_w 288
    //   127: iload 10
    //   129: i2l
    //   130: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   138: aload 14
    //   140: invokeinterface 768 2 0
    //   145: istore 25
    //   147: iload 25
    //   149: istore 12
    //   151: aload 14
    //   153: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   156: iload 12
    //   158: ireturn
    //   159: astore 11
    //   161: iconst_0
    //   162: istore 12
    //   164: aload 11
    //   166: astore 13
    //   168: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   171: aload 13
    //   173: ldc_w 929
    //   176: invokeinterface 805 3 0
    //   181: iload 12
    //   183: ireturn
    //   184: astore 13
    //   186: goto -18 -> 168
    //
    // Exception table:
    //   from	to	target	type
    //   0	147	159	java/lang/Exception
    //   151	156	184	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPACreationStartAndLeaveProcess(long paramLong1, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: ldc 84
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 9
    //   7: aload 9
    //   9: ldc_w 550
    //   12: lload_1
    //   13: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 9
    //   19: ldc_w 378
    //   22: lload_3
    //   23: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   26: pop
    //   27: aload 9
    //   29: ldc_w 468
    //   32: iload 5
    //   34: i2l
    //   35: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   38: pop
    //   39: aload 9
    //   41: ldc_w 318
    //   44: lconst_0
    //   45: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   48: pop
    //   49: aload_0
    //   50: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   53: aload 9
    //   55: invokeinterface 768 2 0
    //   60: istore 14
    //   62: iload 14
    //   64: istore 7
    //   66: aload 9
    //   68: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   71: iload 7
    //   73: ireturn
    //   74: astore 6
    //   76: iconst_0
    //   77: istore 7
    //   79: aload 6
    //   81: astore 8
    //   83: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   86: aload 8
    //   88: ldc_w 933
    //   91: invokeinterface 805 3 0
    //   96: iload 7
    //   98: ireturn
    //   99: astore 8
    //   101: goto -18 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   0	62	74	java/lang/Exception
    //   66	71	99	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPACreationStartAndLeaveProcess(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.viber.jni.LocationInfo paramLocationInfo, String paramString6, String paramString7, String paramString8, boolean paramBoolean2, int paramInt2)
  {
    // Byte code:
    //   0: ldc 84
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 21
    //   7: aload 21
    //   9: ldc_w 550
    //   12: lload_1
    //   13: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 21
    //   19: ldc_w 378
    //   22: lload_3
    //   23: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   26: pop
    //   27: aload 21
    //   29: ldc_w 468
    //   32: iload 5
    //   34: i2l
    //   35: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   38: pop
    //   39: iload 6
    //   41: ifeq +220 -> 261
    //   44: lconst_1
    //   45: lstore 25
    //   47: aload 21
    //   49: ldc_w 318
    //   52: lload 25
    //   54: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   57: pop
    //   58: aload 21
    //   60: ldc_w 426
    //   63: aload 7
    //   65: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   71: pop
    //   72: aload 21
    //   74: ldc 234
    //   76: aload 8
    //   78: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   81: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   84: pop
    //   85: aload 21
    //   87: ldc_w 562
    //   90: aload 9
    //   92: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   98: pop
    //   99: aload 21
    //   101: ldc 141
    //   103: aload 10
    //   105: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   111: pop
    //   112: aload 21
    //   114: ldc_w 390
    //   117: aload 11
    //   119: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   125: pop
    //   126: aload 12
    //   128: ifnull +37 -> 165
    //   131: aload 21
    //   133: ldc_w 396
    //   136: aload 12
    //   138: invokevirtual 918	com/viber/jni/LocationInfo:getLongitude	()D
    //   141: invokestatic 939	java/lang/Double:toString	(D)Ljava/lang/String;
    //   144: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   147: pop
    //   148: aload 21
    //   150: ldc_w 393
    //   153: aload 12
    //   155: invokevirtual 927	com/viber/jni/LocationInfo:getLatitude	()D
    //   158: invokestatic 939	java/lang/Double:toString	(D)Ljava/lang/String;
    //   161: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   164: pop
    //   165: aload 21
    //   167: ldc_w 610
    //   170: aload 13
    //   172: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   178: pop
    //   179: aload 21
    //   181: ldc_w 294
    //   184: aload 14
    //   186: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   192: pop
    //   193: aload 21
    //   195: ldc_w 351
    //   198: aload 15
    //   200: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   206: pop
    //   207: iload 16
    //   209: ifeq +58 -> 267
    //   212: lconst_1
    //   213: lstore 38
    //   215: aload 21
    //   217: ldc 195
    //   219: lload 38
    //   221: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   224: pop
    //   225: aload 21
    //   227: ldc 243
    //   229: iload 17
    //   231: i2l
    //   232: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   235: pop
    //   236: aload_0
    //   237: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   240: aload 21
    //   242: invokeinterface 768 2 0
    //   247: istore 42
    //   249: iload 42
    //   251: istore 19
    //   253: aload 21
    //   255: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   258: iload 19
    //   260: ireturn
    //   261: lconst_0
    //   262: lstore 25
    //   264: goto -217 -> 47
    //   267: lconst_0
    //   268: lstore 38
    //   270: goto -55 -> 215
    //   273: astore 18
    //   275: iconst_0
    //   276: istore 19
    //   278: aload 18
    //   280: astore 20
    //   282: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   285: aload 20
    //   287: ldc_w 941
    //   290: invokeinterface 805 3 0
    //   295: iload 19
    //   297: ireturn
    //   298: astore 20
    //   300: goto -18 -> 282
    //
    // Exception table:
    //   from	to	target	type
    //   0	39	273	java/lang/Exception
    //   47	126	273	java/lang/Exception
    //   131	165	273	java/lang/Exception
    //   165	207	273	java/lang/Exception
    //   215	249	273	java/lang/Exception
    //   253	258	298	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPAEntering1On1Chat(String paramString1, String paramString2, String paramString3, String paramString4, com.viber.jni.LocationInfo paramLocationInfo, long paramLong)
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 11
    //   7: aload 11
    //   9: ldc_w 486
    //   12: aload_1
    //   13: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   16: pop
    //   17: aload 11
    //   19: ldc 231
    //   21: aload_2
    //   22: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   28: pop
    //   29: aload 11
    //   31: ldc_w 559
    //   34: aload_3
    //   35: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   41: pop
    //   42: aload 11
    //   44: ldc_w 279
    //   47: aload 4
    //   49: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   55: pop
    //   56: aload 11
    //   58: ldc_w 396
    //   61: aload 5
    //   63: invokevirtual 918	com/viber/jni/LocationInfo:getLongitude	()D
    //   66: iconst_0
    //   67: invokestatic 924	android/location/Location:convert	(DI)Ljava/lang/String;
    //   70: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   73: pop
    //   74: aload 11
    //   76: ldc_w 393
    //   79: aload 5
    //   81: invokevirtual 927	com/viber/jni/LocationInfo:getLatitude	()D
    //   84: iconst_0
    //   85: invokestatic 924	android/location/Location:convert	(DI)Ljava/lang/String;
    //   88: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   91: pop
    //   92: aload 11
    //   94: ldc_w 535
    //   97: lload 6
    //   99: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   102: pop
    //   103: aload_0
    //   104: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   107: aload 11
    //   109: invokeinterface 768 2 0
    //   114: istore 19
    //   116: iload 19
    //   118: istore 9
    //   120: aload 11
    //   122: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   125: iload 9
    //   127: ireturn
    //   128: astore 8
    //   130: iconst_0
    //   131: istore 9
    //   133: aload 8
    //   135: astore 10
    //   137: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   140: aload 10
    //   142: ldc_w 945
    //   145: invokeinterface 805 3 0
    //   150: iload 9
    //   152: ireturn
    //   153: astore 10
    //   155: goto -18 -> 137
    //
    // Exception table:
    //   from	to	target	type
    //   0	116	128	java/lang/Exception
    //   120	125	153	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPAImpressions(String paramString1, String paramString2, long paramLong1, int paramInt1, String paramString3, boolean paramBoolean, int paramInt2, long paramLong2, long paramLong3, int paramInt3)
  {
    // Byte code:
    //   0: lload 11
    //   2: lconst_0
    //   3: lcmp
    //   4: ifne +15 -> 19
    //   7: aload_0
    //   8: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   11: invokeinterface 950 1 0
    //   16: i2l
    //   17: lstore 11
    //   19: ldc 90
    //   21: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   24: astore 17
    //   26: aload 17
    //   28: ldc_w 486
    //   31: aload_1
    //   32: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   35: pop
    //   36: aload 17
    //   38: ldc_w 279
    //   41: aload_2
    //   42: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   45: pop
    //   46: aload 17
    //   48: ldc_w 535
    //   51: lload_3
    //   52: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   55: pop
    //   56: aload 17
    //   58: ldc_w 595
    //   61: aload 6
    //   63: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   66: pop
    //   67: aload 6
    //   69: ifnull +135 -> 204
    //   72: aload 6
    //   74: invokestatic 854	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   77: invokevirtual 857	android/net/Uri:getHost	()Ljava/lang/String;
    //   80: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 22
    //   85: aload 17
    //   87: ldc_w 291
    //   90: aload 22
    //   92: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   95: pop
    //   96: aload 17
    //   98: ldc_w 402
    //   101: iload 5
    //   103: i2l
    //   104: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   107: pop
    //   108: iload 7
    //   110: ifeq +100 -> 210
    //   113: lconst_1
    //   114: lstore 25
    //   116: aload 17
    //   118: ldc_w 336
    //   121: lload 25
    //   123: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   126: pop
    //   127: iload 8
    //   129: iconst_m1
    //   130: if_icmple +15 -> 145
    //   133: aload 17
    //   135: ldc_w 556
    //   138: iload 8
    //   140: i2l
    //   141: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   144: pop
    //   145: aload 17
    //   147: ldc_w 420
    //   150: lload 9
    //   152: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   155: pop
    //   156: aload 17
    //   158: ldc_w 417
    //   161: lload 11
    //   163: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   166: pop
    //   167: aload 17
    //   169: ldc_w 598
    //   172: iload 13
    //   174: i2l
    //   175: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   178: pop
    //   179: aload_0
    //   180: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   183: aload 17
    //   185: invokeinterface 768 2 0
    //   190: istore 32
    //   192: iload 32
    //   194: istore 15
    //   196: aload 17
    //   198: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   201: iload 15
    //   203: ireturn
    //   204: aconst_null
    //   205: astore 22
    //   207: goto -122 -> 85
    //   210: lconst_0
    //   211: lstore 25
    //   213: goto -97 -> 116
    //   216: astore 14
    //   218: iconst_0
    //   219: istore 15
    //   221: aload 14
    //   223: astore 16
    //   225: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   228: aload 16
    //   230: ldc_w 952
    //   233: invokeinterface 805 3 0
    //   238: iload 15
    //   240: ireturn
    //   241: astore 16
    //   243: goto -18 -> 225
    //
    // Exception table:
    //   from	to	target	type
    //   19	67	216	java/lang/Exception
    //   72	85	216	java/lang/Exception
    //   85	108	216	java/lang/Exception
    //   116	127	216	java/lang/Exception
    //   133	145	216	java/lang/Exception
    //   145	192	216	java/lang/Exception
    //   196	201	241	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPAInfoScreenDisplay(String paramString1, String paramString2, String paramString3, String paramString4, com.viber.jni.LocationInfo paramLocationInfo, long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 13
    //   7: aload 13
    //   9: ldc_w 486
    //   12: aload_1
    //   13: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   16: pop
    //   17: aload 13
    //   19: ldc 231
    //   21: aload_2
    //   22: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   25: pop
    //   26: aload 13
    //   28: ldc_w 559
    //   31: aload_3
    //   32: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   35: pop
    //   36: aload 13
    //   38: ldc_w 279
    //   41: aload 4
    //   43: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   46: pop
    //   47: aload 5
    //   49: ifnull +37 -> 86
    //   52: aload 13
    //   54: ldc_w 396
    //   57: aload 5
    //   59: invokevirtual 918	com/viber/jni/LocationInfo:getLongitude	()D
    //   62: invokestatic 939	java/lang/Double:toString	(D)Ljava/lang/String;
    //   65: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   68: pop
    //   69: aload 13
    //   71: ldc_w 393
    //   74: aload 5
    //   76: invokevirtual 927	com/viber/jni/LocationInfo:getLatitude	()D
    //   79: invokestatic 939	java/lang/Double:toString	(D)Ljava/lang/String;
    //   82: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   85: pop
    //   86: aload 13
    //   88: ldc_w 535
    //   91: lload 6
    //   93: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   96: pop
    //   97: aload 13
    //   99: ldc_w 532
    //   102: iload 8
    //   104: i2l
    //   105: invokevirtual 873	com/viber/jni/cdr/Cdr:SetU16	(Ljava/lang/String;J)Z
    //   108: pop
    //   109: aload 13
    //   111: ldc_w 598
    //   114: iload 9
    //   116: i2l
    //   117: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   120: pop
    //   121: aload_0
    //   122: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   125: aload 13
    //   127: invokeinterface 768 2 0
    //   132: istore 23
    //   134: iload 23
    //   136: istore 11
    //   138: aload 13
    //   140: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   143: iload 11
    //   145: ireturn
    //   146: astore 10
    //   148: iconst_0
    //   149: istore 11
    //   151: aload 10
    //   153: astore 12
    //   155: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   158: aload 12
    //   160: ldc_w 956
    //   163: invokeinterface 805 3 0
    //   168: iload 11
    //   170: ireturn
    //   171: astore 12
    //   173: goto -18 -> 155
    //
    // Exception table:
    //   from	to	target	type
    //   0	47	146	java/lang/Exception
    //   52	86	146	java/lang/Exception
    //   86	134	146	java/lang/Exception
    //   138	143	171	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPAInteractions(String paramString1, String paramString2, String paramString3, String paramString4, com.viber.jni.LocationInfo paramLocationInfo, long paramLong1, int paramInt1, String paramString5, String paramString6, boolean paramBoolean, int paramInt2, long paramLong2, long paramLong3, int paramInt3)
  {
    // Byte code:
    //   0: lload 15
    //   2: lconst_0
    //   3: lcmp
    //   4: ifne +15 -> 19
    //   7: aload_0
    //   8: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   11: invokeinterface 950 1 0
    //   16: i2l
    //   17: lstore 15
    //   19: ldc 96
    //   21: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   24: astore 21
    //   26: aload 21
    //   28: ldc_w 486
    //   31: aload_1
    //   32: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   35: pop
    //   36: aload 21
    //   38: ldc 231
    //   40: aload_2
    //   41: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   44: pop
    //   45: aload 21
    //   47: ldc_w 559
    //   50: aload_3
    //   51: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   54: pop
    //   55: aload 21
    //   57: ldc_w 279
    //   60: aload 4
    //   62: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   65: pop
    //   66: aload 5
    //   68: ifnull +37 -> 105
    //   71: aload 21
    //   73: ldc_w 396
    //   76: aload 5
    //   78: invokevirtual 918	com/viber/jni/LocationInfo:getLongitude	()D
    //   81: invokestatic 939	java/lang/Double:toString	(D)Ljava/lang/String;
    //   84: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   87: pop
    //   88: aload 21
    //   90: ldc_w 393
    //   93: aload 5
    //   95: invokevirtual 927	com/viber/jni/LocationInfo:getLatitude	()D
    //   98: invokestatic 939	java/lang/Double:toString	(D)Ljava/lang/String;
    //   101: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   104: pop
    //   105: aload 21
    //   107: ldc_w 535
    //   110: lload 6
    //   112: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   115: pop
    //   116: aload 21
    //   118: ldc_w 595
    //   121: aload 9
    //   123: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   126: pop
    //   127: aload 9
    //   129: ifnull +146 -> 275
    //   132: aload 9
    //   134: invokestatic 854	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   137: invokevirtual 857	android/net/Uri:getHost	()Ljava/lang/String;
    //   140: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 30
    //   145: aload 21
    //   147: ldc_w 291
    //   150: aload 30
    //   152: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   155: pop
    //   156: aload 21
    //   158: ldc_w 402
    //   161: iload 8
    //   163: i2l
    //   164: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   167: pop
    //   168: aload 21
    //   170: ldc_w 538
    //   173: aload 10
    //   175: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   178: pop
    //   179: iload 11
    //   181: ifeq +100 -> 281
    //   184: lconst_1
    //   185: lstore 34
    //   187: aload 21
    //   189: ldc_w 336
    //   192: lload 34
    //   194: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   197: pop
    //   198: iload 12
    //   200: iconst_m1
    //   201: if_icmple +15 -> 216
    //   204: aload 21
    //   206: ldc_w 556
    //   209: iload 12
    //   211: i2l
    //   212: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   215: pop
    //   216: aload 21
    //   218: ldc_w 420
    //   221: lload 13
    //   223: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   226: pop
    //   227: aload 21
    //   229: ldc_w 417
    //   232: lload 15
    //   234: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   237: pop
    //   238: aload 21
    //   240: ldc_w 598
    //   243: iload 17
    //   245: i2l
    //   246: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   249: pop
    //   250: aload_0
    //   251: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   254: aload 21
    //   256: invokeinterface 768 2 0
    //   261: istore 41
    //   263: iload 41
    //   265: istore 19
    //   267: aload 21
    //   269: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   272: iload 19
    //   274: ireturn
    //   275: aconst_null
    //   276: astore 30
    //   278: goto -133 -> 145
    //   281: lconst_0
    //   282: lstore 34
    //   284: goto -97 -> 187
    //   287: astore 18
    //   289: iconst_0
    //   290: istore 19
    //   292: aload 18
    //   294: astore 20
    //   296: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   299: aload 20
    //   301: ldc_w 960
    //   304: invokeinterface 805 3 0
    //   309: iload 19
    //   311: ireturn
    //   312: astore 20
    //   314: goto -18 -> 296
    //
    // Exception table:
    //   from	to	target	type
    //   19	66	287	java/lang/Exception
    //   71	105	287	java/lang/Exception
    //   105	127	287	java/lang/Exception
    //   132	145	287	java/lang/Exception
    //   145	179	287	java/lang/Exception
    //   187	198	287	java/lang/Exception
    //   204	216	287	java/lang/Exception
    //   216	263	287	java/lang/Exception
    //   267	272	312	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPATappingOnWebSite(String paramString1, String paramString2, String paramString3, String paramString4, com.viber.jni.LocationInfo paramLocationInfo, long paramLong, String paramString5, int paramInt)
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 13
    //   7: aload 13
    //   9: ldc_w 486
    //   12: aload_1
    //   13: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   16: pop
    //   17: aload 13
    //   19: ldc 231
    //   21: aload_2
    //   22: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   25: pop
    //   26: aload 13
    //   28: ldc_w 559
    //   31: aload_3
    //   32: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   35: pop
    //   36: aload 13
    //   38: ldc_w 279
    //   41: aload 4
    //   43: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   46: pop
    //   47: aload 5
    //   49: ifnull +37 -> 86
    //   52: aload 13
    //   54: ldc_w 396
    //   57: aload 5
    //   59: invokevirtual 918	com/viber/jni/LocationInfo:getLongitude	()D
    //   62: invokestatic 939	java/lang/Double:toString	(D)Ljava/lang/String;
    //   65: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   68: pop
    //   69: aload 13
    //   71: ldc_w 393
    //   74: aload 5
    //   76: invokevirtual 927	com/viber/jni/LocationInfo:getLatitude	()D
    //   79: invokestatic 939	java/lang/Double:toString	(D)Ljava/lang/String;
    //   82: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   85: pop
    //   86: aload 13
    //   88: ldc_w 535
    //   91: lload 6
    //   93: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   96: pop
    //   97: aload 13
    //   99: ldc_w 595
    //   102: aload 8
    //   104: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   107: pop
    //   108: aload 8
    //   110: ifnull +70 -> 180
    //   113: aload 8
    //   115: invokestatic 854	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   118: invokevirtual 857	android/net/Uri:getHost	()Ljava/lang/String;
    //   121: invokestatic 862	com/viber/voip/util/da:h	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 22
    //   126: aload 13
    //   128: ldc_w 291
    //   131: aload 22
    //   133: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   136: pop
    //   137: iload 9
    //   139: iconst_m1
    //   140: if_icmpeq +15 -> 155
    //   143: aload 13
    //   145: ldc_w 384
    //   148: iload 9
    //   150: i2l
    //   151: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   154: pop
    //   155: aload_0
    //   156: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   159: aload 13
    //   161: invokeinterface 768 2 0
    //   166: istore 25
    //   168: iload 25
    //   170: istore 11
    //   172: aload 13
    //   174: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   177: iload 11
    //   179: ireturn
    //   180: aconst_null
    //   181: astore 22
    //   183: goto -57 -> 126
    //   186: astore 10
    //   188: iconst_0
    //   189: istore 11
    //   191: aload 10
    //   193: astore 12
    //   195: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   198: aload 12
    //   200: ldc_w 964
    //   203: invokeinterface 805 3 0
    //   208: iload 11
    //   210: ireturn
    //   211: astore 12
    //   213: goto -18 -> 195
    //
    // Exception table:
    //   from	to	target	type
    //   0	47	186	java/lang/Exception
    //   52	86	186	java/lang/Exception
    //   86	108	186	java/lang/Exception
    //   113	126	186	java/lang/Exception
    //   126	137	186	java/lang/Exception
    //   143	155	186	java/lang/Exception
    //   155	168	186	java/lang/Exception
    //   172	177	211	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPinToTop(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc 147
    //   11: iload_1
    //   12: i2l
    //   13: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 7
    //   19: ldc 246
    //   21: iload_2
    //   22: i2l
    //   23: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   26: pop
    //   27: aload 7
    //   29: ldc 240
    //   31: aload_3
    //   32: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   35: pop
    //   36: aload_0
    //   37: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   40: aload 7
    //   42: invokeinterface 768 2 0
    //   47: istore 11
    //   49: iload 11
    //   51: istore 5
    //   53: aload 7
    //   55: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   58: iload 5
    //   60: ireturn
    //   61: astore 4
    //   63: iconst_0
    //   64: istore 5
    //   66: aload 4
    //   68: astore 6
    //   70: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   73: aload 6
    //   75: ldc_w 967
    //   78: invokeinterface 805 3 0
    //   83: iload 5
    //   85: ireturn
    //   86: astore 6
    //   88: goto -18 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   0	49	61	java/lang/Exception
    //   53	58	86	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportPurchaseStatusStatistics(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 8
    //   7: aload 8
    //   9: ldc_w 300
    //   12: iload_2
    //   13: i2l
    //   14: invokevirtual 972	com/viber/jni/cdr/Cdr:SetS32	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 8
    //   20: ldc_w 477
    //   23: aload_1
    //   24: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   27: pop
    //   28: aload 8
    //   30: ldc 198
    //   32: aload_3
    //   33: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   36: pop
    //   37: aload 8
    //   39: ldc_w 285
    //   42: aload 4
    //   44: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   47: pop
    //   48: aload_0
    //   49: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   52: aload 8
    //   54: invokeinterface 768 2 0
    //   59: istore 13
    //   61: iload 13
    //   63: istore 6
    //   65: aload 8
    //   67: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   70: iload 6
    //   72: ireturn
    //   73: astore 5
    //   75: iconst_0
    //   76: istore 6
    //   78: aload 5
    //   80: astore 7
    //   82: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   85: aload 7
    //   87: ldc_w 974
    //   90: invokeinterface 805 3 0
    //   95: iload 6
    //   97: ireturn
    //   98: astore 7
    //   100: goto -18 -> 82
    //
    // Exception table:
    //   from	to	target	type
    //   0	61	73	java/lang/Exception
    //   65	70	98	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportScreenAdClick(String paramString)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 5
    //   7: aload 5
    //   9: ldc 171
    //   11: aload_0
    //   12: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   15: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   18: pop
    //   19: aload 5
    //   21: ldc_w 282
    //   24: aload_1
    //   25: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   28: pop
    //   29: aload_0
    //   30: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   33: aload 5
    //   35: invokeinterface 768 2 0
    //   40: istore 8
    //   42: iload 8
    //   44: istore_3
    //   45: aload 5
    //   47: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   50: iload_3
    //   51: ireturn
    //   52: astore_2
    //   53: iconst_0
    //   54: istore_3
    //   55: aload_2
    //   56: astore 4
    //   58: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   61: aload 4
    //   63: ldc_w 977
    //   66: invokeinterface 805 3 0
    //   71: iload_3
    //   72: ireturn
    //   73: astore 4
    //   75: goto -17 -> 58
    //
    // Exception table:
    //   from	to	target	type
    //   0	42	52	java/lang/Exception
    //   45	50	73	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportScreenAdDisplay(String paramString)
  {
    // Byte code:
    //   0: ldc 114
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 5
    //   7: aload 5
    //   9: ldc 171
    //   11: aload_0
    //   12: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   15: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   18: pop
    //   19: aload 5
    //   21: ldc_w 282
    //   24: aload_1
    //   25: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   28: pop
    //   29: aload_0
    //   30: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   33: aload 5
    //   35: invokeinterface 768 2 0
    //   40: istore 8
    //   42: iload 8
    //   44: istore_3
    //   45: aload 5
    //   47: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   50: iload_3
    //   51: ireturn
    //   52: astore_2
    //   53: iconst_0
    //   54: istore_3
    //   55: aload_2
    //   56: astore 4
    //   58: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   61: aload 4
    //   63: ldc_w 980
    //   66: invokeinterface 805 3 0
    //   71: iload_3
    //   72: ireturn
    //   73: astore 4
    //   75: goto -17 -> 58
    //
    // Exception table:
    //   from	to	target	type
    //   0	42	52	java/lang/Exception
    //   45	50	73	java/lang/Exception
  }

  public boolean handleReportScreenDisplay(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    try
    {
      Cdr localCdr = createGeneralCdr("screen_display");
      localCdr.SetU32("screen_id", paramInt1);
      localCdr.SetU32("origin_screen", paramInt2);
      bool = this.mPhoneController.handleReportCdr(localCdr);
      localCdr.Destroy();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return bool;
  }

  // ERROR //
  public boolean handleReportShareFromStickerProductPage(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: ldc 120
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc 156
    //   11: iload_2
    //   12: i2l
    //   13: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 7
    //   19: ldc_w 538
    //   22: aload_1
    //   23: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   26: pop
    //   27: aload 7
    //   29: ldc_w 462
    //   32: aload_3
    //   33: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   36: pop
    //   37: aload_0
    //   38: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   41: aload 7
    //   43: invokeinterface 768 2 0
    //   48: istore 11
    //   50: iload 11
    //   52: istore 5
    //   54: aload 7
    //   56: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   59: iload 5
    //   61: ireturn
    //   62: astore 4
    //   64: iconst_0
    //   65: istore 5
    //   67: aload 4
    //   69: astore 6
    //   71: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   74: aload 6
    //   76: ldc_w 986
    //   79: invokeinterface 805 3 0
    //   84: iload 5
    //   86: ireturn
    //   87: astore 6
    //   89: goto -18 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   0	50	62	java/lang/Exception
    //   54	59	87	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportShareInvitationNativeMenu(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 123
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 6
    //   7: aload 6
    //   9: ldc 204
    //   11: aload_1
    //   12: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   15: pop
    //   16: aload 6
    //   18: ldc_w 553
    //   21: iload_2
    //   22: i2l
    //   23: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   26: pop
    //   27: aload 6
    //   29: ldc_w 360
    //   32: lconst_1
    //   33: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   36: pop
    //   37: aload_0
    //   38: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   41: aload 6
    //   43: invokeinterface 768 2 0
    //   48: istore 10
    //   50: iload 10
    //   52: istore 4
    //   54: aload 6
    //   56: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   59: iload 4
    //   61: ireturn
    //   62: astore_3
    //   63: iconst_0
    //   64: istore 4
    //   66: aload_3
    //   67: astore 5
    //   69: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   72: aload 5
    //   74: ldc_w 990
    //   77: invokeinterface 805 3 0
    //   82: iload 4
    //   84: ireturn
    //   85: astore 5
    //   87: goto -18 -> 69
    //
    // Exception table:
    //   from	to	target	type
    //   0	50	62	java/lang/Exception
    //   54	59	85	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportShareNativeMenu(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 123
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 8
    //   7: aload 8
    //   9: ldc_w 402
    //   12: iload_1
    //   13: i2l
    //   14: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 8
    //   20: ldc_w 315
    //   23: iload_3
    //   24: i2l
    //   25: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   28: pop
    //   29: aload 8
    //   31: ldc 204
    //   33: aload_2
    //   34: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   37: pop
    //   38: aload 8
    //   40: ldc_w 553
    //   43: iload 4
    //   45: i2l
    //   46: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   49: pop
    //   50: aload 8
    //   52: ldc_w 360
    //   55: lconst_0
    //   56: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   64: aload 8
    //   66: invokeinterface 768 2 0
    //   71: istore 14
    //   73: iload 14
    //   75: istore 6
    //   77: aload 8
    //   79: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   82: iload 6
    //   84: ireturn
    //   85: astore 5
    //   87: iconst_0
    //   88: istore 6
    //   90: aload 5
    //   92: astore 7
    //   94: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   97: aload 7
    //   99: ldc_w 990
    //   102: invokeinterface 805 3 0
    //   107: iload 6
    //   109: ireturn
    //   110: astore 7
    //   112: goto -18 -> 94
    //
    // Exception table:
    //   from	to	target	type
    //   0	73	85	java/lang/Exception
    //   77	82	110	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportShiftKeyMessageSent(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 9
    //   7: aload 9
    //   9: ldc_w 270
    //   12: aload_1
    //   13: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   16: pop
    //   17: aload 9
    //   19: ldc_w 273
    //   22: iload_2
    //   23: i2l
    //   24: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   27: pop
    //   28: aload 9
    //   30: ldc_w 541
    //   33: aload_3
    //   34: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   37: pop
    //   38: aload 9
    //   40: ldc_w 517
    //   43: aload 4
    //   45: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   48: pop
    //   49: aload 9
    //   51: ldc_w 471
    //   54: aload 5
    //   56: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   64: aload 9
    //   66: invokeinterface 768 2 0
    //   71: istore 15
    //   73: iload 15
    //   75: istore 7
    //   77: aload 9
    //   79: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   82: iload 7
    //   84: ireturn
    //   85: astore 6
    //   87: iconst_0
    //   88: istore 7
    //   90: aload 6
    //   92: astore 8
    //   94: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   97: aload 8
    //   99: ldc_w 996
    //   102: invokeinterface 805 3 0
    //   107: iload 7
    //   109: ireturn
    //   110: astore 8
    //   112: goto -18 -> 94
    //
    // Exception table:
    //   from	to	target	type
    //   0	73	85	java/lang/Exception
    //   77	82	110	java/lang/Exception
  }

  public boolean handleReportShiftKeySearch(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    boolean bool = false;
    if (da.a(paramString2))
      return false;
    try
    {
      Cdr localCdr = Cdr.Create("shift_key_search");
      localCdr.SetString("ContentProvider", paramString1);
      localCdr.SetU32("ContentProviderPosition", paramInt1);
      localCdr.SetString("search_term", paramString2);
      localCdr.SetU8("search_success_ind", paramInt2);
      localCdr.SetString("pa_id", paramString3);
      bool = this.mPhoneController.handleReportCdr(localCdr);
      localCdr.Destroy();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return bool;
  }

  // ERROR //
  public boolean handleReportStickerClickerClick(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 10
    //   3: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 14
    //   8: aload 14
    //   10: ldc_w 529
    //   13: lload_1
    //   14: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 14
    //   20: ldc 171
    //   22: aload_0
    //   23: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   26: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   29: pop
    //   30: aload 14
    //   32: ldc 156
    //   34: iload_3
    //   35: i2l
    //   36: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   39: pop
    //   40: aload 14
    //   42: ldc 165
    //   44: ldc2_w 1006
    //   47: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   50: pop
    //   51: aload 14
    //   53: ldc_w 511
    //   56: aload 4
    //   58: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   61: pop
    //   62: aload 14
    //   64: ldc_w 565
    //   67: aload 5
    //   69: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   72: pop
    //   73: aload 14
    //   75: ldc 183
    //   77: iload 6
    //   79: i2l
    //   80: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   83: pop
    //   84: aload 14
    //   86: ldc 180
    //   88: iload 7
    //   90: i2l
    //   91: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   94: pop
    //   95: aload 14
    //   97: ldc_w 483
    //   100: aload 8
    //   102: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   105: pop
    //   106: aload 14
    //   108: ldc 192
    //   110: aload 9
    //   112: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   115: pop
    //   116: aload 14
    //   118: ldc 168
    //   120: aload 10
    //   122: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   125: pop
    //   126: aload_0
    //   127: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   130: aload 14
    //   132: invokeinterface 768 2 0
    //   137: istore 26
    //   139: iload 26
    //   141: istore 12
    //   143: aload 14
    //   145: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   148: iload 12
    //   150: ireturn
    //   151: astore 11
    //   153: iconst_0
    //   154: istore 12
    //   156: aload 11
    //   158: astore 13
    //   160: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   163: aload 13
    //   165: ldc_w 1009
    //   168: invokeinterface 805 3 0
    //   173: iload 12
    //   175: ireturn
    //   176: astore 13
    //   178: goto -18 -> 160
    //
    // Exception table:
    //   from	to	target	type
    //   0	139	151	java/lang/Exception
    //   143	148	176	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportStickerClickerDisplay(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 13
    //   3: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 14
    //   8: aload 14
    //   10: ldc_w 529
    //   13: lload_1
    //   14: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 14
    //   20: ldc 171
    //   22: aload_0
    //   23: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   26: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   29: pop
    //   30: aload 14
    //   32: ldc 165
    //   34: ldc2_w 1006
    //   37: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   40: pop
    //   41: aload 14
    //   43: ldc_w 511
    //   46: aload_3
    //   47: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: aload 14
    //   53: ldc_w 565
    //   56: aload 4
    //   58: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   61: pop
    //   62: aload 14
    //   64: ldc 183
    //   66: iload 5
    //   68: i2l
    //   69: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   72: pop
    //   73: aload 14
    //   75: ldc_w 303
    //   78: iload 6
    //   80: i2l
    //   81: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   84: pop
    //   85: aload 14
    //   87: ldc 180
    //   89: iload 7
    //   91: i2l
    //   92: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   95: pop
    //   96: aload 14
    //   98: ldc_w 483
    //   101: aload 8
    //   103: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   106: pop
    //   107: aload 14
    //   109: ldc 192
    //   111: aload 9
    //   113: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   116: pop
    //   117: aload 14
    //   119: ldc 168
    //   121: aload 10
    //   123: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   126: pop
    //   127: aload_0
    //   128: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   131: aload 14
    //   133: invokeinterface 768 2 0
    //   138: istore 26
    //   140: iload 26
    //   142: istore 12
    //   144: aload 14
    //   146: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   149: iload 12
    //   151: ireturn
    //   152: astore 11
    //   154: iconst_0
    //   155: istore 12
    //   157: aload 11
    //   159: astore 13
    //   161: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   164: aload 13
    //   166: ldc_w 1013
    //   169: invokeinterface 805 3 0
    //   174: iload 12
    //   176: ireturn
    //   177: astore 13
    //   179: goto -18 -> 161
    //
    // Exception table:
    //   from	to	target	type
    //   0	140	152	java/lang/Exception
    //   144	149	177	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportStickerMarketEntry(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 10
    //   7: aload 10
    //   9: ldc_w 535
    //   12: lload_1
    //   13: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   16: pop
    //   17: aload 10
    //   19: ldc_w 544
    //   22: iload_3
    //   23: i2l
    //   24: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   27: pop
    //   28: aload 10
    //   30: ldc_w 532
    //   33: iload 4
    //   35: i2l
    //   36: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   39: pop
    //   40: aload 10
    //   42: ldc 255
    //   44: lload 5
    //   46: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   49: pop
    //   50: aload_0
    //   51: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   54: aload 10
    //   56: invokeinterface 768 2 0
    //   61: istore 15
    //   63: iload 15
    //   65: istore 8
    //   67: aload 10
    //   69: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   72: iload 8
    //   74: ireturn
    //   75: astore 7
    //   77: iconst_0
    //   78: istore 8
    //   80: aload 7
    //   82: astore 9
    //   84: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   87: aload 9
    //   89: ldc_w 1017
    //   92: invokeinterface 805 3 0
    //   97: iload 8
    //   99: ireturn
    //   100: astore 9
    //   102: goto -18 -> 84
    //
    // Exception table:
    //   from	to	target	type
    //   0	63	75	java/lang/Exception
    //   67	72	100	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportStickerMenuExposures(long paramLong, String paramString)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 7
    //   7: aload 7
    //   9: ldc 144
    //   11: lload_1
    //   12: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   15: pop
    //   16: aload 7
    //   18: ldc_w 462
    //   21: aload_3
    //   22: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   30: aload 7
    //   32: invokeinterface 768 2 0
    //   37: istore 10
    //   39: iload 10
    //   41: istore 5
    //   43: aload 7
    //   45: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   48: iload 5
    //   50: ireturn
    //   51: astore 4
    //   53: iconst_0
    //   54: istore 5
    //   56: aload 4
    //   58: astore 6
    //   60: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   63: aload 6
    //   65: ldc_w 1021
    //   68: invokeinterface 805 3 0
    //   73: iload 5
    //   75: ireturn
    //   76: astore 6
    //   78: goto -18 -> 60
    //
    // Exception table:
    //   from	to	target	type
    //   0	39	51	java/lang/Exception
    //   43	48	76	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportStickerPacksInStrickerMenu(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   5: astore 6
    //   7: aload 6
    //   9: ldc_w 465
    //   12: aload_1
    //   13: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   16: pop
    //   17: aload 6
    //   19: ldc_w 586
    //   22: aload_2
    //   23: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   31: aload 6
    //   33: invokeinterface 768 2 0
    //   38: istore 9
    //   40: iload 9
    //   42: istore 4
    //   44: aload 6
    //   46: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   49: iload 4
    //   51: ireturn
    //   52: astore_3
    //   53: iconst_0
    //   54: istore 4
    //   56: aload_3
    //   57: astore 5
    //   59: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   62: aload 5
    //   64: ldc_w 1024
    //   67: invokeinterface 805 3 0
    //   72: iload 4
    //   74: ireturn
    //   75: astore 5
    //   77: goto -18 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   0	40	52	java/lang/Exception
    //   44	49	75	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportTermsAndPrivacyPolicy()
  {
    // Byte code:
    //   0: ldc_w 623
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   12: aload 4
    //   14: invokeinterface 768 2 0
    //   19: istore 5
    //   21: iload 5
    //   23: istore_2
    //   24: aload 4
    //   26: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   29: iload_2
    //   30: ireturn
    //   31: astore_1
    //   32: iconst_0
    //   33: istore_2
    //   34: aload_1
    //   35: astore_3
    //   36: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   39: aload_3
    //   40: ldc_w 1028
    //   43: invokeinterface 805 3 0
    //   48: iload_2
    //   49: ireturn
    //   50: astore_3
    //   51: goto -15 -> 36
    //
    // Exception table:
    //   from	to	target	type
    //   0	21	31	java/lang/Exception
    //   24	29	50	java/lang/Exception
  }

  public boolean handleReportUiDisplayedDuringCall(long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool = false;
    try
    {
      Cdr localCdr = createGeneralCdr("ui_displayed_during_call");
      localCdr.SetString("client_call_token", String.valueOf(paramLong1));
      localCdr.SetU32("ui_display_duration", paramLong2);
      localCdr.SetU32("seconds_into_call", paramLong3);
      bool = this.mPhoneController.handleReportCdr(localCdr);
      localCdr.Destroy();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return bool;
  }

  // ERROR //
  public boolean handleReportVOSendCreditScreen(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 647
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 459
    //   13: iload_1
    //   14: i2l
    //   15: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   18: pop
    //   19: aload_0
    //   20: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   23: aload 5
    //   25: invokeinterface 768 2 0
    //   30: istore 7
    //   32: iload 7
    //   34: istore_3
    //   35: aload 5
    //   37: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   40: iload_3
    //   41: ireturn
    //   42: astore_2
    //   43: iconst_0
    //   44: istore_3
    //   45: aload_2
    //   46: astore 4
    //   48: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   51: aload 4
    //   53: ldc_w 1034
    //   56: invokeinterface 805 3 0
    //   61: iload_3
    //   62: ireturn
    //   63: astore 4
    //   65: goto -17 -> 48
    //
    // Exception table:
    //   from	to	target	type
    //   0	32	42	java/lang/Exception
    //   35	40	63	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportVOSendInviteScreen(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 650
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 459
    //   13: iload_1
    //   14: i2l
    //   15: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   18: pop
    //   19: aload_0
    //   20: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   23: aload 5
    //   25: invokeinterface 768 2 0
    //   30: istore 7
    //   32: iload 7
    //   34: istore_3
    //   35: aload 5
    //   37: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   40: iload_3
    //   41: ireturn
    //   42: astore_2
    //   43: iconst_0
    //   44: istore_3
    //   45: aload_2
    //   46: astore 4
    //   48: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   51: aload 4
    //   53: ldc_w 1034
    //   56: invokeinterface 805 3 0
    //   61: iload_3
    //   62: ireturn
    //   63: astore 4
    //   65: goto -17 -> 48
    //
    // Exception table:
    //   from	to	target	type
    //   0	32	42	java/lang/Exception
    //   35	40	63	java/lang/Exception
  }

  public boolean handleReportVersionChecksumChanged(String paramString)
  {
    boolean bool = false;
    try
    {
      Cdr localCdr = Cdr.Create("version_checksum_changed");
      localCdr.SetString("new_checksum", paramString);
      bool = this.mPhoneController.handleReportCdr(localCdr);
      localCdr.Destroy();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return bool;
  }

  public boolean handleReportViberNewsSessionAndUrls(int paramInt, NewsSession paramNewsSession)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject1.put("news_provider", CdrConst.NewsProviderName.NewsProviderNameHelper.convert(paramInt));
      Iterator localIterator = paramNewsSession.getVisitedUrls().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("url", localEntry.getKey());
        localJSONObject2.put("duration", TimeUnit.MILLISECONDS.toSeconds(((Long)localEntry.getValue()).longValue()));
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("news_urls", localJSONArray);
      return handleClientTrackingReport(7, Long.toString(TimeUnit.MILLISECONDS.toSeconds(paramNewsSession.getSessionTimeMillis())), localJSONObject1.toString());
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }

  // ERROR //
  public boolean handleReportVideoAdClick(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 10
    //   3: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 14
    //   8: aload 14
    //   10: ldc_w 529
    //   13: lload_1
    //   14: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 14
    //   20: ldc 171
    //   22: aload_0
    //   23: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   26: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   29: pop
    //   30: aload 14
    //   32: ldc 156
    //   34: iload_3
    //   35: i2l
    //   36: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   39: pop
    //   40: aload 14
    //   42: ldc 165
    //   44: ldc2_w 1119
    //   47: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   50: pop
    //   51: aload 14
    //   53: ldc_w 511
    //   56: aload 4
    //   58: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   61: pop
    //   62: aload 14
    //   64: ldc_w 565
    //   67: aload 5
    //   69: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   72: pop
    //   73: aload 14
    //   75: ldc 183
    //   77: iload 6
    //   79: i2l
    //   80: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   83: pop
    //   84: aload 14
    //   86: ldc 180
    //   88: iload 7
    //   90: i2l
    //   91: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   94: pop
    //   95: aload 14
    //   97: ldc_w 483
    //   100: aload 8
    //   102: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   105: pop
    //   106: aload 14
    //   108: ldc 192
    //   110: aload 9
    //   112: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   115: pop
    //   116: aload 14
    //   118: ldc 168
    //   120: aload 10
    //   122: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   125: pop
    //   126: aload_0
    //   127: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   130: aload 14
    //   132: invokeinterface 768 2 0
    //   137: istore 26
    //   139: iload 26
    //   141: istore 12
    //   143: aload 14
    //   145: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   148: iload 12
    //   150: ireturn
    //   151: astore 11
    //   153: iconst_0
    //   154: istore 12
    //   156: aload 11
    //   158: astore 13
    //   160: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   163: aload 13
    //   165: ldc_w 1122
    //   168: invokeinterface 805 3 0
    //   173: iload 12
    //   175: ireturn
    //   176: astore 13
    //   178: goto -18 -> 160
    //
    // Exception table:
    //   from	to	target	type
    //   0	139	151	java/lang/Exception
    //   143	148	176	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportVideoAdDisplay(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 13
    //   3: invokespecial 754	com/viber/jni/cdr/CdrController:createGeneralCdr	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 14
    //   8: aload 14
    //   10: ldc_w 529
    //   13: lload_1
    //   14: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   17: pop
    //   18: aload 14
    //   20: ldc 171
    //   22: aload_0
    //   23: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   26: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   29: pop
    //   30: aload 14
    //   32: ldc 165
    //   34: ldc2_w 1119
    //   37: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   40: pop
    //   41: aload 14
    //   43: ldc_w 511
    //   46: aload_3
    //   47: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: aload 14
    //   53: ldc_w 565
    //   56: aload 4
    //   58: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   61: pop
    //   62: aload 14
    //   64: ldc 183
    //   66: iload 5
    //   68: i2l
    //   69: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   72: pop
    //   73: aload 14
    //   75: ldc_w 303
    //   78: iload 6
    //   80: i2l
    //   81: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   84: pop
    //   85: aload 14
    //   87: ldc 180
    //   89: iload 7
    //   91: i2l
    //   92: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   95: pop
    //   96: aload 14
    //   98: ldc_w 483
    //   101: aload 8
    //   103: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   106: pop
    //   107: aload 14
    //   109: ldc 192
    //   111: aload 9
    //   113: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   116: pop
    //   117: aload 14
    //   119: ldc 168
    //   121: aload 10
    //   123: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   126: pop
    //   127: aload_0
    //   128: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   131: aload 14
    //   133: invokeinterface 768 2 0
    //   138: istore 26
    //   140: iload 26
    //   142: istore 12
    //   144: aload 14
    //   146: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   149: iload 12
    //   151: ireturn
    //   152: astore 11
    //   154: iconst_0
    //   155: istore 12
    //   157: aload 11
    //   159: astore 13
    //   161: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   164: aload 13
    //   166: ldc_w 1125
    //   169: invokeinterface 805 3 0
    //   174: iload 12
    //   176: ireturn
    //   177: astore 13
    //   179: goto -18 -> 161
    //
    // Exception table:
    //   from	to	target	type
    //   0	140	152	java/lang/Exception
    //   144	149	177	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportVoBannerClick(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 635
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 7
    //   8: aload 7
    //   10: ldc_w 477
    //   13: aload_2
    //   14: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   17: pop
    //   18: aload 7
    //   20: ldc_w 571
    //   23: aload_1
    //   24: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   27: pop
    //   28: aload 7
    //   30: ldc 156
    //   32: iload_3
    //   33: i2l
    //   34: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   37: pop
    //   38: aload_0
    //   39: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   42: aload 7
    //   44: invokeinterface 768 2 0
    //   49: istore 11
    //   51: iload 11
    //   53: istore 5
    //   55: aload 7
    //   57: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   60: iload 5
    //   62: ireturn
    //   63: astore 4
    //   65: iconst_0
    //   66: istore 5
    //   68: aload 4
    //   70: astore 6
    //   72: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   75: aload 6
    //   77: ldc_w 1128
    //   80: invokeinterface 805 3 0
    //   85: iload 5
    //   87: ireturn
    //   88: astore 6
    //   90: goto -18 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   0	51	63	java/lang/Exception
    //   55	60	88	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportVoBannerDisplayed(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 638
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 6
    //   8: aload 6
    //   10: ldc_w 477
    //   13: aload_2
    //   14: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   17: pop
    //   18: aload 6
    //   20: ldc_w 571
    //   23: aload_1
    //   24: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   27: pop
    //   28: aload_0
    //   29: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   32: aload 6
    //   34: invokeinterface 768 2 0
    //   39: istore 9
    //   41: iload 9
    //   43: istore 4
    //   45: aload 6
    //   47: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   50: iload 4
    //   52: ireturn
    //   53: astore_3
    //   54: iconst_0
    //   55: istore 4
    //   57: aload_3
    //   58: astore 5
    //   60: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   63: aload 5
    //   65: ldc_w 1131
    //   68: invokeinterface 805 3 0
    //   73: iload 4
    //   75: ireturn
    //   76: astore 5
    //   78: goto -18 -> 60
    //
    // Exception table:
    //   from	to	target	type
    //   0	41	53	java/lang/Exception
    //   45	50	76	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportVoBuy(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc_w 641
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 10
    //   8: aload 10
    //   10: ldc_w 490
    //   13: iload_2
    //   14: i2l
    //   15: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   18: pop
    //   19: aload 10
    //   21: ldc 225
    //   23: iload_3
    //   24: i2l
    //   25: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   28: pop
    //   29: aload 10
    //   31: ldc 108
    //   33: iload 4
    //   35: i2l
    //   36: invokevirtual 758	com/viber/jni/cdr/Cdr:SetU32	(Ljava/lang/String;J)Z
    //   39: pop
    //   40: aload 10
    //   42: ldc_w 477
    //   45: aload_1
    //   46: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   49: pop
    //   50: aload 10
    //   52: ldc_w 474
    //   55: aload 5
    //   57: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   60: pop
    //   61: aload 10
    //   63: ldc_w 285
    //   66: aload 6
    //   68: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   71: pop
    //   72: aload_0
    //   73: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   76: aload 10
    //   78: invokeinterface 768 2 0
    //   83: istore 17
    //   85: iload 17
    //   87: istore 8
    //   89: aload 10
    //   91: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   94: iload 8
    //   96: ireturn
    //   97: astore 7
    //   99: iconst_0
    //   100: istore 8
    //   102: aload 7
    //   104: astore 9
    //   106: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   109: aload 9
    //   111: ldc_w 1135
    //   114: invokeinterface 805 3 0
    //   119: iload 8
    //   121: ireturn
    //   122: astore 9
    //   124: goto -18 -> 106
    //
    // Exception table:
    //   from	to	target	type
    //   0	85	97	java/lang/Exception
    //   89	94	122	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportVoDisplay(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 644
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 459
    //   13: iload_1
    //   14: i2l
    //   15: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   18: pop
    //   19: aload_0
    //   20: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   23: aload 5
    //   25: invokeinterface 768 2 0
    //   30: istore 7
    //   32: iload 7
    //   34: istore_3
    //   35: aload 5
    //   37: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   40: iload_3
    //   41: ireturn
    //   42: astore_2
    //   43: iconst_0
    //   44: istore_3
    //   45: aload_2
    //   46: astore 4
    //   48: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   51: aload 4
    //   53: ldc_w 1138
    //   56: invokeinterface 805 3 0
    //   61: iload_3
    //   62: ireturn
    //   63: astore 4
    //   65: goto -17 -> 48
    //
    // Exception table:
    //   from	to	target	type
    //   0	32	42	java/lang/Exception
    //   35	40	63	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportVoiceMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 632
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 7
    //   8: aload 7
    //   10: ldc_w 381
    //   13: iload_1
    //   14: i2l
    //   15: invokevirtual 873	com/viber/jni/cdr/Cdr:SetU16	(Ljava/lang/String;J)Z
    //   18: pop
    //   19: aload 7
    //   21: ldc_w 553
    //   24: iload_2
    //   25: i2l
    //   26: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   29: pop
    //   30: aload 7
    //   32: ldc_w 568
    //   35: iload_3
    //   36: i2l
    //   37: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   40: pop
    //   41: aload_0
    //   42: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   45: aload 7
    //   47: invokeinterface 768 2 0
    //   52: istore 11
    //   54: iload 11
    //   56: istore 5
    //   58: aload 7
    //   60: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   63: iload 5
    //   65: ireturn
    //   66: astore 4
    //   68: iconst_0
    //   69: istore 5
    //   71: aload 4
    //   73: astore 6
    //   75: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   78: aload 6
    //   80: ldc_w 1141
    //   83: invokeinterface 805 3 0
    //   88: iload 5
    //   90: ireturn
    //   91: astore 6
    //   93: goto -18 -> 75
    //
    // Exception table:
    //   from	to	target	type
    //   0	54	66	java/lang/Exception
    //   58	63	91	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportWalletEntryFrom(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 653
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 7
    //   8: aload 7
    //   10: ldc 171
    //   12: aload_0
    //   13: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   16: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   19: pop
    //   20: aload 7
    //   22: ldc 210
    //   24: aload_1
    //   25: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   28: pop
    //   29: aload 7
    //   31: ldc_w 297
    //   34: iload_2
    //   35: i2l
    //   36: invokevirtual 787	com/viber/jni/cdr/Cdr:SetU8	(Ljava/lang/String;J)Z
    //   39: pop
    //   40: aload 7
    //   42: ldc_w 480
    //   45: aload_3
    //   46: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   49: pop
    //   50: aload_0
    //   51: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   54: aload 7
    //   56: invokeinterface 768 2 0
    //   61: istore 12
    //   63: iload 12
    //   65: istore 5
    //   67: aload 7
    //   69: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   72: iload 5
    //   74: ireturn
    //   75: astore 4
    //   77: iconst_0
    //   78: istore 5
    //   80: aload 4
    //   82: astore 6
    //   84: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   87: aload 6
    //   89: ldc_w 1144
    //   92: invokeinterface 805 3 0
    //   97: iload 5
    //   99: ireturn
    //   100: astore 6
    //   102: goto -18 -> 84
    //
    // Exception table:
    //   from	to	target	type
    //   0	63	75	java/lang/Exception
    //   67	72	100	java/lang/Exception
  }

  // ERROR //
  public boolean handleReportWalletOptIn(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 656
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 7
    //   8: aload 7
    //   10: ldc 171
    //   12: aload_0
    //   13: getfield 686	com/viber/jni/cdr/CdrController:mAdvertisingId	Ljava/lang/String;
    //   16: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   19: pop
    //   20: aload 7
    //   22: ldc 210
    //   24: aload_1
    //   25: invokevirtual 762	com/viber/jni/cdr/Cdr:SetString	(Ljava/lang/String;Ljava/lang/String;)Z
    //   28: pop
    //   29: aload 7
    //   31: ldc_w 450
    //   34: lload_2
    //   35: invokevirtual 784	com/viber/jni/cdr/Cdr:SetU64	(Ljava/lang/String;J)Z
    //   38: pop
    //   39: aload_0
    //   40: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   43: aload 7
    //   45: invokeinterface 768 2 0
    //   50: istore 11
    //   52: iload 11
    //   54: istore 5
    //   56: aload 7
    //   58: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   61: iload 5
    //   63: ireturn
    //   64: astore 4
    //   66: iconst_0
    //   67: istore 5
    //   69: aload 4
    //   71: astore 6
    //   73: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   76: aload 6
    //   78: ldc_w 1147
    //   81: invokeinterface 805 3 0
    //   86: iload 5
    //   88: ireturn
    //   89: astore 6
    //   91: goto -18 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   0	52	64	java/lang/Exception
    //   56	61	89	java/lang/Exception
  }

  public boolean handleReportWeb(String paramString1, String paramString2, long paramLong)
  {
    Cdr localCdr;
    Exception localException2;
    boolean bool1;
    try
    {
      localCdr = Cdr.Create("Web");
      localCdr.SetTag(paramString1);
      if (("web_ad_display".equals(paramString1)) || ("web_ad_click".equals(paramString1)))
        localCdr.SetString("advertising_id", this.mAdvertisingId);
      localCdr.SetU64("SessionToken", paramLong);
      Type localType = new a()
      {
      }
      .getType();
      Iterator localIterator = ((Map)new f().a(paramString2, localType)).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localCdr.SetString((String)localEntry.getKey(), localEntry.getValue().toString());
      }
    }
    catch (Exception localException1)
    {
      localException2 = localException1;
      bool1 = false;
    }
    while (true)
    {
      L.a(localException2, "handleReportWeb not sent");
      return bool1;
      boolean bool2 = this.mPhoneController.handleReportCdr(localCdr);
      bool1 = bool2;
      try
      {
        localCdr.Destroy();
        return bool1;
      }
      catch (Exception localException3)
      {
      }
    }
  }

  // ERROR //
  public boolean handleReportWesternUnionStatistics()
  {
    // Byte code:
    //   0: ldc_w 662
    //   3: invokestatic 710	com/viber/jni/cdr/Cdr:Create	(Ljava/lang/String;)Lcom/viber/jni/cdr/Cdr;
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 693	com/viber/jni/cdr/CdrController:mPhoneController	Lcom/viber/jni/controller/PhoneController;
    //   12: aload 4
    //   14: invokeinterface 768 2 0
    //   19: istore 5
    //   21: iload 5
    //   23: istore_2
    //   24: aload 4
    //   26: invokevirtual 771	com/viber/jni/cdr/Cdr:Destroy	()V
    //   29: iload_2
    //   30: ireturn
    //   31: astore_1
    //   32: iconst_0
    //   33: istore_2
    //   34: aload_1
    //   35: astore_3
    //   36: getstatic 678	com/viber/jni/cdr/CdrController:L	Lcom/viber/dexshared/Logger;
    //   39: aload_3
    //   40: ldc_w 1174
    //   43: invokeinterface 805 3 0
    //   48: iload_2
    //   49: ireturn
    //   50: astore_3
    //   51: goto -15 -> 36
    //
    // Exception table:
    //   from	to	target	type
    //   0	21	31	java/lang/Exception
    //   24	29	50	java/lang/Exception
  }

  public boolean handleViberNewsProviderChanges(ViberNewsProviderSpec paramViberNewsProviderSpec)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i;
      if (paramViberNewsProviderSpec.isNewsProviderExists())
      {
        i = CdrConst.NewsProviderEntryPoint.NewsProviderEntryPointHelper.convert(paramViberNewsProviderSpec.getEntryPoint());
        localJSONObject.put("news_provider", CdrConst.NewsProviderName.NewsProviderNameHelper.convert(paramViberNewsProviderSpec.getId()));
      }
      while (true)
      {
        return handleClientTrackingReport(13, Integer.toString(i), localJSONObject.toString());
        localJSONObject.put("news_provider", "none");
        i = 0;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }

  public void setAdvertisingId(String paramString)
  {
    this.mAdvertisingId = paramString;
  }

  public void setCommunityViewSource(int paramInt)
  {
    addTrackable("community_view_source", Integer.valueOf(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.CdrController
 * JD-Core Version:    0.6.2
 */