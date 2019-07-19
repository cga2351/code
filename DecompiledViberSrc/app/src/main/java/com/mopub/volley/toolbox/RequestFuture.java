package com.mopub.volley.toolbox;

import android.os.SystemClock;
import com.mopub.volley.Request;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T>
  implements Response.ErrorListener, Response.Listener<T>, Future<T>
{
  private Request<?> a;
  private boolean b = false;
  private T c;
  private VolleyError d;

  private T a(Long paramLong)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    try
    {
      if (this.d != null)
        throw new ExecutionException(this.d);
    }
    finally
    {
    }
    if (this.b);
    for (Object localObject2 = this.c; ; localObject2 = this.c)
    {
      return localObject2;
      if (paramLong == null)
        while (!isDone())
          wait(0L);
      if (paramLong.longValue() > 0L)
      {
        long l1 = SystemClock.uptimeMillis();
        long l2 = l1 + paramLong.longValue();
        while ((!isDone()) && (l1 < l2))
        {
          wait(l2 - l1);
          l1 = SystemClock.uptimeMillis();
        }
      }
      if (this.d != null)
        throw new ExecutionException(this.d);
      if (!this.b)
        throw new TimeoutException();
    }
  }

  public static <E> RequestFuture<E> newFuture()
  {
    return new RequestFuture();
  }

  public boolean cancel(boolean paramBoolean)
  {
    try
    {
      Request localRequest = this.a;
      boolean bool1 = false;
      if (localRequest == null);
      while (true)
      {
        return bool1;
        boolean bool2 = isDone();
        bool1 = false;
        if (!bool2)
        {
          this.a.cancel();
          bool1 = true;
        }
      }
    }
    finally
    {
    }
  }

  public T get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      Object localObject = a(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }

  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }

  public boolean isCancelled()
  {
    if (this.a == null)
      return false;
    return this.a.isCanceled();
  }

  public boolean isDone()
  {
    try
    {
      if ((!this.b) && (this.d == null))
      {
        boolean bool2 = isCancelled();
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
    }
  }

  public void onErrorResponse(VolleyError paramVolleyError)
  {
    try
    {
      this.d = paramVolleyError;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onResponse(T paramT)
  {
    try
    {
      this.b = true;
      this.c = paramT;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setRequest(Request<?> paramRequest)
  {
    this.a = paramRequest;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.RequestFuture
 * JD-Core Version:    0.6.2
 */