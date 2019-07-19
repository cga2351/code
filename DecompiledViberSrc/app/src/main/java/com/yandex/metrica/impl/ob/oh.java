package com.yandex.metrica.impl.ob;

import java.util.concurrent.Callable;

public abstract class oh<T>
  implements Callable<T>
{
  public abstract T b()
    throws Exception;

  public T call()
  {
    try
    {
      Object localObject = b();
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.oh
 * JD-Core Version:    0.6.2
 */