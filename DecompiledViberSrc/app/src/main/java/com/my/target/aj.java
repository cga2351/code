package com.my.target;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;

public final class aj extends al
{
  private boolean a = false;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private float p = 0.0F;
  private String q = "";
  private String r = "";
  private String s = "";
  private String t = "";
  private String u = "";

  private void c(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    if (localWindowManager == null)
      return;
    Display localDisplay = localWindowManager.getDefaultDisplay();
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17)
      localDisplay.getRealSize(localPoint);
    while (true)
    {
      this.m = localPoint.x;
      this.n = localPoint.y;
      return;
      localDisplay.getSize(localPoint);
    }
  }

  // ERROR //
  private boolean c()
  {
    // Byte code:
    //   0: getstatic 126	android/os/Build:TAGS	Ljava/lang/String;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnull +448 -> 453
    //   8: aload_1
    //   9: ldc 128
    //   11: invokevirtual 134	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +439 -> 453
    //   17: iconst_1
    //   18: istore_2
    //   19: iload_2
    //   20: ifne +96 -> 116
    //   23: bipush 10
    //   25: anewarray 130	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc 136
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: ldc 138
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: ldc 140
    //   42: aastore
    //   43: dup
    //   44: iconst_3
    //   45: ldc 142
    //   47: aastore
    //   48: dup
    //   49: iconst_4
    //   50: ldc 144
    //   52: aastore
    //   53: dup
    //   54: iconst_5
    //   55: ldc 146
    //   57: aastore
    //   58: dup
    //   59: bipush 6
    //   61: ldc 148
    //   63: aastore
    //   64: dup
    //   65: bipush 7
    //   67: ldc 150
    //   69: aastore
    //   70: dup
    //   71: bipush 8
    //   73: ldc 152
    //   75: aastore
    //   76: dup
    //   77: bipush 9
    //   79: ldc 154
    //   81: aastore
    //   82: astore_3
    //   83: aload_3
    //   84: arraylength
    //   85: istore 4
    //   87: iconst_0
    //   88: istore 5
    //   90: iload 5
    //   92: iload 4
    //   94: if_icmpge +22 -> 116
    //   97: new 156	java/io/File
    //   100: dup
    //   101: aload_3
    //   102: iload 5
    //   104: aaload
    //   105: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 162	java/io/File:exists	()Z
    //   111: ifeq +151 -> 262
    //   114: iconst_1
    //   115: istore_2
    //   116: iload_2
    //   117: ifne +334 -> 451
    //   120: invokestatic 168	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   123: astore 6
    //   125: iconst_3
    //   126: anewarray 130	java/lang/String
    //   129: dup
    //   130: iconst_0
    //   131: ldc 170
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: ldc 172
    //   138: aastore
    //   139: dup
    //   140: iconst_2
    //   141: ldc 174
    //   143: aastore
    //   144: astore 7
    //   146: aload 7
    //   148: arraylength
    //   149: istore 8
    //   151: iconst_0
    //   152: istore 9
    //   154: iload 9
    //   156: iload 8
    //   158: if_icmpge +293 -> 451
    //   161: aload 7
    //   163: iload 9
    //   165: aaload
    //   166: astore 10
    //   168: aload 6
    //   170: aload 10
    //   172: invokevirtual 178	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   175: astore 17
    //   177: aload 17
    //   179: astore 15
    //   181: new 180	java/io/BufferedReader
    //   184: dup
    //   185: new 182	java/io/InputStreamReader
    //   188: dup
    //   189: aload 15
    //   191: invokevirtual 188	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   194: invokespecial 191	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   197: invokespecial 194	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   200: astore 18
    //   202: new 196	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   209: astore 19
    //   211: aload 18
    //   213: invokevirtual 201	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   216: astore 28
    //   218: aload 28
    //   220: ifnull +48 -> 268
    //   223: aload 19
    //   225: aload 28
    //   227: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: goto -20 -> 211
    //   234: astore 25
    //   236: aload 18
    //   238: ifnull +8 -> 246
    //   241: aload 18
    //   243: invokevirtual 208	java/io/BufferedReader:close	()V
    //   246: aload 15
    //   248: ifnull +8 -> 256
    //   251: aload 15
    //   253: invokevirtual 211	java/lang/Process:destroy	()V
    //   256: iinc 9 1
    //   259: goto -105 -> 154
    //   262: iinc 5 1
    //   265: goto -175 -> 90
    //   268: aload 15
    //   270: invokevirtual 211	java/lang/Process:destroy	()V
    //   273: aload 19
    //   275: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   281: istore 30
    //   283: iload 30
    //   285: ifne +25 -> 310
    //   288: aload 18
    //   290: ifnull +8 -> 298
    //   293: aload 18
    //   295: invokevirtual 208	java/io/BufferedReader:close	()V
    //   298: aload 15
    //   300: ifnull +8 -> 308
    //   303: aload 15
    //   305: invokevirtual 211	java/lang/Process:destroy	()V
    //   308: iconst_1
    //   309: ireturn
    //   310: aload 18
    //   312: ifnull -66 -> 246
    //   315: aload 18
    //   317: invokevirtual 208	java/io/BufferedReader:close	()V
    //   320: goto -74 -> 246
    //   323: astore 31
    //   325: goto -79 -> 246
    //   328: astore 22
    //   330: aconst_null
    //   331: astore 21
    //   333: aload 21
    //   335: ifnull +8 -> 343
    //   338: aload 21
    //   340: invokevirtual 208	java/io/BufferedReader:close	()V
    //   343: aload 22
    //   345: athrow
    //   346: astore 23
    //   348: aload 15
    //   350: astore 12
    //   352: aload 12
    //   354: ifnull -98 -> 256
    //   357: aload 12
    //   359: invokevirtual 211	java/lang/Process:destroy	()V
    //   362: goto -106 -> 256
    //   365: astore 13
    //   367: goto -111 -> 256
    //   370: astore 14
    //   372: aconst_null
    //   373: astore 15
    //   375: aload 15
    //   377: ifnull +8 -> 385
    //   380: aload 15
    //   382: invokevirtual 211	java/lang/Process:destroy	()V
    //   385: aload 14
    //   387: athrow
    //   388: astore 33
    //   390: goto -92 -> 298
    //   393: astore 32
    //   395: iconst_1
    //   396: ireturn
    //   397: astore 27
    //   399: goto -153 -> 246
    //   402: astore 24
    //   404: goto -61 -> 343
    //   407: astore 26
    //   409: goto -153 -> 256
    //   412: astore 16
    //   414: goto -29 -> 385
    //   417: astore 14
    //   419: goto -44 -> 375
    //   422: astore 11
    //   424: aconst_null
    //   425: astore 12
    //   427: goto -75 -> 352
    //   430: astore 20
    //   432: aload 18
    //   434: astore 21
    //   436: aload 20
    //   438: astore 22
    //   440: goto -107 -> 333
    //   443: astore 34
    //   445: aconst_null
    //   446: astore 18
    //   448: goto -212 -> 236
    //   451: iload_2
    //   452: ireturn
    //   453: iconst_0
    //   454: istore_2
    //   455: goto -436 -> 19
    //
    // Exception table:
    //   from	to	target	type
    //   202	211	234	java/lang/Exception
    //   211	218	234	java/lang/Exception
    //   223	231	234	java/lang/Exception
    //   268	283	234	java/lang/Exception
    //   315	320	323	java/lang/Exception
    //   181	202	328	finally
    //   343	346	346	java/lang/Exception
    //   357	362	365	java/lang/Exception
    //   168	177	370	finally
    //   293	298	388	java/lang/Exception
    //   303	308	393	java/lang/Exception
    //   241	246	397	java/lang/Exception
    //   338	343	402	java/lang/Exception
    //   251	256	407	java/lang/Exception
    //   380	385	412	java/lang/Exception
    //   241	246	417	finally
    //   293	298	417	finally
    //   315	320	417	finally
    //   338	343	417	finally
    //   343	346	417	finally
    //   168	177	422	java/lang/Exception
    //   202	211	430	finally
    //   211	218	430	finally
    //   223	231	430	finally
    //   268	283	430	finally
    //   181	202	443	java/lang/Exception
  }

  // ERROR //
  private String d(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 227	com/my/target/bg:a	(Landroid/content/Context;)Lcom/my/target/bg;
    //   4: astore 8
    //   6: aload 8
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 229	com/my/target/bg:a	()Ljava/lang/String;
    //   15: astore 9
    //   17: aload 9
    //   19: astore 5
    //   21: aload 5
    //   23: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +71 -> 97
    //   29: getstatic 232	android/os/Build:SERIAL	Ljava/lang/String;
    //   32: astore 6
    //   34: ldc 37
    //   36: astore 7
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 235	com/my/target/aj:e	(Landroid/content/Context;)Z
    //   43: ifeq +10 -> 53
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 237	com/my/target/aj:b	(Landroid/content/Context;)Ljava/lang/String;
    //   51: astore 7
    //   53: new 196	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 41	com/my/target/aj:c	Ljava/lang/String;
    //   64: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 6
    //   69: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 7
    //   74: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 242	com/my/target/bd:a	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: aload 4
    //   87: ifnull +10 -> 97
    //   90: aload 4
    //   92: aload 5
    //   94: invokevirtual 244	com/my/target/bg:a	(Ljava/lang/String;)V
    //   97: aload 5
    //   99: areturn
    //   100: astore_2
    //   101: aload_2
    //   102: astore_3
    //   103: aconst_null
    //   104: astore 4
    //   106: ldc 246
    //   108: invokestatic 249	com/my/target/dp:a	(Ljava/lang/String;)V
    //   111: aload_3
    //   112: invokevirtual 252	java/lang/Throwable:printStackTrace	()V
    //   115: aconst_null
    //   116: astore 5
    //   118: goto -97 -> 21
    //   121: astore_3
    //   122: goto -16 -> 106
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	100	java/lang/Throwable
    //   10	17	121	java/lang/Throwable
  }

  private boolean e(Context paramContext)
  {
    try
    {
      int i2 = paramContext.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS");
      i1 = i2;
      if (i1 == 0)
        return true;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        dp.a("unable to check android.permission.GET_ACCOUNTS permission! Unexpected throwable in Context.checkCallingOrSelfPermission() method: " + localThrowable.getMessage());
        int i1 = -1;
      }
    }
    return false;
  }

  // ERROR //
  @android.annotation.SuppressLint({"HardwareIds"})
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/my/target/aj:a	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc_w 270
    //   17: invokestatic 249	com/my/target/dp:a	(Ljava/lang/String;)V
    //   20: new 272	com/my/target/aj$1
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 275	com/my/target/aj$1:<init>	(Lcom/my/target/aj;)V
    //   28: invokestatic 280	com/my/target/dq:b	(Ljava/lang/Runnable;)V
    //   31: aload_0
    //   32: getstatic 283	android/os/Build:DEVICE	Ljava/lang/String;
    //   35: putfield 39	com/my/target/aj:b	Ljava/lang/String;
    //   38: aload_0
    //   39: getstatic 286	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   42: putfield 51	com/my/target/aj:h	Ljava/lang/String;
    //   45: aload_0
    //   46: getstatic 289	android/os/Build:MODEL	Ljava/lang/String;
    //   49: putfield 53	com/my/target/aj:i	Ljava/lang/String;
    //   52: aload_0
    //   53: getstatic 292	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   56: putfield 43	com/my/target/aj:d	Ljava/lang/String;
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 295	android/content/Context:getPackageName	()Ljava/lang/String;
    //   64: putfield 45	com/my/target/aj:e	Ljava/lang/String;
    //   67: aload_0
    //   68: invokestatic 301	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   71: invokevirtual 304	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   74: putfield 55	com/my/target/aj:j	Ljava/lang/String;
    //   77: aload_1
    //   78: invokevirtual 308	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   81: aload_0
    //   82: getfield 45	com/my/target/aj:e	Ljava/lang/String;
    //   85: iconst_0
    //   86: invokevirtual 314	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   89: astore 34
    //   91: aload_0
    //   92: aload 34
    //   94: getfield 319	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   97: putfield 47	com/my/target/aj:f	Ljava/lang/String;
    //   100: aload_0
    //   101: aload 34
    //   103: getfield 322	android/content/pm/PackageInfo:versionCode	I
    //   106: invokestatic 327	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   109: putfield 49	com/my/target/aj:g	Ljava/lang/String;
    //   112: aload_1
    //   113: invokevirtual 331	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   116: astore 5
    //   118: aload 5
    //   120: ifnull +28 -> 148
    //   123: aload_0
    //   124: aload 5
    //   126: ldc_w 333
    //   129: invokestatic 339	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 41	com/my/target/aj:c	Ljava/lang/String;
    //   135: aload_0
    //   136: getfield 41	com/my/target/aj:c	Ljava/lang/String;
    //   139: ifnonnull +9 -> 148
    //   142: aload_0
    //   143: ldc 37
    //   145: putfield 41	com/my/target/aj:c	Ljava/lang/String;
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   153: invokevirtual 349	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   156: getfield 355	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   159: invokevirtual 304	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   162: putfield 57	com/my/target/aj:k	Ljava/lang/String;
    //   165: aload_1
    //   166: ldc_w 357
    //   169: invokevirtual 90	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   172: checkcast 359	android/telephony/TelephonyManager
    //   175: astore 6
    //   177: aload 6
    //   179: ifnull +75 -> 254
    //   182: aload_0
    //   183: aload 6
    //   185: invokevirtual 362	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   188: putfield 71	com/my/target/aj:r	Ljava/lang/String;
    //   191: aload 6
    //   193: invokevirtual 366	android/telephony/TelephonyManager:getSimState	()I
    //   196: iconst_5
    //   197: if_icmpne +12 -> 209
    //   200: aload_0
    //   201: aload 6
    //   203: invokevirtual 369	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   206: putfield 73	com/my/target/aj:s	Ljava/lang/String;
    //   209: aload 6
    //   211: invokevirtual 372	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   214: astore 7
    //   216: aload 7
    //   218: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +540 -> 761
    //   224: aload 7
    //   226: invokevirtual 375	java/lang/String:length	()I
    //   229: iconst_3
    //   230: if_icmple +531 -> 761
    //   233: aload_0
    //   234: aload 7
    //   236: iconst_3
    //   237: invokevirtual 378	java/lang/String:substring	(I)Ljava/lang/String;
    //   240: putfield 69	com/my/target/aj:q	Ljava/lang/String;
    //   243: aload_0
    //   244: aload 7
    //   246: iconst_0
    //   247: iconst_3
    //   248: invokevirtual 381	java/lang/String:substring	(II)Ljava/lang/String;
    //   251: putfield 59	com/my/target/aj:l	Ljava/lang/String;
    //   254: aload_0
    //   255: aload_1
    //   256: invokespecial 383	com/my/target/aj:c	(Landroid/content/Context;)V
    //   259: aload_1
    //   260: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   263: invokevirtual 387	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   266: astore 8
    //   268: aload_0
    //   269: aload 8
    //   271: getfield 392	android/util/DisplayMetrics:densityDpi	I
    //   274: putfield 65	com/my/target/aj:o	I
    //   277: aload_0
    //   278: aload 8
    //   280: getfield 395	android/util/DisplayMetrics:density	F
    //   283: putfield 67	com/my/target/aj:p	F
    //   286: invokestatic 400	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   289: astore 9
    //   291: aload_0
    //   292: new 196	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   299: aload 9
    //   301: iconst_0
    //   302: iconst_0
    //   303: invokevirtual 404	java/util/TimeZone:getDisplayName	(ZI)Ljava/lang/String;
    //   306: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 406
    //   312: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 9
    //   317: invokevirtual 409	java/util/TimeZone:getID	()Ljava/lang/String;
    //   320: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: putfield 75	com/my/target/aj:t	Ljava/lang/String;
    //   329: aload_0
    //   330: aload_1
    //   331: invokespecial 411	com/my/target/aj:d	(Landroid/content/Context;)Ljava/lang/String;
    //   334: astore 10
    //   336: aload 10
    //   338: ifnull +9 -> 347
    //   341: aload_0
    //   342: aload 10
    //   344: putfield 77	com/my/target/aj:u	Ljava/lang/String;
    //   347: aload_0
    //   348: ldc_w 333
    //   351: aload_0
    //   352: getfield 41	com/my/target/aj:c	Ljava/lang/String;
    //   355: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   358: pop
    //   359: aload_0
    //   360: ldc_w 416
    //   363: aload_0
    //   364: getfield 39	com/my/target/aj:b	Ljava/lang/String;
    //   367: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   370: pop
    //   371: aload_0
    //   372: ldc_w 418
    //   375: ldc_w 420
    //   378: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   381: pop
    //   382: aload_0
    //   383: ldc_w 422
    //   386: aload_0
    //   387: getfield 51	com/my/target/aj:h	Ljava/lang/String;
    //   390: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   393: pop
    //   394: aload_0
    //   395: ldc_w 424
    //   398: aload_0
    //   399: getfield 43	com/my/target/aj:d	Ljava/lang/String;
    //   402: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   405: pop
    //   406: aload_0
    //   407: ldc_w 426
    //   410: aload_0
    //   411: getfield 45	com/my/target/aj:e	Ljava/lang/String;
    //   414: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   417: pop
    //   418: aload_0
    //   419: ldc_w 428
    //   422: aload_0
    //   423: getfield 47	com/my/target/aj:f	Ljava/lang/String;
    //   426: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   429: pop
    //   430: aload_0
    //   431: ldc_w 430
    //   434: aload_0
    //   435: getfield 49	com/my/target/aj:g	Ljava/lang/String;
    //   438: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   441: pop
    //   442: aload_0
    //   443: ldc_w 432
    //   446: aload_0
    //   447: getfield 55	com/my/target/aj:j	Ljava/lang/String;
    //   450: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   453: pop
    //   454: aload_0
    //   455: ldc_w 434
    //   458: aload_0
    //   459: getfield 57	com/my/target/aj:k	Ljava/lang/String;
    //   462: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   465: pop
    //   466: aload_0
    //   467: ldc_w 436
    //   470: aload_0
    //   471: getfield 59	com/my/target/aj:l	Ljava/lang/String;
    //   474: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   477: pop
    //   478: aload_0
    //   479: ldc_w 438
    //   482: aload_0
    //   483: getfield 53	com/my/target/aj:i	Ljava/lang/String;
    //   486: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   489: pop
    //   490: aload_0
    //   491: ldc_w 440
    //   494: new 196	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   501: ldc 37
    //   503: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload_0
    //   507: getfield 61	com/my/target/aj:m	I
    //   510: invokevirtual 443	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   519: pop
    //   520: aload_0
    //   521: ldc_w 444
    //   524: new 196	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   531: ldc 37
    //   533: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload_0
    //   537: getfield 63	com/my/target/aj:n	I
    //   540: invokevirtual 443	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   549: pop
    //   550: aload_0
    //   551: ldc_w 446
    //   554: new 196	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   561: ldc 37
    //   563: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 65	com/my/target/aj:o	I
    //   570: invokevirtual 443	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   579: pop
    //   580: aload_0
    //   581: ldc_w 447
    //   584: new 196	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   591: ldc 37
    //   593: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_0
    //   597: getfield 67	com/my/target/aj:p	F
    //   600: invokevirtual 450	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   603: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   609: pop
    //   610: aload_0
    //   611: ldc_w 452
    //   614: aload_0
    //   615: getfield 69	com/my/target/aj:q	Ljava/lang/String;
    //   618: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   621: pop
    //   622: aload_0
    //   623: ldc_w 454
    //   626: aload_0
    //   627: getfield 71	com/my/target/aj:r	Ljava/lang/String;
    //   630: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   633: pop
    //   634: aload_0
    //   635: ldc_w 456
    //   638: aload_0
    //   639: getfield 73	com/my/target/aj:s	Ljava/lang/String;
    //   642: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   645: pop
    //   646: aload_0
    //   647: ldc_w 458
    //   650: aload_0
    //   651: getfield 75	com/my/target/aj:t	Ljava/lang/String;
    //   654: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   657: pop
    //   658: aload_0
    //   659: ldc_w 460
    //   662: aload_0
    //   663: getfield 77	com/my/target/aj:u	Ljava/lang/String;
    //   666: invokevirtual 414	com/my/target/aj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   669: pop
    //   670: aload_0
    //   671: invokevirtual 463	com/my/target/aj:a	()Ljava/util/Map;
    //   674: invokeinterface 469 1 0
    //   679: invokeinterface 475 1 0
    //   684: astore 32
    //   686: aload 32
    //   688: invokeinterface 480 1 0
    //   693: ifeq +77 -> 770
    //   696: aload 32
    //   698: invokeinterface 484 1 0
    //   703: checkcast 486	java/util/Map$Entry
    //   706: astore 33
    //   708: new 196	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   715: aload 33
    //   717: invokeinterface 489 1 0
    //   722: checkcast 130	java/lang/String
    //   725: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: ldc_w 491
    //   731: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload 33
    //   736: invokeinterface 494 1 0
    //   741: checkcast 130	java/lang/String
    //   744: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 249	com/my/target/dp:a	(Ljava/lang/String;)V
    //   753: goto -67 -> 686
    //   756: astore_2
    //   757: aload_0
    //   758: monitorexit
    //   759: aload_2
    //   760: athrow
    //   761: aload_0
    //   762: aload 7
    //   764: putfield 69	com/my/target/aj:q	Ljava/lang/String;
    //   767: goto -513 -> 254
    //   770: aload_0
    //   771: iconst_1
    //   772: putfield 35	com/my/target/aj:a	Z
    //   775: ldc_w 496
    //   778: invokestatic 249	com/my/target/dp:a	(Ljava/lang/String;)V
    //   781: goto -770 -> 11
    //   784: astore 4
    //   786: goto -674 -> 112
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	756	finally
    //   14	77	756	finally
    //   77	112	756	finally
    //   112	118	756	finally
    //   123	148	756	finally
    //   148	177	756	finally
    //   182	209	756	finally
    //   209	254	756	finally
    //   254	336	756	finally
    //   341	347	756	finally
    //   347	686	756	finally
    //   686	753	756	finally
    //   761	767	756	finally
    //   770	781	756	finally
    //   77	112	784	android/content/pm/PackageManager$NameNotFoundException
  }

  public String b(Context paramContext)
  {
    try
    {
      Account[] arrayOfAccount2 = AccountManager.get(paramContext).getAccountsByType("com.google");
      arrayOfAccount1 = arrayOfAccount2;
      if ((arrayOfAccount1 != null) && (arrayOfAccount1.length > 0))
        return arrayOfAccount1[0].name;
      return "";
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Account[] arrayOfAccount1 = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.aj
 * JD-Core Version:    0.6.2
 */