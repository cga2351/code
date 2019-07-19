package com.viber.provider.contacts.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ac;
import com.viber.voip.settings.d.p;
import com.viber.voip.util.af;
import org.sqlite.database.DatabaseUtils;
import org.sqlite.database.SQLException;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteOpenHelper;

public class a extends com.viber.provider.e
{
  public static final Logger b = ViberEnv.getLogger();
  private static volatile a c = null;

  private a(Context paramContext)
  {
    super(paramContext, "viber_data");
  }

  private int a(SQLiteDatabase paramSQLiteDatabase)
  {
    return (int)DatabaseUtils.longForQuery(paramSQLiteDatabase, "SELECT COUNT(*) FROM phonebookcontact WHERE has_number=1 AND viber=1", null);
  }

  public static com.viber.provider.b a(Context paramContext)
  {
    return com.viber.provider.messages.c.a(c(paramContext).getWritableDatabase());
  }

  private void a(com.viber.provider.b paramb, int paramInt1, int paramInt2)
  {
    paramb.a("DROP TABLE IF EXISTS phonebookrawcontact");
    paramb.a("DROP TABLE IF EXISTS phonebookcontact");
    paramb.a("DROP TABLE IF EXISTS phonebookdata");
    paramb.a("DROP TABLE IF EXISTS vibernumbers");
    paramb.a("DROP TABLE IF EXISTS calls");
    paramb.a("DROP TABLE IF EXISTS blockednumbers");
    paramb.a("DROP TABLE IF EXISTS sync_data");
  }

  public static com.viber.provider.b b(Context paramContext)
  {
    return com.viber.provider.messages.c.a(c(paramContext).getReadableDatabase());
  }

  private static SQLiteOpenHelper c(Context paramContext)
  {
    com.viber.provider.messages.b.i();
    if (c == null);
    try
    {
      if (c == null)
      {
        com.viber.voip.e.a.e.b().a("DATA", "ViberContactsHelper init");
        c = new a(paramContext);
      }
      return c;
    }
    finally
    {
    }
  }

  private void c(com.viber.provider.b paramb)
  {
    paramb.a("CREATE TABLE IF NOT EXISTS calls (_id INTEGER PRIMARY KEY AUTOINCREMENT,call_id LONG NOT NULL,aggregate_hash LONG NOT NULL,number TEXT NOT NULL,canonized_number TEXT NOT NULL,viber_call BOOLEAN DEFAULT TRUE,viber_call_type INTEGER DEFAULT 1, date LONG NOT NULL,duration LONG NOT NULL,type INT NOT NULL,end_reason INT DEFAULT 0,start_reason INT DEFAULT 0,token LONG DEFAULT 0,looked BOOLEAN DEFAULT TRUE,conference_info TEXT);");
    paramb.a("CREATE TABLE IF NOT EXISTS phonebookrawcontact (_id INTEGER PRIMARY KEY NOT NULL,native_id INTEGER DEFAULT 0,contact_id INTEGER NOT NULL,version INTEGER NOT NULL,starred BOOLEAN NOT NULL,  UNIQUE (_id) ON CONFLICT REPLACE);");
    paramb.a("CREATE TABLE IF NOT EXISTS phonebookcontact (_id INTEGER PRIMARY KEY NOT NULL,native_id INTEGER DEFAULT 0,display_name TEXT,phonetic_name TEXT,phone_label TEXT,low_display_name TEXT,starred BOOLEAN, viber BOOLEAN, contact_lookup_key TEXT, contact_hash LONG, version INTEGER DEFAULT 0, has_number BOOLEAN, has_name BOOLEAN, native_photo_id LONG DEFAULT 0, recently_joined_date LONG DEFAULT 0, joined_date LONG DEFAULT 0, numbers_name TEXT DEFAULT '', deleted BOOLEAN, flags INTEGER DEFAULT 0,  UNIQUE (_id) ON CONFLICT REPLACE);");
    paramb.a("CREATE TABLE IF NOT EXISTS phonebookdata (_id INTEGER PRIMARY KEY AUTOINCREMENT,native_id INTEGER DEFAULT 0,contact_id INTEGER NOT NULL,raw_id INTEGER NOT NULL,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT, int_data1 INTEGER DEFAULT 0, int_data2 INTEGER DEFAULT 0, mime_type INTEGER, clear INTEGER DEFAULT 0);");
    paramb.a("CREATE TABLE IF NOT EXISTS vibernumbers (_id INTEGER PRIMARY KEY AUTOINCREMENT,canonized_number TEXT NOT NULL,photo TEXT DEFAULT '', viber_name TEXT, clear BOOLEAN, member_id TEXT NOT NULL, encrypted_member_id TEXT NOT NULL, viber_id TEXT);");
    paramb.a("CREATE TABLE IF NOT EXISTS blockednumbers (_id INTEGER PRIMARY KEY AUTOINCREMENT, canonized_number TEXT NOT NULL,blocked_date LONG DEFAULT 0, block_reason INTEGER DEFAULT 0,  UNIQUE (canonized_number) ON CONFLICT REPLACE );");
    paramb.a("CREATE TABLE IF NOT EXISTS walletnumbers (_id INTEGER PRIMARY KEY AUTOINCREMENT, canonized_number TEXT NOT NULL,wallet_wu_status INTEGER DEFAULT 0,  UNIQUE (canonized_number) ON CONFLICT REPLACE );");
    paramb.a("CREATE TABLE IF NOT EXISTS walletlist (_id INTEGER PRIMARY KEY AUTOINCREMENT, country_codes INTEGER NOT NULL);");
    paramb.a("CREATE TABLE IF NOT EXISTS sync_data (_id INTEGER PRIMARY KEY AUTOINCREMENT,canonized_phone_number TEXT NOT NULL,display_name TEXT DEFAULT '',phonetic_name TEXT DEFAULT '',operation INTEGER  DEFAULT 0);");
  }

  protected void a(com.viber.provider.b paramb)
  {
    paramb.c("phonebookcontact");
    paramb.c("vibernumbers");
    paramb.c("phonebookrawcontact");
    paramb.c("phonebookdata");
  }

  protected void b(com.viber.provider.b paramb)
  {
    a(a(), "db/contacts_indexes.sql", paramb, b);
  }

  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    this.useMemoryMapIo = true;
    this.memoryMapIoSize = 1048576;
    this.executeVacuumAfterUpgrade = true;
    paramSQLiteDatabase.setLocale(Resources.getSystem().getConfiguration().locale);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    com.viber.provider.b localb = com.viber.provider.messages.c.a(paramSQLiteDatabase);
    c(localb);
    a(a(), "db/contacts_indexes.sql", localb, b);
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }

  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    try
    {
      com.viber.provider.messages.c.a(paramSQLiteDatabase).a("PRAGMA synchronous = OFF");
      label16: com.viber.voip.e.a.e.b().b("DATA", "ViberContactsHelper init");
      return;
    }
    catch (SQLException localSQLException)
    {
      break label16;
    }
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    com.viber.provider.b localb = com.viber.provider.messages.c.a(paramSQLiteDatabase);
    if (paramInt1 < 49)
    {
      a(localb, paramInt1, paramInt2);
      onCreate(paramSQLiteDatabase);
      return;
    }
    c(localb);
    if (a(paramInt1, paramInt2, 51))
      a(a(), "db/contacts_migration_51.sql", localb, b);
    if (a(paramInt1, paramInt2, 64))
      a(a(), "db/contacts_migration_64.sql", localb, b);
    if (a(paramInt1, paramInt2, 74))
      a(a(), "db/contacts_migration_74.sql", localb, b);
    if (a(paramInt1, paramInt2, 79))
    {
      a(a(), "db/contacts_migration_79.sql", localb, b);
      localb.a("UPDATE vibernumbers SET member_id=canonized_number");
    }
    if (a(paramInt1, paramInt2, 88))
    {
      Cursor localCursor = localb.a("vibernumbers", new String[] { "_id" }, "member_id=?", new String[] { "null" }, null, null, null);
      if ((af.c(localCursor)) && (localCursor.getCount() > 5))
        d.ac.a.a(true);
      af.a(localCursor);
    }
    if (a(paramInt1, paramInt2, 92))
      a(localb);
    if (a(paramInt1, paramInt2, 117))
      a(a(), "db/contacts_migration_117.sql", localb, b);
    if (a(paramInt1, paramInt2, 139))
      a(a(), "db/contacts_migration_139.sql", localb, b);
    if (a(paramInt1, paramInt2, 151))
    {
      int i = a(paramSQLiteDatabase);
      d.p.v.a(i);
    }
    b(localb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.contacts.a.a
 * JD-Core Version:    0.6.2
 */