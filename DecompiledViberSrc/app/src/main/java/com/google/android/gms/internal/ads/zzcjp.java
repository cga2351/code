package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public final class zzcjp
{
  public static int zza(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    String[] arrayOfString1 = { "total" };
    String[] arrayOfString2 = new String[1];
    Cursor localCursor;
    switch (paramInt)
    {
    default:
      localCursor = paramSQLiteDatabase.query("offline_signal_statistics", arrayOfString1, "statistic_name = ?", arrayOfString2, null, null, null);
      if (localCursor.getCount() > 0)
        localCursor.moveToNext();
      break;
    case 1:
    case 2:
    }
    for (int i = 0 + localCursor.getInt(localCursor.getColumnIndexOrThrow("total")); ; i = 0)
    {
      localCursor.close();
      return i;
      arrayOfString2[0] = "failed_requests";
      break;
      arrayOfString2[0] = "total_requests";
      break;
    }
  }

  public static ArrayList<zzwr.zzi.zza> zza(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = paramSQLiteDatabase.query("offline_signal_contents", new String[] { "serialized_proto_data" }, null, null, null, null, null);
    while (localCursor.moveToNext())
    {
      byte[] arrayOfByte = localCursor.getBlob(localCursor.getColumnIndexOrThrow("serialized_proto_data"));
      try
      {
        localArrayList.add(zzwr.zzi.zza.zzh(arrayOfByte));
      }
      catch (zzdoj localzzdoj)
      {
        zzaxa.zzen("Unable to deserialize proto from offline signals database:");
        zzaxa.zzen(localzzdoj.getMessage());
      }
    }
    localCursor.close();
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjp
 * JD-Core Version:    0.6.2
 */