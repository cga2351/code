package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class zzciz extends SQLiteOpenHelper
{
  public zzciz(Context paramContext)
  {
    super(paramContext, "OfflineUpload.db", null, 1);
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE offline_signal_contents (timestamp INTEGER PRIMARY_KEY, serialized_proto_data BLOB)");
    paramSQLiteDatabase.execSQL("CREATE TABLE offline_signal_statistics (statistic_name TEXT PRIMARY_KEY, total INTEGER)");
    ContentValues localContentValues1 = new ContentValues();
    localContentValues1.put("statistic_name", "failed_requests");
    localContentValues1.put("total", Integer.valueOf(0));
    paramSQLiteDatabase.insert("offline_signal_statistics", null, localContentValues1);
    ContentValues localContentValues2 = new ContentValues();
    localContentValues2.put("statistic_name", "total_requests");
    localContentValues2.put("total", Integer.valueOf(0));
    paramSQLiteDatabase.insert("offline_signal_statistics", null, localContentValues2);
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_contents");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_statistics");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzciz
 * JD-Core Version:    0.6.2
 */