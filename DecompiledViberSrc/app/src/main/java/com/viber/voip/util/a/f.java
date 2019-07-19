package com.viber.voip.util.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class f
{
  private static final Logger a = ViberEnv.getLogger();

  public static String a(String paramString)
  {
    int i = 0;
    while (true)
    {
      int k;
      if (i < paramString.length())
      {
        k = paramString.codePointAt(i);
        if (!Character.isLetterOrDigit(k));
      }
      else
      {
        if (i != paramString.length())
          break;
        return "";
      }
      i += Character.charCount(k);
    }
    for (int j = -1 + paramString.length(); ; j--)
      if (j > -1)
      {
        if (Character.isLowSurrogate(paramString.charAt(j)))
          j--;
        if (!Character.isLetterOrDigit(paramString.codePointAt(j)));
      }
      else
      {
        return paramString.substring(i, j + 1);
      }
  }

  // ERROR //
  public static java.util.Set<java.lang.Long> a(android.content.Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 55	java/util/HashSet
    //   3: dup
    //   4: invokespecial 58	java/util/HashSet:<init>	()V
    //   7: astore_3
    //   8: aload_1
    //   9: ldc 60
    //   11: ldc 62
    //   13: invokevirtual 66	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 4
    //   18: aload 4
    //   20: invokestatic 72	com/viber/voip/util/a/e:m	(Ljava/lang/String;)Z
    //   23: ifeq +69 -> 92
    //   26: aload 4
    //   28: ldc 62
    //   30: invokevirtual 76	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   33: ifne +59 -> 92
    //   36: aload 4
    //   38: invokestatic 79	com/viber/voip/util/a/e:a	(Ljava/lang/String;)I
    //   41: istore 21
    //   43: iconst_m1
    //   44: iload 21
    //   46: if_icmpeq +46 -> 92
    //   49: new 81	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   56: aload 4
    //   58: iconst_0
    //   59: iload 21
    //   61: invokevirtual 50	java/lang/String:substring	(II)Ljava/lang/String;
    //   64: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 62
    //   69: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: iload 21
    //   76: aload 4
    //   78: invokevirtual 23	java/lang/String:length	()I
    //   81: invokevirtual 50	java/lang/String:substring	(II)Ljava/lang/String;
    //   84: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 4
    //   92: aload 4
    //   94: invokevirtual 93	java/lang/String:trim	()Ljava/lang/String;
    //   97: invokevirtual 96	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   100: invokestatic 98	com/viber/voip/util/a/f:a	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 5
    //   105: aload 5
    //   107: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +249 -> 359
    //   113: aload 5
    //   115: invokestatic 72	com/viber/voip/util/a/e:m	(Ljava/lang/String;)Z
    //   118: istore 6
    //   120: aconst_null
    //   121: astore 7
    //   123: iload 6
    //   125: ifeq +140 -> 265
    //   128: aconst_null
    //   129: astore 7
    //   131: iload_2
    //   132: ifeq +133 -> 265
    //   135: new 81	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   142: ldc 105
    //   144: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 5
    //   149: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 105
    //   154: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore 14
    //   162: iconst_3
    //   163: anewarray 19	java/lang/String
    //   166: dup
    //   167: iconst_0
    //   168: ldc 107
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload 14
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload 14
    //   180: aastore
    //   181: astore 15
    //   183: aload_0
    //   184: invokevirtual 113	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   187: getstatic 119	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   190: iconst_1
    //   191: anewarray 19	java/lang/String
    //   194: dup
    //   195: iconst_0
    //   196: ldc 121
    //   198: aastore
    //   199: ldc 123
    //   201: aload 15
    //   203: aconst_null
    //   204: invokevirtual 129	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   207: astore 17
    //   209: aload 17
    //   211: ifnull +45 -> 256
    //   214: aload 17
    //   216: invokeinterface 135 1 0
    //   221: ifeq +35 -> 256
    //   224: aload_3
    //   225: aload 17
    //   227: iconst_0
    //   228: invokeinterface 139 2 0
    //   233: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   236: invokeinterface 151 2 0
    //   241: pop
    //   242: aload 17
    //   244: invokeinterface 154 1 0
    //   249: istore 20
    //   251: iload 20
    //   253: ifne -29 -> 224
    //   256: aload 17
    //   258: invokestatic 159	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   261: aload 17
    //   263: astore 7
    //   265: getstatic 164	android/provider/ContactsContract$Contacts:CONTENT_FILTER_URI	Landroid/net/Uri;
    //   268: invokevirtual 170	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   271: astore 8
    //   273: aload 8
    //   275: aload 5
    //   277: invokevirtual 176	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   280: pop
    //   281: aload_0
    //   282: invokevirtual 113	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   285: aload 8
    //   287: invokevirtual 180	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   290: iconst_1
    //   291: anewarray 19	java/lang/String
    //   294: dup
    //   295: iconst_0
    //   296: ldc 182
    //   298: aastore
    //   299: aconst_null
    //   300: aconst_null
    //   301: aconst_null
    //   302: invokevirtual 129	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   305: astore 7
    //   307: aload 7
    //   309: ifnull +45 -> 354
    //   312: aload 7
    //   314: invokeinterface 135 1 0
    //   319: ifeq +35 -> 354
    //   322: aload_3
    //   323: aload 7
    //   325: iconst_0
    //   326: invokeinterface 139 2 0
    //   331: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   334: invokeinterface 151 2 0
    //   339: pop
    //   340: aload 7
    //   342: invokeinterface 154 1 0
    //   347: istore 13
    //   349: iload 13
    //   351: ifne -29 -> 322
    //   354: aload 7
    //   356: invokestatic 159	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   359: aload_3
    //   360: areturn
    //   361: astore 16
    //   363: aload 7
    //   365: invokestatic 159	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   368: aload 16
    //   370: athrow
    //   371: astore 11
    //   373: aload 7
    //   375: invokestatic 159	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   378: aload_3
    //   379: areturn
    //   380: astore 10
    //   382: aload 7
    //   384: invokestatic 159	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   387: aload 10
    //   389: athrow
    //   390: astore 18
    //   392: aload 17
    //   394: astore 7
    //   396: aload 18
    //   398: astore 16
    //   400: goto -37 -> 363
    //
    // Exception table:
    //   from	to	target	type
    //   183	209	361	finally
    //   281	307	371	java/lang/Exception
    //   312	322	371	java/lang/Exception
    //   322	349	371	java/lang/Exception
    //   281	307	380	finally
    //   312	322	380	finally
    //   322	349	380	finally
    //   214	224	390	finally
    //   224	251	390	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.a.f
 * JD-Core Version:    0.6.2
 */