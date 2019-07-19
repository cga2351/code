package com.viber.service.contacts.sync.a.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Groups;
import android.provider.ContactsContract.RawContacts;
import com.viber.dexshared.Logger;
import com.viber.service.contacts.sync.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a
  implements com.viber.service.contacts.sync.a.b
{
  private final Context a;
  private final String b;
  private final String c;
  private final String d;
  private final com.viber.service.contacts.sync.c.b e;
  private long f;
  private j g;
  private c h;

  public a(Context paramContext, com.viber.service.contacts.sync.c.b paramb, String paramString1, String paramString2)
  {
    this(paramContext, paramb, paramString1, paramString2, null);
  }

  public a(Context paramContext, com.viber.service.contacts.sync.c.b paramb, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramContext;
    this.c = paramString1;
    this.b = paramString2;
    this.d = paramString3;
    this.e = paramb;
    this.h = new c(this);
  }

  // ERROR //
  private List<a.i.a> a(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: new 54	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 55	java/util/ArrayList:<init>	()V
    //   12: astore_3
    //   13: aload_2
    //   14: getstatic 60	com/viber/service/contacts/sync/a/a/a$i:a	Landroid/net/Uri;
    //   17: getstatic 63	com/viber/service/contacts/sync/a/a/a$i:b	[Ljava/lang/String;
    //   20: ldc 65
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 6
    //   29: aload 6
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull +43 -> 78
    //   38: aload 5
    //   40: invokeinterface 77 1 0
    //   45: ifeq +33 -> 78
    //   48: aload_3
    //   49: new 79	com/viber/service/contacts/sync/a/a/a$i$a
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 82	com/viber/service/contacts/sync/a/a/a$i$a:<init>	(Landroid/database/Cursor;)V
    //   58: invokeinterface 88 2 0
    //   63: pop
    //   64: aload 5
    //   66: invokeinterface 91 1 0
    //   71: istore 8
    //   73: iload 8
    //   75: ifne -27 -> 48
    //   78: aload 5
    //   80: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   83: aload_3
    //   84: areturn
    //   85: astore 4
    //   87: aconst_null
    //   88: astore 5
    //   90: aload 5
    //   92: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   95: aload 4
    //   97: athrow
    //   98: astore 4
    //   100: goto -10 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   13	29	85	finally
    //   38	48	98	finally
    //   48	73	98	finally
  }

  // ERROR //
  private Set<Long> a(Context paramContext, j paramj)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_3
    //   5: new 100	java/util/HashSet
    //   8: dup
    //   9: invokespecial 101	java/util/HashSet:<init>	()V
    //   12: astore 4
    //   14: getstatic 104	com/viber/service/contacts/sync/a/a/a$b:a	Landroid/net/Uri;
    //   17: astore 7
    //   19: getstatic 105	com/viber/service/contacts/sync/a/a/a$b:b	[Ljava/lang/String;
    //   22: astore 8
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: astore 9
    //   30: aload 9
    //   32: iconst_0
    //   33: aload_2
    //   34: getfield 108	com/viber/service/contacts/sync/a/a/a$j:d	Ljava/lang/String;
    //   37: aastore
    //   38: ldc 110
    //   40: aload 9
    //   42: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   45: astore 10
    //   47: iconst_1
    //   48: anewarray 112	java/lang/String
    //   51: astore 11
    //   53: aload 11
    //   55: iconst_0
    //   56: aload_0
    //   57: getfield 34	com/viber/service/contacts/sync/a/a/a:b	Ljava/lang/String;
    //   60: aastore
    //   61: aload_3
    //   62: aload 7
    //   64: aload 8
    //   66: aload 10
    //   68: aload 11
    //   70: aconst_null
    //   71: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore 12
    //   76: aload 12
    //   78: astore 6
    //   80: aload 6
    //   82: ifnull +87 -> 169
    //   85: aload 6
    //   87: invokeinterface 120 1 0
    //   92: aload_2
    //   93: getfield 123	com/viber/service/contacts/sync/a/a/a$j:c	Ljava/util/Set;
    //   96: invokeinterface 128 1 0
    //   101: if_icmpeq +68 -> 169
    //   104: aload 4
    //   106: aload_2
    //   107: getfield 123	com/viber/service/contacts/sync/a/a/a$j:c	Ljava/util/Set;
    //   110: invokeinterface 132 2 0
    //   115: pop
    //   116: aload 6
    //   118: invokeinterface 77 1 0
    //   123: istore 14
    //   125: iload 14
    //   127: ifeq +42 -> 169
    //   130: aload 4
    //   132: aload 6
    //   134: iconst_0
    //   135: invokeinterface 136 2 0
    //   140: invokestatic 142	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   143: invokevirtual 146	java/lang/Long:longValue	()J
    //   146: invokestatic 149	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   149: invokeinterface 152 2 0
    //   154: pop
    //   155: aload 6
    //   157: invokeinterface 91 1 0
    //   162: istore 16
    //   164: iload 16
    //   166: ifne -36 -> 130
    //   169: aload 6
    //   171: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   174: aload 4
    //   176: areturn
    //   177: astore 5
    //   179: aconst_null
    //   180: astore 6
    //   182: aload 6
    //   184: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   187: aload 5
    //   189: athrow
    //   190: astore 5
    //   192: goto -10 -> 182
    //   195: astore 15
    //   197: goto -42 -> 155
    //
    // Exception table:
    //   from	to	target	type
    //   14	76	177	finally
    //   85	125	190	finally
    //   130	155	190	finally
    //   155	164	190	finally
    //   130	155	195	java/lang/NumberFormatException
  }

  // ERROR //
  private void a(Context paramContext, long paramLong, String paramString, Set<Long> paramSet, Map<Long, Long> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 156	com/viber/service/contacts/sync/a/a/a:g	()Lcom/viber/dexshared/Logger;
    //   4: pop
    //   5: new 158	com/viber/provider/a
    //   8: dup
    //   9: aload_1
    //   10: ldc 160
    //   12: invokespecial 163	com/viber/provider/a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   15: astore 9
    //   17: aload_1
    //   18: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore 10
    //   23: iconst_0
    //   24: istore 11
    //   26: getstatic 166	com/viber/service/contacts/sync/a/a/a$f:a	Landroid/net/Uri;
    //   29: astore 14
    //   31: getstatic 167	com/viber/service/contacts/sync/a/a/a$f:b	[Ljava/lang/String;
    //   34: astore 15
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: astore 16
    //   42: aload 16
    //   44: iconst_0
    //   45: aload 5
    //   47: invokestatic 172	com/viber/voip/s/a:e	(Ljava/util/Collection;)Ljava/lang/String;
    //   50: aastore
    //   51: aload 10
    //   53: aload 14
    //   55: aload 15
    //   57: ldc 174
    //   59: aload 16
    //   61: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: aconst_null
    //   65: ldc 176
    //   67: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 17
    //   72: aload 17
    //   74: ifnonnull +3 -> 77
    //   77: aload 17
    //   79: ifnull +269 -> 348
    //   82: aload 17
    //   84: invokeinterface 77 1 0
    //   89: ifeq +259 -> 348
    //   92: aconst_null
    //   93: astore 20
    //   95: aload 17
    //   97: bipush 7
    //   99: invokeinterface 180 2 0
    //   104: istore 21
    //   106: iload 21
    //   108: ifeq +9 -> 117
    //   111: aload 17
    //   113: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   116: return
    //   117: aload 17
    //   119: iconst_0
    //   120: invokeinterface 184 2 0
    //   125: lstore 22
    //   127: aload 20
    //   129: ifnull +112 -> 241
    //   132: aload 20
    //   134: getfield 188	com/viber/service/contacts/sync/a/a/a$f$a:b	J
    //   137: lload 22
    //   139: lcmp
    //   140: ifeq +101 -> 241
    //   143: aload_0
    //   144: aload_1
    //   145: lload_2
    //   146: aload 4
    //   148: aload 9
    //   150: aload 20
    //   152: aload 6
    //   154: iload 7
    //   156: invokespecial 191	com/viber/service/contacts/sync/a/a/a:a	(Landroid/content/Context;JLjava/lang/String;Lcom/viber/provider/a;Lcom/viber/service/contacts/sync/a/a/a$f$a;Ljava/util/Map;Z)Z
    //   159: ifeq +71 -> 230
    //   162: aload_0
    //   163: getfield 45	com/viber/service/contacts/sync/a/a/a:h	Lcom/viber/service/contacts/sync/a/c;
    //   166: invokevirtual 193	com/viber/service/contacts/sync/a/c:b	()Z
    //   169: istore 29
    //   171: iconst_0
    //   172: istore 28
    //   174: iload 29
    //   176: ifne +58 -> 234
    //   179: iconst_1
    //   180: istore 26
    //   182: aload 20
    //   184: ifnull +25 -> 209
    //   187: iload 26
    //   189: ifne +20 -> 209
    //   192: aload_0
    //   193: aload_1
    //   194: lload_2
    //   195: aload 4
    //   197: aload 9
    //   199: aload 20
    //   201: aload 6
    //   203: iload 7
    //   205: invokespecial 191	com/viber/service/contacts/sync/a/a/a:a	(Landroid/content/Context;JLjava/lang/String;Lcom/viber/provider/a;Lcom/viber/service/contacts/sync/a/a/a$f$a;Ljava/util/Map;Z)Z
    //   208: pop
    //   209: iload 26
    //   211: istore 18
    //   213: aload 17
    //   215: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   218: iload 18
    //   220: ifne -104 -> 116
    //   223: aload 9
    //   225: invokevirtual 196	com/viber/provider/a:b	()Ljava/util/List;
    //   228: pop
    //   229: return
    //   230: iload 11
    //   232: istore 28
    //   234: aconst_null
    //   235: astore 20
    //   237: iload 28
    //   239: istore 11
    //   241: aload 20
    //   243: ifnull +14 -> 257
    //   246: aload 20
    //   248: getfield 188	com/viber/service/contacts/sync/a/a/a$f$a:b	J
    //   251: lload 22
    //   253: lcmp
    //   254: ifeq +45 -> 299
    //   257: new 186	com/viber/service/contacts/sync/a/a/a$f$a
    //   260: dup
    //   261: lload 22
    //   263: aload 17
    //   265: iconst_1
    //   266: invokeinterface 184 2 0
    //   271: aload 17
    //   273: iconst_2
    //   274: invokeinterface 180 2 0
    //   279: aload 17
    //   281: iconst_3
    //   282: invokeinterface 136 2 0
    //   287: invokespecial 199	com/viber/service/contacts/sync/a/a/a$f$a:<init>	(JJILjava/lang/String;)V
    //   290: astore 24
    //   292: iinc 11 1
    //   295: aload 24
    //   297: astore 20
    //   299: aload 20
    //   301: aload 17
    //   303: invokevirtual 200	com/viber/service/contacts/sync/a/a/a$f$a:a	(Landroid/database/Cursor;)V
    //   306: aload 17
    //   308: invokeinterface 91 1 0
    //   313: istore 25
    //   315: iload 25
    //   317: ifne -222 -> 95
    //   320: iconst_0
    //   321: istore 26
    //   323: goto -141 -> 182
    //   326: astore 12
    //   328: aconst_null
    //   329: astore 13
    //   331: aload 13
    //   333: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   336: aload 12
    //   338: athrow
    //   339: astore 12
    //   341: aload 17
    //   343: astore 13
    //   345: goto -14 -> 331
    //   348: iconst_0
    //   349: istore 18
    //   351: goto -138 -> 213
    //
    // Exception table:
    //   from	to	target	type
    //   26	72	326	finally
    //   82	92	339	finally
    //   95	106	339	finally
    //   117	127	339	finally
    //   132	171	339	finally
    //   192	209	339	finally
    //   246	257	339	finally
    //   257	292	339	finally
    //   299	315	339	finally
  }

  private boolean a(Context paramContext, long paramLong, String paramString, com.viber.provider.a parama, a.f.a parama1, Map<Long, Long> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Long localLong = (Long)paramMap.get(Long.valueOf(parama1.a));
      if (localLong != null)
        this.e.a(paramContext, parama, localLong.longValue(), parama1.e, a(parama1), parama1.g, parama1.f);
    }
    while (parama.a() >= 100)
    {
      parama.b();
      return true;
      this.e.a(paramContext, parama, parama1.a, parama1.e, a(parama1), parama1.g, parama1.f, paramLong, paramString);
    }
    return false;
  }

  // ERROR //
  private boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_3
    //   5: getstatic 231	com/viber/service/contacts/sync/a/a/a$d:a	Landroid/net/Uri;
    //   8: astore 6
    //   10: getstatic 232	com/viber/service/contacts/sync/a/a/a$d:b	[Ljava/lang/String;
    //   13: astore 7
    //   15: ldc 234
    //   17: iconst_1
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: aload_2
    //   24: aastore
    //   25: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   28: astore 8
    //   30: iconst_1
    //   31: anewarray 112	java/lang/String
    //   34: astore 9
    //   36: aload 9
    //   38: iconst_0
    //   39: aload_0
    //   40: getfield 34	com/viber/service/contacts/sync/a/a/a:b	Ljava/lang/String;
    //   43: aastore
    //   44: aload_3
    //   45: aload 6
    //   47: aload 7
    //   49: aload 8
    //   51: aload 9
    //   53: aconst_null
    //   54: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore 10
    //   59: aload 10
    //   61: astore 5
    //   63: aload 5
    //   65: ifnull +34 -> 99
    //   68: aload 5
    //   70: invokeinterface 120 1 0
    //   75: istore 11
    //   77: iload 11
    //   79: ifle +14 -> 93
    //   82: iconst_1
    //   83: istore 12
    //   85: aload 5
    //   87: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   90: iload 12
    //   92: ireturn
    //   93: iconst_0
    //   94: istore 12
    //   96: goto -11 -> 85
    //   99: aload 5
    //   101: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   104: iconst_1
    //   105: ireturn
    //   106: astore 4
    //   108: aconst_null
    //   109: astore 5
    //   111: aload 5
    //   113: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   116: aload 4
    //   118: athrow
    //   119: astore 4
    //   121: goto -10 -> 111
    //
    // Exception table:
    //   from	to	target	type
    //   5	59	106	finally
    //   68	77	119	finally
  }

  // ERROR //
  private int b(Context paramContext, j paramj)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_3
    //   5: new 158	com/viber/provider/a
    //   8: dup
    //   9: aload_1
    //   10: ldc 160
    //   12: invokespecial 163	com/viber/provider/a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   15: astore 4
    //   17: getstatic 238	com/viber/service/contacts/sync/a/a/a$g:a	Landroid/net/Uri;
    //   20: astore 7
    //   22: getstatic 239	com/viber/service/contacts/sync/a/a/a$g:b	[Ljava/lang/String;
    //   25: astore 8
    //   27: iconst_2
    //   28: anewarray 4	java/lang/Object
    //   31: astore 9
    //   33: aload 9
    //   35: iconst_0
    //   36: aload_2
    //   37: getfield 241	com/viber/service/contacts/sync/a/a/a$j:f	Ljava/lang/String;
    //   40: aastore
    //   41: aload 9
    //   43: iconst_1
    //   44: aload_2
    //   45: getfield 241	com/viber/service/contacts/sync/a/a/a$j:f	Ljava/lang/String;
    //   48: aastore
    //   49: ldc 243
    //   51: aload 9
    //   53: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   56: astore 10
    //   58: bipush 6
    //   60: anewarray 112	java/lang/String
    //   63: astore 11
    //   65: aload 11
    //   67: iconst_0
    //   68: aload_0
    //   69: getfield 34	com/viber/service/contacts/sync/a/a/a:b	Ljava/lang/String;
    //   72: aastore
    //   73: aload 11
    //   75: iconst_1
    //   76: ldc 245
    //   78: aastore
    //   79: aload 11
    //   81: iconst_2
    //   82: ldc 247
    //   84: aastore
    //   85: aload 11
    //   87: iconst_3
    //   88: ldc 249
    //   90: aastore
    //   91: aload 11
    //   93: iconst_4
    //   94: ldc 251
    //   96: aastore
    //   97: aload 11
    //   99: iconst_5
    //   100: ldc 253
    //   102: aastore
    //   103: aload_3
    //   104: aload 7
    //   106: aload 8
    //   108: aload 10
    //   110: aload 11
    //   112: aconst_null
    //   113: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   116: astore 12
    //   118: aload 12
    //   120: ifnull +168 -> 288
    //   123: aload 12
    //   125: invokeinterface 77 1 0
    //   130: ifeq +158 -> 288
    //   133: aload 12
    //   135: invokeinterface 120 1 0
    //   140: istore 13
    //   142: aload 12
    //   144: iconst_0
    //   145: invokeinterface 184 2 0
    //   150: lstore 15
    //   152: aload 12
    //   154: iconst_1
    //   155: invokeinterface 184 2 0
    //   160: lstore 17
    //   162: aload 12
    //   164: iconst_3
    //   165: invokeinterface 136 2 0
    //   170: astore 19
    //   172: aload 12
    //   174: iconst_2
    //   175: invokeinterface 136 2 0
    //   180: astore 20
    //   182: aload_0
    //   183: getfield 38	com/viber/service/contacts/sync/a/a/a:e	Lcom/viber/service/contacts/sync/c/b;
    //   186: aload_0
    //   187: getfield 30	com/viber/service/contacts/sync/a/a/a:a	Landroid/content/Context;
    //   190: aload 4
    //   192: lload 15
    //   194: lload 17
    //   196: aload 19
    //   198: aload 20
    //   200: invokeinterface 256 9 0
    //   205: aload 4
    //   207: invokevirtual 224	com/viber/provider/a:a	()I
    //   210: bipush 100
    //   212: if_icmple +37 -> 249
    //   215: aload_0
    //   216: getfield 45	com/viber/service/contacts/sync/a/a/a:h	Lcom/viber/service/contacts/sync/a/c;
    //   219: invokevirtual 193	com/viber/service/contacts/sync/a/c:b	()Z
    //   222: istore 22
    //   224: iload 22
    //   226: ifne +17 -> 243
    //   229: aload 12
    //   231: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   234: aload 4
    //   236: invokevirtual 196	com/viber/provider/a:b	()Ljava/util/List;
    //   239: pop
    //   240: iload 13
    //   242: ireturn
    //   243: aload 4
    //   245: invokevirtual 196	com/viber/provider/a:b	()Ljava/util/List;
    //   248: pop
    //   249: aload 12
    //   251: invokeinterface 91 1 0
    //   256: istore 21
    //   258: iload 21
    //   260: ifne -118 -> 142
    //   263: goto -34 -> 229
    //   266: astore 5
    //   268: aconst_null
    //   269: astore 6
    //   271: aload 6
    //   273: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   276: aload 5
    //   278: athrow
    //   279: astore 5
    //   281: aload 12
    //   283: astore 6
    //   285: goto -14 -> 271
    //   288: iconst_0
    //   289: istore 13
    //   291: goto -62 -> 229
    //
    // Exception table:
    //   from	to	target	type
    //   17	118	266	finally
    //   123	142	279	finally
    //   142	224	279	finally
    //   243	249	279	finally
    //   249	258	279	finally
  }

  private int b(Context paramContext, String paramString)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = d.a;
    String str = String.format("account_type=? AND sourceid NOT IN (%s)", new Object[] { paramString });
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.b;
    return localContentResolver.delete(localUri, str, arrayOfString);
  }

  // ERROR //
  private Set<String> b(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: new 100	java/util/HashSet
    //   8: dup
    //   9: invokespecial 101	java/util/HashSet:<init>	()V
    //   12: astore_3
    //   13: aload_2
    //   14: getstatic 265	com/viber/service/contacts/sync/a/a/a$h:a	Landroid/net/Uri;
    //   17: getstatic 266	com/viber/service/contacts/sync/a/a/a$h:b	[Ljava/lang/String;
    //   20: getstatic 267	com/viber/service/contacts/sync/a/a/a$h:c	Ljava/lang/String;
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore 6
    //   30: aload 6
    //   32: astore 5
    //   34: aload 5
    //   36: ifnull +42 -> 78
    //   39: aload 5
    //   41: invokeinterface 77 1 0
    //   46: ifeq +32 -> 78
    //   49: aload_3
    //   50: aload 5
    //   52: iconst_0
    //   53: invokeinterface 136 2 0
    //   58: invokeinterface 268 2 0
    //   63: pop
    //   64: aload 5
    //   66: invokeinterface 91 1 0
    //   71: istore 8
    //   73: iload 8
    //   75: ifne -26 -> 49
    //   78: aload 5
    //   80: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   83: aload_3
    //   84: areturn
    //   85: astore 4
    //   87: aconst_null
    //   88: astore 5
    //   90: aload 5
    //   92: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   95: aload 4
    //   97: athrow
    //   98: astore 4
    //   100: goto -10 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   13	30	85	finally
    //   39	49	98	finally
    //   49	73	98	finally
  }

  // ERROR //
  private Map<Long, Long> c(Context paramContext, j paramj)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_3
    //   5: new 271	java/util/HashMap
    //   8: dup
    //   9: invokespecial 272	java/util/HashMap:<init>	()V
    //   12: astore 4
    //   14: getstatic 275	com/viber/service/contacts/sync/a/a/a$e:a	Landroid/net/Uri;
    //   17: astore 7
    //   19: getstatic 276	com/viber/service/contacts/sync/a/a/a$e:b	[Ljava/lang/String;
    //   22: astore 8
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: astore 9
    //   30: aload 9
    //   32: iconst_0
    //   33: aload_2
    //   34: getfield 277	com/viber/service/contacts/sync/a/a/a$j:e	Ljava/lang/String;
    //   37: aastore
    //   38: ldc_w 279
    //   41: aload 9
    //   43: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   46: astore 10
    //   48: iconst_1
    //   49: anewarray 112	java/lang/String
    //   52: astore 11
    //   54: aload 11
    //   56: iconst_0
    //   57: aload_0
    //   58: getfield 34	com/viber/service/contacts/sync/a/a/a:b	Ljava/lang/String;
    //   61: aastore
    //   62: aload_3
    //   63: aload 7
    //   65: aload 8
    //   67: aload 10
    //   69: aload 11
    //   71: aconst_null
    //   72: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 12
    //   77: aload 12
    //   79: astore 6
    //   81: aload 6
    //   83: ifnull +71 -> 154
    //   86: aload 6
    //   88: invokeinterface 77 1 0
    //   93: istore 13
    //   95: iload 13
    //   97: ifeq +57 -> 154
    //   100: aload 6
    //   102: iconst_0
    //   103: invokeinterface 184 2 0
    //   108: lstore 16
    //   110: aload 4
    //   112: aload 6
    //   114: iconst_1
    //   115: invokeinterface 136 2 0
    //   120: invokestatic 142	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   123: invokevirtual 146	java/lang/Long:longValue	()J
    //   126: invokestatic 149	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   129: lload 16
    //   131: invokestatic 149	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: invokeinterface 283 3 0
    //   139: pop
    //   140: aload 6
    //   142: invokeinterface 91 1 0
    //   147: istore 15
    //   149: iload 15
    //   151: ifne -51 -> 100
    //   154: aload 6
    //   156: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   159: aload 4
    //   161: areturn
    //   162: astore 5
    //   164: aconst_null
    //   165: astore 6
    //   167: aload 6
    //   169: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   172: aload 5
    //   174: athrow
    //   175: astore 5
    //   177: goto -10 -> 167
    //   180: astore 14
    //   182: goto -42 -> 140
    //
    // Exception table:
    //   from	to	target	type
    //   14	77	162	finally
    //   86	95	175	finally
    //   100	140	175	finally
    //   140	149	175	finally
    //   100	140	180	java/lang/NumberFormatException
  }

  // ERROR //
  private boolean c(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: getstatic 287	com/viber/service/contacts/sync/a/a/a$a:a	Landroid/net/Uri;
    //   8: astore 5
    //   10: getstatic 288	com/viber/service/contacts/sync/a/a/a$a:b	[Ljava/lang/String;
    //   13: astore 6
    //   15: iconst_1
    //   16: anewarray 112	java/lang/String
    //   19: astore 7
    //   21: aload 7
    //   23: iconst_0
    //   24: aload_0
    //   25: getfield 34	com/viber/service/contacts/sync/a/a/a:b	Ljava/lang/String;
    //   28: aastore
    //   29: aload_2
    //   30: aload 5
    //   32: aload 6
    //   34: ldc_w 290
    //   37: aload 7
    //   39: aconst_null
    //   40: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 8
    //   45: aload 8
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull +34 -> 85
    //   54: aload 4
    //   56: invokeinterface 120 1 0
    //   61: istore 9
    //   63: iload 9
    //   65: ifle +14 -> 79
    //   68: iconst_1
    //   69: istore 10
    //   71: aload 4
    //   73: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   76: iload 10
    //   78: ireturn
    //   79: iconst_0
    //   80: istore 10
    //   82: goto -11 -> 71
    //   85: aload 4
    //   87: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   90: iconst_1
    //   91: ireturn
    //   92: astore_3
    //   93: aconst_null
    //   94: astore 4
    //   96: aload 4
    //   98: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   101: aload_3
    //   102: athrow
    //   103: astore_3
    //   104: goto -8 -> 96
    //
    // Exception table:
    //   from	to	target	type
    //   5	45	92	finally
    //   54	63	103	finally
  }

  private int d(Context paramContext)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("dirty", Integer.valueOf(0));
    Uri localUri = a.a;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.b;
    return localContentResolver.update(localUri, localContentValues, "account_type=? AND dirty=1", arrayOfString);
  }

  // ERROR //
  public long a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: lconst_0
    //   8: lreturn
    //   9: aload_1
    //   10: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: astore 4
    //   15: getstatic 320	com/viber/service/contacts/sync/a/a/a$c:a	Landroid/net/Uri;
    //   18: astore 7
    //   20: getstatic 321	com/viber/service/contacts/sync/a/a/a$c:b	[Ljava/lang/String;
    //   23: astore 8
    //   25: iconst_3
    //   26: anewarray 112	java/lang/String
    //   29: astore 9
    //   31: aload 9
    //   33: iconst_0
    //   34: aload_3
    //   35: aastore
    //   36: aload 9
    //   38: iconst_1
    //   39: aload_0
    //   40: getfield 34	com/viber/service/contacts/sync/a/a/a:b	Ljava/lang/String;
    //   43: aastore
    //   44: aload 9
    //   46: iconst_2
    //   47: aload_2
    //   48: aastore
    //   49: aload 4
    //   51: aload 7
    //   53: aload 8
    //   55: ldc_w 323
    //   58: aload 9
    //   60: aconst_null
    //   61: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 10
    //   66: aload 10
    //   68: astore 6
    //   70: aload 6
    //   72: ifnull +127 -> 199
    //   75: aload 6
    //   77: invokeinterface 77 1 0
    //   82: ifeq +117 -> 199
    //   85: aload 6
    //   87: iconst_0
    //   88: invokeinterface 184 2 0
    //   93: lstore 14
    //   95: lload 14
    //   97: lstore 11
    //   99: aload 6
    //   101: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   104: lload 11
    //   106: lconst_0
    //   107: lcmp
    //   108: ifne +70 -> 178
    //   111: new 293	android/content/ContentValues
    //   114: dup
    //   115: iconst_4
    //   116: invokespecial 296	android/content/ContentValues:<init>	(I)V
    //   119: astore 13
    //   121: aload 13
    //   123: ldc_w 325
    //   126: aload_3
    //   127: invokevirtual 328	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 13
    //   132: ldc_w 330
    //   135: aload_0
    //   136: getfield 34	com/viber/service/contacts/sync/a/a/a:b	Ljava/lang/String;
    //   139: invokevirtual 328	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload 13
    //   144: ldc_w 332
    //   147: aload_2
    //   148: invokevirtual 328	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 13
    //   153: ldc_w 334
    //   156: iconst_1
    //   157: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: invokevirtual 306	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   163: aload 4
    //   165: getstatic 339	android/provider/ContactsContract$Groups:CONTENT_URI	Landroid/net/Uri;
    //   168: aload 13
    //   170: invokevirtual 343	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   173: invokestatic 349	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   176: lstore 11
    //   178: lload 11
    //   180: lreturn
    //   181: astore 5
    //   183: aconst_null
    //   184: astore 6
    //   186: aload 6
    //   188: invokestatic 95	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   191: aload 5
    //   193: athrow
    //   194: astore 5
    //   196: goto -10 -> 186
    //   199: lconst_0
    //   200: lstore 11
    //   202: goto -103 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   15	66	181	finally
    //   75	95	194	finally
  }

  protected abstract String a(a.f.a parama);

  protected abstract String a(a.i.a parama);

  public boolean a()
  {
    return this.h.a();
  }

  public void b()
  {
    this.f = a(this.a, this.d, this.c);
    this.g = new j(a(this.a), b(this.a));
  }

  public void c()
  {
    if (this.g == null);
    while (!a(this.a, this.g.d))
      return;
    b(this.a, this.g.d);
  }

  public void d()
  {
    if (this.g == null);
    Set localSet;
    do
    {
      return;
      localSet = a(this.a, this.g);
    }
    while (localSet.size() <= 0);
    a(this.a, this.f, this.c, localSet, null, false);
  }

  public void e()
  {
    if (c(this.a))
      d(this.a);
    this.f = 0L;
    this.g = null;
  }

  public void f()
  {
    if (this.g == null)
      return;
    Map localMap = c(this.a, this.g);
    if (localMap.size() != 0)
      a(this.a, this.f, this.c, localMap.keySet(), localMap, true);
    b(this.a, this.g);
  }

  protected abstract Logger g();

  private static abstract interface a
  {
    public static final Uri a = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    public static final String[] b = { "_id" };
  }

  private static abstract interface b
  {
    public static final Uri a = ContactsContract.RawContacts.CONTENT_URI;
    public static final String[] b = { "sourceid" };
  }

  private static abstract interface c
  {
    public static final Uri a = ContactsContract.Groups.CONTENT_URI;
    public static final String[] b = { "_id" };
  }

  private static abstract interface d
  {
    public static final Uri a = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    public static final String[] b = { "_id" };
  }

  private static abstract interface e
  {
    public static final Uri a = ContactsContract.RawContacts.CONTENT_URI;
    public static final String[] b = { "_id", "sourceid" };
  }

  public static abstract interface f
  {
    public static final Uri a = com.viber.provider.contacts.a.c.h;
    public static final String[] b = { "phonebookcontact._id", "phonebookcontact.contact_hash", "phonebookcontact.version", "phonebookcontact.display_name", "phonebookdata.raw_id", "phonebookdata.data2", "vibernumbers.canonized_number", "phonebookdata.mime_type" };

    public static class a
    {
      public long a;
      public final long b;
      public final long c;
      public final int d;
      public final String e;
      public final Set<String> f = new HashSet();
      public final Set<String> g = new HashSet();

      public a(long paramLong1, long paramLong2, int paramInt, String paramString)
      {
        this.b = paramLong1;
        this.c = paramLong2;
        this.e = paramString;
        this.d = paramInt;
      }

      public void a(Cursor paramCursor)
      {
        if (paramCursor.isNull(6))
          this.f.add(paramCursor.getString(5));
        while (true)
        {
          long l = paramCursor.getLong(4);
          if ((this.a == 0L) || (this.a > l))
            this.a = l;
          return;
          this.g.add(paramCursor.getString(5));
        }
      }
    }
  }

  private static abstract interface g
  {
    public static final Uri a = ContactsContract.Data.CONTENT_URI;
    public static final String[] b = { "_id", "raw_contact_id", "data1", "mimetype" };
  }

  public static abstract interface h
  {
    public static final Uri a = com.viber.provider.contacts.a.g.a;
    public static final String[] b = { "canonized_number" };
    public static final String c = null;
  }

  public static abstract interface i
  {
    public static final Uri a = com.viber.provider.contacts.a.c.k;
    public static final String[] b = { "phonebookrawcontact._id", "phonebookcontact.contact_hash", "phonebookcontact._id", "phonebookcontact.version" };

    public static class a
    {
      public final long a;
      public final long b;
      public final long c;
      public final int d;

      public a(Cursor paramCursor)
      {
        this.a = paramCursor.getLong(2);
        this.b = paramCursor.getLong(0);
        this.c = paramCursor.getLong(1);
        this.d = paramCursor.getInt(3);
      }
    }
  }

  public class j
  {
    final Set<String> a;
    final List<a.i.a> b;
    final Set<Long> c;
    final String d;
    final String e;
    final String f;

    public j(Set<String> arg2)
    {
      Object localObject1;
      this.b = new ArrayList(localObject1.size());
      Object localObject2;
      this.a = localObject2;
      HashMap localHashMap = new HashMap(1 + (int)(localObject1.size() / 0.75F));
      Iterator localIterator1 = localObject1.iterator();
      while (localIterator1.hasNext())
      {
        a.i.a locala2 = (a.i.a)localIterator1.next();
        if (localHashMap.containsKey(Long.valueOf(locala2.a)))
        {
          a.i.a locala3 = (a.i.a)localHashMap.get(Long.valueOf(locala2.a));
          if (locala3.b > locala2.b)
          {
            this.b.remove(locala3);
            localHashMap.put(Long.valueOf(locala2.a), locala2);
            this.b.add(locala2);
          }
        }
        else
        {
          this.b.add(locala2);
          localHashMap.put(Long.valueOf(locala2.a), locala2);
        }
      }
      int i = this.b.size();
      this.c = new HashSet(1 + (int)(i / 0.75F));
      StringBuilder localStringBuilder1 = new StringBuilder(i * 8);
      StringBuilder localStringBuilder2 = new StringBuilder(i * 18);
      Iterator localIterator2 = this.b.iterator();
      while (localIterator2.hasNext())
      {
        a.i.a locala1 = (a.i.a)localIterator2.next();
        this.c.add(Long.valueOf(locala1.b));
        if (localStringBuilder1.length() > 0)
          localStringBuilder1.append(',');
        localStringBuilder1.append('\'').append(locala1.b).append('\'');
        if (localStringBuilder2.length() > 0)
          localStringBuilder2.append(',');
        localStringBuilder2.append('\'').append(a.this.a(locala1)).append('\'');
      }
      this.d = localStringBuilder1.toString();
      this.e = localStringBuilder2.toString();
      StringBuilder localStringBuilder3 = new StringBuilder(16 * localObject2.size());
      Iterator localIterator3 = localObject2.iterator();
      while (localIterator3.hasNext())
      {
        String str = (String)localIterator3.next();
        if (localStringBuilder3.length() > 0)
          localStringBuilder3.append(',');
        localStringBuilder3.append('\'').append(str).append('\'');
      }
      this.f = localStringBuilder3.toString();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.a.a.a
 * JD-Core Version:    0.6.2
 */