package com.mopub.common;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
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

public final class DiskLruCache
  implements Closeable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
  private static final OutputStream p = new OutputStream()
  {
    public void write(int paramAnonymousInt)
      throws IOException
    {
    }
  };
  final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File c;
  private final File d;
  private final File e;
  private final File f;
  private final int g;
  private long h;
  private final int i;
  private long j = 0L;
  private Writer k;
  private final LinkedHashMap<String, a> l = new LinkedHashMap(0, 0.75F, true);
  private int m;
  private long n = 0L;
  private final Callable<Void> o = new Callable()
  {
    public Void call()
      throws Exception
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.a(DiskLruCache.this) == null)
          return null;
        DiskLruCache.b(DiskLruCache.this);
        if (DiskLruCache.c(DiskLruCache.this))
        {
          DiskLruCache.d(DiskLruCache.this);
          DiskLruCache.a(DiskLruCache.this, 0);
        }
        return null;
      }
    }
  };

  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.c = paramFile;
    this.g = paramInt1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.f = new File(paramFile, "journal.bkp");
    this.i = paramInt2;
    this.h = paramLong;
  }

  private Editor a(String paramString, long paramLong)
    throws IOException
  {
    while (true)
    {
      a locala1;
      Editor localEditor2;
      a locala2;
      try
      {
        f();
        b(paramString);
        locala1 = (a)this.l.get(paramString);
        if (paramLong != -1L)
          if (locala1 != null)
          {
            long l1 = a.e(locala1);
            if (l1 == paramLong);
          }
          else
          {
            localEditor2 = null;
            return localEditor2;
          }
        if (locala1 == null)
        {
          a locala3 = new a(paramString, null);
          this.l.put(paramString, locala3);
          locala2 = locala3;
          localEditor2 = new Editor(locala2, null);
          a.a(locala2, localEditor2);
          this.k.write("DIRTY " + paramString + '\n');
          this.k.flush();
          continue;
        }
      }
      finally
      {
      }
      Editor localEditor1 = a.a(locala1);
      if (localEditor1 != null)
        localEditor2 = null;
      else
        locala2 = locala1;
    }
  }

  private void a(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    a locala;
    try
    {
      locala = Editor.a(paramEditor);
      if (a.a(locala) != paramEditor)
        throw new IllegalStateException();
    }
    finally
    {
    }
    int i1 = 0;
    if (paramBoolean)
    {
      boolean bool = a.d(locala);
      i1 = 0;
      if (!bool)
        for (int i2 = 0; ; i2++)
        {
          int i3 = this.i;
          i1 = 0;
          if (i2 >= i3)
            break;
          if (Editor.b(paramEditor)[i2] == 0)
          {
            paramEditor.abort();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
          }
          if (!locala.getDirtyFile(i2).exists())
          {
            paramEditor.abort();
            return;
          }
        }
    }
    while (true)
    {
      if (i1 < this.i)
      {
        File localFile1 = locala.getDirtyFile(i1);
        if (paramBoolean)
        {
          if (localFile1.exists())
          {
            File localFile2 = locala.getCleanFile(i1);
            localFile1.renameTo(localFile2);
            long l2 = a.b(locala)[i1];
            long l3 = localFile2.length();
            a.b(locala)[i1] = l3;
            this.j = (l3 + (this.j - l2));
          }
        }
        else
          a(localFile1);
      }
      else
      {
        this.m = (1 + this.m);
        a.a(locala, null);
        if ((paramBoolean | a.d(locala)))
        {
          a.a(locala, true);
          this.k.write("CLEAN " + a.c(locala) + locala.getLengths() + '\n');
          if (paramBoolean)
          {
            long l1 = this.n;
            this.n = (1L + l1);
            a.a(locala, l1);
          }
        }
        while (true)
        {
          this.k.flush();
          if ((this.j <= this.h) && (!e()))
            break;
          this.b.submit(this.o);
          break;
          this.l.remove(a.c(locala));
          this.k.write("REMOVE " + a.c(locala) + '\n');
        }
      }
      i1++;
    }
  }

  private static void a(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (!paramFile.delete()))
      throw new IOException();
  }

  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
      a(paramFile2);
    if (!paramFile1.renameTo(paramFile2))
      throw new IOException();
  }

  private void a(String paramString)
    throws IOException
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
        break label312;
      this.l.remove(str2);
    }
    label312: for (String str1 = paramString.substring(i2, i3); ; str1 = str2)
    {
      a locala = (a)this.l.get(str1);
      if (locala == null)
      {
        locala = new a(str1, null);
        this.l.put(str1, locala);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        String[] arrayOfString = paramString.substring(i3 + 1).split(" ");
        a.a(locala, true);
        a.a(locala, null);
        a.a(locala, arrayOfString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        a.a(locala, new Editor(locala, null));
        return;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ")))
        break;
      throw new IOException("unexpected journal line: " + paramString);
    }
  }

  private static String b(InputStream paramInputStream)
    throws IOException
  {
    return DiskLruCacheUtil.a(new InputStreamReader(paramInputStream, DiskLruCacheUtil.b));
  }

  // ERROR //
  private void b()
    throws IOException
  {
    // Byte code:
    //   0: new 331	com/mopub/common/e
    //   3: dup
    //   4: new 333	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 104	com/mopub/common/DiskLruCache:d	Ljava/io/File;
    //   12: invokespecial 335	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 337	com/mopub/common/DiskLruCacheUtil:a	Ljava/nio/charset/Charset;
    //   18: invokespecial 338	com/mopub/common/e:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 341	com/mopub/common/e:readLine	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_1
    //   28: invokevirtual 341	com/mopub/common/e:readLine	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_1
    //   34: invokevirtual 341	com/mopub/common/e:readLine	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_1
    //   40: invokevirtual 341	com/mopub/common/e:readLine	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_1
    //   46: invokevirtual 341	com/mopub/common/e:readLine	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc_w 343
    //   54: aload_3
    //   55: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq +55 -> 113
    //   61: ldc_w 349
    //   64: aload 4
    //   66: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +44 -> 113
    //   72: aload_0
    //   73: getfield 95	com/mopub/common/DiskLruCache:g	I
    //   76: invokestatic 353	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   79: aload 5
    //   81: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +29 -> 113
    //   87: aload_0
    //   88: getfield 114	com/mopub/common/DiskLruCache:i	I
    //   91: invokestatic 353	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   94: aload 6
    //   96: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +14 -> 113
    //   102: ldc_w 355
    //   105: aload 7
    //   107: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifne +77 -> 187
    //   113: new 122	java/io/IOException
    //   116: dup
    //   117: new 160	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 357
    //   127: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 359
    //   137: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 4
    //   142: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 359
    //   148: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 6
    //   153: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 359
    //   159: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 7
    //   164: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 361
    //   170: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 280	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: astore_2
    //   181: aload_1
    //   182: invokestatic 364	com/mopub/common/DiskLruCacheUtil:a	(Ljava/io/Closeable;)V
    //   185: aload_2
    //   186: athrow
    //   187: iconst_0
    //   188: istore 8
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual 341	com/mopub/common/e:readLine	()Ljava/lang/String;
    //   195: invokespecial 366	com/mopub/common/DiskLruCache:a	(Ljava/lang/String;)V
    //   198: iinc 8 1
    //   201: goto -11 -> 190
    //   204: astore 9
    //   206: aload_0
    //   207: iload 8
    //   209: aload_0
    //   210: getfield 64	com/mopub/common/DiskLruCache:l	Ljava/util/LinkedHashMap;
    //   213: invokevirtual 369	java/util/LinkedHashMap:size	()I
    //   216: isub
    //   217: putfield 119	com/mopub/common/DiskLruCache:m	I
    //   220: aload_1
    //   221: invokestatic 364	com/mopub/common/DiskLruCacheUtil:a	(Ljava/io/Closeable;)V
    //   224: return
    //
    // Exception table:
    //   from	to	target	type
    //   22	113	180	finally
    //   113	180	180	finally
    //   190	198	180	finally
    //   206	220	180	finally
    //   190	198	204	java/io/EOFException
  }

  private void b(String paramString)
  {
    if (!a.matcher(paramString).matches())
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
  }

  private void c()
    throws IOException
  {
    a(this.e);
    Iterator localIterator = this.l.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (a.a(locala) == null)
      {
        for (int i2 = 0; i2 < this.i; i2++)
          this.j += a.b(locala)[i2];
      }
      else
      {
        a.a(locala, null);
        for (int i1 = 0; i1 < this.i; i1++)
        {
          a(locala.getCleanFile(i1));
          a(locala.getDirtyFile(i1));
        }
        localIterator.remove();
      }
    }
  }

  private void d()
    throws IOException
  {
    BufferedWriter localBufferedWriter;
    while (true)
    {
      a locala;
      try
      {
        if (this.k != null)
          this.k.close();
        localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), DiskLruCacheUtil.a));
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.g));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.i));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.l.values().iterator();
          if (!localIterator.hasNext())
            break;
          locala = (a)localIterator.next();
          if (a.a(locala) != null)
          {
            localBufferedWriter.write("DIRTY " + a.c(locala) + '\n');
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
      localBufferedWriter.write("CLEAN " + a.c(locala) + locala.getLengths() + '\n');
    }
    localBufferedWriter.close();
    if (this.d.exists())
      a(this.d, this.f, true);
    a(this.e, this.d, false);
    this.f.delete();
    this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), DiskLruCacheUtil.a));
  }

  private boolean e()
  {
    return (this.m >= 2000) && (this.m >= this.l.size());
  }

  private void f()
  {
    if (this.k == null)
      throw new IllegalStateException("cache is closed");
  }

  private void g()
    throws IOException
  {
    while (this.j > this.h)
      remove((String)((Map.Entry)this.l.entrySet().iterator().next()).getKey());
  }

  public static DiskLruCache open(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
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
        break label150;
      localFile1.delete();
    }
    while (true)
    {
      DiskLruCache localDiskLruCache1 = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
      if (localDiskLruCache1.d.exists())
        try
        {
          localDiskLruCache1.b();
          localDiskLruCache1.c();
          localDiskLruCache1.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localDiskLruCache1.d, true), DiskLruCacheUtil.a));
          return localDiskLruCache1;
          label150: a(localFile1, localFile2, false);
        }
        catch (IOException localIOException)
        {
          System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
          localDiskLruCache1.delete();
        }
    }
    paramFile.mkdirs();
    DiskLruCache localDiskLruCache2 = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
    localDiskLruCache2.d();
    return localDiskLruCache2;
  }

  public void close()
    throws IOException
  {
    while (true)
    {
      try
      {
        Writer localWriter = this.k;
        if (localWriter == null)
          return;
        Iterator localIterator = new ArrayList(this.l.values()).iterator();
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (a.a(locala) == null)
            continue;
          a.a(locala).abort();
          continue;
        }
      }
      finally
      {
      }
      g();
      this.k.close();
      this.k = null;
    }
  }

  public void delete()
    throws IOException
  {
    close();
    DiskLruCacheUtil.a(this.c);
  }

  public Editor edit(String paramString)
    throws IOException
  {
    return a(paramString, -1L);
  }

  public void flush()
    throws IOException
  {
    try
    {
      f();
      g();
      this.k.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Snapshot get(String paramString)
    throws IOException
  {
    try
    {
      f();
      b(paramString);
      a locala = (a)this.l.get(paramString);
      Snapshot localSnapshot = null;
      if (locala == null);
      while (true)
      {
        return localSnapshot;
        boolean bool = a.d(locala);
        localSnapshot = null;
        if (bool)
        {
          InputStream[] arrayOfInputStream = new InputStream[this.i];
          int i1 = 0;
          while (true)
          {
            int i2;
            int i3;
            try
            {
              if (i1 >= this.i)
                break label144;
              arrayOfInputStream[i1] = new FileInputStream(locala.getCleanFile(i1));
              i1++;
              continue;
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              i2 = 0;
              i3 = this.i;
              localSnapshot = null;
            }
            if (i2 >= i3)
              break;
            InputStream localInputStream = arrayOfInputStream[i2];
            localSnapshot = null;
            if (localInputStream == null)
              break;
            DiskLruCacheUtil.a(arrayOfInputStream[i2]);
            i2++;
          }
          label144: this.m = (1 + this.m);
          this.k.append("READ " + paramString + '\n');
          if (e())
            this.b.submit(this.o);
          localSnapshot = new Snapshot(paramString, a.e(locala), arrayOfInputStream, a.b(locala), null);
        }
      }
    }
    finally
    {
    }
  }

  public File getDirectory()
  {
    return this.c;
  }

  public long getMaxSize()
  {
    try
    {
      long l1 = this.h;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isClosed()
  {
    try
    {
      Writer localWriter = this.k;
      if (localWriter == null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public boolean remove(String paramString)
    throws IOException
  {
    while (true)
    {
      try
      {
        f();
        b(paramString);
        a locala = (a)this.l.get(paramString);
        int i1;
        if (locala != null)
        {
          Editor localEditor = a.a(locala);
          i1 = 0;
          if (localEditor == null);
        }
        else
        {
          bool = false;
          return bool;
          this.j -= a.b(locala)[i1];
          a.b(locala)[i1] = 0L;
          i1++;
        }
        if (i1 < this.i)
        {
          File localFile = locala.getCleanFile(i1);
          if ((!localFile.exists()) || (localFile.delete()))
            continue;
          throw new IOException("failed to delete " + localFile);
        }
      }
      finally
      {
      }
      this.m = (1 + this.m);
      this.k.append("REMOVE " + paramString + '\n');
      this.l.remove(paramString);
      if (e())
        this.b.submit(this.o);
      boolean bool = true;
    }
  }

  public void setMaxSize(long paramLong)
  {
    try
    {
      this.h = paramLong;
      this.b.submit(this.o);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long size()
  {
    try
    {
      long l1 = this.j;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final class Editor
  {
    private final DiskLruCache.a b;
    private final boolean[] c;
    private boolean d;
    private boolean e;

    private Editor(DiskLruCache.a arg2)
    {
      DiskLruCache.a locala;
      this.b = locala;
      if (DiskLruCache.a.d(locala));
      for (boolean[] arrayOfBoolean = null; ; arrayOfBoolean = new boolean[DiskLruCache.e(DiskLruCache.this)])
      {
        this.c = arrayOfBoolean;
        return;
      }
    }

    public void abort()
      throws IOException
    {
      DiskLruCache.a(DiskLruCache.this, this, false);
    }

    public void abortUnlessCommitted()
    {
      if (!this.e);
      try
      {
        abort();
        return;
      }
      catch (IOException localIOException)
      {
      }
    }

    public void commit()
      throws IOException
    {
      if (this.d)
      {
        DiskLruCache.a(DiskLruCache.this, this, false);
        DiskLruCache.this.remove(DiskLruCache.a.c(this.b));
      }
      while (true)
      {
        this.e = true;
        return;
        DiskLruCache.a(DiskLruCache.this, this, true);
      }
    }

    public String getString(int paramInt)
      throws IOException
    {
      InputStream localInputStream = newInputStream(paramInt);
      if (localInputStream != null)
        return DiskLruCache.a(localInputStream);
      return null;
    }

    public InputStream newInputStream(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.a.a(this.b) != this)
          throw new IllegalStateException();
      }
      if (!DiskLruCache.a.d(this.b))
        return null;
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.b.getCleanFile(paramInt));
        return localFileInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
      }
      return null;
    }

    public OutputStream newOutputStream(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.a.a(this.b) != this)
          throw new IllegalStateException();
      }
      if (!DiskLruCache.a.d(this.b))
        this.c[paramInt] = true;
      File localFile = this.b.getDirtyFile(paramInt);
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
          DiskLruCache.f(DiskLruCache.this).mkdirs();
          try
          {
            FileOutputStream localFileOutputStream2 = new FileOutputStream(localFile);
            localObject2 = localFileOutputStream2;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            OutputStream localOutputStream = DiskLruCache.a();
            return localOutputStream;
          }
        }
      }
    }

    // ERROR //
    public void set(int paramInt, String paramString)
      throws IOException
    {
      // Byte code:
      //   0: new 117	java/io/OutputStreamWriter
      //   3: dup
      //   4: aload_0
      //   5: iload_1
      //   6: invokevirtual 119	com/mopub/common/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
      //   9: getstatic 124	com/mopub/common/DiskLruCacheUtil:b	Ljava/nio/charset/Charset;
      //   12: invokespecial 127	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
      //   15: astore_3
      //   16: aload_3
      //   17: aload_2
      //   18: invokevirtual 133	java/io/Writer:write	(Ljava/lang/String;)V
      //   21: aload_3
      //   22: invokestatic 136	com/mopub/common/DiskLruCacheUtil:a	(Ljava/io/Closeable;)V
      //   25: return
      //   26: astore 4
      //   28: aconst_null
      //   29: astore_3
      //   30: aload_3
      //   31: invokestatic 136	com/mopub/common/DiskLruCacheUtil:a	(Ljava/io/Closeable;)V
      //   34: aload 4
      //   36: athrow
      //   37: astore 4
      //   39: goto -9 -> 30
      //
      // Exception table:
      //   from	to	target	type
      //   0	16	26	finally
      //   16	21	37	finally
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
          DiskLruCache.Editor.a(DiskLruCache.Editor.this, true);
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
          DiskLruCache.Editor.a(DiskLruCache.Editor.this, true);
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
          DiskLruCache.Editor.a(DiskLruCache.Editor.this, true);
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
          DiskLruCache.Editor.a(DiskLruCache.Editor.this, true);
        }
      }
    }
  }

  public final class Snapshot
    implements Closeable
  {
    private final String b;
    private final long c;
    private final InputStream[] d;
    private final long[] e;

    private Snapshot(String paramLong, long arg3, InputStream[] paramArrayOfLong, long[] arg6)
    {
      this.b = paramLong;
      this.c = ???;
      this.d = paramArrayOfLong;
      Object localObject;
      this.e = localObject;
    }

    public void close()
    {
      InputStream[] arrayOfInputStream = this.d;
      int i = arrayOfInputStream.length;
      for (int j = 0; j < i; j++)
        DiskLruCacheUtil.a(arrayOfInputStream[j]);
    }

    public DiskLruCache.Editor edit()
      throws IOException
    {
      return DiskLruCache.a(DiskLruCache.this, this.b, this.c);
    }

    public InputStream getInputStream(int paramInt)
    {
      return this.d[paramInt];
    }

    public long getLength(int paramInt)
    {
      return this.e[paramInt];
    }

    public String getString(int paramInt)
      throws IOException
    {
      return DiskLruCache.a(getInputStream(paramInt));
    }
  }

  private final class a
  {
    private final String b;
    private final long[] c;
    private boolean d;
    private DiskLruCache.Editor e;
    private long f;

    private a(String arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = new long[DiskLruCache.e(DiskLruCache.this)];
    }

    private void a(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != DiskLruCache.e(DiskLruCache.this))
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

    public File getCleanFile(int paramInt)
    {
      return new File(DiskLruCache.f(DiskLruCache.this), this.b + "." + paramInt);
    }

    public File getDirtyFile(int paramInt)
    {
      return new File(DiskLruCache.f(DiskLruCache.this), this.b + "." + paramInt + ".tmp");
    }

    public String getLengths()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (long l : this.c)
        localStringBuilder.append(' ').append(l);
      return localStringBuilder.toString();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.DiskLruCache
 * JD-Core Version:    0.6.2
 */