package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.j;
import com.google.android.exoplayer2.g.a;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class e
  implements f
{
  private final ArrayDeque<a> a = new ArrayDeque();
  private final ArrayDeque<j> b;
  private final PriorityQueue<a> c;
  private a d;
  private long e;
  private long f;

  public e()
  {
    for (int j = 0; j < 10; j++)
      this.a.add(new a(null));
    this.b = new ArrayDeque();
    while (i < 2)
    {
      this.b.add(new b(null));
      i++;
    }
    this.c = new PriorityQueue();
  }

  private void a(a parama)
  {
    parama.a();
    this.a.add(parama);
  }

  public void a(long paramLong)
  {
    this.e = paramLong;
  }

  protected abstract void a(i parami);

  protected void a(j paramj)
  {
    paramj.a();
    this.b.add(paramj);
  }

  public void b(i parami)
    throws g
  {
    boolean bool;
    if (parami == this.d)
    {
      bool = true;
      a.a(bool);
      if (!parami.j_())
        break label40;
      a(this.d);
    }
    while (true)
    {
      this.d = null;
      return;
      bool = false;
      break;
      label40: a locala = this.d;
      long l = this.f;
      this.f = (1L + l);
      a.a(locala, l);
      this.c.add(this.d);
    }
  }

  public void c()
  {
    this.f = 0L;
    this.e = 0L;
    while (!this.c.isEmpty())
      a((a)this.c.poll());
    if (this.d != null)
    {
      a(this.d);
      this.d = null;
    }
  }

  public void d()
  {
  }

  protected abstract boolean e();

  protected abstract com.google.android.exoplayer2.e.e f();

  public j g()
    throws g
  {
    if (this.b.isEmpty())
      return null;
    a locala;
    com.google.android.exoplayer2.e.e locale;
    do
    {
      do
      {
        a(locala);
        if ((this.c.isEmpty()) || (((a)this.c.peek()).c > this.e))
          break;
        locala = (a)this.c.poll();
        if (locala.c())
        {
          j localj2 = (j)this.b.pollFirst();
          localj2.b(4);
          a(locala);
          return localj2;
        }
        a(locala);
      }
      while (!e());
      locale = f();
    }
    while (locala.j_());
    j localj1 = (j)this.b.pollFirst();
    localj1.a(locala.c, locale, 9223372036854775807L);
    a(locala);
    return localj1;
    return null;
  }

  public i h()
    throws g
  {
    if (this.d == null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      if (!this.a.isEmpty())
        break;
      return null;
    }
    this.d = ((a)this.a.pollFirst());
    return this.d;
  }

  private static final class a extends i
    implements Comparable<a>
  {
    private long e;

    public int a(a parama)
    {
      if (c() != parama.c())
        if (!c());
      long l;
      do
      {
        return 1;
        return -1;
        l = this.c - parama.c;
        if (l == 0L)
        {
          l = this.e - parama.e;
          if (l == 0L)
            return 0;
        }
      }
      while (l > 0L);
      return -1;
    }
  }

  private final class b extends j
  {
    private b()
    {
    }

    public final void e()
    {
      e.this.a(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a.e
 * JD-Core Version:    0.6.2
 */