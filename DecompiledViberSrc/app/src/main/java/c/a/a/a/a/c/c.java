package c.a.a.a.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class c<E extends b,  extends l,  extends i> extends PriorityBlockingQueue<E>
{
  final Queue<E> a = new LinkedList();
  private final ReentrantLock b = new ReentrantLock();

  public E a()
    throws InterruptedException
  {
    return b(0, null, null);
  }

  E a(int paramInt, Long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return (b)super.take();
    case 1:
      return (b)super.peek();
    case 2:
      return (b)super.poll();
    case 3:
    }
    return (b)super.poll(paramLong.longValue(), paramTimeUnit);
  }

  public E a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return b(3, Long.valueOf(paramLong), paramTimeUnit);
  }

  boolean a(int paramInt, E paramE)
  {
    try
    {
      this.b.lock();
      if (paramInt == 1)
        super.remove(paramE);
      boolean bool = this.a.offer(paramE);
      return bool;
    }
    finally
    {
      this.b.unlock();
    }
  }

  boolean a(E paramE)
  {
    return paramE.d();
  }

  <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    int i = paramArrayOfT1.length;
    int j = paramArrayOfT2.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), i + j);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, i);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, i, j);
    return arrayOfObject;
  }

  public E b()
  {
    try
    {
      b localb = b(1, null, null);
      return localb;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    return null;
  }

  E b(int paramInt, Long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    while (true)
    {
      b localb = a(paramInt, paramLong, paramTimeUnit);
      if ((localb == null) || (a(localb)))
        return localb;
      a(paramInt, localb);
    }
  }

  public E c()
  {
    try
    {
      b localb = b(2, null, null);
      return localb;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    return null;
  }

  public void clear()
  {
    try
    {
      this.b.lock();
      this.a.clear();
      super.clear();
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public boolean contains(Object paramObject)
  {
    try
    {
      this.b.lock();
      if (!super.contains(paramObject))
      {
        boolean bool2 = this.a.contains(paramObject);
        if (!bool2);
      }
      else
      {
        bool1 = true;
        return bool1;
      }
      boolean bool1 = false;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public void d()
  {
    try
    {
      this.b.lock();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (a(localb))
        {
          super.offer(localb);
          localIterator.remove();
        }
      }
    }
    finally
    {
      this.b.unlock();
    }
    this.b.unlock();
  }

  public int drainTo(Collection<? super E> paramCollection)
  {
    int i;
    try
    {
      this.b.lock();
      i = super.drainTo(paramCollection) + this.a.size();
      while (!this.a.isEmpty())
        paramCollection.add(this.a.poll());
    }
    finally
    {
      this.b.unlock();
    }
    this.b.unlock();
    return i;
  }

  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    try
    {
      this.b.lock();
      for (int i = super.drainTo(paramCollection, paramInt); (!this.a.isEmpty()) && (i <= paramInt); i++)
        paramCollection.add(this.a.poll());
      return i;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public boolean remove(Object paramObject)
  {
    try
    {
      this.b.lock();
      if (!super.remove(paramObject))
      {
        boolean bool2 = this.a.remove(paramObject);
        if (!bool2);
      }
      else
      {
        bool1 = true;
        return bool1;
      }
      boolean bool1 = false;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    try
    {
      this.b.lock();
      boolean bool1 = super.removeAll(paramCollection);
      boolean bool2 = this.a.removeAll(paramCollection);
      boolean bool3 = bool1 | bool2;
      return bool3;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public int size()
  {
    try
    {
      this.b.lock();
      int i = this.a.size();
      int j = super.size();
      int k = i + j;
      return k;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public Object[] toArray()
  {
    try
    {
      this.b.lock();
      Object[] arrayOfObject = a(super.toArray(), this.a.toArray());
      return arrayOfObject;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    try
    {
      this.b.lock();
      Object[] arrayOfObject = a(super.toArray(paramArrayOfT), this.a.toArray(paramArrayOfT));
      return arrayOfObject;
    }
    finally
    {
      this.b.unlock();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.c.c
 * JD-Core Version:    0.6.2
 */