package com.yandex.mobile.ads.impl;

import android.os.SystemClock;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class oy
  implements ob
{
  private final Map<String, a> a = new LinkedHashMap(16, 0.75F, true);
  private long b = 0L;
  private final File c;
  private final int d;

  public oy(File paramFile, int paramInt)
  {
    this.c = paramFile;
    this.d = paramInt;
  }

  static int a(InputStream paramInputStream)
    throws IOException
  {
    return 0x0 | e(paramInputStream) << 0 | e(paramInputStream) << 8 | e(paramInputStream) << 16 | e(paramInputStream) << 24;
  }

  static void a(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(0xFF & paramInt >> 0);
    paramOutputStream.write(0xFF & paramInt >> 8);
    paramOutputStream.write(0xFF & paramInt >> 16);
    paramOutputStream.write(0xFF & paramInt >> 24);
  }

  static void a(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }

  static void a(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    a(paramOutputStream, arrayOfByte.length);
    paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
  }

  private void a(String paramString, a parama)
  {
    if (!this.a.containsKey(paramString));
    a locala;
    for (this.b += parama.a; ; this.b += parama.a - locala.a)
    {
      this.a.put(paramString, parama);
      return;
      locala = (a)this.a.get(paramString);
    }
  }

  private static byte[] a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1)
        break;
      i += j;
    }
    if (i != paramInt)
      throw new IOException("Expected " + paramInt + " bytes, read " + i + " bytes");
    return arrayOfByte;
  }

  static long b(InputStream paramInputStream)
    throws IOException
  {
    return 0L | (0xFF & e(paramInputStream)) << 0 | (0xFF & e(paramInputStream)) << 8 | (0xFF & e(paramInputStream)) << 16 | (0xFF & e(paramInputStream)) << 24 | (0xFF & e(paramInputStream)) << 32 | (0xFF & e(paramInputStream)) << 40 | (0xFF & e(paramInputStream)) << 48 | (0xFF & e(paramInputStream)) << 56;
  }

  private void b(String paramString)
  {
    try
    {
      boolean bool = d(paramString).delete();
      a locala = (a)this.a.get(paramString);
      if (locala != null)
      {
        this.b -= locala.a;
        this.a.remove(paramString);
      }
      if (!bool)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = c(paramString);
        on.b("Could not delete cache entry for key=%s, filename=%s", arrayOfObject);
      }
      return;
    }
    finally
    {
    }
  }

  static String c(InputStream paramInputStream)
    throws IOException
  {
    return new String(a(paramInputStream, (int)b(paramInputStream)), "UTF-8");
  }

  private static String c(String paramString)
  {
    int i = paramString.length() / 2;
    String str = String.valueOf(paramString.substring(0, i).hashCode());
    return str + String.valueOf(paramString.substring(i).hashCode());
  }

  private File d(String paramString)
  {
    return new File(this.c, c(paramString));
  }

  static Map<String, String> d(InputStream paramInputStream)
    throws IOException
  {
    int i = a(paramInputStream);
    if (i == 0);
    for (Object localObject = Collections.emptyMap(); ; localObject = new HashMap(i))
      for (int j = 0; j < i; j++)
        ((Map)localObject).put(c(paramInputStream).intern(), c(paramInputStream).intern());
    return localObject;
  }

  private static int e(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1)
      throw new EOFException();
    return i;
  }

  // ERROR //
  public final ob.a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/yandex/mobile/ads/impl/oy:a	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 81 2 0
    //   12: checkcast 71	com/yandex/mobile/ads/impl/oy$a
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +11 -> 28
    //   20: aconst_null
    //   21: astore 10
    //   23: aload_0
    //   24: monitorexit
    //   25: aload 10
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 117	com/yandex/mobile/ads/impl/oy:d	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 4
    //   35: new 195	com/yandex/mobile/ads/impl/oy$b
    //   38: dup
    //   39: new 197	java/io/BufferedInputStream
    //   42: dup
    //   43: new 199	java/io/FileInputStream
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 205	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: iconst_0
    //   56: invokespecial 208	com/yandex/mobile/ads/impl/oy$b:<init>	(Ljava/io/InputStream;B)V
    //   59: astore 5
    //   61: aload 5
    //   63: invokestatic 211	com/yandex/mobile/ads/impl/oy$a:a	(Ljava/io/InputStream;)Lcom/yandex/mobile/ads/impl/oy$a;
    //   66: pop
    //   67: aload 5
    //   69: aload 4
    //   71: invokevirtual 214	java/io/File:length	()J
    //   74: aload 5
    //   76: invokestatic 217	com/yandex/mobile/ads/impl/oy$b:a	(Lcom/yandex/mobile/ads/impl/oy$b;)I
    //   79: i2l
    //   80: lsub
    //   81: l2i
    //   82: invokestatic 141	com/yandex/mobile/ads/impl/oy:a	(Ljava/io/InputStream;I)[B
    //   85: astore 20
    //   87: new 219	com/yandex/mobile/ads/impl/ob$a
    //   90: dup
    //   91: invokespecial 220	com/yandex/mobile/ads/impl/ob$a:<init>	()V
    //   94: astore 21
    //   96: aload 21
    //   98: aload 20
    //   100: putfield 223	com/yandex/mobile/ads/impl/ob$a:a	[B
    //   103: aload 21
    //   105: aload_3
    //   106: getfield 226	com/yandex/mobile/ads/impl/oy$a:c	Ljava/lang/String;
    //   109: putfield 228	com/yandex/mobile/ads/impl/ob$a:b	Ljava/lang/String;
    //   112: aload 21
    //   114: aload_3
    //   115: getfield 230	com/yandex/mobile/ads/impl/oy$a:d	J
    //   118: putfield 232	com/yandex/mobile/ads/impl/ob$a:c	J
    //   121: aload 21
    //   123: aload_3
    //   124: getfield 234	com/yandex/mobile/ads/impl/oy$a:e	J
    //   127: putfield 235	com/yandex/mobile/ads/impl/ob$a:d	J
    //   130: aload 21
    //   132: aload_3
    //   133: getfield 238	com/yandex/mobile/ads/impl/oy$a:f	J
    //   136: putfield 239	com/yandex/mobile/ads/impl/ob$a:e	J
    //   139: aload 21
    //   141: aload_3
    //   142: getfield 242	com/yandex/mobile/ads/impl/oy$a:g	J
    //   145: putfield 243	com/yandex/mobile/ads/impl/ob$a:f	J
    //   148: aload 21
    //   150: aload_3
    //   151: getfield 246	com/yandex/mobile/ads/impl/oy$a:h	Ljava/util/Map;
    //   154: putfield 248	com/yandex/mobile/ads/impl/ob$a:g	Ljava/util/Map;
    //   157: aload 5
    //   159: invokevirtual 251	com/yandex/mobile/ads/impl/oy$b:close	()V
    //   162: aload 21
    //   164: astore 10
    //   166: goto -143 -> 23
    //   169: astore 22
    //   171: aconst_null
    //   172: astore 10
    //   174: goto -151 -> 23
    //   177: astore 6
    //   179: aconst_null
    //   180: astore 7
    //   182: iconst_2
    //   183: anewarray 4	java/lang/Object
    //   186: astore 11
    //   188: aload 11
    //   190: iconst_0
    //   191: aload 4
    //   193: invokevirtual 254	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   196: aastore
    //   197: aload 11
    //   199: iconst_1
    //   200: aload 6
    //   202: invokevirtual 255	java/io/IOException:toString	()Ljava/lang/String;
    //   205: aastore
    //   206: ldc_w 257
    //   209: aload 11
    //   211: invokestatic 136	com/yandex/mobile/ads/impl/on:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload_0
    //   215: aload_1
    //   216: invokespecial 259	com/yandex/mobile/ads/impl/oy:b	(Ljava/lang/String;)V
    //   219: aload 7
    //   221: ifnull +8 -> 229
    //   224: aload 7
    //   226: invokevirtual 251	com/yandex/mobile/ads/impl/oy$b:close	()V
    //   229: aconst_null
    //   230: astore 10
    //   232: goto -209 -> 23
    //   235: astore 12
    //   237: aconst_null
    //   238: astore 10
    //   240: goto -217 -> 23
    //   243: astore 13
    //   245: aconst_null
    //   246: astore 5
    //   248: iconst_2
    //   249: anewarray 4	java/lang/Object
    //   252: astore 14
    //   254: aload 14
    //   256: iconst_0
    //   257: aload 4
    //   259: invokevirtual 254	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   262: aastore
    //   263: aload 14
    //   265: iconst_1
    //   266: aload 13
    //   268: invokevirtual 260	java/lang/NegativeArraySizeException:toString	()Ljava/lang/String;
    //   271: aastore
    //   272: ldc_w 257
    //   275: aload 14
    //   277: invokestatic 136	com/yandex/mobile/ads/impl/on:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: aload_0
    //   281: aload_1
    //   282: invokespecial 259	com/yandex/mobile/ads/impl/oy:b	(Ljava/lang/String;)V
    //   285: aload 5
    //   287: ifnull +8 -> 295
    //   290: aload 5
    //   292: invokevirtual 251	com/yandex/mobile/ads/impl/oy$b:close	()V
    //   295: aconst_null
    //   296: astore 10
    //   298: goto -275 -> 23
    //   301: astore 15
    //   303: aconst_null
    //   304: astore 10
    //   306: goto -283 -> 23
    //   309: astore 16
    //   311: aconst_null
    //   312: astore 5
    //   314: iconst_2
    //   315: anewarray 4	java/lang/Object
    //   318: astore 17
    //   320: aload 17
    //   322: iconst_0
    //   323: aload 4
    //   325: invokevirtual 254	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   328: aastore
    //   329: aload 17
    //   331: iconst_1
    //   332: aload 16
    //   334: invokevirtual 261	java/lang/Throwable:toString	()Ljava/lang/String;
    //   337: aastore
    //   338: ldc_w 257
    //   341: aload 17
    //   343: invokestatic 136	com/yandex/mobile/ads/impl/on:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: aload_0
    //   347: aload_1
    //   348: invokespecial 259	com/yandex/mobile/ads/impl/oy:b	(Ljava/lang/String;)V
    //   351: aload 5
    //   353: ifnull +8 -> 361
    //   356: aload 5
    //   358: invokevirtual 251	com/yandex/mobile/ads/impl/oy$b:close	()V
    //   361: aconst_null
    //   362: astore 10
    //   364: goto -341 -> 23
    //   367: astore 18
    //   369: aconst_null
    //   370: astore 10
    //   372: goto -349 -> 23
    //   375: astore 8
    //   377: aconst_null
    //   378: astore 5
    //   380: aload 5
    //   382: ifnull +8 -> 390
    //   385: aload 5
    //   387: invokevirtual 251	com/yandex/mobile/ads/impl/oy$b:close	()V
    //   390: aload 8
    //   392: athrow
    //   393: astore_2
    //   394: aload_0
    //   395: monitorexit
    //   396: aload_2
    //   397: athrow
    //   398: astore 9
    //   400: aconst_null
    //   401: astore 10
    //   403: goto -380 -> 23
    //   406: astore 8
    //   408: goto -28 -> 380
    //   411: astore 8
    //   413: aload 7
    //   415: astore 5
    //   417: goto -37 -> 380
    //   420: astore 16
    //   422: goto -108 -> 314
    //   425: astore 13
    //   427: goto -179 -> 248
    //   430: astore 6
    //   432: aload 5
    //   434: astore 7
    //   436: goto -254 -> 182
    //
    // Exception table:
    //   from	to	target	type
    //   157	162	169	java/io/IOException
    //   35	61	177	java/io/IOException
    //   224	229	235	java/io/IOException
    //   35	61	243	java/lang/NegativeArraySizeException
    //   290	295	301	java/io/IOException
    //   35	61	309	java/lang/Throwable
    //   356	361	367	java/io/IOException
    //   35	61	375	finally
    //   2	16	393	finally
    //   28	35	393	finally
    //   157	162	393	finally
    //   224	229	393	finally
    //   290	295	393	finally
    //   356	361	393	finally
    //   385	390	393	finally
    //   390	393	393	finally
    //   385	390	398	java/io/IOException
    //   61	157	406	finally
    //   248	285	406	finally
    //   314	351	406	finally
    //   182	219	411	finally
    //   61	157	420	java/lang/Throwable
    //   61	157	425	java/lang/NegativeArraySizeException
    //   61	157	430	java/io/IOException
  }

  // ERROR //
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/yandex/mobile/ads/impl/oy:c	Ljava/io/File;
    //   6: invokevirtual 264	java/io/File:exists	()Z
    //   9: ifne +41 -> 50
    //   12: aload_0
    //   13: getfield 32	com/yandex/mobile/ads/impl/oy:c	Ljava/io/File;
    //   16: invokevirtual 267	java/io/File:mkdirs	()Z
    //   19: ifne +28 -> 47
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: astore 17
    //   28: aload 17
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 32	com/yandex/mobile/ads/impl/oy:c	Ljava/io/File;
    //   35: invokevirtual 254	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: ldc_w 269
    //   42: aload 17
    //   44: invokestatic 271	com/yandex/mobile/ads/impl/on:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 32	com/yandex/mobile/ads/impl/oy:c	Ljava/io/File;
    //   54: invokevirtual 275	java/io/File:listFiles	()[Ljava/io/File;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull -12 -> 47
    //   62: aload_2
    //   63: arraylength
    //   64: istore_3
    //   65: iconst_0
    //   66: istore 4
    //   68: iload 4
    //   70: iload_3
    //   71: if_icmpge -24 -> 47
    //   74: aload_2
    //   75: iload 4
    //   77: aaload
    //   78: astore 5
    //   80: aconst_null
    //   81: astore 6
    //   83: new 197	java/io/BufferedInputStream
    //   86: dup
    //   87: new 199	java/io/FileInputStream
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: invokespecial 205	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 7
    //   101: aload 7
    //   103: invokestatic 211	com/yandex/mobile/ads/impl/oy$a:a	(Ljava/io/InputStream;)Lcom/yandex/mobile/ads/impl/oy$a;
    //   106: astore 14
    //   108: aload 14
    //   110: aload 5
    //   112: invokevirtual 214	java/io/File:length	()J
    //   115: putfield 73	com/yandex/mobile/ads/impl/oy$a:a	J
    //   118: aload_0
    //   119: aload 14
    //   121: getfield 276	com/yandex/mobile/ads/impl/oy$a:b	Ljava/lang/String;
    //   124: aload 14
    //   126: invokespecial 278	com/yandex/mobile/ads/impl/oy:a	(Ljava/lang/String;Lcom/yandex/mobile/ads/impl/oy$a;)V
    //   129: aload 7
    //   131: invokevirtual 279	java/io/BufferedInputStream:close	()V
    //   134: iinc 4 1
    //   137: goto -69 -> 68
    //   140: astore 16
    //   142: aconst_null
    //   143: astore 7
    //   145: aload 5
    //   147: ifnull +9 -> 156
    //   150: aload 5
    //   152: invokevirtual 123	java/io/File:delete	()Z
    //   155: pop
    //   156: aload 7
    //   158: ifnull -24 -> 134
    //   161: aload 7
    //   163: invokevirtual 279	java/io/BufferedInputStream:close	()V
    //   166: goto -32 -> 134
    //   169: astore 9
    //   171: goto -37 -> 134
    //   174: astore 11
    //   176: aload 6
    //   178: ifnull +8 -> 186
    //   181: aload 6
    //   183: invokevirtual 279	java/io/BufferedInputStream:close	()V
    //   186: aload 11
    //   188: athrow
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    //   194: astore 15
    //   196: goto -62 -> 134
    //   199: astore 12
    //   201: goto -15 -> 186
    //   204: astore 10
    //   206: aload 7
    //   208: astore 6
    //   210: aload 10
    //   212: astore 11
    //   214: goto -38 -> 176
    //   217: astore 8
    //   219: goto -74 -> 145
    //
    // Exception table:
    //   from	to	target	type
    //   83	101	140	java/lang/Throwable
    //   161	166	169	java/io/IOException
    //   83	101	174	finally
    //   2	47	189	finally
    //   50	58	189	finally
    //   62	65	189	finally
    //   74	80	189	finally
    //   129	134	189	finally
    //   161	166	189	finally
    //   181	186	189	finally
    //   186	189	189	finally
    //   129	134	194	java/io/IOException
    //   181	186	199	java/io/IOException
    //   101	129	204	finally
    //   150	156	204	finally
    //   101	129	217	java/lang/Throwable
  }

  public final void a(String paramString, ob.a parama)
  {
    int i = 0;
    while (true)
    {
      BufferedOutputStream localBufferedOutputStream;
      a locala1;
      try
      {
        int j = parama.a.length;
        a locala2;
        if (this.b + j >= this.d)
        {
          if (on.b)
            on.a("Pruning old cache entries.", new Object[0]);
          long l1 = this.b;
          long l2 = SystemClock.elapsedRealtime();
          Iterator localIterator = this.a.entrySet().iterator();
          if (!localIterator.hasNext())
            break label412;
          locala2 = (a)((Map.Entry)localIterator.next()).getValue();
          if (!d(locala2.b).delete())
            continue;
          this.b -= locala2.a;
          localIterator.remove();
          k = i + 1;
          if ((float)(this.b + j) >= 0.9F * this.d)
            break label406;
          if (on.b)
          {
            Object[] arrayOfObject3 = new Object[3];
            arrayOfObject3[0] = Integer.valueOf(k);
            arrayOfObject3[1] = Long.valueOf(this.b - l1);
            arrayOfObject3[2] = Long.valueOf(SystemClock.elapsedRealtime() - l2);
            on.a("pruned %d files, %d bytes, %d ms", arrayOfObject3);
          }
        }
        File localFile = d(paramString);
        try
        {
          localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile));
          locala1 = new a(paramString, parama);
          if (locala1.a(localBufferedOutputStream))
            break label382;
          localBufferedOutputStream.close();
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = localFile.getAbsolutePath();
          on.b("Failed to write header for %s", arrayOfObject2);
          throw new IOException();
        }
        catch (IOException localIOException)
        {
          if (!localFile.delete())
          {
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = localFile.getAbsolutePath();
            on.b("Could not clean up file %s", arrayOfObject1);
          }
        }
        return;
        Object[] arrayOfObject4 = new Object[2];
        arrayOfObject4[0] = locala2.b;
        arrayOfObject4[1] = c(locala2.b);
        on.b("Could not delete cache entry for key=%s, filename=%s", arrayOfObject4);
        continue;
      }
      finally
      {
      }
      label382: localBufferedOutputStream.write(parama.a);
      localBufferedOutputStream.close();
      a(paramString, locala1);
      continue;
      label406: i = k;
      continue;
      label412: int k = i;
    }
  }

  static final class a
  {
    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public Map<String, String> h;

    private a()
    {
    }

    public a(String paramString, ob.a parama)
    {
      this.b = paramString;
      this.a = parama.a.length;
      this.c = parama.b;
      this.d = parama.c;
      this.e = parama.d;
      this.f = parama.e;
      this.g = parama.f;
      this.h = parama.g;
    }

    public static a a(InputStream paramInputStream)
      throws IOException
    {
      a locala = new a();
      if (oy.a(paramInputStream) != 538247942)
        throw new IOException();
      locala.b = oy.c(paramInputStream);
      locala.c = oy.c(paramInputStream);
      if (locala.c.equals(""))
        locala.c = null;
      locala.d = oy.b(paramInputStream);
      locala.e = oy.b(paramInputStream);
      locala.f = oy.b(paramInputStream);
      locala.g = oy.b(paramInputStream);
      locala.h = oy.d(paramInputStream);
      return locala;
    }

    public final boolean a(OutputStream paramOutputStream)
    {
      while (true)
      {
        try
        {
          oy.a(paramOutputStream, 538247942);
          oy.a(paramOutputStream, this.b);
          if (this.c == null)
          {
            str = "";
            oy.a(paramOutputStream, str);
            oy.a(paramOutputStream, this.d);
            oy.a(paramOutputStream, this.e);
            oy.a(paramOutputStream, this.f);
            oy.a(paramOutputStream, this.g);
            Map localMap = this.h;
            if (localMap == null)
              break;
            oy.a(paramOutputStream, localMap.size());
            Iterator localIterator = localMap.entrySet().iterator();
            if (!localIterator.hasNext())
              break label187;
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            oy.a(paramOutputStream, (String)localEntry.getKey());
            oy.a(paramOutputStream, (String)localEntry.getValue());
            continue;
          }
        }
        catch (IOException localIOException)
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localIOException.toString();
          on.b("%s", arrayOfObject);
          return false;
        }
        String str = this.c;
      }
      oy.a(paramOutputStream, 0);
      label187: paramOutputStream.flush();
      return true;
    }
  }

  private static final class b extends FilterInputStream
  {
    private int a = 0;

    private b(InputStream paramInputStream)
    {
      super();
    }

    public final int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1)
        this.a = (1 + this.a);
      return i;
    }

    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i != -1)
        this.a = (i + this.a);
      return i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.oy
 * JD-Core Version:    0.6.2
 */