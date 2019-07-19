package com.mopub.volley.toolbox;

import android.os.SystemClock;
import com.mopub.volley.Cache;
import com.mopub.volley.Cache.Entry;
import com.mopub.volley.Header;
import com.mopub.volley.VolleyLog;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DiskBasedCache
  implements Cache
{
  private final Map<String, a> a = new LinkedHashMap(16, 0.75F, true);
  private long b = 0L;
  private final File c;
  private final int d;

  public DiskBasedCache(File paramFile)
  {
    this(paramFile, 5242880);
  }

  public DiskBasedCache(File paramFile, int paramInt)
  {
    this.c = paramFile;
    this.d = paramInt;
  }

  static int a(InputStream paramInputStream)
    throws IOException
  {
    return 0x0 | c(paramInputStream) << 0 | c(paramInputStream) << 8 | c(paramInputStream) << 16 | c(paramInputStream) << 24;
  }

  static String a(b paramb)
    throws IOException
  {
    return new String(a(paramb, b(paramb)), "UTF-8");
  }

  private String a(String paramString)
  {
    int i = paramString.length() / 2;
    String str = String.valueOf(paramString.substring(0, i).hashCode());
    return str + String.valueOf(paramString.substring(i).hashCode());
  }

  private void a()
  {
    if (this.b < this.d);
    label116: label250: 
    while (true)
    {
      return;
      if (VolleyLog.DEBUG)
        VolleyLog.v("Pruning old cache entries.", new Object[0]);
      long l1 = this.b;
      long l2 = SystemClock.elapsedRealtime();
      Iterator localIterator = this.a.entrySet().iterator();
      int i = 0;
      a locala;
      int j;
      if (localIterator.hasNext())
      {
        locala = (a)((Map.Entry)localIterator.next()).getValue();
        if (getFileForKey(locala.b).delete())
        {
          this.b -= locala.a;
          localIterator.remove();
          j = i + 1;
          if ((float)this.b >= 0.9F * this.d)
            break label238;
        }
      }
      while (true)
      {
        if (!VolleyLog.DEBUG)
          break label250;
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = Integer.valueOf(j);
        arrayOfObject1[1] = Long.valueOf(this.b - l1);
        arrayOfObject1[2] = Long.valueOf(SystemClock.elapsedRealtime() - l2);
        VolleyLog.v("pruned %d files, %d bytes, %d ms", arrayOfObject1);
        return;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = locala.b;
        arrayOfObject2[1] = a(locala.b);
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", arrayOfObject2);
        break label116;
        i = j;
        break;
        j = i;
      }
    }
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

  static void a(List<Header> paramList, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramList != null)
    {
      a(paramOutputStream, paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Header localHeader = (Header)localIterator.next();
        a(paramOutputStream, localHeader.getName());
        a(paramOutputStream, localHeader.getValue());
      }
    }
    a(paramOutputStream, 0);
  }

  static byte[] a(b paramb, long paramLong)
    throws IOException
  {
    long l = paramb.a();
    if ((paramLong < 0L) || (paramLong > l) || ((int)paramLong != paramLong))
      throw new IOException("streamToBytes length=" + paramLong + ", maxLength=" + l);
    byte[] arrayOfByte = new byte[(int)paramLong];
    new DataInputStream(paramb).readFully(arrayOfByte);
    return arrayOfByte;
  }

  static long b(InputStream paramInputStream)
    throws IOException
  {
    return 0L | (0xFF & c(paramInputStream)) << 0 | (0xFF & c(paramInputStream)) << 8 | (0xFF & c(paramInputStream)) << 16 | (0xFF & c(paramInputStream)) << 24 | (0xFF & c(paramInputStream)) << 32 | (0xFF & c(paramInputStream)) << 40 | (0xFF & c(paramInputStream)) << 48 | (0xFF & c(paramInputStream)) << 56;
  }

  static List<Header> b(b paramb)
    throws IOException
  {
    int i = a(paramb);
    if (i < 0)
      throw new IOException("readHeaderList size=" + i);
    if (i == 0);
    for (Object localObject = Collections.emptyList(); ; localObject = new ArrayList())
      for (int j = 0; j < i; j++)
        ((List)localObject).add(new Header(a(paramb).intern(), a(paramb).intern()));
    return localObject;
  }

  private void b(String paramString)
  {
    a locala = (a)this.a.remove(paramString);
    if (locala != null)
      this.b -= locala.a;
  }

  private static int c(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1)
      throw new EOFException();
    return i;
  }

  InputStream a(File paramFile)
    throws FileNotFoundException
  {
    return new FileInputStream(paramFile);
  }

  OutputStream b(File paramFile)
    throws FileNotFoundException
  {
    return new FileOutputStream(paramFile);
  }

  public void clear()
  {
    int i = 0;
    try
    {
      File[] arrayOfFile = this.c.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        while (i < j)
        {
          arrayOfFile[i].delete();
          i++;
        }
      }
      this.a.clear();
      this.b = 0L;
      VolleyLog.d("Cache cleared.", new Object[0]);
      return;
    }
    finally
    {
    }
  }

  // ERROR //
  public Cache.Entry get(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/mopub/volley/toolbox/DiskBasedCache:a	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 200 2 0
    //   12: checkcast 133	com/mopub/volley/toolbox/DiskBasedCache$a
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +11 -> 28
    //   20: aconst_null
    //   21: astore 9
    //   23: aload_0
    //   24: monitorexit
    //   25: aload 9
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 140	com/mopub/volley/toolbox/DiskBasedCache:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 4
    //   35: new 220	com/mopub/volley/toolbox/DiskBasedCache$b
    //   38: dup
    //   39: new 304	java/io/BufferedInputStream
    //   42: dup
    //   43: aload_0
    //   44: aload 4
    //   46: invokevirtual 306	com/mopub/volley/toolbox/DiskBasedCache:a	(Ljava/io/File;)Ljava/io/InputStream;
    //   49: invokespecial 307	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: aload 4
    //   54: invokevirtual 309	java/io/File:length	()J
    //   57: invokespecial 312	com/mopub/volley/toolbox/DiskBasedCache$b:<init>	(Ljava/io/InputStream;J)V
    //   60: astore 5
    //   62: aload 5
    //   64: invokestatic 315	com/mopub/volley/toolbox/DiskBasedCache$a:a	(Lcom/mopub/volley/toolbox/DiskBasedCache$b;)Lcom/mopub/volley/toolbox/DiskBasedCache$a;
    //   67: astore 10
    //   69: aload_1
    //   70: aload 10
    //   72: getfield 136	com/mopub/volley/toolbox/DiskBasedCache$a:b	Ljava/lang/String;
    //   75: invokestatic 321	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   78: ifne +56 -> 134
    //   81: iconst_3
    //   82: anewarray 4	java/lang/Object
    //   85: astore 12
    //   87: aload 12
    //   89: iconst_0
    //   90: aload 4
    //   92: invokevirtual 324	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: aastore
    //   96: aload 12
    //   98: iconst_1
    //   99: aload_1
    //   100: aastore
    //   101: aload 12
    //   103: iconst_2
    //   104: aload 10
    //   106: getfield 136	com/mopub/volley/toolbox/DiskBasedCache$a:b	Ljava/lang/String;
    //   109: aastore
    //   110: ldc_w 326
    //   113: aload 12
    //   115: invokestatic 169	com/mopub/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_0
    //   119: aload_1
    //   120: invokespecial 328	com/mopub/volley/toolbox/DiskBasedCache:b	(Ljava/lang/String;)V
    //   123: aload 5
    //   125: invokevirtual 331	com/mopub/volley/toolbox/DiskBasedCache$b:close	()V
    //   128: aconst_null
    //   129: astore 9
    //   131: goto -108 -> 23
    //   134: aload_3
    //   135: aload 5
    //   137: aload 5
    //   139: invokevirtual 222	com/mopub/volley/toolbox/DiskBasedCache$b:a	()J
    //   142: invokestatic 52	com/mopub/volley/toolbox/DiskBasedCache:a	(Lcom/mopub/volley/toolbox/DiskBasedCache$b;J)[B
    //   145: invokevirtual 334	com/mopub/volley/toolbox/DiskBasedCache$a:a	([B)Lcom/mopub/volley/Cache$Entry;
    //   148: astore 11
    //   150: aload 11
    //   152: astore 9
    //   154: aload 5
    //   156: invokevirtual 331	com/mopub/volley/toolbox/DiskBasedCache$b:close	()V
    //   159: goto -136 -> 23
    //   162: astore 7
    //   164: iconst_2
    //   165: anewarray 4	java/lang/Object
    //   168: astore 8
    //   170: aload 8
    //   172: iconst_0
    //   173: aload 4
    //   175: invokevirtual 324	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   178: aastore
    //   179: aload 8
    //   181: iconst_1
    //   182: aload 7
    //   184: invokevirtual 335	java/io/IOException:toString	()Ljava/lang/String;
    //   187: aastore
    //   188: ldc_w 337
    //   191: aload 8
    //   193: invokestatic 169	com/mopub/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokevirtual 339	com/mopub/volley/toolbox/DiskBasedCache:remove	(Ljava/lang/String;)V
    //   201: aconst_null
    //   202: astore 9
    //   204: goto -181 -> 23
    //   207: astore 6
    //   209: aload 5
    //   211: invokevirtual 331	com/mopub/volley/toolbox/DiskBasedCache$b:close	()V
    //   214: aload 6
    //   216: athrow
    //   217: astore_2
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_2
    //   221: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   35	62	162	java/io/IOException
    //   123	128	162	java/io/IOException
    //   154	159	162	java/io/IOException
    //   209	217	162	java/io/IOException
    //   62	123	207	finally
    //   134	150	207	finally
    //   2	16	217	finally
    //   28	35	217	finally
    //   35	62	217	finally
    //   123	128	217	finally
    //   154	159	217	finally
    //   164	201	217	finally
    //   209	217	217	finally
  }

  public File getFileForKey(String paramString)
  {
    return new File(this.c, a(paramString));
  }

  // ERROR //
  public void initialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/mopub/volley/toolbox/DiskBasedCache:c	Ljava/io/File;
    //   6: invokevirtual 346	java/io/File:exists	()Z
    //   9: ifne +41 -> 50
    //   12: aload_0
    //   13: getfield 36	com/mopub/volley/toolbox/DiskBasedCache:c	Ljava/io/File;
    //   16: invokevirtual 349	java/io/File:mkdirs	()Z
    //   19: ifne +28 -> 47
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: astore 13
    //   28: aload 13
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 36	com/mopub/volley/toolbox/DiskBasedCache:c	Ljava/io/File;
    //   35: invokevirtual 324	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: ldc_w 351
    //   42: aload 13
    //   44: invokestatic 354	com/mopub/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 36	com/mopub/volley/toolbox/DiskBasedCache:c	Ljava/io/File;
    //   54: invokevirtual 297	java/io/File:listFiles	()[Ljava/io/File;
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
    //   80: aload 5
    //   82: invokevirtual 309	java/io/File:length	()J
    //   85: lstore 8
    //   87: new 220	com/mopub/volley/toolbox/DiskBasedCache$b
    //   90: dup
    //   91: new 304	java/io/BufferedInputStream
    //   94: dup
    //   95: aload_0
    //   96: aload 5
    //   98: invokevirtual 306	com/mopub/volley/toolbox/DiskBasedCache:a	(Ljava/io/File;)Ljava/io/InputStream;
    //   101: invokespecial 307	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   104: lload 8
    //   106: invokespecial 312	com/mopub/volley/toolbox/DiskBasedCache$b:<init>	(Ljava/io/InputStream;J)V
    //   109: astore 10
    //   111: aload 10
    //   113: invokestatic 315	com/mopub/volley/toolbox/DiskBasedCache$a:a	(Lcom/mopub/volley/toolbox/DiskBasedCache$b;)Lcom/mopub/volley/toolbox/DiskBasedCache$a;
    //   116: astore 12
    //   118: aload 12
    //   120: lload 8
    //   122: putfield 147	com/mopub/volley/toolbox/DiskBasedCache$a:a	J
    //   125: aload_0
    //   126: aload 12
    //   128: getfield 136	com/mopub/volley/toolbox/DiskBasedCache$a:b	Ljava/lang/String;
    //   131: aload 12
    //   133: invokespecial 356	com/mopub/volley/toolbox/DiskBasedCache:a	(Ljava/lang/String;Lcom/mopub/volley/toolbox/DiskBasedCache$a;)V
    //   136: aload 10
    //   138: invokevirtual 331	com/mopub/volley/toolbox/DiskBasedCache$b:close	()V
    //   141: goto +29 -> 170
    //   144: astore 11
    //   146: aload 10
    //   148: invokevirtual 331	com/mopub/volley/toolbox/DiskBasedCache$b:close	()V
    //   151: aload 11
    //   153: athrow
    //   154: astore 6
    //   156: aload 5
    //   158: invokevirtual 145	java/io/File:delete	()Z
    //   161: pop
    //   162: goto +8 -> 170
    //   165: astore_1
    //   166: aload_0
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    //   170: iinc 4 1
    //   173: goto -105 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   111	136	144	finally
    //   80	111	154	java/io/IOException
    //   136	141	154	java/io/IOException
    //   146	154	154	java/io/IOException
    //   2	47	165	finally
    //   50	58	165	finally
    //   62	65	165	finally
    //   74	80	165	finally
    //   80	111	165	finally
    //   136	141	165	finally
    //   146	154	165	finally
    //   156	162	165	finally
  }

  public void invalidate(String paramString, boolean paramBoolean)
  {
    try
    {
      Cache.Entry localEntry = get(paramString);
      if (localEntry != null)
      {
        localEntry.softTtl = 0L;
        if (paramBoolean)
          localEntry.ttl = 0L;
        put(paramString, localEntry);
      }
      return;
    }
    finally
    {
    }
  }

  public void put(String paramString, Cache.Entry paramEntry)
  {
    while (true)
    {
      File localFile;
      BufferedOutputStream localBufferedOutputStream;
      a locala;
      try
      {
        if (this.b + paramEntry.data.length > this.d)
        {
          float f = paramEntry.data.length;
          int i = this.d;
          if (f > 0.9F * i)
            return;
        }
        localFile = getFileForKey(paramString);
        try
        {
          localBufferedOutputStream = new BufferedOutputStream(b(localFile));
          locala = new a(paramString, paramEntry);
          if (locala.a(localBufferedOutputStream))
            break label171;
          localBufferedOutputStream.close();
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = localFile.getAbsolutePath();
          VolleyLog.d("Failed to write header for %s", arrayOfObject2);
          throw new IOException();
        }
        catch (IOException localIOException)
        {
        }
        if (localFile.delete())
          continue;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localFile.getAbsolutePath();
        VolleyLog.d("Could not clean up file %s", arrayOfObject1);
        continue;
      }
      finally
      {
      }
      label171: localBufferedOutputStream.write(paramEntry.data);
      localBufferedOutputStream.close();
      locala.a = localFile.length();
      a(paramString, locala);
      a();
    }
  }

  public void remove(String paramString)
  {
    try
    {
      boolean bool = getFileForKey(paramString).delete();
      b(paramString);
      if (!bool)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = a(paramString);
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", arrayOfObject);
      }
      return;
    }
    finally
    {
    }
  }

  static class a
  {
    long a;
    final String b;
    final String c;
    final long d;
    final long e;
    final long f;
    final long g;
    final List<Header> h;

    a(String paramString, Cache.Entry paramEntry)
    {
      this(paramString, paramEntry.etag, paramEntry.serverDate, paramEntry.lastModified, paramEntry.ttl, paramEntry.softTtl, a(paramEntry));
    }

    private a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<Header> paramList)
    {
      this.b = paramString1;
      if ("".equals(paramString2))
        paramString2 = null;
      this.c = paramString2;
      this.d = paramLong1;
      this.e = paramLong2;
      this.f = paramLong3;
      this.g = paramLong4;
      this.h = paramList;
    }

    static a a(DiskBasedCache.b paramb)
      throws IOException
    {
      if (DiskBasedCache.a(paramb) != 538247942)
        throw new IOException();
      return new a(DiskBasedCache.a(paramb), DiskBasedCache.a(paramb), DiskBasedCache.b(paramb), DiskBasedCache.b(paramb), DiskBasedCache.b(paramb), DiskBasedCache.b(paramb), DiskBasedCache.b(paramb));
    }

    private static List<Header> a(Cache.Entry paramEntry)
    {
      if (paramEntry.allResponseHeaders != null)
        return paramEntry.allResponseHeaders;
      return HttpHeaderParser.a(paramEntry.responseHeaders);
    }

    Cache.Entry a(byte[] paramArrayOfByte)
    {
      Cache.Entry localEntry = new Cache.Entry();
      localEntry.data = paramArrayOfByte;
      localEntry.etag = this.c;
      localEntry.serverDate = this.d;
      localEntry.lastModified = this.e;
      localEntry.ttl = this.f;
      localEntry.softTtl = this.g;
      localEntry.responseHeaders = HttpHeaderParser.a(this.h);
      localEntry.allResponseHeaders = Collections.unmodifiableList(this.h);
      return localEntry;
    }

    boolean a(OutputStream paramOutputStream)
    {
      try
      {
        DiskBasedCache.a(paramOutputStream, 538247942);
        DiskBasedCache.a(paramOutputStream, this.b);
        if (this.c == null);
        for (String str = ""; ; str = this.c)
        {
          DiskBasedCache.a(paramOutputStream, str);
          DiskBasedCache.a(paramOutputStream, this.d);
          DiskBasedCache.a(paramOutputStream, this.e);
          DiskBasedCache.a(paramOutputStream, this.f);
          DiskBasedCache.a(paramOutputStream, this.g);
          DiskBasedCache.a(this.h, paramOutputStream);
          paramOutputStream.flush();
          return true;
        }
      }
      catch (IOException localIOException)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localIOException.toString();
        VolleyLog.d("%s", arrayOfObject);
      }
      return false;
    }
  }

  static class b extends FilterInputStream
  {
    private final long a;
    private long b;

    b(InputStream paramInputStream, long paramLong)
    {
      super();
      this.a = paramLong;
    }

    long a()
    {
      return this.a - this.b;
    }

    public int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1)
        this.b = (1L + this.b);
      return i;
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i != -1)
        this.b += i;
      return i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.DiskBasedCache
 * JD-Core Version:    0.6.2
 */