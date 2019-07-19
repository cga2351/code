package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzx
{
  static void zza(zzas paramzzas, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramzzas == null)
      throw new IllegalArgumentException("Monitor must not be null");
    File localFile = new File(paramSQLiteDatabase.getPath());
    if (!localFile.setReadable(false, false))
      paramzzas.zzjj().zzby("Failed to turn off database read permission");
    if (!localFile.setWritable(false, false))
      paramzzas.zzjj().zzby("Failed to turn off database write permission");
    if (!localFile.setReadable(true, true))
      paramzzas.zzjj().zzby("Failed to turn on database read permission for owner");
    if (!localFile.setWritable(true, true))
      paramzzas.zzjj().zzby("Failed to turn on database write permission for owner");
  }

  static void zza(zzas paramzzas, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
    throws SQLiteException
  {
    if (paramzzas == null)
      throw new IllegalArgumentException("Monitor must not be null");
    if (!zza(paramzzas, paramSQLiteDatabase, paramString1))
      paramSQLiteDatabase.execSQL(paramString2);
    if (paramzzas == null)
      try
      {
        throw new IllegalArgumentException("Monitor must not be null");
      }
      catch (SQLiteException localSQLiteException)
      {
        paramzzas.zzjg().zzg("Failed to verify columns on table that was just created", paramString1);
        throw localSQLiteException;
      }
    Set localSet = zzb(paramSQLiteDatabase, paramString1);
    String[] arrayOfString = paramString3.split(",");
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfString[j];
      if (!localSet.remove(str))
        throw new SQLiteException(35 + String.valueOf(paramString1).length() + String.valueOf(str).length() + "Table " + paramString1 + " is missing required column: " + str);
    }
    while (true)
    {
      int k;
      if (k < paramArrayOfString.length)
      {
        if (!localSet.remove(paramArrayOfString[k]))
          paramSQLiteDatabase.execSQL(paramArrayOfString[(k + 1)]);
      }
      else
      {
        do
        {
          if (!localSet.isEmpty())
            paramzzas.zzjj().zze("Table has extra columns. table, columns", paramString1, TextUtils.join(", ", localSet));
          return;
          j++;
          break;
        }
        while (paramArrayOfString == null);
        k = 0;
        continue;
      }
      k += 2;
    }
  }

  // ERROR //
  private static boolean zza(zzas paramzzas, SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +13 -> 16
    //   6: new 8	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 10
    //   12: invokespecial 14	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_1
    //   17: ldc 130
    //   19: iconst_1
    //   20: anewarray 75	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 132
    //   27: aastore
    //   28: ldc 134
    //   30: iconst_1
    //   31: anewarray 75	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_2
    //   37: aastore
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 138	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 7
    //   46: aload 7
    //   48: astore 6
    //   50: aload 6
    //   52: invokeinterface 143 1 0
    //   57: istore 8
    //   59: aload 6
    //   61: ifnull +10 -> 71
    //   64: aload 6
    //   66: invokeinterface 147 1 0
    //   71: iload 8
    //   73: ireturn
    //   74: astore 5
    //   76: aconst_null
    //   77: astore 6
    //   79: aload_0
    //   80: invokevirtual 33	com/google/android/gms/measurement/internal/zzas:zzjj	()Lcom/google/android/gms/measurement/internal/zzau;
    //   83: ldc 149
    //   85: aload_2
    //   86: aload 5
    //   88: invokevirtual 128	com/google/android/gms/measurement/internal/zzau:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   91: aload 6
    //   93: ifnull +10 -> 103
    //   96: aload 6
    //   98: invokeinterface 147 1 0
    //   103: iconst_0
    //   104: ireturn
    //   105: astore 4
    //   107: aload_3
    //   108: ifnull +9 -> 117
    //   111: aload_3
    //   112: invokeinterface 147 1 0
    //   117: aload 4
    //   119: athrow
    //   120: astore 4
    //   122: aload 6
    //   124: astore_3
    //   125: goto -18 -> 107
    //   128: astore 5
    //   130: goto -51 -> 79
    //
    // Exception table:
    //   from	to	target	type
    //   16	46	74	android/database/sqlite/SQLiteException
    //   16	46	105	finally
    //   50	59	120	finally
    //   79	91	120	finally
    //   50	59	128	android/database/sqlite/SQLiteException
  }

  private static Set<String> zzb(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    HashSet localHashSet = new HashSet();
    Cursor localCursor = paramSQLiteDatabase.rawQuery(22 + String.valueOf(paramString).length() + "SELECT * FROM " + paramString + " LIMIT 0", null);
    try
    {
      Collections.addAll(localHashSet, localCursor.getColumnNames());
      return localHashSet;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzx
 * JD-Core Version:    0.6.2
 */