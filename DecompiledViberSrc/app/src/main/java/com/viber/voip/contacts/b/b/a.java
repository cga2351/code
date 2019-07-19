package com.viber.voip.contacts.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.voip.model.entity.c;

public class a
{
  public static String[] a = { "_id", "canonized_number", "blocked_date", "block_reason" };
  private static int b = 0;
  private static int c = 1 + b;
  private static int d = 1 + c;
  private static int e = 1 + d;

  public static ContentValues a(c paramc)
  {
    ContentValues localContentValues = new ContentValues(3);
    if (paramc.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paramc.getId()));
    localContentValues.put("canonized_number", paramc.a());
    localContentValues.put("blocked_date", Long.valueOf(paramc.b()));
    localContentValues.put("block_reason", Integer.valueOf(paramc.c()));
    return localContentValues;
  }

  public static c a(c paramc, Cursor paramCursor, int paramInt)
  {
    paramc.setId(paramCursor.getLong(paramInt + b));
    paramc.a(paramCursor.getString(paramInt + c));
    paramc.a(paramCursor.getLong(paramInt + d));
    paramc.a(paramCursor.getInt(paramInt + e));
    return paramc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.b.a
 * JD-Core Version:    0.6.2
 */