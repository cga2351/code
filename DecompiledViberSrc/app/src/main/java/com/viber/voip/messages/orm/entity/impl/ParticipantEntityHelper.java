package com.viber.voip.messages.orm.entity.impl;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.voip.messages.orm.entity.EntityHelper;
import com.viber.voip.model.entity.l;
import org.sqlite.database.sqlite.SQLiteStatement;

public class ParticipantEntityHelper
  implements EntityHelper<l>
{
  private static final int INDX_CONVERSATION_ID = 1;
  private static final int INDX_ID = 0;
  private static final int INDX_LAST_MESSAGE_ID = 3;
  private static final int INDX_PATRICIPANT_INFO_ID = 2;
  private static final int INDX_ROLE = 5;
  private static final int INDX_ROLE_LOCAL = 6;
  private static final int INDX_STATUS = 4;
  public static String[] PROJECTIONS = { "_id", "conversation_id", "participant_info_id", "last_message_id", "active", "group_role", "group_role_local" };

  public static SQLiteStatement bindInsertStatmentValues(SQLiteStatement paramSQLiteStatement, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    if (paramLong1 > 0L)
      paramSQLiteStatement.bindLong(1, paramLong1);
    while (true)
    {
      paramSQLiteStatement.bindLong(2, paramLong2);
      paramSQLiteStatement.bindLong(3, paramLong3);
      paramSQLiteStatement.bindLong(4, 0L);
      paramSQLiteStatement.bindLong(5, paramInt1);
      paramSQLiteStatement.bindLong(6, paramInt2);
      paramSQLiteStatement.bindLong(7, paramInt2);
      return paramSQLiteStatement;
      paramSQLiteStatement.bindNull(1);
    }
  }

  public static l createEntity(l paraml, Cursor paramCursor, int paramInt)
  {
    paraml.setId(paramCursor.getLong(paramInt + 0));
    paraml.b(paramCursor.getLong(paramInt + 1));
    paraml.a(paramCursor.getLong(paramInt + 2));
    paraml.c(paramCursor.getLong(paramInt + 3));
    paraml.a(paramCursor.getInt(paramInt + 4));
    paraml.a(paramCursor.getInt(paramInt + 5), paramCursor.getInt(paramInt + 6));
    return paraml;
  }

  public static ContentValues getContentValues(l paraml)
  {
    ContentValues localContentValues = new ContentValues(6);
    if (paraml.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paraml.getId()));
    localContentValues.put("conversation_id", Long.valueOf(paraml.b()));
    localContentValues.put("participant_info_id", Long.valueOf(paraml.a()));
    localContentValues.put("last_message_id", Long.valueOf(paraml.c()));
    localContentValues.put("active", Integer.valueOf(paraml.d()));
    localContentValues.put("group_role", Integer.valueOf(paraml.e()));
    localContentValues.put("group_role_local", Integer.valueOf(paraml.f()));
    return localContentValues;
  }

  public l createEntity(Cursor paramCursor)
  {
    return createEntity(paramCursor, 0);
  }

  public l createEntity(Cursor paramCursor, int paramInt)
  {
    return createEntity(new l(), paramCursor, paramInt);
  }

  public String[] getProjections()
  {
    return PROJECTIONS;
  }

  public String getTable()
  {
    return "participants";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.impl.ParticipantEntityHelper
 * JD-Core Version:    0.6.2
 */