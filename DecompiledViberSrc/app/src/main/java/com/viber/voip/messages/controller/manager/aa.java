package com.viber.voip.messages.controller.manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.entity.impl.MessageEntityHelper;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.s.a;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.af;
import com.viber.voip.util.av;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.sqlite.database.SQLException;

public abstract class aa
{
  protected static final Logger a = ViberEnv.getLogger();
  public static final String b = "messages.conversation_id=conversations._id AND (messages.extra_flags & " + av.a(0L, 32) + ") <> 0 AND (" + "messages" + "." + "token" + ">0 AND (" + "messages" + "." + "status" + "=" + 1 + " OR " + "messages" + "." + "status" + "=" + 2 + "))";
  public static final String c = "(messages.extra_flags & " + av.a(0L, 32) + ") = 0";
  public static final String d = "(messages.extra_flags & " + av.a(0L, 22) + ") = 0";
  public static final String e = "(SELECT msg_info FROM messages WHERE " + b + " ORDER BY " + "messages.order_key DESC, messages.msg_date DESC" + " LIMIT 1)";
  public static final String f = "(SELECT last_pin_msg_info FROM (SELECT msg_info AS last_pin_msg_info, extra_flags AS last_pin_extra_flags FROM messages WHERE " + b + " ORDER BY " + "messages.order_key DESC, messages.msg_date DESC" + " LIMIT 1) WHERE (" + "last_pin_extra_flags" + " & " + 2199023255552L + ") = 0)";

  private void a(String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Can't update entity, table is null");
    if (paramString2 == null)
      throw new IllegalArgumentException("Can't update entity, column is null");
    if (paramLong <= 0L)
      throw new IllegalArgumentException("Can't update entity, invalid entity id=" + paramLong);
  }

  public static com.viber.provider.b f()
  {
    return d.a(ViberApplication.getApplication());
  }

  public int a(long paramLong, String paramString, ContentValues paramContentValues)
  {
    try
    {
      com.viber.provider.b localb = f();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramLong);
      int i = localb.a(paramString, paramContentValues, "_id=?", arrayOfString);
      return i;
    }
    catch (SQLException localSQLException)
    {
    }
    return 0;
  }

  protected long a(String paramString, ContentValues paramContentValues)
  {
    try
    {
      long l = f().b(paramString, null, paramContentValues);
      return l;
    }
    catch (SQLException localSQLException)
    {
    }
    return -1L;
  }

  protected List<MessageEntity> a(String paramString, String[] paramArrayOfString)
  {
    return a(paramString, paramArrayOfString, null);
  }

  protected List<MessageEntity> a(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return a(paramString1, paramArrayOfString, paramString2, null);
  }

  protected List<MessageEntity> a(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    return a(paramString1, paramArrayOfString, paramString2, null, paramString3);
  }

  // ERROR //
  protected List<MessageEntity> a(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   3: ldc 45
    //   5: getstatic 165	com/viber/voip/messages/orm/entity/impl/MessageEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   8: aload_1
    //   9: aload_2
    //   10: aload 4
    //   12: aconst_null
    //   13: aload_3
    //   14: aload 5
    //   16: invokeinterface 168 9 0
    //   21: astore 8
    //   23: aload 8
    //   25: astore 7
    //   27: aload 7
    //   29: ifnull +107 -> 136
    //   32: aload 7
    //   34: invokeinterface 174 1 0
    //   39: ifeq +97 -> 136
    //   42: new 176	java/util/ArrayList
    //   45: dup
    //   46: aload 7
    //   48: invokeinterface 180 1 0
    //   53: invokespecial 183	java/util/ArrayList:<init>	(I)V
    //   56: astore 9
    //   58: aload 9
    //   60: new 185	com/viber/voip/model/entity/MessageEntity
    //   63: dup
    //   64: invokespecial 186	com/viber/voip/model/entity/MessageEntity:<init>	()V
    //   67: aload 7
    //   69: iconst_0
    //   70: invokestatic 190	com/viber/voip/messages/orm/entity/impl/MessageEntityHelper:createEntity	(Lcom/viber/voip/model/entity/MessageEntity;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/MessageEntity;
    //   73: invokeinterface 196 2 0
    //   78: pop
    //   79: aload 7
    //   81: invokeinterface 199 1 0
    //   86: istore 11
    //   88: iload 11
    //   90: ifne -32 -> 58
    //   93: aload_0
    //   94: aload 7
    //   96: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   99: aload 9
    //   101: ifnonnull +13 -> 114
    //   104: new 176	java/util/ArrayList
    //   107: dup
    //   108: iconst_0
    //   109: invokespecial 183	java/util/ArrayList:<init>	(I)V
    //   112: astore 9
    //   114: aload 9
    //   116: areturn
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 7
    //   122: aload_0
    //   123: aload 7
    //   125: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   128: aload 6
    //   130: athrow
    //   131: astore 6
    //   133: goto -11 -> 122
    //   136: aconst_null
    //   137: astore 9
    //   139: goto -46 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   0	23	117	finally
    //   32	58	131	finally
    //   58	88	131	finally
  }

  public List<h> a(Collection<String> paramCollection)
  {
    String str = a.b(paramCollection);
    return e(String.format("conversation_type=0 AND participant_id_1=(SELECT _id FROM participants_info WHERE (member_id IN(%s) OR encrypted_member_id IN (%s)) AND participant_type=1)", new Object[] { str, str }), null);
  }

  // ERROR //
  public Set<Long> a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   3: aload_2
    //   4: aconst_null
    //   5: invokeinterface 220 3 0
    //   10: astore 6
    //   12: aload 6
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 7
    //   19: aload 4
    //   21: ifnull +69 -> 90
    //   24: aload 4
    //   26: invokeinterface 174 1 0
    //   31: istore 8
    //   33: aconst_null
    //   34: astore 7
    //   36: iload 8
    //   38: ifeq +52 -> 90
    //   41: new 222	java/util/HashSet
    //   44: dup
    //   45: aload 4
    //   47: invokeinterface 180 1 0
    //   52: invokespecial 223	java/util/HashSet:<init>	(I)V
    //   55: astore 7
    //   57: aload 7
    //   59: aload 4
    //   61: iload_1
    //   62: invokeinterface 227 2 0
    //   67: invokestatic 232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: invokeinterface 235 2 0
    //   75: pop
    //   76: aload 4
    //   78: invokeinterface 199 1 0
    //   83: istore 10
    //   85: iload 10
    //   87: ifne -30 -> 57
    //   90: aload_0
    //   91: aload 4
    //   93: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   96: aload 7
    //   98: ifnonnull +13 -> 111
    //   101: new 222	java/util/HashSet
    //   104: dup
    //   105: iconst_0
    //   106: invokespecial 223	java/util/HashSet:<init>	(I)V
    //   109: astore 7
    //   111: aload 7
    //   113: areturn
    //   114: astore_3
    //   115: aconst_null
    //   116: astore 4
    //   118: aload_3
    //   119: astore 5
    //   121: aload_0
    //   122: aload 4
    //   124: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   127: aload 5
    //   129: athrow
    //   130: astore 5
    //   132: goto -11 -> 121
    //
    // Exception table:
    //   from	to	target	type
    //   0	12	114	finally
    //   24	33	130	finally
    //   41	57	130	finally
    //   57	85	130	finally
  }

  protected void a(Cursor paramCursor)
  {
    af.a(paramCursor);
  }

  public void a(Runnable paramRunnable)
  {
    af.a(f(), paramRunnable);
  }

  protected void a(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean)
  {
    a(paramString1, paramString2, "_id", paramLong, paramInt, paramBoolean);
  }

  protected void a(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder("UPDATE %s SET %s = %s & (~%s) | %s");
    if (!TextUtils.isEmpty(paramString3))
      localStringBuilder.append(" WHERE ").append(paramString3);
    Locale localLocale = Locale.US;
    String str1 = localStringBuilder.toString();
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = paramString2;
    arrayOfObject[3] = Long.valueOf(paramLong2);
    arrayOfObject[4] = Long.valueOf(paramLong1);
    String str2 = String.format(localLocale, str1, arrayOfObject);
    if (paramArrayOfString != null)
    {
      f().a(str2, paramArrayOfString);
      return;
    }
    f().a(str2);
  }

  protected void a(String paramString1, String paramString2, LongSparseSet paramLongSparseSet, int paramInt, boolean paramBoolean)
  {
    com.viber.provider.b localb = f();
    if (paramBoolean);
    for (String str = "UPDATE %s SET %s=%s | (1 << %s) WHERE %s in (%s)"; ; str = "UPDATE %s SET %s=%s & ~(1 << %s) WHERE %s in (%s)")
    {
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = paramString2;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = String.valueOf(paramInt);
      arrayOfObject[4] = "_id";
      arrayOfObject[5] = a.a(paramLongSparseSet);
      localb.a(String.format(str, arrayOfObject));
      return;
    }
  }

  protected void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, boolean paramBoolean)
  {
    com.viber.provider.b localb = f();
    if (paramBoolean);
    for (String str1 = "UPDATE %s SET %s=%s | (1 << %s) WHERE %s=?"; ; str1 = "UPDATE %s SET %s=%s & ~(1 << %s) WHERE %s=?")
    {
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = paramString2;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = String.valueOf(paramInt);
      arrayOfObject[4] = paramString3;
      String str2 = String.format(str1, arrayOfObject);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramLong);
      localb.a(str2, arrayOfString);
      return;
    }
  }

  protected void a(String paramString1, String paramString2, Set<Long> paramSet, int paramInt, boolean paramBoolean)
  {
    com.viber.provider.b localb = f();
    if (paramBoolean);
    for (String str = "UPDATE %s SET %s=%s | (1 << %s) WHERE %s in (%s)"; ; str = "UPDATE %s SET %s=%s & ~(1 << %s) WHERE %s in (%s)")
    {
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = paramString2;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = String.valueOf(paramInt);
      arrayOfObject[4] = "_id";
      arrayOfObject[5] = a.e(paramSet);
      localb.a(String.format(str, arrayOfObject));
      return;
    }
  }

  public boolean a(com.viber.voip.model.entity.b paramb)
  {
    if (paramb == null)
      throw new IllegalArgumentException("Can't update entity, entity is null");
    ContentValues localContentValues = paramb.getContentValues();
    if (localContentValues == null)
      throw new IllegalArgumentException("Can't update entity, content values is null");
    if (paramb.getTable() == null)
      throw new IllegalArgumentException("Can't update entity, table is null");
    long l = a(paramb.getTable(), localContentValues);
    if (l > 0L)
    {
      paramb.setId(l);
      return true;
    }
    return false;
  }

  public boolean a(String paramString1, long paramLong, String paramString2, Integer paramInteger)
  {
    a(paramString1, paramLong, paramString2);
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put(paramString2, paramInteger);
    return a(paramLong, paramString1, localContentValues) > 0;
  }

  public boolean a(String paramString1, long paramLong, String paramString2, Long paramLong1)
  {
    a(paramString1, paramLong, paramString2);
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put(paramString2, paramLong1);
    return a(paramLong, paramString1, localContentValues) > 0;
  }

  public boolean a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    a(paramString1, paramLong, paramString2);
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put(paramString2, paramString3);
    return a(paramLong, paramString1, localContentValues) > 0;
  }

  // ERROR //
  protected MessageEntity b(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   6: ldc 45
    //   8: getstatic 165	com/viber/voip/messages/orm/entity/impl/MessageEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   11: aload_1
    //   12: aload_2
    //   13: aconst_null
    //   14: aconst_null
    //   15: aload_3
    //   16: ldc_w 335
    //   19: invokeinterface 168 9 0
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +41 -> 69
    //   31: aload 6
    //   33: invokeinterface 174 1 0
    //   38: ifeq +31 -> 69
    //   41: new 185	com/viber/voip/model/entity/MessageEntity
    //   44: dup
    //   45: invokespecial 186	com/viber/voip/model/entity/MessageEntity:<init>	()V
    //   48: aload 6
    //   50: iconst_0
    //   51: invokestatic 190	com/viber/voip/messages/orm/entity/impl/MessageEntityHelper:createEntity	(Lcom/viber/voip/model/entity/MessageEntity;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/MessageEntity;
    //   54: astore 8
    //   56: aload 8
    //   58: astore 7
    //   60: aload_0
    //   61: aload 6
    //   63: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   66: aload 7
    //   68: areturn
    //   69: aconst_null
    //   70: astore 7
    //   72: goto -12 -> 60
    //   75: astore 5
    //   77: aload_0
    //   78: aload 4
    //   80: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
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

  protected List<MessageEntity> b(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      localCursor = f().a(paramString, paramArrayOfString);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          localArrayList.add(MessageEntityHelper.createEntity(new MessageEntity(), localCursor, 0));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localArrayList;
    }
    finally
    {
      a(localCursor);
    }
  }

  // ERROR //
  protected List<MessageCallEntity> b(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 176	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 336	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   12: ldc_w 338
    //   15: getstatic 341	com/viber/voip/messages/orm/entity/impl/MessageCallEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   18: aload_1
    //   19: aload_2
    //   20: aload 4
    //   22: aconst_null
    //   23: aload_3
    //   24: aconst_null
    //   25: invokeinterface 168 9 0
    //   30: astore 8
    //   32: aload 8
    //   34: astore 7
    //   36: aload 7
    //   38: ifnull +48 -> 86
    //   41: aload 7
    //   43: invokeinterface 174 1 0
    //   48: ifeq +38 -> 86
    //   51: aload 5
    //   53: new 343	com/viber/voip/model/entity/MessageCallEntity
    //   56: dup
    //   57: invokespecial 344	com/viber/voip/model/entity/MessageCallEntity:<init>	()V
    //   60: aload 7
    //   62: iconst_0
    //   63: invokestatic 347	com/viber/voip/messages/orm/entity/impl/MessageCallEntityHelper:createEntity	(Lcom/viber/voip/model/entity/MessageCallEntity;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/MessageCallEntity;
    //   66: invokeinterface 196 2 0
    //   71: pop
    //   72: aload 7
    //   74: invokeinterface 199 1 0
    //   79: istore 10
    //   81: iload 10
    //   83: ifne -32 -> 51
    //   86: aload_0
    //   87: aload 7
    //   89: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   92: aload 5
    //   94: areturn
    //   95: astore 6
    //   97: aconst_null
    //   98: astore 7
    //   100: aload_0
    //   101: aload 7
    //   103: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   106: aload 6
    //   108: athrow
    //   109: astore 6
    //   111: goto -11 -> 100
    //
    // Exception table:
    //   from	to	target	type
    //   9	32	95	finally
    //   41	51	109	finally
    //   51	81	109	finally
  }

  public boolean b(com.viber.voip.model.entity.b paramb)
  {
    if (paramb == null)
      throw new IllegalArgumentException("Can't update entity, entity is null");
    ContentValues localContentValues = paramb.getContentValues();
    if (localContentValues == null)
      throw new IllegalArgumentException("Can't update entity, content values is null");
    if (paramb.getTable() == null)
      throw new IllegalArgumentException("Can't update entity, table is null");
    if (paramb.getId() <= 0L)
      throw new IllegalArgumentException("Can't update entity, invalid entity id=" + paramb.getId());
    return a(paramb.getId(), paramb.getTable(), localContentValues) > 0;
  }

  protected long c(long paramLong, String paramString)
  {
    try
    {
      com.viber.provider.b localb = f();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramLong);
      int i = localb.a(paramString, "_id=?", arrayOfString);
      return i;
    }
    catch (SQLException localSQLException)
    {
    }
    return -1L;
  }

  protected MessageEntity c(String paramString, String[] paramArrayOfString)
  {
    return b(paramString, paramArrayOfString, null);
  }

  protected List<MessageCallEntity> c(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return b(paramString1, paramArrayOfString, paramString2, null);
  }

  public void c(long paramLong, int paramInt)
  {
    a("messages", paramLong, "event_count", Integer.valueOf(paramInt));
  }

  public boolean c(com.viber.voip.model.entity.b paramb)
  {
    if (paramb == null)
      throw new IllegalArgumentException("Can update entity, entity is null");
    if (paramb.getTable() == null)
      throw new IllegalArgumentException("Can update entity, table is null");
    if (paramb.getId() <= 0L)
      throw new IllegalArgumentException("Can update entity, invalid entity id=" + paramb.getId());
    return c(paramb.getId(), paramb.getTable()) > 0L;
  }

  protected List<MessageCallEntity> d(String paramString, String[] paramArrayOfString)
  {
    return c(paramString, paramArrayOfString, null);
  }

  // ERROR //
  protected List<h> d(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    // Byte code:
    //   0: new 176	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 336	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   12: ldc_w 382
    //   15: getstatic 385	com/viber/voip/messages/orm/entity/impl/ConversationEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   18: aload_1
    //   19: aload_2
    //   20: aconst_null
    //   21: aconst_null
    //   22: aload_3
    //   23: aconst_null
    //   24: invokeinterface 168 9 0
    //   29: astore 7
    //   31: aload 7
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +48 -> 85
    //   40: aload 6
    //   42: invokeinterface 174 1 0
    //   47: ifeq +38 -> 85
    //   50: aload 4
    //   52: new 387	com/viber/voip/model/entity/h
    //   55: dup
    //   56: invokespecial 388	com/viber/voip/model/entity/h:<init>	()V
    //   59: aload 6
    //   61: iconst_0
    //   62: invokestatic 391	com/viber/voip/messages/orm/entity/impl/ConversationEntityHelper:createEntity	(Lcom/viber/voip/model/entity/h;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/h;
    //   65: invokeinterface 196 2 0
    //   70: pop
    //   71: aload 6
    //   73: invokeinterface 199 1 0
    //   78: istore 9
    //   80: iload 9
    //   82: ifne -32 -> 50
    //   85: aload_0
    //   86: aload 6
    //   88: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   91: aload 4
    //   93: areturn
    //   94: astore 5
    //   96: aconst_null
    //   97: astore 6
    //   99: aload_0
    //   100: aload 6
    //   102: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   105: aload 5
    //   107: athrow
    //   108: astore 5
    //   110: goto -11 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   9	31	94	finally
    //   40	50	108	finally
    //   50	80	108	finally
  }

  // ERROR //
  protected h e(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   6: ldc_w 382
    //   9: getstatic 385	com/viber/voip/messages/orm/entity/impl/ConversationEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   12: aload_1
    //   13: aload_2
    //   14: aconst_null
    //   15: aconst_null
    //   16: aload_3
    //   17: ldc_w 335
    //   20: invokeinterface 168 9 0
    //   25: astore 6
    //   27: aload 6
    //   29: ifnull +41 -> 70
    //   32: aload 6
    //   34: invokeinterface 174 1 0
    //   39: ifeq +31 -> 70
    //   42: new 387	com/viber/voip/model/entity/h
    //   45: dup
    //   46: invokespecial 388	com/viber/voip/model/entity/h:<init>	()V
    //   49: aload 6
    //   51: iconst_0
    //   52: invokestatic 391	com/viber/voip/messages/orm/entity/impl/ConversationEntityHelper:createEntity	(Lcom/viber/voip/model/entity/h;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/h;
    //   55: astore 8
    //   57: aload 8
    //   59: astore 7
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   67: aload 7
    //   69: areturn
    //   70: aconst_null
    //   71: astore 7
    //   73: goto -12 -> 61
    //   76: astore 5
    //   78: aload_0
    //   79: aload 4
    //   81: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   84: aload 5
    //   86: athrow
    //   87: astore 5
    //   89: aload 6
    //   91: astore 4
    //   93: goto -15 -> 78
    //
    // Exception table:
    //   from	to	target	type
    //   3	27	76	finally
    //   32	57	87	finally
  }

  public List<h> e(String paramString, String[] paramArrayOfString)
  {
    return d(paramString, paramArrayOfString, null);
  }

  protected h f(String paramString, String[] paramArrayOfString)
  {
    return e(paramString, paramArrayOfString, null);
  }

  // ERROR //
  protected r f(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   6: ldc_w 400
    //   9: getstatic 403	com/viber/voip/messages/orm/entity/impl/PublicAccountEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   12: aload_1
    //   13: aload_2
    //   14: aconst_null
    //   15: aconst_null
    //   16: aload_3
    //   17: ldc_w 335
    //   20: invokeinterface 168 9 0
    //   25: astore 6
    //   27: aload 6
    //   29: ifnull +41 -> 70
    //   32: aload 6
    //   34: invokeinterface 174 1 0
    //   39: ifeq +31 -> 70
    //   42: new 405	com/viber/voip/model/entity/r
    //   45: dup
    //   46: invokespecial 406	com/viber/voip/model/entity/r:<init>	()V
    //   49: aload 6
    //   51: iconst_0
    //   52: invokestatic 409	com/viber/voip/messages/orm/entity/impl/PublicAccountEntityHelper:createEntity	(Lcom/viber/voip/model/entity/r;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/r;
    //   55: astore 8
    //   57: aload 8
    //   59: astore 7
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   67: aload 7
    //   69: areturn
    //   70: aconst_null
    //   71: astore 7
    //   73: goto -12 -> 61
    //   76: astore 5
    //   78: aload_0
    //   79: aload 4
    //   81: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   84: aload 5
    //   86: athrow
    //   87: astore 5
    //   89: aload 6
    //   91: astore 4
    //   93: goto -15 -> 78
    //
    // Exception table:
    //   from	to	target	type
    //   3	27	76	finally
    //   32	57	87	finally
  }

  protected r g(String paramString, String[] paramArrayOfString)
  {
    return f(paramString, paramArrayOfString, null);
  }

  // ERROR //
  public Set<Long> g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   5: ldc_w 382
    //   8: iconst_1
    //   9: anewarray 132	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc 245
    //   16: aastore
    //   17: ldc_w 416
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokeinterface 168 9 0
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +81 -> 113
    //   35: aload_3
    //   36: invokeinterface 174 1 0
    //   41: ifeq +72 -> 113
    //   44: new 222	java/util/HashSet
    //   47: dup
    //   48: invokespecial 417	java/util/HashSet:<init>	()V
    //   51: astore 4
    //   53: aload 4
    //   55: aload_3
    //   56: aload_3
    //   57: ldc 245
    //   59: invokeinterface 421 2 0
    //   64: invokeinterface 227 2 0
    //   69: invokestatic 232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   72: invokeinterface 235 2 0
    //   77: pop
    //   78: aload_3
    //   79: invokeinterface 199 1 0
    //   84: istore 6
    //   86: iload 6
    //   88: ifne -35 -> 53
    //   91: aload_0
    //   92: aload_3
    //   93: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   96: aload 4
    //   98: areturn
    //   99: astore_2
    //   100: aload_0
    //   101: aload_1
    //   102: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   105: aload_2
    //   106: athrow
    //   107: astore_2
    //   108: aload_3
    //   109: astore_1
    //   110: goto -10 -> 100
    //   113: aconst_null
    //   114: astore 4
    //   116: goto -25 -> 91
    //
    // Exception table:
    //   from	to	target	type
    //   2	31	99	finally
    //   35	53	107	finally
    //   53	86	107	finally
  }

  // ERROR //
  protected List<r> h(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 176	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 336	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: invokestatic 130	com/viber/voip/messages/controller/manager/aa:f	()Lcom/viber/provider/b;
    //   11: ldc_w 400
    //   14: getstatic 403	com/viber/voip/messages/orm/entity/impl/PublicAccountEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   17: aload_1
    //   18: aload_2
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokeinterface 168 9 0
    //   28: astore 6
    //   30: aload 6
    //   32: astore 5
    //   34: aload 5
    //   36: ifnull +47 -> 83
    //   39: aload 5
    //   41: invokeinterface 174 1 0
    //   46: ifeq +37 -> 83
    //   49: aload_3
    //   50: new 405	com/viber/voip/model/entity/r
    //   53: dup
    //   54: invokespecial 406	com/viber/voip/model/entity/r:<init>	()V
    //   57: aload 5
    //   59: iconst_0
    //   60: invokestatic 409	com/viber/voip/messages/orm/entity/impl/PublicAccountEntityHelper:createEntity	(Lcom/viber/voip/model/entity/r;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/r;
    //   63: invokeinterface 196 2 0
    //   68: pop
    //   69: aload 5
    //   71: invokeinterface 199 1 0
    //   76: istore 8
    //   78: iload 8
    //   80: ifne -31 -> 49
    //   83: aload_0
    //   84: aload 5
    //   86: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   89: aload_3
    //   90: areturn
    //   91: astore 4
    //   93: aconst_null
    //   94: astore 5
    //   96: aload_0
    //   97: aload 5
    //   99: invokevirtual 202	com/viber/voip/messages/controller/manager/aa:a	(Landroid/database/Cursor;)V
    //   102: aload 4
    //   104: athrow
    //   105: astore 4
    //   107: goto -11 -> 96
    //
    // Exception table:
    //   from	to	target	type
    //   8	30	91	finally
    //   39	49	105	finally
    //   49	78	105	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.aa
 * JD-Core Version:    0.6.2
 */