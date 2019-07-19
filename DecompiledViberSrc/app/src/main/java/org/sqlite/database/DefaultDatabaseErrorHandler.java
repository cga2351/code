package org.sqlite.database;

import java.io.File;
import org.sqlite.database.sqlite.SQLiteDatabase;

public final class DefaultDatabaseErrorHandler
  implements DatabaseErrorHandler
{
  private static final String TAG = "DefDbErrorHandler";

  private void deleteDatabaseFile(String paramString)
  {
    if ((paramString.equalsIgnoreCase(":memory:")) || (paramString.trim().length() == 0))
      return;
    try
    {
      SQLiteDatabase.deleteDatabase(new File(paramString));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: invokestatic 52	org/sqlite/database/sqlite/SQLiteDatabase:hasCodec	()Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aload_1
    //   8: invokevirtual 55	org/sqlite/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   11: ifne +12 -> 23
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 58	org/sqlite/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   19: invokespecial 60	org/sqlite/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   22: return
    //   23: aload_1
    //   24: invokevirtual 64	org/sqlite/database/sqlite/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   27: astore 11
    //   29: aload 11
    //   31: astore_3
    //   32: aload_1
    //   33: invokevirtual 67	org/sqlite/database/sqlite/SQLiteDatabase:close	()V
    //   36: aload_3
    //   37: ifnull +44 -> 81
    //   40: aload_3
    //   41: invokeinterface 73 1 0
    //   46: astore 9
    //   48: aload 9
    //   50: invokeinterface 78 1 0
    //   55: ifeq -49 -> 6
    //   58: aload_0
    //   59: aload 9
    //   61: invokeinterface 82 1 0
    //   66: checkcast 84	android/util/Pair
    //   69: getfield 88	android/util/Pair:second	Ljava/lang/Object;
    //   72: checkcast 22	java/lang/String
    //   75: invokespecial 60	org/sqlite/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   78: goto -30 -> 48
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 58	org/sqlite/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   86: invokespecial 60	org/sqlite/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   89: return
    //   90: astore 10
    //   92: aconst_null
    //   93: astore 5
    //   95: aload 10
    //   97: astore 6
    //   99: aload 5
    //   101: ifnull +45 -> 146
    //   104: aload 5
    //   106: invokeinterface 73 1 0
    //   111: astore 7
    //   113: aload 7
    //   115: invokeinterface 78 1 0
    //   120: ifeq +34 -> 154
    //   123: aload_0
    //   124: aload 7
    //   126: invokeinterface 82 1 0
    //   131: checkcast 84	android/util/Pair
    //   134: getfield 88	android/util/Pair:second	Ljava/lang/Object;
    //   137: checkcast 22	java/lang/String
    //   140: invokespecial 60	org/sqlite/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   143: goto -30 -> 113
    //   146: aload_0
    //   147: aload_1
    //   148: invokevirtual 58	org/sqlite/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   151: invokespecial 60	org/sqlite/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   154: aload 6
    //   156: athrow
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_3
    //   160: goto -128 -> 32
    //   163: astore 8
    //   165: goto -129 -> 36
    //   168: astore 4
    //   170: aload_3
    //   171: astore 5
    //   173: aload 4
    //   175: astore 6
    //   177: goto -78 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   23	29	90	finally
    //   23	29	157	org/sqlite/database/sqlite/SQLiteException
    //   32	36	163	org/sqlite/database/sqlite/SQLiteException
    //   32	36	168	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.DefaultDatabaseErrorHandler
 * JD-Core Version:    0.6.2
 */