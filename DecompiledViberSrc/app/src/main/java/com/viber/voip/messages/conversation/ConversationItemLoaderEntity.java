package com.viber.voip.messages.conversation;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.group.participants.settings.b;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.model.g;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.cg;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;

public class ConversationItemLoaderEntity
  implements Parcelable, b, g
{
  public static final int BOT_REPLY_INDX = 18;
  public static final int BUSINESS_INBOX_FLAGS_INDX = 22;
  public static final int CONTACT_NAME_INDX = 25;
  public static final int CONVERSATION_APPLICATION_ID_INDX = 14;
  public static final int CONVERSATION_BACKGROUND_LANDSCAPE_INDX = 9;
  public static final int CONVERSATION_BACKGROUND_PORTRAIT_INDX = 10;
  public static final int CONVERSATION_BACKGROUNG_TEXT_COLOR_INDX = 11;
  public static final int CONVERSATION_FLAGS_INDX = 2;
  public static final int CONVERSATION_GROUP_ID_INDX = 4;
  public static final int CONVERSATION_GROUP_NAME_INDX = 3;
  public static final int CONVERSATION_GROUP_ROLE_INDX = 15;
  public static final int CONVERSATION_ICON_URI_INDX = 16;
  public static final int CONVERSATION_ID_INDX = 0;
  public static final int CONVERSATION_MESSAGE_DRAFT_INDX = 5;
  public static final int CONVERSATION_MESSAGE_DRAFT_SPANS_INDX = 6;
  public static final int CONVERSATION_MUTE_NOTIFICATION_INDX = 12;
  public static final int CONVERSATION_READ_NOTIFICATION_TOKEN_INDX = 13;
  public static final int CONVERSATION_SHARE_LOCATION_INDX = 7;
  public static final int CONVERSATION_SMART_NOTIFICATION_INDX = 8;
  public static final int CONVERSATION_TYPE_INDX = 1;
  public static final Parcelable.Creator<ConversationItemLoaderEntity> CREATOR = new Parcelable.Creator()
  {
    public ConversationItemLoaderEntity a(Parcel paramAnonymousParcel)
    {
      return new ConversationItemLoaderEntity(paramAnonymousParcel);
    }

    public ConversationItemLoaderEntity[] a(int paramAnonymousInt)
    {
      return new ConversationItemLoaderEntity[paramAnonymousInt];
    }
  };
  public static final int CREATOR_PARTICIPANT_INFO_ID_INDX = 17;
  public static final int FAVOURITE_CHAT_INDX = 20;
  private static final Logger L = ViberEnv.getLogger();
  public static final int PARTICIPANT_INFO_CONTACT_ID_INDX = 26;
  public static final int PARTICIPANT_INFO_FLAGS_INDX = 30;
  public static final int PARTICIPANT_INFO_ID_INDX = 24;
  public static final int PARTICIPANT_INFO_MEMBER_ID_INDX = 27;
  public static final int PARTICIPANT_INFO_NUMBER_ID_INDX = 28;
  public static final int PARTICIPANT_INFO_VIBER_NAME_INDX = 29;
  public static final String[] PROJECTIONS = { "conversations._id", "conversations.conversation_type", "conversations.flags", "conversations.name", "conversations.group_id", "conversations.message_draft", "conversations.msg_draft_spans", "conversations.share_location", "conversations.smart_notification", "conversations.background_landscape", "conversations.background_portrait", "conversations.background_text_color", "conversations.mute_notification", "conversations.read_notification_token", "conversations.application_id", "conversations.group_role", "conversations.icon_id", "conversations.creator_participant_id", "conversations.bot_reply", "conversations.timebomb_time", "conversations.favourite_conversation", "conversations.reply_banner_draft", "conversations.business_inbox_flags", "conversations.to_number", "participants_info._id", "participants_info.contact_name", "participants_info.contact_id", "participants_info.member_id", "participants_info.number", "participants_info.viber_name", "participants_info.participant_info_flags", "public_accounts.public_account_id", "public_accounts.group_id", "public_accounts.group_uri", "public_accounts.tag_line", "(CASE WHEN conversations.flags & (1 << 19)>0 THEN ( IFNULL((SELECT conversations._id FROM conversations LEFT OUTER JOIN public_accounts ON (conversations.group_id=public_accounts.group_id) WHERE conversations.conversation_type=2 AND public_accounts.public_account_id=participants_info.member_id), 0)) ELSE  0 END) AS PUBLIC_ACCOUNT_GROUP_EXISTS", "public_accounts.verified", "public_accounts.webhook_exists", "public_accounts.auth_token", "public_accounts.subscription_status" };
  public static final int PUBLIC_ACCOUNT_AUTH_TOKEN_INDX = 38;
  public static final String PUBLIC_ACCOUNT_GROUP_EXISTS = "(CASE WHEN conversations.flags & (1 << 19)>0 THEN ( IFNULL((SELECT conversations._id FROM conversations LEFT OUTER JOIN public_accounts ON (conversations.group_id=public_accounts.group_id) WHERE conversations.conversation_type=2 AND public_accounts.public_account_id=participants_info.member_id), 0)) ELSE  0 END) AS PUBLIC_ACCOUNT_GROUP_EXISTS";
  public static final int PUBLIC_ACCOUNT_GROUP_EXISTS_INDX = 35;
  public static final int PUBLIC_ACCOUNT_GROUP_FLAGS_INDX = 36;
  public static final int PUBLIC_ACCOUNT_GROUP_ID_INDX = 32;
  public static final int PUBLIC_ACCOUNT_GROUP_URI_INDX = 33;
  public static final int PUBLIC_ACCOUNT_ID_INDX = 31;
  public static final int PUBLIC_ACCOUNT_SUBSCRIPTION_INDX = 39;
  public static final int PUBLIC_ACCOUNT_TAG_LINE_INDX = 34;
  public static final int PUBLIC_ACCOUNT_WEBHOOK_INDX = 37;
  public static final int REPLY_BANNER_DRAFT_INDX = 21;
  public static final int TIMEBOMB_TIME_INDX = 19;
  public static final int TO_NUMBER_INDX = 23;
  protected int appId;
  protected String backgroundLandscape;
  protected String backgroundPortrait;
  protected int backgroundTextColor;
  private String botReply;
  protected int businessInboxFlags;
  private long contactId;
  private String contactName;
  protected int conversationType;
  protected long creatorParticipantInfoId;
  protected long flags;
  protected long groupId;
  protected String groupName;
  protected int groupRole;
  protected Uri iconUri;
  protected long id;
  protected String messageDraft;
  protected String messageDraftSpans;
  protected int muteNotifications;
  private int participantFlags;
  private long participantInfoId;
  private String participantMemberId;
  private String participantNumber;
  protected String publicAccountAuthToken;
  protected boolean publicAccountGroupExists;
  protected int publicAccountGroupFlags;
  protected long publicAccountGroupId;
  protected String publicAccountGroupUri;
  protected String publicAccountId;
  protected int publicAccountSubscriptionStatus;
  protected String publicAccountTagsLine;
  protected int publicAccountWebhookExist;
  private long readNotificationToken;
  protected String replyBannerDraft;
  protected int shareLocation;
  protected int smartNotification;
  protected int sortOrder;
  protected int timebombTime;
  protected String toNumber;
  private String viberName;

  public ConversationItemLoaderEntity()
  {
  }

  public ConversationItemLoaderEntity(Cursor paramCursor)
  {
    init(this, paramCursor);
  }

  protected ConversationItemLoaderEntity(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.conversationType = paramParcel.readInt();
    this.flags = paramParcel.readLong();
    this.groupName = paramParcel.readString();
    this.groupId = paramParcel.readLong();
    this.groupRole = paramParcel.readInt();
    this.iconUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.appId = paramParcel.readInt();
    this.messageDraft = paramParcel.readString();
    this.messageDraftSpans = paramParcel.readString();
    this.shareLocation = paramParcel.readInt();
    this.smartNotification = paramParcel.readInt();
    this.backgroundLandscape = paramParcel.readString();
    this.backgroundPortrait = paramParcel.readString();
    this.backgroundTextColor = paramParcel.readInt();
    this.muteNotifications = paramParcel.readInt();
    this.readNotificationToken = paramParcel.readLong();
    this.timebombTime = paramParcel.readInt();
    this.sortOrder = paramParcel.readInt();
    this.businessInboxFlags = paramParcel.readInt();
    this.toNumber = paramParcel.readString();
    this.creatorParticipantInfoId = paramParcel.readLong();
    this.botReply = paramParcel.readString();
    this.contactName = paramParcel.readString();
    this.contactId = paramParcel.readLong();
    this.viberName = paramParcel.readString();
    this.participantFlags = paramParcel.readInt();
    this.participantInfoId = paramParcel.readLong();
    this.participantMemberId = paramParcel.readString();
    this.participantNumber = paramParcel.readString();
    this.publicAccountId = paramParcel.readString();
    this.publicAccountGroupId = paramParcel.readLong();
    this.publicAccountGroupUri = paramParcel.readString();
    this.publicAccountTagsLine = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.publicAccountGroupExists = bool;
      this.publicAccountGroupFlags = paramParcel.readInt();
      this.publicAccountWebhookExist = paramParcel.readInt();
      this.publicAccountAuthToken = paramParcel.readString();
      this.publicAccountSubscriptionStatus = paramParcel.readInt();
      this.replyBannerDraft = paramParcel.readString();
      return;
    }
  }

  public ConversationItemLoaderEntity(h paramh)
  {
    this(paramh, null);
  }

  public ConversationItemLoaderEntity(h paramh, com.viber.voip.model.entity.m paramm)
  {
    init(this, paramh, paramm);
  }

  public ConversationItemLoaderEntity(h paramh, com.viber.voip.model.entity.m paramm, r paramr)
  {
    this(paramh, paramm);
    if (paramr != null)
    {
      this.publicAccountId = paramr.b();
      this.publicAccountGroupId = paramr.a();
      this.publicAccountGroupUri = paramr.d();
      this.publicAccountTagsLine = paramr.u();
      this.publicAccountGroupFlags = paramr.x();
      this.publicAccountWebhookExist = paramr.L();
      this.publicAccountAuthToken = paramr.o();
      this.publicAccountSubscriptionStatus = paramr.q();
    }
  }

  public static void init(ConversationItemLoaderEntity paramConversationItemLoaderEntity, Cursor paramCursor)
  {
    paramConversationItemLoaderEntity.id = paramCursor.getLong(0);
    paramConversationItemLoaderEntity.conversationType = paramCursor.getInt(1);
    paramConversationItemLoaderEntity.flags = paramCursor.getLong(2);
    paramConversationItemLoaderEntity.groupName = paramCursor.getString(3);
    paramConversationItemLoaderEntity.groupId = paramCursor.getLong(4);
    paramConversationItemLoaderEntity.messageDraft = paramCursor.getString(5);
    paramConversationItemLoaderEntity.messageDraftSpans = paramCursor.getString(6);
    paramConversationItemLoaderEntity.shareLocation = paramCursor.getInt(7);
    paramConversationItemLoaderEntity.smartNotification = paramCursor.getInt(8);
    paramConversationItemLoaderEntity.backgroundLandscape = paramCursor.getString(9);
    paramConversationItemLoaderEntity.backgroundPortrait = paramCursor.getString(10);
    paramConversationItemLoaderEntity.backgroundTextColor = paramCursor.getInt(11);
    paramConversationItemLoaderEntity.muteNotifications = paramCursor.getInt(12);
    paramConversationItemLoaderEntity.readNotificationToken = paramCursor.getLong(13);
    paramConversationItemLoaderEntity.appId = paramCursor.getInt(14);
    paramConversationItemLoaderEntity.groupRole = paramCursor.getInt(15);
    String str = paramCursor.getString(16);
    Uri localUri;
    if (da.a(str))
    {
      localUri = null;
      paramConversationItemLoaderEntity.iconUri = localUri;
      paramConversationItemLoaderEntity.creatorParticipantInfoId = paramCursor.getLong(17);
      paramConversationItemLoaderEntity.botReply = paramCursor.getString(18);
      paramConversationItemLoaderEntity.timebombTime = paramCursor.getInt(19);
      paramConversationItemLoaderEntity.sortOrder = paramCursor.getInt(20);
      paramConversationItemLoaderEntity.participantInfoId = paramCursor.getLong(24);
      paramConversationItemLoaderEntity.contactName = paramCursor.getString(25);
      paramConversationItemLoaderEntity.contactId = paramCursor.getLong(26);
      paramConversationItemLoaderEntity.participantMemberId = paramCursor.getString(27);
      paramConversationItemLoaderEntity.participantNumber = paramCursor.getString(28);
      paramConversationItemLoaderEntity.viberName = paramCursor.getString(29);
      paramConversationItemLoaderEntity.participantFlags = paramCursor.getInt(30);
      paramConversationItemLoaderEntity.replyBannerDraft = paramCursor.getString(21);
      paramConversationItemLoaderEntity.businessInboxFlags = paramCursor.getInt(22);
      paramConversationItemLoaderEntity.toNumber = paramCursor.getString(23);
      if (paramConversationItemLoaderEntity.isOneToOneWithPublicAccount())
      {
        paramConversationItemLoaderEntity.publicAccountId = paramCursor.getString(31);
        paramConversationItemLoaderEntity.publicAccountGroupId = paramCursor.getLong(32);
        paramConversationItemLoaderEntity.publicAccountGroupUri = paramCursor.getString(33);
        paramConversationItemLoaderEntity.publicAccountTagsLine = paramCursor.getString(34);
        if (paramCursor.getLong(35) <= 0L)
          break label511;
      }
    }
    label511: for (boolean bool = true; ; bool = false)
    {
      paramConversationItemLoaderEntity.publicAccountGroupExists = bool;
      paramConversationItemLoaderEntity.publicAccountGroupFlags = paramCursor.getInt(36);
      paramConversationItemLoaderEntity.publicAccountWebhookExist = paramCursor.getInt(37);
      paramConversationItemLoaderEntity.publicAccountAuthToken = paramCursor.getString(38);
      paramConversationItemLoaderEntity.publicAccountSubscriptionStatus = paramCursor.getInt(39);
      return;
      localUri = Uri.parse(str);
      break;
    }
  }

  private static void init(ConversationItemLoaderEntity paramConversationItemLoaderEntity, h paramh, com.viber.voip.model.entity.m paramm)
  {
    paramConversationItemLoaderEntity.id = paramh.getId();
    paramConversationItemLoaderEntity.conversationType = paramh.j();
    paramConversationItemLoaderEntity.flags = paramh.z();
    paramConversationItemLoaderEntity.groupName = paramh.o();
    paramConversationItemLoaderEntity.groupId = paramh.k();
    paramConversationItemLoaderEntity.groupRole = paramh.p();
    paramConversationItemLoaderEntity.iconUri = paramh.q();
    paramConversationItemLoaderEntity.messageDraft = paramh.B();
    paramConversationItemLoaderEntity.messageDraftSpans = paramh.C();
    paramConversationItemLoaderEntity.shareLocation = paramh.i();
    paramConversationItemLoaderEntity.smartNotification = paramh.v();
    paramConversationItemLoaderEntity.backgroundLandscape = paramh.s();
    paramConversationItemLoaderEntity.backgroundPortrait = paramh.t();
    paramConversationItemLoaderEntity.muteNotifications = paramh.x();
    paramConversationItemLoaderEntity.creatorParticipantInfoId = paramh.Z();
    paramConversationItemLoaderEntity.botReply = paramh.m();
    paramConversationItemLoaderEntity.timebombTime = paramh.ad();
    paramConversationItemLoaderEntity.replyBannerDraft = paramh.ag();
    paramConversationItemLoaderEntity.businessInboxFlags = paramh.ai();
    paramConversationItemLoaderEntity.toNumber = paramh.an();
    if (paramm != null)
    {
      paramConversationItemLoaderEntity.participantInfoId = paramm.getId();
      paramConversationItemLoaderEntity.contactName = paramm.getContactName();
      paramConversationItemLoaderEntity.viberName = paramm.getViberName();
      paramConversationItemLoaderEntity.contactId = paramm.i();
      paramConversationItemLoaderEntity.participantMemberId = paramm.a();
      paramConversationItemLoaderEntity.participantNumber = paramm.getNumber();
    }
  }

  public boolean canChangeGroupIcon()
  {
    if (isBroadcastListType());
    do
    {
      return false;
      if ((isCommunityType()) || (isPublicGroupType()))
        return cd.c(this.groupRole);
    }
    while (!isGroupType());
    return cd.b(this.groupRole);
  }

  public boolean canChangeGroupName()
  {
    if (isBroadcastListType())
      return true;
    if ((isCommunityType()) || (isPublicGroupType()))
      return cd.c(this.groupRole);
    if (isGroupType())
      return cd.b(this.groupRole);
    return false;
  }

  public boolean canCreatePoll()
  {
    boolean bool1 = true;
    if (isCommunityType())
    {
      boolean bool2;
      if (!cd.c(this.groupRole))
      {
        boolean bool3 = canWrite();
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = bool1;
      }
      return bool2;
    }
    if ((isGroupType()) && (!isSecret()));
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  public boolean canSendMessages(int paramInt)
  {
    return (!showInviteBanner()) && (canWrite()) && ((!isOneToOneWithPublicAccount()) || (isWebhookExist())) && (!isVlnConversation()) && (!isPendingInfo()) && (!isSystemConversation()) && (!isDisabledConversation()) && (!isCommunityBlocked()) && ((isGroupBehavior()) || (!cg.c(getNumber()))) && ((paramInt > 1) || (paramInt == 0) || (!isBroadcastListType()));
  }

  public boolean canSendTimeBomb()
  {
    return ((this.conversationType == 0) || (this.conversationType == 1) || (this.conversationType == 4)) && (!isOneToOneWithPublicAccount()) && (!isSystemConversation());
  }

  public boolean canWrite()
  {
    return cd.a(this.conversationType, this.groupRole);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getAppId()
  {
    return this.appId;
  }

  public String getBackgroundLandscape()
  {
    return this.backgroundLandscape;
  }

  public String getBackgroundPortrait()
  {
    return this.backgroundPortrait;
  }

  public int getBackgroundTextColor()
  {
    return this.backgroundTextColor;
  }

  public String getBotReply()
  {
    return this.botReply;
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

  public long getFlags()
  {
    return this.flags;
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

  public Uri getIconUri()
  {
    return this.iconUri;
  }

  public Uri getIconUriOrDefault()
  {
    return com.viber.voip.messages.m.a(this.conversationType, this.iconUri);
  }

  public long getId()
  {
    return this.id;
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

  public int getNativeChatType()
  {
    if (isSecret())
      return 1;
    return 0;
  }

  public String getNumber()
  {
    return this.participantNumber;
  }

  public long getParticipantInfoId()
  {
    return this.participantInfoId;
  }

  public String getParticipantMemberId()
  {
    return this.participantMemberId;
  }

  public String getParticipantName()
  {
    return dg.a(this);
  }

  public String getPublicAccountAuthToken()
  {
    return this.publicAccountAuthToken;
  }

  public int getPublicAccountGroupFlags()
  {
    return this.publicAccountGroupFlags;
  }

  public long getPublicAccountGroupId()
  {
    return this.publicAccountGroupId;
  }

  public String getPublicAccountGroupUri()
  {
    return this.publicAccountGroupUri;
  }

  public String getPublicAccountId()
  {
    return this.publicAccountId;
  }

  public String getPublicAccountTagsLine()
  {
    return this.publicAccountTagsLine;
  }

  public long getReadNotificationToken()
  {
    return this.readNotificationToken;
  }

  public String getReplyBannerDraft()
  {
    if (this.replyBannerDraft == null)
      return "";
    return this.replyBannerDraft;
  }

  public int getTimebombTime()
  {
    return this.timebombTime;
  }

  public String getToNumber()
  {
    return this.toNumber;
  }

  public String getViberName()
  {
    return this.viberName;
  }

  public boolean hasBusinessInboxOverlay()
  {
    return av.c(this.businessInboxFlags, 2);
  }

  public boolean hasIncomingMessages()
  {
    return av.c(this.flags, 7);
  }

  public boolean hasMessages()
  {
    return (hasOutgoingMessages()) || (hasIncomingMessages());
  }

  public boolean hasNewSpamHandlingLogic()
  {
    return av.c(this.flags, 11);
  }

  public boolean hasOutgoingMessages()
  {
    return av.c(this.flags, 5);
  }

  public boolean hasPublicAccountPublicChat()
  {
    return !av.d(getPublicAccountGroupFlags(), 16384);
  }

  public boolean hasPublicAccountSubscription()
  {
    return this.publicAccountSubscriptionStatus == 1;
  }

  public boolean isAdministratorRole()
  {
    return cd.c(this.groupRole);
  }

  public boolean isAgeRestrictedPublicAccount()
  {
    return av.d(this.publicAccountGroupFlags, 32);
  }

  public boolean isAnonymous()
  {
    return com.viber.voip.messages.m.a(this.conversationType, this.participantMemberId);
  }

  public boolean isBroadcastListType()
  {
    return this.conversationType == 4;
  }

  public boolean isCommunityBlocked()
  {
    return av.d(this.publicAccountGroupFlags, 134217728);
  }

  public boolean isCommunityType()
  {
    return this.conversationType == 5;
  }

  public boolean isConversation1on1()
  {
    return this.conversationType == 0;
  }

  public boolean isDisabledConversation()
  {
    return av.c(this.flags, 6);
  }

  public boolean isDisplayInvitationLinkToAll()
  {
    return false;
  }

  public boolean isEngagementConversation()
  {
    return av.c(this.flags, 21);
  }

  public boolean isFavouriteConversation()
  {
    return this.sortOrder == 1;
  }

  public boolean isGroupBehavior()
  {
    return this.conversationType != 0;
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

  public boolean isMarkedAsUnreadConversation()
  {
    return av.c(this.flags, 33);
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

  public boolean isNotJoinedCommunity()
  {
    return av.c(this.flags, 36);
  }

  public boolean isNotShareablePublicAccount()
  {
    return av.d(this.publicAccountGroupFlags, 1048576);
  }

  public boolean isOneToOneWithPublicAccount()
  {
    return av.c(this.flags, 19);
  }

  public boolean isOwner()
  {
    return false;
  }

  public boolean isPendingInfo()
  {
    return av.c(this.flags, 18);
  }

  public boolean isPendingRemoveParticipant()
  {
    return cd.i(this.participantFlags);
  }

  public boolean isPublicAccountGroupExists()
  {
    return this.publicAccountGroupExists;
  }

  public boolean isPublicGroupBehavior()
  {
    return (isPublicGroupType()) || (isCommunityType());
  }

  public boolean isPublicGroupType()
  {
    return com.viber.voip.messages.m.a(this.conversationType);
  }

  public boolean isRakutenSystemConversation()
  {
    return av.c(this.flags, 2);
  }

  public boolean isSecret()
  {
    return av.c(this.flags, 24);
  }

  public boolean isSecure()
  {
    return (!isSecureStateUnknown()) && (av.c(this.flags, 14));
  }

  public boolean isSecureStateUnknown()
  {
    return av.c(this.flags, 16);
  }

  public boolean isSeenConversation()
  {
    return av.c(this.flags, 23);
  }

  public boolean isShareLocation()
  {
    return this.shareLocation == 1;
  }

  public boolean isSmartNotificationOn()
  {
    return this.smartNotification == 1;
  }

  public boolean isSnoozedConversation()
  {
    return this.sortOrder == -1;
  }

  public boolean isSupportEnterConversationEvent()
  {
    return av.d(this.publicAccountGroupFlags, 268435456);
  }

  public boolean isSupportedReply()
  {
    return (canWrite()) && (!isSystemConversation()) && (!isDisabledConversation()) && (!isCommunityBlocked()) && (!isVlnConversation()) && (!isBroadcastListType()) && (!isSecret()) && (da.a(this.botReply));
  }

  public boolean isSystemConversation()
  {
    return av.c(this.flags, 0);
  }

  public boolean isSystemReplyableChat()
  {
    return av.c(this.flags, 13);
  }

  public boolean isUnknownParticipant()
  {
    return cd.a(this.contactId, this.participantFlags);
  }

  public boolean isVerified()
  {
    return av.d(this.publicAccountGroupFlags, 1);
  }

  public boolean isVlnConversation()
  {
    return av.c(this.flags, 34);
  }

  public boolean isWebhookExist()
  {
    return this.publicAccountWebhookExist == 1;
  }

  public boolean isYouInvitedAsMemberCommunity()
  {
    return av.c(this.flags, 37);
  }

  public void setReplyBannerDraft(String paramString)
  {
    this.replyBannerDraft = paramString;
  }

  public boolean showAddNewParticipantNumberBanner()
  {
    return av.c(this.flags, 26);
  }

  public boolean showAdminPromotedBanner()
  {
    return (canWrite()) && (av.c(this.flags, 30));
  }

  public boolean showInviteBanner()
  {
    return av.c(this.flags, 12);
  }

  public boolean showInvitePreviewMessageCommunity()
  {
    return av.c(this.flags, 38);
  }

  public boolean showM2MBlurb()
  {
    return av.c(this.flags, 35);
  }

  public boolean showNoPrivilegesBanner()
  {
    return (isCommunityType()) && (!canWrite()) && (!isDisabledConversation()) && (!av.c(this.flags, 28));
  }

  public boolean showPublicAccountBanner()
  {
    return !av.c(this.flags, 20);
  }

  public boolean showSpamBanner()
  {
    return !av.c(this.flags, 8);
  }

  public boolean showSpamOverlay()
  {
    return !av.c(this.flags, 9);
  }

  public boolean showSuperadminPromotedBanner()
  {
    return av.c(this.flags, 31);
  }

  public boolean showUrlSpamWarning()
  {
    return av.c(this.flags, 32);
  }

  public String toString()
  {
    int i = 1;
    StringBuilder localStringBuilder1 = new StringBuilder().append("ConversationItemLoaderEntity{id=").append(this.id).append(", conversationType=").append(this.conversationType).append(", flags=").append(this.flags).append(", groupName='").append(this.groupName).append('\'').append(", groupId=").append(this.groupId).append(", groupRole=").append(this.groupRole).append(", iconUri=").append(this.iconUri).append(", appId=").append(this.appId).append(", businessInboxFlags=").append(this.businessInboxFlags).append(", messageDraft='").append(this.messageDraft).append('\'').append(", shareLocation=").append(this.shareLocation).append(", smartNotification=").append(this.smartNotification).append(", backgroundLandscape='").append(this.backgroundLandscape).append('\'').append(", backgroundPortrait='").append(this.backgroundPortrait).append('\'').append(", backgroundTextColor=").append(this.backgroundTextColor).append(", muteNotifications=").append(this.muteNotifications).append(", timebombTime=").append(this.timebombTime).append(", toNumber=").append(this.toNumber).append(", favourite=");
    StringBuilder localStringBuilder2;
    if (this.sortOrder == i)
    {
      int k = i;
      localStringBuilder2 = localStringBuilder1.append(k).append(", snoozed=");
      if (this.sortOrder != -1)
        break label636;
    }
    while (true)
    {
      return i + ", creatorParticipantInfoId=" + this.creatorParticipantInfoId + ", botReply='" + this.botReply + '\'' + ", participantInfoId='" + this.participantInfoId + '\'' + ", contactName='" + this.contactName + '\'' + ", viberName='" + this.viberName + '\'' + ", participantFlags='" + this.participantFlags + '\'' + ", contactId=" + this.contactId + ", participantMemberId='" + this.participantMemberId + '\'' + ", participantNumber='" + this.participantNumber + '\'' + ", replyBannerDraft='" + this.replyBannerDraft + '\'' + ", publicAccountId='" + this.publicAccountId + '\'' + ", publicAccountGroupId=" + this.publicAccountGroupId + ", publicAccountGroupUri='" + this.publicAccountGroupUri + '\'' + ", publicAccountTagsLine='" + this.publicAccountTagsLine + '\'' + ", publicAccountGroupExists=" + this.publicAccountGroupExists + ", publicAccountGroupFlags=" + this.publicAccountGroupFlags + ", publicAccountWebhookExist=" + this.publicAccountWebhookExist + ", publicAccountAuthToken=" + this.publicAccountAuthToken + ", publicAccountSubscriptionStatus=" + this.publicAccountSubscriptionStatus + ", readNotificationToken=" + this.readNotificationToken + '}';
      int m = 0;
      break;
      label636: int j = 0;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeInt(this.conversationType);
    paramParcel.writeLong(paramInt);
    paramParcel.writeString(this.groupName);
    paramParcel.writeLong(this.groupId);
    paramParcel.writeInt(this.groupRole);
    paramParcel.writeParcelable(this.iconUri, paramInt);
    paramParcel.writeInt(this.appId);
    paramParcel.writeString(this.messageDraft);
    paramParcel.writeString(this.messageDraftSpans);
    paramParcel.writeInt(this.shareLocation);
    paramParcel.writeInt(this.smartNotification);
    paramParcel.writeString(this.backgroundLandscape);
    paramParcel.writeString(this.backgroundPortrait);
    paramParcel.writeInt(this.backgroundTextColor);
    paramParcel.writeInt(this.muteNotifications);
    paramParcel.writeLong(this.readNotificationToken);
    paramParcel.writeInt(this.timebombTime);
    paramParcel.writeInt(this.sortOrder);
    paramParcel.writeInt(this.businessInboxFlags);
    paramParcel.writeString(this.toNumber);
    paramParcel.writeLong(this.creatorParticipantInfoId);
    paramParcel.writeString(this.botReply);
    paramParcel.writeString(this.contactName);
    paramParcel.writeLong(this.contactId);
    paramParcel.writeString(this.viberName);
    paramParcel.writeInt(this.participantFlags);
    paramParcel.writeLong(this.participantInfoId);
    paramParcel.writeString(this.participantMemberId);
    paramParcel.writeString(this.participantNumber);
    paramParcel.writeString(this.publicAccountId);
    paramParcel.writeLong(this.publicAccountGroupId);
    paramParcel.writeString(this.publicAccountGroupUri);
    paramParcel.writeString(this.publicAccountTagsLine);
    if (this.publicAccountGroupExists);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.publicAccountGroupFlags);
      paramParcel.writeInt(this.publicAccountWebhookExist);
      paramParcel.writeString(this.publicAccountAuthToken);
      paramParcel.writeInt(this.publicAccountSubscriptionStatus);
      paramParcel.writeString(this.replyBannerDraft);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ConversationItemLoaderEntity
 * JD-Core Version:    0.6.2
 */