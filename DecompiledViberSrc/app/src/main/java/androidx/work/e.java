package androidx.work;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  public static final e a = new a().a();
  private static final String c = i.a("Data");
  Map<String, Object> b;

  e()
  {
  }

  public e(e parame)
  {
    this.b = new HashMap(parame.b);
  }

  e(Map<String, ?> paramMap)
  {
    this.b = new HashMap(paramMap);
  }

  // ERROR //
  public static e a(byte[] paramArrayOfByte)
    throws java.lang.IllegalStateException
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: sipush 10240
    //   5: if_icmple +13 -> 18
    //   8: new 44	java/lang/IllegalStateException
    //   11: dup
    //   12: ldc 50
    //   14: invokespecial 53	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: new 36	java/util/HashMap
    //   21: dup
    //   22: invokespecial 54	java/util/HashMap:<init>	()V
    //   25: astore_1
    //   26: new 56	java/io/ByteArrayInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 59	java/io/ByteArrayInputStream:<init>	([B)V
    //   34: astore_2
    //   35: new 61	java/io/ObjectInputStream
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 64	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 68	java/io/ObjectInputStream:readInt	()I
    //   48: istore 15
    //   50: iload 15
    //   52: ifle +24 -> 76
    //   55: aload_1
    //   56: aload_3
    //   57: invokevirtual 72	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   60: aload_3
    //   61: invokevirtual 76	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   64: invokeinterface 82 3 0
    //   69: pop
    //   70: iinc 15 255
    //   73: goto -23 -> 50
    //   76: aload_3
    //   77: ifnull +7 -> 84
    //   80: aload_3
    //   81: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   84: aload_2
    //   85: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   88: new 2	androidx/work/e
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 87	androidx/work/e:<init>	(Ljava/util/Map;)V
    //   96: areturn
    //   97: astore 19
    //   99: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   102: ldc 89
    //   104: aload 19
    //   106: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   109: pop
    //   110: goto -26 -> 84
    //   113: astore 17
    //   115: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   118: ldc 89
    //   120: aload 17
    //   122: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   125: pop
    //   126: goto -38 -> 88
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_3
    //   133: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   136: ldc 89
    //   138: aload 4
    //   140: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   143: pop
    //   144: aload_3
    //   145: ifnull +7 -> 152
    //   148: aload_3
    //   149: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   152: aload_2
    //   153: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   156: goto -68 -> 88
    //   159: astore 11
    //   161: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   164: ldc 89
    //   166: aload 11
    //   168: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   171: pop
    //   172: goto -84 -> 88
    //   175: astore 13
    //   177: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   180: ldc 89
    //   182: aload 13
    //   184: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   187: pop
    //   188: goto -36 -> 152
    //   191: astore 5
    //   193: aconst_null
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   203: aload_2
    //   204: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   207: aload 5
    //   209: athrow
    //   210: astore 8
    //   212: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   215: ldc 89
    //   217: aload 8
    //   219: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   222: pop
    //   223: goto -20 -> 203
    //   226: astore 6
    //   228: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   231: ldc 89
    //   233: aload 6
    //   235: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   238: pop
    //   239: goto -32 -> 207
    //   242: astore 5
    //   244: goto -49 -> 195
    //   247: astore 4
    //   249: goto -116 -> 133
    //   252: astore 4
    //   254: aconst_null
    //   255: astore_3
    //   256: goto -123 -> 133
    //   259: astore 4
    //   261: goto -128 -> 133
    //
    // Exception table:
    //   from	to	target	type
    //   80	84	97	java/io/IOException
    //   84	88	113	java/io/IOException
    //   35	44	129	java/lang/ClassNotFoundException
    //   152	156	159	java/io/IOException
    //   148	152	175	java/io/IOException
    //   35	44	191	finally
    //   199	203	210	java/io/IOException
    //   203	207	226	java/io/IOException
    //   44	50	242	finally
    //   55	70	242	finally
    //   133	144	242	finally
    //   44	50	247	java/lang/ClassNotFoundException
    //   55	70	247	java/lang/ClassNotFoundException
    //   35	44	252	java/io/IOException
    //   44	50	259	java/io/IOException
    //   55	70	259	java/io/IOException
  }

  // ERROR //
  public static byte[] a(e parame)
    throws java.lang.IllegalStateException
  {
    // Byte code:
    //   0: new 98	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 99	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 101	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 104	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 106	androidx/work/e:b	()I
    //   22: invokevirtual 110	java/io/ObjectOutputStream:writeInt	(I)V
    //   25: aload_0
    //   26: getfield 38	androidx/work/e:b	Ljava/util/Map;
    //   29: invokeinterface 114 1 0
    //   34: invokeinterface 120 1 0
    //   39: astore 16
    //   41: aload 16
    //   43: invokeinterface 126 1 0
    //   48: ifeq +82 -> 130
    //   51: aload 16
    //   53: invokeinterface 129 1 0
    //   58: checkcast 131	java/util/Map$Entry
    //   61: astore 21
    //   63: aload_2
    //   64: aload 21
    //   66: invokeinterface 134 1 0
    //   71: checkcast 136	java/lang/String
    //   74: invokevirtual 139	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   77: aload_2
    //   78: aload 21
    //   80: invokeinterface 142 1 0
    //   85: invokevirtual 146	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   88: goto -47 -> 41
    //   91: astore 8
    //   93: aload_2
    //   94: astore 9
    //   96: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   99: ldc 148
    //   101: aload 8
    //   103: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   106: pop
    //   107: aload_1
    //   108: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   111: astore 11
    //   113: aload 9
    //   115: ifnull +8 -> 123
    //   118: aload 9
    //   120: invokevirtual 153	java/io/ObjectOutputStream:close	()V
    //   123: aload_1
    //   124: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   127: aload 11
    //   129: areturn
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 153	java/io/ObjectOutputStream:close	()V
    //   138: aload_1
    //   139: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   142: aload_1
    //   143: invokevirtual 157	java/io/ByteArrayOutputStream:size	()I
    //   146: sipush 10240
    //   149: if_icmple +126 -> 275
    //   152: new 44	java/lang/IllegalStateException
    //   155: dup
    //   156: ldc 50
    //   158: invokespecial 53	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: astore 19
    //   164: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   167: ldc 148
    //   169: aload 19
    //   171: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   174: pop
    //   175: goto -37 -> 138
    //   178: astore 17
    //   180: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   183: ldc 148
    //   185: aload 17
    //   187: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   190: pop
    //   191: goto -49 -> 142
    //   194: astore 14
    //   196: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   199: ldc 148
    //   201: aload 14
    //   203: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   206: pop
    //   207: goto -84 -> 123
    //   210: astore 12
    //   212: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   215: ldc 148
    //   217: aload 12
    //   219: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   222: pop
    //   223: aload 11
    //   225: areturn
    //   226: astore_3
    //   227: aconst_null
    //   228: astore_2
    //   229: aload_2
    //   230: ifnull +7 -> 237
    //   233: aload_2
    //   234: invokevirtual 153	java/io/ObjectOutputStream:close	()V
    //   237: aload_1
    //   238: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   241: aload_3
    //   242: athrow
    //   243: astore 6
    //   245: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   248: ldc 148
    //   250: aload 6
    //   252: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   255: pop
    //   256: goto -19 -> 237
    //   259: astore 4
    //   261: getstatic 22	androidx/work/e:c	Ljava/lang/String;
    //   264: ldc 148
    //   266: aload 4
    //   268: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   271: pop
    //   272: goto -31 -> 241
    //   275: aload_1
    //   276: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   279: areturn
    //   280: astore_3
    //   281: goto -52 -> 229
    //   284: astore_3
    //   285: aload 9
    //   287: astore_2
    //   288: goto -59 -> 229
    //   291: astore 8
    //   293: aconst_null
    //   294: astore 9
    //   296: goto -200 -> 96
    //
    // Exception table:
    //   from	to	target	type
    //   17	41	91	java/io/IOException
    //   41	88	91	java/io/IOException
    //   134	138	162	java/io/IOException
    //   138	142	178	java/io/IOException
    //   118	123	194	java/io/IOException
    //   123	127	210	java/io/IOException
    //   8	17	226	finally
    //   233	237	243	java/io/IOException
    //   237	241	259	java/io/IOException
    //   17	41	280	finally
    //   41	88	280	finally
    //   96	113	284	finally
    //   8	17	291	java/io/IOException
  }

  static Boolean[] a(boolean[] paramArrayOfBoolean)
  {
    Boolean[] arrayOfBoolean = new Boolean[paramArrayOfBoolean.length];
    for (int i = 0; i < paramArrayOfBoolean.length; i++)
      arrayOfBoolean[i] = Boolean.valueOf(paramArrayOfBoolean[i]);
    return arrayOfBoolean;
  }

  static Double[] a(double[] paramArrayOfDouble)
  {
    Double[] arrayOfDouble = new Double[paramArrayOfDouble.length];
    for (int i = 0; i < paramArrayOfDouble.length; i++)
      arrayOfDouble[i] = Double.valueOf(paramArrayOfDouble[i]);
    return arrayOfDouble;
  }

  static Float[] a(float[] paramArrayOfFloat)
  {
    Float[] arrayOfFloat = new Float[paramArrayOfFloat.length];
    for (int i = 0; i < paramArrayOfFloat.length; i++)
      arrayOfFloat[i] = Float.valueOf(paramArrayOfFloat[i]);
    return arrayOfFloat;
  }

  static Integer[] a(int[] paramArrayOfInt)
  {
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    for (int i = 0; i < paramArrayOfInt.length; i++)
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
    return arrayOfInteger;
  }

  static Long[] a(long[] paramArrayOfLong)
  {
    Long[] arrayOfLong = new Long[paramArrayOfLong.length];
    for (int i = 0; i < paramArrayOfLong.length; i++)
      arrayOfLong[i] = Long.valueOf(paramArrayOfLong[i]);
    return arrayOfLong;
  }

  public int a(String paramString, int paramInt)
  {
    Object localObject = this.b.get(paramString);
    if ((localObject instanceof Integer))
      paramInt = ((Integer)localObject).intValue();
    return paramInt;
  }

  public String a(String paramString)
  {
    Object localObject = this.b.get(paramString);
    if ((localObject instanceof String))
      return (String)localObject;
    return null;
  }

  public Map<String, Object> a()
  {
    return Collections.unmodifiableMap(this.b);
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.b.get(paramString);
    if ((localObject instanceof Boolean))
      paramBoolean = ((Boolean)localObject).booleanValue();
    return paramBoolean;
  }

  public int b()
  {
    return this.b.size();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    e locale = (e)paramObject;
    return this.b.equals(locale.b);
  }

  public int hashCode()
  {
    return 31 * this.b.hashCode();
  }

  public static final class a
  {
    private Map<String, Object> a = new HashMap();

    public a a(e parame)
    {
      a(parame.b);
      return this;
    }

    public a a(String paramString, Object paramObject)
    {
      if (paramObject == null)
      {
        this.a.put(paramString, null);
        return this;
      }
      Class localClass = paramObject.getClass();
      if ((localClass == Boolean.class) || (localClass == Integer.class) || (localClass == Long.class) || (localClass == Float.class) || (localClass == Double.class) || (localClass == String.class) || (localClass == [Ljava.lang.Boolean.class) || (localClass == [Ljava.lang.Integer.class) || (localClass == [Ljava.lang.Long.class) || (localClass == [Ljava.lang.Float.class) || (localClass == [Ljava.lang.Double.class) || (localClass == [Ljava.lang.String.class))
      {
        this.a.put(paramString, paramObject);
        return this;
      }
      if (localClass == [Z.class)
      {
        this.a.put(paramString, e.a((boolean[])paramObject));
        return this;
      }
      if (localClass == [I.class)
      {
        this.a.put(paramString, e.a((int[])paramObject));
        return this;
      }
      if (localClass == [J.class)
      {
        this.a.put(paramString, e.a((long[])paramObject));
        return this;
      }
      if (localClass == [F.class)
      {
        this.a.put(paramString, e.a((float[])paramObject));
        return this;
      }
      if (localClass == [D.class)
      {
        this.a.put(paramString, e.a((double[])paramObject));
        return this;
      }
      throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[] { paramString, localClass }));
    }

    public a a(String paramString1, String paramString2)
    {
      this.a.put(paramString1, paramString2);
      return this;
    }

    public a a(Map<String, Object> paramMap)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a((String)localEntry.getKey(), localEntry.getValue());
      }
      return this;
    }

    public e a()
    {
      e locale = new e(this.a);
      e.a(locale);
      return locale;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.e
 * JD-Core Version:    0.6.2
 */