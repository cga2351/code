package com.viber.jni;

public class ClientMessages
{
  public static final int EMPTY_LAST_MESSAGE_ID = 0;
  public static final int EMPTY_WATCHER_COUNT = -1;
  public static final int GROUP_DEFAULT_REVISION = 1;

  public static class BannerEvent
  {
    public static final int BANNER_DISMISSED = 1;
    public static final int BANNER_DISPLAYED = 0;
    public static final int CLICKED_ON_BANNER = 2;
    public static final int CLICKED_ON_BUTTON = 3;
  }

  public static class CBlockAppMsgFlags
  {
    public static final int NONE = 0;
    public static final int OVERLAY_ACTION = 1;
    public static final int OVERLAY_X_BUTTON = 2;
  }

  public static class CChangeGroupAttributesReplyMsgStatus
  {
    public static final int CREATE_PA_NOT_SUPPORTED = 12;
    public static final int EMAIL_NOT_VALID = 10;
    public static final int FAILED = 7;
    public static final int GROUP_NON_EXISTENT = 5;
    public static final int GROUP_OLD_REVISION = 6;
    public static final int NAME_FORBIDDEN = 8;
    public static final int NOT_REG = 3;
    public static final int NO_PRIVILEDGES = 2;
    public static final int OK = 1;
    public static final int TAGLINE_FORBIDDEN = 9;
    public static final int TIMEOUT = 4;
    public static final int WEBSITE_NOT_VALID = 11;
  }

  public static class CChangeSettingsReplyMsgStatus
  {
    public static final int FAIL = 0;
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static class CCreateGroupReplyMsgMemberStatus
  {
    public static final int GROUP_MEMBER_FAILED = 4;
    public static final int GROUP_MEMBER_INSECURE = 5;
    public static final int GROUP_MEMBER_INVALID_NUMBER = 3;
    public static final int GROUP_MEMBER_NOT_REG = 1;
    public static final int GROUP_MEMBER_NO_GROUPS = 2;
    public static final int GROUP_MEMBER_OK = 0;
    public static final int GROUP_MEMBER_OUTDATED_DEVICE_LIST = 6;
    public static final int GROUP_MEMBER_UNSUPPORTED_SECRET_CHAT = 7;
  }

  public static class CCreateGroupReplyMsgStatus
  {
    public static final int CREATE_GROUP_FAILED = 2;
    public static final int CREATE_GROUP_NOT_ENOUGH_VIBER_NUM = 1;
    public static final int CREATE_GROUP_OK = 0;
    public static final int CREATE_GROUP_TIMEOUT = 4;
    public static final int CREATE_GROUP_TOO_MANY_MEMBERS = 3;
    public static final int CREATE_GROUP_URL_NOT_UNIQUE = 5;
  }

  public static class CCreatePublicAccountReplyEState
  {
    public static final int CREATE_PA_EMAIL_NOT_VALID = 7;
    public static final int CREATE_PA_FAILED = 1;
    public static final int CREATE_PA_NAME_FORBIDDEN = 5;
    public static final int CREATE_PA_NOT_SUPPORTED = 9;
    public static final int CREATE_PA_OK = 0;
    public static final int CREATE_PA_TAGLINE_FORBIDDEN = 6;
    public static final int CREATE_PA_TIMEOUT = 2;
    public static final int CREATE_PA_TOO_MANY_MEMBERS = 3;
    public static final int CREATE_PA_URI_NOT_UNIQUE = 4;
    public static final int CREATE_PA_WEBSITE_NOT_VALID = 8;
  }

  public static class CDeleteGlobalMessageReplyState
  {
    public static final int FAILED = 2;
    public static final int NO_PRIVILEGES = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static class CDeleteMessageReplyMsgStatus
  {
    public static final int FAILED = 3;
    public static final int NOT_REG = 1;
    public static final int OK = 0;
    public static final int PUBLIC_GROUP_ERROR = 4;
    public static final int TIMEOUT = 2;
  }

  public static class CGetAppDetailsReplyStatus
  {
    public static final int FAIL = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static class CGetGroupInfoReplyMsgFlags
  {
    public static final int GROUP_FLAGS_NO_SMART_NOTIFICATION = 1;
    public static final int GROUP_FLAGS_SECRET_CHAT = 4;
    public static final int GROUP_FLAGS_SECURE_GROUP = 2;
    public static final int GROUP_FLAGS_SMART_NOTIFICATION;
  }

  public static class CGetGroupInfoReplyMsgStatus
  {
    public static final int GROUP_REPLY_FAIL = 3;
    public static final int GROUP_REPLY_NOT_IN_GROUP = 1;
    public static final int GROUP_REPLY_OK = 0;
    public static final int GROUP_REPLY_TIMEOUT = 2;
  }

  public static class CGetGroupMessageStatusMsgStatus
  {
    public static final int GROUP_MESSAGE_STATUS_MESSAGE_TOO_OLD = 2;
    public static final int GROUP_MESSAGE_STATUS_NO_DATA = 1;
    public static final int GROUP_MESSAGE_STATUS_OK;
  }

  public static class CGetGroupMessageStatusReplyMsgStatus
  {
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_FAILURE = 1;
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_GROUP_NOT_FOUND = 4;
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_INVALID_DATA = 3;
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_OK = 0;
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_TIMEOUT = 2;
  }

  public static class CGetPublicAccountInfoReplyEState
  {
    public static final int FAILED = 2;
    public static final int NOT_AUTH = 4;
    public static final int NOT_IN_GROUP = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static class CGetPublicAccountSubscribersCountReplyMsgEState
  {
    public static final int BAD_PA_ID = 1;
    public static final int FAILED = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static class CGetUserMemberIDsReplyStatus
  {
    public static final int FAIL = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static class CGroupAddMemberReplyMsgStatus
  {
    public static final int GROUP_MEMBER_ADD_OK = 1;
    public static final int GROUP_MEMBER_ALREADY_IN_GROUP = 4;
    public static final int GROUP_MEMBER_FAILED = 6;
    public static final int GROUP_MEMBER_INSECURE = 8;
    public static final int GROUP_MEMBER_NOT_VIBER = 2;
    public static final int GROUP_MEMBER_NO_GROUPS = 3;
    public static final int GROUP_MEMBER_SECURE_PEER_LIST_INVALID = 9;
    public static final int GROUP_MEMBER_TIMEOUT = 7;
    public static final int GROUP_MEMBER_TOO_MANY_MEMBERS = 5;
    public static final int GROUP_MEMBER_UNSUPPORTED_SECRET_CHAT = 10;
  }

  public static class CGroupAddMembersReplyMsgStatus
  {
    public static final int GROUP_ADD_FAILED = 5;
    public static final int GROUP_ADD_NOT_IN_GROUP = 4;
    public static final int GROUP_ADD_NOT_VIBER = 1;
    public static final int GROUP_ADD_NO_RIGHTS = 2;
    public static final int GROUP_ADD_OK = 0;
    public static final int GROUP_ADD_TIMEOUT = 6;
    public static final int GROUP_ADD_TOO_MANY_MEMBERS = 3;
  }

  public static class CGroupAddWatchersReplyMsgStatus
  {
    public static final int GROUP_ADD_TOO_MANY_GROUPS = 4;
    public static final int GROUP_ADD_WATCHERS_ALREADY_WATCHING = 2;
    public static final int GROUP_ADD_WATCHERS_BANNED = 7;
    public static final int GROUP_ADD_WATCHERS_BLOCKED = 8;
    public static final int GROUP_ADD_WATCHERS_FAILED = 5;
    public static final int GROUP_ADD_WATCHERS_NOT_IN_GROUP = 3;
    public static final int GROUP_ADD_WATCHERS_NOT_VIBER = 1;
    public static final int GROUP_ADD_WATCHERS_OK = 0;
    public static final int GROUP_ADD_WATCHERS_TIMEOUT = 6;
  }

  public static class CGroupAssignRoleReplyStatus
  {
    public static final int ALREADY_TAKEN = 4;
    public static final int FAILED = 5;
    public static final int NOT_EXPECTED_IN_FLOW = 7;
    public static final int NOT_IN_GROUP = 3;
    public static final int NOT_VIBER = 1;
    public static final int NO_RIGHTS = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 6;
  }

  public static class CGroupAttributesChangedFlags
  {
    public static final int AUTH_TOKEN_CHANGED = 32768;
    public static final int BACKGROUND_ID_CHANGED = 4;
    public static final int CATEGORY_CHANGED = 512;
    public static final int COUNTRY_CHANGED = 64;
    public static final int CRM_NAME_CHANGED = 2048;
    public static final int EMAIL_CHANGED = 8192;
    public static final int FLAGS_CHANGED = 128;
    public static final int GROUP_NAME_CHANGED = 1;
    public static final int ICON_ID_CHANGED = 2;
    public static final int JOCKER_BUTTON_CHANGED = 16384;
    public static final int LOCATION_CHANGED = 32;
    public static final int TAGLINE_CHANGED = 8;
    public static final int TAGS_CHANGED = 16;
    public static final int URI_CHANGED = 256;
    public static final int WEBHOOK_EXIST_CHANGED = 1024;
    public static final int WEBSITE_CHANGED = 4096;
  }

  public static class CGroupChangedMsgStatus
  {
    public static final int COMMUNITY_DISPLAY_INVITATION_LINK = 17;
    public static final int COMMUNITY_PRIVILEGES_CHANGED = 18;
    public static final int GROUP_BLOCK = 7;
    public static final int GROUP_CHANGE_ATTRIBUTES = 3;
    public static final int GROUP_CHANGE_NAME = 0;
    public static final int GROUP_DELETE_ALL_MESSAGES_FROM_USER = 16;
    public static final int GROUP_DELETE_MESSAGE = 9;
    public static final int GROUP_INVALID_CHANGE = 99;
    public static final int GROUP_MEMBER_ADDED = 1;
    public static final int GROUP_MEMBER_ADDED_MEMBERS = 4;
    public static final int GROUP_MEMBER_ADDED_WATCHER = 5;
    public static final int GROUP_MEMBER_BAN_STATE_CHANGED = 19;
    public static final int GROUP_MEMBER_IDENTITY_CHANGED = 14;
    public static final int GROUP_MEMBER_LEFT = 2;
    public static final int GROUP_MEMBER_LEFT_WATCHER = 6;
    public static final int GROUP_MEMBER_REMOVED = 11;
    public static final int GROUP_MEMBER_ROLE_CHANGED = 10;
    public static final int GROUP_MEMBER_SUBSCRIPTION_CHANGED = 15;
    public static final int GROUP_MEMBER_UPDATE_PHOTO = 8;
    public static final int GROUP_RECOVER_SECURITY = 13;
    public static final int GROUP_SECURITY_CHANGED = 12;
    public static final int MY_COMMUNITY_SETTINGS_CHANGED = 20;
  }

  public static class CGroupLeaveReplyMsgStatus
  {
    public static final int GROUP_LEAVE_OK = 1;
    public static final int NOT_IN_GROUP = 2;
    public static final int TIMEOUT = 3;
  }

  public static class CGroupRemoveMembersReplyStatus
  {
    public static final int FAILED = 4;
    public static final int NOT_IN_GROUP = 3;
    public static final int NOT_VIBER = 1;
    public static final int NO_RIGHTS = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 5;
  }

  public static class CLikeGroupMessageReplyStatus
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static class CMessageReceivedAckFlags
  {
    public static final int ACK_PRE_ACK = 1;
    public static final int G2_INVITER_NOT_IN_ADDRESS_BOOK = 64;
    public static final int M2M_SENDER_NOT_IN_ADDRESS_BOOK = 32;
    public static final int MESSAGE_NOT_DISPLAYED_BY_CLIENT = 16;
    public static final int MESSAGE_NOT_SHOWN = 2;
    public static final int NO_ACK_FLAGS = 0;
    public static final int SENDER_INVALID_MEMBER_ID = 8;
    public static final int SENDER_NOT_IN_ADDRESS_BOOK = 4;
  }

  public static class CPublicAccountSubscriberUpdateReplyEState
  {
    public static final int FAILED = 1;
    public static final int MISSING_WEBHOOK = 6;
    public static final int OK = 0;
    public static final int PUBLIC_ACCOUNT_BLOCKED = 5;
    public static final int PUBLIC_ACCOUNT_NOT_EXIST = 3;
    public static final int PUBLIC_ACCOUNT_SUSPENDED = 7;
    public static final int SUBSCRIBER_IS_NOT_VIBER = 4;
    public static final int TIMEOUT = 2;
  }

  public static class CQueryDestOperationSupportOperation
  {
    public static final int QDOS_OP_INSTANT_VIDEO = 3;
    public static final int QDOS_OP_SECRET_CHAT = 4;
    public static final int QDOS_OP_SEND_FILE = 1;
    public static final int QDOS_OP_UNUSED = 0;
    public static final int QDOS_OP_WINK_MESSAGE = 2;
  }

  public static class CRecoverGroupChatsReplyMsgFlags
  {
    public static final int MUTE = 1;
    public static final int NOT_SMART = 2;
  }

  public static class CRecoverGroupChatsReplyMsgStatus
  {
    public static final int NO_GROUPS = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static class CRefreshPublicAccountTokenReplyMsgEState
  {
    public static final int FAILED = 2;
    public static final int NOT_ADMIN = 4;
    public static final int NOT_IN_GROUP = 3;
    public static final int OK = 0;
    public static final int PUBLIC_ACCOUNT_BLOCKED = 6;
    public static final int PUBLIC_ACCOUNT_NOT_FOUND = 5;
    public static final int PUBLIC_ACCOUNT_SUSPENDED = 7;
    public static final int TIMEOUT = 1;
  }

  public static class CSendActionOnPGReplyMsgStatus
  {
    public static final int PG_SEND_ACTION_FAILED = 4;
    public static final int PG_SEND_ACTION_NOT_REG = 2;
    public static final int PG_SEND_ACTION_OK = 1;
    public static final int PG_SEND_ACTION_TIMELIMIT_FAIL = 5;
    public static final int PG_SEND_ACTION_TIMEOUT = 3;
  }

  public static class CSendBannerToClientAckMsgBannerStatus
  {
    public static final int FAILED = 2;
    public static final int INVALID_FORMAT = 1;
    public static final int OK;
  }

  public static class CSendConversationStatusReplyMsgStatus
  {
    public static final int FAILED = 1;
    public static final int NOT_REG = 2;
    public static final int OK = 0;
    public static final int PUBLIC_ACCOUNT_BLOCKED = 6;
    public static final int PUBLIC_ACCOUNT_NOT_FOUND = 4;
    public static final int PUBLIC_ACCOUNT_NOT_READY = 5;
    public static final int PUBLIC_ACCOUNT_SUSPENDED = 7;
    public static final int TIMEOUT = 3;
  }

  public static class CSendMessageReplyMsgStatus
  {
    public static final int APP_INVITE_BLOCKED = 11;
    public static final int E2E_SECURE_MESSAGE_TO_INSECURE_TARGET = 12;
    public static final int E2E_SECURE_MESSAGE_WHEN_PRIMARY_INSECURE = 13;
    public static final int E2E_SECURE_PEER_LIST_INVALID = 8;
    public static final int E2E_SECURE_SELF_LIST_INVALID = 9;
    public static final int E2E_SECURE_UNSUPPORTED_MSG_TYPE = 10;
    public static final int FAILED_TO_SEND = 21;
    public static final int INVALID_PARAMETER = 22;
    public static final int INVALID_TEXT = 3;
    public static final int INVALID_TIMEBOMB = 19;
    public static final int LARGE_THUMBNAIL_SIZE_TOO_BIG = 6;
    public static final int NOT_REG = 0;
    public static final int NO_SENDING_PRIVILEGES = 20;
    public static final int OK = 1;
    public static final int PUBLIC_ACCOUNT_BLOCKED = 16;
    public static final int PUBLIC_ACCOUNT_NOT_FOUND = 14;
    public static final int PUBLIC_ACCOUNT_NOT_READY = 15;
    public static final int PUBLIC_ACCOUNT_SUSPENDED = 17;
    public static final int TEXT_SIZE_TOO_BIG = 5;
    public static final int THUMBNAIL_SIZE_TOO_BIG = 4;
    public static final int TIMEOUT = 2;
    public static final int UNSUPPORTED_MSG_TYPE_PG = 7;
    public static final int UNSUPPORTED_SECRET_CHAT = 18;
  }

  public static class CSendPublicGroupInviteType
  {
    public static final int PUBLIC_ACCOUNT = 1;
    public static final int PUBLIC_ACCOUNT_INFO = 2;
    public static final int PUBLIC_CHAT;
  }

  public static class CShareSecondaryContactReplyStatus
  {
    public static final int FAILED = 3;
    public static final int INVALID_DATA = 1;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  public static class CUpdateLanguageReplyMsgStatus
  {
    public static final int LANGUAGE_UPDATE_FAILED = 0;
    public static final int LANGUAGE_UPDATE_NOT_NEEDED = 4;
    public static final int LANGUAGE_UPDATE_NOT_SUPPORTED = 3;
    public static final int LANGUAGE_UPDATE_OK = 1;
    public static final int LANGUAGE_UPDATE_TIMEOUT = 2;
  }

  public static class CUpdateUnsavedContactDetailsFlags
  {
    public static final int NAME_UPDATE = 2;
    public static final int NO_UPDATE = 0;
    public static final int PHONE_NUMBER_CHANGED = 4;
    public static final int PHOTO_UPDATE = 1;
  }

  public static class CUpdateUserDetailsReplyMsgStatus
  {
    public static final int USER_DETAILS_CHANGE_OK = 1;
  }

  public static class CValidateGroupUriReplyMsgStatus
  {
    public static final int FAIL = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static class CValidatePublicAccountFieldsEState
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static class CValidatePublicAccountFieldsValidateStatus
  {
    public static final int INVALID_CHARS = 2;
    public static final int RESTRICTED_NAME = 3;
    public static final int URI_NOT_UNIQUE = 4;
    public static final int VALID = 0;
    public static final int VALUE_TOO_LONG = 1;
  }

  public static class ChangedFlagOperation
  {
    public static final int NO_CHANGE = 0;
    public static final int SET_FLAG = 1;
    public static final int UNSET_FLAG = 2;
  }

  public static class ClientStatus
  {
    public static final int CS_GENERAL_FAILURE = 4;
    public static final int CS_KEYBOARD_CORRUPTED = 1;
    public static final int CS_KEYBOARD_UNSUPPORTED_VERSION = 2;
    public static final int CS_MESSAGE_CONTENT_FAILURE = 3;
    public static final int CS_SERVICE_MESSAGE_BUSINESS_INBOX = 6;
    public static final int CS_SERVICE_MESSAGE_CAPPED = 5;
    public static final int CS_SUCCESS;
  }

  public static class ConversationType
  {
    public static final int CT_1ON1 = 0;
    public static final int CT_GENERAL_GROUP = 1;
    public static final int CT_PUBLIC_GROUP = 2;
  }

  public static class DisplayInvitationLink
  {
    public static final byte ADMIN = 0;
    public static final byte ALL = 1;
  }

  public static class EBlockedReason
  {
    public static final int NOT_BLOCKED = 0;
    public static final int VO_BLOCKED_CALLER = 1;
    public static final int VO_BLOCKED_DESTINATION = 2;
  }

  public static class EChatType
  {
    public static final int CHAT_CHAT_TYPE_VLN = 2;
    public static final int CHAT_TYPE_DEFAULT = 0;
    public static final int CHAT_TYPE_SECRET = 1;
  }

  public static class EClientUpgradeType
  {
    public static final int UPGRADE_FORCE = 1;
    public static final int UPGRADE_SUGGESTED = 2;
  }

  public static class EConversationStatusFlags
  {
    public static final int INLINE = 4;
    public static final int OPEN = 1;
    public static final int RESTART = 2;
  }

  public static class EDialType
  {
    public static final int DIALTYPE_CONFERENCE_ADHOC = 4;
    public static final int DIALTYPE_CONFERENCE_GROUP = 3;
    public static final int DIALTYPE_DEFAULT = 0;
    public static final int DIALTYPE_VIBER_OUT = 1;
    public static final int DIALTYPE_VIBER_OUT_TRIAL = 2;
    public static final int DIALTYPE_VIDEO_CALL = 5;
  }

  public static class EFailedMemberStatus
  {
    public static final int MEMBER_BUSY = 4;
    public static final int MEMBER_FAILED = 1;
    public static final int MEMBER_NOT_REG = 2;
    public static final int MEMBER_OK = 0;
    public static final int MEMBER_UNSUPPORTED_VERSION = 3;
  }

  public static class EFeedState
  {
    public static final int FEED_DEFAULT_TAB_FEED = 4;
    public static final int FEED_GENERIC_ENABLED = 1;
    public static final int FEED_NOT_ENABLED = 0;
    public static final int FEED_PERSONAL_ENABLED = 2;
  }

  public static class EForwardedFlags
  {
    public static final int FORWARDED = 1;
    public static final int NOT_FORWARDED = 0;
    public static final int PG_FORWARDED = 2;
  }

  public static class EGroupAddMemberStatus
  {
    public static final int GROUP_MEMBER_BANNED = 13;
    public static final int GROUP_MEMBER_STATUS_ADD_OK = 1;
    public static final int GROUP_MEMBER_STATUS_ALREADY_IN_GROUP = 3;
    public static final int GROUP_MEMBER_STATUS_FAILED = 5;
    public static final int GROUP_MEMBER_STATUS_NOT_IN_GROUP = 8;
    public static final int GROUP_MEMBER_STATUS_NOT_VIBER = 2;
    public static final int GROUP_MEMBER_STATUS_NO_VERSION_SUPPORT = 4;
    public static final int GROUP_MEMBER_STATUS_SYSTEM_NOT_SUPPORTED = 7;
    public static final int GROUP_MEMBER_STATUS_TOO_MANY_GROUPS = 6;
  }

  public static class EGroupRole
  {
    public static final int GROUP_ROLE_ADMINISTRATOR = 2;
    public static final int GROUP_ROLE_LIMITED_MEMBER = 4;
    public static final int GROUP_ROLE_MEMBER = 1;
    public static final int GROUP_ROLE_OLD_MEMBER = 0;
    public static final int GROUP_ROLE_WATCHER = 3;
  }

  public static class EGroupType
  {
    public static final int GROUP_TYPE_2 = 3;
    public static final int GROUP_TYPE_GENERAL = 0;
    public static final int GROUP_TYPE_PUBLIC = 1;
    public static final int GROUP_TYPE_PUBLIC_BLOG = 2;
  }

  public static class EMissedCallConferenceState
  {
    public static final int CONFERENCE_ANSWERED_ON_ANOTHER_DEVICE = 3;
    public static final int CONFERENCE_ENDED = 1;
    public static final int CONFERENCE_IN_PROGRESS = 0;
    public static final int CONFERENCE_MISSED = 2;
  }

  public static class ENotificationFlags
  {
    public static final int NF_BADGE_APP_ICONS_NOTIFICATIONS = 8;
    public static final int NF_GENERAL_NOTIFICATIONS = 2;
    public static final int NF_NOTIFICATIONS_OFF = 1;
    public static final int NF_NOTIFICATIONS_UNKNOWN = 0;
    public static final int NF_SHOW_ON_LOCKSCREEN_NOTIFICATIONS = 16;
    public static final int NF_SOUNDS_NOTIFICATIONS = 4;
  }

  public static class EPgSearchFlags
  {
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

  public static class EPublicAccountFields
  {
    public static final int PA_ABOUT = 3;
    public static final int PA_EMAIL = 5;
    public static final int PA_NAME = 2;
    public static final int PA_URI = 1;
    public static final int PA_WEBSITE = 4;
  }

  public static class EPublicChatState
  {
    public static final int PUBLIC_CHAT_FULL_BLOCK = 3;
    public static final int PUBLIC_CHAT_FULL_SUPPORT = 2;
    public static final int PUBLIC_CHAT_NOT_SUPPORTED = 0;
    public static final int PUBLIC_CHAT_USE_ONLY = 1;
  }

  public static class ESecretChatEvent
  {
    public static final int CHAT_START = 0;
    public static final int SCREEN_SHOT = 2;
    public static final int TIMEBOMB_CHANGE = 1;
  }

  public static class ESelectedCDROption
  {
    public static final int NEW_PERSON = 2;
    public static final int PERSON_DELIVERED_IN_PAST = 3;
    public static final int PERSON_IN_PHONEBOOK = 1;
    public static final int RECENT_TRANSACTION_SCREENS = 4;
  }

  public static class ESendMessageExFlags
  {
    public static final long SM_EX_ADD_PIN = 1L;
    public static final long SM_EX_DELETE_PIN = 2L;
    public static final long SM_EX_MENTION = 4L;
    public static final long SM_G2_INVITE = 8L;
  }

  public static class ESendMessageFlags
  {
    public static final int NONE = 0;
    public static final int SM_BROADCAST_LIST = 128;
    public static final int SM_DOODLE = 2;
    public static final int SM_DOODLE_PICTURE = 1;
    public static final int SM_FORWARDED = 4;
    public static final int SM_PG_FORWARDED = 8;
    public static final int SM_RESEND = 16;
    public static final int SM_WINK_PICTURE = 32;
    public static final int SM_WINK_VIDEO = 64;
  }

  public static class ESendPGInviteStatus
  {
    public static final int INVITE_FAILURE = 1;
    public static final int INVITE_SUCCESS = 0;
    public static final int INVITE_TIMEOUT = 2;
  }

  public static class ESyncFlags
  {
    public static final int SYNC_FLAG_CLEAR_MSG = 4;
    public static final int SYNC_FLAG_NO_PUSH = 2;
    public static final int SYNC_FLAG_PRIMARY_ONLY = 1;
  }

  public static class EViberOutGroup
  {
    public static final int VO_DISABLED = 0;
    public static final int VO_ENABLED = 1;
    public static final int VO_TRIAL = 3;
    public static final int VO_TRIAL_CALL = 2;
  }

  public static class EVideoStartReason
  {
    public static final int VIDEO_ANSWER = 4;
    public static final int VIDEO_CALL = 0;
    public static final int VIDEO_START_REQUEST = 1;
    public static final int VIDEO_TRANSFERRED = 2;
    public static final int VIDEO_UNHOLD = 3;
  }

  public static class EVideoStopReason
  {
    public static final int VIDEO_BACKGROUND = 3;
    public static final int VIDEO_CALL_ENDED = 8;
    public static final int VIDEO_DATA_INTERRUPTION = 9;
    public static final int VIDEO_ERROR = 0;
    public static final int VIDEO_HOLD = 1;
    public static final int VIDEO_LOW_BANDWIDTH = 6;
    public static final int VIDEO_NO_CAMERA = 11;
    public static final int VIDEO_PEER_CAPABILITIES = 10;
    public static final int VIDEO_PEER_HOLD = 2;
    public static final int VIDEO_PEER_REQUEST = 5;
    public static final int VIDEO_PEER_TRANSFER = 7;
    public static final int VIDEO_USER_REQUEST = 4;
  }

  public static class EWalletStatus
  {
    public static final int WALLET_BAD_DATA = 3;
    public static final int WALLET_BAD_SERVICE_ID = 2;
    public static final int WALLET_INTERNAL_FAILURE = 1;
    public static final int WALLET_NOT_PERMITTED = 7;
    public static final int WALLET_NOT_VIBER_USER = 4;
    public static final int WALLET_NO_SUITABLE_DEVICE = 5;
    public static final int WALLET_SUCCESS = 0;
    public static final int WALLET_TIMEOUT = 6;
  }

  public static class GroupLikesStatus
  {
    public static final int GROUP_LIKE_FAIL = 3;
    public static final int GROUP_LIKE_NO_GROUP = 1;
    public static final int GROUP_LIKE_OK = 0;
    public static final int GROUP_LIKE_TIMEOUT = 2;
  }

  public static class GroupMessagesStatus
  {
    public static final int GROUP_MESSAGES_FAIL = 2;
    public static final int GROUP_MESSAGES_NO_GROUP = 1;
    public static final int GROUP_MESSAGES_OK = 0;
    public static final int GROUP_MESSAGES_TIMEOUT = 3;
  }

  public static class GroupSearchStatus
  {
    public static final int PG_SEARCH_FAIL = 1;
    public static final int PG_SEARCH_OK = 0;
    public static final int PG_SEARCH_TIMEOUT = 2;
  }

  public static class PGGeneralQueryStatus
  {
    public static final int GENERAL_QUERY_BAD_ACCESS_TOKEN = 3;
    public static final int GENERAL_QUERY_FAIL = 1;
    public static final int GENERAL_QUERY_OK = 0;
    public static final int GENERAL_QUERY_TIMEOUT = 2;
  }

  public static class PersonalProfileStatus
  {
    public static final int FAIL = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static class QueryDestOperationSupportReplyFlags
  {
    public static final int QDOS_FL_SUPPORTED = 1;
    public static final int QDOS_FL_UNSUPPORTED;
  }

  public static class QueryDestOperationSupportReplyStatus
  {
    public static final int QDOS_ST_FAIL = 0;
    public static final int QDOS_ST_SUCCESS = 1;
    public static final int QDOS_ST_TIMEOUT = 2;
  }

  public static class SendMessageFlags
  {
    public static final int DONT_SHOW_NOTIFICATION = 2;
    public static final int JOIN_MESSAGE = 4;
    public static final int SYSTEM_MESSAGE = 1;
  }

  public static class ShareAddressBook2ReplyStatus
  {
    public static final int BAD_REV = 1;
    public static final int FAILED = 4;
    public static final int INVALID_DATA = 2;
    public static final int NOT_UPDATED = 5;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 3;
  }

  public static class SubscribeState
  {
    public static final int ROLE_ONLY = 0;
    public static final int SUBSCRIBE_AND_ROLE = 2;
    public static final int SUBSCRIBE_ONLY = 1;
  }

  public static class SyncDataStatus
  {
    public static final int FAILED = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static class SyncOpCode
  {
    public static final int SYNC_OP_TUNNEL_DATA;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ClientMessages
 * JD-Core Version:    0.6.2
 */