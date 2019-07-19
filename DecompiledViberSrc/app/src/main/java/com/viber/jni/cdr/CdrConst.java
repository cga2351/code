package com.viber.jni.cdr;

import com.viber.voip.phone.call.CallInfo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract interface CdrConst
{
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ActionReplyType
  {
    public static final int MESSAGE = 2;
    public static final int NONE = 0;
    public static final int QUERY = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdClickActionType
  {
    public static final int CLICK_AD_ACTION = 1;
    public static final int CLICK_DISMISS_ACTION = 2;
    public static final int CLICK_ON_CHATS = 6;
    public static final int CLICK_ON_CLOSE = 4;
    public static final int CLICK_ON_MESSAGE = 5;
    public static final int CLICK_WHY_SEEN_ACTION = 3;
    public static final int NO_ACTION;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdErrorDisplay
  {
    public static final int NO_CONTENT = 1;
    public static final int NO_ERROR = 0;
    public static final int OTHER = 4;
    public static final int PARSE_ERROR = 3;
    public static final int TIMEOUT = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdLocationCode
  {
    public static final int BUSINESS_INBOX_PLACEMENT = 22;
    public static final int CALLS_TAB_PLACEMENT = 23;
    public static final int CALL_SUMMARY_BUSY_ITEM = 16;
    public static final int CALL_SUMMARY_ITEM = 2;
    public static final int CALL_SUMMARY_TIMEOUT_ITEM = 15;
    public static final int CALL_SUMMARY_WITH_MIDCALL_LOADING = 17;
    public static final int CHAT_EXT_PLACEMENT = 25;
    public static final int CHAT_LIST_PLACEMENT = 24;
    public static final int CHAT_SCREEN_ADS = 13;
    public static final int DESKTOP_300_X_250_ITEM = 7;
    public static final int DESKTOP_300_X_50_ITEM = 8;
    public static final int DISCOVER_GAME_SECTION = 9;
    public static final int DISCOVER_PUBLIC_ACCOUNT = 11;
    public static final int DISCOVER_SEARCH_RESULTS = 10;
    public static final int FEED_ITEM = 0;
    public static final int GAME_MARKET_ITEM = 3;
    public static final int PUBLIC_ACCOUNT_SCREEN = 12;
    public static final int PUBLIC_CHAT_ITEM = 1;
    public static final int STICKER_CLICKER_ITEM = 14;
    public static final int STICKER_MARKET_ITEM = 4;
    public static final int STICKER_MARKET_SPONSORED_ITEM = 5;
    public static final int STICKER_MARKET_VIDEO_AD = 6;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdResponseCode
  {
    public static final int ERROR_CODE_INTERNAL_ERROR = 4;
    public static final int ERROR_CODE_INVALID_REQUEST = 5;
    public static final int ERROR_CODE_NETWORK_ERROR = 6;
    public static final int ERROR_CODE_NO_FILL = 7;
    public static final int INTERNAL_SDK_FAILURE = 1;
    public static final int NO_INTERNET = 2;
    public static final int SUCCESS = 0;
    public static final int SUCCESS_BANNER_AD = 101;
    public static final int SUCCESS_NATIVE_AD = 100;
    public static final int SUCCESS_VIDEO_AD = 102;
    public static final int TIMEOUT = 3;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdServiceInd
  {
    public static final int ADMOB = 2;
    public static final int ADS_NATIVE = 1;
    public static final int APP_NEXUS = 3;
    public static final int POLYMORPH_HB = 5;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdType
  {
  }

  public static final class AdTypes
  {
    public static final int BANNER = 5;
    public static final int DISPLAY = 2;
    public static final int GOOGLE_ADVIEW = 4;
    public static final int MULTIFORMAT = 6;
    public static final int STORY = 1;
    public static final int VIDEO = 3;

    public static int fromAdType(String paramString)
    {
      if ("display".equalsIgnoreCase(paramString))
        return 2;
      if ("video".equalsIgnoreCase(paramString))
        return 3;
      if ("google admob sdk".equalsIgnoreCase(paramString))
        return 4;
      if ("banner".equalsIgnoreCase(paramString))
        return 5;
      if ("multiformat".equalsIgnoreCase(paramString))
        return 6;
      return 1;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdsAfterCallTypeCall
  {
    public static final int FREE_CALL = 1;
    public static final int VI_CALL = 3;
    public static final int VO_CALL = 2;

    public static final class Converter
    {
      public static int fromCallInfo(CallInfo paramCallInfo)
      {
        if (paramCallInfo.isViberIn())
          return 3;
        if (paramCallInfo.isViberOut())
          return 2;
        return 1;
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AppsApprovalPageActionType
  {
    public static final int APPROVE = 0;
    public static final int CANCEL = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BackupActionType
  {
    public static final int BACKUP = 0;
    public static final int RESTORE = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BackupCloudStorage
  {
    public static final int GOOGLE_DRIVE = 1;
    public static final int VIBER_CLOUD = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BackupFrequency
  {
    public static final int DAILY = 2;
    public static final int MANUAL = 1;
    public static final int MONTHLY = 4;
    public static final int NON_BACKUP = 0;
    public static final int WEEKLY = 3;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BackupResolution
  {
    public static final int FAILURE = 0;
    public static final int SUCCESS = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface CallChosenAction
  {
    public static final int GSM_CALL = 2;
    public static final int VIBER_CALL = 3;
    public static final int VIDEO_CALL = 4;
    public static final int VO_CALL = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChatSolution
  {
    public static final int API = 2;
    public static final int NOT_CHOOSEN = 0;
    public static final int OTHER = 3;
    public static final int VAM = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface CommunityRole
  {
    public static final int ADMIN = 0;
    public static final int FOLLOWER = 2;
    public static final int PARTICIPANT = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface CommunityViewSource
  {
    public static final int CHAT_LIST = 0;
    public static final int HIGHLIGHT_NOTIFICATION = 3;
    public static final int NOTIFICATION = 1;
    public static final int URL_SCHEME = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ContextChatType
  {
    public static final int ONE_ON_ONE = 1;
    public static final int PRIVATE_GROUP = 2;
    public static final int PUBLIC_ACCOUNT = 4;
    public static final int PUBLIC_CHAT = 3;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EntryPoint
  {
    public static final int MONEY_REQUEST_MESSAGE = 2;
    public static final int MORE_SCREEN = 0;
    public static final int ONE_TO_ONE_CHAT = 1;
    public static final int URL_SCHEME = 3;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface IconTrigger
  {
    public static final int ANIMATION = 2;
    public static final int BIG_ANIMATION = 4;
    public static final int CLICKER = 10;
    public static final int FAVORITES_BANNER = 12;
    public static final int FEATURE_ICON = 5;
    public static final int FORCE_OPEN = 9;
    public static final int INTRO_TOOLTIP = 1;
    public static final int NEW_SERVICE_INDICATION = 11;
    public static final int NONE = 0;
    public static final int PROMOTIONS = 6;
    public static final int SAY_HI = 13;
    public static final int SEND_VIA = 7;
    public static final int UPDATE_TOOLTIP = 3;
    public static final int URL_SCHEME = 8;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface InlineBotType
  {
    public static final int CHAT_EXTENSION = 2;
    public static final int INSTANT_SHOPPING = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface InteractionType
  {
    public static final int AD_CLICK = 5;
    public static final int LIKE = 0;
    public static final int OPEN_CONTENT = 2;
    public static final int PC_CLICK = 4;
    public static final int SHARE = 3;
    public static final int UNLIKE = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ItemOrigin
  {
    public static final int PC = 1;
    public static final int SPONSORED = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ItemType
  {
    public static final int PICTURE = 1;
    public static final int UNKNOWN_OR_AD = 0;
    public static final int URL = 3;
    public static final int VIDEO = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface KeyboardAction
  {
    public static final int NONE = 1;
    public static final int OPEN_URL = 2;
    public static final int REPLY = 3;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface License
  {
    public static final int ELSE = 0;
    public static final int VIBER = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface LinkedServiceType
  {
    public static final int APP_INSTALLED = 2;
    public static final int APP_NOT_INSTALLED = 3;
    public static final int UNKNOWN = -1;
    public static final int WEB = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface MediaScreenSendMediaType
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface MediationType
  {
    public static final int ADSNATIVE_MEDIATION = 2;
    public static final int GOOGLE_MEDIATION = 1;
    public static final int NO_MEDIATION;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Menu3005Full
  {
    public static final int COME = 1;
    public static final int NOT_COME;
  }

  @Retention(RetentionPolicy.CLASS)
  public static @interface NewsProviderEntryPoint
  {
    public static final int MORE_SCREEN = 2;
    public static final int MORE_SCREEN_AND_TAB = 3;
    public static final int NO_TRIGGER = 0;
    public static final int TAB = 1;

    public static class NewsProviderEntryPointHelper
    {
      @CdrConst.NewsProviderEntryPoint
      public static int convert(int paramInt)
      {
        switch (paramInt)
        {
        case 0:
        default:
          return 0;
        case 2:
          return 1;
        case 1:
          return 2;
        case 3:
        }
        return 3;
      }
    }
  }

  @Retention(RetentionPolicy.CLASS)
  public static @interface NewsProviderName
  {
    public static final String SONY = "Sony";
    public static final String YANDEX_ZEN = "Zen";

    public static class NewsProviderNameHelper
    {
      @CdrConst.NewsProviderName
      public static String convert(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return "Sony";
        case 0:
          return "Sony";
        case 1:
        }
        return "Zen";
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface OfferType
  {
    public static final int FREE = 0;
    public static final int FYBER = 2;
    public static final int PAID = 1;
  }

  public static final class OriginalScreen
  {
    public static int fromConversationType(int paramInt)
    {
      switch (paramInt)
      {
      case 0:
      case 2:
      case 3:
      case 4:
      default:
        return 1;
      case 1:
        return 2;
      case 5:
      }
      return 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface BusinessScreenId
    {
      public static final int BACK_FROM_BUSINESS_INBOX = 2;
      public static final int CHATS_LIST = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface ChatScreenId
    {
      public static final int CHAT_1ON1 = 1;
      public static final int CHAT_COMMUNITY = 3;
      public static final int CHAT_GROUP = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface MoreId
    {
      public static final int MORE = 1;
      public static final int URL_SCHEME = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface NewsId
    {
      public static final int MORE = 1;
      public static final int TAB = 3;
      public static final int URL_SCHEME = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface ProfileId
    {
      public static final int MORE = 1;
      public static final int URL_SCHEME = 2;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface PAUserRole
  {
    public static final int ADMIN = 1;
    public static final int FOLLOWER = 3;
    public static final int GUEST = 6;
    public static final int PARTICIPANT = 2;
    public static final int SUBSCRIBER_FOLLOWER = 5;
    public static final int SUBSCRIBER_NOT_FOLLOWER = 4;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface PageLeftType
  {
    public static final int CHAT_SOLUTION = 3;
    public static final int CREATE_PA = 1;
    public static final int ENTER_PA_DETAILS = 2;
    public static final int FINISHED_PROCESS = 99;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface PcFollower
  {
    public static final int AD = 2;
    public static final int FALSE = 0;
    public static final int TRUE = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface PinToTopAction
  {
    public static final int PIN = 0;
    public static final int UN_PIN = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface PinToTopChatType
  {
    public static final int CHAT_1_ON_1 = 0;
    public static final int CHAT_GROUP = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface RefreshAction
  {
    public static final int OTHER = 0;
    public static final int PULL_TO_REFRESH = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScreenId
  {
    public static final int BUSINESS = 4;
    public static final int HOME = 1;
    public static final int MEDIA = 2;
    public static final int MORE = 8;
    public static final int NEWS = 6;
    public static final int PROFILE = 9;
    public static final int SAY_HI = 7;
    public static final int SPAM = 5;
    public static final int VIDEO = 3;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScreenScrollId
  {
    public static final String CHAT_SCREEN = "0";
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ShareActionType
  {
    public static final int COPY = 2;
    public static final int EXTERNAL = 1;
    public static final int FORWARD;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ShareMediaType
  {
  }

  public static final class ShareMediaTypes
  {
    public static final int ANIMATED_STICKER = 6;
    public static final int AUDIO = 2;
    public static final int FILE_OR_GIF = 10;
    public static final int FORMATTED_MESSAGE = 7;
    public static final int LOCATION = 5;
    public static final int PICTURE = 1;
    public static final int SHARE_CONTACT = 9;
    public static final int STICKER = 4;
    public static final int TEXT = 0;
    public static final int URL = 8;
    public static final int VIDEO = 3;
    public static final int VIDEO_PTT = 14;
    public static final int WINK = 11;

    public static int fromMediaType(int paramInt)
    {
      switch (paramInt)
      {
      case 0:
      default:
        return 0;
      case 1:
        return 1;
      case 2:
      case 1009:
        return 2;
      case 3:
        return 3;
      case 4:
        return 4;
      case 5:
        return 5;
      case 7:
        return 7;
      case 8:
        return 8;
      case 9:
        return 9;
      case 10:
      case 1005:
        return 10;
      case 1003:
      case 1004:
        return 11;
      case 14:
      case 1010:
      }
      return 14;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ShareNativeMenuStatus
  {
    public static final int FAILED = 0;
    public static final int SUCCESSFUL = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface SocialSource
  {
    public static final int Error = 99;
    public static final int Facebook = 0;
    public static final int VK = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface StickerArrivingSource
  {
    public static final int CLICK_ON_APP_BANNER = 2;
    public static final int CLICK_ON_CHAT = 3;
    public static final int CLICK_ON_PACK_ = 5;
    public static final int CLICK_ON_PLUS = 6;
    public static final int CLICK_ON_PRODUCT_PAGE = 4;
    public static final int MORE_SCREEN = 1;
    public static final int OTHER = 99;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface StickerLocation
  {
    public static final int MAIN_PAGE = 0;
    public static final int PRODUCT_PAGE = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface StickerMarketEntrySource
  {
    public static final int CLICK_IN_CHAT = 3;
    public static final int CLICK_ON_PLUS_IN_MENU = 6;
    public static final int CLICK_ON_PRODUCT_PAGE = 4;
    public static final int CLICK_ON_PROMOTED_PACK = 5;
    public static final int FROM_BACKGROUND_TO_FOREGROUND = 7;
    public static final int IN_APP_BANNER = 2;
    public static final int MORE_SCREEN = 1;
    public static final int OTHER = 99;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface TrackingEventID
  {
    public static final int AB_STAT = 5;
    public static final int ACTIVATION_DEBUGGING = 1;
    public static final int MESSAGE_PASTED_EVENT = 3;
    public static final int MOBILE_DARK_MODE = 8;
    public static final int NEW_DESKTOP_DETECTION = 2;
    public static final int SCREEN_SCROLL = 10;
    public static final int USE_PEER2PEER_CALLS_SETTING = 4;
    public static final int VIBER_NEWS = 7;
    public static final int VIBER_NEWS_TRIGGER = 13;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface VideoAdMuteInd
  {
    public static final int CLICKED = 1;
    public static final int NONE = -1;
    public static final int NOT_CLICKED;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface VoDisplay
  {
    public static final int ALL_CONTACTS = 0;
    public static final int MORE = 1;
    public static final int REFERAL_MESSAGE = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface VoiceMessageStatus
  {
    public static final int CANCELLED = 2;
    public static final int SENT = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface VoiceMessageTestFlag
  {
    public static final int NEW_VERSION = 2;
    public static final int OLD_VERSION = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.CdrConst
 * JD-Core Version:    0.6.2
 */