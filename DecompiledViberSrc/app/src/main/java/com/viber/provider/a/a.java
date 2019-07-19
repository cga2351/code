package com.viber.provider.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.jni.ConversationSettings;
import com.viber.provider.b;
import com.viber.provider.e;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.af;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteOpenHelper;

public class a extends e
{
  private static final Logger b = ViberEnv.getLogger();
  private static volatile a c = null;

  private a(Context paramContext)
  {
    super(paramContext, "viber_prefs");
  }

  public static b a(Context paramContext)
  {
    return com.viber.provider.messages.c.a(b(paramContext).getWritableDatabase());
  }

  private void a(b paramb, String paramString)
  {
    Cursor localCursor = null;
    b localb = d.b(this.a);
    try
    {
      localCursor = localb.a(paramString, null);
      if (af.c(localCursor))
      {
        ContentValues localContentValues = new ContentValues(4);
        boolean bool;
        do
        {
          localContentValues.clear();
          String str = String.valueOf(localCursor.getLong(0));
          ConversationSettings localConversationSettings = new ConversationSettings(true, false, false);
          localContentValues.put("category", "not_sync_hide_group");
          localContentValues.put("key", str);
          localContentValues.put("value", Integer.valueOf(localConversationSettings.convertToFlags()));
          localContentValues.put("value_type", Integer.valueOf(2));
          paramb.a("kvdata", null, localContentValues);
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return;
    }
    catch (Exception localException)
    {
      b.a(localException, "Cannot add group ids to fetch PA info for");
      return;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  private void a(b paramb, String paramString1, String paramString2)
  {
    Cursor localCursor = null;
    b localb = d.b(this.a);
    try
    {
      localCursor = localb.a(paramString1, null);
      if (af.c(localCursor))
      {
        ContentValues localContentValues = new ContentValues(4);
        boolean bool;
        do
        {
          localContentValues.clear();
          localContentValues.put("category", String.valueOf(localCursor.getLong(0)));
          localContentValues.put("key", paramString2);
          localContentValues.put("value", String.valueOf(true));
          localContentValues.put("value_type", Integer.valueOf(3));
          paramb.a("kvdata", null, localContentValues);
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return;
    }
    catch (Exception localException)
    {
      b.a(localException, "Cannot add group ids to fetch PA info for");
      return;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  private static SQLiteOpenHelper b(Context paramContext)
  {
    if (c == null);
    try
    {
      if (c == null)
        c = new a(paramContext);
      return c;
    }
    finally
    {
    }
  }

  private void c(b paramb)
  {
    Cursor localCursor1 = null;
    try
    {
      b localb = d.a(this.a);
      Cursor localCursor2 = localb.a("PRAGMA table_info('kvdata')", null);
      localCursor1 = null;
      if ((localCursor2 == null) || (localCursor2.getCount() <= 0))
      {
        af.a(localCursor2);
        af.a(null);
        return;
      }
      String[] arrayOfString = { "_id", "object_id", "key", "value", "value_type" };
      new String[] { "_id", "category", "key", "value", "value_type" };
      localCursor1 = localb.a(" SELECT " + com.viber.voip.s.a.d(arrayOfString) + " FROM " + "kvdata", null);
      if ((localCursor1 != null) && (localCursor1.moveToFirst()))
      {
        ContentValues localContentValues = new ContentValues(5);
        do
        {
          localContentValues.clear();
          localContentValues.put("_id", Long.valueOf(localCursor1.getLong(0)));
          localContentValues.put("category", localCursor1.getString(1));
          localContentValues.put("key", localCursor1.getString(2));
          localContentValues.put("value", localCursor1.getString(3));
          localContentValues.put("value_type", Integer.valueOf(localCursor1.getInt(4)));
          paramb.b("kvdata", null, localContentValues);
        }
        while (localCursor1.moveToNext());
      }
      localb.a("DROP TABLE IF EXISTS kvdata");
      return;
    }
    catch (Exception localException)
    {
      b.a(localException, null);
      return;
    }
    finally
    {
      af.a(localCursor1);
    }
  }

  protected void a(b paramb)
  {
    paramb.c("kvdata");
  }

  protected void b(b paramb)
  {
    a(a(), "db/prefs_db_indexes.sql", paramb, b);
  }

  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    this.useMemoryMapIo = true;
    this.memoryMapIoSize = 65536;
    this.executeVacuumAfterUpgrade = true;
    this.disableAutoVacuum = true;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    b localb = com.viber.provider.messages.c.a(paramSQLiteDatabase);
    localb.a("CREATE TABLE IF NOT EXISTS kvdata (_id INTEGER PRIMARY KEY autoincrement,category TEXT DEFAULT '0',key TEXT,value TEXT,value_type INTEGER DEFAULT 0,UNIQUE(category, key) ON CONFLICT REPLACE);");
    c(localb);
    b(localb);
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }

  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    i.a();
    b localb = com.viber.provider.messages.c.a(paramSQLiteDatabase);
    if (c.a.a.a.c.i())
      com.crashlytics.android.a.a("Upgrade PreferencesDb from ", "" + paramInt1);
    if (a(paramInt1, paramInt2, 88))
      a(a(), "db/kvdata_migration_88.sql", localb, b);
    if (a(paramInt1, paramInt2, 128))
      a(localb, "SELECT group_id FROM conversations WHERE conversation_type=5", "key_not_synced_public_group");
    if (a(paramInt1, paramInt2, 129))
      a(localb, "SELECT group_id FROM conversations WHERE conversation_type=5 AND group_role IN (2,1,4)", "key_not_synced_banned_users_list");
    if (a(paramInt1, paramInt2, 134))
      a(localb, "SELECT group_id FROM conversations WHERE conversation_type=5 AND group_role IN (2,1,4) AND mute_notification=0");
    b(localb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.a.a
 * JD-Core Version:    0.6.2
 */