package com.viber.provider.messages.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.viber.common.b.h;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.bk;
import com.viber.voip.messages.extensions.model.c.b;
import com.viber.voip.messages.orm.entity.impl.ChatExtensionEntityHelper;
import com.viber.voip.permissions.o;
import com.viber.voip.registration.ao.b;
import com.viber.voip.registration.s;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.settings.d.af;
import com.viber.voip.settings.d.bh;
import com.viber.voip.settings.d.g;
import com.viber.voip.settings.d.n;
import com.viber.voip.settings.d.o;
import com.viber.voip.settings.d.p;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.at;
import com.viber.voip.util.cv;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sqlite.database.DatabaseUtils;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteOpenHelper;
import org.sqlite.database.sqlite.SQLiteStatement;

public class d extends com.viber.provider.messages.a.a
{
  private static volatile d b = null;
  private static final Logger c = ViberEnv.getLogger();

  private d(Context paramContext)
  {
    super(paramContext);
    this.enableJournalSizeLimit = false;
  }

  public static com.viber.provider.b a(Context paramContext)
  {
    return com.viber.provider.messages.c.a(d(paramContext).getWritableDatabase());
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (b != null)
    {
      i.a();
      com.viber.provider.b localb = a(paramContext);
      if (paramBoolean)
        b.a(localb);
      b.b(localb);
    }
  }

  private static String[] a(boolean paramBoolean)
  {
    String[] arrayOfString1 = dx.a("12345", paramBoolean).toString().split("12345");
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = arrayOfString1[0];
    arrayOfString2[1] = arrayOfString1[1];
    return arrayOfString2;
  }

  public static com.viber.provider.b b(Context paramContext)
  {
    return com.viber.provider.messages.c.a(d(paramContext).getReadableDatabase());
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramSQLiteDatabase.execSQL(String.format("UPDATE conversations SET icon_id = ? || icon_id || ? WHERE icon_id IS NOT NULL AND icon_id <> '' AND icon_id <> '0' AND %s", new Object[] { "conversation_type=1" }), a(false));
      paramSQLiteDatabase.execSQL(String.format("UPDATE conversations SET icon_id = ? || icon_id || ? WHERE icon_id IS NOT NULL AND icon_id <> '' AND icon_id <> '0' AND %s", new Object[] { "(conversation_type=2 OR conversation_type=3)" }), a(true));
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }

  public static void c(Context paramContext)
  {
    if (b != null)
    {
      i.a();
      com.viber.provider.b localb = a(paramContext);
      localb.c("messages");
      b.c(localb);
    }
  }

  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE conversations ADD COLUMN share_location INTEGER DEFAULT 0;");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private long d(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(5);
    return DatabaseUtils.longForQuery(paramSQLiteDatabase, "SELECT COUNT(*) FROM conversations WHERE conversation_type=?", arrayOfString);
  }

  private static SQLiteOpenHelper d(Context paramContext)
  {
    com.viber.provider.messages.b.i();
    if (b == null);
    try
    {
      if (b == null)
      {
        com.viber.voip.e.a.e.b().a("DATA", "ViberMessagesHelper init");
        b = new d(paramContext);
      }
      return b;
    }
    finally
    {
    }
  }

  private void d(com.viber.provider.b paramb)
  {
    long l = 0L;
    try
    {
      l = paramb.b("SELECT COUNT(*) FROM messages").simpleQueryForLong();
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.a(l));
      return;
    }
    catch (Exception localException)
    {
      c.a(localException, "logMessagesCountToCrashlytics error on " + l);
    }
  }

  private void e(com.viber.provider.b paramb)
  {
    paramb.a("DELETE FROM participants WHERE participants.participant_info_id=(" + "SELECT participants_info._id FROM participants_info WHERE participants_info.participant_type=0" + ") AND " + "participants" + "." + "conversation_id" + " IN (" + "SELECT conversations._id FROM conversations WHERE conversations.conversation_type IN (2, 3) AND conversations.group_role=3" + ")");
  }

  private void e(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("stickers_packages", null, null, null, null, null, null);
    SparseArray localSparseArray = new SparseArray();
    if ((!com.viber.voip.util.af.b(localCursor)) && (localCursor.moveToFirst()))
    {
      do
      {
        int k = localCursor.getInt(localCursor.getColumnIndex("_id"));
        String str = localCursor.getString(localCursor.getColumnIndex("package_info"));
        com.viber.voip.stickers.entity.c localc = new com.viber.voip.stickers.entity.c();
        localc.b(str);
        localSparseArray.put(k, localc.a());
      }
      while (localCursor.moveToNext());
      com.viber.voip.util.af.a(localCursor);
    }
    ContentValues localContentValues = new ContentValues();
    for (int i = 0; i < localSparseArray.size(); i++)
    {
      int j = localSparseArray.keyAt(i);
      localContentValues.clear();
      localContentValues.put("package_info", (String)localSparseArray.get(j));
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Integer.toString(j);
      paramSQLiteDatabase.update("stickers_packages", localContentValues, "_id = ?", arrayOfString);
    }
  }

  private void f(com.viber.provider.b paramb)
  {
    String str1 = d.n.g.d();
    if (TextUtils.isEmpty(str1))
      return;
    c.b[] arrayOfb = ((com.viber.voip.messages.extensions.model.c)new com.google.d.f().a(str1, com.viber.voip.messages.extensions.model.c.class)).a();
    paramb.a();
    while (true)
    {
      try
      {
        String str2 = d.n.j.d();
        int i = arrayOfb.length;
        int j = 0;
        if (j < i)
        {
          c.b localb = arrayOfb[j];
          ContentValues localContentValues = ChatExtensionEntityHelper.getContentValues(localb, j);
          if (!localb.b().equals(str2))
            break label157;
          k = 0;
          localContentValues.put("featured_index", Integer.valueOf(k));
          paramb.a("chat_extensions", null, localContentValues);
          j++;
          continue;
        }
        d.n.g.b();
        paramb.c();
        return;
      }
      finally
      {
        paramb.b();
      }
      label157: int k = 2147483647;
    }
  }

  private void f(SQLiteDatabase paramSQLiteDatabase)
  {
    String str = UserManager.from(this.a).getRegistrationValues().h();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("number", str);
    localContentValues.put("encrypted_number", str);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(0);
    paramSQLiteDatabase.update("participants_info", localContentValues, "(number = '' OR number IS NULL) AND participant_type = ?", arrayOfString);
  }

  private void g(SQLiteDatabase paramSQLiteDatabase)
  {
    String str = UserManager.from(this.a).getRegistrationValues().k();
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("encrypted_member_id", str);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(0);
    paramSQLiteDatabase.update("participants_info", localContentValues, "participant_type = ?", arrayOfString);
  }

  private void h(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("UPDATE conversations SET flags=flags | (1 << 18) WHERE _id IN(SELECT conversations._id FROM conversations LEFT OUTER JOIN participants_info ON (conversations.participant_id_1=participants_info._id) WHERE conversations.application_id > 2 AND participants_info.viber_name='viber')", new String[0]);
  }

  public long a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (d.af.h.a())
      try
      {
        String str1 = d.af.h.d();
        if (str1.length() > 0)
        {
          JSONArray localJSONArray = new JSONArray(str1);
          for (int i = 0; i < localJSONArray.length(); i++)
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            if (localJSONObject.has("url"))
            {
              String str2 = (String)localJSONObject.remove("url");
              ContentValues localContentValues = new ContentValues(3);
              localContentValues.put("object_id", "-2");
              localContentValues.put("key", str2);
              localContentValues.put("value", localJSONObject.toString());
              paramSQLiteDatabase.replace("kvdata", null, localContentValues);
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        d.af.h.b();
      }
    return 0L;
  }

  protected void a(com.viber.provider.b paramb)
  {
    paramb.c("messages");
    paramb.c("messages_likes");
    paramb.c("conversations");
    paramb.c("public_accounts");
    paramb.c("participants");
    paramb.c("participants_info");
    paramb.c("messages_calls");
    paramb.c("stickers");
    paramb.c("stickers_packages");
  }

  protected void a(com.viber.provider.b paramb, int paramInt1, int paramInt2)
  {
    super.a(paramb, paramInt1, paramInt2);
    paramb.a("DROP TABLE IF EXISTS conversations");
    paramb.a("DROP TABLE IF EXISTS conversation_auxiliary");
    paramb.a("DROP TABLE IF EXISTS public_accounts");
    paramb.a("DROP TABLE IF EXISTS messages_likes");
    paramb.a("DROP TABLE IF EXISTS participants");
    paramb.a("DROP TABLE IF EXISTS participants_info");
    paramb.a("DROP TABLE IF EXISTS messages");
    paramb.a("DROP TABLE IF EXISTS messages_calls");
    paramb.a("DROP TABLE IF EXISTS stickers");
    paramb.a("DROP TABLE IF EXISTS stickers_packages");
    paramb.a("DROP TABLE IF EXISTS backgrounds");
    paramb.a("DROP TABLE IF EXISTS purchase");
    paramb.a("DROP TABLE IF EXISTS adx");
    paramb.a("DROP TABLE IF EXISTS applications");
    paramb.a("DROP TABLE IF EXISTS blocked_data");
    paramb.a("DROP TABLE IF EXISTS remote_banners");
    paramb.a("DROP TABLE IF EXISTS group_delete_all_from_participant");
    paramb.a("DROP TABLE IF EXISTS conference_calls");
  }

  protected void b(com.viber.provider.b paramb)
  {
    a(a(), "db/messages_indexes.sql", paramb, c);
    a(a(), "db/other_tables_indexes.sql", paramb, c);
    a(a(), "db/conversations_tables_indexes.sql", paramb, c);
  }

  protected void c(com.viber.provider.b paramb)
  {
    a(a(), "db/messages_indexes_for_backup.sql", paramb, c);
  }

  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    this.useMemoryMapIo = true;
    this.memoryMapIoSize = 8388608;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    com.viber.provider.b localb = com.viber.provider.messages.c.a(paramSQLiteDatabase);
    localb.a("CREATE TABLE IF NOT EXISTS conversations (_id INTEGER PRIMARY KEY autoincrement,conversation_type INTEGER DEFAULT 0,group_id INTEGER DEFAULT 0,application_id INTEGER DEFAULT 0,share_location INTEGER DEFAULT 0,message_draft TEXT,msg_draft_spans TEXT DEFAULT '',deleted INTEGER DEFAULT 0,delete_token INTEGER DEFAULT 0,name TEXT,group_role INTEGER DEFAULT 1,icon_id TEXT,background_landscape TEXT, background_portrait TEXT, background_text_color INTEGER, smart_notification INTEGER,smart_event_date INTEGER DEFAULT 0, mute_notification INTEGER, favourite_conversation INTEGER DEFAULT 0, flags INTEGER DEFAULT 0,date INTEGER DEFAULT 0,bot_reply TEXT DEFAULT '', timebomb_time INTEGER DEFAULT 60,read_notification_token INTEGER DEFAULT 0,participant_id_1 INTEGER DEFAULT 0,participant_id_2 INTEGER DEFAULT 0,participant_id_3 INTEGER DEFAULT 0,participant_id_4 INTEGER DEFAULT 0,creator_participant_id INTEGER DEFAULT 0,reply_banner_draft TEXT,business_inbox_flags INTEGER DEFAULT 0,to_number TEXT DEFAULT NULL,grouping_key TEXT DEFAULT NULL,snoozed_conversation_time INTEGER DEFAULT 0 );");
    localb.a("CREATE TABLE IF NOT EXISTS public_accounts (_id INTEGER PRIMARY KEY autoincrement,group_id INTEGER DEFAULT 0,group_uri TEXT,background_id TEXT,location_lat INTEGER DEFAULT 0,location_lng INTEGER DEFAULT 0,country TEXT,location_address TEXT,revision INTEGER DEFAULT 0,watchers_count INTEGER DEFAULT 0,watchers_count_ref INTEGER DEFAULT 0,watchers_count_ref_date INTEGER DEFAULT 0,tag_line TEXT, tags TEXT, local_message_id INTEGER DEFAULT 0, server_message_id INTEGER DEFAULT 0, canceled_message_id INTEGER DEFAULT 0, verified INTEGER,inviter TEXT, invitation_token INTEGER DEFAULT 0, last_media_type TEXT, last_msg_text TEXT, sender_phone TEXT, sender_name TEXT, sender_photo_id TEXT, last_read_message_id INTEGER DEFAULT 0, group_enter_count INTEGER DEFAULT 0, pg_extra_flags INTEGER DEFAULT 0,public_account_id TEXT, webhook_exists INTEGER DEFAULT 0, website TEXT, email TEXT, auth_token TEXT, category_id TEXT, subcategory_id TEXT, crm TEXT, subscribers_count INTEGER DEFAULT 0, subscription_status INTEGER DEFAULT 0, extra_info TEXT, community_privileges INTEGER DEFAULT 9223372036854775807, chat_background TEXT DEFAULT NULL, custom_chat_background TEXT DEFAULT NULL, my_settings TEXT DEFAULT '');");
    localb.a("CREATE TABLE IF NOT EXISTS participants (_id INTEGER PRIMARY KEY autoincrement,conversation_id INTEGER DEFAULT 0,participant_info_id INTEGER DEFAULT 0,last_message_id INTEGER DEFAULT 0,active INTEGER DEFAULT TRUE, group_role INTEGER DEFAULT 1, group_role_local INTEGER DEFAULT 1);");
    localb.a("CREATE TABLE IF NOT EXISTS participants_info (_id INTEGER PRIMARY KEY autoincrement,number TEXT,encrypted_number TEXT,display_name TEXT,contact_name TEXT,contact_id INTEGER DEFAULT 0,viber_id TEXT,viber_name TEXT,viber_image TEXT,participant_type INTEGER DEFAULT 1, has_contact_name INTEGER DEFAULT 0, native_photo_id INTEGER DEFAULT 0, has_photo INTEGER DEFAULT 0, member_id TEXT, encrypted_member_id TEXT, participant_info_flags INTEGER DEFAULT 0, up_date INTEGER DEFAULT 0);");
    localb.a("CREATE TABLE IF NOT EXISTS messages (_id INTEGER PRIMARY KEY autoincrement,conversation_id INTEGER DEFAULT 0,order_key INTEGER,msg_date INTEGER NOT NULL,token INTEGER,conversation_type INTEGER DEFAULT 0,participant_id INTEGER DEFAULT 0,unread INTEGER DEFAULT 0,flag INTEGER DEFAULT 0,group_id INTEGER DEFAULT 0,extra_flags INTEGER DEFAULT 0,deleted INTEGER DEFAULT 0,send_type INTEGER NOT NULL,extra_mime INTEGER,user_id TEXT NOT NULL,seq INTEGER,status INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,sync_read INTEGER DEFAULT 0,location_lat INTEGER,location_lng INTEGER,extra_uri TEXT,extra_status INTEGER,message_global_id INTEGER,extra_upload_id INTEGER,extra_download_id TEXT,extra_bucket_name TEXT,extra_duration INTEGER,body TEXT,description TEXT,msg_info TEXT,event_count INTEGER DEFAULT 1,likes_count INTEGER DEFAULT 0,spans TEXT,encryption_params TEXT,timebomb INTEGER DEFAULT 0,read_message_time INTEGER DEFAULT 0,scroll_pos INTEGER DEFAULT 0,broadcast_msg_id INTEGER DEFAULT 0,quoted_message_data TEXT);");
    localb.a("CREATE TABLE IF NOT EXISTS messages_calls (_id INTEGER PRIMARY KEY AUTOINCREMENT,conversation_id INTEGER NOT NULL,message_id INTEGER NOT NULL,canonized_number TEXT NOT NULL,viber_call_type INTEGER DEFAULT 1, date INTEGER NOT NULL,duration INTEGER NOT NULL,type INTEGER NOT NULL,end_reason INTEGER DEFAULT 0,start_reason INTEGER DEFAULT 0,token INTEGER DEFAULT 0);");
    localb.a("CREATE TABLE IF NOT EXISTS messages_likes (_id INTEGER PRIMARY KEY AUTOINCREMENT,message_token INTEGER NOT NULL,like_token INTEGER DEFAULT 0,seq INTEGER DEFAULT 0,participant_number TEXT NOT NULL,date INTEGER DEFAULT 0,read INTEGER DEFAULT 0,sync_read INTEGER DEFAULT 0,status INTEGER DEFAULT 0);");
    localb.a("CREATE TABLE IF NOT EXISTS stickers_packages ( _id INTEGER PRIMARY KEY NOT NULL, package_info TEXT, flags INTEGER DEFAULT 0, thumb_axis_shrink_factor REAL DEFAULT 0, visibility INTEGER DEFAULT 0, menu_position INTEGER DEFAULT 0, version REAL DEFAULT 1.0);");
    localb.a("CREATE TABLE IF NOT EXISTS stickers ( _id INTEGER PRIMARY KEY NOT NULL, package_id INTEGER DEFAULT 0, generic_col_pos INTEGER DEFAULT 0, generic_row_pos INTEGER DEFAULT 0, column_span INTEGER DEFAULT 0, row_span INTEGER DEFAULT 0, flags INTEGER DEFAULT 0 );");
    localb.a("CREATE TABLE IF NOT EXISTS backgrounds (_id INTEGER PRIMARY KEY NOT NULL, background_id INTEGER DEFAULT 0, color TEXT);");
    localb.a("CREATE TABLE IF NOT EXISTS adx ( _id INTEGER PRIMARY KEY NOT NULL, event_name TEXT, last_tracked INTEGER NOT NULL );");
    localb.a("CREATE TABLE IF NOT EXISTS applications ( _id INTEGER PRIMARY KEY NOT NULL, name TEXT, type TEXT, package_name TEXT, store_id TEXT, url_scheme TEXT, status INTEGER, flags INTEGER DEFAULT 0, last_modified INTEGER DEFAULT (1000*strftime('%s','now')) );");
    localb.a("CREATE TABLE IF NOT EXISTS blocked_data (_id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER, data_1 TEXT, data_2 TEXT, data_3 TEXT DEFAULT NULL, seq INTEGER, status INTEGER DEFAULT 0, UNIQUE (data_1) ON CONFLICT REPLACE);");
    localb.a("CREATE TABLE IF NOT EXISTS purchase ( order_id TEXT PRIMARY KEY NOT NULL, category INTEGER, type TEXT, package_name TEXT, product_id TEXT, purchase_time INTEGER DEFAULT 0, purchase_state INTEGER DEFAULT 0, dev_payload TEXT, token TEXT, json TEXT, signature TEXT,verified INTEGER DEFAULT 0, consumed INTEGER DEFAULT 0, pending INTEGER DEFAULT 0, productjson TEXT);");
    localb.a("CREATE TABLE IF NOT EXISTS remote_banners (_id INTEGER PRIMARY KEY AUTOINCREMENT, token INTEGER NOT NULL, type TEXT NOT NULL, position TEXT, end_time INTEGER DEFAULT 0, meta TEXT, tag TEXT, dummy INTEGER DEFAULT 0, location TEXT, flags INTEGER DEFAULT 0);");
    localb.a("CREATE TABLE IF NOT EXISTS group_delete_all_from_participant (_id INTEGER PRIMARY KEY AUTOINCREMENT, group_id INTEGER DEFAULT 0, participant_encrypted_number TEXT NOT NULL, last_message_token INTEGER DEFAULT 0, UNIQUE(group_id, participant_encrypted_number) ON CONFLICT REPLACE);");
    localb.a("CREATE TABLE IF NOT EXISTS conference_calls (_id INTEGER PRIMARY KEY AUTOINCREMENT, conversation_id INTEGER DEFAULT 0, call_token INTEGER DEFAULT 0, conference_info TEXT NOT NULL, start_time_millis INTEGER DEFAULT 0, UNIQUE (conversation_id) ON CONFLICT REPLACE);");
    localb.a("CREATE TABLE IF NOT EXISTS chat_extensions(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, uri TEXT, icon TEXT, icon_old TEXT, public_account_id TEXT, header_text TEXT, search_hint TEXT, flags INTEGER DEFAULT 0, last_use_time INTEGER DEFAULT 0, featured_index INTEGER DEFAULT 2147483647, order_key INTEGER DEFAULT 0, chat_extension_flags INTEGER DEFAULT 0);");
    localb.a("CREATE TABLE IF NOT EXISTS conversation_auxiliary(_id INTEGER PRIMARY KEY, media_size TEXT NOT NULL DEFAULT \"\");");
    localb.a("CREATE TABLE IF NOT EXISTS chatex_suggestions(_id INTEGER PRIMARY KEY AUTOINCREMENT, keyword TEXT, service_uri TEXT, country TEXT, timeframe_from INTEGER DEFAULT 0, timeframe_to INTEGER DEFAULT 0);");
    localb.a("CREATE TRIGGER IF NOT EXISTS trigger_apps_update AFTER UPDATE ON applications BEGIN UPDATE applications SET last_modified = (1000*strftime('%s','now')) WHERE _id = old._id; END;");
    localb.a("CREATE TRIGGER IF NOT EXISTS trigger_message_likes_delete AFTER DELETE ON messages BEGIN DELETE FROM messages_likes WHERE message_token = OLD.token; END;");
    localb.a("CREATE TRIGGER IF NOT EXISTS trigger_message_calls_delete AFTER DELETE ON messages BEGIN DELETE FROM messages_calls WHERE message_id = OLD._id; END;");
    localb.a("CREATE TRIGGER IF NOT EXISTS trigger_conversations_delete AFTER DELETE ON conversations BEGIN DELETE FROM public_accounts WHERE group_id = OLD.group_id AND  (SELECT COUNT(_id) FROM participants_info WHERE participants_info.member_id=public_accounts.public_account_id )=0; END;");
    localb.a("CREATE TRIGGER IF NOT EXISTS trigger_clear_group_delete_all_from_participant AFTER DELETE ON conversations BEGIN DELETE FROM group_delete_all_from_participant WHERE group_id = OLD.group_id; END;");
    localb.a("CREATE TRIGGER IF NOT EXISTS " + a.a.a);
    localb.a("CREATE TRIGGER IF NOT EXISTS " + a.a.b);
    localb.a("CREATE TRIGGER IF NOT EXISTS trigger_conversation_auxiliary_insert AFTER INSERT ON conversations BEGIN INSERT INTO conversation_auxiliary (_id) VALUES (NEW._id); END;");
    localb.a("CREATE TRIGGER IF NOT EXISTS trigger_conversation_auxiliary_delete AFTER DELETE ON conversations BEGIN DELETE FROM conversation_auxiliary WHERE conversation_auxiliary._id = OLD._id; END;");
    a(a(), "db/script_for_filling_stickers_table.sql", localb, c);
    a(a(), "db/doodle_sticker_pack_migration_92.sql", localb, c);
    a(a(), "db/messages_indexes.sql", localb, c);
    a(a(), "db/other_tables_indexes.sql", localb, c);
    at.h(dv.G.a(this.a));
    d.g.c.a(false);
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    c.a(new RuntimeException("onDowngrade"), "from version : " + paramInt1 + " to version : " + paramInt2);
  }

  public void onPostOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onPostOpen(paramSQLiteDatabase);
    com.viber.voip.e.a.e.b().a("DATA", "ViberMessagesHelper onPostOpen");
    com.viber.provider.b localb;
    if (paramSQLiteDatabase.isReadOnly())
      localb = a(a());
    try
    {
      localb.a();
      new b().a(localb);
      localb.a("UPDATE messages SET extra_status = 3, extra_flags = extra_flags& ~(1 << 22) WHERE extra_status = 13");
      localb.c();
      localb.b();
      com.viber.voip.e.a.e.b().b("DATA", "ViberMessagesHelper onPostOpen");
      return;
      localb = com.viber.provider.messages.c.a(paramSQLiteDatabase);
    }
    finally
    {
      localb.b();
    }
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    com.viber.voip.e.a.e.b().a("DATA", "onUpgrade");
    com.viber.provider.b localb = com.viber.provider.messages.c.a(paramSQLiteDatabase);
    if (paramInt1 < 49)
    {
      a(localb, paramInt1, paramInt2);
      onCreate(paramSQLiteDatabase);
      return;
    }
    if (c.a.a.a.c.i())
      com.crashlytics.android.a.a("Upgrade MessagesDB from ", "" + paramInt1);
    i.a();
    if (a(paramInt1, paramInt2, 50))
      a(a(), "db/messages_migration_50.sql", localb, c);
    if (a(paramInt1, paramInt2, 52))
      a(a(), "db/messages_migration_52.sql", localb, c);
    if (a(paramInt1, paramInt2, 53))
      a(a(), "db/messages_migration_53(public groups).sql", localb, c);
    if (a(paramInt1, paramInt2, 54))
      a(a(), "db/messages_migration_54.sql", localb, c);
    if (a(paramInt1, paramInt2, 55))
    {
      a(a(), "db/messages_migration_55.sql", localb, c);
      a(a(), "db/sticker_default_package_flag.sql", localb, c);
    }
    if (a(paramInt1, paramInt2, 57))
    {
      at.h(dv.G.a(this.a));
      a(a(), "db/messages_migration_57.sql", localb, c);
    }
    if (a(paramInt1, paramInt2, 58))
      a(a(), "db/messages_migration_58.sql", localb, c);
    if (a(paramInt1, paramInt2, 60))
      a(a(), "db/messages_migration_60.sql", localb, c);
    if (a(paramInt1, paramInt2, 62))
    {
      a(a(), "db/messages_migration_62.sql", localb, c);
      a(paramSQLiteDatabase);
    }
    if (a(paramInt1, paramInt2, 63))
      a(a(), "db/messages_migration_63.sql", localb, c);
    if (a(paramInt1, paramInt2, 64))
      a(a(), "db/messages_migration_64.sql", localb, c);
    if (a(paramInt1, paramInt2, 65))
    {
      a(a(), "db/messages_migration_65.sql", localb, c);
      f(paramSQLiteDatabase);
      com.viber.voip.f.a.a(bk.b());
    }
    if (a(paramInt1, paramInt2, 66))
      a(a(), "db/messages_migration_66.sql", localb, c);
    if (a(paramInt1, paramInt2, 67))
      a(a(), "db/messages_migration_67.sql", localb, c);
    if (a(paramInt1, paramInt2, 72))
    {
      a(a(), "db/messages_migration_72.sql", localb, c);
      a(localb);
    }
    if (a(paramInt1, paramInt2, 73))
      a(a(), "db/messages_migration_73.sql", localb, c);
    if (a(paramInt1, paramInt2, 74))
      a(localb);
    if (a(paramInt1, paramInt2, 76))
      b(paramSQLiteDatabase);
    if (a(paramInt1, paramInt2, 77))
      a(a(), "db/messages_migration_77.sql", localb, c);
    if (a(paramInt1, paramInt2, 78))
      a(a(), "db/messages_migration_78.sql", localb, c);
    if (a(paramInt1, paramInt2, 79))
    {
      a(a(), "db/messages_migration_79.sql", localb, c);
      com.viber.voip.memberid.d.b();
      localb.a("UPDATE participants_info SET member_id=number");
    }
    if (a(paramInt1, paramInt2, 80))
      a(a(), "db/messages_migration_80.sql", localb, c);
    if (a(paramInt1, paramInt2, 81))
      a(a(), "db/messages_migration_81.sql", localb, c);
    if (a(paramInt1, paramInt2, 84))
      a(a(), "db/messages_migration_84.sql", localb, c);
    if (a(paramInt1, paramInt2, 86))
    {
      a(a(), "db/messages_migration_86.sql", localb, c);
      e(paramSQLiteDatabase);
    }
    if (a(paramInt1, paramInt2, 87))
      at.h(dv.G.a(this.a));
    if (a(paramInt1, paramInt2, 88))
      a(a(), "db/messages_migration_88.sql", localb, c);
    if (a(paramInt1, paramInt2, 89))
    {
      a(a(), "db/messages_migration_89.sql", localb, c);
      ViberApplication.getInstance().getBackupManager().b();
    }
    if (a(paramInt1, paramInt2, 91))
      a(a(), "db/messages_migration_91.sql", localb, c);
    if (a(paramInt1, paramInt2, 93))
    {
      at.a(com.viber.voip.stickers.c.g.a(this.a, 143700), false);
      a(a(), "db/doodle_sticker_pack_migration_92.sql", localb, c);
    }
    if (a(paramInt1, paramInt2, 95))
      a(a(), "db/messages_migration_95.sql", localb, c);
    if (a(paramInt1, paramInt2, 96))
      h(paramSQLiteDatabase);
    if (a(paramInt1, paramInt2, 98))
      a(a(), "db/messages_migration_98.sql", localb, c);
    if (a(paramInt1, paramInt2, 101))
      a(a(), "db/messages_migration_101.sql", localb, c);
    if (a(paramInt1, paramInt2, 102))
    {
      a(a(), "db/messages_migration_102.sql", localb, c);
      new o(a(), localb).a();
    }
    if (a(paramInt1, paramInt2, 103))
      a(a(), "db/messages_migration_103.sql", localb, c);
    if (a(paramInt1, paramInt2, 104))
      a(a(), "db/messages_migration_104.sql", localb, c);
    if (a(paramInt1, paramInt2, 105))
      a(a(), "db/messages_migration_105.sql", localb, c);
    if (a(paramInt1, paramInt2, 109))
      a(a(), "db/messages_migration_109.sql", localb, c);
    if (a(paramInt1, paramInt2, 110))
      a(a(), "db/messages_migration_110.sql", localb, c);
    if (a(paramInt1, paramInt2, 113))
      a(a(), "db/messages_migration_113.sql", localb, c);
    if (a(paramInt1, paramInt2, 114))
    {
      a(localb);
      a(a(), "db/messages_migration_114.sql", localb, c);
      s.a(ao.b.b, e.a.l.d());
    }
    int n;
    int k;
    label1837: int m;
    label1850: com.viber.common.b.b localb1;
    if (a(paramInt1, paramInt2, 117))
    {
      a(a(), "db/messages_migration_117.sql", localb, c);
      long l2 = d(paramSQLiteDatabase);
      com.viber.common.b.d locald2 = d.p.s;
      if (l2 == 0L)
      {
        n = 1;
        locald2.a(n);
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = String.valueOf(0);
        long l3 = DatabaseUtils.longForQuery(paramSQLiteDatabase, "SELECT SUM([messages].[unread]) AS unread FROM messages WHERE ([messages].conversation_type=0 OR [messages].conversation_type=1)  AND [messages].[unread] > 0  AND ([messages].[deleted] IS NULL OR [messages].[deleted]=0)  AND [messages].[extra_mime]<>1008 AND [messages].[extra_mime]<>1007 AND [messages].[conversation_id]<>? AND [messages].[extra_flags] & 4194304 = 0 AND [messages].[conversation_id] IN(SELECT _id FROM conversations WHERE flags & (1 << 18) = 0  AND conversations.mute_notification=0 AND favourite_conversation <> -1 )", arrayOfString1);
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = String.valueOf(0);
        long l4 = DatabaseUtils.longForQuery(paramSQLiteDatabase, "SELECT  SUM (MAX(local_message_id, server_message_id) - last_read_message_id) FROM public_accounts LEFT JOIN conversations ON conversations.group_id = public_accounts.group_id WHERE conversations.conversation_type = 5 AND conversations.deleted=0 AND conversations.mute_notification=0 AND conversations._id<>?", arrayOfString2);
        cv.a().a((int)l3);
        cv.a().b((int)l4);
      }
    }
    else
    {
      if (a(paramInt1, paramInt2, 118))
        a(a(), "db/messages_migration_118.sql", localb, c);
      if (a(paramInt1, paramInt2, 119))
        a(a(), "db/messages_migration_119.sql", localb, c);
      if (a(paramInt1, paramInt2, 122))
        at.a(dv.G.a(this.a), false);
      if (a(paramInt1, paramInt2, 123))
        a(a(), "db/messages_migration_123.sql", localb, c);
      if (a(paramInt1, paramInt2, 124))
        a(a(), "db/messages_migration_124.sql", localb, c);
      if (a(paramInt1, paramInt2, 126))
        e(localb);
      if (a(paramInt1, paramInt2, 127))
      {
        a(a(), "db/messages_migration_127.sql", localb, c);
        at.a(dv.G.a(this.a), false);
      }
      if (a(paramInt1, paramInt2, 130))
        a(a(), "db/messages_migration_130.sql", localb, c);
      if (a(paramInt1, paramInt2, 131))
        a(a(), "db/messages_migration_131.sql", localb, c);
      if (a(paramInt1, paramInt2, 132))
      {
        a(a(), "db/messages_migration_132.sql", localb, c);
        av.e.f.a().post(new e(this));
      }
      if (a(paramInt1, paramInt2, 135))
        a(a(), "db/messages_migration_135.sql", localb, c);
      if (a(paramInt1, paramInt2, 136))
      {
        a(a(), "db/messages_migration_136.sql", localb, c);
        f(localb);
      }
      if (a(paramInt1, paramInt2, 139))
        a(a(), "db/messages_migration_139.sql", localb, c);
      if (a(paramInt1, paramInt2, 140))
        a(a(), "db/messages_migration_140.sql", localb, c);
      if (a(paramInt1, paramInt2, 141))
        a(a(), "db/messages_migration_141.sql", localb, c);
      if (a(paramInt1, paramInt2, 142))
        a(a(), "db/messages_migration_142.sql", localb, c);
      if (a(paramInt1, paramInt2, 143))
      {
        a(a(), "db/messages_migration_143.sql", localb, c);
        g(paramSQLiteDatabase);
        int j = d.p.s.d();
        if ((j != 4) && (j != 3))
          break label2175;
        k = 1;
        com.viber.common.b.d locald1 = d.p.t;
        if (k == 0)
          break label2181;
        m = 0;
        locald1.a(m);
        long l1 = d(paramSQLiteDatabase);
        localb1 = d.o.e;
        if (l1 <= 0L)
          break label2187;
      }
    }
    label2181: label2187: for (boolean bool2 = true; ; bool2 = false)
    {
      localb1.a(bool2);
      if (a(paramInt1, paramInt2, 144))
        a(a(), "db/messages_migration_144.sql", localb, c);
      if (a(paramInt1, paramInt2, 146))
        a(a(), "db/messages_migration_146.sql", localb, c);
      if (a(paramInt1, paramInt2, 148))
      {
        a(a(), "db/messages_migration_148.sql", localb, c);
        boolean bool1 = DatabaseUtils.longForQuery(paramSQLiteDatabase, "SELECT COUNT (*) FROM conversations WHERE flags & (1 << 34) <> 0", null) < 0L;
        int i = 0;
        if (bool1)
          i = 1;
        if ((i != 0) && (d.bh.c.d() == 1))
          d.bh.c.a(2);
      }
      if (a(paramInt1, paramInt2, 149))
        a(a(), "db/messages_migration_149.sql", localb, c);
      if (a(paramInt1, paramInt2, 152))
      {
        c(paramSQLiteDatabase);
        a(a(), "db/messages_migration_152.sql", localb, c);
      }
      if (a(paramInt1, paramInt2, 153))
        a(a(), "db/messages_migration_153.sql", localb, c);
      if (a(paramInt1, paramInt2, 154))
        new com.viber.provider.messages.b.a.a(paramSQLiteDatabase, c).a();
      if (a(paramInt1, paramInt2, 155))
        a(a(), "db/messages_migration_155.sql", localb, c);
      b(localb);
      d(localb);
      com.viber.voip.e.a.e.b().b("DATA", "onUpgrade");
      return;
      n = 0;
      break;
      label2175: k = 0;
      break label1837;
      m = 5;
      break label1850;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.b.d
 * JD-Core Version:    0.6.2
 */