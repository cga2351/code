package com.viber.voip.phone.viber.conference.data;

import android.content.ContentValues;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.viber.conference.mapper.ConferenceCallMapper;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallEntity;
import dagger.a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.sqlite.database.SQLException;

@Singleton
public class ConferenceCallsDatabaseHelper
{
  private static final Logger L = ViberEnv.getLogger();
  private final ConferenceCallMapper mConferenceCallMapper;
  private final a<b> mDatabase;

  @Inject
  public ConferenceCallsDatabaseHelper(a<b> parama, ConferenceCallMapper paramConferenceCallMapper)
  {
    this.mDatabase = parama;
    this.mConferenceCallMapper = paramConferenceCallMapper;
  }

  private b getDatabase()
  {
    return (b)this.mDatabase.get();
  }

  public void deleteConferenceCallByCallToken(long paramLong)
  {
    try
    {
      b localb = getDatabase();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramLong);
      localb.a("conference_calls", "call_token = ?", arrayOfString);
      return;
    }
    catch (SQLException localSQLException)
    {
    }
  }

  // ERROR //
  public void deleteConferenceCallByConversationIds(java.util.Collection<java.lang.Long> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	com/viber/voip/phone/viber/conference/data/ConferenceCallsDatabaseHelper:getDatabase	()Lcom/viber/provider/b;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface 65 1 0
    //   11: getstatic 71	java/util/Locale:US	Ljava/util/Locale;
    //   14: astore 5
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: astore 6
    //   22: aload 6
    //   24: iconst_0
    //   25: aload_1
    //   26: invokestatic 77	com/viber/voip/s/a:e	(Ljava/util/Collection;)Ljava/lang/String;
    //   29: aastore
    //   30: aload_2
    //   31: aload 5
    //   33: ldc 79
    //   35: aload 6
    //   37: invokestatic 83	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   40: invokeinterface 86 2 0
    //   45: aload_2
    //   46: invokeinterface 89 1 0
    //   51: aload_2
    //   52: invokeinterface 92 1 0
    //   57: return
    //   58: astore 4
    //   60: aload_2
    //   61: invokeinterface 92 1 0
    //   66: return
    //   67: astore_3
    //   68: aload_2
    //   69: invokeinterface 92 1 0
    //   74: aload_3
    //   75: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   5	51	58	org/sqlite/database/SQLException
    //   5	51	67	finally
  }

  // ERROR //
  public OngoingConferenceCallEntity getConferenceCallByToken(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokespecial 47	com/viber/voip/phone/viber/conference/data/ConferenceCallsDatabaseHelper:getDatabase	()Lcom/viber/provider/b;
    //   6: astore 7
    //   8: iconst_1
    //   9: anewarray 49	java/lang/String
    //   12: astore 8
    //   14: aload 8
    //   16: iconst_0
    //   17: lload_1
    //   18: invokestatic 53	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   21: aastore
    //   22: aload 7
    //   24: ldc 55
    //   26: aconst_null
    //   27: ldc 57
    //   29: aload 8
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokeinterface 97 8 0
    //   39: astore 9
    //   41: aload 9
    //   43: ifnull +36 -> 79
    //   46: aload 9
    //   48: invokeinterface 103 1 0
    //   53: ifeq +26 -> 79
    //   56: aload_0
    //   57: getfield 31	com/viber/voip/phone/viber/conference/data/ConferenceCallsDatabaseHelper:mConferenceCallMapper	Lcom/viber/voip/phone/viber/conference/mapper/ConferenceCallMapper;
    //   60: aload 9
    //   62: invokevirtual 109	com/viber/voip/phone/viber/conference/mapper/ConferenceCallMapper:mapToRepositoryEntity	(Landroid/database/Cursor;)Lcom/viber/voip/phone/viber/conference/model/OngoingConferenceCallEntity;
    //   65: astore 12
    //   67: aload 12
    //   69: astore 10
    //   71: aload 9
    //   73: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   76: aload 10
    //   78: areturn
    //   79: aconst_null
    //   80: astore 10
    //   82: goto -11 -> 71
    //   85: astore 5
    //   87: aconst_null
    //   88: astore 6
    //   90: aload 6
    //   92: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   95: aconst_null
    //   96: areturn
    //   97: astore 4
    //   99: aload_3
    //   100: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   103: aload 4
    //   105: athrow
    //   106: astore 4
    //   108: aload 9
    //   110: astore_3
    //   111: goto -12 -> 99
    //   114: astore 11
    //   116: aload 9
    //   118: astore 6
    //   120: goto -30 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   2	41	85	org/sqlite/database/SQLException
    //   2	41	97	finally
    //   46	67	106	finally
    //   46	67	114	org/sqlite/database/SQLException
  }

  public boolean insertConferenceCall(OngoingConferenceCallEntity paramOngoingConferenceCallEntity)
  {
    try
    {
      long l = getDatabase().a("conference_calls", null, this.mConferenceCallMapper.mapToContentValues(paramOngoingConferenceCallEntity));
      boolean bool1 = -1L < l;
      boolean bool2 = false;
      if (bool1)
        bool2 = true;
      return bool2;
    }
    catch (SQLException localSQLException)
    {
    }
    return false;
  }

  // ERROR //
  public java.util.List<OngoingConferenceCallEntity> loadAllConferences()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 129	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 130	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: invokespecial 47	com/viber/voip/phone/viber/conference/data/ConferenceCallsDatabaseHelper:getDatabase	()Lcom/viber/provider/b;
    //   14: ldc 132
    //   16: aconst_null
    //   17: invokeinterface 135 3 0
    //   22: astore 7
    //   24: aload 7
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 138	com/viber/voip/util/af:b	(Landroid/database/Cursor;)Z
    //   31: ifne +38 -> 69
    //   34: aload_1
    //   35: invokeinterface 141 1 0
    //   40: ifeq +29 -> 69
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 31	com/viber/voip/phone/viber/conference/data/ConferenceCallsDatabaseHelper:mConferenceCallMapper	Lcom/viber/voip/phone/viber/conference/mapper/ConferenceCallMapper;
    //   48: aload_1
    //   49: invokevirtual 109	com/viber/voip/phone/viber/conference/mapper/ConferenceCallMapper:mapToRepositoryEntity	(Landroid/database/Cursor;)Lcom/viber/voip/phone/viber/conference/model/OngoingConferenceCallEntity;
    //   52: invokeinterface 147 2 0
    //   57: pop
    //   58: goto -31 -> 27
    //   61: astore 6
    //   63: aload_1
    //   64: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   67: aload_2
    //   68: areturn
    //   69: aload_1
    //   70: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   73: aload_2
    //   74: areturn
    //   75: astore_3
    //   76: aconst_null
    //   77: astore 4
    //   79: aload_3
    //   80: astore 5
    //   82: aload 4
    //   84: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   87: aload 5
    //   89: athrow
    //   90: astore 8
    //   92: aload_1
    //   93: astore 4
    //   95: aload 8
    //   97: astore 5
    //   99: goto -17 -> 82
    //
    // Exception table:
    //   from	to	target	type
    //   10	24	61	org/sqlite/database/SQLException
    //   27	58	61	org/sqlite/database/SQLException
    //   10	24	75	finally
    //   27	58	90	finally
  }

  // ERROR //
  public java.util.List<OngoingConferenceCallEntity> loadInvalidConferences(java.util.Collection<java.lang.Long> paramCollection, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 129	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 130	java/util/ArrayList:<init>	()V
    //   10: astore 5
    //   12: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   15: lstore 6
    //   17: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   20: lload_2
    //   21: lsub
    //   22: lstore 8
    //   24: aload_0
    //   25: invokespecial 47	com/viber/voip/phone/viber/conference/data/ConferenceCallsDatabaseHelper:getDatabase	()Lcom/viber/provider/b;
    //   28: astore 14
    //   30: getstatic 71	java/util/Locale:US	Ljava/util/Locale;
    //   33: astore 15
    //   35: iconst_3
    //   36: anewarray 4	java/lang/Object
    //   39: astore 16
    //   41: aload 16
    //   43: iconst_0
    //   44: lload 8
    //   46: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   49: aastore
    //   50: aload 16
    //   52: iconst_1
    //   53: lload 6
    //   55: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   58: aastore
    //   59: aload 16
    //   61: iconst_2
    //   62: aload_1
    //   63: invokestatic 77	com/viber/voip/s/a:e	(Ljava/util/Collection;)Ljava/lang/String;
    //   66: aastore
    //   67: aload 14
    //   69: aload 15
    //   71: ldc 162
    //   73: aload 16
    //   75: invokestatic 83	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   78: aconst_null
    //   79: invokeinterface 135 3 0
    //   84: astore 17
    //   86: aload 17
    //   88: astore 4
    //   90: aload 4
    //   92: invokestatic 138	com/viber/voip/util/af:b	(Landroid/database/Cursor;)Z
    //   95: ifne +43 -> 138
    //   98: aload 4
    //   100: invokeinterface 141 1 0
    //   105: ifeq +33 -> 138
    //   108: aload 5
    //   110: aload_0
    //   111: getfield 31	com/viber/voip/phone/viber/conference/data/ConferenceCallsDatabaseHelper:mConferenceCallMapper	Lcom/viber/voip/phone/viber/conference/mapper/ConferenceCallMapper;
    //   114: aload 4
    //   116: invokevirtual 109	com/viber/voip/phone/viber/conference/mapper/ConferenceCallMapper:mapToRepositoryEntity	(Landroid/database/Cursor;)Lcom/viber/voip/phone/viber/conference/model/OngoingConferenceCallEntity;
    //   119: invokeinterface 147 2 0
    //   124: pop
    //   125: goto -35 -> 90
    //   128: astore 13
    //   130: aload 4
    //   132: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   135: aload 5
    //   137: areturn
    //   138: aload 4
    //   140: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   143: aload 5
    //   145: areturn
    //   146: astore 10
    //   148: aconst_null
    //   149: astore 11
    //   151: aload 10
    //   153: astore 12
    //   155: aload 11
    //   157: invokestatic 114	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   160: aload 12
    //   162: athrow
    //   163: astore 18
    //   165: aload 4
    //   167: astore 11
    //   169: aload 18
    //   171: astore 12
    //   173: goto -18 -> 155
    //
    // Exception table:
    //   from	to	target	type
    //   24	86	128	org/sqlite/database/SQLException
    //   90	125	128	org/sqlite/database/SQLException
    //   24	86	146	finally
    //   90	125	163	finally
  }

  // ERROR //
  public void removeConferencesByIds(java.util.Collection<java.lang.Long> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	com/viber/voip/phone/viber/conference/data/ConferenceCallsDatabaseHelper:getDatabase	()Lcom/viber/provider/b;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface 65 1 0
    //   11: getstatic 71	java/util/Locale:US	Ljava/util/Locale;
    //   14: astore 5
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: astore 6
    //   22: aload 6
    //   24: iconst_0
    //   25: aload_1
    //   26: invokestatic 77	com/viber/voip/s/a:e	(Ljava/util/Collection;)Ljava/lang/String;
    //   29: aastore
    //   30: aload_2
    //   31: aload 5
    //   33: ldc 165
    //   35: aload 6
    //   37: invokestatic 83	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   40: invokeinterface 86 2 0
    //   45: aload_2
    //   46: invokeinterface 89 1 0
    //   51: aload_2
    //   52: invokeinterface 92 1 0
    //   57: return
    //   58: astore 4
    //   60: aload_2
    //   61: invokeinterface 92 1 0
    //   66: return
    //   67: astore_3
    //   68: aload_2
    //   69: invokeinterface 92 1 0
    //   74: aload_3
    //   75: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   5	51	58	org/sqlite/database/SQLException
    //   5	51	67	finally
  }

  public boolean updateConferenceCallInfo(OngoingConferenceCallEntity paramOngoingConferenceCallEntity)
  {
    try
    {
      b localb = getDatabase();
      ContentValues localContentValues = this.mConferenceCallMapper.mapToConferenceInfoContentValues(paramOngoingConferenceCallEntity);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramOngoingConferenceCallEntity.id);
      int i = localb.a("conference_calls", localContentValues, "_id = ?", arrayOfString);
      return i > 0;
    }
    catch (SQLException localSQLException)
    {
    }
    return false;
  }

  private static abstract interface Clause
  {
    public static final String WHERE_CALL_TOKEN = "call_token = ?";
    public static final String WHERE_ID = "_id = ?";
  }

  private static abstract interface Query
  {
    public static final String DELETE_CONVERSATION_IDS = "DELETE FROM conference_calls WHERE conversation_id IN (%s)";
    public static final String DELETE_IDS = "DELETE FROM conference_calls WHERE _id IN (%s)";
    public static final String SELECT_ALL = "SELECT * FROM conference_calls";
    public static final String SELECT_INVALID = "SELECT * FROM conference_calls WHERE %s > start_time_millis OR %s < start_time_millis OR conversation_id NOT IN (%s)";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.data.ConferenceCallsDatabaseHelper
 * JD-Core Version:    0.6.2
 */