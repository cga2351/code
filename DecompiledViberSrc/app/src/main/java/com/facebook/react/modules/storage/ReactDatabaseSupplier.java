package com.facebook.react.modules.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

public class ReactDatabaseSupplier extends SQLiteOpenHelper
{
  public static final String DATABASE_NAME = "RKStorage";
  private static final int DATABASE_VERSION = 1;
  static final String KEY_COLUMN = "key";
  private static final int SLEEP_TIME_MS = 30;
  static final String TABLE_CATALYST = "catalystLocalStorage";
  static final String VALUE_COLUMN = "value";
  static final String VERSION_TABLE_CREATE = "CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)";

  @Nullable
  private static ReactDatabaseSupplier sReactDatabaseSupplierInstance;
  private Context mContext;

  @Nullable
  private SQLiteDatabase mDb;
  private long mMaximumDatabaseSize = 6291456L;

  private ReactDatabaseSupplier(Context paramContext)
  {
    super(paramContext, "RKStorage", null, 1);
    this.mContext = paramContext;
  }

  private void closeDatabase()
  {
    try
    {
      if ((this.mDb != null) && (this.mDb.isOpen()))
      {
        this.mDb.close();
        this.mDb = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private boolean deleteDatabase()
  {
    try
    {
      closeDatabase();
      boolean bool = this.mContext.deleteDatabase("RKStorage");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void deleteInstance()
  {
    sReactDatabaseSupplierInstance = null;
  }

  public static ReactDatabaseSupplier getInstance(Context paramContext)
  {
    if (sReactDatabaseSupplierInstance == null)
      sReactDatabaseSupplierInstance = new ReactDatabaseSupplier(paramContext.getApplicationContext());
    return sReactDatabaseSupplierInstance;
  }

  void clear()
  {
    try
    {
      get().delete("catalystLocalStorage", null, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void clearAndCloseDatabase()
    throws RuntimeException
  {
    try
    {
      clear();
      closeDatabase();
      FLog.d("ReactNative", "Cleaned RKStorage");
      return;
    }
    catch (Exception localException)
    {
      while (deleteDatabase())
        FLog.d("ReactNative", "Deleted Local Database RKStorage");
    }
    finally
    {
    }
    throw new RuntimeException("Clearing and deleting database RKStorage failed");
  }

  // ERROR //
  boolean ensureDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 49	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 55	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   16: istore 8
    //   18: iload 8
    //   20: ifeq +7 -> 27
    //   23: aload_0
    //   24: monitorexit
    //   25: iconst_1
    //   26: ireturn
    //   27: aconst_null
    //   28: astore_2
    //   29: iconst_0
    //   30: istore_3
    //   31: iload_3
    //   32: iconst_2
    //   33: if_icmpge +20 -> 53
    //   36: iload_3
    //   37: ifle +8 -> 45
    //   40: aload_0
    //   41: invokespecial 105	com/facebook/react/modules/storage/ReactDatabaseSupplier:deleteDatabase	()Z
    //   44: pop
    //   45: aload_0
    //   46: aload_0
    //   47: invokevirtual 120	com/facebook/react/modules/storage/ReactDatabaseSupplier:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: putfield 49	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   53: aload_0
    //   54: getfield 49	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   57: ifnonnull +34 -> 91
    //   60: aload_2
    //   61: athrow
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_2
    //   68: ldc2_w 121
    //   71: invokestatic 128	java/lang/Thread:sleep	(J)V
    //   74: iinc 3 1
    //   77: goto -46 -> 31
    //   80: astore 6
    //   82: invokestatic 132	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   85: invokevirtual 135	java/lang/Thread:interrupt	()V
    //   88: goto -14 -> 74
    //   91: aload_0
    //   92: getfield 49	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   95: aload_0
    //   96: getfield 43	com/facebook/react/modules/storage/ReactDatabaseSupplier:mMaximumDatabaseSize	J
    //   99: invokevirtual 139	android/database/sqlite/SQLiteDatabase:setMaximumSize	(J)J
    //   102: pop2
    //   103: goto -80 -> 23
    //
    // Exception table:
    //   from	to	target	type
    //   2	18	62	finally
    //   40	45	62	finally
    //   45	53	62	finally
    //   53	62	62	finally
    //   68	74	62	finally
    //   82	88	62	finally
    //   91	103	62	finally
    //   40	45	67	android/database/sqlite/SQLiteException
    //   45	53	67	android/database/sqlite/SQLiteException
    //   68	74	80	java/lang/InterruptedException
  }

  public SQLiteDatabase get()
  {
    try
    {
      ensureDatabase();
      SQLiteDatabase localSQLiteDatabase = this.mDb;
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      deleteDatabase();
      onCreate(paramSQLiteDatabase);
    }
  }

  public void setMaximumSize(long paramLong)
  {
    try
    {
      this.mMaximumDatabaseSize = paramLong;
      if (this.mDb != null)
        this.mDb.setMaximumSize(this.mMaximumDatabaseSize);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.storage.ReactDatabaseSupplier
 * JD-Core Version:    0.6.2
 */