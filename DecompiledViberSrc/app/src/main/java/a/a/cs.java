package a.a;

import com.appboy.f.c;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class cs
  implements cy
{
  private static final String a = c.a(cs.class);
  private final cy b;
  private final ThreadPoolExecutor c;
  private boolean d = false;

  public cs(cy paramcy, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this.b = paramcy;
    this.c = paramThreadPoolExecutor;
  }

  public Collection<be> a()
  {
    try
    {
      Object localObject2;
      if (this.d)
      {
        c.d(a, "Storage provider is closed. Not getting all events.");
        localObject2 = null;
      }
      while (true)
      {
        return localObject2;
        try
        {
          localObject2 = (Collection)this.c.submit(new Callable()
          {
            public Collection<be> a()
            {
              return cs.a(cs.this).a();
            }
          }).get();
        }
        catch (Exception localException)
        {
          throw new RuntimeException("Error while trying to asynchronously get all events.", localException);
        }
      }
    }
    finally
    {
    }
  }

  public void a(final be parambe)
  {
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not adding event: " + parambe);
      return;
    }
    this.c.execute(new Runnable()
    {
      public void run()
      {
        cs.a(cs.this).a(parambe);
      }
    });
  }

  public void a(final List<be> paramList)
  {
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not adding events: " + paramList);
      return;
    }
    this.c.execute(new Runnable()
    {
      public void run()
      {
        cs.a(cs.this).a(paramList);
      }
    });
  }

  public void b()
  {
    try
    {
      c.d(a, "Setting this provider and internal storage provider to closed. Cancelling all queued storage provider work.");
      this.d = true;
      this.b.b();
      this.c.shutdownNow();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(final List<be> paramList)
  {
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not deleting events: " + paramList);
      return;
    }
    this.c.execute(new Runnable()
    {
      public void run()
      {
        cs.a(cs.this).b(paramList);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cs
 * JD-Core Version:    0.6.2
 */