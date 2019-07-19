package com.google.a.a.c.b;

import com.google.a.a.c.z;
import java.net.HttpURLConnection;

final class c extends z
{
  private final HttpURLConnection a;

  c(HttpURLConnection paramHttpURLConnection)
  {
    this.a = paramHttpURLConnection;
    paramHttpURLConnection.setInstanceFollowRedirects(false);
  }

  // ERROR //
  public com.google.a.a.c.aa a()
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/google/a/a/c/b/c:a	Ljava/net/HttpURLConnection;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 26	com/google/a/a/c/b/c:e	()Lcom/google/a/a/f/ac;
    //   9: ifnull +141 -> 150
    //   12: aload_0
    //   13: invokevirtual 30	com/google/a/a/c/b/c:d	()Ljava/lang/String;
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +11 -> 31
    //   23: aload_0
    //   24: ldc 32
    //   26: aload 4
    //   28: invokevirtual 35	com/google/a/a/c/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: invokevirtual 38	com/google/a/a/c/b/c:c	()Ljava/lang/String;
    //   35: astore 5
    //   37: aload 5
    //   39: ifnull +11 -> 50
    //   42: aload_0
    //   43: ldc 40
    //   45: aload 5
    //   47: invokevirtual 35	com/google/a/a/c/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 44	com/google/a/a/c/b/c:b	()J
    //   54: lstore 6
    //   56: lload 6
    //   58: lconst_0
    //   59: lcmp
    //   60: iflt +14 -> 74
    //   63: aload_0
    //   64: ldc 46
    //   66: lload 6
    //   68: invokestatic 52	java/lang/Long:toString	(J)Ljava/lang/String;
    //   71: invokevirtual 35	com/google/a/a/c/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 55	java/net/HttpURLConnection:getRequestMethod	()Ljava/lang/String;
    //   78: astore 8
    //   80: ldc 57
    //   82: aload 8
    //   84: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifne +13 -> 100
    //   90: ldc 65
    //   92: aload 8
    //   94: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +91 -> 188
    //   100: aload_1
    //   101: iconst_1
    //   102: invokevirtual 68	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   105: lload 6
    //   107: lconst_0
    //   108: lcmp
    //   109: iflt +56 -> 165
    //   112: lload 6
    //   114: ldc2_w 69
    //   117: lcmp
    //   118: ifgt +47 -> 165
    //   121: aload_1
    //   122: lload 6
    //   124: l2i
    //   125: invokevirtual 74	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   128: aload_1
    //   129: invokevirtual 78	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   132: astore 9
    //   134: aload_0
    //   135: invokevirtual 26	com/google/a/a/c/b/c:e	()Lcom/google/a/a/f/ac;
    //   138: aload 9
    //   140: invokeinterface 83 2 0
    //   145: aload 9
    //   147: invokevirtual 88	java/io/OutputStream:close	()V
    //   150: aload_1
    //   151: invokevirtual 91	java/net/HttpURLConnection:connect	()V
    //   154: new 93	com/google/a/a/c/b/d
    //   157: dup
    //   158: aload_1
    //   159: invokespecial 95	com/google/a/a/c/b/d:<init>	(Ljava/net/HttpURLConnection;)V
    //   162: astore_3
    //   163: aload_3
    //   164: areturn
    //   165: aload_1
    //   166: iconst_0
    //   167: invokevirtual 98	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   170: goto -42 -> 128
    //   173: astore 12
    //   175: aload 12
    //   177: athrow
    //   178: astore 10
    //   180: aload 9
    //   182: invokevirtual 88	java/io/OutputStream:close	()V
    //   185: aload 10
    //   187: athrow
    //   188: lload 6
    //   190: lconst_0
    //   191: lcmp
    //   192: ifne +25 -> 217
    //   195: iconst_1
    //   196: istore 13
    //   198: iload 13
    //   200: ldc 100
    //   202: iconst_1
    //   203: anewarray 102	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload 8
    //   210: aastore
    //   211: invokestatic 107	com/google/a/a/f/z:a	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -64 -> 150
    //   217: iconst_0
    //   218: istore 13
    //   220: goto -22 -> 198
    //   223: astore_2
    //   224: aload_1
    //   225: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   228: aload_2
    //   229: athrow
    //   230: astore 11
    //   232: goto -47 -> 185
    //
    // Exception table:
    //   from	to	target	type
    //   145	150	173	java/io/IOException
    //   134	145	178	finally
    //   150	163	223	finally
    //   180	185	230	java/io/IOException
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a.setReadTimeout(paramInt2);
    this.a.setConnectTimeout(paramInt1);
  }

  public void a(String paramString1, String paramString2)
  {
    this.a.addRequestProperty(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.b.c
 * JD-Core Version:    0.6.2
 */