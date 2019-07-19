package c.a.a.a.a.g;

class i
  implements g
{
  private final c.a.a.a.i a;

  public i(c.a.a.a.i parami)
  {
    this.a = parami;
  }

  // ERROR //
  public org.json.JSONObject a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 24	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   5: ldc 26
    //   7: ldc 28
    //   9: invokeinterface 33 3 0
    //   14: new 35	java/io/File
    //   17: dup
    //   18: new 37	c/a/a/a/a/f/b
    //   21: dup
    //   22: aload_0
    //   23: getfield 15	c/a/a/a/a/g/i:a	Lc/a/a/a/i;
    //   26: invokespecial 39	c/a/a/a/a/f/b:<init>	(Lc/a/a/a/i;)V
    //   29: invokevirtual 42	c/a/a/a/a/f/b:a	()Ljava/io/File;
    //   32: ldc 44
    //   34: invokespecial 47	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 51	java/io/File:exists	()Z
    //   42: ifeq +41 -> 83
    //   45: new 53	java/io/FileInputStream
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: astore 5
    //   55: new 58	org/json/JSONObject
    //   58: dup
    //   59: aload 5
    //   61: invokestatic 63	c/a/a/a/a/b/i:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   64: invokespecial 66	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 5
    //   71: astore 7
    //   73: aload 7
    //   75: ldc 68
    //   77: invokestatic 71	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   80: aload 6
    //   82: areturn
    //   83: invokestatic 24	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   86: ldc 26
    //   88: ldc 73
    //   90: invokeinterface 33 3 0
    //   95: aconst_null
    //   96: astore 6
    //   98: aconst_null
    //   99: astore 7
    //   101: goto -28 -> 73
    //   104: astore 4
    //   106: aconst_null
    //   107: astore 5
    //   109: invokestatic 24	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   112: ldc 26
    //   114: ldc 75
    //   116: aload 4
    //   118: invokeinterface 79 4 0
    //   123: aload 5
    //   125: ldc 68
    //   127: invokestatic 71	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_3
    //   133: aload_1
    //   134: ldc 68
    //   136: invokestatic 71	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   139: aload_3
    //   140: athrow
    //   141: astore_3
    //   142: aload 5
    //   144: astore_1
    //   145: goto -12 -> 133
    //   148: astore 4
    //   150: goto -41 -> 109
    //
    // Exception table:
    //   from	to	target	type
    //   14	55	104	java/lang/Exception
    //   83	95	104	java/lang/Exception
    //   14	55	132	finally
    //   83	95	132	finally
    //   55	69	141	finally
    //   109	123	141	finally
    //   55	69	148	java/lang/Exception
  }

  // ERROR //
  public void a(long paramLong, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 24	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   3: ldc 26
    //   5: ldc 82
    //   7: invokeinterface 33 3 0
    //   12: aload_3
    //   13: ifnull +67 -> 80
    //   16: aconst_null
    //   17: astore 4
    //   19: aload_3
    //   20: ldc 84
    //   22: lload_1
    //   23: invokevirtual 88	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   26: pop
    //   27: new 90	java/io/FileWriter
    //   30: dup
    //   31: new 35	java/io/File
    //   34: dup
    //   35: new 37	c/a/a/a/a/f/b
    //   38: dup
    //   39: aload_0
    //   40: getfield 15	c/a/a/a/a/g/i:a	Lc/a/a/a/i;
    //   43: invokespecial 39	c/a/a/a/a/f/b:<init>	(Lc/a/a/a/i;)V
    //   46: invokevirtual 42	c/a/a/a/a/f/b:a	()Ljava/io/File;
    //   49: ldc 44
    //   51: invokespecial 47	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: invokespecial 91	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   57: astore 7
    //   59: aload 7
    //   61: aload_3
    //   62: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
    //   65: invokevirtual 98	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   68: aload 7
    //   70: invokevirtual 101	java/io/FileWriter:flush	()V
    //   73: aload 7
    //   75: ldc 103
    //   77: invokestatic 71	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   80: return
    //   81: astore 6
    //   83: aconst_null
    //   84: astore 7
    //   86: invokestatic 24	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   89: ldc 26
    //   91: ldc 105
    //   93: aload 6
    //   95: invokeinterface 79 4 0
    //   100: aload 7
    //   102: ldc 103
    //   104: invokestatic 71	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   107: return
    //   108: astore 5
    //   110: aload 4
    //   112: ldc 103
    //   114: invokestatic 71	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   117: aload 5
    //   119: athrow
    //   120: astore 5
    //   122: aload 7
    //   124: astore 4
    //   126: goto -16 -> 110
    //   129: astore 6
    //   131: goto -45 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   19	59	81	java/lang/Exception
    //   19	59	108	finally
    //   59	73	120	finally
    //   86	100	120	finally
    //   59	73	129	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.g.i
 * JD-Core Version:    0.6.2
 */