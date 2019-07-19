package com.viber.voip.messages.controller.manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.util.Pair;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.entity.impl.ParticipantInfoEntityHelper;
import com.viber.voip.model.entity.h;
import com.viber.voip.s.a;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.af;
import com.viber.voip.util.av;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.sqlite.database.sqlite.SQLiteStatement;

public class z extends aa
{
  private static final Logger g = ViberEnv.getLogger();
  private static final String h = "messages._id" + "," + "messages.msg_date" + "," + "messages.group_id" + "," + "participants_info._id";
  private static final String i = "SELECT " + "%s" + " FROM " + "participants" + " LEFT OUTER JOIN " + "messages" + " ON (messages.participant_id=participants._id AND messages._id IN(%s))" + " LEFT OUTER JOIN " + "participants_info" + " ON (participants.participant_info_id=participants_info._id)" + " WHERE " + "participants.conversation_id=?" + " ORDER BY " + "%s" + " LIMIT ?";
  private static final String j = 400 + "SELECT messages._id,MAX(messages.order_key)" + ',' + "messages.msg_date" + str + " ORDER BY messages.order_key DESC, messages.msg_date DESC";
  private static final String k = 400 + "SELECT " + "messages._id" + str + " AND " + "messages.participant_id" + "=?" + " ORDER BY messages.order_key DESC, messages.msg_date DESC" + " LIMIT 1";
  private static final String l = 400 + "SELECT DISTINCT " + "messages.participant_id" + str + " ORDER BY messages.order_key DESC, messages.msg_date DESC" + " LIMIT ?";
  private static final long m = av.a(0L, new int[] { 0, 2, 13, 34, 4, 19, 24 });
  private static final long n = av.a(0L, new int[] { 10, 11, 16 });
  private static final long o = av.a(0L, new int[] { 10, 32, 16 });
  private static final long p = av.a(0L, new int[] { 9, 7, 5 });
  private static final String q = "UPDATE conversations SET deleted = (CASE WHEN conversation_type = 0 THEN 0 ELSE 1 END),delete_token = (SELECT MAX(messages.token) FROM messages WHERE conversations._id = messages.conversation_id), background_portrait = '', background_landscape = '', background_text_color=" + com.viber.voip.backgrounds.m.a(ViberApplication.getApplication()) + ", " + "flags" + " = (CASE WHEN (" + "flags" + " & " + m + ") = 0 THEN (CASE WHEN " + "conversation_type" + " = " + 0 + " THEN (" + o + " | (" + "flags" + " & " + av.a(0L, new int[] { 35 }) + ")) WHEN " + "conversation_type" + " = " + 5 + " THEN (" + n + " | (" + "flags" + " & " + av.a(0L, new int[] { 36 }) + ")) ELSE " + n + " END) ELSE (" + "flags" + " &~ " + p + ") END), " + "smart_notification" + " = 0, " + "message_draft" + " = '', " + "msg_draft_spans" + " = '', " + "bot_reply" + " = '', " + "share_location" + " = 0," + "reply_banner_draft" + "= '' WHERE " + "_id" + " IN (%s)";
  private ak r = ak.a();

  static
  {
    String str = 300 + " FROM " + "messages" + " WHERE " + "messages.conversation_id=?" + " AND " + "messages.deleted=0 AND messages.extra_mime<>1007 AND messages.status<>12 AND messages.extra_flags&4194304=0 AND (messages.flag&131072=0 OR send_type=0)" + " AND " + "broadcast_msg_id=0";
  }

  private static int a(int paramInt)
  {
    int i1 = 1;
    if (i1 == paramInt)
      i1 = 4;
    return i1;
  }

  private void a(boolean paramBoolean, Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    if ((paramCursor != null) && (((paramBoolean) && (paramCursor.moveToFirst())) || ((!paramBoolean) && (paramCursor.moveToNext()))))
    {
      paramContentValues.put(paramString, Long.valueOf(paramCursor.getLong(3)));
      return;
    }
    paramContentValues.put(paramString, Integer.valueOf(0));
  }

  private long b(long paramLong1, long paramLong2)
  {
    SQLiteStatement localSQLiteStatement = aj.a(k);
    localSQLiteStatement.bindLong(1, paramLong1);
    localSQLiteStatement.bindLong(2, paramLong2);
    return localSQLiteStatement.simpleQueryForLong();
  }

  private LongSparseSet d(long paramLong, int paramInt)
  {
    if (1 == paramInt)
      return e(paramLong, paramInt);
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = f(paramLong, 0).longValue();
    return LongSparseSet.from(arrayOfLong);
  }

  private LongSparseSet e(long paramLong, int paramInt)
  {
    Cursor localCursor = null;
    try
    {
      b localb = f();
      int i1 = a(paramInt);
      LongSparseSet localLongSparseSet = new LongSparseSet(i1);
      String str = l;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = String.valueOf(paramLong);
      arrayOfString[1] = String.valueOf(i1);
      localCursor = localb.a(str, arrayOfString);
      if (af.c(localCursor))
      {
        boolean bool;
        do
        {
          localLongSparseSet.add(b(paramLong, localCursor.getLong(0)));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localLongSparseSet;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  // ERROR //
  private Long f(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 283	com/viber/voip/messages/controller/manager/z:f	()Lcom/viber/provider/b;
    //   3: astore 4
    //   5: getstatic 103	com/viber/voip/messages/controller/manager/z:j	Ljava/lang/String;
    //   8: astore 8
    //   10: iconst_1
    //   11: anewarray 288	java/lang/String
    //   14: astore 9
    //   16: aload 9
    //   18: iconst_0
    //   19: lload_1
    //   20: invokestatic 291	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   23: aastore
    //   24: aload 4
    //   26: aload 8
    //   28: aload 9
    //   30: invokeinterface 299 3 0
    //   35: astore 10
    //   37: aload 10
    //   39: astore 6
    //   41: aload 6
    //   43: ifnull +34 -> 77
    //   46: aload 6
    //   48: invokeinterface 218 1 0
    //   53: ifeq +24 -> 77
    //   56: aload 6
    //   58: iload_3
    //   59: invokeinterface 225 2 0
    //   64: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: astore 11
    //   69: aload 6
    //   71: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   74: aload 11
    //   76: areturn
    //   77: aload 6
    //   79: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   82: aconst_null
    //   83: areturn
    //   84: astore 5
    //   86: aconst_null
    //   87: astore 6
    //   89: aload 5
    //   91: astore 7
    //   93: aload 6
    //   95: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   98: aload 7
    //   100: athrow
    //   101: astore 7
    //   103: goto -10 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   5	37	84	finally
    //   46	69	101	finally
  }

  // ERROR //
  private Set<String> i(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 317	java/util/HashSet
    //   3: dup
    //   4: invokespecial 318	java/util/HashSet:<init>	()V
    //   7: astore_3
    //   8: invokestatic 283	com/viber/voip/messages/controller/manager/z:f	()Lcom/viber/provider/b;
    //   11: ldc 67
    //   13: iconst_1
    //   14: anewarray 288	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 320
    //   22: aastore
    //   23: aload_1
    //   24: aload_2
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokeinterface 323 8 0
    //   33: astore 6
    //   35: aload 6
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +54 -> 95
    //   44: aload 5
    //   46: invokeinterface 218 1 0
    //   51: ifeq +44 -> 95
    //   54: aload 5
    //   56: iconst_0
    //   57: invokeinterface 326 2 0
    //   62: astore 7
    //   64: aload 7
    //   66: invokestatic 332	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +12 -> 81
    //   72: aload_3
    //   73: aload 7
    //   75: invokeinterface 337 2 0
    //   80: pop
    //   81: aload 5
    //   83: invokeinterface 221 1 0
    //   88: istore 8
    //   90: iload 8
    //   92: ifne -38 -> 54
    //   95: aload_0
    //   96: aload 5
    //   98: invokevirtual 338	com/viber/voip/messages/controller/manager/z:a	(Landroid/database/Cursor;)V
    //   101: aload_3
    //   102: areturn
    //   103: astore 4
    //   105: aconst_null
    //   106: astore 5
    //   108: aload_0
    //   109: aload 5
    //   111: invokevirtual 338	com/viber/voip/messages/controller/manager/z:a	(Landroid/database/Cursor;)V
    //   114: aload 4
    //   116: athrow
    //   117: astore 4
    //   119: goto -11 -> 108
    //
    // Exception table:
    //   from	to	target	type
    //   8	35	103	finally
    //   44	54	117	finally
    //   54	81	117	finally
    //   81	90	117	finally
  }

  public int a(long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("read_notification_token", Long.valueOf(paramLong2));
    b localb = f();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong1);
    return localb.a("conversations", localContentValues, "_id=?", arrayOfString);
  }

  public int a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("read_message_time", Long.valueOf(paramLong3));
    b localb = f();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = Long.toString(paramLong1);
    int i1 = 0;
    if (paramBoolean);
    while (true)
    {
      arrayOfString[1] = Integer.toString(i1);
      arrayOfString[2] = Long.toString(paramLong2);
      return localb.a("messages", localContentValues, "conversation_id=? AND send_type=? AND read_message_time = 0 AND token<=?", arrayOfString);
      i1 = 1;
    }
  }

  public long a(int paramInt1, int paramInt2)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT COUNT (*) FROM messages WHERE send_type=? AND extra_mime=?");
    localSQLiteStatement.bindLong(1, paramInt1);
    localSQLiteStatement.bindLong(2, paramInt2);
    return localSQLiteStatement.simpleQueryForLong();
  }

  Pair<Set<Long>, Set<Long>> a(long[] paramArrayOfLong)
  {
    Cursor localCursor = null;
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    try
    {
      b localb = f();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a.a(paramArrayOfLong);
      localCursor = localb.a(String.format("SELECT participants_info.contact_id, conversations._id FROM conversations LEFT OUTER JOIN participants ON (conversations._id = participants.conversation_id) LEFT OUTER JOIN participants_info ON (participants.participant_info_id = participants_info._id) WHERE conversations.flags & (1 << 21) <> 0 AND conversations._id NOT IN (%s)", arrayOfObject), null);
      if (af.c(localCursor))
      {
        boolean bool;
        do
        {
          if (!localCursor.isNull(0))
            localHashSet1.add(Long.valueOf(localCursor.getLong(0)));
          localHashSet2.add(Long.valueOf(localCursor.getLong(1)));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return new Pair(localHashSet1, localHashSet2);
    }
    finally
    {
      a(localCursor);
    }
  }

  public List<com.viber.voip.model.entity.m> a(h paramh)
  {
    String str1 = a.a(d(paramh.getId(), paramh.j()));
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      String str2 = i;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = a.a("participants_info", ParticipantInfoEntityHelper.PROJECTIONS);
      arrayOfObject[1] = str1;
      arrayOfObject[2] = "participants_info.has_photo DESC, messages.order_key DESC, messages.msg_date DESC, participants_info.display_name ASC";
      String str3 = String.format(str2, arrayOfObject);
      b localb = f();
      String[] arrayOfString = new String[2];
      arrayOfString[0] = String.valueOf(paramh.getId());
      arrayOfString[1] = String.valueOf(a(paramh.j()));
      localCursor = localb.a(str3, arrayOfString);
      List localList = this.r.a(localCursor, localArrayList);
      return localList;
    }
    finally
    {
      a(localCursor);
    }
  }

  Set<Long> a()
  {
    Cursor localCursor = null;
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    String str = a.e(ViberApplication.getInstance().getMessagesManager().a().a());
    try
    {
      localCursor = f().a(String.format("SELECT contact_id FROM participants_info INNER JOIN (SELECT participant_id_1, conversations.date, favourite_conversation FROM conversations LEFT OUTER JOIN messages ON (messages._id = (SELECT messages._id FROM messages WHERE messages.conversation_id=conversations._id AND messages.deleted=0 AND messages.extra_mime<>1007 AND messages.status<>12 AND messages.extra_flags&4194304=0 AND (messages.flag&131072=0 OR send_type=0) ORDER BY messages.order_key DESC, messages.msg_date DESC LIMIT 1)) WHERE conversations.deleted<>1 AND conversations.conversation_type = 0 AND favourite_conversation=0 AND (messages._id>0 OR conversations.bot_reply <> '' OR conversations._id IN (%s)) AND (conversations.flags & (1 << 0) = 0 OR conversations.flags & 8192 != 0) AND conversations.flags & 294912=0) info_ids ON _id = info_ids.participant_id_1 WHERE contact_id<> 0 ORDER BY + info_ids.date DESC LIMIT 5", new Object[] { str }), null);
      if (af.c(localCursor))
      {
        boolean bool;
        do
        {
          localLinkedHashSet.add(Long.valueOf(localCursor.getLong(0)));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localLinkedHashSet;
    }
    finally
    {
      a(localCursor);
    }
  }

  public void a(long paramLong)
  {
    b localb = f();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    localb.a(String.format("UPDATE public_accounts SET last_read_message_id = (last_read_message_id + 1) WHERE group_id = %s", arrayOfObject));
  }

  // ERROR //
  public void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 452	com/viber/common/d/i:a	()Lcom/viber/common/d/i;
    //   3: pop
    //   4: lload_1
    //   5: invokestatic 291	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8: astore 5
    //   10: new 233	android/content/ContentValues
    //   13: dup
    //   14: iconst_5
    //   15: invokespecial 340	android/content/ContentValues:<init>	(I)V
    //   18: astore 6
    //   20: iload_3
    //   21: ifne +81 -> 102
    //   24: aload_0
    //   25: lload_1
    //   26: invokevirtual 454	com/viber/voip/messages/controller/manager/z:b	(J)Ljava/lang/Long;
    //   29: astore 36
    //   31: aload 36
    //   33: ifnull +23 -> 56
    //   36: aload 36
    //   38: invokevirtual 274	java/lang/Long:longValue	()J
    //   41: lconst_0
    //   42: lcmp
    //   43: ifle +13 -> 56
    //   46: aload 6
    //   48: ldc_w 456
    //   51: aload 36
    //   53: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   56: aload 6
    //   58: invokevirtual 459	android/content/ContentValues:size	()I
    //   61: ifle +40 -> 101
    //   64: invokestatic 283	com/viber/voip/messages/controller/manager/z:f	()Lcom/viber/provider/b;
    //   67: astore 30
    //   69: iconst_1
    //   70: anewarray 288	java/lang/String
    //   73: astore 31
    //   75: aload 31
    //   77: iconst_0
    //   78: lload_1
    //   79: invokestatic 291	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   82: aastore
    //   83: aload 30
    //   85: ldc_w 344
    //   88: aload 6
    //   90: ldc_w 346
    //   93: aload 31
    //   95: invokeinterface 349 5 0
    //   100: pop
    //   101: return
    //   102: aconst_null
    //   103: astore 7
    //   105: aload_0
    //   106: lload_1
    //   107: iload_3
    //   108: invokespecial 395	com/viber/voip/messages/controller/manager/z:d	(JI)Lcom/viber/voip/util/LongSparseSet;
    //   111: astore 8
    //   113: aload 8
    //   115: ifnull +283 -> 398
    //   118: aload 8
    //   120: invokevirtual 460	com/viber/voip/util/LongSparseSet:size	()I
    //   123: ifle +275 -> 398
    //   126: aload 8
    //   128: invokestatic 398	com/viber/voip/s/a:a	(Lcom/viber/voip/util/LongSparseSet;)Ljava/lang/String;
    //   131: astore 9
    //   133: new 32	java/lang/StringBuilder
    //   136: dup
    //   137: sipush 490
    //   140: invokespecial 86	java/lang/StringBuilder:<init>	(I)V
    //   143: astore 10
    //   145: aload 10
    //   147: ldc 57
    //   149: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: getstatic 55	com/viber/voip/messages/controller/manager/z:h	Ljava/lang/String;
    //   155: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 462
    //   161: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 9
    //   166: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 464
    //   172: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: invokestatic 283	com/viber/voip/messages/controller/manager/z:f	()Lcom/viber/provider/b;
    //   179: astore 12
    //   181: aload 10
    //   183: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 16
    //   188: iconst_2
    //   189: anewarray 288	java/lang/String
    //   192: astore 17
    //   194: aload 17
    //   196: iconst_0
    //   197: aload 5
    //   199: aastore
    //   200: aload 17
    //   202: iconst_1
    //   203: iload_3
    //   204: invokestatic 285	com/viber/voip/messages/controller/manager/z:a	(I)I
    //   207: invokestatic 294	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   210: aastore
    //   211: aload 12
    //   213: aload 16
    //   215: aload 17
    //   217: invokeinterface 299 3 0
    //   222: astore 7
    //   224: aload 7
    //   226: invokestatic 305	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   229: istore 18
    //   231: aconst_null
    //   232: astore 19
    //   234: iload 18
    //   236: ifeq +149 -> 385
    //   239: aload 7
    //   241: iconst_0
    //   242: invokeinterface 225 2 0
    //   247: lstore 20
    //   249: aload 7
    //   251: iconst_1
    //   252: invokeinterface 225 2 0
    //   257: lstore 22
    //   259: aload 7
    //   261: iconst_2
    //   262: invokeinterface 225 2 0
    //   267: lstore 24
    //   269: lconst_0
    //   270: lstore 26
    //   272: lconst_0
    //   273: lstore 28
    //   275: aconst_null
    //   276: astore 19
    //   278: iload_3
    //   279: tableswitch	default:+33 -> 312, 1:+321->600, 2:+127->406, 3:+127->406, 4:+321->600, 5:+127->406
    //   313: ldc2_w 2452
    //   316: ifle +69 -> 385
    //   319: lload 22
    //   321: lconst_0
    //   322: lcmp
    //   323: ifle +62 -> 385
    //   326: lload 22
    //   328: lload 28
    //   330: lcmp
    //   331: ifle +54 -> 385
    //   334: aload 6
    //   336: ldc_w 456
    //   339: lload 22
    //   341: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   344: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   347: lload 26
    //   349: bipush 38
    //   351: invokestatic 467	com/viber/voip/util/av:c	(JI)Z
    //   354: ifeq +31 -> 385
    //   357: aload 6
    //   359: ldc 149
    //   361: lload 26
    //   363: iconst_2
    //   364: newarray int
    //   366: dup
    //   367: iconst_0
    //   368: bipush 38
    //   370: iastore
    //   371: dup
    //   372: iconst_1
    //   373: bipush 33
    //   375: iastore
    //   376: invokestatic 469	com/viber/voip/util/av:b	(J[I)J
    //   379: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   382: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   385: aload 19
    //   387: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   390: aload 7
    //   392: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   395: goto -339 -> 56
    //   398: ldc_w 471
    //   401: astore 9
    //   403: goto -270 -> 133
    //   406: aload 12
    //   408: ldc_w 473
    //   411: iconst_1
    //   412: anewarray 288	java/lang/String
    //   415: dup
    //   416: iconst_0
    //   417: aload 5
    //   419: aastore
    //   420: invokeinterface 299 3 0
    //   425: astore 34
    //   427: aload 34
    //   429: astore 14
    //   431: aload 14
    //   433: invokestatic 305	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   436: ifeq +23 -> 459
    //   439: aload 14
    //   441: iconst_0
    //   442: invokeinterface 225 2 0
    //   447: lstore 28
    //   449: aload 14
    //   451: iconst_1
    //   452: invokeinterface 225 2 0
    //   457: lstore 26
    //   459: iconst_3
    //   460: anewarray 364	java/lang/Object
    //   463: astore 35
    //   465: aload 35
    //   467: iconst_0
    //   468: lload_1
    //   469: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   472: aastore
    //   473: aload 35
    //   475: iconst_1
    //   476: lload_1
    //   477: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   480: aastore
    //   481: aload 35
    //   483: iconst_2
    //   484: lload 24
    //   486: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   489: aastore
    //   490: aload 12
    //   492: ldc_w 475
    //   495: aload 35
    //   497: invokestatic 375	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   500: invokeinterface 446 2 0
    //   505: aload_0
    //   506: iconst_1
    //   507: aload 7
    //   509: aload 6
    //   511: ldc_w 477
    //   514: invokespecial 479	com/viber/voip/messages/controller/manager/z:a	(ZLandroid/database/Cursor;Landroid/content/ContentValues;Ljava/lang/String;)V
    //   517: aload_0
    //   518: iconst_0
    //   519: aload 7
    //   521: aload 6
    //   523: ldc_w 481
    //   526: invokespecial 479	com/viber/voip/messages/controller/manager/z:a	(ZLandroid/database/Cursor;Landroid/content/ContentValues;Ljava/lang/String;)V
    //   529: aload_0
    //   530: iconst_0
    //   531: aload 7
    //   533: aload 6
    //   535: ldc_w 483
    //   538: invokespecial 479	com/viber/voip/messages/controller/manager/z:a	(ZLandroid/database/Cursor;Landroid/content/ContentValues;Ljava/lang/String;)V
    //   541: aload_0
    //   542: iconst_0
    //   543: aload 7
    //   545: aload 6
    //   547: ldc_w 485
    //   550: invokespecial 479	com/viber/voip/messages/controller/manager/z:a	(ZLandroid/database/Cursor;Landroid/content/ContentValues;Ljava/lang/String;)V
    //   553: aload 14
    //   555: astore 19
    //   557: goto -245 -> 312
    //   560: astore 13
    //   562: aconst_null
    //   563: astore 14
    //   565: aload 13
    //   567: astore 15
    //   569: aload 14
    //   571: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   574: aload 7
    //   576: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   579: aload 15
    //   581: athrow
    //   582: astore 15
    //   584: goto -15 -> 569
    //   587: astore 33
    //   589: aload 19
    //   591: astore 14
    //   593: aload 33
    //   595: astore 15
    //   597: goto -28 -> 569
    //   600: aconst_null
    //   601: astore 14
    //   603: goto -98 -> 505
    //
    // Exception table:
    //   from	to	target	type
    //   181	231	560	finally
    //   239	269	560	finally
    //   406	427	560	finally
    //   431	459	582	finally
    //   459	505	582	finally
    //   505	553	582	finally
    //   334	385	587	finally
  }

  public void a(String paramString, boolean paramBoolean)
  {
    String str1 = "|";
    StringBuilder localStringBuilder = new StringBuilder().append("UPDATE conversations SET flags = (flags");
    if (paramBoolean);
    while (true)
    {
      String str2 = str1 + " (1 << ?)) " + "&~" + " (1 << ?) WHERE " + "conversation_type=0 AND participant_id_1 IN (SELECT _id FROM participants_info WHERE member_id=? OR number=? OR encrypted_member_id=?)";
      String[] arrayOfString = new String[5];
      arrayOfString[0] = Integer.toString(14);
      arrayOfString[1] = Integer.toString(16);
      arrayOfString[2] = paramString;
      arrayOfString[3] = paramString;
      arrayOfString[4] = paramString;
      f().a(str2, arrayOfString);
      return;
      str1 = "&~";
    }
  }

  public void a(Set<Long> paramSet)
  {
    b localb = f();
    String str = q;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a.e(paramSet);
    localb.a(String.format(str, arrayOfObject));
  }

  public void a(boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder(199);
    localStringBuilder.append("UPDATE messages SET order_key = (");
    String str1;
    if (paramBoolean)
    {
      str1 = "message_global_id";
      localStringBuilder.append("SELECT ").append(str1).append(" FROM messages AS [m] WHERE [m]._id = messages._id");
      localStringBuilder.append(")WHERE ");
      if (!paramBoolean)
        break label126;
      localStringBuilder.append("conversation_type NOT IN(0, 1) AND order_key != message_global_id AND message_global_id != 0");
    }
    while (true)
    {
      localStringBuilder.append(" AND messages.conversation_id = ?");
      b localb = f();
      String str2 = localStringBuilder.toString();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramLong);
      localb.a(str2, arrayOfString);
      return;
      str1 = "token";
      break;
      label126: localStringBuilder.append("conversation_type IN(0, 1) AND order_key != token AND token != 0");
    }
  }

  public boolean a(long paramLong, String paramString)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT COUNT() FROM messages_likes WHERE message_token=? AND participant_number=?");
    localSQLiteStatement.bindLong(1, paramLong);
    localSQLiteStatement.bindString(2, paramString);
    return localSQLiteStatement.simpleQueryForLong() > 0L;
  }

  public boolean a(LongSparseSet paramLongSparseSet)
  {
    String str = a.a(paramLongSparseSet);
    b localb = f();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Integer.valueOf(1));
    localContentValues.put("sync_read", Integer.valueOf(1));
    return localb.a("messages_likes", localContentValues, String.format("_id IN (SELECT messages_likes._id FROM messages_likes LEFT JOIN messages ON messages.token = messages_likes.message_token WHERE messages.conversation_id IN(%s) AND messages_likes.read = 0)", new Object[] { str }), null) > 0;
  }

  public int b()
  {
    return (int)aj.a("SELECT COUNT() FROM conversations WHERE flags & (1 << 33) != 0").simpleQueryForLong();
  }

  public Long b(long paramLong)
  {
    return f(paramLong, 2);
  }

  public Map<Long, Integer> b(long[] paramArrayOfLong)
  {
    Cursor localCursor = null;
    HashMap localHashMap = new HashMap(paramArrayOfLong.length, 1.0F);
    try
    {
      b localb = f();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a.a(paramArrayOfLong);
      localCursor = localb.a(String.format("SELECT DISTINCT messages.conversation_id, messages.conversation_type FROM messages WHERE messages.token IN (%s)", arrayOfObject), null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          localHashMap.put(Long.valueOf(localCursor.getLong(0)), Integer.valueOf(localCursor.getInt(1)));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localHashMap;
    }
    finally
    {
      a(localCursor);
    }
  }

  public void b(long paramLong, int paramInt)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("conversation_type", Integer.valueOf(paramInt));
    b localb = f();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    localb.a("messages", localContentValues, "conversation_id=?", arrayOfString);
  }

  public void b(long paramLong, String paramString)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("media_size", paramString);
    b localb = f();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    localb.a("conversation_auxiliary", localContentValues, "_id=?", arrayOfString);
  }

  public void b(Set<Long> paramSet)
  {
    b localb = f();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a.e(paramSet);
    localb.a(String.format("UPDATE conversations SET favourite_conversation = 0 WHERE _id IN (%s)", arrayOfObject));
  }

  public int c()
  {
    i.a();
    return (int)aj.a("SELECT COUNT(DISTINCT messages.conversation_id)  FROM messages LEFT OUTER JOIN conversations ON (messages.conversation_id=conversations._id) WHERE conversations.conversation_type NOT IN (2, 3, 5) AND conversations.flags & (1 << 18) = 0  AND (conversations.flags & (1 << 33) != 0 OR (messages.unread>0 AND messages.deleted=0 AND messages.extra_mime<>1007 AND messages.status<>12 AND messages.extra_flags&4194304=0 AND (messages.flag&131072=0 OR send_type=0) AND messages.extra_mime<>1008 ) )").simpleQueryForLong();
  }

  public Set<String> c(long[] paramArrayOfLong)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a.a(paramArrayOfLong);
    String str = String.format("(extra_mime=? OR extra_mime=?) AND token IN (%s)", arrayOfObject);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = Integer.toString(2);
    arrayOfString[1] = Integer.toString(1009);
    return i(str, arrayOfString);
  }

  public void c(long paramLong)
  {
    f().a("UPDATE messages SET extra_status = 3, extra_flags = extra_flags& ~(1 << 22) WHERE extra_status = 13 AND _id = " + paramLong);
  }

  public void c(Set<Long> paramSet)
  {
    b localb = f();
    String str = a.e(paramSet);
    localb.a("messages", String.format("conversation_id IN (%s)", new Object[] { str }), null);
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("media_size", "");
    localb.a("conversation_auxiliary", localContentValues, String.format("_id IN (%s)", new Object[] { str }), null);
  }

  public int d(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT SUM([messages].[unread]) AS unread FROM messages WHERE ([messages].conversation_type=0 OR [messages].conversation_type=1)  AND [messages].[unread] > 0  AND ([messages].[deleted] IS NULL OR [messages].[deleted]=0)  AND [messages].[extra_mime]<>1008 AND [messages].[extra_mime]<>1007 AND [messages].[conversation_id]<>? AND [messages].[extra_flags] & 4194304 = 0 AND [messages].[conversation_id] IN(SELECT _id FROM conversations WHERE flags & (1 << 18) = 0  AND conversations.mute_notification=0 AND favourite_conversation <> -1 )");
    localSQLiteStatement.bindLong(1, paramLong);
    return (int)localSQLiteStatement.simpleQueryForLong();
  }

  public void d(Set<Long> paramSet)
  {
    b localb = f();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a.e(paramSet);
    localb.a(String.format("DELETE FROM conversations WHERE conversation_type = 0 AND (conversations.flags & (1 << 24)) !=0 AND _id IN (%s)", arrayOfObject));
  }

  public boolean d()
  {
    return f().b("SELECT COUNT (*) FROM conversations, messages WHERE conversations._id = messages.conversation_id AND conversations.business_inbox_flags & (1 << 0) <> 0").simpleQueryForLong() > 0L;
  }

  public int e(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT  SUM (MAX(local_message_id, server_message_id) - last_read_message_id) FROM public_accounts LEFT JOIN conversations ON conversations.group_id = public_accounts.group_id WHERE conversations.conversation_type = 5 AND conversations.deleted=0 AND conversations.mute_notification=0 AND conversations._id<>?");
    localSQLiteStatement.bindLong(1, paramLong);
    return (int)localSQLiteStatement.simpleQueryForLong();
  }

  // ERROR //
  public List<com.viber.voip.messages.conversation.RegularConversationLoaderEntity> e()
  {
    // Byte code:
    //   0: new 32	java/lang/StringBuilder
    //   3: dup
    //   4: sipush 1150
    //   7: invokespecial 86	java/lang/StringBuilder:<init>	(I)V
    //   10: ldc 57
    //   12: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: getstatic 599	com/viber/voip/messages/conversation/RegularConversationLoaderEntity:PROJECTIONS	[Ljava/lang/String;
    //   18: invokestatic 602	com/viber/voip/s/a:d	([Ljava/lang/String;)Ljava/lang/String;
    //   21: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 604
    //   27: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 4
    //   35: invokestatic 283	com/viber/voip/messages/controller/manager/z:f	()Lcom/viber/provider/b;
    //   38: aload 4
    //   40: aconst_null
    //   41: invokeinterface 299 3 0
    //   46: astore 5
    //   48: aload 5
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic 305	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   55: istore 6
    //   57: aconst_null
    //   58: astore 7
    //   60: iload 6
    //   62: ifeq +47 -> 109
    //   65: new 400	java/util/ArrayList
    //   68: dup
    //   69: aload_2
    //   70: invokeinterface 607 1 0
    //   75: invokespecial 608	java/util/ArrayList:<init>	(I)V
    //   78: astore 7
    //   80: aload 7
    //   82: new 598	com/viber/voip/messages/conversation/RegularConversationLoaderEntity
    //   85: dup
    //   86: aload_2
    //   87: invokespecial 610	com/viber/voip/messages/conversation/RegularConversationLoaderEntity:<init>	(Landroid/database/Cursor;)V
    //   90: invokeinterface 613 2 0
    //   95: pop
    //   96: aload_2
    //   97: invokeinterface 221 1 0
    //   102: istore 9
    //   104: iload 9
    //   106: ifne -26 -> 80
    //   109: aload_2
    //   110: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   113: aload 7
    //   115: ifnonnull +8 -> 123
    //   118: invokestatic 618	java/util/Collections:emptyList	()Ljava/util/List;
    //   121: astore 7
    //   123: aload 7
    //   125: areturn
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_1
    //   130: astore_3
    //   131: aload_2
    //   132: invokestatic 314	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   135: aload_3
    //   136: athrow
    //   137: astore_3
    //   138: goto -7 -> 131
    //
    // Exception table:
    //   from	to	target	type
    //   0	48	126	finally
    //   51	57	137	finally
    //   65	80	137	finally
    //   80	104	137	finally
  }

  public void e(Set<Long> paramSet)
  {
    b localb = f();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a.e(paramSet);
    localb.a(String.format("DELETE FROM conversations WHERE conversation_type = 4 AND _id IN (%s)", arrayOfObject));
  }

  public int f(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT SUM(CASE WHEN ([conversations].group_role<>3) THEN [messages].[unread] ELSE 0 END) AS PGROUP_UNREAD_MSG_COUNT_NOT_WATCHER FROM messages LEFT OUTER JOIN [conversations] ON ([messages].[conversation_id]=[conversations].[_id]) WHERE [messages].conversation_type=2 AND (([messages].[deleted] IS NULL OR [messages].[deleted]=0) AND [messages].[extra_mime]<>1007) AND [messages].[conversation_id]<>?");
    localSQLiteStatement.bindLong(1, paramLong);
    return (int)localSQLiteStatement.simpleQueryForLong();
  }

  public Map<Long, Integer> f(Set<Long> paramSet)
  {
    Cursor localCursor = null;
    HashMap localHashMap = new HashMap(paramSet.size(), 1.0F);
    try
    {
      b localb = f();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a.e(paramSet);
      localCursor = localb.a(String.format("SELECT DISTINCT messages.conversation_id, messages.conversation_type FROM messages WHERE messages._id IN (%s)", arrayOfObject), null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          localHashMap.put(Long.valueOf(localCursor.getLong(0)), Integer.valueOf(localCursor.getInt(1)));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localHashMap;
    }
    finally
    {
      a(localCursor);
    }
  }

  public int g(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT COUNT() FROM messages_likes WHERE message_token=?");
    localSQLiteStatement.bindLong(1, paramLong);
    return (int)localSQLiteStatement.simpleQueryForLong();
  }

  public Set<String> g(Set<Long> paramSet)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a.e(paramSet);
    String str = String.format("(extra_mime=? OR extra_mime=?) AND _id IN (%s)", arrayOfObject);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = Integer.toString(2);
    arrayOfString[1] = Integer.toString(1009);
    return i(str, arrayOfString);
  }

  // ERROR //
  public long h(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 452	com/viber/common/d/i:a	()Lcom/viber/common/d/i;
    //   3: pop
    //   4: lconst_0
    //   5: lstore 4
    //   7: invokestatic 283	com/viber/voip/messages/controller/manager/z:f	()Lcom/viber/provider/b;
    //   10: astore 8
    //   12: iconst_1
    //   13: anewarray 288	java/lang/String
    //   16: astore 9
    //   18: aload 9
    //   20: iconst_0
    //   21: lload_1
    //   22: invokestatic 291	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   25: aastore
    //   26: aload 8
    //   28: ldc_w 634
    //   31: aload 9
    //   33: invokeinterface 299 3 0
    //   38: astore 10
    //   40: aload 10
    //   42: invokestatic 305	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   45: ifeq +17 -> 62
    //   48: aload 10
    //   50: iconst_0
    //   51: invokeinterface 225 2 0
    //   56: lstore 11
    //   58: lload 11
    //   60: lstore 4
    //   62: aload_0
    //   63: aload 10
    //   65: invokevirtual 338	com/viber/voip/messages/controller/manager/z:a	(Landroid/database/Cursor;)V
    //   68: lload 4
    //   70: lreturn
    //   71: astore 6
    //   73: aconst_null
    //   74: astore 7
    //   76: aload_0
    //   77: aload 7
    //   79: invokevirtual 338	com/viber/voip/messages/controller/manager/z:a	(Landroid/database/Cursor;)V
    //   82: aload 6
    //   84: athrow
    //   85: astore 6
    //   87: aload 10
    //   89: astore 7
    //   91: goto -15 -> 76
    //
    // Exception table:
    //   from	to	target	type
    //   7	40	71	finally
    //   40	58	85	finally
  }

  public long i(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT COUNT (*) FROM messages WHERE deleted=0 AND conversation_id=? AND send_type=1 AND status NOT IN (1,2,-1,12)");
    localSQLiteStatement.bindLong(1, paramLong);
    return localSQLiteStatement.simpleQueryForLong();
  }

  public long j(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT COUNT (*) FROM messages WHERE broadcast_msg_id>0 AND broadcast_msg_id=? AND deleted<>1 AND extra_mime<>1008 AND send_type=1 AND status NOT IN (1,2,-1,3)");
    localSQLiteStatement.bindLong(1, paramLong);
    return localSQLiteStatement.simpleQueryForLong();
  }

  public boolean k(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = aj.a("SELECT COUNT(participants.participant_info_id) FROM participants, participants_info WHERE participants.participant_info_id = participants_info._id AND participants.group_role = 2 AND participants_info.contact_id > 0 AND participants.conversation_id= ? LIMIT 1");
    localSQLiteStatement.bindLong(1, paramLong);
    return localSQLiteStatement.simpleQueryForLong() != 0L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.z
 * JD-Core Version:    0.6.2
 */