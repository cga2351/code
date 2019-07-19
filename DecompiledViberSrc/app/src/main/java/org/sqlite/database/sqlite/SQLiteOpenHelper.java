package org.sqlite.database.sqlite;

import android.content.Context;
import android.database.Cursor;
import java.lang.reflect.Method;
import org.sqlite.database.DatabaseErrorHandler;

public abstract class SQLiteOpenHelper
{
  private static final boolean DEBUG_STRICT_READONLY = false;
  private static final String TAG = "SQLiteOpenHelper";
  protected boolean disableAutoVacuum = false;
  protected boolean enableJournalSizeLimit = true;
  protected boolean executeVacuumAfterUpgrade = false;
  private final Context mContext;
  private SQLiteDatabase mDatabase;
  private boolean mEnableWriteAheadLogging;
  private final DatabaseErrorHandler mErrorHandler;
  private final SQLiteDatabase.CursorFactory mFactory;
  private boolean mIsInitializing;
  private final String mName;
  private final int mNewVersion;
  protected int memoryMapIoSize = 2097152;
  protected boolean useMemoryMapIo = false;

  static
  {
    int i = 0;
    String[] arrayOfString = { "icuBinder", "sqliteX" };
    try
    {
      Class localClass = Class.forName("com.viber.common.jni.NativeLibraryLoader");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("loadLibrary", arrayOfClass);
      int k = arrayOfString.length;
      for (int m = 0; m < k; m++)
      {
        String str = arrayOfString[m];
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = Boolean.valueOf(false);
        localMethod.invoke(null, arrayOfObject);
      }
    }
    catch (Throwable localThrowable)
    {
      int j = arrayOfString.length;
      while (i < j)
      {
        System.loadLibrary(arrayOfString[i]);
        i++;
      }
    }
  }

  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null);
  }

  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramInt < 1)
      throw new IllegalArgumentException("Version must be >= 1, was " + paramInt);
    this.mContext = paramContext;
    this.mName = paramString;
    this.mFactory = paramCursorFactory;
    this.mNewVersion = paramInt;
    this.mErrorHandler = paramDatabaseErrorHandler;
  }

  // ERROR //
  private SQLiteDatabase getDatabaseLocked(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 136	org/sqlite/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   16: ifne +25 -> 41
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   24: aload_0
    //   25: getfield 138	org/sqlite/database/sqlite/SQLiteOpenHelper:mIsInitializing	Z
    //   28: ifeq +32 -> 60
    //   31: new 140	java/lang/IllegalStateException
    //   34: dup
    //   35: ldc 142
    //   37: invokespecial 143	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: iload_1
    //   42: ifeq +13 -> 55
    //   45: aload_0
    //   46: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   49: invokevirtual 146	org/sqlite/database/sqlite/SQLiteDatabase:isReadOnly	()Z
    //   52: ifne -28 -> 24
    //   55: aload_0
    //   56: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   59: areturn
    //   60: aload_0
    //   61: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   64: astore_3
    //   65: aload_0
    //   66: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   69: ifnull +13 -> 82
    //   72: aload_0
    //   73: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   76: invokevirtual 136	org/sqlite/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   79: ifne +217 -> 296
    //   82: iload_2
    //   83: istore 4
    //   85: aload_0
    //   86: iconst_1
    //   87: putfield 138	org/sqlite/database/sqlite/SQLiteOpenHelper:mIsInitializing	Z
    //   90: aload_3
    //   91: ifnull +211 -> 302
    //   94: iload_1
    //   95: ifeq +522 -> 617
    //   98: aload_3
    //   99: invokevirtual 146	org/sqlite/database/sqlite/SQLiteDatabase:isReadOnly	()Z
    //   102: ifeq +515 -> 617
    //   105: aload_3
    //   106: invokevirtual 149	org/sqlite/database/sqlite/SQLiteDatabase:reopenReadWrite	()V
    //   109: aload_3
    //   110: astore 6
    //   112: aload_0
    //   113: aload 6
    //   115: invokevirtual 153	org/sqlite/database/sqlite/SQLiteOpenHelper:onConfigure	(Lorg/sqlite/database/sqlite/SQLiteDatabase;)V
    //   118: aload_0
    //   119: getfield 87	org/sqlite/database/sqlite/SQLiteOpenHelper:useMemoryMapIo	Z
    //   122: istore 9
    //   124: iload 9
    //   126: ifeq +32 -> 158
    //   129: aload 6
    //   131: new 96	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   138: ldc 155
    //   140: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: getfield 90	org/sqlite/database/sqlite/SQLiteOpenHelper:memoryMapIoSize	I
    //   147: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aconst_null
    //   154: invokevirtual 159	org/sqlite/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   157: pop
    //   158: aload 6
    //   160: invokevirtual 163	org/sqlite/database/sqlite/SQLiteDatabase:getVersion	()I
    //   163: istore 10
    //   165: iload 10
    //   167: aload_0
    //   168: getfield 120	org/sqlite/database/sqlite/SQLiteOpenHelper:mNewVersion	I
    //   171: if_icmpeq +308 -> 479
    //   174: aload 6
    //   176: invokevirtual 146	org/sqlite/database/sqlite/SQLiteDatabase:isReadOnly	()Z
    //   179: ifeq +223 -> 402
    //   182: new 128	org/sqlite/database/sqlite/SQLiteException
    //   185: dup
    //   186: new 96	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   193: ldc 165
    //   195: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 6
    //   200: invokevirtual 163	org/sqlite/database/sqlite/SQLiteDatabase:getVersion	()I
    //   203: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: ldc 167
    //   208: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_0
    //   212: getfield 120	org/sqlite/database/sqlite/SQLiteOpenHelper:mNewVersion	I
    //   215: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc 169
    //   220: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: getfield 116	org/sqlite/database/sqlite/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   227: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokespecial 170	org/sqlite/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   236: athrow
    //   237: astore 5
    //   239: aload_0
    //   240: iconst_0
    //   241: putfield 138	org/sqlite/database/sqlite/SQLiteOpenHelper:mIsInitializing	Z
    //   244: aload 6
    //   246: ifnull +17 -> 263
    //   249: aload 6
    //   251: aload_0
    //   252: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   255: if_acmpeq +8 -> 263
    //   258: aload 6
    //   260: invokevirtual 173	org/sqlite/database/sqlite/SQLiteDatabase:close	()V
    //   263: iload 4
    //   265: ifeq +28 -> 293
    //   268: aload_0
    //   269: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   272: ifnull +21 -> 293
    //   275: aload_0
    //   276: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   279: invokevirtual 136	org/sqlite/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   282: ifeq +11 -> 293
    //   285: aload_0
    //   286: aload_0
    //   287: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   290: invokevirtual 176	org/sqlite/database/sqlite/SQLiteOpenHelper:onPostOpen	(Lorg/sqlite/database/sqlite/SQLiteDatabase;)V
    //   293: aload 5
    //   295: athrow
    //   296: iconst_0
    //   297: istore 4
    //   299: goto -214 -> 85
    //   302: aload_0
    //   303: getfield 116	org/sqlite/database/sqlite/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   306: ifnonnull +20 -> 326
    //   309: aconst_null
    //   310: aload_0
    //   311: getfield 92	org/sqlite/database/sqlite/SQLiteOpenHelper:enableJournalSizeLimit	Z
    //   314: invokestatic 180	org/sqlite/database/sqlite/SQLiteDatabase:create	(Lorg/sqlite/database/sqlite/SQLiteDatabase$CursorFactory;Z)Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   317: astore 19
    //   319: aload 19
    //   321: astore 6
    //   323: goto -211 -> 112
    //   326: aload_0
    //   327: getfield 116	org/sqlite/database/sqlite/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   330: aload_0
    //   331: getfield 118	org/sqlite/database/sqlite/SQLiteOpenHelper:mFactory	Lorg/sqlite/database/sqlite/SQLiteDatabase$CursorFactory;
    //   334: aload_0
    //   335: getfield 122	org/sqlite/database/sqlite/SQLiteOpenHelper:mErrorHandler	Lorg/sqlite/database/DatabaseErrorHandler;
    //   338: aload_0
    //   339: getfield 92	org/sqlite/database/sqlite/SQLiteOpenHelper:enableJournalSizeLimit	Z
    //   342: invokestatic 184	org/sqlite/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Lorg/sqlite/database/sqlite/SQLiteDatabase$CursorFactory;Lorg/sqlite/database/DatabaseErrorHandler;Z)Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   345: astore 18
    //   347: aload 18
    //   349: astore 6
    //   351: goto -239 -> 112
    //   354: astore 7
    //   356: iload_1
    //   357: ifeq +6 -> 363
    //   360: aload 7
    //   362: athrow
    //   363: aload_0
    //   364: getfield 114	org/sqlite/database/sqlite/SQLiteOpenHelper:mContext	Landroid/content/Context;
    //   367: aload_0
    //   368: getfield 116	org/sqlite/database/sqlite/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   371: invokevirtual 190	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   374: invokevirtual 195	java/io/File:getPath	()Ljava/lang/String;
    //   377: aload_0
    //   378: getfield 118	org/sqlite/database/sqlite/SQLiteOpenHelper:mFactory	Lorg/sqlite/database/sqlite/SQLiteDatabase$CursorFactory;
    //   381: iconst_1
    //   382: aload_0
    //   383: getfield 122	org/sqlite/database/sqlite/SQLiteOpenHelper:mErrorHandler	Lorg/sqlite/database/DatabaseErrorHandler;
    //   386: aload_0
    //   387: getfield 92	org/sqlite/database/sqlite/SQLiteOpenHelper:enableJournalSizeLimit	Z
    //   390: invokestatic 199	org/sqlite/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Lorg/sqlite/database/sqlite/SQLiteDatabase$CursorFactory;ILorg/sqlite/database/DatabaseErrorHandler;Z)Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   393: astore 8
    //   395: aload 8
    //   397: astore 6
    //   399: goto -287 -> 112
    //   402: aload 6
    //   404: invokevirtual 202	org/sqlite/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   407: iload 10
    //   409: ifne +147 -> 556
    //   412: aload_0
    //   413: aload 6
    //   415: invokevirtual 205	org/sqlite/database/sqlite/SQLiteOpenHelper:onCreate	(Lorg/sqlite/database/sqlite/SQLiteDatabase;)V
    //   418: iconst_0
    //   419: istore_2
    //   420: aload 6
    //   422: aload_0
    //   423: getfield 120	org/sqlite/database/sqlite/SQLiteOpenHelper:mNewVersion	I
    //   426: invokevirtual 209	org/sqlite/database/sqlite/SQLiteDatabase:setVersion	(I)V
    //   429: aload 6
    //   431: invokevirtual 212	org/sqlite/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   434: aload 6
    //   436: invokevirtual 215	org/sqlite/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   439: iload_2
    //   440: ifeq +39 -> 479
    //   443: aload_0
    //   444: getfield 83	org/sqlite/database/sqlite/SQLiteOpenHelper:executeVacuumAfterUpgrade	Z
    //   447: istore 12
    //   449: iload 12
    //   451: ifeq +28 -> 479
    //   454: aload_0
    //   455: getfield 85	org/sqlite/database/sqlite/SQLiteOpenHelper:disableAutoVacuum	Z
    //   458: ifeq +10 -> 468
    //   461: aload 6
    //   463: ldc 217
    //   465: invokevirtual 220	org/sqlite/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   468: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   471: pop2
    //   472: aload 6
    //   474: ldc 226
    //   476: invokevirtual 220	org/sqlite/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   479: aload_0
    //   480: aload 6
    //   482: invokevirtual 229	org/sqlite/database/sqlite/SQLiteOpenHelper:onOpen	(Lorg/sqlite/database/sqlite/SQLiteDatabase;)V
    //   485: aload 6
    //   487: invokevirtual 146	org/sqlite/database/sqlite/SQLiteDatabase:isReadOnly	()Z
    //   490: ifeq +3 -> 493
    //   493: aload_0
    //   494: aload 6
    //   496: putfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   499: aload_0
    //   500: iconst_0
    //   501: putfield 138	org/sqlite/database/sqlite/SQLiteOpenHelper:mIsInitializing	Z
    //   504: aload 6
    //   506: ifnull +17 -> 523
    //   509: aload 6
    //   511: aload_0
    //   512: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   515: if_acmpeq +8 -> 523
    //   518: aload 6
    //   520: invokevirtual 173	org/sqlite/database/sqlite/SQLiteDatabase:close	()V
    //   523: iload 4
    //   525: ifeq +28 -> 553
    //   528: aload_0
    //   529: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   532: ifnull +21 -> 553
    //   535: aload_0
    //   536: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   539: invokevirtual 136	org/sqlite/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   542: ifeq +11 -> 553
    //   545: aload_0
    //   546: aload_0
    //   547: getfield 130	org/sqlite/database/sqlite/SQLiteOpenHelper:mDatabase	Lorg/sqlite/database/sqlite/SQLiteDatabase;
    //   550: invokevirtual 176	org/sqlite/database/sqlite/SQLiteOpenHelper:onPostOpen	(Lorg/sqlite/database/sqlite/SQLiteDatabase;)V
    //   553: aload 6
    //   555: areturn
    //   556: iload 10
    //   558: aload_0
    //   559: getfield 120	org/sqlite/database/sqlite/SQLiteOpenHelper:mNewVersion	I
    //   562: if_icmple +20 -> 582
    //   565: aload_0
    //   566: aload 6
    //   568: iload 10
    //   570: aload_0
    //   571: getfield 120	org/sqlite/database/sqlite/SQLiteOpenHelper:mNewVersion	I
    //   574: invokevirtual 233	org/sqlite/database/sqlite/SQLiteOpenHelper:onDowngrade	(Lorg/sqlite/database/sqlite/SQLiteDatabase;II)V
    //   577: iconst_0
    //   578: istore_2
    //   579: goto -159 -> 420
    //   582: aload_0
    //   583: aload 6
    //   585: iload 10
    //   587: aload_0
    //   588: getfield 120	org/sqlite/database/sqlite/SQLiteOpenHelper:mNewVersion	I
    //   591: invokevirtual 236	org/sqlite/database/sqlite/SQLiteOpenHelper:onUpgrade	(Lorg/sqlite/database/sqlite/SQLiteDatabase;II)V
    //   594: goto -174 -> 420
    //   597: astore 11
    //   599: aload 6
    //   601: invokevirtual 215	org/sqlite/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   604: aload 11
    //   606: athrow
    //   607: astore 13
    //   609: goto -130 -> 479
    //   612: astore 16
    //   614: goto -456 -> 158
    //   617: aload_3
    //   618: astore 6
    //   620: goto -508 -> 112
    //   623: astore 5
    //   625: aload_3
    //   626: astore 6
    //   628: goto -389 -> 239
    //
    // Exception table:
    //   from	to	target	type
    //   112	124	237	finally
    //   129	158	237	finally
    //   158	237	237	finally
    //   402	407	237	finally
    //   434	439	237	finally
    //   443	449	237	finally
    //   454	468	237	finally
    //   468	479	237	finally
    //   479	493	237	finally
    //   493	499	237	finally
    //   599	607	237	finally
    //   326	347	354	org/sqlite/database/sqlite/SQLiteException
    //   412	418	597	finally
    //   420	434	597	finally
    //   556	577	597	finally
    //   582	594	597	finally
    //   454	468	607	java/lang/Exception
    //   468	479	607	java/lang/Exception
    //   129	158	612	java/lang/Exception
    //   85	90	623	finally
    //   98	109	623	finally
    //   302	319	623	finally
    //   326	347	623	finally
    //   360	363	623	finally
    //   363	395	623	finally
  }

  public void close()
  {
    try
    {
      if (this.mIsInitializing)
        throw new IllegalStateException("Closed during initialization");
    }
    finally
    {
    }
    if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
    {
      this.mDatabase.close();
      this.mDatabase = null;
    }
  }

  public String getDatabaseName()
  {
    return this.mName;
  }

  public String getPragmaVailue(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("PRAGMA " + paramString, null);
    String str = "";
    if ((localCursor != null) && (localCursor.moveToFirst()))
      do
      {
        str = str + localCursor.getString(0) + "; ";
        if (localCursor.getColumnCount() > 1)
          str = str + localCursor.getString(1) + "; ";
        if (localCursor.getColumnCount() > 2)
          str = str + localCursor.getString(2) + "; ";
      }
      while (localCursor.moveToNext());
    if (localCursor != null)
      localCursor.close();
    return str;
  }

  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = getDatabaseLocked(false);
      return localSQLiteDatabase2;
    }
    catch (SQLiteReadOnlyDatabaseException localSQLiteReadOnlyDatabaseException)
    {
      SQLiteDatabase localSQLiteDatabase1 = getDatabaseLocked(true);
      return localSQLiteDatabase1;
    }
    finally
    {
    }
  }

  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getDatabaseLocked(true);
      return localSQLiteDatabase;
    }
    finally
    {
    }
  }

  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    throw new SQLiteException("Can't downgrade database from version " + paramInt1 + " to " + paramInt2);
  }

  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  public void onPostOpen(SQLiteDatabase paramSQLiteDatabase)
  {
  }

  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);

  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    try
    {
      if (this.mEnableWriteAheadLogging != paramBoolean)
        if ((this.mDatabase != null) && (this.mDatabase.isOpen()) && (!this.mDatabase.isReadOnly()))
        {
          if (!paramBoolean)
            break label57;
          this.mDatabase.enableWriteAheadLogging();
        }
      while (true)
      {
        this.mEnableWriteAheadLogging = paramBoolean;
        return;
        label57: this.mDatabase.disableWriteAheadLogging();
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteOpenHelper
 * JD-Core Version:    0.6.2
 */