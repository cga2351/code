package com.viber.voip.messages.orm.entity.impl;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.entity.EntityHelper;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.upload.ObjectId;
import org.json.JSONException;
import org.sqlite.database.sqlite.SQLiteStatement;

public class MessageEntityHelper
  implements EntityHelper<MessageEntity>
{
  private static final int INDX_BODY = 3;
  private static final int INDX_BROADCAST_MSG_ID = 37;
  private static final int INDX_CONVERSATION_ID = 16;
  private static final int INDX_CONVERSATION_TYPE = 17;
  private static final int INDX_COUNT = 26;
  private static final int INDX_DATE = 1;
  private static final int INDX_DELETED = 23;
  private static final int INDX_DESCRIPTION = 25;
  private static final int INDX_DOWNLOAD_ID = 11;
  private static final int INDX_EXTRA_BUCKET_NAME = 19;
  private static final int INDX_EXTRA_DURATION = 13;
  private static final int INDX_EXTRA_FLAGS = 29;
  private static final int INDX_EXTRA_MIME = 12;
  private static final int INDX_EXTRA_STATUS = 8;
  private static final int INDX_EXTRA_UPLOAD_ID = 10;
  private static final int INDX_EXTRA_URI = 9;
  private static final int INDX_FLAG = 14;
  private static final int INDX_GROUP_ID = 15;
  private static final int INDX_ID = 0;
  private static final int INDX_LIKES_COUNT = 32;
  private static final int INDX_LOCATION_LAT = 6;
  private static final int INDX_LOCATION_LNG = 7;
  private static final int INDX_MEMBER_ID = 18;
  private static final int INDX_MESSAGE_GLOBAL_ID = 30;
  private static final int INDX_MESSAGE_SEQ = 20;
  private static final int INDX_MESSAGE_TOKEN = 21;
  private static final int INDX_MSG_INFO = 31;
  private static final int INDX_OPENED = 24;
  private static final int INDX_ORDER_KEY = 22;
  private static final int INDX_PARTICIOANT_ID = 27;
  private static final int INDX_QUOTED_MESSAGE_DATA = 38;
  private static final int INDX_READ = 5;
  private static final int INDX_READ_MESSAGE_TIME = 35;
  private static final int INDX_SCROLL_POSITION = 36;
  private static final int INDX_SPANS = 33;
  private static final int INDX_STATUS = 4;
  private static final int INDX_SYNC_READ = 28;
  private static final int INDX_TIMEBOMB = 34;
  private static final int INDX_TYPE = 2;
  private static final Logger L = ViberEnv.getLogger();
  public static final String[] PROJECTIONS = { "_id", "msg_date", "send_type", "body", "status", "unread", "location_lat", "location_lng", "extra_status", "extra_uri", "extra_upload_id", "extra_download_id", "extra_mime", "extra_duration", "flag", "group_id", "conversation_id", "conversation_type", "user_id", "extra_bucket_name", "seq", "token", "order_key", "deleted", "opened", "description", "event_count", "participant_id", "sync_read", "extra_flags", "message_global_id", "msg_info", "likes_count", "spans", "timebomb", "read_message_time", "scroll_pos", "broadcast_msg_id", "quoted_message_data" };

  public static SQLiteStatement bindInsertStatementValues(SQLiteStatement paramSQLiteStatement, MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.getId() > 0L)
    {
      paramSQLiteStatement.bindLong(1, paramMessageEntity.getId());
      paramSQLiteStatement.bindLong(2, paramMessageEntity.getDate());
      paramSQLiteStatement.bindLong(3, paramMessageEntity.getType());
      if (paramMessageEntity.getBody() == null)
        break label490;
      paramSQLiteStatement.bindString(4, paramMessageEntity.getBody());
      label53: paramSQLiteStatement.bindLong(5, paramMessageEntity.getStatus());
      paramSQLiteStatement.bindLong(6, paramMessageEntity.getUnread());
      paramSQLiteStatement.bindLong(25, paramMessageEntity.getOpened());
      paramSQLiteStatement.bindLong(7, paramMessageEntity.getLat());
      paramSQLiteStatement.bindLong(8, paramMessageEntity.getLng());
      paramSQLiteStatement.bindLong(9, paramMessageEntity.getExtraStatus());
      if (paramMessageEntity.getMediaUri() == null)
        break label498;
      paramSQLiteStatement.bindString(10, paramMessageEntity.getMediaUri());
      label135: paramSQLiteStatement.bindLong(11, paramMessageEntity.getObjectId().toLong());
      if (paramMessageEntity.getDownloadId() == null)
        break label507;
      paramSQLiteStatement.bindString(12, paramMessageEntity.getDownloadId());
      label165: paramSQLiteStatement.bindLong(13, paramMessageEntity.getMimeType());
      paramSQLiteStatement.bindLong(14, paramMessageEntity.getDuration());
      paramSQLiteStatement.bindLong(15, paramMessageEntity.getFlag());
      paramSQLiteStatement.bindLong(16, paramMessageEntity.getGroupId());
      paramSQLiteStatement.bindLong(17, paramMessageEntity.getConversationId());
      paramSQLiteStatement.bindLong(18, paramMessageEntity.getConversationType());
      String str1 = paramMessageEntity.getMemberId();
      if (str1 == null)
        break label516;
      paramSQLiteStatement.bindString(19, str1);
      label244: if (paramMessageEntity.getBucket() == null)
        break label525;
      paramSQLiteStatement.bindString(20, paramMessageEntity.getBucket());
      label261: paramSQLiteStatement.bindLong(21, paramMessageEntity.getMessageSeq());
      paramSQLiteStatement.bindLong(22, paramMessageEntity.getMessageToken());
      paramSQLiteStatement.bindLong(23, paramMessageEntity.getOrderKey());
      paramSQLiteStatement.bindLong(24, paramMessageEntity.getDeleted());
      String str2 = paramMessageEntity.getDescription();
      if (str2 == null)
        break label534;
      paramSQLiteStatement.bindString(26, str2);
      label319: paramSQLiteStatement.bindLong(27, paramMessageEntity.getCount());
      paramSQLiteStatement.bindLong(28, paramMessageEntity.getParticipantId());
      paramSQLiteStatement.bindLong(29, paramMessageEntity.getSyncRead());
      paramSQLiteStatement.bindLong(30, paramMessageEntity.getExtraFlags());
      paramSQLiteStatement.bindLong(31, paramMessageEntity.getMessageGlobalId());
      String str3 = paramMessageEntity.getRawMessageInfo();
      if (str3 == null)
        break label543;
      paramSQLiteStatement.bindString(32, str3);
      label391: paramSQLiteStatement.bindLong(33, paramMessageEntity.getLikesCount());
      if (paramMessageEntity.getSpans() == null)
        break label552;
      paramSQLiteStatement.bindString(34, paramMessageEntity.getSpans());
    }
    while (true)
    {
      paramSQLiteStatement.bindLong(35, paramMessageEntity.getTimebombInSec());
      paramSQLiteStatement.bindLong(36, paramMessageEntity.getReadMessageTime());
      paramSQLiteStatement.bindLong(37, paramMessageEntity.getScrollPosition());
      paramSQLiteStatement.bindLong(38, paramMessageEntity.getBroadcastMessageId());
      String str4 = paramMessageEntity.getRawQuotedMessageData();
      if (str4 == null)
        break label561;
      paramSQLiteStatement.bindString(39, str4);
      return paramSQLiteStatement;
      paramSQLiteStatement.bindNull(1);
      break;
      label490: paramSQLiteStatement.bindNull(4);
      break label53;
      label498: paramSQLiteStatement.bindNull(10);
      break label135;
      label507: paramSQLiteStatement.bindNull(12);
      break label165;
      label516: paramSQLiteStatement.bindNull(19);
      break label244;
      label525: paramSQLiteStatement.bindNull(20);
      break label261;
      label534: paramSQLiteStatement.bindNull(26);
      break label319;
      label543: paramSQLiteStatement.bindNull(32);
      break label391;
      label552: paramSQLiteStatement.bindNull(34);
    }
    label561: paramSQLiteStatement.bindNull(39);
    return paramSQLiteStatement;
  }

  public static MessageEntity createEntity(MessageEntity paramMessageEntity, Cursor paramCursor, int paramInt)
  {
    paramMessageEntity.setId(paramCursor.getLong(paramInt + 0));
    paramMessageEntity.setDate(paramCursor.getLong(paramInt + 1));
    paramMessageEntity.setType(paramCursor.getInt(paramInt + 2));
    paramMessageEntity.setBody(paramCursor.getString(paramInt + 3));
    paramMessageEntity.setStatus(paramCursor.getInt(paramInt + 4));
    paramMessageEntity.setUnread(paramCursor.getInt(paramInt + 5));
    paramMessageEntity.setLat(paramCursor.getInt(paramInt + 6));
    paramMessageEntity.setLng(paramCursor.getInt(paramInt + 7));
    paramMessageEntity.setExtraStatus(paramCursor.getInt(paramInt + 8));
    paramMessageEntity.setMediaUri(paramCursor.getString(paramInt + 9));
    paramMessageEntity.setObjectId(ObjectId.fromLong(paramCursor.getLong(paramInt + 10)));
    paramMessageEntity.setDownloadId(paramCursor.getString(paramInt + 11));
    paramMessageEntity.setMimeType(paramCursor.getInt(paramInt + 12));
    paramMessageEntity.setDuration(paramCursor.getLong(paramInt + 13));
    paramMessageEntity.setFlag(paramCursor.getInt(paramInt + 14));
    paramMessageEntity.setGroupId(paramCursor.getLong(paramInt + 15));
    paramMessageEntity.setConversationId(paramCursor.getLong(paramInt + 16));
    paramMessageEntity.setConversationType(paramCursor.getInt(paramInt + 17));
    paramMessageEntity.setMemberId(paramCursor.getString(paramInt + 18));
    paramMessageEntity.setBucket(paramCursor.getString(paramInt + 19));
    paramMessageEntity.setMessageSeq(paramCursor.getInt(paramInt + 20));
    paramMessageEntity.setMessageToken(paramCursor.getLong(paramInt + 21));
    paramMessageEntity.setOrderKey(paramCursor.getLong(paramInt + 22));
    paramMessageEntity.setDeleted(paramCursor.getInt(paramInt + 23));
    paramMessageEntity.setOpened(paramCursor.getInt(paramInt + 24));
    paramMessageEntity.setDescription(paramCursor.getString(paramInt + 25));
    paramMessageEntity.setCount(paramCursor.getInt(paramInt + 26));
    paramMessageEntity.setParticipantId(paramCursor.getLong(paramInt + 27));
    paramMessageEntity.setSyncRead(paramCursor.getInt(paramInt + 28));
    paramMessageEntity.setExtraFlags(paramCursor.getLong(paramInt + 29));
    paramMessageEntity.setMessageGlobalId(paramCursor.getInt(paramInt + 30));
    paramMessageEntity.setRawMessageInfo(paramCursor.getString(paramInt + 31));
    paramMessageEntity.setLikesCount(paramCursor.getInt(paramInt + 32));
    paramMessageEntity.setSpans(paramCursor.getString(paramInt + 33));
    paramMessageEntity.setTimebombInSec(paramCursor.getInt(paramInt + 34));
    paramMessageEntity.setReadMessageTime(paramCursor.getLong(paramInt + 35));
    paramMessageEntity.setScrollPosition(paramCursor.getInt(paramInt + 36));
    paramMessageEntity.setBroadcastMessageId(paramCursor.getLong(paramInt + 37));
    paramMessageEntity.setRawQuotedMessageData(paramCursor.getString(paramInt + 38));
    if (paramMessageEntity.isFormattedMessage());
    try
    {
      paramMessageEntity.setFormattedMessage(new FormattedMessage(paramMessageEntity.getBody()));
      return paramMessageEntity;
    }
    catch (JSONException localJSONException)
    {
    }
    return paramMessageEntity;
  }

  public static ContentValues getContentValues(MessageEntity paramMessageEntity)
  {
    ContentValues localContentValues = new ContentValues(40);
    if (paramMessageEntity.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paramMessageEntity.getId()));
    localContentValues.put("msg_date", Long.valueOf(paramMessageEntity.getDate()));
    localContentValues.put("send_type", Integer.valueOf(paramMessageEntity.getType()));
    localContentValues.put("body", paramMessageEntity.getBody());
    localContentValues.put("status", Integer.valueOf(paramMessageEntity.getStatus()));
    localContentValues.put("unread", Integer.valueOf(paramMessageEntity.getUnread()));
    localContentValues.put("opened", Integer.valueOf(paramMessageEntity.getOpened()));
    localContentValues.put("location_lat", Integer.valueOf(paramMessageEntity.getLat()));
    localContentValues.put("location_lng", Integer.valueOf(paramMessageEntity.getLng()));
    localContentValues.put("extra_status", Integer.valueOf(paramMessageEntity.getExtraStatus()));
    localContentValues.put("extra_uri", paramMessageEntity.getMediaUri());
    localContentValues.put("extra_upload_id", Long.valueOf(paramMessageEntity.getObjectId().toLong()));
    localContentValues.put("extra_download_id", paramMessageEntity.getDownloadId());
    localContentValues.put("extra_mime", Integer.valueOf(paramMessageEntity.getMimeType()));
    localContentValues.put("extra_duration", Long.valueOf(paramMessageEntity.getDuration()));
    localContentValues.put("flag", Integer.valueOf(paramMessageEntity.getFlag()));
    localContentValues.put("group_id", Long.valueOf(paramMessageEntity.getGroupId()));
    localContentValues.put("conversation_id", Long.valueOf(paramMessageEntity.getConversationId()));
    localContentValues.put("conversation_type", Integer.valueOf(paramMessageEntity.getConversationType()));
    localContentValues.put("user_id", paramMessageEntity.getMemberId());
    localContentValues.put("extra_bucket_name", paramMessageEntity.getBucket());
    localContentValues.put("seq", Integer.valueOf(paramMessageEntity.getMessageSeq()));
    localContentValues.put("token", Long.valueOf(paramMessageEntity.getMessageToken()));
    localContentValues.put("order_key", Long.valueOf(paramMessageEntity.getOrderKey()));
    localContentValues.put("deleted", Integer.valueOf(paramMessageEntity.getDeleted()));
    localContentValues.put("description", paramMessageEntity.getDescription());
    localContentValues.put("event_count", Integer.valueOf(paramMessageEntity.getCount()));
    localContentValues.put("participant_id", Long.valueOf(paramMessageEntity.getParticipantId()));
    localContentValues.put("sync_read", Integer.valueOf(paramMessageEntity.getSyncRead()));
    localContentValues.put("extra_flags", Long.valueOf(paramMessageEntity.getExtraFlags()));
    localContentValues.put("message_global_id", Integer.valueOf(paramMessageEntity.getMessageGlobalId()));
    localContentValues.put("msg_info", paramMessageEntity.getRawMessageInfo());
    localContentValues.put("likes_count", Integer.valueOf(paramMessageEntity.getLikesCount()));
    localContentValues.put("spans", paramMessageEntity.getSpans());
    localContentValues.put("timebomb", Integer.valueOf(paramMessageEntity.getTimebombInSec()));
    localContentValues.put("read_message_time", Long.valueOf(paramMessageEntity.getReadMessageTime()));
    localContentValues.put("scroll_pos", Integer.valueOf(paramMessageEntity.getScrollPosition()));
    localContentValues.put("broadcast_msg_id", Long.valueOf(paramMessageEntity.getBroadcastMessageId()));
    localContentValues.put("quoted_message_data", paramMessageEntity.getRawQuotedMessageData());
    return localContentValues;
  }

  public MessageEntity createEntity(Cursor paramCursor)
  {
    return createEntity(paramCursor, 0);
  }

  public MessageEntity createEntity(Cursor paramCursor, int paramInt)
  {
    return createEntity(new MessageEntity(), paramCursor, paramInt);
  }

  public String[] getProjections()
  {
    return PROJECTIONS;
  }

  public String getTable()
  {
    return "messages";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.impl.MessageEntityHelper
 * JD-Core Version:    0.6.2
 */