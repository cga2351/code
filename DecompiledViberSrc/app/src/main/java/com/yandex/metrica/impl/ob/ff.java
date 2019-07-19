package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.s.a;
import com.yandex.metrica.impl.t;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

public final class ff
{
  public static final Boolean a = Boolean.FALSE;
  public static final int b = YandexMetrica.getLibraryApiLevel();
  static final SparseArray<q> c;
  static final SparseArray<q> d;
  private static final HashMap<String, List<String>> e;

  static
  {
    SparseArray localSparseArray1 = new SparseArray();
    c = localSparseArray1;
    localSparseArray1.put(6, new y((byte)0));
    c.put(7, new ac((byte)0));
    c.put(14, new r((byte)0));
    c.put(29, new s((byte)0));
    c.put(37, new t((byte)0));
    c.put(39, new u((byte)0));
    c.put(45, new v((byte)0));
    c.put(47, new w((byte)0));
    c.put(50, new x((byte)0));
    c.put(60, new z((byte)0));
    c.put(66, new aa((byte)0));
    c.put(67, new ab((byte)0));
    SparseArray localSparseArray2 = new SparseArray();
    d = localSparseArray2;
    localSparseArray2.put(12, new i((byte)0));
    d.put(29, new j((byte)0));
    d.put(47, new k((byte)0));
    d.put(50, new l((byte)0));
    d.put(55, new m((byte)0));
    d.put(60, new n((byte)0));
    d.put(63, new o((byte)0));
    d.put(67, new p((byte)0));
    HashMap localHashMap = new HashMap();
    e = localHashMap;
    localHashMap.put("reports", af.a);
    e.put("sessions", ag.a);
    e.put("preferences", ae.a);
    e.put("binary_data", b.a);
  }

  public static fo a()
  {
    return new fo("main", new e(), new f(), c, new fq("main", e));
  }

  static List<String> a(String[] paramArrayOfString)
  {
    TreeSet localTreeSet = new TreeSet();
    Collections.addAll(localTreeSet, paramArrayOfString);
    return Collections.unmodifiableList(new ArrayList(localTreeSet));
  }

  public static fo b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("preferences", ae.a);
    localHashMap.put("binary_data", b.a);
    localHashMap.put("startup", ah.a);
    localHashMap.put("l_dat", a.a);
    localHashMap.put("lbs_dat", a.a);
    return new fo("metrica.db", new g(), new h(), d, new fq("metrica.db", localHashMap));
  }

  public static fo c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("preferences", ae.a);
    return new fo("client storage", new c((byte)0), new d((byte)0), new SparseArray(), new fq("metrica.db", localHashMap));
  }

  public static abstract interface a
  {
    public static final List<String> a = ff.a(new String[] { "incremental_id", "timestamp", "data" });

    public static abstract interface a
    {
      public static final String a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s (incremental_id INTEGER NOT NULL,timestamp INTEGER, data TEXT)", new Object[] { "lbs_dat" });
      public static final String b = String.format(Locale.US, "DROP TABLE IF EXISTS %s", new Object[] { "lbs_dat" });
    }

    public static abstract interface b
    {
      public static final String a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s (incremental_id INTEGER NOT NULL,timestamp INTEGER, data TEXT)", new Object[] { "l_dat" });
      public static final String b = String.format(Locale.US, "DROP TABLE IF EXISTS %s", new Object[] { "l_dat" });
    }
  }

  private static class aa extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      Locale localLocale1 = Locale.US;
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = "reports";
      arrayOfObject1[1] = "encrypting_mode";
      arrayOfObject1[2] = Integer.valueOf(pb.a.a());
      paramSQLiteDatabase.execSQL(String.format(localLocale1, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT %d", arrayOfObject1));
      Locale localLocale2 = Locale.US;
      Object[] arrayOfObject2 = new Object[5];
      arrayOfObject2[0] = "reports";
      arrayOfObject2[1] = "encrypting_mode";
      arrayOfObject2[2] = Integer.valueOf(pb.b.a());
      arrayOfObject2[3] = "type";
      arrayOfObject2[4] = Integer.valueOf(s.a.p.a());
      paramSQLiteDatabase.execSQL(String.format(localLocale2, "UPDATE %s SET %s = %d where %s=%d", arrayOfObject2));
      paramSQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN profile_id TEXT ");
    }
  }

  private static class ab extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = "reports";
      arrayOfObject[1] = "first_occurrence_status";
      arrayOfObject[2] = Integer.valueOf(t.a.d);
      paramSQLiteDatabase.execSQL(String.format(localLocale, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT %d", arrayOfObject));
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
    }
  }

  private static class ac extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ALTER TABLE sessions");
      localStringBuilder.append(" ADD COLUMN report_request_parameters");
      localStringBuilder.append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }

  static abstract interface ad
  {
    public static final List<String> a = ff.a(new String[] { "key", "value", "type" });
  }

  public static final class ae
    implements ff.ad
  {
  }

  public static final class af
  {
    public static final List<String> a = ff.a(new String[] { "id", "number", "name", "value", "type", "time", "session_id", "wifi_network_info", "cell_info", "location_info", "error_environment", "user_info", "session_type", "app_environment", "app_environment_revision", "truncated", "connection_type", "cellular_connection_type", "custom_type", "wifi_access_point", "encrypting_mode", "profile_id", "first_occurrence_status" });
    static final String b = "CREATE TABLE IF NOT EXISTS reports (id INTEGER PRIMARY KEY,name TEXT,value TEXT,number INTEGER,type INTEGER,time INTEGER,session_id TEXT,wifi_network_info TEXT DEFAULT '',cell_info TEXT DEFAULT '',location_info TEXT DEFAULT '',error_environment TEXT,user_info TEXT,session_type INTEGER DEFAULT " + ek.a.a() + ",app_environment TEXT DEFAULT '{}',app_environment_revision INTEGER DEFAULT 0,truncated INTEGER DEFAULT 0,connection_type INTEGER DEFAULT 2,cellular_connection_type TEXT,custom_type INTEGER DEFAULT 0, wifi_access_point TEXT, encrypting_mode INTEGER DEFAULT " + pb.a.a() + ", profile_id TEXT, first_occurrence_status INTEGER DEFAULT " + t.a.d + " )";
  }

  public static final class ag
  {
    public static final List<String> a = ff.a(new String[] { "id", "start_time", "network_info", "report_request_parameters", "server_time_offset", "type", "obtained_before_first_sync" });
    static final String b = "CREATE TABLE IF NOT EXISTS sessions (id INTEGER,start_time INTEGER,network_info TEXT,report_request_parameters TEXT,server_time_offset INTEGER,type INTEGER DEFAULT " + ek.a.a() + ",obtained_before_first_sync INTEGER DEFAULT 0 )";
    public static final String c = String.format(localLocale, "(select count(%s.%s) from %s where %s.%s = %s.%s) = 0 and %s NOT IN (%s)", arrayOfObject);

    static
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[9];
      arrayOfObject[0] = "reports";
      arrayOfObject[1] = "id";
      arrayOfObject[2] = "reports";
      arrayOfObject[3] = "reports";
      arrayOfObject[4] = "session_id";
      arrayOfObject[5] = "sessions";
      arrayOfObject[6] = "id";
      arrayOfObject[7] = "id";
      arrayOfObject[8] = nw.a(2);
    }
  }

  public static final class ah
    implements ff.ad
  {
  }

  public static final class b
  {
    static final List<String> a = ff.a(new String[] { "data_key", "value" });
  }

  private static class c extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
    }
  }

  private static class d extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
    }
  }

  static class e extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL(ff.af.b);
      paramSQLiteDatabase.execSQL(ff.ag.b);
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
    }
  }

  static class f extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS reports");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sessions");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
    }
  }

  static class g extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS startup (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
      paramSQLiteDatabase.execSQL(ff.a.b.a);
      paramSQLiteDatabase.execSQL(ff.a.a.a);
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
    }
  }

  static class h extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_id_info");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS api_level_info");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS startup");
      paramSQLiteDatabase.execSQL(ff.a.b.b);
      paramSQLiteDatabase.execSQL(ff.a.a.b);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS permissions");
    }
  }

  private static class i extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS api_level_info (API_LEVEL INT )");
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("API_LEVEL", Integer.valueOf(YandexMetrica.getLibraryApiLevel()));
      paramSQLiteDatabase.insert("api_level_info", "API_LEVEL", localContentValues);
    }
  }

  private static class j extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS api_level_info");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_id_info");
    }
  }

  private static class k extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS startup (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
    }
  }

  private static class l extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS GeoLocationInfo");
    }
  }

  private static final class m extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS permissions (name TEXT PRIMARY KEY,granted INTEGER)");
    }
  }

  private static class n extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      paramSQLiteDatabase.execSQL(ff.a.b.a);
    }
  }

  private static class o extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      paramSQLiteDatabase.execSQL(ff.a.a.a);
    }
  }

  private static class p extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
    }
  }

  static abstract class q
  {
    protected abstract void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException;
  }

  private static class r extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      Cursor localCursor = null;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("CREATE TABLE IF NOT EXISTS sessions_BACKUP (");
      localStringBuilder1.append("id INTEGER,");
      localStringBuilder1.append("start_time INTEGER,");
      localStringBuilder1.append("connection_type INTEGER,");
      localStringBuilder1.append("network_type TEXT,");
      localStringBuilder1.append("country_code INTEGER,");
      localStringBuilder1.append("operator_id INTEGER,");
      localStringBuilder1.append("lac INTEGER,");
      localStringBuilder1.append("report_request_parameters TEXT );");
      paramSQLiteDatabase.execSQL(localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("id,");
      localStringBuilder2.append("start_time,");
      localStringBuilder2.append("connection_type,");
      localStringBuilder2.append("network_type,");
      localStringBuilder2.append("country_code,");
      localStringBuilder2.append("operator_id,");
      localStringBuilder2.append("lac,");
      localStringBuilder2.append("report_request_parameters");
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("INSERT INTO sessions_BACKUP");
      localStringBuilder3.append(" SELECT ").append(localStringBuilder2);
      localStringBuilder3.append(" FROM sessions;");
      paramSQLiteDatabase.execSQL(localStringBuilder3.toString());
      paramSQLiteDatabase.execSQL("DROP TABLE sessions;");
      paramSQLiteDatabase.execSQL(ff.ag.b);
      while (true)
      {
        ContentValues localContentValues1;
        ArrayList localArrayList;
        ContentValues localContentValues2;
        try
        {
          localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM sessions_BACKUP", null);
          if (!localCursor.moveToNext())
            break;
          localContentValues1 = new ContentValues();
          DatabaseUtils.cursorRowToContentValues(localCursor, localContentValues1);
          localArrayList = new ArrayList();
          localArrayList.add("id");
          localArrayList.add("start_time");
          localArrayList.add("report_request_parameters");
          localContentValues2 = new ContentValues(localContentValues1);
          Iterator localIterator1 = localContentValues1.valueSet().iterator();
          if (localIterator1.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator1.next();
            if (localArrayList.contains(localEntry.getKey()))
              continue;
            localContentValues2.remove((String)localEntry.getKey());
            continue;
          }
        }
        finally
        {
          bw.a(localCursor);
        }
        Iterator localIterator2 = localArrayList.iterator();
        while (localIterator2.hasNext())
          localContentValues1.remove((String)localIterator2.next());
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("conn_type", localContentValues1.getAsInteger("connection_type"));
        localJSONObject.putOpt("net_type", localContentValues1.get("network_type"));
        localJSONObject.putOpt("operator_id", localContentValues1.get("operator_id"));
        localJSONObject.putOpt("lac", localContentValues1.get("lac"));
        localJSONObject.putOpt("country_code", localContentValues1.get("country_code"));
        localContentValues2.put("network_info", localJSONObject.toString());
        paramSQLiteDatabase.insertOrThrow("sessions", null, localContentValues2);
      }
      bw.a(localCursor);
      paramSQLiteDatabase.execSQL("DROP TABLE sessions_BACKUP;");
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("ALTER TABLE reports");
      localStringBuilder4.append(" ADD COLUMN wifi_network_info");
      localStringBuilder4.append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(localStringBuilder4.toString());
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("ALTER TABLE reports");
      localStringBuilder5.append(" ADD COLUMN cell_info");
      localStringBuilder5.append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(localStringBuilder5.toString());
      StringBuilder localStringBuilder6 = new StringBuilder();
      localStringBuilder6.append("ALTER TABLE reports");
      localStringBuilder6.append(" ADD COLUMN location_info");
      localStringBuilder6.append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(localStringBuilder6.toString());
    }
  }

  private static class s extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("ALTER TABLE reports");
      localStringBuilder1.append(" ADD COLUMN environment");
      localStringBuilder1.append(" TEXT ");
      paramSQLiteDatabase.execSQL(localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("ALTER TABLE reports");
      localStringBuilder2.append(" ADD COLUMN user_info");
      localStringBuilder2.append(" TEXT ");
      paramSQLiteDatabase.execSQL(localStringBuilder2.toString());
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("ALTER TABLE reports");
      localStringBuilder3.append(" ADD COLUMN session_type");
      localStringBuilder3.append(" INTEGER DEFAULT ").append(ek.a.a());
      paramSQLiteDatabase.execSQL(localStringBuilder3.toString());
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("UPDATE reports");
      localStringBuilder4.append(" SET session_type = ");
      localStringBuilder4.append(ek.b.a());
      localStringBuilder4.append(" WHERE session_id");
      localStringBuilder4.append(" = -2");
      paramSQLiteDatabase.execSQL(localStringBuilder4.toString());
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("ALTER TABLE sessions");
      localStringBuilder5.append(" ADD COLUMN server_time_offset");
      localStringBuilder5.append(" INTEGER ");
      paramSQLiteDatabase.execSQL(localStringBuilder5.toString());
      StringBuilder localStringBuilder6 = new StringBuilder();
      localStringBuilder6.append("ALTER TABLE sessions");
      localStringBuilder6.append(" ADD COLUMN type");
      localStringBuilder6.append(" INTEGER DEFAULT ").append(ek.a.a());
      paramSQLiteDatabase.execSQL(localStringBuilder6.toString());
      StringBuilder localStringBuilder7 = new StringBuilder();
      localStringBuilder7.append("UPDATE sessions");
      localStringBuilder7.append(" SET type = ");
      localStringBuilder7.append(ek.b.a());
      localStringBuilder7.append(" WHERE id");
      localStringBuilder7.append(" = -2");
      paramSQLiteDatabase.execSQL(localStringBuilder7.toString());
    }
  }

  private static class t extends ff.q
  {
    private static final String a = "CREATE TABLE IF NOT EXISTS reports (id INTEGER PRIMARY KEY,name TEXT,value TEXT,number INTEGER,type INTEGER,time INTEGER,session_id TEXT,wifi_network_info TEXT DEFAULT '',cell_info TEXT DEFAULT '',location_info TEXT DEFAULT '',error_environment TEXT,user_info TEXT,session_type INTEGER DEFAULT " + ek.a.a() + ",app_environment TEXT DEFAULT '{}',app_environment_revision INTEGER DEFAULT 0 )";

    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      Cursor localCursor = null;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("ALTER TABLE reports");
      localStringBuilder1.append(" ADD COLUMN app_environment");
      localStringBuilder1.append(" TEXT DEFAULT '{}'");
      paramSQLiteDatabase.execSQL(localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("ALTER TABLE reports");
      localStringBuilder2.append(" ADD COLUMN app_environment_revision");
      localStringBuilder2.append(" INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL(localStringBuilder2.toString());
      paramSQLiteDatabase.execSQL("ALTER TABLE reports RENAME TO reports_backup");
      paramSQLiteDatabase.execSQL(a);
      try
      {
        localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM reports_backup", null);
        while (localCursor.moveToNext())
        {
          ContentValues localContentValues = new ContentValues();
          DatabaseUtils.cursorRowToContentValues(localCursor, localContentValues);
          String str = localContentValues.getAsString("environment");
          localContentValues.remove("environment");
          localContentValues.put("error_environment", str);
          paramSQLiteDatabase.insert("reports", null, localContentValues);
        }
      }
      finally
      {
        bw.a(localCursor);
      }
      bw.a(localCursor);
      paramSQLiteDatabase.execSQL("DROP TABLE reports_backup");
    }
  }

  private static class u extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ALTER TABLE reports");
      localStringBuilder.append(" ADD COLUMN truncated");
      localStringBuilder.append(" INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }

  private static class v extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("ALTER TABLE reports");
      localStringBuilder1.append(" ADD COLUMN connection_type");
      localStringBuilder1.append(" INTEGER DEFAULT 2");
      paramSQLiteDatabase.execSQL(localStringBuilder1.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("ALTER TABLE reports");
      localStringBuilder2.append(" ADD COLUMN cellular_connection_type");
      localStringBuilder2.append(" TEXT ");
      paramSQLiteDatabase.execSQL(localStringBuilder2.toString());
    }
  }

  private static class w extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ALTER TABLE reports");
      localStringBuilder.append(" ADD COLUMN custom_type");
      localStringBuilder.append(" INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }

  private static class x extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ALTER TABLE reports");
      localStringBuilder.append(" ADD COLUMN wifi_access_point");
      localStringBuilder.append(" TEXT ");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }

  private static class y extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ALTER TABLE sessions");
      localStringBuilder.append(" ADD COLUMN wifi_network_info");
      localStringBuilder.append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }

  private static class z extends ff.q
  {
    protected void a(SQLiteDatabase paramSQLiteDatabase)
      throws SQLException, JSONException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ALTER TABLE sessions");
      localStringBuilder.append(" ADD COLUMN obtained_before_first_sync");
      localStringBuilder.append(" INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ff
 * JD-Core Version:    0.6.2
 */