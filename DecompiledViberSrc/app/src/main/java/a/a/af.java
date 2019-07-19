package a.a;

import com.appboy.f.c;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class af
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  private static final String c = c.a(af.class);
  private static final OutputStream q = new OutputStream()
  {
    public void write(int paramAnonymousInt)
    {
    }
  };
  final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File d;
  private final File e;
  private final File f;
  private final File g;
  private final int h;
  private long i;
  private final int j;
  private long k = 0L;
  private Writer l;
  private final LinkedHashMap<String, ag> m = new LinkedHashMap(0, 0.75F, true);
  private int n;
  private long o = 0L;
  private final Callable<Void> p = new Callable()
  {
    public Void a()
    {
      synchronized (af.this)
      {
        if (af.a(af.this) == null)
          return null;
        af.b(af.this);
        if (af.c(af.this))
        {
          af.d(af.this);
          af.a(af.this, 0);
        }
        return null;
      }
    }
  };

  private af(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.d = paramFile;
    this.h = paramInt1;
    this.e = new File(paramFile, "journal");
    this.f = new File(paramFile, "journal.tmp");
    this.g = new File(paramFile, "journal.bkp");
    this.j = paramInt2;
    this.i = paramLong;
  }

  private a a(String paramString, long paramLong)
  {
    while (true)
    {
      ag localag1;
      a locala2;
      ag localag2;
      try
      {
        h();
        e(paramString);
        localag1 = (ag)this.m.get(paramString);
        if (paramLong != -1L)
          if (localag1 != null)
          {
            long l1 = localag1.e;
            if (l1 == paramLong);
          }
          else
          {
            locala2 = null;
            return locala2;
          }
        if (localag1 == null)
        {
          ag localag3 = new ag(paramString, this.j, this.d);
          this.m.put(paramString, localag3);
          localag2 = localag3;
          locala2 = new a(localag2, null);
          localag2.d = locala2;
          this.l.write("DIRTY " + paramString + '\n');
          this.l.flush();
          continue;
        }
      }
      finally
      {
      }
      a locala1 = localag1.d;
      if (locala1 != null)
        locala2 = null;
      else
        localag2 = localag1;
    }
  }

  public static af a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0");
    File localFile1 = new File(paramFile, "journal.bkp");
    File localFile2;
    if (localFile1.exists())
    {
      localFile2 = new File(paramFile, "journal");
      if (!localFile2.exists())
        break label113;
      localFile1.delete();
    }
    while (true)
    {
      af localaf1 = new af(paramFile, paramInt1, paramInt2, paramLong);
      if (localaf1.e.exists())
        try
        {
          localaf1.d();
          localaf1.e();
          return localaf1;
          label113: a(localFile1, localFile2, false);
        }
        catch (IOException localIOException)
        {
          c.e(c, "DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
          localaf1.b();
        }
    }
    paramFile.mkdirs();
    af localaf2 = new af(paramFile, paramInt1, paramInt2, paramLong);
    localaf2.f();
    return localaf2;
  }

  private void a(a parama, boolean paramBoolean)
  {
    ag localag;
    try
    {
      localag = a.a(parama);
      if (localag.d != parama)
        throw new IllegalStateException();
    }
    finally
    {
    }
    int i1 = 0;
    if (paramBoolean)
    {
      boolean bool = localag.c;
      i1 = 0;
      if (!bool)
        for (int i2 = 0; ; i2++)
        {
          int i3 = this.j;
          i1 = 0;
          if (i2 >= i3)
            break;
          if (a.b(parama)[i2] == 0)
          {
            parama.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
          }
          if (!localag.b(i2).exists())
          {
            parama.b();
            return;
          }
        }
    }
    while (true)
    {
      if (i1 < this.j)
      {
        File localFile1 = localag.b(i1);
        if (paramBoolean)
        {
          if (localFile1.exists())
          {
            File localFile2 = localag.a(i1);
            localFile1.renameTo(localFile2);
            long l2 = localag.b[i1];
            long l3 = localFile2.length();
            localag.b[i1] = l3;
            this.k = (l3 + (this.k - l2));
          }
        }
        else
          a(localFile1);
      }
      else
      {
        this.n = (1 + this.n);
        localag.d = null;
        if ((paramBoolean | localag.c))
        {
          localag.c = true;
          this.l.write("CLEAN " + localag.a + localag.a() + '\n');
          if (paramBoolean)
          {
            long l1 = this.o;
            this.o = (1L + l1);
            localag.e = l1;
          }
        }
        while (true)
        {
          this.l.flush();
          if ((this.k <= this.i) && (!g()))
            break;
          this.b.submit(this.p);
          break;
          this.m.remove(localag.a);
          this.l.write("REMOVE " + localag.a + '\n');
        }
      }
      i1++;
    }
  }

  private static void a(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete()))
      throw new IOException();
  }

  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean)
      a(paramFile2);
    if (!paramFile1.renameTo(paramFile2))
      throw new IOException();
  }

  // ERROR //
  private void d()
  {
    // Byte code:
    //   0: new 301	a/a/ah
    //   3: dup
    //   4: new 303	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 111	a/a/af:e	Ljava/io/File;
    //   12: invokespecial 305	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 310	a/a/ai:a	Ljava/nio/charset/Charset;
    //   18: invokespecial 313	a/a/ah:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 314	a/a/ah:a	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_1
    //   28: invokevirtual 314	a/a/ah:a	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_1
    //   34: invokevirtual 314	a/a/ah:a	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_1
    //   40: invokevirtual 314	a/a/ah:a	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_1
    //   46: invokevirtual 314	a/a/ah:a	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc_w 316
    //   54: aload_3
    //   55: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq +55 -> 113
    //   61: ldc_w 324
    //   64: aload 4
    //   66: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +44 -> 113
    //   72: aload_0
    //   73: getfield 102	a/a/af:h	I
    //   76: invokestatic 329	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   79: aload 5
    //   81: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +29 -> 113
    //   87: aload_0
    //   88: getfield 121	a/a/af:j	I
    //   91: invokestatic 329	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   94: aload 6
    //   96: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +14 -> 113
    //   102: ldc_w 331
    //   105: aload 7
    //   107: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifne +77 -> 187
    //   113: new 186	java/io/IOException
    //   116: dup
    //   117: new 161	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 333
    //   127: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 335
    //   137: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 4
    //   142: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 335
    //   148: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 6
    //   153: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 335
    //   159: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 7
    //   164: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 337
    //   170: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 338	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: astore_2
    //   181: aload_1
    //   182: invokestatic 341	a/a/ai:a	(Ljava/io/Closeable;)V
    //   185: aload_2
    //   186: athrow
    //   187: iconst_0
    //   188: istore 8
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual 314	a/a/ah:a	()Ljava/lang/String;
    //   195: invokespecial 343	a/a/af:d	(Ljava/lang/String;)V
    //   198: iinc 8 1
    //   201: goto -11 -> 190
    //   204: astore 9
    //   206: aload_0
    //   207: iload 8
    //   209: aload_0
    //   210: getfield 71	a/a/af:m	Ljava/util/LinkedHashMap;
    //   213: invokevirtual 347	java/util/LinkedHashMap:size	()I
    //   216: isub
    //   217: putfield 126	a/a/af:n	I
    //   220: aload_1
    //   221: invokevirtual 349	a/a/ah:b	()Z
    //   224: ifeq +12 -> 236
    //   227: aload_0
    //   228: invokespecial 232	a/a/af:f	()V
    //   231: aload_1
    //   232: invokestatic 341	a/a/ai:a	(Ljava/io/Closeable;)V
    //   235: return
    //   236: aload_0
    //   237: new 351	java/io/BufferedWriter
    //   240: dup
    //   241: new 353	java/io/OutputStreamWriter
    //   244: dup
    //   245: new 355	java/io/FileOutputStream
    //   248: dup
    //   249: aload_0
    //   250: getfield 111	a/a/af:e	Ljava/io/File;
    //   253: iconst_1
    //   254: invokespecial 358	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   257: getstatic 310	a/a/ai:a	Ljava/nio/charset/Charset;
    //   260: invokespecial 361	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   263: invokespecial 364	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   266: putfield 159	a/a/af:l	Ljava/io/Writer;
    //   269: goto -38 -> 231
    //
    // Exception table:
    //   from	to	target	type
    //   22	113	180	finally
    //   113	180	180	finally
    //   190	198	180	finally
    //   206	231	180	finally
    //   236	269	180	finally
    //   190	198	204	java/io/EOFException
  }

  private void d(String paramString)
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1)
      throw new IOException("unexpected journal line: " + paramString);
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    String str2;
    if (i3 == -1)
    {
      str2 = paramString.substring(i2);
      if ((i1 != "REMOVE".length()) || (!paramString.startsWith("REMOVE")))
        break label315;
      this.m.remove(str2);
    }
    label315: for (String str1 = paramString.substring(i2, i3); ; str1 = str2)
    {
      ag localag = (ag)this.m.get(str1);
      if (localag == null)
      {
        localag = new ag(str1, this.j, this.d);
        this.m.put(str1, localag);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        String[] arrayOfString = paramString.substring(i3 + 1).split(" ");
        localag.c = true;
        localag.d = null;
        localag.a(arrayOfString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        localag.d = new a(localag, null);
        return;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ")))
        break;
      throw new IOException("unexpected journal line: " + paramString);
    }
  }

  private void e()
  {
    a(this.f);
    Iterator localIterator = this.m.values().iterator();
    while (localIterator.hasNext())
    {
      ag localag = (ag)localIterator.next();
      if (localag.d == null)
      {
        for (int i2 = 0; i2 < this.j; i2++)
          this.k += localag.b[i2];
      }
      else
      {
        localag.d = null;
        for (int i1 = 0; i1 < this.j; i1++)
        {
          a(localag.a(i1));
          a(localag.b(i1));
        }
        localIterator.remove();
      }
    }
  }

  private void e(String paramString)
  {
    if (!a.matcher(paramString).matches())
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
  }

  private void f()
  {
    BufferedWriter localBufferedWriter;
    while (true)
    {
      ag localag;
      try
      {
        if (this.l != null)
          this.l.close();
        localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f), ai.a));
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.h));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.j));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.m.values().iterator();
          if (!localIterator.hasNext())
            break;
          localag = (ag)localIterator.next();
          if (localag.d != null)
          {
            localBufferedWriter.write("DIRTY " + localag.a + '\n');
            continue;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
      }
      finally
      {
      }
      localBufferedWriter.write("CLEAN " + localag.a + localag.a() + '\n');
    }
    localBufferedWriter.close();
    if (this.e.exists())
      a(this.e, this.g, true);
    a(this.f, this.e, false);
    this.g.delete();
    this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e, true), ai.a));
  }

  private boolean g()
  {
    return (this.n >= 2000) && (this.n >= this.m.size());
  }

  private void h()
  {
    if (this.l == null)
      throw new IllegalStateException("cache is closed");
  }

  private void i()
  {
    while (this.k > this.i)
      c((String)((Map.Entry)this.m.entrySet().iterator().next()).getKey());
  }

  public b a(String paramString)
  {
    try
    {
      h();
      e(paramString);
      ag localag = (ag)this.m.get(paramString);
      b localb = null;
      if (localag == null);
      while (true)
      {
        return localb;
        boolean bool = localag.c;
        localb = null;
        if (bool)
        {
          InputStream[] arrayOfInputStream = new InputStream[this.j];
          int i1 = 0;
          while (true)
          {
            int i2;
            int i3;
            try
            {
              if (i1 >= this.j)
                break label144;
              arrayOfInputStream[i1] = new FileInputStream(localag.a(i1));
              i1++;
              continue;
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              i2 = 0;
              i3 = this.j;
              localb = null;
            }
            if (i2 >= i3)
              break;
            InputStream localInputStream = arrayOfInputStream[i2];
            localb = null;
            if (localInputStream == null)
              break;
            ai.a(arrayOfInputStream[i2]);
            i2++;
          }
          label144: this.n = (1 + this.n);
          this.l.append("READ " + paramString + '\n');
          if (g())
            this.b.submit(this.p);
          localb = new b(paramString, localag.e, arrayOfInputStream, localag.b, null);
        }
      }
    }
    finally
    {
    }
  }

  public void a()
  {
    while (true)
    {
      try
      {
        Writer localWriter = this.l;
        if (localWriter == null)
          return;
        Iterator localIterator = new ArrayList(this.m.values()).iterator();
        if (localIterator.hasNext())
        {
          ag localag = (ag)localIterator.next();
          if (localag.d == null)
            continue;
          localag.d.b();
          continue;
        }
      }
      finally
      {
      }
      i();
      this.l.close();
      this.l = null;
    }
  }

  public a b(String paramString)
  {
    return a(paramString, -1L);
  }

  public void b()
  {
    a();
    ai.a(this.d);
  }

  public boolean c(String paramString)
  {
    while (true)
    {
      try
      {
        h();
        e(paramString);
        ag localag = (ag)this.m.get(paramString);
        int i1;
        if (localag != null)
        {
          a locala = localag.d;
          i1 = 0;
          if (locala == null);
        }
        else
        {
          bool = false;
          return bool;
          this.k -= localag.b[i1];
          localag.b[i1] = 0L;
          i1++;
        }
        if (i1 < this.j)
        {
          File localFile = localag.a(i1);
          if ((!localFile.exists()) || (localFile.delete()))
            continue;
          throw new IOException("failed to delete " + localFile);
        }
      }
      finally
      {
      }
      this.n = (1 + this.n);
      this.l.append("REMOVE " + paramString + '\n');
      this.m.remove(paramString);
      if (g())
        this.b.submit(this.p);
      boolean bool = true;
    }
  }

  public final class a
  {
    private final ag b;
    private final boolean[] c;
    private boolean d;
    private boolean e;

    private a(ag arg2)
    {
      Object localObject;
      this.b = localObject;
      if (localObject.c);
      for (boolean[] arrayOfBoolean = null; ; arrayOfBoolean = new boolean[af.e(af.this)])
      {
        this.c = arrayOfBoolean;
        return;
      }
    }

    public OutputStream a(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= af.e(af.this)))
        throw new IllegalArgumentException("Expected index " + paramInt + " to be greater than 0 and less than the maximum value count of " + af.e(af.this));
      synchronized (af.this)
      {
        if (this.b.d != this)
          throw new IllegalStateException();
      }
      if (!this.b.c)
        this.c[paramInt] = true;
      File localFile = this.b.b(paramInt);
      try
      {
        FileOutputStream localFileOutputStream1 = new FileOutputStream(localFile);
        localObject2 = localFileOutputStream1;
        a locala = new a((OutputStream)localObject2, null);
        return locala;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        while (true)
        {
          Object localObject2;
          af.f(af.this).mkdirs();
          try
          {
            FileOutputStream localFileOutputStream2 = new FileOutputStream(localFile);
            localObject2 = localFileOutputStream2;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            OutputStream localOutputStream = af.c();
            return localOutputStream;
          }
        }
      }
    }

    public void a()
    {
      if (this.d)
      {
        af.a(af.this, this, false);
        af.this.c(this.b.a);
      }
      while (true)
      {
        this.e = true;
        return;
        af.a(af.this, this, true);
      }
    }

    public void b()
    {
      af.a(af.this, this, false);
    }

    class a extends FilterOutputStream
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
          af.a.a(af.a.this, true);
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
          af.a.a(af.a.this, true);
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
          af.a.a(af.a.this, true);
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
          af.a.a(af.a.this, true);
        }
      }
    }
  }

  public final class b
    implements Closeable
  {
    private final String b;
    private final long c;
    private final InputStream[] d;
    private final long[] e;

    private b(String paramLong, long arg3, InputStream[] paramArrayOfLong, long[] arg6)
    {
      this.b = paramLong;
      this.c = ???;
      this.d = paramArrayOfLong;
      Object localObject;
      this.e = localObject;
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
        ai.a(arrayOfInputStream[j]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.af
 * JD-Core Version:    0.6.2
 */