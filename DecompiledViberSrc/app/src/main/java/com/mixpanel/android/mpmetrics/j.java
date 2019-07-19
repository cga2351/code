package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.mixpanel.android.b.f;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class j
{
  private static final Map<Context, j> a = new HashMap();
  private static final String b = "CREATE TABLE " + b.a.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "data" + " STRING NOT NULL, " + "created_at" + " INTEGER NOT NULL, " + "automatic_data" + " INTEGER DEFAULT 0, " + "token" + " STRING NOT NULL DEFAULT '')";
  private static final String c = "CREATE TABLE " + b.b.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "data" + " STRING NOT NULL, " + "created_at" + " INTEGER NOT NULL, " + "automatic_data" + " INTEGER DEFAULT 0, " + "token" + " STRING NOT NULL DEFAULT '')";
  private static final String d = "CREATE INDEX IF NOT EXISTS time_idx ON " + b.a.a() + " (" + "created_at" + ");";
  private static final String e = "CREATE INDEX IF NOT EXISTS time_idx ON " + b.b.a() + " (" + "created_at" + ");";
  private final a f;

  public j(Context paramContext)
  {
    this(paramContext, "mixpanel");
  }

  public j(Context paramContext, String paramString)
  {
    this.f = new a(paramContext, paramString);
  }

  public static j a(Context paramContext)
  {
    synchronized (a)
    {
      Context localContext = paramContext.getApplicationContext();
      if (!a.containsKey(localContext))
      {
        localj = new j(localContext);
        a.put(localContext, localj);
        return localj;
      }
      j localj = (j)a.get(localContext);
    }
  }

  private void b(b paramb, String paramString)
  {
    String str = paramb.a();
    try
    {
      this.f.getWritableDatabase().delete(str, "automatic_data = 1 AND token = '" + paramString + "'", null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      f.e("MixpanelAPI.Database", "Could not clean automatic Mixpanel records from " + str + ". Re-initializing database.", localSQLiteException);
      this.f.a();
      return;
    }
    finally
    {
      this.f.close();
    }
  }

  // ERROR //
  public int a(JSONObject paramJSONObject, String paramString, b paramb, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 150	com/mixpanel/android/mpmetrics/j:c	()Z
    //   7: ifne +13 -> 20
    //   10: ldc 134
    //   12: ldc 152
    //   14: invokestatic 155	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: bipush 254
    //   19: ireturn
    //   20: aload_3
    //   21: invokevirtual 40	com/mixpanel/android/mpmetrics/j$b:a	()Ljava/lang/String;
    //   24: astore 6
    //   26: aload_0
    //   27: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   30: invokevirtual 119	com/mixpanel/android/mpmetrics/j$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: astore 10
    //   35: new 157	android/content/ContentValues
    //   38: dup
    //   39: invokespecial 158	android/content/ContentValues:<init>	()V
    //   42: astore 11
    //   44: aload 11
    //   46: ldc 44
    //   48: aload_1
    //   49: invokevirtual 161	org/json/JSONObject:toString	()Ljava/lang/String;
    //   52: invokevirtual 163	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload 11
    //   57: ldc 48
    //   59: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   62: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   65: invokevirtual 178	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   68: aload 11
    //   70: ldc 52
    //   72: iload 4
    //   74: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   77: invokevirtual 186	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   80: aload 11
    //   82: ldc 56
    //   84: aload_2
    //   85: invokevirtual 163	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 10
    //   90: aload 6
    //   92: aconst_null
    //   93: aload 11
    //   95: invokevirtual 190	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   98: pop2
    //   99: aload 10
    //   101: new 25	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   108: ldc 192
    //   110: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 6
    //   115: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 194
    //   120: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_2
    //   124: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 123
    //   129: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: aconst_null
    //   136: invokevirtual 198	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   139: astore 14
    //   141: aload 14
    //   143: astore 9
    //   145: aload 9
    //   147: invokeinterface 203 1 0
    //   152: pop
    //   153: aload 9
    //   155: iconst_0
    //   156: invokeinterface 207 2 0
    //   161: istore 16
    //   163: aload 9
    //   165: ifnull +10 -> 175
    //   168: aload 9
    //   170: invokeinterface 208 1 0
    //   175: aload_0
    //   176: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   179: invokevirtual 132	com/mixpanel/android/mpmetrics/j$a:close	()V
    //   182: iload 16
    //   184: ireturn
    //   185: astore 8
    //   187: aconst_null
    //   188: astore 9
    //   190: ldc 134
    //   192: new 25	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   199: ldc 210
    //   201: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 6
    //   206: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 138
    //   211: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload 8
    //   219: invokestatic 143	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload 9
    //   224: ifnull +76 -> 300
    //   227: aload 9
    //   229: invokeinterface 208 1 0
    //   234: aload_0
    //   235: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   238: invokevirtual 145	com/mixpanel/android/mpmetrics/j$a:a	()V
    //   241: aload 5
    //   243: ifnull +10 -> 253
    //   246: aload 5
    //   248: invokeinterface 208 1 0
    //   253: aload_0
    //   254: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   257: invokevirtual 132	com/mixpanel/android/mpmetrics/j$a:close	()V
    //   260: iconst_m1
    //   261: ireturn
    //   262: astore 7
    //   264: aload 5
    //   266: ifnull +10 -> 276
    //   269: aload 5
    //   271: invokeinterface 208 1 0
    //   276: aload_0
    //   277: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   280: invokevirtual 132	com/mixpanel/android/mpmetrics/j$a:close	()V
    //   283: aload 7
    //   285: athrow
    //   286: astore 7
    //   288: aload 9
    //   290: astore 5
    //   292: goto -28 -> 264
    //   295: astore 8
    //   297: goto -107 -> 190
    //   300: aload 9
    //   302: astore 5
    //   304: goto -70 -> 234
    //
    // Exception table:
    //   from	to	target	type
    //   26	141	185	android/database/sqlite/SQLiteException
    //   26	141	262	finally
    //   234	241	262	finally
    //   145	163	286	finally
    //   190	222	286	finally
    //   227	234	286	finally
    //   145	163	295	android/database/sqlite/SQLiteException
  }

  public void a()
  {
    this.f.a();
  }

  public void a(long paramLong, b paramb)
  {
    String str = paramb.a();
    try
    {
      this.f.getWritableDatabase().delete(str, "created_at <= " + paramLong, null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      f.e("MixpanelAPI.Database", "Could not clean timed-out Mixpanel records from " + str + ". Re-initializing database.", localSQLiteException);
      this.f.a();
      return;
    }
    finally
    {
      this.f.close();
    }
  }

  public void a(b paramb, String paramString)
  {
    String str = paramb.a();
    try
    {
      this.f.getWritableDatabase().delete(str, "token = '" + paramString + "'", null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      f.e("MixpanelAPI.Database", "Could not clean timed-out Mixpanel records from " + str + ". Re-initializing database.", localSQLiteException);
      this.f.a();
      return;
    }
    finally
    {
      this.f.close();
    }
  }

  public void a(String paramString)
  {
    try
    {
      b(b.a, paramString);
      b(b.b, paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString1, b paramb, String paramString2, boolean paramBoolean)
  {
    String str = paramb.a();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
      StringBuffer localStringBuffer = new StringBuffer("_id <= " + paramString1 + " AND " + "token" + " = '" + paramString2 + "'");
      if (!paramBoolean)
        localStringBuffer.append(" AND automatic_data=0");
      localSQLiteDatabase.delete(str, localStringBuffer.toString(), null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      f.e("MixpanelAPI.Database", "Could not clean sent Mixpanel records from " + str + ". Re-initializing database.", localSQLiteException);
      this.f.a();
      return;
    }
    finally
    {
      this.f.close();
    }
  }

  // ERROR //
  public String[] a(b paramb, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokevirtual 40	com/mixpanel/android/mpmetrics/j$b:a	()Ljava/lang/String;
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   13: invokevirtual 248	com/mixpanel/android/mpmetrics/j$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 6
    //   18: new 226	java/lang/StringBuffer
    //   21: dup
    //   22: new 25	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   29: ldc 250
    //   31: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 5
    //   36: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 252
    //   41: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 56
    //   46: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 232
    //   51: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 254
    //   60: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 234	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   69: astore 7
    //   71: new 226	java/lang/StringBuffer
    //   74: dup
    //   75: new 25	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   82: ldc 192
    //   84: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 5
    //   89: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 252
    //   94: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 56
    //   99: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 232
    //   104: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_2
    //   108: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 254
    //   113: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 234	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   122: astore 8
    //   124: iload_3
    //   125: ifne +21 -> 146
    //   128: aload 7
    //   130: ldc_w 256
    //   133: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: aload 8
    //   139: ldc_w 258
    //   142: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   145: pop
    //   146: aload 7
    //   148: ldc_w 260
    //   151: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   154: pop
    //   155: aload 6
    //   157: aload 7
    //   159: invokevirtual 240	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   162: aconst_null
    //   163: invokevirtual 198	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   166: astore 20
    //   168: aload 20
    //   170: astore 10
    //   172: aload 6
    //   174: aload 8
    //   176: invokevirtual 240	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   179: aconst_null
    //   180: invokevirtual 198	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   183: astore 21
    //   185: aload 21
    //   187: astore 13
    //   189: aload 13
    //   191: invokeinterface 203 1 0
    //   196: pop
    //   197: aload 13
    //   199: iconst_0
    //   200: invokeinterface 207 2 0
    //   205: invokestatic 265	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   208: astore 23
    //   210: aload 23
    //   212: astore 12
    //   214: new 267	org/json/JSONArray
    //   217: dup
    //   218: invokespecial 268	org/json/JSONArray:<init>	()V
    //   221: astore 24
    //   223: aconst_null
    //   224: astore 25
    //   226: aload 10
    //   228: invokeinterface 271 1 0
    //   233: ifeq +73 -> 306
    //   236: aload 10
    //   238: invokeinterface 274 1 0
    //   243: ifeq +26 -> 269
    //   246: aload 10
    //   248: aload 10
    //   250: ldc_w 276
    //   253: invokeinterface 280 2 0
    //   258: invokeinterface 283 2 0
    //   263: astore 30
    //   265: aload 30
    //   267: astore 25
    //   269: aload 24
    //   271: new 160	org/json/JSONObject
    //   274: dup
    //   275: aload 10
    //   277: aload 10
    //   279: ldc 44
    //   281: invokeinterface 280 2 0
    //   286: invokeinterface 283 2 0
    //   291: invokespecial 284	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   294: invokevirtual 287	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   297: pop
    //   298: goto -72 -> 226
    //   301: astore 28
    //   303: goto -77 -> 226
    //   306: aload 24
    //   308: invokevirtual 291	org/json/JSONArray:length	()I
    //   311: ifle +278 -> 589
    //   314: aload 24
    //   316: invokevirtual 292	org/json/JSONArray:toString	()Ljava/lang/String;
    //   319: astore 27
    //   321: aload 27
    //   323: astore 26
    //   325: aload_0
    //   326: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   329: invokevirtual 132	com/mixpanel/android/mpmetrics/j$a:close	()V
    //   332: aload 10
    //   334: ifnull +10 -> 344
    //   337: aload 10
    //   339: invokeinterface 208 1 0
    //   344: aload 13
    //   346: ifnull +232 -> 578
    //   349: aload 13
    //   351: invokeinterface 208 1 0
    //   356: aload 26
    //   358: astore 15
    //   360: aload 25
    //   362: astore 14
    //   364: aconst_null
    //   365: astore 16
    //   367: aload 14
    //   369: ifnull +32 -> 401
    //   372: aconst_null
    //   373: astore 16
    //   375: aload 15
    //   377: ifnull +24 -> 401
    //   380: iconst_3
    //   381: anewarray 262	java/lang/String
    //   384: dup
    //   385: iconst_0
    //   386: aload 14
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: aload 15
    //   393: aastore
    //   394: dup
    //   395: iconst_2
    //   396: aload 12
    //   398: aastore
    //   399: astore 16
    //   401: aload 16
    //   403: areturn
    //   404: astore 11
    //   406: aconst_null
    //   407: astore 12
    //   409: aconst_null
    //   410: astore 13
    //   412: aconst_null
    //   413: astore 10
    //   415: ldc 134
    //   417: new 25	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 294
    //   427: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 5
    //   432: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc_w 296
    //   438: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: aload 11
    //   446: invokestatic 143	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   449: aload_0
    //   450: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   453: invokevirtual 132	com/mixpanel/android/mpmetrics/j$a:close	()V
    //   456: aload 10
    //   458: ifnull +10 -> 468
    //   461: aload 10
    //   463: invokeinterface 208 1 0
    //   468: aload 13
    //   470: ifnull +99 -> 569
    //   473: aload 13
    //   475: invokeinterface 208 1 0
    //   480: aconst_null
    //   481: astore 14
    //   483: aconst_null
    //   484: astore 15
    //   486: goto -122 -> 364
    //   489: astore 9
    //   491: aconst_null
    //   492: astore 10
    //   494: aload_0
    //   495: getfield 89	com/mixpanel/android/mpmetrics/j:f	Lcom/mixpanel/android/mpmetrics/j$a;
    //   498: invokevirtual 132	com/mixpanel/android/mpmetrics/j$a:close	()V
    //   501: aload 10
    //   503: ifnull +10 -> 513
    //   506: aload 10
    //   508: invokeinterface 208 1 0
    //   513: aload 4
    //   515: ifnull +10 -> 525
    //   518: aload 4
    //   520: invokeinterface 208 1 0
    //   525: aload 9
    //   527: athrow
    //   528: astore 9
    //   530: aconst_null
    //   531: astore 4
    //   533: goto -39 -> 494
    //   536: astore 9
    //   538: aload 13
    //   540: astore 4
    //   542: goto -48 -> 494
    //   545: astore 11
    //   547: aconst_null
    //   548: astore 12
    //   550: aconst_null
    //   551: astore 13
    //   553: goto -138 -> 415
    //   556: astore 11
    //   558: aconst_null
    //   559: astore 12
    //   561: goto -146 -> 415
    //   564: astore 11
    //   566: goto -151 -> 415
    //   569: aconst_null
    //   570: astore 14
    //   572: aconst_null
    //   573: astore 15
    //   575: goto -211 -> 364
    //   578: aload 26
    //   580: astore 15
    //   582: aload 25
    //   584: astore 14
    //   586: goto -222 -> 364
    //   589: aconst_null
    //   590: astore 26
    //   592: goto -267 -> 325
    //
    // Exception table:
    //   from	to	target	type
    //   269	298	301	org/json/JSONException
    //   18	124	404	android/database/sqlite/SQLiteException
    //   128	146	404	android/database/sqlite/SQLiteException
    //   146	168	404	android/database/sqlite/SQLiteException
    //   18	124	489	finally
    //   128	146	489	finally
    //   146	168	489	finally
    //   172	185	528	finally
    //   189	210	536	finally
    //   214	223	536	finally
    //   226	265	536	finally
    //   269	298	536	finally
    //   306	321	536	finally
    //   415	449	536	finally
    //   172	185	545	android/database/sqlite/SQLiteException
    //   189	210	556	android/database/sqlite/SQLiteException
    //   214	223	564	android/database/sqlite/SQLiteException
    //   226	265	564	android/database/sqlite/SQLiteException
    //   269	298	564	android/database/sqlite/SQLiteException
    //   306	321	564	android/database/sqlite/SQLiteException
  }

  public File b()
  {
    return a.a(this.f);
  }

  protected boolean c()
  {
    return this.f.b();
  }

  private static class a extends SQLiteOpenHelper
  {
    private final File a;
    private final i b;

    a(Context paramContext, String paramString)
    {
      super(paramString, null, 5);
      this.a = paramContext.getDatabasePath(paramString);
      this.b = i.a(paramContext);
    }

    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE " + j.b.a.a() + " ADD COLUMN " + "automatic_data" + " INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE " + j.b.b.a() + " ADD COLUMN " + "automatic_data" + " INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE " + j.b.a.a() + " ADD COLUMN " + "token" + " STRING NOT NULL DEFAULT ''");
      paramSQLiteDatabase.execSQL("ALTER TABLE " + j.b.b.a() + " ADD COLUMN " + "token" + " STRING NOT NULL DEFAULT ''");
      Cursor localCursor1 = paramSQLiteDatabase.rawQuery("SELECT * FROM " + j.b.a.a(), null);
      while (true)
      {
        if (localCursor1.moveToNext());
        try
        {
          String str2 = new JSONObject(localCursor1.getString(localCursor1.getColumnIndex("data"))).getJSONObject("properties").getString("token");
          int m = localCursor1.getInt(localCursor1.getColumnIndex("_id"));
          k = m;
          try
          {
            paramSQLiteDatabase.execSQL("UPDATE " + j.b.a.a() + " SET " + "token" + " = '" + str2 + "' WHERE _id = " + k);
          }
          catch (JSONException localJSONException4)
          {
          }
          paramSQLiteDatabase.delete(j.b.a.a(), "_id = " + k, null);
          continue;
          Cursor localCursor2 = paramSQLiteDatabase.rawQuery("SELECT * FROM " + j.b.b.a(), null);
          while (true)
          {
            if (localCursor2.moveToNext());
            try
            {
              String str1 = new JSONObject(localCursor2.getString(localCursor2.getColumnIndex("data"))).getString("$token");
              int j = localCursor2.getInt(localCursor2.getColumnIndex("_id"));
              i = j;
              try
              {
                paramSQLiteDatabase.execSQL("UPDATE " + j.b.b.a() + " SET " + "token" + " = '" + str1 + "' WHERE _id = " + i);
              }
              catch (JSONException localJSONException2)
              {
              }
              paramSQLiteDatabase.delete(j.b.b.a(), "_id = " + i, null);
              continue;
              return;
            }
            catch (JSONException localJSONException1)
            {
              while (true)
                int i = 0;
            }
          }
        }
        catch (JSONException localJSONException3)
        {
          while (true)
            int k = 0;
        }
      }
    }

    public void a()
    {
      close();
      this.a.delete();
    }

    public boolean b()
    {
      return (!this.a.exists()) || (Math.max(this.a.getUsableSpace(), this.b.d()) >= this.a.length());
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      f.a("MixpanelAPI.Database", "Creating a new Mixpanel events DB");
      paramSQLiteDatabase.execSQL(j.d());
      paramSQLiteDatabase.execSQL(j.e());
      paramSQLiteDatabase.execSQL(j.f());
      paramSQLiteDatabase.execSQL(j.g());
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      f.a("MixpanelAPI.Database", "Upgrading app, replacing Mixpanel events DB");
      if (paramInt2 == 5)
      {
        a(paramSQLiteDatabase);
        return;
      }
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + j.b.a.a());
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + j.b.b.a());
      paramSQLiteDatabase.execSQL(j.d());
      paramSQLiteDatabase.execSQL(j.e());
      paramSQLiteDatabase.execSQL(j.f());
      paramSQLiteDatabase.execSQL(j.g());
    }
  }

  public static enum b
  {
    private final String c;

    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
    }

    private b(String paramString)
    {
      this.c = paramString;
    }

    public String a()
    {
      return this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.j
 * JD-Core Version:    0.6.2
 */