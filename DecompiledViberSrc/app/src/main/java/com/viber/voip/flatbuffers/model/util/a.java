package com.viber.voip.flatbuffers.model.util;

public final class a
{
  // ERROR //
  public static java.lang.String a(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 14	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 20	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore_2
    //   9: new 22	java/io/StringWriter
    //   12: dup
    //   13: invokespecial 26	java/io/StringWriter:<init>	()V
    //   16: astore_3
    //   17: sipush 8192
    //   20: newarray char
    //   22: astore 4
    //   24: new 28	java/io/BufferedReader
    //   27: dup
    //   28: new 30	java/io/InputStreamReader
    //   31: dup
    //   32: aload_2
    //   33: ldc 32
    //   35: invokespecial 35	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore 5
    //   43: aload 5
    //   45: aload 4
    //   47: invokevirtual 44	java/io/Reader:read	([C)I
    //   50: istore 11
    //   52: iload 11
    //   54: iconst_m1
    //   55: if_icmpeq +40 -> 95
    //   58: aload_3
    //   59: aload 4
    //   61: iconst_0
    //   62: iload 11
    //   64: invokevirtual 50	java/io/Writer:write	([CII)V
    //   67: goto -24 -> 43
    //   70: astore 8
    //   72: ldc 52
    //   74: ldc 54
    //   76: aload 8
    //   78: invokestatic 60	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   81: pop
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 65	java/io/InputStream:close	()V
    //   90: aload_3
    //   91: invokevirtual 69	java/lang/Object:toString	()Ljava/lang/String;
    //   94: areturn
    //   95: aload_2
    //   96: ifnull -6 -> 90
    //   99: aload_2
    //   100: invokevirtual 65	java/io/InputStream:close	()V
    //   103: goto -13 -> 90
    //   106: astore 12
    //   108: goto -18 -> 90
    //   111: astore 6
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 65	java/io/InputStream:close	()V
    //   121: aload 6
    //   123: athrow
    //   124: astore 10
    //   126: goto -36 -> 90
    //   129: astore 7
    //   131: goto -10 -> 121
    //
    // Exception table:
    //   from	to	target	type
    //   24	43	70	java/io/IOException
    //   43	52	70	java/io/IOException
    //   58	67	70	java/io/IOException
    //   99	103	106	java/io/IOException
    //   24	43	111	finally
    //   43	52	111	finally
    //   58	67	111	finally
    //   72	82	111	finally
    //   86	90	124	java/io/IOException
    //   117	121	129	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.util.a
 * JD-Core Version:    0.6.2
 */