package com.viber.jni;

public class NetDefines
{
  public static class CChangeConversationSettingsReplyState
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static class CChangeUserActivitySettingsReplyState
  {
    public static final int NOT_REG = 0;
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static class CallState
  {
    public static final int CALL_ESTABLISHED = 1;
    public static final int NO_CALL;
  }

  public static class CellularNetworkType
  {
    public static final int CELLULAR_TYPE_1xRTT = 2751;
    public static final int CELLULAR_TYPE_CDMA = 2000;
    public static final int CELLULAR_TYPE_CDMA1x = 2752;
    public static final int CELLULAR_TYPE_EDGE = 2750;
    public static final int CELLULAR_TYPE_EVDO_0 = 3001;
    public static final int CELLULAR_TYPE_EVDO_A = 3002;
    public static final int CELLULAR_TYPE_EVDO_B = 3003;
    public static final int CELLULAR_TYPE_GPRS = 2500;
    public static final int CELLULAR_TYPE_HSDPA = 3500;
    public static final int CELLULAR_TYPE_HSPA = 3006;
    public static final int CELLULAR_TYPE_HSPAP = 3502;
    public static final int CELLULAR_TYPE_HSUPA = 3501;
    public static final int CELLULAR_TYPE_IDEN = 2001;
    public static final int CELLULAR_TYPE_LTE = 4000;
    public static final int CELLULAR_TYPE_NONE = 1;
    public static final int CELLULAR_TYPE_UMTS = 3000;
    public static final int CELLULAR_TYPE_UNKNOWN = 0;
    public static final int CELLULAR_TYPE_WCDMA = 3005;
    public static final int CELLULAR_TYPE_eHRPD = 3004;
  }

  public static class DTMFEvent
  {
    public static final int dtmf0 = 0;
    public static final int dtmf1 = 1;
    public static final int dtmf2 = 2;
    public static final int dtmf3 = 3;
    public static final int dtmf4 = 4;
    public static final int dtmf5 = 5;
    public static final int dtmf6 = 6;
    public static final int dtmf7 = 7;
    public static final int dtmf8 = 8;
    public static final int dtmf9 = 9;
    public static final int dtmfA = 12;
    public static final int dtmfB = 13;
    public static final int dtmfC = 14;
    public static final int dtmfD = 15;
    public static final int dtmfFlash = 16;
    public static final int dtmfPound = 11;
    public static final int dtmfStar = 10;
  }

  public static class DialFlags
  {
    public static final int EFLAG_BUSY_GSM = 1;
    public static final int EFLAG_BUSY_VIBER = 2;
  }

  public static class DialStatus
  {
    public static final int DIAL_BUSY = 1;
    public static final int DIAL_CALL_FAILED = 7;
    public static final int DIAL_GSM = 2;
    public static final int DIAL_IGNORED = 5;
    public static final int DIAL_INVALID_NUMBER = 6;
    public static final int DIAL_NO_ACCOUNT = 16;
    public static final int DIAL_NO_CREDIT = 15;
    public static final int DIAL_NO_SPIRIT = 9;
    public static final int DIAL_OK = 0;
    public static final int DIAL_RINGING = 4;
    public static final int DIAL_STALE = 10;
    public static final int DIAL_STALE_AND_BUSY = 11;
    public static final int DIAL_TEXT_ONLY = 8;
    public static final int DIAL_TIMEOUT = 3;
    public static final int DIAL_UNAVAILABLE = 12;
    public static final int DIAL_UNKNOWN = 13;
    public static final int DIAL_UNSUPPORTED = 14;
  }

  public static class EBackgroundState
  {
    public static final int BG_BACKGROUND = 1;
    public static final int BG_FOREGROUND;
  }

  public static class ECallQuality
  {
    public static final int QUALITY_AVERAGE = 1;
    public static final int QUALITY_CONNECTION_LOST = 3;
    public static final int QUALITY_EXCELLENT = 0;
    public static final int QUALITY_POOR = 2;
  }

  public static class EConnectionState
  {
    public static final int CS_CONNECTED = 3;
    public static final int CS_CONNECTING = 1;
    public static final int CS_DISCONNECTED = 0;
    public static final int CS_FAILED_CONNECT = 2;
  }

  public static class EContactSavedInConversationStatus
  {
    public static final int FAILED = 1;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  public static class EDeviceRole
  {
    public static final int DEVICE_ROLE_PRIMARY = 0;
    public static final int DEVICE_ROLE_SECONDARY = 1;
  }

  public static class EDialogReplyType
  {
    public static final int DIALOG_TYPE_UNKNOWN = 0;
    public static final int REPLY_TYPE_CANCEL = 2;
    public static final int REPLY_TYPE_OK = 1;
  }

  public static class EDialogType
  {
    public static final int DIALOG_TYPE_ERROR = 6;
    public static final int DIALOG_TYPE_NO_SPIRIT = 2;
    public static final int DIALOG_TYPE_SWITCH2GSM = 1;
    public static final int DIALOG_TYPE_TEXT_ONLY = 3;
    public static final int DIALOG_TYPE_UNAVAILABLE = 4;
    public static final int DIALOG_TYPE_UNKNOWN = 0;
    public static final int DIALOG_TYPE_WARNING = 5;
  }

  public static class ELoginReplyType
  {
    public static final int LOGIN_FAILED = 1;
    public static final int LOGIN_OK = 0;
    public static final int USER_NOT_REGISTERED = 2;
  }

  public static class ENetType
  {
    public static final int NET_TYPE_3G = 1;
    public static final int NET_TYPE_UNKNOWN = 0;
    public static final int NET_TYPE_WIFI = 2;
  }

  public static class ENetworkError
  {
    public static final int NoDataFromPeer = 0;
    public static final int NoHandshake = 2;
    public static final int NoNetwork = 1;
  }

  public static class ENetworkStatus
  {
    public static final int NetworkNotReachable = 0;
    public static final int NetworkReachableViaWWAN = 2;
    public static final int NetworkReachableViaWiFi = 1;
    public static final int NetworkUnknown = 3;
  }

  public static class EPhoneType
  {
    public static final int PHONE_TYPE_3G = 1;
    public static final int PHONE_TYPE_3GS = 2;
    public static final int PHONE_TYPE_ANDROID = 4096;
    public static final int PHONE_TYPE_ANDROID_ARMV6 = 4097;
    public static final int PHONE_TYPE_I4 = 3;
    public static final int PHONE_TYPE_INVALID;
  }

  public static class EPixieMode
  {
    public static final int PIXIE_OFF = 0;
    public static final int PIXIE_ON = 1;
    public static final int PIXIE_ON_UDP_ONLY = 2;
  }

  public static class EReadNotificationSetting
  {
    public static final int READ_NOTIFICATION_OFF = 0;
    public static final int READ_NOTIFICATION_ON = 1;
  }

  public static class ERecoverGroupsReplyFlags
  {
    public static final int NO_GROUPS = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static class ERegisterState
  {
    public static final int FAILED = 2;
    public static final int OK = 0;
    public static final int PUSH_CHANGED = 1;
  }

  public static class EState
  {
    public static final int FAIL = 0;
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static class EStatus
  {
    public static final int ST_ACCESS_DENIED = 18;
    public static final int ST_ALREADY_CONNECTED = 33;
    public static final int ST_ALREADY_EXISTS = 31;
    public static final int ST_AUTH_FAILED = 16;
    public static final int ST_AUTH_SUCCEEDED = 17;
    public static final int ST_BAD_ADDRESS = 30;
    public static final int ST_CLOSE_CONNECTION = 42;
    public static final int ST_COMMUNICATION_ERROR = 4;
    public static final int ST_CONNECTION_CLOSED = 23;
    public static final int ST_CONN_REFUSED = 39;
    public static final int ST_CONN_RESET = 38;
    public static final int ST_DUPLICATE = 11;
    public static final int ST_FAIL = 1;
    public static final int ST_FILE_NOT_FOUND = 41;
    public static final int ST_HANGUP = 20;
    public static final int ST_INTERNAL_ERROR = 2;
    public static final int ST_INVALID_MESSAGE = 22;
    public static final int ST_INVALID_PARAM = 10;
    public static final int ST_INVALID_SOCKET = 32;
    public static final int ST_IN_PROGRESS = 28;
    public static final int ST_IN_USE = 35;
    public static final int ST_IO_ERROR = 29;
    public static final int ST_LAST = 47;
    public static final int ST_MORE_DATA = 7;
    public static final int ST_NET_DOWN = 45;
    public static final int ST_NEW_CONNECTION = 12;
    public static final int ST_NOT_CONNECTED = 34;
    public static final int ST_NOT_FOUND = 6;
    public static final int ST_NOT_IMPLEMENTED = 15;
    public static final int ST_NOT_SUPPORTED = 46;
    public static final int ST_NOT_UPDATED = 44;
    public static final int ST_NO_MEMORY = 5;
    public static final int ST_NO_MORE_DATA = 8;
    public static final int ST_NO_REACH = 19;
    public static final int ST_OUT_OF_BOUNDS = 27;
    public static final int ST_OUT_OF_SYNC = 36;
    public static final int ST_PENDING_CONNECTION = 13;
    public static final int ST_QUEUE_FULL = 3;
    public static final int ST_RECONNECTION = 14;
    public static final int ST_SOCKET_ERROR = 21;
    public static final int ST_SUCCESS = 0;
    public static final int ST_TERMINATE = 43;
    public static final int ST_TIMEOUT = 9;
    public static final int ST_TOO_MANY_FILES = 25;
    public static final int ST_TOO_MANY_SOCKETS = 25;
    public static final int ST_TOO_MANY_THREADS = 37;
    public static final int ST_TRY_LATER = 26;
    public static final int ST_VERSION_EXPIRED = 24;
    public static final int ST_WOULD_BLOCK = 40;
  }

  public static class ETestConnectionReason
  {
    public static final int REASON_CONN_APPMODE_CHANGE = 4;
    public static final int REASON_CONN_CONNECTIVITY_CHANGE = 2;
    public static final int REASON_CONN_OTHER = 0;
    public static final int REASON_CONN_TIMEOUT = 1;
    public static final int REASON_CONN_TIMER = 3;
  }

  public static class EUserActivitySetting
  {
    public static final int USER_ACTIVITY_OFF = 0;
    public static final int USER_ACTIVITY_ON = 1;
  }

  public static class EViberOutSplash
  {
    public static final int VO_TRIAL_CALL_SPLASH = 0;
    public static final int VO_TRIAL_ENDED_SPLASH = 2;
    public static final int VO_TRIAL_SPLASH = 1;
  }

  public static class GSMState
  {
    public static final int GSM_CALL = 1;
    public static final int NO_GSM_CALL;
  }

  public static class LastSeenSetting
  {
    public static final int LAST_SEEN_OFF = 0;
    public static final int LAST_SEEN_ON = 1;
  }

  public static class LastSeenSettingReplyState
  {
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static class MediaType
  {
    public static final int MEDIA_TYPE_ANIMATED_MESSAGE = 6;
    public static final int MEDIA_TYPE_AUDIO = 2;
    private static final int MEDIA_TYPE_BASE_ID = 999;
    public static final int MEDIA_TYPE_CALL = 1002;
    public static final int MEDIA_TYPE_CONTACT = 9;
    public static final int MEDIA_TYPE_FILE = 10;
    public static final int MEDIA_TYPE_FORMATTED_MESSAGE = 7;
    public static final int MEDIA_TYPE_GIF_FILE = 1005;
    public static final int MEDIA_TYPE_LOCATION = 5;
    public static final int MEDIA_TYPE_NOTIFICATION = 1000;
    public static final int MEDIA_TYPE_PA = 12;
    public static final int MEDIA_TYPE_PA_RICH_MESSAGE = 1006;
    public static final int MEDIA_TYPE_PICTURE = 1;
    public static final int MEDIA_TYPE_SECRET_MEDIA = 11;
    public static final int MEDIA_TYPE_SMS = 1001;
    public static final int MEDIA_TYPE_STICKER = 4;
    public static final int MEDIA_TYPE_TEXT = 0;
    public static final int MEDIA_TYPE_URL = 8;
    public static final int MEDIA_TYPE_VIDEO = 3;
    public static final int MEDIA_TYPE_VIDEO_PTT = 14;
    public static final int MEDIA_TYPE_WALLET = 13;
    public static final int MEDIA_TYPE_WINK_IMAGE = 1003;
    public static final int MEDIA_TYPE_WINK_VIDEO = 1004;
  }

  public static class MessageFlags
  {
    public static final int BROADCAST_LIST = 131072;
    public static final int DELIVERED_MESSAGE = 32;
    public static final int DONT_ACK = 512;
    public static final int EXTERNAL_APP_MESSAGE = 1024;
    public static final int GROUP_JOINED_BY_LINK = 65536;
    public static final int JOIN_MESSAGE = 4;
    public static final int LAST_IN_CHAT = 128;
    public static final int LIKE_MY_MESSAGE = 8192;
    public static final int NOTIF_SEC_ACTIVATE = 256;
    public static final int PENDING_UPGRADE = 2048;
    public static final int PG_FORWARDED_MESSAGE = 16384;
    public static final int PIN_ADDED = 262144;
    public static final int PIN_DELETED = 524288;
    public static final int PUSH_WAS_SENT = 2;
    public static final int READ_MESSAGE = 64;
    public static final int REGULAR_MESSAGE = 0;
    public static final int SECURE_MESSAGE = 4096;
    public static final int SELF_ADDED_MESSAGE = 1;
    public static final int SEND_SECURITY_ATTR = 32768;
    public static final int SENT_MESSAGE = 16;
    public static final int SILENT_MESSAGE = 8;
    public static final int SYSTEM_MESSAGE = 1;
  }

  public static class MultiDeviceFlags
  {
    public static final int DELETED = 2;
    public static final int FORCE_DELETE = 32;
    public static final int MULT_DEV_FLAGS_MESSAGE_SEEN_BY_ENTIRE_GROUP = 16;
    public static final int MULT_DEV_FLAGS_MESSAGE_SEEN_BY_FIRST_MEMBER = 64;
    public static final int READ = 1;
    public static final int READ_LIKES_ONLY = 8;
    public static final int READ_NOTIFICATION = 4;
  }

  public static class MultiDeviceState
  {
    public static final int NOT_REG = 0;
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static class SelfUserDetailsUpdateFlags
  {
    public static final int SELF_USER_DETAILS_NAME_UPDATE = 2;
    public static final int SELF_USER_DETAILS_NO_UPDATE = 0;
    public static final int SELF_USER_DETAILS_PHOTO_UPDATE = 1;
  }

  public static class Tone
  {
    public static final int BUSY_TONE = 1;
    public static final int HANGUP_TONE = 3;
    public static final int NO_TONE = 0;
    public static final int RINGBACK_TONE = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.NetDefines
 * JD-Core Version:    0.6.2
 */