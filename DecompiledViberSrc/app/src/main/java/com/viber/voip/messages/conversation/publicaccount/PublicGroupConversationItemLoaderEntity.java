package com.viber.voip.messages.conversation.publicaccount;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.jni.LocationInfo;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.publicaccount.MyCommunitySettings;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.m;
import com.viber.voip.model.entity.r;
import com.viber.voip.publicaccount.entity.PublicAccount.GlobalPermissions;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;

public class PublicGroupConversationItemLoaderEntity extends ConversationItemLoaderEntity
  implements Parcelable
{
  public static final int BACKGROUND_INDX = 33;
  public static final int CATEGORY_ID_INDX = 41;
  public static final int CATEGORY_NAME_INDX = 52;
  public static final int COMMUNITY_PRIVILEGES_INDX = 48;
  public static final int CONVERSATION_BACKGROUND_LANDSCAPE_INDX = 9;
  public static final int CONVERSATION_BACKGROUND_PORTRAIT_INDX = 10;
  public static final int CONVERSATION_BACKGROUNG_TEXT_COLOR_INDX = 11;
  public static final int CONVERSATION_CREATOR_PARTICIPANT_INFO_ID_INDX = 19;
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
  public static final int CONVERSATION_REPLY_BANNER_DRAFT_INDX = 18;
  public static final int CONVERSATION_SHARE_LOCATION_INDX = 7;
  public static final int CONVERSATION_SMART_NOTIFICATION_INDX = 8;
  public static final int CONVERSATION_TYPE_INDX = 1;
  public static final int CONVERSATION_UNREAD_MESSAGE_COUNT_INDX = 14;
  public static final int COUNTRY_CODE_INDX = 43;
  public static final Parcelable.Creator<PublicGroupConversationItemLoaderEntity> CREATOR = new Parcelable.Creator()
  {
    public PublicGroupConversationItemLoaderEntity a(Parcel paramAnonymousParcel)
    {
      return new PublicGroupConversationItemLoaderEntity(paramAnonymousParcel);
    }

    public PublicGroupConversationItemLoaderEntity[] a(int paramAnonymousInt)
    {
      return new PublicGroupConversationItemLoaderEntity[paramAnonymousInt];
    }
  };
  public static final int CRM_INDX = 36;
  public static final int EMAIL_INDX = 40;
  public static final int EXTRA_FLAGS_INDX = 35;
  public static final int EXTRA_INFO_INDX = 47;
  public static final int FAVOURITE_CHAT_INDX = 17;
  public static final int GROUP_ADDRESS_INDX = 38;
  public static final int GROUP_ENTER_COUNT_INDEX = 30;
  public static final int GROUP_LAT_INDX = 44;
  public static final int GROUP_LNG_INDX = 45;
  public static final int INVITER_NUMBER_INDX = 31;
  public static final int LAST_LOCAL_MSG_ID_INDX = 51;
  public static final int LAST_SERVER_MSG_ID_INDX = 34;
  public static final int MY_SETTINGS_INDX = 50;
  public static final String[] PROJECTIONS = { "conversations._id", "conversations.conversation_type", "conversations.flags", "conversations.name", "conversations.group_id", "conversations.message_draft", "conversations.msg_draft_spans", "conversations.share_location", "conversations.smart_notification", "conversations.background_landscape", "conversations.background_portrait", "conversations.background_text_color", "conversations.mute_notification", "conversations.read_notification_token", "(CASE WHEN (conversations.conversation_type = 5 OR conversations.conversation_type = 2) THEN ( MAX( public_accounts.local_message_id, public_accounts.server_message_id ) - public_accounts.last_read_message_id ) ELSE (IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime <> 1007 AND [messages].[extra_flags] & 4194304 = 0 AND messages.extra_mime <> 1008 AND messages.extra_mime <> 1002 AND messages.deleted=0 ), 0)) END)", "conversations.group_role", "conversations.icon_id", "conversations.favourite_conversation", "conversations.reply_banner_draft", "conversations.creator_participant_id", "public_accounts.public_account_id", "public_accounts.group_uri", "public_accounts.tag_line", "public_accounts.verified", "public_accounts.webhook_exists", "public_accounts.auth_token", "public_accounts.subscription_status", "public_accounts.watchers_count", "public_accounts.watchers_count_ref", "public_accounts.watchers_count_ref_date", "public_accounts.group_enter_count", "public_accounts.inviter", "public_accounts.revision", "public_accounts.background_id", "public_accounts.server_message_id", "public_accounts.pg_extra_flags", "public_accounts.crm", "public_accounts.tags", "public_accounts.location_address", "public_accounts.website", "public_accounts.email", "public_accounts.category_id", "public_accounts.subcategory_id", "public_accounts.country", "public_accounts.location_lat", "public_accounts.location_lng", "public_accounts.subscribers_count", "public_accounts.extra_info", "public_accounts.community_privileges", "public_accounts._id", "public_accounts.my_settings", "public_accounts.local_message_id" };
  public static final int PUBLIC_ACCOUNT_AUTH_TOKEN_INDX = 25;
  public static final int PUBLIC_ACCOUNT_GROUP_FLAGS_INDX = 23;
  public static final int PUBLIC_ACCOUNT_GROUP_URI_INDX = 21;
  public static final int PUBLIC_ACCOUNT_ID_INDX = 20;
  public static final int PUBLIC_ACCOUNT_ROW_ID_INDX = 49;
  public static final int PUBLIC_ACCOUNT_SUBSCRIPTION_INDX = 26;
  public static final int PUBLIC_ACCOUNT_TAG_LINE_INDX = 22;
  public static final int PUBLIC_ACCOUNT_WEBHOOK_INDX = 24;
  public static final int REVISION_INDX = 32;
  public static final int SUBCATEGORY_ID_INDX = 42;
  public static final int SUBCATEGORY_NAME_INDX = 53;
  public static final int SUBSCRIBERS_COUNT_INDX = 46;
  public static final int TAGS_INDX = 37;
  public static final int WATCHERS_COUNT_INDX = 27;
  public static final int WATCHERS_COUNT_REF_DATE_INDEX = 29;
  public static final int WATCHERS_COUNT_REF_INDX = 28;
  public static final int WEB_SITE_INDX = 39;
  private String addressString;
  private String backgroundId;
  private String categoryId;
  private String categoryName;
  private long communityPrivileges;
  private String countryCode;
  private String crm;
  private String email;
  private int extraFlags;
  private String extraInfo;
  private int groupEnterCount;
  private String inviter;
  private int lastLocalMsgId;
  private int lastServerMsgId;
  private LocationInfo locationInfo;
  private int locationLat;
  private int locationLng;
  private MyCommunitySettings mySettings;
  private String mySettingsJson;
  private long publicAccounRowId;
  private int revision;
  private String subcategoryId;
  private String subcategoryName;
  private int subscribersCount;
  private String tags;
  private int unreadMessagesCount;
  private int watchersCount;
  private int watchersCountRef;
  private long watchersCountRefDate;
  private String website;

  public PublicGroupConversationItemLoaderEntity(Cursor paramCursor)
  {
    this.id = paramCursor.getLong(0);
    this.conversationType = paramCursor.getInt(1);
    this.flags = paramCursor.getLong(2);
    this.groupName = paramCursor.getString(3);
    this.groupId = paramCursor.getLong(4);
    this.messageDraft = paramCursor.getString(5);
    this.messageDraftSpans = paramCursor.getString(6);
    this.shareLocation = paramCursor.getInt(7);
    this.smartNotification = paramCursor.getInt(8);
    this.backgroundLandscape = paramCursor.getString(9);
    this.backgroundPortrait = paramCursor.getString(10);
    this.backgroundTextColor = paramCursor.getInt(11);
    this.muteNotifications = paramCursor.getInt(12);
    this.unreadMessagesCount = paramCursor.getInt(14);
    this.groupRole = paramCursor.getInt(15);
    String str = paramCursor.getString(16);
    if (da.a(str));
    for (Uri localUri = null; ; localUri = Uri.parse(str))
    {
      this.iconUri = localUri;
      this.sortOrder = paramCursor.getInt(17);
      this.replyBannerDraft = paramCursor.getString(18);
      this.publicAccountId = paramCursor.getString(20);
      this.publicAccountGroupId = this.groupId;
      this.publicAccountGroupUri = paramCursor.getString(21);
      this.publicAccountTagsLine = paramCursor.getString(22);
      this.publicAccountGroupFlags = paramCursor.getInt(23);
      this.publicAccountWebhookExist = paramCursor.getInt(24);
      this.publicAccountAuthToken = paramCursor.getString(25);
      this.publicAccountSubscriptionStatus = paramCursor.getInt(26);
      this.watchersCount = paramCursor.getInt(27);
      this.watchersCountRef = paramCursor.getInt(28);
      this.watchersCountRefDate = paramCursor.getLong(29);
      this.groupEnterCount = paramCursor.getInt(30);
      this.inviter = paramCursor.getString(31);
      this.revision = paramCursor.getInt(32);
      this.backgroundId = paramCursor.getString(33);
      this.lastServerMsgId = paramCursor.getInt(34);
      this.extraFlags = paramCursor.getInt(35);
      this.crm = paramCursor.getString(36);
      this.tags = paramCursor.getString(37);
      this.addressString = paramCursor.getString(38);
      this.website = paramCursor.getString(39);
      this.email = paramCursor.getString(40);
      this.categoryId = paramCursor.getString(41);
      this.subcategoryId = paramCursor.getString(42);
      this.countryCode = paramCursor.getString(43);
      this.locationLat = paramCursor.getInt(44);
      this.locationLng = paramCursor.getInt(45);
      this.locationInfo = createLocation(this.locationLat, this.locationLng);
      this.subscribersCount = paramCursor.getInt(46);
      this.extraInfo = paramCursor.getString(47);
      this.communityPrivileges = paramCursor.getLong(48);
      this.publicAccounRowId = paramCursor.getLong(49);
      this.mySettingsJson = paramCursor.getString(50);
      this.lastLocalMsgId = paramCursor.getInt(51);
      this.creatorParticipantInfoId = paramCursor.getLong(19);
      if (paramCursor.getColumnCount() > 52)
      {
        this.categoryName = paramCursor.getString(52);
        this.subcategoryName = paramCursor.getString(53);
      }
      return;
    }
  }

  PublicGroupConversationItemLoaderEntity(Parcel paramParcel)
  {
    super(paramParcel);
    this.unreadMessagesCount = paramParcel.readInt();
    this.backgroundId = paramParcel.readString();
    this.watchersCount = paramParcel.readInt();
    this.watchersCountRef = paramParcel.readInt();
    this.watchersCountRefDate = paramParcel.readLong();
    this.inviter = paramParcel.readString();
    this.revision = paramParcel.readInt();
    this.lastServerMsgId = paramParcel.readInt();
    this.groupEnterCount = paramParcel.readInt();
    this.extraFlags = paramParcel.readInt();
    this.crm = paramParcel.readString();
    this.tags = paramParcel.readString();
    this.addressString = paramParcel.readString();
    this.website = paramParcel.readString();
    this.email = paramParcel.readString();
    this.categoryId = paramParcel.readString();
    this.categoryName = paramParcel.readString();
    this.subcategoryId = paramParcel.readString();
    this.subcategoryName = paramParcel.readString();
    this.countryCode = paramParcel.readString();
    this.locationInfo = ((LocationInfo)paramParcel.readParcelable(LocationInfo.class.getClassLoader()));
    this.locationLat = paramParcel.readInt();
    this.locationLng = paramParcel.readInt();
    this.subscribersCount = paramParcel.readInt();
    this.extraInfo = paramParcel.readString();
    this.communityPrivileges = paramParcel.readLong();
    this.publicAccounRowId = paramParcel.readLong();
    this.mySettingsJson = paramParcel.readString();
    this.mySettings = ((MyCommunitySettings)paramParcel.readParcelable(MyCommunitySettings.class.getClassLoader()));
  }

  public PublicGroupConversationItemLoaderEntity(h paramh, m paramm, r paramr)
  {
    super(paramh, paramm);
    if (paramr != null)
    {
      this.watchersCount = paramr.j();
      this.watchersCountRef = paramr.k();
      this.watchersCountRefDate = paramr.l();
      this.groupEnterCount = paramr.m();
      this.publicAccountGroupUri = paramr.d();
      this.inviter = paramr.D();
      this.publicAccountGroupFlags = paramr.x();
      this.extraFlags = paramr.A();
      this.revision = paramr.e();
      this.backgroundId = paramr.f();
      this.lastServerMsgId = Math.max(paramr.n(), paramr.v());
      this.lastLocalMsgId = paramr.v();
      this.crm = paramr.p();
      this.communityPrivileges = paramr.T();
      this.mySettingsJson = paramr.W();
    }
  }

  public PublicGroupConversationItemLoaderEntity(h paramh, r paramr)
  {
    this(paramh, null, paramr);
  }

  private LocationInfo createLocation(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
      return new LocationInfo(paramInt1, paramInt2);
    return null;
  }

  public boolean canWrite()
  {
    return cd.a(this.conversationType, this.groupRole, PublicAccount.GlobalPermissions.canWrite(this.communityPrivileges));
  }

  public String getAddressString()
  {
    return this.addressString;
  }

  public String getBackgroundId()
  {
    return this.backgroundId;
  }

  public String getCategoryId()
  {
    return this.categoryId;
  }

  public String getCategoryName()
  {
    return this.categoryName;
  }

  public long getCommunityPrivileges()
  {
    return this.communityPrivileges;
  }

  public String getCountryCode()
  {
    return this.countryCode;
  }

  public String getCrm()
  {
    return this.crm;
  }

  public String getEmail()
  {
    return this.email;
  }

  public String getExtraInfo()
  {
    return this.extraInfo;
  }

  public int getGroupEnterCount()
  {
    return this.groupEnterCount;
  }

  public String getInviter()
  {
    return this.inviter;
  }

  public int getLastLocalMsgId()
  {
    return this.lastLocalMsgId;
  }

  public int getLastServerMsgId()
  {
    return this.lastServerMsgId;
  }

  public LocationInfo getLocation()
  {
    return this.locationInfo;
  }

  public int getLocationLat()
  {
    return this.locationLat;
  }

  public int getLocationLng()
  {
    return this.locationLng;
  }

  public MyCommunitySettings getMySettings()
  {
    if ((this.mySettings == null) && (!da.a(this.mySettingsJson)))
      this.mySettings = ((MyCommunitySettings)e.e().a().a(this.mySettingsJson));
    return this.mySettings;
  }

  public String getMySettingsJson()
  {
    return this.mySettingsJson;
  }

  public long getPublicAccounRowId()
  {
    return this.publicAccounRowId;
  }

  public int getPublicGroupExtraFlags()
  {
    return this.extraFlags;
  }

  public int getPublicGroupFlags()
  {
    return this.publicAccountGroupFlags;
  }

  public int getRevision()
  {
    return this.revision;
  }

  public String getSubcategoryId()
  {
    return this.subcategoryId;
  }

  public String getSubcategoryName()
  {
    return this.subcategoryName;
  }

  public int getSubscribersCount()
  {
    return this.subscribersCount;
  }

  public String getTags()
  {
    return this.tags;
  }

  public String[] getTagsArray()
  {
    return r.h(this.tags);
  }

  public int getUnreadMessagesCount()
  {
    return this.unreadMessagesCount;
  }

  public int getWatchersCount()
  {
    return this.watchersCount;
  }

  public int getWatchersCountRef()
  {
    return this.watchersCountRef;
  }

  public long getWatchersCountRefDate()
  {
    return this.watchersCountRefDate;
  }

  public String getWebsite()
  {
    return this.website;
  }

  public boolean hasPublicChat()
  {
    return !av.d(this.publicAccountGroupFlags, 16384);
  }

  public boolean isAgeRestricted()
  {
    return av.d(this.publicAccountGroupFlags, 32);
  }

  public boolean isDisplayInvitationLinkToAll()
  {
    return av.c(this.extraFlags, 1);
  }

  public boolean isNotSearchable()
  {
    return av.d(this.publicAccountGroupFlags, 4);
  }

  public boolean isNotShareable()
  {
    return av.d(this.publicAccountGroupFlags, 1048576);
  }

  public boolean isOpenCommunity()
  {
    return av.d(this.publicAccountGroupFlags, 2097152);
  }

  public boolean isPendingRole()
  {
    return av.c(this.extraFlags, 0);
  }

  public boolean shouldShowNotPublishedPublicAccountBanner()
  {
    return (isNotSearchable()) && (2 == getGroupRole());
  }

  public String toString()
  {
    return super.toString() + "\nPublicGroupConversationItemLoaderEntity{backgroundId='" + this.backgroundId + '\'' + ", watchersCount=" + this.watchersCount + ", watchersCountRef=" + this.watchersCountRef + ", watchersCountRefDate=" + this.watchersCountRefDate + ", inviter='" + this.inviter + '\'' + ", revision=" + this.revision + ", lastServerMsgId=" + this.lastServerMsgId + ", groupEnterCount=" + this.groupEnterCount + ", extraFlags=" + this.extraFlags + ", crm='" + this.crm + '\'' + ", tags='" + this.tags + '\'' + ", addressString='" + this.addressString + '\'' + ", website='" + this.website + '\'' + ", email='" + this.email + '\'' + ", categoryId='" + this.categoryId + '\'' + ", categoryName='" + this.categoryName + '\'' + ", subcategoryId='" + this.subcategoryId + '\'' + ", subcategoryName='" + this.subcategoryName + '\'' + ", countryCode='" + this.countryCode + '\'' + ", locationInfo=" + this.locationInfo + ", locationLat=" + this.locationLat + ", locationLng=" + this.locationLng + ", subscribersCount=" + this.subscribersCount + ", extraInfo='" + this.extraInfo + '\'' + ", communityPrivileges='" + this.communityPrivileges + '\'' + ", mySettingsJson='" + this.mySettingsJson + '\'' + ", unreadMessagesCount=" + this.unreadMessagesCount + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.unreadMessagesCount);
    paramParcel.writeString(this.backgroundId);
    paramParcel.writeInt(this.watchersCount);
    paramParcel.writeInt(this.watchersCountRef);
    paramParcel.writeLong(this.watchersCountRefDate);
    paramParcel.writeString(this.inviter);
    paramParcel.writeInt(this.revision);
    paramParcel.writeInt(this.lastServerMsgId);
    paramParcel.writeInt(this.groupEnterCount);
    paramParcel.writeInt(this.extraFlags);
    paramParcel.writeString(this.crm);
    paramParcel.writeString(this.tags);
    paramParcel.writeString(this.addressString);
    paramParcel.writeString(this.website);
    paramParcel.writeString(this.email);
    paramParcel.writeString(this.categoryId);
    paramParcel.writeString(this.categoryName);
    paramParcel.writeString(this.subcategoryId);
    paramParcel.writeString(this.subcategoryName);
    paramParcel.writeString(this.countryCode);
    paramParcel.writeParcelable(this.locationInfo, paramInt);
    paramParcel.writeInt(this.locationLat);
    paramParcel.writeInt(this.locationLng);
    paramParcel.writeInt(this.subscribersCount);
    paramParcel.writeString(this.extraInfo);
    paramParcel.writeLong(this.communityPrivileges);
    paramParcel.writeLong(this.publicAccounRowId);
    paramParcel.writeString(this.mySettingsJson);
    paramParcel.writeParcelable(this.mySettings, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity
 * JD-Core Version:    0.6.2
 */