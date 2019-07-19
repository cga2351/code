package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.a;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract interface o
{
  public abstract void a(int paramInt, n.a parama);

  public abstract void a(int paramInt, n.a parama, b paramb, c paramc);

  public abstract void a(int paramInt, n.a parama, b paramb, c paramc, IOException paramIOException, boolean paramBoolean);

  public abstract void a(int paramInt, n.a parama, c paramc);

  public abstract void b(int paramInt, n.a parama);

  public abstract void b(int paramInt, n.a parama, b paramb, c paramc);

  public abstract void c(int paramInt, n.a parama);

  public abstract void c(int paramInt, n.a parama, b paramb, c paramc);

  public static final class a
  {
    public final int a;
    public final n.a b;
    private final CopyOnWriteArrayList<a> c;
    private final long d;

    public a()
    {
      this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    private a(CopyOnWriteArrayList<a> paramCopyOnWriteArrayList, int paramInt, n.a parama, long paramLong)
    {
      this.c = paramCopyOnWriteArrayList;
      this.a = paramInt;
      this.b = parama;
      this.d = paramLong;
    }

    private long a(long paramLong)
    {
      long l = c.a(paramLong);
      if (l == -9223372036854775807L)
        return -9223372036854775807L;
      return l + this.d;
    }

    private void a(Handler paramHandler, Runnable paramRunnable)
    {
      if (paramHandler.getLooper() == Looper.myLooper())
      {
        paramRunnable.run();
        return;
      }
      paramHandler.post(paramRunnable);
    }

    public a a(int paramInt, n.a parama, long paramLong)
    {
      return new a(this.c, paramInt, parama, paramLong);
    }

    public void a()
    {
      n.a locala = (n.a)a.a(this.b);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala1 = (a)localIterator.next();
        o localo = locala1.b;
        a(locala1.a, new p(this, localo, locala));
      }
    }

    public void a(int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong)
    {
      a(new o.c(1, paramInt1, paramFormat, paramInt2, paramObject, a(paramLong), -9223372036854775807L));
    }

    public void a(Handler paramHandler, o paramo)
    {
      if ((paramHandler != null) && (paramo != null));
      for (boolean bool = true; ; bool = false)
      {
        a.a(bool);
        this.c.add(new a(paramHandler, paramo));
        return;
      }
    }

    public void a(l paraml, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
    {
      a(new o.b(paraml, paraml.a, Collections.emptyMap(), paramLong3, 0L, 0L), new o.c(paramInt1, paramInt2, paramFormat, paramInt3, paramObject, a(paramLong1), a(paramLong2)));
    }

    public void a(l paraml, int paramInt, long paramLong)
    {
      a(paraml, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong);
    }

    public void a(l paraml, Uri paramUri, Map<String, List<String>> paramMap, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      b(new o.b(paraml, paramUri, paramMap, paramLong3, paramLong4, paramLong5), new o.c(paramInt1, paramInt2, paramFormat, paramInt3, paramObject, a(paramLong1), a(paramLong2)));
    }

    public void a(l paraml, Uri paramUri, Map<String, List<String>> paramMap, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      a(new o.b(paraml, paramUri, paramMap, paramLong3, paramLong4, paramLong5), new o.c(paramInt1, paramInt2, paramFormat, paramInt3, paramObject, a(paramLong1), a(paramLong2)), paramIOException, paramBoolean);
    }

    public void a(l paraml, Uri paramUri, Map<String, List<String>> paramMap, int paramInt, long paramLong1, long paramLong2, long paramLong3)
    {
      a(paraml, paramUri, paramMap, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
    }

    public void a(l paraml, Uri paramUri, Map<String, List<String>> paramMap, int paramInt, long paramLong1, long paramLong2, long paramLong3, IOException paramIOException, boolean paramBoolean)
    {
      a(paraml, paramUri, paramMap, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramIOException, paramBoolean);
    }

    public void a(o.b paramb, o.c paramc)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        o localo = locala.b;
        a(locala.a, new r(this, localo, paramb, paramc));
      }
    }

    public void a(o.b paramb, o.c paramc, IOException paramIOException, boolean paramBoolean)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        o localo = locala.b;
        a(locala.a, new u(this, localo, paramb, paramc, paramIOException, paramBoolean));
      }
    }

    public void a(o.c paramc)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        o localo = locala.b;
        a(locala.a, new w(this, localo, paramc));
      }
    }

    public void a(o paramo)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.b == paramo)
          this.c.remove(locala);
      }
    }

    public void b()
    {
      n.a locala = (n.a)a.a(this.b);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala1 = (a)localIterator.next();
        o localo = locala1.b;
        a(locala1.a, new q(this, localo, locala));
      }
    }

    public void b(l paraml, Uri paramUri, Map<String, List<String>> paramMap, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      c(new o.b(paraml, paramUri, paramMap, paramLong3, paramLong4, paramLong5), new o.c(paramInt1, paramInt2, paramFormat, paramInt3, paramObject, a(paramLong1), a(paramLong2)));
    }

    public void b(l paraml, Uri paramUri, Map<String, List<String>> paramMap, int paramInt, long paramLong1, long paramLong2, long paramLong3)
    {
      b(paraml, paramUri, paramMap, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
    }

    public void b(o.b paramb, o.c paramc)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        o localo = locala.b;
        a(locala.a, new s(this, localo, paramb, paramc));
      }
    }

    public void c()
    {
      n.a locala = (n.a)a.a(this.b);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala1 = (a)localIterator.next();
        o localo = locala1.b;
        a(locala1.a, new v(this, localo, locala));
      }
    }

    public void c(o.b paramb, o.c paramc)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        o localo = locala.b;
        a(locala.a, new t(this, localo, paramb, paramc));
      }
    }

    private static final class a
    {
      public final Handler a;
      public final o b;

      public a(Handler paramHandler, o paramo)
      {
        this.a = paramHandler;
        this.b = paramo;
      }
    }
  }

  public static final class b
  {
    public final l a;
    public final Uri b;
    public final Map<String, List<String>> c;
    public final long d;
    public final long e;
    public final long f;

    public b(l paraml, Uri paramUri, Map<String, List<String>> paramMap, long paramLong1, long paramLong2, long paramLong3)
    {
      this.a = paraml;
      this.b = paramUri;
      this.c = paramMap;
      this.d = paramLong1;
      this.e = paramLong2;
      this.f = paramLong3;
    }
  }

  public static final class c
  {
    public final int a;
    public final int b;
    public final Format c;
    public final int d;
    public final Object e;
    public final long f;
    public final long g;

    public c(int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramFormat;
      this.d = paramInt3;
      this.e = paramObject;
      this.f = paramLong1;
      this.g = paramLong2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.o
 * JD-Core Version:    0.6.2
 */