package a.a;

import com.appboy.f.c;

public abstract class cq<T>
{
  private static final String a = c.a(cq.class);
  private final Object b = new Object();
  private boolean c = false;

  abstract T a();

  abstract void a(T paramT, boolean paramBoolean);

  public T b()
  {
    synchronized (this.b)
    {
      if (this.c)
      {
        c.a(a, "Received call to export dirty object, but the cache was already locked.", false);
        return null;
      }
      this.c = true;
      Object localObject3 = a();
      return localObject3;
    }
  }

  public boolean b(T paramT, boolean paramBoolean)
  {
    synchronized (this.b)
    {
      if (!this.c)
      {
        c.d(a, "Tried to confirm outboundObject [" + paramT + "] with success [" + paramBoolean + "], but the cache wasn't locked, so not doing anything.");
        return false;
      }
      a(paramT, paramBoolean);
      this.c = false;
    }
    try
    {
      c.b(a, "Notifying confirmAndUnlock listeners", false);
      notifyAll();
      return true;
      localObject2 = finally;
      throw localObject2;
    }
    finally
    {
    }
  }

  public boolean c()
  {
    synchronized (this.b)
    {
      boolean bool = this.c;
      return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cq
 * JD-Core Version:    0.6.2
 */