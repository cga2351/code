package c.a.a.a.a.d;

import android.content.Context;
import c.a.a.a.a.b.i;
import c.a.a.a.a.b.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b<T>
{
  protected final Context a;
  protected final a<T> b;
  protected final k c;
  protected final c d;
  protected volatile long e;
  protected final List<d> f = new CopyOnWriteArrayList();
  private final int g;

  public b(Context paramContext, a<T> parama, k paramk, c paramc, int paramInt)
    throws IOException
  {
    this.a = paramContext.getApplicationContext();
    this.b = parama;
    this.d = paramc;
    this.c = paramk;
    this.e = this.c.a();
    this.g = paramInt;
  }

  private void a(int paramInt)
    throws IOException
  {
    if (!this.d.a(paramInt, c()))
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(this.d.a());
      arrayOfObject[1] = Integer.valueOf(paramInt);
      arrayOfObject[2] = Integer.valueOf(c());
      String str = String.format(localLocale, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", arrayOfObject);
      i.a(this.a, 4, "Fabric", str);
      d();
    }
  }

  private void b(String paramString)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      try
      {
        locald.a(paramString);
      }
      catch (Exception localException)
      {
        i.a(this.a, "One of the roll over listeners threw an exception", localException);
      }
    }
  }

  public long a(String paramString)
  {
    String[] arrayOfString = paramString.split("_");
    if (arrayOfString.length != 3)
      return 0L;
    try
    {
      long l = Long.valueOf(arrayOfString[2]).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0L;
  }

  protected abstract String a();

  public void a(d paramd)
  {
    if (paramd != null)
      this.f.add(paramd);
  }

  public void a(T paramT)
    throws IOException
  {
    byte[] arrayOfByte = this.b.a(paramT);
    a(arrayOfByte.length);
    this.d.a(arrayOfByte);
  }

  public void a(List<File> paramList)
  {
    this.d.a(paramList);
  }

  protected int b()
  {
    return this.g;
  }

  protected int c()
  {
    return 8000;
  }

  public boolean d()
    throws IOException
  {
    boolean bool = true;
    String str;
    if (!this.d.b())
    {
      str = a();
      this.d.a(str);
      Context localContext = this.a;
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[bool];
      arrayOfObject[0] = str;
      i.a(localContext, 4, "Fabric", String.format(localLocale, "generated new file %s", arrayOfObject));
      this.e = this.c.a();
    }
    while (true)
    {
      b(str);
      return bool;
      str = null;
      bool = false;
    }
  }

  public List<File> e()
  {
    return this.d.a(1);
  }

  public void f()
  {
    this.d.a(this.d.c());
    this.d.d();
  }

  public void g()
  {
    List localList = this.d.c();
    int i = b();
    if (localList.size() <= i)
      return;
    int j = localList.size() - i;
    Context localContext = this.a;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(localList.size());
    arrayOfObject[1] = Integer.valueOf(i);
    arrayOfObject[2] = Integer.valueOf(j);
    i.a(localContext, String.format(localLocale, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", arrayOfObject));
    TreeSet localTreeSet = new TreeSet(new Comparator()
    {
      public int a(b.a paramAnonymousa1, b.a paramAnonymousa2)
      {
        return (int)(paramAnonymousa1.b - paramAnonymousa2.b);
      }
    });
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
    {
      File localFile = (File)localIterator1.next();
      localTreeSet.add(new a(localFile, a(localFile.getName())));
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = localTreeSet.iterator();
    do
    {
      if (!localIterator2.hasNext())
        break;
      localArrayList.add(((a)localIterator2.next()).a);
    }
    while (localArrayList.size() != j);
    this.d.a(localArrayList);
  }

  static class a
  {
    final File a;
    final long b;

    public a(File paramFile, long paramLong)
    {
      this.a = paramFile;
      this.b = paramLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.d.b
 * JD-Core Version:    0.6.2
 */