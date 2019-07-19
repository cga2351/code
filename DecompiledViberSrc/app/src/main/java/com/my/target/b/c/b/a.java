package com.my.target.b.c.b;

import android.util.LruCache;
import com.my.target.l;
import java.util.ArrayList;
import java.util.List;

public final class a extends l
{
  private static final LruCache<String, String> a = new LruCache(10);
  private final ArrayList<com.my.target.b.c.a.a> b = new ArrayList();

  public static LruCache<String, String> b()
  {
    return a;
  }

  public static a c()
  {
    return new a();
  }

  public final int a()
  {
    return this.b.size();
  }

  public final void a(com.my.target.b.c.a.a parama)
  {
    this.b.add(parama);
    a.put(parama.k(), parama.k());
  }

  public final com.my.target.b.c.a.a d()
  {
    if (this.b.size() > 0)
      return (com.my.target.b.c.a.a)this.b.get(0);
    return null;
  }

  public final List<com.my.target.b.c.a.a> e()
  {
    return new ArrayList(this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.c.b.a
 * JD-Core Version:    0.6.2
 */