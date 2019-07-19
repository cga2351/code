package com.viber.voip.messages.orm.entity.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.messages.orm.entity.EntityHelper;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.da;

public class ConversationEntityHelper
  implements EntityHelper<h>
{
  protected static final int INDX_APPLICATION_ID = 23;
  protected static final int INDX_BACKGROUND_LANDSCAPE = 10;
  protected static final int INDX_BACKGROUND_PORTRAIT = 11;
  protected static final int INDX_BACKGROUND_TEXT_COLOR = 12;
  protected static final int INDX_BOT_REPLY = 26;
  protected static final int INDX_BUSINESS_INBOX_FLAGS = 30;
  protected static final int INDX_CONVERSATION_TYPE = 1;
  protected static final int INDX_CREATOR_PARTICIPANT_INFO_ID = 21;
  protected static final int INDX_DATE = 3;
  protected static final int INDX_DELETED = 8;
  protected static final int INDX_DELETE_TOKEN = 7;
  protected static final int INDX_FAVOURITE = 28;
  protected static final int INDX_FLAGS = 16;
  protected static final int INDX_GROUPING_KEY = 32;
  protected static final int INDX_GROUP_ID = 2;
  protected static final int INDX_GROUP_NAME = 9;
  protected static final int INDX_GROUP_ROLE_ID = 24;
  protected static final int INDX_ICON_URI = 25;
  protected static final int INDX_ID = 0;
  protected static final int INDX_MESSAGE_DRAFT = 5;
  protected static final int INDX_MESSAGE_DRAFT_SPANS = 6;
  protected static final int INDX_MUTE_NOTIFICATION = 15;
  protected static final int INDX_PARTICIPANT_INFO_ID_1 = 17;
  protected static final int INDX_PARTICIPANT_INFO_ID_2 = 18;
  protected static final int INDX_PARTICIPANT_INFO_ID_3 = 19;
  protected static final int INDX_PARTICIPANT_INFO_ID_4 = 20;
  protected static final int INDX_READ_NOTIFICATION_TOKEN = 22;
  protected static final int INDX_REPLY_BANNER_DRAFT = 29;
  protected static final int INDX_SHARE_LOCATION = 4;
  protected static final int INDX_SMART_EVENT_DATE = 14;
  protected static final int INDX_SMART_NOTIFICATION = 13;
  protected static final int INDX_TIMEBOMB_TIME = 27;
  protected static final int INDX_TO_NUMBER = 31;
  public static final String[] PROJECTIONS = { "_id", "conversation_type", "group_id", "date", "share_location", "message_draft", "msg_draft_spans", "delete_token", "deleted", "name", "background_landscape", "background_portrait", "background_text_color", "smart_notification", "smart_event_date", "mute_notification", "flags", "participant_id_1", "participant_id_2", "participant_id_3", "participant_id_4", "creator_participant_id", "read_notification_token", "application_id", "group_role", "icon_id", "bot_reply", "timebomb_time", "favourite_conversation", "reply_banner_draft", "business_inbox_flags", "to_number", "grouping_key" };

  public static h createEntity(h paramh, Cursor paramCursor, int paramInt)
  {
    paramh.setId(paramCursor.getLong(paramInt + 0));
    paramh.a(paramCursor.getInt(paramInt + 1));
    paramh.a(paramCursor.getLong(paramInt + 2));
    paramh.e(paramCursor.getLong(paramInt + 3));
    paramh.j(paramCursor.getInt(paramInt + 4));
    paramh.e(paramCursor.getString(paramInt + 5));
    paramh.f(paramCursor.getString(paramInt + 6));
    paramh.b(paramCursor.getLong(paramInt + 7));
    paramh.k(paramCursor.getInt(paramInt + 8));
    paramh.b(paramCursor.getString(paramInt + 9));
    paramh.c(paramCursor.getString(paramInt + 10));
    paramh.d(paramCursor.getString(paramInt + 11));
    paramh.d(paramCursor.getInt(paramInt + 12));
    paramh.e(paramCursor.getInt(paramInt + 13));
    paramh.c(paramCursor.getLong(paramInt + 14));
    paramh.f(paramCursor.getInt(paramInt + 15));
    paramh.d(paramCursor.getLong(paramInt + 16));
    paramh.f(paramCursor.getLong(paramInt + 17));
    paramh.g(paramCursor.getLong(paramInt + 18));
    paramh.h(paramCursor.getLong(paramInt + 19));
    paramh.i(paramCursor.getLong(paramInt + 20));
    paramh.j(paramCursor.getLong(paramInt + 21));
    paramh.k(paramCursor.getLong(paramInt + 22));
    paramh.b(paramCursor.getInt(paramInt + 23));
    paramh.c(paramCursor.getInt(paramInt + 24));
    String str = paramCursor.getString(paramInt + 25);
    if (da.a(str));
    for (Uri localUri = null; ; localUri = Uri.parse(str))
    {
      paramh.a(localUri);
      paramh.a(paramCursor.getString(paramInt + 26));
      paramh.l(paramCursor.getInt(paramInt + 27));
      paramh.m(paramCursor.getInt(paramInt + 28));
      paramh.g(paramCursor.getString(paramInt + 29));
      paramh.n(paramCursor.getInt(paramInt + 30));
      paramh.h(paramCursor.getString(paramInt + 31));
      paramh.i(paramCursor.getString(paramInt + 32));
      return paramh;
    }
  }

  public static ContentValues getContentValues(h paramh)
  {
    ContentValues localContentValues = new ContentValues(30);
    if (paramh.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paramh.getId()));
    localContentValues.put("conversation_type", Integer.valueOf(paramh.j()));
    localContentValues.put("group_id", Long.valueOf(paramh.k()));
    localContentValues.put("date", Long.valueOf(paramh.A()));
    localContentValues.put("share_location", Integer.valueOf(paramh.i()));
    localContentValues.put("message_draft", paramh.B());
    localContentValues.put("msg_draft_spans", paramh.C());
    localContentValues.put("delete_token", Long.valueOf(paramh.n()));
    localContentValues.put("deleted", Integer.valueOf(paramh.ab()));
    localContentValues.put("name", paramh.o());
    localContentValues.put("background_landscape", paramh.s());
    localContentValues.put("background_portrait", paramh.t());
    localContentValues.put("background_text_color", Integer.valueOf(paramh.u()));
    localContentValues.put("smart_notification", Integer.valueOf(paramh.v()));
    localContentValues.put("smart_event_date", Long.valueOf(paramh.w()));
    localContentValues.put("mute_notification", Integer.valueOf(paramh.x()));
    localContentValues.put("flags", Long.valueOf(paramh.z()));
    localContentValues.put("reply_banner_draft", paramh.ag());
    localContentValues.put("participant_id_1", Long.valueOf(paramh.V()));
    localContentValues.put("participant_id_2", Long.valueOf(paramh.W()));
    localContentValues.put("participant_id_3", Long.valueOf(paramh.X()));
    localContentValues.put("participant_id_4", Long.valueOf(paramh.Y()));
    localContentValues.put("creator_participant_id", Long.valueOf(paramh.Z()));
    localContentValues.put("read_notification_token", Long.valueOf(paramh.aa()));
    localContentValues.put("application_id", Integer.valueOf(paramh.l()));
    localContentValues.put("group_role", Integer.valueOf(paramh.p()));
    if (paramh.q() == null);
    for (String str = null; ; str = paramh.q().toString())
    {
      localContentValues.put("icon_id", str);
      localContentValues.put("bot_reply", paramh.m());
      localContentValues.put("timebomb_time", Integer.valueOf(paramh.ad()));
      localContentValues.put("favourite_conversation", Integer.valueOf(paramh.af()));
      localContentValues.put("business_inbox_flags", Integer.valueOf(paramh.ai()));
      localContentValues.put("to_number", paramh.an());
      localContentValues.put("grouping_key", paramh.ap());
      return localContentValues;
    }
  }

  public h createEntity(Cursor paramCursor)
  {
    return createEntity(paramCursor, 0);
  }

  public h createEntity(Cursor paramCursor, int paramInt)
  {
    return createEntity(new h(), paramCursor, paramInt);
  }

  public String[] getProjections()
  {
    return PROJECTIONS;
  }

  public String getTable()
  {
    return "conversations";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.impl.ConversationEntityHelper
 * JD-Core Version:    0.6.2
 */