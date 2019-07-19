package com.viber.voip.b;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.at;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
  implements Closeable
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Charset b = Charset.forName("UTF-8");
  private final File c;
  private final File d;
  private final File e;
  private final int f;
  private final long g;
  private final int h;
  private final int i;
  private final LinkedHashMap<String, b> j = new LinkedHashMap(200, 0.75F, true);
  private final ExecutorService k = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private long l = 0L;
  private Writer m;
  private int n;
  private final Callable<Void> o = new Callable()
  {
    public Void a()
      throws Exception
    {
      synchronized (b.this)
      {
        if (b.a(b.this) == null)
          return null;
        b.b(b.this);
        if (b.c(b.this))
        {
          b.d(b.this);
          b.a(b.this, 0);
        }
        return null;
      }
    }
  };
  private long p = 0L;

  private b(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.c = paramFile;
    this.f = paramInt1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.h = paramInt2;
    this.i = (paramInt2 + 2);
    this.g = paramLong;
  }

  private a a(String paramString, long paramLong)
    throws IOException
  {
    while (true)
    {
      b localb1;
      a locala2;
      b localb2;
      try
      {
        g();
        d(paramString);
        localb1 = (b)this.j.get(paramString);
        if (paramLong != -1L)
          if (localb1 != null)
          {
            long l1 = b.e(localb1);
            if (l1 == paramLong);
          }
          else
          {
            locala2 = null;
            return locala2;
          }
        if (localb1 == null)
        {
          b localb3 = new b(paramString, null);
          this.j.put(paramString, localb3);
          localb2 = localb3;
          locala2 = new a(localb2, null);
          b.a(localb2, locala2);
          this.m.write("DIRTY " + paramString + '\n');
          this.m.flush();
          continue;
        }
      }
      finally
      {
      }
      a locala1 = b.a(localb1);
      if (locala1 != null)
        locala2 = null;
      else
        localb2 = localb1;
    }
  }

  public static b a(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0");
    b localb1 = new b(paramFile, paramInt1, paramInt2, paramLong);
    if (localb1.d.exists())
      try
      {
        localb1.c();
        localb1.d();
        localb1.m = new BufferedWriter(new FileWriter(localb1.d, true), 8192);
        return localb1;
      }
      catch (IOException localIOException)
      {
        localb1.b();
      }
    paramFile.mkdirs();
    b localb2 = new b(paramFile, paramInt1, paramInt2, paramLong);
    localb2.e();
    return localb2;
  }

  public static String a(InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(45);
    while (true)
    {
      int i1 = paramInputStream.read();
      if (i1 == -1)
        throw new EOFException();
      if (i1 == 10)
      {
        int i2 = localStringBuilder.length();
        if ((i2 > 0) && (localStringBuilder.charAt(i2 - 1) == '\r'))
          localStringBuilder.setLength(i2 - 1);
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i1);
    }
  }

  private void a(a parama, boolean paramBoolean)
    throws IOException
  {
    b localb;
    try
    {
      localb = a.a(parama);
      if (b.a(localb) != parama)
        throw new IllegalStateException();
    }
    finally
    {
    }
    int i1 = 0;
    int i2;
    if (paramBoolean)
    {
      boolean bool = b.d(localb);
      i1 = 0;
      if (!bool)
      {
        i2 = 0;
        int i3 = this.h;
        i1 = 0;
        if (i2 < i3)
        {
          if (localb.b(i2).exists())
            break label408;
          parama.b();
          throw new IllegalStateException("edit didn't create file " + i2);
        }
      }
    }
    while (true)
    {
      if (i1 < this.h)
      {
        File localFile1 = localb.b(i1);
        if (paramBoolean)
        {
          if (localFile1.exists())
          {
            File localFile2 = localb.a(i1);
            localFile1.renameTo(localFile2);
            long l2 = b.b(localb)[i1];
            long l3 = localFile2.length();
            b.b(localb)[i1] = l3;
            this.l = (l3 + (this.l - l2));
          }
        }
        else
          b(localFile1);
      }
      else
      {
        this.n = (1 + this.n);
        b.a(localb, null);
        if ((paramBoolean | b.d(localb)))
        {
          b.a(localb, true);
          this.m.write("CLEAN " + b.c(localb) + localb.a() + '\n');
          if (paramBoolean)
          {
            long l1 = this.p;
            this.p = (1L + l1);
            b.a(localb, l1);
          }
        }
        while (true)
        {
          if ((this.l > this.g) || (f()))
            this.k.submit(this.o);
          return;
          this.j.remove(b.c(localb));
          this.m.write("REMOVE " + b.c(localb) + '\n');
        }
        label408: i2++;
        break;
      }
      i1++;
    }
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(File paramFile)
    throws IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      File localFile1 = new File(paramFile.getPath());
      if (!at.f(localFile1))
        throw new IOException("failed to delete corruptedCacheDir file: " + localFile1);
    }
    else
    {
      int i1 = arrayOfFile.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        File localFile2 = arrayOfFile[i2];
        if (localFile2.isDirectory())
          a(localFile2);
        if (!at.f(localFile2))
          throw new IOException("failed to delete file: " + localFile2);
      }
    }
  }

  private static <T> T[] a(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayOfT.length;
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    if ((paramInt1 < 0) || (paramInt1 > i1))
      throw new ArrayIndexOutOfBoundsException();
    int i2 = paramInt2 - paramInt1;
    int i3 = Math.min(i2, i1 - paramInt1);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i2);
    System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, i3);
    return arrayOfObject;
  }

  private static void b(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (!at.f(paramFile)))
      throw new IOException();
  }

  private void b(InputStream paramInputStream)
    throws IOException
  {
    String[] arrayOfString = new String[this.i];
    StringBuilder[] arrayOfStringBuilder = new StringBuilder[this.i];
    int i1 = 0;
    String str1;
    String str2;
    int i4;
    if (i1 < this.i)
    {
      if (i1 == 1)
        arrayOfStringBuilder[i1] = new StringBuilder(32);
      while (true)
      {
        i1++;
        break;
        arrayOfStringBuilder[i1] = new StringBuilder(6);
      }
      str1 = arrayOfString[1];
      str2 = arrayOfString[0];
      if ((str2.equals("REMOVE")) && (i4 == 2))
        this.j.remove(str1);
    }
    else
    {
      StringBuilder localStringBuilder = arrayOfStringBuilder[0];
      int i2 = 0;
      while (true)
      {
        int i3 = paramInputStream.read();
        if (i3 == -1)
          return;
        if (i3 == 32)
        {
          arrayOfString[i2] = localStringBuilder.toString();
          localStringBuilder.setLength(0);
          i2++;
          localStringBuilder = arrayOfStringBuilder[i2];
        }
        else
        {
          if (i3 == 10)
          {
            arrayOfString[i2] = localStringBuilder.toString();
            localStringBuilder.setLength(0);
            i4 = i2 + 1;
            if (i4 >= 2)
              break;
            throw new IOException("unexpected journal line: ");
          }
          localStringBuilder.append((char)i3);
        }
      }
    }
    b localb1 = (b)this.j.get(str1);
    b localb2;
    if (localb1 == null)
    {
      localb2 = new b(str1, null);
      this.j.put(str1, localb2);
    }
    for (b localb3 = localb2; ; localb3 = localb1)
    {
      if ((str2.equals("CLEAN")) && (i4 == this.i))
      {
        b.a(localb3, true);
        b.a(localb3, null);
        b.a(localb3, (String[])a(arrayOfString, 2, i4));
        break;
      }
      if ((str2.equals("DIRTY")) && (i4 == 2))
      {
        b.a(localb3, new a(localb3, null));
        break;
      }
      if ((str2.equals("READ")) && (i4 == 2))
        break;
      throw new IOException("unexpected journal line: ");
    }
  }

  // ERROR //
  private void c()
    throws IOException
  {
    // Byte code:
    //   0: new 403	java/io/BufferedInputStream
    //   3: dup
    //   4: new 405	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 107	com/viber/voip/b/b:d	Ljava/io/File;
    //   12: invokespecial 407	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: sipush 8192
    //   18: invokespecial 410	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 412	com/viber/voip/b/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore 4
    //   28: aload_1
    //   29: invokestatic 412	com/viber/voip/b/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   32: astore 5
    //   34: aload_1
    //   35: invokestatic 412	com/viber/voip/b/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   38: astore 6
    //   40: aload_1
    //   41: invokestatic 412	com/viber/voip/b/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   44: astore 7
    //   46: aload_1
    //   47: invokestatic 412	com/viber/voip/b/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   50: astore 8
    //   52: ldc_w 414
    //   55: aload 4
    //   57: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +55 -> 115
    //   63: ldc_w 416
    //   66: aload 5
    //   68: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifeq +44 -> 115
    //   74: aload_0
    //   75: getfield 98	com/viber/voip/b/b:f	I
    //   78: invokestatic 421	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   81: aload 6
    //   83: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +29 -> 115
    //   89: aload_0
    //   90: getfield 113	com/viber/voip/b/b:h	I
    //   93: invokestatic 421	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   96: aload 7
    //   98: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifeq +14 -> 115
    //   104: ldc_w 423
    //   107: aload 8
    //   109: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: ifne +77 -> 189
    //   115: new 123	java/io/IOException
    //   118: dup
    //   119: new 158	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 425
    //   129: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 4
    //   134: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 427
    //   140: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 5
    //   145: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 427
    //   151: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 7
    //   156: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 427
    //   162: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 8
    //   167: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 429
    //   173: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 333	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: astore_3
    //   184: aload_1
    //   185: invokestatic 431	com/viber/voip/b/b:a	(Ljava/io/Closeable;)V
    //   188: return
    //   189: aload_0
    //   190: aload_1
    //   191: invokespecial 433	com/viber/voip/b/b:b	(Ljava/io/InputStream;)V
    //   194: aload_1
    //   195: invokestatic 431	com/viber/voip/b/b:a	(Ljava/io/Closeable;)V
    //   198: return
    //   199: astore_2
    //   200: aload_1
    //   201: invokestatic 431	com/viber/voip/b/b:a	(Ljava/io/Closeable;)V
    //   204: aload_2
    //   205: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   22	115	183	java/lang/Exception
    //   115	183	183	java/lang/Exception
    //   189	194	183	java/lang/Exception
    //   22	115	199	finally
    //   115	183	199	finally
    //   189	194	199	finally
  }

  private void d()
    throws IOException
  {
    b(this.e);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (b.a(localb) == null)
      {
        for (int i2 = 0; i2 < this.h; i2++)
          this.l += b.b(localb)[i2];
      }
      else
      {
        b.a(localb, null);
        for (int i1 = 0; i1 < this.h; i1++)
        {
          b(localb.a(i1));
          b(localb.b(i1));
        }
        localIterator.remove();
      }
    }
  }

  private void d(String paramString)
  {
    if ((paramString.contains(" ")) || (paramString.contains("\n")) || (paramString.contains("\r")))
      throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + paramString + "\"");
  }

  private void e()
    throws IOException
  {
    BufferedWriter localBufferedWriter;
    while (true)
    {
      b localb;
      try
      {
        if (this.m != null)
          this.m.close();
        localBufferedWriter = new BufferedWriter(new FileWriter(this.e), 8192);
        localBufferedWriter.write("libcore.io.DiskLruCache");
        localBufferedWriter.write("\n");
        localBufferedWriter.write("1");
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.f));
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.h));
        localBufferedWriter.write("\n");
        localBufferedWriter.write("\n");
        Iterator localIterator = this.j.values().iterator();
        if (!localIterator.hasNext())
          break;
        localb = (b)localIterator.next();
        if (b.a(localb) != null)
        {
          localBufferedWriter.write("DIRTY " + b.c(localb) + '\n');
          continue;
        }
      }
      finally
      {
      }
      localBufferedWriter.write("CLEAN " + b.c(localb) + localb.a() + '\n');
    }
    localBufferedWriter.close();
    this.e.renameTo(this.d);
    this.m = new BufferedWriter(new FileWriter(this.d, true), 8192);
  }

  private boolean f()
  {
    return (this.n >= 2000) && (this.n >= this.j.size());
  }

  private void g()
  {
    if (this.m == null)
      throw new IllegalStateException("cache is closed");
  }

  private void h()
    throws IOException
  {
    while (this.l > this.g)
      c((String)((Map.Entry)this.j.entrySet().iterator().next()).getKey());
  }

  // ERROR //
  public c a(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 125	com/viber/voip/b/b:g	()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 128	com/viber/voip/b/b:d	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 65	com/viber/voip/b/b:j	Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual 132	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 134	com/viber/voip/b/b$b
    //   22: astore_3
    //   23: aconst_null
    //   24: astore 4
    //   26: aload_3
    //   27: ifnonnull +8 -> 35
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: areturn
    //   35: aload_3
    //   36: invokestatic 253	com/viber/voip/b/b$b:d	(Lcom/viber/voip/b/b$b;)Z
    //   39: istore 5
    //   41: aconst_null
    //   42: astore 4
    //   44: iload 5
    //   46: ifeq -16 -> 30
    //   49: aload_0
    //   50: getfield 113	com/viber/voip/b/b:h	I
    //   53: anewarray 226	java/io/InputStream
    //   56: astore 6
    //   58: iconst_0
    //   59: istore 7
    //   61: iload 7
    //   63: aload_0
    //   64: getfield 113	com/viber/voip/b/b:h	I
    //   67: if_icmpge +27 -> 94
    //   70: aload 6
    //   72: iload 7
    //   74: new 405	java/io/FileInputStream
    //   77: dup
    //   78: aload_3
    //   79: iload 7
    //   81: invokevirtual 265	com/viber/voip/b/b$b:a	(I)Ljava/io/File;
    //   84: invokespecial 407	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: aastore
    //   88: iinc 7 1
    //   91: goto -30 -> 61
    //   94: aload_0
    //   95: iconst_1
    //   96: aload_0
    //   97: getfield 120	com/viber/voip/b/b:n	I
    //   100: iadd
    //   101: putfield 120	com/viber/voip/b/b:n	I
    //   104: aload_0
    //   105: getfield 156	com/viber/voip/b/b:m	Ljava/io/Writer;
    //   108: ldc_w 498
    //   111: invokevirtual 501	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   114: aload_1
    //   115: invokevirtual 501	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   118: bipush 10
    //   120: invokevirtual 504	java/io/Writer:append	(C)Ljava/io/Writer;
    //   123: pop
    //   124: aload_0
    //   125: invokespecial 293	com/viber/voip/b/b:f	()Z
    //   128: ifeq +17 -> 145
    //   131: aload_0
    //   132: getfield 83	com/viber/voip/b/b:k	Ljava/util/concurrent/ExecutorService;
    //   135: aload_0
    //   136: getfield 92	com/viber/voip/b/b:o	Ljava/util/concurrent/Callable;
    //   139: invokeinterface 299 2 0
    //   144: pop
    //   145: new 506	com/viber/voip/b/b$c
    //   148: dup
    //   149: aload_0
    //   150: aload_1
    //   151: aload_3
    //   152: invokestatic 139	com/viber/voip/b/b$b:e	(Lcom/viber/voip/b/b$b;)J
    //   155: aload 6
    //   157: aconst_null
    //   158: invokespecial 509	com/viber/voip/b/b$c:<init>	(Lcom/viber/voip/b/b;Ljava/lang/String;J[Ljava/io/InputStream;Lcom/viber/voip/b/b$1;)V
    //   161: astore 4
    //   163: goto -133 -> 30
    //   166: astore_2
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_2
    //   170: athrow
    //   171: astore 8
    //   173: aconst_null
    //   174: astore 4
    //   176: goto -146 -> 30
    //
    // Exception table:
    //   from	to	target	type
    //   2	23	166	finally
    //   35	41	166	finally
    //   49	58	166	finally
    //   61	88	166	finally
    //   94	145	166	finally
    //   145	163	166	finally
    //   61	88	171	java/io/FileNotFoundException
  }

  public boolean a()
  {
    return this.m == null;
  }

  public a b(String paramString)
    throws IOException
  {
    return a(paramString, -1L);
  }

  public void b()
    throws IOException
  {
    close();
    a(this.c);
  }

  public boolean c(String paramString)
    throws IOException
  {
    while (true)
    {
      try
      {
        g();
        d(paramString);
        b localb = (b)this.j.get(paramString);
        int i1;
        if (localb != null)
        {
          a locala = b.a(localb);
          i1 = 0;
          if (locala == null);
        }
        else
        {
          bool = false;
          return bool;
          this.l -= b.b(localb)[i1];
          b.b(localb)[i1] = 0L;
          i1++;
        }
        if (i1 < this.h)
        {
          File localFile = localb.a(i1);
          if (at.f(localFile))
            continue;
          throw new IOException("failed to delete " + localFile);
        }
      }
      finally
      {
      }
      this.n = (1 + this.n);
      this.m.append("REMOVE ").append(paramString).append('\n');
      this.j.remove(paramString);
      if (f())
        this.k.submit(this.o);
      boolean bool = true;
    }
  }

  public void close()
    throws IOException
  {
    while (true)
    {
      try
      {
        Writer localWriter = this.m;
        if (localWriter == null)
          return;
        Iterator localIterator = new ArrayList(this.j.values()).iterator();
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (b.a(localb) == null)
            continue;
          b.a(localb).b();
          continue;
        }
      }
      finally
      {
      }
      h();
      this.m.close();
      this.m = null;
    }
  }

  public final class a
  {
    private final b.b b;
    private boolean c;

    private a(b.b arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public OutputStream a(int paramInt)
      throws IOException
    {
      synchronized (b.this)
      {
        if (b.b.a(this.b) != this)
          throw new IllegalStateException();
      }
      a locala = new a(new FileOutputStream(this.b.b(paramInt)), null);
      return locala;
    }

    public void a()
      throws IOException
    {
      if (this.c)
      {
        b.a(b.this, this, false);
        b.this.c(b.b.c(this.b));
        return;
      }
      b.a(b.this, this, true);
    }

    public void b()
      throws IOException
    {
      b.a(b.this, this, false);
    }

    private class a extends FilterOutputStream
    {
      private a(OutputStream arg2)
      {
        super();
      }

      public void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          b.a.a(b.a.this, true);
        }
      }

      public void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          b.a.a(b.a.this, true);
        }
      }

      public void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          b.a.a(b.a.this, true);
        }
      }

      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException localIOException)
        {
          b.a.a(b.a.this, true);
        }
      }
    }
  }

  private final class b
  {
    private final String b;
    private final long[] c;
    private boolean d;
    private b.a e;
    private long f;

    private b(String arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = new long[b.e(b.this)];
    }

    private void a(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != b.e(b.this))
        throw b(paramArrayOfString);
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.c[i] = Long.parseLong(paramArrayOfString[i]);
          i++;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw b(paramArrayOfString);
      }
    }

    private IOException b(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }

    public File a(int paramInt)
    {
      return new File(b.f(b.this), this.b + "." + paramInt);
    }

    public String a()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (long l : this.c)
        localStringBuilder.append(' ').append(l);
      return localStringBuilder.toString();
    }

    public File b(int paramInt)
    {
      return new File(b.f(b.this), this.b + "." + paramInt + ".tmp");
    }
  }

  public final class c
    implements Closeable
  {
    private final String b;
    private final long c;
    private final InputStream[] d;

    private c(String paramLong, long arg3, InputStream[] arg5)
    {
      this.b = paramLong;
      this.c = ???;
      Object localObject;
      this.d = localObject;
    }

    public InputStream a(int paramInt)
    {
      return this.d[paramInt];
    }

    public void close()
    {
      InputStream[] arrayOfInputStream = this.d;
      int i = arrayOfInputStream.length;
      for (int j = 0; j < i; j++)
        b.a(arrayOfInputStream[j]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.b
 * JD-Core Version:    0.6.2
 */