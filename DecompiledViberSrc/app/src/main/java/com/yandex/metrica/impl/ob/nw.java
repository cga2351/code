package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Build.VERSION;

public class nw
{
  // ERROR //
  public static long a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: ldc 8
    //   5: aload_1
    //   6: invokestatic 14	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9: invokevirtual 18	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   12: aconst_null
    //   13: invokevirtual 24	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 6
    //   18: aload 6
    //   20: invokeinterface 30 1 0
    //   25: ifeq +16 -> 41
    //   28: aload 6
    //   30: iconst_0
    //   31: invokeinterface 34 2 0
    //   36: lstore 7
    //   38: lload 7
    //   40: lstore_2
    //   41: aload 6
    //   43: invokestatic 39	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   46: lload_2
    //   47: lreturn
    //   48: astore 4
    //   50: aconst_null
    //   51: astore 5
    //   53: aload 5
    //   55: invokestatic 39	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   58: aload 4
    //   60: athrow
    //   61: astore 4
    //   63: aload 6
    //   65: astore 5
    //   67: goto -14 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   2	18	48	finally
    //   18	38	61	finally
  }

  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramInt; i++)
      localStringBuilder.append("?,");
    int j = localStringBuilder.length();
    localStringBuilder.replace(j - 1, j, "");
    return localStringBuilder.toString();
  }

  @SuppressLint({"ObsoleteSdkInt"})
  public static void a(Cursor paramCursor, ContentValues paramContentValues)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      b(paramCursor, paramContentValues);
      return;
    }
    DatabaseUtils.cursorRowToContentValues(paramCursor, paramContentValues);
  }

  @TargetApi(11)
  public static void b(Cursor paramCursor, ContentValues paramContentValues)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      switch (paramCursor.getType(j))
      {
      default:
        paramContentValues.put(arrayOfString[j], paramCursor.getString(j));
      case 4:
      case 2:
      case 1:
      case 0:
      case 3:
      }
      while (true)
      {
        j++;
        break;
        paramContentValues.put(arrayOfString[j], paramCursor.getBlob(j));
        continue;
        paramContentValues.put(arrayOfString[j], Double.valueOf(paramCursor.getDouble(j)));
        continue;
        paramContentValues.put(arrayOfString[j], Long.valueOf(paramCursor.getLong(j)));
        continue;
        paramContentValues.put(arrayOfString[j], paramCursor.getString(j));
        continue;
        paramContentValues.put(arrayOfString[j], paramCursor.getString(j));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.nw
 * JD-Core Version:    0.6.2
 */