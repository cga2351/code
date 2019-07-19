package com.viber.voip.model.entity;

import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.LocationInfo;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.c;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.Edit;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.InviteCommunityInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaMetadata;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.flatbuffers.model.msginfo.Poll;
import com.viber.voip.flatbuffers.model.msginfo.Quote;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.l;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.impl.MessageEntityHelper;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.util.av;
import com.viber.voip.util.bg.a;
import com.viber.voip.util.da;
import com.viber.voip.util.n;
import com.viber.voip.util.upload.ObjectId;
import org.json.JSONException;

public class MessageEntity extends b
  implements Parcelable
{
  public static final Parcelable.Creator<MessageEntity> CREATOR = new Parcelable.Creator()
  {
    public MessageEntity a(Parcel paramAnonymousParcel)
    {
      return new MessageEntity(paramAnonymousParcel);
    }

    public MessageEntity[] a(int paramAnonymousInt)
    {
      return new MessageEntity[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  private String body;
  private long broadcastMessageId;
  private String bucket;
  private ConferenceInfo conferenceInfo;
  private long conversationId;
  private int conversationType;
  private int count;
  private long date;
  private int deleted;
  private String description;
  private String downloadId;
  private long duration;
  private long extraFlags;
  private int extraStatus;
  private int flag;
  private FormattedMessage formattedMessage;
  private long groupId;
  private int lat;
  private int likesCount;
  private int lng;
  private long mBenchmarkTrackingSequence;
  private QuotedMessageData mQuotedMessageData;
  private String mediaUri;
  private String memberId;
  private int messageGlobalId;
  private MsgInfo messageInfo;
  private int messageSeq;
  private long messageToken;
  private int mimeType;
  private ObjectId objectId = ObjectId.EMPTY;
  private int opened;
  private long orderKey;
  private long participantId;
  private String rawMessageInfo;
  private String rawQuotedMessageData;
  private long readMessageTime;
  private int scrollPosition;
  private String spans;
  private int status;
  private int syncRead;
  private int timebombInSec;
  private int type;
  private int unread = 1;

  public MessageEntity()
  {
  }

  protected MessageEntity(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.groupId = paramParcel.readLong();
    this.conversationId = paramParcel.readLong();
    this.conversationType = paramParcel.readInt();
    this.participantId = paramParcel.readLong();
    this.memberId = paramParcel.readString();
    this.date = paramParcel.readLong();
    this.unread = paramParcel.readInt();
    this.status = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.body = paramParcel.readString();
    this.opened = paramParcel.readInt();
    this.description = paramParcel.readString();
    this.messageToken = paramParcel.readLong();
    this.orderKey = paramParcel.readLong();
    this.flag = paramParcel.readInt();
    this.messageSeq = paramParcel.readInt();
    this.lat = paramParcel.readInt();
    this.lng = paramParcel.readInt();
    this.deleted = paramParcel.readInt();
    this.count = paramParcel.readInt();
    this.mediaUri = paramParcel.readString();
    this.mimeType = paramParcel.readInt();
    this.extraStatus = paramParcel.readInt();
    this.objectId = ((ObjectId)paramParcel.readParcelable(ObjectId.class.getClassLoader()));
    this.downloadId = paramParcel.readString();
    this.bucket = paramParcel.readString();
    this.duration = paramParcel.readLong();
    this.syncRead = paramParcel.readInt();
    this.extraFlags = paramParcel.readLong();
    this.messageGlobalId = paramParcel.readInt();
    this.rawMessageInfo = paramParcel.readString();
    this.spans = paramParcel.readString();
    this.likesCount = paramParcel.readInt();
    this.timebombInSec = paramParcel.readInt();
    this.readMessageTime = paramParcel.readLong();
    this.scrollPosition = paramParcel.readInt();
    this.broadcastMessageId = paramParcel.readLong();
    this.rawQuotedMessageData = paramParcel.readString();
  }

  public static String humanReadableExtraFlags(long paramLong)
  {
    return Long.toString(paramLong);
  }

  public static String humanReadableFlags(int paramInt)
  {
    return Integer.toString(paramInt);
  }

  public void addExtraFlag(int paramInt)
  {
    this.extraFlags = av.a(this.extraFlags, paramInt);
  }

  public int describeContents()
  {
    return 0;
  }

  public long getBenchmarkTrackingSequence()
  {
    return this.mBenchmarkTrackingSequence;
  }

  public String getBody()
  {
    return this.body;
  }

  public long getBroadcastMessageId()
  {
    return this.broadcastMessageId;
  }

  public String getBucket()
  {
    return this.bucket;
  }

  public ConferenceInfo getConferenceInfo()
  {
    if (this.conferenceInfo == null)
      this.conferenceInfo = ((ConferenceInfo)e.c().a().a(this.description));
    return this.conferenceInfo;
  }

  public ContentValues getContentValues()
  {
    return MessageEntityHelper.getContentValues(this);
  }

  public long getConversationId()
  {
    return this.conversationId;
  }

  public int getConversationType()
  {
    return this.conversationType;
  }

  public int getCount()
  {
    return this.count;
  }

  public String getCustomIncomingMessageSound()
  {
    return getMessageInfo().getPublicAccountMsgInfo().getSound();
  }

  public long getDate()
  {
    return this.date;
  }

  public int getDeleted()
  {
    return this.deleted;
  }

  public String getDescription()
  {
    if (this.description == null)
      return "";
    return this.description;
  }

  public String getDownloadId()
  {
    return this.downloadId;
  }

  public String getDownloadIdOrPublicAccountDownloadUrl()
  {
    if (isConvertedFromPublicAccountFormat())
      return getMessageInfo().getUrl();
    return this.downloadId;
  }

  public long getDuration()
  {
    return this.duration;
  }

  public EncryptionParams getEncryptionParams()
  {
    return EncryptionParams.unserializeCrossPlatformEncryptionParams(getEncryptionParamsSerialized());
  }

  public String getEncryptionParamsSerialized()
  {
    MsgInfo localMsgInfo = getMessageInfo();
    if (localMsgInfo == null)
      return null;
    return localMsgInfo.getMediaMetadata().getEncParams();
  }

  public long getExtraFlags()
  {
    return this.extraFlags;
  }

  public int getExtraStatus()
  {
    return this.extraStatus;
  }

  public int getFlag()
  {
    return this.flag;
  }

  public FormattedMessage getFormattedMessage()
  {
    return this.formattedMessage;
  }

  public long getGroupId()
  {
    return this.groupId;
  }

  public int getLat()
  {
    return this.lat;
  }

  public int getLikesCount()
  {
    return this.likesCount;
  }

  public int getLng()
  {
    return this.lng;
  }

  public LocationInfo getLocation()
  {
    return new LocationInfo(getLat(), getLng());
  }

  public int getMediaFlag()
  {
    if (av.c(this.extraFlags, 1))
      return 1;
    if (av.c(this.extraFlags, 2))
      return 2;
    if (1003 == this.mimeType)
      return 32;
    if (1004 == this.mimeType)
      return 64;
    return 0;
  }

  public String getMediaUri()
  {
    return this.mediaUri;
  }

  public String getMemberId()
  {
    if (this.memberId == null)
      return "";
    return this.memberId;
  }

  public int getMessageGlobalId()
  {
    return this.messageGlobalId;
  }

  public MsgInfo getMessageInfo()
  {
    if (this.messageInfo == null)
      this.messageInfo = ((MsgInfo)e.a().a().a(this.rawMessageInfo));
    return this.messageInfo;
  }

  public MsgInfo getMessageInfoIfParsed()
  {
    return this.messageInfo;
  }

  public int getMessageSeq()
  {
    return this.messageSeq;
  }

  public a getMessageSoundOptions()
  {
    if (isOneToOneChatWithPa())
    {
      String str = getCustomIncomingMessageSound();
      if (str == null)
        return a.a;
      if ("".equals(str))
        return a.b;
      return a.c;
    }
    return a.a;
  }

  public long getMessageToken()
  {
    return this.messageToken;
  }

  public int getMimeType()
  {
    return this.mimeType;
  }

  public FileInfo getMsgInfoFileInfo()
  {
    return getMessageInfo().getFileInfo();
  }

  public int getNativeChatType()
  {
    if (isSecretMessage())
      return 1;
    return 0;
  }

  public ObjectId getObjectId()
  {
    return this.objectId;
  }

  public int getOpened()
  {
    return this.opened;
  }

  public long getOrderKey()
  {
    return this.orderKey;
  }

  public long getParticipantId()
  {
    return this.participantId;
  }

  public String getPublicAccountInfoName()
  {
    return m.a(getMessageInfo());
  }

  public String getPublicAccountMediaUrl()
  {
    return getMessageInfo().getUrl();
  }

  public Quote getQuote()
  {
    return getMessageInfo().getQuote();
  }

  public QuotedMessageData getQuotedMessageData()
  {
    if (this.mQuotedMessageData == null)
      this.mQuotedMessageData = ((QuotedMessageData)e.b().a().a(this.rawQuotedMessageData));
    return this.mQuotedMessageData;
  }

  public String getRawMessageInfo()
  {
    if (TextUtils.isEmpty(this.rawMessageInfo))
      return "{}";
    return this.rawMessageInfo;
  }

  public String getRawQuotedMessageData()
  {
    if (TextUtils.isEmpty(this.rawQuotedMessageData))
      return "{}";
    return this.rawQuotedMessageData;
  }

  public long getReadMessageTime()
  {
    return this.readMessageTime;
  }

  public int getScrollPosition()
  {
    return this.scrollPosition;
  }

  public String getSpans()
  {
    return this.spans;
  }

  public int getStatus()
  {
    return this.status;
  }

  public int getSyncRead()
  {
    return this.syncRead;
  }

  public String getTable()
  {
    return "messages";
  }

  public Uri getThumbnailUri()
  {
    try
    {
      if (!TextUtils.isEmpty(getBody()))
      {
        Uri localUri2 = Uri.parse(getBody());
        localUri1 = localUri2;
        return localUri1;
      }
      Uri localUri1 = null;
    }
    finally
    {
    }
  }

  public int getTimebombInSec()
  {
    return this.timebombInSec;
  }

  public int getType()
  {
    return this.type;
  }

  public int getUnread()
  {
    return this.unread;
  }

  public String getUrlMessageThumbnailContentType()
  {
    String str;
    if (!isUrlMessage())
      str = null;
    MsgInfo localMsgInfo;
    do
    {
      return str;
      localMsgInfo = getMessageInfo();
      str = localMsgInfo.getThumbnailContentType();
    }
    while (!TextUtils.isEmpty(str));
    return localMsgInfo.getContentType();
  }

  public boolean hasAnyStatus(int[] paramArrayOfInt)
  {
    return n.a(getStatus(), paramArrayOfInt);
  }

  public boolean hasConferenceInfo()
  {
    return !c.a(this.description);
  }

  public boolean hasExtraFlag(int paramInt)
  {
    return av.c(this.extraFlags, paramInt);
  }

  public boolean hasExtraFlagNeedFetchUrlByBody()
  {
    return av.c(this.extraFlags, 18);
  }

  public boolean hasExtraStatus()
  {
    return 3 != this.extraStatus;
  }

  public boolean hasManagedMedia()
  {
    return (isVideo()) || (isImage()) || (isFile()) || (isVideoPttBehavior()) || (isAudioPtt()) || (isVoiceMessage());
  }

  public boolean hasMyLike()
  {
    return av.c(this.extraFlags, 12);
  }

  public boolean hasQuote()
  {
    return getMessageInfo().getQuote() != null;
  }

  public boolean hasYouWasMentionedInRepliedMessage()
  {
    return av.c(this.extraFlags, 36);
  }

  public boolean isActivateSecondaryNotification()
  {
    return (0x100 & this.flag) != 0;
  }

  public boolean isActiveOneToOneBroadcast()
  {
    return this.broadcastMessageId > 0L;
  }

  public boolean isAggregatedMessage()
  {
    return av.c(this.extraFlags, 10);
  }

  public boolean isAudioPtt()
  {
    return 2 == this.mimeType;
  }

  public boolean isBroadcastList()
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

  public boolean isConvertedFromPublicAccountFormat()
  {
    return av.c(this.extraFlags, 25);
  }

  public boolean isDeletePinMessage()
  {
    boolean bool1 = isPinMessage();
    boolean bool2 = false;
    if (bool1)
    {
      Pin localPin = getMessageInfo().getPin();
      bool2 = false;
      if (localPin != null)
      {
        Pin.a locala1 = Pin.a.DELETE;
        Pin.a locala2 = localPin.getAction();
        bool2 = false;
        if (locala1 == locala2)
          bool2 = true;
      }
    }
    return bool2;
  }

  public boolean isDeleted()
  {
    return this.deleted == 1;
  }

  public boolean isEditMessage()
  {
    Edit localEdit = getMessageInfo().getEdit();
    return (localEdit != null) && (localEdit.getToken() > 0L);
  }

  public boolean isEditedMessage()
  {
    return av.c(this.extraFlags, 37);
  }

  public boolean isEmpty()
  {
    return 1007 == this.mimeType;
  }

  public boolean isEngagementMessage()
  {
    return av.c(this.extraFlags, 26);
  }

  public boolean isExternalAppMessage()
  {
    return (0x400 & this.flag) != 0;
  }

  public boolean isFeaturePromotion()
  {
    return av.c(this.extraFlags, 35);
  }

  public boolean isFile()
  {
    return (10 == this.mimeType) || (isGifFile()) || (isVoiceMessage());
  }

  public boolean isFormattedMessage()
  {
    return (7 == this.mimeType) || (isShareContactMessage()) || (isUrlMessage());
  }

  public boolean isForwardedFromCommunity()
  {
    return av.c(this.extraFlags, 40);
  }

  public boolean isForwardedFromPG()
  {
    return av.c(this.extraFlags, 7);
  }

  public boolean isForwardedMessage()
  {
    return av.c(this.extraFlags, 6);
  }

  public boolean isFromBackup()
  {
    return av.c(this.extraFlags, 19);
  }

  public boolean isFromPublicAccount()
  {
    return (isIncoming()) && (isPublicAccount());
  }

  public boolean isGifFile()
  {
    return 1005 == this.mimeType;
  }

  public boolean isGifUrlMessage()
  {
    return bg.a.d(getUrlMessageThumbnailContentType());
  }

  public boolean isGroupBehavior()
  {
    return this.conversationType != 0;
  }

  public boolean isGroupType()
  {
    return m.f(this.conversationType);
  }

  public boolean isHiddenChat()
  {
    return av.c(this.extraFlags, 17);
  }

  public boolean isHiddenContent()
  {
    return (isHiddenChat()) || (isSecretMessage());
  }

  public boolean isImage()
  {
    return (1 == this.mimeType) || (isWinkImage());
  }

  public boolean isIncoming()
  {
    return this.type == 0;
  }

  public boolean isIncomingOneToOneBroadcast()
  {
    return (isIncoming()) && (isOneToOneType()) && (av.d(this.flag, 131072));
  }

  public boolean isInvisibleMessage()
  {
    return av.c(this.extraFlags, 22);
  }

  public boolean isInviteFromCommunity()
  {
    return (getMessageInfo().getInviteCommunityInfo() != null) && (getMessageInfo().getInviteCommunityInfo().hasPersonalLink());
  }

  public boolean isLocationMessage()
  {
    return 5 == this.mimeType;
  }

  public boolean isMediaWithThumbnail()
  {
    return (isVideo()) || (isImage()) || (isGifFile()) || (isVideoPttBehavior());
  }

  public boolean isNeedFetchUrl()
  {
    return this.extraStatus == 10;
  }

  public boolean isNeedLoactionStatus()
  {
    return this.extraStatus == 0;
  }

  public boolean isNeedMediaUpload()
  {
    return (!isForwardedFromPG()) && (this.extraStatus == 2) && (hasManagedMedia());
  }

  public boolean isNeedVideoConvert()
  {
    return (getExtraStatus() == 8) && (isVideo());
  }

  public boolean isNotUploadedForwardedMediaTo1on1WithPublicAccount()
  {
    return (isForwardedMessage()) && (hasManagedMedia()) && (getObjectId().isEmpty()) && (isOneToOneChatWithPa());
  }

  public boolean isNotification()
  {
    return (1000 == this.mimeType) || (1008 == this.mimeType);
  }

  public boolean isOneToOneChatWithPa()
  {
    return (this.conversationType == 0) && (isPublicAccount());
  }

  public boolean isOneToOneType()
  {
    return this.conversationType == 0;
  }

  public boolean isOpened()
  {
    return 1 == this.opened;
  }

  public boolean isOutgoing()
  {
    return this.type == 1;
  }

  public boolean isPgForwardedMessage()
  {
    return (0x4000 & this.flag) != 0;
  }

  public boolean isPinMessage()
  {
    return av.c(this.extraFlags, 32);
  }

  public boolean isPinMessageWithToken()
  {
    return (isPinMessage()) && (getMessageInfo().getPin() != null) && (getMessageInfo().getPin().getToken() != 0L) && (!av.d(getMessageInfo().getPin().getFlags(), 1));
  }

  public boolean isPoll()
  {
    return av.c(this.extraFlags, 38);
  }

  public boolean isPollMessage()
  {
    return getMessageInfo().getPoll() != null;
  }

  public boolean isPollOption()
  {
    return av.c(this.extraFlags, 39);
  }

  public boolean isPollOptionMessage()
  {
    boolean bool1;
    if (!m.b(this.conversationType))
    {
      boolean bool5 = m.f(this.conversationType);
      bool1 = false;
      if (!bool5);
    }
    else
    {
      Poll localPoll = getMessageInfo().getPoll();
      bool1 = false;
      if (localPoll != null)
      {
        boolean bool2 = "option".equals(localPoll.getType());
        bool1 = false;
        if (bool2)
        {
          boolean bool3 = Long.toString(this.groupId).equals(localPoll.getGroupId());
          bool1 = false;
          if (bool3)
            if (!isOutgoing())
            {
              boolean bool4 = getMemberId().equals(localPoll.getSenderId());
              bool1 = false;
              if (!bool4);
            }
            else
            {
              bool1 = true;
            }
        }
      }
    }
    return bool1;
  }

  public boolean isPollQuestionMessage()
  {
    boolean bool1;
    if (!m.b(this.conversationType))
    {
      boolean bool5 = m.f(this.conversationType);
      bool1 = false;
      if (!bool5);
    }
    else
    {
      Poll localPoll = getMessageInfo().getPoll();
      bool1 = false;
      if (localPoll != null)
      {
        boolean bool2 = "poll".equals(localPoll.getType());
        bool1 = false;
        if (bool2)
        {
          boolean bool3 = Long.toString(this.groupId).equals(localPoll.getGroupId());
          bool1 = false;
          if (bool3)
            if (!isOutgoing())
            {
              boolean bool4 = getMemberId().equals(localPoll.getSenderId());
              bool1 = false;
              if (!bool4);
            }
            else
            {
              bool1 = true;
            }
        }
      }
    }
    return bool1;
  }

  public boolean isPublicAccount()
  {
    return av.c(this.extraFlags, 20);
  }

  public boolean isPublicGroupBehavior()
  {
    return (isPublicGroupType()) || (isCommunityType());
  }

  public boolean isPublicGroupType()
  {
    return m.a(this.conversationType);
  }

  public boolean isRakutenSystemMessage()
  {
    return av.c(this.extraFlags, 8);
  }

  public boolean isRead()
  {
    return this.unread == 0;
  }

  public boolean isReplyToBot()
  {
    return av.c(this.extraFlags, 21);
  }

  public boolean isResendMessage()
  {
    return av.c(this.extraFlags, 9);
  }

  public boolean isRichMessage()
  {
    return 1006 == this.mimeType;
  }

  public boolean isRoleFollower()
  {
    return av.c(this.extraFlags, 4);
  }

  public boolean isSecretMessage()
  {
    return av.c(this.extraFlags, 27);
  }

  public boolean isShareContactMessage()
  {
    return 9 == this.mimeType;
  }

  @Deprecated
  public boolean isShortVideo()
  {
    return 1010 == this.mimeType;
  }

  public boolean isSilentMessage()
  {
    return (0x8 & this.flag) != 0;
  }

  public boolean isStartNewUserConversationMessage()
  {
    return av.c(this.extraFlags, 30);
  }

  public boolean isSticker()
  {
    return 4 == this.mimeType;
  }

  public boolean isSyncedMessage()
  {
    return av.c(this.extraFlags, 3);
  }

  public boolean isSystemEngagementMessage()
  {
    return (isEngagementMessage()) && (isSystemMessage());
  }

  public boolean isSystemMessage()
  {
    return (0x1 & this.flag) != 0;
  }

  public boolean isSystemReplyableMessage()
  {
    return av.c(this.extraFlags, 16);
  }

  public boolean isTextMessage()
  {
    return this.mimeType == 0;
  }

  public boolean isToSend()
  {
    return (this.messageToken == 0L) && (this.type == 1);
  }

  public boolean isUnsent()
  {
    return (isOutgoing()) && (getStatus() == -1);
  }

  public boolean isUploadCheckingNeeded()
  {
    return (!isForwardedFromPG()) && (this.extraStatus == 9) && (hasManagedMedia());
  }

  public boolean isUrlMessage()
  {
    return 8 == this.mimeType;
  }

  public boolean isVideo()
  {
    return (3 == this.mimeType) || (isWinkVideo());
  }

  @Deprecated
  public boolean isVideoPtt()
  {
    return 14 == this.mimeType;
  }

  public boolean isVideoPttBehavior()
  {
    return (14 == this.mimeType) || (1010 == this.mimeType);
  }

  public boolean isVisibleMessage()
  {
    return (!isInvisibleMessage()) && (!isEmpty());
  }

  public boolean isVlnMessage()
  {
    return (0x400000 & this.flag) != 0;
  }

  public boolean isVoiceMessage()
  {
    return 1009 == this.mimeType;
  }

  public boolean isWink()
  {
    return (isWinkImage()) || (isWinkVideo());
  }

  public boolean isWinkImage()
  {
    return 1003 == this.mimeType;
  }

  public boolean isWinkVideo()
  {
    return 1004 == this.mimeType;
  }

  public boolean isYouWasMentionedInThisMessage()
  {
    return av.c(this.extraFlags, 34);
  }

  public FormattedMessage loadFormattedMessage()
  {
    if (this.formattedMessage != null)
      return this.formattedMessage;
    if (!TextUtils.isEmpty(this.body))
      try
      {
        FormattedMessage localFormattedMessage = new FormattedMessage(this.body);
        this.formattedMessage = localFormattedMessage;
        return localFormattedMessage;
      }
      catch (JSONException localJSONException)
      {
        this.formattedMessage = null;
        return null;
      }
    this.formattedMessage = null;
    return null;
  }

  public boolean needForceDownloadMedia()
  {
    return (isSystemMessage()) && (isImage());
  }

  public void removeExtraFlag(int paramInt)
  {
    this.extraFlags = av.b(this.extraFlags, paramInt);
  }

  public void setBenchmarkTrackingSequence(long paramLong)
  {
    this.mBenchmarkTrackingSequence = paramLong;
  }

  public void setBody(String paramString)
  {
    this.body = paramString;
  }

  public void setBroadcastMessageId(long paramLong)
  {
    this.broadcastMessageId = paramLong;
  }

  public void setBucket(String paramString)
  {
    this.bucket = paramString;
  }

  public void setConversationId(long paramLong)
  {
    this.conversationId = paramLong;
  }

  public void setConversationType(int paramInt)
  {
    this.conversationType = paramInt;
  }

  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }

  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }

  public void setDeleted(int paramInt)
  {
    this.deleted = paramInt;
  }

  public void setDescription(String paramString)
  {
    this.description = paramString;
  }

  public void setDownloadId(String paramString)
  {
    this.downloadId = paramString;
  }

  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }

  public void setExtraFlags(long paramLong)
  {
    this.extraFlags = paramLong;
  }

  public void setExtraStatus(int paramInt)
  {
    this.extraStatus = paramInt;
  }

  public void setFlag(int paramInt)
  {
    this.flag = paramInt;
  }

  public void setFormattedMessage(FormattedMessage paramFormattedMessage)
  {
    this.formattedMessage = paramFormattedMessage;
  }

  public void setGroupId(long paramLong)
  {
    this.groupId = paramLong;
  }

  public void setLat(int paramInt)
  {
    this.lat = paramInt;
  }

  public void setLikesCount(int paramInt)
  {
    this.likesCount = paramInt;
  }

  public void setLng(int paramInt)
  {
    this.lng = paramInt;
  }

  public void setLocation(Location paramLocation)
  {
    if (paramLocation != null)
    {
      this.lat = ((int)(10000000.0D * paramLocation.getLatitude()));
      this.lng = ((int)(10000000.0D * paramLocation.getLongitude()));
    }
  }

  public void setLocation(LocationInfo paramLocationInfo)
  {
    if (paramLocationInfo != null)
    {
      this.lat = paramLocationInfo.getNativeLatitude();
      this.lng = paramLocationInfo.getNativeLongitude();
    }
  }

  public void setMediaUri(String paramString)
  {
    this.mediaUri = paramString;
  }

  public void setMemberId(String paramString)
  {
    this.memberId = paramString;
  }

  public void setMessageGlobalId(int paramInt)
  {
    this.messageGlobalId = paramInt;
  }

  public void setMessageSeq(int paramInt)
  {
    this.messageSeq = paramInt;
  }

  public void setMessageToken(long paramLong)
  {
    this.messageToken = paramLong;
  }

  public void setMimeType(int paramInt)
  {
    this.mimeType = paramInt;
  }

  public void setObjectId(ObjectId paramObjectId)
  {
    this.objectId = paramObjectId;
  }

  public void setOpened(int paramInt)
  {
    this.opened = paramInt;
  }

  public void setOrderKey(long paramLong)
  {
    this.orderKey = paramLong;
  }

  public void setParticipantId(long paramLong)
  {
    this.participantId = paramLong;
  }

  public void setRawMessageInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "{}";
    this.rawMessageInfo = paramString;
    this.messageInfo = null;
  }

  public void setRawQuotedMessageData(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "{}";
    this.rawQuotedMessageData = paramString;
    this.mQuotedMessageData = null;
  }

  public void setReadMessageTime(long paramLong)
  {
    this.readMessageTime = paramLong;
  }

  public void setScrollPosition(int paramInt)
  {
    this.scrollPosition = paramInt;
  }

  public void setSpans(String paramString)
  {
    this.spans = paramString;
  }

  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }

  public void setSyncRead(int paramInt)
  {
    this.syncRead = paramInt;
  }

  public void setTimebombInSec(int paramInt)
  {
    this.timebombInSec = paramInt;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }

  public void setUnread(int paramInt)
  {
    this.unread = paramInt;
  }

  public String toString()
  {
    return "MessageEntity [id=" + this.id + ", groupId=" + this.groupId + ", conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", participantId=" + this.participantId + ", memberId=" + this.memberId + ", date=" + this.date + ", unread=" + this.unread + ", status=" + this.status + ", type=" + this.type + ", body=" + da.a(this.body, this.mimeType) + ", opened=" + this.opened + ", description=" + this.description + ", messageToken=" + this.messageToken + ", flag=" + humanReadableFlags(this.flag) + ", orderKey=" + this.orderKey + ", extraFlags=" + humanReadableExtraFlags(this.extraFlags) + ", messageSeq=" + this.messageSeq + ", lat=" + this.lat + ", lng=" + this.lng + ", deleted=" + this.deleted + ", count=" + this.count + ", mediaUri=" + this.mediaUri + ", mimeType=" + this.mimeType + " - " + l.c(this.mimeType) + ", extraStatus=" + this.extraStatus + ", objectId=" + this.objectId + ", downloadId=" + this.downloadId + ", bucket=" + this.bucket + ", duration=" + this.duration + ", syncRead=" + this.syncRead + ", id=" + this.id + ", messageGlobalId=" + this.messageGlobalId + ", rawMessageInfo=" + this.rawMessageInfo + ", isFromBackup = " + isFromBackup() + ", timebombInSec =" + this.timebombInSec + ", readMessageTime =" + this.readMessageTime + ", scrollPosition = " + this.scrollPosition + ", broadcastMsgId = " + this.broadcastMessageId + ", rawQuotedMessageData = " + this.rawQuotedMessageData + "]";
  }

  public boolean usesVideoConverter()
  {
    return !av.c(this.extraFlags, 15);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeLong(this.groupId);
    paramParcel.writeLong(this.conversationId);
    paramParcel.writeInt(this.conversationType);
    paramParcel.writeLong(this.participantId);
    paramParcel.writeString(this.memberId);
    paramParcel.writeLong(this.date);
    paramParcel.writeInt(this.unread);
    paramParcel.writeInt(this.status);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.body);
    paramParcel.writeInt(this.opened);
    paramParcel.writeString(this.description);
    paramParcel.writeLong(this.messageToken);
    paramParcel.writeLong(this.orderKey);
    paramParcel.writeInt(this.flag);
    paramParcel.writeInt(this.messageSeq);
    paramParcel.writeInt(this.lat);
    paramParcel.writeInt(this.lng);
    paramParcel.writeInt(this.deleted);
    paramParcel.writeInt(this.count);
    paramParcel.writeString(this.mediaUri);
    paramParcel.writeInt(this.mimeType);
    paramParcel.writeInt(this.extraStatus);
    paramParcel.writeParcelable(this.objectId, paramInt);
    paramParcel.writeString(this.downloadId);
    paramParcel.writeString(this.bucket);
    paramParcel.writeLong(this.duration);
    paramParcel.writeInt(this.syncRead);
    paramParcel.writeLong(this.extraFlags);
    paramParcel.writeInt(this.messageGlobalId);
    paramParcel.writeString(this.rawMessageInfo);
    paramParcel.writeString(this.spans);
    paramParcel.writeInt(this.likesCount);
    paramParcel.writeInt(this.timebombInSec);
    paramParcel.writeLong(this.readMessageTime);
    paramParcel.writeInt(this.scrollPosition);
    paramParcel.writeLong(this.broadcastMessageId);
    paramParcel.writeString(this.rawQuotedMessageData);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.MessageEntity
 * JD-Core Version:    0.6.2
 */