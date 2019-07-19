package com.viber.service.contacts.a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;

public class a
{
  private static final Logger a = ViberEnv.getLogger();

  // ERROR //
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 26	com/viber/voip/registration/ao:f	()Z
    //   3: ifeq +9 -> 12
    //   6: iconst_0
    //   7: istore 9
    //   9: iload 9
    //   11: ireturn
    //   12: aload_0
    //   13: invokestatic 31	com/viber/voip/util/x:a	(Landroid/content/Context;)Z
    //   16: ifne +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: iconst_0
    //   22: newarray long
    //   24: astore_1
    //   25: aload_0
    //   26: getstatic 36	com/viber/provider/contacts/a$c:a	Landroid/net/Uri;
    //   29: iconst_1
    //   30: anewarray 38	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 40
    //   37: aastore
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokestatic 45	com/viber/voip/util/af:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 4
    //   46: aload 4
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +494 -> 546
    //   55: aload 5
    //   57: invokeinterface 50 1 0
    //   62: ifeq +484 -> 546
    //   65: aload 5
    //   67: ldc 40
    //   69: invokeinterface 54 2 0
    //   74: istore 25
    //   76: aload 5
    //   78: invokeinterface 58 1 0
    //   83: newarray long
    //   85: astore 6
    //   87: iconst_0
    //   88: istore 26
    //   90: aload 6
    //   92: iload 26
    //   94: aload 5
    //   96: iload 25
    //   98: invokeinterface 62 2 0
    //   103: i2l
    //   104: lastore
    //   105: iinc 26 1
    //   108: aload 5
    //   110: invokeinterface 65 1 0
    //   115: istore 27
    //   117: iload 27
    //   119: ifne -29 -> 90
    //   122: aload 5
    //   124: ifnull +8 -> 132
    //   127: aload 5
    //   129: invokestatic 68	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   132: iconst_4
    //   133: anewarray 38	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: ldc 40
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: ldc 70
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: ldc 72
    //   150: aastore
    //   151: dup
    //   152: iconst_3
    //   153: ldc 74
    //   155: aastore
    //   156: astore 7
    //   158: aload_0
    //   159: getstatic 79	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   162: aload 7
    //   164: new 81	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   171: ldc 84
    //   173: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 6
    //   178: invokestatic 93	com/viber/voip/s/a:a	([J)Ljava/lang/String;
    //   181: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc 95
    //   186: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aconst_null
    //   193: aconst_null
    //   194: invokestatic 45	com/viber/voip/util/af:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   197: astore 5
    //   199: aload 5
    //   201: ifnull +339 -> 540
    //   204: aload 5
    //   206: invokeinterface 50 1 0
    //   211: ifeq +329 -> 540
    //   214: aload 5
    //   216: ldc 40
    //   218: invokeinterface 54 2 0
    //   223: istore 10
    //   225: aload 5
    //   227: ldc 70
    //   229: invokeinterface 54 2 0
    //   234: istore 11
    //   236: aload 5
    //   238: ldc 72
    //   240: invokeinterface 54 2 0
    //   245: istore 12
    //   247: aload 5
    //   249: ldc 74
    //   251: invokeinterface 54 2 0
    //   256: istore 13
    //   258: aload 5
    //   260: invokeinterface 58 1 0
    //   265: sipush 200
    //   268: if_icmple +234 -> 502
    //   271: sipush 200
    //   274: istore 14
    //   276: new 101	java/util/ArrayList
    //   279: dup
    //   280: iload 14
    //   282: invokespecial 104	java/util/ArrayList:<init>	(I)V
    //   285: astore 15
    //   287: iconst_0
    //   288: istore 16
    //   290: aload 5
    //   292: iload 10
    //   294: invokeinterface 108 2 0
    //   299: lstore 17
    //   301: aload 5
    //   303: iload 13
    //   305: invokeinterface 112 2 0
    //   310: aload 5
    //   312: iload 11
    //   314: invokeinterface 112 2 0
    //   319: aload 5
    //   321: iload 12
    //   323: invokeinterface 112 2 0
    //   328: invokestatic 117	com/viber/voip/util/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/util/a/b$a;
    //   331: astore 19
    //   333: getstatic 36	com/viber/provider/contacts/a$c:a	Landroid/net/Uri;
    //   336: invokestatic 123	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   339: astore 20
    //   341: iconst_1
    //   342: anewarray 38	java/lang/String
    //   345: astore 21
    //   347: aload 21
    //   349: iconst_0
    //   350: lload 17
    //   352: invokestatic 127	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   355: aastore
    //   356: aload 15
    //   358: aload 20
    //   360: ldc 129
    //   362: aload 21
    //   364: invokevirtual 135	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   367: ldc 74
    //   369: aload 19
    //   371: getfield 140	com/viber/voip/util/a/b$a:a	Ljava/lang/String;
    //   374: invokevirtual 144	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   377: ldc 70
    //   379: aload 19
    //   381: getfield 147	com/viber/voip/util/a/b$a:b	Ljava/lang/String;
    //   384: invokevirtual 144	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   387: ldc 149
    //   389: aload 19
    //   391: getfield 152	com/viber/voip/util/a/b$a:c	Ljava/lang/String;
    //   394: invokevirtual 144	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   397: ldc 154
    //   399: aload 19
    //   401: getfield 157	com/viber/voip/util/a/b$a:d	Ljava/lang/String;
    //   404: invokevirtual 144	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   407: invokevirtual 161	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   410: invokevirtual 165	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   413: pop
    //   414: aload 15
    //   416: invokevirtual 168	java/util/ArrayList:size	()I
    //   419: sipush 200
    //   422: if_icmple +24 -> 446
    //   425: aload_0
    //   426: aload 15
    //   428: invokestatic 171	com/viber/service/contacts/a/a:a	(Landroid/content/Context;Ljava/util/ArrayList;)V
    //   431: iload 16
    //   433: aload 15
    //   435: invokevirtual 168	java/util/ArrayList:size	()I
    //   438: iadd
    //   439: istore 16
    //   441: aload 15
    //   443: invokevirtual 174	java/util/ArrayList:clear	()V
    //   446: aload 5
    //   448: invokeinterface 65 1 0
    //   453: ifne -163 -> 290
    //   456: aload_0
    //   457: aload 15
    //   459: invokestatic 171	com/viber/service/contacts/a/a:a	(Landroid/content/Context;Ljava/util/ArrayList;)V
    //   462: aload 15
    //   464: invokevirtual 168	java/util/ArrayList:size	()I
    //   467: istore 23
    //   469: iload 16
    //   471: iload 23
    //   473: iadd
    //   474: istore 9
    //   476: aload 5
    //   478: ifnull -469 -> 9
    //   481: aload 5
    //   483: invokestatic 68	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   486: iload 9
    //   488: ireturn
    //   489: astore_2
    //   490: aconst_null
    //   491: astore_3
    //   492: aload_3
    //   493: ifnull +7 -> 500
    //   496: aload_3
    //   497: invokestatic 68	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   500: aload_2
    //   501: athrow
    //   502: aload 5
    //   504: invokeinterface 58 1 0
    //   509: istore 24
    //   511: iload 24
    //   513: istore 14
    //   515: goto -239 -> 276
    //   518: astore 8
    //   520: aload 5
    //   522: ifnull +8 -> 530
    //   525: aload 5
    //   527: invokestatic 68	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   530: aload 8
    //   532: athrow
    //   533: astore_2
    //   534: aload 5
    //   536: astore_3
    //   537: goto -45 -> 492
    //   540: iconst_0
    //   541: istore 9
    //   543: goto -67 -> 476
    //   546: aload_1
    //   547: astore 6
    //   549: goto -427 -> 122
    //
    // Exception table:
    //   from	to	target	type
    //   25	46	489	finally
    //   132	199	518	finally
    //   204	271	518	finally
    //   276	287	518	finally
    //   290	446	518	finally
    //   446	469	518	finally
    //   502	511	518	finally
    //   55	87	533	finally
    //   90	105	533	finally
    //   108	117	533	finally
  }

  private static void a(Context paramContext, ArrayList<ContentProviderOperation> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
      return;
    try
    {
      paramContext.getContentResolver().applyBatch("com.viber.voip.provider.vibercontacts", paramArrayList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
    }
  }

  // ERROR //
  public static int b(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 194	com/viber/voip/util/a/b:a	()Z
    //   3: ifne +9 -> 12
    //   6: iconst_0
    //   7: istore 8
    //   9: iload 8
    //   11: ireturn
    //   12: aload_0
    //   13: invokestatic 31	com/viber/voip/util/x:a	(Landroid/content/Context;)Z
    //   16: ifne +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: new 101	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 195	java/util/ArrayList:<init>	()V
    //   28: astore_1
    //   29: iconst_2
    //   30: anewarray 38	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 40
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc 149
    //   42: aastore
    //   43: astore_2
    //   44: aload_0
    //   45: getstatic 36	com/viber/provider/contacts/a$c:a	Landroid/net/Uri;
    //   48: aload_2
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: invokestatic 45	com/viber/voip/util/af:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore 5
    //   57: aload 5
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +115 -> 178
    //   66: aload 4
    //   68: invokeinterface 50 1 0
    //   73: ifeq +105 -> 178
    //   76: aload 4
    //   78: ldc 40
    //   80: invokeinterface 54 2 0
    //   85: istore 9
    //   87: aload 4
    //   89: ldc 149
    //   91: invokeinterface 54 2 0
    //   96: istore 10
    //   98: aload 4
    //   100: iload 10
    //   102: invokeinterface 112 2 0
    //   107: astore 11
    //   109: aload 11
    //   111: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +54 -> 168
    //   117: aload 11
    //   119: iconst_0
    //   120: invokevirtual 205	java/lang/String:charAt	(I)C
    //   123: istore 12
    //   125: iload 12
    //   127: invokestatic 211	java/lang/Character:isDigit	(C)Z
    //   130: ifne +19 -> 149
    //   133: iload 12
    //   135: invokestatic 211	java/lang/Character:isDigit	(C)Z
    //   138: ifne +30 -> 168
    //   141: iload 12
    //   143: invokestatic 214	java/lang/Character:isLetter	(C)Z
    //   146: ifne +22 -> 168
    //   149: aload_1
    //   150: aload 4
    //   152: iload 9
    //   154: invokeinterface 108 2 0
    //   159: invokestatic 219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   162: invokeinterface 222 2 0
    //   167: pop
    //   168: aload 4
    //   170: invokeinterface 65 1 0
    //   175: ifne -77 -> 98
    //   178: aload_1
    //   179: invokeinterface 223 1 0
    //   184: ifle +101 -> 285
    //   187: new 225	android/content/ContentValues
    //   190: dup
    //   191: iconst_1
    //   192: invokespecial 226	android/content/ContentValues:<init>	(I)V
    //   195: astore 6
    //   197: aload 6
    //   199: ldc 149
    //   201: ldc 228
    //   203: invokevirtual 232	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_0
    //   207: invokevirtual 184	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   210: getstatic 36	com/viber/provider/contacts/a$c:a	Landroid/net/Uri;
    //   213: aload 6
    //   215: new 81	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   222: ldc 84
    //   224: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokestatic 236	com/viber/voip/s/a:e	(Ljava/util/Collection;)Ljava/lang/String;
    //   231: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc 95
    //   236: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: aconst_null
    //   243: invokevirtual 240	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   246: istore 7
    //   248: iload 7
    //   250: istore 8
    //   252: aload 4
    //   254: ifnull -245 -> 9
    //   257: aload 4
    //   259: invokestatic 68	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   262: iload 8
    //   264: ireturn
    //   265: astore_3
    //   266: aconst_null
    //   267: astore 4
    //   269: aload 4
    //   271: ifnull +8 -> 279
    //   274: aload 4
    //   276: invokestatic 68	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   279: aload_3
    //   280: athrow
    //   281: astore_3
    //   282: goto -13 -> 269
    //   285: iconst_0
    //   286: istore 8
    //   288: goto -36 -> 252
    //
    // Exception table:
    //   from	to	target	type
    //   44	57	265	finally
    //   66	98	281	finally
    //   98	149	281	finally
    //   149	168	281	finally
    //   168	178	281	finally
    //   178	248	281	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.a.a
 * JD-Core Version:    0.6.2
 */