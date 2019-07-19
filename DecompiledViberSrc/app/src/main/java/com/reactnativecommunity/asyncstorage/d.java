package com.reactnativecommunity.asyncstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

public class d extends SQLiteOpenHelper
{

  @Nullable
  private static d a;
  private Context b;

  @Nullable
  private SQLiteDatabase c;
  private long d = 6291456L;

  private d(Context paramContext)
  {
    super(paramContext, "RKStorage", null, 1);
    this.b = paramContext;
  }

  public static d a(Context paramContext)
  {
    if (a == null)
      a = new d(paramContext.getApplicationContext());
    return a;
  }

  private boolean e()
  {
    try
    {
      f();
      boolean bool = this.b.deleteDatabase("RKStorage");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void f()
  {
    try
    {
      if ((this.c != null) && (this.c.isOpen()))
      {
        this.c.close();
        this.c = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/reactnativecommunity/asyncstorage/d:c	Landroid/database/sqlite/SQLiteDatabase;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 49	com/reactnativecommunity/asyncstorage/d:c	Landroid/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 54	android/database/sqlite/SQLiteDatabase:isOpen	()Z
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
    //   41: invokespecial 63	com/reactnativecommunity/asyncstorage/d:e	()Z
    //   44: pop
    //   45: aload_0
    //   46: aload_0
    //   47: invokevirtual 67	com/reactnativecommunity/asyncstorage/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: putfield 49	com/reactnativecommunity/asyncstorage/d:c	Landroid/database/sqlite/SQLiteDatabase;
    //   53: aload_0
    //   54: getfield 49	com/reactnativecommunity/asyncstorage/d:c	Landroid/database/sqlite/SQLiteDatabase;
    //   57: ifnonnull +34 -> 91
    //   60: aload_2
    //   61: athrow
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_2
    //   68: ldc2_w 68
    //   71: invokestatic 75	java/lang/Thread:sleep	(J)V
    //   74: iinc 3 1
    //   77: goto -46 -> 31
    //   80: astore 6
    //   82: invokestatic 79	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   85: invokevirtual 82	java/lang/Thread:interrupt	()V
    //   88: goto -14 -> 74
    //   91: aload_0
    //   92: getfield 49	com/reactnativecommunity/asyncstorage/d:c	Landroid/database/sqlite/SQLiteDatabase;
    //   95: aload_0
    //   96: getfield 24	com/reactnativecommunity/asyncstorage/d:d	J
    //   99: invokevirtual 86	android/database/sqlite/SQLiteDatabase:setMaximumSize	(J)J
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

  public SQLiteDatabase b()
  {
    try
    {
      a();
      SQLiteDatabase localSQLiteDatabase = this.c;
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c()
    throws RuntimeException
  {
    try
    {
      d();
      f();
      FLog.d("ReactNative", "Cleaned RKStorage");
      return;
    }
    catch (Exception localException)
    {
      while (e())
        FLog.d("ReactNative", "Deleted Local Database RKStorage");
    }
    finally
    {
    }
    throw new RuntimeException("Clearing and deleting database RKStorage failed");
  }

  void d()
  {
    try
    {
      b().delete("catalystLocalStorage", null, null);
      return;
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
      e();
      onCreate(paramSQLiteDatabase);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.reactnativecommunity.asyncstorage.d
 * JD-Core Version:    0.6.2
 */