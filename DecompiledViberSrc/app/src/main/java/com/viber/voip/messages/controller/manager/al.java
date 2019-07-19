package com.viber.voip.messages.controller.manager;

import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.entity.impl.ParticipantEntityHelper;
import com.viber.voip.model.entity.l;
import com.viber.voip.model.entity.m;
import com.viber.voip.s.a;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.dd;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.sqlite.database.sqlite.SQLiteStatement;

public class al extends aa
{
  private static final Logger g = ViberEnv.getLogger();
  private static volatile al h;

  private long a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    localStringBuilder.append("INSERT INTO ").append("participants").append('(');
    a.b(localStringBuilder, ParticipantEntityHelper.PROJECTIONS);
    localStringBuilder.append(") VALUES (?");
    for (int i = 1; i < ParticipantEntityHelper.PROJECTIONS.length; i++)
      localStringBuilder.append(",?");
    localStringBuilder.append(')');
    return ParticipantEntityHelper.bindInsertStatmentValues(aj.a(localStringBuilder.toString()), paramLong1, paramLong2, paramInt1, paramLong3, paramInt2).executeInsert();
  }

  public static al a()
  {
    if (h == null);
    try
    {
      if (h == null)
      {
        dd.b();
        h = new al();
      }
      return h;
    }
    finally
    {
    }
  }

  public int a(long paramLong, Set<Long> paramSet1, Set<Long> paramSet2)
  {
    return (int)f().b("SELECT COUNT(*) FROM participants WHERE conversation_id=" + paramLong + " AND " + "active" + " = " + 0 + " AND ((" + "group_role_local" + " = " + 4 + " AND " + "_id" + " NOT IN (" + a.e(paramSet1) + ")) OR " + "_id" + " IN (" + a.e(paramSet2) + "))").simpleQueryForLong();
  }

  public int a(long paramLong, String[] paramArrayOfString, int paramInt)
  {
    String str1 = "SELECT participants_info._id FROM participants_info WHERE participants_info.member_id IN (" + a.a(paramArrayOfString) + ")";
    String str2 = "UPDATE participants SET group_role_local=" + paramInt + " WHERE " + "participants.conversation_id" + "=" + paramLong + " AND " + "participants.participant_info_id" + " IN (" + str1 + ")";
    return f().b(str2).executeUpdateDelete();
  }

  public long a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    return a(-1L, paramLong1, paramInt1, paramLong2, paramInt2);
  }

  public long a(l paraml)
  {
    long l = a(paraml.getId(), paraml.b(), paraml.d(), paraml.a(), paraml.e());
    if (l > 0L)
      paraml.setId(l);
    return l;
  }

  public l a(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    return j("participants.conversation_id =? AND participants.participant_info_id IN (SELECT participants_info._id FROM participants_info WHERE participants_info.participant_type=0 )", arrayOfString);
  }

  public l a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    l locall = b(paramLong1, paramLong2);
    if (locall == null)
      locall = b(paramLong1, paramInt1, paramLong2, paramInt2);
    while ((paramInt1 == locall.d()) && (paramInt2 == locall.e()))
      return locall;
    locall.a(paramInt1);
    locall.a(paramInt2, paramInt2);
    b(locall);
    return locall;
  }

  public l a(long paramLong, int paramInt, m paramm)
  {
    return a(paramLong, 0, paramInt, paramm.getId());
  }

  public l a(long paramLong, String paramString)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = String.valueOf(paramLong);
    arrayOfString[1] = paramString;
    arrayOfString[2] = paramString;
    arrayOfString[3] = paramString;
    return h("participants.conversation_id=? AND participants.participant_info_id IN (SELECT participants_info._id FROM participants_info WHERE participants_info.member_id=? OR participants_info.encrypted_member_id=? OR participants_info.encrypted_number=?)", arrayOfString, "active");
  }

  public Long a(long paramLong1, long paramLong2)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT COALESCE((SELECT _id FROM participants WHERE conversation_id=? AND participant_info_id=? LIMIT 1),-1) AS _id");
    localSQLiteStatement.bindLong(1, paramLong1);
    localSQLiteStatement.bindLong(2, paramLong2);
    long l = localSQLiteStatement.simpleQueryForLong();
    if (l < 0L)
      return null;
    return Long.valueOf(l);
  }

  // ERROR //
  @android.annotation.SuppressLint({"UseSparseArrays"})
  public HashMap<Long, Integer> a(Set<Long> paramSet)
  {
    // Byte code:
    //   0: new 231	java/util/HashMap
    //   3: dup
    //   4: aload_1
    //   5: invokeinterface 236 1 0
    //   10: fconst_1
    //   11: invokespecial 239	java/util/HashMap:<init>	(IF)V
    //   14: astore_2
    //   15: invokestatic 87	com/viber/voip/messages/controller/manager/al:f	()Lcom/viber/provider/b;
    //   18: astore 5
    //   20: iconst_2
    //   21: anewarray 176	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 241
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: ldc 243
    //   33: aastore
    //   34: astore 6
    //   36: new 25	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   43: astore 7
    //   45: iconst_1
    //   46: anewarray 245	java/lang/Object
    //   49: astore 8
    //   51: aload 8
    //   53: iconst_0
    //   54: aload_1
    //   55: invokestatic 247	com/viber/voip/s/a:a	(Ljava/util/Collection;)Ljava/lang/String;
    //   58: aastore
    //   59: aload 5
    //   61: ldc 36
    //   63: aload 6
    //   65: aload 7
    //   67: ldc 249
    //   69: aload 8
    //   71: invokestatic 253	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 255
    //   79: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: iconst_0
    //   83: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc_w 257
    //   89: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokeinterface 260 8 0
    //   104: astore 9
    //   106: aload 9
    //   108: astore 4
    //   110: aload 4
    //   112: ifnull +54 -> 166
    //   115: aload 4
    //   117: invokeinterface 266 1 0
    //   122: ifeq +44 -> 166
    //   125: aload_2
    //   126: aload 4
    //   128: iconst_0
    //   129: invokeinterface 270 2 0
    //   134: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: aload 4
    //   139: iconst_1
    //   140: invokeinterface 274 2 0
    //   145: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: invokevirtual 283	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: aload 4
    //   154: invokeinterface 286 1 0
    //   159: istore 11
    //   161: iload 11
    //   163: ifne -38 -> 125
    //   166: aload_0
    //   167: aload 4
    //   169: invokevirtual 289	com/viber/voip/messages/controller/manager/al:a	(Landroid/database/Cursor;)V
    //   172: aload_2
    //   173: areturn
    //   174: astore_3
    //   175: aconst_null
    //   176: astore 4
    //   178: aload_0
    //   179: aload 4
    //   181: invokevirtual 289	com/viber/voip/messages/controller/manager/al:a	(Landroid/database/Cursor;)V
    //   184: aload_3
    //   185: athrow
    //   186: astore_3
    //   187: goto -9 -> 178
    //
    // Exception table:
    //   from	to	target	type
    //   15	106	174	finally
    //   115	125	186	finally
    //   125	161	186	finally
  }

  public List<l> a(LongSparseSet paramLongSparseSet)
  {
    return i("_id IN(" + a.a(paramLongSparseSet) + ")", null);
  }

  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    SQLiteStatement localSQLiteStatement = aj.a("UPDATE participants SET conversation_id=?,last_message_id=? WHERE _id=?");
    localSQLiteStatement.bindLong(1, paramLong2);
    localSQLiteStatement.bindLong(2, paramLong3);
    localSQLiteStatement.bindLong(3, paramLong1);
    localSQLiteStatement.executeUpdateDelete();
  }

  public boolean a(long paramLong, int paramInt)
  {
    SQLiteStatement localSQLiteStatement = aj.a("UPDATE participants SET group_role_local=group_role WHERE participants.conversation_id=? AND group_role_local= ? AND participants.active=0 AND participants.group_role_local<> -1 AND participants.group_role_local<>0 AND participants.group_role <> participants.group_role_local");
    localSQLiteStatement.bindLong(1, paramLong);
    localSQLiteStatement.bindLong(2, paramInt);
    return localSQLiteStatement.executeUpdateDelete() > 0;
  }

  public l b(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    l locall = new l();
    locall.b(paramLong1);
    locall.a(paramInt1);
    locall.a(paramLong2);
    locall.a(paramInt2, paramInt2);
    locall.setId(a(locall));
    return locall;
  }

  public l b(long paramLong1, long paramLong2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramLong1);
    arrayOfString[1] = String.valueOf(paramLong2);
    return j("conversation_id=? AND participant_info_id=?", arrayOfString);
  }

  // ERROR //
  public List<a> b()
  {
    // Byte code:
    //   0: new 318	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 319	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: invokestatic 87	com/viber/voip/messages/controller/manager/al:f	()Lcom/viber/provider/b;
    //   11: ldc_w 321
    //   14: getstatic 325	com/viber/voip/messages/controller/manager/al$a:a	[Ljava/lang/String;
    //   17: ldc_w 327
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: ldc_w 329
    //   26: aconst_null
    //   27: invokeinterface 332 9 0
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +40 -> 78
    //   41: aload_3
    //   42: invokeinterface 266 1 0
    //   47: ifeq +31 -> 78
    //   50: aload_1
    //   51: new 323	com/viber/voip/messages/controller/manager/al$a
    //   54: dup
    //   55: aload_3
    //   56: invokespecial 334	com/viber/voip/messages/controller/manager/al$a:<init>	(Landroid/database/Cursor;)V
    //   59: invokeinterface 340 2 0
    //   64: pop
    //   65: aload_3
    //   66: invokeinterface 286 1 0
    //   71: istore 6
    //   73: iload 6
    //   75: ifne -25 -> 50
    //   78: aload_0
    //   79: aload_3
    //   80: invokevirtual 289	com/viber/voip/messages/controller/manager/al:a	(Landroid/database/Cursor;)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_0
    //   89: aload_3
    //   90: invokevirtual 289	com/viber/voip/messages/controller/manager/al:a	(Landroid/database/Cursor;)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_2
    //   96: goto -8 -> 88
    //
    // Exception table:
    //   from	to	target	type
    //   8	34	85	finally
    //   41	50	95	finally
    //   50	73	95	finally
  }

  public List<l> b(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    return i("conversation_id=?", arrayOfString);
  }

  public List<l> c(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    return i("conversation_id=? AND active = 0", arrayOfString);
  }

  // ERROR //
  protected List<l> c(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 318	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 319	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 87	com/viber/voip/messages/controller/manager/al:f	()Lcom/viber/provider/b;
    //   12: ldc 36
    //   14: getstatic 45	com/viber/voip/messages/orm/entity/impl/ParticipantEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   17: aload_1
    //   18: aload_2
    //   19: aload 4
    //   21: aconst_null
    //   22: aload_3
    //   23: aconst_null
    //   24: invokeinterface 332 9 0
    //   29: astore 8
    //   31: aload 8
    //   33: astore 7
    //   35: aload 7
    //   37: ifnull +48 -> 85
    //   40: aload 7
    //   42: invokeinterface 266 1 0
    //   47: ifeq +38 -> 85
    //   50: aload 5
    //   52: new 157	com/viber/voip/model/entity/l
    //   55: dup
    //   56: invokespecial 306	com/viber/voip/model/entity/l:<init>	()V
    //   59: aload 7
    //   61: iconst_0
    //   62: invokestatic 351	com/viber/voip/messages/orm/entity/impl/ParticipantEntityHelper:createEntity	(Lcom/viber/voip/model/entity/l;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/l;
    //   65: invokeinterface 340 2 0
    //   70: pop
    //   71: aload 7
    //   73: invokeinterface 286 1 0
    //   78: istore 10
    //   80: iload 10
    //   82: ifne -32 -> 50
    //   85: aload_0
    //   86: aload 7
    //   88: invokevirtual 289	com/viber/voip/messages/controller/manager/al:a	(Landroid/database/Cursor;)V
    //   91: aload 5
    //   93: areturn
    //   94: astore 6
    //   96: aconst_null
    //   97: astore 7
    //   99: aload_0
    //   100: aload 7
    //   102: invokevirtual 289	com/viber/voip/messages/controller/manager/al:a	(Landroid/database/Cursor;)V
    //   105: aload 6
    //   107: athrow
    //   108: astore 6
    //   110: goto -11 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   9	31	94	finally
    //   40	50	108	finally
    //   50	80	108	finally
  }

  public int d(long paramLong)
  {
    Integer localInteger = (Integer)a(Collections.singleton(Long.valueOf(paramLong))).get(Long.valueOf(paramLong));
    if (localInteger != null)
      return localInteger.intValue();
    return 0;
  }

  public int e(long paramLong)
  {
    try
    {
      SQLiteStatement localSQLiteStatement = aj.a("SELECT COUNT(*) FROM participants WHERE conversation_id=? AND active = 0 AND (group_role_local = 4 OR group_role_local = 1)");
      localSQLiteStatement.bindLong(1, paramLong);
      long l = localSQLiteStatement.simpleQueryForLong();
      int i = (int)l;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected List<l> g(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return c(paramString1, paramArrayOfString, paramString2, null);
  }

  // ERROR //
  protected l h(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 87	com/viber/voip/messages/controller/manager/al:f	()Lcom/viber/provider/b;
    //   6: ldc 36
    //   8: getstatic 45	com/viber/voip/messages/orm/entity/impl/ParticipantEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   11: aload_1
    //   12: aload_2
    //   13: aconst_null
    //   14: aconst_null
    //   15: aload_3
    //   16: ldc_w 374
    //   19: invokeinterface 332 9 0
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +41 -> 69
    //   31: aload 6
    //   33: invokeinterface 266 1 0
    //   38: ifeq +31 -> 69
    //   41: new 157	com/viber/voip/model/entity/l
    //   44: dup
    //   45: invokespecial 306	com/viber/voip/model/entity/l:<init>	()V
    //   48: aload 6
    //   50: iconst_0
    //   51: invokestatic 351	com/viber/voip/messages/orm/entity/impl/ParticipantEntityHelper:createEntity	(Lcom/viber/voip/model/entity/l;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/l;
    //   54: astore 8
    //   56: aload 8
    //   58: astore 7
    //   60: aload_0
    //   61: aload 6
    //   63: invokevirtual 289	com/viber/voip/messages/controller/manager/al:a	(Landroid/database/Cursor;)V
    //   66: aload 7
    //   68: areturn
    //   69: aconst_null
    //   70: astore 7
    //   72: goto -12 -> 60
    //   75: astore 5
    //   77: aload_0
    //   78: aload 4
    //   80: invokevirtual 289	com/viber/voip/messages/controller/manager/al:a	(Landroid/database/Cursor;)V
    //   83: aload 5
    //   85: athrow
    //   86: astore 5
    //   88: aload 6
    //   90: astore 4
    //   92: goto -15 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   3	26	75	finally
    //   31	56	86	finally
  }

  protected List<l> i(String paramString, String[] paramArrayOfString)
  {
    return g(paramString, paramArrayOfString, null);
  }

  protected l j(String paramString, String[] paramArrayOfString)
  {
    return h(paramString, paramArrayOfString, null);
  }

  public static class a
  {
    public static final String[] a = { "conversations.group_id", "participants_info.member_id", "participants.group_role_local" };
    private long b;
    private int c;
    private String d;

    public a(Cursor paramCursor)
    {
      this.b = paramCursor.getLong(0);
      this.d = paramCursor.getString(1);
      this.c = paramCursor.getInt(2);
    }

    public long a()
    {
      return this.b;
    }

    public int b()
    {
      return this.c;
    }

    public String c()
    {
      return this.d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.al
 * JD-Core Version:    0.6.2
 */