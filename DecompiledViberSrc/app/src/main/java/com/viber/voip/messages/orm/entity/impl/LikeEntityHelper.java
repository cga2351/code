package com.viber.voip.messages.orm.entity.impl;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.voip.model.entity.j;

public class LikeEntityHelper
{
  private static final int INDX_IS_READ = 6;
  private static final int INDX_IS_SYNC_READ = 7;
  private static final int INDX_LIKE_DATE = 5;
  private static final int INDX_LIKE_ID = 0;
  private static final int INDX_LIKE_SEQ = 4;
  private static final int INDX_LIKE_TOKEN = 3;
  private static final int INDX_MESSAGE_TOKEN = 1;
  private static final int INDX_PARTICIPANT_MEMBER_ID = 2;
  private static final int INDX_STATUS = 8;
  public static final String[] PROJECTIONS = { "_id", "message_token", "participant_number", "like_token", "seq", "date", "read", "sync_read", "status" };

  public static j createEntity(Cursor paramCursor)
  {
    return createEntity(paramCursor, 0);
  }

  public static j createEntity(Cursor paramCursor, int paramInt)
  {
    boolean bool1 = true;
    j localj = new j();
    localj.setId(paramCursor.getLong(paramInt + 0));
    localj.a(paramCursor.getLong(paramInt + 1));
    localj.a(paramCursor.getString(paramInt + 2));
    localj.b(paramCursor.getLong(paramInt + 3));
    localj.a(paramCursor.getInt(paramInt + 4));
    localj.c(paramCursor.getLong(paramInt + 5));
    boolean bool2;
    if (paramCursor.getInt(paramInt + 6) > 0)
    {
      bool2 = bool1;
      localj.a(bool2);
      if (paramCursor.getInt(paramInt + 7) <= 0)
        break label151;
    }
    while (true)
    {
      localj.b(bool1);
      localj.b(paramCursor.getInt(paramInt + 8));
      return localj;
      bool2 = false;
      break;
      label151: bool1 = false;
    }
  }

  public static ContentValues getContentValues(j paramj)
  {
    int i = 1;
    ContentValues localContentValues = new ContentValues();
    if (paramj.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paramj.getId()));
    localContentValues.put("like_token", Long.valueOf(paramj.b()));
    localContentValues.put("message_token", Long.valueOf(paramj.a()));
    localContentValues.put("seq", Integer.valueOf(paramj.c()));
    localContentValues.put("participant_number", paramj.d());
    localContentValues.put("date", Long.valueOf(paramj.e()));
    int j;
    if (paramj.f())
    {
      j = i;
      localContentValues.put("read", Integer.valueOf(j));
      if (!paramj.g())
        break label150;
    }
    while (true)
    {
      localContentValues.put("sync_read", Integer.valueOf(i));
      localContentValues.put("status", Integer.valueOf(paramj.h()));
      return localContentValues;
      j = 0;
      break;
      label150: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.impl.LikeEntityHelper
 * JD-Core Version:    0.6.2
 */