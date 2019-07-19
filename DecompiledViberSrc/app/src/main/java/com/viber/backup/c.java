package com.viber.backup;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class c extends a
{
  private static final Logger c = ViberEnv.getLogger();
  private static int d = 2000000;
  protected final String a;
  protected final String b;

  public c(String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.b = paramString1;
  }

  // ERROR //
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 37	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 30	com/viber/backup/c:a	Ljava/lang/String;
    //   8: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 44	java/io/File:exists	()Z
    //   16: ifne +62 -> 78
    //   19: aconst_null
    //   20: astore_3
    //   21: new 46	java/io/FileOutputStream
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: astore 4
    //   31: aload 4
    //   33: aload_1
    //   34: iconst_0
    //   35: aload_1
    //   36: arraylength
    //   37: invokevirtual 53	java/io/FileOutputStream:write	([BII)V
    //   40: aload 4
    //   42: invokevirtual 56	java/io/FileOutputStream:flush	()V
    //   45: aload 4
    //   47: invokestatic 61	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   50: return
    //   51: astore 8
    //   53: aconst_null
    //   54: astore 4
    //   56: getstatic 66	com/viber/voip/settings/d$ar:b	Lcom/viber/common/b/d;
    //   59: iconst_2
    //   60: invokevirtual 71	com/viber/common/b/d:a	(I)V
    //   63: aload 4
    //   65: invokestatic 61	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   68: return
    //   69: astore 7
    //   71: aload_3
    //   72: invokestatic 61	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   75: aload 7
    //   77: athrow
    //   78: getstatic 66	com/viber/voip/settings/d$ar:b	Lcom/viber/common/b/d;
    //   81: iconst_1
    //   82: invokevirtual 71	com/viber/common/b/d:a	(I)V
    //   85: return
    //   86: astore 6
    //   88: aload 4
    //   90: astore_3
    //   91: aload 6
    //   93: astore 7
    //   95: goto -24 -> 71
    //   98: astore 5
    //   100: goto -44 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   21	31	51	java/io/IOException
    //   21	31	69	finally
    //   31	45	86	finally
    //   56	63	86	finally
    //   31	45	98	java/io/IOException
  }

  // ERROR //
  public byte[] a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 37	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 30	com/viber/backup/c:a	Ljava/lang/String;
    //   10: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 44	java/io/File:exists	()Z
    //   18: istore 6
    //   20: iload 6
    //   22: ifne +9 -> 31
    //   25: aconst_null
    //   26: invokestatic 61	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   29: aconst_null
    //   30: areturn
    //   31: getstatic 24	com/viber/backup/c:d	I
    //   34: i2l
    //   35: lstore 7
    //   37: aload_2
    //   38: invokevirtual 76	java/io/File:length	()J
    //   41: lstore 9
    //   43: lload 7
    //   45: lload 9
    //   47: lcmp
    //   48: ifge +9 -> 57
    //   51: aconst_null
    //   52: invokestatic 61	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   55: aconst_null
    //   56: areturn
    //   57: aload_2
    //   58: invokevirtual 76	java/io/File:length	()J
    //   61: l2i
    //   62: newarray byte
    //   64: astore 5
    //   66: new 78	java/io/FileInputStream
    //   69: dup
    //   70: aload_2
    //   71: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: astore 11
    //   76: aload 11
    //   78: aload 5
    //   80: iconst_0
    //   81: aload 5
    //   83: arraylength
    //   84: invokevirtual 83	java/io/FileInputStream:read	([BII)I
    //   87: pop
    //   88: aload 11
    //   90: invokestatic 61	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   93: aload 5
    //   95: areturn
    //   96: astore 4
    //   98: aconst_null
    //   99: astore 5
    //   101: aload_1
    //   102: invokestatic 61	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   105: aload 5
    //   107: areturn
    //   108: astore_3
    //   109: aload_1
    //   110: invokestatic 61	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   113: aload_3
    //   114: athrow
    //   115: astore_3
    //   116: aload 11
    //   118: astore_1
    //   119: goto -10 -> 109
    //   122: astore 14
    //   124: aconst_null
    //   125: astore_1
    //   126: goto -25 -> 101
    //   129: astore 12
    //   131: aload 11
    //   133: astore_1
    //   134: goto -33 -> 101
    //
    // Exception table:
    //   from	to	target	type
    //   2	20	96	java/io/IOException
    //   31	43	96	java/io/IOException
    //   57	66	96	java/io/IOException
    //   2	20	108	finally
    //   31	43	108	finally
    //   57	66	108	finally
    //   66	76	108	finally
    //   76	88	115	finally
    //   66	76	122	java/io/IOException
    //   76	88	129	java/io/IOException
  }

  public String b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.c
 * JD-Core Version:    0.6.2
 */