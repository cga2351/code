package a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.appboy.f.c;
import com.appboy.f.i;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;

public final class cr extends SQLiteOpenHelper
{
  private static final String a = c.a(cr.class);
  private static volatile Map<String, cr> b = new HashMap();
  private static final String[] c = { "ab_events", "ab_sessions", "sessions", "appboy_events" };

  private cr(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 3);
  }

  public static cr a(Context paramContext, String paramString1, String paramString2)
  {
    String str = b(paramContext, paramString1, paramString2);
    if (!b.containsKey(str));
    try
    {
      if (!b.containsKey(str))
      {
        cr localcr = new cr(paramContext, str);
        b.put(str, localcr);
        return localcr;
      }
      return (cr)b.get(str);
    }
    finally
    {
    }
  }

  public static void a(Context paramContext)
  {
    File localFile1 = paramContext.getDatabasePath(" ").getParentFile();
    if ((localFile1.exists()) && (localFile1.isDirectory()))
      for (File localFile2 : localFile1.listFiles(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.startsWith("appboy.db");
        }
      }))
      {
        c.a(a, "Deleting database file at: " + localFile2.getAbsolutePath());
        paramContext.deleteDatabase(localFile2.getName());
      }
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    for (String str : c)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
      c.b(a, "Dropped table with name: " + str);
    }
  }

  static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (i.c(paramString1))
      return "appboy.db";
    return "appboy.db" + i.a(paramContext, paramString1, paramString2);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    c.c(a, "Creating ab_events table");
    paramSQLiteDatabase.execSQL("CREATE TABLE ab_events (_id INTEGER PRIMARY KEY AUTOINCREMENT, session_id TEXT, user_id TEXT, event_type TEXT NOT NULL, event_data TEXT NOT NULL, event_guid TEXT NOT NULL, timestamp INTEGER NOT NULL);");
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    c.c(a, "Downgrading storage from version " + paramInt1 + " to " + paramInt2 + ". Dropping all current tables.");
    a(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }

  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    paramSQLiteDatabase.setForeignKeyConstraintsEnabled(true);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    c.c(a, "Upgrading storage from version " + paramInt1 + " to " + paramInt2 + ". Dropping all current tables.");
    a(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cr
 * JD-Core Version:    0.6.2
 */