package com.viber.voip.notif.h;

import android.database.Cursor;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.CircularArray;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.manager.aa;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.orm.entity.impl.LikeEntityHelper;
import com.viber.voip.messages.orm.entity.impl.MessageEntityHelper;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.j;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.SparseSet;
import com.viber.voip.util.af;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.sqlite.database.sqlite.SQLiteException;

public class l extends aa
{
  private static final String A;
  private static final String B;
  private static final String C;
  private static final String D;
  private static final String E;
  private static final String F;
  private static final String G;
  private static final String H = a(arrayOfString);
  private static final Logger g = ViberEnv.getLogger();
  private static final String h = "(messages.extra_flags & " + av.a(0, new int[] { 22 }) + ")";
  private static final String i = "(extra_flags & " + av.a(0, new int[] { 4 }) + ")=0";
  private static final String j = "(messages.extra_flags & " + av.a(0L, 34) + ")";
  private static final String k = "(conversations.mute_notification=0 OR " + j + "!=0)";
  private static final String l = "(conversations.flags & " + av.a(0L, new int[] { 18 }) + ")=0";
  private static final long m = av.a(0L, new int[] { 15, 24 });
  private static final String n = "(conversations.business_inbox_flags & " + av.a(0L, 0) + "=0 OR " + "conversations.business_inbox_flags" + " & " + av.a(0L, 1) + ">0 OR " + "conversations" + "." + "flags" + "&" + av.a(0L, 13) + "<>0)";
  private static final String o = "(conversations.flags & " + m + ")";
  private static final String p = "messages.unread>0 AND (messages.extra_flags & 8589934592)=0 AND " + h + "=0";
  private static final String q = p + " AND ((" + "messages.extra_mime=1000" + " AND " + i + ") OR " + j + "!=0 OR " + "(messages.extra_flags & (1 << 36))" + "!=0 OR " + " (messages.flag & 1)!=0 " + ") AND " + " (messages.flag & 8)=0 " + " AND " + k + " AND " + "messages.deleted=0 AND messages.extra_mime<>1007 AND messages.status<>12 AND messages.extra_flags&4194304=0 AND (messages.flag&131072=0 OR send_type=0) AND messages.extra_mime<>1008" + " AND " + o + "=0";
  private static final String r = "messages.extra_mime=1002 AND messages.unread>0 AND (messages.extra_flags & 8589934592)=0 AND messages.send_type=0 AND " + k + " AND " + l;
  private static final String s = "messages.extra_mime <>1000 AND messages.extra_mime <>1008 AND messages.extra_mime <>1007 AND (messages.extra_flags & 16) = 0 AND (messages.extra_flags & 256) = 0 AND (messages.flag & 1) = 0 AND messages.extra_mime<>1002 AND " + p + " AND " + "(messages.conversation_type <> 5)" + " AND " + "messages.send_type=0" + " AND " + k + " AND " + l + " AND " + o + "=0 AND " + j + "=0 AND " + "(messages.extra_flags & (1 << 36))" + "=0 AND " + i + " AND " + n;
  private static final String t = "messages.extra_mime<>1002 AND " + p + " AND " + "(messages.conversation_type <> 5)" + " AND " + "messages.send_type=0" + " AND " + k + " AND " + l + " AND " + o + ">0";
  private static final String u = "messages_likes.read=0 AND messages.send_type=1 AND " + k + " AND " + l + " AND " + o + "=0 AND " + h + "=0 AND " + "messages.extra_mime" + "<>" + 1007;
  private static final String v = "messages_likes.read=0 AND messages.send_type=1 AND " + k + " AND " + l + " AND " + o + ">0";
  private static final String w = "messages_likes.read=0 AND messages.send_type=1 AND " + k + " AND " + l + " AND " + o + "=0 AND " + "(messages.extra_flags & (1 << 39))" + ">0";
  private static final String x = com.viber.voip.s.a.a("messages", MessageEntityHelper.PROJECTIONS);
  private static final String y = "SUM(messages_likes.read=0), IFNULL(GROUP_CONCAT(conversations._id), ''), IFNULL(GROUP_CONCAT(conversations.name), ''), messages.token, messages.order_key, messages.conversation_id, " + com.viber.voip.s.a.a("messages_likes", LikeEntityHelper.PROJECTIONS);
  private static final String z = "'fake message body', 'fake message info', " + y;
  private final SparseSet I = new SparseSet(4);
  private final SparseSet J = new SparseSet(4);
  private final com.viber.voip.flatbuffers.b.a<MsgInfo> K;

  static
  {
    A = "messages.body, messages.msg_info, " + y;
    B = "SELECT 1 as itemType, (? & 0), " + x + " FROM " + "messages" + " LEFT OUTER JOIN " + "conversations" + " ON (" + "messages.conversation_id" + "=" + "conversations._id" + ") WHERE %s";
    C = " SELECT 2 as itemType, (? & 0), " + x + " FROM " + "messages" + " LEFT OUTER JOIN " + "conversations" + " ON (" + "messages.conversation_id" + "=" + "conversations._id" + ") WHERE %s";
    D = " SELECT 3 as itemType, (CASE WHEN ((conversations.smart_notification=1 AND conversations.smart_event_date>0 AND conversations.smart_event_date>?)) THEN 1 ELSE 0 END), " + x + " FROM " + "messages" + " LEFT OUTER JOIN " + "conversations" + " ON (" + "messages.conversation_id" + "=" + "conversations._id" + ") WHERE %s";
    E = " SELECT 4 as itemType, (CASE WHEN ((conversations.smart_notification=1 AND conversations.smart_event_date>0 AND conversations.smart_event_date>?)) THEN 1 ELSE 0 END), " + x + " FROM " + "messages" + " LEFT OUTER JOIN " + "conversations" + " ON (" + "messages.conversation_id" + "=" + "conversations._id" + ") WHERE %s";
    F = "SELECT 3,(CASE WHEN ((conversations.smart_notification=1 AND conversations.smart_event_date>0 AND conversations.smart_event_date>?)) THEN 1 ELSE 0 END), " + z + " FROM " + "messages_likes LEFT OUTER JOIN messages ON (messages_likes.message_token=messages.token) LEFT OUTER JOIN conversations ON (messages.conversation_id=conversations._id)" + " WHERE " + u + " UNION ALL  SELECT " + 4 + ", " + "(CASE WHEN ((conversations.smart_notification=1 AND conversations.smart_event_date>0 AND conversations.smart_event_date>?)) THEN 1 ELSE 0 END)" + ", " + z + " FROM " + "messages_likes LEFT OUTER JOIN messages ON (messages_likes.message_token=messages.token) LEFT OUTER JOIN conversations ON (messages.conversation_id=conversations._id)" + " WHERE " + v + " UNION ALL  SELECT " + 5 + ", " + "(CASE WHEN ((conversations.smart_notification=1 AND conversations.smart_event_date>0 AND conversations.smart_event_date>?)) THEN 1 ELSE 0 END)" + ", " + A + " FROM " + "messages_likes LEFT OUTER JOIN messages ON (messages_likes.message_token=messages.token) LEFT OUTER JOIN conversations ON (messages.conversation_id=conversations._id)" + " WHERE " + w + " ORDER BY " + "messages_likes.date DESC";
    G = "SELECT " + com.viber.voip.s.a.d(d.a) + " FROM " + "public_accounts" + " LEFT OUTER JOIN " + "conversations" + " ON (" + "public_accounts.group_id" + "=" + "conversations.group_id" + ") LEFT OUTER JOIN " + "messages" + " ON (" + "messages.conversation_id" + "=" + "conversations._id" + " AND " + "messages.message_global_id" + "=" + "local_message_id" + ") WHERE " + "unreadMsgCount > 0 AND unreadMsgId > canceled_message_id AND conversations.conversation_type=5 AND conversations.mute_notification=0";
    String[] arrayOfString = new String[4];
    arrayOfString[0] = b(1, null);
    arrayOfString[1] = b(2, null);
    arrayOfString[2] = b(3, null);
    arrayOfString[3] = b(4, null);
  }

  public l(com.viber.voip.flatbuffers.b.a<MsgInfo> parama)
  {
    this.K = parama;
    this.I.addAll(new int[] { 1, 2, 3, 4 });
    this.J.addAll(new int[] { 2, 3, 4 });
  }

  private LongSparseArray<n> a(LongSparseSet paramLongSparseSet)
  {
    if (paramLongSparseSet.size() == 0)
      return new LongSparseArray(0);
    return k("group_id IN(" + com.viber.voip.s.a.a(paramLongSparseSet) + ")", null);
  }

  private LongSparseArray<com.viber.voip.model.entity.h> a(LongSparseSet paramLongSparseSet, ab paramab)
  {
    List localList = paramab.a(paramLongSparseSet);
    LongSparseArray localLongSparseArray = new LongSparseArray(localList.size());
    int i1 = localList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      com.viber.voip.model.entity.h localh = (com.viber.voip.model.entity.h)localList.get(i2);
      localLongSparseArray.put(localh.getId(), localh);
    }
    return localLongSparseArray;
  }

  private LongSparseArray<com.viber.voip.model.entity.m> a(LongSparseSet paramLongSparseSet, ak paramak, al paramal)
  {
    int i1 = 0;
    List localList1 = paramal.a(paramLongSparseSet);
    ArraySet localArraySet = new ArraySet(localList1.size());
    int i2 = localList1.size();
    for (int i3 = 0; i3 < i2; i3++)
      localArraySet.add(Long.valueOf(((com.viber.voip.model.entity.l)localList1.get(i3)).a()));
    List localList2 = paramak.c(localArraySet);
    LongSparseArray localLongSparseArray1 = new LongSparseArray(localList2.size());
    int i4 = localList2.size();
    for (int i5 = 0; i5 < i4; i5++)
    {
      com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localList2.get(i5);
      localLongSparseArray1.put(localm.getId(), localm);
    }
    LongSparseArray localLongSparseArray2 = new LongSparseArray(localList2.size());
    int i6 = localList1.size();
    while (i1 < i6)
    {
      com.viber.voip.model.entity.l locall = (com.viber.voip.model.entity.l)localList1.get(i1);
      localLongSparseArray2.put(locall.getId(), localLongSparseArray1.get(locall.a()));
      i1++;
    }
    return localLongSparseArray2;
  }

  private static String a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramArrayOfString.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      String str = paramArrayOfString[i2];
      if ((localStringBuilder.length() > 0) && (!da.a(str)))
        localStringBuilder.append(" UNION ALL ");
      localStringBuilder.append(str);
    }
    if (localStringBuilder.length() > 0)
      localStringBuilder.append(" ORDER BY ").append("itemType, messages.token DESC, messages.msg_date DESC");
    return localStringBuilder.toString();
  }

  private List<i> a(String paramString, SparseSet paramSparseSet)
  {
    String str1 = String.valueOf(System.currentTimeMillis() - 300000L);
    if (((paramSparseSet.size() == 0) || (paramSparseSet.size() == 4)) && (paramString == null))
      return i(H, new String[] { str1, str1, str1, str1 });
    String[] arrayOfString1 = new String[paramSparseSet.size()];
    String[] arrayOfString2 = new String[paramSparseSet.size()];
    int i1 = paramSparseSet.size();
    int i2 = 0;
    if (i2 < i1)
    {
      int i3 = paramSparseSet.get(i2);
      if (this.J.contains(i3));
      for (String str2 = null; ; str2 = paramString)
      {
        arrayOfString1[i2] = b(i3, str2);
        arrayOfString2[i2] = str1;
        i2++;
        break;
      }
    }
    return i(a(arrayOfString1), arrayOfString2);
  }

  private Map<String, com.viber.voip.model.entity.m> a(Set<String> paramSet1, Set<String> paramSet2, ak paramak)
  {
    List localList = paramak.a(paramSet1, paramSet2);
    ArrayMap localArrayMap = new ArrayMap(localList.size());
    int i1 = localList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localList.get(i2);
      localArrayMap.put(localm.a(), localm);
      localArrayMap.put(localm.b(), localm);
    }
    return localArrayMap;
  }

  private LongSparseArray<n> b(Collection<String> paramCollection)
  {
    if (paramCollection.size() == 0)
      return new LongSparseArray(0);
    return k("public_account_id IN(" + com.viber.voip.s.a.b(paramCollection) + ")", null);
  }

  private static String b(int paramInt, String paramString)
  {
    String str1 = "";
    if (!da.a(paramString))
      str1 = " AND " + paramString;
    switch (paramInt)
    {
    default:
      return "";
    case 1:
      String str5 = B;
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = (q + str1);
      return String.format(str5, arrayOfObject4);
    case 2:
      String str4 = C;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = (r + str1);
      return String.format(str4, arrayOfObject3);
    case 3:
      String str3 = D;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = (s + str1);
      return String.format(str3, arrayOfObject2);
    case 4:
    }
    String str2 = E;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = (t + str1);
    return String.format(str2, arrayOfObject1);
  }

  private static Set<String> b(String[] paramArrayOfString)
  {
    ArraySet localArraySet = new ArraySet(paramArrayOfString.length);
    localArraySet.addAll(Arrays.asList(paramArrayOfString));
    return localArraySet;
  }

  private List<i> i(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    Object localObject1 = Collections.emptyList();
    try
    {
      localCursor = f().a(paramString, paramArrayOfString);
      int i1;
      if (af.c(localCursor))
      {
        localObject1 = new ArrayList(localCursor.getCount());
        i1 = localCursor.getInt(0);
        if (localCursor.getInt(1) <= 0)
          break label128;
      }
      label128: for (boolean bool1 = true; ; bool1 = false)
      {
        MessageEntity localMessageEntity = MessageEntityHelper.createEntity(new MessageEntity(), localCursor, 2);
        if (localMessageEntity.getId() > 0L)
          ((List)localObject1).add(new i(localMessageEntity, i1, bool1));
        boolean bool2 = localCursor.moveToNext();
        if (bool2)
          break;
        return localObject1;
      }
    }
    finally
    {
      a(localCursor);
    }
  }

  private Cursor j(String paramString, String[] paramArrayOfString)
  {
    return f().a("public_accounts", new String[] { "group_id", "group_uri", "verified" }, paramString, paramArrayOfString, null, null, null, null);
  }

  private LongSparseArray<n> k(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    LongSparseArray localLongSparseArray = new LongSparseArray();
    try
    {
      localCursor = j(paramString, paramArrayOfString);
      if (af.c(localCursor))
      {
        boolean bool;
        do
        {
          long l1 = localCursor.getLong(0);
          localLongSparseArray.put(l1, new n(l1, localCursor.getString(1), localCursor.getInt(2)));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localLongSparseArray;
    }
    finally
    {
      a(localCursor);
    }
  }

  h a(List<a> paramList, dagger.a<ab> parama, dagger.a<ak> parama1)
  {
    if (paramList.isEmpty())
      return new h(0);
    int i1 = paramList.size();
    ArraySet localArraySet = new ArraySet(i1);
    LongSparseSet localLongSparseSet = new LongSparseSet(i1);
    for (int i2 = 0; i2 < i1; i2++)
    {
      a locala2 = (a)paramList.get(i2);
      localArraySet.add(locala2.a().d());
      localLongSparseSet.add(locala2.j());
    }
    Map localMap = a(localArraySet, localArraySet, (ak)parama1.get());
    LongSparseArray localLongSparseArray = a(localLongSparseSet, (ab)parama.get());
    h localh = new h(i1);
    int i3 = 0;
    if (i3 < i1)
    {
      a locala1 = (a)paramList.get(i3);
      com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localMap.get(locala1.a().d());
      if (localm == null);
      while (true)
      {
        i3++;
        break;
        com.viber.voip.model.entity.h localh1 = (com.viber.voip.model.entity.h)localLongSparseArray.get(locala1.j());
        if (localh1 != null)
          localh.a(new g(locala1, localm, localh1));
      }
    }
    return localh;
  }

  k a(List<i> paramList, dagger.a<ab> parama, dagger.a<ak> parama1, dagger.a<al> parama2)
  {
    if (paramList.size() == 0)
      return new k(0);
    LongSparseSet localLongSparseSet1 = new LongSparseSet(paramList.size());
    ArraySet localArraySet = new ArraySet();
    LongSparseSet localLongSparseSet2 = new LongSparseSet(paramList.size());
    LongSparseSet localLongSparseSet3 = new LongSparseSet(paramList.size());
    int i1 = paramList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      MessageEntity localMessageEntity2 = ((i)paramList.get(i2)).a();
      localLongSparseSet1.add(localMessageEntity2.getParticipantId());
      localLongSparseSet2.add(localMessageEntity2.getConversationId());
      if (localMessageEntity2.isPublicGroupBehavior())
        localLongSparseSet3.add(localMessageEntity2.getGroupId());
      if (localMessageEntity2.isPublicAccount())
        localArraySet.add(localMessageEntity2.getMemberId());
    }
    LongSparseArray localLongSparseArray1 = a(localLongSparseSet1, (ak)parama1.get(), (al)parama2.get());
    LongSparseArray localLongSparseArray2 = a(localLongSparseSet2, (ab)parama.get());
    LongSparseArray localLongSparseArray3 = a(localLongSparseSet3);
    if (!localArraySet.isEmpty())
    {
      LongSparseArray localLongSparseArray4 = b(localArraySet);
      int i5 = localLongSparseArray4.size();
      for (int i6 = 0; i6 < i5; i6++)
      {
        n localn2 = (n)localLongSparseArray4.valueAt(i6);
        localLongSparseArray3.put(localn2.a(), localn2);
      }
    }
    k localk = new k(paramList.size());
    int i3 = paramList.size();
    int i4 = 0;
    if (i4 < i3)
    {
      i locali = (i)paramList.get(i4);
      MessageEntity localMessageEntity1 = locali.a();
      com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localLongSparseArray1.get(localMessageEntity1.getParticipantId());
      if (localm == null);
      com.viber.voip.model.entity.h localh;
      do
      {
        i4++;
        break;
        localh = (com.viber.voip.model.entity.h)localLongSparseArray2.get(localMessageEntity1.getConversationId());
      }
      while (localh == null);
      n localn1 = (n)localLongSparseArray3.get(localh.k());
      boolean bool1;
      label440: boolean bool2;
      o localo;
      if ((localk.a.size() == 0) || (((m)localk.a.getFirst()).i() != locali.b()))
      {
        bool1 = true;
        bool2 = this.J.contains(locali.b());
        localo = new o(locali, localm, localh, localn1);
        if (i4 != i3 - 1)
          break label505;
      }
      label505: for (boolean bool3 = true; ; bool3 = false)
      {
        localk.a(localo, bool2, bool1, bool3);
        break;
        bool1 = false;
        break label440;
      }
    }
    return localk;
  }

  // ERROR //
  List<a> a()
  {
    // Byte code:
    //   0: invokestatic 423	java/lang/System:currentTimeMillis	()J
    //   3: ldc2_w 424
    //   6: lsub
    //   7: invokestatic 428	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: invokestatic 488	java/util/Collections:emptyList	()Ljava/util/List;
    //   16: astore_3
    //   17: invokestatic 492	com/viber/voip/notif/h/l:f	()Lcom/viber/provider/b;
    //   20: getstatic 273	com/viber/voip/notif/h/l:F	Ljava/lang/String;
    //   23: iconst_3
    //   24: anewarray 303	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: aload_1
    //   34: aastore
    //   35: dup
    //   36: iconst_2
    //   37: aload_1
    //   38: aastore
    //   39: invokeinterface 497 3 0
    //   44: astore 5
    //   46: aload 5
    //   48: invokestatic 502	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   51: ifeq +236 -> 287
    //   54: new 504	java/util/ArrayList
    //   57: dup
    //   58: aload 5
    //   60: invokeinterface 509 1 0
    //   65: invokespecial 510	java/util/ArrayList:<init>	(I)V
    //   68: astore 6
    //   70: aload 5
    //   72: iconst_0
    //   73: invokeinterface 513 2 0
    //   78: istore 7
    //   80: aload 5
    //   82: iconst_1
    //   83: invokeinterface 513 2 0
    //   88: ifle +206 -> 294
    //   91: iconst_1
    //   92: istore 8
    //   94: aload 5
    //   96: iconst_4
    //   97: invokeinterface 513 2 0
    //   102: istore 9
    //   104: iload 9
    //   106: ifle +164 -> 270
    //   109: aload 5
    //   111: iconst_5
    //   112: invokeinterface 556 2 0
    //   117: ldc_w 666
    //   120: invokevirtual 670	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   123: invokestatic 674	com/viber/voip/util/LongSparseSet:from	([Ljava/lang/String;)Lcom/viber/voip/util/LongSparseSet;
    //   126: astore 10
    //   128: aload 5
    //   130: bipush 6
    //   132: invokeinterface 556 2 0
    //   137: ldc_w 666
    //   140: invokevirtual 670	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   143: invokestatic 676	com/viber/voip/notif/h/l:b	([Ljava/lang/String;)Ljava/util/Set;
    //   146: astore 11
    //   148: aload 5
    //   150: bipush 7
    //   152: invokeinterface 550 2 0
    //   157: lstore 12
    //   159: aload 5
    //   161: bipush 8
    //   163: invokeinterface 550 2 0
    //   168: lstore 14
    //   170: aload 5
    //   172: bipush 9
    //   174: invokeinterface 550 2 0
    //   179: lstore 16
    //   181: iload 7
    //   183: iconst_5
    //   184: if_icmpne +116 -> 300
    //   187: aload_0
    //   188: getfield 324	com/viber/voip/notif/h/l:K	Lcom/viber/voip/flatbuffers/b/a;
    //   191: aload 5
    //   193: iconst_3
    //   194: invokeinterface 556 2 0
    //   199: invokeinterface 681 2 0
    //   204: checkcast 683	com/viber/voip/flatbuffers/model/msginfo/MsgInfo
    //   207: invokevirtual 687	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:getPoll	()Lcom/viber/voip/flatbuffers/model/msginfo/Poll;
    //   210: invokevirtual 693	com/viber/voip/flatbuffers/model/msginfo/Poll:getParentToken	()Lcom/viber/voip/flatbuffers/model/util/UnsignedLong;
    //   213: invokevirtual 697	com/viber/voip/flatbuffers/model/util/UnsignedLong:get	()J
    //   216: lstore 18
    //   218: aload 5
    //   220: iconst_2
    //   221: invokeinterface 556 2 0
    //   226: astore 20
    //   228: aload 6
    //   230: new 569	com/viber/voip/notif/h/a
    //   233: dup
    //   234: aload 5
    //   236: bipush 10
    //   238: invokestatic 700	com/viber/voip/messages/orm/entity/impl/LikeEntityHelper:createEntity	(Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/j;
    //   241: iload 7
    //   243: aload 10
    //   245: aload 11
    //   247: iload 9
    //   249: iload 8
    //   251: lload 12
    //   253: lload 18
    //   255: aload 20
    //   257: lload 14
    //   259: lload 16
    //   261: invokespecial 703	com/viber/voip/notif/h/a:<init>	(Lcom/viber/voip/model/entity/j;ILcom/viber/voip/util/LongSparseSet;Ljava/util/Set;IZJJLjava/lang/String;JJ)V
    //   264: invokeinterface 527 2 0
    //   269: pop
    //   270: aload 5
    //   272: invokeinterface 531 1 0
    //   277: istore 22
    //   279: iload 22
    //   281: ifne -211 -> 70
    //   284: aload 6
    //   286: astore_3
    //   287: aload 5
    //   289: invokestatic 704	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   292: aload_3
    //   293: areturn
    //   294: iconst_0
    //   295: istore 8
    //   297: goto -203 -> 94
    //   300: aload 5
    //   302: bipush 11
    //   304: invokeinterface 550 2 0
    //   309: lstore 23
    //   311: lload 23
    //   313: lstore 18
    //   315: aconst_null
    //   316: astore 20
    //   318: goto -90 -> 228
    //   321: astore 4
    //   323: aload_2
    //   324: invokestatic 704	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   327: aload 4
    //   329: athrow
    //   330: astore 4
    //   332: aload 5
    //   334: astore_2
    //   335: goto -12 -> 323
    //
    // Exception table:
    //   from	to	target	type
    //   17	46	321	finally
    //   46	70	330	finally
    //   70	91	330	finally
    //   94	104	330	finally
    //   109	181	330	finally
    //   187	228	330	finally
    //   228	270	330	finally
    //   270	279	330	finally
    //   300	311	330	finally
  }

  List<i> a(LongSparseSet paramLongSparseSet, SparseSet paramSparseSet)
  {
    if (paramLongSparseSet.size() == 0);
    Object[] arrayOfObject;
    for (String str = null; ; str = String.format("messages.conversation_id IN (%s)", arrayOfObject))
    {
      return a(str, paramSparseSet);
      arrayOfObject = new Object[1];
      arrayOfObject[0] = com.viber.voip.s.a.a(paramLongSparseSet);
    }
  }

  List<i> a(List<MessageEntity> paramList)
  {
    if (paramList.size() == 0)
      return Collections.emptyList();
    int i1 = paramList.size();
    ArrayList localArrayList = new ArrayList(i1);
    for (int i2 = 0; i2 < i1; i2++)
      localArrayList.add(new i((MessageEntity)paramList.get(i2), 3, false));
    return localArrayList;
  }

  List<i> b()
  {
    return a(null, this.I);
  }

  List<d> c()
  {
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      String str = String.valueOf(System.currentTimeMillis() - 300000L);
      localCursor = f().a(G, new String[] { str });
      if (af.c(localCursor))
      {
        boolean bool;
        do
        {
          d locald = new d(localCursor, this.K);
          if ((locald.a() > 0L) && (!da.a(locald.d())) && (!locald.v()) && (!locald.u()))
            localArrayList.add(locald);
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localArrayList;
    }
    catch (SQLiteException localSQLiteException)
    {
      g.a(localSQLiteException, "communities notification exception");
      return localArrayList;
    }
    finally
    {
      a(localCursor);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.l
 * JD-Core Version:    0.6.2
 */