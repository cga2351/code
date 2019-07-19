package com.viber.voip.backup;

import android.net.Uri;
import android.support.v4.util.ArrayMap;
import com.viber.voip.backup.c.d;
import com.viber.voip.util.upload.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class e extends l
  implements j
{
  private final List<j> a = new ArrayList(4);
  private final ArrayMap<Uri, n> b = new ArrayMap();
  private final Object c = new Object();

  private void b(n paramn)
  {
    if (paramn.b() == null);
    boolean bool;
    do
    {
      return;
      int i = this.a.size();
      int j = 0;
      bool = false;
      while (j < i)
      {
        j localj = (j)this.a.get(j);
        paramn.b(localj);
        bool |= localj.a(paramn.b());
        j++;
      }
    }
    while (!bool);
    c(paramn);
  }

  private void c(n paramn)
  {
    if (paramn.e())
      i(paramn.b());
  }

  private void f(Uri paramUri)
  {
    d(paramUri);
    synchronized (this.c)
    {
      i(g(paramUri));
      return;
    }
  }

  private Uri g(Uri paramUri)
  {
    return t.j(paramUri);
  }

  private n h(Uri paramUri)
  {
    n localn = (n)this.b.get(paramUri);
    if (localn == null)
    {
      localn = new n();
      this.b.put(paramUri, localn);
    }
    return localn;
  }

  private void i(Uri paramUri)
  {
    this.b.remove(paramUri);
  }

  public void a(Uri paramUri, int paramInt)
  {
    b(paramUri, paramInt);
    synchronized (this.c)
    {
      h(g(paramUri)).a(paramUri, paramInt);
      return;
    }
  }

  public void a(Uri paramUri, d paramd)
  {
    if (t.b(paramUri))
      synchronized (this.c)
      {
        b(h(paramUri).a(paramUri, paramd));
        return;
      }
    f(paramUri);
  }

  public void a(j paramj)
  {
    a(paramj);
    synchronized (this.c)
    {
      if (this.a.contains(paramj))
        return;
      this.a.add(paramj);
      if (!this.b.isEmpty())
      {
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext())
        {
          n localn = (n)localIterator.next();
          if (localn.b() != null)
          {
            localn.b(paramj);
            if ((paramj.a(localn.b())) && (localn.e()))
              localIterator.remove();
          }
        }
      }
    }
  }

  public void a(n paramn)
  {
    synchronized (this.c)
    {
      Uri localUri = paramn.b();
      if (localUri != null)
      {
        this.b.put(g(localUri), paramn);
        b(paramn);
      }
      return;
    }
  }

  public boolean a(Uri paramUri)
  {
    return true;
  }

  public boolean a(j paramj, Uri paramUri)
  {
    synchronized (this.c)
    {
      boolean bool = this.b.containsKey(paramUri);
      a(paramj);
      return bool;
    }
  }

  public void b(Uri paramUri)
  {
    if (t.b(paramUri))
      synchronized (this.c)
      {
        b(h(paramUri).a(paramUri));
        return;
      }
    f(paramUri);
  }

  public void b(j paramj)
  {
    b(paramj);
    synchronized (this.c)
    {
      this.a.remove(paramj);
      return;
    }
  }

  public void c(Uri paramUri)
  {
    if (t.b(paramUri))
      synchronized (this.c)
      {
        b(h(paramUri).b(paramUri));
        return;
      }
    f(paramUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.e
 * JD-Core Version:    0.6.2
 */