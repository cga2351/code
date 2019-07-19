package com.yandex.metrica.impl.ob;

public abstract class oi
  implements Runnable
{
  public abstract void a()
    throws Exception;

  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.oi
 * JD-Core Version:    0.6.2
 */