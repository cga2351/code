package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.mixpanel.android.b.h;
import javax.net.ssl.SSLSocketFactory;

public class i
{
  private static i D;
  private static final Object E = new Object();
  public static boolean a = false;
  private final String A;
  private SSLSocketFactory B;
  private h C;
  private final int b;
  private final int c;
  private final long d;
  private final int e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final String[] k;
  private String l;
  private String m;
  private String n;
  private final boolean o;
  private final String p;
  private final String q;
  private final boolean r;
  private final int s;
  private final boolean t;
  private final int u;
  private final int v;
  private final int w;
  private final boolean x;
  private final int y;
  private final String z;

  // ERROR //
  i(Bundle paramBundle, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 51	java/lang/Object:<init>	()V
    //   4: ldc 60
    //   6: invokestatic 66	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   9: astore 17
    //   11: aload 17
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 70	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   19: aload 17
    //   21: invokevirtual 74	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   24: astore 18
    //   26: aload 18
    //   28: astore 4
    //   30: aload_0
    //   31: aload 4
    //   33: putfield 76	com/mixpanel/android/mpmetrics/i:B	Ljavax/net/ssl/SSLSocketFactory;
    //   36: aload_1
    //   37: ldc 78
    //   39: iconst_0
    //   40: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   43: putstatic 48	com/mixpanel/android/mpmetrics/i:a	Z
    //   46: getstatic 48	com/mixpanel/android/mpmetrics/i:a	Z
    //   49: ifeq +7 -> 56
    //   52: iconst_2
    //   53: invokestatic 89	com/mixpanel/android/b/f:a	(I)V
    //   56: aload_1
    //   57: ldc 91
    //   59: invokevirtual 95	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   62: ifeq +10 -> 72
    //   65: ldc 97
    //   67: ldc 99
    //   69: invokestatic 102	com/mixpanel/android/b/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: aload_1
    //   74: ldc 104
    //   76: bipush 40
    //   78: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   81: putfield 110	com/mixpanel/android/mpmetrics/i:b	I
    //   84: aload_0
    //   85: aload_1
    //   86: ldc 112
    //   88: ldc 113
    //   90: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   93: putfield 115	com/mixpanel/android/mpmetrics/i:c	I
    //   96: aload_0
    //   97: aload_1
    //   98: ldc 117
    //   100: ldc 118
    //   102: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   105: putfield 120	com/mixpanel/android/mpmetrics/i:e	I
    //   108: aload_0
    //   109: aload_1
    //   110: ldc 122
    //   112: invokevirtual 126	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: putfield 128	com/mixpanel/android/mpmetrics/i:q	Ljava/lang/String;
    //   118: aload_0
    //   119: aload_1
    //   120: ldc 130
    //   122: iconst_0
    //   123: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   126: putfield 132	com/mixpanel/android/mpmetrics/i:g	Z
    //   129: aload_0
    //   130: aload_1
    //   131: ldc 134
    //   133: iconst_0
    //   134: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   137: putfield 136	com/mixpanel/android/mpmetrics/i:h	Z
    //   140: aload_0
    //   141: aload_1
    //   142: ldc 138
    //   144: iconst_1
    //   145: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   148: putfield 140	com/mixpanel/android/mpmetrics/i:i	Z
    //   151: aload_0
    //   152: aload_1
    //   153: ldc 142
    //   155: iconst_0
    //   156: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   159: putfield 144	com/mixpanel/android/mpmetrics/i:j	Z
    //   162: aload_0
    //   163: aload_1
    //   164: ldc 146
    //   166: iconst_0
    //   167: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   170: putfield 148	com/mixpanel/android/mpmetrics/i:r	Z
    //   173: aload_0
    //   174: aload_1
    //   175: ldc 150
    //   177: bipush 10
    //   179: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   182: putfield 152	com/mixpanel/android/mpmetrics/i:s	I
    //   185: aload_0
    //   186: aload_1
    //   187: ldc 154
    //   189: iconst_0
    //   190: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   193: putfield 156	com/mixpanel/android/mpmetrics/i:t	Z
    //   196: aload_0
    //   197: aload_1
    //   198: ldc 158
    //   200: iconst_1
    //   201: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   204: putfield 160	com/mixpanel/android/mpmetrics/i:o	Z
    //   207: aload_0
    //   208: aload_1
    //   209: ldc 162
    //   211: iconst_0
    //   212: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   215: putfield 164	com/mixpanel/android/mpmetrics/i:u	I
    //   218: aload_0
    //   219: aload_1
    //   220: ldc 166
    //   222: sipush 10000
    //   225: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   228: putfield 168	com/mixpanel/android/mpmetrics/i:v	I
    //   231: aload_0
    //   232: aload_1
    //   233: ldc 170
    //   235: ldc 171
    //   237: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   240: putfield 173	com/mixpanel/android/mpmetrics/i:w	I
    //   243: aload_0
    //   244: aload_1
    //   245: ldc 175
    //   247: iconst_1
    //   248: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   251: putfield 177	com/mixpanel/android/mpmetrics/i:x	Z
    //   254: aload_0
    //   255: aload_1
    //   256: ldc 179
    //   258: iconst_0
    //   259: invokevirtual 84	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   262: putfield 181	com/mixpanel/android/mpmetrics/i:f	Z
    //   265: aload_0
    //   266: aload_1
    //   267: ldc 183
    //   269: iconst_3
    //   270: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   273: putfield 185	com/mixpanel/android/mpmetrics/i:y	I
    //   276: aload_1
    //   277: ldc 187
    //   279: invokevirtual 191	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   282: astore 5
    //   284: aload 5
    //   286: ifnull +283 -> 569
    //   289: aload 5
    //   291: instanceof 193
    //   294: ifeq +209 -> 503
    //   297: aload 5
    //   299: checkcast 193	java/lang/Integer
    //   302: invokevirtual 197	java/lang/Integer:intValue	()I
    //   305: istore 16
    //   307: iload 16
    //   309: i2l
    //   310: lstore 6
    //   312: aload_0
    //   313: lload 6
    //   315: putfield 199	com/mixpanel/android/mpmetrics/i:d	J
    //   318: aload_1
    //   319: ldc 201
    //   321: invokevirtual 126	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: astore 8
    //   326: aload 8
    //   328: ifnonnull +7 -> 335
    //   331: ldc 203
    //   333: astore 8
    //   335: aload_0
    //   336: aload 8
    //   338: putfield 205	com/mixpanel/android/mpmetrics/i:z	Ljava/lang/String;
    //   341: aload_1
    //   342: ldc 207
    //   344: invokevirtual 126	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 9
    //   349: aload 9
    //   351: ifnonnull +12 -> 363
    //   354: aload_2
    //   355: invokestatic 212	com/mixpanel/android/mpmetrics/t:a	(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/t;
    //   358: invokevirtual 215	com/mixpanel/android/mpmetrics/t:c	()Ljava/lang/String;
    //   361: astore 9
    //   363: aload_0
    //   364: aload 9
    //   366: putfield 217	com/mixpanel/android/mpmetrics/i:A	Ljava/lang/String;
    //   369: aload_1
    //   370: ldc 219
    //   372: invokevirtual 126	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 10
    //   377: aload 10
    //   379: ifnull +198 -> 577
    //   382: aload_0
    //   383: aload 10
    //   385: invokevirtual 222	com/mixpanel/android/mpmetrics/i:a	(Ljava/lang/String;)V
    //   388: aload_1
    //   389: ldc 224
    //   391: invokevirtual 126	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   394: astore 11
    //   396: aload 11
    //   398: ifnull +186 -> 584
    //   401: aload_0
    //   402: aload 11
    //   404: invokevirtual 226	com/mixpanel/android/mpmetrics/i:b	(Ljava/lang/String;)V
    //   407: aload_1
    //   408: ldc 228
    //   410: invokevirtual 126	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: astore 12
    //   415: aload 12
    //   417: ifnull +174 -> 591
    //   420: aload_0
    //   421: aload 12
    //   423: invokevirtual 230	com/mixpanel/android/mpmetrics/i:c	(Ljava/lang/String;)V
    //   426: aload_1
    //   427: ldc 232
    //   429: invokevirtual 126	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: astore 13
    //   434: aload 13
    //   436: ifnonnull +7 -> 443
    //   439: ldc 234
    //   441: astore 13
    //   443: aload_0
    //   444: aload 13
    //   446: putfield 236	com/mixpanel/android/mpmetrics/i:p	Ljava/lang/String;
    //   449: aload_1
    //   450: ldc 238
    //   452: iconst_m1
    //   453: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   456: istore 14
    //   458: iload 14
    //   460: iconst_m1
    //   461: if_icmpeq +137 -> 598
    //   464: aload_0
    //   465: aload_2
    //   466: invokevirtual 244	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   469: iload 14
    //   471: invokevirtual 250	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   474: putfield 252	com/mixpanel/android/mpmetrics/i:k	[Ljava/lang/String;
    //   477: ldc 97
    //   479: aload_0
    //   480: invokevirtual 255	com/mixpanel/android/mpmetrics/i:toString	()Ljava/lang/String;
    //   483: invokestatic 257	com/mixpanel/android/b/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: return
    //   487: astore_3
    //   488: ldc 97
    //   490: ldc_w 259
    //   493: aload_3
    //   494: invokestatic 262	com/mixpanel/android/b/f:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   497: aconst_null
    //   498: astore 4
    //   500: goto -470 -> 30
    //   503: aload 5
    //   505: instanceof 264
    //   508: ifeq +17 -> 525
    //   511: aload 5
    //   513: checkcast 264	java/lang/Float
    //   516: invokevirtual 268	java/lang/Float:floatValue	()F
    //   519: f2l
    //   520: lstore 6
    //   522: goto -210 -> 312
    //   525: new 270	java/lang/NumberFormatException
    //   528: dup
    //   529: new 272	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   536: aload 5
    //   538: invokevirtual 274	java/lang/Object:toString	()Ljava/lang/String;
    //   541: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc_w 280
    //   547: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokespecial 283	java/lang/NumberFormatException:<init>	(Ljava/lang/String;)V
    //   556: athrow
    //   557: astore 15
    //   559: ldc 97
    //   561: ldc_w 285
    //   564: aload 15
    //   566: invokestatic 287	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   569: ldc2_w 288
    //   572: lstore 6
    //   574: goto -262 -> 312
    //   577: aload_0
    //   578: invokevirtual 291	com/mixpanel/android/mpmetrics/i:l	()V
    //   581: goto -193 -> 388
    //   584: aload_0
    //   585: invokevirtual 293	com/mixpanel/android/mpmetrics/i:n	()V
    //   588: goto -181 -> 407
    //   591: aload_0
    //   592: invokevirtual 295	com/mixpanel/android/mpmetrics/i:p	()V
    //   595: goto -169 -> 426
    //   598: aload_0
    //   599: iconst_0
    //   600: anewarray 297	java/lang/String
    //   603: putfield 252	com/mixpanel/android/mpmetrics/i:k	[Ljava/lang/String;
    //   606: goto -129 -> 477
    //
    // Exception table:
    //   from	to	target	type
    //   4	26	487	java/security/GeneralSecurityException
    //   289	307	557	java/lang/Exception
    //   503	522	557	java/lang/Exception
    //   525	557	557	java/lang/Exception
  }

  public static i a(Context paramContext)
  {
    synchronized (E)
    {
      if (D == null)
        D = b(paramContext.getApplicationContext());
      return D;
    }
  }

  static i b(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(str, 128).metaData;
      if (localBundle == null)
        localBundle = new Bundle();
      i locali = new i(localBundle, paramContext);
      return locali;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("Can't configure Mixpanel with package name " + str, localNameNotFoundException);
    }
  }

  public boolean A()
  {
    return this.x;
  }

  public String B()
  {
    return this.q;
  }

  public SSLSocketFactory C()
  {
    try
    {
      SSLSocketFactory localSSLSocketFactory = this.B;
      return localSSLSocketFactory;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public h D()
  {
    try
    {
      h localh = this.C;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int E()
  {
    return this.s;
  }

  public int a()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.l = paramString;
  }

  public int b()
  {
    return this.c;
  }

  public void b(String paramString)
  {
    this.m = paramString;
  }

  public long c()
  {
    return this.d;
  }

  public void c(String paramString)
  {
    this.n = paramString;
  }

  public int d()
  {
    return this.e;
  }

  public boolean e()
  {
    return this.g;
  }

  public boolean f()
  {
    return this.h;
  }

  public boolean g()
  {
    return this.i;
  }

  public boolean h()
  {
    return this.j;
  }

  public String[] i()
  {
    return this.k;
  }

  public boolean j()
  {
    return this.f;
  }

  public String k()
  {
    return this.l;
  }

  public void l()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("https://api.mixpanel.com/track?ip=");
    if (A());
    for (String str = "1"; ; str = "0")
    {
      a(str);
      return;
    }
  }

  public String m()
  {
    return this.m;
  }

  public void n()
  {
    b("https://api.mixpanel.com/engage");
  }

  public String o()
  {
    return this.n;
  }

  public void p()
  {
    c("https://decide.mixpanel.com/decide");
  }

  public boolean q()
  {
    return this.o;
  }

  public String r()
  {
    return this.p;
  }

  public boolean s()
  {
    return this.r;
  }

  public boolean t()
  {
    return this.t;
  }

  public String toString()
  {
    return "Mixpanel (5.4.4-SNAPSHOT) configured with:\n    AutoShowMixpanelUpdates " + q() + "\n    BulkUploadLimit " + a() + "\n    FlushInterval " + b() + "\n    DataExpiration " + c() + "\n    MinimumDatabaseLimit " + d() + "\n    DisableAppOpenEvent " + g() + "\n    DisableViewCrawler " + h() + "\n    DisableGestureBindingUI " + e() + "\n    DisableEmulatorBindingUI " + f() + "\n    EnableDebugLogging " + a + "\n    TestMode " + j() + "\n    EventsEndpoint " + k() + "\n    PeopleEndpoint " + m() + "\n    DecideEndpoint " + o() + "\n    EditorUrl " + r() + "\n    ImageCacheMaxMemoryFactor " + E() + "\n    DisableDecideChecker " + s() + "\n    IgnoreInvisibleViewsEditor " + t() + "\n    NotificationDefaults " + u() + "\n    MinimumSessionDuration: " + v() + "\n    SessionTimeoutDuration: " + w() + "\n    NotificationChannelId: " + x() + "\n    NotificationChannelName: " + y() + "\n    NotificationChannelImportance: " + z();
  }

  public int u()
  {
    return this.u;
  }

  public int v()
  {
    return this.v;
  }

  public int w()
  {
    return this.w;
  }

  public String x()
  {
    return this.z;
  }

  public String y()
  {
    return this.A;
  }

  public int z()
  {
    return this.y;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.i
 * JD-Core Version:    0.6.2
 */