package com.viber.voip.contacts.c.f.b;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.viber.dexshared.Logger;
import com.viber.jni.CContactInfo;
import com.viber.provider.contacts.a.c;
import com.viber.provider.contacts.a.f;
import com.viber.provider.contacts.a.g;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.f.b.a.a.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.entity.w;
import com.viber.voip.model.entity.x;
import com.viber.voip.model.i;
import com.viber.voip.util.af;
import com.viber.voip.util.bq.a;
import com.viber.voip.util.bq.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile f b;
  private Queue<d> c = new LinkedList();
  private boolean d;
  private Context e;
  private com.viber.voip.contacts.c.e.b f;
  private ContentResolver g;

  private f(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    this.g = paramContext.getContentResolver();
    this.f = com.viber.voip.contacts.c.e.b.a(paramContext);
  }

  @Deprecated
  public static f a(Context paramContext)
  {
    if (b == null)
      b = new f(paramContext);
    return b;
  }

  // ERROR //
  private String a(HashSet<CContactInfo> paramHashSet1, HashSet<CContactInfo> paramHashSet2, HashSet<CContactInfo> paramHashSet3)
  {
    // Byte code:
    //   0: new 68	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: new 71	java/util/HashMap
    //   12: dup
    //   13: invokespecial 72	java/util/HashMap:<init>	()V
    //   16: astore 5
    //   18: new 71	java/util/HashMap
    //   21: dup
    //   22: invokespecial 72	java/util/HashMap:<init>	()V
    //   25: astore 6
    //   27: new 71	java/util/HashMap
    //   30: dup
    //   31: invokespecial 72	java/util/HashMap:<init>	()V
    //   34: astore 7
    //   36: aload_0
    //   37: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   40: getstatic 77	com/viber/provider/contacts/a$f:b	Landroid/net/Uri;
    //   43: getstatic 82	com/viber/voip/model/entity/w:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   46: invokevirtual 88	com/viber/voip/messages/orm/creator/CreatorHelper:getProjections	()[Ljava/lang/String;
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore 10
    //   57: aload 10
    //   59: astore 9
    //   61: aload 9
    //   63: ifnull +139 -> 202
    //   66: aload 9
    //   68: invokeinterface 100 1 0
    //   73: ifeq +129 -> 202
    //   76: aload 9
    //   78: ldc 102
    //   80: invokeinterface 106 2 0
    //   85: istore 14
    //   87: aload 9
    //   89: ldc 108
    //   91: invokeinterface 106 2 0
    //   96: istore 15
    //   98: getstatic 82	com/viber/voip/model/entity/w:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   101: aload 9
    //   103: invokevirtual 112	com/viber/voip/messages/orm/creator/CreatorHelper:createInstance	(Landroid/database/Cursor;)Lcom/viber/voip/model/d;
    //   106: checkcast 79	com/viber/voip/model/entity/w
    //   109: astore 16
    //   111: aload 16
    //   113: invokevirtual 115	com/viber/voip/model/entity/w:a	()Lcom/viber/provider/contacts/a$f$a;
    //   116: astore 17
    //   118: aload 9
    //   120: iload 15
    //   122: invokeinterface 119 2 0
    //   127: istore 18
    //   129: aload 9
    //   131: iload 14
    //   133: invokeinterface 123 2 0
    //   138: astore 19
    //   140: aload 4
    //   142: invokevirtual 127	java/lang/StringBuilder:length	()I
    //   145: ifle +11 -> 156
    //   148: aload 4
    //   150: bipush 44
    //   152: invokevirtual 131	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 4
    //   158: aload 19
    //   160: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: getstatic 139	com/viber/provider/contacts/a$f$a:a	Lcom/viber/provider/contacts/a$f$a;
    //   167: aload 17
    //   169: if_acmpne +84 -> 253
    //   172: aload 5
    //   174: aload 16
    //   176: invokevirtual 142	com/viber/voip/model/entity/w:b	()Lcom/viber/jni/CContactInfo;
    //   179: iload 18
    //   181: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: aload 9
    //   190: invokeinterface 155 1 0
    //   195: istore 22
    //   197: iload 22
    //   199: ifne -101 -> 98
    //   202: aload 9
    //   204: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   207: aload_0
    //   208: aload 5
    //   210: aload 6
    //   212: aload 7
    //   214: invokespecial 163	com/viber/voip/contacts/c/f/b/f:a	(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V
    //   217: aload_1
    //   218: aload 5
    //   220: invokevirtual 167	java/util/HashMap:keySet	()Ljava/util/Set;
    //   223: invokevirtual 173	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   226: pop
    //   227: aload_2
    //   228: aload 6
    //   230: invokevirtual 167	java/util/HashMap:keySet	()Ljava/util/Set;
    //   233: invokevirtual 173	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   236: pop
    //   237: aload_3
    //   238: aload 7
    //   240: invokevirtual 167	java/util/HashMap:keySet	()Ljava/util/Set;
    //   243: invokevirtual 173	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   246: pop
    //   247: aload 4
    //   249: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: areturn
    //   253: getstatic 179	com/viber/provider/contacts/a$f$a:b	Lcom/viber/provider/contacts/a$f$a;
    //   256: aload 17
    //   258: if_acmpne +32 -> 290
    //   261: aload 6
    //   263: aload 16
    //   265: invokevirtual 142	com/viber/voip/model/entity/w:b	()Lcom/viber/jni/CContactInfo;
    //   268: iload 18
    //   270: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: pop
    //   277: goto -89 -> 188
    //   280: astore 8
    //   282: aload 9
    //   284: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   287: aload 8
    //   289: athrow
    //   290: aload 7
    //   292: aload 16
    //   294: invokevirtual 142	com/viber/voip/model/entity/w:b	()Lcom/viber/jni/CContactInfo;
    //   297: iload 18
    //   299: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: pop
    //   306: goto -118 -> 188
    //   309: astore 8
    //   311: aconst_null
    //   312: astore 9
    //   314: goto -32 -> 282
    //
    // Exception table:
    //   from	to	target	type
    //   66	98	280	finally
    //   98	156	280	finally
    //   156	188	280	finally
    //   188	197	280	finally
    //   253	277	280	finally
    //   290	306	280	finally
    //   36	57	309	finally
  }

  private void a(ContentProviderOperation paramContentProviderOperation1, ContentProviderOperation paramContentProviderOperation2, final Set<i> paramSet, boolean paramBoolean1, boolean paramBoolean2, final a parama)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramContentProviderOperation1 != null)
      localArrayList.add(paramContentProviderOperation1);
    if (paramContentProviderOperation2 != null)
      localArrayList.add(paramContentProviderOperation2);
    if (paramBoolean2)
      localArrayList.add(ContentProviderOperation.newDelete(a.g.a).withSelection("clear=1", null).build());
    localArrayList.add(ContentProviderOperation.newUpdate(a.c.a).withValue("viber", Boolean.valueOf(false)).withValue("recently_joined_date", Integer.valueOf(0)).withSelection(a(false), null).build());
    if (paramBoolean1)
      localArrayList.add(ContentProviderOperation.newUpdate(a.c.a).withValue("viber", Boolean.valueOf(true)).withValue("joined_date", Long.valueOf(System.currentTimeMillis())).withSelection(a(true), null).build());
    while (true)
    {
      this.f.a(1588, "com.viber.voip.provider.vibercontacts", null, localArrayList, new bq.a()
      {
        public void a(int paramAnonymousInt, Object paramAnonymousObject, List<ContentProviderOperation> paramAnonymousList, ContentProviderResult[] paramAnonymousArrayOfContentProviderResult, Exception paramAnonymousException)
        {
          com.viber.voip.contacts.c.f.b.a(f.b(f.this)).a(paramSet);
          if (parama != null)
          {
            int i = 0;
            if (paramAnonymousArrayOfContentProviderResult != null)
            {
              int j = paramAnonymousArrayOfContentProviderResult.length;
              int k = 0;
              while (k < j)
              {
                int m = i + paramAnonymousArrayOfContentProviderResult[k].count.intValue();
                k++;
                i = m;
              }
            }
            parama.a(i);
          }
        }
      });
      return;
      localArrayList.add(ContentProviderOperation.newUpdate(a.c.a).withValue("viber", Boolean.valueOf(true)).withSelection(a(true), null).build());
    }
  }

  // ERROR //
  private void a(java.util.HashMap<CContactInfo, Integer> paramHashMap1, java.util.HashMap<CContactInfo, Integer> paramHashMap2, java.util.HashMap<CContactInfo, Integer> paramHashMap3)
  {
    // Byte code:
    //   0: new 68	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: invokevirtual 167	java/util/HashMap:keySet	()Ljava/util/Set;
    //   13: invokeinterface 263 1 0
    //   18: astore 5
    //   20: aload 5
    //   22: invokeinterface 268 1 0
    //   27: ifeq +44 -> 71
    //   30: aload 5
    //   32: invokeinterface 272 1 0
    //   37: checkcast 274	com/viber/jni/CContactInfo
    //   40: astore 26
    //   42: aload 4
    //   44: invokevirtual 127	java/lang/StringBuilder:length	()I
    //   47: ifle +11 -> 58
    //   50: aload 4
    //   52: bipush 44
    //   54: invokevirtual 131	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: aload 26
    //   62: invokevirtual 277	com/viber/jni/CContactInfo:getClientPhone	()Ljava/lang/String;
    //   65: invokestatic 282	com/viber/voip/s/a:a	(Ljava/lang/StringBuilder;Ljava/lang/String;)V
    //   68: goto -48 -> 20
    //   71: aload_3
    //   72: invokevirtual 167	java/util/HashMap:keySet	()Ljava/util/Set;
    //   75: invokeinterface 263 1 0
    //   80: astore 6
    //   82: aload 6
    //   84: invokeinterface 268 1 0
    //   89: ifeq +44 -> 133
    //   92: aload 6
    //   94: invokeinterface 272 1 0
    //   99: checkcast 274	com/viber/jni/CContactInfo
    //   102: astore 24
    //   104: aload 4
    //   106: invokevirtual 127	java/lang/StringBuilder:length	()I
    //   109: ifle +11 -> 120
    //   112: aload 4
    //   114: bipush 44
    //   116: invokevirtual 131	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 4
    //   122: aload 24
    //   124: invokevirtual 277	com/viber/jni/CContactInfo:getClientPhone	()Ljava/lang/String;
    //   127: invokestatic 282	com/viber/voip/s/a:a	(Ljava/lang/StringBuilder;Ljava/lang/String;)V
    //   130: goto -48 -> 82
    //   133: aload 4
    //   135: invokevirtual 127	java/lang/StringBuilder:length	()I
    //   138: ifle +276 -> 414
    //   141: aload_0
    //   142: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   145: astore 9
    //   147: getstatic 283	com/viber/provider/contacts/a$c:b	Landroid/net/Uri;
    //   150: astore 10
    //   152: iconst_5
    //   153: anewarray 285	java/lang/String
    //   156: dup
    //   157: iconst_0
    //   158: ldc_w 287
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: ldc_w 289
    //   167: aastore
    //   168: dup
    //   169: iconst_2
    //   170: ldc_w 291
    //   173: aastore
    //   174: dup
    //   175: iconst_3
    //   176: ldc_w 293
    //   179: aastore
    //   180: dup
    //   181: iconst_4
    //   182: ldc_w 295
    //   185: aastore
    //   186: astore 11
    //   188: new 68	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   195: astore 12
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: astore 13
    //   203: aload 13
    //   205: iconst_0
    //   206: aload 4
    //   208: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: aastore
    //   212: aload 9
    //   214: aload 10
    //   216: aload 11
    //   218: aload 12
    //   220: ldc_w 297
    //   223: aload 13
    //   225: invokestatic 301	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   228: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 303
    //   234: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: aconst_null
    //   241: ldc_w 305
    //   244: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   247: astore 14
    //   249: aload 14
    //   251: ifnull +158 -> 409
    //   254: aload 14
    //   256: invokeinterface 100 1 0
    //   261: ifeq +148 -> 409
    //   264: new 274	com/viber/jni/CContactInfo
    //   267: dup
    //   268: aload 14
    //   270: iconst_1
    //   271: invokeinterface 123 2 0
    //   276: aload 14
    //   278: iconst_0
    //   279: invokeinterface 123 2 0
    //   284: aload 14
    //   286: iconst_2
    //   287: invokeinterface 123 2 0
    //   292: invokespecial 308	com/viber/jni/CContactInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   295: astore 15
    //   297: aload 14
    //   299: aload 14
    //   301: ldc_w 310
    //   304: invokeinterface 106 2 0
    //   309: invokeinterface 119 2 0
    //   314: istore 16
    //   316: aload_1
    //   317: aload 15
    //   319: invokevirtual 314	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 144	java/lang/Integer
    //   325: astore 17
    //   327: aload_3
    //   328: aload 15
    //   330: invokevirtual 314	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   333: checkcast 144	java/lang/Integer
    //   336: astore 18
    //   338: aload 17
    //   340: ifnull +20 -> 360
    //   343: iload 16
    //   345: aload 17
    //   347: invokevirtual 317	java/lang/Integer:intValue	()I
    //   350: if_icmple +10 -> 360
    //   353: aload_1
    //   354: aload 15
    //   356: invokevirtual 320	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   359: pop
    //   360: aload 18
    //   362: ifnull +33 -> 395
    //   365: aload_3
    //   366: aload 15
    //   368: invokevirtual 320	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: aload 17
    //   374: ifnull +21 -> 395
    //   377: aload_1
    //   378: aload 15
    //   380: invokevirtual 320	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aload_2
    //   385: aload 15
    //   387: iconst_1
    //   388: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   394: pop
    //   395: aload 14
    //   397: invokeinterface 155 1 0
    //   402: istore 22
    //   404: iload 22
    //   406: ifne -142 -> 264
    //   409: aload 14
    //   411: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   414: return
    //   415: astore 7
    //   417: aconst_null
    //   418: astore 8
    //   420: aload 8
    //   422: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   425: aload 7
    //   427: athrow
    //   428: astore 7
    //   430: aload 14
    //   432: astore 8
    //   434: goto -14 -> 420
    //
    // Exception table:
    //   from	to	target	type
    //   141	249	415	finally
    //   254	264	428	finally
    //   264	338	428	finally
    //   343	360	428	finally
    //   365	372	428	finally
    //   377	395	428	finally
    //   395	404	428	finally
  }

  // ERROR //
  private void a(HashSet<CContactInfo> paramHashSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   4: getstatic 82	com/viber/voip/model/entity/w:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   7: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   10: aconst_null
    //   11: aconst_null
    //   12: invokevirtual 331	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   15: pop
    //   16: aload_0
    //   17: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   20: getstatic 334	com/viber/voip/model/entity/f:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   23: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   26: getstatic 334	com/viber/voip/model/entity/f:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   29: invokevirtual 88	com/viber/voip/messages/orm/creator/CreatorHelper:getProjections	()[Ljava/lang/String;
    //   32: ldc_w 336
    //   35: aconst_null
    //   36: ldc_w 305
    //   39: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore 5
    //   44: aload 5
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +139 -> 189
    //   53: aload 4
    //   55: invokeinterface 100 1 0
    //   60: ifeq +129 -> 189
    //   63: aload 4
    //   65: invokeinterface 339 1 0
    //   70: istore 6
    //   72: iconst_0
    //   73: istore 7
    //   75: iload 7
    //   77: iload 6
    //   79: if_icmpge +110 -> 189
    //   82: aload 4
    //   84: iload 7
    //   86: invokeinterface 343 2 0
    //   91: istore 8
    //   93: iload 8
    //   95: ifeq +88 -> 183
    //   98: getstatic 334	com/viber/voip/model/entity/f:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   101: aload 4
    //   103: invokevirtual 112	com/viber/voip/messages/orm/creator/CreatorHelper:createInstance	(Landroid/database/Cursor;)Lcom/viber/voip/model/d;
    //   106: checkcast 333	com/viber/voip/model/entity/f
    //   109: astore 10
    //   111: aload 10
    //   113: ifnull +70 -> 183
    //   116: aload 10
    //   118: invokevirtual 346	com/viber/voip/model/entity/f:k	()Ljava/lang/String;
    //   121: astore 11
    //   123: aload 10
    //   125: invokevirtual 349	com/viber/voip/model/entity/f:l	()Ljava/lang/String;
    //   128: astore 12
    //   130: aload 10
    //   132: invokevirtual 351	com/viber/voip/model/entity/f:d	()Ljava/util/Set;
    //   135: invokeinterface 263 1 0
    //   140: astore 13
    //   142: aload 13
    //   144: invokeinterface 268 1 0
    //   149: ifeq +34 -> 183
    //   152: aload_1
    //   153: new 274	com/viber/jni/CContactInfo
    //   156: dup
    //   157: aload 11
    //   159: aload 13
    //   161: invokeinterface 272 1 0
    //   166: checkcast 285	java/lang/String
    //   169: aload 12
    //   171: invokespecial 308	com/viber/jni/CContactInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   174: invokevirtual 352	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   177: pop
    //   178: goto -36 -> 142
    //   181: astore 9
    //   183: iinc 7 1
    //   186: goto -111 -> 75
    //   189: aload 4
    //   191: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   194: return
    //   195: astore_3
    //   196: aconst_null
    //   197: astore 4
    //   199: aload 4
    //   201: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   204: aload_3
    //   205: athrow
    //   206: astore_3
    //   207: goto -8 -> 199
    //
    // Exception table:
    //   from	to	target	type
    //   98	111	181	java/lang/IllegalStateException
    //   116	142	181	java/lang/IllegalStateException
    //   142	178	181	java/lang/IllegalStateException
    //   16	44	195	finally
    //   53	72	206	finally
    //   82	93	206	finally
    //   98	111	206	finally
    //   116	142	206	finally
    //   142	178	206	finally
  }

  // ERROR //
  private String g()
  {
    // Byte code:
    //   0: new 68	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   12: getstatic 82	com/viber/voip/model/entity/w:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   15: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   18: iconst_1
    //   19: anewarray 285	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc_w 358
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +51 -> 91
    //   43: aload_3
    //   44: invokeinterface 100 1 0
    //   49: ifeq +42 -> 91
    //   52: aload_1
    //   53: invokevirtual 127	java/lang/StringBuilder:length	()I
    //   56: ifle +10 -> 66
    //   59: aload_1
    //   60: bipush 44
    //   62: invokevirtual 131	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: aload_3
    //   68: iconst_0
    //   69: invokeinterface 362 2 0
    //   74: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: invokeinterface 155 1 0
    //   84: istore 6
    //   86: iload 6
    //   88: ifne -36 -> 52
    //   91: aload_3
    //   92: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   95: aload_1
    //   96: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: areturn
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_3
    //   103: aload_3
    //   104: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   107: aload_2
    //   108: athrow
    //   109: astore_2
    //   110: goto -7 -> 103
    //
    // Exception table:
    //   from	to	target	type
    //   8	36	100	finally
    //   43	52	109	finally
    //   52	66	109	finally
    //   66	86	109	finally
  }

  // ERROR //
  public int a(com.viber.voip.ViberApplication paramViberApplication)
  {
    // Byte code:
    //   0: new 183	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 184	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   12: getstatic 369	com/viber/provider/contacts/a$e:a	Landroid/net/Uri;
    //   15: iconst_3
    //   16: anewarray 285	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 358
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 371
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc_w 287
    //   36: aastore
    //   37: ldc_w 373
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 5
    //   47: aload 5
    //   49: astore 6
    //   51: aload 6
    //   53: invokestatic 376	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   56: ifeq +330 -> 386
    //   59: new 71	java/util/HashMap
    //   62: dup
    //   63: aload 6
    //   65: invokeinterface 339 1 0
    //   70: invokespecial 379	java/util/HashMap:<init>	(I)V
    //   73: astore 7
    //   75: aload 6
    //   77: iconst_0
    //   78: invokeinterface 362 2 0
    //   83: lstore 8
    //   85: aload 6
    //   87: iconst_1
    //   88: invokeinterface 123 2 0
    //   93: astore 10
    //   95: aload 6
    //   97: iconst_2
    //   98: invokeinterface 123 2 0
    //   103: astore 11
    //   105: aload_1
    //   106: aload 10
    //   108: invokestatic 384	com/viber/voip/util/dr:a	(Lcom/viber/voip/ViberApplication;Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 12
    //   113: aload 12
    //   115: aload 11
    //   117: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   120: ifne +62 -> 182
    //   123: aload 7
    //   125: aload 11
    //   127: aload 12
    //   129: invokeinterface 390 3 0
    //   134: pop
    //   135: aload_2
    //   136: getstatic 369	com/viber/provider/contacts/a$e:a	Landroid/net/Uri;
    //   139: invokestatic 218	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   142: new 68	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 392
    //   152: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: lload 8
    //   157: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: aconst_null
    //   164: invokevirtual 208	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   167: ldc_w 287
    //   170: aload 12
    //   172: invokevirtual 229	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   175: invokevirtual 212	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   178: invokevirtual 393	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload 6
    //   184: invokeinterface 155 1 0
    //   189: istore 13
    //   191: iload 13
    //   193: ifne -118 -> 75
    //   196: aload 7
    //   198: astore 14
    //   200: aload 6
    //   202: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   205: aload 14
    //   207: invokeinterface 396 1 0
    //   212: ifle +163 -> 375
    //   215: aload_0
    //   216: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   219: getstatic 194	com/viber/provider/contacts/a$g:a	Landroid/net/Uri;
    //   222: iconst_2
    //   223: anewarray 285	java/lang/String
    //   226: dup
    //   227: iconst_0
    //   228: ldc_w 358
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: ldc_w 398
    //   237: aastore
    //   238: new 68	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 400
    //   248: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 14
    //   253: invokeinterface 401 1 0
    //   258: invokestatic 404	com/viber/voip/s/a:b	(Ljava/util/Collection;)Ljava/lang/String;
    //   261: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc_w 406
    //   267: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: aconst_null
    //   274: aconst_null
    //   275: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   278: astore 6
    //   280: aload 6
    //   282: invokestatic 376	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   285: ifeq +85 -> 370
    //   288: aload 6
    //   290: iconst_0
    //   291: invokeinterface 362 2 0
    //   296: lstore 17
    //   298: aload 14
    //   300: aload 6
    //   302: iconst_1
    //   303: invokeinterface 123 2 0
    //   308: invokeinterface 407 2 0
    //   313: checkcast 285	java/lang/String
    //   316: pop
    //   317: aload_2
    //   318: getstatic 194	com/viber/provider/contacts/a$g:a	Landroid/net/Uri;
    //   321: invokestatic 200	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   324: new 68	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 392
    //   334: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: lload 17
    //   339: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: aconst_null
    //   346: invokevirtual 208	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   349: invokevirtual 212	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   352: invokevirtual 393	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   355: pop
    //   356: aload 6
    //   358: invokeinterface 155 1 0
    //   363: istore 21
    //   365: iload 21
    //   367: ifne -79 -> 288
    //   370: aload 6
    //   372: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   375: aload_0
    //   376: aload_2
    //   377: invokevirtual 410	com/viber/voip/contacts/c/f/b/f:a	(Ljava/util/ArrayList;)I
    //   380: pop
    //   381: aload_2
    //   382: invokevirtual 411	java/util/ArrayList:size	()I
    //   385: ireturn
    //   386: invokestatic 417	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   389: astore 24
    //   391: aload 24
    //   393: astore 14
    //   395: goto -195 -> 200
    //   398: astore_3
    //   399: aconst_null
    //   400: astore 4
    //   402: aload 4
    //   404: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   407: aload_3
    //   408: athrow
    //   409: astore 16
    //   411: aload 6
    //   413: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   416: aload 16
    //   418: athrow
    //   419: astore_3
    //   420: aload 6
    //   422: astore 4
    //   424: goto -22 -> 402
    //
    // Exception table:
    //   from	to	target	type
    //   8	47	398	finally
    //   215	288	409	finally
    //   288	365	409	finally
    //   51	75	419	finally
    //   75	182	419	finally
    //   182	191	419	finally
    //   386	391	419	finally
  }

  public int a(ArrayList<ContentProviderOperation> paramArrayList)
  {
    if (paramArrayList.size() > 0);
    try
    {
      int i = this.g.applyBatch("com.viber.voip.provider.vibercontacts", paramArrayList).length;
      return i;
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
      return 0;
    }
    catch (RemoteException localRemoteException)
    {
      label24: break label24;
    }
  }

  public Uri a(w paramw)
  {
    return this.g.insert(a.f.a, paramw.getContentValues());
  }

  // ERROR //
  public x a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   6: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   9: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   12: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   15: invokevirtual 88	com/viber/voip/messages/orm/creator/CreatorHelper:getProjections	()[Ljava/lang/String;
    //   18: ldc_w 441
    //   21: iconst_1
    //   22: anewarray 285	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: aconst_null
    //   30: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull +34 -> 71
    //   40: aload 4
    //   42: invokeinterface 100 1 0
    //   47: ifeq +24 -> 71
    //   50: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   53: aload 4
    //   55: invokevirtual 112	com/viber/voip/messages/orm/creator/CreatorHelper:createInstance	(Landroid/database/Cursor;)Lcom/viber/voip/model/d;
    //   58: checkcast 438	com/viber/voip/model/entity/x
    //   61: astore 5
    //   63: aload 4
    //   65: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   68: aload 5
    //   70: areturn
    //   71: aload 4
    //   73: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_3
    //   79: aload_2
    //   80: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   83: aload_3
    //   84: athrow
    //   85: astore_3
    //   86: aload 4
    //   88: astore_2
    //   89: goto -10 -> 79
    //
    // Exception table:
    //   from	to	target	type
    //   2	35	78	finally
    //   40	63	85	finally
  }

  public String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("viber=");
    int i;
    StringBuilder localStringBuilder2;
    if (paramBoolean)
    {
      i = 0;
      localStringBuilder2 = localStringBuilder1.append(i).append(" AND ").append("_id");
      if (!paramBoolean)
        break label142;
    }
    label142: for (String str = " IN "; ; str = " NOT IN ")
    {
      return str + "(SELECT " + "contact_id" + " FROM " + "phonebookdata" + " WHERE " + "data2" + " IN (SELECT " + "canonized_number" + " FROM  " + "vibernumbers" + " WHERE " + "clear" + "=0))";
      i = 1;
      break;
    }
  }

  // ERROR //
  public List<x> a(Set<String> paramSet)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   6: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   9: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   12: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   15: invokevirtual 88	com/viber/voip/messages/orm/creator/CreatorHelper:getProjections	()[Ljava/lang/String;
    //   18: new 68	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 475
    //   28: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokestatic 404	com/viber/voip/s/a:b	(Ljava/util/Collection;)Ljava/lang/String;
    //   35: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 406
    //   41: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore 4
    //   54: aload 4
    //   56: invokestatic 376	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   59: ifeq +88 -> 147
    //   62: new 183	java/util/ArrayList
    //   65: dup
    //   66: aload 4
    //   68: invokeinterface 339 1 0
    //   73: invokespecial 476	java/util/ArrayList:<init>	(I)V
    //   76: astore 5
    //   78: aload 5
    //   80: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   83: aload 4
    //   85: invokevirtual 112	com/viber/voip/messages/orm/creator/CreatorHelper:createInstance	(Landroid/database/Cursor;)Lcom/viber/voip/model/d;
    //   88: checkcast 438	com/viber/voip/model/entity/x
    //   91: invokeinterface 190 2 0
    //   96: pop
    //   97: aload 4
    //   99: invokeinterface 155 1 0
    //   104: istore 7
    //   106: iload 7
    //   108: ifne -30 -> 78
    //   111: aload 5
    //   113: astore 8
    //   115: aload 4
    //   117: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   120: aload 8
    //   122: ifnonnull +8 -> 130
    //   125: invokestatic 480	java/util/Collections:emptyList	()Ljava/util/List;
    //   128: astore 8
    //   130: aload 8
    //   132: areturn
    //   133: astore_3
    //   134: aload_2
    //   135: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   138: aload_3
    //   139: athrow
    //   140: astore_3
    //   141: aload 4
    //   143: astore_2
    //   144: goto -10 -> 134
    //   147: aconst_null
    //   148: astore 8
    //   150: goto -35 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   2	54	133	finally
    //   54	78	140	finally
    //   78	106	140	finally
  }

  // ERROR //
  public Set<x> a()
  {
    // Byte code:
    //   0: new 169	java/util/HashSet
    //   3: dup
    //   4: invokespecial 481	java/util/HashSet:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   12: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   15: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   18: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   21: invokevirtual 88	com/viber/voip/messages/orm/creator/CreatorHelper:getProjections	()[Ljava/lang/String;
    //   24: ldc 202
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +42 -> 79
    //   40: aload_3
    //   41: invokeinterface 100 1 0
    //   46: ifeq +33 -> 79
    //   49: aload_1
    //   50: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   53: aload_3
    //   54: invokevirtual 112	com/viber/voip/messages/orm/creator/CreatorHelper:createInstance	(Landroid/database/Cursor;)Lcom/viber/voip/model/d;
    //   57: checkcast 438	com/viber/voip/model/entity/x
    //   60: invokeinterface 482 2 0
    //   65: pop
    //   66: aload_3
    //   67: invokeinterface 155 1 0
    //   72: istore 6
    //   74: iload 6
    //   76: ifne -27 -> 49
    //   79: aload_3
    //   80: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_3
    //   89: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: athrow
    //   94: astore_2
    //   95: goto -7 -> 88
    //
    // Exception table:
    //   from	to	target	type
    //   8	33	85	finally
    //   40	49	94	finally
    //   49	74	94	finally
  }

  public void a(final a parama)
  {
    this.f.a(0, null, a.c.a, new String[] { "COUNT(*)" }, "recently_joined_date<>0", null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        int i = 0;
        if (paramAnonymousCursor != null)
        {
          boolean bool = paramAnonymousCursor.moveToFirst();
          i = 0;
          if (bool)
            i = paramAnonymousCursor.getInt(0);
        }
        af.a(paramAnonymousCursor);
        if (parama != null)
          parama.a(i);
      }
    }
    , false, false);
  }

  public void a(Set<String> paramSet, boolean paramBoolean1, boolean paramBoolean2, final a parama)
  {
    synchronized (this.c)
    {
      if (this.d)
      {
        this.c.add(new d(paramSet, paramBoolean1, paramBoolean2, parama));
        return;
      }
      this.d = true;
      a(null, null, null, paramBoolean1, paramBoolean2, new a()
      {
        public void a(int paramAnonymousInt)
        {
          parama.a(paramAnonymousInt);
          synchronized (f.a(f.this))
          {
            f.a(f.this, false);
            if (f.a(f.this).size() > 0)
            {
              f.d locald = (f.d)f.a(f.this).poll();
              f.this.a(locald.d, locald.a, locald.b, locald.c);
            }
            return;
          }
        }
      });
    }
  }

  // ERROR //
  public boolean a(Member paramMember)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   6: astore 4
    //   8: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   11: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   14: astore 5
    //   16: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   19: invokevirtual 88	com/viber/voip/messages/orm/creator/CreatorHelper:getProjections	()[Ljava/lang/String;
    //   22: astore 6
    //   24: iconst_1
    //   25: anewarray 285	java/lang/String
    //   28: astore 7
    //   30: aload 7
    //   32: iconst_0
    //   33: aload_1
    //   34: invokevirtual 515	com/viber/voip/memberid/Member:getId	()Ljava/lang/String;
    //   37: aastore
    //   38: aload 4
    //   40: aload 5
    //   42: aload 6
    //   44: ldc_w 441
    //   47: aload 7
    //   49: aconst_null
    //   50: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore 8
    //   55: aload 8
    //   57: ifnull +171 -> 228
    //   60: aload 8
    //   62: invokeinterface 100 1 0
    //   67: ifeq +161 -> 228
    //   70: getstatic 439	com/viber/voip/model/entity/x:a	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   73: aload 8
    //   75: invokevirtual 112	com/viber/voip/messages/orm/creator/CreatorHelper:createInstance	(Landroid/database/Cursor;)Lcom/viber/voip/model/d;
    //   78: checkcast 438	com/viber/voip/model/entity/x
    //   81: astore 9
    //   83: aload 8
    //   85: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   88: aload 9
    //   90: ifnonnull +114 -> 204
    //   93: new 438	com/viber/voip/model/entity/x
    //   96: dup
    //   97: invokespecial 516	com/viber/voip/model/entity/x:<init>	()V
    //   100: astore 10
    //   102: aload 10
    //   104: aload_1
    //   105: invokevirtual 515	com/viber/voip/memberid/Member:getId	()Ljava/lang/String;
    //   108: invokevirtual 519	com/viber/voip/model/entity/x:e	(Ljava/lang/String;)V
    //   111: aload 10
    //   113: aload_1
    //   114: invokevirtual 522	com/viber/voip/memberid/Member:getPhoneNumber	()Ljava/lang/String;
    //   117: invokevirtual 524	com/viber/voip/model/entity/x:b	(Ljava/lang/String;)V
    //   120: aload_1
    //   121: invokevirtual 527	com/viber/voip/memberid/Member:getPhotoUri	()Landroid/net/Uri;
    //   124: astore 11
    //   126: aconst_null
    //   127: astore 12
    //   129: aload 11
    //   131: ifnull +12 -> 143
    //   134: aload_1
    //   135: invokevirtual 527	com/viber/voip/memberid/Member:getPhotoUri	()Landroid/net/Uri;
    //   138: invokevirtual 532	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   141: astore 12
    //   143: aload 10
    //   145: aload 12
    //   147: invokevirtual 534	com/viber/voip/model/entity/x:c	(Ljava/lang/String;)V
    //   150: aload 10
    //   152: aload_1
    //   153: invokevirtual 537	com/viber/voip/memberid/Member:getViberName	()Ljava/lang/String;
    //   156: invokevirtual 539	com/viber/voip/model/entity/x:d	(Ljava/lang/String;)V
    //   159: aload 10
    //   161: aload_1
    //   162: invokevirtual 542	com/viber/voip/memberid/Member:getViberId	()Ljava/lang/String;
    //   165: invokevirtual 544	com/viber/voip/model/entity/x:f	(Ljava/lang/String;)V
    //   168: aload_1
    //   169: invokevirtual 547	com/viber/voip/memberid/Member:getEncryptedMemberId	()Ljava/lang/String;
    //   172: ifnull +41 -> 213
    //   175: aload_1
    //   176: invokevirtual 547	com/viber/voip/memberid/Member:getEncryptedMemberId	()Ljava/lang/String;
    //   179: astore 13
    //   181: aload 10
    //   183: aload 13
    //   185: invokevirtual 549	com/viber/voip/model/entity/x:a	(Ljava/lang/String;)V
    //   188: aload_0
    //   189: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   192: getstatic 194	com/viber/provider/contacts/a$g:a	Landroid/net/Uri;
    //   195: aload 10
    //   197: invokevirtual 550	com/viber/voip/model/entity/x:getContentValues	()Landroid/content/ContentValues;
    //   200: invokevirtual 435	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   203: pop
    //   204: iconst_1
    //   205: ireturn
    //   206: astore_3
    //   207: aload_2
    //   208: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   211: aload_3
    //   212: athrow
    //   213: ldc_w 552
    //   216: astore 13
    //   218: goto -37 -> 181
    //   221: astore_3
    //   222: aload 8
    //   224: astore_2
    //   225: goto -18 -> 207
    //   228: aconst_null
    //   229: astore 9
    //   231: goto -148 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   2	55	206	finally
    //   60	83	221	finally
  }

  public a.a b(boolean paramBoolean)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet3 = new HashSet();
    String str2;
    if (paramBoolean)
    {
      str2 = g();
      a(localHashSet1);
    }
    for (String str1 = str2; ; str1 = a(localHashSet1, localHashSet2, localHashSet3))
      return new a.a((CContactInfo[])localHashSet1.toArray(new CContactInfo[localHashSet1.size()]), (CContactInfo[])localHashSet2.toArray(new CContactInfo[localHashSet2.size()]), (CContactInfo[])localHashSet3.toArray(new CContactInfo[localHashSet3.size()]), str1);
  }

  // ERROR //
  public List<com.viber.voip.model.entity.e> b(String paramString)
  {
    // Byte code:
    //   0: new 183	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 184	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   12: astore 5
    //   14: getstatic 577	com/viber/voip/model/entity/e:E	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   17: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   20: astore 6
    //   22: getstatic 577	com/viber/voip/model/entity/e:E	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   25: invokevirtual 88	com/viber/voip/messages/orm/creator/CreatorHelper:getProjections	()[Ljava/lang/String;
    //   28: astore 7
    //   30: iconst_2
    //   31: anewarray 285	java/lang/String
    //   34: astore 8
    //   36: aload 8
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aload 8
    //   43: iconst_1
    //   44: iconst_0
    //   45: invokestatic 579	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   48: aastore
    //   49: aload 5
    //   51: aload 6
    //   53: aload 7
    //   55: ldc_w 581
    //   58: aload 8
    //   60: aconst_null
    //   61: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 9
    //   66: aload 9
    //   68: astore 4
    //   70: aload 4
    //   72: ifnull +45 -> 117
    //   75: aload 4
    //   77: invokeinterface 100 1 0
    //   82: ifeq +35 -> 117
    //   85: aload_2
    //   86: getstatic 577	com/viber/voip/model/entity/e:E	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   89: aload 4
    //   91: invokevirtual 112	com/viber/voip/messages/orm/creator/CreatorHelper:createInstance	(Landroid/database/Cursor;)Lcom/viber/voip/model/d;
    //   94: checkcast 574	com/viber/voip/model/entity/e
    //   97: invokeinterface 190 2 0
    //   102: pop
    //   103: aload 4
    //   105: invokeinterface 155 1 0
    //   110: istore 11
    //   112: iload 11
    //   114: ifne -29 -> 85
    //   117: aload 4
    //   119: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   122: aload_2
    //   123: areturn
    //   124: astore_3
    //   125: aconst_null
    //   126: astore 4
    //   128: aload 4
    //   130: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: goto -8 -> 128
    //
    // Exception table:
    //   from	to	target	type
    //   8	66	124	finally
    //   75	85	135	finally
    //   85	112	135	finally
  }

  // ERROR //
  public java.util.Map<String, c> b(Set<String> paramSet)
  {
    // Byte code:
    //   0: new 71	java/util/HashMap
    //   3: dup
    //   4: invokespecial 72	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   12: getstatic 583	com/viber/provider/contacts/a$e:b	Landroid/net/Uri;
    //   15: iconst_3
    //   16: anewarray 285	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 585
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 587
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc_w 589
    //   36: aastore
    //   37: new 68	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 591
    //   47: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokestatic 404	com/viber/voip/s/a:b	(Ljava/util/Collection;)Ljava/lang/String;
    //   54: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 406
    //   60: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +75 -> 150
    //   78: aload 5
    //   80: invokeinterface 100 1 0
    //   85: ifeq +65 -> 150
    //   88: new 593	com/viber/voip/contacts/c/f/b/f$c
    //   91: dup
    //   92: aload 5
    //   94: iconst_0
    //   95: invokeinterface 362 2 0
    //   100: aload 5
    //   102: iconst_1
    //   103: invokeinterface 123 2 0
    //   108: aload 5
    //   110: iconst_2
    //   111: invokeinterface 123 2 0
    //   116: aconst_null
    //   117: invokespecial 596	com/viber/voip/contacts/c/f/b/f$c:<init>	(JLjava/lang/String;Ljava/lang/String;Lcom/viber/voip/contacts/c/f/b/f$1;)V
    //   120: astore 6
    //   122: aload_2
    //   123: aload 6
    //   125: getfield 599	com/viber/voip/contacts/c/f/b/f$c:b	Ljava/lang/String;
    //   128: aload 6
    //   130: invokeinterface 390 3 0
    //   135: pop
    //   136: aload 5
    //   138: invokeinterface 155 1 0
    //   143: istore 8
    //   145: iload 8
    //   147: ifne -59 -> 88
    //   150: aload 5
    //   152: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   155: aload_2
    //   156: areturn
    //   157: astore_3
    //   158: aconst_null
    //   159: astore 4
    //   161: aload 4
    //   163: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   166: aload_3
    //   167: athrow
    //   168: astore_3
    //   169: aload 5
    //   171: astore 4
    //   173: goto -12 -> 161
    //
    // Exception table:
    //   from	to	target	type
    //   8	73	157	finally
    //   78	88	168	finally
    //   88	145	168	finally
  }

  // ERROR //
  public Set<String> b()
  {
    // Byte code:
    //   0: new 169	java/util/HashSet
    //   3: dup
    //   4: invokespecial 481	java/util/HashSet:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   12: getstatic 604	com/viber/voip/model/entity/t:j	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   15: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   18: iconst_1
    //   19: anewarray 285	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc_w 287
    //   27: aastore
    //   28: ldc_w 606
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 4
    //   38: aload 4
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +39 -> 81
    //   45: aload_3
    //   46: invokeinterface 100 1 0
    //   51: ifeq +30 -> 81
    //   54: aload_1
    //   55: aload_3
    //   56: iconst_0
    //   57: invokeinterface 123 2 0
    //   62: invokeinterface 482 2 0
    //   67: pop
    //   68: aload_3
    //   69: invokeinterface 155 1 0
    //   74: istore 6
    //   76: iload 6
    //   78: ifne -24 -> 54
    //   81: aload_3
    //   82: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   85: aload_1
    //   86: areturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_3
    //   90: aload_3
    //   91: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   94: aload_2
    //   95: athrow
    //   96: astore_2
    //   97: goto -7 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   8	38	87	finally
    //   45	54	96	finally
    //   54	76	96	finally
  }

  public boolean b(Member paramMember)
  {
    Uri localUri1 = paramMember.getPhotoUri();
    ContentValues localContentValues = new ContentValues(1);
    if (localUri1 != null);
    for (String str = localUri1.getLastPathSegment(); ; str = null)
    {
      localContentValues.put("photo", str);
      ContentResolver localContentResolver = this.g;
      Uri localUri2 = a.g.a;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramMember.getId();
      localContentResolver.update(localUri2, localContentValues, "member_id=?", arrayOfString);
      return true;
    }
  }

  // ERROR //
  public List<com.viber.voip.model.entity.e> c()
  {
    // Byte code:
    //   0: new 183	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 184	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   12: getstatic 577	com/viber/voip/model/entity/e:E	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   15: invokevirtual 327	com/viber/voip/messages/orm/creator/CreatorHelper:getContentUri	()Landroid/net/Uri;
    //   18: getstatic 577	com/viber/voip/model/entity/e:E	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   21: invokevirtual 88	com/viber/voip/messages/orm/creator/CreatorHelper:getProjections	()[Ljava/lang/String;
    //   24: ldc_w 620
    //   27: aconst_null
    //   28: ldc_w 622
    //   31: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +42 -> 82
    //   43: aload_3
    //   44: invokeinterface 100 1 0
    //   49: ifeq +33 -> 82
    //   52: aload_1
    //   53: getstatic 577	com/viber/voip/model/entity/e:E	Lcom/viber/voip/messages/orm/creator/CreatorHelper;
    //   56: aload_3
    //   57: invokevirtual 112	com/viber/voip/messages/orm/creator/CreatorHelper:createInstance	(Landroid/database/Cursor;)Lcom/viber/voip/model/d;
    //   60: checkcast 574	com/viber/voip/model/entity/e
    //   63: invokeinterface 190 2 0
    //   68: pop
    //   69: aload_3
    //   70: invokeinterface 155 1 0
    //   75: istore 6
    //   77: iload 6
    //   79: ifne -27 -> 52
    //   82: aload_3
    //   83: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   86: aload_1
    //   87: areturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_3
    //   91: aload_3
    //   92: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: goto -7 -> 91
    //
    // Exception table:
    //   from	to	target	type
    //   8	36	88	finally
    //   43	52	97	finally
    //   52	77	97	finally
  }

  // ERROR //
  public java.util.Map<String, b> c(Set<String> paramSet)
  {
    // Byte code:
    //   0: new 71	java/util/HashMap
    //   3: dup
    //   4: invokespecial 72	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   12: getstatic 624	com/viber/provider/contacts/a$c:j	Landroid/net/Uri;
    //   15: iconst_4
    //   16: anewarray 285	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 305
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 626
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc_w 628
    //   36: aastore
    //   37: dup
    //   38: iconst_3
    //   39: ldc_w 589
    //   42: aastore
    //   43: new 68	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 630
    //   53: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokestatic 404	com/viber/voip/s/a:b	(Ljava/util/Collection;)Ljava/lang/String;
    //   60: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 406
    //   66: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: aconst_null
    //   73: aconst_null
    //   74: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnull +83 -> 164
    //   84: aload 5
    //   86: invokeinterface 100 1 0
    //   91: ifeq +73 -> 164
    //   94: new 632	com/viber/voip/contacts/c/f/b/f$b
    //   97: dup
    //   98: aload 5
    //   100: iconst_0
    //   101: invokeinterface 362 2 0
    //   106: aload 5
    //   108: iconst_1
    //   109: invokeinterface 119 2 0
    //   114: aload 5
    //   116: iconst_2
    //   117: invokeinterface 362 2 0
    //   122: aload 5
    //   124: iconst_3
    //   125: invokeinterface 123 2 0
    //   130: aconst_null
    //   131: invokespecial 635	com/viber/voip/contacts/c/f/b/f$b:<init>	(JIJLjava/lang/String;Lcom/viber/voip/contacts/c/f/b/f$1;)V
    //   134: astore 6
    //   136: aload_2
    //   137: aload 6
    //   139: getfield 637	com/viber/voip/contacts/c/f/b/f$b:d	Ljava/lang/String;
    //   142: aload 6
    //   144: invokeinterface 390 3 0
    //   149: pop
    //   150: aload 5
    //   152: invokeinterface 155 1 0
    //   157: istore 8
    //   159: iload 8
    //   161: ifne -67 -> 94
    //   164: aload 5
    //   166: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   169: aload_2
    //   170: areturn
    //   171: astore_3
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 4
    //   177: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   180: aload_3
    //   181: athrow
    //   182: astore_3
    //   183: aload 5
    //   185: astore 4
    //   187: goto -12 -> 175
    //
    // Exception table:
    //   from	to	target	type
    //   8	79	171	finally
    //   84	94	182	finally
    //   94	159	182	finally
  }

  public boolean c(String paramString)
  {
    return this.g.delete(x.a.getContentUri(), "member_id=?", new String[] { paramString }) > 0;
  }

  public int d(String paramString)
  {
    return this.g.delete(w.a.getContentUri(), "_id IN (" + paramString + ")", null);
  }

  public void d()
  {
    this.g.update(a.c.l, null, "phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE clear=1)", null);
  }

  // ERROR //
  public int e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   4: getstatic 215	com/viber/provider/contacts/a$c:a	Landroid/net/Uri;
    //   7: iconst_1
    //   8: anewarray 285	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc_w 485
    //   16: aastore
    //   17: ldc_w 646
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +58 -> 87
    //   32: aload_2
    //   33: invokeinterface 100 1 0
    //   38: ifeq +49 -> 87
    //   41: aload_2
    //   42: ifnull +45 -> 87
    //   45: aload_2
    //   46: invokeinterface 100 1 0
    //   51: ifeq +36 -> 87
    //   54: aload_2
    //   55: iconst_0
    //   56: invokeinterface 119 2 0
    //   61: istore 5
    //   63: iload 5
    //   65: istore 4
    //   67: aload_2
    //   68: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   71: iload 4
    //   73: ireturn
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: goto -7 -> 77
    //   87: iconst_0
    //   88: istore 4
    //   90: goto -23 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   0	26	74	finally
    //   32	41	83	finally
    //   45	63	83	finally
  }

  // ERROR //
  public int f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/viber/voip/contacts/c/f/b/f:g	Landroid/content/ContentResolver;
    //   4: getstatic 215	com/viber/provider/contacts/a$c:a	Landroid/net/Uri;
    //   7: iconst_1
    //   8: anewarray 285	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc_w 485
    //   16: aastore
    //   17: ldc_w 648
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +58 -> 87
    //   32: aload_2
    //   33: invokeinterface 100 1 0
    //   38: ifeq +49 -> 87
    //   41: aload_2
    //   42: ifnull +45 -> 87
    //   45: aload_2
    //   46: invokeinterface 100 1 0
    //   51: ifeq +36 -> 87
    //   54: aload_2
    //   55: iconst_0
    //   56: invokeinterface 119 2 0
    //   61: istore 5
    //   63: iload 5
    //   65: istore 4
    //   67: aload_2
    //   68: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   71: iload 4
    //   73: ireturn
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 160	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: goto -7 -> 77
    //   87: iconst_0
    //   88: istore 4
    //   90: goto -23 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   0	26	74	finally
    //   32	41	83	finally
    //   45	63	83	finally
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }

  public static class b
  {
    public final long a;
    public final int b;
    public final long c;
    public final String d;

    private b(long paramLong1, int paramInt, long paramLong2, String paramString)
    {
      this.a = paramLong1;
      this.b = paramInt;
      this.c = paramLong2;
      this.d = paramString;
    }
  }

  public static class c
  {
    public final long a;
    public final String b;
    public final String c;

    private c(long paramLong, String paramString1, String paramString2)
    {
      this.a = paramLong;
      this.b = paramString1;
      this.c = paramString2;
    }

    public String toString()
    {
      return "DataNumberInfo{id=" + this.a + ", number='" + this.b + '\'' + ", name='" + this.c + '\'' + '}';
    }
  }

  private class d
  {
    final boolean a;
    final boolean b;
    final f.a c;
    final Set<String> d;

    public d(boolean paramBoolean1, boolean parama, f.a arg4)
    {
      this.a = parama;
      boolean bool;
      this.b = bool;
      Object localObject;
      this.c = localObject;
      this.d = paramBoolean1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b.f
 * JD-Core Version:    0.6.2
 */