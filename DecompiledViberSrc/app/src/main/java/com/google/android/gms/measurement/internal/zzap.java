package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

@VisibleForTesting
final class zzap extends SQLiteOpenHelper
{
  zzap(zzao paramzzao, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }

  public final SQLiteDatabase getWritableDatabase()
    throws SQLiteException
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
      return localSQLiteDatabase2;
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      throw localSQLiteDatabaseLockedException;
    }
    catch (SQLiteException localSQLiteException1)
    {
      this.zzalq.zzgt().zzjg().zzby("Opening the local database failed, dropping and recreating it");
      if (!this.zzalq.getContext().getDatabasePath("google_app_measurement_local.db").delete())
        this.zzalq.zzgt().zzjg().zzg("Failed to delete corrupted local db file", "google_app_measurement_local.db");
      try
      {
        SQLiteDatabase localSQLiteDatabase1 = super.getWritableDatabase();
        return localSQLiteDatabase1;
      }
      catch (SQLiteException localSQLiteException2)
      {
        this.zzalq.zzgt().zzjg().zzg("Failed to open local database. Events will bypass local storage", localSQLiteException2);
      }
    }
    return null;
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    zzx.zza(this.zzalq.zzgt(), paramSQLiteDatabase);
  }

  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }

  // ERROR //
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 85	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 15
    //   7: if_icmpge +32 -> 39
    //   10: aload_1
    //   11: ldc 87
    //   13: aconst_null
    //   14: invokevirtual 93	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   17: astore 4
    //   19: aload 4
    //   21: invokeinterface 98 1 0
    //   26: pop
    //   27: aload 4
    //   29: ifnull +10 -> 39
    //   32: aload 4
    //   34: invokeinterface 102 1 0
    //   39: aload_0
    //   40: getfield 11	com/google/android/gms/measurement/internal/zzap:zzalq	Lcom/google/android/gms/measurement/internal/zzao;
    //   43: invokevirtual 28	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   46: aload_1
    //   47: ldc 104
    //   49: ldc 106
    //   51: ldc 108
    //   53: aconst_null
    //   54: invokestatic 111	com/google/android/gms/measurement/internal/zzx:zza	(Lcom/google/android/gms/measurement/internal/zzas;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   57: return
    //   58: astore_3
    //   59: aload_2
    //   60: ifnull +9 -> 69
    //   63: aload_2
    //   64: invokeinterface 102 1 0
    //   69: aload_3
    //   70: athrow
    //   71: astore_3
    //   72: aload 4
    //   74: astore_2
    //   75: goto -16 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   10	19	58	finally
    //   19	27	71	finally
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzap
 * JD-Core Version:    0.6.2
 */