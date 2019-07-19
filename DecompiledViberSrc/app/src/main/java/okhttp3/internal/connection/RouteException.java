package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException extends RuntimeException
{
  private static final Method addSuppressedExceptionMethod;
  private IOException lastException;

  static
  {
    try
    {
      Method localMethod2 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      localMethod1 = localMethod2;
      addSuppressedExceptionMethod = localMethod1;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Method localMethod1 = null;
    }
  }

  public RouteException(IOException paramIOException)
  {
    super(paramIOException);
    this.lastException = paramIOException;
  }

  private void addSuppressedIfPossible(IOException paramIOException1, IOException paramIOException2)
  {
    if (addSuppressedExceptionMethod != null);
    try
    {
      addSuppressedExceptionMethod.invoke(paramIOException1, new Object[] { paramIOException2 });
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
  }

  public void addConnectException(IOException paramIOException)
  {
    addSuppressedIfPossible(paramIOException, this.lastException);
    this.lastException = paramIOException;
  }

  public IOException getLastConnectException()
  {
    return this.lastException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.RouteException
 * JD-Core Version:    0.6.2
 */