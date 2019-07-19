package com.viber.voip.backup;

import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.Pools.SynchronizedPool;
import com.viber.voip.backup.c.d;
import java.util.LinkedList;

public class k
{
  private final a a;

  public k(j paramj, Handler paramHandler)
  {
    this.a = new a(paramj, paramHandler);
  }

  public void a(g paramg)
  {
    this.a.a(true);
    paramg.b(this.a);
  }

  public boolean a(g paramg, int paramInt)
  {
    this.a.a(true);
    return paramg.a(this.a, paramInt);
  }

  public boolean b(g paramg)
  {
    this.a.a(true);
    return paramg.a(this.a);
  }

  public void c(g paramg)
  {
    this.a.a(false);
    paramg.c(this.a);
    n localn = this.a.a();
    if (localn != null)
      paramg.a(localn);
  }

  private class a
    implements j
  {
    private final j b;
    private final Handler c;
    private final Pools.SynchronizedPool<n> d = new Pools.SynchronizedPool(3);
    private final LinkedList<n> e = new LinkedList();
    private volatile boolean f;

    public a(j paramHandler, Handler arg3)
    {
      this.b = paramHandler;
      Object localObject;
      this.c = localObject;
    }

    private void a(n paramn)
    {
      synchronized (this.e)
      {
        this.e.add(paramn);
        paramn.a(this.b);
        this.c.post(paramn);
        return;
      }
    }

    private n b()
    {
      Object localObject = (n)this.d.acquire();
      if (localObject == null)
        localObject = new a(null);
      return localObject;
    }

    private void b(n paramn)
    {
      synchronized (this.e)
      {
        this.e.remove(paramn);
        return;
      }
    }

    private void c(n paramn)
    {
      if (paramn.e())
      {
        while (this.d.acquire() != null);
        return;
      }
      paramn.c();
      this.d.release(paramn);
    }

    public n a()
    {
      LinkedList localLinkedList = this.e;
      Object localObject1 = null;
      try
      {
        while (!this.e.isEmpty())
        {
          n localn = (n)this.e.poll();
          localn.d();
          this.c.removeCallbacks(localn);
          localObject1 = localn;
        }
        if (localObject1 != null)
          return new n(localObject1);
      }
      finally
      {
      }
      return null;
    }

    public void a(Uri paramUri, int paramInt)
    {
      a(b().a(paramUri, paramInt));
    }

    public void a(Uri paramUri, d paramd)
    {
      a(b().a(paramUri, paramd));
    }

    public void a(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }

    public boolean a(Uri paramUri)
    {
      return this.b.a(paramUri);
    }

    public void b(Uri paramUri)
    {
      a(b().a(paramUri));
    }

    public void c(Uri paramUri)
    {
      a(b().b(paramUri));
    }

    private class a extends n
    {
      private a()
      {
      }

      public void run()
      {
        if (k.a.a(k.a.this))
        {
          k.a.a(k.a.this, this);
          super.run();
          k.a.b(k.a.this, this);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.k
 * JD-Core Version:    0.6.2
 */