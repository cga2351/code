package com.yandex.metrica.impl.ob;

import android.database.Cursor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class fq
  implements fp
{
  private final String a;
  private final HashMap<String, List<String>> b;

  public fq(String paramString, HashMap<String, List<String>> paramHashMap)
  {
    this.a = paramString;
    this.b = paramHashMap;
  }

  boolean a(Cursor paramCursor, List<String> paramList)
  {
    List localList = Arrays.asList(paramCursor.getColumnNames());
    Collections.sort(localList);
    return paramList.equals(localList);
  }

  // ERROR //
  public boolean a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 20	com/yandex/metrica/impl/ob/fq:b	Ljava/util/HashMap;
    //   6: invokevirtual 54	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   9: invokeinterface 60 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: invokeinterface 66 1 0
    //   23: ifeq +100 -> 123
    //   26: aload 4
    //   28: invokeinterface 70 1 0
    //   33: checkcast 72	java/util/Map$Entry
    //   36: astore 5
    //   38: aload_1
    //   39: aload 5
    //   41: invokeinterface 75 1 0
    //   46: checkcast 77	java/lang/String
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 83	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 8
    //   60: aload 8
    //   62: astore 7
    //   64: aload 7
    //   66: ifnonnull +10 -> 76
    //   69: aload 7
    //   71: invokestatic 88	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload 5
    //   78: invokeinterface 75 1 0
    //   83: pop
    //   84: aload_0
    //   85: aload 7
    //   87: aload 5
    //   89: invokeinterface 91 1 0
    //   94: checkcast 41	java/util/List
    //   97: invokevirtual 93	com/yandex/metrica/impl/ob/fq:a	(Landroid/database/Cursor;Ljava/util/List;)Z
    //   100: istore 10
    //   102: iload_2
    //   103: iload 10
    //   105: iand
    //   106: istore_2
    //   107: aload 7
    //   109: invokestatic 88	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   112: goto -96 -> 16
    //   115: aload 7
    //   117: invokestatic 88	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   120: aload 6
    //   122: athrow
    //   123: iload_2
    //   124: ireturn
    //   125: astore 6
    //   127: goto -12 -> 115
    //   130: astore_3
    //   131: iconst_0
    //   132: ireturn
    //   133: astore 6
    //   135: aconst_null
    //   136: astore 7
    //   138: goto -23 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   76	102	125	finally
    //   2	16	130	java/lang/Exception
    //   16	38	130	java/lang/Exception
    //   69	74	130	java/lang/Exception
    //   107	112	130	java/lang/Exception
    //   115	123	130	java/lang/Exception
    //   38	60	133	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fq
 * JD-Core Version:    0.6.2
 */