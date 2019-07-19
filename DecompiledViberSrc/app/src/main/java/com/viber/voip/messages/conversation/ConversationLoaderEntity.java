package com.viber.voip.messages.conversation;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.group.participants.settings.b;
import com.viber.voip.messages.controller.manager.aa;
import com.viber.voip.messages.i;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.FormattedUrlMessage;
import com.viber.voip.model.g;
import com.viber.voip.publicaccount.entity.PublicAccount.GlobalPermissions;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import org.json.JSONException;

public abstract class ConversationLoaderEntity
  implements Parcelable, b, g, Comparable<ConversationLoaderEntity>
{
  public static final int APPLICATION_ID_INDX = 9;
  public static final int BODY_INDX = 21;
  public static final int BODY_SPANS_INDX = 22;
  public static final int COMMUNITY_PRIVILEGES_INDX = 49;
  public static final int CONVERSATION_BACKGROUND_LAND_INDX = 16;
  public static final int CONVERSATION_BACKGROUND_PORT_INDX = 15;
  public static final int CONVERSATION_DATE_INDX = 2;
  public static final int CONVERSATION_FLAGS_INDX = 3;
  public static final int CONVERSATION_GROUP_ID_INDX = 5;
  public static final int CONVERSATION_GROUP_NAME_INDX = 4;
  public static final int CONVERSATION_GROUP_ROLE_INDX = 6;
  public static final int CONVERSATION_ICON_ID_INDX = 7;
  public static final int CONVERSATION_ID_INDX = 0;
  public static final int CONVERSATION_MESSAGE_DRAFT_INDX = 18;
  public static final int CONVERSATION_MESSAGE_DRAFT_SPANS_INDX = 19;
  public static final int CONVERSATION_MUTE_NOTIFICATION_INDX = 8;
  private static final String CONVERSATION_TYPE = "conversations.conversation_type";
  public static final int CONVERSATION_TYPE_INDX = 1;
  public static final int CREATOR_PARTICIPANT_INFO_ID_INDX = 17;
  public static final int DESCRIPTION_MESSAGE_ID_INDX = 30;
  public static final int EXTRA_MIME_INDX = 24;
  public static final int GROUPING_KEY_INDX = 12;
  public static final int IN_BUSINESS_INBOX_INDX = 10;
  private static final Logger L = ViberEnv.getLogger();
  private static final String LAST_PIN_MESSAGE_MSG_INFO = "(CASE WHEN (conversations.conversation_type=5 AND conversations.group_role=3)  THEN (IFNULL(" + aa.f + ", \"\")) WHEN " + "conversations.conversation_type" + "<>" + 0 + " THEN (IFNULL(" + aa.e + ", \"\")) ELSE \"\" END) as last_pin_action_msg_info";
  public static final int LAST_PIN_MESSAGE_MSG_INFO_INDX = 40;
  public static final int LOCAL_LAST_MESSAGE_ID_INDX = 46;
  public static final int MESSAGE_EXTRA_FLAGS_INDX = 26;
  public static final int MESSAGE_ID_INDX = 20;
  public static final int MESSAGE_MSG_INFO_INDX = 25;
  public static final int MESSAGE_ORDER_KEY_INDX = 28;
  public static final int MESSAGE_STATUS_INDX = 29;
  public static final int MESSAGE_TOKEN_INDX = 27;
  public static final int MESSAGE_TYPE_INDX = 23;
  public static final int PARTICIPANT_INFO_CONTACT_ID_INDX = 34;
  public static final int PARTICIPANT_INFO_CONTACT_NAME_INDX = 31;
  public static final int PARTICIPANT_INFO_FLAGS_INDX = 37;
  public static final int PARTICIPANT_INFO_ID_1_INDX = 14;
  public static final int PARTICIPANT_INFO_MEMBER_ID_INDX = 35;
  public static final int PARTICIPANT_INFO_NUMBER_ID_INDX = 36;
  public static final int PARTICIPANT_INFO_PHOTO = 38;
  public static final int PARTICIPANT_INFO_TYPE_INDX = 33;
  public static final int PARTICIPANT_INFO_VIBER_IMAGE = 39;
  public static final int PARTICIPANT_INFO_VIBER_NAME_INDX = 32;
  protected static final String[] PROJECTIONS = arrayOfString;
  public static final int PUBLIC_ACCOUNT_FLAGS_INDX = 48;
  public static final int PUBLIC_ACCOUNT_SENDER_NAME = 45;
  public static final int PUBLIC_GROUP_LAST_MEDIA_TYPE = 42;
  public static final int PUBLIC_GROUP_LAST_MESSAGE_TEXT = 43;
  public static final int PUBLIC_GROUP_SENDER_PHONE = 44;
  public static final int READ_NOTIFICATION_TOKEN_INDX = 13;
  public static final String SEARCH_MESSAGES_DATE_ALIASE = "message_date";
  public static final int SERVER_LAST_MESSAGE_ID_INDX = 47;
  public static final int TO_NUMBER_INDX = 11;
  public static final String UNREAD_ALL_MSG_COUNT = "IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime <> 1007 AND [messages].[extra_flags] & 4194304 = 0 AND messages.extra_mime <> 1008 AND messages.extra_mime <> 1002 AND messages.deleted=0 ), 0)";
  public static final String UNREAD_MSG_COUNT = "(CASE WHEN (conversations.conversation_type = 5 OR conversations.conversation_type = 2) THEN ( MAX( public_accounts.local_message_id, public_accounts.server_message_id ) - public_accounts.last_read_message_id ) ELSE (IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime <> 1007 AND [messages].[extra_flags] & 4194304 = 0 AND messages.extra_mime <> 1008 AND messages.extra_mime <> 1002 AND messages.deleted=0 ), 0)) END)";
  private static final String UNREAD_MSG_COUNT_BASE = "IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime <> 1007 AND [messages].[extra_flags] & 4194304 = 0 AND messages.extra_mime <> 1008 AND messages.extra_mime <> 1002 AND messages.deleted=0 ), 0)";
  public static final int UNREAD_MSG_COUNT_INDX = 41;
  public static final int WATCHERS_COUNT_INDX = 50;
  private int appId;
  private String body;
  private String bodySpans;
  private int businessInboxFlags;
  private long communityPrivileges;
  private ConferenceInfo conferenceInfo;
  private long contactId;
  private String contactName;
  private int conversationType;
  private long creatorParticipantInfoId;
  private long date;
  private String description;
  protected long flags;
  private String formatedData;
  private FormattedMessage formattedMessage;
  private long groupId;
  private String groupName;
  private int groupRole;
  private String groupingKey;
  private Uri iconUri;
  private long id;
  private String initialDisplayName;
  private String landBackgroud;
  private int lastMediaType;
  private String lastMsgText;
  private String lastPinMessageRawMsgInfo;
  private int localLastMessageId;
  private a mSearchSection = a.a;
  private String messageDraft;
  private String messageDraftSpans;
  private long messageExtraFlags;
  private long messageId;
  private long messageOrderKey;
  private int messageStatus;
  private long messageToken;
  private int messageType;
  private int mimeType;
  private MsgInfo msgInfo;
  private int muteNotifications;
  private long nativePhotoId;
  private String participantBiDiName;
  private int participantFlags;
  private String participantMemberId;
  private String participantName;
  private String participantNumber;
  private int participantType;
  private String portBackgroud;
  protected int publicGroupsFlags;
  private String rawMessageInfo;
  private long readNotificationToken;
  private String senderName;
  private String senderPhone;
  private int serverLastMessageId;
  private transient CharSequence spannableSubjectText;
  private transient CharSequence spannableTitleText;
  private String toNumber;
  private int unreadMessagesCount;
  private String viberImage;
  private String viberName;
  private int watchersCount;

  static
  {
    String[] arrayOfString = new String[51];
    arrayOfString[0] = "conversations._id";
    arrayOfString[1] = "conversations.conversation_type";
    arrayOfString[2] = "conversations.date";
    arrayOfString[3] = "conversations.flags";
    arrayOfString[4] = "conversations.name";
    arrayOfString[5] = "conversations.group_id";
    arrayOfString[6] = "conversations.group_role";
    arrayOfString[7] = "conversations.icon_id";
    arrayOfString[8] = "conversations.mute_notification";
    arrayOfString[9] = "conversations.application_id";
    arrayOfString[10] = "conversations.business_inbox_flags";
    arrayOfString[11] = "conversations.to_number";
    arrayOfString[12] = "conversations.grouping_key";
    arrayOfString[13] = "conversations.read_notification_token";
    arrayOfString[14] = "conversations.participant_id_1";
    arrayOfString[15] = "conversations.background_portrait";
    arrayOfString[16] = "conversations.background_landscape";
    arrayOfString[17] = "conversations.creator_participant_id";
    arrayOfString[18] = "conversations.message_draft";
    arrayOfString[19] = "conversations.msg_draft_spans";
    arrayOfString[20] = "messages._id";
    arrayOfString[21] = "messages.body";
    arrayOfString[22] = "messages.spans";
    arrayOfString[23] = "messages.send_type";
    arrayOfString[24] = "messages.extra_mime";
    arrayOfString[25] = "messages.msg_info";
    arrayOfString[26] = "messages.extra_flags";
    arrayOfString[27] = "messages.token";
    arrayOfString[28] = "messages.order_key";
    arrayOfString[29] = "messages.status";
    arrayOfString[30] = "messages.description";
    arrayOfString[31] = "participants_info.contact_name";
    arrayOfString[32] = "participants_info.viber_name";
    arrayOfString[33] = "participants_info.participant_type";
    arrayOfString[34] = "participants_info.contact_id";
    arrayOfString[35] = "participants_info.member_id";
    arrayOfString[36] = "participants_info.number";
    arrayOfString[37] = "participants_info.participant_info_flags";
    arrayOfString[38] = "participants_info.native_photo_id";
    arrayOfString[39] = "participants_info.viber_image";
    arrayOfString[40] = LAST_PIN_MESSAGE_MSG_INFO;
    arrayOfString[41] = "SUM (CASE WHEN (conversations.conversation_type = 5 OR conversations.conversation_type = 2) THEN ( MAX( public_accounts.local_message_id, public_accounts.server_message_id ) - public_accounts.last_read_message_id ) ELSE (IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime <> 1007 AND [messages].[extra_flags] & 4194304 = 0 AND messages.extra_mime <> 1008 AND messages.extra_mime <> 1002 AND messages.deleted=0 ), 0)) END)";
    arrayOfString[42] = "public_accounts.last_media_type";
    arrayOfString[43] = "public_accounts.last_msg_text";
    arrayOfString[44] = "public_accounts.sender_phone";
    arrayOfString[45] = "public_accounts.sender_name";
    arrayOfString[46] = "public_accounts.local_message_id";
    arrayOfString[47] = "public_accounts.server_message_id";
    arrayOfString[48] = "public_accounts.verified";
    arrayOfString[49] = "public_accounts.community_privileges";
    arrayOfString[50] = "public_accounts.watchers_count";
  }

  public ConversationLoaderEntity(Cursor paramCursor)
  {
    init(this, paramCursor, false);
  }

  public ConversationLoaderEntity(Cursor paramCursor, boolean paramBoolean)
  {
    init(this, paramCursor, paramBoolean);
  }

  public ConversationLoaderEntity(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.conversationType = paramParcel.readInt();
    this.date = paramParcel.readLong();
    this.flags = paramParcel.readLong();
    this.groupName = paramParcel.readString();
    this.groupId = paramParcel.readLong();
    this.groupRole = paramParcel.readInt();
    this.iconUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.muteNotifications = paramParcel.readInt();
    this.appId = paramParcel.readInt();
    this.businessInboxFlags = paramParcel.readInt();
    this.toNumber = paramParcel.readString();
    this.groupingKey = paramParcel.readString();
    this.readNotificationToken = paramParcel.readLong();
    this.messageDraft = paramParcel.readString();
    this.messageDraftSpans = paramParcel.readString();
    this.messageId = paramParcel.readLong();
    this.body = paramParcel.readString();
    this.bodySpans = paramParcel.readString();
    this.mimeType = paramParcel.readInt();
    this.messageType = paramParcel.readInt();
    this.rawMessageInfo = paramParcel.readString();
    this.messageExtraFlags = paramParcel.readLong();
    this.messageToken = paramParcel.readLong();
    this.messageOrderKey = paramParcel.readLong();
    this.messageStatus = paramParcel.readInt();
    this.description = paramParcel.readString();
    this.contactName = paramParcel.readString();
    this.viberName = paramParcel.readString();
    this.participantType = paramParcel.readInt();
    this.contactId = paramParcel.readLong();
    this.participantMemberId = paramParcel.readString();
    this.participantNumber = paramParcel.readString();
    this.participantFlags = paramParcel.readInt();
    this.nativePhotoId = paramParcel.readLong();
    this.viberImage = paramParcel.readString();
    if (paramParcel.readInt() == 1)
      this.formattedMessage = ((FormattedMessage)paramParcel.readParcelable(FormattedMessage.class.getClassLoader()));
    this.portBackgroud = paramParcel.readString();
    this.landBackgroud = paramParcel.readString();
    this.creatorParticipantInfoId = paramParcel.readLong();
    this.lastPinMessageRawMsgInfo = paramParcel.readString();
    this.mSearchSection = a.values()[paramParcel.readInt()];
    this.unreadMessagesCount = paramParcel.readInt();
    this.lastMediaType = paramParcel.readInt();
    this.lastMsgText = paramParcel.readString();
    this.senderPhone = paramParcel.readString();
    this.senderName = paramParcel.readString();
    this.localLastMessageId = paramParcel.readInt();
    this.serverLastMessageId = paramParcel.readInt();
    this.publicGroupsFlags = paramParcel.readInt();
    this.communityPrivileges = paramParcel.readLong();
    this.watchersCount = paramParcel.readInt();
  }

  public ConversationLoaderEntity(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    this.id = paramConversationLoaderEntity.id;
    this.conversationType = paramConversationLoaderEntity.conversationType;
    this.date = paramConversationLoaderEntity.date;
    this.flags = paramConversationLoaderEntity.flags;
    this.groupName = paramConversationLoaderEntity.groupName;
    this.groupId = paramConversationLoaderEntity.groupId;
    this.groupRole = paramConversationLoaderEntity.groupRole;
    this.iconUri = paramConversationLoaderEntity.iconUri;
    this.muteNotifications = paramConversationLoaderEntity.muteNotifications;
    this.portBackgroud = paramConversationLoaderEntity.portBackgroud;
    this.landBackgroud = paramConversationLoaderEntity.landBackgroud;
    this.appId = paramConversationLoaderEntity.appId;
    this.businessInboxFlags = paramConversationLoaderEntity.businessInboxFlags;
    this.toNumber = paramConversationLoaderEntity.toNumber;
    this.groupingKey = paramConversationLoaderEntity.groupingKey;
    this.readNotificationToken = paramConversationLoaderEntity.readNotificationToken;
    this.messageDraft = paramConversationLoaderEntity.messageDraft;
    this.messageDraftSpans = paramConversationLoaderEntity.messageDraftSpans;
    this.messageId = paramConversationLoaderEntity.messageId;
    this.body = paramConversationLoaderEntity.body;
    this.bodySpans = paramConversationLoaderEntity.bodySpans;
    this.messageType = paramConversationLoaderEntity.messageType;
    this.mimeType = paramConversationLoaderEntity.mimeType;
    this.messageExtraFlags = paramConversationLoaderEntity.messageExtraFlags;
    this.messageToken = paramConversationLoaderEntity.messageToken;
    this.contactName = paramConversationLoaderEntity.contactName;
    this.viberName = paramConversationLoaderEntity.viberName;
    this.nativePhotoId = paramConversationLoaderEntity.nativePhotoId;
    this.viberImage = paramConversationLoaderEntity.viberImage;
    this.participantType = paramConversationLoaderEntity.participantType;
    this.contactId = paramConversationLoaderEntity.contactId;
    this.participantMemberId = paramConversationLoaderEntity.participantMemberId;
    this.participantNumber = paramConversationLoaderEntity.participantNumber;
    this.participantFlags = paramConversationLoaderEntity.participantFlags;
    this.rawMessageInfo = paramConversationLoaderEntity.rawMessageInfo;
    this.formattedMessage = paramConversationLoaderEntity.formattedMessage;
    this.msgInfo = paramConversationLoaderEntity.msgInfo;
    this.unreadMessagesCount = paramConversationLoaderEntity.unreadMessagesCount;
    this.initialDisplayName = paramConversationLoaderEntity.initialDisplayName;
    this.participantName = paramConversationLoaderEntity.participantName;
    this.participantBiDiName = paramConversationLoaderEntity.participantBiDiName;
    this.formatedData = paramConversationLoaderEntity.formatedData;
    this.creatorParticipantInfoId = paramConversationLoaderEntity.creatorParticipantInfoId;
    this.lastPinMessageRawMsgInfo = paramConversationLoaderEntity.lastPinMessageRawMsgInfo;
    this.lastMediaType = paramConversationLoaderEntity.lastMediaType;
    this.lastMsgText = paramConversationLoaderEntity.lastMsgText;
    this.senderPhone = paramConversationLoaderEntity.senderPhone;
    this.senderName = paramConversationLoaderEntity.senderName;
    this.localLastMessageId = paramConversationLoaderEntity.localLastMessageId;
    this.serverLastMessageId = paramConversationLoaderEntity.serverLastMessageId;
    this.publicGroupsFlags = paramConversationLoaderEntity.publicGroupsFlags;
    this.communityPrivileges = paramConversationLoaderEntity.communityPrivileges;
    this.watchersCount = paramConversationLoaderEntity.watchersCount;
    this.mSearchSection = paramConversationLoaderEntity.mSearchSection;
    this.spannableSubjectText = paramConversationLoaderEntity.spannableSubjectText;
    this.spannableTitleText = paramConversationLoaderEntity.spannableTitleText;
    this.description = paramConversationLoaderEntity.description;
  }

  public ConversationLoaderEntity(String paramString, long paramLong, int paramInt1, int paramInt2, Uri paramUri)
  {
    this.groupName = paramString;
    this.groupId = paramLong;
    this.conversationType = paramInt1;
    this.groupRole = paramInt2;
    this.iconUri = paramUri;
  }

  public ConversationLoaderEntity(String paramString1, String paramString2, Uri paramUri)
  {
    this.contactName = paramString1;
    this.participantMemberId = paramString2;
    this.conversationType = 0;
    this.iconUri = paramUri;
    this.participantType = 1;
  }

  public static void init(ConversationLoaderEntity paramConversationLoaderEntity, Cursor paramCursor, boolean paramBoolean)
  {
    paramConversationLoaderEntity.id = paramCursor.getLong(0);
    paramConversationLoaderEntity.conversationType = paramCursor.getInt(1);
    String str;
    if ((paramBoolean) && (paramCursor.getColumnIndex("message_date") != -1))
    {
      paramConversationLoaderEntity.date = paramCursor.getLong(paramCursor.getColumnIndex("message_date"));
      paramConversationLoaderEntity.flags = paramCursor.getLong(3);
      paramConversationLoaderEntity.groupName = paramCursor.getString(4);
      paramConversationLoaderEntity.groupId = paramCursor.getLong(5);
      paramConversationLoaderEntity.groupRole = paramCursor.getInt(6);
      str = paramCursor.getString(7);
      if (!da.a(str))
        break label701;
    }
    label701: for (Uri localUri = null; ; localUri = Uri.parse(str))
    {
      paramConversationLoaderEntity.iconUri = localUri;
      paramConversationLoaderEntity.muteNotifications = paramCursor.getInt(8);
      paramConversationLoaderEntity.appId = paramCursor.getInt(9);
      paramConversationLoaderEntity.businessInboxFlags = paramCursor.getInt(10);
      paramConversationLoaderEntity.toNumber = paramCursor.getString(11);
      paramConversationLoaderEntity.groupingKey = paramCursor.getString(12);
      paramConversationLoaderEntity.readNotificationToken = paramCursor.getLong(13);
      paramConversationLoaderEntity.messageDraft = paramCursor.getString(18);
      paramConversationLoaderEntity.messageDraftSpans = paramCursor.getString(19);
      paramConversationLoaderEntity.messageId = paramCursor.getLong(20);
      paramConversationLoaderEntity.body = paramCursor.getString(21);
      paramConversationLoaderEntity.bodySpans = paramCursor.getString(22);
      paramConversationLoaderEntity.messageType = paramCursor.getInt(23);
      paramConversationLoaderEntity.mimeType = paramCursor.getInt(24);
      paramConversationLoaderEntity.rawMessageInfo = paramCursor.getString(25);
      paramConversationLoaderEntity.messageExtraFlags = paramCursor.getLong(26);
      paramConversationLoaderEntity.messageToken = paramCursor.getLong(27);
      paramConversationLoaderEntity.messageOrderKey = paramCursor.getLong(28);
      paramConversationLoaderEntity.messageStatus = paramCursor.getInt(29);
      paramConversationLoaderEntity.description = paramCursor.getString(30);
      if ((paramBoolean) && ((paramConversationLoaderEntity.mimeType == 1) || (paramConversationLoaderEntity.mimeType == 3)))
      {
        paramConversationLoaderEntity.mimeType = 0;
        paramConversationLoaderEntity.body = paramCursor.getString(51);
      }
      paramConversationLoaderEntity.contactName = paramCursor.getString(31);
      paramConversationLoaderEntity.viberName = paramCursor.getString(32);
      paramConversationLoaderEntity.participantType = paramCursor.getInt(33);
      paramConversationLoaderEntity.contactId = paramCursor.getLong(34);
      paramConversationLoaderEntity.participantMemberId = paramCursor.getString(35);
      paramConversationLoaderEntity.participantNumber = paramCursor.getString(36);
      paramConversationLoaderEntity.participantFlags = paramCursor.getInt(37);
      paramConversationLoaderEntity.nativePhotoId = paramCursor.getLong(38);
      paramConversationLoaderEntity.viberImage = paramCursor.getString(39);
      paramConversationLoaderEntity.portBackgroud = paramCursor.getString(15);
      paramConversationLoaderEntity.landBackgroud = paramCursor.getString(16);
      paramConversationLoaderEntity.creatorParticipantInfoId = paramCursor.getLong(17);
      paramConversationLoaderEntity.lastPinMessageRawMsgInfo = paramCursor.getString(40);
      paramConversationLoaderEntity.unreadMessagesCount = paramCursor.getInt(41);
      if (m.e(paramConversationLoaderEntity.conversationType))
      {
        paramConversationLoaderEntity.setLastMediaType(paramCursor.getString(42));
        paramConversationLoaderEntity.lastMsgText = paramCursor.getString(43);
        paramConversationLoaderEntity.senderPhone = paramCursor.getString(44);
        paramConversationLoaderEntity.senderName = paramCursor.getString(45);
        paramConversationLoaderEntity.localLastMessageId = paramCursor.getInt(46);
        paramConversationLoaderEntity.serverLastMessageId = paramCursor.getInt(47);
        paramConversationLoaderEntity.publicGroupsFlags = paramCursor.getInt(48);
        paramConversationLoaderEntity.communityPrivileges = paramCursor.getInt(49);
        paramConversationLoaderEntity.watchersCount = paramCursor.getInt(50);
      }
      paramConversationLoaderEntity.formattedMessage = obtainFormattedMessage(paramConversationLoaderEntity);
      return;
      paramConversationLoaderEntity.date = paramCursor.getLong(2);
      break;
    }
  }

  private static FormattedMessage obtainFormattedMessage(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if (!paramConversationLoaderEntity.hasMessages());
    while (true)
    {
      return null;
      if (paramConversationLoaderEntity.isFormattedMessage())
        try
        {
          FormattedMessage localFormattedMessage2 = new FormattedMessage(paramConversationLoaderEntity.body);
          return localFormattedMessage2;
        }
        catch (JSONException localJSONException2)
        {
        }
      else if (paramConversationLoaderEntity.isUrlMessage())
        try
        {
          if (da.a(paramConversationLoaderEntity.body))
            return new FormattedMessage(FormattedUrlMessage.createUrlMessage(paramConversationLoaderEntity.getParsedMsgInfo(), false));
          FormattedMessage localFormattedMessage1 = new FormattedMessage(paramConversationLoaderEntity.body);
          return localFormattedMessage1;
        }
        catch (JSONException localJSONException1)
        {
        }
    }
  }

  private void setLastMediaType(String paramString)
  {
    try
    {
      this.lastMediaType = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.lastMediaType = 0;
    }
  }

  public boolean canSendTimeBomb()
  {
    return ((this.conversationType == 0) || (this.conversationType == 1) || (this.conversationType == 4)) && (!isPublicAccount()) && (!isSystemConversation());
  }

  public boolean canWrite()
  {
    return cd.a(this.conversationType, this.groupRole, PublicAccount.GlobalPermissions.canWrite(this.communityPrivileges));
  }

  public int compareTo(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if (paramConversationLoaderEntity.date > this.date);
    do
    {
      return 1;
      if (paramConversationLoaderEntity.date < this.date)
        return -1;
    }
    while (paramConversationLoaderEntity.id > this.id);
    return -1;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getAppId()
  {
    return this.appId;
  }

  public String getBody()
  {
    return this.body;
  }

  public String getBodySpans()
  {
    return this.bodySpans;
  }

  public abstract int getBroadcastListParticipantsCount();

  public ConferenceInfo getConferenceInfo()
  {
    if (this.conferenceInfo == null)
      this.conferenceInfo = ((ConferenceInfo)e.c().a().a(this.description));
    return this.conferenceInfo;
  }

  public long getContactId()
  {
    return this.contactId;
  }

  public String getContactName()
  {
    return this.contactName;
  }

  public int getConversationType()
  {
    return this.conversationType;
  }

  public long getCreatorParticipantInfoId()
  {
    return this.creatorParticipantInfoId;
  }

  public long getDate()
  {
    return this.date;
  }

  public long getFlags()
  {
    return this.flags;
  }

  public String getFormatedData(i parami)
  {
    if (this.formatedData == null)
      this.formatedData = parami.f(this.date);
    return this.formatedData;
  }

  public FormattedMessage getFormattedMessage()
  {
    return this.formattedMessage;
  }

  public long getGroupId()
  {
    return this.groupId;
  }

  public String getGroupName()
  {
    return this.groupName;
  }

  public int getGroupRole()
  {
    return this.groupRole;
  }

  public String getGroupingKey()
  {
    return this.groupingKey;
  }

  public Uri getIconUri()
  {
    return this.iconUri;
  }

  public Uri getIconUriOrDefault()
  {
    return m.a(this.conversationType, this.iconUri);
  }

  public long getId()
  {
    return this.id;
  }

  public String getInitialDisplayName()
  {
    if (this.initialDisplayName == null)
      this.initialDisplayName = da.f(getParticipantName());
    return this.initialDisplayName;
  }

  public String getLandBackgroud()
  {
    return this.landBackgroud;
  }

  public int getLastMediaType()
  {
    return this.lastMediaType;
  }

  public String getLastMsgText()
  {
    return this.lastMsgText;
  }

  public String getLastPinMessageRawMsgInfo()
  {
    return this.lastPinMessageRawMsgInfo;
  }

  public String getMessageDraft()
  {
    if (this.messageDraft != null)
      return this.messageDraft;
    return "";
  }

  public String getMessageDraftSpans()
  {
    if (this.messageDraftSpans != null)
      return this.messageDraftSpans;
    return "";
  }

  public long getMessageExtraFlags()
  {
    return this.messageExtraFlags;
  }

  public long getMessageId()
  {
    return this.messageId;
  }

  public long getMessageOrderKey()
  {
    return this.messageOrderKey;
  }

  public int getMessageStatus()
  {
    return this.messageStatus;
  }

  public long getMessageToken()
  {
    return this.messageToken;
  }

  public int getMimeType()
  {
    return this.mimeType;
  }

  public String getNumber()
  {
    return this.participantNumber;
  }

  public MsgInfo getParsedMsgInfo()
  {
    if (this.msgInfo == null)
      this.msgInfo = ((MsgInfo)e.a().a().a(this.rawMessageInfo));
    return this.msgInfo;
  }

  public String getParticipantBiDiName()
  {
    if (this.participantBiDiName == null)
      this.participantBiDiName = com.viber.common.d.c.a(getParticipantName());
    return this.participantBiDiName;
  }

  public abstract long[] getParticipantInfos();

  public String getParticipantMemberId()
  {
    return this.participantMemberId;
  }

  public String getParticipantName()
  {
    if (this.participantName == null)
      this.participantName = dg.a(this);
    return this.participantName;
  }

  public Uri getParticipantPhoto()
  {
    return cd.a(isOwner(), this.viberImage, this.nativePhotoId, this.contactId, m.c(getNumber()));
  }

  public String getPortBackgroud()
  {
    return this.portBackgroud;
  }

  public a getSearchSection()
  {
    return this.mSearchSection;
  }

  public String getSenderName()
  {
    return this.senderName;
  }

  public String getSenderPhone()
  {
    return this.senderPhone;
  }

  public int getServerLastMessageId()
  {
    return this.serverLastMessageId;
  }

  public CharSequence getSpannableSubjectText()
  {
    return this.spannableSubjectText;
  }

  public CharSequence getSpannableTitleText()
  {
    return this.spannableTitleText;
  }

  public String getToNumber()
  {
    return this.toNumber;
  }

  public abstract int getUnreadEventsCount();

  public int getUnreadMessagesCount()
  {
    return this.unreadMessagesCount;
  }

  public String getViberName()
  {
    return this.viberName;
  }

  public int getWatchersCount()
  {
    return this.watchersCount;
  }

  public boolean hasBusinessInboxOverlay()
  {
    return av.c(this.businessInboxFlags, 2);
  }

  public boolean hasConferenceInfo()
  {
    return !com.viber.voip.flatbuffers.b.c.a(this.description);
  }

  public boolean hasMessageDraft()
  {
    return !da.a(this.messageDraft);
  }

  public boolean hasMessages()
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.messageId > 0L)
    {
      bool2 = bool1;
      if (m.e(this.conversationType))
        if (this.localLastMessageId < this.serverLastMessageId)
          break label45;
    }
    while (true)
    {
      bool2 &= bool1;
      return bool2;
      bool2 = false;
      break;
      label45: bool1 = false;
    }
  }

  public boolean hasMyLike()
  {
    return av.c(this.messageExtraFlags, 12);
  }

  public abstract boolean hasPublicChat();

  public boolean isAnonymous()
  {
    return m.a(this.conversationType, this.participantMemberId);
  }

  public boolean isBroadcastListType()
  {
    return this.conversationType == 4;
  }

  public boolean isCall()
  {
    return 1002 == this.mimeType;
  }

  public boolean isCommunityType()
  {
    return this.conversationType == 5;
  }

  public boolean isConversation1on1()
  {
    return this.conversationType == 0;
  }

  public boolean isDeletedMessageNotification()
  {
    return this.mimeType == 1008;
  }

  public boolean isDisabledConversation()
  {
    return av.c(this.flags, 6);
  }

  public boolean isEngagementConversation()
  {
    return av.c(this.flags, 21);
  }

  public abstract boolean isFavouriteConversation();

  public boolean isFormattedMessage()
  {
    return 7 == this.mimeType;
  }

  public boolean isGroupBehavior()
  {
    return this.conversationType != 0;
  }

  public boolean isGroupCallType()
  {
    return (isCall()) && (("missed_call_group".equals(this.body)) || ("incoming_call_group".equals(this.body)) || ("answ_another_dev_group".equals(this.body)));
  }

  public boolean isGroupType()
  {
    return this.conversationType == 1;
  }

  public boolean isHiddenConversation()
  {
    return av.c(this.flags, 15);
  }

  public boolean isInBusinessInbox()
  {
    return av.c(this.businessInboxFlags, 0);
  }

  public boolean isIncoming()
  {
    return this.messageType == 0;
  }

  public boolean isMarkedAsUnreadConversation()
  {
    return av.c(this.flags, 33);
  }

  public boolean isMessageRead()
  {
    if (isBroadcastListType());
    while (this.messageToken > this.readNotificationToken)
      return false;
    return true;
  }

  public boolean isMissedAudioCall()
  {
    return (isCall()) && (("missed_call".equals(this.body)) || ("missed_call_group".equals(this.body)));
  }

  public boolean isMissedCall()
  {
    return (isMissedAudioCall()) || (isMissedVideoCall());
  }

  public boolean isMissedVideoCall()
  {
    return (isCall()) && ("missed_call_video".equals(this.body));
  }

  public boolean isMuteConversation()
  {
    return this.muteNotifications == 1;
  }

  public boolean isNewSpamBanner()
  {
    return av.c(this.flags, 10);
  }

  public boolean isNewUserJoinedConversation()
  {
    return av.c(this.flags, 25);
  }

  public boolean isNonReplyableChat()
  {
    return av.c(this.flags, 4);
  }

  public boolean isNonreplyableConversation()
  {
    return av.c(this.flags, 4);
  }

  public boolean isNotJoinedCommunity()
  {
    return av.c(this.flags, 36);
  }

  public boolean isNotificationLast()
  {
    return 1000 == this.mimeType;
  }

  public boolean isOneToOneWithPublicAccount()
  {
    return av.c(this.flags, 19);
  }

  public boolean isOwner()
  {
    return this.participantType == 0;
  }

  public boolean isPinMessage()
  {
    return (av.c(this.messageExtraFlags, 32)) && (hasMessages());
  }

  public boolean isPublicAccount()
  {
    return av.c(this.flags, 19);
  }

  public boolean isPublicGroupBehavior()
  {
    return (isPublicGroupType()) || (isCommunityType());
  }

  public boolean isPublicGroupType()
  {
    return m.a(this.conversationType);
  }

  public boolean isRakutenSystemConversation()
  {
    return av.c(this.flags, 2);
  }

  public boolean isSecret()
  {
    return av.c(this.flags, 24);
  }

  public boolean isSeenConversation()
  {
    return av.c(this.flags, 23);
  }

  public abstract boolean isSnoozedConversation();

  public abstract boolean isSystemConversation();

  public boolean isSystemReplyableChat()
  {
    return av.c(this.flags, 13);
  }

  public boolean isTextMessage()
  {
    return this.mimeType == 0;
  }

  public boolean isUnknownParticipant()
  {
    return cd.a(this.contactId, this.participantFlags);
  }

  public boolean isUrlMessage()
  {
    return 8 == this.mimeType;
  }

  public boolean isUserRejoinedConversation()
  {
    return av.c(this.flags, 27);
  }

  public boolean isVerified()
  {
    return av.d(this.publicGroupsFlags, 1);
  }

  public boolean isVlnConversation()
  {
    return av.c(this.flags, 34);
  }

  public void setSearchSection(a parama)
  {
    this.mSearchSection = parama;
  }

  public void setSpannableSubjectText(CharSequence paramCharSequence)
  {
    this.spannableSubjectText = paramCharSequence;
  }

  public void setSpannableTitleText(CharSequence paramCharSequence)
  {
    this.spannableTitleText = paramCharSequence;
  }

  public boolean showAddNewParticipantNumberBanner()
  {
    return av.c(this.flags, 26);
  }

  public boolean showEngagementConversationAnimation()
  {
    return !av.c(this.flags, 22);
  }

  public boolean showInvitePreviewMessageCommunity()
  {
    return av.c(this.flags, 38);
  }

  public boolean showSpamBanner()
  {
    return !av.c(this.flags, 8);
  }

  public String toString()
  {
    return "ConversationLoaderEntity{id=" + this.id + ", conversationType=" + this.conversationType + ", date=" + this.date + ", flags=" + this.flags + ", groupName='" + this.groupName + '\'' + ", groupId=" + this.groupId + ", groupRole=" + this.groupRole + ", iconUri='" + this.iconUri + '\'' + ", mimeType='" + this.mimeType + '\'' + ", body='" + da.b(this.body) + '\'' + ", bodySpans='" + this.bodySpans + '\'' + ", messageId=" + this.messageId + ", messageType=" + this.messageType + ", messageInfo=" + this.rawMessageInfo + ", messageExtraFlags=" + this.messageExtraFlags + ", messageToken=" + this.messageToken + ", messageOrderKey=" + this.messageOrderKey + ", messageStatus=" + this.messageStatus + ", description=" + this.description + ", contactName='" + this.contactName + '\'' + ", viberName='" + this.viberName + '\'' + ", participantType=" + this.participantType + ", contactId=" + this.contactId + ", participantMemberId='" + this.participantMemberId + '\'' + ", participantNumber='" + this.participantNumber + '\'' + ", participantFlags='" + this.participantFlags + '\'' + ", creatorParticipantInfoId=" + this.creatorParticipantInfoId + ", mSearchSection=" + this.mSearchSection + ", lastPinMessageRawMsgInfo=" + this.lastPinMessageRawMsgInfo + ", unreadMessagesCount=" + this.unreadMessagesCount + ", lastMediaType=" + this.lastMediaType + ", lastMsgText=" + da.b(this.lastMsgText) + ", senderPhone=" + this.senderPhone + ", senderName=" + this.senderName + ", localLastMessageId=" + this.localLastMessageId + ", serverLastMessageId=" + this.serverLastMessageId + ", publicGroupsFlags=" + this.publicGroupsFlags + ", communityPrivileges=" + this.communityPrivileges + ", watchersCount=" + this.watchersCount + ", toNumber=" + this.toNumber + ", groupingKey=" + this.groupingKey + ", readNotificationToken=" + this.readNotificationToken + ", messageDraft=" + this.messageDraft + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeInt(this.conversationType);
    paramParcel.writeLong(this.date);
    paramParcel.writeLong(this.flags);
    paramParcel.writeString(this.groupName);
    paramParcel.writeLong(this.groupId);
    paramParcel.writeInt(this.groupRole);
    paramParcel.writeParcelable(this.iconUri, 0);
    paramParcel.writeInt(this.muteNotifications);
    paramParcel.writeInt(this.appId);
    paramParcel.writeInt(this.businessInboxFlags);
    paramParcel.writeString(this.toNumber);
    paramParcel.writeString(this.groupingKey);
    paramParcel.writeLong(this.readNotificationToken);
    paramParcel.writeString(this.messageDraft);
    paramParcel.writeString(this.messageDraftSpans);
    paramParcel.writeLong(this.messageId);
    paramParcel.writeString(this.body);
    paramParcel.writeString(this.bodySpans);
    paramParcel.writeInt(this.mimeType);
    paramParcel.writeInt(this.messageType);
    paramParcel.writeString(this.rawMessageInfo);
    paramParcel.writeLong(this.messageExtraFlags);
    paramParcel.writeLong(this.messageToken);
    paramParcel.writeLong(this.messageOrderKey);
    paramParcel.writeInt(this.messageStatus);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.contactName);
    paramParcel.writeString(this.viberName);
    paramParcel.writeInt(this.participantType);
    paramParcel.writeLong(this.contactId);
    paramParcel.writeString(this.participantMemberId);
    paramParcel.writeString(this.participantNumber);
    paramParcel.writeInt(this.participantFlags);
    paramParcel.writeLong(this.nativePhotoId);
    paramParcel.writeString(this.viberImage);
    if (this.formattedMessage != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeParcelable(this.formattedMessage, paramInt);
    }
    while (true)
    {
      paramParcel.writeString(this.portBackgroud);
      paramParcel.writeString(this.landBackgroud);
      paramParcel.writeLong(this.creatorParticipantInfoId);
      paramParcel.writeString(this.lastPinMessageRawMsgInfo);
      paramParcel.writeInt(this.mSearchSection.ordinal());
      paramParcel.writeInt(this.unreadMessagesCount);
      paramParcel.writeInt(this.lastMediaType);
      paramParcel.writeString(this.lastMsgText);
      paramParcel.writeString(this.senderPhone);
      paramParcel.writeString(this.senderName);
      paramParcel.writeInt(this.localLastMessageId);
      paramParcel.writeInt(this.serverLastMessageId);
      paramParcel.writeInt(this.publicGroupsFlags);
      paramParcel.writeLong(this.communityPrivileges);
      paramParcel.writeInt(this.watchersCount);
      return;
      paramParcel.writeInt(0);
    }
  }

  public static enum a
  {
    private int i;

    static
    {
      a[] arrayOfa = new a[8];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
    }

    private a(int paramInt)
    {
      this.i = paramInt;
    }

    public int a()
    {
      return this.i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ConversationLoaderEntity
 * JD-Core Version:    0.6.2
 */