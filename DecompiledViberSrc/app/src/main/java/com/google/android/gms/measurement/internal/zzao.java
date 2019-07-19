package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzao extends zzf
{
  private final zzap zzalo = new zzap(this, getContext(), "google_app_measurement_local.db");
  private boolean zzalp;

  zzao(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  @VisibleForTesting
  private final SQLiteDatabase getWritableDatabase()
    throws SQLiteException
  {
    if (this.zzalp)
      return null;
    SQLiteDatabase localSQLiteDatabase = this.zzalo.getWritableDatabase();
    if (localSQLiteDatabase == null)
    {
      this.zzalp = true;
      return null;
    }
    return localSQLiteDatabase;
  }

  private final boolean zza(int paramInt, byte[] paramArrayOfByte)
  {
    zzgg();
    zzaf();
    if (this.zzalp)
      return false;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(paramInt));
    localContentValues.put("entry", paramArrayOfByte);
    int i = 0;
    int j = 5;
    while (i < 5)
    {
      SQLiteDatabase localSQLiteDatabase = null;
      Cursor localCursor = null;
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        if (localSQLiteDatabase == null)
        {
          this.zzalp = true;
          if (localSQLiteDatabase != null)
            localSQLiteDatabase.close();
          return false;
        }
        localSQLiteDatabase.beginTransaction();
        long l2 = 0L;
        localCursor = localSQLiteDatabase.rawQuery("select count(1) from messages", null);
        if ((localCursor != null) && (localCursor.moveToFirst()))
          l2 = localCursor.getLong(0);
        if (l2 >= 100000L)
        {
          zzgt().zzjg().zzby("Data loss, local db full");
          long l3 = 1L + (100000L - l2);
          String[] arrayOfString = new String[1];
          arrayOfString[0] = Long.toString(l3);
          long l4 = localSQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", arrayOfString);
          if (l4 != l3)
            zzgt().zzjg().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l3 - l4));
        }
        localSQLiteDatabase.insertOrThrow("messages", null, localContentValues);
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        return true;
      }
      catch (SQLiteFullException localSQLiteFullException)
      {
        zzgt().zzjg().zzg("Error writing entry to local database", localSQLiteFullException);
        this.zzalp = true;
        if (localCursor != null)
          localCursor.close();
        if (localSQLiteDatabase != null)
          localSQLiteDatabase.close();
        i++;
      }
      catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
      {
        while (true)
        {
          long l1 = j;
          SystemClock.sleep(l1);
          j += 20;
          if (localCursor != null)
            localCursor.close();
          if (localSQLiteDatabase != null)
            localSQLiteDatabase.close();
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
        {
          if ((localSQLiteDatabase != null) && (localSQLiteDatabase.inTransaction()))
            localSQLiteDatabase.endTransaction();
          zzgt().zzjg().zzg("Error writing entry to local database", localSQLiteException);
          this.zzalp = true;
          if (localCursor != null)
            localCursor.close();
          if (localSQLiteDatabase != null)
            localSQLiteDatabase.close();
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
        if (localSQLiteDatabase != null)
          localSQLiteDatabase.close();
      }
    }
    zzgt().zzjj().zzby("Failed to write entry to local database");
    return false;
  }

  public final void resetAnalyticsData()
  {
    zzgg();
    zzaf();
    try
    {
      int i = 0 + getWritableDatabase().delete("messages", null, null);
      if (i > 0)
        zzgt().zzjo().zzg("Reset local analytics data. records", Integer.valueOf(i));
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzgt().zzjg().zzg("Error resetting local analytics data. error", localSQLiteException);
    }
  }

  public final boolean zza(zzag paramzzag)
  {
    Parcel localParcel = Parcel.obtain();
    paramzzag.writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    if (arrayOfByte.length > 131072)
    {
      zzgt().zzjj().zzby("Event is too long for local database. Sending event directly to service");
      return false;
    }
    return zza(0, arrayOfByte);
  }

  public final boolean zza(zzfu paramzzfu)
  {
    Parcel localParcel = Parcel.obtain();
    paramzzfu.writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    if (arrayOfByte.length > 131072)
    {
      zzgt().zzjj().zzby("User property too long for local database. Sending directly to service");
      return false;
    }
    return zza(1, arrayOfByte);
  }

  public final boolean zzc(zzo paramzzo)
  {
    zzgr();
    byte[] arrayOfByte = zzfx.zza(paramzzo);
    if (arrayOfByte.length > 131072)
    {
      zzgt().zzjj().zzby("Conditional user property too long for local database. Sending directly to service");
      return false;
    }
    return zza(2, arrayOfByte);
  }

  protected final boolean zzgy()
  {
    return false;
  }

  // ERROR //
  public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzr(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 49	com/google/android/gms/measurement/internal/zzcr:zzaf	()V
    //   4: aload_0
    //   5: invokevirtual 46	com/google/android/gms/measurement/internal/zzcr:zzgg	()V
    //   8: aload_0
    //   9: getfield 34	com/google/android/gms/measurement/internal/zzao:zzalp	Z
    //   12: ifeq +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 297	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 298	java/util/ArrayList:<init>	()V
    //   24: astore_2
    //   25: aload_0
    //   26: invokevirtual 20	com/google/android/gms/measurement/internal/zzcr:getContext	()Landroid/content/Context;
    //   29: ldc 22
    //   31: invokevirtual 304	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   34: invokevirtual 309	java/io/File:exists	()Z
    //   37: ifne +5 -> 42
    //   40: aload_2
    //   41: areturn
    //   42: iconst_5
    //   43: istore_3
    //   44: iconst_0
    //   45: istore 4
    //   47: iload 4
    //   49: iconst_5
    //   50: if_icmpge +749 -> 799
    //   53: aload_0
    //   54: invokespecial 71	com/google/android/gms/measurement/internal/zzao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   57: astore 17
    //   59: aload 17
    //   61: ifnonnull +20 -> 81
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield 34	com/google/android/gms/measurement/internal/zzao:zzalp	Z
    //   69: aload 17
    //   71: ifnull +8 -> 79
    //   74: aload 17
    //   76: invokevirtual 76	android/database/sqlite/SQLiteDatabase:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: aload 17
    //   83: invokevirtual 79	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   86: aload 17
    //   88: ldc 125
    //   90: iconst_3
    //   91: anewarray 117	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 311
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: ldc 55
    //   104: aastore
    //   105: dup
    //   106: iconst_2
    //   107: ldc 67
    //   109: aastore
    //   110: aconst_null
    //   111: aconst_null
    //   112: aconst_null
    //   113: aconst_null
    //   114: ldc_w 313
    //   117: bipush 100
    //   119: invokestatic 316	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   122: invokevirtual 320	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   125: astore 22
    //   127: aload 22
    //   129: astore 11
    //   131: ldc2_w 321
    //   134: lstore 23
    //   136: aload 11
    //   138: invokeinterface 325 1 0
    //   143: ifeq +573 -> 716
    //   146: aload 11
    //   148: iconst_0
    //   149: invokeinterface 95 2 0
    //   154: lstore 23
    //   156: aload 11
    //   158: iconst_1
    //   159: invokeinterface 329 2 0
    //   164: istore 30
    //   166: aload 11
    //   168: iconst_2
    //   169: invokeinterface 333 2 0
    //   174: astore 31
    //   176: iload 30
    //   178: ifne +285 -> 463
    //   181: invokestatic 187	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   184: astore 32
    //   186: aload 32
    //   188: aload 31
    //   190: iconst_0
    //   191: aload 31
    //   193: arraylength
    //   194: invokevirtual 337	android/os/Parcel:unmarshall	([BII)V
    //   197: aload 32
    //   199: iconst_0
    //   200: invokevirtual 341	android/os/Parcel:setDataPosition	(I)V
    //   203: getstatic 345	com/google/android/gms/measurement/internal/zzag:CREATOR	Landroid/os/Parcelable$Creator;
    //   206: aload 32
    //   208: invokeinterface 351 2 0
    //   213: checkcast 189	com/google/android/gms/measurement/internal/zzag
    //   216: astore 35
    //   218: aload 32
    //   220: invokevirtual 200	android/os/Parcel:recycle	()V
    //   223: aload 35
    //   225: ifnull -89 -> 136
    //   228: aload_2
    //   229: aload 35
    //   231: invokeinterface 357 2 0
    //   236: pop
    //   237: goto -101 -> 136
    //   240: astore 28
    //   242: aload 11
    //   244: astore 6
    //   246: aload 17
    //   248: astore 7
    //   250: aload 28
    //   252: astore 5
    //   254: aload_0
    //   255: invokevirtual 101	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   258: invokevirtual 107	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   261: ldc_w 359
    //   264: aload 5
    //   266: invokevirtual 157	com/google/android/gms/measurement/internal/zzau:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   269: aload_0
    //   270: iconst_1
    //   271: putfield 34	com/google/android/gms/measurement/internal/zzao:zzalp	Z
    //   274: aload 6
    //   276: ifnull +10 -> 286
    //   279: aload 6
    //   281: invokeinterface 151 1 0
    //   286: aload 7
    //   288: ifnull +652 -> 940
    //   291: aload 7
    //   293: invokevirtual 76	android/database/sqlite/SQLiteDatabase:close	()V
    //   296: iload_3
    //   297: istore 12
    //   299: iinc 4 1
    //   302: iload 12
    //   304: istore_3
    //   305: goto -258 -> 47
    //   308: astore 34
    //   310: aload_0
    //   311: invokevirtual 101	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   314: invokevirtual 107	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   317: ldc_w 361
    //   320: invokevirtual 115	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   323: aload 32
    //   325: invokevirtual 200	android/os/Parcel:recycle	()V
    //   328: goto -192 -> 136
    //   331: astore 27
    //   333: aload 17
    //   335: astore 10
    //   337: iload_3
    //   338: i2l
    //   339: lstore 14
    //   341: lload 14
    //   343: invokestatic 163	android/os/SystemClock:sleep	(J)V
    //   346: iload_3
    //   347: bipush 20
    //   349: iadd
    //   350: istore 12
    //   352: aload 11
    //   354: ifnull +10 -> 364
    //   357: aload 11
    //   359: invokeinterface 151 1 0
    //   364: aload 10
    //   366: ifnull -67 -> 299
    //   369: aload 10
    //   371: invokevirtual 76	android/database/sqlite/SQLiteDatabase:close	()V
    //   374: goto -75 -> 299
    //   377: astore 33
    //   379: aload 32
    //   381: invokevirtual 200	android/os/Parcel:recycle	()V
    //   384: aload 33
    //   386: athrow
    //   387: astore 26
    //   389: aload 17
    //   391: astore 10
    //   393: aload 26
    //   395: astore 16
    //   397: aload 10
    //   399: ifnull +16 -> 415
    //   402: aload 10
    //   404: invokevirtual 166	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   407: ifeq +8 -> 415
    //   410: aload 10
    //   412: invokevirtual 150	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   415: aload_0
    //   416: invokevirtual 101	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   419: invokevirtual 107	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   422: ldc_w 359
    //   425: aload 16
    //   427: invokevirtual 157	com/google/android/gms/measurement/internal/zzau:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   430: aload_0
    //   431: iconst_1
    //   432: putfield 34	com/google/android/gms/measurement/internal/zzao:zzalp	Z
    //   435: aload 11
    //   437: ifnull +10 -> 447
    //   440: aload 11
    //   442: invokeinterface 151 1 0
    //   447: aload 10
    //   449: ifnull +491 -> 940
    //   452: aload 10
    //   454: invokevirtual 76	android/database/sqlite/SQLiteDatabase:close	()V
    //   457: iload_3
    //   458: istore 12
    //   460: goto -161 -> 299
    //   463: iload 30
    //   465: iconst_1
    //   466: if_icmpne +133 -> 599
    //   469: invokestatic 187	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   472: astore 42
    //   474: aload 42
    //   476: aload 31
    //   478: iconst_0
    //   479: aload 31
    //   481: arraylength
    //   482: invokevirtual 337	android/os/Parcel:unmarshall	([BII)V
    //   485: aload 42
    //   487: iconst_0
    //   488: invokevirtual 341	android/os/Parcel:setDataPosition	(I)V
    //   491: getstatic 362	com/google/android/gms/measurement/internal/zzfu:CREATOR	Landroid/os/Parcelable$Creator;
    //   494: aload 42
    //   496: invokeinterface 351 2 0
    //   501: checkcast 208	com/google/android/gms/measurement/internal/zzfu
    //   504: astore 45
    //   506: aload 42
    //   508: invokevirtual 200	android/os/Parcel:recycle	()V
    //   511: aload 45
    //   513: ifnull -377 -> 136
    //   516: aload_2
    //   517: aload 45
    //   519: invokeinterface 357 2 0
    //   524: pop
    //   525: goto -389 -> 136
    //   528: astore 25
    //   530: aload 17
    //   532: astore 10
    //   534: aload 25
    //   536: astore 8
    //   538: aload 11
    //   540: ifnull +10 -> 550
    //   543: aload 11
    //   545: invokeinterface 151 1 0
    //   550: aload 10
    //   552: ifnull +8 -> 560
    //   555: aload 10
    //   557: invokevirtual 76	android/database/sqlite/SQLiteDatabase:close	()V
    //   560: aload 8
    //   562: athrow
    //   563: astore 44
    //   565: aload_0
    //   566: invokevirtual 101	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   569: invokevirtual 107	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   572: ldc_w 364
    //   575: invokevirtual 115	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   578: aload 42
    //   580: invokevirtual 200	android/os/Parcel:recycle	()V
    //   583: aconst_null
    //   584: astore 45
    //   586: goto -75 -> 511
    //   589: astore 43
    //   591: aload 42
    //   593: invokevirtual 200	android/os/Parcel:recycle	()V
    //   596: aload 43
    //   598: athrow
    //   599: iload 30
    //   601: iconst_2
    //   602: if_icmpne +98 -> 700
    //   605: invokestatic 187	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   608: astore 37
    //   610: aload 37
    //   612: aload 31
    //   614: iconst_0
    //   615: aload 31
    //   617: arraylength
    //   618: invokevirtual 337	android/os/Parcel:unmarshall	([BII)V
    //   621: aload 37
    //   623: iconst_0
    //   624: invokevirtual 341	android/os/Parcel:setDataPosition	(I)V
    //   627: getstatic 367	com/google/android/gms/measurement/internal/zzo:CREATOR	Landroid/os/Parcelable$Creator;
    //   630: aload 37
    //   632: invokeinterface 351 2 0
    //   637: checkcast 366	com/google/android/gms/measurement/internal/zzo
    //   640: astore 40
    //   642: aload 37
    //   644: invokevirtual 200	android/os/Parcel:recycle	()V
    //   647: aload 40
    //   649: ifnull -513 -> 136
    //   652: aload_2
    //   653: aload 40
    //   655: invokeinterface 357 2 0
    //   660: pop
    //   661: goto -525 -> 136
    //   664: astore 39
    //   666: aload_0
    //   667: invokevirtual 101	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   670: invokevirtual 107	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   673: ldc_w 364
    //   676: invokevirtual 115	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   679: aload 37
    //   681: invokevirtual 200	android/os/Parcel:recycle	()V
    //   684: aconst_null
    //   685: astore 40
    //   687: goto -40 -> 647
    //   690: astore 38
    //   692: aload 37
    //   694: invokevirtual 200	android/os/Parcel:recycle	()V
    //   697: aload 38
    //   699: athrow
    //   700: aload_0
    //   701: invokevirtual 101	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   704: invokevirtual 107	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   707: ldc_w 369
    //   710: invokevirtual 115	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   713: goto -577 -> 136
    //   716: iconst_1
    //   717: anewarray 117	java/lang/String
    //   720: astore 29
    //   722: aload 29
    //   724: iconst_0
    //   725: lload 23
    //   727: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   730: aastore
    //   731: aload 17
    //   733: ldc 125
    //   735: ldc_w 371
    //   738: aload 29
    //   740: invokevirtual 131	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   743: aload_2
    //   744: invokeinterface 375 1 0
    //   749: if_icmpge +16 -> 765
    //   752: aload_0
    //   753: invokevirtual 101	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   756: invokevirtual 107	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   759: ldc_w 377
    //   762: invokevirtual 115	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   765: aload 17
    //   767: invokevirtual 147	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   770: aload 17
    //   772: invokevirtual 150	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   775: aload 11
    //   777: ifnull +10 -> 787
    //   780: aload 11
    //   782: invokeinterface 151 1 0
    //   787: aload 17
    //   789: ifnull +8 -> 797
    //   792: aload 17
    //   794: invokevirtual 76	android/database/sqlite/SQLiteDatabase:close	()V
    //   797: aload_2
    //   798: areturn
    //   799: aload_0
    //   800: invokevirtual 101	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   803: invokevirtual 169	com/google/android/gms/measurement/internal/zzas:zzjj	()Lcom/google/android/gms/measurement/internal/zzau;
    //   806: ldc_w 379
    //   809: invokevirtual 115	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   812: aconst_null
    //   813: areturn
    //   814: astore 8
    //   816: aconst_null
    //   817: astore 10
    //   819: aconst_null
    //   820: astore 11
    //   822: goto -284 -> 538
    //   825: astore 21
    //   827: aload 17
    //   829: astore 10
    //   831: aload 21
    //   833: astore 8
    //   835: aconst_null
    //   836: astore 11
    //   838: goto -300 -> 538
    //   841: astore 8
    //   843: aload 6
    //   845: astore 9
    //   847: aload 7
    //   849: astore 10
    //   851: aload 9
    //   853: astore 11
    //   855: goto -317 -> 538
    //   858: astore 8
    //   860: goto -322 -> 538
    //   863: astore 16
    //   865: aconst_null
    //   866: astore 10
    //   868: aconst_null
    //   869: astore 11
    //   871: goto -474 -> 397
    //   874: astore 20
    //   876: aload 17
    //   878: astore 10
    //   880: aload 20
    //   882: astore 16
    //   884: aconst_null
    //   885: astore 11
    //   887: goto -490 -> 397
    //   890: astore 13
    //   892: aconst_null
    //   893: astore 10
    //   895: aconst_null
    //   896: astore 11
    //   898: goto -561 -> 337
    //   901: astore 19
    //   903: aload 17
    //   905: astore 10
    //   907: aconst_null
    //   908: astore 11
    //   910: goto -573 -> 337
    //   913: astore 5
    //   915: aconst_null
    //   916: astore 6
    //   918: aconst_null
    //   919: astore 7
    //   921: goto -667 -> 254
    //   924: astore 18
    //   926: aload 17
    //   928: astore 7
    //   930: aload 18
    //   932: astore 5
    //   934: aconst_null
    //   935: astore 6
    //   937: goto -683 -> 254
    //   940: iload_3
    //   941: istore 12
    //   943: goto -644 -> 299
    //
    // Exception table:
    //   from	to	target	type
    //   136	176	240	android/database/sqlite/SQLiteFullException
    //   181	186	240	android/database/sqlite/SQLiteFullException
    //   218	223	240	android/database/sqlite/SQLiteFullException
    //   228	237	240	android/database/sqlite/SQLiteFullException
    //   323	328	240	android/database/sqlite/SQLiteFullException
    //   379	387	240	android/database/sqlite/SQLiteFullException
    //   469	474	240	android/database/sqlite/SQLiteFullException
    //   506	511	240	android/database/sqlite/SQLiteFullException
    //   516	525	240	android/database/sqlite/SQLiteFullException
    //   578	583	240	android/database/sqlite/SQLiteFullException
    //   591	599	240	android/database/sqlite/SQLiteFullException
    //   605	610	240	android/database/sqlite/SQLiteFullException
    //   642	647	240	android/database/sqlite/SQLiteFullException
    //   652	661	240	android/database/sqlite/SQLiteFullException
    //   679	684	240	android/database/sqlite/SQLiteFullException
    //   692	700	240	android/database/sqlite/SQLiteFullException
    //   700	713	240	android/database/sqlite/SQLiteFullException
    //   716	765	240	android/database/sqlite/SQLiteFullException
    //   765	775	240	android/database/sqlite/SQLiteFullException
    //   186	218	308	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   136	176	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   181	186	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   218	223	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   228	237	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   323	328	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   379	387	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   469	474	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   506	511	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   516	525	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   578	583	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   591	599	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   605	610	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   642	647	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   652	661	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   679	684	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   692	700	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   700	713	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   716	765	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   765	775	331	android/database/sqlite/SQLiteDatabaseLockedException
    //   186	218	377	finally
    //   310	323	377	finally
    //   136	176	387	android/database/sqlite/SQLiteException
    //   181	186	387	android/database/sqlite/SQLiteException
    //   218	223	387	android/database/sqlite/SQLiteException
    //   228	237	387	android/database/sqlite/SQLiteException
    //   323	328	387	android/database/sqlite/SQLiteException
    //   379	387	387	android/database/sqlite/SQLiteException
    //   469	474	387	android/database/sqlite/SQLiteException
    //   506	511	387	android/database/sqlite/SQLiteException
    //   516	525	387	android/database/sqlite/SQLiteException
    //   578	583	387	android/database/sqlite/SQLiteException
    //   591	599	387	android/database/sqlite/SQLiteException
    //   605	610	387	android/database/sqlite/SQLiteException
    //   642	647	387	android/database/sqlite/SQLiteException
    //   652	661	387	android/database/sqlite/SQLiteException
    //   679	684	387	android/database/sqlite/SQLiteException
    //   692	700	387	android/database/sqlite/SQLiteException
    //   700	713	387	android/database/sqlite/SQLiteException
    //   716	765	387	android/database/sqlite/SQLiteException
    //   765	775	387	android/database/sqlite/SQLiteException
    //   136	176	528	finally
    //   181	186	528	finally
    //   218	223	528	finally
    //   228	237	528	finally
    //   323	328	528	finally
    //   379	387	528	finally
    //   469	474	528	finally
    //   506	511	528	finally
    //   516	525	528	finally
    //   578	583	528	finally
    //   591	599	528	finally
    //   605	610	528	finally
    //   642	647	528	finally
    //   652	661	528	finally
    //   679	684	528	finally
    //   692	700	528	finally
    //   700	713	528	finally
    //   716	765	528	finally
    //   765	775	528	finally
    //   474	506	563	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   474	506	589	finally
    //   565	578	589	finally
    //   610	642	664	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   610	642	690	finally
    //   666	679	690	finally
    //   53	59	814	finally
    //   64	69	825	finally
    //   81	127	825	finally
    //   254	274	841	finally
    //   341	346	858	finally
    //   402	415	858	finally
    //   415	435	858	finally
    //   53	59	863	android/database/sqlite/SQLiteException
    //   64	69	874	android/database/sqlite/SQLiteException
    //   81	127	874	android/database/sqlite/SQLiteException
    //   53	59	890	android/database/sqlite/SQLiteDatabaseLockedException
    //   64	69	901	android/database/sqlite/SQLiteDatabaseLockedException
    //   81	127	901	android/database/sqlite/SQLiteDatabaseLockedException
    //   53	59	913	android/database/sqlite/SQLiteFullException
    //   64	69	924	android/database/sqlite/SQLiteFullException
    //   81	127	924	android/database/sqlite/SQLiteFullException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzao
 * JD-Core Version:    0.6.2
 */