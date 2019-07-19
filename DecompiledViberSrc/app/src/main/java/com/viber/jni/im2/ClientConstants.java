package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ClientConstants
{
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DeviceTypes
  {
    public static final int DEVICE_ANDROID = 1;
    public static final int DEVICE_ANDROID_TABLET = 21;
    public static final int DEVICE_APPLE = 0;
    public static final int DEVICE_APPS_API = 115;
    public static final int DEVICE_BACKEND_TEST = 95;
    public static final int DEVICE_BADA3 = 110;
    public static final int DEVICE_BLACKBERRY = 102;
    public static final int DEVICE_BLACKBERRY10 = 10;
    public static final int DEVICE_FIREFOX_OS = 113;
    public static final int DEVICE_INTERNAL_USE = 105;
    public static final int DEVICE_IOS3 = 8;
    public static final int DEVICE_IOSE = 99;
    public static final int DEVICE_IPAD = 20;
    public static final int DEVICE_IPADE = 98;
    public static final int DEVICE_LINUX = 6;
    public static final int DEVICE_MEDIATEK = 108;
    public static final int DEVICE_MEDIATEK_NATIVE = 114;
    public static final int DEVICE_MNC = 104;
    public static final int DEVICE_MSTAR = 106;
    public static final int DEVICE_NOKIAS40 = 109;
    public static final int DEVICE_NOKIAS60 = 101;
    public static final int DEVICE_OSX = 7;
    public static final int DEVICE_OSX_OLD = 2;
    public static final int DEVICE_SERVICE = 116;
    public static final int DEVICE_SPREADTRUM = 107;
    public static final int DEVICE_UNKNOWN = 65535;
    public static final int DEVICE_VIBER_TERM = 111;
    public static final int DEVICE_WEB_WIDGET = 112;
    public static final int DEVICE_WINDOWS = 4;
    public static final int DEVICE_WINDOWS10_PC = 31;
    public static final int DEVICE_WINDOWS10_PHONE = 30;
    public static final int DEVICE_WINDOWS10_TABLET = 32;
    public static final int DEVICE_WINDOWS8 = 5;
    public static final int DEVICE_WP7 = 3;
    public static final int DEVICE_WP7_API = 103;
    public static final int DEVICE_WP8 = 9;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EAppsApiStatus
  {
    public static final int APPS_API_APP_BLOCKED = 12;
    public static final int APPS_API_APP_SERVER_BAD_URL = 17;
    public static final int APPS_API_APP_SERVER_NOT_DEFINED = 18;
    public static final int APPS_API_APP_SERVER_NOT_RESPONDING = 16;
    public static final int APPS_API_BAD_APPID = 2;
    public static final int APPS_API_BAD_PARAMETERS = 11;
    public static final int APPS_API_INTERNAL_FAILURE = 1;
    public static final int APPS_API_INVALID_DATA = 7;
    public static final int APPS_API_INVALID_DESTINATION = 9;
    public static final int APPS_API_INVALID_HASH = 15;
    public static final int APPS_API_INVALID_MESSAGE_TYPE = 8;
    public static final int APPS_API_MESSAGE_TYPE_BLOCKED = 14;
    public static final int APPS_API_NOT_AUTHENTICATED = 5;
    public static final int APPS_API_NOT_PERMITTED = 3;
    public static final int APPS_API_NOT_REGISTERED = 4;
    public static final int APPS_API_NO_SUITABLE_DEVICE = 10;
    public static final int APPS_API_RECEIVER_NOT_REG = 6;
    public static final int APPS_API_SUCCESS = 0;
    public static final int APPS_API_TIMEOUT = 13;
    public static final int TIMEOUT = 13;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EClientUpgradeType
  {
    public static final int UPGRADE_FORCE = 1;
    public static final int UPGRADE_SUGGESTED = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EPublicAccountFields
  {
    public static final int PA_ABOUT = 3;
    public static final int PA_EMAIL = 5;
    public static final int PA_NAME = 2;
    public static final int PA_URI = 1;
    public static final int PA_WEBSITE = 4;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ESendPublicGroupInviteError
  {
    public static final int PG_INVITE_ALREADY_FOLLOWER = 4;
    public static final int PG_INVITE_CANONIZATION_FAILURE = 0;
    public static final int PG_INVITE_FAIL = 2;
    public static final int PG_INVITE_NOT_REG = 1;
    public static final int PG_INVITE_TIMEOUT = 3;
    public static final int PG_IS_BLOCKED = 6;
    public static final int PG_NO_PG_SUPPORT = 5;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EValidateStatus
  {
    public static final int INVALID_CHARS = 2;
    public static final int RESTRICTED_NAME = 3;
    public static final int URI_NOT_UNIQUE = 4;
    public static final int VALID = 0;
    public static final int VALUE_TOO_LONG = 1;
  }

  public static final class Group2InviteMessages
  {
    @Retention(RetentionPolicy.SOURCE)
    public static @interface EGroup2InviteState
    {
      public static final int FAILED = 1;
      public static final int GROUP_NOT_EXIST = 3;
      public static final int INVITE_ALREADY_EXISTS = 6;
      public static final int NOT_ADMIN = 5;
      public static final int NOT_IN_GROUP = 4;
      public static final int OK = 0;
      public static final int TIMEOUT = 2;
    }
  }

  public static final class GroupInviteMessages
  {
    @Retention(RetentionPolicy.SOURCE)
    public static @interface EGroupInviteState
    {
      public static final int FAILED = 1;
      public static final int GROUP_NOT_EXIST = 3;
      public static final int INVITE_ALREADY_EXISTS = 6;
      public static final int NOT_ADMIN = 5;
      public static final int NOT_IN_GROUP = 4;
      public static final int OK = 0;
      public static final int TIMEOUT = 2;
    }
  }

  public static final class SecretChatMessages
  {
    @Retention(RetentionPolicy.SOURCE)
    public static @interface ESecretChatEvent
    {
      public static final int CHAT_START = 0;
      public static final int SCREEN_SHOT = 2;
      public static final int TIMEBOMB_CHANGE = 1;
    }
  }

  public static final class SyncDataBetweenDevices
  {
    @Retention(RetentionPolicy.SOURCE)
    public static @interface ESyncFlags
    {
      public static final long SYNC_FLAG_CLEAR_MSG = 4L;
      public static final long SYNC_FLAG_NO_PUSH = 2L;
      public static final long SYNC_FLAG_PRIMARY_ONLY = 1L;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface ESyncOpCode
    {
      public static final int SYNC_OP_READ_MARK = 1;
      public static final int SYNC_OP_TUNNEL_DATA;
    }
  }

  public static final class ViberIDMessages
  {
    @Retention(RetentionPolicy.SOURCE)
    public static @interface ViberIDFlags
    {
      public static final int VIF_EMAIL_EXISTS = 1;
      public static final int VIF_EMAIL_VERIFIED = 4;
      public static final int VIF_PASSWORD_REVOKED = 8;
      public static final int VIF_PROMOTIONS = 16;
      public static final int VIF_VIBERID_REVOKED = 2;
    }
  }

  public static final class im2_interface
  {
    @Retention(RetentionPolicy.SOURCE)
    public static @interface DisplayInvitationLink
    {
      public static final int ADMIN = 0;
      public static final int ALL = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EAttributeChangeType
    {
      public static final int CHAT_BACKGROUND = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EChatType
    {
      public static final int CHAT_TYPE_DEFAULT = 0;
      public static final int CHAT_TYPE_M2M = 4;
      public static final int CHAT_TYPE_SECRET = 1;
      public static final int CHAT_TYPE_VLN = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface ECommunityPrivileges
    {
      public static final long WRITE_ALL_MESSAGES_OFF = 0L;
      public static final long WRITE_ALL_MESSAGES_ON = 9223372036854775807L;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EGroupAddWatcherStatus
    {
      public static final int GROUP_WATCHER_STATUS_ADD_OK = 1;
      public static final int GROUP_WATCHER_STATUS_ALREADY_WATCHING = 3;
      public static final int GROUP_WATCHER_STATUS_EXCEEDED_LIMIT = 4;
      public static final int GROUP_WATCHER_STATUS_FAILED = 6;
      public static final int GROUP_WATCHER_STATUS_NOT_VIBER = 2;
      public static final int GROUP_WATCHER_STATUS_NO_VERSION_SUPPORT = 5;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EGroupMemberActionStatus
    {
      public static final int GROUP_MEMBER_BANNED = 13;
      public static final int GROUP_MEMBER_STATUS_ALREADY_IN_GROUP = 3;
      public static final int GROUP_MEMBER_STATUS_FAILED = 5;
      public static final int GROUP_MEMBER_STATUS_INSECURE = 9;
      public static final int GROUP_MEMBER_STATUS_NOT_EXPECTED = 12;
      public static final int GROUP_MEMBER_STATUS_NOT_IN_GROUP = 8;
      public static final int GROUP_MEMBER_STATUS_NOT_VIBER = 2;
      public static final int GROUP_MEMBER_STATUS_NO_VERSION_SUPPORT = 4;
      public static final int GROUP_MEMBER_STATUS_OK = 1;
      public static final int GROUP_MEMBER_STATUS_PARTIAL_DEVICES = 10;
      public static final int GROUP_MEMBER_STATUS_SECURE_RECOVERY_COMPLETE = 11;
      public static final int GROUP_MEMBER_STATUS_SYSTEM_NOT_SUPPORTED = 7;
      public static final int GROUP_MEMBER_STATUS_TOO_MANY_GROUPS = 6;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EGroupRole
    {
      public static final int GROUP_ROLE_ADMINISTRATOR = 2;
      public static final int GROUP_ROLE_LIMITED_MEMBER = 4;
      public static final int GROUP_ROLE_MEMBER = 1;
      public static final int GROUP_ROLE_OLD_MEMBER = 0;
      public static final int GROUP_ROLE_WATCHER = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EGroupType
    {
      public static final int GROUP_TYPE_2 = 3;
      public static final int GROUP_TYPE_GENERAL = 0;
      public static final int GROUP_TYPE_NOT_IN_USE_HERE = 4;
      public static final int GROUP_TYPE_PUBLIC = 1;
      public static final int GROUP_TYPE_PUBLIC_BLOG = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EMultDevFlags
    {
      public static final int MULT_DEV_FLAGS_DELETED = 2;
      public static final int MULT_DEV_FLAGS_FORCE_DELETE = 32;
      public static final int MULT_DEV_FLAGS_LIKES_ONLY = 8;
      public static final int MULT_DEV_FLAGS_MESSAGE_SEEN_BY_ENTIRE_GROUP = 16;
      public static final int MULT_DEV_FLAGS_MESSAGE_SEEN_BY_FIRST_MEMBER = 64;
      public static final int MULT_DEV_FLAGS_READ = 1;
      public static final int MULT_DEV_FLAGS_READ_NOTIFICATION = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EPgSearchFlags
    {
      public static final int ALLOW_ENTER_CONVERSATION_EVENT = 268435456;
      public static final int G2_BLOCKED = 134217728;
      public static final int G2_OPEN = 2097152;
      public static final int PA_ALLOW_ACCEPT_USER_LOCATION = 131072;
      public static final int PA_ALLOW_ACCEPT_USER_PHONE = 262144;
      public static final int PA_ALLOW_BROADCAST = 524288;
      public static final int PA_ALLOW_FORWARD_RM = 65536;
      public static final int PA_INLINE_BOT = 8192;
      public static final int PA_NOT_ALLOW_CHAT = 2048;
      public static final int PA_NOT_SHAREABLE = 1048576;
      public static final int PA_NO_PUBLIC_CHAT = 16384;
      public static final int PA_OMIT_USER_PICTURE = 32768;
      public static final int PA_SERVICE_MESSAGE_ALLOWED = 4096;
      public static final int PG_ADS = 256;
      public static final int PG_AGE_RESTRICTED = 32;
      public static final int PG_BLOCKED = 8;
      public static final int PG_CONTAINS_FORBIDDEN_WORDS = 64;
      public static final int PG_FEATURED = 2;
      public static final int PG_GLOBAL = 16;
      public static final int PG_NONE = 0;
      public static final int PG_NOT_DISCOVER = 1024;
      public static final int PG_NOT_SEARCHABLE = 4;
      public static final int PG_SUSPENDED = 512;
      public static final int PG_TOP_BANNER = 128;
      public static final int PG_VERIFIED = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface ESendMessageExFlags
    {
      public static final long SM_COMMUNITY_FORWARDED = 16L;
      public static final long SM_EX_ADD_PIN = 1L;
      public static final long SM_EX_DELETE_PIN = 2L;
      public static final long SM_EX_MENTION = 4L;
      public static final long SM_G2_INVITE = 8L;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface ESendMessageFlags
    {
      public static final int SM_BROADCAST_LIST = 128;
      public static final int SM_DOODLE = 2;
      public static final int SM_DOODLE_PICTURE = 1;
      public static final int SM_FORWARDED = 4;
      public static final int SM_PG_FORWARDED = 8;
      public static final int SM_RESEND = 16;
      public static final int SM_WINK_PICTURE = 32;
      public static final int SM_WINK_VIDEO = 64;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface EUserDetailInputType
    {
      public static final int MEMBER_IDS = 1;
      public static final int PHONE_NUMBERS;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface MediaType
    {
      public static final int MEDIA_TYPE_ANIMATED_MESSAGE = 6;
      public static final int MEDIA_TYPE_AUDIO = 2;
      public static final int MEDIA_TYPE_CONTACT = 9;
      public static final int MEDIA_TYPE_FILE = 10;
      public static final int MEDIA_TYPE_FORMATTED_MESSAGE = 7;
      public static final int MEDIA_TYPE_LOCATION = 5;
      public static final int MEDIA_TYPE_PA = 12;
      public static final int MEDIA_TYPE_PICTURE = 1;
      public static final int MEDIA_TYPE_SECRET_MEDIA = 11;
      public static final int MEDIA_TYPE_STICKER = 4;
      public static final int MEDIA_TYPE_TEXT = 0;
      public static final int MEDIA_TYPE_URL = 8;
      public static final int MEDIA_TYPE_VIDEO = 3;
      public static final int MEDIA_TYPE_VIDEO_PTT = 14;
      public static final int MEDIA_TYPE_WALLET = 13;
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface MessageFlags
    {
      public static final int BROADCAST_LIST = 131072;
      public static final int BUSINESS_INBOX_EXCLUDE = 1048576;
      public static final int DELIVERED_MESSAGE = 32;
      public static final int DONT_ACK = 512;
      public static final int EXTERNAL_APP_MESSAGE = 1024;
      public static final int GROUP_JOINED_BY_LINK = 65536;
      public static final int JOIN_MESSAGE = 4;
      public static final int LAST_IN_CHAT = 128;
      public static final int LIKE_MY_MESSAGE = 8192;
      public static final int NOTIF_SEC_ACTIVATE = 256;
      public static final int OVERLAY_EXCLUDE = 2097152;
      public static final int PENDING_UPGRADE = 2048;
      public static final int PG_FORWARDED_MESSAGE = 16384;
      public static final int PIN_ADDED = 262144;
      public static final int PIN_DELETED = 524288;
      public static final int PUSH_WAS_SENT = 2;
      public static final int READ_MESSAGE = 64;
      public static final int SECURE_MESSAGE = 4096;
      public static final int SELF_ADDED_MESSAGE = 1;
      public static final int SEND_SECURITY_ATTR = 32768;
      public static final int SENT_MESSAGE = 16;
      public static final int SILENT_MESSAGE = 8;
      public static final int SYSTEM_MESSAGE = 1;
      public static final int VIBER_LOCAL_NUMBER = 4194304;
    }
  }

  public static final class std
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.ClientConstants
 * JD-Core Version:    0.6.2
 */