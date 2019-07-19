package com.my.target;

public class u extends v<Void>
{
  private String f;

  public static u a()
  {
    return new u();
  }

  public u a(String paramString)
  {
    this.f = paramString;
    return this;
  }

  // ERROR //
  protected Void a(String paramString, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/my/target/u:f	Ljava/lang/String;
    //   4: ifnonnull +15 -> 19
    //   7: ldc 22
    //   9: invokestatic 27	com/my/target/dp:a	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 30	com/my/target/u:a	Z
    //   17: aconst_null
    //   18: areturn
    //   19: ldc 32
    //   21: invokestatic 27	com/my/target/dp:a	(Ljava/lang/String;)V
    //   24: new 34	java/net/URL
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 40	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   35: checkcast 42	java/net/HttpURLConnection
    //   38: astore 6
    //   40: aload 6
    //   42: iconst_0
    //   43: invokevirtual 46	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   46: aload 6
    //   48: iconst_1
    //   49: invokevirtual 49	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   52: aload 6
    //   54: sipush 5000
    //   57: invokevirtual 53	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   60: aload 6
    //   62: sipush 5000
    //   65: invokevirtual 56	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   68: aload 6
    //   70: ldc 58
    //   72: invokevirtual 61	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   75: aload 6
    //   77: ldc 63
    //   79: ldc 65
    //   81: invokevirtual 69	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 6
    //   86: ldc 71
    //   88: ldc 73
    //   90: invokevirtual 69	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 6
    //   95: invokevirtual 76	java/net/HttpURLConnection:connect	()V
    //   98: aload 6
    //   100: invokevirtual 80	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   103: astore 9
    //   105: new 82	java/io/BufferedWriter
    //   108: dup
    //   109: new 84	java/io/OutputStreamWriter
    //   112: dup
    //   113: aload 9
    //   115: ldc 86
    //   117: invokestatic 92	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   120: invokespecial 95	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   123: invokespecial 98	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   126: astore 10
    //   128: aload 10
    //   130: aload_0
    //   131: getfield 17	com/my/target/u:f	Ljava/lang/String;
    //   134: invokevirtual 101	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   137: aload 10
    //   139: invokevirtual 104	java/io/BufferedWriter:flush	()V
    //   142: aload 10
    //   144: invokevirtual 106	java/io/BufferedWriter:close	()V
    //   147: aload 9
    //   149: invokevirtual 109	java/io/OutputStream:close	()V
    //   152: aload 6
    //   154: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   157: invokevirtual 116	java/io/InputStream:close	()V
    //   160: aload 6
    //   162: ifnull -145 -> 17
    //   165: aload 6
    //   167: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   170: aconst_null
    //   171: areturn
    //   172: astore 5
    //   174: aconst_null
    //   175: astore 4
    //   177: aload_0
    //   178: iconst_0
    //   179: putfield 30	com/my/target/u:a	Z
    //   182: aload_0
    //   183: aload 5
    //   185: invokevirtual 123	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   188: putfield 126	com/my/target/u:e	Ljava/lang/String;
    //   191: new 128	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   198: ldc 131
    //   200: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: getfield 126	com/my/target/u:e	Ljava/lang/String;
    //   207: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 27	com/my/target/dp:a	(Ljava/lang/String;)V
    //   216: aload 4
    //   218: ifnull -201 -> 17
    //   221: aload 4
    //   223: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore 4
    //   232: aload 4
    //   234: ifnull +8 -> 242
    //   237: aload 4
    //   239: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   242: aload_3
    //   243: athrow
    //   244: astore 8
    //   246: aload 6
    //   248: astore 4
    //   250: aload 8
    //   252: astore_3
    //   253: goto -21 -> 232
    //   256: astore_3
    //   257: goto -25 -> 232
    //   260: astore 7
    //   262: aload 6
    //   264: astore 4
    //   266: aload 7
    //   268: astore 5
    //   270: goto -93 -> 177
    //
    // Exception table:
    //   from	to	target	type
    //   24	40	172	java/lang/Throwable
    //   24	40	228	finally
    //   40	160	244	finally
    //   177	216	256	finally
    //   40	160	260	java/lang/Throwable
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.u
 * JD-Core Version:    0.6.2
 */