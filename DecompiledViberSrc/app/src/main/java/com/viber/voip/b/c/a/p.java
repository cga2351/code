package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.b.c.a.a.g;

public class p extends c
{
  private static final Logger d = ViberEnv.getLogger();

  p(Context paramContext)
  {
    super(paramContext);
  }

  private b f()
  {
    return d.a(this.c);
  }

  public void a()
  {
    this.b = new f(new g(new a()), 256);
    this.b.b(true);
  }

  // ERROR //
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/viber/voip/b/c/a/p:a	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokespecial 60	com/viber/voip/b/c/a/p:f	()Lcom/viber/provider/b;
    //   12: ldc 61
    //   14: ldc 63
    //   16: aconst_null
    //   17: invokeinterface 68 4 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore 4
    //   28: aload 4
    //   30: invokeinterface 74 1 0
    //   35: ifeq +231 -> 266
    //   38: aload 4
    //   40: iconst_0
    //   41: invokeinterface 78 2 0
    //   46: astore 8
    //   48: aload 8
    //   50: invokestatic 84	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   53: astore 9
    //   55: aload 9
    //   57: invokestatic 89	com/viber/voip/util/dk:b	(Landroid/net/Uri;)Z
    //   60: ifeq +83 -> 143
    //   63: aload 9
    //   65: invokevirtual 93	android/net/Uri:getPath	()Ljava/lang/String;
    //   68: astore 13
    //   70: aload 13
    //   72: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne +62 -> 137
    //   78: new 101	java/io/File
    //   81: dup
    //   82: aload 13
    //   84: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: astore 10
    //   89: aload 10
    //   91: ifnull -63 -> 28
    //   94: aload 10
    //   96: invokevirtual 107	java/io/File:exists	()Z
    //   99: ifeq -71 -> 28
    //   102: aload_0
    //   103: getfield 50	com/viber/voip/b/c/a/p:b	Lcom/viber/voip/b/c/a/f;
    //   106: aload 10
    //   108: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: invokevirtual 112	com/viber/voip/b/c/a/f:a	(Ljava/lang/String;)V
    //   114: goto -86 -> 28
    //   117: astore_1
    //   118: aload 4
    //   120: astore_2
    //   121: getstatic 16	com/viber/voip/b/c/a/p:d	Lcom/viber/dexshared/Logger;
    //   124: aload_1
    //   125: ldc 114
    //   127: invokeinterface 119 3 0
    //   132: aload_2
    //   133: invokestatic 124	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   136: return
    //   137: aconst_null
    //   138: astore 10
    //   140: goto -51 -> 89
    //   143: aload 8
    //   145: invokestatic 129	com/viber/voip/messages/extras/map/b:a	(Ljava/lang/String;)Z
    //   148: ifeq +21 -> 169
    //   151: getstatic 135	com/viber/voip/util/dv:r	Lcom/viber/voip/util/dv;
    //   154: aload_0
    //   155: getfield 26	com/viber/voip/b/c/a/p:c	Landroid/content/Context;
    //   158: aload 8
    //   160: iconst_0
    //   161: invokevirtual 138	com/viber/voip/util/dv:b	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
    //   164: astore 10
    //   166: goto -77 -> 89
    //   169: getstatic 141	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   172: aload_0
    //   173: getfield 26	com/viber/voip/b/c/a/p:c	Landroid/content/Context;
    //   176: aload 8
    //   178: iconst_0
    //   179: invokevirtual 138	com/viber/voip/util/dv:b	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
    //   182: astore 10
    //   184: aload 10
    //   186: ifnull -97 -> 89
    //   189: aload 10
    //   191: invokevirtual 107	java/io/File:exists	()Z
    //   194: ifne -105 -> 89
    //   197: aload 9
    //   199: invokestatic 145	com/viber/voip/util/dx:q	(Landroid/net/Uri;)Z
    //   202: ifeq -113 -> 89
    //   205: aload 9
    //   207: invokestatic 148	com/viber/voip/util/dx:r	(Landroid/net/Uri;)Ljava/lang/String;
    //   210: astore 11
    //   212: aload 11
    //   214: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifne -128 -> 89
    //   220: aload 11
    //   222: invokestatic 84	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   225: invokevirtual 93	android/net/Uri:getPath	()Ljava/lang/String;
    //   228: astore 12
    //   230: aload 12
    //   232: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +25 -> 260
    //   238: new 101	java/io/File
    //   241: dup
    //   242: aload 12
    //   244: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   247: astore 10
    //   249: goto -160 -> 89
    //   252: astore_3
    //   253: aload 4
    //   255: invokestatic 124	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   258: aload_3
    //   259: athrow
    //   260: aconst_null
    //   261: astore 10
    //   263: goto -174 -> 89
    //   266: aload 4
    //   268: invokestatic 124	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   271: aload_0
    //   272: getfield 50	com/viber/voip/b/c/a/p:b	Lcom/viber/voip/b/c/a/f;
    //   275: getstatic 141	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   278: aload_0
    //   279: getfield 26	com/viber/voip/b/c/a/p:c	Landroid/content/Context;
    //   282: invokevirtual 151	com/viber/voip/util/dv:a	(Landroid/content/Context;)Ljava/io/File;
    //   285: invokevirtual 154	com/viber/voip/b/c/a/f:a	(Ljava/io/File;)Ljava/util/List;
    //   288: astore 6
    //   290: aload_0
    //   291: getfield 58	com/viber/voip/b/c/a/p:a	Z
    //   294: ifne -287 -> 7
    //   297: aload_0
    //   298: getfield 50	com/viber/voip/b/c/a/p:b	Lcom/viber/voip/b/c/a/f;
    //   301: aload 6
    //   303: invokevirtual 157	com/viber/voip/b/c/a/f:a	(Ljava/util/List;)Z
    //   306: pop
    //   307: return
    //   308: astore_3
    //   309: aconst_null
    //   310: astore 4
    //   312: goto -59 -> 253
    //   315: astore_3
    //   316: aload_2
    //   317: astore 4
    //   319: goto -66 -> 253
    //   322: astore_1
    //   323: aconst_null
    //   324: astore_2
    //   325: goto -204 -> 121
    //
    // Exception table:
    //   from	to	target	type
    //   28	89	117	java/lang/IllegalStateException
    //   94	114	117	java/lang/IllegalStateException
    //   143	166	117	java/lang/IllegalStateException
    //   169	184	117	java/lang/IllegalStateException
    //   189	249	117	java/lang/IllegalStateException
    //   28	89	252	finally
    //   94	114	252	finally
    //   143	166	252	finally
    //   169	184	252	finally
    //   189	249	252	finally
    //   8	24	308	finally
    //   121	132	315	finally
    //   8	24	322	java/lang/IllegalStateException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.p
 * JD-Core Version:    0.6.2
 */