package androidx.work.impl.b;

import androidx.work.a;
import androidx.work.j;
import androidx.work.o.a;

public class p
{
  public static int a(a parama)
  {
    switch (1.b[parama.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Could not convert " + parama + " to int");
    case 1:
      return 0;
    case 2:
    }
    return 1;
  }

  public static int a(j paramj)
  {
    switch (1.c[paramj.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Could not convert " + paramj + " to int");
    case 1:
      return 0;
    case 2:
      return 1;
    case 3:
      return 2;
    case 4:
      return 3;
    case 5:
    }
    return 4;
  }

  public static int a(o.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Could not convert " + parama + " to int");
    case 1:
      return 0;
    case 2:
      return 1;
    case 3:
      return 2;
    case 4:
      return 3;
    case 5:
      return 4;
    case 6:
    }
    return 5;
  }

  // ERROR //
  public static androidx.work.d a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 62	androidx/work/d
    //   3: dup
    //   4: invokespecial 63	androidx/work/d:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aload_1
    //   13: areturn
    //   14: new 65	java/io/ByteArrayInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 68	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: astore_2
    //   23: new 70	java/io/ObjectInputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 73	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_3
    //   32: aload_3
    //   33: invokevirtual 76	java/io/ObjectInputStream:readInt	()I
    //   36: istore 10
    //   38: iload 10
    //   40: ifle +24 -> 64
    //   43: aload_1
    //   44: aload_3
    //   45: invokevirtual 79	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   48: invokestatic 85	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   51: aload_3
    //   52: invokevirtual 89	java/io/ObjectInputStream:readBoolean	()Z
    //   55: invokevirtual 92	androidx/work/d:a	(Landroid/net/Uri;Z)V
    //   58: iinc 10 255
    //   61: goto -23 -> 38
    //   64: aload_3
    //   65: ifnull +7 -> 72
    //   68: aload_3
    //   69: invokevirtual 95	java/io/ObjectInputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 96	java/io/ByteArrayInputStream:close	()V
    //   76: aload_1
    //   77: areturn
    //   78: astore 11
    //   80: aload 11
    //   82: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   85: aload_1
    //   86: areturn
    //   87: astore 12
    //   89: aload 12
    //   91: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   94: goto -22 -> 72
    //   97: astore 4
    //   99: aconst_null
    //   100: astore_3
    //   101: aload 4
    //   103: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   106: aload_3
    //   107: ifnull +7 -> 114
    //   110: aload_3
    //   111: invokevirtual 95	java/io/ObjectInputStream:close	()V
    //   114: aload_2
    //   115: invokevirtual 96	java/io/ByteArrayInputStream:close	()V
    //   118: aload_1
    //   119: areturn
    //   120: astore 8
    //   122: aload 8
    //   124: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: areturn
    //   129: astore 9
    //   131: aload 9
    //   133: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   136: goto -22 -> 114
    //   139: astore 5
    //   141: aconst_null
    //   142: astore_3
    //   143: aload_3
    //   144: ifnull +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 95	java/io/ObjectInputStream:close	()V
    //   151: aload_2
    //   152: invokevirtual 96	java/io/ByteArrayInputStream:close	()V
    //   155: aload 5
    //   157: athrow
    //   158: astore 7
    //   160: aload 7
    //   162: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   165: goto -14 -> 151
    //   168: astore 6
    //   170: aload 6
    //   172: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   175: goto -20 -> 155
    //   178: astore 5
    //   180: goto -37 -> 143
    //   183: astore 4
    //   185: goto -84 -> 101
    //
    // Exception table:
    //   from	to	target	type
    //   72	76	78	java/io/IOException
    //   68	72	87	java/io/IOException
    //   23	32	97	java/io/IOException
    //   114	118	120	java/io/IOException
    //   110	114	129	java/io/IOException
    //   23	32	139	finally
    //   147	151	158	java/io/IOException
    //   151	155	168	java/io/IOException
    //   32	38	178	finally
    //   43	58	178	finally
    //   101	106	178	finally
    //   32	38	183	java/io/IOException
    //   43	58	183	java/io/IOException
  }

  public static o.a a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Could not convert " + paramInt + " to State");
    case 0:
      return o.a.a;
    case 1:
      return o.a.b;
    case 2:
      return o.a.c;
    case 3:
      return o.a.d;
    case 4:
      return o.a.e;
    case 5:
    }
    return o.a.f;
  }

  // ERROR //
  public static byte[] a(androidx.work.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 124	androidx/work/d:b	()I
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 126	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 127	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: new 129	java/io/ObjectOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 132	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: invokevirtual 124	androidx/work/d:b	()I
    //   31: invokevirtual 136	java/io/ObjectOutputStream:writeInt	(I)V
    //   34: aload_0
    //   35: invokevirtual 139	androidx/work/d:a	()Ljava/util/Set;
    //   38: invokeinterface 145 1 0
    //   43: astore 9
    //   45: aload 9
    //   47: invokeinterface 150 1 0
    //   52: ifeq +63 -> 115
    //   55: aload 9
    //   57: invokeinterface 154 1 0
    //   62: checkcast 156	androidx/work/d$a
    //   65: astore 12
    //   67: aload_2
    //   68: aload 12
    //   70: invokevirtual 159	androidx/work/d$a:a	()Landroid/net/Uri;
    //   73: invokevirtual 160	android/net/Uri:toString	()Ljava/lang/String;
    //   76: invokevirtual 163	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   79: aload_2
    //   80: aload 12
    //   82: invokevirtual 165	androidx/work/d$a:b	()Z
    //   85: invokevirtual 169	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   88: goto -43 -> 45
    //   91: astore 6
    //   93: aload 6
    //   95: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   98: aload_2
    //   99: ifnull +7 -> 106
    //   102: aload_2
    //   103: invokevirtual 170	java/io/ObjectOutputStream:close	()V
    //   106: aload_1
    //   107: invokevirtual 171	java/io/ByteArrayOutputStream:close	()V
    //   110: aload_1
    //   111: invokevirtual 175	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   114: areturn
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 170	java/io/ObjectOutputStream:close	()V
    //   123: aload_1
    //   124: invokevirtual 171	java/io/ByteArrayOutputStream:close	()V
    //   127: goto -17 -> 110
    //   130: astore 10
    //   132: aload 10
    //   134: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   137: goto -27 -> 110
    //   140: astore 11
    //   142: aload 11
    //   144: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   147: goto -24 -> 123
    //   150: astore 8
    //   152: aload 8
    //   154: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   157: goto -51 -> 106
    //   160: astore 7
    //   162: aload 7
    //   164: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   167: goto -57 -> 110
    //   170: astore 14
    //   172: aconst_null
    //   173: astore_2
    //   174: aload 14
    //   176: astore_3
    //   177: aload_2
    //   178: ifnull +7 -> 185
    //   181: aload_2
    //   182: invokevirtual 170	java/io/ObjectOutputStream:close	()V
    //   185: aload_1
    //   186: invokevirtual 171	java/io/ByteArrayOutputStream:close	()V
    //   189: aload_3
    //   190: athrow
    //   191: astore 5
    //   193: aload 5
    //   195: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   198: goto -13 -> 185
    //   201: astore 4
    //   203: aload 4
    //   205: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   208: goto -19 -> 189
    //   211: astore_3
    //   212: goto -35 -> 177
    //   215: astore 13
    //   217: aload 13
    //   219: astore 6
    //   221: aconst_null
    //   222: astore_2
    //   223: goto -130 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   26	45	91	java/io/IOException
    //   45	88	91	java/io/IOException
    //   123	127	130	java/io/IOException
    //   119	123	140	java/io/IOException
    //   102	106	150	java/io/IOException
    //   106	110	160	java/io/IOException
    //   17	26	170	finally
    //   181	185	191	java/io/IOException
    //   185	189	201	java/io/IOException
    //   26	45	211	finally
    //   45	88	211	finally
    //   93	98	211	finally
    //   17	26	215	java/io/IOException
  }

  public static a b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Could not convert " + paramInt + " to BackoffPolicy");
    case 0:
      return a.a;
    case 1:
    }
    return a.b;
  }

  public static j c(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Could not convert " + paramInt + " to NetworkType");
    case 0:
      return j.a;
    case 1:
      return j.b;
    case 2:
      return j.c;
    case 3:
      return j.d;
    case 4:
    }
    return j.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b.p
 * JD-Core Version:    0.6.2
 */